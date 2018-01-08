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
* @since   01/03/2016 22:42:35
*/

Ext.define('MyApp.view.GestionarClienteJuridico.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarClienteJuridicoFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarClienteJuridico',
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
								name : 'id_persona',
								fieldLabel : 'Id',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'razon_social',
								fieldLabel : 'Razón Social',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'num_tipo_doc',
								fieldLabel : 'Número R.U.C',
								disabled : false,
								editable : true
							}
							,{
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