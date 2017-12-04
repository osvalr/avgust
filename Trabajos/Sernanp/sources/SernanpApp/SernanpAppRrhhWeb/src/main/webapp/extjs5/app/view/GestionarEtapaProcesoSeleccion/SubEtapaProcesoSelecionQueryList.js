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
* DATE CREATE : 18/04/2015 18:55:24
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarEtapaProcesoSeleccion.SubEtapaProcesoSelecionQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.SubEtapaProcesoSelecionQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarEtapaProcesoSeleccion.SubEtapaProcesoSelecionQueryStore',

    columns: [
		{
	    	header: "srl_id_subetapa_proceso_seleccion",
			flex:115 / 100,
			dataIndex: 'srl_id_subetapa_proceso_seleccion',
			hidden:true
		}
		,{
			header: "srl_id_etapa_proceso_seleccion",
			flex:115 / 100,
			dataIndex: 'srl_id_etapa_proceso_seleccion',
			hidden:true
		}
		,{
			header: "Área Organica",
			flex:115 / 100,
			dataIndex: 'desarea',
			hidden:false
		}
		,{
			header: "Unidad Operativa",
			flex:115 / 100,
			dataIndex: 'nomunidad',
			hidden:false
		}
		,{
			header: "Nombre",
			flex:115 / 100,
			dataIndex: 'var_descrip_subetapa',
			hidden:false
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
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
            items: [{
            	glyph:'xf055@FontAwesome',
                itemId: 'add',
                text: 'Agregar',
                action: 'add'
            },{
            	glyph:'xf056@FontAwesome',
                text: 'Eliminar',
                action: 'delete'
            }]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarEtapaProcesoSeleccion.SubEtapaProcesoSelecionQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
