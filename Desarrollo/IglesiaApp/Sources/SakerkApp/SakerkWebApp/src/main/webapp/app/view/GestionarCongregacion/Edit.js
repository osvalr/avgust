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
* DATE CREATE : 20/12/2014 22:23:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarCongregacion.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarCongregacionEdit',

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
				                id: 'form_crud_GestionarCongregacion',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'GestionarCongregacion',
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
											    name : 'id_congregacion_general',
											    fieldLabel : 'Id'
											}
											,{
											    store : {
											    	fields: ['id_congregacion_general','nombre_congregacion'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'listaCongregacionPorReferido.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listRecords'
											    		}
											    	},
											    	autoLoad: true
											    },
											    allowBlank : true,
											    queryMode : 'local',
											    displayField : 'nombre_congregacion',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'id_congregacion_padre',
											    valueField : 'id_congregacion_general',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Congregacion Padre'
											}
											,{
											    allowBlank : true,
											    maxLength : 200,
											    minLength : 1,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'nombre_congregacion',
											    fieldLabel : 'Nombre'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'nombre_congregacion_padre',
											    fieldLabel : 'Congregacion Padre'
											}
											,{
											    store : {
											    	fields: ['valor_general','campo_a'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Estado_Generico',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listRecords'
											    		}
											    	},
											    	autoLoad: true
											    },
											    allowBlank : true,
											    queryMode : 'local',
											    displayField : 'campo_a',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'id_estado',
											    valueField : 'valor_general',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Estado'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'descrip_estado',
											    fieldLabel : 'Estado'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'datefield',
											    name : 'fecha_registro',
											    format : 'd/m/Y',
											    fieldLabel : 'F.Registro'
											}
										]
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
