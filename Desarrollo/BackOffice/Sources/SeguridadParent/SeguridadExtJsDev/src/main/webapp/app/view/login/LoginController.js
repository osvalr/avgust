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
		sb.showBusy('Ingresando...');
		var win = form.up('window');
		win.getEl().mask();
		
		form.submit({
			clientValidation : false,
			url : '/SeguridadWSRestApp/api/Autenticacion/logIn',
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
			localStorage.setItem("loggedIn", true);
			localStorage.setItem("id_usuario", result.id_usuario);
			localStorage.setItem("id_session", result.id_session);

			this.getView().destroy();

			Ext.create({
				xtype : 'appSelect'
			});
		}else{
			sb.clearStatus();
			sb.setStatus({
	            text: result.message
	        });
		}
		
	}
});