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
* DATE CREATE : 20/12/2014 14:30:15
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarPersonaNatural.PersonaNaturalRolQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPersonaNatural.PersonaNaturalRolQueryStore'],

    models: ['GestionarPersonaNatural.PersonaNaturalRolQueryModel'],

    views: ['GestionarPersonaNatural.PersonaNaturalRolQueryEdit', 'GestionarPersonaNatural.PersonaNaturalRolQueryList'],

    refs: [
    	{
            ref: 'PersonaNaturalRolQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'PersonaNaturalRolQueryList',
            selector: 'PersonaNaturalRolQueryList'
        }
    ],

    init: function() {
        this.control({
            'PersonaNaturalRolQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'PersonaNaturalRolQueryList button[action=add]': {
            	click: this.editRecord
            },
            'PersonaNaturalRolQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'PersonaNaturalRolQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarPersonaNatural.PersonaNaturalRolQueryEdit').show();
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
        var store = Ext.getStore('GestionarPersonaNatural.PersonaNaturalRolQueryStore');
        
        var id_rol = form.getForm().findField('id_rol');
        values.nombre_rol = id_rol.getRawValue();
        
        var id_estado = form.getForm().findField('id_estado');
        values.descrip_estado_generico = id_estado.getRawValue();
        
        
		if(win.title === 'Editar') {
			record.set(values);
		} else{
			record = Ext.create('MyApp.model.GestionarPersonaNatural.PersonaNaturalRolQueryModel');
			record.set(values);
			store.add(record);
		}
        
		win.close();	
		store.sync({
	        success: function (batch, eOpts) {
	            store.load({params: {id_persona_natural: null}});
	        }
	    });
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getPersonaNaturalRolQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPersonaNatural.PersonaNaturalRolQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {id_persona_natural: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});