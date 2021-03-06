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
* @since   27/02/2016 15:19:09
*/

Ext.define('MyApp.view.GestionarUsuarioRol.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarUsuarioRolFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarUsuarioRol',
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
								name : 'nombre_usuario',
								fieldLabel : 'Usuario',
								disabled : false,
								editable : true
							}
							,{
								listeners : {
									change: function(field, newValue, oldValue) {

										var on_field = form.getForm().findField('id_rol');
										on_field.setDisabled(true);
										on_field.store.removeAll();
										on_field.store.reload({
											params: {
												id_aplicacion: field.getValue()
											}
										});
										on_field.setDisabled(false);
										if(oldValue != null){
											on_field.setValue('');
										}
									}
								},
								store : {
									fields: ['id_aplicacion','nombre_aplicacion'],
									proxy: {
												type: 'ajax',
												url: '/AcmeCommonWebApp/common/seguridad/appPorNombre',
												reader: {
													type: 'json',
													rootProperty: 'list'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { id_aplicacion:'',nombre_aplicacion:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								queryMode : 'local',
								displayField : 'nombre_aplicacion',
								hidden : false,
								xtype : 'combobox',
								name : 'id_aplicacion',
								value : '',
								valueField : 'id_aplicacion',
								fieldLabel : 'Aplicación',
								disabled : false,
								editable : true
							}
							,{
								store : {
									fields: ['id_rol','nombre_rol'],
									proxy: {
												type: 'ajax',
												url: '/AcmeCommonWebApp/common/seguridad/rolPorAplicacion',
												reader: {
													type: 'json',
													rootProperty: 'list'
												}
									},
									autoLoad: false,
									listeners: {
								        load: function(store) {
								        	var rec = { id_rol:'',nombre_rol:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								queryMode : 'local',
								displayField : 'nombre_rol',
								hidden : false,
								xtype : 'combobox',
								name : 'id_rol',
								value : '',
								valueField : 'id_rol',
								fieldLabel : 'Rol',
								disabled : false,
								editable : true
							}
							,{
								store : {
									fields: ['valor_item','descrip_item'],
									proxy: {
												type: 'ajax',
												url: '/AcmeCommonWebApp/common/catalogo/buscarPorNombre?nombre_catalogo=estado_generico',
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