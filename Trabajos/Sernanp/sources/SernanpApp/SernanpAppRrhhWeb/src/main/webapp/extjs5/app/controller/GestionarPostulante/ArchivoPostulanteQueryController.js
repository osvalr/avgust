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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarPostulante.ArchivoPostulanteQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPostulante.ArchivoPostulanteQueryStore'],

    models: ['GestionarPostulante.ArchivoPostulanteQueryModel'],

    views: ['GestionarPostulante.ArchivoPostulanteQueryEdit', 'GestionarPostulante.ArchivoPostulanteQueryList','GestionarPostulante.PostulacionPersonaQueryList'],

    refs: [
    	{
            ref: 'ArchivoPostulanteQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'ArchivoPostulanteQueryList',
            selector: 'ArchivoPostulanteQueryList'
        }
    ],

    init: function() {
        this.control({
            'PostulacionPersonaQueryList dataview': {
//                itemdblclick: this.editRecord
            },
            'ArchivoPostulanteQueryList button[action=add]': {
            	click: this.editRecord
            },
            'ArchivoPostulanteQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'ArchivoPostulanteQueryList button[action=save]': {
                click: this.updateRecord
            },
            'ArchivoPostulanteQueryList button[action=download]': {
            	click: this.downloadFile
            }
        });
    },

    editRecord: function(grid, record) {
//        var edit = Ext.create('MyApp.view.GestionarPostulante.ArchivoPostulanteQueryEdit').show();
    	var form = Ext.getCmp('form_submodel_ArchivoPostulanteQuery');
        if(record.data){
        	form.getForm().loadRecord(record);
        }
    },
    
    updateRecord: function(button) {
    	
//        var win = button.up('window');
//        var form = button.up('form');
    	var form = Ext.getCmp('form_submodel_ArchivoPostulanteQuery');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarPostulante.ArchivoPostulanteQueryStore');
        
        var int_id_tipo_documento = form.getForm().findField('int_id_tipo_documento');
        values.var_descrip_tipo_documento = int_id_tipo_documento.getRawValue();
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
//                    if(win.title === 'Editar') {
//                    	values.tokenField = 'update';
//                        record.set(values);
//                    } else{
                        record = Ext.create('MyApp.model.GestionarPostulante.ArchivoPostulanteQueryModel');
                        values.tokenField = 'insert';
                        record.set(values);
                        store.add(record);
//                    }
                    
                    var sync = function(){
                    	store.sync({
                            success: function (batch, eOpts) {
                                store.load({params: {int_id_postulante: null}});
                                form.reset();
//                                win.close();
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
	                        success: function(fp, o) {
	        	        		sync();
	                        },
	                        failure: function (fp, o){

	                        	Ext.MessageBox.show({
	                                title: 'FILE EXCEPTION',
	                                msg: "Error subiendo imagen, intentelo despues.",
	                                icon: Ext.MessageBox.ERROR,
	                                buttons: Ext.Msg.OK
	                            });
	                        }
	                    });
	                	
	                }else{
	                	sync();
	                }

	            }
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getArchivoPostulanteQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPostulante.ArchivoPostulanteQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {int_id_postulante: null}});
					        }
					    });
	                }
	        });
    	}

    },
    downloadFile: function(button) {
    	
    	var grid = this.getArchivoPostulanteQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPostulante.ArchivoPostulanteQueryStore');
    	
    	if(record.length > 0){
    		window.open('download-file-postulante.action?srl_id_archivo='+record[0].data.srl_id_archivo, '_blank');
    	}

    }
    
});