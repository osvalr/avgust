/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 01/06/2015 19:30:15
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.RpNominaDescuentoMaestro.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['RpNominaDescuentoMaestro.MainStore'],

    models: ['RpNominaDescuentoMaestro.MainModel'],

    views: ['RpNominaDescuentoMaestro.Edit', 'RpNominaDescuentoMaestro.List'],

    refs: [
    	{
            ref: 'RpNominaDescuentoMaestroPanel',
            selector: 'panel'
        },
        {
            ref: 'RpNominaDescuentoMaestroList',
            selector: 'RpNominaDescuentoMaestroList'
        }
    ],

    init: function() {
    
        Ext.getStore('RpNominaDescuentoMaestro.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'RpNominaDescuentoMaestroList dataview': {
                itemdblclick: this.editRecord
            },
            'RpNominaDescuentoMaestroList button[action=add]': {
            	click: this.editRecord
            },
            'RpNominaDescuentoMaestroList button[action=delete]': {
                click: this.deleteRecord
            },
            'RpNominaDescuentoMaestroEdit button[action=save]': {
                click: this.updateRecord
            },
            'RpNominaDescuentoMaestroList button[action=filter]': {
                click: this.refreshGrid
            },
            'RpNominaDescuentoMaestroList button[action=clearFilter]': {
                click: this.resetForm
            },
            'RpNominaDescuentoMaestroList combobox': {
                change: this.refreshGrid
            },
            'RpNominaDescuentoMaestroList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.RpNominaDescuentoMaestro.Edit').show();
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
        var store = Ext.getStore('RpNominaDescuentoMaestro.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.RpNominaDescuentoMaestro.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_RpNominaDescuentoMaestro_statusbar');
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
    	
    	var grid = this.getRpNominaDescuentoMaestroList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('RpNominaDescuentoMaestro.MainStore');
    	
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
    	var store = Ext.getStore('RpNominaDescuentoMaestro.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('RpNominaDescuentoMaestro.MainStore');
        var form = Ext.getCmp('form_filter_RpNominaDescuentoMaestro');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('RpNominaDescuentoMaestro.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('RpNominaDescuentoMaestro.MainStore');
        var form = Ext.getCmp('form_filter_RpNominaDescuentoMaestro');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});