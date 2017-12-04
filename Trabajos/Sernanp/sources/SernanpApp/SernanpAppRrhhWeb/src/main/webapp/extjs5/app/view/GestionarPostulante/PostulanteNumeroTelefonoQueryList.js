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

Ext.define('MyApp.view.GestionarPostulante.PostulanteNumeroTelefonoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.PostulanteNumeroTelefonoQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarPostulante.PostulanteNumeroTelefonoQueryStore',

    columns: [
		{
	    	header: "srl_id_numero_telefono",
			flex:115 / 100,
			dataIndex: 'srl_id_numero_telefono',
			hidden:true
		}
		,{
			header: "int_id_postulante",
			flex:115 / 100,
			dataIndex: 'int_id_postulante',
			hidden:true
		}
		,{
			header: "Código Cuidad",
			flex:115 / 100,
			dataIndex: 'var_cod_cuidad',
			hidden:false
		}
		,{
			header: "Número",
			flex:115 / 100,
			dataIndex: 'var_numero_telefono',
			hidden:false
		}
		,{
			header: "Tipo Telefono",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_telefono',
			hidden:false
		}
		,{
			header: "Operador",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_operador',
			hidden:false
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
			hidden:false
		}
		,{
			header: "Fecha Registro",
			flex:115 / 100,
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
            store: 'GestionarPostulante.PostulanteNumeroTelefonoQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
