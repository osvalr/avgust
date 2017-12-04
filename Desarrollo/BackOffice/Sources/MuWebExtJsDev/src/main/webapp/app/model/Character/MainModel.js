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

Ext.define('MyApp.model.Character.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'accountID', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'name', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'resets', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'clevel', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'levelUpPoint', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'clazz', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_clazz', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'strength', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dexterity', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'vitality', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'energy', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'money', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'Name'
});
