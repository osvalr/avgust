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
* @since   25/02/2016 20:09:25
*/

Ext.define('MyApp.view.GestionarCatalogo.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarCatalogoEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '65%',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarCatalogo',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información de Catalogo',
				                glyph:'xf022@FontAwesome',
				                
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
											    name : 'id_catalogo',
											    fieldLabel : 'Id Catalogo',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'nombre_catalogo',
											    fieldLabel : 'Nombre',
											    disabled : false,
											    editable : true
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
							

							,{
					    		title: 'Items de Catalogo',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_CatalogoItemQuery', xtype:'CatalogoItemQueryList'}]
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