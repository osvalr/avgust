Ext.define('MyApp.view.login.Login', {
    extend: 'Ext.window.Window',
    xtype: 'login',

    requires: [
        'MyApp.view.login.LoginController',
        'Ext.form.Panel',
        'Ext.ux.statusbar.StatusBar'
    ],

    controller: 'login',
    title: 'Iniciar Sesión',
    iconCls:'icon-user_key',
    closable: false,
    autoShow: true,

    items: {
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
        items: [{
            xtype: 'textfield',
            name: 'nombre_usuario',
            fieldLabel: 'Usuario',
            allowBlank: false,
            listeners: {
                afterrender: function(field) {
                  field.focus();
                }
              }
        }, {
            xtype: 'textfield',
            name: 'clave_usuario',
            inputType: 'password',
            fieldLabel: 'Clave',
            allowBlank: false
        }, {
            xtype: 'displayfield',
            hideEmptyLabel: false,
            value: 'Ingrese usuario y clave.'
        }]

    },
    initComponent: function() {

        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            items: ['->', {
                text: 'Ingresar',
                iconCls:'icon-door_in',
                formBind: true,
                listeners: {
                    click: 'onLoginClick'
                }
            }]
        },
            {
                xtype:'statusbar',
                dock: 'bottom',
                id: 'form_login_statusbar',
                clear: true
            }];

        this.callParent(arguments);
    }
});