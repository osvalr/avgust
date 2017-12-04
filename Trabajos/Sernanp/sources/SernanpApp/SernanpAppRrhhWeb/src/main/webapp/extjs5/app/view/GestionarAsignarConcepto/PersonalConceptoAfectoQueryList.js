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
* DATE CREATE : 04/04/2015 00:02:41
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAsignarConcepto.PersonalConceptoAfectoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.PersonalConceptoAfectoQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarAsignarConcepto.PersonalConceptoAfectoQueryStore',

    columns: [
		{
	    	header: "srl_id_personal_concepto_afecto",
			flex:115 / 100,
			dataIndex: 'srl_id_personal_concepto_afecto',
			hidden:true
		}
		,{
			header: "srl_id_personal_concepto",
			flex:115 / 100,
			dataIndex: 'srl_id_personal_concepto',
			hidden:true
		}
		,{
			header: "Tipo Concepto",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_concepto',
			hidden:false
		}
		,{
			header: "Sub Tipo Concepto",
			flex:115 / 100,
			dataIndex: 'descrip_sub_tipo_concepto',
			hidden:false
		}
		,{
			header: "Concepto",
			flex:115 / 100,
			dataIndex: 'var_descrip_concepto',
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
            store: 'GestionarAsignarConcepto.PersonalConceptoAfectoQueryStore',
            displayInfo: false
        }];
		
		this.callParent(arguments);
	}
});
