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

Ext.define('MyApp.controller.GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryStore'],

    models: ['GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryModel'],

    views: ['GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryEdit', 'GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryList'],

    refs: [
    	{
            ref: 'CongregacionLocalNumeroTelefonicoQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'CongregacionLocalNumeroTelefonicoQueryList',
            selector: 'CongregacionLocalNumeroTelefonicoQueryList'
        }
    ],

    init: function() {
        this.control({
            'CongregacionLocalNumeroTelefonicoQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'CongregacionLocalNumeroTelefonicoQueryList button[action=add]': {
            	click: this.editRecord
            },
            'CongregacionLocalNumeroTelefonicoQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'CongregacionLocalNumeroTelefonicoQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryEdit').show();
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
        var store = Ext.getStore('GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryStore');
        
        var id_tipo_telefono = form.getForm().findField('id_tipo_telefono');
        values.descrip_tipo_telefono = id_tipo_telefono.getRawValue();
        
        var id_empresa_operadora = form.getForm().findField('id_empresa_operadora');
        values.razon_social = id_empresa_operadora.getRawValue();
        
        var id_estado = form.getForm().findField('id_estado');
        values.descrip_estado = id_estado.getRawValue();
        
        
		if(win.title === 'Editar') {
			record.set(values);
		} else{
			record = Ext.create('MyApp.model.GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryModel');
			record.set(values);
			store.add(record);
		}
        
		win.close();	
		store.sync({
	        success: function (batch, eOpts) {
	            store.load({params: {id_persona: null}});
	        }
	    });
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getCongregacionLocalNumeroTelefonicoQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarCongregacionLocal.CongregacionLocalNumeroTelefonicoQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {id_persona: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});