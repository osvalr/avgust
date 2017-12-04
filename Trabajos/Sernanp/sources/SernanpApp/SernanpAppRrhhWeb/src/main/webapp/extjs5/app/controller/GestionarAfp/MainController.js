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
* DATE CREATE : 17/03/2015 19:55:09
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarAfp.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarAfp.MainStore'],

    models: ['GestionarAfp.MainModel'],

    views: ['GestionarAfp.Edit', 'GestionarAfp.List'],

    refs: [
    	{
            ref: 'GestionarAfpPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarAfpList',
            selector: 'GestionarAfpList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarAfp.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarAfpList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarAfpList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarAfpList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarAfpEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarAfpList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarAfpList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarAfpList combobox': {
                change: this.refreshGrid
            },
            'GestionarAfpList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarAfp.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_GestionarAfpPlanillaComisionQuery = Ext.getCmp('subModel_GestionarAfpPlanillaComisionQuery');
        	var srl_id_afp = form.getForm().findField('srl_id_afp');
        	
			subModel_GestionarAfpPlanillaComisionQuery.store.reload({params: {srl_id_afp: srl_id_afp.getValue(), start:0, limit:10}});
			
        }else{
        	edit.setTitle('Agregar');
        	
       	 var int_id_estado = form.getForm().findField('int_id_estado');
       	int_id_estado.setReadOnly(true);
       	int_id_estado.setValue(1);
         
        	var subModel_GestionarAfpPlanillaComisionQuery = Ext.getCmp('subModel_GestionarAfpPlanillaComisionQuery');
			subModel_GestionarAfpPlanillaComisionQuery.store.reload({params: {srl_id_afp: -1, start:0, limit:10}});
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarAfp.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_afp > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarAfp.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarAfp_statusbar');
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
    	
    	var grid = this.getGestionarAfpList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarAfp.MainStore');
    	
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
    	var store = Ext.getStore('GestionarAfp.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarAfp.MainStore');
        var form = Ext.getCmp('form_filter_GestionarAfp');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarAfp.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarAfp.MainStore');
        var form = Ext.getCmp('form_filter_GestionarAfp');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});