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
* @since   01/03/2016 22:17:48
*/

Ext.define('MyApp.model.GestionarClienteNatural.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'id_persona', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ape_pater', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ape_mater', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres_completos', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_tipo_doc', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_tipo_doc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'num_tipo_doc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_nacimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'email', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_modificacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_reg', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_mod', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'id_persona'
});
