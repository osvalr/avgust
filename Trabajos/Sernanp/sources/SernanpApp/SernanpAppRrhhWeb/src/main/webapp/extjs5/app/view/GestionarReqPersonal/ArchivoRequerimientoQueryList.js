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
* DATE CREATE : 19/04/2015 01:20:12
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarReqPersonal.ArchivoRequerimientoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ArchivoRequerimientoQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarReqPersonal.ArchivoRequerimientoQueryStore',

    columns: [
		{
	    	header: "srl_id_archivo",
			flex:115 / 100,
			dataIndex: 'srl_id_archivo',
			hidden:true
		}
		,{
			header: "srl_id_requerimiento_personal",
			flex:115 / 100,
			dataIndex: 'srl_id_requerimiento_personal',
			hidden:true
		}
		,{
			header: "Descripción",
			flex:115 / 100,
			dataIndex: 'var_descripcion_archivo',
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
		
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [
                    
		             {
		            	glyph:'xf055@FontAwesome',
		                itemId: 'add',
		                text: 'Agregar',
		                action: 'add'
		            }
		            ,{
		            	glyph:'xf056@FontAwesome',
		                text: 'Eliminar',
		                action: 'delete'
		            },
		            
		            {
		            	glyph:'xf0ab@FontAwesome',
		                text: 'Descargar',
		                action: 'download'
		            }
		          ]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarReqPersonal.ArchivoRequerimientoQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
