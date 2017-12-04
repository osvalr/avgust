/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */

Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',
    
    name: 'MyApp',

    controllers:[
                 'MyApp.controller.MttoMembInfo.MainController',
                 'MyApp.controller.Character.MainController'
             ],
    
    stores: [
        
    ],
    
    views: [
            'MyApp.view.login.Login',
            'MyApp.view.main.Main'
//            'MyApp.view.main.MainContainer'
        ],

        
    init: function () {
    },        
        
    launch: function () {
    	
        var customVTypes = Ext.create('MyApp.CustomVTypes');
        customVTypes.loadVTypes();
    	
//		Ext.create({
//            xtype: 'app-main'
//        });

		var ct = Ext.fly('app-container') || Ext.getBody();

		Ext.widget('app-main', {
			renderTo : ct
		});
	   	   
    }
});
