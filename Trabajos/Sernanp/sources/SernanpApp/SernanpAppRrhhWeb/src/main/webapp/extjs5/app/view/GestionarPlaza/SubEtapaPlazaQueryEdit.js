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
* DATE CREATE : 20/04/2015 01:10:00
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPlaza.SubEtapaPlazaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.SubEtapaPlazaQueryEdit',

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
                id: 'form_submodel_SubEtapaPlazaQuery',
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
						fieldLabel : 'srl_id_conv_area_org_etapa',
						name : 'srl_id_conv_area_org_etapa',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'srl_id_conv_area_org',
						name : 'srl_id_conv_area_org',
						disabled : false,
						readOnly : false
					}
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						listeners : {
						     change: function(field, newValue, oldValue) {

						          var form = Ext.getCmp('form_submodel_SubEtapaPlazaQuery');
						          var on_field = form.getForm().findField('srl_id_subetapa_proceso_seleccion');
						          on_field.setDisabled(true);
						          on_field.store.removeAll();
						          on_field.store.reload({
						               params: {
						                   		srl_id_etapa_proceso_seleccion: field.getValue()
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
						editable : true,
						readOnly : false,
						store : {
								fields: ['srl_id_etapa_proceso_seleccion','var_nombre_etapa'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-lista-etapa.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'srl_id_etapa_proceso_seleccion',
						fieldLabel : 'Etapa',
						name : 'srl_id_etapa_proceso_seleccion',
						displayField : 'var_nombre_etapa',
						disabled : false
					}
					,{
					    allowBlank : true,
						queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						readOnly : false,
						store : {
								fields: ['srl_id_subetapa_proceso_seleccion','var_descrip_subetapa'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-lista-sub-etapa.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'srl_id_subetapa_proceso_seleccion',
						fieldLabel : 'Sub Etapa',
						name : 'srl_id_subetapa_proceso_seleccion',
						displayField : 'var_descrip_subetapa',
						disabled : false
					}
					,{
					    allowBlank : true,
						xtype : 'textareafield',
						hidden : false,
						editable : true,
						fieldLabel : 'Detalle Sub Etapa',
						minLength : 1,
						name : 'var_descrip_subetapa',
						disabled : false,
						readOnly : false,
						maxLength : 1000
					}
					,{
					    allowBlank : true,
						xtype : 'datefield',
						hidden : false,
						editable : true,
						fieldLabel : 'Fecha Inicio',
						name : 'dte_fecha_inicio',
						format : 'd/m/Y',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'datefield',
						hidden : false,
						editable : true,
						fieldLabel : 'Fecha Termino',
						name : 'dte_fecha_termino',
						format : 'd/m/Y',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						queryMode : 'local',
						xtype : 'combobox',
						listeners : {
						     change: function(field, newValue, oldValue) {

						          var form = Ext.getCmp('form_submodel_SubEtapaPlazaQuery');
						          var on_field = form.getForm().findField('idunidad');
						          on_field.setDisabled(true);
						          on_field.store.removeAll();
						          on_field.store.reload({
						               params: {
						                   		idAreaOrganica: field.getValue()
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
						editable : true,
						readOnly : false,
						store : {
								fields: ['idarea','descrip_dependencia'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-areas-organicas.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'idarea',
						fieldLabel : 'Área Organica',
						name : 'idarea',
						displayField : 'descrip_dependencia',
						disabled : false
					}
					,{
					    allowBlank : true,
						queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						readOnly : false,
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
						valueField : 'idunidad',
						fieldLabel : 'Unidad Operativa',
						name : 'idunidad',
						displayField : 'nomunidad',
						disabled : false
					}
					,{
					    allowBlank : true,
						queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
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