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
* DATE CREATE : 07/04/2015 17:43:08
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionaNomina.DescuentoJudicialesNominaConceptoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.DescuentoJudicialesNominaConceptoQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionaNomina.DescuentoJudicialesNominaConceptoQueryStore',

    columns: [
		{
	    	header: "srl_id_nomina_concepto",
			flex:115 / 100,
			dataIndex: 'srl_id_nomina_concepto',
			hidden:true
		}
		,{
			header: "srl_id_nomina_anio_periodo_personal",
			flex:115 / 100,
			dataIndex: 'srl_id_nomina_anio_periodo_personal',
			hidden:true
		}
		,{
			header: "Concepto",
			flex:115 / 100,
			dataIndex: 'var_descrip_corto_concepto',
			hidden:false
		}
		,{
			header: "Beneficiario",
			flex:115 / 100,
			dataIndex: 'var_descripcion_descuento',
			hidden:false
		}
		,{
			header: "Valor",
			flex:115 / 100,
			dataIndex: 'dec_monto_calculado',
			hidden:false
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
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
            store: 'GestionaNomina.DescuentoJudicialesNominaConceptoQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
