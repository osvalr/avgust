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
* DATE CREATE : 20/01/2015 13:21:31
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPersonaJuridica.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarPersonaJuridicaEdit',

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
				                id: 'form_crud_GestionarPersonaJuridica',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'GestionarPersonaJuridica',
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
											    name : 'id_persona',
											    fieldLabel : 'Id'
											}
											,{
											    allowBlank : true,
											    maxLength : 250,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'razon_social',
											    fieldLabel : 'Razón Social'
											}
											,{
											    allowBlank : true,
											    maxLength : 11,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'numero_ruc',
											    fieldLabel : 'R.U.C'
											}
											,{
											    store : {
											    	fields: ['valor_general','campo_a'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Tipo_Persona_Juridica',
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
											    name : 'id_tipo_persona_juridica',
											    valueField : 'valor_general',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Tipo Persona Juridica'
											}
											,{
											    allowBlank : true,
											    maxLength : 150,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'email',
											    fieldLabel : 'Email'
											}
											,{
											    store : {
											    	fields: ['id_pais','nombre_pais'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'listaPaises.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listRecords'
											    		}
											    	},
											    	autoLoad: true
											    },
											    queryMode : 'local',
											    displayField : 'nombre_pais',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'id_pais',
											    valueField : 'id_pais',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Nacionalidad'
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
