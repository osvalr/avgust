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
* DATE CREATE : 18/05/2015 01:24:16
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteBoletaPersonal.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteBoletaPersonal.MainStore'],

    models: ['ReporteBoletaPersonal.MainModel'],

    views: ['ReporteBoletaPersonal.Edit', 'ReporteBoletaPersonal.List'],

    refs: [
    	{
            ref: 'ReporteBoletaPersonalPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteBoletaPersonalList',
            selector: 'ReporteBoletaPersonalList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteBoletaPersonal.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteBoletaPersonalList dataview': {
//                itemdblclick: this.editRecord
            },
            'ReporteBoletaPersonalList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteBoletaPersonalList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteBoletaPersonalEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteBoletaPersonalList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteBoletaPersonalList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteBoletaPersonalList combobox': {
                change: this.refreshGrid
            },
            'ReporteBoletaPersonalList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteBoletaPersonalList button[action=generarReporte]': {
                click: this.reporteBoletaPago
            }
           
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteBoletaPersonal.Edit').show();
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
        var store = Ext.getStore('ReporteBoletaPersonal.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_nomina_anio_periodo_personal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteBoletaPersonal.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteBoletaPersonal_statusbar');
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
    	
    	var grid = this.getReporteBoletaPersonalList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteBoletaPersonal.MainStore');
    	
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
    
    
    reporteBoletaPago: function(button){
    	
        var form = Ext.getCmp('form_filter_ReporteBoletaPersonal');
        var nombre_completo = form.getForm().findField('nombre_completo');
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var int_anio = form.getForm().findField('int_anio');
    	var tipo_reporte = 'pdf';
    	
        if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
            });
    		
    	}else{
    		
    		window.open('reporte-boleta-pago.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()  + '&nombre_completo=' + nombre_completo.getValue() 
    				+ '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');
    		
    	}	
    	
    },
    
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteBoletaPersonal.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteBoletaPersonal.MainStore');
        var form = Ext.getCmp('form_filter_ReporteBoletaPersonal');
        form.reset();
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(1);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteBoletaPersonal.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteBoletaPersonal.MainStore');
        var form = Ext.getCmp('form_filter_ReporteBoletaPersonal');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});