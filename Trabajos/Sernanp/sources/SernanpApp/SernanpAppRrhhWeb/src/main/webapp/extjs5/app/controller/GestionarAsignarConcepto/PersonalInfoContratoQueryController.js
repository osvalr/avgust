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

Ext.define('MyApp.controller.GestionarAsignarConcepto.PersonalInfoContratoQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarAsignarConcepto.PersonalInfoContratoQueryStore'],

    models: ['GestionarAsignarConcepto.PersonalInfoContratoQueryModel'],

    views: ['GestionarAsignarConcepto.PersonalInfoContratoQueryEdit','GestionarAsignarConcepto.PersonalInfoContratoQueryList'],

    refs: [
    	{
            ref: 'PersonalInfoContratoQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'PersonalInfoContratoQueryList',
            selector: 'PersonalInfoContratoQueryList'
        }
    ],

    init: function() {
        this.control({
            'PersonalInfoContratoQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'PersonalInfoContratoQueryList button[action=showAdendas]': {
            	click: this.selectContrato
            },
            'PersonalInfoContratoQueryList button[action=add]': {
//            	click: this.editRecord
            },
            'PersonalInfoContratoQueryList button[action=delete]': {
//                click: this.deleteRecord
            },
            'PersonalInfoContratoQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarAsignarConcepto.PersonalInfoContratoQueryEdit').show();
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
        var store = Ext.getStore('GestionarAsignarConcepto.PersonalInfoContratoQueryStore');
        
      
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarAsignarConcepto.PersonalInfoContratoQueryModel');
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
    	
//    	var grid = this.getPersonalInfoContratoQueryList();
//    	var record = grid.getSelectionModel().getSelection(); 
//    	var store = Ext.getStore('GestionarAsignarConcepto.PersonalInfoContratoQueryStore');
//    	
//    	if(record.length > 0){
//	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
//	                if (btn == 'yes') {
//	             	   store.remove(record);
//						store.sync({
//					        success: function (batch, eOpts) {
//					            store.load({params: {idpersonal: null}});
//					        }
//					    });
//	                }
//	        });
//    	}

    },
    
    selectContrato: function(){
    	
    	var grid = this.getPersonalInfoContratoQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	
    	if(record.length > 0){
    		
    		var subModel_PersonalInfoAdendasPorContratoQuery = Ext.getCmp('subModel_PersonalInfoAdendasPorContratoQuery');
    		var srl_id_contrato_padre = record[0].data.srl_id_contrato;
    		subModel_PersonalInfoAdendasPorContratoQuery.store.reload({params: {'srl_id_contrato_padre': srl_id_contrato_padre, start:0, limit:20}})

    	}	
    	
    	    	
    }
    
});