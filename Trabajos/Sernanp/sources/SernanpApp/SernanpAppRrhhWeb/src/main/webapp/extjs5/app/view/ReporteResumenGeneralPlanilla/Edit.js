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
* DATE CREATE : 31/05/2015 16:59:27
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteResumenGeneralPlanilla.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteResumenGeneralPlanillaEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '60%',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_ReporteResumenGeneralPlanilla',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Resumen General Planilla ',
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
											    xtype : 'textfield',
											    name : 'numerodoc',
											    fieldLabel : 'numerodoc'
											}
											,{
											    xtype : 'textfield',
											    name : 'dte_fec_inicio',
											    fieldLabel : 'dte_fec_inicio'
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
											    name : 'c_meta',
											    fieldLabel : 'c_meta'
											}
											,{
											    xtype : 'textfield',
											    name : 'c_fte_fto',
											    fieldLabel : 'c_fte_fto'
											}
											,{
											    xtype : 'textfield',
											    name : 'sueldo',
											    fieldLabel : 'sueldo'
											}
											,{
											    xtype : 'textfield',
											    name : 'asignacion_familiar',
											    fieldLabel : 'asignacion_familiar'
											}
											,{
											    xtype : 'textfield',
											    name : 'onp',
											    fieldLabel : 'onp'
											}
											,{
											    xtype : 'textfield',
											    name : 'aporte_obligatorio',
											    fieldLabel : 'aporte_obligatorio'
											}
											,{
											    xtype : 'textfield',
											    name : 'seguro_invalidez',
											    fieldLabel : 'seguro_invalidez'
											}
											,{
											    xtype : 'textfield',
											    name : 'total',
											    fieldLabel : 'total'
											}
											,{
											    xtype : 'textfield',
											    name : 'comision',
											    fieldLabel : 'comision'
											}
											,{
											    xtype : 'textfield',
											    name : 'quinta_categoria',
											    fieldLabel : 'quinta_categoria'
											}
											,{
											    xtype : 'textfield',
											    name : 'cafae',
											    fieldLabel : 'cafae'
											}
											,{
											    xtype : 'textfield',
											    name : 'atlantis',
											    fieldLabel : 'atlantis'
											}
											,{
											    xtype : 'textfield',
											    name : 'tumi',
											    fieldLabel : 'tumi'
											}
											,{
											    xtype : 'textfield',
											    name : 'essalud_vida',
											    fieldLabel : 'essalud_vida'
											}
											,{
											    xtype : 'textfield',
											    name : 'coopal',
											    fieldLabel : 'coopal'
											}
											,{
											    xtype : 'textfield',
											    name : 'rimac',
											    fieldLabel : 'rimac'
											}
											,{
											    xtype : 'textfield',
											    name : 'judicial',
											    fieldLabel : 'judicial'
											}
											,{
											    xtype : 'textfield',
											    name : 'asociacion_guardaparques',
											    fieldLabel : 'asociacion_guardaparques'
											}
											,{
											    xtype : 'textfield',
											    name : 'la_positiva_seguro',
											    fieldLabel : 'la_positiva_seguro'
											}
											,{
											    xtype : 'textfield',
											    name : 'seguros_sura',
											    fieldLabel : 'seguros_sura'
											}
											,{
											    xtype : 'textfield',
											    name : 'tardanzas',
											    fieldLabel : 'tardanzas'
											}
											,{
											    xtype : 'textfield',
											    name : 'vales_tai_loy',
											    fieldLabel : 'vales_tai_loy'
											}
											,{
											    xtype : 'textfield',
											    name : 'pandero_guardaparque',
											    fieldLabel : 'pandero_guardaparque'
											}
											,{
											    xtype : 'textfield',
											    name : 'essalud',
											    fieldLabel : 'essalud'
											}
											,{
											    xtype : 'textfield',
											    name : 'diecinueve',
											    fieldLabel : 'diecinueve'
											}
											,{
											    xtype : 'textfield',
											    name : 'cuarta_categoria',
											    fieldLabel : 'cuarta_categoria'
											}
											,{
											    xtype : 'textfield',
											    name : 'viaticos',
											    fieldLabel : 'viaticos'
											}
											,{
											    xtype : 'textfield',
											    name : 'mapfre',
											    fieldLabel : 'mapfre'
											}
											,{
											    xtype : 'textfield',
											    name : 'otros_descuentos',
											    fieldLabel : 'otros_descuentos'
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
            id: 'form_crud_ReporteResumenGeneralPlanilla_statusbar'
        })];

        this.callParent(arguments);      
    }
});
