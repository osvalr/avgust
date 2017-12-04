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
* DATE CREATE : 17/03/2015 19:55:09
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAfp.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarAfpEdit',

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
				                id: 'form_crud_GestionarAfp',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información de Afp',
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
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'srl_id_afp',
											    vtype : 'soloNumeros',
											    fieldLabel : 'Nro.',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    maxLength : 20,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_cod_afp',
											    fieldLabel : 'Código AFP',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    maxLength : 50,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_nombre_afp',
											    fieldLabel : 'Nombre AFP',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    store : {
											    	fields: ['codinttablatipo','destablatipo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Generico',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    listeners:{
											    	beforerender: function(combobox){
											    		combobox.setValue(1)
											    	}
											    },
											    allowBlank : false,
											    queryMode : 'local',
											    displayField : 'destablatipo',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'int_id_estado',
											    valueField : 'codinttablatipo',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Tipo Estado',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'descrip_estado',
											    fieldLabel : 'Estado',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'datefield',
											    name : 'tsp_fecha_registro',
											    format : 'd/m/Y',
											    fieldLabel : 'Fecha Registro',
											    disabled : false,
											    editable : true
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
							

							,{
					    		title: 'Informacion Comisión',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_GestionarAfpPlanillaComisionQuery', xtype:'GestionarAfpPlanillaComisionQueryList'}]
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
            id: 'form_crud_GestionarAfp_statusbar'
        })];

        this.callParent(arguments);      
    }
});
