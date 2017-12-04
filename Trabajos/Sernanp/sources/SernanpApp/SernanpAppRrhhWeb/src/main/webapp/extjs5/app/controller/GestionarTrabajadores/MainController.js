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
* DATE CREATE : 27/05/2015 04:42:23
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarTrabajadores.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarTrabajadores.MainStore'],

    models: ['GestionarTrabajadores.MainModel'],

    views: ['GestionarTrabajadores.Edit', 'GestionarTrabajadores.List'],

    refs: [
    	{
            ref: 'GestionarTrabajadoresPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarTrabajadoresList',
            selector: 'GestionarTrabajadoresList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarTrabajadores.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarTrabajadoresList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarTrabajadoresList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarTrabajadoresList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarTrabajadoresEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarTrabajadoresList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarTrabajadoresList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarTrabajadoresList combobox': {
                change: this.refreshGrid
            },
            'GestionarTrabajadoresList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarTrabajadores.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_GestionarTrabajadoresPresupuestoQuery = Ext.getCmp('subModel_GestionarTrabajadoresPresupuestoQuery');
        	var idpersonanatural = form.getForm().findField('idpersonanatural');
        	
			subModel_GestionarTrabajadoresPresupuestoQuery.store.reload({
			params: {idpersonanatural: idpersonanatural.getValue(), start:0, limit:10},
			scope: this
			});
			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_GestionarTrabajadoresPresupuestoQuery = Ext.getCmp('subModel_GestionarTrabajadoresPresupuestoQuery');
			subModel_GestionarTrabajadoresPresupuestoQuery.store.reload({params: {idpersonanatural: -1, start:0, limit:10}});
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarTrabajadores.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarTrabajadores.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarTrabajadores_statusbar');
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
    	
    	var grid = this.getGestionarTrabajadoresList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarTrabajadores.MainStore');
    	
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
    	var store = Ext.getStore('GestionarTrabajadores.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarTrabajadores.MainStore');
        var form = Ext.getCmp('form_filter_GestionarTrabajadores');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarTrabajadores.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarTrabajadores.MainStore');
        var form = Ext.getCmp('form_filter_GestionarTrabajadores');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});