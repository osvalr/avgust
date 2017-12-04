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
* DATE CREATE : 21/04/2015 20:40:38
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ConvocatoriaPlaza.ConvocatoriaEtapaQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ConvocatoriaEtapaQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'ConvocatoriaPlaza.ConvocatoriaEtapaQueryStore',

    columns: [
		{
	    	header: "srl_id_convocatoria",
			flex:115 / 100,
			dataIndex: 'srl_id_convocatoria',
			hidden:true
		}
		,{
			header: "srl_id_conv_fecha_etapa_config",
			flex:115 / 100,
			dataIndex: 'srl_id_conv_fecha_etapa_config',
			hidden:true
		}
		,{
			header: "srl_id_subetapa_proceso_seleccion",
			flex:115 / 100,
			dataIndex: 'srl_id_subetapa_proceso_seleccion',
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
			flex:180 / 100,
			dataIndex: 'var_descrip_subetapa',
			hidden:false
		}
		,{
			header: "Fecha de Inicio",
			flex:75 / 100,
			dataIndex: 'dte_fecha_inicio',
			hidden:false
		}
		,{
			header: "Fecha de Término",
			flex:75 / 100,
			dataIndex: 'dte_fecha_termino',
			hidden:false
		}
		
		,{
			header: "srl_id_etapa_proceso_seleccion",
			flex:115 / 100,
			dataIndex: 'srl_id_etapa_proceso_seleccion',
			hidden:true
		}
		
	],
	
	initComponent: function() {
		
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [
//            {
//            	glyph:'xf055@FontAwesome',
//                itemId: 'add',
//                text: 'Agregar',
//                action: 'add'
//            },{
//            	glyph:'xf056@FontAwesome',
//                text: 'Eliminar',
//                action: 'delete'
//            }
            ]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'ConvocatoriaPlaza.ConvocatoriaEtapaQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
