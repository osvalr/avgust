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

Ext.define('MyApp.view.ConvocatoriaPlaza.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.ConvocatoriaPlazaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_ConvocatoriaPlaza',
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
								store : {
									fields: ['var_num_convocatoria','var_num_convocatoria_corto'],
									proxy: {
												type: 'ajax',
												url: 'obtener-lista-numero-convocatoria.action',
												reader: {
													type: 'json',
													rootProperty: 'listResult'
												}
									},
									autoLoad: true,
									listeners: {
								        load: function(store) {
								        	var rec = { var_num_convocatoria:'',var_num_convocatoria_corto:'-- Todos --' };
								        	store.insert(0, rec);
								        }
									}
								},
								queryMode : 'local',
								displayField : 'var_num_convocatoria_corto',
								hidden : false,
								xtype : 'combobox',
								name : 'var_num_convocatoria',
								value : '',
								valueField : 'var_num_convocatoria',
								fieldLabel : 'Nro. de Convocatoria',
								disabled : false,
								editable : true
							}
							,{
								hidden : false,
								xtype : 'textfield',
								name : 'int_num_activacion',
								fieldLabel : 'Nº de Lanzamiento',
								disabled : false,
								editable : true,
								vtype : 'soloNumeros'
							}
				
							,{
								store : {
									fields: ['var_cod_estado','var_nombre_estado'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'obtener-estado-convocatoria.action',
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
								queryMode : 'local',
								displayField : 'var_nombre_estado',
								hidden : false,
								xtype : 'combobox',
								name : 'int_id_estado',
								value : '',
								valueField : 'var_cod_estado',
								fieldLabel : 'Estado',
								disabled : false,
								editable : false
							}
							
							
						]
					}
        ];

        this.callParent(arguments);
    }
});