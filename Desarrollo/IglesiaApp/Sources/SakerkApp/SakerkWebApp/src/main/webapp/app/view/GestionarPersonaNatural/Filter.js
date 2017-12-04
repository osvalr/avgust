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
 * GENERATOR CRUD EXT JS 5 BY FOCUS CONSULTORES ASOCIADOS SAC 
 * DATE CREATE : 09/11/2014 02:30:50 
 * VERSION : 1.0
 */

Ext.define('MyApp.view.GestionarPersonaNatural.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarPersonaNaturalFilter',
    requires: ['Ext.form.Panel'],
    
    initComponent: function() {
    	
    	var form = this;
    	
        this.items = [
                {
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							{
								hidden : false,
								xtype : 'textfield',
								name : 'id_persona',
								fieldLabel : 'Id'
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'nombres_completos',
								fieldLabel : 'Nombres completos'
							}
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
										autoLoad: true,
										listeners: {
									        load: function(store) {
									        	var rec = { valor_general:'',campo_a:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'campo_a',
								hidden : false,
								xtype : 'combobox',
								name : 'id_tipo_documento',
								valueField : 'valor_general',
								value : '',
								fieldLabel : 'Tipo Documento'
							}
							,{
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
											url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Genero_Persona',
											reader: {
												type: 'json',
												rootProperty: 'listRecords'
											}
										},
										autoLoad: true,
										listeners: {
									        load: function(store) {
									        	var rec = { valor_general:'',campo_a:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'campo_a',
								hidden : false,
								xtype : 'combobox',
								name : 'id_genero',
								valueField : 'valor_general',
								value : '',
								fieldLabel : 'Genero'
							}
							,{
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
										autoLoad: true,
										listeners: {
									        load: function(store) {
									        	var rec = { id_pais:'',nombre_pais:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'nombre_pais',
								hidden : false,
								xtype : 'combobox',
								name : 'id_pais',
								valueField : 'id_pais',
								value : '',
								fieldLabel : 'Nacionalidad'
							}
						]
					}
					,{
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							{
								listeners : {
									change: function(combo, value) {
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
										autoLoad: true,
										listeners: {
									        load: function(store) {
									        	var rec = { cod_depto:'',nombre_ubicacion:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'nombre_ubicacion',
								hidden : false,
								xtype : 'combobox',
								name : 'cod_depto',
								valueField : 'cod_depto',
								value : '',
								fieldLabel : 'Departamento'
							}
							,{
								listeners : {
									change: function(combo, value) {
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
										autoLoad: false,
										listeners: {
									        load: function(store) {
									        	var rec = { cod_prov:'',nombre_ubicacion:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'nombre_ubicacion',
								hidden : false,
								xtype : 'combobox',
								name : 'cod_prov',
								valueField : 'cod_prov',
								value : '',
								fieldLabel : 'Provincia'
							}
							,{
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
										autoLoad: false,
										listeners: {
									        load: function(store) {
									        	var rec = { id_ubigeo:'',nombre_ubicacion:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'nombre_ubicacion',
								hidden : false,
								xtype : 'combobox',
								name : 'id_ubigeo',
								valueField : 'id_ubigeo',
								value : '',
								fieldLabel : 'Distrito'
							}
							,{
								listeners : {
									change: function(combo, value) {
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
										autoLoad: true,
										listeners: {
									        load: function(store) {
									        	var rec = { id_congregacion_general:'',nombre_congregacion:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'nombre_congregacion',
								hidden : false,
								xtype : 'combobox',
								name : 'id_congregacion_general_padre',
								valueField : 'id_congregacion_general',
								value : '',
								fieldLabel : 'Congregación Nacional'
							}
							,{
								listeners : {
									change: function(combo, value) {
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
										autoLoad: true,
										listeners: {
									        load: function(store) {
									        	var rec = { id_congregacion_general:'',nombre_congregacion:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'nombre_congregacion',
								hidden : false,
								xtype : 'combobox',
								name : 'id_congregacion_general_distrito',
								valueField : 'id_congregacion_general',
								value : '',
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
										autoLoad: true,
										listeners: {
									        load: function(store) {
									        	var rec = { id_persona_juridica:'',razon_social:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'razon_social',
								hidden : false,
								xtype : 'combobox',
								name : 'id_persona_pertenece',
								valueField : 'id_congregacion_local',
								value : '',
								fieldLabel : 'Congregación Local'
							}
						]
					}
					,{
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							{
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
										autoLoad: true,
										listeners: {
									        load: function(store) {
									        	var rec = { valor_general:'',campo_a:'-- Todos --' };
									        	store.insert(0, rec);
									        }
										}
								},
								queryMode : 'local',
								displayField : 'campo_a',
								hidden : false,
								xtype : 'combobox',
								name : 'id_estado',
								valueField : 'valor_general',
								value : '',
								fieldLabel : 'Estado'
							}
						]
					}
                  ,{
                    xtype: 'container',
                    layout: {
                    	type: 'hbox',
                    	align: 'stretch'
                    },
                    items: [
                            {
								xtype : 'combobox',
								name : 'orderColumn',
								fieldLabel : 'Ordenar por',
								valueField : 'numero',
								displayField : 'descrip',
								store : {
									fields: ['numero','descrip'],
									data: [
										{numero: 1,descrip : 'Id'}
										,{numero: 2,descrip : 'id_persona_natural'}
										,{numero: 3,descrip : 'id_ubicacion_geografica'}
										,{numero: 4,descrip : 'Nombres completos'}
										,{numero: 5,descrip : 'Nombres'}
										,{numero: 6,descrip : 'A. Paterno'}
										,{numero: 7,descrip : 'A. Materno'}
										,{numero: 8,descrip : 'Email'}
										,{numero: 9,descrip : 'Nacionalidad'}
										,{numero: 10,descrip : 'Nacionalidad'}
										,{numero: 11,descrip : 'F.Nacimiento'}
										,{numero: 12,descrip : 'Tipo Documento'}
										,{numero: 13,descrip : 'T.Documento'}
										,{numero: 14,descrip : 'N. Documento'}
										,{numero: 15,descrip : 'Estado Civil'}
										,{numero: 17,descrip : 'Genero'}
										,{numero: 16,descrip : 'E. Civil'}
										,{numero: 19,descrip : 'Departamento'}
										,{numero: 18,descrip : 'Genero'}
										,{numero: 21,descrip : 'Provincia'}
										,{numero: 20,descrip : 'Departamento'}
										,{numero: 23,descrip : 'Distrito'}
										,{numero: 22,descrip : 'Provincia'}
										,{numero: 25,descrip : 'Dirección'}
										,{numero: 24,descrip : 'Distrito'}
										,{numero: 27,descrip : 'cor_y'}
										,{numero: 26,descrip : 'cor_x'}
										,{numero: 29,descrip : 'Congregación Nacional'}
										,{numero: 28,descrip : 'Congregación Nacional'}
										,{numero: 31,descrip : 'Congregación Distrito'}
										,{numero: 30,descrip : 'Congregación Distrito'}
										,{numero: 34,descrip : 'nombre_usuario'}
										,{numero: 35,descrip : 'clave_usuario'}
										,{numero: 32,descrip : 'Congregación Local'}
										,{numero: 33,descrip : 'Congregación Local'}
										,{numero: 38,descrip : 'F.Registro'}
										,{numero: 36,descrip : 'Estado'}
										,{numero: 37,descrip : 'Estado'}
									      ]
								}
							}
							,{
								xtype : 'combobox',
								name : 'orderDirecction',
								fieldLabel : 'Dirección',
								valueField : 'name',
								displayField : 'descrip',
								value: 'ASC',
								store : {
									fields: ['name','descrip'],
									data: [{name: 'ASC',descrip : 'Ascendente'},{name: 'DESC',descrip : 'Descendente'}]
								}
							}
                            ]
                  }

            
        ];

        this.callParent(arguments);
    }
});