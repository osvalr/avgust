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
* DATE CREATE : 11/06/2015 14:14:52
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteResumenAltasBajas.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteResumenAltasBajas.MainStore'],

    models: ['ReporteResumenAltasBajas.MainModel'],

    views: ['ReporteResumenAltasBajas.Edit', 'ReporteResumenAltasBajas.List'],

    refs: [
    	{
            ref: 'ReporteResumenAltasBajasPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteResumenAltasBajasList',
            selector: 'ReporteResumenAltasBajasList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteResumenAltasBajas.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteResumenAltasBajasList dataview': {
//                itemdblclick: this.editRecord
            },
            'ReporteResumenAltasBajasList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteResumenAltasBajasList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteResumenAltasBajasEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteResumenAltasBajasList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteResumenAltasBajasList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteResumenAltasBajasList combobox': {
                change: this.refreshGrid
            },
            'ReporteResumenAltasBajasList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteResumenAltasBajasList button[action=generarReporteXLS]': {
                click: this.resumenAltasBajasXLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteResumenAltasBajas.Edit').show();
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
        var store = Ext.getStore('ReporteResumenAltasBajas.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteResumenAltasBajas.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteResumenAltasBajas_statusbar');
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
    	
    	var grid = this.getReporteResumenAltasBajasList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteResumenAltasBajas.MainStore');
    	
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
    
    resumenAltasBajasXLS: function(button){
        
    	var form = Ext.getCmp('form_filter_ReporteResumenAltasBajas');
    	
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var int_anio = form.getForm().findField('int_anio');
    	var int_estado = form.getForm().findField('int_estado');
    	var tipo_reporte = 'xls';
    	
    		
    		window.open('listar-resumen-altas-bajas.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()
				    +'&int_estado=' + int_estado.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank'); 
    		


    },
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteResumenAltasBajas.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteResumenAltasBajas.MainStore');
        var form = Ext.getCmp('form_filter_ReporteResumenAltasBajas');
        form.reset();
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(1);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteResumenAltasBajas.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteResumenAltasBajas.MainStore');
        var form = Ext.getCmp('form_filter_ReporteResumenAltasBajas');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});