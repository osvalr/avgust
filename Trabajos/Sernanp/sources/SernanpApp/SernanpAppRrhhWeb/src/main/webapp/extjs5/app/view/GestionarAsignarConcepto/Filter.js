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

Ext.define('MyApp.view.GestionarAsignarConcepto.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarAsignarConceptoFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarAsignarConcepto',
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
								name : 'idpersonal',
								disabled : false
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Nombres',
								name : 'nombres_completos',
								disabled : false
							}
							,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
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
							}
							,{
								xtype : 'textfield',
								hidden : true,
								editable : true,
								fieldLabel : 'R.U.C',
								name : 'ruc',
								disabled : false
							}
							,
							{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Régimen Contractual',
								name : 'srl_id_regimen_contractual',
								displayField : 'var_descripcion_regimen_contractual',
								disabled : false,
								store : {
									fields: ['srl_id_regimen_contractual','var_descripcion_regimen_contractual'],
									proxy: {
												type: 'ajax',
												url: 'obtener-valores-regimen-contractual.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { srl_id_regimen_contractual:'',var_descripcion_regimen_contractual:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								valueField : 'srl_id_regimen_contractual',
								value : ''
							}
							,
							{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Estado',
								name : 'int_estado',
								displayField : 'var_nombre_estado',
								disabled : false,
								store : {
									fields: ['var_cod_estado','var_nombre_estado'],
									proxy: {
												type: 'ajax',
												url: 'obtener-estados.action?nom_tabla_estado=personal',
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
								value : 0
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
							
						]
					}
        ];

        this.callParent(arguments);
    }
});