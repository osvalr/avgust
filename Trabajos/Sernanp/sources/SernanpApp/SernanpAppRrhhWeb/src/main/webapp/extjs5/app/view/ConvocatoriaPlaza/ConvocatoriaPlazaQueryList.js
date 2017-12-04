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
* DATE CREATE : 20/04/2015 01:27:21
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ConvocatoriaPlaza.ConvocatoriaPlazaQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ConvocatoriaPlazaQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'ConvocatoriaPlaza.ConvocatoriaPlazaQueryStore',

    columns: [
		{
	    	header: "srl_id_convocatoria",
			flex:115 / 100,
			dataIndex: 'srl_id_convocatoria',
			hidden:true
		}
		,{
			header: "srl_id_conv_area_org",
			flex:115 / 100,
			dataIndex: 'srl_id_conv_area_org',
			hidden:true
		}
		,{
			header: "Nº de Requerimiento",
			flex:115 / 100,
			dataIndex: 'var_numero_requerimiento',
			hidden:true
		}
		,{
			header: "Nº de Requerimiento",
			flex:115 / 100,
			dataIndex: 'var_numero_requerimiento_corto',
			hidden:false
		}
		,{
			header: "Area Responsable",
			flex:115 / 100,
			dataIndex: 'idarea_solicitante',
			hidden:true
		}
		,{
			header: "Area Responsable",
			flex:115 / 100,
			dataIndex: 'descrip_area',
			hidden:false
		}
		
		,{
			header: "Código de Postulación",
			flex:115 / 100,
			dataIndex: 'var_codigo_postulacion',
			hidden:false
		}
		,{
			header: "Cantidad de Vacantes",
			flex:115 / 100,
			dataIndex: 'int_cantidad_requerida',
			hidden:false
		}
		
		
		,{
			header: "Responsable",
			flex:115 / 100,
			dataIndex: 'nombre_completo',
			hidden:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'int_id_estado',
			hidden:true
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
            store: 'ConvocatoriaPlaza.ConvocatoriaPlazaQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
