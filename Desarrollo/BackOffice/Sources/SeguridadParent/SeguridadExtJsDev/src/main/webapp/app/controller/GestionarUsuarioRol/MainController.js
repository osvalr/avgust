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
* @since   27/02/2016 15:19:09
*/

Ext.define('MyApp.controller.GestionarUsuarioRol.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarUsuarioRol.MainStore'],

    models: ['GestionarUsuarioRol.MainModel'],

    views: ['GestionarUsuarioRol.Edit', 'GestionarUsuarioRol.List'],

    refs: [
    	{
            ref: 'GestionarUsuarioRolPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarUsuarioRolList',
            selector: 'GestionarUsuarioRolList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarUsuarioRol.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'GestionarUsuarioRolList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarUsuarioRolList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarUsuarioRolList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarUsuarioRolEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarUsuarioRolList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarUsuarioRolList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarUsuarioRolList combobox': {
                change: this.refreshGrid
            },
            'GestionarUsuarioRolList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarUsuarioRol.Edit').show();
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
        var store = Ext.getStore('GestionarUsuarioRol.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.row_number > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarUsuarioRol.MainModel');
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
    	
    	var grid = this.getGestionarUsuarioRolList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarUsuarioRol.MainStore');
    	
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
    	var store = Ext.getStore('GestionarUsuarioRol.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarUsuarioRol.MainStore');
        var form = Ext.getCmp('form_filter_GestionarUsuarioRol');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarUsuarioRol.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarUsuarioRol.MainStore');
        var form = Ext.getCmp('form_filter_GestionarUsuarioRol');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});