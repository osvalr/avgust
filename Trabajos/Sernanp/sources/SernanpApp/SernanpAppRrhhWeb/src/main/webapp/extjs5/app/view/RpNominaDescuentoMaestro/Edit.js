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
* DATE CREATE : 01/06/2015 19:30:15
* VERSION : 1.0 
*/

Ext.define('MyApp.view.RpNominaDescuentoMaestro.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.RpNominaDescuentoMaestroEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 350,

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_RpNominaDescuentoMaestro',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Title',
				                glyph:'xf022@FontAwesome',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'qtip',
                    				labelWidth: 125
			                	},

		                		items: [
											{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'idpersonal',
											    fieldLabel : 'idpersonal'
											}
											,{
											    xtype : 'textfield',
											    name : 'nombre_completo',
											    fieldLabel : 'nombre_completo'
											}
											,{
											    xtype : 'textfield',
											    name : 'numerodoc',
											    fieldLabel : 'numerodoc'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_contractual',
											    fieldLabel : 'var_descripcion_regimen_contractual'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_anio',
											    fieldLabel : 'int_anio'
											}
											,{
											    xtype : 'textfield',
											    name : 'descrip_periodo',
											    fieldLabel : 'descrip_periodo'
											}
											,{
											    xtype : 'textfield',
											    name : 'remuneracion',
											    fieldLabel : 'remuneracion'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_total_descuentos',
											    fieldLabel : 'dec_total_descuentos'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'tokenField',
											    fieldLabel : 'tokenField'
											}
										]
							}
							


                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            //id:'buttons',
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
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_RpNominaDescuentoMaestro_statusbar'
        })];

        this.callParent(arguments);      
    }
});