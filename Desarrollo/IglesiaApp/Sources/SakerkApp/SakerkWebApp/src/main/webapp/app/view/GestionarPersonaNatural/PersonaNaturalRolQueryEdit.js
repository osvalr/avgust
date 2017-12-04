/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 03/12/2014 03:40:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPersonaNatural.PersonaNaturalRolQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.PersonaNaturalRolQueryEdit',

    requires: ['Ext.form.Panel'],

    title : '',
    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    width: 280,
    
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',
                
                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'left',
                    allowBlank: false,
                    combineErrors: true,
                    msgTarget: 'side'
                },

                items: [
					{
					    id : 'PersonaNaturalRolQuery_id_persona_natural_rol',
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'id_persona_natural_rol',
						fieldLabel : 'Id'
					}
					,{
					    id : 'PersonaNaturalRolQuery_id_persona_natural',
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'id_persona_natural',
						fieldLabel : 'id_persona_natural'
					}
					,{
					    id : 'PersonaNaturalRolQuery_id_rol',
						store : {
								fields: ['id_rol','nombre_rol'],
								proxy: {
							         type: 'ajax',
							         url: 'listarRolesCongregacion.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listRecords'
							         }
						    	},
								autoLoad: true
					    },
						queryMode : 'local',
						displayField : 'nombre_rol',
						hidden : false,
						xtype : 'combobox',
						name : 'id_rol',
						valueField : 'id_rol',
						emptyText : '-- Seleccione Opción --',
						fieldLabel : 'Rol'
					}
					,{
					    id : 'PersonaNaturalRolQuery_id_estado',
						store : {
								fields: ['valor_general','campo_a'],
								proxy: {
							         type: 'ajax',
							         url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Estado_Generico',
							         reader: {
							             type: 'json',
							             rootProperty: 'listRecords'
							         }
						    	},
								autoLoad: true
					    },
						allowBlank : true,
						queryMode : 'local',
						displayField : 'campo_a',
						hidden : false,
						xtype : 'combobox',
						name : 'id_estado',
						valueField : 'valor_general',
						emptyText : '-- Seleccione Opción --',
						fieldLabel : 'Estado'
					}
					,{
					    id : 'PersonaNaturalRolQuery_fecha_registro',
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'fecha_registro',
						fieldLabel : 'F.Registro'
					}
                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            id:'buttons_PersonaNaturalRolQuery',
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
