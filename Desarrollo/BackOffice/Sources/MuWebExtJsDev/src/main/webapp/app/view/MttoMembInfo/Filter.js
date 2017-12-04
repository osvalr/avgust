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
* @since   29/03/2016 22:54:29
*/

Ext.define('MyApp.view.MttoMembInfo.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.MttoMembInfoFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_MttoMembInfo',
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
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Usuario',
								name : 'memb___id',
								disabled : false
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Nombres',
								name : 'nombres_completos',
								disabled : false
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : false,
								fieldLabel : 'Genero',
								name : 'gender',
								displayField : 'descrip_gender',
								disabled : false,
								store : {
									fields: ['id_gender','descrip_gender'],
									proxy: {
												type: 'ajax',
												url: '/MuWSRestApp/api/common/generos',
												reader: {
													type: 'json',
													rootProperty: 'list'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { id_gender:'',descrip_gender:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'id_gender',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : false,
								fieldLabel : 'Pais',
								name : 'country',
								displayField : 'nombre',
								disabled : false,
								store : {
									fields: ['id_pais','nombre'],
									proxy: {
												type: 'ajax',
												url: '/MuWSRestApp/api/common/paises',
												reader: {
													type: 'json',
													rootProperty: 'list'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { id_pais:'',nombre:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'id_pais',
								value : ''
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});