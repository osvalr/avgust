Ext.define('MyApp.view.login.Login', {
    extend: 'Ext.window.Window',
    xtype: 'login',

    requires: [
        'MyApp.view.login.LoginController',
        'Ext.form.Panel',
        'Ext.ux.statusbar.StatusBar'
    ],

    controller: 'login',
    title: 'Sign In',
    iconCls:'icon-user_key',
    modal: true,
    		
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
            name: 'AccountID',
            fieldLabel: 'Account ID',
            allowBlank: false,
            listeners: {
                afterrender: function(field) {
                  field.focus();
                }
              }
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: 'Password',
            allowBlank: false
        }]

    },
		
	    initComponent: function() {
	    	
	        this.dockedItems = [{
	            xtype: 'toolbar',
	            dock: 'bottom',
	            items: ['->', {
	                text: 'Sign In',
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