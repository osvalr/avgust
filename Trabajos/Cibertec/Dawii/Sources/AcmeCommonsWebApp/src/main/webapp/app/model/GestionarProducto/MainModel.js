/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/

/**
* GENERATOR CRUD EXT JS 5
* BY FOCUS CONSULTORES ASOCIADOS SAC
* DATE CREATE : 07/06/2015 12:08:29
* VERSION : 1.0
*/

Ext.define('AcmeWebApp.model.GestionarProducto.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'id_producto', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'cod_producto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_categoria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_categoria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descripcion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'observacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_moneda', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_moneda', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'precio', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ruta_foto', type: 'string', useNull: true, defaultValue:null, allowNull:true}

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
   idProperty:'id_producto'
});
