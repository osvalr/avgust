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
* DATE CREATE : 07/04/2015 23:40:21
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarProcesoNominas.MainController', {
    extend: 'Ext.app.Controller',

    views: [	
            	'GestionarProcesoNominas.Edit',
            	'GestionarProcesoNominas.EditPersonal',
            	'GestionarProcesoNominas.EditDescuentosDa',
            	'GestionarProcesoNominas.EditGenerarPlame',
            	'GestionaNomina.List'
            ],
    
    init: function() {
        this.control({
            'GestionaNominaList button[action=show]': {
                click: this.showForm
            },'GestionaNominaList button[action=showNominaExtraordinaria]': {
                click: this.showFormNominaExtraordinaria
            },'GestionaNominaList button[action=showDescuentoDa]': {
                click: this.showFormDescuentoDa
            },'GestionaNominaList button[action=showGenerarPlame]': {
                click: this.showGenerarPlame
            },
            'GestionarProcesoNominasEdit button[action=procesar]': {
                click: this.procesar
            },
            'GestionarProcesoNominasEditNominaExtraordinaria button[action=procesarNominaExtraordinaria]': {
                click: this.procesarNominaExtraordinaria
            },
            'GestionarProcesoNominasEditDescuentosDa button[action=procesarDescuentoDa]': {
                click: this.procesarDescuentoDa
            },
            'GestionarProcesoNominasEditGenerarPlame button[action=generarPlame]': {
                click: this.generarPlame
            },
            //Invoco al alias donde se encuentra mi control (Boton, Textfield, Combobox, etc)
            'GestionaNominaList' : {
            	//Evento : function (action en mi alias)
            	click:	this.showGeneraReportePlanillaPreliminar
            	
            }
        });
    },
    
    showForm: function(button) {
    	Ext.create('MyApp.view.GestionarProcesoNominas.Edit').show();
    },
    showFormNominaExtraordinaria: function(button) {
    	Ext.create('MyApp.view.GestionarProcesoNominas.EditNominaExtraordinaria').show();
    },
    showFormDescuentoDa: function(button) {
    	Ext.create('MyApp.view.GestionarProcesoNominas.EditDescuentosDa').show();
    },
    
    showGenerarPlame: function(button) {
    	Ext.create('MyApp.view.GestionarProcesoNominas.EditGenerarPlame').show();
    },
    
   	showGeneraReportePlanillaPreliminar	:	function(button) {
   		//Crea un formulario
   		Ext.create('MyApp.view.GestionarProcesoNominas.EditGenerarReportePreliminar').show();
    },
    
    procesar: function(button) {
    	var win = button.up('window');
        var form = win.down('form');
        
        var srl_id_anio_periodo_planilla = form.getForm().findField('srl_id_anio_periodo_planilla');
        var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
        var idpersonal = form.getForm().findField('idpersonal');
        var int_id_estado = form.getForm().findField('int_id_estado');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
        
			        var sb = Ext.getCmp('form_crud_GestionarProcesoNominas_statusbar');
					sb.showBusy('Procesando...');
					win.getEl().mask();
			        
					Ext.Ajax.setTimeout(500000);
					
			        Ext.Ajax.request({
			            method: 'GET',
			            url: 'procesar-nomina.action',
			            
			            params: {	
			            			'srl_id_anio_periodo_planilla':srl_id_anio_periodo_planilla.getValue(),
			            			'srl_id_regimen_contractual': srl_id_regimen_contractual.getValue(),
			            			'idpersonal': idpersonal.getValue()//,
			            			//'int_id_estado': int_id_estado.getValue()
			            		},
			            		
			            success: function( result, request ){
			            	
			            	var json = Ext.JSON.decode(result.responseText);
			            	
			            	if(json.extjsReturn.success == true){
			            		var store = Ext.getStore('GestionaNomina.MainStore');
		                    	store.load();
				            	win.close();
			            	}else{
			            		
			            		sb.setStatus({text:''});
			            		win.getEl().unmask();
			            		
			            		Ext.MessageBox.show({
			                        title: 'REMOTE EXCEPTION',
			                        msg: json.extjsReturn.message,
			                        icon: Ext.MessageBox.ERROR,
			                        buttons: Ext.Msg.OK
			                    });
			            	}
			            	
			            	
			            },
	        	        failure: function (batch, eOpts) {
                            sb.setStatus({text:'Error intentado grabar.'});
				        	win.getEl().unmask();
	        	        }
			        });
        
	            }
	            
	        });
        }
    },
    procesarNominaExtraordinaria: function(button) {
    	var win = button.up('window');
        var form = win.down('form');
        
        var srl_id_anio_periodo_planilla = form.getForm().findField('srl_id_anio_periodo_planilla');
        var idpersonal = form.getForm().findField('idpersonal');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	                var sb = Ext.getCmp('form_proceso_nomina_extraordinaria_statusbar');
	        		sb.showBusy('Procesando...');
	        		win.getEl().mask();
	                
	                Ext.Ajax.request({
	                    method: 'GET',
	                    url: 'procesar-nomina-extraordinaria.action',
	                    params: {'srl_id_anio_periodo_planilla':srl_id_anio_periodo_planilla.getValue(),'idpersonal':idpersonal.getValue()},
	                    success: function( result, request ){
	                    	
	                    	var json = Ext.JSON.decode(result.responseText);
	                    	
	                    	if(json.extjsReturn.success == true){
			            		var store = Ext.getStore('GestionaNomina.MainStore');
		                    	store.load();
				            	win.close();
			            	}else{
			            		
			            		sb.setStatus({text:''});
			            		win.getEl().unmask();
			            		
			            		Ext.MessageBox.show({
			                        title: 'REMOTE EXCEPTION',
			                        msg: json.extjsReturn.message,
			                        icon: Ext.MessageBox.ERROR,
			                        buttons: Ext.Msg.OK
			                    });
			            	}
	                    },
	        	        failure: function (batch, eOpts) {
                            sb.setStatus({text:'Error intentado grabar.'});
				        	win.getEl().unmask();
	        	        }
	                });
	            }
	            
	        });
        }

    },
    procesarDescuentoDa: function(button) {
    	var win = button.up('window');
        var form = win.down('form');
        
        var srl_id_anio_periodo_planilla = form.getForm().findField('srl_id_anio_periodo_planilla');
        var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
        var idpersonal = form.getForm().findField('idpersonal');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	                var sb = Ext.getCmp('form_proceso_descuento_da_statusbar');
	        		sb.showBusy('Procesando...');
	        		win.getEl().mask();
	                
	        		Ext.Ajax.setTimeout(500000);
	        		
	                Ext.Ajax.request({
	                    method: 'GET',
	                    url: 'procesar-decuentos-deplazamiento-asistencia.action',
	                    params: {
	                    			'srl_id_anio_periodo_planilla':srl_id_anio_periodo_planilla.getValue(),
	                    			'srl_id_regimen_contractual': srl_id_regimen_contractual.getValue(),
			            			'idpersonal': idpersonal.getValue()
	                    		},
	                    success: function( result, request ){
	                    	
	                    	var json = Ext.JSON.decode(result.responseText);
	                    	
	                    	if(json.extjsReturn.success == true){
			            		var store = Ext.getStore('GestionaNomina.MainStore');
		                    	store.load();
				            	win.close();
			            	}else{
			            		
			            		sb.setStatus({text:''});
			            		win.getEl().unmask();
			            		
			            		Ext.MessageBox.show({
			                        title: 'REMOTE EXCEPTION',
			                        msg: json.extjsReturn.message,
			                        icon: Ext.MessageBox.ERROR,
			                        buttons: Ext.Msg.OK
			                    });
			            	}
	                    	
	                    },
	        	        failure: function (batch, eOpts) {
                            sb.setStatus({text:'Error intentado grabar.'});
				        	win.getEl().unmask();
	        	        }
	                });
	            }
	            
	        });
        }

    },
    generarPlame: function(button) {
    	var win = button.up('window');
        var form = win.down('form');
        
        var srl_id_anio_periodo_planilla = form.getForm().findField('srl_id_anio_periodo_planilla');
        var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
        var srl_id_fuente_financiamiento = form.getForm().findField('srl_id_fuente_financiamiento');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de generar el PLAME?',function (btn) {
	            
	            if (btn == 'yes') {
	                
	            	window.open('generar-plame?srl_id_anio_periodo_planilla='+srl_id_anio_periodo_planilla.getValue()+'&srl_id_regimen_contractual='+srl_id_regimen_contractual.getValue()+'&srl_id_fuente_financiamiento='+srl_id_fuente_financiamiento.getValue(), '_blank');
	            	
	            }
	            
	        });
        }

    }
});