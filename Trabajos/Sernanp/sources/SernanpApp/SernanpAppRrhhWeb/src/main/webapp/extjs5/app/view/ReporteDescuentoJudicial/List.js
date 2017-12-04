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
* DATE CREATE : 17/05/2015 16:50:57
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteDescuentoJudicial.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteDescuentoJudicialList',
    
    requires: ['MyApp.view.ReporteDescuentoJudicial.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Reporte Descuento 	Judicial',
    store: 'ReporteDescuentoJudicial.MainStore',

    columns: [
		{
	    	header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:true,
			sortable:true
		}
//		,{
//			header: "Año",
//			flex:45 / 100,
//			dataIndex: 'int_anio',
//			hidden:false,
//			sortable:true
//		}
		,{
			header: "Periodo",
			flex:60 / 100,
			dataIndex: 'int_id_periodo_mes',
			hidden:true,
			sortable:true
		}
		,{
			header: "Periodo",
			flex:60 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombres",
			flex:140 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nº Doc.",
			flex:70 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Reg. Contractual",
			flex:80 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
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
			header: "srl_id_anio_planilla",
			flex:115 / 100,
			dataIndex: 'srl_id_anio_planilla',
			hidden:true,
			sortable:true
		}
		
		
		,{
			header: "Descuento",
			flex:130 / 100,
			dataIndex: 'var_descripcion_descuento',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nº Doc. Descuento",
			flex:60 / 100,
			dataIndex: 'var_numero_doc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Beneficiario",
			flex:140 / 100,
			dataIndex: 'nombre_beneficiario_jud',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nº de Cuenta",
			flex:70 / 100,
			dataIndex: 'var_numero_cuenta',
			hidden:false,
			sortable:true
		}
		,{
			header: "monto",
			flex:50 / 100,
			dataIndex: 'dec_monto',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteDescuentoJudicialFilter'
		     },
			 {
	            xtype: 'toolbar',
	            items: [
				            {
				            	glyph:'xf0b0@FontAwesome',
				                text: 'Filtrar',
				                action: 'filter',
				                hidden:false
				            },
				            
				            {
				            	glyph:'xf12d@FontAwesome',
				                text: 'Limpiar',
				                action: 'clearFilter',
				                hidden:false
				            },
				            
							{
							    text: 'Generar PDF',
							    glyph:'xf016@FontAwesome',
							    action: 'generarReportePDF',
							},
							'-',   
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
	            store: 'ReporteDescuentoJudicial.MainStore',
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
