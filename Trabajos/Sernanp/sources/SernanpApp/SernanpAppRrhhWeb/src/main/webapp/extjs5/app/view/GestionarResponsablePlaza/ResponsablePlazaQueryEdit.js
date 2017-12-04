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
* DATE CREATE : 17/04/2015 16:51:57
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarResponsablePlaza.ResponsablePlazaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ResponsablePlazaQueryEdit',

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
                id: 'form_submodel_ResponsablePlazaQuery',
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
						fieldLabel : 'idpersonal',
						name : 'idpersonal',
						disabled : false,
						readOnly : false
					}
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						listeners : {
						     change: function(field, newValue, oldValue) {

						          var form = Ext.getCmp('form_submodel_ResponsablePlazaQuery');
						          var on_field = form.getForm().findField('srl_id_conv_area_org');
						          var formMain = Ext.getCmp('form_crud_GestionarResponsablePlaza');
						          var idpersonal = formMain.getForm().findField('idpersonal');
						          console.log(idpersonal);
						          on_field.setDisabled(true);
						          on_field.store.removeAll();
						          on_field.store.reload({
						               params: {
						                   		idConvocatoria: field.getValue(),
						                   		idpersonal: idpersonal.getValue()
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
								fields: ['srl_id_conv_area_org','var_codigo_postulacion'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-codigos-postulacion-sin-responsable.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: false
					    },
						valueField : 'srl_id_conv_area_org',
						fieldLabel : 'Plaza',
						name : 'srl_id_conv_area_org',
						displayField : 'var_codigo_postulacion',
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
