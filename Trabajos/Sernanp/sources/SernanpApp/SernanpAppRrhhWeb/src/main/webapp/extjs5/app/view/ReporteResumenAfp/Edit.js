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
* DATE CREATE : 17/05/2015 17:00:41
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteResumenAfp.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteResumenAfpEdit',

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
				                id: 'form_crud_ReporteResumenAfp',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'ResumenAfp',
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
											    name : 'var_rubro_fte_fto',
											    fieldLabel : 'var_rubro_fte_fto'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_cod_meta_presupuestaria',
											    fieldLabel : 'var_cod_meta_presupuestaria'
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
											    name : 'idpersonanatural',
											    fieldLabel : 'idpersonanatural'
											}
											,{
											    xtype : 'textfield',
											    name : 'nombre_completo',
											    fieldLabel : 'nombre_completo'
											}
											,{
											    xtype : 'textfield',
											    name : 'sueldo',
											    fieldLabel : 'sueldo'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_total_aportes',
											    fieldLabel : 'dec_total_aportes'
											}
											,{
											    xtype : 'textfield',
											    name : 'seguro_invalidez',
											    fieldLabel : 'seguro_invalidez'
											}
											,{
											    xtype : 'textfield',
											    name : 'comision_variable',
											    fieldLabel : 'comision_variable'
											}
											,{
											    xtype : 'textfield',
											    name : 'sub_total_retencion',
											    fieldLabel : 'sub_total_retencion'
											}
											,{
											    xtype : 'textfield',
											    name : 'total',
											    fieldLabel : 'total'
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
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_ReporteResumenAfp_statusbar'
        })];

        this.callParent(arguments);      
    }
});
