/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 07/06/2015 12:08:29
* VERSION : 1.0 
*/

Ext.define('AcmeWebApp.view.GestionarProducto.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarProductoList',
    
    requires: ['AcmeWebApp.view.GestionarProducto.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Producto',
    store: 'GestionarProducto.MainStore',

    columns: [
		{
	    	header: "Código",
			flex:115 / 100,
			dataIndex: 'cod_producto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Categoría",
			flex:115 / 100,
			dataIndex: 'descrip_categoria',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombre",
			flex:115 / 100,
			dataIndex: 'nombre',
			hidden:false,
			sortable:true
		}
		,{
			header: "Moneda",
			flex:115 / 100,
			dataIndex: 'descrip_moneda',
			hidden:false,
			sortable:true
		}
		,{
			header: "Precio",
			flex:115 / 100,
			dataIndex: 'precio',
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
			header: "F.Registro",
			flex:115 / 100,
			dataIndex: 'fec_reg',
			hidden:false,
			sortable:true
		}

	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarProductoFilter'
		     },
			 {
	            xtype: 'toolbar',
	            items: [
				            {
				            	glyph:'xf0b0@FontAwesome',
				                text: 'Filtrar',
				                action: 'filter'
				            },
				            '-',
				            {
				            	glyph:'xf12d@FontAwesome',
				                text: 'Limpiar',
				                action: 'clearFilter'
				            },
				            '-',
				            {
				            	glyph:'xf055@FontAwesome',
				                text: 'Agregar',
				                action: 'add'
				            },
				            '-',
				            {
				            	glyph:'xf056@FontAwesome',
				                text: 'Eliminar',
				                action: 'delete'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarProducto.MainStore',
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
