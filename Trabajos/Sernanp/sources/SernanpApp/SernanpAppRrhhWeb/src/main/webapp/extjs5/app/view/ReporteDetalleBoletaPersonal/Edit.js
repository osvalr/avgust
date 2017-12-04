/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpAppTemp.
*
* SernanpAppTemp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpAppTemp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpAppTemp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 02/06/2015 14:00:22
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteDetalleBoletaPersonal.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteDetalleBoletaPersonalEdit',

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
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_ReporteDetalleBoletaPersonal',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'title',
				                glyph:'xf022@FontAwesome',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'side',
                    				labelWidth: 125
			                	},

		                		items: [
											{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'idpersonal',
											    fieldLabel : 'idpersonal'
											}
											,{
											    xtype : 'textfield',
											    name : 'nombre_completo',
											    fieldLabel : 'nombre_completo'
											}
											,{
											    xtype : 'textfield',
											    name : 'numerodoc',
											    fieldLabel : 'numerodoc'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_contractual',
											    fieldLabel : 'var_descripcion_regimen_contractual'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_anio',
											    fieldLabel : 'int_anio'
											}
											,{
											    xtype : 'textfield',
											    name : 'descrip_periodo',
											    fieldLabel : 'descrip_periodo'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_id_tipo_concepto',
											    fieldLabel : 'int_id_tipo_concepto'
											}
											,{
											    xtype : 'textfield',
											    name : 'descrip_tipo_concepto',
											    fieldLabel : 'descrip_tipo_concepto'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_concepto_planilla',
											    fieldLabel : 'srl_id_concepto_planilla'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descrip_corto_concepto',
											    fieldLabel : 'var_descrip_corto_concepto'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_monto_calculado',
											    fieldLabel : 'dec_monto_calculado'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_total_ingresos',
											    fieldLabel : 'dec_total_ingresos'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_total_descuentos',
											    fieldLabel : 'dec_total_descuentos'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_total_aportes',
											    fieldLabel : 'dec_total_aportes'
											}
											,{
											    xtype : 'textfield',
											    name : 'neto_pagar',
											    fieldLabel : 'neto_pagar'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'tokenField',
											    fieldLabel : 'tokenField'
											}
										]
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
        }];

        this.callParent(arguments);      
    }
});
