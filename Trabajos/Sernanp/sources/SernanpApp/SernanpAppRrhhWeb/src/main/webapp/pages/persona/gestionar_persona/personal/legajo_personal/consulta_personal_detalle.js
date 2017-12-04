//CONSTANTES
var ESTADO_TRANSACCION_SUCCCESS = 1;
var ESTADO_TRANSACCION_EXCEPTION = 2;

var estado_validacion_ruc = null;

var oTableDefault = null;
var oTableAdenda = null;
var responsiveHelper = undefined;
var breakpointDefinition = {
    tablet: 1024,
    phone : 480
};

$(document).ready(function() {
	instanciarDt();
	
	
	
//	retornarPaisReset();
	validarFormulario();
	validarFormacionAcademica();
	
	$('img').error(function() {
		$("#imgFotoPersonal").attr('src', 'assets/img/imagen-no-disponible.png');
    });

	//forzando a deshabilitar campos tipoprofesion
//	$( "#srl_id_tipo_profesion" ).prop('disabled', true);
//	$( "#srl_id_profesion" ).prop('disabled', true);
	
	//forzando a deshabilitar campos afp
	$("#var_nombre_afp").prop('disabled', true);
	$("#var_codigo_afiliacion").prop('disabled', true);
	$("#dte_fecha_afiliacion").prop('disabled', true);
	
	
	deshabilitarHabilitarAFP();
	
//    $("#int_idpais").val('171');
	
	$("#btnGrabar").click(function() {
		iniciarGrabacion();
	});
	
	$("#fechanacimiento,#dte_fecha_afiliacion").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth: true,
		changeYear: true,	
		yearRange: "1930:+0",
		defaultDate: new Date(1990, 00, 01)
	});
	
	$("#fecha_ingreso").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth: true,
		changeYear: true,	
		yearRange: "1930:+0",
		onClose: function (selectedDate) {
		$("#fecha_culminacion").datepicker("", "minDate", selectedDate);
		}
	});
	
	$("#fecha_culminacion").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth: true,
		changeYear: true,	
		yearRange: "1930:+0",
		onClose: function (selectedDate) {
		$("#fecha_ingreso").datepicker("option", "maxDate", selectedDate);
		}
	});
	
//	mostrarInformacionPersonal();
	cargarUbigeo();
	cargarUbigeoNacimiento();
	
	//ACTIVAR - DESACTIVAR ELEMENTOS POR RESOLUCION DE PANTALLA
	$(window).setBreakpoints({
	      distinct: true, 
		  breakpoints: [
		       320,
		       480,
		       768,
		       1024]
	}); 
	
	$(window).bind('enterBreakpoint768',function() {
		$('#columna-1').removeClass('col-md-6').addClass('col-md-12');
		$('#columna-2').removeClass('col-md-6').addClass('col-md-12');
	});

	$(window).bind('exitBreakpoint768',function() {
		$('#columna-1').removeClass('col-md-12').addClass('col-md-6');
		$('#columna-2').removeClass('col-md-12').addClass('col-md-6');
	});
	
	$(window).bind('enterBreakpoint1024',function() {
		$('#columna-1').removeClass('col-md-12').addClass('col-md-6');
		$('#columna-2').removeClass('col-md-12').addClass('col-md-6');
	});
	
	$(window).bind('exitBreakpoint1024',function() {

	});
	//END ACTIVAR - DESACTIVAR ELEMENTOS X RESOLUCION DE PANTALLA

	
	
//	$('#srl_id_regimen_contractual option[value="3"]').attr('selected', 'selected');
	
	$("#idDepartamento").change(function() {
		obtenerProvinciaUbigeo('#idDepartamento','#idProvincia','#idubigeo');
	});
	
	$("#idDepartamentoNacimiento").change(function() {
		obtenerProvinciaUbigeo('#idDepartamentoNacimiento','#idProvinciaNacimiento','#int_id_ubigeo_nacimiento');
	});
	
	$('form#formRegistrarEntidadBancaria').bootstrapValidator({
        
        fields: {
        	"nombreEntidadBancaria": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
        }
    });
	
			
	$("#btnRegistrarEntidadBancaria").click(function(){
		
		$("form#formRegistrarEntidadBancaria").data('bootstrapValidator').resetForm();
		$("form#formRegistrarEntidadBancaria").data('bootstrapValidator').validate();
		
		if($("form#formRegistrarEntidadBancaria").data('bootstrapValidator').isValid()){
			agregarEntidadBancaria();
			$("form#formRegistrarEntidadBancaria").data('bootstrapValidator').resetForm();
		}
		
	});
	
	$("#btnAgregarEstudio").click(function(){
		
		$("form#formFormacionAcademica").data('bootstrapValidator').resetForm();
		$("form#formFormacionAcademica").data('bootstrapValidator').validate();
		
		if($("form#formFormacionAcademica").data('bootstrapValidator').isValid()){
			agregarEstudio();
			$("form#formFormacionAcademica").data('bootstrapValidator').resetForm();
		}
		
	});
	
	listarEstudios();
	
	cargarSelec();
	
	obtenerFotoPersonal();
	
});/* fin ready*/

function mostrarInformacionPersonal(){
	
	$("#informacionBasica").removeClass('hide');
	$("#btnMostrarInfoPersonal").addClass('hide');
	$("#btnOcultarInfoPersonal").removeClass('hide');
	
	$("#dos").text("2.");
	$("#tres").text("3.");
	$("#cuatro").text("4.");
	$("#cinco").text("5.");
	$("#seis").text("6.");
	
};

function irListarPersonal(id){
	$('#idPersonal').val(id);
	$('#form').get(0).setAttribute('action', '/personal/gestionar-personal-filtro.action');
	$("#form").submit(); 
}

function ocultarInformacionPersonal(){
	
	$("#btnOcultarInfoPersonal").addClass('hide');
	$("#btnMostrarInfoPersonal").removeClass('hide');
	$("#informacionBasica").addClass('hide');
	$("#dos").text("1.");
	$("#tres").text("2.");
	$("#cuatro").text("3.");
	$("#cinco").text("4.");
	$("#seis").text("5.");
	
};


$('#btnMostrarContrato').click(function(){
 
	$('#modalContrato').modal({show:true});
//    $('iframe').attr("src",frameSrc);
});


function obtenerProvinciaUbigeo(idTagDepartamento, idTagProvincia, idTagDistrito){
	
	$(idTagProvincia).empty();
	$(idTagProvincia).append($("<option />").val('').text('Seleccione una opción'));
	$(idTagDistrito).empty();
	$(idTagDistrito).append($("<option />").val('').text('Seleccione una opción'));
	
	parametros = {'idDepartamento': $(idTagDepartamento).val()};
	
	var json = ajaxSincronizado(ctx+"/obtener-provincias-ubigeo.action", "POST", "json", parametros);
	
	$.each(json.listResult, function() {
		$(idTagProvincia).append($("<option />").val(this.codprov).text(this.nombre));
	});
  
};

function obtenerDistritoUbigeo(idTagDepartamento, idTagProvincia, idTagDistrito){
	
	$(idTagDistrito).empty();
	$(idTagDistrito).append($("<option />").val('').text('Seleccione una opción'));
		
	parametros = {'idDepartamento': $(idTagDepartamento).val(),'idProvincia' : $(idTagProvincia).val()};
	
	var json = ajaxSincronizado(ctx+"/obtener-distritos-ubigeo.action", "POST", "json", parametros);
			
	$.each(json.listResult, function() {
			$(idTagDistrito).append($("<option />").val(this.idubigeo).text(this.nombre));
	});

};

function retornarPaisReset(){
	
	var pais = '171'; 
		
	$('#idpais option[value="' + pais + '"]').attr('selected', 'selected');
	habilitarDeshabilitarUbigeo();
};

function habilitarDeshabilitarUbigeo() {
	 
	var valor = $("#idpais").val();
	
	if (valor ==='171'){

		$( "#idDepartamentoNacimiento" ).prop('disabled', false);
        $( "#idProvinciaNacimiento" ).prop('disabled', false);
		$( "#int_id_ubigeo_nacimiento" ).prop('disabled', false);
		
	}
	else{

	    $( "#int_id_ubigeo_nacimiento" ).prop('selectedIndex',0);
		$( "#idProvinciaNacimiento" ).prop('selectedIndex',0);
		$( "#idDepartamentoNacimiento" ).prop('selectedIndex',0);
		
		$( "#idDepartamentoNacimiento" ).prop('disabled', true);
		$( "#idProvinciaNacimiento" ).prop('disabled', true);
		$( "#int_id_ubigeo_nacimiento" ).prop('disabled', true);
	}
};

function obtenerProfesion(idTagTipoProfesion,idTagProfesion){
		
    	$(idTagProfesion).empty();
  	    $(idTagProfesion).append($("<option />").val('').text('Seleccione una opción'));
			
		parametros = {'idTipoProfesion': $(idTagTipoProfesion).val()};
		
		var json = ajaxSincronizado(ctx+"/obtener-profesion.action", "POST", "json", parametros);
		
		$.each(json.listResult, function() {
			$(idTagProfesion).append($("<option />").val(this.srl_id_profesion).text(this.var_descripcion_profesion));
		});
	  
};     


function deshabilitarAnioCulminacion(){
	
	var valor = $("#srl_id_nivel_estudio").val();
	
		$('#estudiando:checked').val() === '1' ? $('#dte_fecha_culminacion').prop('disabled', true) : $('#dte_fecha_culminacion').prop('disabled', false);
	
};

function habilitarDeshabilitarTipoProfesion() {
	 
	var valor = $("#srl_id_nivel_estudio").val();
	var textoOtros = 'Otros';
	
	
	if (valor ==='1' || valor ==='2' || valor ==='3' || valor ==='4'){
        

		$('#srl_id_tipo_profesion option').filter(function () { return $(this).html() == textoOtros; }).prop('selected', true);
		$('#srl_id_tipo_profesion').change=obtenerProfesion('#srl_id_tipo_profesion','#srl_id_profesion');
		$('#srl_id_profesion option').filter(function () { return $(this).html() == textoOtros; }).prop('selected', true);
		
//		$( "#srl_id_tipo_profesion" ).prop('disabled', true);
//      $( "#srl_id_profesion" ).prop('disabled', true);
//      $( "#dte_fecha_culminacion" ).prop('disabled', true);
        
        $( "#descripcion_lugar_estudios1,#descripcion_lugar_estudios2" ).text('del Centro Educativo');
		
	
	}else if( valor ==='5' || valor ==='6'){
		
		$( "#srl_id_tipo_profesion" ).prop('selectedIndex',0);
		$( "#srl_id_profesion" ).prop('selectedIndex',0);
		
//		$( "#srl_id_tipo_profesion" ).prop('disabled', false);
//      $( "#srl_id_profesion" ).prop('disabled', false);
//      $( "#dte_fecha_culminacion" ).prop('disabled', true);
//        
        $( "#descripcion_lugar_estudios1,#descripcion_lugar_estudios2" ).text('del Instituto');

	}else if( valor ==='7'){
		
		$( "#srl_id_tipo_profesion" ).prop('selectedIndex',0);
		$( "#srl_id_profesion" ).prop('selectedIndex',0);
		
		$( "#srl_id_tipo_profesion" ).prop('disabled', false);
        $( "#srl_id_profesion" ).prop('disabled', false);
        
//        $( "#dte_fecha_culminacion" ).prop('disabled', true);
        
        $( "#descripcion_lugar_estudios1,#descripcion_lugar_estudios2" ).text('de la Universidad');
	}else{

		$( "#srl_id_tipo_profesion" ).prop('selectedIndex',0);
		$( "#srl_id_profesion" ).prop('selectedIndex',0);
		
		$( "#srl_id_tipo_profesion" ).prop('disabled', false);
		$( "#srl_id_profesion" ).prop('disabled', false);
		
//		$( "#dte_fecha_culminacion" ).prop('disabled', false);
		
		$( "#descripcion_lugar_estudios1,#descripcion_lugar_estudios2" ).text('de la Universidad');
	};
};

function deshabilitarHabilitarAFP(){
	
  var valor = $("#srl_id_regimen_pensionario").val();
  
   if(valor === '4'){
	  
	  $('#var_nombre_afp').prop('disabled', false);
	  $('#var_codigo_afiliacion').prop('disabled', false);
	  $('#dte_fecha_afiliacion').prop('disabled', false);
	  
  }else{
	  
	  $('#var_nombre_afp').prop('disabled', true);
	  $('#var_codigo_afiliacion').prop('disabled', true);
	  $('#dte_fecha_afiliacion').prop('disabled', true);
	  
	  $('#var_nombre_afp').val('');
	  $('#var_codigo_afiliacion').val('');
	  $('#dte_fecha_afiliacion').val('');
	  
  }	
}

function requireCampo(value){

	var ep = ($("#estado_personal").val() === "") ? "1" : $("#estado_personal").val();
	
	if (ep === "0") {
		return true;
	} else if (ep === "1") {
		if (value === "") {
			return false;
		} else {
			return true;
		}

	}
};

function cargarUbigeo(){
	
	codprovDir = $("#codprovDir").val(); //hidden
	idubigeoDir = $("#idubigeoDir").val();
	
	obtenerProvinciaUbigeo('#idDepartamento','#idProvincia','#idubigeo');
	$('#idProvincia').val(codprovDir);
	obtenerDistritoUbigeo('#idDepartamento','#idProvincia','#idubigeo');
	$('#idubigeo').val(idubigeoDir);
};

function cargarUbigeoNacimiento(){
	
	codprovNac = $("#codprovNac").val(); //hidden
	idubigeoNac = $("#idubigeoNac").val();
	
	obtenerProvinciaUbigeo('#idDepartamentoNacimiento','#idProvinciaNacimiento','#int_id_ubigeo_nacimiento');
	$('#idProvinciaNacimiento').val(codprovNac);
	obtenerDistritoUbigeo('#idDepartamentoNacimiento','#idProvinciaNacimiento','#int_id_ubigeo_nacimiento');
	$('#int_id_ubigeo_nacimiento').val(idubigeoNac);
};

function validarFormacionAcademica(){
	
	$('#formFormacionAcademica').bootstrapValidator({
       fields: {
        	"srl_id_grupo_ocupacional": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
	        "srl_id_nivel_estudio": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
	        "srl_id_tipo_profesion": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
	        "srl_id_profesion": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
	        
        }
    });
	
	
}

function validarFormulario(){
	$('#formPersonal').bootstrapValidator({
	    fields: {
	    	"personal.nombre": {
	            validators:{
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                       
                    },
	                regexp: {
	                	regexp: '^[a-zA-ZñÑáéíóúÁÉÍÓÚ´ ]*$',
                        message: 'El campo sólo permite letras.'
                    },
	                stringLength: {
	                	min: 2,
	                	max: 50,
                        message: 'El valor del campo debe tener entre 2 y 50 caracteres de longitud.'
                    }
                 }
	        },
	        "personal.apepat": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                    },
	                regexp: {
	                	regexp: '^[a-zA-ZñÑáéíóúÁÉÍÓÚ´ ]*$',
                        message: 'El campo sólo permite letras.'
                    },
	                stringLength: {
	                	min: 2,
	                	max: 50,
                        message: 'El valor del campo debe tener entre 2 y 50 caracteres de longitud.'
                    }
                 }
	        },
	        "personal.apemat": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        
                    },
	                regexp: {
	                	regexp: '^[a-zA-ZñÑáéíóúÁÉÍÓÚ´ ]*$',
                        message: 'El campo sólo permite letras.'
                    },
	                stringLength: { 
	                	min: 2,
	                	max: 50,
                        message: 'El valor del campo debe tener entre 2 y 50 caracteres de longitud.'
                    }
                 }
	        },
	        "personal.idsexo": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        
                    }
	            }
	        },
	        "personal.fechanacimiento": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        
                    },
	                date: {
                        format: 'DD/MM/YYYY',
                        message: 'Ingrese el formato de fecha (DD/MM/AAAA).'
                    }
                    
	             }
	        },
//	    	"personal.var_email_principal": {
//	            validators: {
//	                emailAddress: {
//                        message: 'Ingrese un correo electrónico válido.'
//                    },
//                    callback: {
//                        message: 'El correo ingresado ya esta registrado.',
//                        callback: function(value, validator) {
//                        	
//                        	var estado_validacion_email = $("#estado_validacion_email").val();
//                        	var val = null;
//                        	
//                        	if(estado_validacion_email === ""){
//                        		return true;
//                        	}
//                        	
//                        	val = parseInt(estado_validacion_email);
//                        	
//                        	if(val > 0){
//                       	 		return false;
//                       	 	}else{
//                       	 		return true;
//                       	 	}
//                        	                       	        	
//                        }
//                    }
//	            }
//	        },
	    	"personal.ruc": {
	            validators: {
	                digits: {
                        message: 'Ingrese sólo números.'
                    },
                    callback: {

                        callback: function(value, validator, $field) {
                        	
                        	if(estado_validacion_ruc === null){
                        		return true;
                        	}
                        	                        	
                        	if(estado_validacion_ruc === true){
                       	 		return true;
                       	 	}else{
                       	 		return estado_validacion_ruc;
                       	 	}
                        	
                        }
                    }
	            }
	        },
	        "personal.idtipodocumento": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
	            	callback: {
	                    message: 'No puedes dejar este campo en blanco.',
	            	}
	            }
	        },
	    	"personal.numerodoc": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
	                stringLength: {
                        max: 15,
                        min: 8,
                        message: 'El campo debe ser mayor de 8 y menos de 15 caracteres de longitud.'
                    },

	            }
	        },
	    	"personal.direccion": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
	            	stringLength: {
	                	min: 2,
	                	max: 250,
                        message: 'El valor del campo debe tener entre 2 y 250 caracteres de longitud.'
                    },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',

                    }
	                
                 }
	        },
	        "personal.idubigeo": {
	            validators: {
	            	notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                    }
                 }
	        },
	        "personal.var_codigo_ciudad_telefono": {
	            validators: {
	                stringLength: {
                        max: 2,
                        min: 2,
                        message: 'El campo debe contener sólo 2 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        },
	        "personal.var_telefono": {
	            validators: {
	                stringLength: {
                        max: 7,
                        min: 6,
                        message: 'El campo debe contener 6 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        },
	        "personal.var_celular": {
	            validators: {
	                stringLength: {
                        max: 9,
                        min: 9,
                        message: 'El campo debe contener 9 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        },
	        
	        "personal.var_codigo_ciudad_telefono2": {
	            validators: {
	                stringLength: {
                        max: 2,
                        min: 2,
                        message: 'El campo debe contener sólo 2 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        },
	        "personal.var_telefono2": {
	            validators: {
	                stringLength: {
                        max: 7,
                        min: 6,
                        message: 'El campo debe contener 6 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        },
	        "personal.var_celular2": {
	            validators: {
	                stringLength: {
                        max: 9,
                        min: 9,
                        message: 'El campo debe contener 9 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        },
	        
	        "personal.var_codigo_ciudad_telefono3": {
	            validators: {
	                stringLength: {
                        max: 2,
                        min: 2,
                        message: 'El campo debe contener sólo 2 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        },
	        "personal.var_telefono3": {
	            validators: {
	                stringLength: {
                        max: 7,
                        min: 6,
                        message: 'El campo debe contener 6 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        },
	        "personal.var_celular3": {
	            validators: {
	                stringLength: {
                        max: 9,
                        min: 9,
                        message: 'El campo debe contener 9 caracteres de longitud.'
                    },
                   digits: {
                        message: 'Ingrese sólo números.'
                    }
                }
	        }
	        
	       
	     }
	});
	
};	

function iniciarGrabacion(){
	
	$("form#formPersonal").data('bootstrapValidator').resetForm();
	$("form#formPersonal").data('bootstrapValidator').validate();
	
	if($("form#formPersonal").data('bootstrapValidator').isValid()){
		
		$('#modalConfirmarGrabar').modal('toggle');
		
	}else{
		$('#modalError').modal('toggle');
	}
}

function grabarFormulario(){
	
	$('#modalConfirmarGrabar').modal('toggle');
	
	parametros = $("form#formPersonal").serialize();
	console.log(parametros);
	
		var json = ajaxSincronizado(ctx+"/grabar-personal.action", "POST", "json", parametros);

	 	if(json.transaccionUtil.estadoTransaccion === 1){

	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	 		
	 	}else{
	 	
	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	 	}

}

function registroPersonalLegajo(idPersonal,idPersonaNatural){
	$('#idPersonal').val(idPersonal);
	$('#idPersonaNatural').val(idPersonaNatural);
	$('#form').get(0).setAttribute('action', '/personal/gestionar-personal-legajo-filtro.action');
	$("#form").submit(); 
}

function desvincularPersonal(idPersonal,idPersonaNatural){
	$('#idPersonal').val(idPersonal);
	$('#idPersonaNatural').val(idPersonaNatural);
	$('#form').get(0).setAttribute('action', '/personal/gestionar-desvinculacion-personal.action');
	$("#form").submit(); 
}

function listarEstudios(){
	
	$('#tabla_formacion_academica tbody').remove();
	
	parametros = {
			"idPersonaNatural": $('#idpersonanatural').val()
		 };
	
	$.getJSON(ctx+"/listar-estudios.action", parametros, function(json){
		var index=0;
		$.each(json.listResult, function() {
			
			if(this.flagEliminado !== 1){
				$('#tabla_formacion_academica').append(
						'<tr>'
							+'<td>'+((this.descrip_grupo_ocupacional===null)? '' : this.descrip_grupo_ocupacional )+'</td>'
							+'<td>'+((this.descrip_nivel_estudio===null)? '' : this.descrip_nivel_estudio )+'</td>'
							+'<td>'+((this.descrip_tipo_profesion===null)? '' : this.descrip_tipo_profesion )+'</td>'
							+'<td>'+((this.descrip_profesion===null)? '' : this.descrip_profesion )+'</td>'
							+'<td>'+((this.var_descripcion_institucion===null)? '' : this.var_descripcion_institucion )+'</td>'
							+'<td>'+((this.descrip_pais===null)? '' : this.descrip_pais )+'</td>'
							+'<td>'+((this.dte_fecha_ingreso===null)? '' : this.dte_fecha_ingreso )+'</td>'
							+'<td>'+((this.dte_fecha_culminacion===null)? '' : this.dte_fecha_culminacion) +'</td>'
							+'<td>'+((this.int_sigue_estudios===1) ? 'Si' : 'No')+'</td>'
//							+'<td><button class="btn btn-info btn-sm-info" type="button" onclick="editarEstudio('+index+')" ><i class="fa fa-check"></i></button></td>'
//							+'<td><button class="btn btn-danger btn-sm-danger" type="button" onclick="eliminarEstudio('+index+')" ><i class="fa fa-times"></i></button></td>'
							+'</tr>'
				);
			}
			

			index++;
		});
		
	});
}

function agregarEstudio(){
	
//	$("form#formFormacionAcademica").data('bootstrapValidator').resetForm();
//	$("form#formFormacionAcademica").data('bootstrapValidator').validate();
//	
//	if($("form#formFormacionAcademica").data('bootstrapValidator').isValid()){
	
		parametros = {
				"formacionAcademica.srl_id_grupo_ocupacional": $('#srl_id_grupo_ocupacional').val(),
				"formacionAcademica.descrip_grupo_ocupacional": $('#srl_id_grupo_ocupacional option:selected').text(),
				"formacionAcademica.srl_id_nivel_estudio": $('#srl_id_nivel_estudio').val(),
				"formacionAcademica.descrip_nivel_estudio": $('#srl_id_nivel_estudio option:selected').text(),
				"formacionAcademica.srl_id_tipo_profesion": $('#srl_id_tipo_profesion').val(),
				"formacionAcademica.descrip_tipo_profesion": $('#srl_id_tipo_profesion option:selected').text(),
				"formacionAcademica.srl_id_profesion": $('#srl_id_profesion').val(),
				"formacionAcademica.descrip_profesion": $('#srl_id_profesion option:selected').text(),
				"formacionAcademica.var_descripcion_institucion": $('#var_descripcion_institucion').val(),
				"formacionAcademica.idpais": $('#idpaisUniversidad').val(),
				"formacionAcademica.descrip_pais": $('#idpaisUniversidad option:selected').text(),
				"formacionAcademica.dte_fecha_ingreso": $('#fecha_ingreso').val(),
				"formacionAcademica.dte_fecha_culminacion": $('#fecha_culminacion').val(),
				"formacionAcademica.int_sigue_estudios": $('#int_sigue_estudios').val()
			 }; 
		
		request = ajaxRequest(ctx+"/agregar-estudio.action", "POST", "json", parametros);
		
		request.done(function(){
			listarEstudios();
		});
	
		limpiarFormFormacionAcademica();
//	}//end if isValid

}

function eliminarEstudio(index){

	parametros = {
			"index": index
		 };
	
	request = ajaxRequest(ctx+"/eliminar-estudio.action", "POST", "json", parametros);
	
	request.done(function(){
		listarEstudios();
	});

}

function editarEstudio(index) {

	parametros = {
			"index": index
	};


	$.getJSON(ctx + "/editar-estudios.action", parametros,
			function(json) {

//				$('#op').val("update");
				$('#srl_id_grupo_ocupacional').val(json.record.srl_id_grupo_ocupacional);
				$('#srl_id_nivel_estudio').val(json.record.srl_id_nivel_estudio);
				$('#srl_id_tipo_profesion').val(json.record.srl_id_tipo_profesion);
				$('#srl_id_profesion').val(json.record.srl_id_profesion);
				$('#idpaisUniversidad').val(json.record.idpais);
				$('#var_descripcion_institucion').val(json.record.var_descripcion_institucion);
				$('#fecha_ingreso').val(json.record.dte_fecha_ingreso);
				$('#fecha_culminacion').val(json.record.dte_fecha_culminacion);
				$('#int_sigue_estudios').val(json.record.int_sigue_estudios);

			});
	
//	$("form#formRegistrarLegajo").data('bootstrapValidator').resetForm();
//	$("form#formRegistrarLegajo").data('bootstrapValidator').validate();
	
}
function agregarEntidadBancaria(){
	
	parametros = {
			"nombreEntidadBancaria": $('#nombreEntidadBancaria').val()
		 };
	
	request = ajaxRequest(ctx+"/agregar-entidad-bancaria.action", "POST", "json", parametros);
	
	request.done(function(json){
		$('#modalRegistrarEntidadBancaria').modal('toggle');
		listarEntidadBancaria(json.record.srl_id_entidad_bancaria);
	});
    
	$('#nombreEntidadBancaria').val('');
}

function listarEntidadBancaria(id){
	
	$("#srl_id_entidad_bancaria").empty();
	$("#srl_id_entidad_bancaria").append($("<option />").val('').text('Seleccione una opción'));
	parametros = {};
	
	request = ajaxRequest(ctx+"/listar-entidad-bancaria.action", "POST", "json", parametros);
	
	request.done(function(json){
		$.each(json.listResult, function() {
			$("#srl_id_entidad_bancaria").append($("<option />").val(this.srl_id_entidad_bancaria).text(this.var_desc_entidad_bancaria));
		});
		if(id !== null && id !== ""){
			$("#srl_id_entidad_bancaria").val(id);
		}
	});

}

function cargarSelec(){
	
	hd_idpais = $("#hd_idpais").val();
	hd_idestadocivil = $("#hd_idestadocivil").val();
	hd_srl_id_regimen_pensionario = $("#hd_srl_id_regimen_pensionario").val();
	hd_srl_id_entidad_bancaria = $("#hd_srl_id_entidad_bancaria").val();
	
	$('#idpais').val(hd_idpais);
	$('#idestadocivil').val(hd_idestadocivil);
	$('#srl_id_regimen_pensionario').val(hd_srl_id_regimen_pensionario);
	$('#srl_id_entidad_bancaria').val(hd_srl_id_entidad_bancaria);
	deshabilitarHabilitarAFP();
}

function obtenerFotoPersonal(){
	parametros = {
			"idPersonaNatural" : $('#idpersonanatural').val()
		};

		$.getJSON(ctx + "/obtener-foto-personal", parametros, function(json) {
			$("#imgFotoPersonal").attr("src","data:"+json.mimeType+";base64,"+json.base64StringFoto);
		});
		
		
}

function valruc(valor) {
	 valor = trim(valor);
	if (esnumero(valor)) {
		if (valor.length == 8) {
			suma = 0;
			for (var i = 0; i < valor.length - 1; i++) {

				digito = valor.charAt(i) - '0';

				if (i == 0)
					suma += (digito * 2);
				else
					suma += (digito * (valor.length - i));
			}
			resto = suma % 11;
			if (resto == 1)
				resto = 11;
			if (resto + (valor.charAt(valor.length - 1) - '0') == 11) {
				return true;
			}
		} else if (valor.length == 11) {
			suma = 0;
			x = 6;
			for (var i = 0; i < valor.length - 1; i++) {
				if (i == 4)
					x = 8;
				digito = valor.charAt(i) - '0';
				x--;
				if (i == 0)
					suma += (digito * x);
				else
					suma += (digito * x);
			}
			resto = suma % 11;
			resto = 11 - resto;

			if (resto >= 10)
				resto = resto - 10;
			if (resto == valor.charAt(valor.length - 1) - '0') {
				return true;
			}
		}
	}
	return false;
}


function esnulo(campo) {
	return (campo == null || campo == "");
}
function esnumero(campo) {
	return (!(isNaN(campo)));
}
function eslongrucok(ruc) {
	return (ruc.length == 11);
}
function esrucok(ruc) {
	return (!(esnulo(ruc) || !esnumero(ruc) || !eslongrucok(ruc) || !valruc(ruc)));
}
function trim(cadena) {
	cadena2 = "";
	len = cadena.length;
	for (var i = 0; i <= len; i++)
		if (cadena.charAt(i) != " ") {
			cadena2 += cadena.charAt(i);
		}
	return cadena2;
}

function validarRuc(){
	value = $("#ruc").val();
	estadoRuc(value);
}

function estadoRuc(value){
	
    if(value === ""){
		
	estado_validacion_ruc = true;
	$('#formPersonal').bootstrapValidator('revalidateField', 'personal.ruc');
	}
        		
	if(!esrucok(value)){
		 		estado_validacion_ruc = {
	            	valid: false,    // or false
	            	message: 'El número de RUC ingresado no es valido.'
	        		};
		 		
   	}else{
		 		estado_validacion_ruc = true;
		 		
		 	}
	 		
	 $('#formPersonal').bootstrapValidator('revalidateField', 'personal.ruc');
	 	
}


function instanciarDt(){
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
				 	{"mData" : "var_num_contrato"},
				 	{"mData" : "var_descripcion_regimen_contractual"},
					{"mData" : "dte_fec_suscrip"},
					{"mData" : "dte_fec_inicio"},
					{"mData" : "dte_fec_termino"},
					{"mData" : "dte_fec_cese"},
					{"mData" : "var_nombre_estado"},
					{"mData" : "var_nom_cargo"},
					{"mData" : "srl_id_contrato"}
					
				]
			, "aoColumnDefs": [
					 		                  {
					 		                       "aTargets": [8],
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    	  
					 		                    	  var b = '';
					 		                    	
						 		                    	b = '<div class="btn-group">'+
							 		                    	  '<button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown">'+
							 		                    	    'Contrato <span class="caret"></span>'+
							 		                    	  '</button>'+
							 		                    	  '<ul class="dropdown-menu" role="menu">';
						 		                    	
						 		         
						 		                    	b = b + '<li><a href="#adendas" onclick="obtenerAdendas('+data+');">Adendas</a></li>';
						 		                    	
						 		                    	
						 		                    	b = b +  '</ul>'+'</div>';  
						 		                    	  
					 		                    	  
 
					 		                    	   return b;
					 		                       }
					 		                   }
					 		                   
					 		  ],
					 		  
  		   "fnInitComplete": function(oSettings, json) {
  			   iniciarFiltro();
  		    },
  		  bFilter: false

	});
	
	oTableAdenda = $('#tableAdenda').dataTable( {
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
				 	{"mData" : "var_num_contrato"},
				 	{"mData" : "var_num_contrato_padre"},
					{"mData" : "dte_fec_suscrip"},
					{"mData" : "dte_fec_inicio"},
					{"mData" : "dte_fec_termino"},
					{"mData" : "dte_fec_cese"},
					{"mData" : "var_nombre_estado"}
					
				],
					 		  
  		   "fnInitComplete": function(oSettings, json) {
  			   //iniciarFiltro();
  		    },
  		    bFilter: false, 
  		    bInfo: false

	});
	
}


function iniciarFiltro(){
	
	parametros = {
			"criteriaCPP.idpersonanatural": $('#idpersonanatural').val()
		 };
	
		$('#loadAjax').modal('toggle');
		
		json = ajaxSincronizado(ctx+"/buscar-contrato-por-persona.action", "POST", "json", parametros);
		
		oTableDefault.fnClearTable();

		var oSettings = oTableDefault.fnSettings();
		
		
		oTableDefault.fnClearTable(this);

	    for (var i=0; i<json.listResult.length; i++)
	    {
	    	oTableDefault.oApi._fnAddData(oSettings, json.listResult[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableDefault.fnDraw();
	    
	    $('#loadAjax').modal('toggle');
}

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
}

function limpiarFormFormacionAcademica(){
	
	var arr = [ 
	           
	            "srl_id_grupo_ocupacional",
	            "srl_id_nivel_estudio",
	            "srl_id_tipo_profesion",
	            "srl_id_profesion",
	            "idpaisUniversidad",
	            "int_sigue_estudios",
	            
	          ];
	
	jQuery.each( arr, function( i, val ) {
	   $('#'+val).prop('selectedIndex',0);
	});
	
	$('#var_descripcion_institucion').val('');
	$('#fecha_ingreso').val('');
	$('#fecha_culminacion').val('');
	
}

function generarConstancia(){
	$('#idPersonal').val($('#idpersonal').val());
	$('#form').get(0).setAttribute('action', '/personal/generar-constancia.action');
	$("#form").submit(); 
}