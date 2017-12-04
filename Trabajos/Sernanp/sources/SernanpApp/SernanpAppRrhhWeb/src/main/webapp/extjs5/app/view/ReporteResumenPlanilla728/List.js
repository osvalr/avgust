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
* DATE CREATE : 31/05/2015 14:56:55
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteResumenPlanilla728.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteResumenPlanilla728List',
    
    requires: ['MyApp.view.ReporteResumenPlanilla728.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'ReporteResumenPlanilla728',
    store: 'ReporteResumenPlanilla728.MainStore',

    columns: [
		{
	    	header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:true,
			sortable:true
		}
		,{
			header: "idpersonanatural",
			flex:115 / 100,
			dataIndex: 'idpersonanatural',
			hidden:true,
			sortable:true
		}
		,{
			header: "Año",
			flex:45 / 100,
			dataIndex: 'int_anio',
			hidden:false,
			sortable:true
		}
		,{
			header: "Periodo",
			flex:115 / 100,
			dataIndex: 'int_id_periodo_mes',
			hidden:true,
			sortable:true
		}
		,{
			header: "Periodo",
			flex:70 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombres",
			flex:160 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nº Doc.",
			flex:60 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fecha Inicio",
			flex:60 / 100,
			dataIndex: 'dte_fec_inicio',
			hidden:false,
			sortable:true
		}
		,{
			header: "srl_id_regimen_contractual",
			flex:60 / 100,
			dataIndex: 'srl_id_regimen_contractual',
			hidden:true,
			sortable:true
		}
		,{
			header: "Reg. Contractual",
			flex:70 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
			sortable:true
		}
		,{
			header: "srl_id_anio_planilla",
			flex:115 / 100,
			dataIndex: 'srl_id_anio_planilla',
			hidden:true,
			sortable:true
		}
		
		,{
			header: "MP",
			flex:35 / 100,
			dataIndex: 'c_meta',
			hidden:false,
			sortable:true
		}
		,{
			header: "FF",
			flex:35 / 100,
			dataIndex: 'c_fte_fto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Sueldo",
			flex:50 / 100,
			dataIndex: 'sueldo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Asignación Familiar",
			flex:70 / 100,
			dataIndex: 'asignacion_familiar',
			hidden:false,
			sortable:true
		}
		,{
			header: "SNP / ONP",
			flex:45 / 100,
			dataIndex: 'onp',
			hidden:false,
			sortable:true
		}
		,{
			header: "Aporte Obligatorio",
			flex:80 / 100,
			dataIndex: 'aporte_obligatorio',
			hidden:false,
			sortable:true
		}
		,{
			header: "Seguro de Invalidez",
			flex:80 / 100,
			dataIndex: 'seguro_invalidez',
			hidden:false,
			sortable:true
		}
		,{
			header: "Total",
			flex:45 / 100,
			dataIndex: 'total',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteResumenPlanilla728Filter'
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
//				            '-',
//							{
//							    text: 'Generar Reporte',
//							    glyph:'xf016@FontAwesome',
//							    action: 'generarReportePDF',
//							},
//							'-',   
							{
							    text: 'Generar XLS',
							    glyph:'xf016@FontAwesome',
							    action: 'generarReporteXLS',
							}
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteResumenPlanilla728.MainStore',
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
