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
* DATE CREATE : 17/05/2015 17:00:41
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteResumenAfp.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteResumenAfpList',
    
    requires: ['MyApp.view.ReporteResumenAfp.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'ReporteResumenAfp',
    store: 'ReporteResumenAfp.MainStore',

    columns: [
		{
	    	header: "var_descripcion_regimen_contractual",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
			sortable:true
		}
		,{
			header: "int_anio",
			flex:115 / 100,
			dataIndex: 'int_anio',
			hidden:false,
			sortable:true
		}
		,{
			header: "descrip_periodo",
			flex:115 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:true
		}
		,{
			header: "var_rubro_fte_fto",
			flex:115 / 100,
			dataIndex: 'var_rubro_fte_fto',
			hidden:false,
			sortable:true
		}
		,{
			header: "var_cod_meta_presupuestaria",
			flex:115 / 100,
			dataIndex: 'var_cod_meta_presupuestaria',
			hidden:false,
			sortable:true
		}
		,{
			header: "var_nombre_afp",
			flex:115 / 100,
			dataIndex: 'var_nombre_afp',
			hidden:false,
			sortable:true
		}
		,{
			header: "var_codigo_afiliacion",
			flex:115 / 100,
			dataIndex: 'var_codigo_afiliacion',
			hidden:false,
			sortable:true
		}
		,{
			header: "idpersonanatural",
			flex:115 / 100,
			dataIndex: 'idpersonanatural',
			hidden:false,
			sortable:true
		}
		,{
			header: "nombre_completo",
			flex:115 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "sueldo",
			flex:115 / 100,
			dataIndex: 'dec_total_ingresos',
			hidden:false,
			sortable:true
		}
		,{
			header: "dec_total_aportes",
			flex:115 / 100,
			dataIndex: 'dec_total_aportes',
			hidden:false,
			sortable:true
		}
		,{
			header: "seguro_invalidez",
			flex:115 / 100,
			dataIndex: 'seguro_invalidez',
			hidden:false,
			sortable:true
		}
		,{
			header: "comision_variable",
			flex:115 / 100,
			dataIndex: 'comision_variable',
			hidden:false,
			sortable:true
		}
		,{
			header: "sub_total_retencion",
			flex:115 / 100,
			dataIndex: 'sub_total_retencion',
			hidden:false,
			sortable:true
		}
		,{
			header: "total",
			flex:115 / 100,
			dataIndex: 'total',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteResumenAfpFilter'
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
	            store: 'ReporteResumenAfp.MainStore',
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
