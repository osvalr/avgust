/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   17/03/2016 18:54:46
*/

Ext.define('MyApp.view.GestionarSaldo.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarSaldoList',
    
    requires: ['MyApp.view.GestionarSaldo.Filter','MyApp.util.InaviUtil'],

    iconCls:'icon-application_form',

    title : 'Gestionar Saldos',
    store: 'GestionarSaldo.MainStore',

    columns: [
		{
	    	header: "Id",
			flex:115 / 100,
			dataIndex: 'id_guia',
			hidden:false,
			sortable:true
		}
		,{
			header: "Jornada",
			flex:115 / 100,
			dataIndex: 'fecha_jornada',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo Producto",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_producto',
			hidden:false,
			sortable:true
		}
		,{
			header: "Cliente",
			flex:115 / 100,
			dataIndex: 'nombre_cliente',
			hidden:false,
			sortable:true
		}
		, {
            text: 'Total',
            columns: [
	            {
	                text     : 'Bruto',
	                width    : 75,
	                sortable : true,
	                dataIndex: 'total_peso_bruto'
	            }, 
	            {
	                text     : 'Tara',
	                width    : 75,
	                sortable : true,
	                dataIndex: 'total_peso_tara'
	            }, 
	            {
	                text     : 'Devoluciones',
	                width    : 110,
	                sortable : true,
	                dataIndex: 'total_peso_devolucion'
	            }, 
	            {
	                text     : 'Neto',
	                width    : 75,
	                sortable : true,
	                dataIndex: 'total_peso_neto'
	            }
            ]
        }
		,{
			header: "Precio",
			flex:115 / 100,
			dataIndex: 'precio_aplicado',
			hidden:false,
			sortable:true
		}
		,{
			header: "Total Importe",
			flex:115 / 100,
			dataIndex: 'total_importe',
			hidden:false,
			sortable:true, 
			renderer:function(value) {
				return MyApp.util.InaviUtil.formatMoney(value,'S/ ');
			}
		}
		,{
			header: "Total Amortizado",
			flex:115 / 100,
			dataIndex: 'total_amortizado',
			hidden:false,
			sortable:true, 
			renderer:function(value) {
				return MyApp.util.InaviUtil.formatMoney(value,'S/ ');
			}
		},
		{
			header: "Deuda",
			width    : 110,
			dataIndex: 'total_deuda',
			hidden:false,
			sortable:true,
			renderer:function(value) {
				return MyApp.util.InaviUtil.formatMoney(value,'S/ ');
			}
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
			hidden:false,
			sortable:true
		}
		,{
			header: "F. Registro",
			flex:115 / 100,
			dataIndex: 'fecha_registro',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarSaldoFilter'
		     },
			 {
	            xtype: 'toolbar',
	            items: [
				            {
				            	iconCls:'icon-find',
				                text: 'Filtrar',
				                action: 'filter'
				            },
				            '-',
				            {
				            	iconCls:'icon-erase',
				                text: 'Limpiar',
				                action: 'clearFilter'
				            },
							'-',
							{
								iconCls:'icon-report',
								text: 'Guias por Cobrar',
                                handler:function(){
                                    var win = Ext.create('MyApp.view.GestionarSaldo.ReporteSaldoWindow').show();
                                }
							},
							'-',
							{
								iconCls:'icon-report',
								text: 'Resumen de pagos',
								handler:function(){
									var win = Ext.create('MyApp.view.GestionarSaldo.ReporteResumenPagoPorFechasWindow').show();
								}
							},
							'-',
							{
								iconCls:'icon-bullet_wrench',
								text: 'Registro rapido',
                                handler:function(){
                                    var win = Ext.create('MyApp.view.GestionarSaldo.RegistroRapidoSaldoWindow').show();
                                    var registroRapidoSaldoGridPanel = Ext.getCmp('registroRapidoSaldoGridPanel');
                                    registroRapidoSaldoGridPanel.getStore().removeAll();
                                }
							}
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarSaldo.MainStore',
	            displayInfo: true
	        }
        ];
		
		this.callParent(arguments);
        this.on('render', this.loadStore, this);
	},
    loadStore: function() {
        this.getStore().load();
    }
});