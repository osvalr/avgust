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
* DATE CREATE : 17/04/2015 16:51:57
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarResponsablePlaza.ResponsablePlazaQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarResponsablePlaza.ResponsablePlazaQueryStore'],

    models: ['GestionarResponsablePlaza.ResponsablePlazaQueryModel'],

    views: ['GestionarResponsablePlaza.ResponsablePlazaQueryEdit', 'GestionarResponsablePlaza.ResponsablePlazaQueryList'],

    refs: [
    	{
            ref: 'ResponsablePlazaQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'ResponsablePlazaQueryList',
            selector: 'ResponsablePlazaQueryList'
        }
    ],

    init: function() {
        this.control({
//            'ResponsablePlazaQueryList dataview': {
//                itemdblclick: this.editRecord
//            },
            'ResponsablePlazaQueryList button[action=add]': {
            	click: this.editRecord
            },
            'ResponsablePlazaQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'ResponsablePlazaQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarResponsablePlaza.ResponsablePlazaQueryEdit').show();
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
        var store = Ext.getStore('GestionarResponsablePlaza.ResponsablePlazaQueryStore');
        
        var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
        values.var_codigo_postulacion = srl_id_conv_area_org.getRawValue();
        
        var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
        values.var_num_convocatoria = srl_id_convocatoria.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarResponsablePlaza.ResponsablePlazaQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {idpersonal: null}});
                            win.close();
                        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
	        	        }
                    });
	            }
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getResponsablePlazaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarResponsablePlaza.ResponsablePlazaQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {idpersonal: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});