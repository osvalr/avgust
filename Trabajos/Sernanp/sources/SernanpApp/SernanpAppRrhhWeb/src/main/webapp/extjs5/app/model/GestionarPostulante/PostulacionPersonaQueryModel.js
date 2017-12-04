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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.model.GestionarPostulante.PostulacionPersonaQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
    	     {name: 'srl_id_postulante_conv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_postulante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_convocatoria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_num_convocatoria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_conv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_codigo_postulacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nombre_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tsp_fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_archivo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nombre_archivo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_tipo_archivo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_archivo_ruta_almacen', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'num_size_archivo', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'file_name_session', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'srl_id_postulante_conv_area_org'
});