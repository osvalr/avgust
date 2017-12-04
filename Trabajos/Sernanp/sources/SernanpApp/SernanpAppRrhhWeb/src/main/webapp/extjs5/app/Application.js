/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 */
Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',
    requires : ['MyApp.CustomVTypes'],
   
    name: 'MyApp',

    stores: [
    
    ],
    
    controllers: [

              ],
    
    launch: function () {
    	
    	var arrayLength = controllerNames.length;
    	
    	//Agregamos los controles dinamicamente
    	for (var i = 0; i < arrayLength; i++) {
    		 // See if the controller was already loaded
	   	     var iController = this.controllers.get(controllerNames[i]);
	   	
	   	     // If the controller was never loaded before
	   	     if ( !iController )
	   	     {    
	   	         // Dynamically load the controller
	   	         var iController = this.getController(controllerNames[i]);
	   	     }
    	}
    	
       var customVTypes = Ext.create('MyApp.CustomVTypes');
       customVTypes.loadVTypes();

   	   var ct = Ext.fly('cmp-ct') || Ext.getBody();
   	
   	   Ext.widget(component,{
   	        renderTo:ct
   	   });
    }
});
