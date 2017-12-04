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
* DATE CREATE : 10/07/2015 13:32:32
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteSeleccionPostulantesFichaPostulacion.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteSeleccionPostulantesFichaPostulacionList',
    
    requires: ['MyApp.view.ReporteSeleccionPostulantesFichaPostulacion.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Postulantes Etapas de Evalución',
    store: 'ReporteSeleccionPostulantesFichaPostulacion.MainStore',

    columns: [
		{
	    	header: "idpersona",
			flex:115 / 100,
			dataIndex: 'idpersona',
			hidden:true,
			sortable:true
		}
		,{
			header: "idpersonanatural",
			flex:115 / 100,
			dataIndex: 'idpersonanatural',
			hidden:true,
			sortable:true
		}
		,{
			header: "int_id_postulante",
			flex:115 / 100,
			dataIndex: 'int_id_postulante',
			hidden:true,
			sortable:true
		}
		,{
			header: "Nombre Completo",
			flex:200 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
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
			header: "Documento",
			flex:80 / 100,
			dataIndex: 'tipodocumento',
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
			header: "srl_id_convocatoria",
			flex:115 / 100,
			dataIndex: 'srl_id_convocatoria',
			hidden:true,
			sortable:true
		}
		,{
			header: "Convocatoria",
			flex:115 / 100,
			dataIndex: 'var_num_convocatoria',
			hidden:false,
			sortable:true
		}
		,{
			header: "estado_convocatoria",
			flex:115 / 100,
			dataIndex: 'estado_convocatoria',
			hidden:true,
			sortable:true
		}
		,{
			header: "srl_id_conv_area_org",
			flex:115 / 100,
			dataIndex: 'srl_id_conv_area_org',
			hidden:true,
			sortable:true
		}
		
		,{
			header: "Plaza",
			flex:115 / 100,
			dataIndex: 'var_codigo_postulacion',
			hidden:false,
			sortable:true
		}
		
		,{
			header: "Sede Administrativa",
			flex:115 / 100,
			dataIndex: 'var_nomb_sede',
			hidden:false,
			sortable:true
		}		

		,{
			header: "int_id_tipo_factor",
			flex:115 / 100,
			dataIndex: 'int_id_tipo_factor',
			hidden:true,
			sortable:true
		}
		,{
			header: "Etapa Evaluación",
			flex:115 / 100,
			dataIndex: 'evaluacion',
			hidden:false,
			sortable:true
		}
		,{
			header: "int_id_estado_asistencia",
			flex:115 / 100,
			dataIndex: 'int_id_estado_asistencia',
			hidden:true,
			sortable:true
		}
		,{
			header: "Puntaje",
			flex:115 / 100,
			dataIndex: 'dec_puntaje_obtenido',
			hidden:false,
			sortable:true
		}
		,{
			header: "int_id_estado_clasificacion",
			flex:115 / 100,
			dataIndex: 'int_id_estado_clasificacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'des_estado_postulante_cnv_area_org',
			hidden:true,
			sortable:true
		}
	
	
		
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteSeleccionPostulantesFichaPostulacionFilter'
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
				            	glyph:'xf01a@FontAwesome',
				                text: 'PDF',
				                action: 'generarReportePDF'
				            }	
				            ,
				            '-',
				            {
				            	glyph:'xf01a@FontAwesome',
				                text: 'XLS',
				                action: 'generarReporteXLS'
				            }
				       ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteSeleccionPostulantesFichaPostulacion.MainStore',
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
