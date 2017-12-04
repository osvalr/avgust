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
* DATE CREATE : 19/04/2015 06:16:31
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarMetaFuenteGenerica.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarMetaFuenteGenericaList',
    
    requires: ['MyApp.view.GestionarMetaFuenteGenerica.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Metas y Fuentes Fto',
    store: 'GestionarMetaFuenteGenerica.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:50 / 100,
			dataIndex: 'srl_id_meta_fuente_generica',
			hidden:false,
			sortable:true
		}
		,{
			header: "Año",
			flex:75 / 100,
			dataIndex: 'int_anio',
			hidden:false,
			sortable:true
		}
		,{
			header: "Código año meta",
			flex:115 / 100,
			dataIndex: 'var_cod_meta_anio',
			hidden:true,
			sortable:true
		}
		,{
			header: "Meta Presupuestaria",
			flex:115 / 100,
			dataIndex: 'var_cod_meta_presupuestaria',
			hidden:false,
			sortable:true
		}
		
		,{
			header: "Fte Fto",
			flex:115 / 100,
			dataIndex: 'var_rubro_fte_fto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Génerica Gasto",
			flex:115 / 100,
			dataIndex: 'var_descrip_generica_gasto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Clasificador",
			flex:115 / 100,
			dataIndex: 'var_descrip_clasificador',
			hidden:false,
			sortable:true
		}
		,{
			header: "Área Organica",
			flex:115 / 100,
			dataIndex: 'desarea',
			hidden:false,
			sortable:true
		}
		,{
			header: "Unidad Operativa",
			flex:115 / 100,
			dataIndex: 'nomunidad',
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
			dataIndex: 'tsp_fecha_registro',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarMetaFuenteGenericaFilter'
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
	            store: 'GestionarMetaFuenteGenerica.MainStore',
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
