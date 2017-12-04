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
* DATE CREATE : 07/04/2015 14:31:08
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionaNomina.DescuentosNominaConceptoQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionaNomina.DescuentosNominaConceptoQueryStore'],

    models: ['GestionaNomina.DescuentosNominaConceptoQueryModel'],

    views: ['GestionaNomina.DescuentosNominaConceptoQueryEdit', 'GestionaNomina.DescuentosNominaConceptoQueryList'],

    refs: [
    	{
            ref: 'DescuentosNominaConceptoQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'DescuentosNominaConceptoQueryList',
            selector: 'DescuentosNominaConceptoQueryList'
        }
    ],

    init: function() {
        this.control({
            'DescuentosNominaConceptoQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'DescuentosNominaConceptoQueryList button[action=add]': {
            	click: this.editRecord
            },
            'DescuentosNominaConceptoQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'DescuentosNominaConceptoQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {    
    	
    	/*ADD 16-02-2016 DAVID */
    	
    	var grid = this.getDescuentosNominaConceptoQueryList();
    	var record1 = grid.getSelectionModel().getSelection(); 
        
        var srl_id_concepto_planilla = record1[0].data.srl_id_concepto_planilla;        
        
        //Solo podra editar / agregar cuando sea el concepto Quinta Categoría
        
        if(srl_id_concepto_planilla == 8 ){
            var edit = Ext.create('MyApp.view.GestionaNomina.DescuentosNominaConceptoQueryEdit').show();
            var form = edit.down('form');
            
            int_id_tipo_concepto = form.getForm().findField('int_id_tipo_concepto');
            int_id_tipo_concepto.setValue(2);
            
            if(record.data){
            	edit.down('form').loadRecord(record);
            	edit.setTitle('Editar');
            }else{
            	edit.setTitle('Agregar');
            	
            	var int_id_estado = form.getForm().findField('int_id_estado');
            	int_id_estado.setReadOnly(true);
            	int_id_estado.setValue(1);
            	
            }
        }
        
        
//        var edit = Ext.create('MyApp.view.GestionaNomina.DescuentosNominaConceptoQueryEdit').show();
//        var form = edit.down('form');
//        
//        int_id_tipo_concepto = form.getForm().findField('int_id_tipo_concepto');
//        int_id_tipo_concepto.setValue(2);
//        
//        if(record.data){
//        	edit.down('form').loadRecord(record);
//        	edit.setTitle('Editar');
//        }else{
//        	edit.setTitle('Agregar');
//        	
//        	var int_id_estado = form.getForm().findField('int_id_estado');
//        	int_id_estado.setReadOnly(true);
//        	int_id_estado.setValue(1);
//        	
//        }
//        END DAVID

    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionaNomina.DescuentosNominaConceptoQueryStore');
        
        var srl_id_concepto_planilla = form.getForm().findField('srl_id_concepto_planilla');
        values.var_descrip_corto_concepto = srl_id_concepto_planilla.getRawValue();
        
        var int_id_estado = form.getForm().findField('int_id_estado');
        values.descrip_estado = int_id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionaNomina.DescuentosNominaConceptoQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {srl_id_nomina_anio_periodo_personal: null}});
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
    	
    	var grid = this.getDescuentosNominaConceptoQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionaNomina.DescuentosNominaConceptoQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {srl_id_nomina_anio_periodo_personal: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});