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

Ext.define('MyApp.view.GestionarPlaza.PostulantePlazaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.PostulantePlazaQueryEdit',

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
                id: 'form_submodel_PostulantePlazaQuery',
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
						fieldLabel : 'srl_id_conv_area_org',
						name : 'srl_id_conv_area_org',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Nombres',
						name : 'nombres_completos',
						disabled : false,
						readOnly : true
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Tipo Documento',
						name : 'descrip_tipo_documento',
						disabled : false,
						readOnly : true
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Número Documento',
						name : 'numerodoc',
						disabled : false,
						readOnly : true
					}
					,{
					    allowBlank : false,
						xtype : 'numberfield',
						vtype : 'soloNumeros',
						hidden : false,
						editable : true,
						fieldLabel : 'Orden Mérito',
						name : 'int_orden_merito',
						minValue: 0,
					    maxValue: 100
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
								fields: ['var_cod_estado','var_nombre_estado'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-estados-postulantes.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
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
