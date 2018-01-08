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
* @since   01/03/2016 22:42:35
*/

Ext.define('MyApp.view.GestionarClienteJuridico.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarClienteJuridicoList',
    
    requires: ['MyApp.view.GestionarClienteJuridico.Filter'],

    iconCls:'icon-application_form',

    title : 'Clientes Juridicos',
    store: 'GestionarClienteJuridico.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:115 / 100,
			dataIndex: 'id_persona',
			hidden:false,
			sortable:true
		}
		,{
			header: "Razón Social",
			flex:115 / 100,
			dataIndex: 'razon_social',
			hidden:false,
			sortable:true
		}
		,{
			header: "RUC",
			flex:115 / 100,
			dataIndex: 'num_tipo_doc',
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
		          xtype: 'GestionarClienteJuridicoFilter'
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
				            }
//				            ,
//				            '-',
//				            {
//				            	iconCls:'icon-delete',
//				                text: 'Eliminar',
//				                action: 'delete'
//				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarClienteJuridico.MainStore',
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
