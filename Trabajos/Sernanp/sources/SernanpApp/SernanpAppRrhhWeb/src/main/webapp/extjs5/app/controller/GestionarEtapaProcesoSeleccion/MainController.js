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
* DATE CREATE : 18/04/2015 18:55:24
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarEtapaProcesoSeleccion.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarEtapaProcesoSeleccion.MainStore'],

    models: ['GestionarEtapaProcesoSeleccion.MainModel'],

    views: ['GestionarEtapaProcesoSeleccion.Edit', 'GestionarEtapaProcesoSeleccion.List'],

    refs: [
    	{
            ref: 'GestionarEtapaProcesoSeleccionPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarEtapaProcesoSeleccionList',
            selector: 'GestionarEtapaProcesoSeleccionList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarEtapaProcesoSeleccion.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarEtapaProcesoSeleccionList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarEtapaProcesoSeleccionList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarEtapaProcesoSeleccionList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarEtapaProcesoSeleccionEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarEtapaProcesoSeleccionList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarEtapaProcesoSeleccionList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarEtapaProcesoSeleccionList combobox': {
                change: this.refreshGrid
            },
            'GestionarEtapaProcesoSeleccionList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarEtapaProcesoSeleccion.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_SubEtapaProcesoSelecionQuery = Ext.getCmp('subModel_SubEtapaProcesoSelecionQuery');
        	var srl_id_etapa_proceso_seleccion = form.getForm().findField('srl_id_etapa_proceso_seleccion');
        	
			subModel_SubEtapaProcesoSelecionQuery.store.reload({params: {srl_id_etapa_proceso_seleccion: srl_id_etapa_proceso_seleccion.getValue(), start:0, limit:10}});
			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_SubEtapaProcesoSelecionQuery = Ext.getCmp('subModel_SubEtapaProcesoSelecionQuery');
			subModel_SubEtapaProcesoSelecionQuery.store.reload({params: {srl_id_etapa_proceso_seleccion: -1, start:0, limit:10}});
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarEtapaProcesoSeleccion.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_etapa_proceso_seleccion > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarEtapaProcesoSeleccion.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarEtapaProcesoSeleccion_statusbar');
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
    	
    	var grid = this.getGestionarEtapaProcesoSeleccionList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarEtapaProcesoSeleccion.MainStore');
    	
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
    	var store = Ext.getStore('GestionarEtapaProcesoSeleccion.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarEtapaProcesoSeleccion.MainStore');
        var form = Ext.getCmp('form_filter_GestionarEtapaProcesoSeleccion');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarEtapaProcesoSeleccion.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarEtapaProcesoSeleccion.MainStore');
        var form = Ext.getCmp('form_filter_GestionarEtapaProcesoSeleccion');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});