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
* DATE CREATE : 27/05/2015 02:48:17
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarTrabajadores.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarTrabajadoresEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '40%',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarTrabajadores',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Gestionar Trabajadores',
				                glyph:'xf022@FontAwesome',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'qtip',
                    				labelWidth: 125
			                	},

		                		items: [
											{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'idpersona',
											    fieldLabel : 'idpersona',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'idpersonanatural',
											    fieldLabel : 'idpersonanatural',
											    disabled : false,
											    editable : true
											}
											
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'nombre_completo',
											    fieldLabel : 'Nombres',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    maxLength : 45,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'nombre',
											    fieldLabel : 'Nombres',
											    disabled : false,
											    editable : true,
											    fieldStyle: 'text-transform:uppercase',
											    upper: true,
											    listeners:{
											    	change: function(field, newValue, oldValue){
											    		field.setValue(newValue.toUpperCase());
											    	}
											    }
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    maxLength : 45,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'apepat',
											    fieldLabel : 'Apellido Paterno',
											    disabled : false,
											    editable : true,
											    fieldStyle: 'text-transform:uppercase',
											    upper: true,
											    listeners:{
											    	change: function(field, newValue, oldValue){
											    		field.setValue(newValue.toUpperCase());
											    	}
											    }
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    maxLength : 45,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'apemat',
											    fieldLabel : 'Apellido Materno',
											    disabled : false,
											    editable : true,
											    fieldStyle: 'text-transform:uppercase',
											    upper: true,
											    listeners:{
											    	change: function(field, newValue, oldValue){
											    		field.setValue(newValue.toUpperCase());
											    	}
											    }
											}
											,{
											    readOnly : false,
											    store : {
											    	fields: ['idtablatipo','abrtablatipo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo de Documento',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    allowBlank : false,
											    queryMode : 'local',
											    displayField : 'abrtablatipo',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'idtipodocumento',
											    valueField : 'idtablatipo',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Tipo de Doc.',
											    disabled : false,
											    editable : false
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'descrip_documento',
											    fieldLabel : 'Tipo de Doc.',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    maxLength : 45,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'numerodoc',
											    fieldLabel : 'Nº de Doc.',
											    disabled : false,
											    editable : true,
											    vtype:'soloNumeros'
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    maxLength : 11,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'ruc',
											    fieldLabel : 'Ruc',
											    disabled : false,
											    editable : true,
											    vtype:'soloNumeros'
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    maxLength : 150,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'direccion',
											    fieldLabel : 'Dirección',
											    disabled : false,
											    editable : true,
											    fieldStyle: 'text-transform:uppercase',
											    upper: true,
											    listeners:{
											    	change: function(field, newValue, oldValue){
											    		field.setValue(newValue.toUpperCase());
											    	}
											    }
											}
											,{
											    readOnly : false,
											    store : {
											    	fields: ['idpais','nompais'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-pais.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    allowBlank : true,
											    queryMode : 'local',
											    displayField : 'nompais',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'idpais',
											    valueField : 'idpais',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Pais',
											    disabled : false,
											    editable : false,
											    listeners : {
											    	scope : this,
											    	afterRender : function(me){
											    		me.setValue(171);
											    	}
											    }
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'nompais',
											    fieldLabel : 'Pais',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    store : {
											    	fields: ['idtablatipo','abrtablatipo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Sexo',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    allowBlank : false,
											    queryMode : 'local',
											    displayField : 'abrtablatipo',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'idsexo',
											    valueField : 'idtablatipo',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Género',
											    disabled : false,
											    editable : false
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'descrip_genero',
											    fieldLabel : 'Género',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'datefield',
											    name : 'fechanacimiento',
											    format : 'd/m/Y',
											    fieldLabel : 'F. Nacimiento',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    maxLength : 32,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'telefono',
											    fieldLabel : 'Teléfono',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    maxLength : 100,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'correopersonal',
											    fieldLabel : 'Correo',
											    disabled : false,
											    editable : true,
											    fieldStyle: 'text-transform:uppercase',
											    upper: true,
											    listeners:{
											    	change: function(field, newValue, oldValue){
											    		field.setValue(newValue.toUpperCase());
											    	}
											    }
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'tokenField',
											    fieldLabel : 'tokenField'
											}
										]
							}
							
 						,{
					    		title: 'Presupuesto',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_GestionarTrabajadoresPresupuestoQuery', xtype:'GestionarTrabajadoresPresupuestoQueryList'}]
							}

                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            //id:'buttons',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf0c7@FontAwesome',
                itemId: 'save',
                text: 'Grabar',
                action: 'save'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_GestionarTrabajadores_statusbar'
        })];

        this.callParent(arguments);      
    }
});
