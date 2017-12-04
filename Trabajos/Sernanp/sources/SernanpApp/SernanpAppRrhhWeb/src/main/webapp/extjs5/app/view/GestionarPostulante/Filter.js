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

Ext.define('MyApp.view.GestionarPostulante.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarPostulanteFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarPostulante',
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
								xtype : 'textfield',
								hidden : true,
								editable : true,
								fieldLabel : 'Id',
								name : 'idpersonanatural',
								disabled : false
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Nombres',
								name : 'nombres_completos',
								disabled : false,
								fieldStyle:'text-transform: uppercase',
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : false,
								fieldLabel : 'Tipo Documento',
								name : 'idtipodocumento',
								displayField : 'abrtablatipo',
								disabled : false,
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
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { idtablatipo:'',abrtablatipo:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'idtablatipo',
								value : ''
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Número Documento',
								name : 'numerodoc',
								disabled : false
							},
							{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'R.U.C',
								name : 'ruc',
								disabled : false
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : false,
								fieldLabel : 'Genero',
								name : 'idsexo',
								displayField : 'destablatipo',
								disabled : false,
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
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { idtablatipo:'',destablatipo:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'idtablatipo',
								value : ''
							},
							
							{
								queryMode : 'local',
								xtype : 'combobox',
								listeners : {
									change: function(field, newValue, oldValue) {

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
								editable : true,
								fieldLabel : 'Departamento',
								name : 'coddpto',
								displayField : 'nombre',
								disabled : false,
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
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { coddpto:'',nombre:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'coddpto',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								listeners : {
									change: function(field, newValue, oldValue) {

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
								editable : true,
								fieldLabel : 'Provincia',
								name : 'codprov',
								displayField : 'nombre',
								disabled : false,
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
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { codprov:'',nombre:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'codprov',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Departamento',
								name : 'idubigeo',
								displayField : 'nombre',
								disabled : false,
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
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { idubigeo:'',nombre:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'idubigeo',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Pais',
								name : 'idpais',
								displayField : 'nompais',
								disabled : false,
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
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { idpais:'',nompais:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'idpais',
								value : ''
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
								queryMode : 'local',
								displayField : 'var_num_convocatoria',
								hidden : false,
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
								name : 'srl_id_convocatoria',
								value : '',
								valueField : 'srl_id_convocatoria',
								fieldLabel : 'Nro. de Convocatoria',
								disabled : false,
								editable : true
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
								value : '',
								matchFieldWidth: false,
								width : 250
							}
							
							/*FILTER UNIDAD OPERATIVA*/
							
							/*start*/
							
							,{								
							    store : {
							    	fields: ['srl_id_sede_req_sel','sede_administrativa_req_sel'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'obtener-sede-administrativa.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_sede_req_sel:'',sede_administrativa_req_sel:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
							    },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'sede_administrativa_req_sel',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'srl_id_sede_req_sel',
							    valueField : 'srl_id_sede_req_sel',
							    emptyText : '-- Seleccione Opción --',
							    fieldLabel : 'Sede Administrativa',
							    disabled : false,
							    editable : false
							    ,
							    matchFieldWidth:false,
							    width : 250,
								value : ''
							    
							},
							/*end*/
							
							/*END */
							
							
							,{
							    queryMode : 'local',
//								allowBlank : true,
								xtype : 'combobox',
								hidden : false,
								emptyText : '-- Seleccione Opción --',
								editable : true,
//								readOnly : false,
								store : {
									fields: ['codinttablatipo','destablatipo'],
									proxy: {
								         type: 'ajax',
								         /*ADD David 31-08-2015 	: 	OBTENER TIPOS DE EVALUACION*/
//								         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Factor_Evaluacion',
								         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Factor_Evaluacion&codIntTablaTipo=-1',
								         reader: {
								             type: 'json',
								             rootProperty: 'listResult'
								         }
							    	},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { codinttablatipo:'',destablatipo:'-- Todas --' };
								        	store.insert(0, rec);
								        }
									}
							    },
								valueField : 'codinttablatipo',
								value:'',
								fieldLabel : 'Etapa Evaluación',
								name : 'int_id_tipo_factor',
								displayField : 'destablatipo',
								disabled : false,
							    matchFieldWidth: false,
							    width: '250px'
							}
							
							,{
								queryMode: 'local',
								editable : true,
								xtype : 'combobox',
								name : 'int_id_estado_postulante',
								fieldLabel : 'Estado Contrato',
								displayField: 'estado',
								valueField: 'codigo',
								value : '',
								store: {
								    fields: ['codigo', 'estado'],
								    data : [
								        {"codigo":'', "estado":"-- Todos --"},
								        {"codigo":"3", "estado":"Suscrito"},
								        {"codigo":"6", "estado":"No Suscrito"}								     
								  
								    ],
								    autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { codigo:'',estado:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}						
								}
																
							}
                	        
							
						]
					}
        ];

        this.callParent(arguments);
    }
});