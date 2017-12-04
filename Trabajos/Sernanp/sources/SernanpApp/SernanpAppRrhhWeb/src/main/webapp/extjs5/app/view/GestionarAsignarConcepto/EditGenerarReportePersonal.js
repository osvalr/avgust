/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
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
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 08/04/2015 00:02:56
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAsignarConcepto.EditGenerarReportePersonal', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarAsignarConceptoEditGenerarReportePersonal',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 300,
    title:'Generar Reporte Personal',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
							{
				                xtype: 'form',
				                id: 'form_generar_jor',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'qtip',
                    				labelWidth: 125
			                	},

		                		items: [
											,{
								queryMode : 'local',
								xtype : 'combobox',
								hidden : false,
								editable : true,
								fieldLabel : 'Estado',
								name : 'int_estado',
								displayField : 'var_nombre_estado',
								disabled : false,
								store : {
									fields: ['var_cod_estado','var_nombre_estado'],
									proxy: {
												type: 'ajax',
												url: 'obtener-estados.action?nom_tabla_estado=personal',
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
								valueField : 'var_cod_estado',
								value : 0
							}
											
										]
							}

        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf013@FontAwesome',
                text: 'Generar Reporte',
                action: 'generarReportePersonal'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_generar_reporte_personal_statusbar'
        })];

        this.callParent(arguments);      
    }
});
