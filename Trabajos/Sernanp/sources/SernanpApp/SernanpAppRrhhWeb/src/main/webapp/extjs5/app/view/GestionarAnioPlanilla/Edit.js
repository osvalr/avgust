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
* DATE CREATE : 23/03/2015 12:20:16
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarAnioPlanilla.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarAnioPlanillaEdit',

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
				                id: 'form_crud_GestionarAnioPlanilla',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información del Año',
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
											    hidden : true,
											    xtype : 'textfield',
											    name : 'srl_id_anio_planilla',
											    fieldLabel : 'Nro.',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    maxLength : 100,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_cod_ejecutor',
											    vtype : 'soloNumeros',
											    fieldLabel : 'Código Ejecutor',
											    disabled : false,
											    editable : true,
											    listeners : {
											    	scope : this,
											    	afterRender : function(me){
											    		me.setValue('0155');
											    	}
											    }
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    hidden : false,
											    xtype : 'textfield',
											    name : 'int_anio',
											    vtype : 'soloNumeros',
											    fieldLabel : 'Año',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : false,
											    maxLength : 500,
											    hidden : false,
											    minLength : 1,
											    xtype : 'textareafield',
											    name : 'var_nombre_anio',
											    fieldLabel : 'Denominación del Año',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'datefield',
											    name : 'dte_fecha_inicio',
											    format : 'd/m/Y',
											    fieldLabel : 'Fecha Inicio',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'datefield',
											    name : 'dte_fecha_fin',
											    format : 'd/m/Y',
											    fieldLabel : 'Fecha Fin ',
											    disabled : false,
											    editable : true
											}
//											,{
//											    readOnly : false,
//											    store : {
//											    	fields: ['codinttablatipo','destablatipo'],
//											    	proxy: {
//											    		type: 'ajax',
//											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Vigencia',
//											    		reader: {
//											    			type: 'json',
//											    			rootProperty: 'listResult'
//											    		}
//											    	},
//											    	autoLoad: true
//											    },
//											    listeners:{
//											    	beforerender:function(combobox){
////											    		combobox.setValue(1)
//											    	}
//											    },
//											    allowBlank : false,
//											    queryMode : 'local',
//											    displayField : 'destablatipo',
//											    hidden : true,
//											    xtype : 'combobox',
//											    name : 'int_id_estado_vigencia',
//											    valueField : 'codinttablatipo',
//											    emptyText : '-- Seleccione Opción --',
//											    fieldLabel : 'Vigencia',
//											    disabled : false,
//											    editable : true
//											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'descrip_estado_vigencia',
											    fieldLabel : 'Estado Vigencia',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    store : {
											    	fields: ['codinttablatipo','destablatipo'],
											    	proxy: {
											    		type: 'ajax',
											    		url: 'obtener-valores-tablatipo-por-nombre.action?nombre_tabla=Tipo_Estado_Generico',
											    		reader: {
											    			type: 'json',
											    			rootProperty: 'listResult'
											    		}
											    	},
											    	autoLoad: true
											    },
											    listeners:{
											    	beforerender:function(combobox){
											    		combobox.setValue(1)
											    	}
											    },
											    allowBlank : false,
											    queryMode : 'local',
											    displayField : 'destablatipo',
											    hidden : false,
											    xtype : 'combobox',
											    name : 'int_id_estado',
											    valueField : 'codinttablatipo',
											    emptyText : '-- Seleccione Opción --',
											    fieldLabel : 'Estado',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'descrip_estado',
											    fieldLabel : 'Estado',
											    disabled : false,
											    editable : true
											}
											,{
											    readOnly : false,
											    allowBlank : true,
											    hidden : true,
											    xtype : 'datefield',
											    name : 'tsp_fecha_registro',
											    format : 'd/m/Y',
											    fieldLabel : 'Fecha Registro',
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
							

							,{
					    		title: 'Parámetros',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_GestionarAnioParametroPlanillaQuery', xtype:'GestionarAnioParametroPlanillaQueryList'}]
							}
							,{
					    		title: 'Periodos',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_GestionarAnioPeriodoPlanillaQuery', xtype:'GestionarAnioPeriodoPlanillaQueryList'}]
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
            id: 'form_crud_GestionarAnioPlanilla_statusbar'
        })];

        this.callParent(arguments);      
    }
});
