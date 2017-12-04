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
* DATE CREATE : 04/04/2015 00:02:41
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAsignarConcepto.ConceptoPersonalQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ConceptoPersonalQueryEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 550,
    
    glyph:'xf044@FontAwesome',
    
    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_ConceptoPersonalQuery',
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
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'srl_id_personal_concepto',
						name : 'srl_id_personal_concepto',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'idpersonal',
						name : 'idpersonal',
						disabled : false,
						readOnly : false
					}
					,{
					    queryMode : 'local',
						allowBlank : false,
						xtype : 'combobox',
						listeners : {
						     change: function(field, newValue, oldValue) {

						          var form = Ext.getCmp('form_submodel_ConceptoPersonalQuery');
						          var on_field = form.getForm().findField('int_id_sub_tipo_concepto');
						          on_field.setDisabled(true);
						          on_field.store.removeAll();
						          on_field.store.reload({
						               params: {
						                   		int_cod_refer_tablatipo: field.getValue()
						               }
						          });
						          on_field.setDisabled(false);
						          if(oldValue != null){
										on_field.setValue('');
						          }
						    }
						},
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						readOnly : false,
						store : {
								fields: ['codinttablatipo','destablatipo'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Concepto_Planilla',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'codinttablatipo',
						fieldLabel : 'Tipo Concepto',
						name : 'int_id_tipo_concepto',
						displayField : 'destablatipo',
						disabled : false
					}
					,{
					    queryMode : 'local',
						allowBlank : false,
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						readOnly : false,
						store : {
								fields: ['codinttablatipo','destablatipo'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-valores-tablatipo-por-refer.action?nombre_tabla=Sub_Tipo_Concepto_Planilla',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: false
					    },
						valueField : 'codinttablatipo',
						fieldLabel : 'Sub Tipo Concepto',
						name : 'int_id_sub_tipo_concepto',
						displayField : 'destablatipo',
						disabled : false,
					    listeners : {
					    	change: function(field, newValue, oldValue) {
					    		
					    		 /////////
					    		  var form = Ext.getCmp('form_submodel_ConceptoPersonalQuery');
						          var on_field = form.getForm().findField('srl_id_concepto_planilla');
						          on_field.setDisabled(true);
						          on_field.store.removeAll();
						          var field_int_id_tipo_concepto = form.getForm().findField('int_id_tipo_concepto');
						          on_field.store.reload({
						               params: {
						                   		int_id_tipo_concepto: field_int_id_tipo_concepto.getValue(),
						                   		int_id_subtipo_concepto: field.getValue()
						               }
						          });
						          on_field.setDisabled(false);
						          if(oldValue != null){
										on_field.setValue('');
						          }
						          
						          /////////
						          
						          var srl_id_beneficiario_descuento_judicial = form.getForm().findField('srl_id_beneficiario_descuento_judicial');
						          srl_id_beneficiario_descuento_judicial.setDisabled(true);
						          srl_id_beneficiario_descuento_judicial.store.removeAll();
						          var mainForm = Ext.getCmp('form_crud_GestionarAsignarConcepto');
						          var idpersonal = mainForm.getForm().findField('idpersonal');
						          srl_id_beneficiario_descuento_judicial.store.reload({
						               params: {
						            	   		idpersonal: idpersonal.getValue()
						               }
						          });
						          srl_id_beneficiario_descuento_judicial.setDisabled(false);
						          
						          /////////
						          

					    		var form = Ext.getCmp('form_submodel_ConceptoPersonalQuery');
					    		var int_id_tipo_monto_concepto = form.getForm().findField('int_id_tipo_monto_concepto');
					    		var dec_monto_concepto = form.getForm().findField('dec_monto_concepto');
					    		var srl_id_beneficiario_descuento_judicial = form.getForm().findField('srl_id_beneficiario_descuento_judicial');
					    		
					    		if(newValue === 2 || newValue === 4){
					    			
					    			int_id_tipo_monto_concepto.setHidden(false);
					    			int_id_tipo_monto_concepto.allowBlank = false;
					    			int_id_tipo_monto_concepto.clearInvalid();
					    			
					    			dec_monto_concepto.setHidden(false);
					    			dec_monto_concepto.allowBlank = false;
					    			dec_monto_concepto.clearInvalid();
					    			
					    			srl_id_beneficiario_descuento_judicial.setHidden(true);
					    			srl_id_beneficiario_descuento_judicial.allowBlank = true;
					    			srl_id_beneficiario_descuento_judicial.clearInvalid();
					    			
					    			
					    		}else if(newValue === 6){
					    			
					    			int_id_tipo_monto_concepto.setHidden(false);
					    			int_id_tipo_monto_concepto.allowBlank = false;
					    			int_id_tipo_monto_concepto.clearInvalid();
					    			
					    			dec_monto_concepto.setHidden(false);
					    			dec_monto_concepto.allowBlank = false;
					    			dec_monto_concepto.clearInvalid();
					    			
					    			srl_id_beneficiario_descuento_judicial.setHidden(false);
					    			srl_id_beneficiario_descuento_judicial.allowBlank = false;
					    			srl_id_beneficiario_descuento_judicial.clearInvalid();
					    			
					    		}else{
					    			
					    			int_id_tipo_monto_concepto.setHidden(true);
					    			int_id_tipo_monto_concepto.allowBlank = true;
					    			int_id_tipo_monto_concepto.clearInvalid();
					    			
					    			dec_monto_concepto.setHidden(true);
					    			dec_monto_concepto.allowBlank = true;
					    			dec_monto_concepto.clearInvalid();
					    			
					    			srl_id_beneficiario_descuento_judicial.setHidden(true);
					    			srl_id_beneficiario_descuento_judicial.allowBlank = true;
					    			srl_id_beneficiario_descuento_judicial.clearInvalid();
					    			
					    			int_id_tipo_monto_concepto.setValue('');
					    			dec_monto_concepto.setValue('');
					    			srl_id_beneficiario_descuento_judicial.setValue('');
					    			
					    		}
					    		
					    		
					    	}
					    }
					}
					,{
					    queryMode : 'local',
						allowBlank : false,
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						readOnly : false,
						store : {
								fields: ['srl_id_concepto_planilla','var_descrip_corto_concepto'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-lista-concepto.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: false
					    },
					    listeners : {
					    	select: function(field, record, index) {

					    		var form = Ext.getCmp('form_submodel_ConceptoPersonalQuery');
					    		var int_id_tipo_monto_concepto = form.getForm().findField('int_id_tipo_monto_concepto');
					    		var dec_monto_concepto = form.getForm().findField('dec_monto_concepto');

					    		if(field.getValue() !== null){
					    			Ext.onReady(function() {
					                    Ext.Ajax.request({
					                        method: 'GET',
					                        url: 'obtener-concepto-planilla.action',
					                        params: { 'srl_id_concepto_planilla' : field.getValue() },
					                        success: function( result, request ){
					                        	var json = Ext.JSON.decode(result.responseText);
					                        	int_id_tipo_monto_concepto.setValue(json.result.int_id_tipo_monto_concepto);
					                        	dec_monto_concepto.setValue(json.result.dec_monto_concepto);
					                        }
					                    });
					                });
					    		}
						          
					    	}
					    },
						valueField : 'srl_id_concepto_planilla',
						fieldLabel : 'Concepto',
						name : 'srl_id_concepto_planilla',
						displayField : 'var_descrip_corto_concepto',
						disabled : false
					}
					,{
					    queryMode : 'local',
						allowBlank : false,
						xtype : 'combobox',
						hidden : true,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						readOnly : false,
						store : {
								fields: ['codinttablatipo','destablatipo'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Monto',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'codinttablatipo',
						fieldLabel : 'Tipo Monto',
						name : 'int_id_tipo_monto_concepto',
						displayField : 'destablatipo',
						disabled : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'Valor',
						name : 'dec_monto_concepto',
						disabled : false,
						readOnly : false
//						,
//						vtype:'soloNumeroDecimales'
					}
					,{
					    queryMode : 'local',
						allowBlank : true,
						xtype : 'combobox',
						hidden : true,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						readOnly : false,
						store : {
								fields: ['srl_id_beneficiario_descuento_judicial','var_descripcion_descuento'],
								proxy: {
							         type: 'ajax',
							         url: 'lista-beneficiarios-por-personal.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: false
					    },
						valueField : 'srl_id_beneficiario_descuento_judicial',
						fieldLabel : 'Beneficiario',
						name : 'srl_id_beneficiario_descuento_judicial',
						displayField : 'var_descripcion_descuento',
						disabled : false
					}
					,{
					    queryMode : 'local',
						allowBlank : true,
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						readOnly : false,
						store : {
								fields: ['codinttablatipo','destablatipo'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Boolean_Generico',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'codinttablatipo',
						fieldLabel : 'Aplicar Afectos',
						name : 'int_aplica_afectos',
						displayField : 'destablatipo',
						disabled : false
					},
					{
					    queryMode : 'local',
						allowBlank : true,
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						readOnly : false,
						store : {
								fields: ['codinttablatipo','destablatipo'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Boolean_Generico',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'codinttablatipo',
						fieldLabel : 'Aplicar Frecuencias',
						name : 'int_aplica_frecuencias',
						displayField : 'destablatipo',
						disabled : false
					},
					{
					    allowBlank : true,
					    queryMode : 'local',
					    xtype : 'combobox',
					    hidden : false,
					    emptyText : '-- Seleccione Opción --',
					    editable : true,
					    readOnly : false,
					    store : {
					    	fields: ['srl_id_anio_planilla','int_anio'],
					    	proxy: {
					    		type: 'ajax',
					    		url: 'obtener-todos-anios-planilla.action',
					    		reader: {
					    			type: 'json',
					    			rootProperty: 'listResult'
					    		}
					    	},
					    	autoLoad: true,
							listeners: {
						        load: function(store) {
						        	var rec = { srl_id_anio_planilla:'',int_anio:'-- Todos --' };
						        	store.insert(0, rec);
						        }
							}
					    },
					    valueField : 'srl_id_anio_planilla',
					    fieldLabel : 'Año',
					    name : 'srl_id_anio_planilla',
					    displayField : 'int_anio',
					    disabled : false,
					    value : ''
					}
					,{
					    queryMode : 'local',
						allowBlank : false,
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						readOnly : false,
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
						valueField : 'codinttablatipo',
						fieldLabel : 'Estado',
						name : 'int_id_estado',
						displayField : 'destablatipo',
						disabled : false
					}
					,{
			    		title: 'Afectos',
			    		glyph:'xf022@FontAwesome',
			    		items: [{id:'subModel_PersonalConceptoAfectoQuery', xtype:'PersonalConceptoAfectoQueryList'}]
					}
					,{
			    		title: 'Frecuencias',
			    		glyph:'xf022@FontAwesome',
			    		items: [{id:'subModel_PersonalConceptoFrecuenciaQuery', xtype:'PersonalConceptoFrecuenciaQueryList'}]
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
