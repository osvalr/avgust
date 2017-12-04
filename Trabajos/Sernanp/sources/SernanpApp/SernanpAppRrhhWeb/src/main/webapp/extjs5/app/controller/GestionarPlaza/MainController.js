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

Ext.define('MyApp.controller.GestionarPlaza.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPlaza.MainStore'],

    models: ['GestionarPlaza.MainModel'],

    views: ['GestionarPlaza.Edit', 'GestionarPlaza.List', 'GestionarPlaza.ListAlterno'],

    refs: [
    	{
            ref: 'GestionarPlazaPanel',
            selector: 'panel'
        },
        {
            ref: 'GestionarPlazaList',
            selector: 'GestionarPlazaList'
        }
    ],

    init: function() {
    
        Ext.getStore('GestionarPlaza.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'GestionarPlazaList dataview': {
                itemdblclick: this.editRecord
            },
            'GestionarPlazaList button[action=add]': {
            	click: this.editRecord
            },
            'GestionarPlazaList button[action=delete]': {
                click: this.deleteRecord
            },
            'GestionarPlazaEdit button[action=save]': {
                click: this.updateRecord
            },
            'GestionarPlazaList button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarPlazaList button[action=clearFilter]': {
                click: this.resetForm
            },
            
            'GestionarPlazaList combobox': {
                change: this.refreshGrid
            },
            'GestionarPlazaList textfield': {
            	specialkey: this.onKeyEnter
            },
            'GestionarPlazaListAlterno button[action=filter]': {
                click: this.refreshGrid
            },
            'GestionarPlazaListAlterno button[action=clearFilter]': {
                click: this.resetForm
            },
            
            'GestionarPlazaListAlterno combobox': {
                change: this.refreshGrid
            },
            'GestionarPlazaListAlterno textfield': {
            	specialkey: this.onKeyEnter
            }
           
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarPlaza.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_SubEtapaPlazaQuery = Ext.getCmp('subModel_SubEtapaPlazaQuery');
        	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
        	
        	var subModel_PostulantePlazaQuery = Ext.getCmp('subModel_PostulantePlazaQuery');
        	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
        	
        	var subModel_ArchivoPlazaQuery = Ext.getCmp('subModel_ArchivoPlazaQuery');
        	var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
        	
			subModel_SubEtapaPlazaQuery.store.reload({
				params: {srl_id_conv_area_org: srl_id_conv_area_org.getValue(), start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_PostulantePlazaQuery.store.reload({
							params: {srl_id_conv_area_org: srl_id_conv_area_org.getValue(), start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									subModel_ArchivoPlazaQuery.store.reload({params: {srl_id_conv_area_org: srl_id_conv_area_org.getValue(), start:0, limit:10}});
								}
							}
						});

					}
				}
			});

			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_SubEtapaPlazaQuery = Ext.getCmp('subModel_SubEtapaPlazaQuery');
        	var subModel_PostulantePlazaQuery = Ext.getCmp('subModel_PostulantePlazaQuery');
        	var subModel_ArchivoPlazaQuery = Ext.getCmp('subModel_ArchivoPlazaQuery');
			subModel_SubEtapaPlazaQuery.store.reload({
				params: {srl_id_conv_area_org: -1, start:0, limit:10},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_PostulantePlazaQuery.store.reload({
							params: {srl_id_conv_area_org: -1, start:0, limit:10},
							scope: this,
							callback: function(records, operation, success) {
								if (success) {
									subModel_ArchivoPlazaQuery.store.reload({params: {srl_id_conv_area_org: -1, start:0, limit:10}});
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
        var store = Ext.getStore('GestionarPlaza.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_conv_area_org > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.GestionarPlaza.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_GestionarPlaza_statusbar');
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
    	
    	var grid = this.getGestionarPlazaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPlaza.MainStore');
    	
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
   
    refreshGrid: function() {
    	var store = Ext.getStore('GestionarPlaza.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('GestionarPlaza.MainStore');
        var form = Ext.getCmp('form_filter_GestionarPlaza');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('GestionarPlaza.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('GestionarPlaza.MainStore');
        var form = Ext.getCmp('form_filter_GestionarPlaza');
        var values = form.getValues();
        
        if (typeof idpersonal !== "undefined") {
        	values.idpersonal = idpersonal;
        }
        
    	store.getProxy().extraParams = values;
    }
    
});