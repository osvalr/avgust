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
* DATE CREATE : 17/03/2015 19:55:09
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAfp.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarAfpList',
    
    requires: ['MyApp.view.GestionarAfp.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar AFP',
    store: 'GestionarAfp.MainStore',

    columns: [
		{
	    	header: "Nro.",
			flex:20 / 100,
			dataIndex: 'srl_id_afp',
			hidden:false,
			sortable:true
		}
		,{
			header: "Código AFP",
			flex:70 / 100,
			dataIndex: 'var_cod_afp',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombre AFP",
			flex:200 / 100,
			dataIndex: 'var_nombre_afp',
			hidden:false,
			sortable:true
		}
		,{
			header: "int_id_estado",
			flex:115 / 100,
			dataIndex: 'int_id_estado',
			hidden:true,
			sortable:true
		}
		,{
			header: "Estado",
			flex:70 / 100,
			dataIndex: 'descrip_estado',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fecha Registro",
			flex:70 / 100,
			dataIndex: 'tsp_fecha_registro',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarAfpFilter'
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
	            store: 'GestionarAfp.MainStore',
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
