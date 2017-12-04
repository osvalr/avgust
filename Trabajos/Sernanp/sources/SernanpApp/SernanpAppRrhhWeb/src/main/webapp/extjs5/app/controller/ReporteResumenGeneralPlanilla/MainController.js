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
* DATE CREATE : 31/05/2015 16:59:27
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteResumenGeneralPlanilla.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteResumenGeneralPlanilla.MainStore'],

    models: ['ReporteResumenGeneralPlanilla.MainModel'],

    views: ['ReporteResumenGeneralPlanilla.Edit', 'ReporteResumenGeneralPlanilla.List'],

    refs: [
    	{
            ref: 'ReporteResumenGeneralPlanillaPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteResumenGeneralPlanillaList',
            selector: 'ReporteResumenGeneralPlanillaList'
        }
    ],

    init: function() {
    
        Ext.getStore('ReporteResumenGeneralPlanilla.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'ReporteResumenGeneralPlanillaList dataview': {
//                itemdblclick: this.editRecord
            },
            'ReporteResumenGeneralPlanillaList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteResumenGeneralPlanillaList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteResumenGeneralPlanillaEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteResumenGeneralPlanillaList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteResumenGeneralPlanillaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteResumenGeneralPlanillaList combobox': {
                change: this.refreshGrid
            },
            'ReporteResumenGeneralPlanillaList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ReporteResumenGeneralPlanillaList button[action=showGenerarNominaPago]': {
                click: this.showGenerarNominaPago
            },
            'ReporteResumenGeneralPlanillaEditGenerarNominaPago button[action=generarNominaPago]': {
                click: this.generarNominaPago
            },
            
            'ReporteResumenGeneralPlanillaList button[action=showNominaPagosRegimenXLS]': {
                click: this.showNominaPagosRegimenXLS
            },
            'ReporteResumenGeneralPlanillaList button[action=showNominaPagosFF_XLS]': {
                click: this.showNominaPagosFF_XLS
            },
            'ReporteResumenGeneralPlanillaList button[action=listarResumenNominaPagoFFMP728]': {
                click: this.listarResumenNominaPagoFFMP728
            },
            'ReporteResumenGeneralPlanillaList button[action=showGenerarJOR]': {
                click: this.showGenerarJOR
            },
            'ReporteResumenGeneralPlanillaList button[action=showGenerarREM]': {
                click: this.showGenerarREM
            },
            'ReporteResumenGeneralPlanillaEditGenerarJOR button[action=generarJOR]': {
                click: this.generarJOR
            },
            'ReporteResumenGeneralPlanillaEditGenerarREM button[action=generarREM]': {
                click: this.generarREM
            },
            'ReporteResumenGeneralPlanillaList button[action=generarProyeccion]': {
                click: this.listarProyeccionPlanillaFFMP_XLS
            }
            
        });
    },
    
    showGenerarNominaPago: function(button) {
    	Ext.create('MyApp.view.ReporteResumenGeneralPlanilla.EditGenerarNominaPago').show();
    },
    
    showGenerarJOR: function(button) {
    	Ext.create('MyApp.view.ReporteResumenGeneralPlanilla.EditGenerarJOR').show();
    },
    
    showGenerarREM: function(button) {
    	Ext.create('MyApp.view.ReporteResumenGeneralPlanilla.EditGenerarREM').show();
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteResumenGeneralPlanilla.Edit').show();
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
        var store = Ext.getStore('ReporteResumenGeneralPlanilla.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteResumenGeneralPlanilla.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_ReporteResumenGeneralPlanilla_statusbar');
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
    	
    	var grid = this.getReporteResumenGeneralPlanillaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteResumenGeneralPlanilla.MainStore');
    	
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
    
    
    generarNominaPago: function(button){
    	
    	var form_principal = Ext.getCmp('form_filter_ReporteResumenGeneralPlanilla');
//    	var int_anio = form_principal.getForm().findField('int_anio');
//    	var int_id_periodo_mes = form_principal.getForm().findField('int_id_periodo_mes');
    	
    	var win = button.up('window');
        var form = win.down('form');
        
        var int_anio = form.getForm().findField('int_anio');
    	var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
    	
        var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
        var c_fte_fto = form.getForm().findField('c_fte_fto');
    	var c_meta = form.getForm().findField('c_meta');
        
        var rbNomina = form.getForm().getValues()['rbNomina'];
        
        if (form.isValid()) {
        	
        
	        if (rbNomina == 1){
	        	
	        	var tipo_reporte = 'xls';
	
	        	window.open('listar-resumen-general-planilla-FF-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()  + '&c_fte_fto=' + c_fte_fto.getValue()
					     + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');
	        	
	        }
	        
	        else if (rbNomina == 2){
	        	
	        	var tipo_reporte = 'xls';
	        	c_fte_fto.setValue('');
	        	
	        	if(srl_id_regimen_contractual.getValue() == ''){
	        		
	        		Ext.Msg.alert('Mensaje','Seleccione un regimen Contractual');
	        	}else{
	        	        	
	        	window.open('listar-resumen-nomina-pago-regimen.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes=' + int_id_periodo_mes.getValue() + '&c_fte_fto=' + c_fte_fto.getValue()
			 			+ '&srl_id_regimen_contractual=' + srl_id_regimen_contractual.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank'); 
	        	}
	        }
	        
	        else if (rbNomina == 3){
	        	
	        	var tipo_reporte = 'pdf';
	        	
	        	if(srl_id_regimen_contractual.getValue() == 1){
	        	
	        		window.open('listar-resumen-general-planilla-FF-MP-728-pdf.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()  + '&c_fte_fto=' + c_fte_fto.getValue()
						     +  '&c_meta=' + c_meta.getValue().trim() + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');
		        	
	        	}else if(srl_id_regimen_contractual.getValue() == 3){
	        		
	        		window.open('listar-resumen-general-planilla-FF-MP-CAS-pdf.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()  + '&c_fte_fto=' + c_fte_fto.getValue()
						     +  '&c_meta=' + c_meta.getValue().trim() + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank');
		        	
	        	}
	        	        	
	        	
	        }
	        else if (rbNomina == 4){
	        	
	        	var tipo_reporte = 'xls';
	        	//c_fte_fto.setValue('');
	        	
	        	if(srl_id_regimen_contractual.getValue() == ''){
	        		
	        		Ext.Msg.alert('Mensaje','Seleccione un regimen Contractual');
	        	}else{
	        	        	
	        	window.open('listar-proyeccion-planilla-FF-MP-xls.action?int_anio=' + int_anio.getValue() + '&int_id_periodo_mes='+ int_id_periodo_mes.getValue()  + '&c_fte_fto=' + c_fte_fto.getValue()
	    				+ '&c_meta=' + c_meta.getValue() + '&srl_id_regimen_contractual='+ srl_id_regimen_contractual.getValue() + '&tipo_reporte=' + tipo_reporte,'_blank'); 
	        	
	        	}
	        }
        
        }
		
    	
    },
    
    generarJOR: function(button) {
    	var win = button.up('window');
        var form = win.down('form');
        
        var srl_id_anio_periodo_planilla = form.getForm().findField('srl_id_anio_periodo_planilla');
        var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de generar el JOR?',function (btn) {
	            
	            if (btn == 'yes') {
	                
	            	window.open('generar-jor?srl_id_anio_periodo_planilla='+srl_id_anio_periodo_planilla.getValue()+'&srl_id_regimen_contractual='+srl_id_regimen_contractual.getValue(), '_blank');
	            	
	            }
	            
	        });
        }

    }, 
    
    generarREM: function(button) {
    	var win = button.up('window');
        var form = win.down('form');
        
        var srl_id_anio_periodo_planilla = form.getForm().findField('srl_id_anio_periodo_planilla');
        var srl_id_regimen_contractual = form.getForm().findField('srl_id_regimen_contractual');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de generar el REM?',function (btn) {
	            
	            if (btn == 'yes') {
	                
	            	window.open('generar-rem?srl_id_anio_periodo_planilla='+srl_id_anio_periodo_planilla.getValue() + '&srl_id_regimen_contractual=' + srl_id_regimen_contractual.getValue() , '_blank');
	            	
	            }
	            
	        });
        }

    }, 
    
    
    refreshGrid: function() {
    	var store = Ext.getStore('ReporteResumenGeneralPlanilla.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ReporteResumenGeneralPlanilla.MainStore');
        var form = Ext.getCmp('form_filter_ReporteResumenGeneralPlanilla');
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
        	var store = Ext.getStore('ReporteResumenGeneralPlanilla.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ReporteResumenGeneralPlanilla.MainStore');
        var form = Ext.getCmp('form_filter_ReporteResumenGeneralPlanilla');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});