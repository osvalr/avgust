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
* DATE CREATE : 18/12/2014 22:25:38
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.RegistrarItemTablaGeneral.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['RegistrarItemTablaGeneral.MainStore'],

    models: ['RegistrarItemTablaGeneral.MainModel'],

    views: [	
            	'RegistrarItemTablaGeneral.Edit',
            	'GestionarPersonaNatural.NumeroTelefonicoQueryEdit',
            	'GestionarPersonaNatural.InformacionAcademicaQueryEdit',
            	'GestionarPersonaNatural.InformacionLaboralQueryEdit',
            	'GestionarPersonaNatural.InformacionEclesiasticaQueryEdit',
            	'GestionarPersonaNatural.PersonaNaturalParentescoQueryEdit'
            ],

    refs: [
        {
            ref: 'RegistrarItemTablaGeneralList',
            selector: 'RegistrarItemTablaGeneralList'
        }
    ],

    init: function() {
        this.control({
            'RegistrarItemTablaGeneralEdit button[action=save]': {
                click: this.saveRecord
            },
            'NumeroTelefonicoQueryEdit button[action=addTipoTelefono]': {
                click: this.registrarTipoTelefono
            },
            'InformacionAcademicaQueryEdit button[action=addCategoriaEstudio]': {
                click: this.registrarCategoriaEstudio
            },
            'InformacionAcademicaQueryEdit button[action=addNivelAcademico]': {
                click: this.registrarNivelAcademico
            },
            'InformacionLaboralQueryEdit button[action=addTipoPersonaJuridica]': {
                click: this.registrarTipoPersonaJuridica
            },
            'InformacionLaboralQueryEdit button[action=addCargo]': {
                click: this.registrarCargo
            },
            'InformacionEclesiasticaQueryEdit button[action=addTipoEvento]': {
                click: this.registrarTipoEvento
            },
            'PersonaNaturalParentescoQueryEdit button[action=addTipoParentesco]': {
                click: this.registrarTipoParentesco
            }
        });
    },

    registrarTipoTelefono: function(grid, record) {
        var edit = Ext.create('MyApp.view.RegistrarItemTablaGeneral.Edit').show();
        edit.setTitle('Agregar');
        var form = edit.down('form');
        form.setTitle('Tipo Telefono');
        var id_tabla_general = form.getForm().findField('id_tabla_general');
        id_tabla_general.setValue(4); //Tipo Telefono en tabla_general
        var id_form = form.getForm().findField('id_form');
        id_form.setValue("form_submodel_NumeroTelefonicoQuery");
        var name_field = form.getForm().findField('name_field');
        name_field.setValue("id_tipo_telefono");
    },
    
    registrarCategoriaEstudio: function(grid, record) {
        var edit = Ext.create('MyApp.view.RegistrarItemTablaGeneral.Edit').show();
        edit.setTitle('Agregar');
        var form = edit.down('form');
        form.setTitle('Categoria Estudio');
        var id_tabla_general = form.getForm().findField('id_tabla_general');
        id_tabla_general.setValue(10); //Categoria Estudio en tabla_general
        var id_form = form.getForm().findField('id_form');
        id_form.setValue("form_submodel_InformacionAcademicaQuery");
        var name_field = form.getForm().findField('name_field');
        name_field.setValue("id_categoria_estudio");
    },
    
    registrarNivelAcademico: function(grid, record) {
        var edit = Ext.create('MyApp.view.RegistrarItemTablaGeneral.Edit').show();
        edit.setTitle('Agregar');
        var form = edit.down('form');
        form.setTitle('Grado de Instrucción');
        var id_tabla_general = form.getForm().findField('id_tabla_general');
        id_tabla_general.setValue(11); //Categoria Estudio en tabla_general
        var id_form = form.getForm().findField('id_form');
        id_form.setValue("form_submodel_InformacionAcademicaQuery");
        var name_field = form.getForm().findField('name_field');
        name_field.setValue("id_tipo_grado_instruccion");
    },
    
    registrarTipoPersonaJuridica: function(grid, record) {
        var edit = Ext.create('MyApp.view.RegistrarItemTablaGeneral.Edit').show();
        edit.setTitle('Agregar');
        var form = edit.down('form');
        form.setTitle('Tipo Organización');
        var id_tabla_general = form.getForm().findField('id_tabla_general');
        id_tabla_general.setValue(13); //Tipo Persona Juridica en tabla_general
        var id_form = form.getForm().findField('id_form');
        id_form.setValue("form_submodel_InformacionLaboralQuery");
        var name_field = form.getForm().findField('name_field');
        name_field.setValue("id_tipo_persona_juridica");
    },
    
    registrarCargo: function(grid, record) {
        var edit = Ext.create('MyApp.view.RegistrarItemTablaGeneral.Edit').show();
        edit.setTitle('Agregar');
        var form = edit.down('form');
        form.setTitle('Cargo');
        var id_tabla_general = form.getForm().findField('id_tabla_general');
        id_tabla_general.setValue(14); //Cargos en tabla_general
        var id_form = form.getForm().findField('id_form');
        id_form.setValue("form_submodel_InformacionLaboralQuery");
        var name_field = form.getForm().findField('name_field');
        name_field.setValue("id_cargo");
    },
    
    registrarTipoEvento: function(grid, record) {
        var edit = Ext.create('MyApp.view.RegistrarItemTablaGeneral.Edit').show();
        edit.setTitle('Agregar');
        var form = edit.down('form');
        form.setTitle('Evento');
        var id_tabla_general = form.getForm().findField('id_tabla_general');
        id_tabla_general.setValue(16); //Tipo Evento en tabla_general
        var id_form = form.getForm().findField('id_form');
        id_form.setValue("form_submodel_InformacionEclesiasticaQuery");
        var name_field = form.getForm().findField('name_field');
        name_field.setValue("id_tipo_evento");
    },
    
    registrarTipoParentesco: function(grid, record) {
        var edit = Ext.create('MyApp.view.RegistrarItemTablaGeneral.Edit').show();
        edit.setTitle('Agregar');
        var form = edit.down('form');
        form.setTitle('Parentesco');
        var id_tabla_general = form.getForm().findField('id_tabla_general');
        id_tabla_general.setValue(17); //Tipo Parentesco en tabla_general
        var id_form = form.getForm().findField('id_form');
        id_form.setValue("form_submodel_PersonaNaturalParentescoQuery");
        var name_field = form.getForm().findField('name_field');
        name_field.setValue("id_tipo_parentesco");
    },
    
    saveRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('RegistrarItemTablaGeneral.MainStore');
        
        // Start JRaffo 31/12/2014
        var id_form = form.getForm().findField('id_form');
        var name_field = form.getForm().findField('name_field');
        
        var on_form = Ext.getCmp(id_form.getValue());
        var on_field = on_form.getForm().findField(name_field.getValue());
        // End JRaffo 31/12/2014
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de GRABAR el Registro?',function (btn) {
	            
	            if (btn == 'yes') {

	        		record = Ext.create('MyApp.model.RegistrarItemTablaGeneral.MainModel');
	        		record.set(values);
	        		store.add(record);

	        		store.sync({
	        	        success: function (batch, eOpts) {
	        	        	// Start JRaffo 31/12/2014
	        	        	var jsonResponse = Ext.decode(batch.operations[0]._response.responseText);
	        	        	on_field.store.load({
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