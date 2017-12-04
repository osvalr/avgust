/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 */
Ext.define('MyApp.Application', {
    extend: 'Ext.app.Application',
    
    name: 'MyApp',

    stores: [
        // TODO: add global / shared stores here
//        'GestionarTablaGeneral.MainStore'
    ],
    controllers: [
                  'MyApp.controller.GestionarPersonaNatural.MainController',
                  'MyApp.controller.GestionarPersonaNatural.NumeroTelefonicoQueryController',
                  'MyApp.controller.GestionarPersonaNatural.InformacionAcademicaQueryController',
                  'MyApp.controller.GestionarPersonaNatural.InformacionLaboralQueryController',
                  'MyApp.controller.GestionarPersonaNatural.InformacionEclesiasticaQueryController',
                  'MyApp.controller.GestionarPersonaNatural.PersonaNaturalParentescoQueryController',
                  'MyApp.controller.GestionarPersonaNatural.PersonaNaturalRolQueryController',
                  'MyApp.controller.GestionarTablaGeneral.MainController',
                  'MyApp.controller.GestionarTablaGeneral.TablaGeneralDetalleQueryController',
                  'MyApp.controller.GestionarCongregacion.MainController',
                  'MyApp.controller.GestionarCongregacionLocal.MainController',
                  'MyApp.controller.GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryController',
                  'MyApp.controller.GestionarPersonaJuridica.MainController',
                  'MyApp.controller.GestionarEstudio.MainController',
                  'MyApp.controller.RegistrarItemTablaGeneral.MainController',
                  'MyApp.controller.RegistrarPersonaJuridica.MainController',
                  'MyApp.controller.RegistrarEstudio.MainController'
              ],
    
    launch: function () {
	    var  me = this;
//	    var ct = Ext.fly('cmp-ct') || Ext.getBody();
//		
//	    Ext.widget(component,{
//	         renderTo:ct
//	    });
    }
});
