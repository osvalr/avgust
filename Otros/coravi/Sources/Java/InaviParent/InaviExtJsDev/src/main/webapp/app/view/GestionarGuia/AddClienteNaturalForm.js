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
* @since   01/03/2016 22:17:48
*/

Ext.define('MyApp.view.GestionarGuia.AddClienteNaturalForm', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarGuiaAddClienteNaturalForm',

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
				                id: 'form_AddClienteNaturalForm',
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
											    name : 'nombres',
											    fieldLabel : 'Nombres',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'ape_pater',
											    fieldLabel : 'Apellido Paterno',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'ape_mater',
											    fieldLabel : 'Apellido Materno',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    store : {
											    	fields: ['valor_item','descrip_item'],
											    	proxy: {
											    		type: 'ajax',
											    		url: '/SeguridadWSRestApp/api/catalogo/buscarPorNombre?nombre_catalogo=tipo_documento_identidad',
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
											    name : 'id_tipo_doc',
											    valueField : 'valor_item',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Tipo Documento',
											    disabled : false,
											    editable : false
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'num_tipo_doc',
											    fieldLabel : 'Numero Documento',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'datefield',
											    name : 'fecha_nacimiento',
											    fieldLabel : 'Fecha Nacimiento',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'email',
											    vtype : 'email',
											    fieldLabel : 'Email',
											    disabled : false,
											    editable : true
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
                action: 'saveClienteNatural'
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
