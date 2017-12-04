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
* DATE CREATE : 23/03/2015 12:20:16
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryStore'],

    models: ['GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryModel'],

    views: ['GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryEdit', 'GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryList'],

    refs: [
    	{
            ref: 'GestionarAnioPeriodoPlanillaQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarAnioPeriodoPlanillaQueryList',
            selector: 'GestionarAnioPeriodoPlanillaQueryList'
        }
    ],

    init: function() {
        this.control({
            'GestionarAnioPeriodoPlanillaQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarAnioPeriodoPlanillaQueryList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarAnioPeriodoPlanillaQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarAnioPeriodoPlanillaQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryEdit').show();
        var form = Ext.getCmp('form_submodel_GestionarAnioPeriodoPlanillaQuery');
        
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        }else{
        	edit.setTitle('Agregar');
        	var int_id_estado = form.getForm().findField('int_id_estado');
        	int_id_estado.setReadOnly(true);
        	int_id_estado.setValue(1);
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryStore');
        
        var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
        values.var_des_periodo_mes = int_id_periodo_mes.getRawValue();
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.var_des_tipo_estado = int_id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {srl_id_anio_planilla: null}});
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
    	
    	var grid = this.getGestionarAnioPeriodoPlanillaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {srl_id_anio_planilla: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});