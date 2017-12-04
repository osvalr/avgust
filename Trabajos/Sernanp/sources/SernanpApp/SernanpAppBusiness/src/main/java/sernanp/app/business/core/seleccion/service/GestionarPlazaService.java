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

package sernanp.app.business.core.seleccion.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;
import sernanp.app.dao.query.domain.GestionarPlazaQuery;
import sernanp.app.dao.query.domain.SubEtapaPlazaQuery;
import sernanp.app.dao.query.domain.PostulantePlazaQuery;
import sernanp.app.dao.query.domain.ArchivoPlazaQuery;

public interface GestionarPlazaService extends HelperServiceMybatis {
	Integer create(GestionarPlazaQuery model, List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery, List<PostulantePlazaQuery> listPostulantePlazaQuery, List<ArchivoPlazaQuery> listArchivoPlazaQuery)  throws BusinessException, FileNotFoundException, IOException;
	void save(GestionarPlazaQuery model, List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery, List<PostulantePlazaQuery> listPostulantePlazaQuery, List<ArchivoPlazaQuery> listArchivoPlazaQuery)  throws BusinessException, FileNotFoundException, IOException;
	void remove(GestionarPlazaQuery model, List<SubEtapaPlazaQuery> listSubEtapaPlazaQuery, List<PostulantePlazaQuery> listPostulantePlazaQuery, List<ArchivoPlazaQuery> listArchivoPlazaQuery)  throws BusinessException, FileNotFoundException, IOException;
}