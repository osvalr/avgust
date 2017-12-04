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
* DATE CREATE : 01/12/2014 19:55:03
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarTablaGeneral.TablaGeneralDetalleQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarTablaGeneral.TablaGeneralDetalleQueryStore'],

    models: ['GestionarTablaGeneral.TablaGeneralDetalleQueryModel'],

    views: ['GestionarTablaGeneral.TablaGeneralDetalleQueryEdit', 'GestionarTablaGeneral.TablaGeneralDetalleQueryList'],

    refs: [
    	{
            ref: 'TablaGeneralDetalleQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'TablaGeneralDetalleQueryList',
            selector: 'TablaGeneralDetalleQueryList'
        }
    ],

    init: function() {
        this.control({
            'TablaGeneralDetalleQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'TablaGeneralDetalleQueryList button[action=add]': {
            	click: this.editRecord
            },
            'TablaGeneralDetalleQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'TablaGeneralDetalleQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarTablaGeneral.TablaGeneralDetalleQueryEdit').show();
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
        var store = Ext.getStore('GestionarTablaGeneral.TablaGeneralDetalleQueryStore');
        
        var TablaGeneralDetalleQuery_id_estado = Ext.getCmp('TablaGeneralDetalleQuery_id_estado');
        values.descrip_estado = TablaGeneralDetalleQuery_id_estado.getRawValue();
        
        
		if(win.title === 'Editar') {
			record.set(values);
		} else{
			record = Ext.create('MyApp.model.GestionarTablaGeneral.TablaGeneralDetalleQueryModel');
			record.set(values);
			store.add(record);
		}
        
		win.close();	
		store.sync({
	        success: function (batch, eOpts) {
	            store.load({params: {id_tabla_general: null}});
	        }
	    });
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getTablaGeneralDetalleQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarTablaGeneral.TablaGeneralDetalleQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {id_tabla_general: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});