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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPostulante.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarPostulanteList',
    
    requires: ['MyApp.view.GestionarPostulante.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Postulante',
    store: 'GestionarPostulante.MainStore',

    columns: [
		{
	    	header: "idpersona",
			flex:115 / 100,
			dataIndex: 'idpersona',
			hidden:true,
			sortable:true
		}
		,{
			header: "Id",
			flex:50 / 100,
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
			header: "Nombres",
			flex:250 / 100,
			dataIndex: 'nombres_completos',
			hidden:false,
			sortable:true
		}
		,{
			header: "Documento",
			flex:80 / 100,
			dataIndex: 'descrip_tipo_documento',
			hidden:false,
			sortable:true
		}
		,{
			header: "N°. Doc.",
			flex:80 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "R.U.C",
			flex:80 / 100,
			dataIndex: 'ruc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Genero",
			flex:80 / 100,
			dataIndex: 'descrip_sexo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Pais",
			flex:115 / 100,
			dataIndex: 'nompais',
			hidden:false,
			sortable:true
		}
		
        //ADD 28-01-2016 DAVID
		,{
			header: "Nro. Convocatoria",
			flex:100 / 100,
			dataIndex: 'var_num_convocatoria',
			hidden:false,
			sortable:true
		}
		,{
			header: "Lanzamiento",
			flex:50 / 100,
			dataIndex: 'lanzamiento',
			hidden:true,
			sortable:true
		}		
		,{
			header: "Estado Convocatoria",
			flex:80 / 100,
			dataIndex: 'des_estado_convocatoria',
			hidden:true,
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
			header: "Código Postulación",
			flex:115 / 100,
			dataIndex: 'var_codigo_postulacion',
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
			header: "Dirección / Oficina / Jefatura",
			flex:115 / 100,
			dataIndex: 'desarea',
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
			header: "Unidad Operativa",
			flex:115 / 100,
			dataIndex: 'nomunidad',
			hidden:true,
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
			header: "estado_postulante_cnv_area_org",
			flex:115 / 100,
			dataIndex: 'estado_postulante_cnv_area_org',
			hidden:true,
			sortable:true
		}
		
		,{
			header: "Etapa Evaluación",
			flex:120 / 100,
			dataIndex: 'evaluacion',
			hidden:false,
			sortable:true
		}

		,{
			header: "Puntaje",
			flex:50 / 100,
			dataIndex: 'dec_puntaje_obtenido',
			hidden:false,
			sortable:true
		}
		
		,{
			header: "Puntaje Total",
			flex:80 / 100,
			dataIndex: 'dec_puntaje_total',
			hidden:false,
			sortable:true
		}
		
		,{
			header: "Estado",
			flex:85 / 100,
			dataIndex: 'des_estado_postulante_cnv_area_org',
			hidden:false,
			sortable:true
		}		
		
		,{
			header: "Fecha Registro",
			flex:80 / 100,
			dataIndex: 'tsp_fecha_registro',
			hidden:false,
			sortable:true
		}
		// END
		
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarPostulanteFilter'
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
				                text: 'Nuevo postulante',
				                action: 'add'
				            },
				            '-',
				            {
				            	glyph:'xf056@FontAwesome',
				                text: 'Eliminar',
				                action: 'delete'
				            },
				            
				            '-',
				            {
				            	glyph:'xf01a@FontAwesome',
				                text: 'Generar Reportes',
				                //action: 'generarReportePDF'
				                action: 'MostrarEditReportePostulante'
				            }
				            /*,
				            '-',
				            {
				            	glyph:'xf01a@FontAwesome',
				                text: 'XLS',
				                action: 'generarReporteXLS'
				            }*/
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarPostulante.MainStore',
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
