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
* DATE CREATE : 19/05/2015 22:46:28
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteRequerimientoPersonalMINTRA.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteRequerimientoPersonalMINTRAEdit',

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
				                id: 'form_crud_ReporteRequerimientoPersonalMINTRA',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información Requerimiento Personal',
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
											    name : 'srl_id_requerimiento_personal',
											    fieldLabel : 'Nro',
											    readOnly : true
											},
											{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'int_cantidad_requerida',
											    fieldLabel : 'Cantidad Requerida',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    maxLength : 5000,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_denominacion_requerimiento',
											    fieldLabel : 'Denominación del Requerimiento',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'idarea_solicitante',
											    hidden:true,
											    fieldLabel : 'idarea_solicitante',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'desarea',
											    fieldLabel : 'Área Solicitante',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'idunidad_solicitante',
											    hidden:true,
											    fieldLabel : 'idunidad_solicitante',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'nomunidad',
											    fieldLabel : 'Unidad Solicitante',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'int_id_estado',
											    hidden:true,
											    fieldLabel : 'int_id_estado',
											    readOnly : true
											}
											,{
											    xtype : 'textfield',
											    name : 'var_nombre_estado',
											    fieldLabel : 'Estado',
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'datefield',
											    name : 'tsp_fecha_registro',
											    format : 'd/m/Y',
											    fieldLabel : 'Fecha Registro',
											    readOnly : true
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
                hidden:true,
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
            id: 'form_crud_ReporteRequerimientoPersonalMINTRA_statusbar'
        })];

        this.callParent(arguments);      
    }
});
