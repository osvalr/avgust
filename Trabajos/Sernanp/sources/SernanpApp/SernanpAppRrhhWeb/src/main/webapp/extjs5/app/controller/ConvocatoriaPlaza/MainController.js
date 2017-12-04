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
* DATE CREATE : 23/04/2015 16:49:26
* VERSION : 1.0 
*/

Ext.define('MyApp.controller.ConvocatoriaPlaza.MainController', {
    extend: 'Ext.app.Controller',

    stores: ['ConvocatoriaPlaza.MainStore'],

    models: ['ConvocatoriaPlaza.MainModel'],

    views: ['ConvocatoriaPlaza.Edit', 'ConvocatoriaPlaza.List'],

    refs: [
    	{
            ref: 'ConvocatoriaPlazaPanel',
            selector: 'panel'
        },
        {
            ref: 'ConvocatoriaPlazaList',
            selector: 'ConvocatoriaPlazaList'
        }
    ],

    init: function() {
    
        Ext.getStore('ConvocatoriaPlaza.MainStore').addListener('beforeload',this.setExtraParams,this);
        
        this.control({
            'ConvocatoriaPlazaList dataview': {
                itemdblclick: this.editRecord
            },
            'ConvocatoriaPlazaList button[action=add]': {
            	click: this.editRecord
            },
            'ConvocatoriaPlazaList button[action=relanzar]': {
            	click: this.relanzar
            },
            'ConvocatoriaPlazaList button[action=delete]': {
                click: this.deleteRecord
            },
            'ConvocatoriaPlazaEdit button[action=save]': {
                click: this.updateRecord
            },
            'ConvocatoriaPlazaList button[action=filter]': {
                click: this.refreshGrid
            },
            'ConvocatoriaPlazaList button[action=clearFilter]': {
                click: this.resetForm
            },
            'ConvocatoriaPlazaList combobox': {
                change: this.refreshGrid
            },
            'ConvocatoriaPlazaList textfield': {
            	specialkey: this.onKeyEnter
            },
            'ConvocatoriaPlazaList button[action=relanzarConvocatoria]': {
                click: this.relanzarConvocatoria
            },
            'ConvocatoriaPlazaList button[action=MostrarFormConvocatoriaMintra]': {
            	click: this.MostrarFormConvocatoriaMintra
            },
            'ConvocatoriaPlazaEditConvocatoriaMintra button[action=generarReporteMintra]': {
            	click: this.generarReporteMintra
            },
            
            /*
            'ConvocatoriaPlazaList button[action=generarReporteVacantesPublicas]': {
            	click: this.generarReporteVacantesPublicas
            },
            */
            
            'ConvocatoriaPlazaList button[action=MostrarReporteVacantesPlaza]': {
            	click: this.MostrarReporteVacantesPlaza
            },
            
            
            'ConvocatoriaPlazaEditConvocatoriaReporteVacantes button[action=generarReporteVacantesPlaza]': {
            	click: this.generarReporteVacantesPlaza
            },
            
            'ConvocatoriaPlazaList button[action=MostrarFormOficioMintra]': {
            	click: this.MostrarFormOficioMintra
            },
            
            
            'ConvocatoriaPlazaEditConvocatoriaOficioMintra button[action=generarOficionMintra]': {
            	click: this.generarOficionMintra
            }
            
            
            
            
            
        });
    },

    editRecord: function(grid, record) {
        var edit = Ext.create('MyApp.view.ConvocatoriaPlaza.Edit').show();
        var form = edit.down('form');
        if(record.data){
        	edit.down('form').loadRecord(record);
        	edit.setTitle('Editar');
        	
        	var subModel_ConvocatoriaPlazaQuery = Ext.getCmp('subModel_ConvocatoriaPlazaQuery');
        	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
        	
        	var subModel_ConvocatoriaEtapaQuery = Ext.getCmp('subModel_ConvocatoriaEtapaQuery');
        	var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
        	
//        	var subModel_ConvocatoriaPlazaFactorQuery = Ext.getCmp('subModel_ConvocatoriaPlazaFactorQuery');
//        	var srl_id_configuracion_factor_evaluacion = form.getForm().findField('srl_id_configuracion_factor_evaluacion');
      	
			subModel_ConvocatoriaPlazaQuery.store.reload({
				params: {srl_id_convocatoria: srl_id_convocatoria.getValue(), start:0, limit:20},
				scope: this,
				callback: function(records, operation, success) {
					if (success) {
						subModel_ConvocatoriaEtapaQuery.store.reload({
							params: {srl_id_convocatoria: srl_id_convocatoria.getValue(), start:0, limit:20},
							scope: this,
							callback: function(records, operation, success) {
//								if (success) {
//									subModel_ConvocatoriaPlazaFactorQuery.store.reload({params: {srl_id_configuracion_factor_evaluacion: srl_id_configuracion_factor_evaluacion.getValue(), start:0, limit:10}});
//								}
							}
						});

					}
				}
			});

			
        }else{
        	edit.setTitle('Agregar');
        	var subModel_ConvocatoriaPlazaQuery = Ext.getCmp('subModel_ConvocatoriaPlazaQuery');
        	var subModel_ConvocatoriaEtapaQuery = Ext.getCmp('subModel_ConvocatoriaEtapaQuery');
//        	var subModel_ConvocatoriaPlazaFactorQuery = Ext.getCmp('subModel_ConvocatoriaPlazaFactorQuery');
        	
        		subModel_ConvocatoriaPlazaQuery.store.reload({
					params: {srl_id_convocatoria: -1, start:0, limit:20},
					scope: this,
					callback: function(records, operation, success) {
						if (success) {
							subModel_ConvocatoriaEtapaQuery.store.reload({
								params: {srl_id_convocatoria: -1, start:0, limit:20},
								scope: this,
								callback: function(records, operation, success) {
//									if (success) {
//										subModel_ConvocatoriaPlazaFactorQuery.store.reload({params: {srl_id_configuracion_factor_evaluacion: -1, start:0, limit:10}});
//									}
								}
							});

						}
					}
});

        }
    },
    
    updateRecord: function(button) {
    	
        var win = button.up('window');
        var form = win.down('form');
        var record = form.getRecord();
        var values = form.getValues();
        var store = Ext.getStore('ConvocatoriaPlaza.MainStore');
        
        var form = Ext.getCmp('form_filter_ConvocatoriaPlaza');
		var form_filter_ConvocatoriaPlaza = form.getForm().findField('var_num_convocatoria');
        
        if (form.isValid()) {
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
	            
	            if (btn == 'yes') {
	        		if (values.srl_id_convocatoria > 0){
	        			values.tokenField = 'update';
	        			record.set(values);
	        		} else{
	        			record = Ext.create('MyApp.model.ConvocatoriaPlaza.MainModel');
	        			values.tokenField = 'insert';
	        			record.set(values);
	        			store.add(record);
	        		}
	                
                    var sb = Ext.getCmp('form_crud_ConvocatoriaPlaza_statusbar');
	        		sb.showBusy('Grabando...');
	        		win.getEl().mask();
                    
	        		store.sync({
	        	        success: function (batch, eOpts) {
				        	store.load();
				        	
				        	form_filter_ConvocatoriaPlaza.store.reload({params: {srl_id_convocatoria: -1}});
				        	
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
    	
    	var grid = this.getConvocatoriaPlazaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ConvocatoriaPlaza.MainStore');
    	
    	if(record.length > 0){
	        Ext.Msg.confirm('Confirmar','¿Estás seguro de ELIMINAR el registro?',function (btn) {
	                if (btn == 'yes') {
	             	   store.remove(record);
						store.sync({
					        success: function (batch, eOpts) {
					        	store.load();
					        }
					    });
	                }
	        });
    	}

    },
    relanzar: function(button) {
    	
    	var grid = this.getConvocatoriaPlazaList();
    	var record = grid.getSelectionModel().getSelection(); 
    	var store = Ext.getStore('ConvocatoriaPlaza.MainStore');
        
    	if(record.length > 0){
    	        Ext.Msg.confirm('Confirmar','¿Estás seguro de GRABAR el registro?',function (btn) {
    	            
    	            if (btn == 'yes') {
                			        
    					Ext.Ajax.setTimeout(500000);
    					
    			        Ext.Ajax.request({
    			            method: 'GET',
    			            url: 'relanzar-convocatoria.action',
    			            
    			            params: {'srl_id_convocatoria':record[0].data.srl_id_convocatoria},
    			            success: function( result, request ){
    			            	
    			            	var json = Ext.JSON.decode(result.responseText);
    			            	
    			            	if(json.extjsReturn.success == true){
    		                    	store.load();
    				            	win.close();
    			            	}else{		            		
    			            		Ext.MessageBox.show({
    			                        title: 'REMOTE EXCEPTION',
    			                        msg: json.extjsReturn.message,
    			                        icon: Ext.MessageBox.ERROR,
    			                        buttons: Ext.Msg.OK
    			                    });
    			            	}
    			            	
    			            	
    			            },
    	        	        failure: function (batch, eOpts) {
                                sb.setStatus({text:'Error intentado grabar.'});
    				        	win.getEl().unmask();
    	        	        }
    			        });
            
    	            }
    	            
    	        });
            
    	}
        

    },
    
    generarReporteMintra: function(){
    	
       var form = Ext.getCmp('form_convocatoria_mintra');
       var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
       var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
       var idformato = form.getForm().findField('idformato');
        
        if (form.isValid()) {
        	if(idformato.getValue() == 1){
        		
        		window.open('reporte-convocatoria-mintra-doc.action?srl_id_convocatoria=' + srl_id_convocatoria.getValue() 
        				+"&srl_id_conv_area_org=" + srl_id_conv_area_org.getValue()
        				+"&idformato="+idformato.getValue(),'_blank');
        	}else{
        		
        		window.open('reporte-convocatoria-mintra-pdf.action?srl_id_convocatoria=' + srl_id_convocatoria.getValue() 
        				+"&srl_id_conv_area_org=" + srl_id_conv_area_org.getValue()
        				+"&idformato="+idformato.getValue(),'_blank');	
        	}
        	
       	
        }
    },
    
    MostrarFormConvocatoriaMintra: function(button) {
    	Ext.create('MyApp.view.ConvocatoriaPlaza.EditConvocatoriaMintra').show();
    },
    
    generarReporteVacantesPublicas: function(){
    	
    	window.open('reporte-vacantes-publicas.action','_blank');
    	
    },
    
    
    
    MostrarReporteVacantesPlaza: function(button){
    	Ext.create('MyApp.view.ConvocatoriaPlaza.EditConvocatoriaReporteVacantes').show();
    },
    
    
    generarReporteVacantesPlaza: function(){
    	
    	//window.open('reporte-vacantes-plazas.action','_blank');
    	
        var form = Ext.getCmp('form_convocatoria_vacantes');
        var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
        var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
        var idformato = form.getForm().findField('idformato');
         
         if (form.isValid()) {
         	if(idformato.getValue() == 1){
         		
         		window.open('reporte-vacantes-plazas-doc.action?srl_id_convocatoria=' + srl_id_convocatoria.getValue() 
         				+"&srl_id_conv_area_org=" + srl_id_conv_area_org.getValue()
         				+"&idformato="+idformato.getValue(),'_blank');
         	}else{
         		
         		window.open('reporte-vacantes-plazas-pdf.action?srl_id_convocatoria=' + srl_id_convocatoria.getValue() 
         				+"&srl_id_conv_area_org=" + srl_id_conv_area_org.getValue()
         				+"&idformato="+idformato.getValue(),'_blank');	
         	}
         	
        	
         }
    	
    },
    
    
    
    
    MostrarFormOficioMintra: function(button){
    	Ext.create('MyApp.view.ConvocatoriaPlaza.EditConvocatoriaOficioMintra').show();
    },
    
    
    generarOficionMintra: function(){
    	
    	//window.open('reporte-vacantes-plazas.action','_blank');
    	
        var form = Ext.getCmp('form_convocatoria_oficio_mintra');
        var srl_id_convocatoria = form.getForm().findField('srl_id_convocatoria');
        var srl_id_conv_area_org = form.getForm().findField('srl_id_conv_area_org');
        var idformato = form.getForm().findField('idformato');
         
         if (form.isValid()) {
         	if(idformato.getValue() == 1){

         		window.open('oficio-requerimientos-mintra-doc.action?srl_id_convocatoria=' + srl_id_convocatoria.getValue() 
         				+"&srl_id_conv_area_org=" + srl_id_conv_area_org.getValue()
         				+"&idformato="+idformato.getValue(),'_blank');
         	}else{
         		
         		window.open('oficio-requerimientos-mintra-pdf.action?srl_id_convocatoria=' + srl_id_convocatoria.getValue() 
         				+"&srl_id_conv_area_org=" + srl_id_conv_area_org.getValue()
         				+"&idformato="+idformato.getValue(),'_blank');	
         	}
         	
        	
         }
    	
    },   
    
    
    refreshGrid: function() {
    	var store = Ext.getStore('ConvocatoriaPlaza.MainStore');
    	store.load({start:0});
    },
    resetForm: function() {
    	var store = Ext.getStore('ConvocatoriaPlaza.MainStore');
        var form = Ext.getCmp('form_filter_ConvocatoriaPlaza');
        form.reset();
    	store.load({start:0});
    },
    onKeyEnter: function(field, event, options) {
        if (event.getKey() == event.ENTER) {
        	var store = Ext.getStore('ConvocatoriaPlaza.MainStore');
        	store.load({start:0});
        }
    },
    setExtraParams: function(field, event, options) {
    	var store = Ext.getStore('ConvocatoriaPlaza.MainStore');
        var form = Ext.getCmp('form_filter_ConvocatoriaPlaza');
        var values = form.getValues();
    	store.getProxy().extraParams = values;
    }
    
});