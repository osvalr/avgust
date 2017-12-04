/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 22/01/2015 18:47:38
* VERSION : 1.0 
*/

Ext.define('MyApp.model.GestionarCongregacionLocal.MainModel', {
    extend: 'Ext.data.Model',
    fields: [		
                		{name: 'id_persona', type: 'integer'}
               		   ,{name: 'id_persona_juridica', type: 'integer'}
               		   ,{name: 'id_congregacion_local', type: 'integer'}
               		   ,{name: 'id_congregacion_general', type: 'integer'}
               		   ,{name: 'id_ubicacion_geografica', type: 'integer'}
               		   ,{name: 'nombre_congregacion', type: 'string'}
               		   ,{name: 'razon_social', type: 'string'}
               		   ,{name: 'email', type: 'string'}
               		   ,{name: 'id_pais', type: 'integer'}
               		   ,{name: 'nombre_pais', type: 'string'}
               		   ,{name: 'cod_depto', type: 'string'}
               		   ,{name: 'descrip_depto', type: 'string'}
               		   ,{name: 'cod_prov', type: 'string'}
               		   ,{name: 'descrip_prov', type: 'string'}
               		   ,{name: 'id_ubigeo', type: 'integer'}
               		   ,{name: 'descrip_ubigeo', type: 'string'}
               		   ,{name: 'direccion', type: 'string'}
               		   ,{name: 'cor_x', type: 'string'}
               		   ,{name: 'cor_y', type: 'string'}
               		   ,{name: 'id_estado', type: 'integer'}
               		   ,{name: 'descrip_estado', type: 'string'}
               		   ,{name: 'fecha_registro', type: 'string'}
                   ],
   idProperty:'id_persona'
});