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

Ext.define('MyApp.view.GestionarMetaFuenteGenerica.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarMetaFuenteGenericaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarMetaFuenteGenerica',
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
								hidden : false,
								editable : true,
								fieldLabel : 'Id',
								name : 'srl_id_meta_fuente_generica',
								disabled : false
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Año',
								name : 'srl_id_anio_planilla',
								displayField : 'int_anio',
								disabled : false,
								store : {
									fields: ['srl_id_anio_planilla','int_anio'],
									proxy: {
												type: 'ajax',
												url: 'obtener-anios-planilla.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_anio_planilla:'',int_anio:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_anio_planilla',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Meta Presupuestaria',
								name : 'srl_id_meta_presupuestaria',
								displayField : 'var_descripcion',
								disabled : false,
								store : {
									fields: ['srl_id_meta_presupuestaria','var_descripcion'],
									proxy: {
												type: 'ajax',
												url: 'obtener-lista-meta-presupuestaria.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_meta_presupuestaria:'',var_descripcion:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_meta_presupuestaria',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : false,
								fieldLabel : 'Fuente Fto',
								name : 'srl_id_fuente_financiamiento',
								displayField : 'var_rubro_fte_fto',
								disabled : false,
								store : {
									fields: ['srl_id_fuente_financiamiento','var_rubro_fte_fto'],
									proxy: {
												type: 'ajax',
												url: 'obtener-lista-fuente-financiamiento.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_fuente_financiamiento:'',var_rubro_fte_fto:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_fuente_financiamiento',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								listeners : {
									change: function(field, newValue, oldValue) {

										var on_field = form.getForm().findField('srl_id_clasificador');
										on_field.setDisabled(true);
										on_field.store.removeAll();
										on_field.store.reload({
											params: {
												srl_id_generica_gasto: field.getValue()
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
								fieldLabel : 'Genérica de Gasto',
								name : 'srl_id_generica_gasto',
								displayField : 'var_descrip_generica_gasto',
								disabled : false,
								store : {
									fields: ['srl_id_generica_gasto','var_descrip_generica_gasto'],
									proxy: {
												type: 'ajax',
												url: 'obtener-lista-generica-gasto.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_generica_gasto:'',var_descrip_generica_gasto:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_generica_gasto',
								value : ''
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Clasificador',
								name : 'srl_id_clasificador',
								displayField : 'var_descrip_clasificador',
								disabled : false,
								store : {
									fields: ['srl_id_clasificador','var_descrip_clasificador'],
									proxy: {
												type: 'ajax',
												url: 'obtener-lista-clasificador.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: false,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_clasificador:'',var_descrip_clasificador:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_clasificador',
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
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Estado',
								name : 'int_id_estado',
								displayField : 'destablatipo',
								disabled : false,
								store : {
									fields: ['codinttablatipo','destablatipo'],
									proxy: {
												type: 'ajax',
												url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Generico',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { codinttablatipo:'',destablatipo:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'codinttablatipo',
								value : ''
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});