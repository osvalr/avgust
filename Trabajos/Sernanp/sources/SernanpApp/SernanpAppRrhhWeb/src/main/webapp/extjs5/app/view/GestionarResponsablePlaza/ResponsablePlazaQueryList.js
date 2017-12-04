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
* DATE CREATE : 17/04/2015 16:51:57
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarResponsablePlaza.ResponsablePlazaQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ResponsablePlazaQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarResponsablePlaza.ResponsablePlazaQueryStore',

    columns: [
		{
	    	header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
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
            store: 'GestionarResponsablePlaza.ResponsablePlazaQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
