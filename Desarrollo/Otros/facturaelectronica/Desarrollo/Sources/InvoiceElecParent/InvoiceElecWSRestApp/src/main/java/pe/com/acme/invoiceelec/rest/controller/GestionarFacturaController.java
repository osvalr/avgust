package pe.com.acme.invoiceelec.rest.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.acme.inoiceelec.util.GeneratedDocInfoDto;
import pe.com.acme.inoiceelec.util.ProcessInfoDto;
import pe.com.acme.invoiceelec.business.service.GestionarFacturaService;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElect;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElectExample;
import pe.com.acme.invoiceelec.model.mybatis.mapper.VentElectMapper;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaDetalleWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaWebQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.FacturaDetalleWebQueryMapper;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.FacturaQueryMapper;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.web.ControllerHelper;

@RestController
public class GestionarFacturaController extends ControllerHelper {
	private static Logger log = Logger.getLogger(GestionarFacturaController.class);

	@Autowired
	private GestionarFacturaService gestionarFacturaService;

	@RequestMapping(value = "/factura/generar", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> obtenerClientes(@ModelAttribute FacturaQueryCriteria facturaQueryCriteria) throws Exception {

		try {
			
			List<FacturaQuery> facturaQueries = gestionarFacturaService.selectByQuery(FacturaQueryMapper.class, facturaQueryCriteria);
			List<GeneratedDocInfoDto> generatedDocInfos = new ArrayList<>();
			ProcessInfoDto processInfoDto = new ProcessInfoDto();
			
			int success = 0;
			int error = 0;
			
			for (FacturaQuery facturaQuery : facturaQueries) {
				
				GeneratedDocInfoDto generatedDocInfo=null;
				
				try {
					generatedDocInfo = gestionarFacturaService.generarDocumentoElectronico(facturaQuery);
					success++;
				} catch (Exception e) {
					log.error(e.getMessage(), e);
					generatedDocInfo = new GeneratedDocInfoDto();
					generatedDocInfo.setNumDoc(facturaQuery.getVentas_key());
					generatedDocInfo.setStatus(false);
					generatedDocInfo.setMessage(e.getMessage());
					error++;
				}
				
				generatedDocInfos.add(generatedDocInfo);
				
			}
			
			processInfoDto.setGeneratedDocInfoDtos(generatedDocInfos);
			processInfoDto.setNumError(error);
			processInfoDto.setNumSuccess(success);
			
			return new ResponseEntity<>(JsonReturnUtil.returnRecord(processInfoDto), HttpStatus.OK);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(JsonReturnUtil.exception(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@RequestMapping(value = "/factura")
	public @ResponseBody Map<String, ? extends Object> factura(HttpServletRequest request) {
		try {
			FacturaWebQueryCriteria facturaQueryCriteria = this.loadCriteria(request, FacturaWebQueryCriteria.class);
			
			if(facturaQueryCriteria.getFechaemisanio() == null){
				int year = Calendar.getInstance().get(Calendar.YEAR);
				facturaQueryCriteria.setFechaemisanio(year);
			}
			
			if(facturaQueryCriteria.getFechaemismes() == null){
				int month = Calendar.getInstance().get(Calendar.MONTH);
				month +=1;
				facturaQueryCriteria.setFechaemismes(month);
			}
			
			List<FacturaWebQuery> listFacturaQuery = gestionarFacturaService.list(facturaQueryCriteria);
			int count = gestionarFacturaService.countRecords(facturaQueryCriteria);
			return JsonReturnUtil.success(listFacturaQuery, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="/factura/detalle", method = RequestMethod.GET)
	public @ResponseBody Map<String,? extends Object> listFacturaDetalleWebQuery(String ventas_key, int start, int limit, HttpSession session) throws Exception {
		try{
		
			List<FacturaDetalleWebQuery> listFacturaDetalleWebQuery;
			
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("ventas_key", ventas_key);
			listFacturaDetalleWebQuery = this.gestionarFacturaService.selectByQuery(FacturaDetalleWebQueryMapper.class, paramMap,start,limit);
			int count = this.gestionarFacturaService.selectCountByQuery(FacturaDetalleWebQueryMapper.class, paramMap);
			this.setRandomId(listFacturaDetalleWebQuery);
			
			return JsonReturnUtil.success(listFacturaDetalleWebQuery,count);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "/factura/documento/{numf_correl}")
	public void documento(HttpServletResponse response, @PathVariable("numf_correl") Integer numf_correl) {
		try {
			
			VentElectExample example = new VentElectExample();
			example.createCriteria().andNumfCorrelEqualTo(numf_correl);
			
			VentElect ventElect = gestionarFacturaService.selectOneByExample(VentElectMapper.class, example);
			
			File file = new File(ventElect.getRutaDocElec());

	        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
	        if(mimeType==null){
	            mimeType = "application/octet-stream";
	        }

	        response.setContentType(mimeType);
	        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
	        response.setContentLength((int)file.length());
	 
	        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	        FileCopyUtils.copy(inputStream, response.getOutputStream());
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
