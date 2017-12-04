Ext.define('MyApp.view.ServerInfo.GameServerList', {
    extend: 'Ext.grid.Panel',
    xtype: 'GameServerList',

    store : {
    	fields: [
    	         {name: 'nameServer', type: 'string'},
    	         {name: 'exp', type: 'string'},
    	         {name: 'drop', type: 'string'},
    	         {name: 'type', type: 'string'},
    	         {name: 'status', type: 'string'}
    	        ],
    	        data: [
    	               {nameServer: 'GS 1', exp:'100x', drop:'65%',  type:'PVP',  status:'Online'}
    	           ]
    },
    
    title: 'Game Server',
    iconCls:'icon-controller',
    initComponent: function () {
        var me = this;
        
        me.columns = [
            {
                text     : 'Name',
                flex     : 1,
                sortable : false,
                dataIndex: 'nameServer'
            },
            {
                text     : 'Exp',
                flex     : 1,
                sortable : false,
                dataIndex: 'exp'
            },
            {
                text     : 'Drop',
                flex     : 1,
                sortable : false,
                dataIndex: 'drop'
            },
            {
                text     : 'Type',
                flex     : 1,
                sortable : false,
                dataIndex: 'type'
            },
            {
                text     : 'Status',
                flex     : 1,
                sortable : false,
                dataIndex: 'status'
            }
        ];

		this.dockedItems = [

		       			 {
		       	            xtype: 'toolbar',
		       	            items: [
		       				            {
		       				            	iconCls:'icon-package_down',
		       				                text: 'Download Client',
		       				                handler: function(){
		       				                	window.open('https://mega.nz/#!SUgXkJrD!Bh0PInHDUtV1NxjDriWJ-BQXGpIOY2Mq2zrClAyyYN4', '_blank');
		       				                }
		       				            }
		       			           ]
		       	        }
		               ];
        
        me.callParent();
    }
});