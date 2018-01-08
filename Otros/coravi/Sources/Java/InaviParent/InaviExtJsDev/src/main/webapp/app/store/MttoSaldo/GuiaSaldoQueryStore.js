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
* @since   17/03/2016 17:12:09
*/
Ext.define('MyApp.store.MttoSaldo.GuiaSaldoQueryStore', {
    extend: 'Ext.data.Store',
    model: 'MyApp.model.MttoSaldo.GuiaSaldoQueryModel',
    autoLoad: false,
    pageSize: 10,
    limit:10,
    proxy: {
        type: 'ajax',
        api: {
        	read : '/InaviWSRestApp/api/MttoSaldo/listGuiaSaldoQuery',
            create : '/InaviWSRestApp/api/MttoSaldo/createGuiaSaldoQuery',
            update: '/InaviWSRestApp/api/MttoSaldo/updateGuiaSaldoQuery',
            destroy: '/InaviWSRestApp/api/MttoSaldo/destroyGuiaSaldoQuery'
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