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
* DATE CREATE : 14/06/2015 01:52:58
* VERSION : 1.0
*/

Ext.define('MyApp.model.ReporteNominaDescuento.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_completo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'numerodoc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'c_meta', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'c_fte_fto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_fuente_financiamiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_regimen_contractual', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_regimen_contractual', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_anio', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_periodo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'reg_19990', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'reg_afp', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'reg_20530', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'reg_25897', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_19990', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_afp', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_20530', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_25897', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_regimen_pensionario', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_regimen_pensionario', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'idpersonal'
});
