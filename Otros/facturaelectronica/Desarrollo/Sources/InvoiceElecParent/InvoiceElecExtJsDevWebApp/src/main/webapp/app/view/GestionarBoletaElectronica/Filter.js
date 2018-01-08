/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   18/07/2016 02:28:23
*/

Ext.define('MyApp.view.GestionarBoletaElectronica.Filter', {

    extend: 'Ext.form.Panel',
    alias: 'widget.GestionarBoletaElectronicaFilter',
    requires: ['Ext.form.Panel'],
    
    id:'form_filter_GestionarBoletaElectronica',
	layout: {
        type: 'vbox'
    },
    fieldDefaults: {
        labelAlign: 'top',
        margin: "0 5 5 5"
    },
                                
    initComponent: function() {
    
    	var form = this;
    
        this.items = [
                
{
    xtype: 'fieldset',
    title: 'Filtros',
    flex:1,
    margin: '0 5 5 5',
    layout: {
		type: 'hbox'
	},
    flex:1,
    defaultType: 'textfield',
    defaults: {
    	labelAlign: 'top',
        anchor: '100%'
    },
    
    items: [
{
	xtype: 'container',
	layout: {
		type: 'hbox',
		align: 'stretch'
	},
	items: [
	                        	        
			{
				xtype : 'numberfield',
				hidden : false,
				editable : true,
				fieldLabel : 'Año',
				name : 'fechaemisanio',
				disabled : false,
				value:new Date().getFullYear()
			}
			,{
				xtype : 'numberfield',
				hidden : false,
				editable : true,
				fieldLabel : 'Mes',
				name : 'fechaemismes',
				disabled : false,
				value:new Date().getMonth() + 1
			}
			,{
				xtype : 'numberfield',
				hidden : false,
				editable : true,
				fieldLabel : 'Dia',
				name : 'fechaemisdia',
				disabled : false
			}
			,{
				store : {
					fields: ['codDocumento','descripDocumento'],
					proxy: {
								type: 'ajax',
								url: '/InvoiceElecWSRestApp/api/common/tipoDocumento',
								reader: {
									type: 'json',
									rootProperty: 'list'
								}
					},
					autoLoad: true,
					listeners: {
				        load: function(store) {
				        	var rec = { codDocumento:'',descripDocumento:'-- Todos --' };
				        	store.insert(0, rec);
				        }
					}
				},
				queryMode : 'local',
				displayField : 'descripDocumento',
				hidden : false,
				xtype : 'combobox',
				name : 'tipodocumentousuario',
				value : '',
				valueField : 'codDocumento',
				fieldLabel : 'T.D Cliente',
				disabled : false,
				editable : false
			}

			,{
				xtype : 'textfield',
				hidden : false,
				editable : true,
				fieldLabel : 'N.D Cliente',
				name : 'numerodocumentousuario',
				disabled : false
			}
			,{
				xtype : 'numberfield',
				hidden : false,
				editable : true,
				fieldLabel : 'N. Boleta',
				name : 'numerodocumento',
				disabled : false
			}
		]
	}
	,{
	xtype: 'container',
	layout: {
		type: 'hbox',
		align: 'stretch'
	},
	items: [
			{
				xtype : 'numberfield',
				hidden : false,
				editable : true,
				fieldLabel : 'N. Doc Electronico',
				name : 'numf_correl',
				disabled : false
			}
		]
	}
           ]
}
                      
                
        ];

        this.callParent(arguments);
    }
});