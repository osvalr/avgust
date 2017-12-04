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
* DATE CREATE : 13/07/2015 14:25:29
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReporteSeleccionPostulantesEntrevistaPersonal.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReporteSeleccionPostulantesEntrevistaPersonalEdit',

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
				                id: 'form_crud_ReporteSeleccionPostulantesEntrevistaPersonal',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'RpSeleccionPostulantesEntrevistaPersonalQuery',
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
											    name : 'var_nombre_etapa',
											    fieldLabel : 'var_nombre_etapa'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descrip_subetapa',
											    fieldLabel : 'var_descrip_subetapa'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_id_estado_asistencia',
											    fieldLabel : 'int_id_estado_asistencia'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_puntaje_obtenido',
											    fieldLabel : 'dec_puntaje_obtenido'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_id_estado_clasificacion',
											    fieldLabel : 'int_id_estado_clasificacion'
											}
											,{
											    xtype : 'textfield',
											    name : 'des_estado_postulante_cnv_area_org',
											    fieldLabel : 'des_estado_postulante_cnv_area_org'
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
            id: 'form_crud_ReporteSeleccionPostulantesEntrevistaPersonal_statusbar'
        })];

        this.callParent(arguments);      
    }
});
