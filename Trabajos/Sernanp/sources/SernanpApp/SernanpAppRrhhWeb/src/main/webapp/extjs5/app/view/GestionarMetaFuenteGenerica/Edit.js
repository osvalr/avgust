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
* DATE CREATE : 19/04/2015 06:16:31
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarMetaFuenteGenerica.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarMetaFuenteGenericaEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 550,

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarMetaFuenteGenerica',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información de Metas y Fte Fto',
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
											    fieldLabel : 'Id',
											    name : 'srl_id_meta_fuente_generica',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : false,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : true,
											    readOnly : false,
											    store : {
											    	fields: ['srl_id_anio_planilla','int_anio'],
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
											    valueField : 'srl_id_anio_planilla',
											    fieldLabel : 'Año',
											    name : 'srl_id_anio_planilla',
											    displayField : 'int_anio',
											    disabled : false
											}
											,{
											    allowBlank : false,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : true,
											    readOnly : false,
											    store : {
											    	fields: ['srl_id_meta_presupuestaria','var_cod_meta_presupuestaria'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-lista-meta-presupuestaria.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    valueField : 'srl_id_meta_presupuestaria',
											    fieldLabel : 'Meta Presupuestaria',
											    name : 'srl_id_meta_presupuestaria',
											    displayField : 'var_cod_meta_presupuestaria',
											    disabled : false
											}
											,{
											    allowBlank : false,
											    xtype : 'textfield',
											    hidden : false,
											    vtype : 'soloNumeros',
											    editable : true,
											    fieldLabel : 'Código año meta',
											    minLength : 1,
											    name : 'var_cod_meta_anio',
											    disabled : false,
											    readOnly : false,
											    maxLength : 10
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
											    	fields: ['srl_id_fuente_financiamiento','var_rubro_fte_fto'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-lista-fuente-financiamiento.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    valueField : 'srl_id_fuente_financiamiento',
											    fieldLabel : 'Fuente Fto',
											    name : 'srl_id_fuente_financiamiento',
											    displayField : 'var_rubro_fte_fto',
											    disabled : false
											}
											,{
											    queryMode : 'local',
											    allowBlank : false,
											    xtype : 'combobox',
											    listeners : {
											    	change: function(field, newValue, oldValue) {
											    		
											    		var form = Ext.getCmp('form_crud_GestionarMetaFuenteGenerica');
											    		var on_field = form.getForm().findField('srl_id_clasificador');
											    		on_field.setDisabled(true);
											    		on_field.store.removeAll();
											    		on_field.store.reload({
											    			params: {
											    				srl_id_generica_gasto: field.getValue()
											    			}
											    		});
											    		on_field.setDisabled(false);
											    		if(oldValue != null){
											    			on_field.setValue('');
											    		}
											    	}
											    },
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : true,
											    readOnly : false,
											    store : {
											    	fields: ['srl_id_generica_gasto','var_descrip_generica_gasto'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-lista-generica-gasto.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    valueField : 'srl_id_generica_gasto',
											    fieldLabel : 'Genérica de Gasto',
											    name : 'srl_id_generica_gasto',
											    displayField : 'var_descrip_generica_gasto',
											    disabled : false
											}
											,{
											    allowBlank : false,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : true,
											    readOnly : false,
											    store : {
											    	fields: ['srl_id_clasificador','var_descrip_clasificador'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-lista-clasificador.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: false
											    },
											    valueField : 'srl_id_clasificador',
											    fieldLabel : 'Clasificador',
											    name : 'srl_id_clasificador',
											    displayField : 'var_descrip_clasificador',
											    disabled : false
											}
											,{
											    allowBlank : false,
											    queryMode : 'local',
											    xtype : 'combobox',
											    listeners : {
											    	change: function(field, newValue, oldValue) {
											    		
											    		var form = Ext.getCmp('form_crud_GestionarMetaFuenteGenerica');
											    		var on_field = form.getForm().findField('idunidad');
											    		on_field.setDisabled(true);
											    		on_field.store.removeAll();
											    		on_field.store.reload({
											    			params: {
											    				idAreaOrganica: field.getValue()
											    			}
											    		});
											    		on_field.setDisabled(false);
											    		if(oldValue != null){
											    			on_field.setValue('');
											    		}
											    	}
											    },
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : true,
											    readOnly : false,
											    store : {
											    	fields: ['idarea','descrip_dependencia'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-areas-organicas.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    valueField : 'idarea',
											    fieldLabel : 'Área Organica',
											    name : 'idarea',
											    displayField : 'descrip_dependencia',
											    disabled : false
											}
											,{
											    allowBlank : true,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : true,
											    readOnly : false,
											    store : {
											    	fields: ['idunidad','nomunidad'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-unidad-operativa.action',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: false
											    },
											    valueField : 'idunidad',
											    fieldLabel : 'Unidad Operativa',
											    name : 'idunidad',
											    displayField : 'nomunidad',
											    disabled : false
											}
											,{
											    allowBlank : false,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : true,
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
											    valueField : 'codinttablatipo',
											    fieldLabel : 'Estado',
											    name : 'int_id_estado',
											    displayField : 'destablatipo',
											    disabled : false
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
            id: 'form_crud_GestionarMetaFuenteGenerica_statusbar'
        })];

        this.callParent(arguments);      
    }
});
