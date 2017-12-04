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
* DATE CREATE : 27/05/2015 02:48:17
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarTrabajadores.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarTrabajadoresList',
    
    requires: ['MyApp.view.GestionarTrabajadores.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'GestionarTrabajadores',
    store: 'GestionarTrabajadores.MainStore',

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
			flex:45 / 100,
			dataIndex: 'idpersonanatural',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombres",
			flex:160 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombres",
			flex:115 / 100,
			dataIndex: 'nombre',
			hidden:true,
			sortable:true
		}
		,{
			header: "apepat",
			flex:115 / 100,
			dataIndex: 'apepat',
			hidden:true,
			sortable:true
		}
		,{
			header: "Apellido Materno",
			flex:115 / 100,
			dataIndex: 'apemat',
			hidden:true,
			sortable:true
		}
		,{
			header: "Tipo de Doc.",
			flex:45 / 100,
			dataIndex: 'idtipodocumento',
			hidden:true,
			sortable:true
		}
		,{
			header: "Tipo de Doc.",
			flex:60 / 100,
			dataIndex: 'descrip_documento',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nº de Doc.",
			flex:60 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Ruc",
			flex:60 / 100,
			dataIndex: 'ruc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Dirección",
			flex:250 / 100,
			dataIndex: 'direccion',
			hidden:false,
			sortable:true
		}
		,{
			header: "Pais",
			flex:60 / 100,
			dataIndex: 'idpais',
			hidden:true,
			sortable:true
		}
		,{
			header: "Pais",
			flex:80 / 100,
			dataIndex: 'nompais',
			hidden:false,
			sortable:true
		}
		,{
			header: "Género",
			flex:40 / 100,
			dataIndex: 'idsexo',
			hidden:true,
			sortable:true
		}
		,{
			header: "Género",
			flex:40 / 100,
			dataIndex: 'descrip_genero',
			hidden:false,
			sortable:true
		}
		,{
			header: "F. Nacimiento",
			flex:60 / 100,
			dataIndex: 'fechanacimiento',
			hidden:false,
			sortable:true
		}
		,{
			header: "Teléfono",
			flex:60 / 100,
			dataIndex: 'telefono',
			hidden:false,
			sortable:true
		}
		,{
			header: "Correo",
			flex:150 / 100,
			dataIndex: 'correopersonal',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarTrabajadoresFilter'
		     },
			 {
	            xtype: 'toolbar',
	            items: [
				            {
				            	glyph:'xf0b0@FontAwesome',
				                text: 'Filtrar',
				                action: 'filter'
				            },
				            '-',
				            {
				            	glyph:'xf12d@FontAwesome',
				                text: 'Limpiar',
				                action: 'clearFilter'
				            },
				            '-',
				            {
				            	glyph:'xf055@FontAwesome',
				                text: 'Agregar',
				                action: 'add'
				            },
				            '-',
				            {
				            	glyph:'xf056@FontAwesome',
				                text: 'Eliminar',
				                action: 'delete'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarTrabajadores.MainStore',
	            displayInfo: true
	        }
        ];
		
		this.callParent(arguments);
        this.on('render', this.loadStore, this);
	},
    loadStore: function() {
        this.getStore().load();
        if (Ext.get('page-loader')) {
            Ext.get('page-loader').remove();
        }
    }
});
