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
* DATE CREATE : 23/03/2015 00:00:56
* VERSION : 1.0 
*/

Ext.define('MyApp.store.GestionarParametroPlanilla.MainStore', {
    extend: 'Ext.data.Store',
    model: 'MyApp.model.GestionarParametroPlanilla.MainModel',
//  autoLoad: true,
    remoteSort:true,
//  remoteFilter:true,
    pageSize: 20,
//  autoLoad: {start: 0, limit: 20},
    
    proxy: {
        type: 'ajax',
        api: {
        	read : 'GestionarParametroPlanillaView.action',
            create : 'GestionarParametroPlanillaCreate.action',
            update: 'GestionarParametroPlanillaSave.action',
            destroy: 'GestionarParametroPlanillaRemove.action'
        },
        reader: {
            type: 'json',
            rootProperty: 'extjsReturn.data',
            successProperty: 'extjsReturn.success',
            totalProperty: 'extjsReturn.total',
            messageProperty: 'extjsReturn.message'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false,
            rootProperty: 'gestionarParametroPlanillaQuery'
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