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
* @since   25/07/2016 19:41:32
*/

Ext.define('MyApp.model.MttoCuentaPorCobrar.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'id_cuenta_x_cobrar', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_cliente', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres_completos', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_glosa', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_cuenta', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'monto_deuda', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_modificacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_reg', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_mod', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'id_cuenta_x_cobrar'
});
