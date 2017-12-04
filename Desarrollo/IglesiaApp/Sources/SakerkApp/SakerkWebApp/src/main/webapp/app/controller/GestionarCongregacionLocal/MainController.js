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
* DATE CREATE : 22/01/2015 18:47:38
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarCongregacionLocal.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarCongregacionLocal.MainStore'],

    models: ['GestionarCongregacionLocal.MainModel'],

    views: ['GestionarCongregacionLocal.Edit', 'GestionarCongregacionLocal.List'],

    refs: [
    	{
            ref: 'GestionarCongregacionLocalPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarCongregacionLocalList',
            selector: 'GestionarCongregacionLocalList'
        }
    ],

    init: function() {
        this.control({
            'GestionarCongregacionLocalList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarCongregacionLocalList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarCongregacionLocalList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarCongregacionLocalEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarCongregacionLocalList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarCongregacionLocalList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarCongregacionLocalList combobox': {
                change: this.refreshGrid
            },
            'GestionarCongregacionLocalList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarCongregacionLocal.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var detailCongregacionLocalNumeroTelefonicoQuery = Ext.getCmp('detailCongregacionLocalNumeroTelefonicoQuery');
        	var id_persona = form.getForm().findField('id_persona');
        	
			detailCongregacionLocalNumeroTelefonicoQuery.store.reload({params: {id_persona: id_persona.getValue(), start:0, limit:10}});
			
        }else{
        	edit.setTitle('Agregar');
        	var detailCongregacionLocalNumeroTelefonicoQuery = Ext.getCmp('detailCongregacionLocalNumeroTelefonicoQuery');
			detailCongregacionLocalNumeroTelefonicoQuery.store.reload({params: {id_persona: -1, start:0, limit:10}});
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarCongregacionLocal.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.id_persona > 0){
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarCongregacionLocal.MainModel');
	        			record.set(values);
	        			store.add(record);
	        		}
	                
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	var form = Ext.getCmp('form_filter_GestionarCongregacionLocal');
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
    	
    	var grid = this.getGestionarCongregacionLocalList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarCongregacionLocal.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	var form = Ext.getCmp('form_filter_GestionarCongregacionLocal');
					            var values = form.getValues();
					        	store.load({params:values});
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {

    	var store = Ext.getStore('GestionarCongregacionLocal.MainStore');
        var form = Ext.getCmp('form_filter_GestionarCongregacionLocal');
        var values = form.getValues();

    	store.load({params:values});

    },
    resetForm: function() {
    	
    	var store = Ext.getStore('GestionarCongregacionLocal.MainStore');
        var form = Ext.getCmp('form_filter_GestionarCongregacionLocal');
        form.reset();
        var values = form.getValues();

    	store.load({params:values});

    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarCongregacionLocal.MainStore');
            var form = Ext.getCmp('form_filter_GestionarCongregacionLocal');
            var values = form.getValues();

        	store.load({params:values});
        }
    }
    
});