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
* DATE CREATE : 23/04/2015 16:49:26
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryStore'],

    models: ['ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryModel'],

    views: ['ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryEdit', 'ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryList'],

    refs: [
    	{
            ref: 'ConvocatoriaPlazaFactorQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'ConvocatoriaPlazaFactorQueryList',
            selector: 'ConvocatoriaPlazaFactorQueryList'
        }
    ],

    init: function() {
        this.control({
            'ConvocatoriaPlazaFactorQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'ConvocatoriaPlazaFactorQueryList button[action=add]': {
            	click: this.editRecord
            },
            'ConvocatoriaPlazaFactorQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'ConvocatoriaPlazaFactorQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryEdit').show();
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
        var store = Ext.getStore('ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryStore');
        
        var int_id_tipo_factor = form.getForm().findField('int_id_tipo_factor');
        values.int_descrip_tipo_factor = int_id_tipo_factor.getRawValue();
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.int_descrip_estado = int_id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {srl_id_configuracion_factor_evaluacion: null}});
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
    	
    	var grid = this.getConvocatoriaPlazaFactorQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {srl_id_configuracion_factor_evaluacion: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});