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
* DATE CREATE : 02/06/2015 16:08:44
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteCertificadoCuartaCategoria.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteCertificadoCuartaCategoriaList',
    
    requires: ['MyApp.view.ReporteCertificadoCuartaCategoria.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Certificado Cuarta Categoría',
    store: 'ReporteCertificadoCuartaCategoria.MainStore',

    columns: [
		{
	    	header: "Año",
			flex:115 / 100,
			dataIndex: 'int_anio',
			hidden:false,
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
			header: "Nombre Completo",
			flex:180 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nro. RUC",
			flex:115 / 100,
			dataIndex: 'ruc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Dirección",
			flex:180 / 100,
			dataIndex: 'direccion',
			hidden:false,
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
			header: "Nro. Meses",
			flex:115 / 100,
			dataIndex: 'meses',
			hidden:true,
			sortable:true
		}
		,{
			header: "Total Ingresos",
			flex:115 / 100,
			dataIndex: 'total_ingresos',
			hidden:false,
			sortable:true
		}
		,{
			header: "Cuarta Categoria",
			flex:115 / 100,
			dataIndex: 'cuarta_cat',
			hidden:false,
			sortable:true
		}
		,{
			header: "Neto",
			flex:115 / 100,
			dataIndex: 'neto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Ubicación",
			flex:115 / 100,
			dataIndex: 'ubicacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "idareanatural",
			flex:115 / 100,
			dataIndex: 'idareanatural',
			hidden:true,
			sortable:true
		}
		,{
			header: "srl_id_cargo",
			flex:115 / 100,
			dataIndex: 'srl_id_cargo',
			hidden:true,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteCertificadoCuartaCategoriaFilter'
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
				                text: 'Generar Reporte',
				                action: 'generarReportePDF'
				            }
				            
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteCertificadoCuartaCategoria.MainStore',
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
