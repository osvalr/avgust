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
* DATE CREATE : 19/05/2015 22:46:28
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteRequerimientoPersonalMINTRA.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteRequerimientoPersonalMINTRAList',
    
    requires: ['MyApp.view.ReporteRequerimientoPersonalMINTRA.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Reporte Oficio Requerimientos para MINTRA',
    store: 'ReporteRequerimientoPersonalMINTRA.MainStore',

    columns: [
		{
			header: "Nro.",
			flex:115 / 100,
			dataIndex: 'srl_id_requerimiento_personal',
			hidden:false,
			sortable:true
		},
		{
	    	header: "Cantidad Requerida",
			flex:115 / 100,
			dataIndex: 'int_cantidad_requerida',
			hidden:false,
			sortable:true
		}
		,{
			header: "Denominación de Requerimiento",
			flex:115 / 100,
			dataIndex: 'var_denominacion_requerimiento',
			hidden:false,
			sortable:true
		}
		,{
			header: "idarea_solicitante",
			flex:115 / 100,
			dataIndex: 'idarea_solicitante',
			hidden:true,
			sortable:true
		}
		,{
			header: "Área Solicitante",
			flex:115 / 100,
			dataIndex: 'desarea',
			hidden:false,
			sortable:true
		}
		,{
			header: "idunidad_solicitante",
			flex:115 / 100,
			dataIndex: 'idunidad_solicitante',
			hidden:true,
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
			header: "int_id_estado",
			flex:115 / 100,
			dataIndex: 'int_id_estado',
			hidden:true,
			sortable:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'var_nombre_estado',
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
		          xtype: 'ReporteRequerimientoPersonalMINTRAFilter'
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
				            
				            {
				            	glyph:'xf055@FontAwesome',
				                text: 'Agregar',
				                hidden:true,
				                action: 'add'
				            },
				            
				            {
				            	glyph:'xf056@FontAwesome',
				                text: 'Eliminar',
				                hidden:true,
				                action: 'delete'
				            },
				            '-',
				            {
				            	glyph:'xf056@FontAwesome',
				                text: 'Generar Reporte',
				                hidden:false,
				                action: 'generarReporte'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteRequerimientoPersonalMINTRA.MainStore',
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
