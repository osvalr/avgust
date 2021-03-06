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
* @since   14/09/2016 05:45:45
*/

Ext.define('MyApp.view.GestionarDocFactura.DocumentoFacturaDetalleQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.DocumentoFacturaDetalleQueryEdit',

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
                id: 'form_submodel_DocumentoFacturaDetalleQuery',
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
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'id_venta_item',
						name : 'id_venta_item',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'id_documento_venta',
						name : 'id_documento_venta',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Unidad medida',
						name : 'unidad_medida',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Codigo articulo',
						name : 'codigo_articulo',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Nombre articulo',
						name : 'nombre_articulo',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'numberfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Cantidad',
						name : 'cantidad_articulo',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						vtype : 'soloNumeroDecimales',
						editable : true,
						fieldLabel : 'Peso',
						name : 'peso_articulo',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						vtype : 'soloNumeroDecimales',
						editable : true,
						fieldLabel : 'Precio',
						name : 'precio_unitario',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : false,
						editable : false,
						fieldLabel : 'Total',
						name : 'importe_total',
						disabled : false,
						readOnly : true
					}
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						fieldLabel : 'Estado',
						name : 'id_estado',
						displayField : 'descrip_item',
						disabled : false,
						readOnly : false,
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
						valueField : 'valor_item'
					}
                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            //id:'buttons_DocumentoFacturaDetalleQuery',
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
