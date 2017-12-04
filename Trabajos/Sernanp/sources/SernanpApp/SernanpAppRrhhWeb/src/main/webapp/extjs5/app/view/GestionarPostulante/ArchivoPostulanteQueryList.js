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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPostulante.ArchivoPostulanteQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ArchivoPostulanteQueryList',
    
    glyph:'xf022@FontAwesome',
	header: true,
    store: 'GestionarPostulante.ArchivoPostulanteQueryStore',

    columns: [
		{
	    	header: "srl_id_archivo",
			flex:115 / 100,
			dataIndex: 'srl_id_archivo',
			hidden:true
		}
		,{
			header: "int_id_postulante",
			flex:115 / 100,
			dataIndex: 'int_id_postulante',
			hidden:true
		}
		,{
			header: "Nombre Documento",
			flex:115 / 100,
			dataIndex: 'var_descripcion_archivo',
			hidden:false
		}
		,{
			header: "Tipo Documento",
			flex:115 / 100,
			dataIndex: 'var_descrip_tipo_documento',
			hidden:false
		}
		,{
			header: "Fecha Registro",
			flex:115 / 100,
			dataIndex: 'tsp_fecha_registro',
			hidden:false
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [
		                    
		                    {
		                        xtype: 'form',
		                        id: 'form_submodel_ArchivoPostulanteQuery',
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
		        						xtype : 'textfield',
		        						hidden : true,
		        						editable : true,
		        						fieldLabel : 'srl_id_archivo',
		        						name : 'srl_id_archivo',
		        						disabled : false,
		        						readOnly : false
		        					}
		        					,{
		        					    allowBlank : true,
		        						xtype : 'textfield',
		        						hidden : true,
		        						editable : true,
		        						fieldLabel : 'int_id_postulante',
		        						name : 'int_id_postulante',
		        						disabled : false,
		        						readOnly : false
		        					}
		        					,{
		        					    xtype : 'textfield',
		        						hidden : false,
		        						editable : true,
		        						fieldLabel : 'Nombre de Archivo',
		        						name : 'var_descripcion_archivo',
		        						disabled : false,
		        						readOnly : false,
		        						fieldStyle: 'text-transform:uppercase',
		        						allowBlank: false
		        					},
		        					{
		        					    queryMode : 'local',
		        						xtype : 'combobox',
		        						emptyText : '-- Seleccione Opción --',
		        						editable : false,
		        						fieldLabel : 'Tipo',
		        						name : 'int_id_tipo_documento',
		        						store : {
		        								fields: ['int_id_tipo_documento','var_descrip_tipo_documento'],
		        								data: [
															{
																int_id_tipo_documento : 1, 
																var_descrip_tipo_documento : 'DNI'
															},
															{
																int_id_tipo_documento : 2, 
																var_descrip_tipo_documento : 'RUC'
															}
		        								       ]
		        						},
		        					    displayField : 'var_descrip_tipo_documento',
		        						valueField : 'int_id_tipo_documento'
		        					}
		        					,{
		        						xtype: 'filefield',
		        						emptyText: 'Seleccione un archivo',
		        						vtype:'fileDocUpload',
		        						allowBlank: false,
		        						fieldLabel: 'Archivo',
		        						name: 'upload',
		        						buttonConfig: {
		        							glyph: 'xf03e@FontAwesome'
		        						}
		        					},
		        					{
		        						xtype: 'hidden',
		        						name: 'file_name_session',
		        						value: 'files_postulante',
		        						hidden : true
		        					}
		                        ],

		                        buttons: [
		                            {
		                            	glyph: 'xf055@FontAwesome',
						                text: 'Agregar Documento',
						                action: 'save'
						            }
		                        ]
		                    },
		                    
		  {
            xtype: 'toolbar',
            items: [
                    
//{
//	glyph:'xf055@FontAwesome',
//    itemId: 'add',
//    text: 'Agregar Documento',
//    action: 'add'
//},
                    
            {
            	glyph:'xf056@FontAwesome',
                text: 'Eliminar Documento',
                action: 'delete'
            },{
            	glyph:'xf01a@FontAwesome',
                text: 'Descargar Doucumento',
                action: 'download'
              }
            ]
        }
		  ,
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarPostulante.ArchivoPostulanteQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
