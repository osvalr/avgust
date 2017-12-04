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
* DATE CREATE : 02/06/2015 23:42:36
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteCertificadoQuintaCategoria.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteCertificadoQuintaCategoriaList',
    
    requires: ['MyApp.view.ReporteCertificadoQuintaCategoria.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Certificado Quinta Categoría',
    store: 'ReporteCertificadoQuintaCategoria.MainStore',

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
			header: "Nro. Documento",
			flex:115 / 100,
			dataIndex: 'numerodoc',
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
			dataIndex: 'cargo',
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
			header: "Aporte Obligatorio",
			flex:115 / 100,
			dataIndex: 'aporte_obligatorio',
			hidden:false,
			sortable:true
		}
		,{
			header: "Quinta Categoria",
			flex:115 / 100,
			dataIndex: 'quinta_cat',
			hidden:false,
			sortable:true
		}
		,{
			header: "Retencion",
			flex:115 / 100,
			dataIndex: 'retencion',
			hidden:false,
			sortable:true
		}

	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteCertificadoQuintaCategoriaFilter'
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
	            store: 'ReporteCertificadoQuintaCategoria.MainStore',
	            displayInfo: true
	          
	        },
	        
	        
	        
	        this.dockedItems = [ {
				xtype : 'pagingtoolbar',
				store : 'ReporteCertificadoQuintaCategoria.MainStore',
				dock : 'top',
				displayInfo : true
			} ]
	        
	        
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
