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
* DATE CREATE : 07/05/2015 16:53:32
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.RpPlanillaCasMesAnio.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['RpPlanillaCasMesAnio.MainStore'],

    models: ['RpPlanillaCasMesAnio.MainModel'],

    views: ['RpPlanillaCasMesAnio.Edit', 'RpPlanillaCasMesAnio.List'],

    refs: [
    	{
            ref: 'RpPlanillaCasMesAnioPanel',
            selector: 'panel'
        },
        {
            ref: 'RpPlanillaCasMesAnioList',
            selector: 'RpPlanillaCasMesAnioList'
        }
    ],

    init: function() {
    
        Ext.getStore('RpPlanillaCasMesAnio.MainStore').addListener('beforeload',this.setExtraParams,this);
    
        this.control({
            'RpPlanillaCasMesAnioList dataview': {
                itemdblclick: this.editRecord
            },
            'RpPlanillaCasMesAnioList button[action=add]': {
            	click: this.editRecord
            },
            'RpPlanillaCasMesAnioList button[action=delete]': {
                click: this.deleteRecord
            },
            'RpPlanillaCasMesAnioEdit button[action=save]': {
                click: this.updateRecord
            },
            'RpPlanillaCasMesAnioList button[action=filter]': {
                click: this.refreshGrid
            },
            'RpPlanillaCasMesAnioList button[action=clearFilter]': {
                click: this.resetForm
            },
            'RpPlanillaCasMesAnioList button[action=generarReporte]': {
                click: this.listarResumenCasMesAnio
            },
            'RpPlanillaCasMesAnioList combobox': {
                change: this.refreshGrid
            },
            'RpPlanillaCasMesAnioList textfield': {
            	specialkey: this.onKeyEnter
            }
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.RpPlanillaCasMesAnio.Edit').show();
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
        var store = Ext.getStore('RpPlanillaCasMesAnio.MainStore');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_nomina_anio_periodo_personal > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.RpPlanillaCasMesAnio.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
                    
                    var sb = Ext.getCmp('form_crud_RpPlanillaCasMesAnio_statusbar');
	        		sb.showBusy('Grabando...');
	        		win.getEl().mask();
	                	
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	store.load();
				        	win.close();
	        	        },
	        	        failure: function (batch, eOpts) {
							store.rejectChanges();
                            sb.setStatus({text:'Error intentado grabar.'});
				        	win.getEl().unmask();
	        	        }
	        	    });
	            }
	        });
		}
    },
    
    deleteRecord: function(button) {
    	
    	var grid = this.getRpPlanillaCasMesAnioList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('RpPlanillaCasMesAnio.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        },
		        	        failure: function (batch, eOpts) {
								store.rejectChanges();
		        	        }
					    });
	                }
	        });
    	}

    },
    
    listarResumenCasMesAnio: function(button){
    	
    	var grid = this.getRpPlanillaCasMesAnioList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('RpPlanillaCasMesAnio.MainStore');
    	
   		window.open('listar-resumen-cas-mes-anio.action','_blank');        //?int_id_periodo_mes='+record[0].data.int_id_periodo_mes, '_blank');
    	
    },
    
    refreshGrid: function() {
    	var store = Ext.getStore('RpPlanillaCasMesAnio.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('RpPlanillaCasMesAnio.MainStore');
        var form = Ext.getCmp('form_filter_RpPlanillaCasMesAnio');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('RpPlanillaCasMesAnio.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('RpPlanillaCasMesAnio.MainStore');
        var form = Ext.getCmp('form_filter_RpPlanillaCasMesAnio');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
});