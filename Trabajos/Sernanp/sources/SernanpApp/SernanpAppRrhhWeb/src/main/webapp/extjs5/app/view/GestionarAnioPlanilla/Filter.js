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

Ext.define('MyApp.view.GestionarAnioPlanilla.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarAnioPlanillaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarAnioPlanilla',
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
								hidden : true,
								xtype : 'textfield',
								name : 'srl_id_anio_planilla',
								vtype : 'soloNumeros',
								fieldLabel : 'Nro.',
								disabled : false,
								editable : true
							}
							,{
								hidden : true,
								xtype : 'textfield',
								name : 'var_cod_ejecutor',
								vtype : 'soloNumeros',
								fieldLabel : 'Código Ejecutor',
								disabled : false,
								editable : true
							}
							,{
								
								
								hidden : false,
								xtype : 'textfield',
								name : 'int_anio',
								vtype : 'soloNumeros',
								fieldLabel : 'Año',
								disabled : false,
								editable : true		
							}
							,{
								hidden : true,
								xtype : 'datefield',
								name : 'dte_fecha_inicio',
								fieldLabel : 'Fecha Inicio',
								disabled : false,
								editable : true
							}
							,{
								hidden : true,
								xtype : 'datefield',
								name : 'dte_fecha_fin',
								fieldLabel : 'Fecha Fin ',
								disabled : false,
								editable : true
							}
						]
					}
        ];

        this.callParent(arguments);
    }
});