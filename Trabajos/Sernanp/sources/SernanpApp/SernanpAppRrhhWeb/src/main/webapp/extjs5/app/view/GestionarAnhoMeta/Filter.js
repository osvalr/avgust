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

Ext.define('MyApp.view.GestionarAnhoMeta.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarAnhoMetaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarAnhoMeta',
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
								name : 'srl_id_anio_meta',
								disabled : false
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : false,
								fieldLabel : 'Año',
								name : 'srl_id_anio_planilla',
								displayField : 'int_anio',
								disabled : false,
								store : {
									fields: ['srl_id_anio_planilla','int_anio'],
									proxy: {
												type: 'ajax',
												url: 'obtener-todos-anios-planilla.action',
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
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Meta',
								name : 'cod_meta',
								disabled : false
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});