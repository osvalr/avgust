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
* DATE CREATE : 22/01/2015 18:47:38
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarCongregacionLocal.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarCongregacionLocalEdit',

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
				                id: 'form_crud_GestionarCongregacionLocal',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'GestionarCongregacionLocal',
				                glyph:'xf022@FontAwesome',
				                
				                fieldDefaults: {
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
											    store : {
											    	fields: ['id_congregacion_general','nombre_congregacion'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'listaCongregacionDistrito.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listRecords'
											    		}
											    	},
											    	autoLoad: true
											    },
											    queryMode : 'local',
											    displayField : 'nombre_congregacion',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'id_congregacion_general',
											    valueField : 'id_congregacion_general',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Congregación Distrito'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'id_ubicacion_geografica',
											    fieldLabel : 'id_ubicacion_geografica'
											}
											,{
											    allowBlank : true,
											    maxLength : 250,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'razon_social',
											    fieldLabel : 'Congregación Local'
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
											    fieldLabel : 'Pais'
											}
											,{
											    listeners : {
											    	change: function(combo, value) {

											    		var form = Ext.getCmp('form_crud_GestionarCongregacionLocal');
											    		var on_combo = form.getForm().findField('cod_prov');
											    		on_combo.setDisabled(true);
											    		on_combo.store.removeAll();
											    		on_combo.store.reload({
											    			params: {
											    				idDepartamento: combo.getValue()
											    			}
											    		});
											    		on_combo.setDisabled(false);
											    	}
											    },
											    store : {
											    	fields: ['cod_depto','nombre_ubicacion'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtenerDepartamentosUbigeo.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listRecords'
											    		}
											    	},
											    	autoLoad: true
											    },
											    queryMode : 'local',
											    displayField : 'nombre_ubicacion',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'cod_depto',
											    valueField : 'cod_depto',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Departamento'
											}
											,{
											    listeners : {
											    	change: function(combo, value) {

											    		var form = Ext.getCmp('form_crud_GestionarCongregacionLocal');
											    		var on_combo = form.getForm().findField('id_ubigeo');
											    		on_combo.setDisabled(true);
											    		on_combo.store.removeAll();
											    		var combo_cod_depto = form.getForm().findField('cod_depto');
											    		on_combo.store.reload({
											    			params: {
											    				idDepartamento: combo_cod_depto.getValue(),
											    				idProvincia: combo.getValue()
											    			}
											    		});
											    		on_combo.setDisabled(false);
											    	}
											    },
											    store : {
											    	fields: ['cod_prov','nombre_ubicacion'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtenerProvinciaUbigeo.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listRecords'
											    		}
											    	},
											    	autoLoad: false
											    },
											    queryMode : 'local',
											    displayField : 'nombre_ubicacion',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'cod_prov',
											    valueField : 'cod_prov',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Provincia'
											}
											,{
											    store : {
											    	fields: ['id_ubigeo','nombre_ubicacion'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtenerDistritoUbigeo.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listRecords'
											    		}
											    	},
											    	autoLoad: false
											    },
											    queryMode : 'local',
											    displayField : 'nombre_ubicacion',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'id_ubigeo',
											    valueField : 'id_ubigeo',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Distrito'
											}
											,{
											    hidden : false,
											    xtype : 'textarea',
											    name : 'direccion',
											    fieldLabel : 'Dirección'
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
											    value : 1,
											    valueField : 'valor_general',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Estado',
											    editable : false
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
							

							,{
					    		title: 'NumeroTelefonicoQuery',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'detailCongregacionLocalNumeroTelefonicoQuery', xtype:'CongregacionLocalNumeroTelefonicoQueryList'}]
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
