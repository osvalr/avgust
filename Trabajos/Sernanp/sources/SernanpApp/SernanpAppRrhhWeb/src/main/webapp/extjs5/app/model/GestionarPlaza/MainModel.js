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

Ext.define('MyApp.model.GestionarPlaza.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'srl_id_conv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_num_convocatoria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_requerimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_requerimiento_corto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_codigo_postulacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_num_puestos', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_lugar_prestacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_area_responsable', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_area_responsable', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres_completos', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idtipodocumento', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_tipodocumento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'numerodoc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tsp_fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'srl_id_conv_area_org'
});
