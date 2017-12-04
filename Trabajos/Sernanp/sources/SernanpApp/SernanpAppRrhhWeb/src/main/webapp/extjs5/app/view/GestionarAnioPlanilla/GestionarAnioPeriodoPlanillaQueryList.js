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
* DATE CREATE : 23/03/2015 12:20:16
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarAnioPeriodoPlanillaQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryStore',

    columns: [
		{
	    	header: "Nro.",
			flex:20 / 100,
			dataIndex: 'srl_id_anio_periodo_planilla',
			hidden:true
		}
		,{
			header: "srl_id_anio_planilla",
			flex:115 / 100,
			dataIndex: 'srl_id_anio_planilla',
			hidden:true
		}
		,{
			header: "Periódo",
			flex:115 / 100,
			dataIndex: 'int_id_periodo_mes',
			hidden:true
		}
		,{
			header: "Periódo",
			flex:200 / 100,
			dataIndex: 'var_des_periodo_mes',
			hidden:false
		}
		,{
			header: "Fecha Inicio",
			flex:115 / 100,
			dataIndex: 'dte_fecha_inicio_periodo',
			hidden:true
		}
		,{
			header: "Fecha Fin",
			flex:115 / 100,
			dataIndex: 'dte_fecha_fin_periodo',
			hidden:true
		}
		,{
			header: "Tipo Estado",
			flex:115 / 100,
			dataIndex: 'int_id_estado',
			hidden:true
		}
		,{
			header: "Estado",
			flex:100 / 100,
			dataIndex: 'var_des_tipo_estado',
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
            store: 'GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
