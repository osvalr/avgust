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
* DATE CREATE : 27/05/2015 04:42:23
* VERSION : 1.0
*/

Ext.define('MyApp.model.GestionarTrabajadores.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'idpersona', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonanatural', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_completo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apepat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apemat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idtipodocumento', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_documento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'numerodoc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ruc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'direccion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpais', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nompais', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idsexo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_genero', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fechanacimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'telefono', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'correopersonal', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'idpersona'
});
