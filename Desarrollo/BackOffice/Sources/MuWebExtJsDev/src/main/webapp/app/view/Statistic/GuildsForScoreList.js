/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   29/03/2016 22:54:29
*/

Ext.define('MyApp.view.Statistic.GuildsForScoreList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GuildsForScoreList',
    
    iconCls:'icon-shield_silver',

    title : 'Guilds Ranking',
    
    store : Ext.create('Ext.data.Store', {
    	
    	fields: [
    	         {name: 'rowNumber', type: 'integer'},
    	         {name: 'g_Name', type: 'string'},
    	         {name: 'g_Count', type: 'integer'},
    	         {name: 'g_Score', type: 'integer'}
    	        ],
    	        
    	proxy: {
    		type: 'ajax',
    		url: '/MuWSRestApp/api/Statistic/guildsForScore',
            reader: {
                type: 'json',
                rootProperty: 'data',
                successProperty: 'success',
                totalProperty: 'total',
                messageProperty: 'message'
            }
    	},
    	
    	autoLoad: false
    }),

    columns: [
		{
		    text : 'N°',
		    dataIndex: 'rowNumber',
		    sortable : false,
		    flex:1/100
		},
		{
			header: "Name",
			flex:1,
			dataIndex: 'g_Name',
			hidden:false,
			sortable:false
		},
		{
			header: "Member Count",
			flex:1,
			dataIndex: 'g_Count',
			hidden:false,
			sortable:false
		},
		{
			header: "Score",
			flex:1,
			dataIndex: 'g_Score',
			hidden:false,
			sortable:false
		}
		
	],
	
	initComponent: function() {
		
		var me = this;
		
		this.dockedItems = [
			 {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store : me.store,
	            displayInfo: true
	        }
        ];
		
		this.callParent(arguments);
		this.on('render', this.loadStore, this);
	},
    loadStore: function() {
        this.getStore().load();
    }
});
