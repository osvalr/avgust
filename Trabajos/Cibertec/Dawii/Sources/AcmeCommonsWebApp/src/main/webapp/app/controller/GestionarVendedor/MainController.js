Ext.define('AcmeWebApp.controller.GestionarVendedor.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarVendedor.MainStore'],

    models: ['GestionarVendedor.MainModel'],

    views: ['GestionarVendedor.Edit', 'GestionarVendedor.List'],

    refs: [
    	{
            ref: 'GestionarVendedorPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarVendedorList',
            selector: 'GestionarVendedorList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarVendedor.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'GestionarVendedorList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarVendedorList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarVendedorList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarVendedorEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarVendedorList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarVendedorList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarVendedorList combobox': {
                change: this.refreshGrid
            },
            'GestionarVendedorList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('AcmeWebApp.view.GestionarVendedor.Edit').show();
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
        var store = Ext.getStore('GestionarVendedor.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_persona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('AcmeWebApp.model.GestionarVendedor.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_GestionarVendedor_statusbar');
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
    	
    	var grid = this.getGestionarVendedorList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarVendedor.MainStore');
    	
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
    	var store = Ext.getStore('GestionarVendedor.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarVendedor.MainStore');
        var form = Ext.getCmp('form_filter_GestionarVendedor');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarVendedor.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarVendedor.MainStore');
        var form = Ext.getCmp('form_filter_GestionarVendedor');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});