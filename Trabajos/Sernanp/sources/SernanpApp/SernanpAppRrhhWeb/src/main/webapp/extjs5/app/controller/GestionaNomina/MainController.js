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
* DATE CREATE : 07/04/2015 14:31:08
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionaNomina.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionaNomina.MainStore'],

    models: ['GestionaNomina.MainModel'],

    views: ['GestionaNomina.Edit', 'GestionaNomina.List'],

    refs: [
    	{
            ref: 'GestionaNominaPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionaNominaList',
            selector: 'GestionaNominaList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionaNomina.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionaNominaList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionaNominaList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionaNominaEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionaNominaList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionaNominaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionaNominaList combobox': {
                select: this.refreshGrid
            },
            'GestionaNominaList textfield': {
            	specialkey: this.onKeyEnter
            }
            
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionaNomina.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_IngresosNominaConceptoQuery = Ext.getCmp('subModel_IngresosNominaConceptoQuery');
        	var srl_id_nomina_anio_periodo_personal = form.getForm().findField('srl_id_nomina_anio_periodo_personal');
        	
        	var subModel_DescuentosNominaConceptoQuery = Ext.getCmp('subModel_DescuentosNominaConceptoQuery');
        	var srl_id_nomina_anio_periodo_personal = form.getForm().findField('srl_id_nomina_anio_periodo_personal');
        	
        	var subModel_DescuentoJudicialesNominaConceptoQuery = Ext.getCmp('subModel_DescuentoJudicialesNominaConceptoQuery');
        	var srl_id_nomina_anio_periodo_personal = form.getForm().findField('srl_id_nomina_anio_periodo_personal');
        	
        	var subModel_AportesNominaConceptoQuery = Ext.getCmp('subModel_AportesNominaConceptoQuery');
        	var srl_id_nomina_anio_periodo_personal = form.getForm().findField('srl_id_nomina_anio_periodo_personal');
        	
			subModel_IngresosNominaConceptoQuery.store.reload({
				params: {srl_id_nomina_anio_periodo_personal: srl_id_nomina_anio_periodo_personal.getValue(), start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_DescuentosNominaConceptoQuery.store.reload({
							params: {srl_id_nomina_anio_periodo_personal: srl_id_nomina_anio_periodo_personal.getValue(), start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									subModel_DescuentoJudicialesNominaConceptoQuery.store.reload({
										params: {srl_id_nomina_anio_periodo_personal: srl_id_nomina_anio_periodo_personal.getValue(), start:0, limit:10},
										scope: this,
										callback: function(records, operation, success) {
											if (success) {
												subModel_AportesNominaConceptoQuery.store.reload({params: {srl_id_nomina_anio_periodo_personal: srl_id_nomina_anio_periodo_personal.getValue(), start:0, limit:10}});
											}
										}
									});

								}
							}
						});

					}
				}
			});

			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_IngresosNominaConceptoQuery = Ext.getCmp('subModel_IngresosNominaConceptoQuery');
        	var subModel_DescuentosNominaConceptoQuery = Ext.getCmp('subModel_DescuentosNominaConceptoQuery');
        	var subModel_DescuentoJudicialesNominaConceptoQuery = Ext.getCmp('subModel_DescuentoJudicialesNominaConceptoQuery');
        	var subModel_AportesNominaConceptoQuery = Ext.getCmp('subModel_AportesNominaConceptoQuery');
			subModel_IngresosNominaConceptoQuery.store.reload({
				params: {srl_id_nomina_anio_periodo_personal: -1, start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_DescuentosNominaConceptoQuery.store.reload({
							params: {srl_id_nomina_anio_periodo_personal: -1, start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									subModel_DescuentoJudicialesNominaConceptoQuery.store.reload({
										params: {srl_id_nomina_anio_periodo_personal: -1, start:0, limit:10},
										scope: this,
										callback: function(records, operation, success) {
											if (success) {
												subModel_AportesNominaConceptoQuery.store.reload({params: {srl_id_nomina_anio_periodo_personal: -1, start:0, limit:10}});
											}
										}
									});

								}
							}
						});

					}
				}
			});

        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionaNomina.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionaNomina.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionaNomina_statusbar');
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
    	
    	var grid = this.getGestionaNominaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionaNomina.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        }
						//ADD 15-10-2015 DAVID
						,
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
	        	        }
						//END
					    });
	                }
	        });
    	}

    },
    
   
    refreshGrid: function() {
    	var store = Ext.getStore('GestionaNomina.MainStore');
    	store.load({start:0});
    	
    	////////

        var form = Ext.getCmp('form_filter_GestionaNomina');
        var formTotales = Ext.getCmp('form_totales_GestionaNomina');
        
        var cantidad_nominas = formTotales.getForm().findField('cantidad_nominas');
        var total_ingresos = formTotales.getForm().findField('total_ingresos');
        var total_descuentos = formTotales.getForm().findField('total_descuentos');
        var total_aportes = formTotales.getForm().findField('total_aportes');
        var total_neto = formTotales.getForm().findField('total_neto');
        
        var values = form.getValues();
 
        Ext.Ajax.request({
	            method: 'GET',
	            url: 'GestionaNominaTotalesView.action',
	            params: values,
	            success: function( result, request ){

	            	var json = Ext.JSON.decode(result.responseText);
	            	
	            	cantidad_nominas.setValue(json.record.cantidad_nominas);
	            	total_ingresos.setValue(json.record.total_ingresos);
	            	total_descuentos.setValue(json.record.total_descuentos);
	            	total_aportes.setValue(json.record.total_aportes);
	            	total_neto.setValue(json.record.total_neto);
	            },
		        failure: function (batch, eOpts) {
		        	store.rejectChanges();
		        }
	        });
    	
    	///////
    },
       
    resetForm: function() {
    	var store = Ext.getStore('GestionaNomina.MainStore');
        var form = Ext.getCmp('form_filter_GestionaNomina');
        form.reset();
        
		var int_anio = form.getForm().findField('int_anio');
		int_anio.setValue(new Date().getFullYear());
		
		var int_id_periodo_mes = form.getForm().findField('int_id_periodo_mes');
		int_id_periodo_mes.setValue(1);
		
    	store.load({start:0});
    	
    	////////
    	
        var formTotales = Ext.getCmp('form_totales_GestionaNomina');
        
        var cantidad_nominas = formTotales.getForm().findField('cantidad_nominas');
        var total_ingresos = formTotales.getForm().findField('total_ingresos');
        var total_descuentos = formTotales.getForm().findField('total_descuentos');
        var total_aportes = formTotales.getForm().findField('total_aportes');
        var total_neto = formTotales.getForm().findField('total_neto');
        
        var values = form.getValues();
    	
        console.log(values);
        
	    	Ext.Ajax.request({
	            method: 'GET',
	            url: 'GestionaNominaTotalesView.action',
	            params: values,
	            success: function( result, request ){
	            	var json = Ext.JSON.decode(result.responseText);
	            	
	            	cantidad_nominas.setValue(json.record.cantidad_nominas);
	            	total_ingresos.setValue(json.record.total_ingresos);
	            	total_descuentos.setValue(json.record.total_descuentos);
	            	total_aportes.setValue(json.record.total_aportes);
	            	total_neto.setValue(json.record.total_neto);
	            },
		        failure: function (batch, eOpts) {
		        	store.rejectChanges();
		        }
	        });    	///////
        
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
    
        	var store = Ext.getStore('GestionaNomina.MainStore');
        	store.load({start:0});
        	
        	////////
        	var form = Ext.getCmp('form_filter_GestionaNomina');
            var formTotales = Ext.getCmp('form_totales_GestionaNomina');
            
            var cantidad_nominas = formTotales.getForm().findField('cantidad_nominas');
            var total_ingresos = formTotales.getForm().findField('total_ingresos');
            var total_descuentos = formTotales.getForm().findField('total_descuentos');
            var total_aportes = formTotales.getForm().findField('total_aportes');
            var total_neto = formTotales.getForm().findField('total_neto');
            
            var values = form.getValues();
        	
            console.log(values);
            
    	    	Ext.Ajax.request({
    	            method: 'GET',
    	            url: 'GestionaNominaTotalesView.action',
    	            params: values,
    	            success: function( result, request ){
    	            	var json = Ext.JSON.decode(result.responseText);
    	            	
    	            	cantidad_nominas.setValue(json.record.cantidad_nominas);
    	            	total_ingresos.setValue(json.record.total_ingresos);
    	            	total_descuentos.setValue(json.record.total_descuentos);
    	            	total_aportes.setValue(json.record.total_aportes);
    	            	total_neto.setValue(json.record.total_neto);
    	            },
    		        failure: function (batch, eOpts) {
    		        	store.rejectChanges();
    		        }
    	        });
    	    ///////
       	
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionaNomina.MainStore');
        var form = Ext.getCmp('form_filter_GestionaNomina');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});