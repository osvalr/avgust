/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
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
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
 * GENERATOR CRUD EXT JS 5 BY FOCUS CONSULTORES ASOCIADOS SAC 
 * DATE CREATE : 09/11/2014 02:30:50 
 * VERSION : 1.0
 */

Ext.define('AcmeWebApp.view.GestionarProducto.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarProductoFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarProducto',
	layout: {
        type: 'vbox'
    },
    fieldDefaults: {
        labelAlign: 'top',
        margin: "0 5 5 5"
    },
                                
    initComponent: function() {
    
    	var form = this;
    
        this.items = [
                {
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							{
								allowBlank : false,
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Nombre',
								name : 'nombre',
								disabled : false,
								readOnly : false
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
									fields: ['valor_b','valor_a'],
									proxy: {
										type: 'ajax',
										url: '/commons/ItemsByNameCatalogo?nameCataoglo=Categoria_Producto',
										reader: {
											type: 'json',
											rootProperty: 'list'
										}
									},
									autoLoad: true,
									listeners: {
										load: function(store) {
											var rec = { valor_b:'',valor_a:'-- Todos --' };
											store.insert(0, rec);
										}
									}
								},
								valueField : 'valor_b',
								fieldLabel : 'Categoria',
								name : 'id_categoria',
								displayField : 'valor_a',
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
									fields: ['valor_b','valor_a'],
									proxy: {
										type: 'ajax',
										url: '/commons/ItemsByNameCatalogo?nameCataoglo=Divisa',
										reader: {
											type: 'json',
											rootProperty: 'list'
										}
									},
									autoLoad: true,
									listeners: {
										load: function(store) {
											var rec = { valor_b:'',valor_a:'-- Todos --' };
											store.insert(0, rec);
										}
									}
								},
								valueField : 'valor_b',
								fieldLabel : 'Moneda',
								name : 'id_moneda',
								displayField : 'valor_a',
								disabled : false
							}
						,{
							queryMode : 'local',
							xtype : 'combobox',
							hidden : false,
							editable : false,
							readOnly : false,
							store : {
								fields: ['valor_b','valor_a'],
								proxy: {
									type: 'ajax',
									url: '/commons/ItemsByNameCatalogo?nameCataoglo=Estado_Generico',
									reader: {
										type: 'json',
										rootProperty: 'list'
									}
								},
								autoLoad: true,
								listeners: {
									load: function(store) {
										var rec = { valor_b:'',valor_a:'-- Todos --' };
										store.insert(0, rec);
									}
								}
							},
							valueField : 'valor_b',
							fieldLabel : 'Estado',
							name : 'id_estado',
							displayField : 'valor_a',
							disabled : false,
							value:''
						}
						]
					}
        ];

        this.callParent(arguments);
    }
});