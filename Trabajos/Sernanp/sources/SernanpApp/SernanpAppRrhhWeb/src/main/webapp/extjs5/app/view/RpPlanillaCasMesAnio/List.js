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
* DATE CREATE : 07/05/2015 16:53:32
* VERSION : 1.0 
*/

Ext.define('MyApp.view.RpPlanillaCasMesAnio.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.RpPlanillaCasMesAnioList',
    
    requires: ['MyApp.view.RpPlanillaCasMesAnio.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Reporte CAS ',
    store: 'RpPlanillaCasMesAnio.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:45 / 100,
			dataIndex: 'srl_id_nomina_anio_periodo_personal',
			hidden:false,
			sortable:true
		}
		,{
			header: "Mes",
			flex:70 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombre Completo",
			flex:115 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		
		,{
			header: "Régimen",
			flex:90 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
			sortable:true
		}
		,{
			header: "Ubicación",
			flex:180 / 100,
			dataIndex: 'ubicacion',
			hidden:false,
			sortable:true
		}
		,{
			header: "FF",
			flex:130 / 100,
			dataIndex: 'var_descripcion_fuente_financiamiento',
			hidden:false,
			sortable:true
		}
		,{
			header: "MP",
			flex:45 / 100,
			dataIndex: 'var_cod_meta_presupuestaria',
			hidden:false,
			sortable:true
		}
		,{
			header: "HONORARIOS",
			flex:90 / 100,
			dataIndex: 'dec_total_ingresos',
			hidden:false,
			sortable:true
		}
		,{
			header: "DESCUENTOS",
			flex:90 / 100,
			dataIndex: 'dec_total_descuentos',
			hidden:false,
			sortable:true
		}
		,{
			header: "APORTES",
			flex:90 / 100,
			dataIndex: 'dec_total_aportes',
			hidden:false,
			sortable:true
		}
		,{
			header: "TOTAL",
			flex:90 / 100,
			dataIndex: 'dec_total_neto',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'RpPlanillaCasMesAnioFilter'
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
				            	glyph:'xf080@FontAwesome',
				                text: 'Generar Reporte',
				                action: 'generarReporte'
				            }
				            /*
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
				            */
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'RpPlanillaCasMesAnio.MainStore',
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
