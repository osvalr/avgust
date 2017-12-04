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

Ext.define('MyApp.view.GestionarAfp.GestionarAfpPlanillaComisionQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarAfpPlanillaComisionQueryEdit',

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
                id: 'form_submodel_GestionarAfpPlanillaComisionQuery',
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
						name : 'srl_id_afp_comision',
						fieldLabel : 'Nro.',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'srl_id_afp',
						fieldLabel : 'afp',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
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
					    },
						allowBlank : false,
						queryMode : 'local',
						displayField : 'destablatipo',
						hidden : false,
						xtype : 'combobox',
						name : 'int_id_tipo_comision',
						valueField : 'codinttablatipo',
						emptyText : '-- Seleccione Opción --',
						fieldLabel : 'Tipo Comisión',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'descrip_tipo_comision',
						fieldLabel : 'Descripción Comisión',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : false,
						hidden : false,
						xtype : 'textfield',
						name : 'dec_aporte',
						vtype : 'soloNumeroDecimales',
						fieldLabel : 'Aporte',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : false,
						hidden : false,
						xtype : 'textfield',
						name : 'dec_seguro',
//						vtype : 'soloNumeroDecimales',
						fieldLabel : 'Seguro',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : false,
						hidden : false,
						xtype : 'textfield',
						name : 'dec_comision',
//						vtype : 'soloNumeroDecimales',
						fieldLabel : 'Comisión',
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
					    	beforerender:function(combobox){
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
