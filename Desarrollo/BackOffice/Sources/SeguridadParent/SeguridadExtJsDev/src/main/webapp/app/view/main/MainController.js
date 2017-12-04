Ext.define('MyApp.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    onLogOut: function () {
        
    	var me = this;
    	
    	me.splashscreen = Ext.getBody().mask('Cerrando Sesión', 'splashscreen');
    	
    	Ext.Ajax.request({
    	    url:  '/SeguridadWSRestApp/api/Autenticacion/logOut',
    	    params: {
    	    	id_session: localStorage.getItem('id_session')
    	    },
    	    success: function(response){
    	    	
    	        localStorage.removeItem('loggedIn');
    			localStorage.removeItem('id_usuario');
    			localStorage.removeItem('id_session');
    			localStorage.removeItem("isSelectApp");
    			localStorage.removeItem("pathApp");
    			
    			me.getView().destroy();
    			
    			Ext.create({
    	            xtype: 'login'
    	        });
    			
    	    }
    	});
    	
		
    	
    },
    onChangeApp: function () {
    	
    	localStorage.removeItem("isSelectApp");
        
    	this.getView().destroy();
    	
    	Ext.create({
            xtype: 'appSelect'
        });
    }
});