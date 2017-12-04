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
* DATE CREATE : 19/04/2015 01:20:12
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarReqPersonal.ArchivoRequerimientoQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ArchivoRequerimientoQueryEdit',

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
                id: 'form_submodel_ArchivoRequerimientoQuery',
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
					    hidden : true,
						xtype : 'textfield',
						name : 'srl_id_archivo',
						fieldLabel : 'srl_id_archivo'
					}
					,{
						allowBlank : true,
					    xtype : 'textfield',
						name : 'srl_id_requerimiento_personal',
						fieldLabel : 'srl_id_requerimiento_personal',
						hidden : true
					}
					,{
					    xtype : 'textareafield',
						hidden : false,
						editable : true,
						fieldLabel : 'Descripcion',
						name : 'var_descripcion_archivo',
						disabled : false,
						readOnly : false,
						fieldStyle: 'text-transform:uppercase'
					}
					,{
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
						value: 'files_requerimiento',
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
