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
* DATE CREATE : 07/04/2015 17:43:08
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionaNomina.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionaNominaList',
    
    requires: ['MyApp.view.GestionaNomina.Filter','MyApp.view.GestionaNomina.Totales'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Nominas',
    store: 'GestionaNomina.MainStore',
    

    columns: [
		{
	    	header: "Id",
			flex:60 / 100,
			dataIndex: 'srl_id_nomina_anio_periodo_personal',
			hidden:true,
			sortable:true
		}
		,{
			header: "Año",
			flex:70 / 100,
			dataIndex: 'int_anio',
			hidden:false,
			sortable:true
		}
		,{
			header: "Periodo",
			flex:115 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombres completos",
			flex:300 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "T.D",
			flex:70 / 100,
			dataIndex: 'descrip_documento',
			hidden:false,
			sortable:true
		}
		,{
			header: "N.D",
			flex:115 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Régimen",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
			sortable:true
		}
		,{
			header: "Cargo",
			flex:250 / 100,
			dataIndex: 'var_nom_cargo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fte Fto",
			flex:75 / 100,
			dataIndex: 'c_fte_fto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Meta",
			flex:75 / 100,
			dataIndex: 'c_meta',
			hidden:false,
			sortable:true
		}
		,{
			header: "Ingresos",
			flex:85 / 100,
			dataIndex: 'dec_total_ingresos',
			hidden:false,
			sortable:true
		}
		,{
			header: "Descuentos",
			flex:100 / 100,
			dataIndex: 'dec_total_descuentos',
			hidden:false,
			sortable:true
		}
		,{
			header: "Aportes",
			flex:85 / 100,
			dataIndex: 'dec_total_aportes',
			hidden:false,
			sortable:true
		}
		,{
			header: "Neto",
			flex:85 / 100,
			dataIndex: 'dec_total_neto',
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
		          xtype: 'GestionaNominaFilter'
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
				            	glyph:'xf056@FontAwesome',
				                text: 'Eliminar',
				                action: 'delete'
				            },
				            '-',
				            {
				            	glyph:'xf013@FontAwesome',
				                text: 'Generar Nomina',
				                action: 'show'
				            },
				            '-',
				            {
				            	glyph:'xf013@FontAwesome',
				                text: 'Nomina Extraordinaria',
				                action: 'showNominaExtraordinaria'
				            },
				            '-',
				            {
				            	glyph:'xf013@FontAwesome',
				                text: 'Obtener Descuentos Desp. y Asist.',
				                action: 'showDescuentoDa'
				            },
				            '-',
				            {
				            	glyph:'xf013@FontAwesome',
				                text: 'Generar Archivos TXT-SIAF',
				                action: 'showGenerarPlame'
				            }
//				            ,
//				            {
//				            	glyph:	'xf013@FontAwesome',
//				            	text:	'Planilla preliminar',
//				            	action:	'showGeneraReportePlanillaPreliminar'
//				            }
				           
				            
			           ]
	        },
	        
	        {
            	xtype: 'container',
            	layout: {
            		type: 'hbox',
            		align: 'stretch'
            		
            	},
            	items: [
            	        
            	        {
            	            xtype: 'container',
            	            flex: 1
            	        },
            	        {
            		          xtype: 'GestionaNominaTotales'
            		    }
            	        
            	        ]
            },
	        
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionaNomina.MainStore',
	            displayInfo: true
	        }
        ];
		
		this.callParent(arguments);
        this.on('afterrender', this.loadStore, this);
	},
    loadStore: function() {
        this.getStore().load();
        if (Ext.get('page-loader')) {
            Ext.get('page-loader').remove();
        }
        
        ////////

        var form = Ext.getCmp('form_filter_GestionaNomina');
        var formTotales = Ext.getCmp('form_totales_GestionaNomina');
        
        var cantidad_nominas = formTotales.getForm().findField('cantidad_nominas');
        var total_ingresos = formTotales.getForm().findField('total_ingresos');
        var total_descuentos = formTotales.getForm().findField('total_descuentos');
        var total_aportes = formTotales.getForm().findField('total_aportes');
        var total_neto = formTotales.getForm().findField('total_neto');
        
        var values = form.getValues();
 
        Ext.Ajax.request({
	            method: 'GET',
	            url: 'GestionaNominaTotalesView.action',
	            params: values,
	            success: function( result, request ){

	            	var json = Ext.JSON.decode(result.responseText);
	            	
	            	cantidad_nominas.setValue(json.record.cantidad_nominas);
	            	total_ingresos.setValue(json.record.total_ingresos);
	            	total_descuentos.setValue(json.record.total_descuentos);
	            	total_aportes.setValue(json.record.total_aportes);
	            	total_neto.setValue(json.record.total_neto);
	            },
		        failure: function (batch, eOpts) {
		        	store.rejectChanges();
		        }
	        });
    	
    	///////
        
    }
});
