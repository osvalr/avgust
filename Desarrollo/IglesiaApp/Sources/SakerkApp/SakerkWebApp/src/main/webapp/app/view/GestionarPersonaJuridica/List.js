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
* DATE CREATE : 20/01/2015 13:21:31
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPersonaJuridica.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarPersonaJuridicaList',
    
    requires: ['MyApp.view.GestionarPersonaJuridica.ToolbarPaging','MyApp.view.GestionarPersonaJuridica.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'GestionarPersonaJuridica',
    store: 'GestionarPersonaJuridica.MainStore',

    columns: [
		{
	    	header: "Id",
			width: 170,
			flex:1,
			dataIndex: 'id_persona',
			hidden:false,
			sortable:false
		}
		,{
			header: "Razón Social",
			width: 170,
			flex:1,
			dataIndex: 'razon_social',
			hidden:false,
			sortable:false
		}
		,{
			header: "R.U.C",
			width: 170,
			flex:1,
			dataIndex: 'numero_ruc',
			hidden:false,
			sortable:false
		}
		,{
			header: "Tipo Persona Juridica",
			width: 170,
			flex:1,
			dataIndex: 'descrip_tipo_persona_juridica',
			hidden:false,
			sortable:false
		}
		,{
			header: "Nacionalidad",
			width: 170,
			flex:1,
			dataIndex: 'nombre_pais',
			hidden:false,
			sortable:false
		}
		,{
			header: "Estado",
			width: 170,
			flex:1,
			dataIndex: 'descrip_estado',
			hidden:false,
			sortable:false
		}
		,{
			header: "F.Registro",
			width: 170,
			flex:1,
			dataIndex: 'fecha_registro',
			hidden:false,
			sortable:false
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		                        id:'form_filter_GestionarPersonaJuridica',
		                    	xtype: 'GestionarPersonaJuridicaFilter',
		                        layout: {
		                            type: 'vbox'
		                        },
		                        fieldDefaults: {
		                            labelAlign: 'top',
		                            margin: "0 5 5 5"
		                        }

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
	            xtype: 'GestionarPersonaJuridicaToolbarPaging',
	            dock:'top',
	            store: 'GestionarPersonaJuridica.MainStore',
	            displayInfo: true
	        }
        ];
		
		this.callParent(arguments);
		this.on('render', this.loadStore, this);
	},
    loadStore: function() {
        var form = Ext.getCmp('form_filter_GestionarPersonaJuridica');
        var values = form.getValues();
        this.getStore().load({params:values});
    }
});
