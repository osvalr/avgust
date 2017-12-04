Ext.define('MyApp.view.login.AppSelect', {
    extend: 'Ext.window.Window',
    xtype: 'appSelect',

    requires: [
        'MyApp.view.login.AppSelectController',
        'Ext.form.Panel',
        'Ext.ux.statusbar.StatusBar'
    ],

    controller: 'appSelect',
    title: 'Rol',
    iconCls:'icon-group',
    closable: false,
    autoShow: true,

    bbar:{
		xtype:'statusbar',
		id: 'form_app_select_statusbar',
        clear: true
	},

    listeners:{
        'show':function(win){
        	
        	var form = win.lookupReference('form');
        	var on_field = form.getForm().findField('id_aplicacion');
        	on_field.setDisabled(true);
    		on_field.store.removeAll();
    		on_field.store.reload({
    			params: {
    				id_usuario: localStorage.getItem('id_usuario')
    			}
    		});
    		on_field.setDisabled(false);
    		///
    		var id_session = form.getForm().findField('id_session');
    		id_session.setValue(localStorage.getItem('id_session'));
         }
    },


		initComponent: function() {

			this.items = [
				{
					xtype: 'form',
					reference: 'form',
					padding: '5 5 0 5',
					border: false,
					style: 'background-color: #fff;',
					header:false,
					fieldDefaults: {
						anchor: '100%',
						labelAlign: 'right',
						allowBlank: false,
						combineErrors: true,
						msgTarget: 'qtip',
						labelWidth: 80
					},
					items: [
						{
							xtype: 'textfield',
							name: 'id_session',
							allowBlank: false,
							hidden:true
						},
						{
							listeners : {
								change: function(field, newValue, oldValue) {

									var me = this;
									var form = me.up('form');
									var on_field = form.getForm().findField('id_rol');
									on_field.setDisabled(true);
									on_field.store.removeAll();
									on_field.store.reload({
										params: {
											id_aplicacion: field.getValue(),
											id_usuario: localStorage.getItem('id_usuario')
										}
									});
									on_field.setDisabled(false);
									if(oldValue != null){
										on_field.setValue('');
									}
								}
							},
							readOnly : false,
							allowBlank : false,
							store : {
								fields: ['id_aplicacion','nombre_aplicacion'],
								proxy: {
									type: 'ajax',
									url: '/SeguridadWSRestApp/api/seguridad/aplicacionPorUsuario',
									reader: {
										type: 'json',
										rootProperty: 'list'
									}
								},
								autoLoad: false
							},
							queryMode : 'local',
							displayField : 'nombre_aplicacion',
							hidden : false,
							xtype : 'combobox',
							name : 'id_aplicacion',
							valueField : 'id_aplicacion',
							emptyText : '-- Seleccione Opción --',
							fieldLabel : 'Aplicación',
							disabled : false,
							editable : false
						},
						{
							readOnly : false,
							allowBlank : false,
							store : {
								fields: ['id_rol','nombre_rol'],
								proxy: {
									type: 'ajax',
									url: '/SeguridadWSRestApp/api/seguridad/rolPorUsuarioAplicacion',
									reader: {
										type: 'json',
										rootProperty: 'list'
									}
								},
								autoLoad: false
							},
							queryMode : 'local',
							displayField : 'nombre_rol',
							hidden : false,
							xtype : 'combobox',
							name : 'id_rol',
							valueField : 'id_rol',
							emptyText : '-- Seleccione Opción --',
							fieldLabel : 'Rol',
							disabled : false,
							editable : false
						}
					]

				}
			];

			this.dockedItems = [{
				xtype: 'toolbar',
				dock: 'bottom',
				items: ['->',
					{
						text: 'Ingresar',
						iconCls:'icon-door_in',
						formBind: true,
						listeners: {
							click: 'onSelectClick'
						}
					},
					{
						text: 'Salir',
						iconCls:'icon-door_out',
						listeners: {
							click: 'onLogOut'
						}
					}
				]
			}];

			this.callParent(arguments);

    }
});