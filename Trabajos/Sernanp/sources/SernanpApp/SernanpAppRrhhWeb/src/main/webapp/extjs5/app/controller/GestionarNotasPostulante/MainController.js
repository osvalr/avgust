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
* DATE CREATE : 20/04/2015 15:33:18
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarNotasPostulante.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarNotasPostulante.MainStore'],

    models: ['GestionarNotasPostulante.MainModel'],

    views: ['GestionarNotasPostulante.Edit', 'GestionarNotasPostulante.List', , 'GestionarNotasPostulante.WindowList'],

    refs: [
    	{
            ref: 'GestionarNotasPostulantePanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarNotasPostulanteList',
            selector: 'GestionarNotasPostulanteList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarNotasPostulante.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'GestionarNotasPostulanteList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarNotasPostulanteList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarNotasPostulanteList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarNotasPostulanteEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarNotasPostulanteList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarNotasPostulanteList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarNotasPostulanteList combobox': {
                change: this.refreshGrid
            },
            'GestionarNotasPostulanteList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
    	
    	var store = Ext.getStore('GestionarNotasPostulante.MainStore');
    	
    	var int_id_tipo_factor = record.data.int_id_tipo_factor;
    	console.log('int_id_tipo_factor --> ' +int_id_tipo_factor);
    	var existeSubItem = false;
    	store.each(function(rec){
    		var int_id_tipo_factor_padre = rec.get('int_id_tipo_factor_padre');
    		console.log('int_id_tipo_factor_padre --> ' +int_id_tipo_factor_padre)
    		if(int_id_tipo_factor_padre === int_id_tipo_factor){
    			existeSubItem = true;
    		}
    	});
    	
    	if(!existeSubItem){
    		var edit = Ext.create('MyApp.view.GestionarNotasPostulante.Edit').show();
            if(record.data){
            	edit.down('form').loadRecord(record);
            	edit.setTitle('Editar');
            }else{
            	edit.setTitle('Agregar');
            }
    	}
        
    },
    
    updateRecord: function(button) {
    	alert("Guardando nota ...");
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarNotasPostulante.MainStore');
        
        if (form.isValid()) {
//	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
//	            if (btn == 'yes') {
	        		if (values.srl_conv_area_org_factor_eval > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarNotasPostulante.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_GestionarNotasPostulante_statusbar');
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
//	            }
//	        });
		}
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarNotasPostulanteList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarNotasPostulante.MainStore');
    	
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
    	var store = Ext.getStore('GestionarNotasPostulante.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarNotasPostulante.MainStore');
        var form = Ext.getCmp('form_filter_GestionarNotasPostulante');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarNotasPostulante.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarNotasPostulante.MainStore');
        var form = Ext.getCmp('form_filter_GestionarNotasPostulante');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});