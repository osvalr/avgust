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
* DATE CREATE : 12/05/2015 19:01:07
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReportePlanillaPagoONP.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReportePlanillaPagoONPEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

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
				                id: 'form_crud_ReportePlanillaPagoONP',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'ReportePlanillaPagoPersonalONP',
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
											    hidden : true,
											    xtype : 'textfield',
											    name : 'srl_id_nomina_anio_periodo_personal',
											    fieldLabel : 'srl_id_nomina_anio_periodo_personal'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_anio_planilla',
											    fieldLabel : 'srl_id_anio_planilla'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_anio',
											    fieldLabel : 'int_anio'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_anio_periodo_planilla',
											    fieldLabel : 'srl_id_anio_periodo_planilla'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_id_periodo_mes',
											    fieldLabel : 'int_id_periodo_mes'
											}
											,{
											    xtype : 'textfield',
											    name : 'descrip_periodo',
											    fieldLabel : 'descrip_periodo'
											}
											,{
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
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'srl_id_regimen_contractual',
											    fieldLabel : 'srl_id_regimen_contractual'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_contractual',
											    fieldLabel : 'var_descripcion_regimen_contractual'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_total_ingresos',
											    fieldLabel : 'dec_total_ingresos'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_monto_calculado',
											    fieldLabel : 'dec_monto_calculado'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_cod_meta_presupuestaria',
											    fieldLabel : 'var_cod_meta_presupuestaria'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_rubro_fte_fto',
											    fieldLabel : 'var_rubro_fte_fto'
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
                action: 'save',
                hidden:true
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Aceptar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_ReportePlanillaPagoONP_statusbar'
        })];

        this.callParent(arguments);      
    }
});
