/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */

Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',
    
    name: 'MyApp',

    controllers:[
                 'MyApp.controller.GestionarClienteJuridico.MainController',
                 'MyApp.controller.GestionarClienteNatural.MainController',
                 'MyApp.controller.GestionarGuia.MainController',
                 'MyApp.controller.GestionarGuia.GuiaPesoQueryController',
                 'MyApp.controller.GestionarGuiaCompra.MainController',
                 'MyApp.controller.GestionarGuiaCompra.GuiaPesoCompraQueryController',
                 'MyApp.controller.GestionarJornada.MainController',
                 'MyApp.controller.GestionarProveedores.MainController',
                 'MyApp.controller.GestionarSaldo.MainController',
                 'MyApp.controller.GestionarSaldo.GuiaSaldoQueryController',
                 'MyApp.controller.MttoSaldo.MainController',
                 'MyApp.controller.MttoSaldo.GuiaSaldoQueryController',
                 'MyApp.controller.MttoCuentaPorCobrar.MainController',
                 'MyApp.controller.MttoCuentaPorCobrar.CuentaAmortizacionQueryController',
                 'MyApp.controller.GestionarDocFactura.MainController',
                 'MyApp.controller.GestionarDocFactura.DocumentoFacturaDetalleQueryController'
    ],
    
    stores: [
        
    ],
    
    views: [
            'MyApp.view.main.Main'
    ],
    
    init: function () {
        if (Ext.get('page-loader')) {
            Ext.get('page-loader').remove();
        }
    },   
        
    launch: function () {
    	
    	var me = this;
    	
    	Ext.enableAriaButtons = false;
    	
        var customVTypes = Ext.create('MyApp.CustomVTypes');
        customVTypes.loadVTypes();
    	
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
        		
        		window.location.assign(hostSeguridadExtJsApp);
        		
        	}
        }else{
        	window.location.assign(hostSeguridadExtJsApp);
        }

        
    }
});
