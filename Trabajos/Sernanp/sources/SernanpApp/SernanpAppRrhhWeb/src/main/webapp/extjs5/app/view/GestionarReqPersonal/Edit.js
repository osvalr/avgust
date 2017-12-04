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
* DATE CREATE : 18/03/2015 17:14:21
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarReqPersonal.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarReqPersonalEdit',

    requires: [
               'Ext.form.Panel','Ext.ux.statusbar.StatusBar'
              ],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '80%',
    glyph:'xf044@FontAwesome',
    listeners : {
    	afterRender : function(){
    		
    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
    		
    		var idarea = form.getForm().findField('idarea_solicitante');
    		var idunidad_solicitante = form.getForm().findField('idunidad_solicitante');
    		
    			//unidad
    			idunidad_solicitante.setDisabled(true);
    			idunidad_solicitante.store.removeAll();

//				DAVIVD  
//    			console.log('idunidad_solicitante --> ' + idunidad_solicitante.getValue());
//    			if (idunidad_solicitante.getValue() != null){
    				idunidad_solicitante.store.reload({
        				params: {
        					idAreaOrganica: idarea.getValue()
        				}
        			});	
//    			}
    			
    		
    			idunidad_solicitante.setDisabled(false);
    			
    	}
    },

    
    initComponent: function() {
    	
    	 this.items = [   
            {
                xtype: 'tabpanel',
                activeTab: 0,
                                
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarReqPersonal',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información del Requerimiento',
				                glyph:'xf022@FontAwesome',
				                
				                fieldDefaults: {
				                    labelAlign: 'right',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'side',
                    				labelWidth: 125
			                	},
			                	
			                	
			                	items: [{ 
				                	      xtype:'container', //container principal
				                	      layout:{
				                	    	  type:'hbox',
				                	    	  align: 'stretch'
				                	      },
		                		  
				                	      items: [
				                	              {
				                	            	xtype:'container', //container 1
				                	            	defaults:{
								                		   margin: '5 10'  
								                	   },
								                	width:'50%',   
//				                	            	flex:2,
				                	            	layout:{
				                	            		type:'vbox',
				                	            		align:'stretch'
				                	            	},
				                	            	
				                	            	items: [
				                	            	        {
						                		        	    allowBlank : true,
															    hidden : true,
															    xtype : 'textfield',
															    name : 'srl_id_requerimiento_personal',
															    fieldLabel : 'srl_id_requerimiento_personal',
															    disabled : false,
															    editable : true
															}
				                	            	        ,{
															    allowBlank : true,
															    maxLength : 100,
															    hidden : true,
															    minLength : 1,
															    xtype : 'textfield',
															    name : 'var_numero_requerimiento',
															    fieldLabel : 'Nro. de Requerimiento',
															    disabled : false,
															    editable : false
															}
				                	            	        ,{
															    maxLength : 100,
															    minLength : 1,
															    xtype : 'textfield',
															    name : 'var_numero_requerimiento_corto',
															    fieldLabel : 'Nro. de Requerimiento',
															    editable : false,
															    allowBlank : true,
															    hidden:false,
															    inputAttrTpl: " data-qtip='Número autogenerado.' "
															}
				                	            	        ,{
						                		        	    allowBlank : false,
															    hidden : false,
															    xtype : 'textareafield',
															    name : 'var_denominacion_requerimiento',
															    fieldLabel : 'Denominación del Requerimiento o cargo',
															    disabled : false,
															    editable : true,
															    upper: true,
															    maxLength:2000,
															    inputAttrTpl: " data-qtip='Breve explicación acerca del requerimiento.' "
															}
				                	            	       
				                	            			
															,{
															    listeners : {
															    	change: function(field, newValue, oldValue) {
					
															    		if(newValue === 0){
															    			field.setValue('');
															    		}
															    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
															    		
															    		var idarea = form.getForm().findField('idarea_solicitante');
															    		var idunidad_solicitante = form.getForm().findField('idunidad_solicitante');
															    		var srl_id_anio_planilla = form.getForm().findField('srl_id_anio_planilla');
															    		
															    			//unidad
															    			idunidad_solicitante.setDisabled(true);
															    			idunidad_solicitante.store.removeAll();
															    			idunidad_solicitante.store.reload({
															    				params: {
															    					idAreaOrganica: field.getValue()
															    				}
															    			});
															    		
															    			idunidad_solicitante.setDisabled(false);
															    			if(oldValue != null){
															    				idunidad_solicitante.setValue('');
																    		}
															    			
															    			
															    			
															    	},
															    	select: function(combo, record, index) {
															    		
															    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
															    		
															    		var idarea = form.getForm().findField('idarea_solicitante');
															    		var idunidad_solicitante = form.getForm().findField('idunidad_solicitante');
															    		var srl_id_anio_planilla = form.getForm().findField('srl_id_anio_planilla');
															    		
															    		//meta
														    			var c_meta = form.getForm().findField('c_meta');
														    			c_meta.setDisabled(true);
														    			c_meta.store.removeAll();
														    			c_meta.store.reload({
															    			params: {
															    				srl_id_anio_planilla: srl_id_anio_planilla.getValue(),
															    				idarea: idarea.getValue(),
															    				idunidad: idunidad_solicitante.getValue()
															    			}
															    		});
														    			c_meta.setDisabled(false);
														    			c_meta.setValue('');
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
															    	autoLoad: true
															    },
															    allowBlank : false,
															    queryMode : 'local',
															    displayField : 'desarea',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'idarea_solicitante',
															    valueField : 'idarea',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Área Solicitante',
															    disabled : false,
															    editable : false,
															    value : idarea
															    
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
															    	autoLoad: false
															    },
															    listeners : {
															 
															    	select: function(combo, record, index) {
															    		
															    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
															    		
															    		var idarea = form.getForm().findField('idarea_solicitante');
															    		var idunidad_solicitante = form.getForm().findField('idunidad_solicitante');
															    		var srl_id_anio_planilla = form.getForm().findField('srl_id_anio_planilla');
															    		
															    		//meta
														    			var c_meta = form.getForm().findField('c_meta');
														    			c_meta.setDisabled(true);
														    			c_meta.store.removeAll();
														    			c_meta.store.reload({
															    			params: {
															    				srl_id_anio_planilla: srl_id_anio_planilla.getValue(),
															    				idarea: idarea.getValue(),
															    				idunidad: idunidad_solicitante.getValue()
															    			}
															    		});
														    			c_meta.setDisabled(false);
														    			c_meta.setValue('');
															    	}
															    },
															    allowBlank : true,
															    queryMode : 'local',
															    displayField : 'nomunidad',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'idunidad_solicitante',
															    valueField : 'idunidad',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'U.O.F. Solicitante',
															    disabled : false,
															    editable : false,
															    readOnly : false

															},
															{
															    allowBlank : true,
															    queryMode : 'local',
															    xtype : 'combobox',
															    hidden : false,
															    listeners : {
															    	change: function(field, newValue, oldValue) {

															    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
															    		
															    		var on_field = form.getForm().findField('c_meta');
															    		
															    		var idarea = form.getForm().findField('idarea_solicitante');
															    		var idunidad_solicitante = form.getForm().findField('idunidad_solicitante');
															    		var srl_id_anio_planilla = form.getForm().findField('srl_id_anio_planilla');
															    		
															    		var int_anio			 = form.getForm().findField('int_anio');															    		
															    		int_anio.setValue(field.getRawValue());																														    		
															    		
															    		on_field.setDisabled(true);
															    		on_field.store.removeAll();
															    		on_field.store.reload({
															    			params: {
															    				srl_id_anio_planilla: srl_id_anio_planilla.getValue(),
															    				idarea: idarea.getValue(),
															    				idunidad: idunidad_solicitante.getValue()
															    			}
															    		});
															    		on_field.setDisabled(false);
															    		if(oldValue != null){
															    			on_field.setValue('');
															    		}
															    	}
															    },
															    emptyText : '-- Seleccione Opción --',
															    editable : true,
															    readOnly : false,
															    store : {
															    	fields: ['srl_id_anio_planilla','int_anio'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'obtener-anios-planilla.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listResult'
															    		}
															    	},
															    	autoLoad: true
															    },
															    valueField : 'srl_id_anio_planilla',
															    fieldLabel : 'Año',
															    name : 'srl_id_anio_planilla',
															    displayField : 'int_anio',
															    disabled : false
															}
															,{
																allowBlank : true,
																emptyText : '-- Seleccione Opción --',
																queryMode : 'local',
																xtype : 'combobox',
																hidden : false,
																editable : true,
																fieldLabel : 'Meta',
																name : 'c_meta',
																displayField : 'descrip_meta',
																disabled : false,
																store : {
																	fields: ['cod_meta','descrip_meta'],
																	proxy: {
																				type: 'ajax',
																				url: 'obtener-meta-por-area-anho.action',
																				reader: {
																					type: 'json',
																					rootProperty: 'listResult'
																				}
																	},
																	autoLoad: true
																},
																valueField : 'cod_meta'
															},
															{
																queryMode : 'local',
																xtype : 'combobox',
																hidden : false,
																editable : false,
																emptyText : '-- Seleccione Opción --',
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
																	autoLoad: true
																},
																valueField : 'var_rubro_fte_fto',
																value : ''
															}
															,{
															    listeners : {
															    	change: function(combo, newValue, oldValue) {
					
															    		if(newValue === 0){
															    			combo.setValue('');
															    		}
															    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
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
															    	autoLoad: true
															    },
															    allowBlank : false,
															    queryMode : 'local',
															    displayField : 'desarea',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'idarea_supervisora',
															    valueField : 'idarea',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Área Supervisora',
															    disabled : false,
															    editable : false
															}
															,{
															    allowBlank : true,
															    hidden : true,
															    xtype : 'textfield',
															    name : 'descrip_area_supervisora',
															    fieldLabel : 'Area Operativa Supervisora',
															    disabled : false,
															    editable : true
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
															    	autoLoad: false
															    },
															    allowBlank : true,
															    queryMode : 'local',
															    displayField : 'nomunidad',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'idunidad_supervisora',
															    valueField : 'idunidad',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'U.O.F. Supervisora',
															    disabled : false,
															    editable : false
															}
															/*
															,{
																listeners : {
															    	change: function(combo, newValue, oldValue) {
					
															    		if(newValue === 0){
															    			combo.setValue('');
															    		}
															    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
															    		var on_combo = form.getForm().findField('srl_id_sede_uni_ope_anp');
															    		on_combo.setDisabled(true);
															    		on_combo.store.removeAll();
															    		on_combo.store.reload({
															    			params: {
															    				srl_id_unidad_operativa: combo.getValue()
															    			}
															    		});
															    		on_combo.setDisabled(false);
															    		
															    		if(oldValue != null){
															    			on_combo.setValue('');
															    		}
															    	}
															    },
															    store : {
															    	fields: ['srl_id_unidad_operativa','var_nom_unidad'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'obtener-unidad-operativa-geografica.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listResult'
															    		}
															    	},
															    	autoLoad: true
															    },
															    allowBlank : true,
															    queryMode : 'local',
															    displayField : 'var_nom_unidad',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'srl_id_unidad_operativa',
															    valueField : 'srl_id_unidad_operativa',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Unidad Operativa',
															    //fieldLabel : 'Sede Operativa',
															    disabled : false,
															    editable : false
															}
															,{
															    store : {
															    	fields: ['idarea','var_descrip'],
															    	proxy: {
															    		type: 'ajax',
															    		//url: 'obtener-dependencia-sede-anp-geografica.action',
															    		url: 'obtener-dependencia-geografica.action',															    		
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listResult'
															    		}
															    	},
															    	autoLoad: false
															    },
															    allowBlank : false,
															    queryMode : 'local',
															    displayField : 'var_descrip',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'srl_id_sede_uni_ope_anp',
															    valueField : 'idarea',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Dependencia Geografica',
															    disabled : false,
															    editable : false
															}
															*/
															
															,{
															    allowBlank : false,
															    hidden : false,
															    xtype : 'textfield',
															    name : 'int_cantidad_requerida',
															    fieldLabel : 'Cantidad de vacantes',
															    vtype : 'soloNumeros',
															    disabled : false,
															    editable : true
															}
															,{
															    allowBlank : false,
															    hidden : false,
															    xtype : 'textfield',
															    name : 'dec_honorario_personal',
															    fieldLabel : 'Honorarios',
															    vtype : 'soloNumeros',
															    disabled : false,
															    editable : true
															}
															
															,{
																store : {
															    	fields: ['codinttablatipo','destablatipo'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Unidad_Tiempo',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listResult'
															    		}
															    	},
															    	autoLoad: true
															    },
															    allowBlank : true,
															    queryMode : 'local',
															    displayField : 'destablatipo',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'int_id_tipo_unidad_tiempo',
															    valueField : 'codinttablatipo',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Unidad de Tiempo',
															    disabled : false,
															    editable : false,
															    listeners : {
															    	scope : this,
															    	afterRender : function(me){
															    		me.setValue(2);
															    	}
															    }
															}
															,{
															    allowBlank : false,
															    hidden : false,
															    xtype : 'textfield',
															    name : 'int_cantidad_tiempo',
															    fieldLabel : 'Cantidad de Tiempo',
															    vtype:'soloNumeros',
															    disabled : false,
															    editable : true,
															    inputAttrTpl: " data-qtip='Duración del Contrato.' "
															}															
															 ,{
																 allowBlank : false,
																 hidden : false, 
																 xtype : 'checkbox',
																 name:'int_requiere_evaluacion',
																 id:'int_requiere_evaluacion',
																 fieldLabel : 'Req. Evaluación Escrita',
																 boxLabel: 'Sí',
																 checkOnly: true,
																 inputValue: '1',
																 uncheckedValue: '2'
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
																	    	autoLoad: true
																	    },
																	    allowBlank : false,
																	    queryMode : 'local',
																	    displayField : 'destablatipo',
																	    hidden : false,
																	    xtype : 'combobox',
																	    name : 'int_id_tipo_trabajador',
																	    valueField : 'codinttablatipo',
																	    emptyText : '-- Seleccione Opción --',
																	    fieldLabel : 'Tipo de Trabajador',
																	    disabled : false,
																	    editable : false
																	    
															},
															{															    
															    store : {
															    	fields: ['srl_id_unidad_operativa','var_nom_unidad'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'obtener-unidad-operativa-geografica.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listResult'
															    		}
															    	},
															    	autoLoad: true
															    },																																
																
																queryMode : 'local',
																xtype : 'combobox',
																hidden : false,
																editable : false,
																emptyText : '-- Seleccione Opción --',
																fieldLabel : 'Ubicación Geográfica',
																name : 'id_sede_ubicacion',
																displayField : 'var_descrip',
																disabled : false,
																valueField : 'idsede',
																value : '',
																store : {
																	fields: ['idsede','var_descrip'],
																	proxy: {
																				type: 'ajax',
																				url: 'obtener-dependencia-geografica.action',
																				reader: {
																					type: 'json',
																					rootProperty: 'listResult'
																				}
																	},
																	autoLoad: true
																},																	
																	
																listeners : {

																	select: function(combo, record, index) {

															    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
//															    		var int_id_tipo_monto_concepto = form.getForm().findField('int_id_tipo_monto_concepto');
															    		var direccion_ubicacion_fisica = form.getForm().findField('var_lugar_prestacion');

															    		if(combo.getValue() !== null){
															    			Ext.onReady(function() {
															                    Ext.Ajax.request({
															                        method: 'GET',
															                        url: 'obtener-direccion-dependencia-prestacion-servicio.action',
															                        params: { 'int_sede_prestacion' : combo.getValue() },
															                        success: function( result, request ){
															                        	var json = Ext.JSON.decode(result.responseText);
//															                        	int_id_tipo_monto_concepto.setValue(json.result.int_id_tipo_monto_concepto);
															                        	direccion_ubicacion_fisica.setValue(json.result.direccion_sede_prestacion);
															                        }
															                    });
															                });
															    		}																          
															    	
															    	}
																}
																	
															}	
															
															,{															   
																
															    allowBlank : false,
															    maxLength : 5000,
															    hidden : false,
															    minLength : 1,
															    xtype : 'textareafield',
															    name : 'var_lugar_prestacion',
															    fieldLabel : 'Lugar de Prestación',
															    fieldStyle: 'text-transform:uppercase',
															    upper: true,
															    disabled : false,
															    editable : false,
															    listeners:{
															    	
															    	
															    	change: function(field, newValue, oldValue){
															    		field.setValue(newValue.toUpperCase());
															    	}
															
															    }
															}
															
															,{
															    allowBlank : true,
															    hidden : false,
															    xtype : 'textfield',
															    name : 'int_anio',
															    fieldLabel : 'Anio',
															    disabled : false,
															    editable : false
															}
															
															,{
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
															    	autoLoad: true
															    },
															    allowBlank : true,
															    queryMode : 'local',
															    displayField : 'destablatipo',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'int_id_estado',
															    valueField : 'codinttablatipo',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Estado',
															    disabled : false,
															    editable : false,
															    listeners : {
															    	scope : this,
															    	afterRender : function(me){
															    		me.setValue(1);
//															    		me.setReadOnly(true);
															    	}
															    }
															}
															,{
															    allowBlank : true,
															    hidden : true,
															    xtype : 'textfield',
															    name : 'descrip_estado',
															    fieldLabel : 'Estado',
															    disabled : false,
															    editable : true
															}
															,{
															    allowBlank : true,
															    hidden : true,
															    xtype : 'datefield',
															    name : 'tsp_fecha_registro',
															    format : 'd/m/Y',
															    fieldLabel : 'Fecha de Registro',
															    disabled : false,
															    editable : true
															}
															,{
															    allowBlank : true,
															    hidden : true,
															    xtype : 'textfield',
															    name : 'tokenField',
															    fieldLabel : 'tokenField'
															}
				                	            	        
				                	            	       ]
				                	            	
				                	               },    //fin container 1 vbox
				                	               {
							                	   xtype:'container', //container vbox 2
							                	   defaults:{
							                		   margin: '5 5'  
							                	   },
							                	   width:'50%',
//							                	   flex:1,
							                	   layout:{
							                	       type:'vbox',
							                	       align:'stretch'
							                	   },
				                	               items:[
															{
															    allowBlank : true,
															    maxLength : 5000,
															    hidden : false,
															    minLength : 1,
															    xtype : 'htmleditor',
															    enableColors: false,
															    enableAlignments: false,
															    enableFont:false,
															    enableFontSize: false,
															    enableFormat : false,
															    enableLinks : false,
															    enableSourceEdit : false,
//															    enableLists : false,
															    height:100,
															    name : 'var_experiencia_requerida',
															    fieldLabel : 'Experiencia Requerida',
															    disabled : false,
															    editable : true
															 }
															,{
															    allowBlank : true,
															    maxLength : 5000,
															    hidden : false,
															    minLength : 1,
															    xtype : 'htmleditor',
															    enableColors: false,
															    enableAlignments: false,
															    enableFont:false,
															    enableFontSize: false,
															    enableFormat : false,
															    enableLinks : false,
															    enableSourceEdit : false,
//															    enableLists : false,
															    height:100,
															    name : 'var_competencias_requeridas',
															    fieldLabel : 'Competencia Requerida',
															    disabled : false,
															    editable : true
															}
															,{
															    allowBlank : true,
															    maxLength : 5000,
															    hidden : false,
															    minLength : 1,
															    xtype : 'htmleditor',
															    enableColors: false,
															    enableAlignments: false,
															    enableFont:false,
															    enableFontSize: false,
															    enableFormat : false,
															    enableLinks : false,
															    enableSourceEdit : false,
//															    enableLists : false,
															    height:100,
															    name : 'var_formacion_academica',
															    fieldLabel : 'Formación Académica',
															    disabled : false,
															    editable : true
															}
															,{
															    allowBlank : true,
															    maxLength : 5000,
															    hidden : false,
															    minLength : 1,
															    xtype : 'htmleditor',
															    enableColors: false,
															    enableAlignments: false,
															    enableFont:false,
															    enableFontSize: false,
															    enableFormat : false,
															    enableLinks : false,
															    enableSourceEdit : false,
//															    enableLists : false,
															    height:100,
															    name : 'var_cursos_especializacion',
															    fieldLabel : 'Cursos / Especializaciones',
															    disabled : false,
															    editable : true
															}
															,{
															    allowBlank : true,
															    maxLength : 5000,
															    hidden : false,
															    minLength : 1,
															    xtype : 'htmleditor',
															    enableColors: false,
															    enableAlignments: false,
															    enableFont:false,
															    enableFontSize: false,
															    enableFormat : false,
															    enableLinks : false,
															    enableSourceEdit : false,
//															    enableLists : false,
															    height:100,
															    name : 'var_requisitos_puesto',
															    fieldLabel : 'Requisitos para el puesto',
															    disabled : false,
															    editable : true,
															    enableRemoveHtml : true
															    														    
															}
															,{
															    allowBlank : true,
															    maxLength : 20000,
															    hidden : false,
															    minLength : 1,
															    xtype : 'htmleditor',
															    enableColors: false,
															    enableAlignments: false,
															    enableFont:false,
															    enableFontSize: false,
															    enableFormat : false,
															    enableLinks : false,
															    enableSourceEdit : false,
//															    enableLists : false,
															    height:140,
															    name : 'var_principales_funciones',
															    fieldLabel : 'Principales Funciones',
															    disabled : false,
															    editable : true,
															    enableRemoveHtml : true
															}
															
				                	                  ]
						                	    } //end container vbox 2
				                	        ],
								     }
			                	
			                	
			                	]//end container principal
							    
						},//end form
							
						,{
							title: 'Archivos Adjuntos',
				    		glyph:'xf022@FontAwesome',
				    		items: [{id:'subModel_ArchivoRequerimientoQuery', xtype:'ArchivoRequerimientoQueryList'}]
						}	

                ] //items form
            }
        ]; //end items principal
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            //id:'buttons',
            ui: 'footer',
            items: ['->'
                  /*  , {
            	glyph:'xf0c7@FontAwesome',
                itemId: 'save',
                text: 'Grabar',
                action: 'save'
            }
             */
             ,{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        },
        
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_GestionarReqPersonal_statusbar'
        })];

        this.callParent(arguments);      
    }//end function
});
