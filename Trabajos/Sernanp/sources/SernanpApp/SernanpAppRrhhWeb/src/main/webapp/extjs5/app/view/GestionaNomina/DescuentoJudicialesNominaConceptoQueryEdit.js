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
* DATE CREATE : 07/04/2015 17:43:08
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionaNomina.DescuentoJudicialesNominaConceptoQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.DescuentoJudicialesNominaConceptoQueryEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 350,
    
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_DescuentoJudicialesNominaConceptoQuery',
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
						fieldLabel : 'srl_id_nomina_concepto',
						name : 'srl_id_nomina_concepto',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'srl_id_nomina_anio_periodo_personal',
						name : 'srl_id_nomina_anio_periodo_personal',
						disabled : false,
						readOnly : false
					}
					,{
					    queryMode : 'local',
						allowBlank : true,
						xtype : 'combobox',
						listeners : {
						     change: function(field, newValue, oldValue) {

						          var form = Ext.getCmp('form_submodel_DescuentoJudicialesNominaConceptoQuery');
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
						readOnly : true,
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
						allowBlank : true,
						xtype : 'combobox',
						listeners : {
						     change: function(field, newValue, oldValue) {

						          var form = Ext.getCmp('form_submodel_DescuentoJudicialesNominaConceptoQuery');
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
						    }
						},
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						readOnly : true,
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
						disabled : false
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
						valueField : 'srl_id_concepto_planilla',
						fieldLabel : 'Concepto',
						name : 'srl_id_concepto_planilla',
						displayField : 'var_descrip_corto_concepto',
						disabled : false,
						listeners : {
					    	change: function(field, newValue, oldValue) {
					    		  var form = Ext.getCmp('form_submodel_DescuentoJudicialesNominaConceptoQuery');
					    		  var srl_id_beneficiario_descuento_judicial = form.getForm().findField('srl_id_beneficiario_descuento_judicial');
						          srl_id_beneficiario_descuento_judicial.setDisabled(true);
						          srl_id_beneficiario_descuento_judicial.store.removeAll();
						          var mainForm = Ext.getCmp('form_crud_GestionaNomina');
						          var idpersonal = mainForm.getForm().findField('idpersonal');
						          srl_id_beneficiario_descuento_judicial.store.reload({
						               params: {
						            	   		idpersonal: idpersonal.getValue()
						               }
						          });
						          srl_id_beneficiario_descuento_judicial.setDisabled(false);
						          if(oldValue != null){
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
					    allowBlank : false,
						xtype : 'textfield',
						hidden : false,
						vtype : 'soloNumeroDecimales',
						editable : true,
						fieldLabel : 'Valor',
						name : 'dec_monto_calculado',
						disabled : false,
						readOnly : false
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
							fields: ['var_cod_estado','var_nombre_estado'],
							proxy: {
										type: 'ajax',
										url: 'obtener-estados.action?nom_tabla_estado=t_nomina_concepto',
										reader: {
											type: 'json',
											rootProperty: 'listResult'
										}
							},
							autoLoad: true,
					    },
						valueField : 'var_cod_estado',
						fieldLabel : 'Estado',
						name : 'int_id_estado',
						displayField : 'var_nombre_estado',
						disabled : false
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
