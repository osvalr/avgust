Ext.define('MyApp.view.login.LoginController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.login',

	onLoginClick : function() {

		var me = this;
		if (me.lookupReference('form').isValid()) {
			me.doLogin();
		}
		
	},
	
	doLogin : function() {
		var me = this, form = me.lookupReference('form');
		
		var sb = Ext.getCmp('form_login_statusbar');
		sb.showBusy('Send...');
		var win = form.up('window');
		win.getEl().mask();
		
		form.submit({
			clientValidation : false,
			url : '/MuWSRestApp/api/Autenticacion/logIn',
			scope : me,
			success : 'onLoginSuccess',
			failure : 'onLoginFailure'
		});
	},
	
	onLoginFailure : function(form, action) {
		
		var result = Ext.JSON.decode(action.response.responseText, true);

		if (!result) {
			
			console.log(result);
		}

	},
	
	onLoginSuccess : function(form, action) {
		
		var me = this, form = me.lookupReference('form');
		
		var win = form.up('window');
		win.getEl().unmask();
		
		var sb = Ext.getCmp('form_login_statusbar');
		
		var result = Ext.JSON.decode(action.response.responseText, true);
		
		if(result.statusLogin == true){

			win.close();
			
			Ext.getCmp('center').removeAll(true,true);
		   	Ext.getCmp('center').add({xtype:'CharacterList'});

		}else{
			sb.clearStatus();
			sb.setStatus({
	            text: result.message
	        });
		}
		
	}
});