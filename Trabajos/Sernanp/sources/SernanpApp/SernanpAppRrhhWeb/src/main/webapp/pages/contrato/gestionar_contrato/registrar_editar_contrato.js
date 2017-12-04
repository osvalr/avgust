$(document).ready(function() {	
	
	$("#btnVolver").click(function() {
		window.history.back();
	});
	
	$("#btnGrabar").click(function() {
		iniciarGrabacion();
	});
	
	$("#btnEditarForm").click(function() {
		activarForm();
		$('#op').val("update");
	});
	
	$("#dte_fec_suscrip").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth: true,
		changeYear: true	    
	});
	
	 $( "#dte_fec_inicio" ).datepicker({
		 dateFormat : "dd/mm/yy",
	      changeMonth: true,
	      changeYear: true,
	      numberOfMonths: 1,
	      onClose: function( selectedDate ) {
	        $( "#dte_fec_termino" ).datepicker( "option", "minDate", selectedDate );
	      }
	  });
	 
	  $( "#dte_fec_termino" ).datepicker({
		  dateFormat : "dd/mm/yy",
	      changeMonth: true,
	      changeYear: true,
	      numberOfMonths: 1,
	      onClose: function( selectedDate ) {
	        $( "#dte_fec_inicio" ).datepicker( "option", "maxDate", selectedDate );
	      }
	  });
	  
	  $("#dte_fec_cese").datepicker({
			dateFormat : "dd/mm/yy",
			changeMonth: true,
			changeYear: true	    
		});
	  
	  $("#srl_id_regimen_contractual").change(function() {
		 
		  cargarTipoContrato();
			
			
	  });
	  
	  cargarValidacion();
	  inicializarForm();
	  cargarTipoContrato();
	
});	

function inicializarForm(){
	
	var op = $("#op").val();
	if(op === 'query'){
		desactivarCampos(true);
		$("#bloque_btn_form").hide();
		$("#btnEditarForm").show();
		
	}else if(op === 'update' || op === 'insert'){
		activarForm();
	}
	if(op === 'insert'){
		$('#int_id_estado').prop('disabled', true);
	}
	
	var tipoReg = $("#tipoReg").val();
	
	if(tipoReg === 'adenda'){
		$("#bloque_num_sueldo").hide();
		$("#bloque_srl_id_postulante_conv_area_org").hide();
		$("#bloque_srl_id_cargo").hide();
//		$("#bloque_int_id_estado").hide();
		$("#bloque_campo_periodo_hasta").hide();
		$("#bloque_campo_resolucion_hasta").hide();
		$("#bloque_campo_tipo_contrato").hide();
		$("#bloque_var_lugar_prestacion").hide();
		$('#srl_id_postulante_conv_area_org').val('');
		$("#bloque_campo_tipo_trato").hide();
		
	}else{
		$("#srl_id_contrato_padre").val('');
	}
	
	var estado = $("#int_id_estado").val();
//	var tipo = $("#int_id_tab_tip").val();
	if(estado === "2" /*&& tipo === "1"*/){
		//desactivarCampos(true);
		//$('#dte_fec_cese').prop('disabled', false);
		$("#bloque_campo_fecha_cese").show();
		$("#btnEditarForm").hide();
	}else if(estado === "3"){
		desactivarCampos(true);
		$("#bloque_btn_form").hide();
		$("#btnEditarForm").hide();
	}
	
	$('#num_sueldo').prop('readonly', 'readonly');
	
}

function activarForm(){
	desactivarCampos(false);
	$("#bloque_btn_form").show();
	$("#btnEditarForm").hide();
}

function desactivarCampos(estado){
	
	var arr = [ 
	            "dte_fec_suscrip", 
	            "dte_fec_inicio", 
	            "dte_fec_termino", 
//	            "num_sueldo", 
	            "srl_id_cargo",
	            "srl_id_postulante_conv_area_org",
	            "int_id_estado",
	            "int_id_tipo_trato",
	            "srl_id_regimen_contractual",
	            "var_num_resolucion",
	            "var_lugar_prestacion",
	            "dte_fec_cese"
	          ];
	
	jQuery.each( arr, function( i, val ) {
	  
	  $('#'+val).prop('disabled', estado);
	});
	
}

function cargarValidacion(){
	$('#formContrato').bootstrapValidator({
	    fields: {
	        "contrato.dte_fec_suscrip": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
	                date: {
                        format: 'DD/MM/YYYY',
                        message: 'Ingrese el formato de fecha (DD/MM/AAAA).'
                    }
                    
	             }
	        },
	        "contrato.dte_fec_inicio": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
	                date: {
                        format: 'DD/MM/YYYY',
                        message: 'Ingrese el formato de fecha (DD/MM/AAAA).'
                    }
                    
	             }
	        },
	        "contrato.dte_fec_termino": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
	                date: {
                        format: 'DD/MM/YYYY',
                        message: 'Ingrese el formato de fecha (DD/MM/AAAA).'
                    }
                    
	             }
	        },
	        "contrato.num_sueldo": {
	            validators: {
	            	numeric: {
                        message: 'El valor no es un número.'
                    },

                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	        
	            }
	        },
	        "contrato.srl_id_cargo": {
	            validators: {
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	        
	            }
	        },
//	        "contrato.srl_id_postulante_conv_area_org": {
//	            validators: {
//                    notEmpty: {
//	                    message: 'No puedes dejar este campo en blanco.'
//	                }
//	        
//	            }
//	        },
	        "contrato.int_id_estado": {
	            validators: {
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	        
	            }
	        },
	        "contrato.int_id_tipo_trato": {
	            validators: {
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	        
	            }
	        },
	        "contrato.srl_id_regimen_contractual": {
	            validators: {
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	        
	            }
	        },
	        "contrato.var_num_resolucion": {
	            validators: {
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	        
	            }
	        },
	        "contrato.var_lugar_prestacion": {
	            validators: {
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	        
	            }
	        }
	        ,
	        "contrato.dte_fec_cese": {
	            validators: {
	            	
	                date: {
                        format: 'DD/MM/YYYY',
                        message: 'Ingrese el formato de fecha (DD/MM/AAAA).'
                    }
	        
	            }
	        }
	     }
	});
}

function iniciarGrabacion(){
	
	$("form#formContrato").data('bootstrapValidator').resetForm();
	$("form#formContrato").data('bootstrapValidator').validate();
	
	if($("form#formContrato").data('bootstrapValidator').isValid()){

		//ADD 04-09-2015 DAVID
		$("#confirmacion_grabar").prop('disabled',false);
		$("#desistir_grabar").prop('disabled',false);
		//END
		
		$('#modalConfirmarGrabar').modal('toggle');
		
	}
}

function grabarFormulario(){
		
		//ADD 04-09-2015 DAVID
		$("#confirmacion_grabar").prop('disabled',true);
		$("#desistir_grabar").prop('disabled',true);
		//END
		$('#modalConfirmarGrabar').modal('toggle');

		desactivarCampos(false);
		
		parametros = $("form#formContrato").serialize();

   	 	var json = ajaxSincronizado(ctx+"/grabar-contrato.action", "POST", "json", parametros);
   	 
   	 	if(json.transaccionUtil.estadoTransaccion === 1){

   	 		window.history.back();
   	 		
   	 	}else{
   	 		desactivarCampos(false);
   	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
   	 	}

}
function cargarTipoContrato(){
	if($("#srl_id_regimen_contractual").val() === '1'){
		$('#bloque_campo_periodo_hasta').hide();
		$('#bloque_campo_resolucion_hasta').show();
	}else{
		$('#bloque_campo_periodo_hasta').show();
		$('#bloque_campo_resolucion_hasta').hide();
	}
}