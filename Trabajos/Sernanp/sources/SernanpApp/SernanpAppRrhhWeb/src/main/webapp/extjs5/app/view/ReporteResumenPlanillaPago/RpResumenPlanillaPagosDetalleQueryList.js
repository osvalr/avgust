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
* DATE CREATE : 17/05/2015 16:09:38
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteResumenPlanillaPago.RpResumenPlanillaPagosDetalleQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.RpResumenPlanillaPagosDetalleQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'ReporteResumenPlanillaPago.RpResumenPlanillaPagosDetalleQueryStore',

    columns: [
		{
	    	header: "srl_id_nomina_anio_periodo_personal",
			flex:115 / 100,
			dataIndex: 'srl_id_nomina_anio_periodo_personal',
			hidden:false
		}
		,{
			header: "srl_id_nomina_concepto",
			flex:115 / 100,
			dataIndex: 'srl_id_nomina_concepto',
			hidden:false
		}
		,{
			header: "srl_id_concepto_planilla",
			flex:115 / 100,
			dataIndex: 'srl_id_concepto_planilla',
			hidden:false
		}
		,{
			header: "int_id_tipo_concepto",
			flex:115 / 100,
			dataIndex: 'int_id_tipo_concepto',
			hidden:false
		}
		,{
			header: "var_descrip_concepto",
			flex:115 / 100,
			dataIndex: 'var_descrip_concepto',
			hidden:false
		}
		,{
			header: "dec_monto_calculado",
			flex:115 / 100,
			dataIndex: 'dec_monto_calculado',
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
            store: 'ReporteResumenPlanillaPago.RpResumenPlanillaPagosDetalleQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
