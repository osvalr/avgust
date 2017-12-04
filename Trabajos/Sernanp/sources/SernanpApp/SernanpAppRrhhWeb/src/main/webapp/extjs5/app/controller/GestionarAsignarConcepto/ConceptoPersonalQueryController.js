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
* DATE CREATE : 12/04/2015 20:29:10
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarAsignarConcepto.ConceptoPersonalQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarAsignarConcepto.ConceptoPersonalQueryStore'],

    models: ['GestionarAsignarConcepto.ConceptoPersonalQueryModel'],

    views: ['GestionarAsignarConcepto.ConceptoPersonalQueryEdit', 'GestionarAsignarConcepto.ConceptoPersonalQueryList'],

    refs: [
    	{
            ref: 'ConceptoPersonalQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'ConceptoPersonalQueryList',
            selector: 'ConceptoPersonalQueryList'
        }
    ],

    init: function() {
        this.control({
            'ConceptoPersonalQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'ConceptoPersonalQueryList button[action=add]': {
            	click: this.editRecord
            },
            'ConceptoPersonalQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'ConceptoPersonalQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        
        	
        if(record.data){
        	
        	var int_id_estado = record.data.int_id_estado;
        	
        	if(int_id_estado == 1){
        		var edit = Ext.create('MyApp.view.GestionarAsignarConcepto.ConceptoPersonalQueryEdit').show();
        		var form = edit.down('form');
        		edit.down('form').loadRecord(record);
            	edit.setTitle('Editar');
            	
            	var subModel_PersonalConceptoFrecuenciaQuery = Ext.getCmp('subModel_PersonalConceptoFrecuenciaQuery');
            	var subModel_PersonalConceptoAfectoQuery = Ext.getCmp('subModel_PersonalConceptoAfectoQuery');
            	var srl_id_personal_concepto = form.getForm().findField('srl_id_personal_concepto');
            	
            	subModel_PersonalConceptoFrecuenciaQuery.store.reload({
            			params: {srl_id_personal_concepto: srl_id_personal_concepto.getValue(), start:0, limit:20},
    					scope: this,
    					callback: function(records, operation, success) {
    						if (success) {
    							subModel_PersonalConceptoAfectoQuery.store.reload({params: {srl_id_personal_concepto: srl_id_personal_concepto.getValue(), start:0, limit:20}});
    						}
    					}
            	});
        	}

        }else{
        	
        	var edit = Ext.create('MyApp.view.GestionarAsignarConcepto.ConceptoPersonalQueryEdit').show();
        	var form = edit.down('form');
        	
        	edit.setTitle('Agregar');
        	
        	var subModel_PersonalConceptoFrecuenciaQuery = Ext.getCmp('subModel_PersonalConceptoFrecuenciaQuery');
        	var subModel_PersonalConceptoAfectoQuery = Ext.getCmp('subModel_PersonalConceptoAfectoQuery');
        	
        	subModel_PersonalConceptoFrecuenciaQuery.store.reload({
        			params: {srl_id_personal_concepto: -1, start:0, limit:20},
					scope: this,
					callback: function(records, operation, success) {
						if (success) {
							subModel_PersonalConceptoAfectoQuery.store.reload({params: {srl_id_personal_concepto: -1, start:0, limit:20}});
						}
					}
        	});
        	
        	
        	
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
        var store = Ext.getStore('GestionarAsignarConcepto.ConceptoPersonalQueryStore');
        
        var int_id_tipo_concepto = form.getForm().findField('int_id_tipo_concepto');
        values.descrip_tipo_concepto = int_id_tipo_concepto.getRawValue();
        
        var int_id_sub_tipo_concepto = form.getForm().findField('int_id_sub_tipo_concepto');
        values.descrip_sub_tipo_concepto = int_id_sub_tipo_concepto.getRawValue();
        
        var srl_id_concepto_planilla = form.getForm().findField('srl_id_concepto_planilla');
        values.var_descrip_corto_concepto = srl_id_concepto_planilla.getRawValue();
        
        var int_id_tipo_monto_concepto = form.getForm().findField('int_id_tipo_monto_concepto');
        values.descrip_tipo_monto = int_id_tipo_monto_concepto.getRawValue();
        
        
        
        var srl_id_beneficiario_descuento_judicial = form.getForm().findField('srl_id_beneficiario_descuento_judicial');
        values.srl_descrip_beneficiario_descuento_judicial = srl_id_beneficiario_descuento_judicial.getRawValue();
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.descrip_estado = int_id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarAsignarConcepto.ConceptoPersonalQueryModel');
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
    	
    	var grid = this.getConceptoPersonalQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarAsignarConcepto.ConceptoPersonalQueryStore');
    	
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