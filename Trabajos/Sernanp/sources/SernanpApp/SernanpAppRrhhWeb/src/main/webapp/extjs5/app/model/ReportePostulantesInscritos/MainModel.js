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
* DATE CREATE : 08/06/2015 18:38:03
* VERSION : 1.0
*/

Ext.define('MyApp.model.ReportePostulantesInscritos.MainModel', {
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
            ,{name: 'idarea', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'desarea', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idunidad', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nomunidad', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'des_estado_convocatoria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'estado_postulante_cnv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'des_estado_postulante_cnv_area_org', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tsp_fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'srl_id_sede_req_sel', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nomb_sede', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'idpersona'
});
