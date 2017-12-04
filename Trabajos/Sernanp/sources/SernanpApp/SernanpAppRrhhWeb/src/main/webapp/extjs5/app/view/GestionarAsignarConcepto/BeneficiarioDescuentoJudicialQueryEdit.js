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

Ext.define('MyApp.view.GestionarAsignarConcepto.BeneficiarioDescuentoJudicialQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.BeneficiarioDescuentoJudicialQueryEdit',

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
                id: 'form_submodel_BeneficiarioDescuentoJudicialQuery',
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
						fieldLabel : 'srl_id_beneficiario_descuento_judicial',
						name : 'srl_id_beneficiario_descuento_judicial',
						disabled : false,
						readOnly : false
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : true,
						editable : true,
						fieldLabel : 'idpersonal',
						name : 'idpersonal',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Descripción',
						name : 'var_descripcion_descuento',
						disabled : false,
						readOnly : false
					}
					,{
					    queryMode : 'local',
						xtype : 'combobox',
						hidden : false,
						emptyText : '-- Seleccione Opción --',
						editable : false,
						fieldLabel : 'Tipo Documento',
						name : 'int_id_tipo_documento',
						displayField : 'abrtablatipo',
						disabled : false,
						readOnly : false,
						store : {
								fields: ['idtablatipo','abrtablatipo'],
								proxy: {
							         type: 'ajax',
							         url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo de Documento',
							         reader: {
							             type: 'json',
							             rootProperty: 'listResult'
							         }
						    	},
								autoLoad: true
					    },
						valueField : 'idtablatipo'
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Número Documento',
						name : 'var_numero_doc',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Nombres',
						name : 'var_nombres',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'A. Paterno',
						name : 'var_ape_pater',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'A. Materno',
						name : 'var_ape_mater',
						disabled : false,
						readOnly : false
					}
					,{
					    xtype : 'textfield',
						hidden : false,
						editable : true,
						fieldLabel : 'Numero Cuenta',
						name : 'var_numero_cuenta',
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
