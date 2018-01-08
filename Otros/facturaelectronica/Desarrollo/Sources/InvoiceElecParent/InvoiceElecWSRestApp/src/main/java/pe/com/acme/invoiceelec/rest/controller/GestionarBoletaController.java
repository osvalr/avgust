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
import pe.com.acme.invoiceelec.business.service.GestionarBoletaService;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElect;
import pe.com.acme.invoiceelec.model.mybatis.domain.VentElectExample;
import pe.com.acme.invoiceelec.model.mybatis.mapper.VentElectMapper;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaDetalleWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaWebQueryCriteria;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.BoletaQueryMapper;
import pe.com.acme.invoiceelec.model.mybatis.query.mapper.BoletaDetalleWebQueryMapper;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.web.ControllerHelper;

@RestController
public class GestionarBoletaController extends ControllerHelper {
	private static Logger log = Logger.getLogger(GestionarBoletaController.class);

	@Autowired
	private GestionarBoletaService gestionarBoletaService;

	@RequestMapping(value = "/boleta/generar", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> obtenerClientes(@ModelAttribute BoletaQueryCriteria boletaQueryCriteria) throws Exception {

		try {
			
			List<BoletaQuery> boletaQueries = gestionarBoletaService.selectByQuery(BoletaQueryMapper.class, boletaQueryCriteria);
			List<GeneratedDocInfoDto> generatedDocInfos = new ArrayList<>();
			ProcessInfoDto processInfoDto = new ProcessInfoDto();
			
			int success = 0;
			int error = 0;
			
			for (BoletaQuery boletaQuery : boletaQueries) {
				
				GeneratedDocInfoDto generatedDocInfo=null;
				
				try {
					generatedDocInfo = gestionarBoletaService.generarDocumentoElectronico(boletaQuery);
					success++;
				} catch (Exception e) {
					log.error(e.getMessage(), e);
					generatedDocInfo = new GeneratedDocInfoDto();
					generatedDocInfo.setNumDoc(boletaQuery.getVentas_key());
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
	
	@RequestMapping(value = "/boleta")
	public @ResponseBody Map<String, ? extends Object> boleta(HttpServletRequest request) {
		try {
			BoletaWebQueryCriteria boletaQueryCriteria = this.loadCriteria(request, BoletaWebQueryCriteria.class);
			
			if(boletaQueryCriteria.getFechaemisanio() == null){
				int year = Calendar.getInstance().get(Calendar.YEAR);
				boletaQueryCriteria.setFechaemisanio(year);
			}
			
			if(boletaQueryCriteria.getFechaemismes() == null){
				int month = Calendar.getInstance().get(Calendar.MONTH);
				month +=1;
				boletaQueryCriteria.setFechaemismes(month);
			}
			
			List<BoletaWebQuery> listBoletaQuery = gestionarBoletaService.list(boletaQueryCriteria);
			int count = gestionarBoletaService.countRecords(boletaQueryCriteria);
			return JsonReturnUtil.success(listBoletaQuery, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="/boleta/detalle", method = RequestMethod.GET)
	public @ResponseBody Map<String,? extends Object> listBoletaDetalleWebQuery(String ventas_key, int start, int limit, HttpSession session) throws Exception {
		try{
		
			List<BoletaDetalleWebQuery> listBoletaDetalleWebQuery;
			
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("ventas_key", ventas_key);
			listBoletaDetalleWebQuery = this.gestionarBoletaService.selectByQuery(BoletaDetalleWebQueryMapper.class, paramMap,start,limit);
			int count = this.gestionarBoletaService.selectCountByQuery(BoletaDetalleWebQueryMapper.class, paramMap);
			this.setRandomId(listBoletaDetalleWebQuery);
			
			return JsonReturnUtil.success(listBoletaDetalleWebQuery,count);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "/boleta/documento/{numf_correl}")
	public void documento(HttpServletResponse response, @PathVariable("numf_correl") Integer numf_correl) {
		try {
			
			VentElectExample example = new VentElectExample();
			example.createCriteria().andNumfCorrelEqualTo(numf_correl);
			
			VentElect ventElect = gestionarBoletaService.selectOneByExample(VentElectMapper.class, example);
			
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
