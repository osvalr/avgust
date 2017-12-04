/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpAppTemp.
*
* SernanpAppTemp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpAppTemp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpAppTemp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 02/06/2015 14:00:22
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteDetalleBoletaPersonal.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteDetalleBoletaPersonalList',
    
    requires: ['MyApp.view.ReporteDetalleBoletaPersonal.ToolbarPaging','MyApp.view.ReporteDetalleBoletaPersonal.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'ReporteDetalleBoletaPersonal',
    store: 'ReporteDetalleBoletaPersonal.MainStore',

    columns: [
		{
	    	header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:false,
			sortable:false
		}
		,{
			header: "nombre_completo",
			flex:115 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:false
		}
		,{
			header: "numerodoc",
			flex:115 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:false
		}
		,{
			header: "var_descripcion_regimen_contractual",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
			sortable:false
		}
		,{
			header: "int_anio",
			flex:115 / 100,
			dataIndex: 'int_anio',
			hidden:false,
			sortable:false
		}
		,{
			header: "descrip_periodo",
			flex:115 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:false
		}
		,{
			header: "int_id_tipo_concepto",
			flex:115 / 100,
			dataIndex: 'int_id_tipo_concepto',
			hidden:false,
			sortable:false
		}
		,{
			header: "descrip_tipo_concepto",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_concepto',
			hidden:false,
			sortable:false
		}
		,{
			header: "srl_id_concepto_planilla",
			flex:115 / 100,
			dataIndex: 'srl_id_concepto_planilla',
			hidden:false,
			sortable:false
		}
		,{
			header: "var_descrip_corto_concepto",
			flex:115 / 100,
			dataIndex: 'var_descrip_corto_concepto',
			hidden:false,
			sortable:false
		}
		,{
			header: "dec_monto_calculado",
			flex:115 / 100,
			dataIndex: 'dec_monto_calculado',
			hidden:false,
			sortable:false
		}
		,{
			header: "dec_total_ingresos",
			flex:115 / 100,
			dataIndex: 'dec_total_ingresos',
			hidden:false,
			sortable:false
		}
		,{
			header: "dec_total_descuentos",
			flex:115 / 100,
			dataIndex: 'dec_total_descuentos',
			hidden:false,
			sortable:false
		}
		,{
			header: "dec_total_aportes",
			flex:115 / 100,
			dataIndex: 'dec_total_aportes',
			hidden:false,
			sortable:false
		}
		,{
			header: "neto_pagar",
			flex:115 / 100,
			dataIndex: 'neto_pagar',
			hidden:false,
			sortable:false
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		                        id:'form_filter_ReporteDetalleBoletaPersonal',
		                    	xtype: 'ReporteDetalleBoletaPersonalFilter',
		                        layout: {
		                            type: 'vbox'
		                        },
		                        fieldDefaults: {
		                            labelAlign: 'top',
		                            margin: "0 5 5 5"
		                        }

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
	            xtype: 'ReporteDetalleBoletaPersonalToolbarPaging',
	            dock:'top',
	            store: 'ReporteDetalleBoletaPersonal.MainStore',
	            displayInfo: true
	        }
        ];
		
		this.callParent(arguments);
		this.on('render', this.loadStore, this);
	},
    loadStore: function() {
        var form = Ext.getCmp('form_filter_ReporteDetalleBoletaPersonal');
        var values = form.getValues();
        this.getStore().load({params:values});
    }
});
