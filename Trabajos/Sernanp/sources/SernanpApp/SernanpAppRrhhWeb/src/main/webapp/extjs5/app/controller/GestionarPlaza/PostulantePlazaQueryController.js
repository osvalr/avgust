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
* DATE CREATE : 20/04/2015 01:10:00
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarPlaza.PostulantePlazaQueryController', {
    extend: 'Ext.app.Controller',
    
    stores: ['GestionarPlaza.PostulantePlazaQueryStore','GestionarNotasPostulante.MainStore'],

    models: ['GestionarPlaza.PostulantePlazaQueryModel'],

    views: ['GestionarPlaza.PostulantePlazaQueryEdit', 'GestionarPlaza.PostulantePlazaQueryList'],

    requires: ['MyApp.view.GestionarNotasPostulante.WindowList'],
    
    refs: [
    	{
            ref: 'PostulantePlazaQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'PostulantePlazaQueryList',
            selector: 'PostulantePlazaQueryList'
        }
    ],

    init: function() {
        this.control({
        	
            'GestionarNotasPostulanteList dataview': {
                itemdblclick: this.editRecordNotas
            },
            
            'GestionarNotasPostulanteEdit button[action=save]': {
                click: this.updateRecordNotas
            },
        	
            'PostulantePlazaQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'PostulantePlazaQueryList button[action=add]': {
            	click: this.editRecord
            },
            'PostulantePlazaQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'PostulantePlazaQueryEdit button[action=save]': {
                click: this.updateRecord
            },
            'PostulantePlazaQueryList button[action=registrarNotas]': {
                click: this.registrarNotas
            },
            'PostulantePlazaQueryList button[action=seleccionarGanadores]': {
                click: this.seleccionarGanadores
            }
            
        });
    },
    
    editRecordNotas : function(grid, record){
    	
//    	console.log('Add notas ...');
    	
    	var store = Ext.getStore('GestionarNotasPostulante.MainStore');
    	
    	var int_id_tipo_factor = record.data.int_id_tipo_factor;
//    	console.log('int_id_tipo_factor --> ' +int_id_tipo_factor);
    	var existeSubItem = false;
    	store.each(function(rec){
    		var int_id_tipo_factor_padre = rec.get('int_id_tipo_factor_padre');
    		console.log('int_id_tipo_factor_padre --> ' +int_id_tipo_factor_padre)
    		if(int_id_tipo_factor_padre === int_id_tipo_factor){
    			existeSubItem = true;
    		}
    	});
    	
    	if(!existeSubItem){
    		var edit = Ext.create('MyApp.view.GestionarNotasPostulante.Edit').show();
            if(record.data){
            	edit.down('form').loadRecord(record);
            	edit.setTitle('Editar');
            }else{
            	edit.setTitle('Agregar');
            }
    	}
    	
    },
    
    updateRecordNotas: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarNotasPostulante.MainStore');
        
        if (form.isValid()) {
//	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
//	            if (btn == 'yes') {
	        		if (values.srl_conv_area_org_factor_eval > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarNotasPostulante.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_GestionarNotasPostulante_statusbar');
	        		sb.showBusy('Grabando...');
	        		win.getEl().mask();
	                	
	        		store.sync({
	        	        success: function (batch, eOpts) {
//				        	store.load();
	        	        	var formFilter = Ext.getCmp('form_filter_GestionarNotasPostulante');
	        		        var srl_id_postulante_conv_area_org = formFilter.getForm().findField('srl_id_postulante_conv_area_org');	        		        

	        		        console.log('srl_id_postulante_conv_area_org --> ' + srl_id_postulante_conv_area_org.getValue())
	        		        
				        	store.load({params: {srl_id_postulante_conv_area_org:srl_id_postulante_conv_area_org.getValue()}});
				        	win.close();
	        	        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
                            sb.setStatus({text:'Error intentado grabar.'});
				        	win.getEl().unmask();
	        	        }
	        	    });
//	            }
//	        });
		}      

        
        
    },

    editRecord: function(grid, record) {
    	
    	console.log(record);
    	console.log(record.data.srl_id_postulante_conv_area_org);
    	
    	if(record.data.int_id_estado == 7 || record.data.int_id_estado == 2){
    		var edit = Ext.create('MyApp.view.GestionarPlaza.PostulantePlazaQueryEdit').show();
            if(record.data){
            	edit.down('form').loadRecord(record);
            	edit.setTitle('Editar');
            }else{
            	edit.setTitle('Agregar');
            }
    	}
    	
        
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarPlaza.PostulantePlazaQueryStore');
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.var_nombre_estado = int_id_estado.getRawValue();
        
        var srl_id_postulante_conv_area_org = form.getForm().findField('srl_id_postulante_conv_area_org');
        
        var int_orden_merito = form.getForm().findField('int_orden_merito');
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	            	
	            	Ext.Ajax.request({
	                    method: 'GET',
	                    url: 'grabar-estado-postulacion.action',
	                    params: {
	                    			'srl_id_postulante_conv_area_org':srl_id_postulante_conv_area_org.getValue(),
	                    			'int_orden_merito':int_orden_merito.getValue(),
	                    			'int_id_estado':int_id_estado.getValue()
	                    		},
	                    success: function( result, request ){
	                    	store.load({params: {srl_id_conv_area_org: null}});
                            win.close();
	                    },
	        	        failure: function (batch, eOpts) {
	        	        	store.rejectChanges();
	        	        }
	                });
	            	
                
//                    if(win.title === 'Editar') {
//                        record.set(values);
//                    } else{
//                        record = Ext.create('MyApp.model.GestionarPlaza.PostulantePlazaQueryModel');
//                        record.set(values);
//                        store.add(record);
//                    }
//                    	
//                    store.sync({
//                        success: function (batch, eOpts) {
//                            store.load({params: {srl_id_conv_area_org: null}});
//                            win.close();
//                        },
//	        	        failure: function (batch, eOpts) {
//							store.rejectChanges();
//	        	        }
//                    });
	            }
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getPostulantePlazaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPlaza.PostulantePlazaQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {srl_id_conv_area_org: null}});
					        }
					    });
	                }
	        });
    	}

    },
    
    registrarNotas: function(button) {
    	
    	var grid = this.getPostulantePlazaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	
    	
    	if(record.length > 0){
    		
    		Ext.create('MyApp.view.GestionarNotasPostulante.WindowList').show();
    		var formFilter = Ext.getCmp('form_filter_GestionarNotasPostulante');
	        var srl_id_postulante_conv_area_org = formFilter.getForm().findField('srl_id_postulante_conv_area_org');
	        srl_id_postulante_conv_area_org.setValue(record[0].data.srl_id_postulante_conv_area_org);	        
	        var store = Ext.getStore('GestionarNotasPostulante.MainStore');
	        store.load({params: {srl_id_postulante_conv_area_org:srl_id_postulante_conv_area_org.getValue()}});
    	}

    },
    
    seleccionarGanadores: function(button) {
    	
    	var store = Ext.getStore('GestionarPlaza.PostulantePlazaQueryStore');
    	
    	var form = Ext.getCmp('form_crud_GestionarPlaza');
        var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	
    	Ext.Ajax.request({
            method: 'GET',
            url: 'seleccionar-ganadores.action',
            params: {
            			'srl_id_conv_area_org':srl_id_conv_area_org.getValue()
            		},
            success: function( result, request ){
            	store.load({params: {srl_id_conv_area_org: null}});
//                win.close();
            },
	        failure: function (batch, eOpts) {
	        	store.rejectChanges();
	        }
        });

    }
    
});