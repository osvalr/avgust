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
* DATE CREATE : 19/04/2015 01:20:12
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarReqPersonal.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarReqPersonal.MainStore'],

    models: ['GestionarReqPersonal.MainModel'],

    views: ['GestionarReqPersonal.Edit', 'GestionarReqPersonal.EditAlterno', 'GestionarReqPersonal.List', 'GestionarReqPersonal.ListAlterno'],

    refs: [
    	{
            ref: 'GestionarReqPersonalPanel',
            selector: 'panel'
        },
//        {
//            ref: 'GestionarReqPersonalList',
//            selector: 'GestionarReqPersonalList'
//        },
        {
            ref: 'GestionarReqPersonalListAlterno',
            selector: 'GestionarReqPersonalListAlterno'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarReqPersonal.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarReqPersonalList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarReqPersonalListAlterno dataview': {
                itemdblclick: this.editRecordAlterno
            },
            'GestionarReqPersonalList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarReqPersonalListAlterno button[action=add]': {
            	click: this.editRecordAlterno
            },
//            'GestionarReqPersonalList button[action=delete]': {
//                click: this.deleteRecord
//            }            
            
            'GestionarReqPersonalListAlterno button[action=delete]': {
                click: this.deleteRecord
            },
            
            
            'GestionarReqPersonalEdit button[action=save]': {
                click: this.updateRecord
            },
            
            'GestionarReqPersonalEditAlterno button[action=save]': {
                click: this.updateRecord
            },
            
            'GestionarReqPersonalList button[action=filter]': {
                click: this.refreshGrid
            },            
	        
	        'GestionarReqPersonalListAlterno button[action=filter]': {
	            click: this.refreshGrid
	        },
            
            'GestionarReqPersonalList button[action=clearFilter]': {
                click: this.resetForm
            },
            
            'GestionarReqPersonalListAlterno button[action=clearFilter]': {
                click: this.resetForm
            },
            
            
            'GestionarReqPersonalList combobox': {
                change: this.refreshGrid
            },
            
            'GestionarReqPersonalListAlterno combobox': {
                change: this.refreshGrid
            },
            
            'GestionarReqPersonalList textfield': {
            	specialkey: this.onKeyEnter
            },
            'GestionarReqPersonalList button[action=generarOficioMintra]': {
                click: this.generarOficioMintra
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarReqPersonal.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_ArchivoRequerimientoQuery = Ext.getCmp('subModel_ArchivoRequerimientoQuery');
        	var srl_id_requerimiento_personal = form.getForm().findField('srl_id_requerimiento_personal');
        	
			subModel_ArchivoRequerimientoQuery.store.reload({
			params: {srl_id_requerimiento_personal: srl_id_requerimiento_personal.getValue(), start:0, limit:10},
			scope: this
			
			});
			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_ArchivoRequerimientoQuery = Ext.getCmp('subModel_ArchivoRequerimientoQuery');
			subModel_ArchivoRequerimientoQuery.store.reload({params: {srl_id_requerimiento_personal: -1, start:0, limit:10},
				scope: this});
        }
    },
    
    editRecordAlterno: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarReqPersonal.EditAlterno').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_ArchivoRequerimientoQuery = Ext.getCmp('subModel_ArchivoRequerimientoQuery');
        	var srl_id_requerimiento_personal = form.getForm().findField('srl_id_requerimiento_personal');
        	
			subModel_ArchivoRequerimientoQuery.store.reload({
			params: {srl_id_requerimiento_personal: srl_id_requerimiento_personal.getValue(), start:0, limit:10},
			scope: this
			
			});
			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_ArchivoRequerimientoQuery = Ext.getCmp('subModel_ArchivoRequerimientoQuery');
			subModel_ArchivoRequerimientoQuery.store.reload({params: {srl_id_requerimiento_personal: -1, start:0, limit:10},
				scope: this});
        }
    },
    
    updateRecord: function(button) {
    	console.log("Grabando");
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarReqPersonal.MainStore');
        
        var form_filter = Ext.getCmp('form_filter_GestionarReqPersonal');
		var srl_id_requerimiento_personal = form_filter.getForm().findField('srl_id_requerimiento_personal');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_requerimiento_personal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarReqPersonal.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarReqPersonal_statusbar');
	        		sb.showBusy('Grabando...');
	        		win.getEl().mask();
                    
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	store.load();
				        	
//				        	srl_id_requerimiento_personal.store.reload({params: {srl_id_convocatoria: -1}});
//				        	
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
        /* 01-09-2015 DAVID
        else{
			alert("form.noValid");
		}*/

    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarReqPersonalListAlterno();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarReqPersonal.MainStore');
    	
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
    generarOficioMintra :function(button){
    	
    	var grid = this.getGestionarReqPersonalList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarReqPersonal.MainStore');
    	
    	window.open('oficio-requerimientos-mintra.action',  '_blank');
//    	window.open('oficio-requerimientos-mintra.action');
    	
    },
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarReqPersonal.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarReqPersonal.MainStore');
        var form = Ext.getCmp('form_filter_GestionarReqPersonal');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarReqPersonal.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarReqPersonal.MainStore');
        var form = Ext.getCmp('form_filter_GestionarReqPersonal');
        var values = form.getValues();
         	
        if (typeof alter !== "undefined") {   		
    		
        	var on_combo_areas = form.getForm().findField('idarea_solicitante');    		
    		
    		on_combo_areas.setValue(idarea);
    		
    		on_combo_areas.store.on('load',function(ds,records,o){

    			on_combo_areas.setValue(records[0].data.desarea);
	  			  
	  		});

    		on_combo_areas.setDisabled(true);
        	
           values.idarea_solicitante = idarea;           
        }

        store.getProxy().extraParams = values;
    }
    
});