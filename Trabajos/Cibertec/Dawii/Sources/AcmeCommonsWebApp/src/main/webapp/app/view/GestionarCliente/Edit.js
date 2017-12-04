Ext.define('AcmeWebApp.view.GestionarCliente.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarClienteEdit',

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
				                id: 'form_crud_GestionarCliente',
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
													data:[
														{valor_b: 2,    valor_a: 'P. Natural'},
														{valor_b: 3,    valor_a: 'Sociedad'}
													]
												},
												valueField : 'valor_b',
												fieldLabel : 'Tipo',
												name : 'id_sub_tipo_persona',
												displayField : 'valor_a',
												disabled : false,
												listeners : {
													change: function(field, newValue, oldValue) {

														var form = Ext.getCmp('form_crud_GestionarCliente');
														var nombres_completos = form.getForm().findField('nombres_completos');
														var ape_pater = form.getForm().findField('ape_pater');
														var ape_mater = form.getForm().findField('ape_mater');
														var fecha_nacimiento = form.getForm().findField('fecha_nacimiento');

														var razon_social = form.getForm().findField('razon_social');

														if(newValue === 2){

															nombres_completos.setHidden(false);
															nombres_completos.allowBlank = false;
															nombres_completos.clearInvalid();

															ape_pater.setHidden(false);
															ape_pater.allowBlank = false;
															ape_pater.clearInvalid();

															ape_mater.setHidden(false);
															ape_mater.allowBlank = false;
															ape_mater.clearInvalid();

															fecha_nacimiento.setHidden(false);
															fecha_nacimiento.allowBlank = false;
															fecha_nacimiento.clearInvalid();

															razon_social.setHidden(true);
															razon_social.allowBlank = true;
															razon_social.clearInvalid();

														}else{

															nombres_completos.setHidden(true);
															nombres_completos.allowBlank = true;
															nombres_completos.clearInvalid();

															ape_pater.setHidden(true);
															ape_pater.allowBlank = true;
															ape_pater.clearInvalid();

															ape_mater.setHidden(true);
															ape_mater.allowBlank = true;
															ape_mater.clearInvalid();

															fecha_nacimiento.setHidden(true);
															fecha_nacimiento.allowBlank = true;
															fecha_nacimiento.clearInvalid();

															razon_social.setHidden(false);
															razon_social.allowBlank = false;
															razon_social.clearInvalid();

														}

													}

												}
											}
											//,{
											//	queryMode : 'local',
											//	allowBlank : false,
											//	xtype : 'combobox',
											//	hidden : false,
											//	emptyText : '-- Seleccione Opción --',
											//	editable : false,
											//	readOnly : false,
											//	store : {
											//		fields: ['valor_b','valor_a'],
											//		proxy: {
											//			type: 'ajax',
											//			url: '/commons/ItemsByNameCatalogo?nameCataoglo=Doucmento_Identidad',
											//			reader: {
											//				type: 'json',
											//				rootProperty: 'list'
											//			}
											//		},
											//		autoLoad: true
											//	},
											//	valueField : 'valor_b',
											//	fieldLabel : 'Tipo Documento',
											//	name : 'id_tipo_docu_iden',
											//	displayField : 'valor_a',
											//	disabled : false
											//}
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
												hidden : true,
												editable : true,
												fieldLabel : 'Razón Social',
												name : 'razon_social',
												disabled : false,
												readOnly : false
											}
											,{
											    allowBlank : false,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Nombres',
											    name : 'nombres_completos',
											    disabled : false,
											    readOnly : false
											}
											,{
												allowBlank : false,
												xtype : 'textfield',
												hidden : true,
												editable : true,
												fieldLabel : 'Apellido Paterno',
												name : 'ape_pater',
												disabled : false,
												readOnly : false
											}
											,{
												allowBlank : false,
												xtype : 'textfield',
												hidden : true,
												editable : true,
												fieldLabel : 'Apellido Materno',
												name : 'ape_mater',
												disabled : false,
												readOnly : false
											}

											,{
												allowBlank : false,
												xtype : 'datefield',
												hidden : true,
												editable : true,
												fieldLabel : 'Fecha Nacimmiento',
												name : 'fecha_nacimiento',
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
            id: 'form_crud_GestionarCliente_statusbar'
        })];

        this.callParent(arguments);      
    }
});
