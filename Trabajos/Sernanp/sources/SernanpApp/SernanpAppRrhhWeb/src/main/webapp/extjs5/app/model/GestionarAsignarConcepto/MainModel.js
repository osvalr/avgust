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
* DATE CREATE : 12/04/2015 20:29:10
* VERSION : 1.0
*/

Ext.define('MyApp.model.GestionarAsignarConcepto.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'idpersona', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonanatural', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_completo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apepat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apemat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_documento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'numerodoc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ruc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'fechanacimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nompais', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_genero', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'telefono', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'correoinstitucional', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_depto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_prov', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_ubigeo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'direccion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'srl_id_regimen_pensionario', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_regimen_pensionario', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_afp', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nombre_afp', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_tipo_comision', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_tipo_comision', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'dte_fecha_afiliacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_codigo_afiliacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_entidad_bancaria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_desc_entidad_bancaria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_cuenta_bancaria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'int_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'desc_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'idpersona'
});
