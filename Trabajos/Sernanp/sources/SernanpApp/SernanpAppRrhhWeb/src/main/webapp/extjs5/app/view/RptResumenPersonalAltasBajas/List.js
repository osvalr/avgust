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
* DATE CREATE : 26/05/2015 21:05:52
* VERSION : 1.0 
*/

Ext.define('MyApp.view.RptResumenPersonalAltasBajas.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.RptResumenPersonalAltasBajasList',
    
    requires: ['MyApp.view.RptResumenPersonalAltasBajas.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Altas y Bajas del Personal',
    store: 'RptResumenPersonalAltasBajas.MainStore',

    columns: [
		{
	    	header: "idpersonanatural",
			flex:115 / 100,
			dataIndex: 'idpersonanatural',
			hidden:true,
			sortable:true
		}
		,{
			header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:true,
			sortable:true
		}
		,{
			header: "Nombres",
			flex:115 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "nombre",
			flex:115 / 100,
			dataIndex: 'nombre',
			hidden:true,
			sortable:true
		}
		,{
			header: "apepat",
			flex:115 / 100,
			dataIndex: 'apepat',
			hidden:true,
			sortable:true
		}
		,{
			header: "apemat",
			flex:115 / 100,
			dataIndex: 'apemat',
			hidden:true,
			sortable:true
		}
		,{
			header: "idtipodocumento",
			flex:115 / 100,
			dataIndex: 'idtipodocumento',
			hidden:true,
			sortable:true
		}
		,{
			header: "DNI",
			flex:115 / 100,
			dataIndex: 'descrip_documento',
			hidden:true,
			sortable:true
		}
		,{
			header: "DNI",
			flex:115 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "RUC",
			flex:115 / 100,
			dataIndex: 'ruc',
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
			header: "Reg. Contractual",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
			sortable:true
		}
		,{
			header: "srl_id_cargo",
			flex:115 / 100,
			dataIndex: 'srl_id_cargo',
			hidden:true,
			sortable:true
		}
		,{
			header: "Cargo",
			flex:115 / 100,
			dataIndex: 'var_nom_cargo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Inicio del Contrato",
			flex:115 / 100,
			dataIndex: 'inicio_contrato',
			hidden:false,
			sortable:true
		}
		,{
			header: "Término del Contrato",
			flex:115 / 100,
			dataIndex: 'termino_contrato',
			hidden:false,
			sortable:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'desc_estado',
			hidden:false,
			sortable:true
		}
		,{
			header: "int_estado",
			flex:115 / 100,
			dataIndex: 'int_estado',
			hidden:true,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'RptResumenPersonalAltasBajasFilter'
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
							    action: 'generarReportePDF'
							    
							},
							'-',   
							{
							    text: 'Generar XLS',
							    glyph:'xf016@FontAwesome',
							    action: 'generarReporteXLS'
							   
							}
				           
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'RptResumenPersonalAltasBajas.MainStore',
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
