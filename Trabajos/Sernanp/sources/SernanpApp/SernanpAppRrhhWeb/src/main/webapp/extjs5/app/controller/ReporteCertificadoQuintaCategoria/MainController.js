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
* DATE CREATE : 02/06/2015 23:42:36
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteCertificadoQuintaCategoria.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteCertificadoQuintaCategoria.MainStore'],

    models: ['ReporteCertificadoQuintaCategoria.MainModel'],

    views: ['ReporteCertificadoQuintaCategoria.Edit', 'ReporteCertificadoQuintaCategoria.List'],

    refs: [
    	{
            ref: 'ReporteCertificadoQuintaCategoriaPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteCertificadoQuintaCategoriaList',
            selector: 'ReporteCertificadoQuintaCategoriaList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteCertificadoQuintaCategoria.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteCertificadoQuintaCategoriaList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteCertificadoQuintaCategoriaList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteCertificadoQuintaCategoriaList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteCertificadoQuintaCategoriaEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteCertificadoQuintaCategoriaList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteCertificadoQuintaCategoriaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteCertificadoQuintaCategoriaList combobox': {
                change: this.refreshGrid
            },
            'ReporteCertificadoQuintaCategoriaList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteCertificadoQuintaCategoriaList button[action=generarReportePDF]': {
                click: this.reporteCertificadoQuintaCategoriaPDF
            },
            'ReporteCertificadoQuintaCategoriaList button[action=generarReporteIndividual]': {
                click: this.reporteCertificadoQuintaCategoriaIndividual
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteCertificadoQuintaCategoria.Edit').show();
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
        var store = Ext.getStore('ReporteCertificadoQuintaCategoria.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteCertificadoQuintaCategoria.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteCertificadoQuintaCategoria_statusbar');
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
    	
    	var grid = this.getReporteCertificadoQuintaCategoriaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteCertificadoQuintaCategoria.MainStore');
    	
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
    
    reporteCertificadoQuintaCategoriaPDF: function(button){
    	
    	var form = Ext.getCmp('form_filter_ReporteCertificadoQuintaCategoria');   	
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var int_anio = form.getForm().findField('int_anio');
    	var srl_id_cargo = form.getForm().findField('srl_id_cargo');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var tipo_reporte = 'pdf';
    	

    	
    	window.open('listar-certificado-quinta-categoria.action?nombre_completo=' + nombre_completo.getValue() + '&int_anio='+ int_anio.getValue()
    				+ '&srl_id_cargo=' + srl_id_cargo.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()+ '&tipo_reporte=' + tipo_reporte,'_blank'); 
    },
    
    reporteCertificadoQuintaCategoriaIndividual: function(button){
    	
	  	var grid = this.getReporteCertificadoQuintaCategoriaList();
		var record = grid.getSelectionModel().getSelection(); 
		var store = Ext.getStore('ReporteCertificadoQuintaCategoria.MainStore');
						
		if(record.length > 0){			
			var int_anio = record[0].data.int_anio;
			var idpersonal = record[0].data.idpersonal	   ;
			var tipo_reporte = 'pdf';		    	 	
			window.open('certificado-quinta-categoria-individual.action?&int_anio='+ record[0].data.int_anio + '&idpersonal=' + record[0].data.idpersonal  + '&tipo_reporte=' + tipo_reporte,'_blank'); 
		}
    	
    },
    
    
    
    
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteCertificadoQuintaCategoria.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteCertificadoQuintaCategoria.MainStore');
        var form = Ext.getCmp('form_filter_ReporteCertificadoQuintaCategoria');
        form.reset();
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(6);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteCertificadoQuintaCategoria.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteCertificadoQuintaCategoria.MainStore');
        var form = Ext.getCmp('form_filter_ReporteCertificadoQuintaCategoria');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});