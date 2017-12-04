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
* DATE CREATE : 23/03/2015 00:00:56
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarParametroPlanilla.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarParametroPlanillaList',
    
    requires: ['MyApp.view.GestionarParametroPlanilla.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Parametros Planilla',
    store: 'GestionarParametroPlanilla.MainStore',

    columns: [
		{
	    	header: "Nro.",
			flex:20 / 100,
			dataIndex: 'srl_id_parametro_planilla',
			hidden:false,
			sortable:true
		}
		,{
			header: "Parámetro",
			flex:200 / 100,
			dataIndex: 'var_descrip_parametro',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo Parámetro",
			flex:115 / 100,
			dataIndex: 'int_tipo_parametro',
			hidden:true,
			sortable:true
		}
		,{
			header: "Tipo",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_parametro',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo Estado",
			flex:115 / 100,
			dataIndex: 'int_id_estado',
			hidden:true,
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
			dataIndex: 'tsp_fecha_registro',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarParametroPlanillaFilter'
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
	            store: 'GestionarParametroPlanilla.MainStore',
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
