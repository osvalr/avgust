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
* DATE CREATE : 02/06/2015 16:08:44
* VERSION : 1.0
*/

Ext.define('MyApp.model.ReporteCertificadoCuartaCategoria.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'int_anio', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_completo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ruc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'direccion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nom_cargo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'meses', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_ingresos', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'cuarta_cat', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'neto', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ubicacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idareanatural', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_cargo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'idpersonal'
});
