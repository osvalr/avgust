/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 20/12/2014 14:30:15
* VERSION : 1.0 
*/

var editPhoto = null;

Ext.define('MyApp.controller.GestionarPersonaNatural.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPersonaNatural.MainStore'],

    models: ['GestionarPersonaNatural.MainModel'],

    views: ['GestionarPersonaNatural.Edit', 'GestionarPersonaNatural.EditPhoto', 'GestionarPersonaNatural.List'],

    refs: [
    	{
            ref: 'GestionarPersonaNaturalPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarPersonaNaturalList',
            selector: 'GestionarPersonaNaturalList'
        }
    ],

    init: function() {
        this.control({
            'GestionarPersonaNaturalList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarPersonaNaturalList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarPersonaNaturalList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarPersonaNaturalEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarPersonaNaturalList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarPersonaNaturalList button[action=clearFilter]': {
                click: this.resetForm
            },
            'GestionarPersonaNaturalList combobox': {
                change: this.refreshGrid
            },
            'GestionarPersonaNaturalList textfield': {
            	specialkey: this.onKeyEnter
            },
            'GestionarPersonaNaturalEdit button[action=editPhoto]': {
                click: this.editPhoto
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarPersonaNatural.Edit').show();

        if(editPhoto != null){
        	editPhoto.close();
        }
        editPhoto = Ext.create('MyApp.view.GestionarPersonaNatural.EditPhoto');
        
        var form = edit.down('form');
        var photo_persona = Ext.getCmp('photo_persona');
        
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	// Start JRaffo 28/12/2014
        	var id_archivo = record.data.id_archivo;
        	
        	if(id_archivo != 0){
        		Ext.onReady(function() {
                    Ext.Ajax.request({
                        method: 'GET',
                        url: 'downloadImageBase64.action',
                        params: { 'id_archivo' : id_archivo },
                        success: function( result, request ){
                        	 photo_persona.setSrc(result.responseText);
                        }
                    });
                });
        	}else{
        		photo_persona.setSrc("resources/images/man.jpg");
        	}
            // End JRaffo 28/12/2014
            
        	var detailNumeroTelefonicoQuery = Ext.getCmp('detailNumeroTelefonicoQuery');
        	var id_persona = form.getForm().findField('id_persona');
        	
        	var detailInformacionAcademicaQuery = Ext.getCmp('detailInformacionAcademicaQuery');
        	var id_persona_natural = form.getForm().findField('id_persona_natural');
        	
        	var detailInformacionLaboralQuery = Ext.getCmp('detailInformacionLaboralQuery');
        	var id_persona_natural = form.getForm().findField('id_persona_natural');
        	
        	var detailInformacionEclesiasticaQuery = Ext.getCmp('detailInformacionEclesiasticaQuery');
        	var id_persona_natural = form.getForm().findField('id_persona_natural');
        	
        	var detailPersonaNaturalParentescoQuery = Ext.getCmp('detailPersonaNaturalParentescoQuery');
        	var id_persona_natural = form.getForm().findField('id_persona_natural');
        	
        	var detailPersonaNaturalRolQuery = Ext.getCmp('detailPersonaNaturalRolQuery');
        	var id_persona_natural = form.getForm().findField('id_persona_natural');
        	
			detailNumeroTelefonicoQuery.store.reload({
				params: {id_persona: id_persona.getValue(), start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						detailInformacionAcademicaQuery.store.reload({
							params: {id_persona_natural: id_persona_natural.getValue(), start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									detailInformacionLaboralQuery.store.reload({
										params: {id_persona_natural: id_persona_natural.getValue(), start:0, limit:10},
										scope: this,
										callback: function(records, operation, success) {
											if (success) {
												detailInformacionEclesiasticaQuery.store.reload({
													params: {id_persona_natural: id_persona_natural.getValue(), start:0, limit:10},
													scope: this,
													callback: function(records, operation, success) {
														if (success) {
															detailPersonaNaturalParentescoQuery.store.reload({
																params: {id_persona_natural: id_persona_natural.getValue(), start:0, limit:10},
																scope: this,
																callback: function(records, operation, success) {
																	if (success) {
																		detailPersonaNaturalRolQuery.store.reload({params: {id_persona_natural: id_persona_natural.getValue(), start:0, limit:10}});
																	}
																}
															});

														}
													}
												});

											}
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
        	
        	photo_persona.setSrc("resources/images/man.jpg");
        	
        	var detailNumeroTelefonicoQuery = Ext.getCmp('detailNumeroTelefonicoQuery');
        	var detailInformacionAcademicaQuery = Ext.getCmp('detailInformacionAcademicaQuery');
        	var detailInformacionLaboralQuery = Ext.getCmp('detailInformacionLaboralQuery');
        	var detailInformacionEclesiasticaQuery = Ext.getCmp('detailInformacionEclesiasticaQuery');
        	var detailPersonaNaturalParentescoQuery = Ext.getCmp('detailPersonaNaturalParentescoQuery');
        	var detailPersonaNaturalRolQuery = Ext.getCmp('detailPersonaNaturalRolQuery');
			detailNumeroTelefonicoQuery.store.reload({
				params: {id_persona: -1, start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						detailInformacionAcademicaQuery.store.reload({
							params: {id_persona_natural: -1, start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									detailInformacionLaboralQuery.store.reload({
										params: {id_persona_natural: -1, start:0, limit:10},
										scope: this,
										callback: function(records, operation, success) {
											if (success) {
												detailInformacionEclesiasticaQuery.store.reload({
													params: {id_persona_natural: -1, start:0, limit:10},
													scope: this,
													callback: function(records, operation, success) {
														if (success) {
															detailPersonaNaturalParentescoQuery.store.reload({
																params: {id_persona_natural: -1, start:0, limit:10},
																scope: this,
																callback: function(records, operation, success) {
																	if (success) {
																		detailPersonaNaturalRolQuery.store.reload({params: {id_persona_natural: -1, start:0, limit:10}});
																	}
																}
															});

														}
													}
												});

											}
										}
									});

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
        var store = Ext.getStore('GestionarPersonaNatural.MainStore');
        
        // Start JRaffo 31/12/2014
        var sync = function(){
    		store.sync({
    	        success: function (batch, eOpts) {
		        	var form = Ext.getCmp('form_filter_GestionarPersonaNatural');
		            var values = form.getValues();
		        	store.load({params:values});
		        	win.close();
    	        },
    	        failure: function (batch, eOpts) {
					store.rejectChanges();
    	        }
    	    });
        };
        // End JRaffo 31/12/2014
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {
	            	
	        		if (values.id_persona > 0){
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarPersonaNatural.MainModel');
	        			record.set(values);
	        			store.add(record);
	        		}
	        		
	        		// Start JRaffo 31/12/2014
	        		var formPhoto = Ext.getCmp('form_photo');
	        		var file = formPhoto.getForm().findField('file');
	                if(file.getValue() !== ""){
	                	
	                	formPhoto.submit({
	                        url: 'fileUpload.action',
	                        waitMsg: 'Subiendo imagen...',
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
	                // End JRaffo 31/12/2014
	          
	            }
	        });
		}

    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getGestionarPersonaNaturalList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPersonaNatural.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	var form = Ext.getCmp('form_filter_GestionarPersonaNatural');
					            var values = form.getValues();
					        	store.load({params:values});
					        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {

    	var store = Ext.getStore('GestionarPersonaNatural.MainStore');
        var form = Ext.getCmp('form_filter_GestionarPersonaNatural');
        var values = form.getValues();

    	store.load({params:values});

    },
    resetForm: function() {
    	
    	var store = Ext.getStore('GestionarPersonaNatural.MainStore');
        var form = Ext.getCmp('form_filter_GestionarPersonaNatural');
        form.reset();
        var values = form.getValues();

    	store.load({params:values});

    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarPersonaNatural.MainStore');
            var form = Ext.getCmp('form_filter_GestionarPersonaNatural');
            var values = form.getValues();

        	store.load({params:values});
        }
    },
    editPhoto: function() {
    	editPhoto.show();
    }
    
});