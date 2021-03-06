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
* @since   29/03/2016 22:54:29
*/

Ext.define('MyApp.view.Character.AddPointForm', {
    extend: 'Ext.window.Window',
    alias : 'widget.AddPointForm',

    requires: ['Ext.form.Panel'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 350,
    title:'Add Points',
    iconCls:'icon-pencil',

    initComponent: function() {
        this.items = [

							{
				                xtype: 'form',
				                id: 'form_AddPointForm',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                header:false,
				                
				                fieldDefaults: {
					    			anchor: '100%',
					    			labelAlign: 'right',
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
											    fieldLabel : 'NameCharacter',
											    name : 'name',
											    disabled : false,
											    readOnly : false
											}
											
											,{
										        xtype: 'fieldset',
										        title: 'Stats Info',
										        defaultType: 'textfield',
										        defaults: {
										            anchor: '100%'
										        },
										        
										        items: [
													{
													    allowBlank : true,
													    xtype : 'textfield',
													    hidden : false,
													    editable : true,
													    fieldLabel : 'LevelUpPoint',
													    name : 'levelUpPoint',
													    disabled : false,
													    readOnly : true
													}
												    ,{
													    allowBlank : true,
													    xtype : 'numberfield',
													    fieldLabel : 'Strength',
													    name : 'str',
													    minValue: 0,
													    maxValue:65535
													}
													,{
													    allowBlank : true,
													    xtype : 'numberfield',
													    fieldLabel : 'Dexterity',
													    name : 'dex',
													    minValue: 0,
													    maxValue:65535
													}
													,{
													    allowBlank : true,
													    xtype : 'numberfield',
													    fieldLabel : 'Vitality',
													    name : 'vit',
													    minValue: 0,
													    maxValue:65535
													}
													,{
													    allowBlank : true,
													    xtype : 'numberfield',
													    fieldLabel : 'Energy',
													    name : 'ene',
													    minValue: 0,
													    maxValue:65535
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
            	iconCls:'icon-disk_black',
                itemId: 'save',
                text: 'Save',
                action: 'save'
            },{
            	iconCls:'icon-cross',
                text: 'Cancel',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);      
    }
});
