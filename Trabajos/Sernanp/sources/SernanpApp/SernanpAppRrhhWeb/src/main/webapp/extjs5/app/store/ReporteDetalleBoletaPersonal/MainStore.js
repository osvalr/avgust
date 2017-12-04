/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpAppTemp.
*
* SernanpAppTemp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpAppTemp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpAppTemp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 02/06/2015 14:00:22
* VERSION : 1.0 
*/

Ext.define('MyApp.store.ReporteDetalleBoletaPersonal.MainStore', {
    extend: 'Ext.data.Store',
    model: 'MyApp.model.ReporteDetalleBoletaPersonal.MainModel',
//    autoLoad: true,
//    remoteSort:true,
//    remoteFilter:true,
	  pageSize: 20,
//    autoLoad: {start: 0, limit: 20},
    
    proxy: {
        type: 'ajax',
        api: {
        	read : 'ReporteDetalleBoletaPersonalView.action',
            create : 'ReporteDetalleBoletaPersonalCreate.action',
            update: 'ReporteDetalleBoletaPersonalSave.action',
            destroy: 'ReporteDetalleBoletaPersonalRemove.action'
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
            rootProperty: 'rpDetalleBoletasPersonalQuery'
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