package pe.com.acme.invoiceelec.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.invoiceelec.model.dto.TipoDocumentoDto;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.web.ControllerHelper;

@Controller
public class CommonController extends ControllerHelper {

	private static Logger log = Logger.getLogger(CommonController.class);
	
	@RequestMapping(value = "/common/tipoDocumento")
	public @ResponseBody Map<String, ? extends Object> tipoDocumento(HttpServletRequest request) {
		try {
			
			List<TipoDocumentoDto> list = new ArrayList<>();
			
			{
				TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
				tipoDocumentoDto.setCodDocumento("0");
				tipoDocumentoDto.setDescripDocumento("0 - DOC.TRIB.NO.DOM.SIN.RUC");
				list.add(tipoDocumentoDto);
			}
			
			{
				TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
				tipoDocumentoDto.setCodDocumento("1");
				tipoDocumentoDto.setDescripDocumento("1 - DOC. NACIONAL DE IDENTIDAD");
				list.add(tipoDocumentoDto);
			}
			
			{
				TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
				tipoDocumentoDto.setCodDocumento("4");
				tipoDocumentoDto.setDescripDocumento("4 - CARNET DE EXTRANJERIA");
				list.add(tipoDocumentoDto);
			}
			
			{
				TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
				tipoDocumentoDto.setCodDocumento("6");
				tipoDocumentoDto.setDescripDocumento("6 - REG. UNICO DE CONTRIBUYENTE");
				list.add(tipoDocumentoDto);
			}
			
			{
				TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
				tipoDocumentoDto.setCodDocumento("7");
				tipoDocumentoDto.setDescripDocumento("7 - PASAPORTE");
				list.add(tipoDocumentoDto);
			}
			
			{
				TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
				tipoDocumentoDto.setCodDocumento("A");
				tipoDocumentoDto.setDescripDocumento("A - CED. DIPLOMATICA DE IDENTIDAD");
				list.add(tipoDocumentoDto);
			}			

			return JsonReturnUtil.returnList(list);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
}
