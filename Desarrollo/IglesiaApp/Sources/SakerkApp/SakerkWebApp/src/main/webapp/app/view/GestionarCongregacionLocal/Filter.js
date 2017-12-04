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

Ext.define('MyApp.view.GestionarCongregacionLocal.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarCongregacionLocalFilter',
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
								xtype : 'textfield',
								name : 'id_persona',
								fieldLabel : 'Id'
							}
							,{
								hidden : true,
								xtype : 'textfield',
								name : 'id_persona_juridica',
								fieldLabel : 'id_persona_juridica'
							}
							,{
								store : {
									fields: ['id_congregacion_general','nombre_congregacion'],
									proxy: {
												type: 'ajax',
												url: 'listaCongregacionDistrito.action',
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
								xtype : 'combobox',
								name : 'id_congregacion_general',
								value : '',
								valueField : 'id_congregacion_general',
								fieldLabel : 'Congregación Distrito'
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
								xtype : 'combobox',
								name : 'id_pais',
								value : '',
								valueField : 'id_pais',
								fieldLabel : 'Pais'
							}
							,{
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
								xtype : 'combobox',
								name : 'cod_depto',
								value : '',
								valueField : 'cod_depto',
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
								xtype : 'combobox',
								name : 'cod_prov',
								value : '',
								valueField : 'cod_prov',
								fieldLabel : 'Provincia'
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
								xtype : 'combobox',
								name : 'id_ubigeo',
								value : '',
								valueField : 'id_ubigeo',
								fieldLabel : 'Distrito'
							}
							,{
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
								xtype : 'combobox',
								name : 'id_estado',
								value : '',
								valueField : 'valor_general',
								fieldLabel : 'Estado',
								editable : false
							}
							,{
								xtype : 'textfield',
								name : 'razon_social',
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
								xtype : 'combobox',
								name : 'orderColumn',
								fieldLabel : 'Ordenar por',
								valueField : 'numero',
								displayField : 'descrip',
								store : {
									fields: ['numero','descrip'],
									data: [
										{numero: 1,descrip : 'Id'}
										,{numero: 2,descrip : 'id_persona_juridica'}
										,{numero: 3,descrip : 'id_congregacion_local'}
										,{numero: 4,descrip : 'Congregación Distrito'}
										,{numero: 5,descrip : 'id_ubicacion_geografica'}
										,{numero: 6,descrip : 'Congregación Distrito'}
										,{numero: 7,descrip : 'Congregación Local'}
										,{numero: 8,descrip : 'Email'}
										,{numero: 9,descrip : 'Pais'}
										,{numero: 10,descrip : 'Pais'}
										,{numero: 11,descrip : 'Departamento'}
										,{numero: 12,descrip : 'Departamento'}
										,{numero: 13,descrip : 'Provincia'}
										,{numero: 14,descrip : 'Provincia'}
										,{numero: 15,descrip : 'Distrito'}
										,{numero: 17,descrip : 'Dirección'}
										,{numero: 16,descrip : 'Distrito'}
										,{numero: 19,descrip : 'cor_y'}
										,{numero: 18,descrip : 'cor_x'}
										,{numero: 21,descrip : 'Estado'}
										,{numero: 20,descrip : 'Estado'}
										,{numero: 22,descrip : 'F.Registro'}
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