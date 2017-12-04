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
* DATE CREATE : 26/05/2015 21:05:52
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.RptResumenPersonalAltasBajas.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['RptResumenPersonalAltasBajas.MainStore'],

    models: ['RptResumenPersonalAltasBajas.MainModel'],

    views: ['RptResumenPersonalAltasBajas.Edit', 'RptResumenPersonalAltasBajas.List'],

    refs: [
    	{
            ref: 'RptResumenPersonalAltasBajasPanel',
            selector: 'panel'
        },
        {
            ref: 'RptResumenPersonalAltasBajasList',
            selector: 'RptResumenPersonalAltasBajasList'
        }
    ],

    init: function() {
    
        Ext.getStore('RptResumenPersonalAltasBajas.MainStore').addListener('beforeload',this.setExtraParams,this);
        
    
        this.control({
            'RptResumenPersonalAltasBajasList dataview': {
//                itemdblclick: this.editRecord
            },
            'RptResumenPersonalAltasBajasList button[action=add]': {
            	click: this.editRecord
            },
            'RptResumenPersonalAltasBajasList button[action=delete]': {
                click: this.deleteRecord
            },
            'RptResumenPersonalAltasBajasEdit button[action=save]': {
                click: this.updateRecord
            },
            'RptResumenPersonalAltasBajasList button[action=filter]': {
                click: this.refreshGrid
            },
            'RptResumenPersonalAltasBajasList button[action=clearFilter]': {
                click: this.resetForm
            },
            'RptResumenPersonalAltasBajasList combobox': {
                change: this.refreshGrid
            },
            'RptResumenPersonalAltasBajasList textfield': {
            	specialkey: this.onKeyEnter
            },
            'RptResumenPersonalAltasBajasList button[action=generarReportePDF]': {
                click: this.listarAltasBajasPersonalPDF
            },
            'RptResumenPersonalAltasBajasList button[action=generarReporteXLS]': {
                click: this.listarAltasBajasPersonalXLS
                
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.RptResumenPersonalAltasBajas.Edit').show();
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
        var store = Ext.getStore('RptResumenPersonalAltasBajas.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonanatural > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.RptResumenPersonalAltasBajas.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_RptResumenPersonalAltasBajas_statusbar');
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
    	
    	var grid = this.getRptResumenPersonalAltasBajasList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('RptResumenPersonalAltasBajas.MainStore');
    	
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
    listarAltasBajasPersonalPDF: function(button){
        
    	var form = Ext.getCmp('form_filter_RptResumenPersonalAltasBajas');
    	
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var ruc = form.getForm().findField('ruc');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var int_estado = form.getForm().findField('int_estado');
    	var tipo_reporte = 'pdf';
    	
    	window.open('listar-altas-bajas-personal.action?srl_id_regimen_contractual=' + srl_id_regimen_contractual.getValue() + '&ruc='+ ruc.getValue()
    				+ '&numerodoc=' + numerodoc.getValue() + '&nombre_completo=' + nombre_completo.getValue()  + '&int_estado=' + int_estado.getValue()
    				+ '&tipo_reporte=' + tipo_reporte,'_blank'); 
    	

    },
    
    listarAltasBajasPersonalXLS: function(button){
        
    	var form = Ext.getCmp('form_filter_RptResumenPersonalAltasBajas');
    	
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var ruc = form.getForm().findField('ruc');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var int_estado = form.getForm().findField('int_estado');
    	var tipo_reporte = 'xls';
    	   		
    	window.open('listar-altas-bajas-personal.action?srl_id_regimen_contractual=' + srl_id_regimen_contractual.getValue() + '&ruc='+ ruc.getValue()
 				+ '&numerodoc=' + numerodoc.getValue() + '&nombre_completo=' + nombre_completo.getValue()  + '&int_estado=' + int_estado.getValue()
 				+ '&tipo_reporte=' + tipo_reporte,'_blank');  
    	

    },
    
    refreshGrid: function() {
    	var store = Ext.getStore('RptResumenPersonalAltasBajas.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('RptResumenPersonalAltasBajas.MainStore');
        var form = Ext.getCmp('form_filter_RptResumenPersonalAltasBajas');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('RptResumenPersonalAltasBajas.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('RptResumenPersonalAltasBajas.MainStore');
        var form = Ext.getCmp('form_filter_RptResumenPersonalAltasBajas');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});