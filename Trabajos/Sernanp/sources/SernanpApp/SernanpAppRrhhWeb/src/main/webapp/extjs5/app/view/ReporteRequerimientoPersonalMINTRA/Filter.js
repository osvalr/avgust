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

Ext.define('MyApp.view.ReporteRequerimientoPersonalMINTRA.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.ReporteRequerimientoPersonalMINTRAFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_ReporteRequerimientoPersonalMINTRA',
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
							    	fields: ['idarea','desarea'],
							    	proxy: {
							    		type: 'ajax',
							    		url: 'listar-area-organica.action',
							    		reader: {
							    			type: 'json',
							    			rootProperty: 'listResult'
							    		}
							    	},
							    	autoLoad: true,
							   },
							    allowBlank : true,
							    queryMode : 'local',
							    displayField : 'desarea',
							    hidden : false,
							    xtype : 'combobox',
							    name : 'idarea_solicitante',
							    valueField : 'idarea',
							    emptyText : '-- Seleccione Opción --',
							    fieldLabel : 'Área Solicitante',
							    disabled : false,
							    editable : true
							},
						
							{
								xtype : 'textfield',
								name : 'var_denominacion_requerimiento',
								fieldLabel : 'Denominación Requerimiento'
							},
//							{
//								 store : {
//								    	fields: ['var_cod_estado','var_nombre_estado'],
//								    	proxy: {
//								    		type: 'ajax',
//								    		url: 'obtener-estados.action?nom_tabla_estado=t_requerimiento_personal',
//								    		reader: {
//								    			type: 'json',
//								    			rootProperty: 'listResult'
//								    		}
//								    	},
//								    	autoLoad: true,
//										listeners: {
//									        load: function(store) {
//									        	var rec = { var_cod_estado:'',var_nombre_estado:'-- Todos --' };
//									        	store.insert(0, rec);
//									        }
//										}
//								   },
//								allowBlank : true,
//								queryMode : 'local',
//								displayField : 'var_nombre_estado',
//								hidden : false,
//								xtype : 'combobox',
//								name : 'int_id_estado',
//								fieldLabel : 'Estado',
//								valueField : 'var_cod_estado',
//								emptyText : '-- Seleccione Opción --',								
//								disabled : false,
//								editable : true
//					
//							}
							
						]
					}
        ];

        this.callParent(arguments);
    }
});