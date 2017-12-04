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

Ext.define('MyApp.model.GestionarPersonaNatural.PersonaNaturalParentescoQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
                		{name: 'id_persona_parentesco', type: 'integer'}
               		   ,{name: 'id_persona_natural', type: 'integer'}
               		   ,{name: 'id_persona_natural_parentesco', type: 'integer'}              		   
               		   ,{name: 'nombres_completos', type: 'string'}
               		   ,{name: 'fecha_nacimiento', type: 'string'}
               		   ,{name: 'id_tipo_documento', type: 'integer'}
            		   ,{name: 'descrip_tipo_documento', type: 'string'}
            		   ,{name: 'numero_documento', type: 'string'}         		   
               		   ,{name: 'id_tipo_parentesco', type: 'integer'}
               		   ,{name: 'descrip_tipo_parentesco', type: 'string'}
               		   ,{name: 'id_estado', type: 'integer'}
               		   ,{name: 'descrip_estado_generico', type: 'string'}
               		   ,{name: 'fecha_registro', type: 'string'}
                   ],
   idProperty:'id_persona_parentesco'
});