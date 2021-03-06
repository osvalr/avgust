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
* @since   25/02/2016 20:09:25
*/

Ext.define('MyApp.view.GestionarCatalogo.CatalogoItemQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.CatalogoItemQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarCatalogo.CatalogoItemQueryStore',

    columns: [
		{
	    	header: "id_catalogo_item",
			flex:115 / 100,
			dataIndex: 'id_catalogo_item',
			hidden:true
		}
		,{
			header: "id_catalogo",
			flex:115 / 100,
			dataIndex: 'id_catalogo',
			hidden:true
		}
		,{
			header: "Valor",
			flex:115 / 100,
			dataIndex: 'valor_item',
			hidden:false
		}
		,{
			header: "Descripción",
			flex:115 / 100,
			dataIndex: 'descrip_item',
			hidden:false
		}
		,{
			header: "Valor A",
			flex:115 / 100,
			dataIndex: 'valor_a',
			hidden:false
		}
		,{
			header: "Valor B",
			flex:115 / 100,
			dataIndex: 'valor_b',
			hidden:false
		}
		,{
			header: "Valor C",
			flex:115 / 100,
			dataIndex: 'valor_c',
			hidden:false
		}
		,{
			header: "Valor D",
			flex:115 / 100,
			dataIndex: 'valor_d',
			hidden:false
		}
		,{
			header: "Valor E",
			flex:115 / 100,
			dataIndex: 'valor_e',
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
            	glyph:'xf055@FontAwesome',
                itemId: 'add',
                text: 'Agregar',
                action: 'add'
            },{
            	glyph:'xf056@FontAwesome',
                text: 'Eliminar',
                action: 'delete'
            }]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarCatalogo.CatalogoItemQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
