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

Ext.define('MyApp.model.GestionarPersonaNatural.MainModel', {
    extend: 'Ext.data.Model',
    fields: [		
                		{name: 'id_persona', type: 'integer'}
               		   ,{name: 'id_persona_natural', type: 'integer'}
               		   ,{name: 'id_ubicacion_geografica', type: 'integer'}
               		   ,{name: 'id_archivo', type: 'integer'}
               		   ,{name: 'nombres_completos', type: 'string'}
               		   ,{name: 'nombres', type: 'string'}
               		   ,{name: 'ape_pater', type: 'string'}
               		   ,{name: 'ape_mater', type: 'string'}
               		   ,{name: 'email', type: 'string'}
               		   ,{name: 'id_pais', type: 'integer'}
               		   ,{name: 'nombre_pais', type: 'string'}
               		   ,{name: 'fecha_nacimiento', type: 'string'}
               		   ,{name: 'id_tipo_documento', type: 'integer'}
               		   ,{name: 'descrip_tipo_documento', type: 'string'}
               		   ,{name: 'numero_documento', type: 'string'}
               		   ,{name: 'id_estado_civil', type: 'integer'}
               		   ,{name: 'descrip_estado_civil', type: 'string'}
               		   ,{name: 'id_genero', type: 'integer'}
               		   ,{name: 'descrip_genero', type: 'string'}
               		   ,{name: 'cod_depto', type: 'string'}
               		   ,{name: 'descrip_depto', type: 'string'}
               		   ,{name: 'cod_prov', type: 'string'}
               		   ,{name: 'descrip_prov', type: 'string'}
               		   ,{name: 'id_ubigeo', type: 'integer'}
               		   ,{name: 'descrip_ubigeo', type: 'string'}
               		   ,{name: 'direccion', type: 'string'}
               		   ,{name: 'cor_x', type: 'string'}
               		   ,{name: 'cor_y', type: 'string'}
               		   ,{name: 'id_congregacion_general_padre', type: 'integer'}
               		   ,{name: 'nombre_congregacion_padre', type: 'string'}
               		   ,{name: 'id_congregacion_general_distrito', type: 'integer'}
               		   ,{name: 'nombre_congregacion_distrito', type: 'string'}
               		   ,{name: 'id_persona_pertenece', type: 'integer'}
               		   ,{name: 'nombre_congregacion_local', type: 'string'}
               		   ,{name: 'nombre_usuario', type: 'string'}
               		   ,{name: 'clave_usuario', type: 'string'}
               		   ,{name: 'id_estado', type: 'integer'}
               		   ,{name: 'descrip_estado', type: 'string'}
               		   ,{name: 'fecha_registro', type: 'string'}
                   ],
   idProperty:'id_persona'
});