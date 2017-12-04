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

Ext.define('MyApp.model.MttoMembInfo.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'memb_guid', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'memb___id', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'memb__pwd', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'memb_name', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres_completos', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ape_pater', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ape_mater', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_nacimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'gender', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_gender', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'mail_addr', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'country', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_country', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'sno__numb', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'memb___id_referido', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'memb_guid'
});