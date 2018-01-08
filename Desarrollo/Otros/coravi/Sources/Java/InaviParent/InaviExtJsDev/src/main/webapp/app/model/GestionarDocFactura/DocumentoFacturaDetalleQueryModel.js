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
* @since   14/09/2016 05:45:45
*/

Ext.define('MyApp.model.GestionarDocFactura.DocumentoFacturaDetalleQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
    	     {name: 'id_venta_item', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_documento_venta', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'unidad_medida', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'codigo_articulo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_articulo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'cantidad_articulo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'peso_articulo', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'precio_unitario', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'importe_total', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fecha_modificacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_reg', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_usuario_mod', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'id_venta_item'
});