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
Ext.define('MyApp.store.GestionarDocFactura.DocumentoFacturaDetalleQueryStore', {
    extend: 'Ext.data.Store',
    model: 'MyApp.model.GestionarDocFactura.DocumentoFacturaDetalleQueryModel',
    autoLoad: false,
    pageSize: 10,
    limit:10,
    proxy: {
        type: 'ajax',
        api: {
        	read : '/InaviWSRestApp/api/GestionarDocFactura/listDocumentoFacturaDetalleQuery',
            create : '/InaviWSRestApp/api/GestionarDocFactura/createDocumentoFacturaDetalleQuery',
            update: '/InaviWSRestApp/api/GestionarDocFactura/updateDocumentoFacturaDetalleQuery',
            destroy: '/InaviWSRestApp/api/GestionarDocFactura/destroyDocumentoFacturaDetalleQuery'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success',
            totalProperty: 'total',
            messageProperty: 'message'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false,
            rootProperty: 'data'
        },
        listeners: {
            exception: function(proxy, response, operation){	
                Ext.MessageBox.show({
                    title: 'REMOTE EXCEPTION',
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
    }
});