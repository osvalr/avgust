/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
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
* DATE CREATE : 22/01/2015 18:47:38
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.CongregacionLocalNumeroTelefonicoQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryStore',

    columns: [
		{
	    	header: "Id",
			width: 170,
			flex:1,
			dataIndex: 'id_numero_telefonico',
			hidden:true
		}
		,{
			header: "Numero",
			width: 170,
			flex:1,
			dataIndex: 'numero_telefono',
			hidden:false
		}
		,{
			header: "Tipo Telefono",
			width: 170,
			flex:1,
			dataIndex: 'descrip_tipo_telefono',
			hidden:false
		}
		,{
			header: "Empresa Operadora",
			width: 170,
			flex:1,
			dataIndex: 'razon_social',
			hidden:false
		}
		,{
			header: "Estado",
			width: 170,
			flex:1,
			dataIndex: 'descrip_estado',
			hidden:false
		}
		,{
			header: "F.Registro",
			width: 170,
			flex:1,
			dataIndex: 'fecha_registro',
			hidden:true
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
            store: 'GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
