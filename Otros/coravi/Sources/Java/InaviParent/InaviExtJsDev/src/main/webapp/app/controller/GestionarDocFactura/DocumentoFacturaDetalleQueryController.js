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
* @since   14/09/2016 05:45:45
*/

Ext.define('MyApp.controller.GestionarDocFactura.DocumentoFacturaDetalleQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarDocFactura.DocumentoFacturaDetalleQueryStore'],

    models: ['GestionarDocFactura.DocumentoFacturaDetalleQueryModel'],

    views: ['GestionarDocFactura.DocumentoFacturaDetalleQueryEdit', 'GestionarDocFactura.DocumentoFacturaDetalleQueryList'],

    refs: [
    	{
            ref: 'DocumentoFacturaDetalleQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'DocumentoFacturaDetalleQueryList',
            selector: 'DocumentoFacturaDetalleQueryList'
        }
    ],

    init: function() {
        this.control({
            'DocumentoFacturaDetalleQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'DocumentoFacturaDetalleQueryList button[action=add]': {
            	click: this.editRecord
            },
            'DocumentoFacturaDetalleQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'DocumentoFacturaDetalleQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarDocFactura.DocumentoFacturaDetalleQueryEdit').show();
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
        var store = Ext.getStore('GestionarDocFactura.DocumentoFacturaDetalleQueryStore');
        
        var id_estado = form.getForm().findField('id_estado');
        values.descrip_estado = id_estado.getRawValue();
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.GestionarDocFactura.DocumentoFacturaDetalleQueryModel');
                        record.set(values);
                        store.add(record);
                    }

                    win.close();	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {id_documento_venta: null}});
                        }
                    });
	            }
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getDocumentoFacturaDetalleQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarDocFactura.DocumentoFacturaDetalleQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {id_documento_venta: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});