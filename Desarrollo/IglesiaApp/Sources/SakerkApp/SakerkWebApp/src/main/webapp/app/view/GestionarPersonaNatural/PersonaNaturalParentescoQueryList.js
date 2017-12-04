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
* DATE CREATE : 03/12/2014 03:40:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPersonaNatural.PersonaNaturalParentescoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.PersonaNaturalParentescoQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarPersonaNatural.PersonaNaturalParentescoQueryStore',

    columns: [
		{
	    	header: "Id",
			width: 170,
			flex:1,
			dataIndex: 'id_persona_parentesco',
			hidden:true
		}
		,{
			header: "id_persona_natural",
			width: 170,
			flex:1,
			dataIndex: 'id_persona_natural',
			hidden:true
		}
		,{
			header: "Nombres Completos",
			width: 170,
			flex:1,
			dataIndex: 'nombres_completos',
			hidden:false
		}
		,{
			header: "F.Nacimiento",
			width: 170,
			flex:1,
			dataIndex: 'fecha_nacimiento',
			hidden:false
		}
		,{
			header: "T.Documento",
			width: 170,
			flex:1,
			dataIndex: 'descrip_tipo_documento',
			hidden:false
		}
		,{
			header: "N.Documento",
			width: 170,
			flex:1,
			dataIndex: 'numero_documento',
			hidden:false
		}

		,{
			header: "Tipo Parentesco",
			width: 170,
			flex:1,
			dataIndex: 'descrip_tipo_parentesco',
			hidden:false
		}
		,{
			header: "Estado",
			width: 170,
			flex:1,
			dataIndex: 'descrip_estado_generico',
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
            store: 'GestionarPersonaNatural.PersonaNaturalParentescoQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
