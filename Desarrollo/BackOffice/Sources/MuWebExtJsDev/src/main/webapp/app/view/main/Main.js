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
//        'Ext.plugin.Viewport',
        'MyApp.view.ServerInfo.Info',
        'MyApp.view.Statistic.CharactersForResetsList',
        'MyApp.view.Statistic.CharactersOnlineList',
        'MyApp.view.Statistic.GuildsForScoreList'
    ],
    
    controller: 'main', 
    
    layout: 'border',
//    plugins: 'viewport',
    height:'90%',
    bodyBorder: false,
//    border: 1,
    style: {
//    			borderColor:'#000000', 
//    			borderStyle:'solid', 
//    			borderWidth:'1px', 
    			position: 'absolute',
    			left:'1%',
    			right:'45%',
    			top:'5%'
    },
    defaults: {
        collapsible: true,
        split: true,
        bodyPadding: 0,
        autoScroll: true
    },
    
    items: [
		{
		    title: 'Anker Mu',
		    iconCls:'icon-shield',
		    region: 'north',
		    height: 28,
		    layout: {
		        type: 'hbox',
		        pack : 'end'
		    },
		    bodyPadding: 5
		},
        {
            title: 'Main Menu',
            items: [
                    {
                        xtype: 'MenuTree'
                    }
                ],
            region:'west',
            floatable: false,
            width: 222,
            minWidth: 100,
            maxWidth: 258,
            iconCls:'icon-text_list_bullets'
        },
        {
        	id: 'center',
            collapsible: false,
            region: 'center',
            items: [
                    {
                    	xtype:'ServerInfo'
                    }
                    ]
        }
    ]

});