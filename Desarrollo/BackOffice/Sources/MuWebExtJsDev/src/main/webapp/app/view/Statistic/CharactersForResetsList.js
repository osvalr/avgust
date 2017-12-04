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

Ext.define('MyApp.view.Statistic.CharactersForResetsList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.CharactersForResetsList',
    
    iconCls:'icon-award_star_gold_3',

    title : 'Characters Ranking',
    
    store : Ext.create('Ext.data.Store', {
    	
    	fields: [
    	         {name: 'rowNumber', type: 'integer'},
    	         {name: 'name', type: 'string'},
    	         {name: 'descrip_clazz', type: 'string'},
    	         {name: 'clevel', type: 'integer'},
    	         {name: 'strength', type: 'integer'},
    	         {name: 'dexterity', type: 'integer'},
    	         {name: 'vitality', type: 'integer'},
    	         {name: 'energy', type: 'integer'},
    	         {name: 'leadership', type: 'integer'},
    	         {name: 'resets', type: 'integer'}
    	        ],
    	        
    	proxy: {
    		type: 'ajax',
    		url: '/MuWSRestApp/api/Statistic/charactersForResets',
            reader: {
                type: 'json',
                rootProperty: 'data',
                successProperty: 'success',
                totalProperty: 'total',
                messageProperty: 'message'
            }
    	},
    	pageSize: 25,
    	autoLoad: false
    }),

//    store:'Statistic.CharactersForResetsStore',
    
    columns: [
		{
		    text : 'N°',
		    dataIndex: 'rowNumber',
		    sortable : false,
		    flex:1/100
		},
		{
			header: "Name",
			flex:2,
			dataIndex: 'name',
			hidden:false,
			sortable:false
		},
		{
			header: "Class",
			flex:2,
			dataIndex: 'descrip_clazz',
			hidden:false,
			sortable:false
		},
		{
			header: "Level",
			flex:1,
			dataIndex: 'clevel',
			hidden:false,
			sortable:false
		},
		{
			header: "Strength",
			flex:1,
			dataIndex: 'strength',
			hidden:false,
			sortable:false
		}
		,{
			header: "Dexterity",
			flex:1,
			dataIndex: 'dexterity',
			hidden:false,
			sortable:false
		}
		,{
			header: "Vitality",
			flex:1,
			dataIndex: 'vitality',
			hidden:false,
			sortable:false
		}
		,{
			header: "Energy",
			flex:1,
			dataIndex: 'energy',
			hidden:false,
			sortable:false
		},
		{
			header: "Leadership",
			flex:1,
			dataIndex: 'leadership',
			hidden:false,
			sortable:false
		},
		{
			header: "Resets",
			flex:1,
			dataIndex: 'resets',
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
