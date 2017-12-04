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

Ext.define('MyApp.view.GestionarReqPersonal.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarReqPersonalFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarReqPersonal',
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
//	                         {
//							    
//							    store : {
//							    	fields: ['srl_id_requerimiento_personal','var_numero_requerimiento_corto'],
//							    	proxy: {
//							    		type: 'ajax',
//							    		url: 'obtener-requerimiento-disponible.action',
//							    		reader: {
//							    			type: 'json',
//							    			rootProperty: 'listResult'
//							    		}
//							    	},
//							    	autoLoad: true,
//							    	listeners:{
//							    		load: function(store){
//							    			var rec = {srl_id_requerimiento_personal:'', var_numero_requerimiento_corto:'-- Todos --'}
//							    			store.insert(0,rec);
//							    		}
//							    	}
//							    },
//							    allowBlank : true,
//							    queryMode : 'local',
//							    displayField : 'var_numero_requerimiento_corto',
//							    hidden : false,
//							    xtype : 'combobox',
//							    name : 'srl_id_requerimiento_personal',
//							    valueField : 'srl_id_requerimiento_personal',
//							    value:'',
//							    fieldLabel : 'Nº de Requerimiento',
//							    disabled : false,
//							    editable : true
//							},
							
							{
							    listeners : {
							    	change: function(combo, newValue, oldValue) {

							    		var form = Ext.getCmp('form_filter_GestionarReqPersonal');
							    		var on_combo = form.getForm().findField('idunidad_solicitante');
							    		on_combo.setDisabled(true);
							    		on_combo.store.removeAll();
							    		on_combo.store.reload({
							    			params: {
							    				idAreaOrganica: combo.getValue()
							    			}
							    		});
							    		on_combo.setDisabled(false);
							    		
							    		if(oldValue != null){
							    			on_combo.setValue('');
							    		}
							    	}
							    },
							    store : {
							    	fields: ['idarea','desarea'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'listar-area-organica.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: true,
							    	listeners:{
							    		load: function(store){
							    			var rec = {idarea:'', desarea:'-- Todos --'}
							    			store.insert(0,rec);
							    		}
							    	}
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'desarea',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'idarea_solicitante',
							    valueField : 'idarea',
							    fieldLabel : 'Área Solicitante',
							    disabled : false,
							    editable : true,
							    value:''
							    	,
								    matchFieldWidth:false,
								    width : 350
							},
							{
							    store : {
							    	fields: ['idunidad','nomunidad'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'obtener-unidad-operativa.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: false,
							    	listeners:{
							    		load: function(store){
							    			var rec = {idunidad:'', nomunidad:'-- Todos --'}
							    			store.insert(0,rec);
							    		}
							    	}
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'nomunidad',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'idunidad_solicitante',
							    valueField : 'idunidad',
							    fieldLabel : 'U.O.F. Solicitante',
							    disabled : false,
							    editable : true,
							    value:''
							    	,
							    matchFieldWidth:false,
							    width : 200
							}
							/*start*/
							
							,{								
							    store : {
							    	fields: ['srl_id_sede_req_sel','sede_administrativa_req_sel'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'obtener-sede-administrativa.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: true
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'sede_administrativa_req_sel',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'srl_id_sede_req_sel',
							    valueField : 'srl_id_sede_req_sel',
							    emptyText : '-- Seleccione Opción --',
							    fieldLabel : 'Sede Administrativa',
							    disabled : false,
							    editable : false
							    ,
							    matchFieldWidth:false,
							    width : 200
							    
							},
							/*end*/
							{
							    listeners : {
							    	change: function(combo, newValue, oldValue) {

							    		var form = Ext.getCmp('form_filter_GestionarReqPersonal');
							    		var on_combo = form.getForm().findField('idunidad_supervisora');
							    		on_combo.setDisabled(true);
							    		on_combo.store.removeAll();
							    		on_combo.store.reload({
							    			params: {
							    				idAreaOrganica: combo.getValue()
							    			}
							    		});
							    		on_combo.setDisabled(false);
							    		
							    		if(oldValue != null){
							    			on_combo.setValue('');
							    		}
							    	}
							    },
							    store : {
							    	fields: ['idarea','desarea'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'listar-area-organica.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: true,
							    	listeners:{
							    		load: function(store){
							    			var rec = {idarea:'', desarea:'-- Todos --'}
							    			store.insert(0,rec);
							    		}
							    	}
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'desarea',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'idarea_supervisora',
							    valueField : 'idarea',
							    fieldLabel : 'Área Supervisora',
							    disabled : false,
							    editable : true,
							    value:''
							    	,
							    matchFieldWidth:false,
							    width : 200
							}
							
							,{
							    store : {
							    	fields: ['idunidad','nomunidad'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'obtener-unidad-operativa.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: false,
							    	listeners:{
							    		load: function(store){
							    			var rec = {idunidad:'', nomunidad:'-- Todos --'}
							    			store.insert(0,rec);
							    		}
							    	}
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'nomunidad',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'idunidad_supervisora',
							    valueField : 'idunidad',
							    fieldLabel : 'U.O.F. Supervisora',
							    disabled : false,
							    editable : true,
							    value:''
						    	,
							    matchFieldWidth:false,
							    width : 200
							}							
							
							,
							{
							    store : {
							    	fields: ['codinttablatipo','destablatipo'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Generico',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
										
							    	},
							    	autoLoad: true,
							    	listeners: {
								        load: function(store) {
								        	var rec = { codinttablatipo:'',destablatipo:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'destablatipo',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'int_id_estado',
							    valueField : 'codinttablatipo',
							    value:'',
							    fieldLabel : 'Estado',
							    disabled : false,
							    editable : false
							    ,
//							    matchFieldWidth:false,
							    width : 120
							}
							,{
								store : {
							    	fields: ['codinttablatipo','destablatipo'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Trabajador',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
										
							    	},
							    	autoLoad: true,
							    	listeners:{
							    		load: function(store){
							    			var rec = {codinttablatipo:'', destablatipo:'-- Todos --'}
							    			store.insert(0,rec);
							    		}
							    	}
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'destablatipo',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'int_id_tipo_trabajador',
							    valueField : 'codinttablatipo',
							    fieldLabel : 'Tipo de Trabajador',
							    value:'',
							    disabled : false,
							    editable : true
							    ,
//							    matchFieldWidth:false,
							    width : 150
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
//                	        {
//                	        		    
//									    store : {
//									    	fields: ['srl_id_fuente_financiamiento','var_rubro_fte_fto'],
//									    	proxy: {
//									    		type: 'ajax',
//									    		url: 'listar-fuente-financiamiento.action',
//									    		reader: {
//									    			type: 'json',
//									    			rootProperty: 'listResult'
//									    		}
//									    	},
//									    	autoLoad: true,
//									    	listeners: {
//										        load: function(store) {
//										        	var rec = { srl_id_fuente_financiamiento:'',var_rubro_fte_fto:'-- Todos --' };
//										        	store.insert(0, rec);
//										        }
//											}
//									    },
//									    allowBlank : true,
//									    queryMode : 'local',
//									    displayField : 'var_rubro_fte_fto',
//									    hidden : false,
//									    xtype : 'combobox',
//									    name : 'srl_id_fuente_financiamiento',
//									    valueField : 'srl_id_fuente_financiamiento',
//									    value:'',
//									    fieldLabel: 'F. de Financiamiento',
//									    disabled : false,
//									    editable : true
//								
//				            	 },
//				            	 {
//             	        		    
//									    store : {
//									    	fields: ['srl_id_meta_presupuestaria','var_cod_meta_presupuestaria'],
//									    	proxy: {
//									    		type: 'ajax',
//									    		url: 'listar-meta-presupuestaria.action',
//									    		reader: {
//									    			type: 'json',
//									    			rootProperty: 'listResult'
//									    		}
//									    	},
//									    	autoLoad: true,
//									    	listeners: {
//										        load: function(store) {
//										        	var rec = { srl_id_meta_presupuestaria:'',var_cod_meta_presupuestaria:'-- Todos --' };
//										        	store.insert(0, rec);
//										        }
//											}
//									    },
//									    allowBlank : true,
//									    queryMode : 'local',
//									    displayField : 'var_cod_meta_presupuestaria',
//									    hidden : false,
//									    xtype : 'combobox',
//									    name : 'srl_id_meta_presupuestaria',
//									    valueField : 'srl_id_meta_presupuestaria',
//									    value:'',
//									    fieldLabel: 'Meta Presupuestaria',
//									    disabled : false,
//									    editable : true
//								
//				            	 },
							
//							{
//							    store : {
//							    	fields: ['codinttablatipo','destablatipo'],
//							    	proxy: {
//							    		type: 'ajax',
//							    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Generico',
//							    		reader: {
//							    			type: 'json',
//							    			rootProperty: 'listResult'
//							    		}
//										
//							    	},
//							    	autoLoad: true,
//							    	listeners: {
//								        load: function(store) {
//								        	var rec = { codinttablatipo:'',destablatipo:'-- Todos --' };
//								        	store.insert(0, rec);
//								        }
//									}
//							    },
//							    allowBlank : true,
//							    queryMode : 'local',
//							    displayField : 'destablatipo',
//							    hidden : false,
//							    xtype : 'combobox',
//							    name : 'int_id_estado',
//							    valueField : 'codinttablatipo',
//							    value:'',
//							    fieldLabel : 'Estado',
//							    disabled : false,
//							    editable : false
//							}
//							,{
//								store : {
//							    	fields: ['codinttablatipo','destablatipo'],
//							    	proxy: {
//							    		type: 'ajax',
//							    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Trabajador',
//							    		reader: {
//							    			type: 'json',
//							    			rootProperty: 'listResult'
//							    		}
//										
//							    	},
//							    	autoLoad: true,
//							    	listeners:{
//							    		load: function(store){
//							    			var rec = {codinttablatipo:'', destablatipo:'-- Todos --'}
//							    			store.insert(0,rec);
//							    		}
//							    	}
//							    },
//							    allowBlank : true,
//							    queryMode : 'local',
//							    displayField : 'destablatipo',
//							    hidden : false,
//							    xtype : 'combobox',
//							    name : 'int_id_tipo_trabajador',
//							    valueField : 'codinttablatipo',
//							    fieldLabel : 'Tipo de Trabajador',
//							    value:'',
//							    disabled : false,
//							    editable : true
//							    
//							}
							,{
						    	listeners:{							
						    	change: function(combo, newValue, oldValue) {
	
						    		var form = Ext.getCmp('form_filter_GestionarReqPersonal');
						    		var on_combo = form.getForm().findField('idareanatural');
						    		on_combo.setDisabled(true);
						    		on_combo.store.removeAll();
						    		on_combo.store.reload({
						    			params: {
						    				idCategoriaAnp: combo.getValue()
						    			}
						    		});
						    		on_combo.setDisabled(false);
						    		
						    		if(oldValue != null){
						    			on_combo.setValue('');
						    		}
						    	}
				
						    	},
						    	
							    store : {
							    	fields: ['idcategoriaanp','descategoriaanp'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'listar-categoria-anp.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: true,
							    	listeners:{
							    		load: function(store){
							    			var rec = {idcategoriaanp:'', descategoriaanp:'-- Todos --'}
							    			store.insert(0,rec);
							    		}
							    	}
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'descategoriaanp',
							    hidden : true,
							    xtype : 'combobox',
							    name : 'idcategoriaanp',
							    valueField : 'idcategoriaanp',
							    value:'',
							    emptyText : '-- Seleccione Opción --',
							    fieldLabel : 'Categoria ANP',
							    disabled : false,
							    editable : false
							    
							},
							
							
							{
							    store : {
							    	fields: ['idareanatural','desareanatural'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'obtener-area-natural.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: false,
							    	listeners:{
							    		load: function(store){
							    			var rec = {idareanatural:'', desareanatural:'-- Todos --'}
							    			store.insert(0,rec);
							    		}
							    	}

							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'desareanatural',
							    hidden : true,
							    xtype : 'combobox',
							    name : 'idareanatural',
							    valueField : 'idareanatural',
							    fieldLabel : 'Area Natural',
							    disabled : false,
							    editable : false,
							    value:''
							},
							

						]
					}
        ];

        this.callParent(arguments);
    }
});