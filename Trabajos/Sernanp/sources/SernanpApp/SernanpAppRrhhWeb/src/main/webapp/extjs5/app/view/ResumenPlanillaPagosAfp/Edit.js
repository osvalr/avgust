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
* DATE CREATE : 28/05/2015 11:00:40
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ResumenPlanillaPagosAfp.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ResumenPlanillaPagosAfpEdit',

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
				                id: 'form_crud_ResumenPlanillaPagosAfp',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Resumen Planilla Pagos AFP',
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
											    name : 'idpersonal',
											    fieldLabel : 'idpersonal'
											}
											,{
											    xtype : 'textfield',
											    name : 'idpersonanatural',
											    fieldLabel : 'idpersonanatural'
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
											    name : 'srl_id_fuente_financiamiento',
											    fieldLabel : 'srl_id_fuente_financiamiento'
											}
											,{
											    xtype : 'textfield',
											    name : 'codfuente',
											    fieldLabel : 'codfuente'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_meta_presupuestaria',
											    fieldLabel : 'srl_id_meta_presupuestaria'
											}
											,{
											    xtype : 'textfield',
											    name : 'codmeta',
											    fieldLabel : 'codmeta'
											}
											,{
											    allowBlank : true,
											    maxLength : 50,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_nombre_afp',
											    fieldLabel : 'var_nombre_afp'
											}
											,{
											    allowBlank : true,
											    maxLength : 20,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_codigo_afiliacion',
											    fieldLabel : 'var_codigo_afiliacion'
											}
											,{
											    xtype : 'textfield',
											    name : 'sueldo',
											    fieldLabel : 'sueldo'
											}
											,{
											    xtype : 'textfield',
											    name : 'seguro',
											    fieldLabel : 'seguro'
											}
											,{
											    xtype : 'textfield',
											    name : 'comision_variable',
											    fieldLabel : 'comision_variable'
											}
											,{
											    xtype : 'textfield',
											    name : 'fondo_pension',
											    fieldLabel : 'fondo_pension'
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
            id: 'form_crud_ResumenPlanillaPagosAfp_statusbar'
        })];

        this.callParent(arguments);      
    }
});
