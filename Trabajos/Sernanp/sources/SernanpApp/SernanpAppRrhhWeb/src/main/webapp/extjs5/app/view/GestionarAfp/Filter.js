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

Ext.define('MyApp.view.GestionarAfp.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarAfpFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarAfp',
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
								hidden : false,
								xtype : 'textfield',
								name : 'srl_id_afp',
								vtype : 'soloNumeros',
								fieldLabel : 'Nro.',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'var_cod_afp',
								fieldLabel : 'Código AFP',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'var_nombre_afp',
								fieldLabel : 'Nombre AFP',
								disabled : false,
								editable : true
							}
							,{
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
								queryMode : 'local',
								displayField : 'destablatipo',
								hidden : false,
								xtype : 'combobox',
								name : 'int_id_estado',
								value : '',
								valueField : 'codinttablatipo',
								fieldLabel : 'Tipo Estado',
								disabled : false,
								editable : true
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});