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
* DATE CREATE : 02/06/2015 16:08:44
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteCertificadoCuartaCategoria.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteCertificadoCuartaCategoria.MainStore'],

    models: ['ReporteCertificadoCuartaCategoria.MainModel'],

    views: ['ReporteCertificadoCuartaCategoria.Edit', 'ReporteCertificadoCuartaCategoria.List'],

    refs: [
    	{
            ref: 'ReporteCertificadoCuartaCategoriaPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteCertificadoCuartaCategoriaList',
            selector: 'ReporteCertificadoCuartaCategoriaList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteCertificadoCuartaCategoria.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteCertificadoCuartaCategoriaList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteCertificadoCuartaCategoriaList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteCertificadoCuartaCategoriaList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteCertificadoCuartaCategoriaEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteCertificadoCuartaCategoriaList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteCertificadoCuartaCategoriaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteCertificadoCuartaCategoriaList combobox': {
                change: this.refreshGrid
            },
            'ReporteCertificadoCuartaCategoriaList textfield': {
            	specialkey: this.onKeyEnter
            } ,

            'ReporteCertificadoCuartaCategoriaList button[action=generarReportePDF]': {
                click: this.reporteCertificadoCuartaCategoriaPDF
            },
            
            'ReporteCertificadoCuartaCategoriaList button[action=generarReporteIndividual]': {
                click: this.reporteCertificadoCuartaCategoriaIndividual
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteCertificadoCuartaCategoria.Edit').show();
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
        var store = Ext.getStore('ReporteCertificadoCuartaCategoria.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteCertificadoCuartaCategoria.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteCertificadoCuartaCategoria_statusbar');
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
    	
    	var grid = this.getReporteCertificadoCuartaCategoriaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteCertificadoCuartaCategoria.MainStore');
    	
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
    
    
reporteCertificadoCuartaCategoriaPDF: function(button){
    	
    	var form = Ext.getCmp('form_filter_ReporteCertificadoCuartaCategoria');   	
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var int_anio = form.getForm().findField('int_anio');
    	var srl_id_cargo = form.getForm().findField('srl_id_cargo');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var tipo_reporte = 'pdf';
    	    	 	
    	window.open('listar-certificado-cuarta-categoria.action?nombre_completo=' + nombre_completo.getValue() + '&int_anio='+ int_anio.getValue()
    				+ '&srl_id_cargo=' + srl_id_cargo.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()+  '&tipo_reporte=' + tipo_reporte,'_blank'); 
    },
    
   
  reporteCertificadoCuartaCategoriaIndividual: function(button){
	
	  	var grid = this.getReporteCertificadoCuartaCategoriaList();
		var record = grid.getSelectionModel().getSelection(); 
		
						
		if(record.length > 0){			
			var int_anio = record[0].data.int_anio;
			var idpersonal = record[0].data.idpersonal;
			var tipo_reporte = 'pdf';		    	 	
			window.open('certificado-cuarta-categoria-individual.action?&int_anio='+ int_anio + '&idpersonal=' + idpersonal +'&tipo_reporte=' + tipo_reporte,'_blank'); 
		}			

},
    
    
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteCertificadoCuartaCategoria.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteCertificadoCuartaCategoria.MainStore');
        var form = Ext.getCmp('form_filter_ReporteCertificadoCuartaCategoria');
        form.reset();
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(6);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteCertificadoCuartaCategoria.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteCertificadoCuartaCategoria.MainStore');
        var form = Ext.getCmp('form_filter_ReporteCertificadoCuartaCategoria');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});