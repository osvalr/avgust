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
* DATE CREATE : 20/04/2015 15:33:18
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarNotasPostulante.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarNotasPostulanteList',
    
    requires: ['MyApp.view.GestionarNotasPostulante.Filter'],

    glyph:'xf022@FontAwesome',
    header:true,
//    title : 'Gestionar Notas',
    store: 'GestionarNotasPostulante.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:115 / 100,
			dataIndex: 'srl_conv_area_org_factor_eval',
			hidden:true,
			sortable:true
		}
		,{
			header: "srl_id_postulante_conv_area_org",
			flex:115 / 100,
			dataIndex: 'srl_id_postulante_conv_area_org',
			hidden:true,
			sortable:true
		}
		,{
			header: "Factor Predecesor",
			flex:300 / 100,
			dataIndex: 'descrip_factor_evaluacion_padre',
			hidden:true,
			sortable:true
		}
		,{
			header: "srl_id_factor_evaluacion",
			flex:115 / 100,
			dataIndex: 'srl_id_factor_evaluacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "Factor",
			flex:300 / 100,
			dataIndex: 'descrip_facto_evaluacion',
			hidden:false,
			sortable:false
		}
		,{
			header: "Asistencia",
			flex:115 / 100,
			dataIndex: 'descrip_estado_asistencia',
			hidden:false,
			sortable:false
		}
		,{
			header: "P. Obtenido",
			flex:115 / 100,
			dataIndex: 'dec_puntaje_obtenido',
			hidden:false,
			sortable:false
		}
		,{
			header: "P. Calculado",
			flex:115 / 100,
			dataIndex: 'dec_puntaje_calculado',
			hidden:false,
			sortable:false
		}
		,{
			header: "Clasificación",
			flex:115 / 100,
			dataIndex: 'descrip_estado_clasificacion',
			hidden:false,
			sortable:false
		}
//		,{
//			header: "Estado",
//			flex:115 / 100,
//			dataIndex: 'descrip_estado',
//			hidden:false,
//			sortable:true
//		}
//		,{
//			header: "Fecha Registro",
//			flex:115 / 100,
//			dataIndex: 'tsp_fecha_registro',
//			hidden:false,
//			sortable:true
//		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarNotasPostulanteFilter'
		     },
//			 {
//	            xtype: 'toolbar',
//	            items: [
//				            {
//				            	glyph:'xf0b0@FontAwesome',
//				                text: 'Filtrar',
//				                action: 'filter'
//				            },
//				            '-',
//				            {
//				            	glyph:'xf12d@FontAwesome',
//				                text: 'Limpiar',
//				                action: 'clearFilter'
//				            },
//				            '-',
//				            {
//				            	glyph:'xf055@FontAwesome',
//				                text: 'Agregar',
//				                action: 'add'
//				            },
//				            '-',
//				            {
//				            	glyph:'xf056@FontAwesome',
//				                text: 'Eliminar',
//				                action: 'delete'
//				            }
//			           ]
//	        },
	        {
//	            xtype: 'pagingtoolbar',
	            dock:'top',
//	            store: 'GestionarNotasPostulante.MainStore',
	            displayInfo: true

	        }
        ];
		
		this.callParent(arguments);
        this.on('render', this.loadStore, this);
	},
    loadStore: function() {
    	
        this.getStore().load();
        
        
    }
});
