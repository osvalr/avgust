/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpAppTemp.
*
* SernanpAppTemp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpAppTemp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpAppTemp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 02/06/2015 14:00:22
* VERSION : 1.0 
*/

Ext.define('MyApp.model.ReporteDetalleBoletaPersonal.MainModel', {
    extend: 'Ext.data.Model',
    fields: [		
                		{name: 'idpersonal', type: 'integer'}
               		   ,{name: 'nombre_completo', type: 'string'}
               		   ,{name: 'numerodoc', type: 'string'}
               		   ,{name: 'srl_id_regimen_contractual', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
               		   ,{name: 'var_descripcion_regimen_contractual', type: 'string'}
               		   ,{name: 'int_anio', type: 'integer'}
               		   ,{name: 'descrip_periodo', type: 'string'}
               		   ,{name: 'int_id_tipo_concepto', type: 'integer'}
               		   ,{name: 'descrip_tipo_concepto', type: 'string'}
               		   ,{name: 'srl_id_concepto_planilla', type: 'integer'}
               		   ,{name: 'var_descrip_corto_concepto', type: 'string'}
               		   ,{name: 'dec_monto_calculado', type: 'float'}
               		   ,{name: 'dec_total_ingresos', type: 'float'}
               		   ,{name: 'dec_total_descuentos', type: 'float'}
               		   ,{name: 'dec_total_aportes', type: 'float'}
               		   ,{name: 'neto_pagar', type: 'float'}
               		   ,{name: 'tokenField', type: 'string'}
                   ],
   idProperty:'idpersonal'
});