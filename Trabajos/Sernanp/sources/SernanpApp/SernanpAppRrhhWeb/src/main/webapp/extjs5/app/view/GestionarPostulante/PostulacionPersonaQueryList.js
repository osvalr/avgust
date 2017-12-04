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

Ext.define('MyApp.view.GestionarPostulante.PostulacionPersonaQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.PostulacionPersonaQueryList',
    
    glyph:'xf022@FontAwesome',
	header: true,
    store: 'GestionarPostulante.PostulacionPersonaQueryStore',

    columns: [
		{
	    	header: "srl_id_postulante_conv_area_org",
			flex:115 / 100,
			dataIndex: 'srl_id_postulante_conv_area_org',
			hidden:true
		}
		,{
			header: "int_id_postulante",
			flex:115 / 100,
			dataIndex: 'int_id_postulante',
			hidden:true
		}
		,{
			header: "Convocatoria",
			flex:115 / 100,
			dataIndex: 'var_num_convocatoria',
			hidden:false
		}
		,{
			header: "Plaza",
			flex:115 / 100,
			dataIndex: 'var_codigo_postulacion',
			hidden:false
		}
        ,{
            xtype:'actioncolumn', 
            header: "Ficha Inscripción",
            flex:115 / 100,
            items: [
		               {
		            	icon:'img/icons/application_put.png',
		            	tooltip: 'Descargar',
		                handler: function(grid, rowIndex, colIndex) {
			                    var rec = grid.getStore().getAt(rowIndex);
//			                    alert("Edit " + rec.get('srl_id_archivo'));
			                    window.open('download-file-postulacion.action?srl_id_archivo='+rec.get('srl_id_archivo'), '_blank');
			                }
		               }
               ]
        }
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'var_nombre_estado',
			hidden:false
		}
		,{
			header: "Fecha Registro",
			flex:115 / 100,
			dataIndex: 'tsp_fecha_registro',
			hidden:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		 
//		{
//			title: 'Fichas (DNI y RUC)',
//			glyph:'xf022@FontAwesome',
//			items: [{id:'subModel_ArchivoPostulanteQuery', xtype:'ArchivoPostulanteQueryList'}]
//		},
		 
		 {
            xtype: 'toolbar',
            items: [{
            	glyph:'xf055@FontAwesome',
                itemId: 'add',
                text: 'Agregar Postulación',
                action: 'add'
            },{
            	glyph:'xf056@FontAwesome',
                text: 'Eliminar Postulación',
                action: 'delete'
            }]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarPostulante.PostulacionPersonaQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
