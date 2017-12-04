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
* DATE CREATE : 07/05/2015 16:53:32
* VERSION : 1.0 
*/

Ext.define('MyApp.view.RpPlanillaCasMesAnio.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.RpPlanillaCasMesAnioEdit',

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
				                id: 'form_crud_RpPlanillaCasMesAnio',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Reporte de Planilla',
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
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'srl_id_nomina_anio_periodo_personal',
											    fieldLabel : 'Id',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'descrip_periodo',
											    fieldLabel : 'Mes',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'nombre',
											    fieldLabel : 'NOMBRES',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'apepat',
											    fieldLabel : 'APELLIDO PAT',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'apemat',
											    fieldLabel : 'APELLIDO MAT',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_contractual',
											    fieldLabel : 'REG. CONTRACTUAL',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'ubicacion',
											    fieldLabel : 'UBICACIÓN',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'var_descripcion_fuente_financiamiento',
											    fieldLabel : 'FUENTE DE FINANCIAMIENTO',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'var_cod_meta_presupuestaria',
											    fieldLabel : 'META',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'dec_total_ingresos',
											    fieldLabel : 'HONORARIOS',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'dec_total_descuentos',
											    fieldLabel : 'DESCUENTOS',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'dec_total_aportes',
											    fieldLabel : 'APORTES',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'dec_total_neto',
											    fieldLabel : 'TOTAL',
											    disabled : false,
											    editable : true
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
            id: 'form_crud_RpPlanillaCasMesAnio_statusbar'
        })];

        this.callParent(arguments);      
    }
});
