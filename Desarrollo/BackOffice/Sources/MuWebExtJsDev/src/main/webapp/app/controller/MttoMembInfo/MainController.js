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
* @since   29/03/2016 22:54:29
*/

Ext.define('MyApp.controller.MttoMembInfo.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['MttoMembInfo.MainStore'],

    models: ['MttoMembInfo.MainModel'],

    views: ['MttoMembInfo.Edit', 'MttoMembInfo.List'],

    refs: [
    	{
            ref: 'MttoMembInfoPanel',
            selector: 'panel'
        },
        {
            ref: 'MttoMembInfoList',
            selector: 'MttoMembInfoList'
        }
    ],

    init: function() {
    
        Ext.getStore('MttoMembInfo.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'MttoMembInfoList dataview': {
                itemdblclick: this.editRecord
            },
            'MttoMembInfoList button[action=add]': {
            	click: this.editRecord
            },
            'MttoMembInfoList button[action=delete]': {
                click: this.deleteRecord
            },
            'MttoMembInfoEdit button[action=save]': {
                click: this.saveAccount
            },
            'MttoMembInfoList button[action=filter]': {
                click: this.refreshGrid
            },
            'MttoMembInfoList button[action=clearFilter]': {
                click: this.resetForm
            },
            'MttoMembInfoList combobox': {
                change: this.refreshGrid
            },
            'MttoMembInfoList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.MttoMembInfo.Edit').show();
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
        var store = Ext.getStore('MttoMembInfo.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.memb_guid > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.MttoMembInfo.MainModel');
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
    
    saveAccount: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('MttoMembInfo.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','Are you sure to continue?',function (btn) {
	            
	            if (btn == 'yes') {

	        		record = Ext.create('MyApp.model.MttoMembInfo.MainModel');
	        		values.tokenField = 'insert';
	        		record.set(values);
	        		store.add(record);
	        		
	        		store.sync({
	        	        success: function (batch, eOpts) {
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
    	
    	var grid = this.getMttoMembInfoList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('MttoMembInfo.MainStore');
    	
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
    	var store = Ext.getStore('MttoMembInfo.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('MttoMembInfo.MainStore');
        var form = Ext.getCmp('form_filter_MttoMembInfo');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('MttoMembInfo.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('MttoMembInfo.MainStore');
        var form = Ext.getCmp('form_filter_MttoMembInfo');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});