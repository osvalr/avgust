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
* DATE CREATE : 15/06/2015 18:26:46
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteBanco.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteBancoList',
    
    requires: ['MyApp.view.ReporteBanco.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Reporte Banco',
    store: 'ReporteBanco.MainStore',

    columns: [
              
		{
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
			header: "Apellidos y Nombres",
			flex:180 / 100,
			dataIndex: 'nombre_completo',
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
			header: "Cuenta",
			flex:80 / 100,
			dataIndex: 'var_numero_cuenta_bancaria',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo Doc.",
			flex:40 / 100,
			dataIndex: 'idtipodocumento',
			hidden:false,
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
			header: "Importe",
			flex:115 / 100,
			dataIndex: 'dec_total_neto',
			hidden:false,
			sortable:true
		}
		,{
			header: "c_fte_fto",
			flex:115 / 100,
			dataIndex: 'c_fte_fto',
			hidden:true,
			sortable:true
		}
		,{
			header: "c_meta",
			flex:115 / 100,
			dataIndex: 'c_meta',
			hidden:true,
			sortable:true
		}
		
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteBancoFilter'
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
				                text: 'Generar Reporte',
				                action: 'showReporteAbonoBanco'				            	
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteBanco.MainStore',
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
