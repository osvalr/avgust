/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 20/12/2014 14:30:15
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.GestionarPersonaNatural.InformacionAcademicaQueryController', {
    extend: 'Ext.app.Controller',

    stores: ['GestionarPersonaNatural.InformacionAcademicaQueryStore'],

    models: ['GestionarPersonaNatural.InformacionAcademicaQueryModel'],

    views: ['GestionarPersonaNatural.InformacionAcademicaQueryEdit', 'GestionarPersonaNatural.InformacionAcademicaQueryList'],

    refs: [
    	{
            ref: 'InformacionAcademicaQueryPanel',
            selector: 'panel'
        },
        {
            ref: 'InformacionAcademicaQueryList',
            selector: 'InformacionAcademicaQueryList'
        }
    ],

    init: function() {
        this.control({
            'InformacionAcademicaQueryList dataview': {
                itemdblclick: this.editRecord
            },
            'InformacionAcademicaQueryList button[action=add]': {
            	click: this.editRecord
            },
            'InformacionAcademicaQueryList button[action=delete]': {
                click: this.deleteRecord
            },
            'InformacionAcademicaQueryEdit button[action=save]': {
                click: this.updateRecord
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.GestionarPersonaNatural.InformacionAcademicaQueryEdit').show();
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        }else{
        	edit.setTitle('Agregar');
        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('GestionarPersonaNatural.InformacionAcademicaQueryStore');
        
        var id_categoria_estudio = form.getForm().findField('id_categoria_estudio');
        values.descrip_categoria_estudio = id_categoria_estudio.getRawValue();
        
        var id_estudio = form.getForm().findField('id_estudio');
        values.nombre_estudio = id_estudio.getRawValue();
        
        var id_centro_estudio = form.getForm().findField('id_centro_estudio');
        values.razon_social = id_centro_estudio.getRawValue();
        
        var id_tipo_grado_instruccion = form.getForm().findField('id_tipo_grado_instruccion');
        values.descrip_tipo_grado_instruccion = id_tipo_grado_instruccion.getRawValue();
        
        var flag_encurso = form.getForm().findField('flag_encurso');
        values.descrip_flag_encurso = flag_encurso.getRawValue();
        
        var id_estado = form.getForm().findField('id_estado');
        values.descrip_estado = id_estado.getRawValue();
        
        
		if(win.title === 'Editar') {
			record.set(values);
		} else{
			record = Ext.create('MyApp.model.GestionarPersonaNatural.InformacionAcademicaQueryModel');
			record.set(values);
			store.add(record);
		}
        
		win.close();	
		store.sync({
	        success: function (batch, eOpts) {
	            store.load({params: {id_persona_natural: null}});
	        }
	    });
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getInformacionAcademicaQueryList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('GestionarPersonaNatural.InformacionAcademicaQueryStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás Seguro de ELIMINAR el Registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					            store.load({params: {id_persona_natural: null}});
					        }
					    });
	                }
	        });
    	}

    }
    
});