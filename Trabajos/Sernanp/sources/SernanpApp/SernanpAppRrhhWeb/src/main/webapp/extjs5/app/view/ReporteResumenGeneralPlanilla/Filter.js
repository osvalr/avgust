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

Ext.define('MyApp.view.ReporteResumenGeneralPlanilla.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.ReporteResumenGeneralPlanillaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_ReporteResumenGeneralPlanilla',
	layout: {
        type: 'vbox'
    },
    fieldDefaults: {
        labelAlign: 'top',
        margin: "0 5 5 5"
    },
                                
    initComponent: function() {
    
    	var form = this;
    
        this.items = [
                {
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							{
								xtype : 'numberfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Año',
								name : 'int_anio',
								disabled : false,
								maxValue: 99999.99,
							    minValue: 2009,
								listeners: {
									'beforerender': {
									scope: this,
									fn: function (field) {
											field.setValue(new Date().getFullYear());
										}
								    }
								}
							}
							
							
							,{
								allowBlank:false, 
								queryMode : 'local',
								xtype : 'numberfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Periodo',
								name : 'int_id_periodo_mes',
								disabled : false,
								maxValue: 12,
							    minValue: 1,
								listeners: {
									'beforerender': {
									scope: this,
									fn: function (field) {
											var d = new Date();
											var n = d.getMonth() + 1;
											field.setValue(n);
										}
								    }
								}
							}
							,{
								xtype : 'textfield',
								name : 'nombre_completo',
								fieldLabel : 'Nombres',
								hidden:true
							}
							
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : true,
								editable : false,
								fieldLabel : 'Régimen Contractual',
								name : 'srl_id_regimen_contractual',
								displayField : 'var_descripcion_regimen_contractual',
								disabled : false,
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
								valueField : 'srl_id_regimen_contractual',
								value : ''
								
							}
							
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : true,
								editable : false,
								fieldLabel : 'Fuente Financiamiento',
								name : 'c_fte_fto',
								displayField : 'var_descripcion_fuente_financiamiento',
								disabled : false,
								store : {
									fields: ['var_rubro_fte_fto','var_descripcion_fuente_financiamiento'],
									proxy: {
												type: 'ajax',
												url: 'obtener-fuentes-financiamiento.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { var_rubro_fte_fto:'',var_descripcion_fuente_financiamiento:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'var_rubro_fte_fto',
								value : '',
								width:300
							}
							,{
								xtype : 'textfield',
								name : 'c_meta',
								fieldLabel : 'Meta Presupuestaria',
								hidden:true
							}
							
							
						]
					}
        ];

        this.callParent(arguments);
    }
});