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
* DATE CREATE : 14/06/2015 01:52:58
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteNominaDescuento.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteNominaDescuento.MainStore'],

    models: ['ReporteNominaDescuento.MainModel'],

    views: ['ReporteNominaDescuento.Edit', 'ReporteNominaDescuento.List'],

    refs: [
    	{
            ref: 'ReporteNominaDescuentoPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteNominaDescuentoList',
            selector: 'ReporteNominaDescuentoList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteNominaDescuento.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteNominaDescuentoList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteNominaDescuentoList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteNominaDescuentoList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteNominaDescuentoEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteNominaDescuentoList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteNominaDescuentoList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteNominaDescuentoList combobox': {
                change: this.refreshGrid
            },
            'ReporteNominaDescuentoList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteNominaDescuentoList button[action=generarReportePDF]': {
                click: this.listarNominaDescuentoPDF
            },
            'ReporteNominaDescuentoList button[action=generarReporteXLS]': {
                click: this.listarNominaDescuentoXLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteNominaDescuento.Edit').show();
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
        var store = Ext.getStore('ReporteNominaDescuento.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteNominaDescuento.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteNominaDescuento_statusbar');
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
    	
    	var grid = this.getReporteNominaDescuentoList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteNominaDescuento.MainStore');
    	
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
    
    listarNominaDescuentoPDF: function(button){
        
    	var form = Ext.getCmp('form_filter_ReporteNominaDescuento');
    	
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var srl_id_regimen_pensionario = form.getForm().findField('srl_id_regimen_pensionario');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var int_anio = form.getForm().findField('int_anio');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var c_fte_fto = form.getForm().findField('c_fte_fto');
    	var tipo_reporte = 'pdf';
    	
    	console.log(c_fte_fto.getValue());
    	
        if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
            });
    		
    	}
        else if (c_fte_fto.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione una Fuente de Financiamiento');
            });
    		
    	}
        else{

    		
    		window.open('listar-nomina-descuento-pdf.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_pensionario='+ srl_id_regimen_pensionario.getValue()
    				+ '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&nombre_completo=' + nombre_completo.getValue()+ '&c_fte_fto='+ c_fte_fto.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');  
    	}

    },
    
    
    listarNominaDescuentoXLS: function(button){
        
    	var form = Ext.getCmp('form_filter_ReporteNominaDescuento');
    	
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var srl_id_regimen_pensionario = form.getForm().findField('srl_id_regimen_pensionario');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var int_anio = form.getForm().findField('int_anio');
    	var c_fte_fto = form.getForm().findField('c_fte_fto');

    	var tipo_reporte = 'xls';
    	
    	if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
        });
    		
    	}else{  
    		
    		window.open('listar-nomina-descuento-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_pensionario='+ srl_id_regimen_pensionario.getValue()
    				+ '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&nombre_completo=' + nombre_completo.getValue()+ '&c_fte_fto='+ c_fte_fto.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');  
    	}

    },
    
    
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteNominaDescuento.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteNominaDescuento.MainStore');
        var form = Ext.getCmp('form_filter_ReporteNominaDescuento');
        form.reset();
        
       
		var d = new Date();
		var n = d.getMonth() + 1;
		
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(n);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteNominaDescuento.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteNominaDescuento.MainStore');
        var form = Ext.getCmp('form_filter_ReporteNominaDescuento');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});