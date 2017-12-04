/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 01/12/2014 19:55:03
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarTablaGeneral.TablaGeneralDetalleQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.TablaGeneralDetalleQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarTablaGeneral.TablaGeneralDetalleQueryStore',

    columns: [
		{
	    	header: "id_tabla_general_detalle",
			width: 170,
			flex:1,
			dataIndex: 'id_tabla_general_detalle',
			hidden:true
		}
		,{
			header: "id_tabla_general",
			width: 170,
			flex:1,
			dataIndex: 'id_tabla_general',
			hidden:true
		}
		,{
			header: "Valor",
			width: 170,
			flex:1,
			dataIndex: 'valor_general',
			hidden:false
		}
		,{
			header: "Campo A",
			width: 170,
			flex:1,
			dataIndex: 'campo_a',
			hidden:false
		}
		,{
			header: "Campo B",
			width: 170,
			flex:1,
			dataIndex: 'campo_b',
			hidden:false
		}
		,{
			header: "Campo C",
			width: 170,
			flex:1,
			dataIndex: 'campo_c',
			hidden:false
		}
		,{
			header: "Campo D",
			width: 170,
			flex:1,
			dataIndex: 'campo_d',
			hidden:false
		}
		,{
			header: "Campo E",
			width: 170,
			flex:1,
			dataIndex: 'campo_e',
			hidden:false
		}
		,{
			header: "Estado",
			width: 170,
			flex:1,
			dataIndex: 'id_estado',
			hidden:true
		}
		,{
			header: "Estado",
			width: 170,
			flex:1,
			dataIndex: 'descrip_estado',
			hidden:false
		}
		,{
			header: "Orden",
			width: 170,
			flex:1,
			dataIndex: 'orden',
			hidden:false
		}
		,{
			header: "F.Registro",
			width: 170,
			flex:1,
			dataIndex: 'fecha_registro',
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
            store: 'GestionarTablaGeneral.TablaGeneralDetalleQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
