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
* DATE CREATE : 17/05/2015 17:19:53
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteBoletaPersonal.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteBoletaPersonalList',
    
    requires: ['MyApp.view.ReporteBoletaPersonal.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Reporte Boleta Personal',
    store: 'ReporteBoletaPersonal.MainStore',
   
    
    columns: [

		{
	    	header: "id",
			flex:45 / 100,
			dataIndex: 'idpersonal',
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
			flex:60 / 100,
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
			header: "Nro. Doc.",
			flex:115 / 100,
			dataIndex: 'numerodoc',
			hidden:true,
			sortable:true
		}
		,{
			header: "Cargo",
			flex:170 / 100,
			dataIndex: 'var_nom_cargo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Ubicación",
			flex:90 / 100,
			dataIndex: 'ubicacion',
			hidden:false,
			sortable:true
		}
		,{
			header: "Inicio Contrato",
			flex:70 / 100,
			dataIndex: 'inicio_contrato',
			hidden:false,
			sortable:true
		}
		,{
			header: "Reg. Contractual",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:true,
			sortable:true
		}
		
		
		,{
			header: "Reg. Pensionario",
			flex:90 / 100,
			dataIndex: 'regimen_pensionario',
			hidden:false,
			sortable:true
		}
		,{
			header: "Cod. Afiliación",
			flex:115 / 100,
			dataIndex: 'var_codigo_afiliacion',
			hidden:false,
			sortable:true
		}
		
		
		,{
			header: "FF",
			flex:45 / 100,
			dataIndex: 'c_fte_fto',
			hidden:false,
			sortable:true
		}
		,{
			header: "MP",
			flex:45 / 100,
			dataIndex: 'c_meta',
			hidden:false,
			sortable:true
		}
		,{
			header: "Ingresos",
			flex:50 / 100,
			dataIndex: 'dec_total_ingresos',
			hidden:false,
			sortable:true,
//			align:'right',
			
		}
		,{
			
			header: "Descuentos",
			flex:60 / 100,
			dataIndex: 'dec_total_descuentos',
			hidden:false,
			sortable:true
		}
		,{
			header: "Aportes",
			flex:50 / 100,
			dataIndex: 'dec_total_aportes',
			hidden:false,
			sortable:true,
			name:'dec_total_aportes'
			
		}
		,{
			header: "Neto",
			flex:50 / 100,
			dataIndex: 'dec_total_neto',
			hidden:false,
			sortable:true
		
		}
		,{
			header: "srl_id_nomina_anio_periodo_personal",
			flex:50 / 100,
			dataIndex: 'srl_id_nomina_anio_periodo_personal',
			hidden:true,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteBoletaPersonalFilter'
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
				            	glyph:'xf016@FontAwesome',
				                text: 'Generar Boleta',
				                action: 'generarReporte'				            	
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteBoletaPersonal.MainStore',
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
