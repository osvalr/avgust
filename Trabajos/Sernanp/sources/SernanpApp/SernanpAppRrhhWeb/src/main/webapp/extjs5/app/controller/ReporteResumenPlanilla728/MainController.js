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
* DATE CREATE : 31/05/2015 14:56:55
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteResumenPlanilla728.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteResumenPlanilla728.MainStore'],

    models: ['ReporteResumenPlanilla728.MainModel'],

    views: ['ReporteResumenPlanilla728.Edit', 'ReporteResumenPlanilla728.List'],

    refs: [
    	{
            ref: 'ReporteResumenPlanilla728Panel',
            selector: 'panel'
        },
        {
            ref: 'ReporteResumenPlanilla728List',
            selector: 'ReporteResumenPlanilla728List'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteResumenPlanilla728.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteResumenPlanilla728List dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteResumenPlanilla728List button[action=add]': {
            	click: this.editRecord
            },
            'ReporteResumenPlanilla728List button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteResumenPlanilla728Edit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteResumenPlanilla728List button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteResumenPlanilla728List button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteResumenPlanilla728List combobox': {
                change: this.refreshGrid
            },
            'ReporteResumenPlanilla728List textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteResumenPlanilla728List button[action=generarReportePDF]': {
                click: this.listarResumenPlanilla728_PDF
            },
            'ReporteResumenPlanilla728List button[action=generarReporteXLS]': {
                click: this.listarResumenPlanilla728_XLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteResumenPlanilla728.Edit').show();
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
        var store = Ext.getStore('ReporteResumenPlanilla728.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteResumenPlanilla728.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteResumenPlanilla728_statusbar');
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
    	
    	var grid = this.getReporteResumenPlanilla728List();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteResumenPlanilla728.MainStore');
    	
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
    listarResumenPlanilla728_PDF: function(button){
        
    	var form = Ext.getCmp('form_filter_ReporteResumenPlanilla728');
    	
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var srl_id_fuente_financiamiento = form.getForm().findField('srl_id_fuente_financiamiento');
    	var int_anio = form.getForm().findField('int_anio');
    	var tipo_reporte = 'pdf';
    	
    	
        if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
            });
    		
    	}else{

    		
    		window.open('listar-resumen-planilla-728-pdf.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()
    				+ '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&srl_id_fuente_financiamiento=' + srl_id_fuente_financiamiento.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');  
    	}

    },
    listarResumenPlanilla728_XLS: function(button){
        
    	var form = Ext.getCmp('form_filter_ReporteResumenPlanilla728');
    	
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var srl_id_fuente_financiamiento = form.getForm().findField('srl_id_fuente_financiamiento');
    	var int_anio = form.getForm().findField('int_anio');
    	var tipo_reporte = 'xls';
    	
    	if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
        });
    		
    	}else{  
    		
    		window.open('listar-resumen-planilla-728-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()
				     + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&srl_id_fuente_financiamiento=' + srl_id_fuente_financiamiento.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank'); 
    		
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteResumenPlanilla728.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteResumenPlanilla728.MainStore');
        var form = Ext.getCmp('form_filter_ReporteResumenPlanilla728');
        form.reset();
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(1);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteResumenPlanilla728.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteResumenPlanilla728.MainStore');
        var form = Ext.getCmp('form_filter_ReporteResumenPlanilla728');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});