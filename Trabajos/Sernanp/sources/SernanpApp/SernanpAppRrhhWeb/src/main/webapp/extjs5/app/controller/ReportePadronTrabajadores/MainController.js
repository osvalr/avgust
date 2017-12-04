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
* DATE CREATE : 03/06/2015 07:19:09
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReportePadronTrabajadores.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReportePadronTrabajadores.MainStore'],

    models: ['ReportePadronTrabajadores.MainModel'],

    views: ['ReportePadronTrabajadores.Edit', 'ReportePadronTrabajadores.List'],

    refs: [
    	{
            ref: 'ReportePadronTrabajadoresPanel',
            selector: 'panel'
        },
        {
            ref: 'ReportePadronTrabajadoresList',
            selector: 'ReportePadronTrabajadoresList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReportePadronTrabajadores.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReportePadronTrabajadoresList dataview': {
                itemdblclick: this.editRecord
            },
            'ReportePadronTrabajadoresList button[action=add]': {
            	click: this.editRecord
            },
            'ReportePadronTrabajadoresList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReportePadronTrabajadoresEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReportePadronTrabajadoresList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReportePadronTrabajadoresList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReportePadronTrabajadoresList combobox': {
                change: this.refreshGrid
            },
            'ReportePadronTrabajadoresList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReportePadronTrabajadoresList button[action=generarReporteXLS]': {
                click: this.PadronTrabajadoresXLS
            }
            
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReportePadronTrabajadores.Edit').show();
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
        var store = Ext.getStore('ReportePadronTrabajadores.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_nomina_anio_periodo_personal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReportePadronTrabajadores.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReportePadronTrabajadores_statusbar');
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
    	
    	var grid = this.getReportePadronTrabajadoresList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReportePadronTrabajadores.MainStore');
    	
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
    
    PadronTrabajadoresXLS: function(button){
        
    	var form = Ext.getCmp('form_filter_ReportePadronTrabajadores');
    	
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
//    	var srl_id_fuente_financiamiento = form.getForm().findField('srl_id_fuente_financiamiento');
    	var int_anio = form.getForm().findField('int_anio');
    	var tipo_reporte = 'xls';
    	
    	if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
        });
    		
    	}else{  
    		
    		window.open('listar-padron-trabajadores.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()
				     + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() +  '&tipo_reporte=' + tipo_reporte,'_blank'); 
    		
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('ReportePadronTrabajadores.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReportePadronTrabajadores.MainStore');
        var form = Ext.getCmp('form_filter_ReportePadronTrabajadores');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReportePadronTrabajadores.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReportePadronTrabajadores.MainStore');
        var form = Ext.getCmp('form_filter_ReportePadronTrabajadores');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});