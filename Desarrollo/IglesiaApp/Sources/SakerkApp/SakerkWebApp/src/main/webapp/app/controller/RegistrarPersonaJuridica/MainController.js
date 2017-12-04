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
* DATE CREATE : 31/12/2014 13:25:15
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.RegistrarPersonaJuridica.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['RegistrarPersonaJuridica.MainStore'],

    models: ['RegistrarPersonaJuridica.MainModel'],

    views: [
            	'RegistrarPersonaJuridica.Edit',
            	'GestionarPersonaNatural.NumeroTelefonicoQueryEdit',
            	'GestionarPersonaNatural.InformacionAcademicaQueryEdit',
            	'GestionarPersonaNatural.InformacionLaboralQueryEdit',
            	'GestionarPersonaNatural.InformacionEclesiasticaQueryEdit'
            ],

    refs: [
        {
            ref: 'RegistrarPersonaJuridicaList',
            selector: 'RegistrarPersonaJuridicaList'
        }
    ],

    init: function() {
        this.control({
            'RegistrarPersonaJuridicaEdit button[action=save]': {
                click: this.saveRecord
            },
            'NumeroTelefonicoQueryEdit button[action=addEmpresaComunicaciones]': {
                click: this.registrarEmpresaOperadora
            },
            'InformacionAcademicaQueryEdit button[action=addCentroEstudio]': {
                click: this.registrarCentroEstudio
            },
            'InformacionLaboralQueryEdit button[action=addPersonaJuridica]': {
                click: this.registrarPersonaJuridica
            },
            'InformacionEclesiasticaQueryEdit button[action=addCongregacion]': {
                click: this.registrarCongragacion
            }
        });
    },
    
    // Start JRaffo 31/12/2014
    registrarEmpresaOperadora: function() {
        var edit = Ext.create('MyApp.view.RegistrarPersonaJuridica.Edit').show();
        var form = edit.down('form');
        var id_tipo_persona_juridica = form.getForm().findField('id_tipo_persona_juridica');
        var id_form = form.getForm().findField('id_form');
        var name_field = form.getForm().findField('name_field');
        
        edit.setTitle('Agregar');
        form.setTitle('Empresa Operadora');
        id_tipo_persona_juridica.setValue(1); //Servicio Comunicaciones
        id_form.setValue("form_submodel_NumeroTelefonicoQuery");
        name_field.setValue("id_empresa_operadora");
    },
    registrarCentroEstudio: function() {
        var edit = Ext.create('MyApp.view.RegistrarPersonaJuridica.Edit').show();
        var form = edit.down('form');
        var id_tipo_persona_juridica = form.getForm().findField('id_tipo_persona_juridica');
        var id_form = form.getForm().findField('id_form');
        var name_field = form.getForm().findField('name_field');
        
        edit.setTitle('Agregar');
        form.setTitle('Centro de Estudios');
        id_tipo_persona_juridica.setValue(2); //Centro de Estudios
        id_form.setValue("form_submodel_InformacionAcademicaQuery");
        name_field.setValue("id_centro_estudio");
    },
    registrarPersonaJuridica: function() {

        
        var form_submodel_InformacionAcademicaQuery = Ext.getCmp('form_submodel_InformacionLaboralQuery'); 
        var fsiaq_id_tipo_persona_juridica = form_submodel_InformacionAcademicaQuery.getForm().findField('id_tipo_persona_juridica');

        if(fsiaq_id_tipo_persona_juridica.getValue() == null){
            Ext.MessageBox.show({
                title: 'Error',
                msg: 'Debe seleccionar el tipo de organización',
                icon: Ext.MessageBox.ERROR,
                buttons: Ext.Msg.OK
            });
        }else{
            var edit = Ext.create('MyApp.view.RegistrarPersonaJuridica.Edit').show();
            var form = edit.down('form');
            var id_tipo_persona_juridica = form.getForm().findField('id_tipo_persona_juridica');
            var id_form = form.getForm().findField('id_form');
            var name_field = form.getForm().findField('name_field');
            
            edit.setTitle('Agregar');
            form.setTitle('Organización');
            id_tipo_persona_juridica.setValue(fsiaq_id_tipo_persona_juridica.getValue()); //Tipo Persona Juridica
            id_form.setValue("form_submodel_InformacionLaboralQuery");
            name_field.setValue("id_empresa");
        }
        
    },
    registrarCongragacion: function() {
        var edit = Ext.create('MyApp.view.RegistrarPersonaJuridica.Edit').show();
        var form = edit.down('form');
        var id_tipo_persona_juridica = form.getForm().findField('id_tipo_persona_juridica');
        var id_form = form.getForm().findField('id_form');
        var name_field = form.getForm().findField('name_field');
        
        edit.setTitle('Agregar');
        form.setTitle('Congregación');
        id_tipo_persona_juridica.setValue(4); //Congregacion
        id_form.setValue("form_submodel_InformacionEclesiasticaQuery");
        name_field.setValue("id_congregacion");
    },
    // End JRaffo 31/12/2014
    
    saveRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('RegistrarPersonaJuridica.MainStore');
        
        // Start JRaffo 31/12/2014
        var id_form = form.getForm().findField('id_form');
        var name_field = form.getForm().findField('name_field');
        
        var on_form = Ext.getCmp(id_form.getValue());
        var on_field = on_form.getForm().findField(name_field.getValue());
        // End JRaffo 31/12/2014
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {

	        		record = Ext.create('MyApp.model.RegistrarPersonaJuridica.MainModel');
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