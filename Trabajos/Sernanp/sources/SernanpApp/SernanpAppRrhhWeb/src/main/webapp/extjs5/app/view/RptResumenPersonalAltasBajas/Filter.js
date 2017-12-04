/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
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
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
 * GENERATOR CRUD EXT JS 5 BY FOCUS CONSULTORES ASOCIADOS SAC 
 * DATE CREATE : 09/11/2014 02:30:50 
 * VERSION : 1.0
 */

Ext.define('MyApp.view.RptResumenPersonalAltasBajas.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.RptResumenPersonalAltasBajasFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_RptResumenPersonalAltasBajas',
	layout: {
        type: 'vbox'
    },
    fieldDefaults: {
        labelAlign: 'top',
        margin: "0 5 5 5"
    },
    
                                
    initComponent: function() {
    
    	var form = this;
    	var estado = Ext.create('Ext.data.Store', {
	        fields: ['int_estado', 'desc_estado'],
	        data : [
	            {"int_estado":"", "desc_estado":"-- Todos --"},
	            {"int_estado":"0", "desc_estado":"ACTIVO"},
	            {"int_estado":"1", "desc_estado":"INACTIVO"}
	           
	        ]
	    });
    
        this.items = [
                {
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							{
								hidden : false,
								xtype : 'textfield',
								name : 'numerodoc',
								fieldLabel : 'DNI',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'ruc',
								fieldLabel : 'RUC',
								disabled : false,
								editable : true
							}
							,{
								store : {
									fields: ['srl_id_regimen_contractual','var_descripcion_regimen_contractual'],
									proxy: {
												type: 'ajax',
												url: 'obtener-valores-regimen-contractual.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_regimen_contractual:'',var_descripcion_regimen_contractual:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								queryMode : 'local',
								displayField : 'var_descripcion_regimen_contractual',
								hidden : false,
								xtype : 'combobox',
								name : 'srl_id_regimen_contractual',
								value : '',
								valueField : 'srl_id_regimen_contractual',
								fieldLabel : 'Reg. Contractual',
								disabled : false,
								editable : true
							}
							,{
								hidden : true,
								xtype : 'textfield',
								name : 'idpersonal',
								fieldLabel : 'idpersonal',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'nombre_completo',
								fieldLabel : 'Nombres',
								disabled : false,
								editable : true
							}
							,{
								hidden : true,
								xtype : 'textfield',
								name : 'srl_id_cargo',
								fieldLabel : 'srl_id_cargo',
								disabled : false,
								editable : true
							},
							 
							{
								hidden : false,
								xtype : 'combobox',
								name : 'int_estado',
								fieldLabel : 'Estado',
								disabled : false,
								editable : false,
								queryMode: 'local',
								displayField: 'desc_estado',
								valueField: 'int_estado',
								store: estado,
								listeners: {
									'beforerender': {
									scope: this,
									fn: function (field) {
											field.setValue('');
										}
								    }
								}
							}
						]
					}
					,{
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							
							,{
								hidden : true,
								xtype : 'textfield',
								name : 'idtipodocumento',
								fieldLabel : 'idtipodocumento',
								disabled : false,
								editable : true
							}
							,{
								hidden : true,
								xtype : 'textfield',
								name : 'tipo_reporte',
								fieldLabel : 'tipo_reporte',
								disabled : false,
								editable : false
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});