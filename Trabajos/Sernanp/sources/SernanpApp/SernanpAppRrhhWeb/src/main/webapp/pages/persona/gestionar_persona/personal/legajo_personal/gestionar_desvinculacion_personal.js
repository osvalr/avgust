var oTableDefault = null;
var id_estado_personal;
var responsiveHelper = undefined;
var breakpointDefinition = {
    tablet: 1024,
    phone : 480
};

$(document).ready(function() {
	
	$('img').error(function() {
		
		$("#imgFotoPersonal").attr('src', 'assets/img/imagen-no-disponible.png');
	});

	instanciarDt();
	
	$("#dte_fecha_estado").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth: true,
		changeYear: true,	
		yearRange: "1950:+0",
//		defaultDate: new Date(1990, 00, 01)
	});
	
	$("#dte_fec_cese").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth: true,
		changeYear: true,	
		yearRange: "1950:+0",
//		defaultDate: new Date(1990, 00, 01)
	});
	
	$("#registrarDesvinculacion").click(function() {
//		$('#op').val("insert");
		solicitarGrabacion();
		
	});
	
	$('#op').val("insert");
	

	
	$('#formRegistrarDesvinculacion').bootstrapValidator({
        
        fields: {
	    	"desvinculacion.int_id_tipificacion": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
	        "desvinculacion.dte_fec_cese": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
	        "desvinculacion.var_motivo": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        }
        }
    });
	
	obtenerFotoPersonal();
});

function instanciarDt(){

	oTableDefault = null;
	oTableDefault = $('#tableDefault').dataTable( {
			autoWidth      : false,
		    preDrawCallback: function () {
		        
		        if (!responsiveHelper) {
		            responsiveHelper = new ResponsiveDatatablesHelper(oTableDefault, breakpointDefinition);
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
			    "bFilter": false,
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
						{"mData" : "var_descripcion_tipificacion","sWidth": "20%"},
						{"mData" : "var_motivo","sWidth": "45%"},
						{"mData" : "des_estado_desvinculacion","sWidth": "10%"}, 
						{"mData" : "dte_fec_cese","sWidth": "10%"},
						{"mData" : "dte_fecha_estado","sWidth": "10%"},
						{"mData" : "srl_id_estado_personal","sWidth": "5%"},
						
						

						
					]
				, "aoColumnDefs": [
//						 		                  {
//						 		                       "aTargets": [5], 
//						 		                       "mData": null,
//						 		                       "mRender": function (data, type, row) {
//						 		                    	  
//						 		                    	  console.log("srl_id_estado_personal " + row.ultima_desvinculacion);
//						 		                    	  console.log("ultima_desvinculacion " + row.ultima_desvinculacion);
//						 		                    	  console.log("int_id_estado " + row.int_id_estado);
//						 		                    	  console.log(" ");
//						 		                    	  
//						 		                    	   if(row.ultima_desvinculacion === 1 && row.int_id_estado === 1){
//						 		                    		  return '<button title="Eliminar" class="btn btn-danger" onclick="solicitarEliminar('+ data +');">Eliminar</button>';
//						 		                    	   }
//						 		                    	   return "";
//						 		                    	}
//						 		                   },
						 		                  {
						 		                       "aTargets": [5], 
						 		                       "mData": null,
						 		                       "mRender": function (data, type, row) {
						 		                    	  
						 		                    	  console.log("srl_id_estado_personal " + row.ultima_desvinculacion);
						 		                    	  console.log("ultima_desvinculacion " + row.ultima_desvinculacion);
						 		                    	  console.log("int_id_estado " + row.int_id_estado);
						 		                    	  console.log(" ");
						 		                    	  
						 		                    	   if(row.ultima_desvinculacion === 1 && row.int_id_estado === 1){
						 		                    		  return '<button title="Editar" class="btn btn-info btn-sm-info" onclick="editarDesvinculacion('+ data +');">Editar</button>';
						 		                    	   }
						 		                    	   return "";
						 		                    	}
						 		                   }
						 		                  
					 		                ],
					"fnInitComplete": function(oSettings, json) {
	  			   iniciarFiltro();
	  		    }	 		                

		});
	}

function iniciarFiltro() {

	parametros = {
		"criteriaOD.idpersonal" : $('#idpersonal').val() 
	};

	$('#loadAjax').modal('toggle');

	json = ajaxSincronizado(ctx + "/buscar-desvinculacion-por-persona.action", "POST",
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
}

function solicitarGrabacion(){
	
	$("form#formRegistrarDesvinculacion").data('bootstrapValidator').resetForm();
	$("form#formRegistrarDesvinculacion").data('bootstrapValidator').validate();
	
	if($("form#formRegistrarDesvinculacion").data('bootstrapValidator').isValid()){
		$('#modalConfirmarGrabar').modal('toggle');
	}
	
	
}

function irListarPersonal(id){
	$('#idPersonal').val(id);
	$('#form').get(0).setAttribute('action', '/personal/gestionar-personal-filtro.action');
	$("#form").submit(); 
}

function solicitarEliminar(id){
	$('#modalConfirmarEliminar').modal('toggle');
	id_estado_personal = id;
}

function editarDesvinculacion(id){
	  
	   $('#op').val("update");
	   
	   $("#dte_fec_cese").prop('disabled', true);
	   
	   parametros = {
			"criteriaDD.srl_id_estado_personal" : id
		};

		$.getJSON(ctx + "/obtener-detalle-desvinculacion.action", parametros,
				function(json) {
			
			$('#srl_id_estado_personal').val(json.record.srl_id_estado_personal);
			$('#int_id_tipificacion').val(json.record.int_id_tipificacion);
			$('#dte_fec_cese').val(json.record.dte_fec_cese); 
			$('#var_motivo').val(json.record.var_motivo);
			
		});
		

		
}

function grabarFormulario(){
	
	$('#modalConfirmarGrabar').modal('toggle');
	
	parametros = $("form#formRegistrarDesvinculacion").serialize();
	
	console.log(parametros);
	 var json = ajaxSincronizado(ctx+"/grabar-desvinculacion.action", "POST", "json", parametros);

	 	if(json.transaccionUtil.estadoTransaccion === 1){

	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	 		iniciarFiltro();
	 		limpiarForm();
	 		
	 	}else{
	 	
	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	 	};
	 
	 
}

function limpiarForm(){
	$('#int_id_tipificacion').prop('selectedIndex',0);
	$('#dte_fec_cese').val(''); 
	$('#var_motivo').val('');
	$('#op').val('insert');
}

function obtenerFotoPersonal(){
	parametros = {
			"idPersonaNatural" : $('#idpersonanatural').val()
		};

		$.getJSON(ctx + "/obtener-foto-personal", parametros, function(json) {
			$("#imgFotoPersonal").attr("src","data:"+json.mimeType+";base64,"+json.base64StringFoto);
		});
	
}

function eliminar(){
	$('#modalConfirmarEliminar').modal('toggle');
	parametros = {
			"srl_id_estado_personal" : id_estado_personal,
			"idpersonal" : $('#idpersonal').val()
		};

		$.getJSON(ctx + "/eliminar-desvinculacion", parametros, function(json) {
			 iniciarFiltro();
		});
	
}

function irRegistroPersonal(id){
	$('#idPersonal').val(id);
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-personal.action');
	$("#form").submit(); 
}