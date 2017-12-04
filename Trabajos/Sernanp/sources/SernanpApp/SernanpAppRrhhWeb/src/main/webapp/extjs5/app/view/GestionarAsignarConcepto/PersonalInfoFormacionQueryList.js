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

Ext.define('MyApp.view.GestionarAsignarConcepto.PersonalInfoFormacionQueryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.PersonalInfoFormacionQueryList',
    
    glyph:'xf022@FontAwesome',
	header: false,
    store: 'GestionarAsignarConcepto.PersonalInfoFormacionQueryStore',

    columns: [
		{
	    	header: "srl_id_personanatural_formacion",
			flex:115 / 100,
			dataIndex: 'srl_id_personanatural_formacion',
			hidden:true
		}
		,{
			header: "idpersonal",
			flex:115 / 100,
			dataIndex: 'idpersonal',
			hidden:true
		}
		,{
			header: "Grupo Ocupacional",
			flex:115 / 100,
			dataIndex: 'descrip_grupo_ocupacional',
			hidden:false
		}
		,{
			header: "Nivel Estudio",
			flex:115 / 100,
			dataIndex: 'descrip_nivel_estudio',
			hidden:false
		}
		,{
			header: "Tipo Profesion",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_profesion',
			hidden:false
		}
		,{
			header: "Profesion",
			flex:115 / 100,
			dataIndex: 'descrip_profesion',
			hidden:false
		}
		
		,{
			header: "Formacion",
			flex:115 / 100,
			dataIndex: 'descrip_tipo_formacion',
			hidden:false
		}
		
		,{
			header: "Institucion",
			flex:115 / 100,
			dataIndex: 'var_descripcion_institucion',
			hidden:false
		}
		
		,{
			header: "Pais",
			flex:115 / 100,
			dataIndex: 'descrip_pais',
			hidden:false
		}
		
		,{
			header: "F. Ingreso",
			flex:115 / 100,
			dataIndex: 'dte_fecha_ingreso',
			hidden:false
		}
		
		
		
		,{
			header: "F. Culminacion",
			flex:115 / 100,
			dataIndex: 'dte_fecha_culminacion',
			hidden:false
		}
	],
	
	initComponent: function() {
		
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [
//                    {
//            	glyph:'xf055@FontAwesome',
//                itemId: 'add',
//                text: 'Agregar',
//                action: 'add'
//            },{
//            	glyph:'xf056@FontAwesome',
//                text: 'Eliminar',
//                action: 'delete'
//            }
            ]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'GestionarAsignarConcepto.PersonalInfoFormacionQueryStore',
            displayInfo: true
        }];
		
		this.callParent(arguments);
	}
});
