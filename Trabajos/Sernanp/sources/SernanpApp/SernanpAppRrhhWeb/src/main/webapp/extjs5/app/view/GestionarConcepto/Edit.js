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
* DATE CREATE : 03/04/2015 18:33:21
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarConcepto.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarConceptoEdit',

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
				                id: 'form_crud_GestionarConcepto',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información Concepto',
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
											    name : 'srl_id_concepto_planilla',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : false,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Código',
											    minLength : 1,
											    name : 'var_cod_concepto',
											    disabled : false,
											    readOnly : false,
											    maxLength : 10
											}
											,{
											    allowBlank : false,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Descripción',
											    minLength : 1,
											    name : 'var_descrip_concepto',
											    disabled : false,
											    readOnly : false,
											    maxLength : 500
											}
											,{
											    allowBlank : false,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Descripción Corta',
											    minLength : 1,
											    name : 'var_descrip_corto_concepto',
											    disabled : false,
											    readOnly : false,
											    maxLength : 50
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Código PDT',
											    minLength : 1,
											    name : 'var_cod_pdt_concepto',
											    disabled : false,
											    readOnly : false,
											    maxLength : 20
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Código MEF',
											    minLength : 1,
											    name : 'var_cod_mef_concepto',
											    disabled : false,
											    readOnly : false,
											    maxLength : 20
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Código SIAF',
											    minLength : 1,
											    name : 'var_cod_siaf_concepto',
											    disabled : false,
											    readOnly : false,
											    maxLength : 50
											}
											,{
											    allowBlank : false,
											    queryMode : 'local',
											    xtype : 'combobox',
											    listeners : {
											    	change: function(field, newValue, oldValue) {

											    		var form = Ext.getCmp('form_crud_GestionarConcepto');
											    		var on_field = form.getForm().findField('int_id_sub_tipo_concepto');
											    		on_field.setDisabled(true);
											    		on_field.store.removeAll();
											    		on_field.store.reload({
											    			params: {
											    				int_cod_refer_tablatipo: field.getValue()
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
											    editable : false,
											    readOnly : false,
											    store : {
											    	fields: ['codinttablatipo','destablatipo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Concepto_Planilla',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    valueField : 'codinttablatipo',
											    fieldLabel : 'Tipo Concepto',
											    name : 'int_id_tipo_concepto',
											    displayField : 'destablatipo',
											    disabled : false
											}
											,{
											    allowBlank : false,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : false,
											    readOnly : false,
											    store : {
											    	fields: ['codinttablatipo','destablatipo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-tablatipo-por-refer.action?nombre_tabla=Sub_Tipo_Concepto_Planilla',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: false
											    },
											    valueField : 'codinttablatipo',
											    fieldLabel : 'Sub Tipo Concepto',
											    name : 'int_id_sub_tipo_concepto',
											    displayField : 'destablatipo',
											    disabled : false,
											    listeners : {
											    	change: function(field, newValue, oldValue) {
											    														          
											    		var form = Ext.getCmp('form_crud_GestionarConcepto');
											    		var int_id_tipo_monto_concepto = form.getForm().findField('int_id_tipo_monto_concepto');
											    		var dec_monto_concepto = form.getForm().findField('dec_monto_concepto');
											    		
											    		if(newValue === 2 || newValue === 4){
											    			
											    			int_id_tipo_monto_concepto.setHidden(false);
											    			int_id_tipo_monto_concepto.allowBlank = false;
											    			int_id_tipo_monto_concepto.clearInvalid();
											    			
											    			dec_monto_concepto.setHidden(false);
											    			dec_monto_concepto.allowBlank = false;
											    			dec_monto_concepto.clearInvalid();
											    			
											    			
											    		}else if(newValue === 6){
											    			
											    			int_id_tipo_monto_concepto.setHidden(false);
											    			int_id_tipo_monto_concepto.allowBlank = false;
											    			int_id_tipo_monto_concepto.clearInvalid();
											    			
											    			dec_monto_concepto.setHidden(false);
											    			dec_monto_concepto.allowBlank = false;
											    			dec_monto_concepto.clearInvalid();
											    			
											    		}else{
											    			
											    			int_id_tipo_monto_concepto.setHidden(true);
											    			int_id_tipo_monto_concepto.allowBlank = true;
											    			int_id_tipo_monto_concepto.clearInvalid();
											    			
											    			dec_monto_concepto.setHidden(true);
											    			dec_monto_concepto.allowBlank = true;
											    			dec_monto_concepto.clearInvalid();
											    			
											    			
											    			
											    			int_id_tipo_monto_concepto.setValue('');
											    			dec_monto_concepto.setValue('');
											    			
											    		}
											    		
											    		
											    	}
											    }
											}
											,{
											    allowBlank : true,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : true,
											    emptyText : '-- Seleccione Opción --',
											    editable : false,
											    readOnly : false,
											    store : {
											    	fields: ['codinttablatipo','destablatipo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Monto',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    valueField : 'codinttablatipo',
											    fieldLabel : 'Tipo Monto',
											    name : 'int_id_tipo_monto_concepto',
											    displayField : 'destablatipo',
											    disabled : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Valor',
											    name : 'dec_monto_concepto',
											    disabled : false,
											    readOnly : false,
											    vtype:'soloNumeroDecimales'
											}
											,{
											    allowBlank : false,
											    queryMode : 'local',
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : false,
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
							

							,{
					    		title: 'Afectos',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_ConceptoAfectoQuery', xtype:'ConceptoAfectoQueryList'}]
							}
							,{
					    		title: 'Frecuencia',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_ConceptoFrecuenciaQuery', xtype:'ConceptoFrecuenciaQueryList'}]
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
            id: 'form_crud_GestionarConcepto_statusbar'
        })];

        this.callParent(arguments);      
    }
});
