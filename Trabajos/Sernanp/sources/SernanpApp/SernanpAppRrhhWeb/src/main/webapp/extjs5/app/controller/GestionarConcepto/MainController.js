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
* DATE CREATE : 03/04/2015 18:33:21
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarConcepto.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarConcepto.MainStore'],

    models: ['GestionarConcepto.MainModel'],

    views: ['GestionarConcepto.Edit', 'GestionarConcepto.List'],

    refs: [
    	{
            ref: 'GestionarConceptoPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarConceptoList',
            selector: 'GestionarConceptoList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarConcepto.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarConceptoList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarConceptoList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarConceptoList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarConceptoEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarConceptoList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarConceptoList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarConceptoList combobox': {
                change: this.refreshGrid
            },
            'GestionarConceptoList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarConcepto.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_ConceptoAfectoQuery = Ext.getCmp('subModel_ConceptoAfectoQuery');
        	var srl_id_concepto_planilla = form.getForm().findField('srl_id_concepto_planilla');
        	
        	var subModel_ConceptoFrecuenciaQuery = Ext.getCmp('subModel_ConceptoFrecuenciaQuery');
        	var srl_id_concepto_planilla = form.getForm().findField('srl_id_concepto_planilla');
        	
			subModel_ConceptoAfectoQuery.store.reload({
				params: {srl_id_concepto_planilla: srl_id_concepto_planilla.getValue(), start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_ConceptoFrecuenciaQuery.store.reload({params: {srl_id_concepto_planilla: srl_id_concepto_planilla.getValue(), start:0, limit:20}});
					}
				}
			});

			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_ConceptoAfectoQuery = Ext.getCmp('subModel_ConceptoAfectoQuery');
        	var subModel_ConceptoFrecuenciaQuery = Ext.getCmp('subModel_ConceptoFrecuenciaQuery');
			subModel_ConceptoAfectoQuery.store.reload({
				params: {srl_id_concepto_planilla: -1, start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_ConceptoFrecuenciaQuery.store.reload({params: {srl_id_concepto_planilla: -1, start:0, limit:20}});
					}
				}
			});

			var int_id_estado = form.getForm().findField('int_id_estado');
        	int_id_estado.setReadOnly(true);
        	int_id_estado.setValue(1);
        	
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarConcepto.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_concepto_planilla > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarConcepto.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarConcepto_statusbar');
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
    	
    	var grid = this.getGestionarConceptoList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarConcepto.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarConcepto.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarConcepto.MainStore');
        var form = Ext.getCmp('form_filter_GestionarConcepto');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarConcepto.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarConcepto.MainStore');
        var form = Ext.getCmp('form_filter_GestionarConcepto');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});