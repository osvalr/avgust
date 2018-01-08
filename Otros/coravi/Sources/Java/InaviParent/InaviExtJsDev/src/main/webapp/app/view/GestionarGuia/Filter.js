/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   10/03/2016 00:37:53
*/

Ext.define('MyApp.view.GestionarGuia.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarGuiaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarGuia',
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
								hidden : false,
								xtype : 'textfield',
								name : 'id_guia',
								fieldLabel : 'Id',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'numberfield',
								name : 'num_anio',
								fieldLabel : 'Año',
								disabled : false,
								editable : true,
								value:new Date().getFullYear()
							}
							,{
								hidden : false,
								xtype : 'numberfield',
								name : 'num_mes',
								fieldLabel : 'Mes',
								disabled : false,
								editable : true,
								value:new Date().getMonth() + 1
							}
							,{
								hidden : false,
								xtype : 'numberfield',
								name : 'num_dia',
								fieldLabel : 'Dia',
								disabled : false,
								editable : true,
								value:new Date().getDate() 
							}
							,{
								store : {
									fields: ['valor_item','descrip_item'],
									proxy: {
												type: 'ajax',
												url: '/SeguridadWSRestApp/api/catalogo/buscarPorNombre?nombre_catalogo=tipo_producto',
												reader: {
													type: 'json',
													rootProperty: 'list'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { valor_item:'',descrip_item:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								queryMode : 'local',
								displayField : 'descrip_item',
								hidden : false,
								xtype : 'combobox',
								name : 'id_tipo_producto',
								value : '',
								valueField : 'valor_item',
								fieldLabel : 'Tipo Producto',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'nombre_cliente',
								fieldLabel : 'Cliente',
								disabled : false,
								editable : true
							}
						]
					}
					,{
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							{
								store : {
									fields: ['valor_item','descrip_item'],
									proxy: {
												type: 'ajax',
												url: '/SeguridadWSRestApp/api/catalogo/buscarPorNombre?nombre_catalogo=estado_guia_venta',
												reader: {
													type: 'json',
													rootProperty: 'list'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { valor_item:'',descrip_item:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								queryMode : 'local',
								displayField : 'descrip_item',
								hidden : false,
								xtype : 'combobox',
								name : 'id_estado',
								value : '',
								valueField : 'valor_item',
								fieldLabel : 'Estado',
								disabled : false,
								editable : false
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});