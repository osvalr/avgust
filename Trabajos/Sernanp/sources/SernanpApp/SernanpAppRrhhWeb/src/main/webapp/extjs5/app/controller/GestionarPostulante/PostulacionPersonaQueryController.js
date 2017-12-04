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

Ext.define('MyApp.controller.GestionarPostulante.PostulacionPersonaQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPostulante.PostulacionPersonaQueryStore'],

    models: ['GestionarPostulante.PostulacionPersonaQueryModel'],

    views: ['GestionarPostulante.PostulacionPersonaQueryEdit', 'GestionarPostulante.PostulacionPersonaQueryList'],

    refs: [
    	{
            ref: 'PostulacionPersonaQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'PostulacionPersonaQueryList',
            selector: 'PostulacionPersonaQueryList'
        }
    ],

    init: function() {
        this.control({
            'PostulacionPersonaQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'PostulacionPersonaQueryList button[action=add]': {
            	click: this.editRecord
            },
            'PostulacionPersonaQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'PostulacionPersonaQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
    	
    		if(record.data){
            	
            	var int_id_estado = record.data.int_id_estado;
            	
            	if(int_id_estado == 1){
            		var edit = Ext.create('MyApp.view.GestionarPostulante.PostulacionPersonaQueryEdit').show();
            		edit.down('form').loadRecord(record);
                	edit.setTitle('Editar');	
            	}
            	
            }else{
            	var edit = Ext.create('MyApp.view.GestionarPostulante.PostulacionPersonaQueryEdit').show();
            	edit.setTitle('Agregar');
            }
    	
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarPostulante.PostulacionPersonaQueryStore');
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.var_nombre_estado = int_id_estado.getRawValue();
        
        var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
        values.var_num_convocatoria = srl_id_convocatoria.getRawValue();
        
        var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
        values.var_codigo_postulacion = srl_id_conv_area_org.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarPostulante.PostulacionPersonaQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    var sync = function(){
                    	store.sync({
                            success: function (batch, eOpts) {
                                store.load({params: {int_id_postulante: null}});
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
    	
    	var grid = this.getPostulacionPersonaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPostulante.PostulacionPersonaQueryStore');
    	
    	if(record.length > 0){
    		
    		var int_id_estado = record[0].data.int_id_estado;
        	
        	if(int_id_estado == 1){
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
    		
	        
    	}

    }
    
});