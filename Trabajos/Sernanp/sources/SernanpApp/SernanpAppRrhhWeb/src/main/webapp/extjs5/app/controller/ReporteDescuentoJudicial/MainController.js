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
* DATE CREATE : 17/05/2015 16:50:57
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteDescuentoJudicial.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteDescuentoJudicial.MainStore'],

    models: ['ReporteDescuentoJudicial.MainModel'],

    views: ['ReporteDescuentoJudicial.Edit', 'ReporteDescuentoJudicial.List'],

    refs: [
    	{
            ref: 'ReporteDescuentoJudicialPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteDescuentoJudicialList',
            selector: 'ReporteDescuentoJudicialList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteDescuentoJudicial.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteDescuentoJudicialList dataview': {
//                itemdblclick: this.editRecord
            },
            'ReporteDescuentoJudicialList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteDescuentoJudicialList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteDescuentoJudicialEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteDescuentoJudicialList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteDescuentoJudicialList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteDescuentoJudicialList combobox': {
                change: this.refreshGrid
            },
            'ReporteDescuentoJudicialList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteDescuentoJudicialList button[action=generarReportePDF]': {
                click: this.listarDescuentoJudicialPDF
            },
            'ReporteDescuentoJudicialList button[action=generarReporteXLS]': {
                click: this.listarDescuentoJudicialXLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteDescuentoJudicial.Edit').show();
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
        var store = Ext.getStore('ReporteDescuentoJudicial.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteDescuentoJudicial.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteDescuentoJudicial_statusbar');
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
    	
    	var grid = this.getReporteDescuentoJudicialList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteDescuentoJudicial.MainStore');
    	
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
    listarDescuentoJudicialPDF: function(button){
        
    	var form = Ext.getCmp('form_filter_ReporteDescuentoJudicial');
    	
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var int_anio = form.getForm().findField('int_anio');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var tipo_reporte = 'pdf';
    	    	
        if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
            });
    		
    	}else{

    	    		
    		window.open('listar-descuento-judicial-pdf.action?srl_id_regimen_contractual=' + srl_id_regimen_contractual.getValue() + '&int_anio='+ int_anio.getValue()
    				+'&int_id_periodo_mes='+int_id_periodo_mes.getValue()+ '&nombre_completo='+ nombre_completo.getValue()+'&tipo_reporte=' + tipo_reporte,'_blank');  
    	}

    },
    listarDescuentoJudicialXLS: function(button){
        
    	var form = Ext.getCmp('form_filter_ReporteDescuentoJudicial');
    	
    	var int_anio = form.getForm().findField('int_anio');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var tipo_reporte = 'xls';
    	    	
        if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
            });
    		
    	}else{
  		
    		window.open('listar-descuento-judicial-xls.action?srl_id_regimen_contractual=' + srl_id_regimen_contractual.getValue() + '&int_anio='+ int_anio.getValue()
    				+'&int_id_periodo_mes='+int_id_periodo_mes.getValue()+ '&nombre_completo='+ nombre_completo.getValue()+'&tipo_reporte=' + tipo_reporte,'_blank');  
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteDescuentoJudicial.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteDescuentoJudicial.MainStore');
        var form = Ext.getCmp('form_filter_ReporteDescuentoJudicial');
        form.reset();
        
       		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteDescuentoJudicial.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteDescuentoJudicial.MainStore');
        var form = Ext.getCmp('form_filter_ReporteDescuentoJudicial');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});