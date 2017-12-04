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
* DATE CREATE : 18/05/2015 04:29:11
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReportePlanillaPagoSNP.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReportePlanillaPagoSNPList',
    
    requires: ['MyApp.view.ReportePlanillaPagoSNP.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'ReportePlanillaPagoSNP',
    store: 'ReportePlanillaPagoSNP.MainStore',

    columns: [
		{
	    	header: "srl_id_nomina_anio_periodo_personal",
			flex:115 / 100,
			dataIndex: 'srl_id_nomina_anio_periodo_personal',
			hidden:true,
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
			header: "Año",
			flex:115 / 100,
			dataIndex: 'int_anio',
			hidden:false,
			sortable:true
		}
		,{
			header: "srl_id_anio_periodo_planilla",
			flex:115 / 100,
			dataIndex: 'srl_id_anio_periodo_planilla',
			hidden:true,
			sortable:true
		}
		,{
			header: "int_id_periodo_mes",
			flex:115 / 100,
			dataIndex: 'int_id_periodo_mes',
			hidden:true,
			sortable:true
		}
		,{
			header: "Periodo",
			flex:115 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Id",
			flex:115 / 100,
			dataIndex: 'idpersonal',
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
			header: "srl_id_regimen_contractual",
			flex:115 / 100,
			dataIndex: 'srl_id_regimen_contractual',
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
			header: "Ingresos",
			flex:115 / 100,
			dataIndex: 'dec_total_ingresos',
			hidden:false,
			sortable:true
		}
		,{
			header: "Monto Calculado",
			flex:115 / 100,
			dataIndex: 'dec_monto_calculado',
			hidden:false,
			sortable:true
		}
		,{
			header: "Meta",
			flex:115 / 100,
			dataIndex: 'var_cod_meta_presupuestaria',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fte. Fto.",
			flex:115 / 100,
			dataIndex: 'var_rubro_fte_fto',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReportePlanillaPagoSNPFilter'
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
				            	glyph:'xf12d@FontAwesome',
				                text: 'Generar Reporte',
				                action: 'generarReporte'
				            },
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReportePlanillaPagoSNP.MainStore',
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
