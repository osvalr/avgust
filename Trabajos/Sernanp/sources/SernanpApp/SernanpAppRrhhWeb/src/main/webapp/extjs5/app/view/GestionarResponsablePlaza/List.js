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
* DATE CREATE : 17/04/2015 16:51:57
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarResponsablePlaza.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarResponsablePlazaList',
    
    requires: ['MyApp.view.GestionarResponsablePlaza.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Responsable de las Plazas',
    store: 'GestionarResponsablePlaza.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:30 / 100,
			dataIndex: 'idpersonal',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombres",
			flex:115 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "T.D",
			flex:60 / 100,
			dataIndex: 'descrip_documento',
			hidden:false,
			sortable:true
		}
		,{
			header: "Número",
			flex:60 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "R.U.C",
			flex:115 / 100,
			dataIndex: 'ruc',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarResponsablePlazaFilter'
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
				            }//,
//				            '-',
//				            {
//				            	glyph:'xf055@FontAwesome',
//				                text: 'Agregar',
//				                action: 'add'
//				            },
//				            '-',
//				            {
//				            	glyph:'xf056@FontAwesome',
//				                text: 'Eliminar',
//				                action: 'delete'
//				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarResponsablePlaza.MainStore',
	            displayInfo: true
	        }
        ];
		
		this.callParent(arguments);
        this.on('render', this.loadStore, this);
	},
    loadStore: function() {
        this.getStore().load();
        if (Ext.get('page-loader')) {
            Ext.get('page-loader').remove();
        }
    }
});
