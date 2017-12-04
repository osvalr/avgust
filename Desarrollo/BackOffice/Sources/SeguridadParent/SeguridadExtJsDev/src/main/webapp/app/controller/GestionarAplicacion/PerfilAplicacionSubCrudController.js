/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 20:07:02
*/

Ext.define('MyApp.controller.GestionarAplicacion.PerfilAplicacionSubCrudController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarAplicacion.PerfilAplicacionSubCrudStore'],

    models: ['GestionarAplicacion.PerfilAplicacionSubCrudModel'],

    views: ['GestionarAplicacion.PerfilAplicacionSubCrudEdit', 'GestionarAplicacion.PerfilAplicacionSubCrudList'],

    refs: [
    	{
            ref: 'PerfilAplicacionSubCrudPanel',
            selector: 'panel'
        },
        {
            ref: 'PerfilAplicacionSubCrudList',
            selector: 'PerfilAplicacionSubCrudList'
        }
    ],

    init: function() {
        this.control({
            'PerfilAplicacionSubCrudList dataview': {
                itemdblclick: this.editRecord
            },
            'PerfilAplicacionSubCrudList button[action=add]': {
            	click: this.editRecord
            },
            'PerfilAplicacionSubCrudList button[action=delete]': {
                click: this.deleteRecord
            },
            'PerfilAplicacionSubCrudEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarAplicacion.PerfilAplicacionSubCrudEdit').show();
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
        var store = Ext.getStore('GestionarAplicacion.PerfilAplicacionSubCrudStore');
        
        var id_perfil = form.getForm().findField('id_perfil');
        values.nombre_perfil = id_perfil.getRawValue();
        
        var id_estado = form.getForm().findField('id_estado');
        values.descrip_estado = id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarAplicacion.PerfilAplicacionSubCrudModel');
                        record.set(values);
                        store.add(record);
                    }

                    win.close();	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {id_aplicacion: null}});
                        }
                    });
	            }
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getPerfilAplicacionSubCrudList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarAplicacion.PerfilAplicacionSubCrudStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {id_aplicacion: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});