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
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 01/12/2014 19:55:03
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarTablaGeneral.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarTablaGeneralEdit',

    requires: ['Ext.form.Panel'],

    title : '',
    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    width: '65%',
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Tabla General',
				                glyph:'xf0ce@FontAwesome',
				                
				                fieldDefaults: {
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'side'
			                	},

		                		items: [
											{
											    id : 'GestionarTablaGeneral_id_tabla_general',
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'id_tabla_general',
											    fieldLabel : 'Id'
											}
											,{
											    id : 'GestionarTablaGeneral_nombre_tabla_general',
											    maxLength : 200,
											    minLength : 1,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'nombre_tabla_general',
											    fieldLabel : 'Nombre'
											}
											,{
											    id : 'GestionarTablaGeneral_fecha_registro',
											    allowBlank : true,
											    hidden : true,
											    xtype : 'datefield',
											    name : 'fecha_registro',
											    format : 'd/m/Y',
											    fieldLabel : 'F.Registro'
											}
										]
							}
							

							,{
					    		title: 'Items Tabla General',
					    		glyph:'xf0c1@FontAwesome',
					    		items: [{id:'detailTablaGeneralDetalleQuery', xtype:'TablaGeneralDetalleQueryList'}]
							}

                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            id:'buttons',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf0c7@FontAwesome',
                itemId: 'save',
                text: 'Grabar',
                action: 'save'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);      
    }
});
