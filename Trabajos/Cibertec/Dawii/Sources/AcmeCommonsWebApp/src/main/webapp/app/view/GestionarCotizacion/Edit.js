Ext.define('AcmeWebApp.view.GestionarCotizacion.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarCotizacionEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 670,

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarCotizacion',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información de Cliente',
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
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Cod Cotizacion',
											    name : 'cod_cotizacion',
											    disabled : false,
											    readOnly : false
											}
											,{
												allowBlank : true,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Cliente',
												name : 'id_cliente',
												disabled : false,
												readOnly : true
											}
											,{
												allowBlank : true,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Vendedor',
												name : 'id_vendedor',
												disabled : false,
												readOnly : true
											}
											,{
												allowBlank : false,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Importe Total',
												name : 'importe_total',
												disabled : false,
												readOnly : false
											}

											,{
												queryMode : 'local',
												allowBlank : false,
												xtype : 'combobox',
												hidden : false,
												emptyText : '-- Seleccione Opción --',
												editable : false,
												readOnly : false,
												store : {
													fields: ['valor_b','valor_a'],
													proxy: {
														type: 'ajax',
														url: '/commons/ItemsByNameCatalogo?nameCataoglo=Estado_Generico',
														reader: {
															type: 'json',
															rootProperty: 'list'
														}
													},
													autoLoad: true
												},
												valueField : 'valor_b',
												fieldLabel : 'Estado',
												name : 'id_estado',
												displayField : 'valor_a',
												disabled : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    fieldLabel : 'tokenField',
											    name : 'tokenField'
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
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_GestionarCotizacion_statusbar'
        })];

        this.callParent(arguments);      
    }
});
