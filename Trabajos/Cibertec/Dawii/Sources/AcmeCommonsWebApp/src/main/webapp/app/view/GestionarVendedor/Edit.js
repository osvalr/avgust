Ext.define('AcmeWebApp.view.GestionarVendedor.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarVendedorEdit',

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
				                id: 'form_crud_GestionarVendedor',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información de Vendedor',
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
											    fieldLabel : 'Id',
											    name : 'id_persona',
											    disabled : false,
											    readOnly : false
											}
											,{
												allowBlank : true,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Código',
												name : 'cod_persona',
												disabled : false,
												readOnly : true
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
														url: '/commons/ItemsByNameCatalogo?nameCataoglo=Doucmento_Identidad',
														reader: {
															type: 'json',
															rootProperty: 'list'
														}
													},
													autoLoad: true
												},
												valueField : 'valor_b',
												fieldLabel : 'Tipo Documento',
												name : 'id_tipo_docu_iden',
												displayField : 'valor_a',
												disabled : false
											}
											,{
												allowBlank : false,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Numero Documento',
												name : 'num_docu_iden',
												disabled : false,
												readOnly : false
											}

											,{
											    allowBlank : false,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Nombres',
											    name : 'nombres_completos',
											    disabled : false,
											    readOnly : false
											}
											,{
												allowBlank : false,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Apellido Paterno',
												name : 'ape_pater',
												disabled : false,
												readOnly : false
											}
											,{
												allowBlank : false,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Apellido Materno',
												name : 'ape_mater',
												disabled : false,
												readOnly : false
											}

											,{
												allowBlank : true,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Correo',
												name : 'correo',
												disabled : false,
												readOnly : false
											}
											,{
												allowBlank : true,
												xtype : 'textareafield',
												hidden : false,
												editable : true,
												fieldLabel : 'Dirección',
												name : 'direccion',
												disabled : false,
												readOnly : false
											}
											,{
												allowBlank : true,
												xtype : 'textfield',
												hidden : false,
												editable : true,
												fieldLabel : 'Telefono',
												name : 'telefono',
												disabled : false,
												readOnly : false
											}
											,{
												allowBlank : true,
												xtype : 'textareafield',
												hidden : false,
												editable : true,
												fieldLabel : 'Sucursal',
												name : 'sucursal',
												disabled : false,
												readOnly : false
											}
									,{
										allowBlank : true,
										xtype : 'textfield',
										hidden : false,
										editable : true,
										fieldLabel : 'Usuario',
										name : 'usuario',
										disabled : false,
										readOnly : false
									}
									,{
										allowBlank : true,
										xtype : 'textfield',
										inputType: 'password',
										hidden : false,
										editable : true,
										fieldLabel : 'Clave',
										name : 'clave',
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
            id: 'form_crud_GestionarVendedor_statusbar'
        })];

        this.callParent(arguments);      
    }
});
