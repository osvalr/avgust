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
* DATE CREATE : 17/04/2015 16:51:57
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarResponsablePlaza.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarResponsablePlaza.MainStore'],

    models: ['GestionarResponsablePlaza.MainModel'],

    views: ['GestionarResponsablePlaza.Edit', 'GestionarResponsablePlaza.List'],

    refs: [
    	{
            ref: 'GestionarResponsablePlazaPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarResponsablePlazaList',
            selector: 'GestionarResponsablePlazaList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarResponsablePlaza.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarResponsablePlazaList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarResponsablePlazaList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarResponsablePlazaList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarResponsablePlazaEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarResponsablePlazaList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarResponsablePlazaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarResponsablePlazaList combobox': {
                change: this.refreshGrid
            },
            'GestionarResponsablePlazaList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarResponsablePlaza.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_ResponsablePlazaQuery = Ext.getCmp('subModel_ResponsablePlazaQuery');
        	var idpersonal = form.getForm().findField('idpersonal');
        	
			subModel_ResponsablePlazaQuery.store.reload({params: {idpersonal: idpersonal.getValue(), start:0, limit:10}});
			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_ResponsablePlazaQuery = Ext.getCmp('subModel_ResponsablePlazaQuery');
			subModel_ResponsablePlazaQuery.store.reload({params: {idpersonal: -1, start:0, limit:10}});
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarResponsablePlaza.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarResponsablePlaza.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarResponsablePlaza_statusbar');
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
    	
    	var grid = this.getGestionarResponsablePlazaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarResponsablePlaza.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarResponsablePlaza.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarResponsablePlaza.MainStore');
        var form = Ext.getCmp('form_filter_GestionarResponsablePlaza');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarResponsablePlaza.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarResponsablePlaza.MainStore');
        var form = Ext.getCmp('form_filter_GestionarResponsablePlaza');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});