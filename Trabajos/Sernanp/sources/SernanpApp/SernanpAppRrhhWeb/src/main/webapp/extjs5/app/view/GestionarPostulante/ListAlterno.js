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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPostulante.ListAlterno' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarPostulanteListAlterno',
    
    glyph:'xf022@FontAwesome',

    title : 'Información del Postulante',
    
    store: 'GestionarPostulante.MainStore',

    columns: [
		{
	    	header: "idpersona",
			flex:115 / 100,
			dataIndex: 'idpersona',
			hidden:true,
			sortable:true
		}
		,{
			header: "Id",
			flex:50 / 100,
			dataIndex: 'idpersonanatural',
			hidden:false,
			sortable:true
		}
		,{
			header: "int_id_postulante",
			flex:115 / 100,
			dataIndex: 'int_id_postulante',
			hidden:true,
			sortable:true
		}
		,{
			header: "Nombres",
			flex:300 / 100,
			dataIndex: 'nombres_completos',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo Documento",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_documento',
			hidden:false,
			sortable:true
		}
		,{
			header: "N.D",
			flex:115 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "R.U.C",
			flex:115 / 100,
			dataIndex: 'ruc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Genero",
			flex:115 / 100,
			dataIndex: 'descrip_sexo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Pais",
			flex:115 / 100,
			dataIndex: 'nompais',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarPostulanteFilter',
		          hidden:true
		     },
			 {
		            xtype: 'toolbar',
		            items: [
					            {
					            	glyph:'xf055@FontAwesome',
					                text: 'Registrarme',
					                action: 'add'
					            }
				           ]
		        }
        ];
		
		this.callParent(arguments);
        this.on('render', this.loadStore, this);
	},
    loadStore: function() {
//        this.getStore().load({
//			scope: this,
//			callback: function(records, operation, success) {
//
//			}
//		});
    	
    	var edit = Ext.create('MyApp.view.GestionarPostulante.FindPostulanteWindow').show();
    	
        if (Ext.get('page-loader')) {
            Ext.get('page-loader').remove();
        }
    }
});
