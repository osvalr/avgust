/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   05/03/2016 15:14:59
*/

Ext.define('MyApp.controller.GestionarGuia.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarGuia.MainStore', 'GestionarClienteNatural.MainStore', 'GestionarClienteJuridico.MainStore'],

    models: ['GestionarGuia.MainModel'],

    views: ['GestionarGuia.Edit', 'GestionarGuia.List', 'GestionarGuia.PerfilCobradorList', 'GestionarGuia.AddClienteNaturalForm', 'GestionarGuia.AddClienteJuridicoForm'],

    refs: [
    	{
            ref: 'GestionarGuiaPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarGuiaList',
            selector: 'GestionarGuiaList'
        },
        {
            ref: 'PerfilCobradorList',
            selector: 'PerfilCobradorList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarGuia.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarGuiaList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarGuiaList button[action=add]': {
            	click: this.editRecord
            },
            'PerfilCobradorList dataview': {
                itemdblclick: this.editRecord
            },
            'PerfilCobradorList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarGuiaEdit menuitem[action=addClienteNatural]': {
            	click: this.showFormAddClienteNatural
            },
            'GestionarGuiaAddClienteNaturalForm button[action=saveClienteNatural]': {
            	click: this.saveClienteNatural
            },
            'GestionarGuiaEdit menuitem[action=addClienteJuridico]': {
            	click: this.showFormAddClienteJuridico
            },
            'GestionarGuiaAddClienteJuridicoForm button[action=saveClienteJuridico]': {
            	click: this.saveClienteJuridico
            },
            'GestionarGuiaList button[action=delete]': {
                click: this.deleteRecord
            },
            'PerfilCobradorList button[action=delete]': {
                click: this.deleteRecord2
            },
            'GestionarGuiaEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarGuiaList button[action=filter]': {
                click: this.refreshGrid
            },
            'PerfilCobradorList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarGuiaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'PerfilCobradorList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarGuiaList combobox': {
                change: this.refreshGrid
            },
            'GestionarGuiaList textfield': {
            	specialkey: this.onKeyEnter
            },
            'PerfilCobradorList combobox': {
                change: this.refreshGrid
            },
            'PerfilCobradorList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarGuia.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_GuiaPesoQuery = Ext.getCmp('subModel_GuiaPesoQuery');
        	var id_guia = form.getForm().findField('id_guia');
        	
			subModel_GuiaPesoQuery.store.reload({
				params: {id_guia: id_guia.getValue(), start:0, limit:1000},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						//Obtenemos Totales
						this.setGuiaTotales();
					}
				}
			});

			
        }else{
        	edit.setTitle('Agregar');
        	
        	var subModel_GuiaPesoQuery = Ext.getCmp('subModel_GuiaPesoQuery');
        	var subModel_GuiaSaldoQuery = Ext.getCmp('subModel_GuiaSaldoQuery');
			subModel_GuiaPesoQuery.store.reload({params: {id_guia: -1, start:0, limit:1000}});
//			subModel_GuiaSaldoQuery.store.reload({params: {id_guia: id_guia.getValue(), start:0, limit:10}});
			
          	var id_estado = form.getForm().findField('id_estado');
          	id_estado.setReadOnly(true);
          	id_estado.setValue(1);
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarGuia.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	            	
	            	var formTotales = Ext.getCmp('form_totales');
	            	taraCompleta = formTotales.getForm().findField('taraCompleta');
	            	
	            	if(taraCompleta.getValue() == '' || taraCompleta.getValue() == 'Si'){
	            		
		        		if (values.id_guia > 0){
		        			values.tokenField = 'update';
		        			record.set(values);
		        		} else{
		        			record = Ext.create('MyApp.model.GestionarGuia.MainModel');
		        			values.tokenField = 'insert';
		        			record.set(values);
		        			store.add(record);
		        		}
		                
		        		store.sync({
		        	        success: function (batch, eOpts) {
					        	store.load();
					        	win.close();
		        	        },
		        	        failure: function (batch, eOpts) {
								store.rejectChanges();
		        	        }
		        	    });
	            		
	            	}else{
	            		Ext.MessageBox.show({
	                        title: 'Error',
	                        msg: 'Falta completar la TARA, la cantidad de jabas de los pesos bruto y tara son diferentes.',
	                        icon: Ext.MessageBox.ERROR,
	                        buttons: Ext.Msg.OK
	                    });
	            	}
	            	

	            }
	        });
		}

    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarGuiaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarGuia.MainStore');
    	
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
    deleteRecord2: function(button) {
    	
    	var grid = this.getPerfilCobradorList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarGuia.MainStore');
    	
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
    
    showFormAddClienteNatural: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarGuia.AddClienteNaturalForm').show();
        edit.setTitle('Agregar');
    },
    
    saveClienteNatural: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarClienteNatural.MainStore');
        
        if (form.isValid()) {
        	
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	            	store.loadData([],false);
	        		record = Ext.create('MyApp.model.GestionarClienteNatural.MainModel');
	        		values.tokenField = 'insert';
	        		record.set(values);
	        		store.add(record);
	                
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	win.close();
	        	        }
	        	    });
	            }
	            
	        });
		}

    },
    
    showFormAddClienteJuridico: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarGuia.AddClienteJuridicoForm').show();
        edit.setTitle('Agregar');
    },
    
    saveClienteJuridico: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarClienteJuridico.MainStore');
        
        if (form.isValid()) {
        	
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	            	store.loadData([],false);
	        		record = Ext.create('MyApp.model.GestionarClienteJuridico.MainModel');
	        		values.tokenField = 'insert';
	        		record.set(values);
	        		store.add(record);
	                
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	win.close();
	        	        }
	        	    });
	            }
	            
	        });
		}

    },
    
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarGuia.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarGuia.MainStore');
        var form = Ext.getCmp('form_filter_GestionarGuia');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarGuia.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarGuia.MainStore');
        var form = Ext.getCmp('form_filter_GestionarGuia');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    },
    setGuiaTotales: function() {
    	Ext.Ajax.request({
            method: 'GET',
            url: '/InaviWSRestApp/api/GestionarGuia/guiaTotales',
            success: function( result, request ){
            	
            	var json = Ext.JSON.decode(result.responseText);
            	var formTotales = Ext.getCmp('form_totales');
            	
            	total_peso_bruto = formTotales.getForm().findField('total_peso_bruto');
            	total_peso_tara = formTotales.getForm().findField('total_peso_tara');
            	total_peso_devolucion = formTotales.getForm().findField('total_peso_devolucion');
            	total_peso_tara_devo = formTotales.getForm().findField('total_peso_tara_devo');
            	total_peso_neto = formTotales.getForm().findField('total_peso_neto');
            	taraCompleta = formTotales.getForm().findField('taraCompleta');

            	total_peso_bruto.setValue(json.record.total_peso_bruto);
            	total_peso_tara.setValue(json.record.total_peso_tara);
            	total_peso_devolucion.setValue(json.record.total_peso_devolucion);
            	total_peso_tara_devo.setValue(json.record.total_peso_tara_devo);
            	total_peso_neto.setValue(json.record.total_peso_neto);
            	taraCompleta.setValue(json.record.taraCompleta);
            }
        });
    }
    
});