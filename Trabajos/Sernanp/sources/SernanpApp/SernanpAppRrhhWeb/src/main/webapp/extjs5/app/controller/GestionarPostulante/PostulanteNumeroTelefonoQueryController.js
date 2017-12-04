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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarPostulante.PostulanteNumeroTelefonoQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPostulante.PostulanteNumeroTelefonoQueryStore'],

    models: ['GestionarPostulante.PostulanteNumeroTelefonoQueryModel'],

    views: ['GestionarPostulante.PostulanteNumeroTelefonoQueryEdit', 'GestionarPostulante.PostulanteNumeroTelefonoQueryList'],

    refs: [
    	{
            ref: 'PostulanteNumeroTelefonoQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'PostulanteNumeroTelefonoQueryList',
            selector: 'PostulanteNumeroTelefonoQueryList'
        }
    ],

    init: function() {
        this.control({
            'PostulanteNumeroTelefonoQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'PostulanteNumeroTelefonoQueryList button[action=add]': {
            	click: this.editRecord
            },
            'PostulanteNumeroTelefonoQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'PostulanteNumeroTelefonoQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarPostulante.PostulanteNumeroTelefonoQueryEdit').show();
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
        var store = Ext.getStore('GestionarPostulante.PostulanteNumeroTelefonoQueryStore');
        
        var int_id_tipo_telefono = form.getForm().findField('int_id_tipo_telefono');
        values.descrip_tipo_telefono = int_id_tipo_telefono.getRawValue();
        
        var int_id_tipo_operador = form.getForm().findField('int_id_tipo_operador');
        values.descrip_tipo_operador = int_id_tipo_operador.getRawValue();
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.descrip_estado = int_id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarPostulante.PostulanteNumeroTelefonoQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {int_id_postulante: null}});
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
    	
    	var grid = this.getPostulanteNumeroTelefonoQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPostulante.PostulanteNumeroTelefonoQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {int_id_postulante: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});