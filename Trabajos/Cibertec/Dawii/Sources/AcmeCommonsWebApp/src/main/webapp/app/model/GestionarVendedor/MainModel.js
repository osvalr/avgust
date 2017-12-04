Ext.define('AcmeWebApp.model.GestionarVendedor.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id_persona', type: 'integer', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'cod_persona', type: 'string', useNull: true, defaultValue: null, allowNull: true}

        , {name: 'nombres_completos', type: 'string', useNull: true, defaultValue: null, allowNull: true}

        , {name: 'ape_pater', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'ape_mater', type: 'string', useNull: true, defaultValue: null, allowNull: true}

        , {name: 'id_tipo_docu_iden', type: 'integer', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'descrip_tipo_docu_iden', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'num_docu_iden', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'correo', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'direccion', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'telefono', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'sucursal', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'usuario', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'clave', type: 'string', useNull: true, defaultValue: null, allowNull: true}

        , {name: 'nom_user', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'nom_user_mod', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'descrip_estado', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'id_user', type: 'integer', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'fec_reg', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'id_user_mod', type: 'integer', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'fec_mod', type: 'string', useNull: true, defaultValue: null, allowNull: true}
        , {name: 'id_estado', type: 'integer', useNull: true, defaultValue: null, allowNull: true}

        , {name: 'tokenField', type: 'string', useNull: true, defaultValue: null, allowNull: true}

    ],
    idProperty: 'id_persona'
});
