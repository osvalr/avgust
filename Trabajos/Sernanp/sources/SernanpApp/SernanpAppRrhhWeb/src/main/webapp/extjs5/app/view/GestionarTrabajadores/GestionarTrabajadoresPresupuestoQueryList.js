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
* DATE CREATE : 27/05/2015 04:42:23
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarTrabajadoresPresupuestoQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryStore',

    columns: [
		{
	    	header: "idpersonanatural",
			flex:115 / 100,
			dataIndex: 'idpersonanatural',
			hidden:true
		}
		
		,{
			header: "srl_id_anio_planilla",
			flex:115 / 100,
			dataIndex: 'srl_id_anio_planilla',
			hidden:true
		}
		,{
			header: "Año",
			flex:40 / 100,
			dataIndex: 'int_anio',
			hidden:false
		}
		,{
			header: "Fte. Fto.",
			flex:45 / 100,
			dataIndex: 'c_fte_fto',
			hidden:false
		}
		,{
			header: "Meta",
			flex:45 / 100,
			dataIndex: 'c_meta',
			hidden:false
		}
		
		,{
			header: "srl_id_fuente_financiamiento",
			flex:115 / 100,
			dataIndex: 'srl_id_fuente_financiamiento',
			hidden:false
		}
		,{
			header: "var_rubro_fte_fto",
			flex:115 / 100,
			dataIndex: 'var_rubro_fte_fto',
			hidden:false
		}
		,{
			header: "srl_id_meta_presupuestaria",
			flex:115 / 100,
			dataIndex: 'srl_id_meta_presupuestaria',
			hidden:false
		}
		,{
			header: "var_cod_meta_presupuestaria",
			flex:115 / 100,
			dataIndex: 'var_cod_meta_presupuestaria',
			hidden:false
		}
		,{
			header: "int_id_estado",
			flex:115 / 100,
			dataIndex: 'int_id_estado',
			hidden:true
		}
		,{
			header: "Estado",
			flex:60 / 100,
			dataIndex: 'descrip_estado',
			hidden:false
		}
		,{
			header: "Fecha de Registro",
			flex:60 / 100,
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
            store: 'GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
