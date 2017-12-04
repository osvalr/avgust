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
* DATE CREATE : 15/06/2015 18:26:46
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteBanco.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteBanco.MainStore'],

    models: ['ReporteBanco.MainModel'],

    views: ['ReporteBanco.Edit', 'ReporteBanco.List'],

    refs: [
    	{
            ref: 'ReporteBancoPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteBancoList',
            selector: 'ReporteBancoList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteBanco.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteBancoList dataview': {
//                itemdblclick: this.editRecord
            },
            'ReporteBancoList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteBancoList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteBancoEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteBancoList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteBancoList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteBancoList combobox': {
                change: this.refreshGrid
            },
            'ReporteBancoList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteBancoEditGenerarAbonoBanco button[action=generarAbonoBanco]': {
                click: this.generarAbonoBanco
            },
            'ReporteBancoList button[action=showReporteAbonoBanco]': {
                click: this.showReporteAbonoBanco
            }
            
        });
    },
    showReporteAbonoBanco: function(button) {
    	Ext.create('MyApp.view.ReporteBanco.EditGenerarAbonoBanco').show();
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteBanco.Edit').show();
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
        var store = Ext.getStore('ReporteBanco.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteBanco.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteBanco_statusbar');
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
    
    generarAbonoBanco: function(button){
    	
    	var form_principal = Ext.getCmp('form_filter_ReporteBanco');
    	var int_anio = form_principal.getForm().findField('int_anio');
    	var int_id_periodo_mes = form_principal.getForm().findField('int_id_periodo_mes');
    	
    	var win = button.up('window');
        var form = win.down('form');
        
        var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
        var c_fte_fto = form.getForm().findField('c_fte_fto');
    	var c_meta = form.getForm().findField('c_meta');
    	
    	 var rbFormato = form.getForm().getValues()['rbFormato'];
    	 
          	
        if (form.isValid()) {
        	
        	 if (rbFormato == 1){
                 
        		 var tipo_reporte = 'pdf';
        		 
        		 window.open('listar-reporte-banco.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_contractual=' + srl_id_regimen_contractual.getValue() 
    				+ '&c_fte_fto=' + c_fte_fto.getValue()+ '&c_meta=' + c_meta.getValue().trim() + '&tipo_reporte=' + tipo_reporte,'_blank');
        		 
        	 }else if (rbFormato == 2){
        		 
        		 var tipo_reporte = 'xls';
        		 
        		 window.open('listar-reporte-banco-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_contractual=' + srl_id_regimen_contractual.getValue() 
    				+ '&c_fte_fto=' + c_fte_fto.getValue()+ '&c_meta=' + c_meta.getValue().trim() + '&tipo_reporte=' + tipo_reporte,'_blank');
        	 }
        }
    	
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getReporteBancoList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteBanco.MainStore');
    	
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
    	var store = Ext.getStore('ReporteBanco.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteBanco.MainStore');
        var form = Ext.getCmp('form_filter_ReporteBanco');
        form.reset();
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(6);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteBanco.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteBanco.MainStore');
        var form = Ext.getCmp('form_filter_ReporteBanco');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});