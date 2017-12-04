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
* DATE CREATE : 12/04/2015 20:29:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAsignarConcepto.PersonalInfoAdendasPorContratoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.PersonalInfoAdendasPorContratoQueryList',
    
    glyph:'xf022@FontAwesome',
	title: 'Adendas',
    store: 'GestionarAsignarConcepto.PersonalInfoAdendasPorContratoQueryStore',

    columns: [
		{
	    	header: "srl_id_contrato",
			flex:115 / 100,
			dataIndex: 'srl_id_contrato',
			hidden:true
		}
		,{
			header: "srl_id_contrato_padre",
			flex:115 / 100,
			dataIndex: 'srl_id_contrato_padre',
			hidden:true
		}
		,{
			header: "Número",
			flex:115 / 100,
			dataIndex: 'var_num_contrato',
			hidden:false
		}
		,{
			header: "Contrato",
			flex:115 / 100,
			dataIndex: 'var_num_contrato_padre',
			hidden:false
		}
		,{
			header: "F. Suscripción",
			flex:115 / 100,
			dataIndex: 'dte_fec_suscrip',
			hidden:false
		}
		,{
			header: "F. Inicio",
			flex:115 / 100,
			dataIndex: 'dte_fec_inicio',
			hidden:false
		}
		
		,{
			header: "F. Termino",
			flex:115 / 100,
			dataIndex: 'dte_fec_termino',
			hidden:false
		}
		
		,{
			header: "F. Cese",
			flex:115 / 100,
			dataIndex: 'dte_fec_cese',
			hidden:false
		}
		
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'var_nombre_estado',
			hidden:false
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [
//                    {
//            	glyph:'xf055@FontAwesome',
//                itemId: 'add',
//                text: 'Agregar',
//                action: 'add'
//            },{
//            	glyph:'xf056@FontAwesome',
//                text: 'Eliminar',
//                action: 'delete'
//            }
            ]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarAsignarConcepto.PersonalInfoAdendasPorContratoQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
