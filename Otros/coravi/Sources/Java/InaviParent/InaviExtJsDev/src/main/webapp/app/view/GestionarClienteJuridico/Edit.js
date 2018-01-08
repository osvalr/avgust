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

Ext.define('MyApp.view.GestionarClienteJuridico.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarClienteJuridicoEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 350,

    iconCls:'icon-pencil',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarClienteJuridico',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información de Cliente',
//				                glyph:'xf022@FontAwesome',
				                
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
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'id_persona',
											    fieldLabel : 'Id',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'razon_social',
											    fieldLabel : 'Razón Social',
											    maxLength: 250,
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    hidden : false,
											    xtype : 'textfield',
											    vtype: 'numeroRuc',
											    name : 'num_tipo_doc',
											    fieldLabel : 'Número R.U.C',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
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
											    	autoLoad: true
											    },
											    queryMode : 'local',
											    displayField : 'descrip_item',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'id_estado',
											    valueField : 'valor_item',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Estado',
											    disabled : false,
											    editable : false
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'tokenField',
											    fieldLabel : 'tokenField'
											}
										]
							}
							


                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            //id:'buttons',
            ui: 'footer',
            items: ['->', {
            	iconCls:'icon-disk_black',
                itemId: 'save',
                text: 'Grabar',
                action: 'save'
            },{
            	iconCls:'icon-cross',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);      
    }
});
