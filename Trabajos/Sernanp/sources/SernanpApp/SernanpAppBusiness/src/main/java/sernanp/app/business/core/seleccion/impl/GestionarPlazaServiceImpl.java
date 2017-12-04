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
* DATE CREATE : 20/04/2015 00:26:11
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

import sernanp.app.business.core.common.service.FileCommonsService;
import sernanp.app.business.core.seleccion.service.GestionarPlazaService;
import sernanp.app.dao.domain.TArchivo;
import sernanp.app.dao.domain.TArchivoExample;
import sernanp.app.dao.domain.TArchivoKey;
import sernanp.app.dao.domain.TConvAreaOrgArchivo;
import sernanp.app.dao.domain.TConvAreaOrgArchivoExample;
import sernanp.app.dao.domain.TConvAreaOrgEtapa;
import sernanp.app.dao.domain.TConvAreaOrgEtapaExample;
import sernanp.app.dao.domain.TConvocatoriaAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgExample;
import sernanp.app.dao.mapper.TArchivoMapper;
import sernanp.app.dao.mapper.TConvAreaOrgArchivoMapper;
import sernanp.app.dao.mapper.TConvAreaOrgEtapaMapper;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.dao.query.domain.ArchivoPlazaQuery;
import sernanp.app.dao.query.domain.GestionarPlazaQuery;
import sernanp.app.dao.query.domain.PostulantePlazaQuery;
import sernanp.app.dao.query.domain.SubEtapaPlazaQuery;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GestionarPlazaServiceImpl extends HelperServiceMybatisImpl implements GestionarPlazaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Autowired
	private FileCommonsService fileCommonsService;
	
	@Transactional
	@Override
	public Integer create(GestionarPlazaQuery model, List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery, List<PostulantePlazaQuery> listPostulantePlazaQuery, List<ArchivoPlazaQuery> listArchivoPlazaQuery)  throws BusinessException, FileNotFoundException, IOException {
		
		Integer lastId = null;

		TConvocatoriaAreaOrg tConvocatoriaAreaOrg = beanUtil.copyBean(model, TConvocatoriaAreaOrg.class);
		this.insertSelective(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
		
		
		for (SubEtapaPlazaQuery subEtapaPlazaQuery : listSubEtapaPlazaQuery) {
			subEtapaPlazaQuery.setSrl_id_conv_area_org_etapa(null);
			subEtapaPlazaQuery.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
			TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(subEtapaPlazaQuery, TConvAreaOrgEtapa.class);
			this.insertSelective(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);
		}
		

		for (PostulantePlazaQuery postulantePlazaQuery : listPostulantePlazaQuery) {
			postulantePlazaQuery.setSrl_id_postulante_conv_area_org(null);
			postulantePlazaQuery.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
			TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = beanUtil.copyBean(postulantePlazaQuery, TPostulanteCnvAreaOrg.class);
			this.insertSelective(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
		}
		

		for (ArchivoPlazaQuery archivoPlazaQuery : listArchivoPlazaQuery) {
			archivoPlazaQuery.setSrl_id_archivo(null);
			archivoPlazaQuery.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
			
			TArchivo tArchivo = beanUtil.copyBean(archivoPlazaQuery, TArchivo.class);
			this.insertSelective(TArchivoMapper.class, tArchivo);
						
			File folders = new File(model.getPath_files_plazas() + File.separator + tConvocatoriaAreaOrg.getSrl_id_conv_area_org() + File.separator + tArchivo.getSrl_id_archivo());

			if(!folders.exists()){
				folders.mkdirs();
			}
			
			String fileName = tConvocatoriaAreaOrg.getSrl_id_conv_area_org() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(archivoPlazaQuery.getVar_nombre_archivo());
			File origin = new File(archivoPlazaQuery.getVar_archivo_ruta_almacen());
			File target = new File(folders.getAbsolutePath()+File.separator+fileName);
			fileCommonsService.copy(origin,target);
			
			tArchivo.setTsp_fecha_registro(new Date());
			tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
			tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
			tArchivo.setVar_nombre_archivo(fileName);
			this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
			
			File file = new File(archivoPlazaQuery.getVar_archivo_ruta_almacen());
			file.delete();
			
			TConvAreaOrgArchivo tConvAreaOrgArchivo = new TConvAreaOrgArchivo();
			tConvAreaOrgArchivo.setSrl_id_conv_area_org(archivoPlazaQuery.getSrl_id_conv_area_org());
			tConvAreaOrgArchivo.setSrl_id_conv_area_org_etapa(archivoPlazaQuery.getSrl_id_conv_area_org_etapa());
			tConvAreaOrgArchivo.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
			tConvAreaOrgArchivo.setVar_descrip_archivo(archivoPlazaQuery.getVar_descrip_archivo());
			this.insertSelective(TConvAreaOrgArchivoMapper.class, tConvAreaOrgArchivo);
		}
		lastId = tConvocatoriaAreaOrg.getSrl_id_conv_area_org();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarPlazaQuery model, List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery, List<PostulantePlazaQuery> listPostulantePlazaQuery, List<ArchivoPlazaQuery> listArchivoPlazaQuery)  throws BusinessException, FileNotFoundException, IOException {
	
		TConvocatoriaAreaOrg tConvocatoriaAreaOrg = beanUtil.copyBean(model, TConvocatoriaAreaOrg.class);
		this.updateByPrimaryKeySelective(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
		
		

		TConvAreaOrgEtapaExample tConvAreaOrgEtapaExample = new TConvAreaOrgEtapaExample();
		tConvAreaOrgEtapaExample.createCriteria().andSrl_id_conv_area_orgEqualTo(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
		List<TConvAreaOrgEtapa> listTConvAreaOrgEtapaCurrent = this.selectByExample(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapaExample);
		List<TConvAreaOrgEtapa> listTConvAreaOrgEtapaDeleted = new ArrayList<TConvAreaOrgEtapa>();
		
		for (TConvAreaOrgEtapa tConvAreaOrgEtapa : listTConvAreaOrgEtapaCurrent) {
			boolean noExists = true;
			for (SubEtapaPlazaQuery subEtapaPlazaQuery : listSubEtapaPlazaQuery) {
				if(subEtapaPlazaQuery.getSrl_id_conv_area_org_etapa().equals(tConvAreaOrgEtapa.getSrl_id_conv_area_org_etapa())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTConvAreaOrgEtapaDeleted.add(tConvAreaOrgEtapa);
			}
		}
		
		this.deleteByPrimaryKey(TConvAreaOrgEtapaMapper.class, listTConvAreaOrgEtapaDeleted);
		
		for (SubEtapaPlazaQuery subEtapaPlazaQuery : listSubEtapaPlazaQuery) {
			if(subEtapaPlazaQuery.getSrl_id_conv_area_org_etapa() < 1){
				subEtapaPlazaQuery.setSrl_id_conv_area_org_etapa(null);
				subEtapaPlazaQuery.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
				TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(subEtapaPlazaQuery, TConvAreaOrgEtapa.class);
				this.insertSelective(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);
			}else{
				TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(subEtapaPlazaQuery, TConvAreaOrgEtapa.class);
				this.updateByPrimaryKeySelective(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);
			}
		}
		/* End TConvAreaOrgEtapa */	
		

		TPostulanteCnvAreaOrgExample tPostulanteCnvAreaOrgExample = new TPostulanteCnvAreaOrgExample();
		tPostulanteCnvAreaOrgExample.createCriteria().andSrl_id_conv_area_orgEqualTo(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
		List<TPostulanteCnvAreaOrg> listTPostulanteCnvAreaOrgCurrent = this.selectByExample(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgExample);
		List<TPostulanteCnvAreaOrg> listTPostulanteCnvAreaOrgDeleted = new ArrayList<TPostulanteCnvAreaOrg>();
		
		for (TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg : listTPostulanteCnvAreaOrgCurrent) {
			boolean noExists = true;
			for (PostulantePlazaQuery postulantePlazaQuery : listPostulantePlazaQuery) {
				if(postulantePlazaQuery.getSrl_id_postulante_conv_area_org().equals(tPostulanteCnvAreaOrg.getSrl_id_postulante_conv_area_org())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTPostulanteCnvAreaOrgDeleted.add(tPostulanteCnvAreaOrg);
			}
		}
		
		this.deleteByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, listTPostulanteCnvAreaOrgDeleted);
		
		for (PostulantePlazaQuery postulantePlazaQuery : listPostulantePlazaQuery) {
			if(postulantePlazaQuery.getSrl_id_postulante_conv_area_org() < 1){
				postulantePlazaQuery.setSrl_id_postulante_conv_area_org(null);
				postulantePlazaQuery.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
				TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = beanUtil.copyBean(postulantePlazaQuery, TPostulanteCnvAreaOrg.class);
				this.insertSelective(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
			}else{
				TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = beanUtil.copyBean(postulantePlazaQuery, TPostulanteCnvAreaOrg.class);
				this.updateByPrimaryKeySelective(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
			}
		}
		/* End TPostulanteCnvAreaOrg */	
		

		TConvAreaOrgArchivoExample tConvAreaOrgArchivoExample = new TConvAreaOrgArchivoExample();
		tConvAreaOrgArchivoExample.createCriteria().andSrl_id_conv_area_orgEqualTo(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
		List<TConvAreaOrgArchivo> listTConvAreaOrgArchivoCurrent = this.selectByExample(TConvAreaOrgArchivoMapper.class, tConvAreaOrgArchivoExample);
		List<TConvAreaOrgArchivo> listTConvAreaOrgArchivoDeleted = new ArrayList<TConvAreaOrgArchivo>();
		
		for (TConvAreaOrgArchivo tConvAreaOrgArchivo : listTConvAreaOrgArchivoCurrent) {
			boolean noExists = true;
			for (ArchivoPlazaQuery archivoPlazaQuery : listArchivoPlazaQuery) {
				if(archivoPlazaQuery.getSrl_id_archivo().equals(tConvAreaOrgArchivo.getSrl_id_archivo())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTConvAreaOrgArchivoDeleted.add(tConvAreaOrgArchivo);
			}
		}
		
//		this.deleteByPrimaryKey(TConvAreaOrgArchivoMapper.class, listTConvAreaOrgArchivoDeleted);
		
		for (TConvAreaOrgArchivo tConvAreaOrgArchivo : listTConvAreaOrgArchivoDeleted) {
			this.deleteByPrimaryKey(TConvAreaOrgArchivoMapper.class, tConvAreaOrgArchivo);
			TArchivoKey tArchivoKey = new TArchivo();
			tArchivoKey.setSrl_id_archivo(tConvAreaOrgArchivo.getSrl_id_archivo());
			this.deleteByPrimaryKey(TArchivoMapper.class, tArchivoKey);
		}
		
		for (ArchivoPlazaQuery archivoPlazaQuery : listArchivoPlazaQuery) {
			if(archivoPlazaQuery.getSrl_id_archivo() < 1){
				archivoPlazaQuery.setSrl_id_archivo(null);
				archivoPlazaQuery.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
				
				TArchivo tArchivo = beanUtil.copyBean(archivoPlazaQuery, TArchivo.class);
				this.insertSelective(TArchivoMapper.class, tArchivo);
				
				File folders = new File(model.getPath_files_plazas() + File.separator + tConvocatoriaAreaOrg.getSrl_id_conv_area_org() + File.separator + tArchivo.getSrl_id_archivo());

				if(!folders.exists()){
					folders.mkdirs();
				}
				
				String fileName = tConvocatoriaAreaOrg.getSrl_id_conv_area_org() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(archivoPlazaQuery.getVar_nombre_archivo());
				File origin = new File(archivoPlazaQuery.getVar_archivo_ruta_almacen());
				File target = new File(folders.getAbsolutePath()+File.separator+fileName);
				fileCommonsService.copy(origin,target);
				
				tArchivo.setTsp_fecha_registro(new Date());
				tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
				tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
				tArchivo.setVar_nombre_archivo(fileName);
				this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
				
				File file = new File(archivoPlazaQuery.getVar_archivo_ruta_almacen());
				file.delete();
				
				TConvAreaOrgArchivo tConvAreaOrgArchivo = new TConvAreaOrgArchivo();
				tConvAreaOrgArchivo.setSrl_id_conv_area_org(archivoPlazaQuery.getSrl_id_conv_area_org());
				tConvAreaOrgArchivo.setSrl_id_conv_area_org_etapa(archivoPlazaQuery.getSrl_id_conv_area_org_etapa());
				tConvAreaOrgArchivo.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
				tConvAreaOrgArchivo.setVar_descrip_archivo(archivoPlazaQuery.getVar_descrip_archivo());
				this.insertSelective(TConvAreaOrgArchivoMapper.class, tConvAreaOrgArchivo);
			}else{
				
				TArchivo tArchivo = beanUtil.copyBean(archivoPlazaQuery, TArchivo.class);
				this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
				
				TArchivoExample tArchivoExample = new TArchivoExample();
				tArchivoExample.createCriteria().andVar_nombre_archivoEqualTo(tArchivo.getVar_nombre_archivo()).andSrl_id_archivoEqualTo(tArchivo.getSrl_id_archivo());
				
				List<TArchivo> listTArchivo = this.selectByExample(TArchivoMapper.class, tArchivoExample);
				
				if(listTArchivo.isEmpty()){
					File folders = new File(model.getPath_files_plazas() + File.separator + tConvocatoriaAreaOrg.getSrl_id_conv_area_org() + File.separator + tArchivo.getSrl_id_archivo());

					if(!folders.exists()){
						folders.mkdirs();
					}
					
					String fileName = tConvocatoriaAreaOrg.getSrl_id_conv_area_org() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(archivoPlazaQuery.getVar_nombre_archivo());
					File origin = new File(archivoPlazaQuery.getVar_archivo_ruta_almacen());
					File target = new File(folders.getAbsolutePath()+File.separator+fileName);
					fileCommonsService.copy(origin,target);
					
					tArchivo.setTsp_fecha_registro(new Date());
					tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
					tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
					tArchivo.setVar_nombre_archivo(fileName);
					this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
					
					File file = new File(archivoPlazaQuery.getVar_archivo_ruta_almacen());
					file.delete();
				}
				
				
				TConvAreaOrgArchivo tConvAreaOrgArchivo = beanUtil.copyBean(archivoPlazaQuery, TConvAreaOrgArchivo.class);
				this.updateByPrimaryKeySelective(TConvAreaOrgArchivoMapper.class, tConvAreaOrgArchivo);
			}
		}
		/* End TConvAreaOrgArchivo */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarPlazaQuery model, List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery, List<PostulantePlazaQuery> listPostulantePlazaQuery, List<ArchivoPlazaQuery> listArchivoPlazaQuery)  throws BusinessException, FileNotFoundException, IOException {
	
		for (SubEtapaPlazaQuery subEtapaPlazaQuery : listSubEtapaPlazaQuery) {
			TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(subEtapaPlazaQuery, TConvAreaOrgEtapa.class);
			this.deleteByPrimaryKey(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);
		}
		for (PostulantePlazaQuery postulantePlazaQuery : listPostulantePlazaQuery) {
			TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = beanUtil.copyBean(postulantePlazaQuery, TPostulanteCnvAreaOrg.class);
			this.deleteByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
		}
		for (ArchivoPlazaQuery archivoPlazaQuery : listArchivoPlazaQuery) {
			TConvAreaOrgArchivo tConvAreaOrgArchivo = beanUtil.copyBean(archivoPlazaQuery, TConvAreaOrgArchivo.class);
			this.deleteByPrimaryKey(TConvAreaOrgArchivoMapper.class, tConvAreaOrgArchivo);
			
			TArchivo tArchivo = beanUtil.copyBean(archivoPlazaQuery, TArchivo.class);
			this.deleteByPrimaryKey(TArchivoMapper.class, tArchivo);
		}

		TConvocatoriaAreaOrg tConvocatoriaAreaOrg = beanUtil.copyBean(model, TConvocatoriaAreaOrg.class);
		this.deleteByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
	}

}
