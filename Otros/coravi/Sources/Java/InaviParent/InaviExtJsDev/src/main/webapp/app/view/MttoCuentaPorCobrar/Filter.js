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
* @since   25/07/2016 19:41:32
*/

Ext.define('MyApp.view.MttoCuentaPorCobrar.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.MttoCuentaPorCobrarFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_MttoCuentaPorCobrar',
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
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : false,
								fieldLabel : 'Estado',
								name : 'id_estado',
								displayField : 'descrip_item',
								disabled : false,
								store : {
									fields: ['valor_item','descrip_item'],
									proxy: {
												type: 'ajax',
												url: '/SeguridadWSRestApp/api/catalogo/buscarPorNombre?nombre_catalogo=estado_generico',
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
								value : '',
								valueField : 'valor_item'
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Cliente',
								name : 'nombre_cliente',
								disabled : false
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});