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
* @since   17/03/2016 18:54:46
*/

Ext.define('MyApp.view.GestionarSaldo.GuiaSaldoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GuiaSaldoQueryList',
    
//    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarSaldo.GuiaSaldoQueryStore',

    columns: [
		{
	    	header: "id_guia_saldo",
			flex:115 / 100,
			dataIndex: 'id_guia_saldo',
			hidden:true
		}
		,{
			header: "id_guia",
			flex:115 / 100,
			dataIndex: 'id_guia',
			hidden:true
		}
		,{
			header: "Monto",
			flex:115 / 100,
			dataIndex: 'monto_amortizado',
			hidden:false
		}
		,{
			header: "Fecha Saldo",
			flex:115 / 100,
			dataIndex: 'fecha_saldo',
			hidden:false
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
			hidden:false
		}
		,{
			header: "F. Registro",
			flex:115 / 100,
			dataIndex: 'fecha_registro',
			hidden:false
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [{
            	iconCls:'icon-add',
                itemId: 'add',
                text: 'Agregar',
                action: 'add'
            },{
            	iconCls:'icon-delete',
                text: 'Eliminar',
                action: 'delete'
            }]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarSaldo.GuiaSaldoQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});