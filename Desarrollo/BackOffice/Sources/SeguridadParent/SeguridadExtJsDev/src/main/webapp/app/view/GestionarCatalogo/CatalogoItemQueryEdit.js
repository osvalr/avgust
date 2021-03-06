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

Ext.define('MyApp.view.GestionarCatalogo.CatalogoItemQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.CatalogoItemQueryEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 350,
    
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_CatalogoItemQuery',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',
                
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
						name : 'id_catalogo_item',
						fieldLabel : 'id_catalogo_item',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'id_catalogo',
						fieldLabel : 'id_catalogo',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : false,
						xtype : 'textfield',
						name : 'valor_item',
						fieldLabel : 'Valor',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : false,
						xtype : 'textfield',
						name : 'descrip_item',
						fieldLabel : 'Descripción',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : false,
						xtype : 'textfield',
						name : 'valor_a',
						fieldLabel : 'Valor A',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : false,
						xtype : 'textfield',
						name : 'valor_b',
						fieldLabel : 'Valor B',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : false,
						xtype : 'textfield',
						name : 'valor_c',
						fieldLabel : 'Valor C',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : false,
						xtype : 'textfield',
						name : 'valor_d',
						fieldLabel : 'Valor D',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : false,
						xtype : 'textfield',
						name : 'valor_e',
						fieldLabel : 'Valor E',
						disabled : false,
						editable : true
					}
                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            //id:'buttons_CatalogoItemQuery',
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
