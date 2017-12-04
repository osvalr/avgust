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
* DATE CREATE : 12/05/2015 19:01:07
* VERSION : 1.0
*/

Ext.define('MyApp.model.ReportePlanillaPagoONP.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'srl_id_nomina_anio_periodo_personal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_anio_planilla', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_anio', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_anio_periodo_planilla', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_periodo_mes', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_periodo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'c_meta', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'c_fte_fto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_completo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_regimen_contractual', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_regimen_contractual', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dec_total_ingresos', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dec_monto_calculado', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'remuneracion', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_cod_meta_presupuestaria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_rubro_fte_fto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'srl_id_nomina_anio_periodo_personal'
});
