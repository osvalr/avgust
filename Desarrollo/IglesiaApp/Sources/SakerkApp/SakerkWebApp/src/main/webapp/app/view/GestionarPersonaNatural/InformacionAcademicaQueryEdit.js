/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 03/12/2014 03:40:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPersonaNatural.InformacionAcademicaQueryEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.InformacionAcademicaQueryEdit',

    requires: ['Ext.form.Panel'],

    title : '',
    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    width: 410,
    
    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                id: 'form_submodel_InformacionAcademicaQuery',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',
                
                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'left',
                    allowBlank: false,
                    combineErrors: true,
                    msgTarget: 'side',
                    labelWidth: 125
                },

                items: [
					{
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'id_informacion_academica',
						fieldLabel : 'Id'
					}
					,{
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'id_persona_natural',
						fieldLabel : 'id_persona_natural'
					}
					,{
                    	xtype: 'container',
                    	padding: '0 0 5 0',
                    	layout: {
                    		type: 'hbox',
                    		align: 'stretch'
                    	},
                    	items:[
	           					{
	        						listeners : {
	        						          change: function(combo, value) {
	        						        	  	var form = Ext.getCmp('form_submodel_InformacionAcademicaQuery');
	        							    		var on_combo = form.getForm().findField('id_estudio');
	        						                on_combo.setDisabled(true);
	        						                on_combo.store.removeAll();
	        						                on_combo.store.reload({
	        							                params: {
	        							                   			id_categoria_estudio: combo.getValue()
	        							                }
	        						                });
	        						                on_combo.setDisabled(false);
	        						          }
	        						},
	        						store : {
	        								fields: ['valor_general','campo_a'],
	        								proxy: {
	        							         type: 'ajax',
	        							         url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Categoria_Estudio',
	        							         reader: {
	        							             type: 'json',
	        							             rootProperty: 'listRecords'
	        							         }
	        						    	},
	        								autoLoad: true
	        					    },
	        						queryMode : 'local',
	        						displayField : 'campo_a',
	        						hidden : false,
	        						xtype : 'combobox',
	        						name : 'id_categoria_estudio',
	        						valueField : 'valor_general',
	        						emptyText : '-- Seleccione Opción --',
	        						fieldLabel : 'Categoria Estudio'
	        					},
								{
									xtype:'button',
									margin: '0 0 0 5',
					            	glyph:'xf055@FontAwesome',
					                text: 'Nuevo',
					                action: 'addCategoriaEstudio'
					            }
                    	]
					}
					,{
                    	xtype: 'container',
                    	padding: '0 0 5 0',
                    	layout: {
                    		type: 'hbox',
                    		align: 'stretch'
                    	},
                    	items:[
	           					{
	        						store : {
	        								fields: ['id_estudio','nombre_estudio'],
	        								proxy: {
	        							         type: 'ajax',
	        							         url: 'listaEstudio.action',
	        							         reader: {
	        							             type: 'json',
	        							             rootProperty: 'listRecords'
	        							         }
	        						    	},
	        								autoLoad: false
	        					    },
	        						queryMode : 'local',
	        						displayField : 'nombre_estudio',
	        						hidden : false,
	        						xtype : 'combobox',
	        						name : 'id_estudio',
	        						valueField : 'id_estudio',
	        						emptyText : '-- Seleccione Opción --',
	        						fieldLabel : 'Estudio'
	        					},
								{
									xtype:'button',
									margin: '0 0 0 5',
					            	glyph:'xf055@FontAwesome',
					                text: 'Nuevo',
					                action: 'addEstudio'
					            }
                    	]
					}
					,{
                    	xtype: 'container',
                    	padding: '0 0 5 0',
                    	layout: {
                    		type: 'hbox',
                    		align: 'stretch'
                    	},
                    	items:[
	           					{
	        						store : {
	        								fields: ['id_persona_juridica','razon_social'],
	        								proxy: {
	        							         type: 'ajax',
	        							         url: 'listaPersonaJuridicaPorTipo.action?id_tipo_persona_juridica=2',
	        							         reader: {
	        							             type: 'json',
	        							             rootProperty: 'listRecords'
	        							         }
	        						    	},
	        								autoLoad: true
	        					    },
	        						queryMode : 'local',
	        						displayField : 'razon_social',
	        						hidden : false,
	        						xtype : 'combobox',
	        						name : 'id_centro_estudio',
	        						valueField : 'id_persona_juridica',
	        						emptyText : '-- Seleccione Opción --',
	        						fieldLabel : 'Centro Estudio'
	        					},
	        					{
									xtype:'button',
									margin: '0 0 0 5',
					            	glyph:'xf055@FontAwesome',
					                text: 'Nuevo',
					                action: 'addCentroEstudio'
					            }
                    	]
					},
					{
                    	xtype: 'container',
                    	padding: '0 0 5 0',
                    	layout: {
                    		type: 'hbox',
                    		align: 'stretch'
                    	},
                    	items:[
	           					{
	        						store : {
	        								fields: ['valor_general','campo_a'],
	        								proxy: {
	        							         type: 'ajax',
	        							         url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Nivel_Academico',
	        							         reader: {
	        							             type: 'json',
	        							             rootProperty: 'listRecords'
	        							         }
	        						    	},
	        								autoLoad: true
	        					    },
	        						allowBlank : true,
	        						queryMode : 'local',
	        						displayField : 'campo_a',
	        						hidden : false,
	        						xtype : 'combobox',
	        						name : 'id_tipo_grado_instruccion',
	        						valueField : 'valor_general',
	        						emptyText : '-- Seleccione Opción --',
	        						fieldLabel : 'Grado Instrucción'
	        					},
								{
									xtype:'button',
									margin: '0 0 0 5',
					            	glyph:'xf055@FontAwesome',
					                text: 'Nuevo',
					                action: 'addNivelAcademico'
					            }
                    	]
					}
					,{
						allowBlank : true,
						hidden : false,
						xtype : 'datefield',
						name : 'fecha_ingreso',
						format : 'd/m/Y',
						fieldLabel : 'F.Ingreso'
					}
					,{
						allowBlank : true,
						hidden : false,
						xtype : 'datefield',
						name : 'fecha_egreso',
						format : 'd/m/Y',
						fieldLabel : 'F.Egreso'
					}
					,{
						store : {
								fields: ['id','text'],
								data : [
								        {id: 1, text: 'En Curso'},{id: 2, text: 'Finalizado'}
								]
						},
						allowBlank : true,
						queryMode : 'local',
						displayField : 'text',
						hidden : false,
						xtype : 'combobox',
						name : 'flag_encurso',
						valueField : 'id',
						emptyText : '-- Seleccione Opción --',
						fieldLabel : 'En Curso?'
					}
					,{
						store : {
								fields: ['valor_general','campo_a'],
								proxy: {
							         type: 'ajax',
							         url: 'listaTablaGeneralDetalle.action?nombre_tabla_general=Estado_Generico',
							         reader: {
							             type: 'json',
							             rootProperty: 'listRecords'
							         }
						    	},
								autoLoad: true
					    },
						allowBlank : true,
						queryMode : 'local',
						displayField : 'campo_a',
						hidden : false,
						xtype : 'combobox',
						name : 'id_estado',
						valueField : 'valor_general',
						emptyText : '-- Seleccione Opción --',
						fieldLabel : 'Estado'
					}
					,{
						allowBlank : true,
						hidden : true,
						xtype : 'textfield',
						name : 'fecha_registro',
						fieldLabel : 'F.Registro'
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
