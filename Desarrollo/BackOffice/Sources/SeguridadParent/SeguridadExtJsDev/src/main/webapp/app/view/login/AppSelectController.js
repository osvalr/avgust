Ext.define('MyApp.view.login.AppSelectController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.appSelect',

	onSelectClick : function() {

		var me = this;
		if (me.lookupReference('form').isValid()) {
			me.doSelect();
		}
		
	},
	
	doSelect : function() {
		var me = this, form = me.lookupReference('form');
		
		var sb = Ext.getCmp('form_app_select_statusbar');
		sb.showBusy('Cargando aplicación...');
		var win = form.up('window');
		win.getEl().mask();
		
		form.submit({
			clientValidation : false,
			url : '/SeguridadWSRestApp/api/Autenticacion/setData',
			scope : me,
			success : 'onSelectSuccess',
			failure : 'onSelectFailure'
		});
	},
	
	onSelectFailure : function(form, action) {

	},
	
	onSelectSuccess : function(form, action) {
		
		var me = this, form = me.lookupReference('form');
		localStorage.setItem("isSelectApp", true);
		
		var on_field = form.getForm().findField('id_aplicacion');
		
    	Ext.Ajax.request({
    	    url: '/SeguridadWSRestApp/api/seguridad/aplicacionPorId',
    	    params: {
    	    	id_aplicacion: on_field.getValue()
    	    },
    	    success: function(response){
    	    	
    	    	var json = Ext.util.JSON.decode(response.responseText);
    	    	var pathApp = json.record.url_aplicacion+"?id_session="+localStorage.getItem('id_session');
    	    	localStorage.setItem("pathApp", pathApp);
    	    	location.href = pathApp;
    	    }
    	});

	},
	onLogOut: function () {
        
    	Ext.Ajax.request({
    	    url: '/SeguridadWSRestApp/api/Autenticacion/logOut',
    	    params: {
    	        id_session: localStorage.getItem('id_session')
    	    },
    	    success: function(response){
    	    	
    	        localStorage.removeItem('loggedIn');
    			localStorage.removeItem('id_usuario');
    			localStorage.removeItem('id_session');
    			localStorage.removeItem("isSelectApp");
    			localStorage.removeItem("pathApp");
    			
    	    }
    	});
    	
		this.getView().destroy();
		
		Ext.create({
            xtype: 'login'
        });
    }
});