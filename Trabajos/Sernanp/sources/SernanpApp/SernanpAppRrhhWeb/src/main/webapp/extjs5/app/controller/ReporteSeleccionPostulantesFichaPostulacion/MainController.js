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
* DATE CREATE : 10/07/2015 13:32:32
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteSeleccionPostulantesFichaPostulacion.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteSeleccionPostulantesFichaPostulacion.MainStore'],

    models: ['ReporteSeleccionPostulantesFichaPostulacion.MainModel'],

    views: ['ReporteSeleccionPostulantesFichaPostulacion.Edit', 'ReporteSeleccionPostulantesFichaPostulacion.List'],

    refs: [
    	{
            ref: 'ReporteSeleccionPostulantesFichaPostulacionPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteSeleccionPostulantesFichaPostulacionList',
            selector: 'ReporteSeleccionPostulantesFichaPostulacionList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteSeleccionPostulantesFichaPostulacion.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteSeleccionPostulantesFichaPostulacionList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteSeleccionPostulantesFichaPostulacionList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteSeleccionPostulantesFichaPostulacionList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteSeleccionPostulantesFichaPostulacionEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteSeleccionPostulantesFichaPostulacionList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteSeleccionPostulantesFichaPostulacionList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteSeleccionPostulantesFichaPostulacionList combobox': {
                change: this.refreshGrid
            },
            'ReporteSeleccionPostulantesFichaPostulacionList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteSeleccionPostulantesFichaPostulacionList button[action=generarReportePDF]': {
                click: this.reporteSeleccionPostulantesFichaPostulacionPDF
            },
            'ReporteSeleccionPostulantesFichaPostulacionList button[action=generarReporteXLS]': {
                click: this.reporteSeleccionPostulantesFichaPostulacionXLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteSeleccionPostulantesFichaPostulacion.Edit').show();
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
        var store = Ext.getStore('ReporteSeleccionPostulantesFichaPostulacion.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteSeleccionPostulantesFichaPostulacion.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteSeleccionPostulantesFichaPostulacion_statusbar');
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
    	
    	var grid = this.getReporteSeleccionPostulantesFichaPostulacionList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteSeleccionPostulantesFichaPostulacion.MainStore');
    	
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
    
    reporteSeleccionPostulantesFichaPostulacionPDF: function (button){
    	
    	var form = Ext.getCmp('form_filter_ReporteSeleccionPostulantesFichaPostulacion');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var int_id_tipo_factor = form.getForm().findField('int_id_tipo_factor');
    	
    	var tipo_reporte = 'pdf';
    	
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
    	var srl_id_sede_req_sel 	= form.getForm().findField('srl_id_sede_req_sel');
//    	var srl_id_sede_uni_ope_anp	= form.getForm().findField('srl_id_sede_uni_ope_anp');
		/*END*/
    	window.open('postulantes-ficha-postulacion-pdf.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc=' + numerodoc.getValue()
    			+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&int_id_tipo_factor=' + int_id_tipo_factor.getValue() + '&tipo_reporte=' + tipo_reporte
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
//				+'&srl_id_sede_uni_ope_anp='+srl_id_sede_uni_ope_anp.getValue()
				,'_blank'); 
    	
    },
    
    reporteSeleccionPostulantesFichaPostulacionXLS: function (button){
    	
    	var form = Ext.getCmp('form_filter_ReporteSeleccionPostulantesFichaPostulacion');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var int_id_tipo_factor = form.getForm().findField('int_id_tipo_factor');
    	var tipo_reporte = 'xls';
    	
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
    	var srl_id_sede_req_sel 	= form.getForm().findField('srl_id_sede_req_sel');
//    	var srl_id_sede_uni_ope_anp	= form.getForm().findField('srl_id_sede_uni_ope_anp');
		/*END*/
    	
    	window.open('postulantes-ficha-postulacion-xls.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc=' + numerodoc.getValue()
    			+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&int_id_tipo_factor=' + int_id_tipo_factor.getValue() + '&tipo_reporte=' + tipo_reporte
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
//				+'&srl_id_sede_uni_ope_anp='+srl_id_sede_uni_ope_anp.getValue()
				,'_blank'); 
    	
    },
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteSeleccionPostulantesFichaPostulacion.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteSeleccionPostulantesFichaPostulacion.MainStore');
        var form = Ext.getCmp('form_filter_ReporteSeleccionPostulantesFichaPostulacion');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteSeleccionPostulantesFichaPostulacion.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteSeleccionPostulantesFichaPostulacion.MainStore');
        var form = Ext.getCmp('form_filter_ReporteSeleccionPostulantesFichaPostulacion');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});
