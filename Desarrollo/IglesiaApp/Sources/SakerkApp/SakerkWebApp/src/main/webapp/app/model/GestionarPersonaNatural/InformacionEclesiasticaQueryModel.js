/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
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
* DATE CREATE : 03/12/2014 03:40:10
* VERSION : 1.0 
*/

Ext.define('MyApp.model.GestionarPersonaNatural.InformacionEclesiasticaQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
                		{name: 'id_info_eclesiastica', type: 'integer'}
               		   ,{name: 'id_persona_natural', type: 'integer'}
               		   ,{name: 'id_congregacion', type: 'integer'}
               		   ,{name: 'razon_social', type: 'string'}
               		   ,{name: 'fecha_evento', type: 'string'}
               		   ,{name: 'id_tipo_evento', type: 'integer'}
               		   ,{name: 'descrip_tipo_evento_eclesiastico', type: 'string'}
               		   ,{name: 'id_estado', type: 'integer'}
               		   ,{name: 'descrip_estado', type: 'string'}
               		   ,{name: 'fecha_registro', type: 'string'}
                   ],
   idProperty:'id_info_eclesiastica'
});