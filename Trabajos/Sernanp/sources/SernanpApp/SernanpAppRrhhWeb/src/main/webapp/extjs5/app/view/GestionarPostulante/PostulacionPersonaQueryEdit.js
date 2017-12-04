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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPostulante.PostulacionPersonaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.PostulacionPersonaQueryEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '45%',
    
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_PostulacionPersonaQuery',
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
						fieldLabel : 'srl_id_postulante_conv_area_org',
						name : 'srl_id_postulante_conv_area_org',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'int_id_postulante',
						name : 'int_id_postulante',
						disabled : false,
						readOnly : false
					}
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						listeners : {
						     change: function(field, newValue, oldValue) {

						          var form = Ext.getCmp('form_submodel_PostulacionPersonaQuery');
						          var on_field = form.getForm().findField('srl_id_conv_area_org');
						          on_field.setDisabled(true);
						          on_field.store.removeAll();
						          on_field.store.reload({
						               params: {
						                   		idConvocatoria: field.getValue()
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
								fields: ['srl_id_convocatoria','var_num_convocatoria'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-convocatorias.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'srl_id_convocatoria',
						fieldLabel : 'Convocatoria',
						name : 'srl_id_convocatoria',
						displayField : 'var_num_convocatoria',
						disabled : false
					}
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						fieldLabel : 'Plazas',
						name : 'srl_id_conv_area_org',
						displayField : 'var_codigo_postulacion',
						disabled : false,
						readOnly : false,
						store : {
								fields: ['srl_id_conv_area_org','var_codigo_postulacion'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-codigos-postulacion.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'srl_id_conv_area_org'
					}
					,{
						xtype: 'filefield',
						emptyText: 'Seleccione un archivo',
						vtype:'fileDocUpload',
						allowBlank: false,
						fieldLabel: 'Ficha de Inscripción',
						name: 'upload',
						buttonConfig: {
							glyph: 'xf03e@FontAwesome'
						}
					}
					
					,{
						xtype: 'hidden',
						name: 'file_name_session',
						value: 'files_postulacion',
						hidden : true
					}
					
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						fieldLabel : 'Estado',
						name : 'int_id_estado',
						displayField : 'var_nombre_estado',
						disabled : false,
						readOnly : true,
						store : {
								fields: ['var_cod_estado','var_nombre_estado'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-estados.action?nom_tabla_estado=t_postulante_cnv_area_org',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'var_cod_estado',
					    listeners : {
					    	scope : this,
					    	afterRender : function(me){
					    		me.setValue(1);
					    	}
					    }
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
