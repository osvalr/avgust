/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('AcmeWebApp.Application', {
    extend: 'Ext.app.Application',
    
    name: 'AcmeWebApp',

    stores: [
        // TODO: add global / shared stores here
    ],

    controllers:[
        'AcmeWebApp.controller.GestionarProducto.MainController',
        'AcmeWebApp.controller.GestionarCliente.MainController',
        'AcmeWebApp.controller.GestionarVendedor.MainController',
        'AcmeWebApp.controller.GestionarCotizacion.MainController'
    ],

    launch: function () {
        // TODO - Launch the application
        var me = this;
        var task = new Ext.util.DelayedTask(function() {
            //Fade out the body mask
            me.splashscreen.fadeOut({
                duration: 1000,
                remove:true
            });
            //Fade out the icon and message
            me.splashscreen.next().fadeOut({
                duration: 500,
                remove:true,
                listeners: { // #1
                    afteranimate: function(el, startTime, eOpts ){//#2

                        // It's important to note that this type of application could use
                        // any type of storage, i.e., Cookies, LocalStorage, etc.
                        var loggedIn;

                        // Check to see the current value of the localStorage key
                        loggedIn = localStorage.getItem("TutorialLoggedIn");

                        // This ternary operator determines the value of the TutorialLoggedIn key.
                        // If TutorialLoggedIn isn't true, we display the login window,
                        // otherwise, we display the main view
                        Ext.create({
                            xtype: loggedIn ? 'app-main' : 'login',autoShow: true
                        });

                        //Ext.create({ xtype: 'app-main',renderTo : Ext.getBody() }); // #3


                    } }
            }); });
        task.delay(500);
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
