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
* DATE CREATE : 20/12/2014 22:23:10
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarCongregacion.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarCongregacion.MainStore'],

    models: ['GestionarCongregacion.MainModel'],

    views: ['GestionarCongregacion.Edit', 'GestionarCongregacion.List'],

    refs: [
    	{
            ref: 'GestionarCongregacionPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarCongregacionList',
            selector: 'GestionarCongregacionList'
        }
    ],

    init: function() {
        this.control({
            'GestionarCongregacionList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarCongregacionList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarCongregacionList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarCongregacionEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarCongregacionList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarCongregacionList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarCongregacionList combobox': {
                change: this.refreshGrid
            },
            'GestionarCongregacionList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarCongregacion.Edit').show();
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
        var store = Ext.getStore('GestionarCongregacion.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_congregacion_general > 0){
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarCongregacion.MainModel');
	        			record.set(values);
	        			store.add(record);
	        		}
	                	
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	var form = Ext.getCmp('form_filter_GestionarCongregacion');
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
    	
    	var grid = this.getGestionarCongregacionList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarCongregacion.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	var form = Ext.getCmp('form_filter_GestionarCongregacion');
					            var values = form.getValues();
					        	store.load({params:values});
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {

    	var store = Ext.getStore('GestionarCongregacion.MainStore');
        var form = Ext.getCmp('form_filter_GestionarCongregacion');
        var values = form.getValues();

    	store.load({params:values});

    },
    resetForm: function() {
    	
    	var store = Ext.getStore('GestionarCongregacion.MainStore');
        var form = Ext.getCmp('form_filter_GestionarCongregacion');
        form.reset();
        var values = form.getValues();

    	store.load({params:values});

    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarCongregacion.MainStore');
            var form = Ext.getCmp('form_filter_GestionarCongregacion');
            var values = form.getValues();

        	store.load({params:values});
        }
    }
      
});