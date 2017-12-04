/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 20/12/2014 14:30:15
* VERSION : 1.0 
*/

Ext.define('MyApp.store.GestionarPersonaNatural.InformacionEclesiasticaQueryStore', {
    extend: 'Ext.data.Store',
    model: 'MyApp.model.GestionarPersonaNatural.InformacionEclesiasticaQueryModel',
    autoLoad: false,
    pageSize: 10,
    limit:10,
    proxy: {
        type: 'ajax',
        api: {
        	read : 'InformacionEclesiasticaQueryList.action',
            create : 'InformacionEclesiasticaQueryAdd.action',
            update: 'InformacionEclesiasticaQueryUpdate.action',
            destroy: 'InformacionEclesiasticaQueryDelete.action'
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