/**
 * This class is the main view for the application. It is specified in app.js as the
 * "autoCreateViewport" property. That setting automatically applies the "viewport"
 * plugin to promote that instance of this class to the body element.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('MyApp.view.main.Main', {
    extend: 'Ext.container.Container',
    requires: [
        'MyApp.view.main.MainController',
        'MyApp.view.main.MainModel',
        'MyApp.view.Menu.Tree'
    ],

    xtype: 'app-main',
    
    controller: 'main',
    viewModel: {
        type: 'main'
    },

    layout: {
        type: 'border'
    },

    items: [{
        xtype: 'MenuTree',
        bind: {
            title: 'Menú Principal'
        },
        region: 'west',
        width: 250,
        split: true,
        glyph:'xf009@FontAwesome'
    }//,
//    {
//    	xtype	:	"panel",
//    	region	:	"north",
//    	ui: 'navigation',
//    	bind: {
//            title: '{name}'
//        },
//    	height	:	70
//    }
    ,{
        id: 'center',
        region: 'center',
        layout: 'card',
        border: false,
        activeItem: 0,
        items: [
                {
                	id: 'GestionarCongregacionList',
                    xtype: 'GestionarCongregacionList'
                },
                {
                	id: 'GestionarCongregacionLocalList',
                    xtype: 'GestionarCongregacionLocalList'
                },
                {
                	id: 'GestionarPersonaNaturalList',
                    xtype: 'GestionarPersonaNaturalList'
                },
                {
                	id: 'GestionarTablaGeneralList',
                    xtype: 'GestionarTablaGeneralList'
                },
                {
                	id: 'GestionarPersonaJuridicaList',
                    xtype: 'GestionarPersonaJuridicaList'
                },
                {
                	id: 'GestionarEstudioList',
                    xtype: 'GestionarEstudioList'
                }
            ]
    }]
});
