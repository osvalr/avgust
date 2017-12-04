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
* DATE CREATE : 20/04/2015 15:33:18
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarNotasPostulante.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarNotasPostulanteEdit',

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
				                id: 'form_crud_GestionarNotasPostulante',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Registro de Notas',
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
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Id',
											    name : 'srl_conv_area_org_factor_eval',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'srl_id_postulante_conv_area_org',
											    name : 'srl_id_postulante_conv_area_org',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'srl_id_factor_evaluacion',
											    name : 'srl_id_factor_evaluacion',
											    disabled : false,
											    readOnly : false
											}
											,{
											    queryMode : 'local',
											    allowBlank : false,
											    xtype : 'combobox',
											    hidden : false,
											    emptyText : '-- Seleccione Opción --',
											    editable : false,
											    readOnly : false,
											    store : {
											    	fields: ['codinttablatipo','destablatipo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Asistencia',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    valueField : 'codinttablatipo',
											    fieldLabel : 'Asistencia',
											    name : 'int_id_estado_asistencia',
											    displayField : 'destablatipo',
											    disabled : false
											}
											,{
											    allowBlank : true,
											    xtype : 'numberfield',
											    hidden : false,
											    vtype : 'soloNumeroDecimales',
											    editable : true,
											    fieldLabel : 'Puntaje Obtenido',
											    name : 'dec_puntaje_obtenido',
											    disabled : false,
											    readOnly : false,
											    minValue: 0,
											    maxValue: 100
											}
//											,{
//											    queryMode : 'local',
//											    allowBlank : false,
//											    xtype : 'combobox',
//											    hidden : true,
//											    emptyText : '-- Seleccione Opción --',
//											    editable : false,
//											    readOnly : false,
//											    store : {
//											    	fields: ['codinttablatipo','destablatipo'],
//											    	proxy: {
//											    		type: 'ajax',
//											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Clasificacion',
//											    		reader: {
//											    			type: 'json',
//											    			rootProperty: 'listResult'
//											    		}
//											    	},
//											    	autoLoad: true
//											    },
//											    valueField : 'codinttablatipo',
//											    fieldLabel : 'Clasificación',
//											    name : 'int_id_estado_clasificacion',
//											    displayField : 'destablatipo',
//											    disabled : false
//											}
//											,{
//											    queryMode : 'local',
//											    allowBlank : false,
//											    xtype : 'combobox',
//											    hidden : true,
//											    emptyText : '-- Seleccione Opción --',
//											    editable : false,
//											    readOnly : false,
//											    store : {
//											    	fields: ['codinttablatipo','destablatipo'],
//											    	proxy: {
//											    		type: 'ajax',
//											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Generico',
//											    		reader: {
//											    			type: 'json',
//											    			rootProperty: 'listResult'
//											    		}
//											    	},
//											    	autoLoad: true
//											    },
//											    valueField : 'codinttablatipo',
//											    fieldLabel : 'Estado',
//											    name : 'int_id_estado',
//											    displayField : 'destablatipo',
//											    disabled : false
//											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    fieldLabel : 'tokenField',
											    name : 'tokenField'
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
            id: 'form_crud_GestionarNotasPostulante_statusbar'
        })];

        this.callParent(arguments);      
    }
});
