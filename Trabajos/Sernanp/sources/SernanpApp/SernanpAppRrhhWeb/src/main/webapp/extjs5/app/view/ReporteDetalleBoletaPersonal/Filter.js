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

Ext.define('MyApp.view.ReporteDetalleBoletaPersonal.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.ReporteDetalleBoletaPersonalFilter',
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
								name : 'int_anio',
								fieldLabel : 'int_anio'
							}
							,{
								xtype : 'textfield',
								name : 'idpersonal',
								fieldLabel : 'idpersonal'
							}
							,{
								xtype : 'textfield',
								name : 'int_id_periodo_mes',
								fieldLabel : 'int_id_periodo_mes'
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
								editable:false,
								store : {
									fields: ['numero','descrip'],
									data: [
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
								editable:false,
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