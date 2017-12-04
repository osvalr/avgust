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
* DATE CREATE : 20/04/2015 01:10:00
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPlaza.ListAlterno' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarPlazaListAlterno',
    
    requires: ['MyApp.view.GestionarPlaza.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Plazas',
    store: 'GestionarPlaza.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:115 / 100,
			dataIndex: 'srl_id_conv_area_org',
			hidden:false,
			sortable:true
		}
		,{
			header: "Convocatoria",
			flex:115 / 100,
			dataIndex: 'var_num_convocatoria',
			hidden:false,
			sortable:true
		}
		,{
			header: "Requerimiento",
			flex:115 / 100,
			dataIndex: 'var_numero_requerimiento',
			hidden:true,
			sortable:true
		}
		,{
			header: "Requerimiento",
			flex:115 / 100,
			dataIndex: 'var_numero_requerimiento_corto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Código Postulación",
			flex:115 / 100,
			dataIndex: 'var_codigo_postulacion',
			hidden:false,
			sortable:true
		}
		,{
			header: "Area Responsable",
			flex:115 / 100,
			dataIndex: 'descrip_area_responsable',
			hidden:false,
			sortable:true
		}
		,{
			header: "Responsable",
			flex:115 / 100,
			dataIndex: 'nombres_completos',
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
		          xtype: 'GestionarPlazaFilter'
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
				            }

			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarPlaza.MainStore',
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
