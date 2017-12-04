/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
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
* DATE CREATE : 01/01/2015 21:59:41
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.RegistrarEstudio.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['RegistrarEstudio.MainStore'],

    models: ['RegistrarEstudio.MainModel'],

    views: [
            'RegistrarEstudio.Edit',
        	'GestionarPersonaNatural.InformacionAcademicaQueryEdit'
        ],

    refs: [
        {
            ref: 'RegistrarEstudioList',
            selector: 'RegistrarEstudioList'
        }
    ],

    init: function() {
        this.control({
            'RegistrarEstudioEdit button[action=save]': {
                click: this.saveRecord
            },
            'InformacionAcademicaQueryEdit button[action=addEstudio]': {
                click: this.registrarEstuido
            }
        });
    },

    registrarEstuido: function() {

        
        var form_submodel_InformacionAcademicaQuery = Ext.getCmp('form_submodel_InformacionAcademicaQuery'); 
        var fiaq_id_categoria_estudio = form_submodel_InformacionAcademicaQuery.getForm().findField('id_categoria_estudio');

        if(fiaq_id_categoria_estudio.getValue() == null){
            Ext.MessageBox.show({
                title: 'Error',
                msg: 'Debe seleccionar la categoría del estuido',
                icon: Ext.MessageBox.ERROR,
                buttons: Ext.Msg.OK
            });
        }else{
            var edit = Ext.create('MyApp.view.RegistrarEstudio.Edit').show();
            var form = edit.down('form');
            var id_categoria_estudio = form.getForm().findField('id_categoria_estudio');
            var id_form = form.getForm().findField('id_form');
            var name_field = form.getForm().findField('name_field');
            
            edit.setTitle('Agregar');
            form.setTitle('Estudio');
            id_categoria_estudio.setValue(fiaq_id_categoria_estudio.getValue()); //Tipo Persona Juridica
            id_form.setValue("form_submodel_InformacionAcademicaQuery");
            name_field.setValue("id_estudio");
        }
        
    },
    
    saveRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('RegistrarEstudio.MainStore');
        
        // Start JRaffo 31/12/2014
        var id_form = form.getForm().findField('id_form');
        var name_field = form.getForm().findField('name_field');
        
        var on_form = Ext.getCmp(id_form.getValue());
        var on_field = on_form.getForm().findField(name_field.getValue());
        // End JRaffo 31/12/2014
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {

	        		record = Ext.create('MyApp.model.RegistrarEstudio.MainModel');
	        		record.set(values);
	        		store.add(record);

	        		store.sync({
	        	        success: function (batch, eOpts) {
	        	        	// Start JRaffo 31/12/2014
	        	        	var jsonResponse = Ext.decode(batch.operations[0]._response.responseText);
	        	        	on_field.store.reload({
	        	        		callback: function (records, operation, success) {
	        	        			if (success) {
	        	        				on_field.setValue(jsonResponse.lastId);
	        	        			}
	        	        	        
	        	        	    }
	        	        	});
	        	        	win.close();
	        	        	// End JRaffo 31/12/2014
	        	        },
	        	        failure: function (batch, eOpts) {
	        	        	// Start JRaffo 31/12/2014
	        	        	store.rejectChanges();
	        	        	// End JRaffo 31/12/2014
	        	        }
	        	    });
	            }
	        });
		}
    }
          
});