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
* @since   25/07/2016 19:41:32
*/

Ext.define('MyApp.view.MttoCuentaPorCobrar.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.MttoCuentaPorCobrarList',
    
    requires: ['MyApp.view.MttoCuentaPorCobrar.Filter'],

    iconCls:'icon-application_form',

    title : 'Mtto Cuentas por Cobrar',
    store: 'MttoCuentaPorCobrar.MainStore',

    columns: [
		{
	    	header: "Cliente",
			flex:115 / 100,
			dataIndex: 'nombres_completos',
			hidden:false,
			sortable:true
		}
		,{
			header: "Glosa",
			flex:115 / 100,
			dataIndex: 'descrip_glosa',
			hidden:false,
			sortable:true
		}
		,{
			header: "Deuda",
			flex:115 / 100,
			dataIndex: 'monto_deuda',
			hidden:false,
			sortable:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fecha Registro",
			flex:115 / 100,
			dataIndex: 'fecha_registro',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'MttoCuentaPorCobrarFilter'
		     },
			 {
	            xtype: 'toolbar',
	            items: [
				            {
				            	iconCls:'icon-find',
				                text: 'Filtrar',
				                action: 'filter'
				            },
				            '-',
				            {
				            	iconCls:'icon-erase',
				                text: 'Limpiar',
				                action: 'clearFilter'
				            },
				            '-',
				            {
				            	iconCls:'icon-add',
				                text: 'Agregar',
				                action: 'add'
				            },
				            '-',
				            {
				            	iconCls:'icon-delete',
				                text: 'Eliminar',
				                action: 'delete'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'MttoCuentaPorCobrar.MainStore',
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
