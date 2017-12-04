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

Ext.define('MyApp.view.GestionaNomina.Totales', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionaNominaTotales',
    requires: ['Ext.form.Panel'],
    
    id:'form_totales_GestionaNomina',
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
								editable : false,
								fieldLabel : 'Cantidad',
								name : 'cantidad_nominas',
								disabled : false
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : false,
								fieldLabel : 'Total Ingresos',
								name : 'total_ingresos',
								disabled : false,
								fieldStyle: 'text-align:right;font-weight: bold;'
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : false,
								fieldLabel : 'Total Descuentos',
								name : 'total_descuentos',
								disabled : false,
								fieldStyle: 'text-align:right;font-weight: bold;'
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : false,
								fieldLabel : 'Total Aportes',
								name : 'total_aportes',
								disabled : false,
								fieldStyle: 'text-align:right;font-weight: bold;'
							}
							,{
								xtype : 'textfield',
								hidden : false,
								editable : false,
								fieldLabel : 'Total Neto',
								name : 'total_neto',
								disabled : false,
								fieldStyle: 'text-align:right;font-weight: bold;'
							}
							
							
						]
					}
					
        ];

        this.callParent(arguments);
    }
});