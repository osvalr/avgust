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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPostulante.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarPostulanteEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '55%',
    title:'Formulario de Postulación',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							
							{
								title: 'Documentos y Postulaciones',
								glyph:'xf022@FontAwesome',
								
								layout: {
								    type: 'vbox',
								    align : 'stretch',
								    pack  : 'start',
								},
								items: [

											{
												title: 'Documentos de Identidad (DNI y RUC)',
												id:'subModel_ArchivoPostulanteQuery',
												xtype:'ArchivoPostulanteQueryList'
											},
								        	{
								        		title: 'Postulaciones (Plaza y Ficha de Inscripción)',
								        		id:'subModel_PostulacionPersonaQuery',
								        		xtype:'PostulacionPersonaQueryList'
								        	}
								        ]
							},
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarPostulante',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información Personal',
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
														xtype: 'container',
														layout: {
															type: 'vbox',
															align: 'stretch'
														},
														items:[
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																			    allowBlank : true,
																			    xtype : 'textfield',
																			    hidden : true,
																			    editable : true,
																			    fieldLabel : 'idpersona',
																			    name : 'idpersona',
																			    disabled : false,
																			    readOnly : false
																			}
																			,{
																			    allowBlank : true,
																			    xtype : 'textfield',
																			    hidden : true,
																			    editable : true,
																			    fieldLabel : 'Id',
																			    name : 'idpersonanatural',
																			    disabled : false,
																			    readOnly : false
																			}
																			,{
																			    allowBlank : true,
																			    xtype : 'textfield',
																			    hidden : true,
																			    editable : true,
																			    fieldLabel : 'int_id_postulante',
																			    name : 'int_id_postulante',
																			    disabled : false,
																			    readOnly : false
																			}
																			,{
																			    allowBlank : false,
																			    xtype : 'textfield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Nombres',
																			    minLength : 1,
																			    name : 'nombre',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 45,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0",
																			    fieldStyle: 'text-transform:uppercase',
																			    listeners:{
																			    	change: function(field, newValue, oldValue){
																			    		field.setValue(newValue.toUpperCase());
																			    	}
																			    }
																			}
																			,{
																			    allowBlank : false,
																			    xtype : 'textfield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Apellido Paterno',
																			    minLength : 1,
																			    name : 'apepat',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 45,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0",
																			    fieldStyle: 'text-transform:uppercase',
																			    listeners:{
																			    	change: function(field, newValue, oldValue){
																			    		field.setValue(newValue.toUpperCase());
																			    	}
																			    }
																			}
																			,{
																			    allowBlank : false,
																			    xtype : 'textfield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Apellido Materno',
																			    minLength : 1,
																			    name : 'apemat',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 45,
																			    labelAlign: 'top',
																			    flex: 1,
																			    fieldStyle: 'text-transform:uppercase',
																			    listeners:{
																			    	change: function(field, newValue, oldValue){
																			    		field.setValue(newValue.toUpperCase());
																			    	}
																			    }
																			}
																	      ]
																},
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																			    allowBlank : false,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : false,
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
																			    valueField : 'idtablatipo',
																			    fieldLabel : 'Tipo Documento',
																			    name : 'idtipodocumento',
																			    displayField : 'abrtablatipo',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0"
																			}
																			,{
																			    allowBlank : false,
																			    xtype : 'textfield',
																			    vtype: 'soloNumeros',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Número Documento',
																			    minLength : 1,
																			    name : 'numerodoc',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 45,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0"
																			}
																			,{
																			    allowBlank : false,
																			    xtype : 'textfield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'R.U.C',
																			    minLength : 8,
																			    name : 'ruc',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 11,
																			    labelAlign: 'top',
																			    flex: 1,
																			    vtype:'numeroRuc'
																			}
																	       ]
																}
																,{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																			    allowBlank : false,
																			    xtype : 'datefield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Fecha Nacimiento',
																			    name : 'fechanacimiento',
																			    format : 'd/m/Y',
																			    disabled : false,
																			    readOnly : false,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0"
																			}
																			,{
																			    allowBlank : false,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : false,
																			    readOnly : false,
																			    store : {
																			    	fields: ['idtablatipo','destablatipo'],
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
																			    valueField : 'idtablatipo',
																			    fieldLabel : 'Genero',
																			    name : 'idsexo',
																			    displayField : 'destablatipo',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0"
																			}
																			,{
																			    allowBlank : false,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : true,
																			    readOnly : false,
																			    store : {
																			    	fields: ['idtablatipo','destablatipo'],
																			    	proxy: {
																			    		type: 'ajax',
																			    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Estado Civil',
																			    		reader: {
																			    			type: 'json',
																			    			rootProperty: 'listResult'
																			    		}
																			    	},
																			    	autoLoad: true
																			    },
																			    valueField : 'idtablatipo',
																			    fieldLabel : 'Estado Civil',
																			    name : 'idestadocivil',
																			    displayField : 'destablatipo',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1
																			}
																	       ]
																},
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																				queryMode : 'local',
																			    allowBlank : false,
																			    xtype : 'combobox',
																			    listeners : {
																			    	change: function(field, newValue, oldValue) {
																			
																			    		var form = Ext.getCmp('form_crud_GestionarPostulante');
																			    		var on_field = form.getForm().findField('codprov');
																			    		on_field.setDisabled(true);
																			    		on_field.store.removeAll();
																			    		on_field.store.reload({
																			    			params: {
																			    				idDepartamento: field.getValue()
																			    			}
																			    		});
																			    		on_field.setDisabled(false);
																			    		if(oldValue != null){
																			    			on_field.setValue('');
																			    		}
																			    	}
																			    },
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : true,
																			    readOnly : false,
																			    store : {
																			    	fields: ['coddpto','nombre'],
																			    	proxy: {
																			    		type: 'ajax',
																			    		url: 'obtener-departamentos-ubigeo.action',
																			    		reader: {
																			    			type: 'json',
																			    			rootProperty: 'listResult'
																			    		}
																			    	},
																			    	autoLoad: true
																			    },
																			    valueField : 'coddpto',
																			    fieldLabel : 'Departamento',
																			    name : 'coddpto',
																			    displayField : 'nombre',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0"
																			}
																			,{
																			    queryMode : 'local',
																			    allowBlank : false,
																			    xtype : 'combobox',
																			    listeners : {
																			    	change: function(field, newValue, oldValue) {
																			
																			    		var form = Ext.getCmp('form_crud_GestionarPostulante');
																			    		var on_field = form.getForm().findField('idubigeo');
																			    		on_field.setDisabled(true);
																			    		on_field.store.removeAll();
																			    		var field_coddpto = form.getForm().findField('coddpto');
																			    		on_field.store.reload({
																			    			params: {
																			    				idDepartamento: field_coddpto.getValue(),
																			    				idProvincia: field.getValue()
																			    			}
																			    		});
																			    		on_field.setDisabled(false);
																			    		if(oldValue != null){
																			    			on_field.setValue('');
																			    		}
																			    	}
																			    },
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : true,
																			    readOnly : false,
																			    store : {
																			    	fields: ['codprov','nombre'],
																			    	proxy: {
																			    		type: 'ajax',
																			    		url: 'obtener-provincias-ubigeo.action',
																			    		reader: {
																			    			type: 'json',
																			    			rootProperty: 'listResult'
																			    		}
																			    	},
																			    	autoLoad: true
																			    },
																			    valueField : 'codprov',
																			    fieldLabel : 'Provincia',
																			    name : 'codprov',
																			    displayField : 'nombre',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0"
																			}
																			,{
																			    allowBlank : false,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : true,
																			    readOnly : false,
																			    store : {
																			    	fields: ['idubigeo','nombre'],
																			    	proxy: {
																			    		type: 'ajax',
																			    		url: 'obtener-distritos-ubigeo.action',
																			    		reader: {
																			    			type: 'json',
																			    			rootProperty: 'listResult'
																			    		}
																			    	},
																			    	autoLoad: true
																			    },
																			    valueField : 'idubigeo',
																			    fieldLabel : 'Distrito',
																			    name : 'idubigeo',
																			    displayField : 'nombre',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1
																			}
																	       ]
																},
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																			    allowBlank : false,
																			    hidden : false,
																			    xtype : 'textareafield',
																			    editable : true,
																			    fieldLabel : 'Dirección',
																			    minLength : 1,
																			    name : 'direccion',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 250,
																			    labelAlign: 'top',
																			    flex: 1,
																			    fieldStyle: 'text-transform:uppercase',
																			    listeners:{
																			    	change: function(field, newValue, oldValue){
																			    		field.setValue(newValue.toUpperCase());
																			    	}
																			    }
																			}
																	       ]
																},
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																			    allowBlank : true,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : true,
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
																			    valueField : 'idpais',
																			    fieldLabel : 'Pais',
																			    name : 'idpais',
																			    displayField : 'nompais',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1
																			} 
																	      ]
																},
																
//																{
//																	xtype: 'container',
//																	
//																	layout: {
//																		type: 'hbox',
//																		align: 'stretch'
//																	},
//																	items:[
//
//																				{
//																					xtype: 'filefield',
//																					emptyText: 'Seleccione un archivo',
//																					vtype:'fileDocUpload',
//																					allowBlank: false,
//																					fieldLabel: 'DNI',
//																					name: 'upload',
//																					buttonConfig: {
//																						glyph: 'xf03e@FontAwesome'
//																					},
//																				    labelAlign: 'top',
//																					flex: 1,
//																					margin: "0 10 0 0"
//																				}
//																				,
//																				{
//																					xtype: 'filefield',
//																					emptyText: 'Seleccione un archivo',
//																					vtype:'fileDocUpload',
//																					allowBlank: false,
//																					fieldLabel: 'Ficha RUC',
//																					name: 'upload',
//																					buttonConfig: {
//																						glyph: 'xf03e@FontAwesome'
//																					},
//																				    labelAlign: 'top',
//																					flex: 1,
//																					margin: "0 10 0 0"
//																				}
//																	       ]
//																
//																},
																
																
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[

																			{
																			    allowBlank : true,
																			    xtype : 'textfield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Email Principal',
																			    minLength : 1,
																			    name : 'var_email_principal',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 100,
																			    labelAlign: 'top',
																				flex: 1,
																				margin: "0 10 0 0",
//																				vtype:'email',
																				fieldStyle: 'text-transform:uppercase',
																				 listeners:{
																				    	change: function(field, newValue, oldValue){
																				    		field.setValue(newValue.toUpperCase());
																				    	}
																				    }
																			}
																			,{
																			    allowBlank : true,
																			    xtype : 'textfield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Email Secundario',
																			    minLength : 1,
																			    name : 'var_email_secundario',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 100,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 0 0 0",
																				vtype:'email',
																				fieldStyle: 'text-transform:uppercase',
																				 listeners:{
																				    	change: function(field, newValue, oldValue){
																				    		field.setValue(newValue.toUpperCase());
																				    	}
																				    }
																			}
																	       ]
																},
																
																
																
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																			    allowBlank : true,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : false,
																			    readOnly : false,
																			    store : {
																			    	fields: ['codinttablatipo','destablatipo'],
																			    	proxy: {
																			    		type: 'ajax',
																			    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Boolean_Generico',
																			    		reader: {
																			    			type: 'json',
																			    			rootProperty: 'listResult'
																			    		}
																			    	},
																			    	autoLoad: true
																			    },
																			    valueField : 'codinttablatipo',
																			    fieldLabel : 'Persona Discapacitada',
																			    name : 'int_persona_discapacitada',
																			    displayField : 'destablatipo',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0"
																			}
																			,{
																			    allowBlank : true,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : false,
																			    fieldLabel : 'Perteneció F.F A.A',
																			    name : 'int_pertenece_ffaa',
																			    displayField : 'destablatipo',
																			    disabled : false,
																			    readOnly : false,
																			    store : {
																			    	fields: ['codinttablatipo','destablatipo'],
																			    	proxy: {
																			    		type: 'ajax',
																			    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Boolean_Generico',
																			    		reader: {
																			    			type: 'json',
																			    			rootProperty: 'listResult'
																			    		}
																			    	},
																			    	autoLoad: true
																			    },
																			    valueField : 'codinttablatipo',
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 0 0 0"
																			}
																	       ]
																},
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																			    allowBlank : true,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : false,
																			    readOnly : false,
																			    store : {
																			    	fields: ['codinttablatipo','destablatipo'],
																			    	proxy: {
																			    		type: 'ajax',
																			    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Boolean_Generico',
																			    		reader: {
																			    			type: 'json',
																			    			rootProperty: 'listResult'
																			    		}
																			    	},
																			    	autoLoad: true
																			    },
																			    valueField : 'codinttablatipo',
																			    fieldLabel : 'Culminó Primaria',
																			    name : 'int_culmino_edu_prima',
																			    displayField : 'destablatipo',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 10 0 0"
																			}
																			,{
																			    allowBlank : true,
																			    queryMode : 'local',
																			    xtype : 'combobox',
																			    hidden : false,
																			    emptyText : '-- Seleccione Opción --',
																			    editable : false,
																			    readOnly : false,
																			    store : {
																			    	fields: ['codinttablatipo','destablatipo'],
																			    	proxy: {
																			    		type: 'ajax',
																			    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Boolean_Generico',
																			    		reader: {
																			    			type: 'json',
																			    			rootProperty: 'listResult'
																			    		}
																			    	},
																			    	autoLoad: true
																			    },
																			    valueField : 'codinttablatipo',
																			    fieldLabel : 'Culminó Secundaria',
																			    name : 'int_culmino_edu_secun',
																			    displayField : 'destablatipo',
																			    disabled : false,
																			    labelAlign: 'top',
																			    flex: 1,
																			    margin: "0 0 0 0"
																			}
																	       ]
																},
																{
																	xtype: 'container',
																	
																	layout: {
																		type: 'hbox',
																		align: 'stretch'
																	},
																	items:[
																			{
																			    allowBlank : true,
																			    xtype : 'textareafield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Resumen Profesional',
																			    minLength : 1,
																			    name : 'var_resumen_profesional',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 5000,
																			    labelAlign: 'top',
																			    flex: 1,
																			    fieldStyle: 'text-transform:uppercase',
																			    listeners:{
																			    	change: function(field, newValue, oldValue){
																			    		field.setValue(newValue.toUpperCase());
																			    	}
																			    },
																				margin: "0 10 0 0"
																			},
																			{
																			    allowBlank : true,
																			    xtype : 'textareafield',
																			    hidden : false,
																			    editable : true,
																			    fieldLabel : 'Observaciones',
																			    minLength : 1,
																			    name : 'var_observacion_registro',
																			    disabled : false,
																			    readOnly : false,
																			    maxLength : 5000,
																			    labelAlign: 'top',
																			    flex: 1,
																			    fieldStyle: 'text-transform:uppercase',
																			    listeners:{
																			    	change: function(field, newValue, oldValue){
																			    		field.setValue(newValue.toUpperCase());
																			    	}
																			    },
																			    margin: "0 0 0 0"
																			}
																	       ]
																}
																
																
													]
													}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    fieldLabel : 'tokenField',
											    name : 'tokenField'
											}
										]
							}
							

//							,{
//					    		title: 'Telefonos',
//					    		glyph:'xf022@FontAwesome',
//					    		items: [{id:'subModel_PostulanteNumeroTelefonoQuery', xtype:'PostulanteNumeroTelefonoQueryList'}]
//							}
//							,{
//					    		title: 'Archivos Adjuntos',
//					    		glyph:'xf022@FontAwesome',
//					    		items: [{id:'subModel_ArchivoPostulanteQuery', xtype:'ArchivoPostulanteQueryList'}]
//							}

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
            id: 'form_crud_GestionarPostulante_statusbar'
        })];

        this.callParent(arguments);      
    }
});
