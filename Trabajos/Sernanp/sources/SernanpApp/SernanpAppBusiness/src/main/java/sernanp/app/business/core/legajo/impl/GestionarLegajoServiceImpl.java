package sernanp.app.business.core.legajo.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.legajo.service.GestionarLegajoService;
import sernanp.app.business.dto.PersonalLegajoDto;
import sernanp.app.dao.domain.TArchivo;
import sernanp.app.dao.domain.TPersonaNaturalLegajo;
import sernanp.app.dao.domain.TPersonaNaturalLegajoArchivo;
import sernanp.app.dao.domain.TPersonaNaturalLegajoExample;
import sernanp.app.dao.mapper.TArchivoMapper;
import sernanp.app.dao.mapper.TPersonaNaturalLegajoArchivoMapper;
import sernanp.app.dao.mapper.TPersonaNaturalLegajoMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperService;
import sernanp.app.util.IntrospeccionUtil;
import sernanp.app.util.PropUtil;

@Service
public class GestionarLegajoServiceImpl extends HelperService  implements GestionarLegajoService{
	
	@Autowired
	TArchivoMapper tArchivoMapper;
	
	@Autowired
	TPersonaNaturalLegajoMapper tPersonaNaturalLegajoMapper; 
	
	@Autowired
	TPersonaNaturalLegajoArchivoMapper tPersonaNaturalLegajoArchivoMapper;
	
	
	@Transactional
	@Override
	public void registrarLegajo(PersonalLegajoDto record) throws BusinessException , Exception{
					
		File destino = new File(PropUtil.getInstance().getPropVal("documents.properties", "ruta.legajos") + record.getIdpersonanatural());

		if(!destino.exists()){
			 destino.mkdir();
		}
		   
		String nombreLegajo;
		
		TPersonaNaturalLegajo pl = IntrospeccionUtil.tranferBean(record, TPersonaNaturalLegajo.class, true);
		
		pl.setTsp_fecha_registro(new Date());
		pl.setInt_id_estado(1);
		
		tPersonaNaturalLegajoMapper.insertSelective(pl);
		
		TArchivo archivo = IntrospeccionUtil.tranferBean(record, TArchivo.class, false);
		
		archivo.setNum_size_archivo(new BigDecimal(String.valueOf(record.getLegajo_file().length()/(1024 * 1024 * 1.0))));
		archivo.setTsp_fecha_registro(new Date());
		archivo.setVar_archivo_ruta_almacen(destino + File.separator + record.getVar_nombre_archivo());
		
		tArchivoMapper.insertSelective(archivo);
		nombreLegajo = record.getIdpersonanatural() +"_" + archivo.getSrl_id_archivo() + "_" + this.nextSessionId() + "." +this.getFileExtension(record.getVar_nombre_archivo());
		
		archivo.setVar_nombre_archivo(nombreLegajo);
		archivo.setVar_archivo_ruta_almacen(destino + File.separator + nombreLegajo);
		tArchivoMapper.updateByPrimaryKeySelective(archivo);
		
		TPersonaNaturalLegajoArchivo legajoArchivo = IntrospeccionUtil.tranferBean(record, TPersonaNaturalLegajoArchivo.class, false);
		
		legajoArchivo.setSrl_id_persona_natural_legajo(pl.getSrl_id_persona_natural_legajo());
		legajoArchivo.setSrl_id_archivo(archivo.getSrl_id_archivo());
		
		tPersonaNaturalLegajoArchivoMapper.insertSelective(legajoArchivo);
				
		CopiarDirectorio(record.getLegajo_file(),
		new File(destino + File.separator + nombreLegajo));

	}
	
	@Transactional
	@Override
	public void actualizarLegajo(PersonalLegajoDto record) throws BusinessException , Exception{
		
		File destino = new File(PropUtil.getInstance().getPropVal("documents.properties", "ruta.legajos") + record.getIdpersonanatural());
		
		String nombreLegajo;
		
		TPersonaNaturalLegajo pl = IntrospeccionUtil.tranferBean(record, TPersonaNaturalLegajo.class, true);
		
		tPersonaNaturalLegajoMapper.updateByPrimaryKeySelective(pl);
		
		if(record.getLegajo_file() !=null){
			TArchivo archivo = IntrospeccionUtil.tranferBean(record, TArchivo.class, false);
			
			archivo.setNum_size_archivo(new BigDecimal(String.valueOf(record.getLegajo_file().length()/(1024 * 1024 * 1.0))));
			archivo.setTsp_fecha_registro(new Date());
			archivo.setVar_archivo_ruta_almacen(destino + File.separator + record.getVar_nombre_archivo());
			
			tArchivoMapper.insertSelective(archivo);
			nombreLegajo = record.getIdpersonanatural() +"_" + archivo.getSrl_id_archivo() + "_" + this.nextSessionId() + "." +this.getFileExtension(record.getVar_nombre_archivo());
			
			archivo.setVar_nombre_archivo(nombreLegajo);
			archivo.setVar_archivo_ruta_almacen(destino + File.separator + nombreLegajo);
			tArchivoMapper.updateByPrimaryKeySelective(archivo);
			
			TPersonaNaturalLegajoArchivo legajoArchivo = IntrospeccionUtil.tranferBean(record, TPersonaNaturalLegajoArchivo.class, false);
			
			legajoArchivo.setSrl_id_persona_natural_legajo(pl.getSrl_id_persona_natural_legajo());
			legajoArchivo.setSrl_id_archivo(archivo.getSrl_id_archivo());
			
			tPersonaNaturalLegajoArchivoMapper.insertSelective(legajoArchivo);
					
			CopiarDirectorio(record.getLegajo_file(),
			new File(destino + File.separator + nombreLegajo));
		}
		


	}
	
	public static void CopiarDirectorio(File dirOrigen, File dirDestino) throws Exception { 

			if (dirOrigen.isDirectory()) { 
				if (!dirDestino.exists())
					dirDestino.mkdir(); 
	 
				String[] hijos = dirOrigen.list(); 
				for (int i=0; i < hijos.length; i++) { 
					CopiarDirectorio(new File(dirOrigen, hijos[i]), 
						new File(dirDestino, hijos[i])); 
				} // end for
			} else { 
				Copiar(dirOrigen, dirDestino); 
			} // end if

	} // end CopiarDirectorio
	 
	public static void Copiar(File dirOrigen, File dirDestino) throws Exception { 
	 
		InputStream in = new FileInputStream(dirOrigen); 
		OutputStream out = new FileOutputStream(dirDestino); 
	 
		byte[] buffer = new byte[1024];
		int len;
	 
		try {
			// recorrer el array de bytes y recomponerlo
			while ((len = in.read(buffer)) > 0) { 
				out.write(buffer, 0, len); 
			} // end while
			out.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			in.close(); 
			out.close(); 
		} 
	} // end Copiar
	 
	public static void Copiar(String dirOrigen, String dirDestino) throws Exception { 
		
		InputStream in = new FileInputStream(dirOrigen); 
		OutputStream out = new FileOutputStream(dirDestino); 
	 
		byte[] buffer = new byte[1024];
		int len;
	 
		try {
			// recorrer el array de bytes y recomponerlo
			while ((len = in.read(buffer)) > 0) { 
				out.write(buffer, 0, len); 
			} // end while
			out.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			in.close(); 
			out.close(); 
		}
	} // end Copiar
	
	private String getFileExtension(String nomFile) {
        if(nomFile.lastIndexOf(".") != -1 && nomFile.lastIndexOf(".") != 0)
        return nomFile.substring(nomFile.lastIndexOf(".")+1);
        else return "";
    }
	public String nextSessionId() {
		SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	  }
	
	@Transactional
	@Override
	public void grabarFotoPersonal(PersonalLegajoDto record) throws BusinessException, Exception {
		
		File destino = new File(PropUtil.getInstance().getPropVal("documents.properties", "ruta.legajos") + record.getIdpersonanatural());
		TPersonaNaturalLegajo pl=null;
		if(!destino.exists()){
			 destino.mkdir();
		}
		   
		String nombreLegajo;
		
		TPersonaNaturalLegajoExample example = new TPersonaNaturalLegajoExample();
		example.createCriteria().andIdpersonanaturalEqualTo(record.getIdpersonanatural()).andInt_id_estadoEqualTo(1).andInt_id_tipo_documentoEqualTo(1);
		
		List<TPersonaNaturalLegajo> list = this.selectByExample(TPersonaNaturalLegajoMapper.class, example);
		
		if(!list.isEmpty()){
			pl = list.get(0);
		}else{
			pl = new TPersonaNaturalLegajo();
		}
		pl.setIdpersonanatural(record.getIdpersonanatural());
		pl.setInt_id_tipo_documento(1);
		pl.setTsp_fecha_registro(new Date());
		pl.setInt_id_estado(1);
		
		if(list.isEmpty()){
			tPersonaNaturalLegajoMapper.insertSelective(pl);
		}
		
		
		TArchivo archivo = IntrospeccionUtil.tranferBean(record, TArchivo.class, false);
		
		archivo.setNum_size_archivo(new BigDecimal(String.valueOf(record.getLegajo_file().length()/(1024 * 1024 * 1.0))));
		archivo.setTsp_fecha_registro(new Date());
		archivo.setVar_archivo_ruta_almacen(destino + File.separator + record.getVar_nombre_archivo());
		
		tArchivoMapper.insertSelective(archivo);
		nombreLegajo = record.getIdpersonanatural() +"_" + archivo.getSrl_id_archivo() + "_" + this.nextSessionId() + "." +this.getFileExtension(record.getVar_nombre_archivo());
		
		archivo.setVar_nombre_archivo(nombreLegajo);
		archivo.setVar_archivo_ruta_almacen(destino + File.separator + nombreLegajo);
		tArchivoMapper.updateByPrimaryKeySelective(archivo);
		
		TPersonaNaturalLegajoArchivo legajoArchivo = IntrospeccionUtil.tranferBean(record, TPersonaNaturalLegajoArchivo.class, false);
		
		legajoArchivo.setSrl_id_persona_natural_legajo(pl.getSrl_id_persona_natural_legajo());
		legajoArchivo.setSrl_id_archivo(archivo.getSrl_id_archivo());
		
		tPersonaNaturalLegajoArchivoMapper.insertSelective(legajoArchivo);
				
		CopiarDirectorio(record.getLegajo_file(),
		new File(destino + File.separator + nombreLegajo));
	}
}	

