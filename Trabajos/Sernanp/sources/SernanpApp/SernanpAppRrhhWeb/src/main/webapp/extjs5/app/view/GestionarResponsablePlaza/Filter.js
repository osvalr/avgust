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

Ext.define('MyApp.view.GestionarResponsablePlaza.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarResponsablePlazaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarResponsablePlaza',
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
								name : 'idpersonal',
								disabled : false
							},
							{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Nombres',
								name : 'nombre_completo',
								disabled : false
							},
							{
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
							},
							{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'Número',
								name : 'numerodoc',
								disabled : false
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : true,
								fieldLabel : 'R.U.C',
								name : 'ruc',
								disabled : false
							}
							
						]
					}

        ];

        this.callParent(arguments);
    }
});