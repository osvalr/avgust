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
* DATE CREATE : 03/04/2015 18:33:21
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarConcepto.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarConceptoList',
    
    requires: ['MyApp.view.GestionarConcepto.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Conceptos',
    store: 'GestionarConcepto.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:50 / 100,
			dataIndex: 'srl_id_concepto_planilla',
			hidden:false,
			sortable:true
		}
		,{
			header: "Código",
			flex:60 / 100,
			dataIndex: 'var_cod_concepto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Descripción",
			flex:300 / 100,
			dataIndex: 'var_descrip_corto_concepto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Código PDT",
			flex:115 / 100,
			dataIndex: 'var_cod_pdt_concepto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Código MEF",
			flex:115 / 100,
			dataIndex: 'var_cod_mef_concepto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Código SIAF",
			flex:115 / 100,
			dataIndex: 'var_cod_siaf_concepto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo Concepto",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_concepto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Sub Tipo Concepto",
			flex:140 / 100,
			dataIndex: 'descrip_sub_tipo_concepto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo Monto",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_monto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Valor",
			flex:115 / 100,
			dataIndex: 'dec_monto_concepto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fecha Registro",
			flex:115 / 100,
			dataIndex: 'tsp_fecha_registro',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarConceptoFilter'
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
				                text: 'Agregar',
				                action: 'add'
				            },
				            '-',
				            {
				            	glyph:'xf056@FontAwesome',
				                text: 'Eliminar',
				                action: 'delete'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarConcepto.MainStore',
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
