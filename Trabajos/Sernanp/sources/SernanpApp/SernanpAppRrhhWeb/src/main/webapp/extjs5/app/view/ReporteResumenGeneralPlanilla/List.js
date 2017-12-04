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
* DATE CREATE : 31/05/2015 16:59:27
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteResumenGeneralPlanilla.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteResumenGeneralPlanillaList',
    
    requires: ['MyApp.view.ReporteResumenGeneralPlanilla.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Reporte Resumen General de Planilla',
    store: 'ReporteResumenGeneralPlanilla.MainStore',

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
			flex:35 / 100,
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
			flex:45 / 100,
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
			hidden:true,
			sortable:true
		}
		,{
			header: "Asignación Familiar",
			flex:70 / 100,
			dataIndex: 'asignacion_familiar',
			hidden:true,
			sortable:true
		}
		,{
			header: "SNP / ONP",
			flex:45 / 100,
			dataIndex: 'onp',
			hidden:true,
			sortable:true
		}
		,{
			header: "Aporte Obligatorio",
			flex:80 / 100,
			dataIndex: 'aporte_obligatorio',
			hidden:true,
			sortable:true
		}
		,{
			header: "Seguro de Invalidez",
			flex:80 / 100,
			dataIndex: 'seguro_invalidez',
			hidden:true,
			sortable:true
		}
		,{
			header: "Total",
			flex:45 / 100,
			dataIndex: 'total',
			hidden:true,
			sortable:true
		}
		,{
			header: "comision",
			flex:115 / 100,
			dataIndex: 'comision',
			hidden:true,
			sortable:true
		}
		,{
			header: "quinta_categoria",
			flex:115 / 100,
			dataIndex: 'quinta_categoria',
			hidden:true,
			sortable:true
		}
		,{
			header: "cafae",
			flex:115 / 100,
			dataIndex: 'cafae',
			hidden:true,
			sortable:true
		}
		,{
			header: "atlantis",
			flex:115 / 100,
			dataIndex: 'atlantis',
			hidden:true,
			sortable:true
		}
		,{
			header: "tumi",
			flex:115 / 100,
			dataIndex: 'tumi',
			hidden:true,
			sortable:true
		}
		,{
			header: "essalud_vida",
			flex:115 / 100,
			dataIndex: 'essalud_vida',
			hidden:true,
			sortable:true
		}
		,{
			header: "coopal",
			flex:115 / 100,
			dataIndex: 'coopal',
			hidden:true,
			sortable:true
		}
		,{
			header: "rimac",
			flex:115 / 100,
			dataIndex: 'rimac',
			hidden:true,
			sortable:true
		}
		,{
			header: "judicial",
			flex:115 / 100,
			dataIndex: 'judicial',
			hidden:true,
			sortable:true
		}
		,{
			header: "asociacion_guardaparques",
			flex:115 / 100,
			dataIndex: 'asociacion_guardaparques',
			hidden:true,
			sortable:true
		}
		,{
			header: "la_positiva_seguro",
			flex:115 / 100,
			dataIndex: 'la_positiva_seguro',
			hidden:true,
			sortable:true
		}
		,{
			header: "seguros_sura",
			flex:115 / 100,
			dataIndex: 'seguros_sura',
			hidden:true,
			sortable:true
		}
		,{
			header: "tardanzas",
			flex:115 / 100,
			dataIndex: 'tardanzas',
			hidden:true,
			sortable:true
		}
		,{
			header: "vales_tai_loy",
			flex:115 / 100,
			dataIndex: 'vales_tai_loy',
			hidden:true,
			sortable:true
		}
		,{
			header: "pandero_guardaparque",
			flex:115 / 100,
			dataIndex: 'pandero_guardaparque',
			hidden:true,
			sortable:true
		}
		,{
			header: "essalud",
			flex:115 / 100,
			dataIndex: 'essalud',
			hidden:true,
			sortable:true
		}
		,{
			header: "diecinueve",
			flex:115 / 100,
			dataIndex: 'diecinueve',
			hidden:true,
			sortable:true
		}
		,{
			header: "cuarta_categoria",
			flex:115 / 100,
			dataIndex: 'cuarta_categoria',
			hidden:true,
			sortable:true
		}
		,{
			header: "viaticos",
			flex:115 / 100,
			dataIndex: 'viaticos',
			hidden:true,
			sortable:true
		}
		,{
			header: "mapfre",
			flex:115 / 100,
			dataIndex: 'mapfre',
			hidden:true,
			sortable:true
		}
		,{
			header: "otros_descuentos",
			flex:115 / 100,
			dataIndex: 'otros_descuentos',
			hidden:true,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteResumenGeneralPlanillaFilter'
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
							    text: 'Generar Nominas de Pago',
							    glyph:'xf016@FontAwesome',
							    action: 'showGenerarNominaPago'
							   
							},
							/*
							'-',
				            {
							    text: 'Nomina de Pagos por Régimen',
							    glyph:'xf016@FontAwesome',
							    action: 'showNominaPagosRegimenXLS'
							   
							},
							'-',
				            {
							    text: 'Nomina de Pagos por FF',
							    glyph:'xf016@FontAwesome',
							    action: 'showNominaPagosFF_XLS'
							   
							},
							'-',
				            {
							    text: 'Proyeccion de Planillas de Pago',
							    glyph:'xf016@FontAwesome',
							    action: 'generarProyeccion'
							   
							},
							'-',
							 {
							    text: 'Nomina de Pagos por FF-MP 728',
							    glyph:'xf016@FontAwesome',
							    action: 'listarResumenNominaPagoFFMP728',
							    hidden:false
							   
							},
							'-',
							 {
							    text: 'Nomina de Pagos por FF-MP CAS',
							    glyph:'xf016@FontAwesome',
							    action: 'listarResumenNominaPagoFFMPCAS',
							    hidden:false
							   
							},
							*/
				            '-',
				            {
				            	glyph:'xf013@FontAwesome',
				                text: 'JOR',
				                action: 'showGenerarJOR'
				            },
				            '-',
				            {
				            	glyph:'xf013@FontAwesome',
				                text: 'REM',
				                action: 'showGenerarREM'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteResumenGeneralPlanilla.MainStore',
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
