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
* DATE CREATE : 20/04/2015 01:27:21
* VERSION : 1.0
*/

Ext.define('MyApp.view.ConvocatoriaPlaza.ConvocatoriaPlazaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ConvocatoriaPlazaQueryEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '50%',

    glyph:'xf044@FontAwesome',
    
    listeners:{
    	
    	afterRender : function(me){
//    		var factorStore = Ext.getCmp('factorStore');
//    		var form = Ext.getCmp('form_submodel_ConvocatoriaPlazaQuery');
//    		var srl_id_configuracion_factor_evaluacion = form.getForm().findField('srl_id_configuracion_factor_evaluacion');
//    		 
//    		srl_id_configuracion_factor_evaluacion.setValue(1);
//    		
//    		factorStore.store.reload({
//    			params: {
//    				srl_id_configuracion_factor_evaluacion: srl_id_configuracion_factor_evaluacion
//    			}
//    		
//    		});
    	}

    },
    
    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_ConvocatoriaPlazaQuery',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',

                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'left',
                    allowBlank: false,
                    combineErrors: true,
                    msgTarget: 'qtip',
                    labelWidth: 140
                },

                items: [
						{
							xtype:'container', //container 1
							defaults:{
								   margin: '5 10'
							   },
							width:'50%',
							layout:{
								type:'vbox',
								align:'stretch'
							},
							items: [

									{
									    allowBlank : true,
										hidden : true,
										xtype : 'textfield',
										name : 'srl_id_convocatoria',
										fieldLabel : 'srl_id_convocatoria'
									}
									,{
										allowBlank : true,
									    xtype : 'textfield',
										name : 'srl_id_conv_area_org',
										fieldLabel : 'srl_id_conv_area_org',
										hidden : true
									}
																
									
									,{
										listeners : {
											/*
											select: function(combo, record, index) {

									    		var form = Ext.getCmp('form_crud_GestionarReqPersonal');
//									    		var int_id_tipo_monto_concepto = form.getForm().findField('int_id_tipo_monto_concepto');
									    		var direccion_ubicacion_fisica = form.getForm().findField('var_lugar_prestacion');

									    		if(combo.getValue() !== null){
									    			Ext.onReady(function() {
									                    Ext.Ajax.request({
									                        method: 'GET',
									                        url: 'obtener-direccion-dependencia-prestacion-servicio.action',
									                        params: { 'int_sede_prestacion' : combo.getValue() },
									                        success: function( result, request ){
									                        	var json = Ext.JSON.decode(result.responseText);
//									                        	int_id_tipo_monto_concepto.setValue(json.result.int_id_tipo_monto_concepto);
									                        	direccion_ubicacion_fisica.setValue(json.result.direccion_sede_prestacion);
									                        }
									                    });
									                });
									    		}																          
									    	
									    	},
											*/
									    	change: function(combo, newValue, oldValue) {
									    			
									    		var form = Ext.getCmp('form_submodel_ConvocatoriaPlazaQuery');
									    		
									    		var srl_id_requerimiento_personal = combo.getValue(); 
									    		// Obtiene el valor del combo combo.getRawValue();
									    		// Obtiene key del combo.getValue();
									    		
									    		
									    		// ADD 29-01-2016 DAVID
									    		
									    		var dte_fec_aprobacion_oa = form.getForm().findField('dte_fec_aprobacion_oa');									    	
									    											    		
									    		var idarea = form.getForm().findField('idarea_solicitante');
									    		
//									    		var idarea = form.getForm().findField('idarea_solicitante');
									    		
									    		var descrip_area = form.getForm().findField('descrip_area');
									    		var idunidad = form.getForm().findField('idunidad_solicitante');
									    		
									    		var int_cantidad_requerida = form.getForm().findField('int_cantidad_requerida');
									    	   	var var_lugar_prestacion = form.getForm().findField('var_lugar_prestacion');
									    	   	var var_denominacion_requerimiento = form.getForm().findField('var_denominacion_requerimiento');
									    	   	
									    	   	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
									    	   	
									    	   	var srl_id_requerimiento_personal = form.getForm().findField('srl_id_requerimiento_personal');
									    	   	
//									    	   	var descrip_unidad = form.getForm().findField('descrip_unidad');
									 										   
									    		idarea.store.on('load',function(ds,records,o){

									    			  idarea.setValue(records[0].data.idarea_solicitante);
									    			  
									    			  if(records[0].data.idunidad_solicitante != null){
									    				  idunidad.setValue(records[0].data.idunidad_solicitante);
									    			  }
									    			  descrip_area.setValue(records[0].data.desarea);
									    			  
//									    			  descrip_unidad.setValue(records[0].data.nomunidad);
									    			  
									    			  int_cantidad_requerida.setValue(records[0].data.int_cantidad_requerida);
									    			  var_lugar_prestacion.setValue(records[0].data.var_lugar_prestacion);
									    			  
									    			  var_denominacion_requerimiento.setValue(records[0].data.var_denominacion_requerimiento);
									    			  
//									    			  console.log(records[0].data.dte_fec_aprobacion_oa);	
									    			  dte_fec_aprobacion_oa.setValue(records[0].data.dte_fec_aprobacion_oa);
									    			  
									    			  srl_id_requerimiento_personal.setValue(records[0].data.var_numero_requerimiento_corto)
									    			  
									    		});
									    		
									    	  	//area organica
									    		idarea.setDisabled(true);
									    		idarea.store.removeAll();
									    		idarea.store.reload({
									    			params: {
									    				IdReq: combo.getValue()	,								    				
									    				srl_id_convocatoria : srl_id_convocatoria.getValue()
									    				}
									    				
									    		});
									    		idarea.setDisabled(false);
									    		idarea.setEditable(false);
									    		
									    		//unidad operativa
									    		idunidad.setDisabled(true);
									    		idunidad.store.removeAll();
									    		idunidad.store.reload({
									    			params: {
									    				IdReq: combo.getValue(),
									    				srl_id_convocatoria : srl_id_convocatoria.getValue()
									    				}
									    		});
									    		idunidad.setDisabled(false);
									    		idunidad.setEditable(false);
									    
									    
									    	}
									    },
										store : {
									    	fields: ['srl_id_requerimiento_personal','var_numero_requerimiento'],
									    	proxy: {
									    		type: 'ajax',
									    		url: 'obtener-requerimiento-disponible.action',
									    		reader: {
									    			type: 'json',
									    			rootProperty: 'listResult'
									    		}
									    	},
									    	
									    	
									    	autoLoad: true
									    },
									    
									    allowBlank : false,
									    queryMode : 'local',
									    displayField : 'var_numero_requerimiento_corto',
									    hidden : false,
									    xtype : 'combobox',
									    name : 'srl_id_requerimiento_personal',
									    valueField : 'srl_id_requerimiento_personal',
									    emptyText : '-- Seleccione Opción --',
									    fieldLabel : 'Nº de Requerimiento',
									    disabled : false,
									    editable : false
									   
									}
									,{
									    allowBlank : true,
										maxLength : 5000,
										minLength : 1,
										xtype : 'textareafield',
										name : 'var_denominacion_requerimiento',
										fieldLabel : 'Denominación',
										editable:false
									}
									,{									   
									    store : {
									    	fields: ['idarea_solicitante','desarea'],
									    	proxy: {
									    		type: 'ajax',
									    		url: 'detalle-requerimiento-plaza.action',
									    		reader: {
									    			type: 'json',
									    			rootProperty: 'listResult'
									    		}
									    	},
									    	autoLoad: false
									    },
									    allowBlank : true,
									    queryMode : 'local',
									    displayField : 'desarea',
									    hidden : false,
									    xtype : 'combobox',
									    name : 'idarea_solicitante',
									    valueField : 'idarea_solicitante',
									    fieldLabel : 'Área Solicitante',
									    disabled : false,
									    editable : false,
									    readOnly:true
									   									   
									}
									,{
									    allowBlank : true,
										xtype : 'textfield',
										name : 'descrip_area',
										fieldLabel : 'descrip_area',
										hidden:true
									}
									,{
									    store : {
									    	fields: ['idunidad_solicitante','nomunidad'],
									    	proxy: {
									    		type: 'ajax',
									    		url: 'detalle-requerimiento-plaza.action',
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
									    name : 'idunidad_solicitante',
									    valueField : 'idunidad_solicitante',
									    fieldLabel : 'Unidad Operativa Solicitante',
									    disabled : false,
									    editable : false,
									    readOnly:true
									    
									}
									,{
									    allowBlank : true,
										xtype : 'textfield',
										name : 'descrip_unidad',
										fieldLabel : 'descrip_unidad',
										hidden:true
									}
									,{
									    allowBlank : true,
										xtype : 'textfield',
										name : 'int_cantidad_requerida',
										fieldLabel : 'Cantidad de Vacantes',
										editable:false
									}
									,{
									    allowBlank : true,
										maxLength : 5000,
										minLength : 1,
										xtype : 'textareafield',
										name : 'var_lugar_prestacion',
										fieldLabel : 'Lugar de Prestación',
										editable:false
									}
									,{
										allowBlank : false,
									    maxLength : 200,
										minLength : 1,
										xtype : 'textfield',
										name : 'var_codigo_postulacion',
										fieldLabel : 'Código de Postulación',
										fieldStyle: 'text-transform:uppercase',
										listeners:{
									    	change: function(field, newValue, oldValue){
									    		field.setValue(newValue.toUpperCase());
									    	}
									    }
									}
									
									/*ADD 25-01-2016 DAVID      PARA REGISTRAR LA FECHA DE APROBACIÓN DE LA PLAZA POR OA */
									
									,{
									    allowBlank : false,
									    xtype : 'datefield',
									    name : 'dte_fec_aprobacion_oa',
									    format : 'd/m/Y',
									    fieldLabel : 'Fecha de Aprobación OA'									    
									}
									,
									,{
									    allowBlank : false,
									    xtype : 'datefield',
									    name : 'dte_fecha_inicio_contrato',
									    format : 'd/m/Y',
									    fieldLabel : 'Fecha Inicio Contrato'									    
									}
									,
									,{
									    allowBlank : false,
									    xtype : 'datefield',
									    name : 'dte_fecha_fin_contrato',
									    format : 'd/m/Y',
									    fieldLabel : 'Fecha Fín Contrato'									    
									}

									/* END DAVID*/
 								
									,{
									    allowBlank : true,
										xtype : 'textfield',
										name : 'var_numero_requerimiento_corto',
										fieldLabel : 'Nº de Requerimiento',
										hidden:true
									}
									,{
									    allowBlank : true,
										xtype : 'textfield',
										name : 'idpersonal',
										fieldLabel : 'idpersonal',
										hidden:true
									}
									,{
									    store : {
									    	fields: ['var_cod_estado','var_nombre_estado'],
									    	proxy: {
									    		type: 'ajax',
									    		url: 'obtener-estado-plaza.action',
									    		reader: {
									    			type: 'json',
									    			rootProperty: 'listResult'
									    		}
									    	},
									    	autoLoad: true
									    },
									    allowBlank : false,
									    queryMode : 'local',
									    displayField : 'var_nombre_estado',
									    hidden : false,
									    xtype : 'combobox',
									    name : 'int_id_estado',
									    valueField : 'var_cod_estado',
									    emptyText : '-- Seleccione Opción --',
									    fieldLabel : 'Estado',
									    disabled : false,
									    editable : false,
									    listeners : {
									    	scope : this,
									    	afterRender : function(me){
									    		me.setValue(1);
									    	}
									    }
									}
									,{
									    allowBlank : true,
										xtype : 'textfield',
										name : 'descrip_estado',
										fieldLabel : 'descrip_estado',
										hidden:true
									}
									,{
									    store : {
									    	fields: ['srl_id_configuracion_evaluacion_personal','var_nombre_configuracion'],
									    	proxy: {
									    		type: 'ajax',
									    		url: 'obtener-lista-conf-etapas.action',
									    		reader: {
									    			type: 'json',
									    			rootProperty: 'listResult'
									    		}
									    	},
									    	autoLoad: true
									    },
									    allowBlank : false,
									    queryMode : 'local',
									    displayField : 'var_nombre_configuracion',
									    hidden : false,
									    xtype : 'combobox',
									    name : 'srl_id_configuracion_evaluacion_personal',
									    valueField : 'srl_id_configuracion_evaluacion_personal',
									    emptyText : '-- Seleccione Opción --',
									    fieldLabel : 'Configuración etapas',
									    disabled : false,
									    editable : false
									}
									,{ 
										
										listeners : {
											
									    	change: function(field, newValue, oldValue) {
									    		
									    		var factorStore = Ext.getCmp('factorStore');
									    		
									    		factorStore.store.reload({
									    			params: {
									    				srl_id_configuracion_factor_evaluacion: field.getValue()
									    			}
									    		
									    		});
									    	}
									    },
										

									    store : {
									    	fields: ['srl_id_configuracion_factor_evaluacion','var_descrip_configuracion'],
									    	proxy: {
									    		type: 'ajax',
									    		url: 'listar-factor-evaluacion.action',
									    		reader: {
									    			type: 'json',
									    			rootProperty: 'listResult'
									    		}
									    	},
									    	autoLoad: true
									    },
									    allowBlank : false,
									    queryMode : 'local',
									    displayField : 'var_descrip_configuracion',
									    hidden : false,
									    xtype : 'combobox',
									    name : 'srl_id_configuracion_factor_evaluacion',
									    valueField : 'srl_id_configuracion_factor_evaluacion',
									    value:'',
									    fieldLabel : 'Factor de Evaluación',
									    disabled : false,
									    editable : false,
									    emptyText : '-- Seleccione Opción --',
									    
									}
									,{
									    xtype : 'ConvocatoriaPlazaFactorQueryList',
										id: 'factorStore'
									}
									]
						  }


                     ]
            }
        ];

        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf0c7@FontAwesome',
                itemId: 'save',
                text: 'Grabar',
                action: 'save'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);
    }
});
