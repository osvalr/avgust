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
* DATE CREATE : 08/04/2015 00:02:56
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarProcesoNominas.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarProcesoNominasEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 650,
    title:'Procesar Nominas',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarProcesoNominas',
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
//											{
//											    readOnly : false,
//											    store : {
//											    	fields: ['int_id_estado','descrip_estado'],
//											    	data : [
//											    	        {int_id_estado: 1,    descrip_estado: 'Final'},
//											    	        {int_id_estado: 3, descrip_estado: 'Preliminar'}
//											    	    ],
//											    	autoLoad: true
//											    },
//											    allowBlank : false,
//											    queryMode : 'local',
//											    displayField : 'descrip_estado',
//											    hidden : false,
//											    xtype : 'combobox',
//											    name : 'int_id_estado',
//											    valueField : 'int_id_estado',
//											    emptyText : '-- Seleccione Opción --',
//											    fieldLabel : 'Tipo',
//											    disabled : false,
//											    editable : true,
//											    value:1
//											},
											{
											    allowBlank : true,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : false,
											    listeners : {
											    	change: function(field, newValue, oldValue) {

											    		var form = Ext.getCmp('form_crud_GestionarProcesoNominas');
											    		var on_field = form.getForm().findField('srl_id_anio_periodo_planilla');
											    		on_field.setDisabled(true);
											    		on_field.store.removeAll();
											    		on_field.store.reload({
											    			params: {
											    				int_anio: field.getValue()
											    			}
											    		});
											    		on_field.setDisabled(false);
											    		if(oldValue != null){
											    			on_field.setValue('');
											    		}
											    	}
											    },
											    emptyText : '-- Seleccione Opción --',
											    editable : false,
											    readOnly : false,
											    store : {
											    	fields: ['int_anio','int_anio'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-anios-planilla.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    valueField : 'int_anio',
											    fieldLabel : 'Año',
											    name : 'srl_id_anio_planilla',
											    displayField : 'int_anio',
											    disabled : false
											}
											,{
											    queryMode : 'local',
											    allowBlank : false,
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : false,
											    readOnly : false,
											    store : {
											    	fields: ['srl_id_anio_periodo_planilla','descrip_periodo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-periodos-por-anio.action?int_id_estado=1',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: false
											    },
											    valueField : 'srl_id_anio_periodo_planilla',
											    fieldLabel : 'Periodo',
											    name : 'srl_id_anio_periodo_planilla',
											    displayField : 'descrip_periodo',
											    disabled : false
											},{
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
												emptyText : '-- Seleccione Opción --',
												editable : false,
												fieldLabel : 'Régimen Contractual',
												name : 'srl_id_regimen_contractual',
												displayField : 'var_descripcion_regimen_contractual',
												disabled : false,
												store : {
													fields: ['srl_id_regimen_contractual','var_descripcion_regimen_contractual'],
													proxy: {
																type: 'ajax',
																url: 'obtener-valores-regimen-contractual.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true
												},
												listeners : {
											    	change: function(field, newValue, oldValue) {

											    		var form = Ext.getCmp('form_crud_GestionarProcesoNominas');
											    		var on_field = form.getForm().findField('idpersonal');
											    		on_field.setDisabled(true);
											    		on_field.store.removeAll();
											    		on_field.store.reload({
											    			params: {
											    				srl_id_regimen_contractual: field.getValue()
											    			}
											    		});
											    		on_field.setDisabled(false);
											    		if(oldValue != null){
											    			on_field.setValue('');
											    		}
											    	}
											    },
												valueField : 'srl_id_regimen_contractual',
												value : ''
											},
											{
											    queryMode : 'local',
											    allowBlank : true,
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : true,
											    readOnly : false,
											    store : {
											    	fields: ['idpersonal','nombre_completo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-lista-personal-planilla.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: false
											    },
											    valueField : 'idpersonal',
											    fieldLabel : 'Personal',
											    name : 'idpersonal',
											    displayField : 'nombre_completo',
											    disabled : false
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
            	glyph:'xf013@FontAwesome',
                itemId: 'save',
                text: 'Procesar',
                action: 'procesar'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_GestionarProcesoNominas_statusbar'
        })];

        this.callParent(arguments);      
    }
});
