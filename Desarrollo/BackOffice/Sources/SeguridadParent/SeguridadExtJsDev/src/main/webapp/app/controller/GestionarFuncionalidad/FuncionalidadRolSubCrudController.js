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
* @since   28/02/2016 02:49:06
*/

Ext.define('MyApp.controller.GestionarFuncionalidad.FuncionalidadRolSubCrudController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarFuncionalidad.FuncionalidadRolSubCrudStore'],

    models: ['GestionarFuncionalidad.FuncionalidadRolSubCrudModel'],

    views: ['GestionarFuncionalidad.FuncionalidadRolSubCrudEdit', 'GestionarFuncionalidad.FuncionalidadRolSubCrudList'],

    refs: [
    	{
            ref: 'FuncionalidadRolSubCrudPanel',
            selector: 'panel'
        },
        {
            ref: 'FuncionalidadRolSubCrudList',
            selector: 'FuncionalidadRolSubCrudList'
        }
    ],

    init: function() {
        this.control({
            'FuncionalidadRolSubCrudList dataview': {
                itemdblclick: this.editRecord
            },
            'FuncionalidadRolSubCrudList button[action=add]': {
            	click: this.editRecord
            },
            'FuncionalidadRolSubCrudList button[action=delete]': {
                click: this.deleteRecord
            },
            'FuncionalidadRolSubCrudEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarFuncionalidad.FuncionalidadRolSubCrudEdit').show();
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
        var store = Ext.getStore('GestionarFuncionalidad.FuncionalidadRolSubCrudStore');
        
        var id_aplicacion = form.getForm().findField('id_aplicacion');
        values.nombre_aplicacion = id_aplicacion.getRawValue();
        
        var id_rol = form.getForm().findField('id_rol');
        values.nombre_rol = id_rol.getRawValue();
        
        var id_estado = form.getForm().findField('id_estado');
        values.descrip_estado = id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarFuncionalidad.FuncionalidadRolSubCrudModel');
                        record.set(values);
                        store.add(record);
                    }

                    win.close();	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {id_funcionalidad: null}});
                        }
                    });
	            }
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getFuncionalidadRolSubCrudList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarFuncionalidad.FuncionalidadRolSubCrudStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {id_funcionalidad: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});