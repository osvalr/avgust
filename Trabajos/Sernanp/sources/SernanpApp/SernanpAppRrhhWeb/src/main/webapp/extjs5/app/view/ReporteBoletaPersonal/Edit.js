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
* DATE CREATE : 17/05/2015 17:19:53
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteBoletaPersonal.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteBoletaPersonalEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '65%',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_ReporteBoletaPersonal',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'ReporteBoletaPersonalPlanilla',
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
											    xtype : 'textfield',
											    name : 'idpersonal',
											    fieldLabel : 'idpersonal',
											    hidden : true
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_contractual',
											    fieldLabel : 'Régimen Contractual',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'c_fte_fto',
											    fieldLabel : 'Fuente Financiamiento',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'c_meta',
											    fieldLabel : 'Meta Presupuestaria',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'int_anio',
											    fieldLabel : 'Año',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'descrip_periodo',
											    fieldLabel : 'Periodo',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'var_nombre_afp',
											    fieldLabel : 'AFP',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'var_codigo_afiliacion',
											    fieldLabel : 'Código Afiliación',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'inicio_contrato',
											    fieldLabel : 'Inicio Contrato',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'nombre_completo',
											    fieldLabel : 'Nombres Completos',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'numerodoc',
											    fieldLabel : 'Nro. Documento',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'var_nom_cargo',
											    fieldLabel : 'Cargo',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'ubicacion',
											    fieldLabel : 'Ubicación',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'dec_total_ingresos',
											    fieldLabel : 'Ingresos',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'dec_total_descuentos',
											    fieldLabel : 'Descuentos',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'dec_total_aportes',
											    fieldLabel : 'Aportes',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'dec_total_neto',
											    fieldLabel : 'Neto',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'srl_id_nomina_anio_periodo_personal',
											    fieldLabel : 'srl_id_nomina_anio_periodo_personal'
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
            items: ['->',
                    
             {
            	glyph:'xf0c7@FontAwesome',
                itemId: 'save',
                text: 'Grabar',
                action: 'save',
                hidden : true
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Aceptar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_ReporteBoletaPersonal_statusbar'
        })];

        this.callParent(arguments);      
    }
});
