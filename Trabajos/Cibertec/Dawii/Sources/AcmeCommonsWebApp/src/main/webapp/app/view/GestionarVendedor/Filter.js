Ext.define('AcmeWebApp.view.GestionarVendedor.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarVendedorFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarVendedor',
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
								fieldLabel : 'Nombres',
								name : 'nombres_completos',
								disabled : false,
								readOnly : false
							}
							,{
								queryMode : 'local',
								allowBlank : false,
								xtype : 'combobox',
								hidden : false,
								editable : false,
								readOnly : false,
								store : {
									fields: ['valor_b','valor_a'],
									proxy: {
										type: 'ajax',
										url: '/commons/ItemsByNameCatalogo?nameCataoglo=Doucmento_Identidad',
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
								fieldLabel : 'Tipo Documento',
								name : 'id_tipo_docu_iden',
								displayField : 'valor_a',
								disabled : false,
								value:''
							}

							,{
								allowBlank : true,
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Numero Documento',
								name : 'num_docu_iden',
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