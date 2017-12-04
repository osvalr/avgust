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

Ext.define('MyApp.view.GestionarEstudio.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarEstudioFilter',
    requires: ['Ext.form.Panel'],
    
    initComponent: function() {
        this.items = [
                {
                	xtype: 'container',
                	layout: {
                		type: 'hbox',
                		align: 'stretch'
                	},
                	items: [
							{
								id : 'filter_GestionarEstudio_id_estudio',
								hidden : false,
								xtype : 'textfield',
								name : 'id_estudio',
								fieldLabel : 'Id'
							}
							,{
								id : 'filter_GestionarEstudio_id_categoria_estudio',
								store : {
									fields: ['valor_general','campo_a'],
										proxy: {
											type: 'ajax',
											url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Categoria_Estudio',
											reader: {
												type: 'json',
												rootProperty: 'listRecords'
											}
										},
										autoLoad: true
								},
								queryMode : 'local',
								displayField : 'campo_a',
								hidden : false,
								xtype : 'combobox',
								name : 'id_categoria_estudio',
								valueField : 'valor_general',
								emptyText : '-- Seleccione Opción --',
								fieldLabel : 'Categoría Estudio'
							}
							,{
								id : 'filter_GestionarEstudio_nombre_estudio',
								hidden : false,
								xtype : 'textfield',
								name : 'nombre_estudio',
								fieldLabel : 'Nombre'
							}
							,{
								id : 'filter_GestionarEstudio_id_estado',
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
								queryMode : 'local',
								displayField : 'campo_a',
								hidden : false,
								xtype : 'combobox',
								name : 'id_estado',
								valueField : 'valor_general',
								emptyText : '-- Seleccione Opción --',
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
										,{numero: 2,descrip : 'Categoría Estudio'}
										,{numero: 3,descrip : 'Categoría Estudio'}
										,{numero: 4,descrip : 'Nombre'}
										,{numero: 5,descrip : 'Estado'}
										,{numero: 6,descrip : 'Estado'}
										,{numero: 7,descrip : 'F.Registro'}
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