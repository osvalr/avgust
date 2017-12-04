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

Ext.define('MyApp.view.GestionarPlaza.ArchivoPlazaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ArchivoPlazaQueryEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '40%',
    
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_ArchivoPlazaQuery',
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
						fieldLabel : 'srl_id_archivo',
						name : 'srl_id_archivo',
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

						          var form = Ext.getCmp('form_submodel_ArchivoPlazaQuery');
						          var on_field = form.getForm().findField('srl_id_conv_area_org_etapa');
						          
						          var formMain = Ext.getCmp('form_crud_GestionarPlaza');
						          var srl_id_conv_area_org = formMain.getForm().findField('srl_id_conv_area_org');
						          
						          on_field.setDisabled(true);
						          on_field.store.removeAll();
						          on_field.store.reload({
						               params: {
						                   		srl_id_etapa_proceso_seleccion: field.getValue(),
						                   		srl_id_conv_area_org : srl_id_conv_area_org.getValue()
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
					    queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						fieldLabel : 'Sub Etapa',
						name : 'srl_id_conv_area_org_etapa',
						displayField : 'var_descrip_subetapa',
						disabled : false,
						readOnly : false,
						store : {
								fields: ['srl_id_conv_area_org_etapa','var_descrip_subetapa'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-lista-sub-etapa-por-etapa-por-plaza.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: false
					    },
						valueField : 'srl_id_conv_area_org_etapa'
					}
					,{
					    allowBlank : true,
						xtype : 'textareafield',
						hidden : false,
						editable : true,
						fieldLabel : 'Descripción',
						minLength : 1,
						name : 'var_descrip_archivo',
						disabled : false,
						readOnly : false,
						maxLength : 1000
					},
					{
						xtype: 'filefield',
						emptyText: 'Seleccione un archivo',
						vtype:'fileDocUpload',
						allowBlank: true,
						fieldLabel: 'Archivo',
						name: 'upload',
						buttonConfig: {
							glyph: 'xf03e@FontAwesome'
						}
					},
					{
						xtype: 'hidden',
						name: 'file_name_session',
						value: 'files_plazas',
						hidden : true
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
