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
* DATE CREATE : 08/04/2015 00:02:56
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteResumenGeneralPlanilla.EditGenerarNominaPago', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteResumenGeneralPlanillaEditGenerarNominaPago',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 600,
    title:'Generar Nominas de Pago',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
							{
				                xtype: 'form',
				                id: 'form_generar_nomina_pago',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'qtip',
                    				labelWidth: 125
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
												
												},
												
											
											{
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
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
												value : '',
												listeners: {
													'beforerender': {
													scope: this,
													fn: function (field) {
															
															field.setValue(3);
														}
												    }
												}
											},
											,{
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
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
												width:300,
												listeners: {
													'beforerender': {
													scope: this,
													fn: function (field) {
															
															field.setValue('00');
														}
												    }
												}
											}
											,{
												xtype : 'textfield',
												name : 'c_meta',
												fieldLabel : 'Meta Presupuestaria',
												hidden:false,
												allowBlank:false,
												vtype:'metaNumeros',
												maxLength: 40,
												enforceMaxLength: true,
												disabled : true
											},
											
											//bn
											
											{
								                xtype: 'radiogroup',
								                flex: 8,
								                vertical: true,
								                columns: 1,
								                //labelWidth: 50,
								                id: 'radio_group_id',
								                fieldLabel: 'Opciones',
								                items: [
								                        {
										                    boxLabel: 'Nomina de Pagos por FF',
										                    name: 'rbNomina',
										                    inputValue: 1,
										                    checked: true,
										                    listeners: {
										                        change: function (cb, newValue, oldValue) {
										                            if (newValue) {
										                            	var form = Ext.getCmp('form_generar_nomina_pago');
											                            
											                            var c_meta = form.getForm().findField('c_meta');
											                        	c_meta.setDisabled(true);
										                            } 
										                        }
										                    }
								                        }, 
								                        {
										                    boxLabel: 'Nomina de Pagos por Régimen Contractual',
										                    name: 'rbNomina',
										                    inputValue: 2,
										                    listeners: {
										                        change: function (cb, newValue, oldValue) {
										                            if (newValue) {
										                            	var form = Ext.getCmp('form_generar_nomina_pago');
											                            
											                            var c_meta = form.getForm().findField('c_meta');
											                        	c_meta.setDisabled(true);
										                            } 
										                        }
										                    }
								                        },
								                        {
										                    boxLabel: 'Resumen de Nomina de Pagos',
										                    name: 'rbNomina',
										                    inputValue: 3,
										                    listeners: {
										                        change: function (cb, newValue, oldValue) {
										                            if (newValue) {
										                            	var form = Ext.getCmp('form_generar_nomina_pago');
											                            
											                            var c_meta = form.getForm().findField('c_meta');
											                        	c_meta.setDisabled(false);
										                            } 
										                        }
										                    }
										                }, 
								                        {
										                    boxLabel: 'Proyección de Planillas de Pago',
										                    name: 'rbNomina',
										                    inputValue: 4,
										                    listeners: {
										                        change: function (cb, newValue, oldValue) {
										                            if (newValue) {
										                            	var form = Ext.getCmp('form_generar_nomina_pago');
											                            
											                            var c_meta = form.getForm().findField('c_meta');
											                        	c_meta.setDisabled(false);
										                            } 
										                        }
										                    }
								                        }
								                        ]
								            }
											
											//ed
											
										]
							}

        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf013@FontAwesome',
                text: 'Generar',
                action: 'generarNominaPago'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_generar_nomina_pago_statusbar'
        })];

        this.callParent(arguments);      
    }
});
