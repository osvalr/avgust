Ext.define('AcmeWebApp.controller.GestionarCotizacion.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarCotizacion.MainStore'],

    models: ['GestionarCotizacion.MainModel'],

    views: ['GestionarCotizacion.Edit', 'GestionarCotizacion.List'],

    refs: [
    	{
            ref: 'GestionarCotizacionPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarCotizacionList',
            selector: 'GestionarCotizacionList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarCotizacion.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'GestionarCotizacionList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarCotizacionList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarCotizacionList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarCotizacionEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarCotizacionList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarCotizacionList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarCotizacionList combobox': {
                change: this.refreshGrid
            },
            'GestionarCotizacionList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('AcmeWebApp.view.GestionarCotizacion.Edit').show();
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
        var store = Ext.getStore('GestionarCotizacion.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_cotizacion > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('AcmeWebApp.model.GestionarCotizacion.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_GestionarCotizacion_statusbar');
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
    	
    	var grid = this.getGestionarCotizacionList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarCotizacion.MainStore');
    	
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
    	var store = Ext.getStore('GestionarCotizacion.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarCotizacion.MainStore');
        var form = Ext.getCmp('form_filter_GestionarCotizacion');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarCotizacion.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarCotizacion.MainStore');
        var form = Ext.getCmp('form_filter_GestionarCotizacion');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});