Ext.define('AcmeWebApp.controller.GestionarCliente.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarCliente.MainStore'],

    models: ['GestionarCliente.MainModel'],

    views: ['GestionarCliente.Edit', 'GestionarCliente.List'],

    refs: [
    	{
            ref: 'GestionarClientePanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarClienteList',
            selector: 'GestionarClienteList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarCliente.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'GestionarClienteList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarClienteList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarClienteList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarClienteEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarClienteList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarClienteList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarClienteList combobox': {
                change: this.refreshGrid
            },
            'GestionarClienteList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('AcmeWebApp.view.GestionarCliente.Edit').show();
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
        var store = Ext.getStore('GestionarCliente.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_persona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('AcmeWebApp.model.GestionarCliente.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_GestionarCliente_statusbar');
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
    	
    	var grid = this.getGestionarClienteList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarCliente.MainStore');
    	
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
    	var store = Ext.getStore('GestionarCliente.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarCliente.MainStore');
        var form = Ext.getCmp('form_filter_GestionarCliente');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarCliente.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarCliente.MainStore');
        var form = Ext.getCmp('form_filter_GestionarCliente');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});