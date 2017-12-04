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
* DATE CREATE : 03/06/2015 07:19:09
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReportePadronTrabajadores.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ReportePadronTrabajadoresList',
    
    requires: ['MyApp.view.ReportePadronTrabajadores.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'ReportePadronTrabajadores',
    store: 'ReportePadronTrabajadores.MainStore',

    columns: [
		{
	    	header: "Año",
			flex:115 / 100,
			dataIndex: 'int_anio',
			hidden:false,
			sortable:true
		}
		,{
			header: "Periodo",
			flex:115 / 100,
			dataIndex: 'int_id_periodo_mes',
			hidden:true,
			sortable:true
		}
		,{
			header: "Periodo",
			flex:115 / 100,
			dataIndex: 'descrip_periodo',
			hidden:false,
			sortable:true
		}
		,{
			header: "srl_id_nomina_anio_periodo_personal",
			flex:115 / 100,
			dataIndex: 'srl_id_nomina_anio_periodo_personal',
			hidden:true,
			sortable:true
		}
		,{
			header: "srl_id_regimen_contractual",
			flex:115 / 100,
			dataIndex: 'srl_id_regimen_contractual',
			hidden:true,
			sortable:true
		}
		,{
			header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:true,
			sortable:true
		}

		,{
			header: "apepat",
			flex:115 / 100,
			dataIndex: 'apepat',
			hidden:true,
			sortable:true
		}
		,{
			header: "apemat",
			flex:115 / 100,
			dataIndex: 'apemat',
			hidden:true,
			sortable:true
		}
		,{
			header: "nombre",
			flex:115 / 100,
			dataIndex: 'nombre',
			hidden:true,
			sortable:true
		}
		,{
			header: "Nombre Completo",
			flex:180 / 100,
			dataIndex: 'nombre_completo',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nro Documento",
			flex:115 / 100,
			dataIndex: 'numerodoc',
			hidden:false,
			sortable:true
		}
		,{
			header: "int_estado",
			flex:115 / 100,
			dataIndex: 'int_estado',
			hidden:true,
			sortable:true
		}
		,{
			header: "Dirección",
			flex:180 / 100,
			dataIndex: 'direccion',
			hidden:false,
			sortable:true
		}
		,{
			header: "nompais",
			flex:115 / 100,
			dataIndex: 'nompais',
			hidden:true,
			sortable:true
		}
		,{
			header: "sexo",
			flex:115 / 100,
			dataIndex: 'sexo',
			hidden:true,
			sortable:true
		}
		,{
			header: "fechanacimiento",
			flex:115 / 100,
			dataIndex: 'fechanacimiento',
			hidden:true,
			sortable:true
		}
		,{
			header: "ruc",
			flex:115 / 100,
			dataIndex: 'ruc',
			hidden:true,
			sortable:true
		}
		,{
			header: "telefono",
			flex:115 / 100,
			dataIndex: 'telefono',
			hidden:true,
			sortable:true
		}
		,{
			header: "mailpersonal",
			flex:115 / 100,
			dataIndex: 'mailpersonal',
			hidden:true,
			sortable:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'estado',
			hidden:false,
			sortable:true
		}
		,{
			header: "idarea",
			flex:115 / 100,
			dataIndex: 'idarea',
			hidden:true,
			sortable:true
		}
		,{
			header: "desarea",
			flex:115 / 100,
			dataIndex: 'desarea',
			hidden:true,
			sortable:true
		}
		,{
			header: "inicio_contrato",
			flex:115 / 100,
			dataIndex: 'inicio_contrato',
			hidden:true,
			sortable:true
		}
		,{
			header: "termino_contrato",
			flex:115 / 100,
			dataIndex: 'termino_contrato',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_desc_grupo_ocupacional",
			flex:115 / 100,
			dataIndex: 'var_desc_grupo_ocupacional',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_nom_cargo",
			flex:115 / 100,
			dataIndex: 'var_nom_cargo',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_descripcion_regimen_pensionario",
			flex:115 / 100,
			dataIndex: 'var_descripcion_regimen_pensionario',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_nombre_afp",
			flex:115 / 100,
			dataIndex: 'var_nombre_afp',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_codigo_afiliacion",
			flex:115 / 100,
			dataIndex: 'var_codigo_afiliacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "dte_fecha_afiliacion",
			flex:115 / 100,
			dataIndex: 'dte_fecha_afiliacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_numero_cuenta_bancaria",
			flex:115 / 100,
			dataIndex: 'var_numero_cuenta_bancaria',
			hidden:true,
			sortable:true
		}
		,{
			header: "Meta",
			flex:115 / 100,
			dataIndex: 'c_meta',
			hidden:false,
			sortable:true
		}
		,{
			header: "Fte Fto",
			flex:115 / 100,
			dataIndex: 'c_fte_fto',
			hidden:false,
			sortable:true
		}
		,{
			header: "ubicacion",
			flex:115 / 100,
			dataIndex: 'ubicacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "Ingresos",
			flex:115 / 100,
			dataIndex: 'dec_total_ingresos',
			hidden:false,
			sortable:true
		}
		,{
			header: "var_cod_nivel_estudio",
			flex:115 / 100,
			dataIndex: 'var_cod_nivel_estudio',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_descripcion_nivel_estudio",
			flex:115 / 100,
			dataIndex: 'var_descripcion_nivel_estudio',
			hidden:true,
			sortable:true
		}
		,{
			header: "int_cod_tipo_profesion",
			flex:115 / 100,
			dataIndex: 'int_cod_tipo_profesion',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_descripcion_tipo_profesion",
			flex:115 / 100,
			dataIndex: 'var_descripcion_tipo_profesion',
			hidden:true,
			sortable:true
		}
		,{
			header: "int_cod_profesion",
			flex:115 / 100,
			dataIndex: 'int_cod_profesion',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_descripcion_profesion",
			flex:115 / 100,
			dataIndex: 'var_descripcion_profesion',
			hidden:true,
			sortable:true
		}
		,{
			header: "var_descripcion_institucion",
			flex:115 / 100,
			dataIndex: 'var_descripcion_institucion',
			hidden:true,
			sortable:true
		}
		,{
			header: "dte_fecha_ingreso",
			flex:115 / 100,
			dataIndex: 'dte_fecha_ingreso',
			hidden:true,
			sortable:true
		}
		,{
			header: "dte_fecha_culminacion",
			flex:115 / 100,
			dataIndex: 'dte_fecha_culminacion',
			hidden:true,
			sortable:true
		}
		,{
			header: "int_sigue_estudios",
			flex:115 / 100,
			dataIndex: 'int_sigue_estudios',
			hidden:true,
			sortable:true
		}

		,{
			header: "Quinta Categoria",
			flex:115 / 100,
			dataIndex: 'quinta_categoria',
			hidden:false,
			sortable:true
		}
		,{
			header: "Cuarta Categoria",
			flex:115 / 100,
			dataIndex: 'cuarta_categoria',
			hidden:false,
			sortable:true
		}
		,{
			header: "Essalud",
			flex:115 / 100,
			dataIndex: 'essalud',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'ReportePadronTrabajadoresFilter'
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
				            	glyph:'xf055@FontAwesome',
				                text: 'Generar Reporte XLS',
				                action: 'generarReporteXLS'
				            }
				            
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'ReportePadronTrabajadores.MainStore',
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
