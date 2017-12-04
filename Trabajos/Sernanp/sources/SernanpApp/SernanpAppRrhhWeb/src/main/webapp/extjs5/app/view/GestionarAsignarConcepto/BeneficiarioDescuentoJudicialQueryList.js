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

Ext.define('MyApp.view.GestionarAsignarConcepto.BeneficiarioDescuentoJudicialQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.BeneficiarioDescuentoJudicialQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarAsignarConcepto.BeneficiarioDescuentoJudicialQueryStore',

    columns: [
		{
	    	header: "srl_id_beneficiario_descuento_judicial",
			flex:115 / 100,
			dataIndex: 'srl_id_beneficiario_descuento_judicial',
			hidden:true
		}
		,{
			header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:true
		}
		,{
			header: "Descripción",
			flex:115 / 100,
			dataIndex: 'var_descripcion_descuento',
			hidden:false
		}
		,{
			header: "Tipo Documento",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_documento',
			hidden:false
		}
		,{
			header: "Número Documento",
			flex:115 / 100,
			dataIndex: 'var_numero_doc',
			hidden:false
		}
		,{
			header: "Nombres",
			flex:115 / 100,
			dataIndex: 'var_nombres',
			hidden:false
		}
		,{
			header: "A. Paterno",
			flex:115 / 100,
			dataIndex: 'var_ape_pater',
			hidden:false
		}
		,{
			header: "A. Materno",
			flex:115 / 100,
			dataIndex: 'var_ape_mater',
			hidden:false
		}
		,{
			header: "Numero Cuenta",
			flex:115 / 100,
			dataIndex: 'var_numero_cuenta',
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
            store: 'GestionarAsignarConcepto.BeneficiarioDescuentoJudicialQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
