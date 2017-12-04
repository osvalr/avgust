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
* DATE CREATE : 23/03/2015 12:20:16
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarAnioPlanilla.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarAnioPlanilla.MainStore'],

    models: ['GestionarAnioPlanilla.MainModel'],

    views: ['GestionarAnioPlanilla.Edit', 'GestionarAnioPlanilla.List'],

    refs: [
    	{
            ref: 'GestionarAnioPlanillaPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarAnioPlanillaList',
            selector: 'GestionarAnioPlanillaList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarAnioPlanilla.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarAnioPlanillaList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarAnioPlanillaList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarAnioPlanillaList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarAnioPlanillaEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarAnioPlanillaList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarAnioPlanillaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarAnioPlanillaList combobox': {
                change: this.refreshGrid
            },
            'GestionarAnioPlanillaList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
        

    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarAnioPlanilla.Edit').show();
        var form = edit.down('form');

        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_GestionarAnioParametroPlanillaQuery = Ext.getCmp('subModel_GestionarAnioParametroPlanillaQuery');
        	var srl_id_anio_planilla = form.getForm().findField('srl_id_anio_planilla');
        	
        	var subModel_GestionarAnioPeriodoPlanillaQuery = Ext.getCmp('subModel_GestionarAnioPeriodoPlanillaQuery');
        	var srl_id_anio_planilla = form.getForm().findField('srl_id_anio_planilla');
        	
			subModel_GestionarAnioParametroPlanillaQuery.store.reload({
				params: {srl_id_anio_planilla: srl_id_anio_planilla.getValue(), start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_GestionarAnioPeriodoPlanillaQuery.store.reload({params: {srl_id_anio_planilla: srl_id_anio_planilla.getValue(), start:0, limit:20}});
					}
				}
			});

			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_GestionarAnioParametroPlanillaQuery = Ext.getCmp('subModel_GestionarAnioParametroPlanillaQuery');
        	var subModel_GestionarAnioPeriodoPlanillaQuery = Ext.getCmp('subModel_GestionarAnioPeriodoPlanillaQuery');
        	
       	 var int_id_estado = form.getForm().findField('int_id_estado');
         int_id_estado.setReadOnly(true);
         int_id_estado.setValue(1); 
        	
//     	 var int_id_estado_vigencia = form.getForm().findField('int_id_estado_vigencia');
//     	int_id_estado_vigencia.setReadOnly(true);
//     	int_id_estado_vigencia.setValue(1); 
         
			subModel_GestionarAnioParametroPlanillaQuery.store.reload({
				params: {srl_id_anio_planilla: -1, start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_GestionarAnioPeriodoPlanillaQuery.store.reload({params: {srl_id_anio_planilla: -1, start:0, limit:20}});
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
        var store = Ext.getStore('GestionarAnioPlanilla.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_anio_planilla > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarAnioPlanilla.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarAnioPlanilla_statusbar');
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
    	
    	var grid = this.getGestionarAnioPlanillaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarAnioPlanilla.MainStore');
    	
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
    	var store = Ext.getStore('GestionarAnioPlanilla.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarAnioPlanilla.MainStore');
        var form = Ext.getCmp('form_filter_GestionarAnioPlanilla');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarAnioPlanilla.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarAnioPlanilla.MainStore');
        var form = Ext.getCmp('form_filter_GestionarAnioPlanilla');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});