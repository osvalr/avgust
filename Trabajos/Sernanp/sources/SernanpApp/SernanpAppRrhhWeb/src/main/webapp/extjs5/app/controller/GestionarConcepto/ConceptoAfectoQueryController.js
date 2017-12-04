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
* DATE CREATE : 03/04/2015 18:33:21
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarConcepto.ConceptoAfectoQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarConcepto.ConceptoAfectoQueryStore'],

    models: ['GestionarConcepto.ConceptoAfectoQueryModel'],

    views: ['GestionarConcepto.ConceptoAfectoQueryEdit', 'GestionarConcepto.ConceptoAfectoQueryList'],

    refs: [
    	{
            ref: 'ConceptoAfectoQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'ConceptoAfectoQueryList',
            selector: 'ConceptoAfectoQueryList'
        }
    ],

    init: function() {
        this.control({
            'ConceptoAfectoQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'ConceptoAfectoQueryList button[action=add]': {
            	click: this.editRecord
            },
            'ConceptoAfectoQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'ConceptoAfectoQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
    	
        var edit = Ext.create('MyApp.view.GestionarConcepto.ConceptoAfectoQueryEdit').show();
        var form = edit.down('form');
        
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        }else{
        	edit.setTitle('Agregar');
        	
        	var int_id_estado = form.getForm().findField('int_id_estado');
        	int_id_estado.setReadOnly(true);
        	int_id_estado.setValue(1);
        	
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarConcepto.ConceptoAfectoQueryStore');
        
        var int_id_tipo_concepto = form.getForm().findField('int_id_tipo_concepto');
        values.descrip_tipo_concepto = int_id_tipo_concepto.getRawValue();
        
        var int_id_sub_tipo_concepto = form.getForm().findField('int_id_sub_tipo_concepto');
        values.descrip_sub_tipo_concepto = int_id_sub_tipo_concepto.getRawValue();
        
        var srl_id_concepto_planilla_afecto = form.getForm().findField('srl_id_concepto_planilla_afecto');
        values.var_descrip_corto_concepto = srl_id_concepto_planilla_afecto.getRawValue();
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.descrip_estado = int_id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarConcepto.ConceptoAfectoQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {srl_id_concepto_planilla: null}});
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
    	
    	var grid = this.getConceptoAfectoQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarConcepto.ConceptoAfectoQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {srl_id_concepto_planilla: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});