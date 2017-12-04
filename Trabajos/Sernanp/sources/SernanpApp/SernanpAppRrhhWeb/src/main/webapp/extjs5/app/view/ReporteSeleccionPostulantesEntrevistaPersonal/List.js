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
* DATE CREATE : 13/07/2015 14:25:29
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteSeleccionPostulantesEntrevistaPersonal.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReporteSeleccionPostulantesEntrevistaPersonalList',
    
    requires: ['MyApp.view.ReporteSeleccionPostulantesEntrevistaPersonal.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'ReporteSeleccionPostulantesEntrevistaPersonal',
    store: 'ReporteSeleccionPostulantesEntrevistaPersonal.MainStore',

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
			flex:180 / 100,
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
			flex:100 / 100,
			dataIndex: 'tipodocumento',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nro. Documento",
			flex:100 / 100,
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
			header: "Etapa",
			flex:115 / 100,
			dataIndex: 'var_nombre_etapa',
			hidden:false,
			sortable:true
		}
		,{
			header: "Sub Etapa",
			flex:115 / 100,
			dataIndex: 'var_descrip_subetapa',
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
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReporteSeleccionPostulantesEntrevistaPersonalFilter'
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
				                text: 'GenerarReporte',
				                action: 'generarReporte'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReporteSeleccionPostulantesEntrevistaPersonal.MainStore',
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
