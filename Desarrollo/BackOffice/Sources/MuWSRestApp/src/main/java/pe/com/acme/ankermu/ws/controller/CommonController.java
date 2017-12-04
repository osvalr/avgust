package pe.com.acme.ankermu.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.ankermu.ws.bean.GenderBean;
import pe.com.acme.domain.mybatis.mapper.PaisesMapper;
import pe.com.acme.domain.mybatis.model.PaisesExample;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.web.ControllerHelper;

@Controller
@RequestMapping("/common")
public class CommonController extends ControllerHelper {
	
	@Autowired
	private PaisesMapper paisesMapper;
	
	@RequestMapping(value="/paises")
	public @ResponseBody Map<String,? extends Object> paises(){
		
		PaisesExample paisesExample = new PaisesExample();
		paisesExample.setOrderByClause("nombre");
		return JsonReturnUtil.returnList(paisesMapper.selectByExample(paisesExample));
		
	}
	
	@RequestMapping(value="/generos")
	public @ResponseBody Map<String,? extends Object> generos(){
		
		List<GenderBean> generos = new ArrayList<>();
		{
			GenderBean g = new GenderBean();
			g.setId_gender(1);
			g.setDescrip_gender("Male");
			generos.add(g);
		}
		{
			GenderBean g = new GenderBean();
			g.setId_gender(2);
			g.setDescrip_gender("Female");
			generos.add(g);
		}
		
		return JsonReturnUtil.returnList(generos);
		
	}
		
}
