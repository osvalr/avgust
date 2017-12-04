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
* DATE CREATE : 25/06/2015 14:27:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteContratoSuscritosYNoSuscritos.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteContratoSuscritosYNoSuscritosEdit',

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
				                id: 'form_crud_ReporteContratoSuscritosYNoSuscritos',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'RpSeleccionContratosSuscritosNoSuscritosQuery',
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
											    name : 'idpersona',
											    fieldLabel : 'idpersona'
											}
											,{
											    xtype : 'textfield',
											    name : 'idpersonanatural',
											    fieldLabel : 'idpersonanatural'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_id_postulante',
											    fieldLabel : 'int_id_postulante'
											}
											,{
											    xtype : 'textfield',
											    name : 'nombre_completo',
											    fieldLabel : 'nombre_completo'
											}
											,{
											    xtype : 'textfield',
											    name : 'idtipodocumento',
											    fieldLabel : 'idtipodocumento'
											}
											,{
											    xtype : 'textfield',
											    name : 'tipodocumento',
											    fieldLabel : 'tipodocumento'
											}
											,{
											    xtype : 'textfield',
											    name : 'numerodoc',
											    fieldLabel : 'numerodoc'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_convocatoria',
											    fieldLabel : 'srl_id_convocatoria'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_num_convocatoria',
											    fieldLabel : 'var_num_convocatoria'
											}
											,{
											    xtype : 'textfield',
											    name : 'estado_convocatoria',
											    fieldLabel : 'estado_convocatoria'
											}
											,{
											    xtype : 'textfield',
											    name : 'srl_id_conv_area_org',
											    fieldLabel : 'srl_id_conv_area_org'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_codigo_postulacion',
											    fieldLabel : 'var_codigo_postulacion'
											}
											,{
											    xtype : 'textfield',
											    name : 'idarea',
											    fieldLabel : 'idarea'
											}
											,{
											    xtype : 'textfield',
											    name : 'desarea',
											    fieldLabel : 'desarea'
											}
											,{
											    xtype : 'textfield',
											    name : 'idunidad',
											    fieldLabel : 'idunidad'
											}
											,{
											    xtype : 'textfield',
											    name : 'nomunidad',
											    fieldLabel : 'nomunidad'
											}
											,{
											    xtype : 'textfield',
											    name : 'des_estado_convocatoria',
											    fieldLabel : 'des_estado_convocatoria'
											}
											,{
											    xtype : 'textfield',
											    name : 'estado_postulante_cnv_area_org',
											    fieldLabel : 'estado_postulante_cnv_area_org'
											}
											,{
											    xtype : 'textfield',
											    name : 'des_estado_postulante_cnv_area_org',
											    fieldLabel : 'des_estado_postulante_cnv_area_org'
											}
											,{
											    xtype : 'textfield',
											    name : 'tsp_fecha_registro',
											    fieldLabel : 'tsp_fecha_registro'
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
            id: 'form_crud_ReporteContratoSuscritosYNoSuscritos_statusbar'
        })];

        this.callParent(arguments);      
    }
});
