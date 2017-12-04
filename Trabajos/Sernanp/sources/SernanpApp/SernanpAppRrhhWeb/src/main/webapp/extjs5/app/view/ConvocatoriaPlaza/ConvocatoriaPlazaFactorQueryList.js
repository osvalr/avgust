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
* DATE CREATE : 23/04/2015 16:49:26
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ConvocatoriaPlazaFactorQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryStore',

    columns: [
		{
	    	header: "srl_id_factor_evaluacion",
			flex:115 / 100,
			dataIndex: 'srl_id_factor_evaluacion',
			hidden:true
		}
		,{
			header: "srl_id_configuracion_factor_evaluacion",
			flex:115 / 100,
			dataIndex: 'srl_id_configuracion_factor_evaluacion',
			hidden:true
		}
		,{
			header: "int_id_tipo_factor_padre",
			flex:115 / 100,
			dataIndex: 'int_id_tipo_factor_padre',
			hidden:true
		}
		,{
			header: "Factor",
			flex:150 / 100,
			dataIndex: 'descrip_tipo_factor_padre',
			hidden:false
			
		}
		,{
			header: "int_id_tipo_factor",
			flex:115 / 100,
			dataIndex: 'int_id_tipo_factor',
			hidden:true
		}
		,{
			header: "Sub Factor",
			flex:180 / 100,
			dataIndex: 'descrip_tipo_factor',
			hidden:false
		}
		,{
			header: "Peso",
			flex:70 / 100,
			dataIndex: 'dec_peso',
			hidden:false
		}
		,{
			header: "Puntaje Mínimo",
			flex:70 / 100,
			dataIndex: 'dec_puntaje_min',
			hidden:false
		}
		,{
			header: "Puntaje Máximo",
			flex:70/ 100,
			dataIndex: 'dec_puntaje_max',
			hidden:false
		}
		
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'int_id_estado',
			hidden:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
			hidden:true
		}
		,{
			header: "tsp_fecha_registro",
			flex:115 / 100,
			dataIndex: 'tsp_fecha_registro',
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
            store: 'ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
