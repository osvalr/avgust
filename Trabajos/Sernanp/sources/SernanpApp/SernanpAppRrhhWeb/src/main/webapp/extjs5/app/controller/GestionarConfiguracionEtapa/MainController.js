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
* DATE CREATE : 18/04/2015 19:13:57
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarConfiguracionEtapa.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarConfiguracionEtapa.MainStore'],

    models: ['GestionarConfiguracionEtapa.MainModel'],

    views: ['GestionarConfiguracionEtapa.Edit', 'GestionarConfiguracionEtapa.List'],

    refs: [
    	{
            ref: 'GestionarConfiguracionEtapaPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarConfiguracionEtapaList',
            selector: 'GestionarConfiguracionEtapaList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarConfiguracionEtapa.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarConfiguracionEtapaList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarConfiguracionEtapaList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarConfiguracionEtapaList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarConfiguracionEtapaEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarConfiguracionEtapaList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarConfiguracionEtapaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarConfiguracionEtapaList combobox': {
                change: this.refreshGrid
            },
            'GestionarConfiguracionEtapaList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarConfiguracionEtapa.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_ConfiguracionEtapaQuery = Ext.getCmp('subModel_ConfiguracionEtapaQuery');
        	var srl_id_configuracion_evaluacion_personal = form.getForm().findField('srl_id_configuracion_evaluacion_personal');
        	
			subModel_ConfiguracionEtapaQuery.store.reload({params: {srl_id_configuracion_evaluacion_personal: srl_id_configuracion_evaluacion_personal.getValue(), start:0, limit:10}});
			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_ConfiguracionEtapaQuery = Ext.getCmp('subModel_ConfiguracionEtapaQuery');
			subModel_ConfiguracionEtapaQuery.store.reload({params: {srl_id_configuracion_evaluacion_personal: -1, start:0, limit:10}});
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarConfiguracionEtapa.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_configuracion_evaluacion_personal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarConfiguracionEtapa.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarConfiguracionEtapa_statusbar');
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
    	
    	var grid = this.getGestionarConfiguracionEtapaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarConfiguracionEtapa.MainStore');
    	
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
    	var store = Ext.getStore('GestionarConfiguracionEtapa.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarConfiguracionEtapa.MainStore');
        var form = Ext.getCmp('form_filter_GestionarConfiguracionEtapa');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarConfiguracionEtapa.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarConfiguracionEtapa.MainStore');
        var form = Ext.getCmp('form_filter_GestionarConfiguracionEtapa');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});