/*
 * Personal Legajo 
 * Alan Morón 09/09/2014
*/

//CONSTANTES
var ESTADO_TRANSACCION_SUCCCESS = 1;
var ESTADO_TRANSACCION_EXCEPTION = 2;

var oTableDefault = null;
var responsiveHelper = undefined;
var breakpointDefinition = {
	tablet : 1024,
	phone : 480
};


$(document).ready(function() {

	instanciarDt();

	$('img').error(function() {
		
		$("#imgFotoPersonal").attr('src', 'assets/img/imagen-no-disponible.png');
	});

	$('#formRegistrarLegajo').bootstrapValidator({
        
        fields: {
        	fileUpload: {
                validators: {
                    file: {
                        extension: 'jpg,jpeg,png,pdf',
                        type: 'image/jpeg,image/png,application/pdf',
                        maxSize: 20480 * 1024,   // 20 MB
                        message: 'El archivo seleccionado no es válido'
                    },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	if($("#op").val() === 'insert'){
                        		if(value === ""){
                        			return false;
                        		}else{
                        			return true;
                        		}
                        		
                        	}else{
                        		return true;
                        	}
                        	
                        }
                    }
                }
            },
	    	"legajo.var_asunto_documento": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
	        "legajo.var_descripcion_documento": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        }
        }
    });
	
	$('#fomSubirFoto').bootstrapValidator({
        
        fields: {
        	fileFoto: {
                validators: {
                    file: {
                        extension: 'jpg,jpeg,png',
                        type: 'image/jpeg,image/png',
                        maxSize: 20480 * 1024,   // 10 MB
                        message: 'El archivo seleccionado no es válido'
                    },
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
                }
            }
        }
    });

	$('#iframe').load(function(){
		terminarRegistro();
    });
	
	$('#iframeFoto').load(function(){
		$('#modalSubirFoto').modal('toggle');
		obtenerFotoPersonal();
		
    });
	
	obtenerFotoPersonal();
	
	$('form#formRegistrarTipoLegajo').bootstrapValidator({
        
        fields: {
        	"nombreTipoLegajo": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
        }
    });
	
	$('#btnRegistrarTipoLegajo').click(function(){
		
		$("form#formRegistrarTipoLegajo").data('bootstrapValidator').resetForm();
		$("form#formRegistrarTipoLegajo").data('bootstrapValidator').validate();
		
		if($("form#formRegistrarTipoLegajo").data('bootstrapValidator').isValid()){
			agregarTipoLegajo();
			$("form#formRegistrarTipoLegajo").data('bootstrapValidator').resetForm();
		}
		
	});
	
	$('#int_id_tipo_documento').change(function(){
		
		var tipo = $('#int_id_tipo_documento option:selected').text();
		
		$('#var_nombre_documento').val(tipo);
		
	});
	
	
	//06-02-2015 DAVID
	
	$('#formRegistrarLegajoContratoAdenda').bootstrapValidator({
        
        fields: {
        	fileUpload: 
        		{
                validators: {
                    file: {
                        extension: 'jpg,jpeg,png,pdf',
                        type: 'image/jpeg,image/png,application/pdf',
                        maxSize: 20480 * 1024,   // 10 MB
                        message: 'El archivo seleccionado no es válido'
                    },
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
                }
            }
        }
    });

	$('#iframeContratoAdenda').load(function(){
		terminarRegistroContratoAdenda();
    });

	
});

function instanciarDt() {

	oTableDefault = null;
	oTableDefault = $('#tableDefault')
			.dataTable(
					{
						autoWidth : false,
						preDrawCallback : function() {

							if (!responsiveHelper) {
								responsiveHelper = new ResponsiveDatatablesHelper(
										oTableDefault, breakpointDefinition);
							}
						},
						rowCallback : function(nRow) {
							responsiveHelper.createExpandIcon(nRow);
						},
						drawCallback : function(oSettings) {
							responsiveHelper.respond();
						},
						"sDom" : "<'row'<'col-md-12' f>> <'row' <'col-md-6'l><'col-md-6'p>>  t <'row'<'col-md-12'p i> >",
						// "sDom": '<l<"pull-left"f> <"pull-right"p>r>t<p>',
						"aaSorting" : [],
						// "bFilter": false,
						"oLanguage" : {
							"sUrl" : "assets/plugins/datatables/lang/spanish.json"
						},
						"aLengthMenu" : [ [ 25, 50, 100, 200, -1 ],
								[ 25, 50, 100, 200, "Todos" ] ],
						"sAjaxDataProp" : "listResult",
						"sAjaxSource" : null,
						"aoColumns" : [ 
						               {"mData" : "nombre","sWidth": "20%"},
						               {"mData" : "asunto","sWidth": "20%"},
						               {"mData" : "descripcion","sWidth": "40%"},
						               {"mData" : "fecha_registro","sWidth": "10%"},
//						               {"mData" : "srl_id_contrato","sWidth": "10%"},
						               {"mData" : "srl_id_persona_natural_legajo","sWidth": "5%"},
						               {"mData" : "srl_id_persona_natural_legajo","sWidth": "5%"},
						               {"mData" : "srl_id_persona_natural_legajo","sWidth": "5%"}

						],
						"aoColumnDefs" : [
								{
									"aTargets" : [ 4 ],
									"mData" : null,
									"mRender" : function(data, type, row) {

										return '<center><button title="Editar" class="btn btn-primary" onclick="editarLegajo('+ data + ',' + row.srl_id_contrato + ');"><i class="fa fa-edit"></i></button></center>';

									}
								},
								{
									"aTargets" : [ 5 ],
									"mData" : null,
									"mRender" : function(data, type, row) {

										return '<center><a title="Descargar" class="btn btn-primary" href="/personal/descargar-legajo?srl_id_persona_natural_legajo=' + data + '"><i class="fa fa-download"></i></a></center>';

									}
								},

								{

									"aTargets" : [ 6 ],
									"mData" : null,
									"mRender" : function(data, type, row) {

										return '<center><button title="Eliminar" class="btn btn-danger" onclick="modalAnularLegajo(' + data + ');"><i class="fa fa-trash-o"></i></button></center>';
									}
								}

						],

						"fnInitComplete" : function(oSettings, json) {
							iniciarFiltro();
						}

					});
	
	
	/* 09-02-2015   DAVID*/ 
	
		oTableContratos = null;
		oTableContratos = $('#tableContratos').dataTable( {
			autoWidth      : false,
		    preDrawCallback: function () {
		        
		        if (!responsiveHelper) {
		            responsiveHelper = new ResponsiveDatatablesHelper(oTableContratos, breakpointDefinition);
		        }
		    },
		    rowCallback    : function (nRow) {
		        responsiveHelper.createExpandIcon(nRow);
		    },
		    drawCallback   : function (oSettings) {
		        responsiveHelper.respond();
		    },
				"sDom": "<'row'<'col-md-12'f>> <'row' <'col-md-6'l><'col-md-6'p>>  t <'row'<'col-md-12'p i> >",
			    "aaSorting": [],
			    "oLanguage": {
				   "sUrl": "assets/plugins/datatables/lang/spanish.json"
	  		     },
	  		   "aLengthMenu": [
	  		                 [25, 50, 100, 200, -1],
	  		                 [25, 50, 100, 200, "Todos"]
	  		             ],
				"sAjaxDataProp": "listResult",
				"sAjaxSource": null,
				"aoColumns" : 
					[  
					 	{"mData" : "var_num_contrato","sWidth":"10%"},
					 	{"mData" : "var_descripcion_regimen_contractual"},
						{"mData" : "dte_fec_suscrip"},
						{"mData" : "dte_fec_inicio"},
						{"mData" : "dte_fec_termino"},
						{"mData" : "dte_fec_cese"},
						{"mData" : "var_nombre_estado"},
						{"mData" : "var_nom_cargo"},
						{"mData" : "flag_digital_contrato","sWidth":"5%"},
						{"mData" : "srl_id_contrato","sWidth":"5%"}
					]
				, "aoColumnDefs": [
												{
												     "aTargets": [8],
												     "mData": null,
												     "mRender": function (data, type, row) {
												  	   
												      	  var b = '';
												          	
												      	  if(data > 0)
												      	  
												      		 b ='<center><button type="button" class="btn btn-primary dropdown-toggle btn-sm-success">'+
												          	    '<i class="fa fa-check"></i>'+
												          	  '</button></center>';
												      	   return b;												  	 
												
												  	}
												 },
						 		                  {
						 		                       "aTargets": [9],
						 		                       "mData": null,
						 		                       "mRender": function (data, type, row) {
						 		                    	  
						 		                    	  var b = '';
						 		                    	
							 		                    	b = '<div class="btn-group">'+
								 		                    	  '<button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown">'+
								 		                    	    'Contrato <span class="caret"></span>'+
								 		                    	  '</button>'+
								 		                    	  '<ul class="dropdown-menu" role="menu">';
						 		         
							 		                    	b = b + '<li><a href="#adendas" 	onclick="obtenerAdendas('+data+');"><i class="fa fa-file-text-o"></i> Adendas</a></li>';
							 		                    	b = b + '<li class="divider"></li>';
							 		                    	
							 		                    	if(row.flag_digital_contrato == 0){
							 		                    		b = b + '<li><a href="#legajopdf" onclick=registrarLegajoContratoAdenda('+	data + ',' + row.flag_digital_contrato +',"C");><i class="fa fa-upload"></i> Subir</a></li>';
							 		                    	}
							 		                    	
							 		                    	if(row.flag_digital_contrato > 0){
							 		                    		
								 		                    	b = b + '<li><a href="/personal/descargar-legajo?srl_id_persona_natural_legajo=' + row.flag_digital_contrato + '"><i class="fa fa-download"></i> Descargar</li>';	 

//								 		                    	b = b + '<li><a href="#legajopdf" onclick="modalAnularLegajo(' + data + ');"href="javascript:void(0);"><i class="fa fa-trash-o"></i> Eliminar</li>';							 		                    		
							 		                    	}
						 		                    	
							 		                    	b = b +  '</ul>'+'</div>';					 		                    	  

							 		                    	return b;
														}
													}

						 		  ],
						 		  
	  		   "fnInitComplete": function(oSettings, json) {
//	  			 obtenerContratos();
	  		    },
	  		  bFilter: false
	
		});
		
		oTableAdenda = null;
		oTableAdenda = $('#tableAdenda').dataTable( {
			autoWidth      : false,
		    preDrawCallback: function () {
		        
		        if (!responsiveHelper) {
		            responsiveHelper = new ResponsiveDatatablesHelper(oTableAdenda, breakpointDefinition);
		        }
		    },
		    rowCallback    : function (nRow) {
		        responsiveHelper.createExpandIcon(nRow);
		    },
		    drawCallback   : function (oSettings) {
		        responsiveHelper.respond();
		    },
				"sDom": "<'row'<'col-md-12'f>> <'row' <'col-md-6'l><'col-md-6'p>>  t <'row'<'col-md-12'p i> >",
				bPaginate: false,
			    "aaSorting": [],
			    "oLanguage": {
				   "sUrl": "assets/plugins/datatables/lang/spanish.json"
	  		     },
	  		   "aLengthMenu": [
	  		                 [25, 50, 100, 200, -1],
	  		                 [25, 50, 100, 200, "Todos"]
	  		             ],
				"sAjaxDataProp": "listResult",
				"sAjaxSource": null,
				"aoColumns" : 
					[ 
					 	{"mData" : "var_num_contrato","sWidth":"10%"},
					 	{"mData" : "var_num_contrato_padre"},
						{"mData" : "dte_fec_suscrip"},
						{"mData" : "dte_fec_inicio"},
						{"mData" : "dte_fec_termino"},
						{"mData" : "dte_fec_cese"},
						{"mData" : "var_nombre_estado"},
						{"mData" : "flag_digital_contrato","sWidth":"5%"},
						{"mData" : "srl_id_contrato","sWidth":"5%"}
						
					],
					 "aoColumnDefs": [
										{
										     "aTargets": [7],
										     "mData": null,
										     "mRender": function (data, type, row) {
										  	   
										      	  var b = '';
										          	
										      	  if(data > 0)
										      	  
										      		 b ='<center><button type="button" class="btn btn-primary dropdown-toggle btn-sm-success">'+
										          	    '<i class="fa fa-check"></i>'+
										          	  '</button></center>';
										      	   return b;												  	 
										
										  	}
										 },
				 		                  {
				 		                       "aTargets": [8],
				 		                       "mData": null,
				 		                       "mRender": function (data, type, row) {
				 		                    	  
				 		                    	  var b = '';
				 		                    	
					 		                    	b = '<div class="btn-group">'+
						 		                    	  '<button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown">'+
						 		                    	    'Adenda <span class="caret"></span>'+
						 		                    	  '</button>'+
						 		                    	  '<ul class="dropdown-menu" role="menu">';
					 		                    	if(row.flag_digital_contrato == 0){
					 		                    	
					 		                    		b = b + '<li><a href="#legajopdf" onclick=registrarLegajoContratoAdenda('+	data + ',' + row.flag_digital_contrato +',"A");><i class="fa fa-upload"></i> Subir</a></li>';
					 		                    	}
					 		                    	
					 		                    	if(row.flag_digital_contrato > 0){
					 		                    		
						 		                    	b = b + '<li><a href="/personal/descargar-legajo?srl_id_persona_natural_legajo=' + row.flag_digital_contrato + '"><i class="fa fa-download"></i> Descargar</li>';	 

//						 		                    	b = b + '<li><a href="#legajopdf" onclick="modalAnularLegajo(' + data + ');"href="javascript:void(0);"><i class="fa fa-trash-o"></i> Eliminar</li>';
					 		                    	}
				 		                    	
					 		                    	b = b +  '</ul>'+'</div>';					 		                    	  

					 		                    	return b;
												}
											}

				 		  ],
						 		  
	  		   "fnInitComplete": function(oSettings, json) {
	  			   //iniciarFiltro();
	  		    },
	  		    bFilter: false, 
//	  		    bInfo: false
	
		});
	
	/* FIN */

}

function iniciarFiltro() {

	parametros = {
		"criteriaOLP.idpersonal" : $('#idPersonal').val()
	};

	$('#loadAjax').modal('toggle');

	json = ajaxSincronizado(ctx + "/buscar-legajo-por-persona.action", "POST",
			"json", parametros);

	oTableDefault.fnClearTable();

	var oSettings = oTableDefault.fnSettings();

	oTableDefault.fnClearTable(this);

	for (var i = 0; i < json.listResult.length; i++) {
		oTableDefault.oApi._fnAddData(oSettings, json.listResult[i]);
	}

	oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();

	oTableDefault.fnDraw();
		
	$('#loadAjax').modal('toggle');
	/*
	//11-02-2015 DAVID
	$('#bloque_tabla_contratos').hide();
//  $('iframe').attr("src",frameSrc);
	$("#bloque_tabla_legajos").show();
	$('#btnverLegajos').html('<i class="fa fa-plus-circle"></i> Registrar Contrato y/o Adenda');	
	$('#btnverLegajos').attr('id',"btnverContratos");
	*/
}

function editarLegajo(idLegajo, idContrato) {

	//11-02-2015 DAVID
	
	if(idContrato > 0 ){
		
		registrarLegajoContratoAdenda(idContrato, idLegajo);
		
	}else{
		
		$('#modalRegistrarLegajo').modal('toggle');

		parametros = {
			"criteriaODLP.srl_id_persona_natural_legajo" : idLegajo
		};

		$.getJSON(ctx + "/obtener-detalle-legajo.action", parametros,
				function(json) {

					$('#op').val("update");
					$('#srl_id_persona_natural_legajo').val(json.record.srl_id_persona_natural_legajo);
//					$('select#int_id_tipo_documento').each(function() { this.selected = (this.val == json.record.int_id_tipo_documento); });
					$('#int_id_tipo_documento').val(json.record.int_id_tipo_documento);
					$('#var_asunto_documento').val(json.record.asunto);
					$('#var_descripcion_documento').val(json.record.descripcion);
					
					// 11-02-2015 DAVID				
					$('#var_nombre_documento').val($('#int_id_tipo_documento option:selected').text());
					
					$('#fileUpload').val("");
					$('#registrarLegajo').prop("disabled",false);
				});
		
		$("form#formRegistrarLegajo").data('bootstrapValidator').resetForm();
		$("form#formRegistrarLegajo").data('bootstrapValidator').validate();
	}
	

	
}

function registrarLegajo() {
	
	// 11-02-2015 DAVID
	$('#bloque_tabla_contratos').hide();
	$('#bloque_tabla_legajos').show();

	$('#formRegistrarLegajo')[0].reset();
	$("form#formRegistrarLegajo").data('bootstrapValidator').resetForm();
	$("form#formRegistrarLegajo").data('bootstrapValidator').validate();

	$('#modalRegistrarLegajo').on('show', function() {
		$("#var_asunto_documento input").first().focus();
	});
	
	$('#op').val("insert");
//	$('#fieldFile').html('<input type="file" name="fileUpload" size="40" value="" tabindex="-1" id="fileUpload" class="filestyle" data-bv-field="fileUpload" style="position: absolute; clip: rect(0px 0px 0px 0px);"><div class="bootstrap-filestyle input-group"><input type="text" class="form-control " disabled=""> <span class="group-span-filestyle input-group-btn" tabindex="0"><label for="fileUpload" class="btn btn-info "><span class="glyphicon undefined"></span> Seleccionar Archivo</label></span></div>');
	$('#fileUpload').val("");
	$('#registrarLegajo').prop("disabled",false);
	$('#modalRegistrarLegajo').modal();

	// 11-02-2015 DAVID
	$('#btnverLegajos').html('<i class="fa fa-plus-circle"></i> Registrar Contrato y/o Adenda');	
	$('#btnverLegajos').attr('id',"btnverContratos");

}

function terminarRegistro(){

	 var txtJson = $(frames['iframe'].document).text();
	 
	 var json = eval('(' + txtJson + ')');
	 
	 if(json.transaccionUtil.estadoTransaccion === ESTADO_TRANSACCION_SUCCCESS){
		 
		 $('#modalRegistrarLegajo').modal('toggle');
		 
		 mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">"+ json.transaccionUtil.mensaje + "</div>");	 
	 }else{
		 mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">"+ json.transaccionUtil.mensaje + "</div>");	
	 }
		 
	 iniciarFiltro();
}

function irRegistroPersonal(id){
	$('#idPersonal').val(id);
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-personal.action');
	$("#form").submit(); 
}

function irListarPersonal(id){
	$('#idPersonal').val(id);
	$('#form').get(0).setAttribute('action', '/personal/gestionar-personal-filtro.action');
	$("#form").submit(); 
}

function modalAnularLegajo(idLegajo){
	
	$('#modalConfirmarEliminar').modal('toggle');
	$('#idLegajo').val(idLegajo);
}

function anularLegajo() {

	parametros = {
		"srl_id_persona_natural_legajo" : $("#idLegajo").val()
	};

	$.getJSON(ctx + "/anular-legajo.action", parametros, function(json) {
		iniciarFiltro();
	});
	
	$('#modalConfirmarEliminar').modal('toggle');
}

function registrarFotoLegajo() {

	$('#fileFoto').val("");
	$('#btnGrabarFoto').prop("disabled",false);
	$('#modalSubirFoto').modal();

}

function obtenerFotoPersonal(){
	parametros = {
			"idPersonaNatural" : $('#idpersonanatural').val()
		};

		$.getJSON(ctx + "/obtener-foto-personal", parametros, function(json) {
			$("#imgFotoPersonal").attr("src","data:"+json.mimeType+";base64,"+json.base64StringFoto);
		});
		
		
}

function agregarTipoLegajo(){
	
	parametros = {
			"nombreTipoLegajo": $('#nombreTipoLegajo').val()
		 };
	
	request = ajaxRequest(ctx+"/agregar-tipo-legajo.action", "POST", "json", parametros);
	
	request.done(function(json){
		$('#modalRegistrarTipoLegajo').modal('toggle');
		listarTipoLegajo(json.record.idtablatipo);
	});
    
	$('#nombreTipoLegajo').val('');
}

function listarTipoLegajo(id){
	
	$("#int_id_tipo_documento").empty();
	$("#int_id_tipo_documento").append($("<option />").val('').text('Seleccione una opción'));
	parametros = {};
	
	request = ajaxRequest(ctx+"/listar-tipo-legajo.action", "POST", "json", parametros);
	
	request.done(function(json){
		$.each(json.listResult, function() {
			$("#int_id_tipo_documento").append($("<option />").val(this.idtablatipo).text(this.destablatipo));
//			$("#int_id_tipo_documento").remove().val(0);
			
		});
		if(id !== null && id !== ""){
			$("#int_id_tipo_documento").val(id);
			 var tipo = $('#int_id_tipo_documento option:selected').text();
			 $('#var_nombre_documento').val(tipo);
			
		}
	});

}



/*06-02-2015 DAVID */


function obtenerContratos(){

	parametros = {
			"criteriaCPP.idpersonanatural": $('#idpersonanatural_legajo_ContratoAdenda').val()
		 };
	
		
		$('#loadAjax').modal('toggle');
	
		json = ajaxSincronizado(ctx+"/buscar-contrato-por-persona.action", "POST", "json", parametros);
		
		oTableContratos.fnClearTable();

		var oSettings = oTableContratos.fnSettings();
		
		
		oTableContratos.fnClearTable(this);

	    for (var i=0; i<json.listResult.length; i++)
	    {
	    	oTableContratos.oApi._fnAddData(oSettings, json.listResult[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableContratos.fnDraw();	
	    
	    $('#loadAjax').modal('toggle');
	    
		$('#bloque_tabla_contratos').show();
		$("#bloque_tabla_legajos").hide();
		$('#bloque_tabla_adendas').hide();		
		$('#btnverContratos').html('<i class="fa fa-folder-open-o"></i> Mostrar Legajo');
		$('#btnverContratos').attr('onclick',"verLegajos()");
		$('#btnverContratos').attr('id',"btnverLegajos");
		$("#flag_contrato_adenda").val('');
		

}

//$('#btnverLegajos').click(function(){	
function verLegajos(){
	iniciarFiltro();
	$('#btnverLegajos').html('<i class="fa fa-plus-circle"></i> Registrar Contrato y/o Adenda');	
	$('#btnverLegajos').attr('onclick',"obtenerContratos()");
	$('#btnverLegajos').attr('id',"btnverContratos");
	$('#bloque_tabla_legajos').show();
	$('#bloque_tabla_contratos').hide();
	$('#bloque_tabla_adendas').hide();
	$("#flag_contrato_adenda").val('');

};


//$('#btnverContratos').click(function(){
	
//	obtenerContratos();

//});

function obtenerAdendas(idContratoPadre){
	
	parametros = {
			"criteriaAPC.srl_id_contrato_padre": idContratoPadre
		 };
	
		$('#loadAjax').modal('toggle');
		
		json = ajaxSincronizado(ctx+"/buscar-adenda-por-contrato.action", "POST", "json", parametros);
		
		oTableAdenda.fnClearTable();

		var oSettings = oTableAdenda.fnSettings();
		
		oTableAdenda.fnClearTable(this);

	    for (var i=0; i<json.listResult.length; i++)
	    {
	    	oTableAdenda.oApi._fnAddData(oSettings, json.listResult[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableAdenda.fnDraw();
	    
	    $('#loadAjax').modal('toggle');
	    $('#bloque_tabla_adendas').show();
	    $("#flag_contrato_adenda").val(idContratoPadre);
}



function registrarLegajoContratoAdenda(idContrato, flag_digital_contrato, flag_contrato_adenda ) {	
	
	$('#formRegistrarLegajoContratoAdenda')[0].reset();
	$("form#formRegistrarLegajoContratoAdenda").data('bootstrapValidator').resetForm();
	$("form#formRegistrarLegajoContratoAdenda").data('bootstrapValidator').validate();
	
	$('#formRegistrarLegajoContratoAdenda').on('show', function() {

	});	

	$('#srl_id_contrato').val(idContrato);
	
	if(flag_digital_contrato > 0){
		$('#opContratoAdenda').val("update");	
		$("#srl_id_persona_natural_legajo_ContratoAdenda").val(flag_digital_contrato);
	}else if(flag_digital_contrato === 0){
		$('#opContratoAdenda').val("insert");
		$("#srl_id_persona_natural_legajo_ContratoAdenda").val("");
	}	
	
	$('#fileUpload_ContratoAdenda').val("");


	$('#registrarLegajoContratoAdenda').prop("disabled",false);
	$('#modalRegistrarLegajoContratoAdenda').modal();
	
	if(flag_contrato_adenda === 'C'){
		$("#flag_contrato_adenda").val(idContrato);		
	}

}


function terminarRegistroContratoAdenda(){
	
	var flag_padre = $("#flag_contrato_adenda").val();

	 var txtJson = $(frames['iframeContratoAdenda'].document).text();
	 
	 var json = eval('(' + txtJson + ')');
	 
	 if(json.transaccionUtil.estadoTransaccion === ESTADO_TRANSACCION_SUCCCESS){
		 
		 $('#modalRegistrarLegajoContratoAdenda').modal('toggle');
		 
		 mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">"+ json.transaccionUtil.mensaje + "</div>");	 
	 }else{
		 mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">"+ json.transaccionUtil.mensaje + "</div>");	
	 }
//	$('#btnverLegajos').html('<i class="fa fa-plus-circle"></i> Registrar Contrato y/o Adenda');
//	$('#btnverLegajos').attr('onclick',"obtenerContratos()");
//	$('#btnverLegajos').attr('id',"btnverContratos");
	 obtenerContratos();	 	
	 if(flag_padre != ''){
		 obtenerAdendas_(flag_padre);
		 $("#flag_contrato_adenda").val(flag_padre);		 
		 $('#bloque_tabla_adendas').show();
	 }
//	 iniciarFiltro();
}

function obtenerAdendas_(idContratoPadre){
	
	parametros = {
			"criteriaAPC.srl_id_contrato_padre": idContratoPadre
		 };	
		
		json = ajaxSincronizado(ctx+"/buscar-adenda-por-contrato.action", "POST", "json", parametros);
		
		oTableAdenda.fnClearTable();

		var oSettings = oTableAdenda.fnSettings();
		
		oTableAdenda.fnClearTable(this);

	    for (var i=0; i<json.listResult.length; i++)
	    {
	    	oTableAdenda.oApi._fnAddData(oSettings, json.listResult[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableAdenda.fnDraw();	    

}
