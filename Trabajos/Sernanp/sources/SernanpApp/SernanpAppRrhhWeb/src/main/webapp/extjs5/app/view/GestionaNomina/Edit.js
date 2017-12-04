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
* DATE CREATE : 07/04/2015 17:43:08
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionaNomina.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionaNominaEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '55%',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionaNomina',
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
                    				labelWidth: 150
			                	},

		                		items: [
											{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Id',
											    name : 'srl_id_nomina_anio_periodo_personal',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'srl_id_anio_planilla',
											    name : 'srl_id_anio_planilla',
											    disabled : false,
											    readOnly : false,
												listeners: {
													change: function (field) {
														
															var form = Ext.getCmp('form_crud_GestionaNomina');
															var c_meta = form.getForm().findField('c_meta');
															var srl_id_anio_planilla = form.getForm().findField('srl_id_anio_planilla');
															
															c_meta.setDisabled(true);
															c_meta.store.removeAll();
															c_meta.store.reload({
													               params: {srl_id_anio_planilla: srl_id_anio_planilla.value}
													        });
															
															c_meta.setDisabled(false);
													}
												}
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Año',
											    name : 'int_anio',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'srl_id_anio_periodo_planilla',
											    name : 'srl_id_anio_periodo_planilla',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'int_id_periodo_mes',
											    name : 'int_id_periodo_mes',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Periodo',
											    name : 'descrip_periodo',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'idpersona',
											    name : 'idpersona',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'idpersonanatural',
											    name : 'idpersonanatural',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Id Personal',
											    name : 'idpersonal',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Nombres completos',
											    name : 'nombre_completo',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Tipo Documento',
											    name : 'descrip_documento',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Número Documento',
											    name : 'numerodoc',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Régimen',
											    name : 'var_descripcion_regimen_contractual',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Cargo',
											    name : 'var_nom_cargo',
											    disabled : false,
											    readOnly : true
											}
											,{
												allowBlank : true,
												emptyText : '-- Seleccione Opción --',
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
												editable : false,
												fieldLabel : 'Fuente Financiamiento',
												name : 'c_fte_fto',
												displayField : 'var_descripcion_fuente_financiamiento',
												disabled : false,
												store : {
													fields: ['var_rubro_fte_fto','var_descripcion_fuente_financiamiento'],
													proxy: {
																type: 'ajax',
																url: 'obtener-fuentes-financiamiento.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true
												},
												valueField : 'var_rubro_fte_fto'
											}
											,{
												allowBlank : true,
												emptyText : '-- Seleccione Opción --',
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
												editable : false,
												fieldLabel : 'Meta',
												name : 'c_meta',
												displayField : 'cod_meta',
												disabled : false,
												store : {
													fields: ['cod_meta','cod_meta'],
													proxy: {
																type: 'ajax',
																url: 'obtener-meta-por-periodo.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true
												},
												valueField : 'cod_meta'
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Total Ingresos',
											    name : 'dec_total_ingresos',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Total Descuentos',
											    name : 'dec_total_descuentos',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Total Aportes',
											    name : 'dec_total_aportes',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Total Neto',
											    name : 'dec_total_neto',
											    disabled : false,
											    readOnly : true
											}
//											,{
//											    readOnly : false,
//											    store : {
//											    	fields: ['codinttablatipo','destablatipo'],
//											    	proxy: {
//											    		type: 'ajax',
//											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Generico',
//											    		reader: {
//											    			type: 'json',
//											    			rootProperty: 'listResult'
//											    		}
//											    	},
//											    	autoLoad: true
//											    },
//											    listeners:{
//											    	beforerender: function(combobox){
//											    		combobox.setValue(1)
//											    	}
//											    },
//											    allowBlank : false,
//											    queryMode : 'local',
//											    displayField : 'destablatipo',
//											    hidden : false,
//											    xtype : 'combobox',
//											    name : 'int_id_estado',
//											    valueField : 'codinttablatipo',
//											    emptyText : '-- Seleccione Opción --',
//											    fieldLabel : 'Tipo Estado',
//											    disabled : false,
//											    editable : true
//											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Fecha Registro',
											    name : 'tsp_fecha_registro',
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
					    		title: 'Ingresos',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_IngresosNominaConceptoQuery', xtype:'IngresosNominaConceptoQueryList'}]
							}
							,{
					    		title: 'Descuentos',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_DescuentosNominaConceptoQuery', xtype:'DescuentosNominaConceptoQueryList'}]
							}
							,{
					    		title: 'Descuentos Judiciales',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_DescuentoJudicialesNominaConceptoQuery', xtype:'DescuentoJudicialesNominaConceptoQueryList'}]
							}
							,{
					    		title: 'Aportes',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_AportesNominaConceptoQuery', xtype:'AportesNominaConceptoQueryList'}]
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
            id: 'form_crud_GestionaNomina_statusbar'
        })];

        this.callParent(arguments);      
    }
});
