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
* DATE CREATE : 20/04/2015 01:10:00
* VERSION : 1.0 
*/

Ext.define('MyApp.model.GestionarPlaza.SubEtapaPlazaQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
    	     {name: 'srl_id_conv_area_org_etapa', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_conv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_etapa_proceso_seleccion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nombre_etapa', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_subetapa_proceso_seleccion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_subetapa', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descrip_subetapa', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fecha_inicio', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fecha_termino', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idarea', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'desarea', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idunidad', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nomunidad', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tsp_fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'srl_id_conv_area_org_etapa'
});