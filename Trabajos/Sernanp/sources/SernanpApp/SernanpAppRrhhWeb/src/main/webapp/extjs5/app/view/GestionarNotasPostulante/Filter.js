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

Ext.define('MyApp.view.GestionarNotasPostulante.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarNotasPostulanteFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarNotasPostulante',
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
								fieldLabel : 'srl_id_postulante_conv_area_org',
								name : 'srl_id_postulante_conv_area_org',
								disabled : false
							}
							,{
								xtype : 'textfield',
								hidden : true,
								editable : true,
								fieldLabel : 'Id',
								name : 'srl_conv_area_org_factor_eval',
								disabled : false
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});