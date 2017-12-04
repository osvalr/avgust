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

Ext.define('MyApp.controller.ReporteDetalleBoletaPersonal.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ReporteDetalleBoletaPersonal.MainStore'],

    models: ['ReporteDetalleBoletaPersonal.MainModel'],

    views: ['ReporteDetalleBoletaPersonal.Edit', 'ReporteDetalleBoletaPersonal.List'],

    refs: [
    	{
            ref: 'ReporteDetalleBoletaPersonalPanel',
            selector: 'panel'
        },
        {
            ref: 'ReporteDetalleBoletaPersonalList',
            selector: 'ReporteDetalleBoletaPersonalList'
        }
    ],

    init: function() {
        this.control({
            'ReporteDetalleBoletaPersonalList dataview': {
                itemdblclick: this.editRecord
            },
            'ReporteDetalleBoletaPersonalList button[action=add]': {
            	click: this.editRecord
            },
            'ReporteDetalleBoletaPersonalList button[action=delete]': {
                click: this.deleteRecord
            },
            'ReporteDetalleBoletaPersonalEdit button[action=save]': {
                click: this.updateRecord
            },
            'ReporteDetalleBoletaPersonalList button[action=filter]': {
                click: this.refreshGrid
            },
            'ReporteDetalleBoletaPersonalList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ReporteDetalleBoletaPersonalList combobox': {
                change: this.refreshGrid
            },
            'ReporteDetalleBoletaPersonalList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ReporteDetalleBoletaPersonal.Edit').show();
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
        var store = Ext.getStore('ReporteDetalleBoletaPersonal.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.idpersonal > 0){
	        			values.tokenField = 'insert';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ReporteDetalleBoletaPersonal.MainModel');
	        			values.tokenField = 'update';
	        			record.set(values);
	        			store.add(record);
	        		}
	                	
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	var form = Ext.getCmp('form_filter_ReporteDetalleBoletaPersonal');
				            var values = form.getValues();
				        	store.load({params:values});
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
    	
    	var grid = this.getReporteDetalleBoletaPersonalList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ReporteDetalleBoletaPersonal.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	var form = Ext.getCmp('form_filter_ReporteDetalleBoletaPersonal');
					            var values = form.getValues();
					        	store.load({params:values});
					        },
		        	        failure: function (batch, eOpts) {
								store.rejectChanges();
		        	        }
					    });
	                }
	        });
    	}

    },
    refreshGrid: function() {

    	var store = Ext.getStore('ReporteDetalleBoletaPersonal.MainStore');
        var form = Ext.getCmp('form_filter_ReporteDetalleBoletaPersonal');
        var values = form.getValues();
		values['start'] = 0;
        values['limit'] = 20;
    	store.load({params:values});

    },
    resetForm: function() {
    	
    	var store = Ext.getStore('ReporteDetalleBoletaPersonal.MainStore');
        var form = Ext.getCmp('form_filter_ReporteDetalleBoletaPersonal');
        form.reset();
        var values = form.getValues();
		values['start'] = 0;
        values['limit'] = 20;
    	store.load({params:values});

    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ReporteDetalleBoletaPersonal.MainStore');
            var form = Ext.getCmp('form_filter_ReporteDetalleBoletaPersonal');
            var values = form.getValues();
			values['start'] = 0;
        	values['limit'] = 20;
        	store.load({params:values});
        }
    }
      
});