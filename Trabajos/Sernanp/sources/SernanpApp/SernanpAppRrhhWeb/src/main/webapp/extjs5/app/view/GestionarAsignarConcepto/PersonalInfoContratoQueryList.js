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

Ext.define('MyApp.view.GestionarAsignarConcepto.PersonalInfoContratoQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.PersonalInfoContratoQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarAsignarConcepto.PersonalInfoContratoQueryStore',

    columns: [
		{
	    	header: "srl_id_contrato",
			flex:115 / 100,
			dataIndex: 'srl_id_contrato',
			hidden:true
		}
		,{
			header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:true
		}
		,{
			header: "Número",
			flex:115 / 100,
			dataIndex: 'var_num_contrato',
			hidden:false
		}
		,{
			header: "Regimen",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
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
			header: "Cargo",
			flex:115 / 100,
			dataIndex: 'var_nom_cargo',
			hidden:false
		}
		
		,{
			header: "Sueldo",
			flex:115 / 100,
			dataIndex: 'num_sueldo',
			hidden:false
		}
		
		,{
			header: "Ubicación Fisica",
			flex:115 / 100,
			dataIndex: 'var_ubicacion_fisica',
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
		
		this.dockedItems = [

			{
	            xtype: 'toolbar',
	            items: [
	        			{
	        				glyph:'xf0ce@FontAwesome',
	        				text: 'Adendas',
	        				action: 'showAdendas'
	        			}
	            ]
	        },
			{
			    xtype: 'pagingtoolbar',
			    dock:'top',
			    store: 'GestionarAsignarConcepto.PersonalInfoContratoQueryStore',
			    displayInfo: true
			}

        ];
		
		this.callParent(arguments);
	}
});
