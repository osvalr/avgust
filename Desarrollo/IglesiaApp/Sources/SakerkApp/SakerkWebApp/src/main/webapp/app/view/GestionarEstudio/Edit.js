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
* DATE CREATE : 03/12/2014 15:04:40
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarEstudio.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarEstudioEdit',

    requires: ['Ext.form.Panel'],

    title : '',
    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    width: 350,
    glyph:'xf0c5@FontAwesome',

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
				                title: 'GestionarEstudio',
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
											    id : 'GestionarEstudio_id_estudio',
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'id_estudio',
											    fieldLabel : 'Id'
											}
											,{
											    id : 'GestionarEstudio_id_categoria_estudio',
											    store : {
											    	fields: ['valor_general','campo_a'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Categoria_Estudio',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listRecords'
											    		}
											    	},
											    	autoLoad: true
											    },
											    allowBlank : false,
											    queryMode : 'local',
											    displayField : 'campo_a',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'id_categoria_estudio',
											    valueField : 'valor_general',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Categoría Estudio'
											}
											,{
											    id : 'GestionarEstudio_nombre_estudio',
											    allowBlank : true,
											    maxLength : 500,
											    minLength : 1,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'nombre_estudio',
											    fieldLabel : 'Nombre'
											}
											,{
											    id : 'GestionarEstudio_id_estado',
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
											    allowBlank : false,
											    queryMode : 'remote',
											    displayField : 'campo_a',
											    hidden : false,
											    editable:false,
											    xtype : 'combobox',
											    name : 'id_estado',
											    valueField : 'valor_general',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Estado',
											    value:1
											}
											,{
											    id : 'GestionarEstudio_fecha_registro',
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
