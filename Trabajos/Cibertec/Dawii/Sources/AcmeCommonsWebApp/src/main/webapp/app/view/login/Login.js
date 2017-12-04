/**
 * Created by JRaffo on 10/25/15.
 */
Ext.define('AcmeWebApp.view.login.Login', {
    extend: 'Ext.window.Window',
    xtype: 'login',

    requires: [
        'AcmeWebApp.view.login.LoginController',
        'Ext.form.Panel'
    ],

    controller: 'login',
    title: 'Iniciar Sesión',
    closable: false,
    autoShow: true,

    bodyPadding: 15,
    defaults: {
        xtype: 'textfield',
        anchor: '100%',
        labelWidth: 60
    },


    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
            xtype: 'textfield',
            name: 'username',
            fieldLabel: 'Username',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: 'Password',
            allowBlank: false
        }, {
            xtype: 'displayfield',
            hideEmptyLabel: false,
            value: 'Enter any non-blank password'
        }],
        buttons: [
            {
                text: 'Cancelar',
                iconCls: 'fa fa-times fa-lg'
            },
            {
                text: 'Ingresar',
                iconCls: 'fa fa-sign-in fa-lg',
                formBind: true,
                listeners: {
                    click: 'onLoginClick'
                }
            }
        ]
    }
});