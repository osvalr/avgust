/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 19/04/2015 01:20:12
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.cons.Tablas;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.common.service.CommonServiceMybatis;
import sernanp.app.business.core.common.service.FileCommonsService;
import sernanp.app.business.core.seleccion.service.GestionarReqPersonalService;
import sernanp.app.dao.domain.TArchivo;
import sernanp.app.dao.domain.TArchivoExample;
import sernanp.app.dao.domain.TArchivoKey;
import sernanp.app.dao.domain.TRequerimientoPersonal;
import sernanp.app.dao.domain.TRequerimientoPersonalArchivo;
import sernanp.app.dao.domain.TRequerimientoPersonalArchivoExample;
import sernanp.app.dao.domain.TRequerimientoPersonalExample;
import sernanp.app.dao.domain.TRequerimientoPersonalKey;
import sernanp.app.dao.mapper.TArchivoMapper;
import sernanp.app.dao.mapper.TMetaFuenteGenericaMapper;
import sernanp.app.dao.mapper.TRequerimientoPersonalArchivoMapper;
import sernanp.app.dao.mapper.TRequerimientoPersonalMapper;
import sernanp.app.dao.query.domain.ArchivoRequerimientoQuery;
import sernanp.app.dao.query.domain.GestionarReqPersonalQuery;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQuery;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaUnidadOperativaQuery;
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaUnidadOperativaQueryCriteria;
import sernanp.app.dao.query.mapper.ObtenerSedeAdministrativaAreaOrganicaQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerSedeAdministrativaUnidadOperativaQueryMapper;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GestionarReqPersonalServiceImpl extends HelperServiceMybatisImpl implements GestionarReqPersonalService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private FileCommonsService fileCommonsService;
	
	@Autowired
	private  TRequerimientoPersonalMapper  tRequerimientoPersonalMapper;
	
	@Autowired
	private TMetaFuenteGenericaMapper tMetaFuenteGenericaMapper;
	
	@Autowired
	CommonServiceMybatis commonServiceMybatis;
	
	
	@Transactional
	@Override
	public Integer create(GestionarReqPersonalQuery model, List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery) throws BusinessException, FileNotFoundException, IOException {
		
		Integer lastId = null;
		
		String numSecuencia = commonService.obtenerSecuencia(Tablas.T_REQUERIMIENTO, true, true);
        model.setVar_numero_requerimiento(numSecuencia);
        
        TRequerimientoPersonalExample example = new TRequerimientoPersonalExample();
		example.createCriteria().andVar_numero_requerimientoEqualTo(model.getVar_numero_requerimiento());
		
		List<TRequerimientoPersonal> list = tRequerimientoPersonalMapper.selectByExample(example);
		
		if(!list.isEmpty()){
			throw new BusinessException("ERROR","EL CODIGO DE REQUERIMIENTO YA ESTA REGISTRADO");
		}
		
		TRequerimientoPersonal tRequerimientoPersonal = beanUtil.copyBean(model, TRequerimientoPersonal.class);
		
		
		Integer idarea_solicitante = model.getIdarea_solicitante(); 
		 
		Integer idunidad_solicitante = model.getIdunidad_solicitante();
		
		
		Integer sede_administrativa = null;
		
		if(idunidad_solicitante != null){
			ObtenerSedeAdministrativaUnidadOperativaQueryCriteria criteria = new ObtenerSedeAdministrativaUnidadOperativaQueryCriteria();
			criteria.setIdunidad(idunidad_solicitante);
			List<ObtenerSedeAdministrativaUnidadOperativaQuery> sedeAreaOrg = commonServiceMybatis.getListByQuery(ObtenerSedeAdministrativaUnidadOperativaQueryMapper.class, criteria);
			
			if(!sedeAreaOrg.isEmpty()){
				if(sedeAreaOrg.get(0).getInt_sede_principal() != null){
					sede_administrativa = sedeAreaOrg.get(0).getInt_sede_principal();	
				}
				
			}
			
		}
		
		
		if(sede_administrativa == null){
			
			ObtenerSedeAdministrativaAreaOrganicaQueryCriteria criteria = new ObtenerSedeAdministrativaAreaOrganicaQueryCriteria();
			criteria.setIdarea(idarea_solicitante);
			
			List listResult = commonServiceMybatis.getListByQuery(ObtenerSedeAdministrativaAreaOrganicaQueryMapper.class, criteria);
										
			if(listResult.size() > 0){
				List<ObtenerSedeAdministrativaAreaOrganicaQuery> x = new ArrayList<ObtenerSedeAdministrativaAreaOrganicaQuery>();
				x = listResult;
				sede_administrativa = x.get(0).getInt_sede_principal();
			}			
		}
		
		tRequerimientoPersonal.setSrl_id_sede_req_sel(sede_administrativa);
		
		
		this.insertSelective(TRequerimientoPersonalMapper.class, tRequerimientoPersonal);
		
		for (ArchivoRequerimientoQuery archivoRequerimientoQuery : listArchivoRequerimientoQuery) {
			archivoRequerimientoQuery.setSrl_id_archivo(null);
			archivoRequerimientoQuery.setSrl_id_requerimiento_personal(tRequerimientoPersonal.getSrl_id_requerimiento_personal());
			
			TArchivo tArchivo = beanUtil.copyBean(archivoRequerimientoQuery, TArchivo.class);
			this.insertSelective(TArchivoMapper.class, tArchivo);
			
			File destino = new File(model.getPath_files_requerimiento() + File.separator + tRequerimientoPersonal.getSrl_id_requerimiento_personal() + File.separator + tArchivo.getSrl_id_archivo());
			
			if(!destino.exists()){
				destino.mkdirs();
			}
			
			String fileName = tRequerimientoPersonal.getSrl_id_requerimiento_personal() + "_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." + fileCommonsService.getFileExtension(archivoRequerimientoQuery.getVar_nombre_archivo());
			File origin = new File(archivoRequerimientoQuery.getVar_archivo_ruta_almacen());
			File target = new File(destino.getAbsolutePath() + File.separator + fileName);
			fileCommonsService.copy(origin, target);
			
			tArchivo.setTsp_fecha_registro(new Date());
			tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
			tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
			tArchivo.setVar_nombre_archivo(fileName);
			this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
			
			TRequerimientoPersonalArchivo tRequerimientoPersonalArchivo = new TRequerimientoPersonalArchivo();
			tRequerimientoPersonalArchivo.setSrl_id_requerimiento_personal(archivoRequerimientoQuery.getSrl_id_requerimiento_personal());
			tRequerimientoPersonalArchivo.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
			tRequerimientoPersonalArchivo.setVar_descripcion_archivo(archivoRequerimientoQuery.getVar_descripcion_archivo());
			this.insertSelective(TRequerimientoPersonalArchivoMapper.class, tRequerimientoPersonalArchivo);
		
		}
		
		lastId = tRequerimientoPersonal.getSrl_id_requerimiento_personal();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarReqPersonalQuery model, List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery) throws BusinessException, FileNotFoundException, IOException {
	    				
		TRequerimientoPersonal tRequerimientoPersonal = beanUtil.copyBean(model, TRequerimientoPersonal.class);
		
		TRequerimientoPersonalKey pk = new TRequerimientoPersonalKey();
		pk.setSrl_id_requerimiento_personal(tRequerimientoPersonal.getSrl_id_requerimiento_personal());
		TRequerimientoPersonal obj = this.selectByPrimaryKey(TRequerimientoPersonalMapper.class, pk);
		if(obj.getInt_id_estado().intValue() != 1){
			throw new BusinessException("ERROR","El Requerimiento no se encuentra en estado ACTIVO");
		}
		
		
		Integer idarea_solicitante = model.getIdarea_solicitante(); 
		 
		Integer idunidad_solicitante = model.getIdunidad_solicitante();
		
		
		Integer sede_administrativa = null;
		
		if(idunidad_solicitante != null){
			ObtenerSedeAdministrativaUnidadOperativaQueryCriteria criteria = new ObtenerSedeAdministrativaUnidadOperativaQueryCriteria();
			criteria.setIdunidad(idunidad_solicitante);
			List<ObtenerSedeAdministrativaUnidadOperativaQuery> sedeAreaOrg = commonServiceMybatis.getListByQuery(ObtenerSedeAdministrativaUnidadOperativaQueryMapper.class, criteria);
			
			if(!sedeAreaOrg.isEmpty()){
				if(sedeAreaOrg.get(0).getInt_sede_principal() != null){
					sede_administrativa = sedeAreaOrg.get(0).getInt_sede_principal();	
				}
				
			}
			
		}
		
		
		if(sede_administrativa == null){
			
			ObtenerSedeAdministrativaAreaOrganicaQueryCriteria criteria = new ObtenerSedeAdministrativaAreaOrganicaQueryCriteria();
			criteria.setIdarea(idarea_solicitante);
			
			List listResult = commonServiceMybatis.getListByQuery(ObtenerSedeAdministrativaAreaOrganicaQueryMapper.class, criteria);
										
			if(listResult.size() > 0){
				List<ObtenerSedeAdministrativaAreaOrganicaQuery> x = new ArrayList<ObtenerSedeAdministrativaAreaOrganicaQuery>();
				x = listResult;
				sede_administrativa = x.get(0).getInt_sede_principal();
			}			
		}
		
		tRequerimientoPersonal.setSrl_id_sede_req_sel(sede_administrativa);
		
		this.updateByPrimaryKeySelective(TRequerimientoPersonalMapper.class, tRequerimientoPersonal);
		
		TRequerimientoPersonalArchivoExample tRequerimientoPersonalArchivoExample = new TRequerimientoPersonalArchivoExample();
		tRequerimientoPersonalArchivoExample.createCriteria().andSrl_id_requerimiento_personalEqualTo(tRequerimientoPersonal.getSrl_id_requerimiento_personal());
		List<TRequerimientoPersonalArchivo> listTRequerimientoPersonalArchivoCurrent = this.selectByExample(TRequerimientoPersonalArchivoMapper.class, tRequerimientoPersonalArchivoExample);
		List<TRequerimientoPersonalArchivo> listTRequerimientoPersonalArchivoDeleted = new ArrayList<TRequerimientoPersonalArchivo>();
		
		for (TRequerimientoPersonalArchivo tRequerimientoPersonalArchivo : listTRequerimientoPersonalArchivoCurrent) {
			boolean noExists = true;
			for (ArchivoRequerimientoQuery archivoRequerimientoQuery : listArchivoRequerimientoQuery) {
				if(archivoRequerimientoQuery.getSrl_id_archivo().equals(tRequerimientoPersonalArchivo.getSrl_id_archivo())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTRequerimientoPersonalArchivoDeleted.add(tRequerimientoPersonalArchivo);
			}
		}
		
		for (TRequerimientoPersonalArchivo tRequerimientoPersonalArchivo : listTRequerimientoPersonalArchivoDeleted) {
			this.deleteByPrimaryKey(TRequerimientoPersonalArchivoMapper.class, tRequerimientoPersonalArchivo);
			TArchivoKey tArchivoKey = new TArchivo();
			tArchivoKey.setSrl_id_archivo(tRequerimientoPersonalArchivo.getSrl_id_archivo());
			this.deleteByPrimaryKey(TArchivoMapper.class, tArchivoKey);
		}
		
		
		for (ArchivoRequerimientoQuery archivoRequerimientoQuery : listArchivoRequerimientoQuery) {
			if(archivoRequerimientoQuery.getSrl_id_archivo() < 1){
				archivoRequerimientoQuery.setSrl_id_archivo(null);
				archivoRequerimientoQuery.setSrl_id_requerimiento_personal(tRequerimientoPersonal.getSrl_id_requerimiento_personal());
				
				TArchivo tArchivo = beanUtil.copyBean(archivoRequerimientoQuery, TArchivo.class);
				this.insertSelective(TArchivoMapper.class, tArchivo);
				
				File folders = new File(model.getPath_files_requerimiento() + File.separator + tRequerimientoPersonal.getSrl_id_requerimiento_personal() + File.separator + tArchivo.getSrl_id_archivo());
				
				if(!folders.exists()){
					folders.mkdirs();
				}
				
				String fileName = tRequerimientoPersonal.getSrl_id_requerimiento_personal() + "_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." + fileCommonsService.getFileExtension(archivoRequerimientoQuery.getVar_nombre_archivo());
				File origin = new File(archivoRequerimientoQuery.getVar_archivo_ruta_almacen());
				File target = new File(folders.getAbsolutePath() + File.separator + fileName);
				fileCommonsService.copy(origin, target);
				
				tArchivo.setTsp_fecha_registro(new Date());
				tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
				tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
				tArchivo.setVar_nombre_archivo(fileName);
				this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
				
				File file = new File(archivoRequerimientoQuery.getVar_archivo_ruta_almacen());
				file.delete();
				
				TRequerimientoPersonalArchivo tRequerimientoPersonalArchivo = new TRequerimientoPersonalArchivo();
				tRequerimientoPersonalArchivo.setSrl_id_requerimiento_personal(archivoRequerimientoQuery.getSrl_id_requerimiento_personal());
				tRequerimientoPersonalArchivo.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
				tRequerimientoPersonalArchivo.setVar_descripcion_archivo(archivoRequerimientoQuery.getVar_descripcion_archivo());
				this.insertSelective(TRequerimientoPersonalArchivoMapper.class, tRequerimientoPersonalArchivo);
			
			}else{
				
				TArchivo tArchivo = beanUtil.copyBean(archivoRequerimientoQuery, TArchivo.class);
				this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
				
				TArchivoExample tArchivoExample = new TArchivoExample();
				tArchivoExample.createCriteria().andVar_nombre_archivoEqualTo(tArchivo.getVar_nombre_archivo()).andSrl_id_archivoEqualTo(tArchivo.getSrl_id_archivo());
				
				List<TArchivo> listTArchivo = this.selectByExample(TArchivoMapper.class, tArchivoExample);
				
				if(listTArchivo.isEmpty()){
					File folders = new File(model.getPath_files_requerimiento() + File.separator + tRequerimientoPersonal.getSrl_id_requerimiento_personal() + File.separator + tArchivo.getSrl_id_archivo());
					
					if(!folders.exists()){
						folders.mkdirs();
					}
					
					String fileName = tRequerimientoPersonal.getSrl_id_requerimiento_personal() + "_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." + fileCommonsService.getFileExtension(archivoRequerimientoQuery.getVar_nombre_archivo());
					File origin = new File(archivoRequerimientoQuery.getVar_archivo_ruta_almacen());
					File target = new File (folders.getAbsolutePath() + File.separator + fileName);
					fileCommonsService.copy(origin, target);
					
					tArchivo.setTsp_fecha_registro(new Date());
					tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
					tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
					tArchivo.setVar_nombre_archivo(fileName);
					this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
					
					File file = new File(archivoRequerimientoQuery.getVar_archivo_ruta_almacen());
					file.delete();
					
				}
				
				TRequerimientoPersonalArchivo tRequerimientoPersonalArchivo = beanUtil.copyBean(archivoRequerimientoQuery, TRequerimientoPersonalArchivo.class);
				this.updateByPrimaryKeySelective(TRequerimientoPersonalArchivoMapper.class, tRequerimientoPersonalArchivo);
			}
		}
		
		
	}

	@Transactional
	@Override
	public void remove(GestionarReqPersonalQuery model, List<ArchivoRequerimientoQuery> listArchivoRequerimientoQuery) throws BusinessException, FileNotFoundException, IOException {
	
		for (ArchivoRequerimientoQuery archivoRequerimientoQuery : listArchivoRequerimientoQuery) {
			TRequerimientoPersonalArchivo tRequerimientoPersonalArchivo = beanUtil.copyBean(archivoRequerimientoQuery, TRequerimientoPersonalArchivo.class);
			this.deleteByPrimaryKey(TRequerimientoPersonalArchivoMapper.class, tRequerimientoPersonalArchivo);
		
			TArchivo tArchivo = beanUtil.copyBean(archivoRequerimientoQuery, TArchivo.class);
			this.deleteByPrimaryKey(TArchivoMapper.class, tArchivo);
		}
		
		TRequerimientoPersonal tRequerimientoPersonal = beanUtil.copyBean(model, TRequerimientoPersonal.class);
		TRequerimientoPersonalKey pk = new TRequerimientoPersonalKey();
		pk.setSrl_id_requerimiento_personal(tRequerimientoPersonal.getSrl_id_requerimiento_personal());
		TRequerimientoPersonal obj = this.selectByPrimaryKey(TRequerimientoPersonalMapper.class, pk);
		if(obj.getInt_id_estado().intValue() != 1){
			throw new BusinessException("ERROR","El Requerimiento no se encuentra en estado ACTIVO");
		}
		this.deleteByPrimaryKey(TRequerimientoPersonalMapper.class, tRequerimientoPersonal);
	}
	
}
