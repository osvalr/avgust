Ext.define('AcmeWebApp.controller.GestionarProducto.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarProducto.MainStore'],

    models: ['GestionarProducto.MainModel'],

    views: ['GestionarProducto.Edit', 'GestionarProducto.List'],

    refs: [
    	{
            ref: 'GestionarProductoPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarProductoList',
            selector: 'GestionarProductoList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarProducto.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'GestionarProductoList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarProductoList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarProductoList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarProductoEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarProductoList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarProductoList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarProductoList combobox': {
                change: this.refreshGrid
            },
            'GestionarProductoList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('AcmeWebApp.view.GestionarProducto.Edit').show();
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        }else{
        	edit.setTitle('Agregar');
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarProducto.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_producto > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('AcmeWebApp.model.GestionarProducto.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_GestionarProducto_statusbar');
	        		sb.showBusy('Grabando...');
	        		win.getEl().mask();
	                	
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	store.load();
				        	win.close();
	        	        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
                            sb.setStatus({text:'Error intentado grabar.'});
				        	win.getEl().unmask();
	        	        }
	        	    });
	            }
	        });
		}
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarProductoList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarProducto.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        },
		        	        failure: function (batch, eOpts) {
								store.rejectChanges();
		        	        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarProducto.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarProducto.MainStore');
        var form = Ext.getCmp('form_filter_GestionarProducto');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarProducto.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarProducto.MainStore');
        var form = Ext.getCmp('form_filter_GestionarProducto');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});