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
* DATE CREATE : 03/12/2014 03:40:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPersonaNatural.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarPersonaNaturalEdit',

    requires: ['Ext.form.Panel'],

    title : '',
    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    width: '925px',
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarPersonaNatural',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Personal',
				                glyph:'xf007@FontAwesome',
				                
				                fieldDefaults: {
				                    labelAlign: 'top',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'side',
				                    margin: "0 5 5 5"
			                	},

		                		items: [
		                                {
		                                	xtype: 'container',
		                                	layout: {
		                                		type: 'hbox',
		                                		align: 'stretch'
		                                	},
		                                	items:[
		       									{
		    									    xtype: 'fieldset',
		    									    padding: '5 5 7 5',				    
		    									    style: 'margin-right: 7px;',
		    									    title: 'Fotografía',
		    									    items:[
		    				                                {
		    				                                	xtype: 'container',
		    				                                	layout: {
		    				                                		type: 'vbox',
		    				                                		align: 'stretch'
		    				                                	},
		    				                                	items:[
		    															{
		    																xtype : 'image',
//		    																src: '/Home/DefaultImage',
		    																id:'photo_persona',
		    															    width: '145px',
		    															    height: '165px',
		    															    style: 'margin-bottom: 7px;'
		    															},
		    															{
		    																xtype:'button',
		    												            	glyph:'xf083@FontAwesome',
		    												                text: 'Añadir',
		    												                action: 'editPhoto'
		    												            }
		    				                                	]
		    				                                }  
		    									    ]
		    									},
		    									{
		    									    xtype: 'fieldset',
		    									    flex: 1,
		    									    padding: '5 5 7 5',
		    									    title: 'Información Personal',
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
		    															    hidden : true,
		    															    xtype : 'textfield',
		    															    name : 'id_persona',
		    															    fieldLabel : 'Id'
		    															}
		    															,{
		    															    allowBlank : true,
		    															    hidden : true,
		    															    xtype : 'textfield',
		    															    name : 'id_persona_natural',
		    															    fieldLabel : 'id_persona_natural'
		    															}
		    															,{
		    															    allowBlank : true,
		    															    hidden : true,
		    															    xtype : 'textfield',
		    															    name : 'id_ubicacion_geografica',
		    															    fieldLabel : 'id_ubicacion_geografica'
		    															},
		    															{
		    															    allowBlank : true,
		    															    hidden : true,
		    															    xtype : 'textfield',
		    															    name : 'id_archivo',
		    															    fieldLabel : 'id_archivo'
		    															}
		    															,{
		    															    maxLength : 100,
		    															    minLength : 1,
		    															    hidden : false,
		    															    xtype : 'textfield',
		    															    name : 'nombres',
		    															    fieldLabel : 'Nombres'
		    															}
		    															,{
		    															    maxLength : 100,
		    															    minLength : 1,
		    															    hidden : false,
		    															    xtype : 'textfield',
		    															    name : 'ape_pater',
		    															    fieldLabel : 'A. Paterno'
		    															}
		    															,{
		    															    maxLength : 100,
		    															    minLength : 1,
		    															    hidden : false,
		    															    xtype : 'textfield',
		    															    name : 'ape_mater',
		    															    fieldLabel : 'A. Materno'
		    															}
		    															,{
		    															    allowBlank : true,
		    															    maxLength : 150,
		    															    minLength : 1,
		    															    hidden : false,
		    															    xtype : 'textfield',
		    															    name : 'email',
		    															    fieldLabel : 'Email'
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
		    															,{
		    															    store : {
		    															    	fields: ['valor_general','campo_a'],
		    															    	proxy: {
		    															    		type: 'ajax',
		    															    		url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Tipo_Documento_Identidad',
		    															    		reader: {
		    															    			type: 'json',
		    															    			rootProperty: 'listRecords'
		    															    		}
		    															    	},
		    															    	autoLoad: true
		    															    },
		    															    allowBlank : true,
		    															    queryMode : 'local',
		    															    displayField : 'campo_a',
		    															    hidden : false,
		    															    xtype : 'combobox',
		    															    name : 'id_tipo_documento',
		    															    valueField : 'valor_general',
		    															    emptyText : '-- Seleccione Opción --',
		    															    fieldLabel : 'Tipo Documento'
		    															}
		    															,{
		    															    allowBlank : true,
		    															    maxLength : 50,
		    															    minLength : 1,
		    															    hidden : false,
		    															    xtype : 'textfield',
		    															    name : 'numero_documento',
		    															    fieldLabel : 'N. Documento'
		    															}
		    															,{
		    															    store : {
		    															    	fields: ['valor_general','campo_a'],
		    															    	proxy: {
		    															    		type: 'ajax',
		    															    		url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Estado_Civil',
		    															    		reader: {
		    															    			type: 'json',
		    															    			rootProperty: 'listRecords'
		    															    		}
		    															    	},
		    															    	autoLoad: true
		    															    },
		    															    allowBlank : true,
		    															    queryMode : 'local',
		    															    displayField : 'campo_a',
		    															    hidden : false,
		    															    xtype : 'combobox',
		    															    name : 'id_estado_civil',
		    															    valueField : 'valor_general',
		    															    emptyText : '-- Seleccione Opción --',
		    															    fieldLabel : 'Estado Civil'
		    															}
		    															,{
		    															    store : {
		    															    	fields: ['valor_general','campo_a'],
		    															    	proxy: {
		    															    		type: 'ajax',
		    															    		url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Genero_Persona',
		    															    		reader: {
		    															    			type: 'json',
		    															    			rootProperty: 'listRecords'
		    															    		}
		    															    	},
		    															    	autoLoad: true
		    															    },
		    															    allowBlank : true,
		    															    queryMode : 'local',
		    															    displayField : 'campo_a',
		    															    hidden : false,
		    															    xtype : 'combobox',
		    															    name : 'id_genero',
		    															    valueField : 'valor_general',
		    															    emptyText : '-- Seleccione Opción --',
		    															    fieldLabel : 'Genero'
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
																		    store : {
																		    	fields: ['id_pais','nombre_pais'],
																		    	proxy: {
																		    		type: 'ajax',
																		    		url: 'listaPaises.action',
																		    		reader: {
																		    			type: 'json',
																		    			rootProperty: 'listRecords'
																		    		}
																		    	},
																		    	autoLoad: true
																		    },
																		    queryMode : 'local',
																		    displayField : 'nombre_pais',
																		    hidden : false,
																		    xtype : 'combobox',
																		    name : 'id_pais',
																		    valueField : 'id_pais',
																		    emptyText : '-- Seleccione Opción --',
																		    fieldLabel : 'Nacionalidad'
																		},{
		    															    allowBlank : true,
		    															    hidden : false,
		    															    xtype : 'datefield',
		    															    name : 'fecha_nacimiento',
		    															    format : 'd/m/Y',
		    															    fieldLabel : 'F.Nacimiento'
		    															}
		    				                                	]
		    				                                }
		    									    ]
		    									}
		                                	]
		                                },

									{
									    xtype: 'fieldset',
									    flex: 1,
									    padding: '5 5 7 5',
									    title: 'Domicílio',
									    items:[
				                                {
				                                	xtype: 'container',
				                                	layout: {
				                                		type: 'hbox',
				                                		align: 'stretch'
				                                	},
				                                	items:[
															{
															    listeners : {
															    	change: function(combo, value) {
															    		
															    		var form = Ext.getCmp('form_crud_GestionarPersonaNatural');
															    		var on_combo = form.getForm().findField('cod_prov');
															    		on_combo.setDisabled(true);
															    		on_combo.store.removeAll();
															    		on_combo.store.reload({
															    			params: {
															    				idDepartamento: combo.getValue()
															    			}
															    		});
															    		on_combo.setDisabled(false);
															    	}
															    },
															    store : {
															    	fields: ['cod_depto','nombre_ubicacion'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'obtenerDepartamentosUbigeo.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listRecords'
															    		}
															    	},
															    	autoLoad: true
															    },
															    queryMode : 'local',
															    displayField : 'nombre_ubicacion',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'cod_depto',
															    valueField : 'cod_depto',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Departamento'
															}
															,{
															    listeners : {
															    	change: function(combo, value) {
															    		var form = Ext.getCmp('form_crud_GestionarPersonaNatural');
															    		var on_combo = form.getForm().findField('id_ubigeo');
															    		on_combo.setDisabled(true);
															    		on_combo.store.removeAll();
															    		var combo_cod_depto = form.getForm().findField('cod_depto');
															    		on_combo.store.reload({
															    			params: {
															    				idDepartamento: combo_cod_depto.getValue(),
															    				idProvincia: combo.getValue()
															    			}
															    		});
															    		on_combo.setDisabled(false);
															    	}
															    },
															    store : {
															    	fields: ['cod_prov','nombre_ubicacion'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'obtenerProvinciaUbigeo.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listRecords'
															    		}
															    	},
															    	autoLoad: false
															    },
															    queryMode : 'local',
															    displayField : 'nombre_ubicacion',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'cod_prov',
															    valueField : 'cod_prov',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Provincia'
															},
															{
															    store : {
															    	fields: ['id_ubigeo','nombre_ubicacion'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'obtenerDistritoUbigeo.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listRecords'
															    		}
															    	},
															    	autoLoad: false
															    },
															    queryMode : 'local',
															    displayField : 'nombre_ubicacion',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'id_ubigeo',
															    valueField : 'id_ubigeo',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Distrito'
															}
				                                	]
				                                }
													
													,{
													    hidden : false,
													    xtype : 'textarea',
													    name : 'direccion',
													    fieldLabel : 'Dirección',
													    anchor: '100%'
													}
									    ]
									},
									{
									    xtype: 'fieldset',
									    flex: 1,
									    padding: '5 5 7 5',
									    title: 'Lugar de Congregación',
									    items:[
				                                {
				                                	xtype: 'container',
				                                	layout: {
				                                		type: 'hbox',
				                                		align: 'stretch'
				                                	},
				                                	items:[
															{
															    listeners : {
															    	change: function(combo, value) {
															    		var form = Ext.getCmp('form_crud_GestionarPersonaNatural');
															    		var on_combo = form.getForm().findField('id_congregacion_general_distrito');
															    		on_combo.setDisabled(true);
															    		on_combo.store.removeAll();
															    		on_combo.store.reload({
															    			params: {
															    				id_congregacion_padre: combo.getValue()
															    			}
															    		});
															    		on_combo.setDisabled(false);
															    	}
															    },
															    store : {
															    	fields: ['id_congregacion_general','nombre_congregacion'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'listaCongregacionPorReferido.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listRecords'
															    		}
															    	},
															    	autoLoad: true
															    },
															    queryMode : 'local',
															    displayField : 'nombre_congregacion',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'id_congregacion_general_padre',
															    valueField : 'id_congregacion_general',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Congregación Nacional'
															}
															,{
															    listeners : {
															    	change: function(combo, value) {
															    		var form = Ext.getCmp('form_crud_GestionarPersonaNatural');
															    		var on_combo = form.getForm().findField('id_persona_pertenece');
															    		on_combo.setDisabled(true);
															    		on_combo.store.removeAll();
															    		on_combo.store.reload({
															    			params: {
															    				id_congregacion_general: combo.getValue()
															    			}
															    		});
															    		on_combo.setDisabled(false);
															    	}
															    },
															    store : {
															    	fields: ['id_congregacion_general','nombre_congregacion'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'listaCongregacionPorReferido.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listRecords'
															    		}
															    	},
															    	autoLoad: true
															    },
															    queryMode : 'local',
															    displayField : 'nombre_congregacion',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'id_congregacion_general_distrito',
															    valueField : 'id_congregacion_general',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Congregación Distrito'
															}
															,{
															    store : {
															    	fields: ['id_congregacion_local','razon_social'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'listaCongregacionLocal.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listRecords'
															    		}
															    	},
															    	autoLoad: true
															    },
															    allowBlank : true,
															    queryMode : 'local',
															    displayField : 'razon_social',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'id_persona_pertenece',
															    valueField : 'id_congregacion_local',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Congregación Local'
															},{
															    store : {
															    	fields: ['valor_general','campo_a'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Estado_Generico',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listRecords'
															    		}
															    	},
															    	autoLoad: true
															    },
															    allowBlank : true,
															    queryMode : 'local',
															    displayField : 'campo_a',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'id_estado',
															    valueField : 'valor_general',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Estado'
															}
															,{
															    allowBlank : true,
															    hidden : true,
															    xtype : 'datefield',
															    name : 'fecha_registro',
															    format : 'd/m/Y',
															    fieldLabel : 'F.Registro'
															}
				                                	]
				                                }
									    ]
									}
											
										]
							},
							

							,{
					    		title: 'Teléfonos',
					    		glyph:'xf10b@FontAwesome',
					    		items: [{id:'detailNumeroTelefonicoQuery', xtype:'NumeroTelefonicoQueryList'}]
							}
							,{
					    		title: 'Info Acádemica',
					    		glyph:'xf19d@FontAwesome',
					    		items: [{id:'detailInformacionAcademicaQuery', xtype:'InformacionAcademicaQueryList'}]
							}
							,{
					    		title: 'Info Laboral',
					    		glyph:'xf0ad@FontAwesome',
					    		items: [{id:'detailInformacionLaboralQuery', xtype:'InformacionLaboralQueryList'}]
							}
							,{
					    		title: 'Info Eclesiastica',
					    		glyph:'xf19c@FontAwesome',
					    		items: [{id:'detailInformacionEclesiasticaQuery', xtype:'InformacionEclesiasticaQueryList'}]
							}
							,{
					    		title: 'Parentesco',
					    		glyph:'xf0c0@FontAwesome',
					    		items: [{id:'detailPersonaNaturalParentescoQuery', xtype:'PersonaNaturalParentescoQueryList'}]
							}
							,{
					    		title: 'Roles',
					    		glyph:'xf0e8@FontAwesome',
					    		items: [{id:'detailPersonaNaturalRolQuery', xtype:'PersonaNaturalRolQueryList'}]
							}

                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            id:'buttons',
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
        }];

        this.callParent(arguments);      
    }
});
