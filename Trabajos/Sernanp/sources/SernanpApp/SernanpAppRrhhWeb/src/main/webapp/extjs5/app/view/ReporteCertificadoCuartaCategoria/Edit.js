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
* DATE CREATE : 02/06/2015 16:08:44
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteCertificadoCuartaCategoria.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteCertificadoCuartaCategoriaEdit',

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
				                id: 'form_crud_ReporteCertificadoCuartaCategoria',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'CertificadoCuartaCategoria',
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
											    name : 'int_anio',
											    fieldLabel : 'int_anio'
											}
											,{
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
											    name : 'ruc',
											    fieldLabel : 'ruc'
											}
											,{
											    xtype : 'textfield',
											    name : 'direccion',
											    fieldLabel : 'direccion'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_nom_cargo',
											    fieldLabel : 'var_nom_cargo'
											}
											,{
											    xtype : 'textfield',
											    name : 'meses',
											    fieldLabel : 'meses'
											}
											,{
											    xtype : 'textfield',
											    name : 'total_ingresos',
											    fieldLabel : 'total_ingresos'
											}
											,{
											    xtype : 'textfield',
											    name : 'cuarta_cat',
											    fieldLabel : 'cuarta_cat'
											}
											,{
											    xtype : 'textfield',
											    name : 'retencion',
											    fieldLabel : 'retencion'
											}
											,{
											    xtype : 'textfield',
											    name : 'ubicacion',
											    fieldLabel : 'ubicacion'
											}
											,{
											    xtype : 'textfield',
											    name : 'idareanatural',
											    fieldLabel : 'idareanatural'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_cargo',
											    fieldLabel : 'srl_id_cargo'
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
                text: 'Generar Reporte',
                action: 'generarReporteIndividual'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_ReporteCertificadoCuartaCategoria_statusbar'
        })];

        this.callParent(arguments);      
    }
});
