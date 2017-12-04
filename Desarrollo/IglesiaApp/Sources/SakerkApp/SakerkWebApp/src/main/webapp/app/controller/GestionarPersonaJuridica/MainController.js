/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
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
* DATE CREATE : 20/01/2015 13:21:31
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarPersonaJuridica.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPersonaJuridica.MainStore'],

    models: ['GestionarPersonaJuridica.MainModel'],

    views: ['GestionarPersonaJuridica.Edit', 'GestionarPersonaJuridica.List'],

    refs: [
    	{
            ref: 'GestionarPersonaJuridicaPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarPersonaJuridicaList',
            selector: 'GestionarPersonaJuridicaList'
        }
    ],

    init: function() {
        this.control({
            'GestionarPersonaJuridicaList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarPersonaJuridicaList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarPersonaJuridicaList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarPersonaJuridicaEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarPersonaJuridicaList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarPersonaJuridicaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarPersonaJuridicaList combobox': {
                change: this.refreshGrid
            },
            'GestionarPersonaJuridicaList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarPersonaJuridica.Edit').show();
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
        var store = Ext.getStore('GestionarPersonaJuridica.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_persona > 0){
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarPersonaJuridica.MainModel');
	        			record.set(values);
	        			store.add(record);
	        		}
	                	
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	var form = Ext.getCmp('form_filter_GestionarPersonaJuridica');
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
    	
    	var grid = this.getGestionarPersonaJuridicaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPersonaJuridica.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	var form = Ext.getCmp('form_filter_GestionarPersonaJuridica');
					            var values = form.getValues();
					        	store.load({params:values});
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {

    	var store = Ext.getStore('GestionarPersonaJuridica.MainStore');
        var form = Ext.getCmp('form_filter_GestionarPersonaJuridica');
        var values = form.getValues();

    	store.load({params:values});

    },
    resetForm: function() {
    	
    	var store = Ext.getStore('GestionarPersonaJuridica.MainStore');
        var form = Ext.getCmp('form_filter_GestionarPersonaJuridica');
        form.reset();
        var values = form.getValues();

    	store.load({params:values});

    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarPersonaJuridica.MainStore');
            var form = Ext.getCmp('form_filter_GestionarPersonaJuridica');
            var values = form.getValues();

        	store.load({params:values});
        }
    }
      
});