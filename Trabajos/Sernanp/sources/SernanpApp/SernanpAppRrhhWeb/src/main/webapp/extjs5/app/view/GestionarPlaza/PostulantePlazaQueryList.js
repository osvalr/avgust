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
* DATE CREATE : 20/04/2015 01:10:00
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPlaza.PostulantePlazaQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.PostulantePlazaQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarPlaza.PostulantePlazaQueryStore',

    columns: [
		{
	    	header: "srl_id_postulante_conv_area_org",
			flex:115 / 100,
			dataIndex: 'srl_id_postulante_conv_area_org',
			hidden:true
		}
		,{
			header: "srl_id_conv_area_org",
			flex:115 / 100,
			dataIndex: 'srl_id_conv_area_org',
			hidden:true
		}
		,{
			header: "Nombres",
			flex:115 / 100,
			dataIndex: 'nombres_completos',
			hidden:false
		}
		,{
			header: "Tipo Documento",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_documento',
			hidden:false
		}
		,{
			header: "Número Documento",
			flex:115 / 100,
			dataIndex: 'numerodoc',
			hidden:false
		}
		,{
			header: "Orden Mérito",
			flex:115 / 100,
			dataIndex: 'int_orden_merito',
			hidden:false
		}
		,{
			header: "Puntaje Total",
			flex:115 / 100,
			dataIndex: 'dec_puntaje_total',
			hidden:false
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
			hidden:false
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		                    {
            xtype: 'toolbar',
            items: [
		            {
		            	glyph:'xf12b@FontAwesome',
		                text: 'Registrar Resultados',
		                action: 'registrarNotas'
		            },
		            {
		            	glyph:'xf12b@FontAwesome',
		                text: 'Seleccionar Ganadores',
		                action: 'seleccionarGanadores'
		            }
//	            ,{
//	            	glyph:'xf056@FontAwesome',
//	                text: 'Eliminar',
//	                action: 'delete'
//	            }
		    ]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarPlaza.PostulantePlazaQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
