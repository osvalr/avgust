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

Ext.define('MyApp.controller.GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryStore'],

    models: ['GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryModel'],

    views: ['GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryEdit', 'GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryList'],

    refs: [
    	{
            ref: 'GestionarTrabajadoresPresupuestoQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarTrabajadoresPresupuestoQueryList',
            selector: 'GestionarTrabajadoresPresupuestoQueryList'
        }
    ],

    init: function() {
        this.control({
            'GestionarTrabajadoresPresupuestoQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarTrabajadoresPresupuestoQueryList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarTrabajadoresPresupuestoQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarTrabajadoresPresupuestoQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryEdit').show();
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
        var store = Ext.getStore('GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryStore');
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                    	values.tokenField = 'update';
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryModel');
                        values.tokenField = 'insert';
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {idpersonal: null}});
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
    	
    	var grid = this.getGestionarTrabajadoresPresupuestoQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {idpersonal: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});