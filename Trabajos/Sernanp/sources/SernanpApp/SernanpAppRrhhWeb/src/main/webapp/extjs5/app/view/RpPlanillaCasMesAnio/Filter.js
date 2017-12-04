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

Ext.define('MyApp.view.RpPlanillaCasMesAnio.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.RpPlanillaCasMesAnioFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_RpPlanillaCasMesAnio',
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
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Año',
								name : 'int_anio',
								disabled : false,
								listeners: {
									'render': {
									scope: this,
									fn: function (field) {
											field.setValue(new Date().getFullYear());
										}
								    },
								    change: function(field, newValue, oldValue) {
								    	var form = Ext.getCmp('form_filter_RpPlanillaCasMesAnio');
							    		var on_field = form.getForm().findField('srl_id_anio_periodo_planilla');
							    		on_field.setDisabled(true);
							    		on_field.store.removeAll();
							    		on_field.store.reload({
							    			params: {
							    				int_anio: field.getValue()
							    			},
											scope: this,
											callback: function(records, operation, success) {
									    		on_field.select(on_field.getStore().getAt(on_field.getStore().getCount()-1));
											}
							    		});
							    		on_field.setDisabled(false);
							
								    }
								}
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Periodo',
								name : 'srl_id_anio_periodo_planilla',
								displayField : 'descrip_periodo',
								disabled : false,
								store : {
									fields: ['srl_id_anio_periodo_planilla','descrip_periodo'],
									proxy: {
												type: 'ajax',
												url: 'obtener-periodos-por-anio.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: false,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_anio_periodo_planilla:'',descrip_periodo:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_anio_periodo_planilla',
								value : ''
							}
							,{
								hidden : true,
								xtype : 'textfield',
								name : 'srl_id_regimen_contractual',
								fieldLabel : 'srl_id_regimen_contractual',
								disabled : false,
								editable : true
								
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});