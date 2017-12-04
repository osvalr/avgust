/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */

Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',
    
    name: 'MyApp',

    controllers:[
                    'MyApp.controller.GestionarAplicacion.MainController',
                    'MyApp.controller.GestionarAplicacion.PerfilAplicacionSubCrudController',
                    'MyApp.controller.GestionarCatalogo.MainController',
                    'MyApp.controller.GestionarCatalogo.CatalogoItemQueryController',
                    'MyApp.controller.GestionarFuncionalidad.MainController',
                    'MyApp.controller.GestionarFuncionalidad.FuncionalidadRolSubCrudController',
                    'MyApp.controller.GestionarPerfil.MainController',
                    'MyApp.controller.GestionarRol.MainController',
                    'MyApp.controller.GestionarUsuario.MainController',
                    'MyApp.controller.GestionarUsuario.UsuarioPerfilSubCrudController',
                    'MyApp.controller.GestionarUsuarioRol.MainController'
             ],
    
    stores: [
        
    ],
    
    views: [
            'MyApp.view.login.Login',
            'MyApp.view.login.AppSelect',
            'MyApp.view.main.Main'
        ],

        
    init: function () {
        if (Ext.get('page-loader')) {
            Ext.get('page-loader').remove();
        }
    },        
        
    launch: function () {
    	
    	var me = this;

        me.validLogin();
        
    },
    
    validLogin: function () {
    	
        var loggedIn;

        loggedIn = localStorage.getItem("loggedIn");
        isSelectApp = localStorage.getItem("isSelectApp");
        pathApp = localStorage.getItem("pathApp");
        
        if(loggedIn){
        	if(isSelectApp){
        		
        		var pathname = window.location.pathname;
        		
        		if(pathApp.indexOf(pathname) > -1){
        			Ext.create({
                        xtype: 'app-main'
                    });
        		}else{
        			window.location.assign(pathApp);
        		}
        		
        	}else{
        		
        		Ext.create({
                    xtype: 'appSelect'
                });
        		
        	}
        }else{
        	Ext.create({
                xtype: 'login'
            });
        }
        
    }
});
