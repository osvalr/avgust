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
* DATE CREATE : 13/07/2015 14:25:29
* VERSION : 1.0
*/

Ext.define('MyApp.model.ReporteSeleccionPostulantesEntrevistaPersonal.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'idpersona', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonanatural', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_postulante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_completo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idtipodocumento', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tipodocumento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'numerodoc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_convocatoria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_num_convocatoria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'estado_convocatoria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_conv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_codigo_postulacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nombre_etapa', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descrip_subetapa', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_estado_asistencia', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dec_puntaje_obtenido', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_estado_clasificacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'des_estado_postulante_cnv_area_org', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'idpersona'
});
