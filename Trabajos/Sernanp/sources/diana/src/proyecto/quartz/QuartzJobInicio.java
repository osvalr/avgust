package proyecto.quartz;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import proyecto.constants.ValueConstants;
import proyecto.util.Funciones;
import proyecto.vo.Areanatural;
import proyecto.vo.FichaRegistro;
import proyecto.vo.HistorialJefesAnp;
import proyecto.vo.Personajuridica;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Personanatural;
import proyecto.vo.Tipo;

/**
 * Clase que define el trabajo a realizar. Cuando Quartz "alcance"
 * el momento de ejecuci�n buscar� este Job y lanzar� el execute.
 * 
 * @author gonzalo.delgado
 * 
 */
public class QuartzJobInicio implements Job {
	
	private Areanatural areanatural;
	private FichaRegistro ficharegistro;
	private Personajuridica personajuridica;
	private Personanatural personanatural;
	private HistorialJefesAnp historialjefesanp;
		
	private List<Tipo> tipomediotraedit;
	private List<Tipo> tipodocumento;
	private List<Tipo> tipogenero;
	private List<Tipo> tipolocal;
	
	private LinkedHashMap<String, String> tipos;
	private List<PersonalRegistro> personalregistro;	

	

	public QuartzJobInicio(){
		ficharegistro = new FichaRegistro();
		personajuridica = new Personajuridica();
		personanatural = new Personanatural();
		historialjefesanp = new HistorialJefesAnp();
		
		tipomediotraedit = new ArrayList<Tipo>();
		personalregistro = new ArrayList<PersonalRegistro>();		
		
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
    	try{
    		//llamada a la clase que implementa la tarea a ejecutar.
    		//System.out.println("Parametro:"+context.getMergedJobDataMap().get("param"));
    		
    		System.out.println("Llamada a tarea " + new Date().toString());
    		
    		JobDataMap data = context.getJobDetail().getJobDataMap();
    		
    		this.aprobarFichaFormulario(data);
    		
    		//this.aprobarFichaRegistro(fr);
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }
	
public void aprobarFichaFormulario(JobDataMap data){		
		
	try {
			
			ficharegistro = (FichaRegistro)data.get("ficharegistro");
			areanatural = (Areanatural)data.get("areanatural");
			areanatural = QuartzSQL.obtieneAreaNatural(areanatural.getIdareanatural());
											
			List<FichaRegistro> listaficharegistro = new ArrayList<FichaRegistro>();
							
			ficharegistro = QuartzSQL.muestraFicha(ficharegistro.getIdficharegistro());
			personajuridica = QuartzSQL.listarPersonaJuridica(ficharegistro.getOperadorturismo().getIdpersonajuridica());
			personanatural = QuartzSQL.listarPersonaNaturalxID(personajuridica.getIdpersona());
						
			tipomediotraedit = QuartzSQL.listarTipoMT(new Tipo(ValueConstants.TIPO_MEDIO_TRAN), ficharegistro.getIdficharegistro());
			
			tipodocumento = QuartzSQL.listarTipo(new Tipo(ValueConstants.TIPO_DOCUMENTO));
	        tipogenero = QuartzSQL.listarTipo(new Tipo(ValueConstants.TIPO_GENERO));
	        tipolocal = QuartzSQL.listarTipo(new Tipo(ValueConstants.TIPO_LOCAL));
	        
	        tipos = new LinkedHashMap<String, String>();
	        
	        for(Tipo t1 : tipodocumento){
	        	tipos.put(""+t1.getIdtabla()+t1.getIdtipo(), t1.getAbrevtipo());        	
	        }        
	        for(Tipo t2 : tipogenero){        	
	        	tipos.put(""+t2.getIdtabla()+t2.getIdtipo(), t2.getAbrevtipo());
	        }        
	        for(Tipo t3 : tipolocal){        	
	        	tipos.put(""+t3.getIdtabla()+t3.getIdtipo(), t3.getAbrevtipo());
	        }
			
			personalregistro = QuartzSQL.listarPersonalxFicha(ficharegistro.getIdficharegistro());
			historialjefesanp = QuartzSQL.obtineActualJefe(areanatural.getIdareanatural());
															
			ficharegistro.setPersonajuridica(personajuridica);
			ficharegistro.setTipomediotra(tipomediotraedit);
			ficharegistro.setPersonalregistro(personalregistro);
			
			listaficharegistro.add(ficharegistro);
			
			String path = (String)data.get("DirectorioJasper");		
						
			Map reportParams = new HashMap();
		
			reportParams.put("contacto", personanatural.getApepat()+" "+personanatural.getApemat()+", "+personanatural.getNombre());
			reportParams.put("SUBREPORT_DIR", path);
			reportParams.put("tipos", tipos);
			reportParams.put("nombreanp", areanatural.getCategoriaanp().getDescategoriaanp()+" "+areanatural.getDesareanatural());
			reportParams.put("firmasello", "FirmaSello_"+areanatural.getIdareanatural());
			
			String pathPDF = (String)data.get("DirectorioDescargaFicha");
			
		JasperReport reporte = (JasperReport) JRLoader.loadObject(path+"FichaRegistro.jasper");
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, reportParams, new JRBeanCollectionDataSource(listaficharegistro));

        JRExporter exporter = new JRPdfExporter();
        
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("C:/Documents and Settings/Administrador/workspace/ReporteJasper/report2PDF.pdf")); 
        	        
        String rutaArch = pathPDF;
        
        String nombreArch = "FA"+Funciones.fechaHoy("ddMMyyyy")+"-"+ficharegistro.getIdficharegistro()+".pdf";
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(rutaArch+nombreArch));        	                
        
		exporter.exportReport();
		
		ficharegistro.setNombrearchivo(nombreArch);
		ficharegistro.setIdestadoficha(2);
		
		QuartzSQL.aprobarFichaRegistro(ficharegistro);
		
		//addActionMessage("Formulario Aprobado con &Eacute;xito!!!<br><br>");		
						
		if( QuartzSQL.enviarMailConfirmacionRegistroConAdjunto(ficharegistro, rutaArch+nombreArch, historialjefesanp) ){
			//addActionMessage("Se remiti&oacute; Documento de aprobaci&oacute;n al siguiente correo: "+personajuridica.getCorreoinstitucional());
		}else{
			//addActionError("Lo sentimos: no se pudo remitir la aprobaci&oacute;n al siguiente correo: "+personajuridica.getCorreoinstitucional()+", por favor comuniquese con su administrador");
		}	
		
		}catch(Exception e){
			e.printStackTrace();
			//addActionError("Lo sentimos, no se pudo aprobar la Ficha, por favor comuniquese con su administrador.");
		}
	}


public Areanatural getAreanatural() {
	return areanatural;
}

public void setAreanatural(Areanatural areanatural) {
	this.areanatural = areanatural;
}

public FichaRegistro getFicharegistro() {
	return ficharegistro;
}

public void setFicharegistro(FichaRegistro ficharegistro) {
	this.ficharegistro = ficharegistro;
}

public Personajuridica getPersonajuridica() {
	return personajuridica;
}

public void setPersonajuridica(Personajuridica personajuridica) {
	this.personajuridica = personajuridica;
}

public Personanatural getPersonanatural() {
	return personanatural;
}

public void setPersonanatural(Personanatural personanatural) {
	this.personanatural = personanatural;
}

public HistorialJefesAnp getHistorialjefesanp() {
	return historialjefesanp;
}

public void setHistorialjefesanp(HistorialJefesAnp historialjefesanp) {
	this.historialjefesanp = historialjefesanp;
}

public List<Tipo> getTipomediotraedit() {
	return tipomediotraedit;
}

public void setTipomediotraedit(List<Tipo> tipomediotraedit) {
	this.tipomediotraedit = tipomediotraedit;
}

public List<Tipo> getTipodocumento() {
	return tipodocumento;
}

public void setTipodocumento(List<Tipo> tipodocumento) {
	this.tipodocumento = tipodocumento;
}

public List<Tipo> getTipogenero() {
	return tipogenero;
}

public void setTipogenero(List<Tipo> tipogenero) {
	this.tipogenero = tipogenero;
}

public List<Tipo> getTipolocal() {
	return tipolocal;
}

public void setTipolocal(List<Tipo> tipolocal) {
	this.tipolocal = tipolocal;
}

public LinkedHashMap<String, String> getTipos() {
	return tipos;
}

public void setTipos(LinkedHashMap<String, String> tipos) {
	this.tipos = tipos;
}

public List<PersonalRegistro> getPersonalregistro() {
	return personalregistro;
}

public void setPersonalregistro(List<PersonalRegistro> personalregistro) {
	this.personalregistro = personalregistro;
}


}