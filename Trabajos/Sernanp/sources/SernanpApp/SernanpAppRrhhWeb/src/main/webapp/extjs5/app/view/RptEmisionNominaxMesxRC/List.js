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
* DATE CREATE : 23/05/2015 11:23:37
* VERSION : 1.0 
*/

Ext.define('MyApp.view.RptEmisionNominaxMesxRC.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.RptEmisionNominaxMesxRCList',
    
    requires: ['MyApp.view.RptEmisionNominaxMesxRC.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Emitir Nomina Mensual del Personal',
    store: 'RptEmisionNominaxMesxRC.MainStore',
    

    columns: [
      		{
      	    	header: "Nº Nomina",
      			flex:50 / 100,
      			dataIndex: 'srl_id_nomina_anio_periodo_personal',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "Año",
      			flex:40 / 100,
      			dataIndex: 'int_anio',
      			hidden:false,
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
      			header: "Nombre Completo",
      			flex:135 / 100,
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
      			dataIndex: 'desareanatural',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "FF",
      			flex:45 / 100,
      			dataIndex: 'var_rubro_fte_fto',
      			hidden:true,
      			sortable:true
      		}
      		,{
      			header: "MP",
      			flex:45 / 100,
      			dataIndex: 'var_cod_meta_presupuestaria',
      			hidden:true,
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
      			header: "Honorarios",
      			flex:90 / 100,
      			dataIndex: 'dec_total_ingresos',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "Descuentos",
      			flex:90 / 100,
      			dataIndex: 'dec_total_descuentos',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "Aportes",
      			flex:90 / 100,
      			dataIndex: 'dec_total_aportes',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "Total",
      			flex:90 / 100,
      			dataIndex: 'dec_total_neto',
      			hidden:false,
      			sortable:true
      		}
      	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'RptEmisionNominaxMesxRCFilter'
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
							    text: 'Generar PDF',
							    glyph:'xf016@FontAwesome',
							    action: 'generarReportePDF',
							}//,
//							'-',   
//							{
//							    text: 'Generar XLS',
//							    glyph:'xf016@FontAwesome',
//							    action: 'generarReporteXLS',
//							}
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'RptEmisionNominaxMesxRC.MainStore',
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
