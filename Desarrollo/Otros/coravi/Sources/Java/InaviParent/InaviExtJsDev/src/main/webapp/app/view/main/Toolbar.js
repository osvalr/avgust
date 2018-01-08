/**
 * This example demonstrates the Toolbar's two different modes of handling overflow:
 *
 * - "menu": buttons that don't fit on the toolbar are rendered into an overflow menu
 * - "scroller": scroller buttons are rendered on either side of the toolbar for scrolling
 * overflowing items into view.
 */
Ext.define('MyApp.view.main.Toolbar', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.toolbar-app',

    layout: 'fit',
    width : '100%',
    height : '100%',
    initComponent: function() {
        var items = [
        '->',         
//        {
//			xtype : 'label',
//			text : 'Bienvenido: { Usuario: jraffo, Rol: Analista Programador }',
//			style: 'font-weight:bold'
//		},
		{
			xtype : 'button',
            text: 'Aplicacines',
            iconCls:'icon-application_cascade',
            handler: 'onChangeApp'
        },
        {
        	xtype : 'button',
            text: 'Salir',
            iconCls:'icon-door_out',
            handler: 'onLogOut'
        }
         
    ];

        

        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'top',
            width : '100%',
            height : '100%',
            padding: "10 0 10 5",  // Same as CSS ordering (top, right, bottom, left)
            items: items
        }];

        this.callParent();
    }
});