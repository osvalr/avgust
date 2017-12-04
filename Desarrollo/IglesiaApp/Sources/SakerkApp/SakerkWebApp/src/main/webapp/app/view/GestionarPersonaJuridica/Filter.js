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

Ext.define('MyApp.view.GestionarPersonaJuridica.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarPersonaJuridicaFilter',
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
								xtype : 'textfield',
								name : 'id_persona_juridica',
								fieldLabel : 'id_persona_juridica'
							}
							,{
								xtype : 'textfield',
								name : 'razon_social',
								fieldLabel : 'Razón Social'
							}
							,{
								xtype : 'textfield',
								name : 'numero_ruc',
								fieldLabel : 'R.U.C'
							}
							,{
								store : {
									fields: ['valor_general','campo_a'],
									proxy: {
												type: 'ajax',
												url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Tipo_Persona_Juridica',
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
								name : 'id_tipo_persona_juridica',
								value : '',
								valueField : 'valor_general',
								fieldLabel : 'Tipo Persona Juridica'
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
										,{numero: 2,descrip : 'id_persona_juridica'}
										,{numero: 3,descrip : 'Razón Social'}
										,{numero: 4,descrip : 'R.U.C'}
										,{numero: 5,descrip : 'Tipo Persona Juridica'}
										,{numero: 6,descrip : 'Tipo Persona Juridica'}
										,{numero: 7,descrip : 'Email'}
										,{numero: 8,descrip : 'Nacionalidad'}
										,{numero: 9,descrip : 'Nacionalidad'}
										,{numero: 10,descrip : 'Estado'}
										,{numero: 11,descrip : 'Estado'}
										,{numero: 12,descrip : 'F.Registro'}
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