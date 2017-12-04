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
* DATE CREATE : 21/04/2015 20:40:38
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ConvocatoriaPlaza.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ConvocatoriaPlazaEdit',

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
				                id: 'form_crud_ConvocatoriaPlaza',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información de la Convocatoria',
				                glyph:'xf022@FontAwesome',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'qtip',
                    				labelWidth: 145
			                	},
			                	
			                	items: [{ 
			                	      xtype:'container', 
			                	      layout:{
			                	    	  type:'hbox',
			                	    	  align: 'stretch'
			                	      },
			                	
					                	items: [
					                	        { 
						                	      xtype:'container',
						                	      defaults:{
							                		   margin: '5 5'  
							                	   },
						                	      width:'50%',
						                	      layout:{
						                	    	  type:'vbox',
						                	    	  align: 'stretch'
						                	      },

						                		items: [
															{
															    allowBlank : true,
															    hidden : true,
															    xtype : 'textfield',
															    name : 'srl_id_convocatoria',
															    fieldLabel : 'srl_id_convocatoria'
															}
															,{
															    maxLength : 100,
															    minLength : 1,
															    xtype : 'textfield',
															    name : 'var_num_convocatoria',
															    fieldLabel : 'Nº de Convocatoria',
															    editable : false,
															    allowBlank : true,
															    hidden:true
															    
															}
															,{
															    maxLength : 100,
															    minLength : 1,
															    xtype : 'textfield',
															    name : 'var_num_convocatoria_corto',
															    fieldLabel : 'Nº de Convocatoria',
															    editable : false,
															    allowBlank : true,
															    inputAttrTpl: " data-qtip='Número autogenerado.' "
															}
															,{
															    allowBlank : false,
															    xtype : 'datefield',
															    name : 'dte_fecha_aprobacion',
															    format : 'd/m/Y',
															    fieldLabel : 'Fecha de Aprobación'
															}
															,{
															    allowBlank : false,
															    xtype : 'datefield',
															    name : 'dte_fecha_inicio_publicacion',
															    id: 'startdt',
															    vtype: 'daterange',
															    endDateField: 'enddt',
															    format : 'd/m/Y',
															    fieldLabel : 'F. Inicio de la Publicación del Proceso'
															}
															,{
															    allowBlank : false,
															    xtype : 'datefield',
															    name : 'dte_fecha_termino_publicacion',
															    vtype: 'daterange',
															    id: 'enddt',
															    startDateField: 'startdt',
															    format : 'd/m/Y',
															    fieldLabel : 'F. Término de la Publicación del Proceso'
															}
//															,{
//															    allowBlank : false,
//															    xtype : 'numberfield',
//															    name : 'int_num_activacion',
//															    fieldLabel : 'Nº de Lanzamiento',
//															    vtype : 'soloNumeros',
//															    maxValue: 10,
//														        minValue: 0,
//														        readOnly: true,
//														        value: 1
//															}
															,{
															    store : {
															    	fields: ['var_cod_estado','var_nombre_estado'],
															    	proxy: {
															    		type: 'ajax',
															    		url: 'obtener-estado-convocatoria.action',
															    		reader: {
															    			type: 'json',
															    			rootProperty: 'listResult'
															    		}
															    	},
															    	autoLoad: true
															    },
															    allowBlank : false,
															    queryMode : 'local',
															    displayField : 'var_nombre_estado',
															    hidden : false,
															    xtype : 'combobox',
															    name : 'int_id_estado',
															    valueField : 'var_cod_estado',
															    emptyText : '-- Seleccione Opción --',
															    fieldLabel : 'Estado',
															    disabled : false,
															    editable : false,
															    listeners : {
															    	scope : this,
															    	afterRender : function(me){
															    		me.setValue(1);
															    	}
															    }
															}
															,{
															    allowBlank : true,
															    xtype : 'datefield',
															    name : 'tsp_fecha_registro',
															    format : 'd/m/Y',
															    fieldLabel : 'tsp_fecha_registro',
															    hidden: true
															}
															,{
															    allowBlank : true,
															    hidden : true,
															    xtype : 'textfield',
															    name : 'tokenField',
															    fieldLabel : 'tokenField'
															}
														]
					                	      }]
							         }]
							}
							

							,{
					    		title: 'Plazas',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_ConvocatoriaPlazaQuery', xtype:'ConvocatoriaPlazaQueryList'}]
							}
							,{
					    		title: 'Configuracion de etapas',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_ConvocatoriaEtapaQuery', xtype:'ConvocatoriaEtapaQueryList'}]
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
            id: 'form_crud_ConvocatoriaPlaza_statusbar'
        })];

        this.callParent(arguments);      
    }
});
