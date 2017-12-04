Ext.define('AcmeWebApp.model.GestionarCotizacion.MainModel', {
    extend: 'Ext.data.Model',
    fields: [

    	     {name: 'id_cotizacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'cod_cotizacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_cliente', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres_cliente', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_vendedor', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres_vendedor', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'importe_total', type: 'float', useNull: true, defaultValue:null, allowNull:true}

            ,{name: 'nom_user', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nom_user_mod', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_user', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fec_reg', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_user_mod', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fec_mod', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}

            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}

            ],
   idProperty:'id_cotizacion'
});
