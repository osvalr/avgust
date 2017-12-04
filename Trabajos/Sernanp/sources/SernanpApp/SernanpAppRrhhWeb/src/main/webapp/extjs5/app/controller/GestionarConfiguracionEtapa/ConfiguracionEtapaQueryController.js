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
* DATE CREATE : 18/04/2015 19:13:57
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarConfiguracionEtapa.ConfiguracionEtapaQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarConfiguracionEtapa.ConfiguracionEtapaQueryStore'],

    models: ['GestionarConfiguracionEtapa.ConfiguracionEtapaQueryModel'],

    views: ['GestionarConfiguracionEtapa.ConfiguracionEtapaQueryEdit', 'GestionarConfiguracionEtapa.ConfiguracionEtapaQueryList'],

    refs: [
    	{
            ref: 'ConfiguracionEtapaQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'ConfiguracionEtapaQueryList',
            selector: 'ConfiguracionEtapaQueryList'
        }
    ],

    init: function() {
        this.control({
            'ConfiguracionEtapaQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'ConfiguracionEtapaQueryList button[action=add]': {
            	click: this.editRecord
            },
            'ConfiguracionEtapaQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'ConfiguracionEtapaQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarConfiguracionEtapa.ConfiguracionEtapaQueryEdit').show();
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
        var store = Ext.getStore('GestionarConfiguracionEtapa.ConfiguracionEtapaQueryStore');
        
        var srl_id_subetapa_proceso_seleccion = form.getForm().findField('srl_id_subetapa_proceso_seleccion');
        values.var_descrip_subetapa = srl_id_subetapa_proceso_seleccion.getRawValue();
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.descrip_estado = int_id_estado.getRawValue();
        
        var srl_id_etapa_proceso_seleccion = form.getForm().findField('srl_id_etapa_proceso_seleccion');
        values.var_nombre_etapa = srl_id_etapa_proceso_seleccion.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarConfiguracionEtapa.ConfiguracionEtapaQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {srl_id_configuracion_evaluacion_personal: null}});
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
    	
    	var grid = this.getConfiguracionEtapaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarConfiguracionEtapa.ConfiguracionEtapaQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {srl_id_configuracion_evaluacion_personal: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});