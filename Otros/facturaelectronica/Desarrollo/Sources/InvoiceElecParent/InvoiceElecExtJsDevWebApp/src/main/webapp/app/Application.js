/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */

Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',
    
    name: 'MyApp',

    controllers:[
                 'MyApp.controller.GestionarFacturaElectronica.MainController',
                 'MyApp.controller.GestionarFacturaElectronica.FacturaDetalleWebQueryController',
                 'MyApp.controller.GestionarBoletaElectronica.MainController',
                 'MyApp.controller.GestionarBoletaElectronica.BoletaDetalleWebQueryController'
    ],
    
    stores: [
        
    ],
    
    views: [
            'MyApp.view.main.Main'
    ],
    
    init: function () {
 
    },   
        
    launch: function () {
    	        		
    }
});
