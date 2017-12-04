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

Ext.define('MyApp.view.GestionarCongregacion.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarCongregacionFilter',
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
								name : 'id_congregacion_general',
								fieldLabel : 'Id'
							}
							,{
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
								name : 'id_congregacion_padre',
								value : '',
								valueField : 'id_congregacion_general',
								fieldLabel : 'Congregacion Padre'
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'nombre_congregacion',
								fieldLabel : 'Nombre'
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
								hidden : false,
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
										{numero: 2,descrip : 'Id'}
										,{numero: 4,descrip : 'Nombre'}
										,{numero: 5,descrip : 'Congregacion Padre'}
										,{numero: 7,descrip : 'Estado'}
										,{numero: 8,descrip : 'F.Registro'}
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