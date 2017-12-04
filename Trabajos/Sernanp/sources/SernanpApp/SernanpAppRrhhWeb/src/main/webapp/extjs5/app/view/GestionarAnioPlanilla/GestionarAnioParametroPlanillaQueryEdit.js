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
* DATE CREATE : 23/03/2015 12:20:16
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAnioPlanilla.GestionarAnioParametroPlanillaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarAnioParametroPlanillaQueryEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 350,
    
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_GestionarAnioParametroPlanillaQuery',
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
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'srl_id_anio_parametro_planilla',
						fieldLabel : 'srl_id_anio_parametro_planilla',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'srl_id_anio_planilla',
						fieldLabel : 'srl_id_anio_planilla',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						store : {
								fields: ['srl_id_parametro_planilla','var_descrip_parametro'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-parametros-planilla.action',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						queryMode : 'local',
						displayField : 'var_descrip_parametro',
						hidden : false,
						xtype : 'combobox',
						name : 'srl_id_parametro_planilla',
						valueField : 'srl_id_parametro_planilla',
						emptyText : '-- Seleccione Opción --',
						fieldLabel : 'Parámetro',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'var_descrip_parametro',
						fieldLabel : 'Descripción Parámetro',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : false,
						hidden : false,
						xtype : 'textfield',
						name : 'dec_valor_parametro',
						vtype : 'soloNumeroDecimales',
						fieldLabel : 'Valor',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'datefield',
						name : 'dte_fecha_vigencia',
						format : 'd/m/Y',
						fieldLabel : 'Fecha Vigencia',
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
					    
						listeners	: {
							beforerender: function(combobox){
								combobox.setValue(1)// El ID de la opción por defecto
							}
						},
						
						allowBlank : false,
						queryMode : 'local',
						displayField : 'destablatipo',						
						hidden : false,
						xtype : 'combobox',
						name : 'int_id_estado',
						valueField : ('codinttablatipo'),
						emptyText : '-- Seleccione Opción --', 
						fieldLabel : 'Tipo Estado',
						disabled : false,
						editable : false,
						
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'var_des_tipo_estado',
						fieldLabel : 'Estado',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'tsp_fecha_registro',
						fieldLabel : 'Fecha Registro',
						disabled : false,
						editable : true
					}
                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
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
