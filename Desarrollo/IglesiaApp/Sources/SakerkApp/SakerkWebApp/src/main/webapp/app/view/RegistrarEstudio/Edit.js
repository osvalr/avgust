/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
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
* DATE CREATE : 01/01/2015 21:59:41
* VERSION : 1.0 
*/

Ext.define('MyApp.view.RegistrarEstudio.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.RegistrarEstudioEdit',

    requires: ['Ext.form.Panel'],

    title : '',
    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
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
				                id: 'form_crud_RegistrarEstudio',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'RegistrarEstudio',
				                glyph:'xf022@FontAwesome',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'side'
			                	},

		                		items: [
											{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'id_estudio',
											    fieldLabel : 'Id'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'id_categoria_estudio',
											    fieldLabel : 'id_categoria_estudio'
											}
											,{
												allowBlank: true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'id_form',
											    fieldLabel : 'id_form'
											}
											,{
												allowBlank: true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'name_field',
											    fieldLabel : 'name_field'
											}
											,{
											    allowBlank : true,
											    maxLength : 500,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'nombre_estudio',
											    fieldLabel : 'Nombre Estudio'
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
        }];

        this.callParent(arguments);      
    }
});
