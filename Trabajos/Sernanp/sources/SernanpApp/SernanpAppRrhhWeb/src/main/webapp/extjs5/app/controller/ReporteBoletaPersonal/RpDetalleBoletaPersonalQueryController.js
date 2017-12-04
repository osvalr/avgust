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
* DATE CREATE : 17/05/2015 23:55:33
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryStore'],

    models: ['ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryModel'],

    views: ['ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryEdit', 'ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryList'],

    refs: [
    	{
            ref: 'RpDetalleBoletaPersonalQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'RpDetalleBoletaPersonalQueryList',
            selector: 'RpDetalleBoletaPersonalQueryList'
        }
    ],

    init: function() {
        this.control({
            'RpDetalleBoletaPersonalQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'RpDetalleBoletaPersonalQueryList button[action=add]': {
            	click: this.editRecord
            },
            'RpDetalleBoletaPersonalQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'RpDetalleBoletaPersonalQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryEdit').show();
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
        var store = Ext.getStore('ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryStore');
        
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
                
                    if(win.title === 'Editar') {
                        record.set(values);
                    } else{
                        record = Ext.create('MyApp.model.ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryModel');
                        record.set(values);
                        store.add(record);
                    }
                    	
                    store.sync({
                        success: function (batch, eOpts) {
                            store.load({params: {srl_id_nomina_anio_periodo_personal: null}});
                            win.close();
                        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
	        	        }
                    });
	            }
	            
	     });
        
        }
    },
    deleteRecord: function(button) {
    	
    	var grid = this.getRpDetalleBoletaPersonalQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteBoletaPersonal.RpDetalleBoletaPersonalQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {srl_id_nomina_anio_periodo_personal: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});