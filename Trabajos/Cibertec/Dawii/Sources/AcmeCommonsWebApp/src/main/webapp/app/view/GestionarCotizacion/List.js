Ext.define('AcmeWebApp.view.GestionarCotizacion.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarCotizacionList',
    
    requires: ['AcmeWebApp.view.GestionarCotizacion.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Cotización',
    store: 'GestionarCotizacion.MainStore',

    columns: [
		{
	    	header: "Código",
			flex:115 / 100,
			dataIndex: 'cod_cotizacion',
			hidden:false,
			sortable:true
		}
		,{
			header: "Cliente",
			flex:115 / 100,
			dataIndex: 'nombres_cliente',
			hidden:false,
			sortable:true
		}
		,{
			header: "Vendedor",
			flex:115 / 100,
			dataIndex: 'nombres_vendedor',
			hidden:false,
			sortable:true
		}
		,{
			header: "Importe Total",
			flex:115 / 100,
			dataIndex: 'importe_total',
			hidden:false,
			sortable:true
		}
		,{
			header: "Estado",
			flex:115 / 100,
			dataIndex: 'descrip_estado',
			hidden:false,
			sortable:true
		}
		,{
			header: "F.Registro",
			flex:115 / 100,
			dataIndex: 'fec_reg',
			hidden:false,
			sortable:true
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		     {
		          xtype: 'GestionarCotizacionFilter'
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
				                text: 'Agregar',
				                action: 'add'
				            },
				            '-',
				            {
				            	glyph:'xf056@FontAwesome',
				                text: 'Eliminar',
				                action: 'delete'
				            }
			           ]
	        },
	        {
	            xtype: 'pagingtoolbar',
	            dock:'top',
	            store: 'GestionarCotizacion.MainStore',
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
