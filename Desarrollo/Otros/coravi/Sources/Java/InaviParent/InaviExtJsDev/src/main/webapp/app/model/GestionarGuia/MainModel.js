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
* @since   10/03/2016 00:37:53
*/

Ext.define('MyApp.model.GestionarGuia.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'id_guia', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'num_anio', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'num_mes', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'num_dia', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'cod_jornada', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_jornada', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_tipo_producto', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_tipo_producto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_cliente', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_cliente', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_peso_bruto', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_peso_tara', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_peso_devolucion', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_peso_neto', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'precio_aplicado', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_importe', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_amortizado', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'total_deuda', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_modificacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_reg', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_mod', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'id_guia'
});
