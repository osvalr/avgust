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
* @since   01/03/2016 15:25:46
*/

Ext.define('MyApp.model.GestionarJornada.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'row_number', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'num_anio', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'num_mes', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'num_dia', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_jornada', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_modificacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_reg', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_mod', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'row_number'
});