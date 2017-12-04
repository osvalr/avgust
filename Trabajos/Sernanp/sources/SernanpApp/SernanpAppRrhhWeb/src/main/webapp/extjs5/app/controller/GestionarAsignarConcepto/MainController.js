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

Ext.define('MyApp.controller.GestionarAsignarConcepto.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarAsignarConcepto.MainStore'],

    models: ['GestionarAsignarConcepto.MainModel'],

    views: ['GestionarAsignarConcepto.Edit', 'GestionarAsignarConcepto.List'],

    refs: [
    	{
            ref: 'GestionarAsignarConceptoPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarAsignarConceptoList',
            selector: 'GestionarAsignarConceptoList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarAsignarConcepto.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarAsignarConceptoList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarAsignarConceptoList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarAsignarConceptoList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarAsignarConceptoEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarAsignarConceptoList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarAsignarConceptoList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarAsignarConceptoList button[action=showGenerarReportePersonal]': {
                click: this.showGenerarReportePersonal
            },
            'GestionarAsignarConceptoEditGenerarReportePersonal button[action=generarReportePersonal]': {
                click: this.generarReportePersonal
            },
                        
            'GestionarAsignarConceptoList combobox': {
                change: this.refreshGrid
            },
            'GestionarAsignarConceptoList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarAsignarConcepto.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_ConceptoPersonalQuery = Ext.getCmp('subModel_ConceptoPersonalQuery');
        	var idpersonal = form.getForm().findField('idpersonal');
        	
        	var subModel_PersonalConceptoFrecuenciaQuery = Ext.getCmp('subModel_PersonalConceptoFrecuenciaQuery');
        	var srl_id_personal_concepto = form.getForm().findField('srl_id_personal_concepto');
        	
        	var subModel_SuspensionCuartaCategoriaQuery = Ext.getCmp('subModel_SuspensionCuartaCategoriaQuery');
//        	var idpersonal = form.getForm().findField('idpersonal');
        	
        	var subModel_BeneficiarioDescuentoJudicialQuery = Ext.getCmp('subModel_BeneficiarioDescuentoJudicialQuery');
//        	var idpersonal = form.getForm().findField('idpersonal');
        	
        	var subModel_PersonalInfoContratoQuery = Ext.getCmp('subModel_PersonalInfoContratoQuery');
        	
        	var subModel_PersonalInfoFormacionQuery = Ext.getCmp('subModel_PersonalInfoFormacionQuery');
        	
			subModel_ConceptoPersonalQuery.store.reload({
				params: {idpersonal: idpersonal.getValue(), start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_SuspensionCuartaCategoriaQuery.store.reload({
							params: {idpersonal: idpersonal.getValue(), start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									subModel_BeneficiarioDescuentoJudicialQuery.store.reload({
										params: {idpersonal: idpersonal.getValue(), start:0, limit:10},
										scope: this,
										callback: function(records, operation, success) {
											subModel_PersonalInfoContratoQuery.store.reload({
												params: {idpersonal: idpersonal.getValue(), start:0, limit:20},
												scope: this,
												callback: function(records, operation, success) {
													subModel_PersonalInfoFormacionQuery.store.reload({params: {idpersonal: idpersonal.getValue(), start:0, limit:20}})
													var subModel_PersonalInfoAdendasPorContratoQuery = Ext.getCmp('subModel_PersonalInfoAdendasPorContratoQuery');
													subModel_PersonalInfoAdendasPorContratoQuery.store.removeAll();
												}
												
											});
										}
									
									});
								}
							}
						});
					}
				}
			});

			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_ConceptoPersonalQuery = Ext.getCmp('subModel_ConceptoPersonalQuery');
        	var subModel_PersonalConceptoFrecuenciaQuery = Ext.getCmp('subModel_PersonalConceptoFrecuenciaQuery');
        	var subModel_SuspensionCuartaCategoriaQuery = Ext.getCmp('subModel_SuspensionCuartaCategoriaQuery');
        	var subModel_BeneficiarioDescuentoJudicialQuery = Ext.getCmp('subModel_BeneficiarioDescuentoJudicialQuery');
			subModel_ConceptoPersonalQuery.store.reload({
				params: {idpersonal: -1, start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_SuspensionCuartaCategoriaQuery.store.reload({
							params: {idpersonal: -1, start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									subModel_BeneficiarioDescuentoJudicialQuery.store.reload({params: {idpersonal: -1, start:0, limit:10}});
								}
							}
						});
					}
				}
			});

        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarAsignarConcepto.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarAsignarConcepto.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarAsignarConcepto_statusbar');
	        		sb.showBusy('Grabando...');
	        		win.getEl().mask();
                    
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	store.load();
				        	win.close();
	        	        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
                            sb.setStatus({text:'Error intentado grabar.'});
				        	win.getEl().unmask();
	        	        }
	        	    });
	            }
	        });
		}

    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarAsignarConceptoList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarAsignarConcepto.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        }
					    });
	                }
	        });
    	}

    },
    
    showGenerarReportePersonal: function(button) {
    	Ext.create('MyApp.view.GestionarAsignarConcepto.EditGenerarReportePersonal').show();
    },
    
    generarReportePersonal : function(button){
    	var win = button.up('window');
        var form = win.down('form');
        
        var int_estado = form.getForm().findField('int_estado');
        
        var parametros = {
        		"int_estado" : int_estado.getValue()
        };
        
//        $('.loading').show();
        
        window.location.href = 'listar-resumen-altas-bajas.action?int_estado=' + int_estado.getValue();
        
//	    $.ajax({
//	        type		: 'HEAD',
//	        data		: parametros,
//	        url			: 'listar-resumen-altas-bajas.action',
//	        complete	: function () {
//	            $('.loading').hide();
//	        }
//
//	    });         	
//	        
//	    console.log(int_estado.getValue());
        
//		return false;	

        
//        window.open('listar-resumen-altas-bajas.action?int_estado=' + int_estado.getValue(),'_blank');
        
        
    },
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarAsignarConcepto.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarAsignarConcepto.MainStore');
        var form = Ext.getCmp('form_filter_GestionarAsignarConcepto');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarAsignarConcepto.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarAsignarConcepto.MainStore');
        var form = Ext.getCmp('form_filter_GestionarAsignarConcepto');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});