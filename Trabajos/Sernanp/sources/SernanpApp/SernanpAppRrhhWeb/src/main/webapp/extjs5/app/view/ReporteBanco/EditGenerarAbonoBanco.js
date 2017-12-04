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

Ext.define('MyApp.view.ReporteBanco.EditGenerarAbonoBanco', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteBancoEditGenerarAbonoBanco',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 600,
    title:'Generar Reporte Abono a Bancos',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
							{
				                xtype: 'form',
				                id: 'form_generar_abono_banco',
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
												queryMode : 'local',
												xtype : 'combobox',
												hidden : false,
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
												valueField : 'srl_id_regimen_contractual',
												emptyText : '-- Seleccione Opción --',
												listeners: {
													'beforerender': {
													scope: this,
													fn: function (field) {
															
															field.setValue(3);
														}
												    }
												}
											},
											,{
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
												valueField : 'var_rubro_fte_fto',
												emptyText : '-- Seleccione Opción --',
												width:300,
												listeners: {
													'beforerender': {
													scope: this,
													fn: function (field) {
															
															field.setValue('00');
														}
												    }
												}
											}
											,{
												xtype : 'textfield',
												name : 'c_meta',
												fieldLabel : 'Meta Presupuestaria',
												hidden:false,
												allowBlank:false,
												vtype:'metaNumeros',
												maxLength: 40,
												enforceMaxLength: true,
												disabled : false
											},
											{
								                xtype: 'radiogroup',
								                flex: 1,
								                vertical: false,
								                columns: 1,
								                //labelWidth: 50,
								                id: 'radio_group_id',
								                fieldLabel: 'Formato',
//								                width:'30%',
								                items: [
								                        {
										                    boxLabel: 'PDF',
										                    name: 'rbFormato',
										                    inputValue: 1,
										                    checked: true
										                    
								                        }, 
								                        {
										                    boxLabel: 'XLS',
										                    name: 'rbFormato',
										                    inputValue: 2
										                    
								                        }
								                        
								                        ]
								            }
											
											
										]
							}

        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf013@FontAwesome',
                text: 'Generar',
                action: 'generarAbonoBanco'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_generar_abono_banco_statusbar'
        })];

        this.callParent(arguments);      
    }
});
