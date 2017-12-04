Ext.define('AcmeWebApp.store.GestionarCotizacion.MainStore', {
    extend: 'Ext.data.Store',
    model: 'AcmeWebApp.model.GestionarCotizacion.MainModel',
//  autoLoad: true,
    remoteSort:true,
//  remoteFilter:true,
    pageSize: 20,
//  autoLoad: {start: 0, limit: 20},
    
    proxy: {
        type: 'ajax',
        api: {
        	read : '/commons/GestionarCotizacion/list',
            create : '/commons/GestionarCotizacion/create',
            update: '/commons/GestionarCotizacion/update',
            destroy: '/commons/GestionarCotizacion/destroy'
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