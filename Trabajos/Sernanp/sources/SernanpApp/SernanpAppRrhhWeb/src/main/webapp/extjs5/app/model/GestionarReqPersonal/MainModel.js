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
* DATE CREATE : 19/04/2015 01:20:12
* VERSION : 1.0
*/

Ext.define('MyApp.model.GestionarReqPersonal.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'srl_id_requerimiento_personal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_requerimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_numero_requerimiento_corto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idarea_solicitante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_area_solicitante', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idunidad_solicitante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_unidad_solicitante', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idarea_supervisora', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_area_supervisora', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idunidad_supervisora', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_unidad_supervisora', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idareanatural', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'desareanatural', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idsede', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dessede', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idcategoriaanp', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descategoriaanp', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'int_cantidad_requerida', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dec_honorario_personal', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_cantidad_tiempo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_tipo_unidad_tiempo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_experiencia_requerida', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_competencias_requeridas', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_formacion_academica', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_cursos_especializacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_requisitos_puesto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_principales_funciones', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_requiere_evaluacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_lugar_prestacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_estado', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_tipo_trabajador', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'descrip_trabajador', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_denominacion_requerimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tsp_fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'path_files_requerimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'c_fte_fto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'c_meta', type: 'string', useNull: true, defaultValue:null, allowNull:true}
                        
            ,{name: 'int_anio', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'srl_id_anio_planilla', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'tsp_fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'id_sede_ubicacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true} 
            ,{name: 'direccion_ubicacion_fisica', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_nomb_sede', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            

            
            
            ],
   idProperty:'srl_id_requerimiento_personal'
});
