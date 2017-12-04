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

Ext.define('MyApp.view.GestionarPlaza.SubEtapaPlazaQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.SubEtapaPlazaQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarPlaza.SubEtapaPlazaQueryStore',

    columns: [
		{
	    	header: "srl_id_conv_area_org_etapa",
			flex:115 / 100,
			dataIndex: 'srl_id_conv_area_org_etapa',
			hidden:true
		}
		,{
			header: "srl_id_conv_area_org",
			flex:115 / 100,
			dataIndex: 'srl_id_conv_area_org',
			hidden:true
		}
		,{
			header: "Etapa",
			flex:115 / 100,
			dataIndex: 'var_nombre_etapa',
			hidden:false
		}
		,{
			header: "Sub Etapa",
			flex:115 / 100,
			dataIndex: 'nombre_subetapa',
			hidden:false
		}
		,{
			header: "Fecha Inicio",
			flex:40 / 100,
			dataIndex: 'dte_fecha_inicio',
			hidden:false
		}
		,{
			header: "Fecha Termino",
			flex:40 / 100,
			dataIndex: 'dte_fecha_termino',
			hidden:false
		}
		,{
			header: "Área Organica",
			flex:70 / 100,
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
			header: "Estado",
			flex:40 / 100,
			dataIndex: 'descrip_estado',
			hidden:false
		}
		,{
			header: "Fecha Registro",
			flex:40 / 100,
			dataIndex: 'tsp_fecha_registro',
			hidden:false
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
//		                    {
//            xtype: 'toolbar',
//            items: [{
//            	glyph:'xf055@FontAwesome',
//                itemId: 'add',
//                text: 'Agregar',
//                action: 'add'
//            },{
//            	glyph:'xf056@FontAwesome',
//                text: 'Eliminar',
//                action: 'delete'
//            }]
//        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarPlaza.SubEtapaPlazaQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
