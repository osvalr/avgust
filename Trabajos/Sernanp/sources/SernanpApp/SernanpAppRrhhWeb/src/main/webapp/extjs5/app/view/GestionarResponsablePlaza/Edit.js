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
* DATE CREATE : 17/04/2015 16:51:57
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarResponsablePlaza.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarResponsablePlazaEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
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
				                id: 'form_crud_GestionarResponsablePlaza',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información del Personal',
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
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    name : 'idpersona',
											    disabled : false,
											    readOnly : false
											},
											{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    name : 'idpersonanatural',
											    disabled : false,
											    readOnly : false
											},
											{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Id',
											    name : 'idpersonal',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Nombres',
											    name : 'nombre_completo',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Tipo Documento',
											    name : 'descrip_documento',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Número',
											    name : 'numerodoc',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'R.U.C',
											    name : 'ruc',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    fieldLabel : 'tokenField',
											    name : 'tokenField'
											}
										]
							}
							

							,{
					    		title: 'Plazas',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_ResponsablePlazaQuery', xtype:'ResponsablePlazaQueryList'}]
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
            id: 'form_crud_GestionarResponsablePlaza_statusbar'
        })];

        this.callParent(arguments);      
    }
});
