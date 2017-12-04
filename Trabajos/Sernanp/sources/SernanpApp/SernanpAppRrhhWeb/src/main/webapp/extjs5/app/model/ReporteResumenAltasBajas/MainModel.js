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
* DATE CREATE : 11/06/2015 14:14:52
* VERSION : 1.0
*/

Ext.define('MyApp.model.ReporteResumenAltasBajas.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'int_anio', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_periodo_mes', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_regimen_contractual', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'numerodoc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apepat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apemat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre_completo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'direccion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nompais', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'sexo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fechanacimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ruc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'telefono', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'mailpersonal', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idarea', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'desarea', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fec_inicio', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fec_termino', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_desc_grupo_ocupacional', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nom_cargo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_regimen_pensionario', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nombre_afp', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_codigo_afiliacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fecha_afiliacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_cuenta_bancaria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'c_meta', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'c_fte_fto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ubicacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dec_total_ingresos', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_cod_nivel_estudio', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_nivel_estudio', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_cod_tipo_profesion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_tipo_profesion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_cod_profesion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_profesion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_institucion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fecha_ingreso', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fecha_culminacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_sigue_estudios', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_periodo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'quinta_categoria', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'cuarta_categoria', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'essalud', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'idpersonal'
});
