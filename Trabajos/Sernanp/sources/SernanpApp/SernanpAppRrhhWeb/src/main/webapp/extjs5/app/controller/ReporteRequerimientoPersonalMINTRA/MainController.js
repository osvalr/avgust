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
* DATE CREATE : 19/05/2015 22:46:28
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteRequerimientoPersonalMINTRA.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteRequerimientoPersonalMINTRA.MainStore'],

    models: ['ReporteRequerimientoPersonalMINTRA.MainModel'],

    views: ['ReporteRequerimientoPersonalMINTRA.Edit', 'ReporteRequerimientoPersonalMINTRA.List'],

    refs: [
    	{
            ref: 'ReporteRequerimientoPersonalMINTRAPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteRequerimientoPersonalMINTRAList',
            selector: 'ReporteRequerimientoPersonalMINTRAList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteRequerimientoPersonalMINTRA.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteRequerimientoPersonalMINTRAList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteRequerimientoPersonalMINTRAList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteRequerimientoPersonalMINTRAList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteRequerimientoPersonalMINTRAEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteRequerimientoPersonalMINTRAList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteRequerimientoPersonalMINTRAList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteRequerimientoPersonalMINTRAList combobox': {
                change: this.refreshGrid
            },
            'ReporteRequerimientoPersonalMINTRAList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteRequerimientoPersonalMINTRAList button[action=generarReporte]': {
                click: this.reporteOficioMintra
            }
               
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteRequerimientoPersonalMINTRA.Edit').show();
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
        var store = Ext.getStore('ReporteRequerimientoPersonalMINTRA.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_requerimiento_personal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteRequerimientoPersonalMINTRA.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteRequerimientoPersonalMINTRA_statusbar');
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
    	
    	var grid = this.getReporteRequerimientoPersonalMINTRAList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteRequerimientoPersonalMINTRA.MainStore');
    	
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
    
    reporteOficioMintra :function(button){
    	
    	var grid = this.getReporteRequerimientoPersonalMINTRAList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteRequerimientoPersonalMINTRA.MainStore');
    	
    	window.open('oficio-requerimientos-mintra.action',  '_blank');
    	
    },
        
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteRequerimientoPersonalMINTRA.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteRequerimientoPersonalMINTRA.MainStore');
        var form = Ext.getCmp('form_filter_ReporteRequerimientoPersonalMINTRA');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteRequerimientoPersonalMINTRA.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteRequerimientoPersonalMINTRA.MainStore');
        var form = Ext.getCmp('form_filter_ReporteRequerimientoPersonalMINTRA');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});