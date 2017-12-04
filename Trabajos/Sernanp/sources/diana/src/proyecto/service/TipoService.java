package proyecto.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.ConceptoExoneracionPagoDAO;
import proyecto.dao.TipoDAO;
import proyecto.vo.Conceptoexoneracionpago;
import proyecto.vo.Tipo;

@Service
public class TipoService {

	
	@Autowired
	private TipoDAO tipoDAO;
	@Autowired
	private ConceptoExoneracionPagoDAO conceptoExoneracionPagoDAO;
	
	


	public void setTipoDAO(TipoDAO tipoDAO) {
		this.tipoDAO = tipoDAO;
	}



	public Map<Integer, Object> obtenerMapCodigoxTabla(int idtabla){
		return tipoDAO.obtenerMapCodigoxTabla(idtabla);
	}
	
	
	
	public Map<Integer, Object> obtenerMapOrdenxTabla(int idtabla){
		return tipoDAO.obtenerMapOrdenxTabla(idtabla);
	}
	
	
	public int obtenerIdtipoxCodigo(int idtabla,int codigotipo){
		 Map<Integer, Object> mapTipo= obtenerMapCodigoxTabla(idtabla);
		Tipo tipo=(Tipo) mapTipo.get(codigotipo);
		return tipo.getIdtipo();		
	}
	
	
//	public List<Conceptoexoneracionpago> listarConceptoExoneracionPago(){
//		List<Conceptoexoneracionpago> lista=new ArrayList<Conceptoexoneracionpago>();
//		lista=conceptoExoneracionPagoDAO.listar(new Conceptoexoneracionpago());
//		for(int i=0;i<lista.size();i++){
//			if(lista.get(i).getIdconceptoexoneracionpago()==ValueConstants.ID_CONCEPTO_EXONERACION_PAGO_MENOR){
//				lista.remove(i);
//			}
//		}
//		return lista;
//	}
	
	
	public List<Conceptoexoneracionpago> listarConceptoExoneracionPago(){
		//List<Conceptoexoneracionpago> lista=new ArrayList<Conceptoexoneracionpago>();
		return conceptoExoneracionPagoDAO.listar(new Conceptoexoneracionpago());
	}
	
	
	public List<Conceptoexoneracionpago> listarConceptoExoneracionPagoInfante(){
		Conceptoexoneracionpago c=new Conceptoexoneracionpago();
		c.setIdconceptoexoneracionpago(ValueConstants.ID_CONCEPTO_EXONERACION_PAGO_MENOR);
		return conceptoExoneracionPagoDAO.listar(c);
	}
	
    public List<Conceptoexoneracionpago> listarConceptoExoneracionPagoNoInfante(){
		List<Conceptoexoneracionpago>listacon=conceptoExoneracionPagoDAO.listar(new Conceptoexoneracionpago());
		List<Conceptoexoneracionpago>lista=new ArrayList<Conceptoexoneracionpago>();
		for(Conceptoexoneracionpago c:listacon){
			if(c.getIdconceptoexoneracionpago()!=ValueConstants.ID_CONCEPTO_EXONERACION_PAGO_MENOR){
				lista.add(c);
			}
		}
		return lista;
	}
	
	
	public List<Tipo> listarAniosPublicacion(){
		List<Tipo> lista=new ArrayList<Tipo>();
		Calendar c = Calendar.getInstance();
		int anioActual =  c.get(Calendar.YEAR);
		for(int i=ValueConstants.ANIO_BASE_PUBLICACION;i<=anioActual+1;i++){
			Tipo t=new Tipo();
			t.setIdtipo(i);
			t.setNombretipo(String.valueOf(i));
			lista.add(t);
		}
		return lista;
	}
	
	
	
    public List<Tipo>  listarTipoDocumentoIdentidad()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_DOCUMENTO));		
    }
    
    
    public List<Tipo>  listarGenero()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_GENERO));		
    }
    
    public List<Tipo>  listarEstadoCivil()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_ESTADO_CIVIL));		
    }
    
    public List<Tipo>  listarTipoOcupacion()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_OCUPACION));		
    }
    
    public List<Tipo>  listarMotivoVisita()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_MOTIVO_VISITA));		
    }
    
    public List<Tipo>  listarEstadoFichaTurismo()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_ESTADO_FICHA_TURISMO));		
    }
    
    public List<Tipo>  listarModalidadPagoFichaTurismo()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_MODALIDAD_PAGO_FICHA_TURISMO));		
    }
   
    public List<Tipo>  listarModalidadPagoFichaTurismoSedeAnp()  {
		List<Tipo> lista= new ArrayList<Tipo>();		
        for(Tipo t: tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_MODALIDAD_PAGO_FICHA_TURISMO))){
        	if(t.getCodigointtipo()!=ValueConstants.CODIGO_MODPAGOFICHA_BANCO_FICHA){
        		lista.add(t);
        	}
        }
		return lista;
    }
    
    
	public List<Tipo>  listarTipoRecursoInformacion()  {
		return tipoDAO.listarTipoRecursoInformacion(new Tipo());		
    }
	
    public List<Tipo>  listarMedioRecursoInformacion()  {
		return tipoDAO.listarMedioRecursoInformacion(new Tipo());		
    }
	
    
    
//	public List<Tipo>  listarTipoProyectos()  {
//		
//			return tipoDAO.listarTipoProyecto(new Tipo());		
//	}
//	
//	public List<Tipo>  listarCategoriaProyectos()  {
//		
//		return tipoDAO.listarCategoriaProyecto(new Tipo());		
//}
	
	
	/*
	public List<Tipo>  listarGenero()  {
		List<Tipo> lista=new ArrayList<Tipo>();
		Tipo t1=new Tipo();
		t1.setCodigotipo("M");
		t1.setNombretipo("Masculino");
		lista.add(t1);
		Tipo t2=new Tipo();
		t2.setCodigotipo("F");
		t2.setNombretipo("Femenino");
		lista.add(t2);
		return lista;		
    }
	*/

	public List<Tipo>  listarOpciones()  {
		List<Tipo> lista=new ArrayList<Tipo>();
		Tipo t1=new Tipo();
		t1.setIdtipo(1);
		t1.setNombretipo("SI");
		lista.add(t1);
		Tipo t2=new Tipo();
		t2.setIdtipo(2);
		t2.setNombretipo("NO");
		lista.add(t2);
		return lista;		
    }
	
	public List<Tipo> listarAnios(){
		List<Tipo> lista=new ArrayList<Tipo>();
		Calendar c = Calendar.getInstance();
		int anioActual =  c.get(Calendar.YEAR);
		System.out.println(anioActual);
		for(int i=ValueConstants.ANIO_BASE;i<=anioActual;i++){
			Tipo t=new Tipo();
			t.setIdtipo(i);
			t.setNombretipo(String.valueOf(i));
			lista.add(t);
		}
		return lista;
	}
	
	
	
	public List<Tipo> listarMeses(){
		List<Tipo> lista=new ArrayList<Tipo>();
		Tipo t1=new Tipo();
		t1.setIdtipo(1);
		t1.setNombretipo("Enero");
		lista.add(t1);
		Tipo t2=new Tipo();
		t2.setIdtipo(2);
		t2.setNombretipo("Febrero");
		lista.add(t2);
		Tipo t3=new Tipo();
		t3.setIdtipo(3);
		t3.setNombretipo("Marzo");
		lista.add(t3);
		Tipo t4=new Tipo();
		t4.setIdtipo(4);
		lista.add(t4);
		t4.setNombretipo("Abril");
		Tipo t5=new Tipo();
		t5.setIdtipo(5);
		t5.setNombretipo("Mayo");
		lista.add(t5);
		Tipo t6=new Tipo();
		t6.setIdtipo(6);
		t6.setNombretipo("Junio");
		lista.add(t6);
		Tipo t7=new Tipo();
		t7.setIdtipo(7);
		t7.setNombretipo("Julio");
		lista.add(t7);
		Tipo t8=new Tipo();
		t8.setIdtipo(8);
		t8.setNombretipo("Agosto");
		lista.add(t8);
		Tipo t9=new Tipo();
		t9.setIdtipo(9);
		t9.setNombretipo("Setiembre");
		lista.add(t9);
		Tipo t10=new Tipo();
		t10.setIdtipo(10);
		t10.setNombretipo("Octubre");
		lista.add(t10);
		Tipo t11=new Tipo();
		t11.setIdtipo(11);
		t11.setNombretipo("Noviembre");
		lista.add(t11);
		Tipo t12=new Tipo();
		t12.setIdtipo(12);
		t12.setNombretipo("Diciembre");
		lista.add(t12);
		return lista;
	}
	
	public List<Tipo>  listarEstadoMulta()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_ESTADO_MULTA));		
    }
	
	//Agregado 27-05-2012 (Y.C.B.)
	public List<Tipo>  listarLocal()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_LOCAL));		
    }
	
	public List<Tipo>  listarMediosTransporte()  {
		return tipoDAO.listarTipo(new Tipo(ValueConstants.TIPO_MEDIO_TRAN));		
    }

	public List<Tipo>  listarMediosTransporteFichaRegistro(int idficharegistro)  {
		return tipoDAO.listarTipoMT(new Tipo(ValueConstants.TIPO_MEDIO_TRAN), idficharegistro);		
    }
	
}
