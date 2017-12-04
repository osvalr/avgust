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
* DATE CREATE : 23/05/2015 14:01:52
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteDocumentoConsolidadoConvocatoria.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteDocumentoConsolidadoConvocatoria.MainStore'],

    models: ['ReporteDocumentoConsolidadoConvocatoria.MainModel'],

    views: ['ReporteDocumentoConsolidadoConvocatoria.Edit', 'ReporteDocumentoConsolidadoConvocatoria.List'],

    refs: [
    	{
            ref: 'ReporteDocumentoConsolidadoConvocatoriaPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteDocumentoConsolidadoConvocatoriaList',
            selector: 'ReporteDocumentoConsolidadoConvocatoriaList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteDocumentoConsolidadoConvocatoria.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteDocumentoConsolidadoConvocatoriaList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteDocumentoConsolidadoConvocatoriaList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteDocumentoConsolidadoConvocatoriaList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteDocumentoConsolidadoConvocatoriaEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteDocumentoConsolidadoConvocatoriaList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteDocumentoConsolidadoConvocatoriaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteDocumentoConsolidadoConvocatoriaList combobox': {
                change: this.refreshGrid
            },
            'ReporteDocumentoConsolidadoConvocatoriaList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteDocumentoConsolidadoConvocatoria.Edit').show();
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
        var store = Ext.getStore('ReporteDocumentoConsolidadoConvocatoria.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_convocatoria > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteDocumentoConsolidadoConvocatoria.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteDocumentoConsolidadoConvocatoria_statusbar');
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
    	
    	var grid = this.getReporteDocumentoConsolidadoConvocatoriaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteDocumentoConsolidadoConvocatoria.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        },
		        	        failure: function (batch, eOpts) {
								store.rejectChanges();
		        	        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteDocumentoConsolidadoConvocatoria.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteDocumentoConsolidadoConvocatoria.MainStore');
        var form = Ext.getCmp('form_filter_ReporteDocumentoConsolidadoConvocatoria');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteDocumentoConsolidadoConvocatoria.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteDocumentoConsolidadoConvocatoria.MainStore');
        var form = Ext.getCmp('form_filter_ReporteDocumentoConsolidadoConvocatoria');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});