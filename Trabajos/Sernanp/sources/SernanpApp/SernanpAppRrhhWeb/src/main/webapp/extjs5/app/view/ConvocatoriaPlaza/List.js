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
* DATE CREATE : 20/04/2015 01:27:21
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ConvocatoriaPlaza.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ConvocatoriaPlazaList',
    
    requires: ['MyApp.view.ConvocatoriaPlaza.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Convocatoria',
    store: 'ConvocatoriaPlaza.MainStore',

    columns: [
      		{
      	    	header: "srl_id_convocatoria",
      			flex:115 / 100,
      			dataIndex: 'srl_id_convocatoria',
      			hidden:true,
      			sortable:true
      		}
      		,{
      			header: "Nº de Convocatoria",
      			flex:115 / 100,
      			dataIndex: 'var_num_convocatoria',
      			hidden:true,
      			sortable:true
      		}
      		,{
      			header: "Nº de Convocatoria",
      			flex:70 / 100,
      			dataIndex: 'var_num_convocatoria_corto',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "Fecha de Aprobación",
      			flex:115 / 100,
      			dataIndex: 'dte_fecha_aprobacion',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "F. Inicio de la Publicación",
      			flex:115 / 100,
      			dataIndex: 'dte_fecha_inicio_publicacion',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "F. Termino de la Publicación",
      			flex:115 / 100,
      			dataIndex: 'dte_fecha_termino_publicacion',
      			hidden:false,
      			sortable:true
      		}
      		,{
      			header: "idarea",
      			flex:115 / 100,
      			dataIndex: 'idarea',
      			hidden:true,
      			sortable:true
      		}
      		,{
      			header: "idunidad",
      			flex:115 / 100,
      			dataIndex: 'idunidad',
      			hidden:true,
      			sortable:true
      		}
      		,{
      			header: "Nº de Lanzamiento",
      			flex:115 / 100,
      			dataIndex: 'int_num_activacion',
      			hidden:true,
      			sortable:true
      		}
      		,{
      			header: "Estado",
      			flex:115 / 100,
      			dataIndex: 'int_id_estado',
      			hidden:true,
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
      			header: "Fecha de Registro",
      			flex:115 / 100,
      			dataIndex: 'tsp_fecha_registro',
      			hidden:false,
      			sortable:true
      		}
      	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ConvocatoriaPlazaFilter'
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
				            	glyph:'xf055@FontAwesome',
				                text: 'Relanzar',
				                action: 'relanzar'
				            },
				            
				            '-',
				            {
				            	glyph:'xf055@FontAwesome',
				                text: 'Generar Oficio',
				                action: 'MostrarFormOficioMintra'
				            },
				            
				            '-',
				            {
				            	glyph:'xf055@FontAwesome',
				                text: 'Genera Reporte Convocatoria',
				                action: 'MostrarFormConvocatoriaMintra'
				            },
				            '-',
				            /*
				            {
				            	glyph:'xf055@FontAwesome',
				                text: 'Reporte Vacantes Públicas',
				                action: 'generarReporteVacantesPublicas'
				            },
				            '-',
				            */
				            {
				            	glyph:'xf055@FontAwesome',
				                text: 'Genera Reporte Vacantes',
				                action: 'MostrarReporteVacantesPlaza'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ConvocatoriaPlaza.MainStore',
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
