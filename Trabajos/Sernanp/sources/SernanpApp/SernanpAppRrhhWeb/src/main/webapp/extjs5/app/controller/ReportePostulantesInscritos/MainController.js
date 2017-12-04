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
* DATE CREATE : 08/06/2015 18:38:03
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReportePostulantesInscritos.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReportePostulantesInscritos.MainStore'],

    models: ['ReportePostulantesInscritos.MainModel'],

    views: ['ReportePostulantesInscritos.Edit', 'ReportePostulantesInscritos.List'],

    refs: [
    	{
            ref: 'ReportePostulantesInscritosPanel',
            selector: 'panel'
        },
        {
            ref: 'ReportePostulantesInscritosList',
            selector: 'ReportePostulantesInscritosList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReportePostulantesInscritos.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReportePostulantesInscritosList dataview': {
                itemdblclick: this.editRecord
            },
            'ReportePostulantesInscritosList button[action=add]': {
            	click: this.editRecord
            },
            'ReportePostulantesInscritosList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReportePostulantesInscritosEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReportePostulantesInscritosList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReportePostulantesInscritosList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReportePostulantesInscritosList combobox': {
                change: this.refreshGrid
            },
            'ReportePostulantesInscritosList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReportePostulantesInscritosList button[action=generarReportePDF]': {
                click: this.reportePostulantesInscritosPDF
            },
            'ReportePostulantesInscritosList button[action=generarReporteXLS]': {
                click: this.reportePostulantesInscritosXLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReportePostulantesInscritos.Edit').show();
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
        var store = Ext.getStore('ReportePostulantesInscritos.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReportePostulantesInscritos.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReportePostulantesInscritos_statusbar');
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
    	
    	var grid = this.getReportePostulantesInscritosList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReportePostulantesInscritos.MainStore');
    	
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
    
    
    reportePostulantesInscritosPDF: function(button){
    	
    	var form = Ext.getCmp('form_filter_ReportePostulantesInscritos');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var tipo_reporte = 'pdf';
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
    	var srl_id_sede_req_sel 	= form.getForm().findField('srl_id_sede_req_sel');
//    	var srl_id_sede_uni_ope_anp	= form.getForm().findField('srl_id_sede_uni_ope_anp');
		/*END*/
    	
    	window.open('postulantes-inscritos-pdf.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue()
				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&tipo_reporte=' + tipo_reporte
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
//				+'&srl_id_sede_uni_ope_anp='+srl_id_sede_uni_ope_anp.getValue()
				,'_blank'); 

    },
    
    reportePostulantesInscritosXLS: function(button){
    	
    	var form = Ext.getCmp('form_filter_ReportePostulantesInscritos');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var tipo_reporte = 'xls';
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
    	var srl_id_sede_req_sel 	= form.getForm().findField('srl_id_sede_req_sel');
//    	var srl_id_sede_uni_ope_anp	= form.getForm().findField('srl_id_sede_uni_ope_anp');
		/*END*/
    	
    	window.open('postulantes-inscritos-xls.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue()
				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&tipo_reporte=' + tipo_reporte
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
//				+'&srl_id_sede_uni_ope_anp='+srl_id_sede_uni_ope_anp.getValue()
				,'_blank'); 

    },
    
    refreshGrid: function() {
    	var store = Ext.getStore('ReportePostulantesInscritos.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReportePostulantesInscritos.MainStore');
        var form = Ext.getCmp('form_filter_ReportePostulantesInscritos');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReportePostulantesInscritos.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReportePostulantesInscritos.MainStore');
        var form = Ext.getCmp('form_filter_ReportePostulantesInscritos');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});