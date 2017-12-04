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
* DATE CREATE : 12/04/2015 20:29:10
* VERSION : 1.0 
*/

Ext.define('MyApp.model.GestionarAsignarConcepto.PersonalInfoAdendasPorContratoQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
    	     {name: 'srl_id_contrato', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_contrato_padre', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_num_contrato', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_num_contrato_padre', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fec_suscrip', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fec_inicio', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fec_termino', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fec_cese', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nombre_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'srl_id_contrato'
});