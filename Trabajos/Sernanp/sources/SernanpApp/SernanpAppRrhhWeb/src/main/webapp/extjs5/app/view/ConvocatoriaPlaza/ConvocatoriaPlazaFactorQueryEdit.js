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
* DATE CREATE : 23/04/2015 16:49:26
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ConvocatoriaPlaza.ConvocatoriaPlazaFactorQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ConvocatoriaPlazaFactorQueryEdit',

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
                id: 'form_submodel_ConvocatoriaPlazaFactorQuery',
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
						name : 'srl_id_factor_evaluacion',
						fieldLabel : 'srl_id_factor_evaluacion',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'srl_id_configuracion_factor_evaluacion',
						fieldLabel : 'srl_id_configuracion_factor_evaluacion',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'int_id_tipo_factor_padre',
						fieldLabel : 'int_id_tipo_factor_padre',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'descrip_tipo_factor_padre',
						fieldLabel : 'descrip_tipo_factor_padre',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'int_id_tipo_factor',
						fieldLabel : 'int_id_tipo_factor',
						disabled : false,
						editable : true
					}
					
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : false,
						xtype : 'textareafield',
						name : 'descrip_tipo_factor',
						fieldLabel : 'Factor de Evaluación',
						disabled : false,
						editable : false
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'dec_puntaje_min',
						fieldLabel : 'Puntaje Mínimo',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'dec_puntaje_max',
						fieldLabel : 'Puntaje Máximo',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'dec_peso',
						fieldLabel : 'Peso',
						disabled : false,
						editable : true
					}
					,{
					    readOnly : false,
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'int_id_estado',
						fieldLabel : 'int_id_estado',
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
						xtype : 'textfield',
						name : 'tsp_fecha_registro',
						fieldLabel : 'tsp_fecha_registro',
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
