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
* DATE CREATE : 18/04/2015 17:45:06
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarFactorEvaluacion.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarFactorEvaluacion.MainStore'],

    models: ['GestionarFactorEvaluacion.MainModel'],

    views: ['GestionarFactorEvaluacion.Edit', 'GestionarFactorEvaluacion.List'],

    refs: [
    	{
            ref: 'GestionarFactorEvaluacionPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarFactorEvaluacionList',
            selector: 'GestionarFactorEvaluacionList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarFactorEvaluacion.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarFactorEvaluacionList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarFactorEvaluacionList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarFactorEvaluacionList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarFactorEvaluacionEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarFactorEvaluacionList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarFactorEvaluacionList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarFactorEvaluacionList combobox': {
                change: this.refreshGrid
            },
            'GestionarFactorEvaluacionList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarFactorEvaluacion.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_FactorEvaluacionQuery = Ext.getCmp('subModel_FactorEvaluacionQuery');
        	var srl_id_configuracion_factor_evaluacion = form.getForm().findField('srl_id_configuracion_factor_evaluacion');
        	
			subModel_FactorEvaluacionQuery.store.reload({params: {srl_id_configuracion_factor_evaluacion: srl_id_configuracion_factor_evaluacion.getValue(), start:0, limit:10}});
			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_FactorEvaluacionQuery = Ext.getCmp('subModel_FactorEvaluacionQuery');
			subModel_FactorEvaluacionQuery.store.reload({params: {srl_id_configuracion_factor_evaluacion: -1, start:0, limit:10}});
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarFactorEvaluacion.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_configuracion_factor_evaluacion > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarFactorEvaluacion.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarFactorEvaluacion_statusbar');
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
	            }
	        });
		}

    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarFactorEvaluacionList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarFactorEvaluacion.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarFactorEvaluacion.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarFactorEvaluacion.MainStore');
        var form = Ext.getCmp('form_filter_GestionarFactorEvaluacion');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarFactorEvaluacion.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarFactorEvaluacion.MainStore');
        var form = Ext.getCmp('form_filter_GestionarFactorEvaluacion');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});