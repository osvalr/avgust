/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by GeneratorCrud v.1.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 20:14:59
*/
Ext.define('MyApp.store.GestionarRol.MainStore', {
    extend: 'Ext.data.Store',
    model: 'MyApp.model.GestionarRol.MainModel',
//  autoLoad: true,
	remoteSort:true,
//  remoteFilter:true,
    pageSize: 20,
//  autoLoad: {start: 0, limit: 20},
    
    proxy: {
        type: 'ajax',
        api: {
        	read : '/SeguridadWSRestApp/api/GestionarRol/list',
            create : '/SeguridadWSRestApp/api/GestionarRol/create',
            update: '/SeguridadWSRestApp/api/GestionarRol/update',
            destroy: '/SeguridadWSRestApp/api/GestionarRol/destroy'
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