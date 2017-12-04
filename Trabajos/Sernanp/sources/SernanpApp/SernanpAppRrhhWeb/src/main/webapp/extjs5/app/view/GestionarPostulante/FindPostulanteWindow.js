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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPostulante.FindPostulanteWindow', {
    extend: 'Ext.window.Window',
    alias : 'widget.FindPostulanteWindow',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '35%',
    title:'Buscar Registro de Postulante',
    closable:false,
    
    glyph:'xf002@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_find_postulante',
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
						{
						    allowBlank : false,
						    queryMode : 'local',
						    xtype : 'combobox',
						    hidden : false,
						    emptyText : '-- Seleccione Opción --',
						    editable : false,
						    readOnly : false,
						    store : {
						    	fields: ['idtablatipo','abrtablatipo'],
						    	proxy: {
						    		type: 'ajax',
						    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo de Documento',
						    		reader: {
						    			type: 'json',
						    			rootProperty: 'listResult'
						    		}
						    	},
						    	autoLoad: true
						    },
						    valueField : 'idtablatipo',
						    fieldLabel : 'Tipo Documento',
						    name : 'idtipodocumento',
						    displayField : 'abrtablatipo',
						    disabled : false
						}
						,{
						    allowBlank : false,
						    xtype : 'textfield',
						    vtype: 'soloNumeros',
						    hidden : false,
						    editable : true,
						    fieldLabel : 'Número Documento',
						    minLength : 1,
						    name : 'numerodoc',
						    disabled : false,
						    readOnly : false,
						    maxLength : 45
						},
						{
						    allowBlank : false,
						    xtype : 'datefield',
						    hidden : false,
						    editable : true,
						    fieldLabel : 'Fecha Nacimiento',
						    name : 'fechanacimiento',
						    format : 'd/m/Y',
						    disabled : false,
						    readOnly : false,
						    format : 'd/m/Y'
						}
                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf0b0@FontAwesome',
                itemId: 'save',
                text: 'Buscar',
                action: 'buscarPostulante'
            }]
        }];

        this.callParent(arguments);
    }
});
