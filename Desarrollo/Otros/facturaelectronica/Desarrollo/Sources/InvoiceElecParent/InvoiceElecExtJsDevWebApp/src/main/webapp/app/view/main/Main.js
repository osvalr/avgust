/**
 * This class is the main view for the application. It is specified in app.js as the
 * "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */

Ext.define('MyApp.view.main.Main', {
    extend: 'Ext.panel.Panel',
    xtype: 'app-main',
    requires: [
               
        'MyApp.view.main.MainController',
        'Ext.layout.container.Border',
        'MyApp.view.main.Tree',
        'Ext.plugin.Viewport'
    ],
    
    controller: 'main', 
    
    layout: 'border',
    plugins: 'viewport',
    bodyBorder: false,
    
    defaults: {
        collapsible: true,
        split: true,
        bodyPadding: 0,
        autoScroll: true
    },
    
    items: [
		{
		    title: 'Emision Electronica App',
		    iconCls:'icon-layout',
		    region: 'north',
		    height: 72,
		    width : '100%',
		    autoScroll: false,
		    layout: {
		        type: 'hbox',
		        pack : 'end'
		    },
		    items: [
//                {
//                    xtype: 'toolbar-app'
//                }
            ]

		},
        {
            title: 'Menú principal',
            items: [
                    {
                        xtype: 'MenuTree'
                    }
                ],
            region:'west',
            floatable: false,
            width: 250,
            minWidth: 100,
            maxWidth: 250,
            iconCls:'icon-text_list_bullets'
        },
        {
        	id: 'center',
            collapsible: false,
            region: 'center',
            items: [
                ]
        }
    ]

});

