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

Ext.define('MyApp.model.GestionarAsignarConcepto.PersonalInfoFormacionQueryModel', {
    extend: 'Ext.data.Model',
    fields: [		
    	     {name: 'srl_id_personanatural_formacion', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'idpersonal', type: 'integer', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_grupo_ocupacional', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_nivel_estudio', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_tipo_profesion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_profesion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_tipo_formacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'var_descripcion_institucion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'descrip_pais', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ,{name: 'dte_fecha_ingreso', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            
            ,{name: 'dte_fecha_culminacion', type: 'string', useNull: true, defaultValue:null, allowNull:true}
            ],
   idProperty:'srl_id_personanatural_formacion'
});