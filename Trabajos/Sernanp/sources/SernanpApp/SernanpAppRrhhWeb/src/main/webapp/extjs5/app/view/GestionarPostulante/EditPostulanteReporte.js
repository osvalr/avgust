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
* DATE CREATE : 08/04/2015 00:02:56
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPostulante.EditPostulanteReporte', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionaPostulanteEditReporte',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 400,
    title:'Generar Reportes : ',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
							{
				                xtype: 'form',
				                id: 'form_reporte_postulante',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'qtip',
                    				labelWidth: 125
			                	},

		                		items: [
											/*{
												listeners : {
											    	change: function(combo, newValue, oldValue) {

											    		var form = Ext.getCmp('form_reporte_postulante');
											    		var on_combo = form.getForm().findField('srl_id_conv_area_org');
											    		on_combo.setDisabled(true);
											    		on_combo.store.removeAll();
											    		on_combo.store.reload({
											    			params: {
											    				idConvocatoria: combo.getValue()
											    			}
											    		});
											    		on_combo.setDisabled(false);
											    		
											    		if(oldValue != null){
											    			on_combo.setValue('');
											    		}
											    	}
											    },
												store : {
													fields: ['srl_id_convocatoria','var_num_convocatoria'],
													proxy: {
																type: 'ajax',
																url: 'obtener-convocatorias.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true,
													
												},
												queryMode : 'local',
												displayField : 'var_num_convocatoria',
												hidden : false,
												xtype : 'combobox',
												name : 'srl_id_convocatoria',
												value : '',
												valueField : 'srl_id_convocatoria',
												fieldLabel : 'Convocatoria',
												disabled : false,
												editable : false,
												allowBlank: false,
												emptyText : '-- Seleccione Opción --'
											},
											
											{
												
												store : {
													fields: ['srl_id_conv_area_org','var_codigo_postulacion'],
													proxy: {
																type: 'ajax',
																url: 'obtener-codigos-postulacion.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: false,
													listeners:{
											    		load: function(store){
											    			var rec = {srl_id_conv_area_org:'', var_codigo_postulacion:'-- Todos --'}
											    			store.insert(0,rec);
											    		}
											    	}
													
												},
												queryMode : 'local',
												displayField : 'var_codigo_postulacion',
												hidden : false,
												xtype : 'combobox',
												name : 'srl_id_conv_area_org',
												value : '',
												valueField : 'srl_id_conv_area_org',
												fieldLabel : 'Código de Postulación',
												disabled : false,
												editable : false,
												allowBlank: true
												
											}
											,*/
											
											{
												
												store : {
													fields: ['idTipoReporte','reporte'],
													proxy: {
																type: 'ajax',
																url: 'obtener-codigos-postulacion.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true,
													listeners:{
											    		load: function(store){
											    			var rec  = {idTipoReporte:'1', reporte:'Inscritos'}
											    			var rec1 = {idTipoReporte:'2', reporte:'Contrato Suscrito / no Suscrito'}
											    			var rec2 = {idTipoReporte:'3', reporte:'Etapas de Evaluación'}
											    			store.insert(0,rec);
											    			store.insert(0,rec1);
											    			store.insert(0,rec2);
											    			
											    		}
											    	}
													
												},
												queryMode : 'local',
												displayField : 'reporte',
												hidden : false,
												xtype : 'combobox',
												name : 'idTipoReporte',
												value : '',
												valueField : 'idTipoReporte',
												fieldLabel : 'Postulantes ',
												disabled : false,
												editable : false,
												allowBlank: false
												
											}
											,
											{
												
												store : {
													fields: ['idformato','formato'],
													proxy: {
																type: 'ajax',
																url: 'obtener-codigos-postulacion.action',
																reader: {
																	type: 'json',
																	rootProperty: 'listResult'
																}
													},
													autoLoad: true,
													listeners:{
											    		load: function(store){
											    			var rec  = {idformato:'1', formato:'-- Excel --'}
											    			var rec1 = {idformato:'2', formato:'-- Pdf --'}											    			
											    			store.insert(0,rec);
											    			store.insert(0,rec1);
											    			
											    		}
											    	}
													
												},
												queryMode : 'local',
												displayField : 'formato',
												hidden : false,
												xtype : 'combobox',
												name : 'idformato',
												value : '',
												valueField : 'idformato',
												fieldLabel : 'Formato Reporte',
												disabled : false,
												editable : false,
												allowBlank: false
												
											}
											
											
										]
							}

        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf013@FontAwesome',
                text: 'Generar',
                action: 'generarReportePostulante'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_reporte_postulante_statusbar'
        })];

        this.callParent(arguments);      
    }
});
