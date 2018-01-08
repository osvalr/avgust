package pe.com.acme.inavi.business.implement;

import org.springframework.stereotype.Service;

import pe.com.acme.domain.mybatis.mapper.PersonaMapper;
import pe.com.acme.domain.mybatis.model.Persona;
import pe.com.acme.domain.mybatis.model.PersonaExample;
import pe.com.acme.util.MybatisRepositoryHelper;

@Service
public class InaviCommonServiceImpl extends MybatisRepositoryHelper {

	public Persona buscarPersonaPorTipoNumDoc(Integer id_tipo_doc, String numero_doc, Integer id) throws Exception{
		
		PersonaExample example = new PersonaExample();
		
		if(id == null){
			example.createCriteria().andId_tipo_docEqualTo(id_tipo_doc).andNum_tipo_docEqualTo(numero_doc);
		}else{
			example.createCriteria().andId_tipo_docEqualTo(id_tipo_doc).andNum_tipo_docEqualTo(numero_doc).andId_personaNotEqualTo(id);
		}
		
		Persona persona = this.selectOneByExample(PersonaMapper.class, example);
		
		return persona;
	}
	
	public Persona buscarPersonaPorRazonSocial(String razon_social, Integer id) throws Exception{
		
		PersonaExample example = new PersonaExample();
		
		if(id == null){
			example.createCriteria().andRazon_socialEqualTo(razon_social);
		}else{
			example.createCriteria().andRazon_socialEqualTo(razon_social).andId_personaNotEqualTo(id);
		}
		
		Persona persona = this.selectOneByExample(PersonaMapper.class, example);
		
		return persona;
	}
}
