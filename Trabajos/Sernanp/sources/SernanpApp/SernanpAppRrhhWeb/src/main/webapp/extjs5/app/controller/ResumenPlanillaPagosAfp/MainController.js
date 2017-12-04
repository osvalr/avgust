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
* DATE CREATE : 30/05/2015 17:26:51
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ResumenPlanillaPagosAfp.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ResumenPlanillaPagosAfp.MainStore'],

    models: ['ResumenPlanillaPagosAfp.MainModel'],

    views: ['ResumenPlanillaPagosAfp.Edit', 'ResumenPlanillaPagosAfp.List'],

    refs: [
    	{
            ref: 'ResumenPlanillaPagosAfpPanel',
            selector: 'panel'
        },
        {
            ref: 'ResumenPlanillaPagosAfpList',
            selector: 'ResumenPlanillaPagosAfpList'
        }
    ],

    init: function() {
    
        Ext.getStore('ResumenPlanillaPagosAfp.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ResumenPlanillaPagosAfpList dataview': {
//                itemdblclick: this.editRecord
            },
            'ResumenPlanillaPagosAfpList button[action=add]': {
            	click: this.editRecord
            },
            'ResumenPlanillaPagosAfpList button[action=delete]': {
                click: this.deleteRecord
            },
            'ResumenPlanillaPagosAfpEdit button[action=save]': {
                click: this.updateRecord
            },
            'ResumenPlanillaPagosAfpList button[action=filter]': {
                click: this.refreshGrid
            },
            'ResumenPlanillaPagosAfpList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ResumenPlanillaPagosAfpList combobox': {
                change: this.refreshGrid
            },
            'ResumenPlanillaPagosAfpList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ResumenPlanillaPagosAfpList button[action=generarReportePDF]': {
                click: this.resumenNominaPagoRegimenPensionario
            },
            'ResumenPlanillaPagosAfpList button[action=generarReporteXLS]': {
                click: this.resumenNominaPagoRegimenPensionario_XLS
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ResumenPlanillaPagosAfp.Edit').show();
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
        var store = Ext.getStore('ResumenPlanillaPagosAfp.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ResumenPlanillaPagosAfp.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ResumenPlanillaPagosAfp_statusbar');
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
    	
    	var grid = this.getResumenPlanillaPagosAfpList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ResumenPlanillaPagosAfp.MainStore');
    	
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
    resumenNominaPagoRegimenPensionario: function(button){
    	
    	var form = Ext.getCmp('form_filter_ResumenPlanillaPagosAfp');
    	
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var srl_id_regimen_pensionario = form.getForm().findField('srl_id_regimen_pensionario');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var c_fte_fto = form.getForm().findField('c_fte_fto');
    	var int_anio = form.getForm().findField('int_anio');
    	var tipo_reporte = 'pdf';
    	
    	if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
            });
    		
    	}else if(srl_id_regimen_pensionario.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Pensionario');
            });
    		
    	}else{
    		
    		  if(srl_id_regimen_pensionario.getValue() == 1){  //25897
    			  
    			  Ext.onReady(function() {
    	                Ext.MessageBox.alert('Mensaje','Reporte Sin Datos');
    	            });
    		  }
    		  else if(srl_id_regimen_pensionario.getValue() == 2){ // 19990
    			  
    			  window.open('listar-planilla-pago-onp-pdf.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_pensionario=' + srl_id_regimen_pensionario.getValue()
    					  + '&c_fte_fto=' + c_fte_fto.getValue() + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');  
    		  }
    		  else if(srl_id_regimen_pensionario.getValue() == 3){ // 20530
    			  
    			  Ext.onReady(function() {
  	                Ext.MessageBox.alert('Mensaje','Reporte Sin Datos');
  	              });
    		  }
    		  else if(srl_id_regimen_pensionario.getValue() == 4){ // AFP
    			  
    			  window.open('listar-resumen-planilla-pago-afp-pdf.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_pensionario=' + srl_id_regimen_pensionario.getValue()
    	    				+ '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&c_fte_fto=' + c_fte_fto.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');  
    	    	
    		  }
    		  else if(srl_id_regimen_pensionario.getValue() == 5){ // NINGUNO
    			  
    			  window.open('listar-resumen-planilla-pago-afp-pdf.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_pensionario=' + srl_id_regimen_pensionario.getValue()
  	    				+ '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&c_fte_fto=' + c_fte_fto.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');  
  	    	
    		  }
    	}
    	
    },
    
    resumenNominaPagoRegimenPensionario_XLS: function(button){
    	
    	var form = Ext.getCmp('form_filter_ResumenPlanillaPagosAfp');
    	
    	var nombre_completo = form.getForm().findField('nombre_completo');
    	var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
    	var srl_id_regimen_pensionario = form.getForm().findField('srl_id_regimen_pensionario');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	var c_fte_fto = form.getForm().findField('c_fte_fto');
    	var int_anio = form.getForm().findField('int_anio');
    	var tipo_reporte = 'xls';
    	
    	if (srl_id_regimen_contractual.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Contractual');
            });
    		
    	}else if(srl_id_regimen_pensionario.getValue() == ''){
    		
    		Ext.onReady(function() {
                Ext.MessageBox.alert('Mensaje','Seleccione un Régimen Pensionario');
            });
    		
    	}else{
    		
    		  if(srl_id_regimen_pensionario.getValue() == 1){  //25897
    			  
    			  Ext.onReady(function() {
    	                Ext.MessageBox.alert('Mensaje','Reporte Sin Datos');
    	            });
    		  }
    		  else if(srl_id_regimen_pensionario.getValue() == 2){ // 19990
    			  
    			  window.open('listar-planilla-pago-onp-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()  + '&srl_id_regimen_pensionario=' + srl_id_regimen_pensionario.getValue()
    	    				+ '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&c_fte_fto=' + c_fte_fto.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');  
    		  }
    		  else if(srl_id_regimen_pensionario.getValue() == 3){ // 20530
    			  
    			  Ext.onReady(function() {
  	                Ext.MessageBox.alert('Mensaje','Reporte Sin Datos');
  	              });
    		  }
    		  else if(srl_id_regimen_pensionario.getValue() == 4){ // AFP
    			  
    			  window.open('listar-resumen-planilla-pago-afp-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_pensionario=' + srl_id_regimen_pensionario.getValue()
    					     + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&c_fte_fto=' + c_fte_fto.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank'); 
    	    	
    		  }
    		  else if(srl_id_regimen_pensionario.getValue() == 5){ // NINGUNO
    			  
    			  window.open('listar-resumen-planilla-pago-afp-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue() + '&srl_id_regimen_pensionario=' + srl_id_regimen_pensionario.getValue()
 					     + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&c_fte_fto=' + c_fte_fto.getValue() + '&nombre_completo=' + nombre_completo.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank'); 
 	    	
    		  }
    	}
    	
    },
    
        
   
    refreshGrid: function() {
    	var store = Ext.getStore('ResumenPlanillaPagosAfp.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ResumenPlanillaPagosAfp.MainStore');
        var form = Ext.getCmp('form_filter_ResumenPlanillaPagosAfp');
        form.reset();
        
        var d = new Date();
	    var n = d.getMonth() + 1;
		
        
        var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(n);
		
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ResumenPlanillaPagosAfp.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ResumenPlanillaPagosAfp.MainStore');
        var form = Ext.getCmp('form_filter_ResumenPlanillaPagosAfp');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});