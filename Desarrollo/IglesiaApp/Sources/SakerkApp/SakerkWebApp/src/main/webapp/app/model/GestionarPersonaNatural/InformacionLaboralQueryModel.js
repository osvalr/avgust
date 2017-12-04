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

Ext.define('MyApp.model.GestionarPersonaNatural.InformacionLaboralQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
                		{name: 'id_informacion_laboral', type: 'integer'}
               		   ,{name: 'id_persona_natural', type: 'integer'}
               		   ,{name: 'id_tipo_persona_juridica', type: 'integer'}
               		   ,{name: 'descrip_tipo_persona_juridica', type: 'string'}
               		   ,{name: 'id_empresa', type: 'integer'}
               		   ,{name: 'razon_social', type: 'string'}
               		   ,{name: 'id_cargo', type: 'integer'}
               		   ,{name: 'descrip_cargo', type: 'string'}
               		   ,{name: 'fecha_ingreso', type: 'string'}
               		   ,{name: 'fecha_salida', type: 'string'}
               		   ,{name: 'flag_encurso', type: 'integer'}
               		   ,{name: 'descrip_flag_encurso', type: 'string'}
               		   ,{name: 'id_estado', type: 'integer'}
               		   ,{name: 'descrip_estado', type: 'string'}
               		   ,{name: 'fecha_registro', type: 'string'}
                   ],
   idProperty:'id_informacion_laboral'
});