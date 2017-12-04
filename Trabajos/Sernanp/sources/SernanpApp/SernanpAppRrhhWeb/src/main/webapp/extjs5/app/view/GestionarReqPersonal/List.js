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
* DATE CREATE : 13/03/2015 00:50:29
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarReqPersonal.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarReqPersonalList',
    
    requires: ['MyApp.view.GestionarReqPersonal.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Requerimientos de Personal',
    store: 'GestionarReqPersonal.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:30 / 100,
			dataIndex: 'srl_id_requerimiento_personal',
			hidden:false,
			sortable:false
		}
		,{
			header: "Nro. de Req.",
			flex:80 / 100,
			dataIndex: 'var_numero_requerimiento',
			hidden:true,
			sortable:true
		}
		,{
			header: "Nro. de Req.",
			flex:80 / 100,
			dataIndex: 'var_numero_requerimiento_corto',
			hidden:false,
			sortable:true
		}
		
		
		,{
			header: "idcategoriaanp.",
			flex:80 / 100,
			dataIndex: 'idcategoriaanp',
			hidden:true,
			sortable:true
		}
		
		,{
			header: "Categoria.",
			flex:140 / 100,
			dataIndex: 'descategoriaanp',
			hidden:true,
			sortable:true
		}
		,{
			header: "Id FF.",
			flex:140 / 100,
			dataIndex: 'srl_id_fuente_financiamiento',
			hidden:true,
			sortable:true
		}
		
		,{
			header: "idareanatural",
			flex:80 / 100,
			dataIndex: 'idareanatural',
			hidden:true,
			sortable:true
		}
		
		,{
			header: "Area Natural",
			flex:160 / 100,
			dataIndex: 'desareanatural',
			hidden:true,
			sortable:true
		}
		
		
		
		,{
			header: "Área Solicitante",
			flex:160 / 100,
			dataIndex: 'idarea_solicitante',
			hidden:true,
			sortable:true
		}
		,{
			header: "A.O. Solicitante",
			flex:160 / 100,
			dataIndex: 'descrip_area_solicitante',
			hidden:false,
			sortable:true
		}

		,{
			header: "U.O. Solicitante",
			flex:115 / 100,
			dataIndex: 'idunidad_solicitante',
			hidden:true,
			sortable:true
		}
		,{
			header: "U.O. Solicitante",
			flex:180 / 100,
			dataIndex: 'descrip_unidad_solicitante',
			hidden:false,
			sortable:true
		}
		
		
		,{
			header: "Sede Administrativa",
			flex:180 / 100,
			dataIndex: 'var_nomb_sede',
			hidden:false,
			sortable:true
		}

		,{
			header: "A.O. Supervisora",
			flex:160 / 100,
			dataIndex: 'descrip_area_supervisora',
			hidden:false,
			sortable:true
		}
		,{
			header: "U. O. Supervisora",
			flex:115 / 100,
			dataIndex: 'idunidad_supervisora',
			hidden:true,
			sortable:true
		}
		,{
			header: "U. O. Supervisora",
			flex:180 / 100,
			dataIndex: 'descrip_unidad_supervisora',
			hidden:false,
			sortable:true
		}
		,{
			header: "Cantidad",
			flex:50 / 100,
			dataIndex: 'int_cantidad_requerida',
			hidden:false,
			sortable:true
		}
		,{
			header: "Honorario",
			flex:115 / 100,
			dataIndex: 'dec_honorario_personal',
			hidden:true,
			sortable:true
		}
		,{
			header: "Inicio Periodo",
			flex:115 / 100,
			dataIndex: 'dte_fecha_inicio_periodo',
			hidden:true,
			sortable:true
		}
		,{
			header: "Fin Periodo",
			flex:115 / 100,
			dataIndex: 'dte_fecha_termino_periodo',
			hidden:true,
			sortable:true
		}
		,{
			header: "Tiempo",
			flex:115 / 100,
			dataIndex: 'int_cant_periodo',
			hidden:true,
			sortable:true
		}
		,{
			header: "Unidad Tiempo",
			flex:115 / 100,
			dataIndex: 'int_id_tipo_periodo',
			hidden:true,
			sortable:true
		}
		,{
			header: "Experiencia Requerida",
			flex:115 / 100,
			dataIndex: 'var_experiencia_requerida',
			hidden:true,
			sortable:true
		}
		,{
			header: "Competencia Requerida",
			flex:115 / 100,
			dataIndex: 'var_competencias_requeridas',
			hidden:true,
			sortable:true
		}
		,{
			header: "Formación Académica",
			flex:115 / 100,
			dataIndex: 'var_formacion_academica',
			hidden:true,
			sortable:true
		}
		,{
			header: "Cursos / Especializaciones",
			flex:115 / 100,
			dataIndex: 'var_cursos_especializacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "Requisitos para el puesto",
			flex:115 / 100,
			dataIndex: 'var_requisitos_puesto',
			hidden:true,
			sortable:true
		}
		,{
			header: "Principales Funciones",
			flex:115 / 100,
			dataIndex: 'var_principales_funciones',
			hidden:true,
			sortable:true
		}
		,{
			header: "Req. Evaluación Escrita",
			flex:115 / 100,
			dataIndex: 'int_requiere_evaluacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "FF",
			flex:40 / 100,
			dataIndex: 'c_fte_fto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fte. Fto.",
			flex:40 / 100,
			dataIndex: 'var_descrip_fte_fto',
			hidden:true,
			sortable:true
		}
		,{
			header: "MP",
			flex:40 / 100,
			dataIndex: 'c_meta',
			hidden:false,
			sortable:true
		}
		,{
			header: "T. Trabajador",
			flex:60 / 100,
			dataIndex: 'descrip_trabajador',
			hidden:false,
			sortable:true
		}
		,{
			header: "Lugar Prestación",
			flex:115 / 100,
			dataIndex: 'var_lugar_prestacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "Estado",
			flex:60 / 100,
			dataIndex: 'int_id_estado',
			hidden:true,
			sortable:true
		}
		,{
			header: "Estado",
			flex:80 / 100,
			dataIndex: 'descrip_estado',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fecha de Registro",
			flex:80 / 100,
			dataIndex: 'tsp_fecha_registro',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarReqPersonalFilter',
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
				            /*
				            '-',				            
				            {
				            	glyph:'xf055@FontAwesome',
				                text: 'Nuevo',
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
				            	glyph:'xf055@FontAwesome',
				                text: 'Generar Oficio de Requerimientos',
				                action: 'generarOficioMintra'
				            }*/
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarReqPersonal.MainStore',
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
