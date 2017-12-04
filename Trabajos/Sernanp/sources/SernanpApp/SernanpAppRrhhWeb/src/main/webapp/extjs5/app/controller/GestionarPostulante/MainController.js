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

Ext.define('MyApp.controller.GestionarPostulante.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPostulante.MainStore'],

    models: ['GestionarPostulante.MainModel'],

    views: ['GestionarPostulante.Edit', 'GestionarPostulante.List', 'GestionarPostulante.ListAlterno','GestionarPostulante.FindPostulanteWindow'],

    refs: [
    	{
            ref: 'GestionarPostulantePanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarPostulanteList',
            selector: 'GestionarPostulanteList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarPostulante.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarPostulanteList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarPostulanteListAlterno dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarPostulanteList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarPostulanteListAlterno button[action=add]': {
            	click: this.registroNuevo
            },
            'GestionarPostulanteList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarPostulanteEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarPostulanteList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarPostulanteList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarPostulanteList combobox': {
                change: this.refreshGrid
            },
            'GestionarPostulanteList textfield': {
            	specialkey: this.onKeyEnter
            }
            
            // ADD 28-01-2016 DAVID
            /*
            ,
            'GestionarPostulanteList button[action=generarReportePDF]': {
                click: this.reportePostulantesInscritosPDF
            },
            'GestionarPostulanteList button[action=generarReporteXLS]': {
                click: this.reportePostulantesInscritosXLS
            }
            */
            
            ,
            'FindPostulanteWindow button[action=buscarPostulante]': {
                click: this.buscarPostulante
            }
            ,
            
            'GestionarPostulanteList button[action=MostrarEditReportePostulante]': {
            	click: this.MostrarEditReportePostulante
            },
            
            
            'GestionaPostulanteEditReporte button[action=generarReportePostulante]': {
            	click: this.generarReportePostulante
            }
            
            
        });
    },

    editRecord: function(grid, record) {
    	
        var edit = Ext.create('MyApp.view.GestionarPostulante.Edit').show();
//        var form = edit.down('form');
        var form = Ext.getCmp('form_crud_GestionarPostulante');
        
        if(record.data){
//        	edit.down('form').loadRecord(record);
        	form.loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_PostulanteNumeroTelefonoQuery = Ext.getCmp('subModel_PostulanteNumeroTelefonoQuery');
        	var int_id_postulante = form.getForm().findField('int_id_postulante');
        	
        	var subModel_ArchivoPostulanteQuery = Ext.getCmp('subModel_ArchivoPostulanteQuery');
        	var int_id_postulante = form.getForm().findField('int_id_postulante');
        	
        	var subModel_PostulacionPersonaQuery = Ext.getCmp('subModel_PostulacionPersonaQuery');
        	var int_id_postulante = form.getForm().findField('int_id_postulante');
        	
//			subModel_PostulanteNumeroTelefonoQuery.store.reload({
//				params: {int_id_postulante: int_id_postulante.getValue(), start:0, limit:10},
//				scope: this,
//				callback: function(records, operation, success) {
//					if (success) {
						subModel_ArchivoPostulanteQuery.store.reload({
							params: {int_id_postulante: int_id_postulante.getValue(), start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									
									var id = int_id_postulante.getValue();
									
									if(id == ''){
										id = -1;
									}
									
									subModel_PostulacionPersonaQuery.store.reload({params: {int_id_postulante: id, start:0, limit:10}});
								}
							}
						});

//					}
//				}
//			});

			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_PostulanteNumeroTelefonoQuery = Ext.getCmp('subModel_PostulanteNumeroTelefonoQuery');
        	var subModel_ArchivoPostulanteQuery = Ext.getCmp('subModel_ArchivoPostulanteQuery');
        	var subModel_PostulacionPersonaQuery = Ext.getCmp('subModel_PostulacionPersonaQuery');
//			subModel_PostulanteNumeroTelefonoQuery.store.reload({
//				params: {int_id_postulante: -1, start:0, limit:10},
//				scope: this,
//				callback: function(records, operation, success) {
//					if (success) {
						subModel_ArchivoPostulanteQuery.store.reload({
							params: {int_id_postulante: -1, start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									subModel_PostulacionPersonaQuery.store.reload({params: {int_id_postulante: -1, start:0, limit:10}});
								}
							}
						});

//					}
//				}
//			});

        }
    },
    
    registroNuevo: function(grid, record) {
    	
    	var store = Ext.getStore('GestionarPostulante.MainStore');
    	var count = store.getCount();

    	if(count == 0) {
    		var edit = Ext.create('MyApp.view.GestionarPostulante.Edit').show();
            var form = edit.down('form');

//            	edit.setTitle('Agregar');
            	var subModel_PostulanteNumeroTelefonoQuery = Ext.getCmp('subModel_PostulanteNumeroTelefonoQuery');
            	var subModel_ArchivoPostulanteQuery = Ext.getCmp('subModel_ArchivoPostulanteQuery');
            	var subModel_PostulacionPersonaQuery = Ext.getCmp('subModel_PostulacionPersonaQuery');
//    			subModel_PostulanteNumeroTelefonoQuery.store.reload({
//    				params: {int_id_postulante: -1, start:0, limit:10},
//    				scope: this,
//    				callback: function(records, operation, success) {
//    					if (success) {
    						subModel_ArchivoPostulanteQuery.store.reload({
    							params: {int_id_postulante: -1, start:0, limit:10},
    							scope: this,
    							callback: function(records, operation, success) {
    								if (success) {
    									subModel_PostulacionPersonaQuery.store.reload({params: {int_id_postulante: -1, start:0, limit:10}});
    								}
    							}
    						});

//    					}
//    				}
//    			});

            
    	}else{
    		Ext.MessageBox.show({
                title: 'Error',
                msg: "Ya estas registrado.",
                icon: Ext.MessageBox.ERROR,
                buttons: Ext.Msg.OK
            });
    	}
    	
        
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
//        var form = win.down('form');
        var form = Ext.getCmp('form_crud_GestionarPostulante');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarPostulante.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersona > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarPostulante.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarPostulante_statusbar');
	        		sb.showBusy('Grabando...');
	        		win.getEl().mask();
                    
	        		store.sync({
	        	        success: function (batch, eOpts) {
	        	        	
	        	        	if(values.tokenField == 'insert'){
	        	        		idpersonanatural = eOpts.operations.create[0].data.idpersonanatural;
	        	        	}
	        	        	
				        	store.load();
				        	win.close();
	        	        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
                            sb.setStatus({text:'Error intentado grabar.'});
				        	win.getEl().unmask();
	        	        },
	        	        callback: function (records, operation, success) {
	        	        	
	        	            
	        	        }
	        	    });
	            }
	        });
		}

    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarPostulanteList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPostulante.MainStore');
    	
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
    
    
    // ADD 28-01-2016 DAVID
    
    
    reportePostulantesInscritosPDF: function(button){
    	
    	var form = Ext.getCmp('form_filter_GestionarPostulante');
    	var nombre_completo = form.getForm().findField('nombres_completos');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var tipo_reporte = 'pdf';
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
    	var srl_id_sede_req_sel 	= form.getForm().findField('srl_id_sede_req_sel');
//    	var srl_id_sede_uni_ope_anp	= form.getForm().findField('srl_id_sede_uni_ope_anp');
		/*END*/
    	
    	window.open('postulantes-inscritos-pdf.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue()
				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&tipo_reporte=' + tipo_reporte
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
//				+'&srl_id_sede_uni_ope_anp='+srl_id_sede_uni_ope_anp.getValue()
				,'_blank'); 

    },
    
    reportePostulantesInscritosXLS: function(button){
    	
    	var form = Ext.getCmp('form_filter_GestionarPostulante');
    	var nombre_completo = form.getForm().findField('nombres_completos');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
    	var tipo_reporte = 'xls';
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
    	var srl_id_sede_req_sel 	= form.getForm().findField('srl_id_sede_req_sel');
//    	var srl_id_sede_uni_ope_anp	= form.getForm().findField('srl_id_sede_uni_ope_anp');
		/*END*/
    	
    	window.open('postulantes-inscritos-xls.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue()
				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&tipo_reporte=' + tipo_reporte
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
//				+'&srl_id_sede_uni_ope_anp='+srl_id_sede_uni_ope_anp.getValue()
				,'_blank'); 

    },
    
    
    MostrarEditReportePostulante: function(button){
    	Ext.create('MyApp.view.GestionarPostulante.EditPostulanteReporte').show();
    },
    
    
    generarReportePostulante: function(){
    	
        var form_padre = Ext.getCmp('form_filter_GestionarPostulante');
        
        var form_hijo  = Ext.getCmp('form_reporte_postulante');        
    	
    	var nombre_completo 		= form_padre.getForm().findField('nombres_completos');
    	var numerodoc 				= form_padre.getForm().findField('numerodoc');
    	var srl_id_convocatoria 	= form_padre.getForm().findField('srl_id_convocatoria');
    	var srl_id_conv_area_org 	= form_padre.getForm().findField('srl_id_conv_area_org');
    	var srl_id_sede_req_sel 	= form_padre.getForm().findField('srl_id_sede_req_sel');
    	var int_id_estado 			= form_padre.getForm().findField('int_id_estado_postulante');    	
    	var int_id_tipo_factor 		= form_padre.getForm().findField('int_id_tipo_factor');
    	
    	var idTipoReporte 			= form_hijo.getForm().findField('idTipoReporte');
    	var idformato 				= form_hijo.getForm().findField('idformato');
    	
    	
/*
    	window.open('postulantes-inscritos-pdf.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue()
				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() 
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
				,'_blank');
*/
/*
    	window.open('postulantes-contratos.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue() + '&int_id_estado='+ int_id_estado.getValue()
				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() 
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
				,'_blank'); 
*/    	    	
/*
    	window.open('postulantes-ficha-postulacion-pdf.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc=' + numerodoc.getValue()
    			+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue() + '&int_id_tipo_factor=' + int_id_tipo_factor.getValue() 
				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue()
				,'_blank');
    	
  */  	
    	
    	var name_action				= null;
    	var param_add				= '';
    	
        if (form_hijo.isValid()) {
        	
//			var rec  = {idTipoReporte:'1', reporte:'Inscritos'}
//			var rec1 = {idTipoReporte:'2', reporte:'Contrato Suscrito / no Suscrito'}
//			var rec2 = {idTipoReporte:'3', reporte:'Etapas de Evaluación'}
			
			if(idTipoReporte.getValue() == 1){
				
				name_action	= 'postulantes-inscritos';
				param_add	= '';
				
			}else if(idTipoReporte.getValue() == 2){
				
				name_action	= 'postulantes-contratos';				
				param_add	= '&int_id_estado='+ int_id_estado.getValue();
				
			}else if (idTipoReporte.getValue() == 3){
				
				name_action	= 'postulantes-ficha-postulacion';
				param_add	= '&int_id_tipo_factor=' + int_id_tipo_factor.getValue();

			}
			
			
         	if(idformato.getValue() == 1){            	
            	window.open(name_action + '-xls.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue()
        				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue()
        				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue() + param_add
        				,'_blank'); 
         	}else{
         		
            	window.open(name_action + '-pdf.action?nombre_completo=' + nombre_completo.getValue() + '&numerodoc='+ numerodoc.getValue()
        				+ '&srl_id_convocatoria=' + srl_id_convocatoria.getValue() + '&srl_id_conv_area_org=' + srl_id_conv_area_org.getValue()
        				+ '&srl_id_sede_req_sel=' + srl_id_sede_req_sel.getValue() + param_add
        				,'_blank'); 
         	}
         	
        	
         }
    	
    }, 
    
    
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarPostulante.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarPostulante.MainStore');
        var form = Ext.getCmp('form_filter_GestionarPostulante');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarPostulante.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	
//    	console.log('idpersonanatural:');
//    	console.log(idpersonanatural);
    	
    	var store = Ext.getStore('GestionarPostulante.MainStore');
        var form = Ext.getCmp('form_filter_GestionarPostulante');
        var values = form.getValues();
        
        if (typeof idpersonanatural !== "undefined") {
        	values.idpersonanatural = idpersonanatural;
        }
        
    	store.getProxy().extraParams = values;
    },
    buscarPostulante: function() {
    	
    	me = this;
    	
    	var form = Ext.getCmp('form_find_postulante');
    	var win = form.up('window');
    	
    	var idtipodocumento = form.getForm().findField('idtipodocumento');
    	var numerodoc = form.getForm().findField('numerodoc');
    	var fechanacimiento = form.getForm().findField('fechanacimiento');

    	Ext.Ajax.request({
            method: 'GET',
            params: {
            	'idtipodocumento': idtipodocumento.getValue(),
            	'numerodoc': numerodoc.getValue(),
            	'fechanacimiento': fechanacimiento.getRawValue()
            },
            url: 'buscar-postulante-query',
            success: function( result, request ){
            	
            	var json = Ext.JSON.decode(result.responseText);
            	
            	if(json.result != null){
            		idpersonanatural = json.result.idpersonanatural;
            		me.showFormEdit(idtipodocumento,numerodoc,fechanacimiento);
            	}else{
            		idpersonanatural = -1;
            		me.showFormEdit(idtipodocumento,numerodoc,fechanacimiento);
            	}
            	
            	win.close();
            }
        });
    	
    },
    showFormEdit : function (idtipodocumento, numerodoc, fechanacimiento) {
		
			var store = Ext.getStore('GestionarPostulante.MainStore');
				
			store.load({
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
					
				        if(records.length > 0){
				        	
				        	var edit = Ext.create('MyApp.view.GestionarPostulante.Edit').show();
//					        var form = edit.down('form');
				        	var form = Ext.getCmp('form_crud_GestionarPostulante');
				        	
					        if(records[0].data){
					        	
//					        	edit.down('form').loadRecord(records[0]);
					        	form.loadRecord(records[0]);
//					        	edit.setTitle('Editar');
					        	
					        	var int_id_postulante = form.getForm().findField('int_id_postulante');
					        	
					        	var subModel_PostulanteNumeroTelefonoQuery = Ext.getCmp('subModel_PostulanteNumeroTelefonoQuery');
					        	var subModel_ArchivoPostulanteQuery = Ext.getCmp('subModel_ArchivoPostulanteQuery');
					        	var subModel_PostulacionPersonaQuery = Ext.getCmp('subModel_PostulacionPersonaQuery');
					        	
//								subModel_PostulanteNumeroTelefonoQuery.store.reload({
//									params: {int_id_postulante: int_id_postulante.getValue(), start:0, limit:10},
//									scope: this,
//									callback: function(records, operation, success) {
//										if (success) {
											subModel_ArchivoPostulanteQuery.store.reload({
												params: {int_id_postulante: int_id_postulante.getValue(), start:0, limit:10},
												scope: this,
												callback: function(records, operation, success) {
													if (success) {
														
														var id = int_id_postulante.getValue();
														
														if(id == ''){
															id = -1;
														}
														
														subModel_PostulacionPersonaQuery.store.reload({params: {int_id_postulante: id, start:0, limit:10}});
													}
												}
											});
		
//										}
//									}
//								});
					        	
					        }
				        	
				        }else{
				        	
				        	var edit = Ext.create('MyApp.view.GestionarPostulante.Edit').show();
					        var form = Ext.getCmp('form_crud_GestionarPostulante');
				        	
//					        idtipodocumento, numerodoc, fechanacimiento
					        
					        var var_idtipodocumento 		= form.getForm().findField('idtipodocumento');
					    	var var_numerodoc 				= form.getForm().findField('numerodoc');
					    	var var_fechanacimiento 	= form.getForm().findField('fechanacimiento');
					    	
					    	var_idtipodocumento.setValue(idtipodocumento.getValue());
					    	var_numerodoc.setValue(numerodoc.getValue());
					    	var_fechanacimiento.setValue(fechanacimiento.getValue());
					        
				        	var subModel_PostulanteNumeroTelefonoQuery = Ext.getCmp('subModel_PostulanteNumeroTelefonoQuery');
				        	var subModel_ArchivoPostulanteQuery = Ext.getCmp('subModel_ArchivoPostulanteQuery');
				        	var subModel_PostulacionPersonaQuery = Ext.getCmp('subModel_PostulacionPersonaQuery');
//							subModel_PostulanteNumeroTelefonoQuery.store.reload({
//								params: {int_id_postulante: -1, start:0, limit:10},
//								scope: this,
//								callback: function(records, operation, success) {
//									if (success) {
										subModel_ArchivoPostulanteQuery.store.reload({
											params: {int_id_postulante: -1, start:0, limit:10},
											scope: this,
											callback: function(records, operation, success) {
												if (success) {
													subModel_PostulacionPersonaQuery.store.reload({params: {int_id_postulante: -1, start:0, limit:10}});
												}
											}
										});

//									}
//								}
//							});
				        }
				        
					}
				}
			});
    }
});