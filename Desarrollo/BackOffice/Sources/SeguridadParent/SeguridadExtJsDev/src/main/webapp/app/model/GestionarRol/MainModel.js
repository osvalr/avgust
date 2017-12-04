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
* @since   27/02/2016 14:42:18
*/

Ext.define('MyApp.model.GestionarRol.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'id_aplicacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_aplicacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_rol', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_rol', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_modificacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_reg', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_mod', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'id_rol'
});
