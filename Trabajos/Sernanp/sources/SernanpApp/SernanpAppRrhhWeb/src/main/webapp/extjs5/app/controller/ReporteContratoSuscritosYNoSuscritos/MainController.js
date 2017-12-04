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
* DATE CREATE : 25/06/2015 14:27:10
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteContratoSuscritosYNoSuscritos.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteContratoSuscritosYNoSuscritos.MainStore'],

    models: ['ReporteContratoSuscritosYNoSuscritos.MainModel'],

    views: ['ReporteContratoSuscritosYNoSuscritos.Edit', 'ReporteContratoSuscritosYNoSuscritos.List'],

    refs: [
    	{
            ref: 'ReporteContratoSuscritosYNoSuscritosPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteContratoSuscritosYNoSuscritosList',
            selector: 'ReporteContratoSuscritosYNoSuscritosList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteContratoSuscritosYNoSuscritos.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteContratoSuscritosYNoSuscritosList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteContratoSuscritosYNoSuscritosList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteContratoSuscritosYNoSuscritosList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteContratoSuscritosYNoSuscritosEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteContratoSuscritosYNoSuscritosList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteContratoSuscritosYNoSuscritosList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteContratoSuscritosYNoSuscritosList combobox': {
                change: this.refreshGrid
            },
            'ReporteContratoSuscritosYNoSuscritosList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteContratoSuscritosYNoSuscritosList button[action=generarReporte]': {
                click: this.reporteContratosSuscritosNoSuscritos
            },
            'ReporteContratoSuscritosYNoSuscritosList button[action=generarReporteXLS]': {
                click: this.reporteContratosSuscritosNoSuscritosXLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteContratoSuscritosYNoSuscritos.Edit').show();
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
        var store = Ext.getStore('ReporteContratoSuscritosYNoSuscritos.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteContratoSuscritosYNoSuscritos.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteContratoSuscritosYNoSuscritos_statusbar');
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
    	
    	var grid = this.getReporteContratoSuscritosYNoSuscritosList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteContratoSuscritosYNoSuscritos.MainStore');
    	
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
    
    reporteContratosSuscritosNoSuscritos: function(button){
    	
    	var form = Ext.getCmp('form_filter_ReporteContratoSuscritosYNoSuscritos');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var int_id_estado = form.getForm().findField('int_id_estado');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var tipo_reporte = 'pdf';
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
    	var srl_id_sede_req_sel 	= form.getForm().findField('srl_id_sede_req_sel');
//    	var srl_id_sede_uni_ope_anp	= form.getForm().findField('srl_id_sede_uni_ope_anp');
		/*END*/
    	window.open('postulantes-contratos.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue() + '&int_id_estado='+ int_id_estado.getValue()
				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&tipo_reporte=' + tipo_reporte
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
//				+'&srl_id_sede_uni_ope_anp='+srl_id_sede_uni_ope_anp.getValue()
				,'_blank'); 
    },
    
    reporteContratosSuscritosNoSuscritosXLS: function(button){
    	
    	var form = Ext.getCmp('form_filter_ReporteContratoSuscritosYNoSuscritos');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var int_id_estado = form.getForm().findField('int_id_estado');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var tipo_reporte = 'xls';
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
    	var srl_id_sede_req_sel 	= form.getForm().findField('srl_id_sede_req_sel');
//    	var srl_id_sede_uni_ope_anp	= form.getForm().findField('srl_id_sede_uni_ope_anp');
		/*END*/
    	window.open('postulantes-contratos-xls.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue() + '&int_id_estado='+ int_id_estado.getValue()
				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&tipo_reporte=' + tipo_reporte
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
//				+'&srl_id_sede_uni_ope_anp='+srl_id_sede_uni_ope_anp.getValue()
				,'_blank'); 

    },
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteContratoSuscritosYNoSuscritos.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteContratoSuscritosYNoSuscritos.MainStore');
        var form = Ext.getCmp('form_filter_ReporteContratoSuscritosYNoSuscritos');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteContratoSuscritosYNoSuscritos.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteContratoSuscritosYNoSuscritos.MainStore');
        var form = Ext.getCmp('form_filter_ReporteContratoSuscritosYNoSuscritos');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});