Ext.define('AcmeWebApp.view.GestionarCotizacion.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarCotizacionFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarCotizacion',
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
								allowBlank : true,
								xtype : 'textfield',
								hidden : false,
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
								fieldLabel : 'N. Vendedor',
								name : 'nombres_cliente',
								disabled : false,
								readOnly : false
							}

							,{
								allowBlank : true,
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'N. Cliente',
								name : 'nombres_vendedor',
								disabled : false,
								readOnly : false
							}

							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
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
									autoLoad: true,
									listeners: {
										load: function(store) {
											var rec = { valor_b:'',valor_a:'-- Todos --' };
											store.insert(0, rec);
										}
									}
								},
								valueField : 'valor_b',
								fieldLabel : 'Estado',
								name : 'id_estado',
								displayField : 'valor_a',
								disabled : false,
								value:''
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});