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
* DATE CREATE : 18/05/2015 04:29:11
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReportePlanillaPagoSNP.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReportePlanillaPagoSNPEdit',

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
				                id: 'form_crud_ReportePlanillaPagoSNP',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'ReportePlanillaPagoPersonalSNP',
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
											    fieldLabel : 'srl_id_anio_planilla',
								            	hidden:true
											}
											,{
											    xtype : 'textfield',
											    name : 'int_anio',
											    fieldLabel : 'Año'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_anio_periodo_planilla',
											    fieldLabel : 'srl_id_anio_periodo_planilla',
								            	hidden:true
											}
											,{
											    xtype : 'textfield',
											    name : 'int_id_periodo_mes',
											    fieldLabel : 'int_id_periodo_mes',
								            	hidden:true
											}
											,{
											    xtype : 'textfield',
											    name : 'descrip_periodo',
											    fieldLabel : 'Periodo'
											}
											,{
											    xtype : 'textfield',
											    name : 'idpersonal',
											    fieldLabel : 'Id'
											}
											,{
											    xtype : 'textfield',
											    name : 'nombre_completo',
											    fieldLabel : 'Nombre Completo'
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'srl_id_regimen_contractual',
											    fieldLabel : 'srl_id_regimen_contractual',
								            	hidden:true
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_contractual',
											    fieldLabel : 'Régimen Contractual'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_total_ingresos',
											    fieldLabel : 'Ingresos'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_monto_calculado',
											    fieldLabel : 'Monto Calculado'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_cod_meta_presupuestaria',
											    fieldLabel : 'Meta Presupuestaria'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_rubro_fte_fto',
											    fieldLabel : 'Fuente Financiamiento'
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
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_ReportePlanillaPagoSNP_statusbar'
        })];

        this.callParent(arguments);      
    }
});
