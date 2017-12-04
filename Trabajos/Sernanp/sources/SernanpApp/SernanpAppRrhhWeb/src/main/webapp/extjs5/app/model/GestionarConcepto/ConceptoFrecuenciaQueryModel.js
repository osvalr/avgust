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
* DATE CREATE : 03/04/2015 18:33:21
* VERSION : 1.0 
*/

Ext.define('MyApp.model.GestionarConcepto.ConceptoFrecuenciaQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
    	     {name: 'srl_id_frecuencia', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_concepto_planilla', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_mes', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_mes', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tsp_fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'srl_id_frecuencia'
});