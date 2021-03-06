/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by GeneratorCrud v.1.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   04/03/2016 20:30:30
*/

Ext.define('MyApp.controller.GestionarProveedores.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarProveedores.MainStore'],

    models: ['GestionarProveedores.MainModel'],

    views: ['GestionarProveedores.Edit', 'GestionarProveedores.List'],

    refs: [
    	{
            ref: 'GestionarProveedoresPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarProveedoresList',
            selector: 'GestionarProveedoresList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarProveedores.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'GestionarProveedoresList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarProveedoresList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarProveedoresList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarProveedoresEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarProveedoresList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarProveedoresList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarProveedoresList combobox': {
                change: this.refreshGrid
            },
            'GestionarProveedoresList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarProveedores.Edit').show();
        var form = edit.down('form');
        
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        }else{
        	edit.setTitle('Agregar');
        	
          	var id_estado = form.getForm().findField('id_estado');
          	id_estado.setReadOnly(true);
          	id_estado.setValue(1);
        	
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarProveedores.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_persona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarProveedores.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                	
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	store.load();
				        	win.close();
	        	        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
	        	        }
	        	    });
	            }
	        });
		}
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarProveedoresList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarProveedores.MainStore');
    	
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
    	var store = Ext.getStore('GestionarProveedores.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarProveedores.MainStore');
        var form = Ext.getCmp('form_filter_GestionarProveedores');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarProveedores.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarProveedores.MainStore');
        var form = Ext.getCmp('form_filter_GestionarProveedores');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});