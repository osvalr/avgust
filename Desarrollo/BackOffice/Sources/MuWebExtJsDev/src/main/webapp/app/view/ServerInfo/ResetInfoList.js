Ext.define('MyApp.view.ServerInfo.ResetInfoList', {
    extend: 'Ext.grid.Panel',
    xtype: 'ResetInfoList',

    store : {
    	fields: [
    	         {name: 'level', type: 'string'},
    	         {name: 'zen', type: 'string'},
    	         {name: 'cleanInventory', type: 'string'},
    	         {name: 'cleanStats', type: 'string'},
    	         {name: 'points', type: 'string'}
    	        ],
    	        data: [
    	               {level: '400', zen:'80,000,000', cleanInventory:'No',  cleanStats:'Yes',  points:'250'}
    	           ]
    },
    
    title: 'Info Reset',
    iconCls:'icon-arrow_rotate_clockwise',
    initComponent: function () {
        var me = this;
        
        me.columns = [
            {
                text     : 'Level Required',
                flex     : 1,
                sortable : false,
                dataIndex: 'level'
            },
            {
                text     : 'Zen Required',
                flex     : 1,
                sortable : false,
                dataIndex: 'zen'
            },
            {
                text     : 'Clean Inventory',
                flex     : 1,
                sortable : false,
                dataIndex: 'cleanInventory'
            },
            {
                text     : 'Clean Stats',
                flex     : 1,
                sortable : false,
                dataIndex: 'cleanStats'
            },
            {
                text     : 'Points',
                flex     : 1,
                sortable : false,
                dataIndex: 'points'
            }
        ];

        me.callParent();
    }
});