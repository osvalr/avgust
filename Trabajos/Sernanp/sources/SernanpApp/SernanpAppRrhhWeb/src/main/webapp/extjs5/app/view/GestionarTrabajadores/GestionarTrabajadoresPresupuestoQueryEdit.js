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
* DATE CREATE : 27/05/2015 04:42:23
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarTrabajadores.GestionarTrabajadoresPresupuestoQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarTrabajadoresPresupuestoQueryEdit',

    requires: ['Ext.form.Panel'],

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
                xtype: 'form',
                id: 'form_submodel_GestionarTrabajadoresPresupuestoQuery',
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
					{
					    allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'idpersonanatural',
						fieldLabel : 'idpersonanatural'
					}
					,{
					    allowBlank : true,
					    hidden : true,
						xtype : 'textfield',
						name : 'idpersonal',
						fieldLabel : 'idpersonal'
					}
					,{
	        		    
					    store : {
					    	fields: ['srl_id_anio_planilla','int_anio'],
					    	proxy: {
					    		type: 'ajax',
					    		url: 'obtener-anios-planilla.action',
					    		reader: {
					    			type: 'json',
					    			rootProperty: 'listResult'
					    		}
					    	},
					    	autoLoad: true,
					    	
					    },
					    allowBlank : true,
					    queryMode : 'local',
					    displayField : 'int_anio',
					    hidden : false,
					    xtype : 'combobox',
					    name : 'srl_id_anio_planilla',
					    valueField : 'srl_id_anio_planilla',
					    emptyText : '-- Seleccione Opción --',
					    fieldLabel: 'Año',
					    disabled : false,
					    editable : false
				
					}
					
					,{
					    allowBlank : true,
						maxLength : 100,
						minLength : 1,
						xtype : 'textfield',
						name : 'c_meta',
						fieldLabel : 'c_meta',
						hidden : true
					}
					,{
					    allowBlank : true,
						maxLength : 100,
						minLength : 1,
						xtype : 'textfield',
						name : 'c_fte_fto',
						fieldLabel : 'c_fte_fto',
						hidden : true
					}
					,{
	        		    
					    store : {
					    	fields: ['srl_id_fuente_financiamiento','var_rubro_fte_fto'],
					    	proxy: {
					    		type: 'ajax',
					    		url: 'listar-fuente-financiamiento.action',
					    		reader: {
					    			type: 'json',
					    			rootProperty: 'listResult'
					    		}
					    	},
					    	autoLoad: true,
					    	
					    },
					    allowBlank : true,
					    queryMode : 'local',
					    displayField : 'var_rubro_fte_fto',
					    hidden : false,
					    xtype : 'combobox',
					    name : 'srl_id_fuente_financiamiento',
					    valueField : 'srl_id_fuente_financiamiento',
					    emptyText : '-- Seleccione Opción --',
					    fieldLabel: 'Fte. Fto.',
					    disabled : false,
					    editable : false
				
					}
					,{
					    xtype : 'textfield',
						name : 'var_rubro_fte_fto',
						fieldLabel : 'var_rubro_fte_fto',
						hidden : true,
						allowBlank : true
					}
					,{
 	        		    
					    store : {
					    	fields: ['srl_id_meta_presupuestaria','var_cod_meta_presupuestaria'],
					    	proxy: {
					    		type: 'ajax',
					    		url: 'listar-meta-presupuestaria.action',
					    		reader: {
					    			type: 'json',
					    			rootProperty: 'listResult'
					    		}
					    	},
					    	autoLoad: true,
					    	
					    },
					    allowBlank : true,
					    queryMode : 'local',
					    displayField : 'var_cod_meta_presupuestaria',
					    hidden : false,
					    xtype : 'combobox',
					    name : 'srl_id_meta_presupuestaria',
					    valueField : 'srl_id_meta_presupuestaria',
					    emptyText : '-- Seleccione Opción --',
					    fieldLabel: 'Meta',
					    disabled : false,
					    editable : true
				
					}
					,{
					    xtype : 'textfield',
						name : 'var_cod_meta_presupuestaria',
						fieldLabel : 'var_cod_meta_presupuestaria',
						hidden : true,
						allowBlank : true
					}
					,{
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
					    allowBlank : true,
					    queryMode : 'local',
					    displayField : 'destablatipo',
					    hidden : false,
					    xtype : 'combobox',
					    name : 'int_id_estado',
					    valueField : 'codinttablatipo',
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
					    xtype : 'textfield',
						name : 'descrip_estado',
						fieldLabel : 'descrip_estado',
						hidden : true,
						allowBlank : true
					}
					,{
					    allowBlank : true,
						xtype : 'textfield',
						name : 'tsp_fecha_registro',
						fieldLabel : 'tsp_fecha_registro',
						hidden : true
						
					}
                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
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
        }];

        this.callParent(arguments);
    }
});
