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
* @since   26/02/2016 21:33:30
*/
Ext.define('MyApp.store.GestionarUsuario.UsuarioPerfilSubCrudStore', {
    extend: 'Ext.data.Store',
    model: 'MyApp.model.GestionarUsuario.UsuarioPerfilSubCrudModel',
    autoLoad: false,
    pageSize: 10,
    limit:10,
    proxy: {
        type: 'ajax',
        api: {
        	read : '/SeguridadWSRestApp/api/GestionarUsuario/listUsuarioPerfilSubCrud',
            create : '/SeguridadWSRestApp/api/GestionarUsuario/createUsuarioPerfilSubCrud',
            update: '/SeguridadWSRestApp/api/GestionarUsuario/updateUsuarioPerfilSubCrud',
            destroy: '/SeguridadWSRestApp/api/GestionarUsuario/destroyUsuarioPerfilSubCrud'
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