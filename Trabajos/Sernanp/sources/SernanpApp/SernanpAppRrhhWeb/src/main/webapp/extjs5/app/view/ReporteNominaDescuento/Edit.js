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
* DATE CREATE : 14/06/2015 01:52:58
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteNominaDescuento.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteNominaDescuentoEdit',

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
				                id: 'form_crud_ReporteNominaDescuento',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'NominaDescuentosPersonal',
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
											    name : 'nombre_completo',
											    fieldLabel : 'nombre_completo'
											}
											,{
											    xtype : 'textfield',
											    name : 'numerodoc',
											    fieldLabel : 'numerodoc'
											}
											,{
											    allowBlank : true,
											    maxLength : 20,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'c_meta',
											    fieldLabel : 'c_meta'
											}
											,{
											    allowBlank : true,
											    maxLength : 20,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'c_fte_fto',
											    fieldLabel : 'c_fte_fto'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_fuente_financiamiento',
											    fieldLabel : 'var_descripcion_fuente_financiamiento'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_contractual',
											    fieldLabel : 'var_descripcion_regimen_contractual'
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'srl_id_regimen_contractual',
											    fieldLabel : 'srl_id_regimen_contractual'
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
											    name : 'reg_19990',
											    fieldLabel : 'reg_19990'
											}
											,{
											    xtype : 'textfield',
											    name : 'reg_afp',
											    fieldLabel : 'reg_afp'
											}
											,{
											    xtype : 'textfield',
											    name : 'reg_20530',
											    fieldLabel : 'reg_20530'
											}
											,{
											    xtype : 'textfield',
											    name : 'reg_25897',
											    fieldLabel : 'reg_25897'
											}
											,{
											    xtype : 'textfield',
											    name : 'total_19990',
											    fieldLabel : 'total_19990'
											}
											,{
											    xtype : 'textfield',
											    name : 'total_afp',
											    fieldLabel : 'total_afp'
											}
											,{
											    xtype : 'textfield',
											    name : 'total_20530',
											    fieldLabel : 'total_20530'
											}
											,{
											    xtype : 'textfield',
											    name : 'total_25897',
											    fieldLabel : 'total_25897'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_regimen_pensionario',
											    fieldLabel : 'srl_id_regimen_pensionario'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_pensionario',
											    fieldLabel : 'var_descripcion_regimen_pensionario'
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
            id: 'form_crud_ReporteNominaDescuento_statusbar'
        })];

        this.callParent(arguments);      
    }
});
