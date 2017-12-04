Ext.define('AcmeWebApp.view.GestionarCliente.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.GestionarClienteList',
    
    requires: ['AcmeWebApp.view.GestionarCliente.Filter'],

    glyph:'xf022@FontAwesome',

    title : 'Gestionar Clientes',
    store: 'GestionarCliente.MainStore',

    columns: [
		{
	    	header: "Código",
			flex:115 / 100,
			dataIndex: 'cod_persona',
			hidden:false,
			sortable:true
		}
		,{
			header: "Tipo",
			flex:115 / 100,
			dataIndex: 'descrip_sub_tipo_persona',
			hidden:false,
			sortable:true
		}
		,{
			header: "Nombres / Razón Social",
			flex:115 / 100,
			dataIndex: 'nombre_razon',
			hidden:false,
			sortable:true
		}
		,{
			header: "T.D",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_docu_iden',
			hidden:false,
			sortable:true
		}
		,{
			header: "N.D",
			flex:115 / 100,
			dataIndex: 'num_docu_iden',
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
		          xtype: 'GestionarClienteFilter'
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
	            store: 'GestionarCliente.MainStore',
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
