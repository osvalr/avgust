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
* DATE CREATE : 14/06/2015 01:52:58
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteNominaDescuento.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteNominaDescuentoList',
    
    requires: ['MyApp.view.ReporteNominaDescuento.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Reporte Nomina Descuentos',
    store: 'ReporteNominaDescuento.MainStore',

    columns: [
		{
			header: "Año",
			flex:50 / 100,
			dataIndex: 'int_anio',
			hidden:false,
			sortable:true
		}
		,{
			header: "Periodo",
			flex:50 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:true
		}
		,{
	    	header: "Id",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:true,
			sortable:true
		}
		,{
			header: "Nombre Completo",
			flex:160 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nro. Documento",
			flex:115 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fte. Fto.",
			flex:115 / 100,
			dataIndex: 'c_fte_fto',
			hidden:false,
			sortable:true
		}
		
		,{
			header: "Meta",
			flex:115 / 100,
			dataIndex: 'c_meta',
			hidden:false,
			sortable:true
		}
		
		

		,{
			header: "Descripción Fte. Fto.",
			flex:115 / 100,
			dataIndex: 'var_descripcion_fuente_financiamiento',
			hidden:true,
			sortable:true
		}
		,{
			header: "Régimen Contractual",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
			sortable:true
		}
		,{
			header: "srl_id_regimen_contractual",
			flex:115 / 100,
			dataIndex: 'srl_id_regimen_contractual',
			hidden:true,
			sortable:true
		}
		
		,{
			header: "reg_19990",
			flex:115 / 100,
			dataIndex: 'reg_19990',
			hidden:true,
			sortable:true
		}
		,{
			header: "reg_afp",
			flex:115 / 100,
			dataIndex: 'reg_afp',
			hidden:true,
			sortable:true
		}
		,{
			header: "reg_20530",
			flex:115 / 100,
			dataIndex: 'reg_20530',
			hidden:true,
			sortable:true
		}
		,{
			header: "reg_25897",
			flex:115 / 100,
			dataIndex: 'reg_25897',
			hidden:true,
			sortable:true
		}
		,{
			header: "total_19990",
			flex:115 / 100,
			dataIndex: 'total_19990',
			hidden:true,
			sortable:true
		}
		,{
			header: "total_afp",
			flex:115 / 100,
			dataIndex: 'total_afp',
			hidden:true,
			sortable:true
		}
		,{
			header: "total_20530",
			flex:115 / 100,
			dataIndex: 'total_20530',
			hidden:true,
			sortable:true
		}
		,{
			header: "total_25897",
			flex:115 / 100,
			dataIndex: 'total_25897',
			hidden:true,
			sortable:true
		}
		,{
			header: "srl_id_regimen_pensionario",
			flex:115 / 100,
			dataIndex: 'srl_id_regimen_pensionario',
			hidden:true,
			sortable:true
		}
		,{
			header: "Régimen Pensionario",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_pensionario',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteNominaDescuentoFilter'
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
				                text: 'Generar Reporte PDF',
				                action: 'generarReportePDF'
				            },
				            '-',
				            {
				            	glyph:'xf056@FontAwesome',
				                text: 'Generar Reporte XLS',
				                action: 'generarReporteXLS'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteNominaDescuento.MainStore',
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
