package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.LogoDAO;
import proyecto.vo.Logo;


@Service
public class LogoService {
	
	@Autowired
	private LogoDAO logoDAO; 
	
	public String consultarRutaLogoPrincipalxIdareanatural(int idareanatural) {
		Logo l=new Logo();
		l.getAreanatural().setIdareanatural(idareanatural);
		l.getTipologo().setCodigointtipo(ValueConstants.CODIGO_TIPO_LOGO_PRINCIPAL);
		l=consultarLogo(l);
		String ruta=l.getDirectorioarchivo().getDirdirectorio()+l.getNombregeneradologo();
		return ruta;	
	}
	
	
	
	public Logo consultarLogo(Logo logo){
		Logo l=new Logo();
		List<Logo> lista=logoDAO.listar(logo);
		if(lista.size()==1){
			l=lista.get(0);
		}
		return l;
	}
	
	

}
