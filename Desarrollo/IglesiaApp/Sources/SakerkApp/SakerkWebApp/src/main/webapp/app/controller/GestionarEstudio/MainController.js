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
* DATE CREATE : 03/12/2014 15:04:40
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarEstudio.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarEstudio.MainStore'],

    models: ['GestionarEstudio.MainModel'],

    views: ['GestionarEstudio.Edit', 'GestionarEstudio.List'],

    refs: [
    	{
            ref: 'GestionarEstudioPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarEstudioList',
            selector: 'GestionarEstudioList'
        }
    ],

    init: function() {
        this.control({
            'GestionarEstudioList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarEstudioList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarEstudioList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarEstudioEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarEstudioList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarEstudioList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarEstudioList combobox': {
                change: this.refreshGrid
            },
            'GestionarEstudioList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarEstudio.Edit').show();
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
        var store = Ext.getStore('GestionarEstudio.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_estudio > 0){
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarEstudio.MainModel');
	        			record.set(values);
	        			store.add(record);
	        		}
	                	
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	var form = Ext.getCmp('form_filter_GestionarEstudio');
				            var values = form.getValues();
				        	store.load({params:values});
				        	win.close();
	        	        },
	        	        failure: function (batch, eOpts) {

	        	        }
	        	    });
	            }
	        });
		}
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarEstudioList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarEstudio.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	var form = Ext.getCmp('form_filter_GestionarEstudio');
					            var values = form.getValues();
					        	store.load({params:values});
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {

    	var store = Ext.getStore('GestionarEstudio.MainStore');
        var form = Ext.getCmp('form_filter_GestionarEstudio');
        var values = form.getValues();

    	store.load({params:values});

    },
    resetForm: function() {
    	
    	var store = Ext.getStore('GestionarEstudio.MainStore');
        var form = Ext.getCmp('form_filter_GestionarEstudio');
        form.reset();
        var values = form.getValues();

    	store.load({params:values});

    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarEstudio.MainStore');
            var form = Ext.getCmp('form_filter_GestionarEstudio');
            var values = form.getValues();

        	store.load({params:values});
        }
    }
      
});