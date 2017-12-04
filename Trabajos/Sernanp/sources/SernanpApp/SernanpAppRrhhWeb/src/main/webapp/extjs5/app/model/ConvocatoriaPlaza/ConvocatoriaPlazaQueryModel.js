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
* DATE CREATE : 23/04/2015 16:49:26
* VERSION : 1.0 
*/

Ext.define('MyApp.model.ConvocatoriaPlaza.ConvocatoriaPlazaQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
    	     {name: 'srl_id_conv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_convocatoria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_configuracion_factor_evaluacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descrip_configuracion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'srl_id_configuracion_evaluacion_personal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nombre_configuracion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'idarea_solicitante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_area', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idunidad_solicitante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_unidad', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_requerimiento_personal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_requerimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_requerimiento_corto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_codigo_postulacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_cantidad_requerida', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apepat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apemat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_completo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_lugar_prestacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_denominacion_requerimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'dte_fec_aprobacion_oa', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'dte_fecha_inicio_contrato', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fecha_fin_contrato', type: 'string', useNull: true, defaultValue:null, allowNull:true}

            
            ],
   idProperty:'srl_id_conv_area_org'
});