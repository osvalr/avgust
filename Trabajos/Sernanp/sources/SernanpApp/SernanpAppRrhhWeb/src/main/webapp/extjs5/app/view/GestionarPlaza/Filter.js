/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
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
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
 * GENERATOR CRUD EXT JS 5 BY FOCUS CONSULTORES ASOCIADOS SAC 
 * DATE CREATE : 09/11/2014 02:30:50 
 * VERSION : 1.0
 */

Ext.define('MyApp.view.GestionarPlaza.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarPlazaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarPlaza',
	layout: {
        type: 'vbox'
    },
    fieldDefaults: {
        labelAlign: 'top',
        margin: "0 5 5 5"
    },
                                
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
								queryMode : 'local',
								xtype : 'combobox',
								listeners : {
									change: function(field, newValue, oldValue) {

										var on_field = form.getForm().findField('idunidad');
										on_field.setDisabled(true);
										on_field.store.removeAll();
										on_field.store.reload({
											params: {
												idAreaOrganica: field.getValue()
											}
										});
										on_field.setDisabled(false);
										if(oldValue != null){
											on_field.setValue('');
										}
									}
								},
								hidden : false,
								editable : true,
								fieldLabel : 'Área Organica',
								name : 'idarea',
								displayField : 'descrip_dependencia',
								disabled : false,
								store : {
									fields: ['idarea','descrip_dependencia'],
									proxy: {
												type: 'ajax',
												url: 'obtener-areas-organicas.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { idarea:'',descrip_dependencia:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'idarea',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Unidad Operativa',
								name : 'idunidad',
								displayField : 'nomunidad',
								disabled : false,
								store : {
									fields: ['idunidad','nomunidad'],
									proxy: {
												type: 'ajax',
												url: 'obtener-unidad-operativa.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: false,
									listeners: {
								        load: function(store) {
								        	var rec = { idunidad:'',nomunidad:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'idunidad',
								value : ''
							}
//							,{
//								queryMode : 'local',
//								xtype : 'combobox',
//								hidden : false,
//								editable : true,
//								fieldLabel : 'Personal',
//								name : 'idpersonal',
//								displayField : 'nombres_completos',
//								disabled : false,
//								store : {
//									fields: ['idpersonal','nombres_completos'],
//									proxy: {
//												type: 'ajax',
//												url: 'obtener-lista-personal.action',
//												reader: {
//													type: 'json',
//													rootProperty: 'listResult'
//												}
//									},
//									autoLoad: true,
//									listeners: {
//								        load: function(store) {
//								        	var rec = { idpersonal:'',nombres_completos:'-- Todos --' };
//								        	store.insert(0, rec);
//								        }
//									}
//								},
//								valueField : 'idpersonal',
//								value : ''
//							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								listeners : {
									change: function(field, newValue, oldValue) {

										var on_field = form.getForm().findField('srl_id_conv_area_org');
										on_field.setDisabled(true);
										on_field.store.removeAll();
										on_field.store.reload({
											params: {
												srl_id_convocatoria: field.getValue()
											}
										});
										on_field.setDisabled(false);
										if(oldValue != null){
											on_field.setValue('');
										}
									}
								},
								hidden : false,
								editable : true,
								fieldLabel : 'Convocatoria',
								name : 'srl_id_convocatoria',
								displayField : 'var_num_convocatoria',
								disabled : false,
								store : {
									fields: ['srl_id_convocatoria','var_num_convocatoria'],
									proxy: {
												type: 'ajax',
												url: 'obtener-convocatorias.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_convocatoria:'',var_num_convocatoria:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_convocatoria',
								value : ''
							}
							
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Plaza',
								name : 'srl_id_conv_area_org',
								displayField : 'var_codigo_postulacion',
								disabled : false,
								store : {
									fields: ['srl_id_conv_area_org','var_codigo_postulacion'],
									proxy: {
												type: 'ajax',
												url: 'obtener-Lista-codpostulacion-por-lanzamiento.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: false,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_conv_area_org:'',var_codigo_postulacion:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_conv_area_org',
								value : ''
							}
							/*
							,{
								xtype : 'numberfield',
								fieldLabel : 'Nro Requerimiento',
								name : 'num_req'
							}
							*/
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Estado',
								name : 'int_id_estado',
								displayField : 'var_nombre_estado',
								disabled : false,
								store : {
									fields: ['var_cod_estado','var_nombre_estado'],
									proxy: {
												type: 'ajax',
												url: 'obtener-estados.action?nom_tabla_estado=t_convocatoria_area_org',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { var_cod_estado:'',var_nombre_estado:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'var_cod_estado',
								value : ''
							}
						]
					}

        ];

        this.callParent(arguments);
    }
});