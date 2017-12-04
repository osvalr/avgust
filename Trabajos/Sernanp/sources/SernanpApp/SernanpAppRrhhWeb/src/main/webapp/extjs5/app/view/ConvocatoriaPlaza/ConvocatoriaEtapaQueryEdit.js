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
* DATE CREATE : 21/04/2015 20:40:38
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ConvocatoriaPlaza.ConvocatoriaEtapaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ConvocatoriaEtapaQueryEdit',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '35%',
    
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_ConvocatoriaEtapaQuery',
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
						name : 'srl_id_convocatoria',
						fieldLabel : 'srl_id_convocatoria',
						hidden:true
					}
					,{
					    allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'srl_id_conv_fecha_etapa_config',
						fieldLabel : 'srl_id_conv_fecha_etapa_config',
						
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						name : 'srl_id_subetapa_proceso_seleccion',
						fieldLabel : 'Etapa',
						hidden:true,
						editable:false
					}
					,{
					    xtype : 'textfield',
						name : 'var_nombre_etapa',
						fieldLabel : 'Etapa',
						editable:false,
						allowBlank : true
					}
					,{
					    xtype : 'textfield',
						name : 'var_descrip_subetapa',
						fieldLabel : 'SubEtapa',
						editable:false,
						allowBlank : true
					}
					
					,{
					    allowBlank : false,
						xtype : 'datefield',
						name : 'dte_fecha_inicio',
						format : 'd/m/Y',
						fieldLabel : 'Fecha de Inicio',
						id: 'finicio',
					    vtype: 'daterange',
					    endDateField: 'ffin'
					}
					,{
					    allowBlank : true,
						xtype : 'datefield',
						name : 'dte_fecha_termino',
						format : 'd/m/Y',
						fieldLabel : 'Fecha de Término',
						id: 'ffin',
					    vtype: 'daterange',
					    startDateField: 'finicio'
					}
					,{
					    xtype : 'textfield',
						name : 'srl_id_etapa_proceso_seleccion',
						fieldLabel : 'srl_id_etapa_proceso_seleccion',
						hidden:true
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
