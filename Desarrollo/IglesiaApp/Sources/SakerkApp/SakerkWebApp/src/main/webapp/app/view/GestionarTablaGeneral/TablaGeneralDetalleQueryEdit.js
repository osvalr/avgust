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
* DATE CREATE : 01/12/2014 19:55:03
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarTablaGeneral.TablaGeneralDetalleQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.TablaGeneralDetalleQueryEdit',

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
					    id : 'TablaGeneralDetalleQuery_id_tabla_general_detalle',
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'id_tabla_general_detalle',
						fieldLabel : 'id_tabla_general_detalle'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_id_tabla_general',
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'id_tabla_general',
						fieldLabel : 'id_tabla_general'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_valor_general',
						hidden : false,
						xtype : 'textfield',
						name : 'valor_general',
						fieldLabel : 'Valor'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_campo_a',
						maxLength : 500,
						minLength : 1,
						hidden : false,
						xtype : 'textfield',
						name : 'campo_a',
						fieldLabel : 'Campo A'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_campo_b',
						allowBlank : true,
						maxLength : 500,
						minLength : 1,
						hidden : false,
						xtype : 'textfield',
						name : 'campo_b',
						fieldLabel : 'Campo B'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_campo_c',
						allowBlank : true,
						maxLength : 500,
						minLength : 1,
						hidden : false,
						xtype : 'textfield',
						name : 'campo_c',
						fieldLabel : 'Campo C'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_campo_d',
						allowBlank : true,
						maxLength : 500,
						minLength : 1,
						hidden : false,
						xtype : 'textfield',
						name : 'campo_d',
						fieldLabel : 'Campo D'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_campo_e',
						allowBlank : true,
						maxLength : 500,
						minLength : 1,
						hidden : false,
						xtype : 'textfield',
						name : 'campo_e',
						fieldLabel : 'Campo E'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_id_estado',
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
					    id : 'TablaGeneralDetalleQuery_descrip_estado',
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'descrip_estado',
						fieldLabel : 'Estado'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_orden',
						allowBlank : true,
						hidden : false,
						xtype : 'textfield',
						name : 'orden',
						fieldLabel : 'Orden'
					}
					,{
					    id : 'TablaGeneralDetalleQuery_fecha_registro',
						allowBlank : true,
						hidden : true,
						xtype : 'datefield',
						name : 'fecha_registro',
						format : 'd/m/Y',
						fieldLabel : 'F.Registro'
					}
                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            id:'buttons_TablaGeneralDetalleQuery',
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
