/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 01/12/2014 19:55:03
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarTablaGeneral.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarTablaGeneral.MainStore'],

    models: ['GestionarTablaGeneral.MainModel'],

    views: ['GestionarTablaGeneral.Edit', 'GestionarTablaGeneral.List'],

    refs: [
    	{
            ref: 'GestionarTablaGeneralPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarTablaGeneralList',
            selector: 'GestionarTablaGeneralList'
        }
    ],

    init: function() {
        this.control({
            'GestionarTablaGeneralList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarTablaGeneralList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarTablaGeneralList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarTablaGeneralEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarTablaGeneralList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarTablaGeneralList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarTablaGeneralList combobox': {
                change: this.refreshGrid
            },
            'GestionarTablaGeneralList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarTablaGeneral.Edit').show();
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var detailTablaGeneralDetalleQuery = Ext.getCmp('detailTablaGeneralDetalleQuery');
        	var id_tabla_general = Ext.getCmp('GestionarTablaGeneral_id_tabla_general');
        	
			detailTablaGeneralDetalleQuery.store.reload({params: {id_tabla_general: id_tabla_general.getValue(), start:0, limit:10}});
			
        }else{
        	edit.setTitle('Agregar');
        	var detailTablaGeneralDetalleQuery = Ext.getCmp('detailTablaGeneralDetalleQuery');
			detailTablaGeneralDetalleQuery.store.reload({params: {id_tabla_general: -1, start:0, limit:10}});
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarTablaGeneral.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_tabla_general > 0){
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarTablaGeneral.MainModel');
	        			record.set(values);
	        			store.add(record);
	        		}
	                
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	var form = Ext.getCmp('form_filter_GestionarTablaGeneral');
				            var values = form.getValues();
				        	store.load({params:values});
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
    	
    	var grid = this.getGestionarTablaGeneralList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarTablaGeneral.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	var form = Ext.getCmp('form_filter_GestionarTablaGeneral');
					            var values = form.getValues();
					        	store.load({params:values});
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {

    	var store = Ext.getStore('GestionarTablaGeneral.MainStore');
        var form = Ext.getCmp('form_filter_GestionarTablaGeneral');
        var values = form.getValues();

    	store.load({params:values});

    },
    resetForm: function() {
    	
    	var store = Ext.getStore('GestionarTablaGeneral.MainStore');
        var form = Ext.getCmp('form_filter_GestionarTablaGeneral');
        form.reset();
        var values = form.getValues();

    	store.load({params:values});

    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarTablaGeneral.MainStore');
            var form = Ext.getCmp('form_filter_GestionarTablaGeneral');
            var values = form.getValues();

        	store.load({params:values});
        }
    }
    
});