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
* DATE CREATE : 12/04/2015 20:29:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAsignarConcepto.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarAsignarConceptoEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '75%',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarAsignarConcepto',
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
                    				labelWidth: 125
			                	},

		                		items: [
											{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'idpersona',
											    name : 'idpersona',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'idpersonanatural',
											    name : 'idpersonanatural',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Id',
											    name : 'idpersonal',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Nombres Completos',
											    name : 'nombre_completo',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Tipo Documento',
											    name : 'descrip_documento',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Número Documento',
											    name : 'numerodoc',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'R.U.C',
											    name : 'ruc',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Fecha de Nacimiento',
											    name : 'fechanacimiento',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Genero',
											    name : 'descrip_genero',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Telefono',
											    name : 'telefono',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Correo',
											    name : 'correoinstitucional',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Departamento',
											    name : 'descrip_depto',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Provincia',
											    name : 'descrip_prov',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Distrito',
											    name : 'descrip_ubigeo',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Dirección',
											    name : 'direccion',
											    disabled : false,
											    readOnly : false
											}
											
											,{
												allowBlank : true,
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
												editable : false,
												fieldLabel : 'Regimen Pensionario',
												name : 'srl_id_regimen_pensionario',
												displayField : 'var_descripcion_regimen_pensionario',
												valueField : 'srl_id_regimen_pensionario',
												disabled : false,
												store : {
													fields: ['srl_id_regimen_pensionario','var_descripcion_regimen_pensionario'],
													proxy: {
																type: 'ajax',
																url: 'obtener-lista-regimen-pensionario.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true
												},
											    listeners : {
											    	change: function(field, newValue, oldValue) {
											    	 
											    		var form = Ext.getCmp('form_crud_GestionarAsignarConcepto');
											    		var srl_id_afp = form.getForm().findField('srl_id_afp');
											    		var int_id_tipo_comision = form.getForm().findField('int_id_tipo_comision');
											    		
											    		var dte_fecha_afiliacion = form.getForm().findField('dte_fecha_afiliacion');
											    		var var_codigo_afiliacion = form.getForm().findField('var_codigo_afiliacion');
											    		
											    		if(newValue === 4){
											    			
											    			srl_id_afp.setHidden(false);
											    			srl_id_afp.allowBlank = false;
											    			srl_id_afp.clearInvalid();
											    			
											    			int_id_tipo_comision.setHidden(false);
											    			int_id_tipo_comision.allowBlank = false;
											    			int_id_tipo_comision.clearInvalid();
											    			
											    			dte_fecha_afiliacion.setHidden(false);
											    			dte_fecha_afiliacion.allowBlank = false;
											    			dte_fecha_afiliacion.clearInvalid();
											    			
											    			var_codigo_afiliacion.setHidden(false);
											    			var_codigo_afiliacion.allowBlank = false;
											    			var_codigo_afiliacion.clearInvalid();
											    			
											    		}else{
											    			
											    			srl_id_afp.setHidden(true);
											    			srl_id_afp.allowBlank = true;
											    			srl_id_afp.clearInvalid();
											    			
											    			int_id_tipo_comision.setHidden(true);
											    			int_id_tipo_comision.allowBlank = true;
											    			int_id_tipo_comision.clearInvalid();
											    			
											    			dte_fecha_afiliacion.setHidden(true);
											    			dte_fecha_afiliacion.allowBlank = true;
											    			dte_fecha_afiliacion.clearInvalid();
											    			
											    			var_codigo_afiliacion.setHidden(true);
											    			var_codigo_afiliacion.allowBlank = true;
											    			var_codigo_afiliacion.clearInvalid();
											    		
											    			srl_id_afp.setValue('');
											    			int_id_tipo_comision.setValue('');
											    			dte_fecha_afiliacion.setValue('');
											    			var_codigo_afiliacion.setValue('');
											    			
											    		}
											    		
											    		
											    	}
											    }
												
												
											},{
												allowBlank : true,
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
												editable : false,
												fieldLabel : 'AFP',
												name : 'srl_id_afp',
												displayField : 'var_nombre_afp',
												valueField : 'srl_id_afp',
												disabled : false,
												store : {
													fields: ['srl_id_afp','var_nombre_afp'],
													proxy: {
																type: 'ajax',
																url: 'obtener-lista-afp.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true
												}
												
											},{
												allowBlank : true,
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
												editable : false,
												fieldLabel : 'Tipo Comisión',
												name : 'int_id_tipo_comision',
												displayField : 'destablatipo',
												valueField : 'codinttablatipo',
												disabled : false,
												store : {
													fields: ['codinttablatipo','destablatipo'],
													proxy: {
																type: 'ajax',
																url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Comision',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true
												}
												
											}
											,{
											    allowBlank : true,
											    xtype : 'datefield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Fecha Afiliación',
											    name : 'dte_fecha_afiliacion',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Cod. Afiliación',
											    name : 'var_codigo_afiliacion',
											    disabled : false,
											    readOnly : false
											}
											
											,{
												allowBlank : true,
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
												editable : false,
												fieldLabel : 'Entidad Bancaria',
												name : 'srl_id_entidad_bancaria',
												displayField : 'var_desc_entidad_bancaria',
												valueField : 'srl_id_entidad_bancaria',
												disabled : false,
												store : {
													fields: ['srl_id_entidad_bancaria','var_desc_entidad_bancaria'],
													proxy: {
																type: 'ajax',
																url: 'listar-entidad-bancaria.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true
												}
												
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Nro. Cuenta',
											    name : 'var_numero_cuenta_bancaria',
											    disabled : false,
											    readOnly : false
											}
											
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : false,
											    fieldLabel : 'Estado',
											    name : 'desc_estado',
											    disabled : false,
											    readOnly : false
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
					    		title: 'Conceptos',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_ConceptoPersonalQuery', xtype:'ConceptoPersonalQueryList'}]
							}
							,{
					    		title: 'Suspensiones Cuarta',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_SuspensionCuartaCategoriaQuery', xtype:'SuspensionCuartaCategoriaQueryList'}]
							}
							,{
					    		title: 'Beneficiarios Judiciales',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_BeneficiarioDescuentoJudicialQuery', xtype:'BeneficiarioDescuentoJudicialQueryList'}]
							}
							
							,{
					    		title: 'Contratos',
					    		glyph:'xf022@FontAwesome',
					    		items: [
						    		        {
						    		        	id:'subModel_PersonalInfoContratoQuery', 
						    		        	xtype:'PersonalInfoContratoQueryList'
						    		        },
						    				{
						    					id:'subModel_PersonalInfoAdendasPorContratoQuery', 
						    					xtype:'PersonalInfoAdendasPorContratoQueryList'
						    				}
					    		        ]
							}
							
							
							
							,{
					    		title: 'Formación',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_PersonalInfoFormacionQuery', xtype:'PersonalInfoFormacionQueryList'}]
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
            id: 'form_crud_GestionarAsignarConcepto_statusbar'
        })];

        this.callParent(arguments);      
    }
});
