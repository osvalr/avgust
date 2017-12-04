/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 01/12/2014 19:55:03
* VERSION : 1.0 
*/

Ext.define('MyApp.model.GestionarTablaGeneral.TablaGeneralDetalleQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
                		{name: 'id_tabla_general_detalle', type: 'integer'}
               		   ,{name: 'id_tabla_general', type: 'integer'}
               		   ,{name: 'valor_general', type: 'integer'}
               		   ,{name: 'campo_a', type: 'string'}
               		   ,{name: 'campo_b', type: 'string'}
               		   ,{name: 'campo_c', type: 'string'}
               		   ,{name: 'campo_d', type: 'string'}
               		   ,{name: 'campo_e', type: 'string'}
               		   ,{name: 'id_estado', type: 'integer'}
               		   ,{name: 'descrip_estado', type: 'string'}
               		   ,{name: 'orden', type: 'integer'}
               		   ,{name: 'fecha_registro', type: 'string'}
                   ],
   idProperty:'id_tabla_general_detalle'
});