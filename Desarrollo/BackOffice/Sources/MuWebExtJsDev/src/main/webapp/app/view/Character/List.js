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

Ext.define('MyApp.view.Character.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.CharacterList',
    
    iconCls:'icon-group',

    title : 'Characters',
    store: 'Character.MainStore',

    columns: [

		{
			header: "Name",
			flex:115 / 100,
			dataIndex: 'name',
			hidden:false,
			sortable:true
		}
		,{
			header: "Resets",
			flex:115 / 100,
			dataIndex: 'resets',
			hidden:false,
			sortable:true
		}
		,{
			header: "Level",
			flex:115 / 100,
			dataIndex: 'clevel',
			hidden:false,
			sortable:true
		}
		,{
			header: "LevelUpPoint",
			flex:115 / 100,
			dataIndex: 'levelUpPoint',
			hidden:false,
			sortable:true
		}
		,{
			header: "Class",
			flex:115 / 100,
			dataIndex: 'descrip_clazz',
			hidden:false,
			sortable:true
		}
		,{
			header: "Strength",
			flex:115 / 100,
			dataIndex: 'strength',
			hidden:false,
			sortable:true
		}
		,{
			header: "Dexterity",
			flex:115 / 100,
			dataIndex: 'dexterity',
			hidden:false,
			sortable:true
		}
		,{
			header: "Vitality",
			flex:115 / 100,
			dataIndex: 'vitality',
			hidden:false,
			sortable:true
		}
		,{
			header: "Energy",
			flex:115 / 100,
			dataIndex: 'energy',
			hidden:false,
			sortable:true
		}
		,{
			header: "Money",
			flex:115 / 100,
			dataIndex: 'money',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
			 {
	            xtype: 'toolbar',
	            items: [

				            {
				            	iconCls:'icon-arrow_rotate_clockwise',
				                text: 'Reset',
				                action: 'reset'
				            },
				            '-',
				            {
				            	iconCls:'icon-add',
				                text: 'Add Points',
				                action: 'add'
				            },
				            '-',
				            {
				            	iconCls:'icon-bullet_stop',
				                text: 'Pk Clear',
				                action: 'pkClear'
				            }
			           ]
	        }
        ];
		
		this.callParent(arguments);
        this.on('render', this.loadStore, this);
	},
    loadStore: function() {
        this.getStore().load();
    }
});
