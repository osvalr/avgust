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
* DATE CREATE : 15/04/2015 13:43:48
* VERSION : 1.0
*/

Ext.define('MyApp.model.GestionarPostulante.MainModel', {
    extend: 'Ext.data.Model',
    fields: [
    	     {name: 'idpersona', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonanatural', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_id_postulante', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombres_completos', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nombre', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apepat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'apemat', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idtipodocumento', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_tipo_documento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'numerodoc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'ruc', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'fechanacimiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idsexo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_sexo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idestadocivil', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_estado_civil', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'coddpto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_depto', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'codprov', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_prov', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idubigeo', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_ubigeo', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'direccion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpais', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'nompais', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_email_principal', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_email_secundario', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_persona_discapacitada', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_pertenece_ffaa', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_culmino_edu_prima', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'int_culmino_edu_secun', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_resumen_profesional', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            //ADD 28-01-2016 DAVID
            
            
            
            ,{name: 'srl_id_convocatoria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'var_num_convocatoria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'estado_convocatoria', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'srl_id_conv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'var_codigo_postulacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'idarea', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'desarea', type: 'string', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'idunidad', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'nomunidad', type: 'string', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'des_estado_convocatoria', type: 'string', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'estado_postulante_cnv_area_org', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'des_estado_postulante_cnv_area_org', type: 'string', useNull: true, defaultValue:null, allowNull:true}
             
            ,{name: 'tsp_fecha_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'var_nomb_sede', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'lanzamiento', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            
            ,{name: 'int_id_tipo_factor', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'evaluacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'dec_puntaje_obtenido', type: 'float', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'dec_puntaje_total', type: 'float', useNull: true, defaultValue:null, allowNull:true}            
            
            ,{name: 'int_id_estado_clasificacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'estado_clasificacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'var_observacion_registro', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            
            
            //END
            
            ,{name: 'tokenField', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'idpersona'
});
