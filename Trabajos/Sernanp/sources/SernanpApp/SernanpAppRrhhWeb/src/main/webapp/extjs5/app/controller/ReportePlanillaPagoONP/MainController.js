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
* DATE CREATE : 12/05/2015 19:01:07
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReportePlanillaPagoONP.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReportePlanillaPagoONP.MainStore'],

    models: ['ReportePlanillaPagoONP.MainModel'],

    views: ['ReportePlanillaPagoONP.Edit', 'ReportePlanillaPagoONP.List'],

    refs: [
    	{
            ref: 'ReportePlanillaPagoONPPanel',
            selector: 'panel'
        },
        {
            ref: 'ReportePlanillaPagoONPList',
            selector: 'ReportePlanillaPagoONPList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReportePlanillaPagoONP.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReportePlanillaPagoONPList dataview': {
//                itemdblclick: this.editRecord
            },
            'ReportePlanillaPagoONPList button[action=add]': {
            	click: this.editRecord
            },
            'ReportePlanillaPagoONPList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReportePlanillaPagoONPEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReportePlanillaPagoONPList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReportePlanillaPagoONPList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReportePlanillaPagoONPList combobox': {
                change: this.refreshGrid
            },
            'ReportePlanillaPagoONPList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReportePlanillaPagoONPList button[action=generarReportePDF]': {
                click: this.listarPlanillaPagoONP_PDF
            },
            'ReportePlanillaPagoONPList button[action=generarReporteXLS]': {
                click: this.listarPlanillaPagoONP_XLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReportePlanillaPagoONP.Edit').show();
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
        var store = Ext.getStore('ReportePlanillaPagoONP.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_nomina_anio_periodo_personal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReportePlanillaPagoONP.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReportePlanillaPagoONP_statusbar');
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
    	
    	var grid = this.getReportePlanillaPagoONPList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReportePlanillaPagoONP.MainStore');
    	
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
    listarPlanillaPagoONP_PDF: function(button){
        
    	var form = Ext.getCmp('form_filter_ReportePlanillaPagoONP');
    	
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var srl_id_fuente_financiamiento = form.getForm().findField('srl_id_fuente_financiamiento');
    	var int_anio = form.getForm().findField('int_anio');
    	var tipo_reporte = 'pdf';
    	console.log(srl_id_regimen_contractual.getValue() );
    	
        if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
            });
    		
    	}else{

    		
    		window.open('listar-planilla-pago-onp-pdf.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()
    				+ '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');  
    	}

    },
    listarPlanillaPagoONP_XLS: function(button){
        
    	var form = Ext.getCmp('form_filter_ReportePlanillaPagoONP');
    	
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
    		
    		window.open('listar-planilla-pago-onp-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()
				     + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank'); 
    		
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('ReportePlanillaPagoONP.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReportePlanillaPagoONP.MainStore');
        var form = Ext.getCmp('form_filter_ReportePlanillaPagoONP');
        form.reset();
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(1);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReportePlanillaPagoONP.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReportePlanillaPagoONP.MainStore');
        var form = Ext.getCmp('form_filter_ReportePlanillaPagoONP');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});