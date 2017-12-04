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

Ext.define('MyApp.view.GestionarAsignarConcepto.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarAsignarConceptoList',
    
    requires: ['MyApp.view.GestionarAsignarConcepto.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Información del Personal',
    store: 'GestionarAsignarConcepto.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:50 / 100,
			dataIndex: 'idpersonal',
			hidden:true,
			sortable:true
		}
		,{
			header: "Nombres",
			flex:260 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Correo",
			flex:160 / 100,
			dataIndex: 'correoinstitucional',
			hidden:false,
			sortable:true
		}
				
		,{
			header: "T.D",
			flex:50 / 100,
			dataIndex: 'descrip_documento',
			hidden:false,
			sortable:true
		}
		,{
			header: "N.D",
			flex:70 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "R.U.C",
			flex:90 / 100,
			dataIndex: 'ruc',
			hidden:false,
			sortable:true
		}
		,{
			header: "Reg. Pensionario",
			flex:90 / 100,
			dataIndex: 'var_descripcion_regimen_pensionario',
			hidden:false,
			sortable:true
		}
		,{
			header: "AFP",
			flex:90 / 100,
			dataIndex: 'var_nombre_afp',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo Comisión",
			flex:90 / 100,
			dataIndex: 'descrip_tipo_comision',
			hidden:false,
			sortable:true
		}

		,{
			header: "Entid. Banc.",
			flex:120 / 100,
			dataIndex: 'var_desc_entidad_bancaria',
			hidden:false,
			sortable:true
		}
		,{
			header: "N° Cuenta",
			flex:90 / 100,
			dataIndex: 'var_numero_cuenta_bancaria',
			hidden:false,
			sortable:true
		}	
		
		,{
			header: "Reg. Contractual",
			flex:100 / 100,
			dataIndex: 'var_descripcion_regimen_contractual',
			hidden:false,
			sortable:true
		}
		
		,{
			header: "Fec. Inicio",
			flex:100 / 100,
			dataIndex: 'dte_fec_inicio',
			hidden:false,
			sortable:true
		}
		
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'desc_estado',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarAsignarConceptoFilter'
		     },
			 {
	            xtype: 'toolbar',
	            items: [
				            {
				            	glyph:'xf0b0@FontAwesome',
				                text: 'Filtrar',
				                action: 'filter'
				            },
				            '-',
				            {
				            	glyph:'xf12d@FontAwesome',
				                text: 'Limpiar',
				                action: 'clearFilter'
				            },
				            '-',
				            {
				            	glyph:'xf12d@FontAwesome',
				                text: 'Reporte Personal',
				                action: 'showGenerarReportePersonal'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarAsignarConcepto.MainStore',
	            displayInfo: true
	        }
        ];
		
		this.callParent(arguments);
        this.on('render', this.loadStore, this);
	},
    loadStore: function() {
        this.getStore().load();
        if (Ext.get('page-loader')) {
            Ext.get('page-loader').remove();
        }
    }
});
