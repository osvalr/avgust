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
* @since   01/03/2016 15:25:46
*/

Ext.define('MyApp.view.GestionarJornada.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarJornadaList',
    
    requires: ['MyApp.view.GestionarJornada.Filter'],

    iconCls:'icon-application_form',

    title : 'Gestionar Jornadas',
    store: 'GestionarJornada.MainStore',

    columns: [
		{
	    	header: "Año",
			flex:115 / 100,
			dataIndex: 'num_anio',
			hidden:false,
			sortable:true
		}
		,{
			header: "Mes",
			flex:115 / 100,
			dataIndex: 'num_mes',
			hidden:false,
			sortable:true
		}
		,{
			header: "Dia",
			flex:115 / 100,
			dataIndex: 'num_dia',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fecha de Jornada",
			flex:115 / 100,
			dataIndex: 'fecha_jornada',
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
			header: "F. Registro",
			flex:115 / 100,
			dataIndex: 'fecha_registro',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarJornadaFilter'
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
	            store: 'GestionarJornada.MainStore',
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