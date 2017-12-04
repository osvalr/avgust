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
* @since   28/02/2016 02:49:06
*/

Ext.define('MyApp.model.GestionarFuncionalidad.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'id_funcionalidad', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_funcionalidad', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'recurso_funcionalidad', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'icon_cls', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'alias_component', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'component_controllers', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_modificacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_reg', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_mod', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'id_funcionalidad'
});
