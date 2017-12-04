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

Ext.define('MyApp.controller.GestionarPersonaNatural.InformacionEclesiasticaQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPersonaNatural.InformacionEclesiasticaQueryStore'],

    models: ['GestionarPersonaNatural.InformacionEclesiasticaQueryModel'],

    views: ['GestionarPersonaNatural.InformacionEclesiasticaQueryEdit', 'GestionarPersonaNatural.InformacionEclesiasticaQueryList'],

    refs: [
    	{
            ref: 'InformacionEclesiasticaQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'InformacionEclesiasticaQueryList',
            selector: 'InformacionEclesiasticaQueryList'
        }
    ],

    init: function() {
        this.control({
            'InformacionEclesiasticaQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'InformacionEclesiasticaQueryList button[action=add]': {
            	click: this.editRecord
            },
            'InformacionEclesiasticaQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'InformacionEclesiasticaQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarPersonaNatural.InformacionEclesiasticaQueryEdit').show();
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
        var store = Ext.getStore('GestionarPersonaNatural.InformacionEclesiasticaQueryStore');
        
        var id_congregacion = form.getForm().findField('id_congregacion');
        values.razon_social = id_congregacion.getRawValue();
        
        var id_tipo_evento = form.getForm().findField('id_tipo_evento');
        values.descrip_tipo_evento_eclesiastico = id_tipo_evento.getRawValue();
        
        var id_estado = form.getForm().findField('id_estado');
        values.descrip_estado = id_estado.getRawValue();
        
        
		if(win.title === 'Editar') {
			record.set(values);
		} else{
			record = Ext.create('MyApp.model.GestionarPersonaNatural.InformacionEclesiasticaQueryModel');
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
    	
    	var grid = this.getInformacionEclesiasticaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPersonaNatural.InformacionEclesiasticaQueryStore');
    	
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