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
* DATE CREATE : 23/05/2015 14:01:52
* VERSION : 1.0
*/

Ext.define('MyApp.model.ReporteDocumentoConsolidadoConvocatoria.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'srl_id_convocatoria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_num_convocatoria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_conv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_codigo_postulacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_requerimiento_personal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_requerimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_denominacion_requerimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idarea_solicitante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'desarea', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idunidad_solicitante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idarea_supervisora', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idunidad_supervisora', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_experiencia_requerida', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_competencias_requeridas', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_formacion_academica', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_cursos_especializacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_principales_funciones', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_requisitos_puesto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_lugar_prestacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_cantidad_tiempo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_tipo_unidad_tiempo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_cantidad_requerida', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dec_honorario_personal', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_configuracion_factor_evaluacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'srl_id_convocatoria'
});
