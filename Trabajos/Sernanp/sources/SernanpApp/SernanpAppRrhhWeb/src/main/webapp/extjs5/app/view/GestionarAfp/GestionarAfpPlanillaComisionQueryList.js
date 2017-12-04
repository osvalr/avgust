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
* DATE CREATE : 17/03/2015 19:55:09
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAfp.GestionarAfpPlanillaComisionQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarAfpPlanillaComisionQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarAfp.GestionarAfpPlanillaComisionQueryStore',

    columns: [
		{
	    	header: "Nro.",
			flex:20 / 100,
			dataIndex: 'srl_id_afp_comision',
			hidden:false
		}
		,{
			header: "afp",
			flex:115 / 100,
			dataIndex: 'srl_id_afp',
			hidden:true
		}
		,{
			header: "Tipo Comisión",
			flex:115 / 100,
			dataIndex: 'int_id_tipo_comision',
			hidden:true
		}
		,{
			header: "Comisión",
			flex:200 / 100,
			dataIndex: 'descrip_tipo_comision',
			hidden:false
		}
		,{
			header: "Aporte",
			flex:50 / 100,
			dataIndex: 'dec_aporte',
			hidden:false
		}
		,{
			header: "Seguro",
			flex:50 / 100,
			dataIndex: 'dec_seguro',
			hidden:false
		}
		,{
			header: "Comisión",
			flex:50 / 100,
			dataIndex: 'dec_comision',
			hidden:false
		}
		,{
			header: "Tipo Estado",
			flex:115 / 100,
			dataIndex: 'int_id_estado',
			hidden:true
		}
		,{
			header: "Estado",
			flex:100 / 100,
			dataIndex: 'descrip_estado',
			hidden:false
		}
		,{
			header: "Fecha Registro",
			flex:100 / 100,
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
            store: 'GestionarAfp.GestionarAfpPlanillaComisionQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
