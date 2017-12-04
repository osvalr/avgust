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

Ext.define('MyApp.controller.GestionarReqPersonal.ArchivoRequerimientoQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarReqPersonal.ArchivoRequerimientoQueryStore'],

    models: ['GestionarReqPersonal.ArchivoRequerimientoQueryModel'],

    views: ['GestionarReqPersonal.ArchivoRequerimientoQueryEdit', 'GestionarReqPersonal.ArchivoRequerimientoQueryList'],

    refs: [
    	{
            ref: 'ArchivoRequerimientoQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'ArchivoRequerimientoQueryList',
            selector: 'ArchivoRequerimientoQueryList'
        }
    ],

    init: function() {
        this.control({
        
            'ArchivoRequerimientoQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'ArchivoRequerimientoQueryList button[action=add]': {
            	click: this.editRecord
            },
            'ArchivoRequerimientoQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'ArchivoRequerimientoQueryEdit button[action=save]': {
                click: this.updateRecord
            },
            
            'ArchivoRequerimientoQueryList button[action=download]': {
                click: this.downloadFile
            },

        	/*
            'ArchivoRequerimientoQueryListAlterno dataview': {
                itemdblclick: this.editRecord
            },
            'ArchivoRequerimientoQueryListAlterno button[action=add]': {
            	click: this.editRecord
            },
            'ArchivoRequerimientoQueryListAlterno button[action=delete]': {
                click: this.deleteRecord
            },
            'ArchivoRequerimientoQueryListAlterno button[action=save]': {
                click: this.updateRecord
            },
            'ArchivoRequerimientoQueryListAlterno button[action=download]': {
                click: this.downloadFile
            }
            */
            
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarReqPersonal.ArchivoRequerimientoQueryEdit').show();
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
        var store = Ext.getStore('GestionarReqPersonal.ArchivoRequerimientoQueryStore');
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                    	values.tokenField = 'update';
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarReqPersonal.ArchivoRequerimientoQueryModel');
                        values.tokenField = 'insert';
                        record.set(values);
                        store.add(record);
                    }
                   
                 var sync = function(){
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {srl_id_requerimiento_personal: null}});
                            win.close();
                        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
	        	        }
                    });
                 };
                 
                 var upload = form.getForm().findField('upload');
                 
                 if(upload.getValue() !== ""){
                	 
                	 form.submit({
                		
                		 url: 'upload-file-common.action',
                		 waitMsg: 'Subiendo archivo...',
                		 success: function(fp, o){
                			 sync();
                		 },
                		 failure: function(fp, o){
                			 Ext.MessageBox.show({
                				 title: 'FILE EXCEPTION',
                				 msg: "Error subiendo archivo, intentelo despues.",
                				 icon: Ext.MessageBox.ERROR,
                				 buttons: Ext.Msg.OK
                			 });
                		 }
                	 });
                 }else{
                	 sync();
                 }
                    
	            }//end if 'yes'
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getArchivoRequerimientoQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarReqPersonal.ArchivoRequerimientoQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {srl_id_requerimiento_personal: null}});
					        }
					    });
	                }
	        });
    	}

    },
    
    downloadFile: function(button) {
    	
    	var grid = this.getArchivoRequerimientoQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarReqPersonal.ArchivoRequerimientoQueryStore');
    	
    	if(record.length > 0){
    		
    		window.open('download-file-requerimiento.action?srl_id_archivo='+record[0].data.srl_id_archivo, '_blank');
    	}

    }
    
});