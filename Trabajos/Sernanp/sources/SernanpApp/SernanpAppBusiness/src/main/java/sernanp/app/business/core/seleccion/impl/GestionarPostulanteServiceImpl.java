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
* DATE CREATE : 15/04/2015 00:11:39
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
import sernanp.app.business.core.seleccion.service.GestionarPostulanteService;
import sernanp.app.dao.domain.Persona;
import sernanp.app.dao.domain.Personanatural;
import sernanp.app.dao.domain.PersonanaturalExample;
import sernanp.app.dao.domain.TArchivo;
import sernanp.app.dao.domain.TArchivoExample;
import sernanp.app.dao.domain.TArchivoKey;
import sernanp.app.dao.domain.TNumeroTelefono;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgExample;
import sernanp.app.dao.domain.TPostulanteNumeroTelefono;
import sernanp.app.dao.domain.TPostulantePersonal;
import sernanp.app.dao.domain.TPostulantePersonalArchivo;
import sernanp.app.dao.domain.TPostulantePersonalArchivoExample;
import sernanp.app.dao.mapper.PersonaMapper;
import sernanp.app.dao.mapper.PersonanaturalMapper;
import sernanp.app.dao.mapper.TArchivoMapper;
import sernanp.app.dao.mapper.TNumeroTelefonoMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.dao.mapper.TPostulanteNumeroTelefonoMapper;
import sernanp.app.dao.mapper.TPostulantePersonalArchivoMapper;
import sernanp.app.dao.mapper.TPostulantePersonalMapper;
import sernanp.app.dao.query.domain.ArchivoPostulanteQuery;
import sernanp.app.dao.query.domain.GestionarPersonaNaturalQuery;
import sernanp.app.dao.query.domain.PostulacionPersonaQuery;
import sernanp.app.dao.query.domain.PostulanteNumeroTelefonoQuery;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GestionarPostulanteServiceImpl extends HelperServiceMybatisImpl implements GestionarPostulanteService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Autowired
	private FileCommonsService fileCommonsService;
	
	@Transactional
	@Override
	public Integer create(GestionarPersonaNaturalQuery model, List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery, List<ArchivoPostulanteQuery> listArchivoPostulanteQuery, List<PostulacionPersonaQuery> listPostulacionPersonaQuery) throws BusinessException, FileNotFoundException, IOException {
		
		Integer lastId = null;

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.insertSelective(PersonaMapper.class, persona);

		Personanatural personanatural = beanUtil.copyBean(model, Personanatural.class);
		personanatural.setIdpersona(persona.getIdpersona());
		
		PersonanaturalExample personanaturalExample = new PersonanaturalExample();
		personanaturalExample.createCriteria().andIdtipodocumentoEqualTo(personanatural.getIdtipodocumento()).
		andNumerodocEqualTo(personanatural.getNumerodoc());
		
		List<Personanatural> listPersonanatural = this.selectByExample(PersonanaturalMapper.class, personanaturalExample);
		
		if(!listPersonanatural.isEmpty()){
			throw new BusinessException("Error, el tipo y numero de documento ya estan registrados.");
		}
		
		personanaturalExample = new PersonanaturalExample();
		personanaturalExample.createCriteria().andRucEqualTo(personanatural.getRuc());
		
		listPersonanatural = this.selectByExample(PersonanaturalMapper.class, personanaturalExample);
		
		if(!listPersonanatural.isEmpty()){
			throw new BusinessException("Error, el R.U.C ya esta registrado.");
		}
		
		this.insertSelective(PersonanaturalMapper.class, personanatural);

		TPostulantePersonal tPostulantePersonal = beanUtil.copyBean(model, TPostulantePersonal.class);
		tPostulantePersonal.setInt_id_postulante(personanatural.getIdpersonanatural());
		this.insertSelective(TPostulantePersonalMapper.class, tPostulantePersonal);
		
		/*
		if(listPostulanteNumeroTelefonoQuery == null){
			throw new BusinessException("Error, no existen registros en TPostulanteNumeroTelefono.");
		}else if(listPostulanteNumeroTelefonoQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TPostulanteNumeroTelefono.");
		}
		*/

//		for (PostulanteNumeroTelefonoQuery postulanteNumeroTelefonoQuery : listPostulanteNumeroTelefonoQuery) {
//			
//			postulanteNumeroTelefonoQuery.setSrl_id_numero_telefono(null);
//			postulanteNumeroTelefonoQuery.setInt_id_postulante(tPostulantePersonal.getInt_id_postulante());
//			
//			TNumeroTelefono tNumeroTelefono = beanUtil.copyBean(postulanteNumeroTelefonoQuery, TNumeroTelefono.class);
//			this.insertSelective(TNumeroTelefonoMapper.class, tNumeroTelefono);
//			
//			TPostulanteNumeroTelefono tPostulanteNumeroTelefono = new TPostulanteNumeroTelefono();
//			tPostulanteNumeroTelefono.setInt_id_postulante(postulanteNumeroTelefonoQuery.getInt_id_postulante());
//			tPostulanteNumeroTelefono.setSrl_id_numero_telefono(tNumeroTelefono.getSrl_id_numero_telefono());
//			this.insertSelective(TPostulanteNumeroTelefonoMapper.class, tPostulanteNumeroTelefono);
//		}
		/*
		if(listArchivoPostulanteQuery == null){
			throw new BusinessException("Error, no existen registros en TPostulantePersonalArchivo.");
		}else if(listArchivoPostulanteQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TPostulantePersonalArchivo.");
		}
		*/

		for (ArchivoPostulanteQuery archivoPostulanteQuery : listArchivoPostulanteQuery) {
			archivoPostulanteQuery.setSrl_id_archivo(null);
			archivoPostulanteQuery.setInt_id_postulante(tPostulantePersonal.getInt_id_postulante());
			
			TArchivo tArchivo = beanUtil.copyBean(archivoPostulanteQuery, TArchivo.class);
			this.insertSelective(TArchivoMapper.class, tArchivo);
						
			File folders = new File(model.getPath_files_postulantes() + File.separator + personanatural.getIdpersonanatural() + File.separator + tArchivo.getSrl_id_archivo());

			if(!folders.exists()){
				folders.mkdirs();
			}
			
			String fileName = personanatural.getIdpersonanatural() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(archivoPostulanteQuery.getVar_nombre_archivo());
			File origin = new File(archivoPostulanteQuery.getVar_archivo_ruta_almacen());
			File target = new File(folders.getAbsolutePath()+File.separator+fileName);
			fileCommonsService.copy(origin,target);
			
			tArchivo.setTsp_fecha_registro(new Date());
			tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
			tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
			tArchivo.setVar_nombre_archivo(fileName);
			this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
			
			File file = new File(archivoPostulanteQuery.getVar_archivo_ruta_almacen());
			file.delete();
			
			TPostulantePersonalArchivo tPostulantePersonalArchivo = new TPostulantePersonalArchivo();
			tPostulantePersonalArchivo.setInt_id_postulante(archivoPostulanteQuery.getInt_id_postulante());
			tPostulantePersonalArchivo.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
			tPostulantePersonalArchivo.setVar_descripcion_archivo(archivoPostulanteQuery.getVar_descripcion_archivo());
			tPostulantePersonalArchivo.setInt_id_tipo_documento(archivoPostulanteQuery.getInt_id_tipo_documento());
			
			this.insertSelective(TPostulantePersonalArchivoMapper.class, tPostulantePersonalArchivo);
		}
		/*
		if(listPostulacionPersonaQuery == null){
			throw new BusinessException("Error, no existen registros en TPostulanteCnvAreaOrg.");
		}else if(listPostulacionPersonaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TPostulanteCnvAreaOrg.");
		}
		*/
		
		for (PostulacionPersonaQuery postulacionPersonaQuery : listPostulacionPersonaQuery) {
			
			postulacionPersonaQuery.setSrl_id_archivo(null);
			postulacionPersonaQuery.setInt_id_postulante(tPostulantePersonal.getInt_id_postulante());
			
			TArchivo tArchivo = beanUtil.copyBean(postulacionPersonaQuery, TArchivo.class);
			this.insertSelective(TArchivoMapper.class, tArchivo);
			
			File folders = new File(model.getPath_files_postulantes() + File.separator + personanatural.getIdpersonanatural() + File.separator + tArchivo.getSrl_id_archivo());

			if(!folders.exists()){
				folders.mkdirs();
			}
			
			String fileName = personanatural.getIdpersonanatural() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(postulacionPersonaQuery.getVar_nombre_archivo());
			File origin = new File(postulacionPersonaQuery.getVar_archivo_ruta_almacen());
			File target = new File(folders.getAbsolutePath()+File.separator+fileName);
			fileCommonsService.copy(origin,target);
			
			tArchivo.setTsp_fecha_registro(new Date());
			tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
			tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
			tArchivo.setVar_nombre_archivo(fileName);
			this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
			
			File file = new File(postulacionPersonaQuery.getVar_archivo_ruta_almacen());
			file.delete();
			
			postulacionPersonaQuery.setSrl_id_postulante_conv_area_org(null);
			TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = beanUtil.copyBean(postulacionPersonaQuery, TPostulanteCnvAreaOrg.class);
			tPostulanteCnvAreaOrg.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
			this.insertSelective(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
			
		}
		
		lastId = personanatural.getIdpersonanatural();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarPersonaNaturalQuery model, List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery, List<ArchivoPostulanteQuery> listArchivoPostulanteQuery, List<PostulacionPersonaQuery> listPostulacionPersonaQuery) throws BusinessException, FileNotFoundException, IOException {
	
		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.updateByPrimaryKeySelective(PersonaMapper.class, persona);
		
		Personanatural personanatural = beanUtil.copyBean(model, Personanatural.class);
		this.updateByPrimaryKeySelective(PersonanaturalMapper.class, personanatural);
		
		PersonanaturalExample personanaturalExample = new PersonanaturalExample();
		personanaturalExample.createCriteria().andIdtipodocumentoEqualTo(personanatural.getIdtipodocumento()).
		andNumerodocEqualTo(personanatural.getNumerodoc()).
		andIdpersonanaturalNotEqualTo(personanatural.getIdpersonanatural());
		
		List<Personanatural> listPersonanatural = this.selectByExample(PersonanaturalMapper.class, personanaturalExample);
		
		if(!listPersonanatural.isEmpty()){
			throw new BusinessException("Error, el tipo y numero de documento ya estan registrados.");
		}
		
		personanaturalExample = new PersonanaturalExample();
		personanaturalExample.createCriteria().andRucEqualTo(personanatural.getRuc()).
		andIdpersonanaturalNotEqualTo(personanatural.getIdpersonanatural());
		
		listPersonanatural = this.selectByExample(PersonanaturalMapper.class, personanaturalExample);
		
		if(!listPersonanatural.isEmpty()){
			throw new BusinessException("Error, el R.U.C ya esta registrado.");
		}
		
		TPostulantePersonal tPostulantePersonal = beanUtil.copyBean(model, TPostulantePersonal.class);
		if(tPostulantePersonal.getInt_id_postulante() == null){
			tPostulantePersonal.setInt_id_postulante(personanatural.getIdpersonanatural());
			this.insertSelective(TPostulantePersonalMapper.class, tPostulantePersonal);
		}else{
//			if(tPostulantePersonal.getVar_observacion_registro() == null){
//				tPostulantePersonal.setVar_observacion_registro("");
//			}
			this.updateByPrimaryKey(TPostulantePersonalMapper.class, tPostulantePersonal);
		}
		
		/* Start TPostulanteNumeroTelefono */
		/*
		if(listPostulanteNumeroTelefonoQuery == null){
			throw new BusinessException("Error, no existen registros en TPostulanteNumeroTelefono.");
		}else if(listPostulanteNumeroTelefonoQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TPostulanteNumeroTelefono.");
		}
		*/

//		TPostulanteNumeroTelefonoExample tPostulanteNumeroTelefonoExample = new TPostulanteNumeroTelefonoExample();
//		tPostulanteNumeroTelefonoExample.createCriteria().andInt_id_postulanteEqualTo(personanatural.getIdpersonanatural());
//		List<TPostulanteNumeroTelefono> listTPostulanteNumeroTelefonoCurrent = this.selectByExample(TPostulanteNumeroTelefonoMapper.class, tPostulanteNumeroTelefonoExample);
//		List<TPostulanteNumeroTelefono> listTPostulanteNumeroTelefonoDeleted = new ArrayList<TPostulanteNumeroTelefono>();
//		
//		for (TPostulanteNumeroTelefono tPostulanteNumeroTelefono : listTPostulanteNumeroTelefonoCurrent) {
//			boolean noExists = true;
//			for (PostulanteNumeroTelefonoQuery postulanteNumeroTelefonoQuery : listPostulanteNumeroTelefonoQuery) {
//				if(postulanteNumeroTelefonoQuery.getSrl_id_numero_telefono().equals(tPostulanteNumeroTelefono.getSrl_id_numero_telefono())){
//					noExists = false;
//					break;
//				}
//			}
//			if(noExists){
//				listTPostulanteNumeroTelefonoDeleted.add(tPostulanteNumeroTelefono);
//			}
//		}
		
//		this.deleteByPrimaryKey(TPostulanteNumeroTelefonoMapper.class, listTPostulanteNumeroTelefonoDeleted);
		
//		for (TPostulanteNumeroTelefono tPostulanteNumeroTelefono : listTPostulanteNumeroTelefonoDeleted) {
//			this.deleteByPrimaryKey(TPostulanteNumeroTelefonoMapper.class, tPostulanteNumeroTelefono);
//			TNumeroTelefonoKey tNumeroTelefonoKey = new TNumeroTelefono();
//			tNumeroTelefonoKey.setSrl_id_numero_telefono(tPostulanteNumeroTelefono.getSrl_id_numero_telefono());
//			this.deleteByPrimaryKey(TNumeroTelefonoMapper.class, tNumeroTelefonoKey);
//		}
		
//		for (PostulanteNumeroTelefonoQuery postulanteNumeroTelefonoQuery : listPostulanteNumeroTelefonoQuery) {
//			if(postulanteNumeroTelefonoQuery.getSrl_id_numero_telefono() < 1){				
//				postulanteNumeroTelefonoQuery.setSrl_id_numero_telefono(null);
//				postulanteNumeroTelefonoQuery.setInt_id_postulante(tPostulantePersonal.getInt_id_postulante());
//				
//				TNumeroTelefono tNumeroTelefono = beanUtil.copyBean(postulanteNumeroTelefonoQuery, TNumeroTelefono.class);
//				this.insertSelective(TNumeroTelefonoMapper.class, tNumeroTelefono);
//				
//				TPostulanteNumeroTelefono tPostulanteNumeroTelefono = new TPostulanteNumeroTelefono();
//				tPostulanteNumeroTelefono.setInt_id_postulante(postulanteNumeroTelefonoQuery.getInt_id_postulante());
//				tPostulanteNumeroTelefono.setSrl_id_numero_telefono(tNumeroTelefono.getSrl_id_numero_telefono());
//				this.insertSelective(TPostulanteNumeroTelefonoMapper.class, tPostulanteNumeroTelefono);
//				
//			}else{
//				TNumeroTelefono tNumeroTelefono = beanUtil.copyBean(postulanteNumeroTelefonoQuery, TNumeroTelefono.class);
//				this.updateByPrimaryKeySelective(TNumeroTelefonoMapper.class, tNumeroTelefono);
//				
//				TPostulanteNumeroTelefono tPostulanteNumeroTelefono = beanUtil.copyBean(postulanteNumeroTelefonoQuery, TPostulanteNumeroTelefono.class);
//				this.updateByPrimaryKeySelective(TPostulanteNumeroTelefonoMapper.class, tPostulanteNumeroTelefono);
//			}
//		}
		
		/* End TPostulanteNumeroTelefono */	
		/* Start TPostulantePersonalArchivo */
		/*
		if(listArchivoPostulanteQuery == null){
			throw new BusinessException("Error, no existen registros en TPostulantePersonalArchivo.");
		}else if(listArchivoPostulanteQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TPostulantePersonalArchivo.");
		}
		*/

		TPostulantePersonalArchivoExample tPostulantePersonalArchivoExample = new TPostulantePersonalArchivoExample();
		tPostulantePersonalArchivoExample.createCriteria().andInt_id_postulanteEqualTo(personanatural.getIdpersonanatural());
		List<TPostulantePersonalArchivo> listTPostulantePersonalArchivoCurrent = this.selectByExample(TPostulantePersonalArchivoMapper.class, tPostulantePersonalArchivoExample);
		List<TPostulantePersonalArchivo> listTPostulantePersonalArchivoDeleted = new ArrayList<TPostulantePersonalArchivo>();
		
		for (TPostulantePersonalArchivo tPostulantePersonalArchivo : listTPostulantePersonalArchivoCurrent) {
			boolean noExists = true;
			for (ArchivoPostulanteQuery archivoPostulanteQuery : listArchivoPostulanteQuery) {
				if(archivoPostulanteQuery.getSrl_id_archivo().equals(tPostulantePersonalArchivo.getSrl_id_archivo())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTPostulantePersonalArchivoDeleted.add(tPostulantePersonalArchivo);
			}
		}
		
//		this.deleteByPrimaryKey(TPostulantePersonalArchivoMapper.class, listTPostulantePersonalArchivoDeleted);
		
		for (TPostulantePersonalArchivo tPostulantePersonalArchivo : listTPostulantePersonalArchivoDeleted) {
			this.deleteByPrimaryKey(TPostulantePersonalArchivoMapper.class, tPostulantePersonalArchivo);
			TArchivoKey tArchivoKey = new TArchivo();
			tArchivoKey.setSrl_id_archivo(tPostulantePersonalArchivo.getSrl_id_archivo());
			this.deleteByPrimaryKey(TArchivoMapper.class, tArchivoKey);
		}
		
		for (ArchivoPostulanteQuery archivoPostulanteQuery : listArchivoPostulanteQuery) {
			if(archivoPostulanteQuery.getSrl_id_archivo() < 1){
				archivoPostulanteQuery.setSrl_id_archivo(null);
				archivoPostulanteQuery.setInt_id_postulante(tPostulantePersonal.getInt_id_postulante());
				
				TArchivo tArchivo = beanUtil.copyBean(archivoPostulanteQuery, TArchivo.class);
				this.insertSelective(TArchivoMapper.class, tArchivo);
				
				File folders = new File(model.getPath_files_postulantes() + File.separator + personanatural.getIdpersonanatural() + File.separator + tArchivo.getSrl_id_archivo());

				if(!folders.exists()){
					folders.mkdirs();
				}
				
				String fileName = personanatural.getIdpersonanatural() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(archivoPostulanteQuery.getVar_nombre_archivo());
				File origin = new File(archivoPostulanteQuery.getVar_archivo_ruta_almacen());
				File target = new File(folders.getAbsolutePath()+File.separator+fileName);
				fileCommonsService.copy(origin,target);
				
				tArchivo.setTsp_fecha_registro(new Date());
				tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
				tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
				tArchivo.setVar_nombre_archivo(fileName);
				this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
				
				File file = new File(archivoPostulanteQuery.getVar_archivo_ruta_almacen());
				file.delete();
				
				TPostulantePersonalArchivo tPostulantePersonalArchivo = new TPostulantePersonalArchivo();
				tPostulantePersonalArchivo.setInt_id_postulante(archivoPostulanteQuery.getInt_id_postulante());
				tPostulantePersonalArchivo.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
				tPostulantePersonalArchivo.setVar_descripcion_archivo(archivoPostulanteQuery.getVar_descripcion_archivo());
				tPostulantePersonalArchivo.setInt_id_tipo_documento(archivoPostulanteQuery.getInt_id_tipo_documento());
				this.insertSelective(TPostulantePersonalArchivoMapper.class, tPostulantePersonalArchivo);
			}else{
				
				TArchivo tArchivo = beanUtil.copyBean(archivoPostulanteQuery, TArchivo.class);
				this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
				
				TArchivoExample tArchivoExample = new TArchivoExample();
				tArchivoExample.createCriteria().andVar_nombre_archivoEqualTo(tArchivo.getVar_nombre_archivo()).andSrl_id_archivoEqualTo(tArchivo.getSrl_id_archivo());
				
				List<TArchivo> listTArchivo = this.selectByExample(TArchivoMapper.class, tArchivoExample);
				
				if(listTArchivo.isEmpty()){
					File folders = new File(model.getPath_files_postulantes() + File.separator + personanatural.getIdpersonanatural() + File.separator + tArchivo.getSrl_id_archivo());

					if(!folders.exists()){
						folders.mkdirs();
					}
					
					String fileName = personanatural.getIdpersonanatural() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(archivoPostulanteQuery.getVar_nombre_archivo());
					File origin = new File(archivoPostulanteQuery.getVar_archivo_ruta_almacen());
					File target = new File(folders.getAbsolutePath()+File.separator+fileName);
					fileCommonsService.copy(origin,target);
					
					tArchivo.setTsp_fecha_registro(new Date());
					tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
					tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
					tArchivo.setVar_nombre_archivo(fileName);
					this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
					
					File file = new File(archivoPostulanteQuery.getVar_archivo_ruta_almacen());
					file.delete();
				}
				
				TPostulantePersonalArchivo tPostulantePersonalArchivo = beanUtil.copyBean(archivoPostulanteQuery, TPostulantePersonalArchivo.class);
				this.updateByPrimaryKeySelective(TPostulantePersonalArchivoMapper.class, tPostulantePersonalArchivo);
			}
		}
		
		/* End TPostulantePersonalArchivo */	
		/* Start TPostulanteCnvAreaOrg */
		/*
		if(listPostulacionPersonaQuery == null){
			throw new BusinessException("Error, no existen registros en TPostulanteCnvAreaOrg.");
		}else if(listPostulacionPersonaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TPostulanteCnvAreaOrg.");
		}
		*/

		TPostulanteCnvAreaOrgExample tPostulanteCnvAreaOrgExample = new TPostulanteCnvAreaOrgExample();
		tPostulanteCnvAreaOrgExample.createCriteria().andInt_id_postulanteEqualTo(personanatural.getIdpersonanatural());
		List<TPostulanteCnvAreaOrg> listTPostulanteCnvAreaOrgCurrent = this.selectByExample(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgExample);
		List<TPostulanteCnvAreaOrg> listTPostulanteCnvAreaOrgDeleted = new ArrayList<TPostulanteCnvAreaOrg>();
		
		for (TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg : listTPostulanteCnvAreaOrgCurrent) {
			boolean noExists = true;
			for (PostulacionPersonaQuery postulacionPersonaQuery : listPostulacionPersonaQuery) {
				if(postulacionPersonaQuery.getSrl_id_postulante_conv_area_org().equals(tPostulanteCnvAreaOrg.getSrl_id_postulante_conv_area_org())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTPostulanteCnvAreaOrgDeleted.add(tPostulanteCnvAreaOrg);
			}
		}
		
		this.deleteByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, listTPostulanteCnvAreaOrgDeleted);
		

		for (PostulacionPersonaQuery postulacionPersonaQuery : listPostulacionPersonaQuery) {
			if(postulacionPersonaQuery.getSrl_id_postulante_conv_area_org() < 1){
				postulacionPersonaQuery.setSrl_id_postulante_conv_area_org(null);
				postulacionPersonaQuery.setSrl_id_archivo(null);
				postulacionPersonaQuery.setInt_id_postulante(tPostulantePersonal.getInt_id_postulante());
				
				TArchivo tArchivo = beanUtil.copyBean(postulacionPersonaQuery, TArchivo.class);
				this.insertSelective(TArchivoMapper.class, tArchivo);
				
				File folders = new File(model.getPath_files_postulantes() + File.separator + personanatural.getIdpersonanatural() + File.separator + tArchivo.getSrl_id_archivo());

				if(!folders.exists()){
					folders.mkdirs();
				}
				
				String fileName = personanatural.getIdpersonanatural() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(postulacionPersonaQuery.getVar_nombre_archivo());
				File origin = new File(postulacionPersonaQuery.getVar_archivo_ruta_almacen());
				File target = new File(folders.getAbsolutePath()+File.separator+fileName);
				fileCommonsService.copy(origin,target);
				
				tArchivo.setTsp_fecha_registro(new Date());
				tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
				tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
				tArchivo.setVar_nombre_archivo(fileName);
				this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
				
				File file = new File(postulacionPersonaQuery.getVar_archivo_ruta_almacen());
				file.delete();
				
				TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = beanUtil.copyBean(postulacionPersonaQuery, TPostulanteCnvAreaOrg.class);
				tPostulanteCnvAreaOrg.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
				this.insertSelective(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
			}else{
				
				TArchivo tArchivo = beanUtil.copyBean(postulacionPersonaQuery, TArchivo.class);
				this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
				
				TArchivoExample tArchivoExample = new TArchivoExample();
				tArchivoExample.createCriteria().andVar_nombre_archivoEqualTo(tArchivo.getVar_nombre_archivo()).andSrl_id_archivoEqualTo(tArchivo.getSrl_id_archivo());
				
				List<TArchivo> listTArchivo = this.selectByExample(TArchivoMapper.class, tArchivoExample);
				
				if(listTArchivo.isEmpty()){
					File folders = new File(model.getPath_files_postulantes() + File.separator + personanatural.getIdpersonanatural() + File.separator + tArchivo.getSrl_id_archivo());

					if(!folders.exists()){
						folders.mkdirs();
					}
					
					String fileName = personanatural.getIdpersonanatural() +"_" + tArchivo.getSrl_id_archivo() + "_" + fileCommonsService.nextSessionId() + "." +fileCommonsService.getFileExtension(postulacionPersonaQuery.getVar_nombre_archivo());
					File origin = new File(postulacionPersonaQuery.getVar_archivo_ruta_almacen());
					File target = new File(folders.getAbsolutePath()+File.separator+fileName);
					fileCommonsService.copy(origin,target);
					
					tArchivo.setTsp_fecha_registro(new Date());
					tArchivo.setVar_archivo_ruta_almacen(target.getAbsolutePath());
					tArchivo.setNum_size_archivo(new BigDecimal(String.valueOf(target.length()/(1024 * 1024 * 1.0))));
					tArchivo.setVar_nombre_archivo(fileName);
					this.updateByPrimaryKeySelective(TArchivoMapper.class, tArchivo);
					
					File file = new File(postulacionPersonaQuery.getVar_archivo_ruta_almacen());
					file.delete();
				}

				
				TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = beanUtil.copyBean(postulacionPersonaQuery, TPostulanteCnvAreaOrg.class);
				tPostulanteCnvAreaOrg.setSrl_id_archivo(tArchivo.getSrl_id_archivo());
				this.updateByPrimaryKeySelective(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
			}
		}
		
		/* End TPostulanteCnvAreaOrg */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarPersonaNaturalQuery model, List<PostulanteNumeroTelefonoQuery> listPostulanteNumeroTelefonoQuery, List<ArchivoPostulanteQuery> listArchivoPostulanteQuery, List<PostulacionPersonaQuery> listPostulacionPersonaQuery) throws BusinessException, FileNotFoundException, IOException {
	
		for (PostulanteNumeroTelefonoQuery postulanteNumeroTelefonoQuery : listPostulanteNumeroTelefonoQuery) {
			TPostulanteNumeroTelefono tPostulanteNumeroTelefono = beanUtil.copyBean(postulanteNumeroTelefonoQuery, TPostulanteNumeroTelefono.class);
			this.deleteByPrimaryKey(TPostulanteNumeroTelefonoMapper.class, tPostulanteNumeroTelefono);
			
			TNumeroTelefono tNumeroTelefono = beanUtil.copyBean(postulanteNumeroTelefonoQuery, TNumeroTelefono.class);
			this.deleteByPrimaryKey(TNumeroTelefonoMapper.class, tNumeroTelefono);
		}
		for (ArchivoPostulanteQuery archivoPostulanteQuery : listArchivoPostulanteQuery) {
			TPostulantePersonalArchivo tPostulantePersonalArchivo = beanUtil.copyBean(archivoPostulanteQuery, TPostulantePersonalArchivo.class);
			this.deleteByPrimaryKey(TPostulantePersonalArchivoMapper.class, tPostulantePersonalArchivo);
			
			TArchivo tArchivo = beanUtil.copyBean(archivoPostulanteQuery, TArchivo.class);
			this.deleteByPrimaryKey(TArchivoMapper.class, tArchivo);
		}
		for (PostulacionPersonaQuery postulacionPersonaQuery : listPostulacionPersonaQuery) {
			TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = beanUtil.copyBean(postulacionPersonaQuery, TPostulanteCnvAreaOrg.class);
			this.deleteByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
		}

		TPostulantePersonal tPostulantePersonal = beanUtil.copyBean(model, TPostulantePersonal.class);
		this.deleteByPrimaryKey(TPostulantePersonalMapper.class, tPostulantePersonal);

		Personanatural personanatural = beanUtil.copyBean(model, Personanatural.class);
		this.deleteByPrimaryKey(PersonanaturalMapper.class, personanatural);

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.deleteByPrimaryKey(PersonaMapper.class, persona);
	}

}
