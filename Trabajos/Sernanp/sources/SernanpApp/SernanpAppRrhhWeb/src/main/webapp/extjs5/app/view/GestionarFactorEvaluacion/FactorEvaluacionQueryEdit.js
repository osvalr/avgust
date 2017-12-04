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
* DATE CREATE : 18/04/2015 17:45:06
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarFactorEvaluacion.FactorEvaluacionQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.FactorEvaluacionQueryEdit',

    requires: ['Ext.form.Panel'],

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
                xtype: 'form',
                id: 'form_submodel_FactorEvaluacionQuery',
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
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'srl_id_factor_evaluacion',
						name : 'srl_id_factor_evaluacion',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'srl_id_configuracion_factor_evaluacion',
						name : 'srl_id_configuracion_factor_evaluacion',
						disabled : false,
						readOnly : false
					}
					,{
					    queryMode : 'local',
						allowBlank : true,
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : true,
						readOnly : false,
						store : {
							fields: ['codinttablatipo','destablatipo'],
							proxy: {
						         type: 'ajax',
						         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Factor_Evaluacion',
						         reader: {
						             type: 'json',
						             rootProperty: 'listResult'
						         }
					    	},
							autoLoad: true
					    },
						valueField : 'codinttablatipo',
						fieldLabel : 'Factor Predecedor',
						name : 'int_id_tipo_factor_padre',
						displayField : 'destablatipo',
						disabled : false
					}
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						fieldLabel : 'Tipo',
						name : 'int_id_tipo_factor',
						displayField : 'destablatipo',
						disabled : false,
						readOnly : false,
						store : {
								fields: ['codinttablatipo','destablatipo'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Factor_Evaluacion',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'codinttablatipo'
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						vtype : 'soloNumeroDecimales',
						editable : true,
						fieldLabel : 'Puntaje Min',
						name : 'dec_puntaje_min',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						vtype : 'soloNumeroDecimales',
						editable : true,
						fieldLabel : 'Puntaje Max',
						name : 'dec_puntaje_max',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						vtype : 'soloNumeroDecimales',
						editable : true,
						fieldLabel : 'Peso',
						name : 'dec_peso',
						disabled : false,
						readOnly : false
					}
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						fieldLabel : 'Estado',
						name : 'int_id_estado',
						displayField : 'destablatipo',
						disabled : false,
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
						valueField : 'codinttablatipo'
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
