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
* DATE CREATE : 13/07/2015 13:44:48
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteSeleccionPostulantesEvaluacionEscrita.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteSeleccionPostulantesEvaluacionEscrita.MainStore'],

    models: ['ReporteSeleccionPostulantesEvaluacionEscrita.MainModel'],

    views: ['ReporteSeleccionPostulantesEvaluacionEscrita.Edit', 'ReporteSeleccionPostulantesEvaluacionEscrita.List'],

    refs: [
    	{
            ref: 'ReporteSeleccionPostulantesEvaluacionEscritaPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteSeleccionPostulantesEvaluacionEscritaList',
            selector: 'ReporteSeleccionPostulantesEvaluacionEscritaList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteSeleccionPostulantesEvaluacionEscrita.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteSeleccionPostulantesEvaluacionEscritaList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteSeleccionPostulantesEvaluacionEscritaList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteSeleccionPostulantesEvaluacionEscritaList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteSeleccionPostulantesEvaluacionEscritaEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteSeleccionPostulantesEvaluacionEscritaList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteSeleccionPostulantesEvaluacionEscritaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteSeleccionPostulantesEvaluacionEscritaList combobox': {
                change: this.refreshGrid
            },
            'ReporteSeleccionPostulantesEvaluacionEscritaList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteSeleccionPostulantesEvaluacionEscritaList button[action=generarReporte]': {
                click: this.reportePostulantesEvaluacionEscrita
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteSeleccionPostulantesEvaluacionEscrita.Edit').show();
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
        var store = Ext.getStore('ReporteSeleccionPostulantesEvaluacionEscrita.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteSeleccionPostulantesEvaluacionEscrita.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteSeleccionPostulantesEvaluacionEscrita_statusbar');
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
    	
    	var grid = this.getReporteSeleccionPostulantesEvaluacionEscritaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteSeleccionPostulantesEvaluacionEscrita.MainStore');
    	
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
    
    reportePostulantesEvaluacionEscrita: function(button){
    	
    	var form = Ext.getCmp('form_filter_ReporteSeleccionPostulantesEvaluacionEscrita');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var tipo_reporte = 'pdf';
    	
    	window.open('postulantes-evaluacion-escrita.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc=' + numerodoc.getValue()
    			+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank'); 
  
    	
    }, 
    
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteSeleccionPostulantesEvaluacionEscrita.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteSeleccionPostulantesEvaluacionEscrita.MainStore');
        var form = Ext.getCmp('form_filter_ReporteSeleccionPostulantesEvaluacionEscrita');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteSeleccionPostulantesEvaluacionEscrita.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteSeleccionPostulantesEvaluacionEscrita.MainStore');
        var form = Ext.getCmp('form_filter_ReporteSeleccionPostulantesEvaluacionEscrita');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});