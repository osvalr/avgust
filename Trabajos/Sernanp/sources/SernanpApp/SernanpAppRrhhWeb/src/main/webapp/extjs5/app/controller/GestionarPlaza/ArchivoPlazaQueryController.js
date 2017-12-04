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

Ext.define('MyApp.controller.GestionarPlaza.ArchivoPlazaQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPlaza.ArchivoPlazaQueryStore'],

    models: ['GestionarPlaza.ArchivoPlazaQueryModel'],

    views: ['GestionarPlaza.ArchivoPlazaQueryEdit', 'GestionarPlaza.ArchivoPlazaQueryList'],

    refs: [
    	{
            ref: 'ArchivoPlazaQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'ArchivoPlazaQueryList',
            selector: 'ArchivoPlazaQueryList'
        }
    ],

    init: function() {
        this.control({
            'ArchivoPlazaQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'ArchivoPlazaQueryList button[action=add]': {
            	click: this.editRecord
            },
            'ArchivoPlazaQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'ArchivoPlazaQueryEdit button[action=save]': {
                click: this.updateRecord
            },
            'ArchivoPlazaQueryList button[action=download]': {
            	click: this.downloadFile
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarPlaza.ArchivoPlazaQueryEdit').show();
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
        var store = Ext.getStore('GestionarPlaza.ArchivoPlazaQueryStore');
        
        var srl_id_etapa_proceso_seleccion = form.getForm().findField('srl_id_etapa_proceso_seleccion');
        values.var_nombre_etapa = srl_id_etapa_proceso_seleccion.getRawValue();
        
        var srl_id_conv_area_org_etapa = form.getForm().findField('srl_id_conv_area_org_etapa');
        values.var_descrip_subetapa = srl_id_conv_area_org_etapa.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarPlaza.ArchivoPlazaQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    var sync = function(){
	                    store.sync({
	                        success: function (batch, eOpts) {
	                            store.load({params: {srl_id_conv_area_org: null}});
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
	                        success: function(fp, o) {
	        	        		sync();
	                        },
	                        failure: function (fp, o){

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
	            }
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getArchivoPlazaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPlaza.ArchivoPlazaQueryStore');
    	
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
    downloadFile: function(button) {
    	
    	var grid = this.getArchivoPlazaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPlaza.ArchivoPlazaQueryStore');
    	
    	if(record.length > 0){
    		window.open('download-file-plaza.action?srl_id_archivo='+record[0].data.srl_id_archivo, '_blank');
    	}

    }
    
});