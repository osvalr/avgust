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
* DATE CREATE : 17/05/2015 17:00:41
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteResumenAfp.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteResumenAfp.MainStore'],

    models: ['ReporteResumenAfp.MainModel'],

    views: ['ReporteResumenAfp.Edit', 'ReporteResumenAfp.List'],

    refs: [
    	{
            ref: 'ReporteResumenAfpPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteResumenAfpList',
            selector: 'ReporteResumenAfpList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteResumenAfp.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteResumenAfpList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteResumenAfpList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteResumenAfpList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteResumenAfpEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteResumenAfpList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteResumenAfpList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteResumenAfpList combobox': {
                change: this.refreshGrid
            },
            'ReporteResumenAfpList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteResumenAfp.Edit').show();
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
        var store = Ext.getStore('ReporteResumenAfp.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.var_descripcion_regimen_contractual > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteResumenAfp.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteResumenAfp_statusbar');
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
    	
    	var grid = this.getReporteResumenAfpList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteResumenAfp.MainStore');
    	
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
    	var store = Ext.getStore('ReporteResumenAfp.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteResumenAfp.MainStore');
        var form = Ext.getCmp('form_filter_ReporteResumenAfp');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteResumenAfp.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteResumenAfp.MainStore');
        var form = Ext.getCmp('form_filter_ReporteResumenAfp');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});