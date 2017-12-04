/*
 * Postulante Ganador 
 * Alan Morón - Javier Raffo 08/07/2014
*/

//CONSTANTES
var ESTADO_TRANSACCION_SUCCCESS = 1;
var ESTADO_TRANSACCION_EXCEPTION = 2;
var estado_validacion_ruc = null;
var estado_validacion_dni = null;

$(document).ready(function() {
	
	obtenerValoresTablaTipo(1,'#idtipodocumento');
	obtenerValoresTablaTipo(3,'#idestadocivil');
	obtenerValoresTablaTipo(2,'#idsexo');
	
	obtenerDepartamentosUbigeo('#idDepartamento','#idProvincia','#int_id_ubigeo_direccion');
	obtenerDepartamentosUbigeo('#idDepartamentoNacimiento','#idProvinciaNacimiento','#int_id_ubigeo_nacimiento');
	
	mostrarDescripcionGenero();
	
	obtenerConvocatorias("#srl_id_convocatoria");
	obtenerConvocatorias("#idConvocatoria_reg");
	obtenerConvocatorias("#criteriaResumen_srl_id_convocatoria");
	obtenerAreasOrganicas();
	
	$("#idtipodocumento").prepend($("<option />").val('').text('Seleccione una opción'));
	$("#idestadocivil").prepend($("<option />").val('').text('Seleccione una opción'));
	$('#idsexo').prepend($("<option />").val('').text('Seleccione una opción'));
	
	//SE DESHABILITA LOS CAMPOS LISTAR POR DEFECTO
	$("#numeroDocumentoBuscar").prop('disabled', true); 
	$("#pasaporteBuscar").prop('disabled', true);
	$("#ceBuscar").prop('disabled', true);
	
	//	cambios alanmar 13:59pm
	//OCULTA BOTON VOLVER
	$('#btnVolverListado').hide();
	//	end cambios alanmar 13:59pm
	
//	//CARGA DE LA FECHA DESDE EL ICONO DE CALENDARIO  
//	$('#fechanacimiento_datepicker').datepicker({
//		format: "dd-mm-yyyy",
//		weekStart: 1,
//		   language: "es",
//		   changeMonth: true,
//		   changeYear: true,
//		   autoclose: true
//		   }).on('changeDate', function(e){ 
//
//		         UTC = new Date(e.date);
//		         var options = {year: "numeric", month: "2-digit", day: "2-digit"};
//		   	     fecha = UTC.toLocaleDateString("en-GB",options);
//		   		   	    
//		   	    $('#fechanacimiento').val(fecha);
//
//		});
	
	
	$("#fechanacimiento").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth: true,
		changeYear: true,	
		yearRange: "-110:+0"
	});

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

	 
	validarFormulario();
	//VALIDACIÓN DEL FORMULARIO "REGISTRAR CONVOCATORIA"
		
	$('#formRegistrarConvocatoria').bootstrapValidator({
	    fields: {
	    	idConvocatoria_reg: {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        },
	        idArea_reg: {
	            validators: {
	            	callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	if($("#idConvocatoria_reg").val() === '-1'){
                        		return true;
                        	}
                        	
                        	if(value === ""){
                        		return false;
                        	}else{
                        		return true;
                        	}
                        	
                        	
                        }
                    }
	            }
	        },
	        
	        codigoPostulacion_reg: {
	            validators: {
	            	callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	if($("#idConvocatoria_reg").val() === '-1'){
                        		return true;
                        	}
                        	
                        	if($("#codigoPostulacion_reg").val() === ""){
                        		return false;
                        	}else{
                        		return true;
                        	}
                        	
                        }
                    },
	            stringLength: {
	                	min: 2,
	                	max: 200,
                        message: 'El valor del campo debe tener entre 2 y 200 caracteres de longitud.'
                    },
                regexp: {
	                	regexp: '^[a-zA-Z0-9- .]*$',
                        message: 'El campo sólo permite letras, numeros y guiones.'
                    }
	            }
	        },
	        
	        numeroVacantes_reg: {
	            validators: {
	            	integer: {
                        message: 'El valor no es un número entero.'
                    },
                    digits: {
                        message: 'Solo se permite dígitos.'
                    },
	            	callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	if($("#idConvocatoria_reg").val() === '-1'){
                        		return true;
                        	}
                        	
                        	if($("#numeroVacantes_reg").val() === ""){
                        		return false;
                        	}else{
                        		return true;
                        	}
                        	
                        }
                    }
	        
	            }
	        }
	        //01-06-2015 -- DVR
	        //SE COMENTO PARA PERMITIR REGISTRAR UNA CONVOCATORIA SIN UNIDAD OPERATIVA, PARA LAS AREAS QUE TENGAN UNIDADES.
	        /*,
	        idUnidadOp_reg: {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	            }
	        }*/
	     }
	});
	
	$("#btnRegistrarConvocatoria").click(function(){
		
		$("form#formRegistrarConvocatoria").data('bootstrapValidator').resetForm();
		$("form#formRegistrarConvocatoria").data('bootstrapValidator').validate();
		
		if($("form#formRegistrarConvocatoria").data('bootstrapValidator').isValid()){
			iniciarRegistroConvocatoria();
			$("form#formRegistrarConvocatoria").data('bootstrapValidator').resetForm();
		}
		
	});
	//END VALIDACIÓN DEL FORMULARIO "REGISTRAR CONVOCATORIA"
		
	$("#btnRegistrarPostulante").click(function(){
		
		$("form#frmRegistrarPostulante").data('bootstrapValidator').resetForm();
		$("form#frmRegistrarPostulante").data('bootstrapValidator').validate();
		
		if($("form#frmRegistrarPostulante").data('bootstrapValidator').isValid()){
		
		$('#modalConfirmarGrabar').modal('toggle');
		
		}
	});

	//EVENTO KEYPRESS - DETECTA SI HA PULSADO LA TECLA "ENTER" - REGISTRAR POSTULANTE
	$("#numeroDocumentoBuscar,#rucBuscar").keypress (function (e) {
		if(e.which == 13) {
			iniciarFiltro('json');
	    }
	});
	//END EVENTO KEYPRESS
	
	$("#btnLimpiarForm").click(function(){
		limpiarForm();
	});
	
	//BUSQUEDA BÁSICA - LISTAR POSTULANTE
	$("#idTipoDocumentoBuscar").change(function() {
		 
		 var valor= $("#idTipoDocumentoBuscar").val();
		 
		 if (valor ==='1'){
			  //DNI
			   $("#numeroDocumentoBuscar").prop('disabled', false);
			   $("#ceBuscar").prop('disabled', true);
			   $("#pasaporteBuscar").prop('disabled', true);
			   $("#ceBuscar").val('');
			   $("#pasaporteBuscar").val('');
			   $("#numeroDocumentoBuscar").focus();
			   
			}
		 else if(valor ==='2'){
			   //CE
			   $("#ceBuscar").prop('disabled', false);
			   $("#numeroDocumentoBuscar").prop('disabled', true);
			   $("#pasaporteBuscar").prop('disabled', true);
			   $("#pasaporteBuscar").val('');
			   $("#numeroDocumentoBuscar").val('');
			   $("#ceBuscar").focus();
			}
		 else if(valor ==='3'){
			   //PASAPORTE
			   $("#pasaporteBuscar").prop('disabled', false);
			   $("#numeroDocumentoBuscar").prop('disabled', true);
			   $("#ceBuscar").prop('disabled', true);
			   $("#numeroDocumentoBuscar").val('');
			   $("#ceBuscar").val('');
			   $("#pasaporteBuscar").focus();
			}
		 else{
			   //SIN SELECCIÓN 
			   $("#pasaporteBuscar").prop('disabled', true);
			   $("#numeroDocumentoBuscar").prop('disabled', true);
			   $("#ceBuscar").prop('disabled', true);
			   $("#pasaporteBuscar").val('');
			   $("#numeroDocumentoBuscar").val('');
			   $("#ceBuscar").val('');
			  
		 }
		 
		 
	 });
	
	//BUSQUEDA BÁSICA - REGISTRAR POSTULANTE
	$("#tipoDoc_bus").change(function() {
		 
		 var valor= $("#tipoDoc_bus").val();
		 
		 if (valor ==='1'){
			  //DNI
			   $("#numeroDoc_bus").prop('disabled', false);
			   $("#numero_ruc_bus").prop('disabled', true);	
			   $("#numero_ruc_bus").val('');
			   $("#numeroDoc_bus").focus();
			   
			}
		 else if(valor ==='2'){
			   //RUC
			   $("#numeroDoc_bus").prop('disabled', true);
			   $("#numero_ruc_bus").prop('disabled', false);	
			   $("#numeroDoc_bus").val('');
			   $("#numero_ruc_bus").focus();
			}
		 else{
			   //SIN SELECCIÓN
			   $("#numeroDoc_bus").prop('disabled', true);
			   $("#numero_ruc_bus").prop('disabled', true);
			   $("#numeroDoc_bus").val('');
			   $("#numero_ruc_bus").val('');
		 }
		 
		 
	 });
	
	//INICIALIZA LA BUSQUEDA
	$("#btnBusquedaBasica").click(function(){
		if($("#tipoDoc_bus").val() === '1'){
			buscarPorDni();
		}else if($("#tipoDoc_bus").val() === '2'){
			buscarPorRuc();
		}
	});
	
		//EVENTO KEYPRESS - DETECTA SI HA PULSADO LA TECLA "ENTER"
		$("#numeroDoc_bus,#numero_ruc_bus").keypress (function (e) {
			if(e.which == 13) {
				if($("#tipoDoc_bus").val() === '1'){
					buscarPorDni();
				}else if($("#tipoDoc_bus").val() === '2'){
					buscarPorRuc();
				}
		    }
		});
	//END EVENTO KEYPRESS
	//END BUSQUEDA BÁSICA
	 
	    $("#srl_id_conv_area_org").change(function(){
			obtenerInfoVacantes();	
		});
	 
		
	 	$("#criteriaResumen_srl_id_convocatoria").val($("#criteriaResumen_srl_id_convocatoria option:eq(1)").val());
	 	if($("#criteriaResumen_srl_id_convocatoria").val() !== ''){
	 		obtenerCodigosPostulacion('#criteriaResumen_srl_id_conv_area_org','#criteriaResumen_srl_id_convocatoria');
		 	iniciarFiltro('json');
	 	}
	 	
	 	$("#btnImprimirLista").click(function (){
	 		iniciarFiltro('pdf');
	 	});
	 	
	 	$("#btnImprimirForm").click(function (){
	 		
	 		if($('#idpersona').val() !== ''){
	 			obtenerDetallePostulacion($('#idpersona').val(),"","","","","","","","pdf");
	 		}else{
	 			mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">No hay datos para mostrar.</div>");
	 		}
	 		
	 	});
	 	
	 	$("#criteriaResumen_srl_id_convocatoria").change(function(){
	 		obtenerCodigosPostulacion('#criteriaResumen_srl_id_conv_area_org','#criteriaResumen_srl_id_convocatoria');
	 		iniciarFiltro('json');
		});
	 	
	 	$("#criteriaResumen_srl_id_conv_area_org").change(function(){
	 		iniciarFiltro('json');
		});
	 	
	 	$("#criteriaResumen_int_id_estado").change(function(){
	 		iniciarFiltro('json');
		});
	 	
	 	$("#btnEditarPostulante").click(function (){
	 		seleccionarPostulante($('#idpersona').val(),null,$('#srl_id_postulante_conv_area_org').val(),'json');
	 	});
	 	
	 	$("#int_orden_merito").TouchSpin({
	 	      verticalbuttons: true
	 	});
	 	
	 	$("#int_num_activacion").TouchSpin({
	 	      verticalbuttons: true
	 	});
	 		 	
});	

//cambios alanmar 08/07/2014 13:59
function mostrarFormRegistroPostulante(){
	    
		$('#bloque-convocatoriaListado').removeClass('show').addClass('hide');
        $('#bloque-convocatoriaFormulario').removeClass('hide').addClass('show');
        $('#btnVolverListado').show();
        $('#tituloRegistrar').removeClass('light').addClass('semi-bold');
        $('#tituloEditar').removeClass('semi-bold').addClass('light');
        $('#tituloConsultar').removeClass('semi-bold').addClass('light');
        
        $("#bloque_busqueda_basica").removeClass("hide").addClass("show");
    	$("#bloque_botones_form_reg_postulante").removeClass("hide").addClass("show");
    	$("#bloque_info_vacantes").removeClass("hide").addClass("show");
    	$('#bloque_editar_postulante').removeClass('show').addClass('hide');
    	$('#bloque_btn_agregar_convocatoria').removeClass('hide').addClass('show');
    	$('#bloque_btn_registrar_postulante').removeClass('show').addClass('hide');
    	$('#bloque_btn_impresion_info').removeClass('hide').addClass('show');
    	
        $('#nombre').focus();
		
        limpiarForm();
        $('#idtipodocumento').val('1');
        
	
}

function mostrarListadoPostulante(){
	    
		$('#bloque-convocatoriaFormulario').removeClass('show').addClass('hide');
    	$('#bloque-convocatoriaListado').removeClass('hide').addClass('show');
    	$('#btnVolverListado').hide();
    	$('#tituloRegistrar').removeClass('semi-bold').addClass('light');
        $('#tituloEditar').removeClass('semi-bold').addClass('light');
        $('#tituloConsultar').removeClass('semi-bold').addClass('light');
        $('#bloque_btn_agregar_convocatoria').removeClass('show').addClass('hide');
        $('#bloque_btn_registrar_postulante').removeClass('hide').addClass('show');
        $('#bloque_btn_impresion_info').removeClass('show').addClass('hide');
    	
        iniciarFiltro('json');
}    	
//end cambios alanmar   	

function grabarFormulario(){
	
	$('#modalConfirmarGrabar').modal('toggle');
	
//	$("form#frmRegistrarPostulante").data('bootstrapValidator').resetForm();
//	$("form#frmRegistrarPostulante").data('bootstrapValidator').validate();
//	
//	if($("form#frmRegistrarPostulante").data('bootstrapValidator').isValid()){
					
		parametros = $("form#frmRegistrarPostulante").serialize();
    	
   	 	var json = ajaxSincronizado(ctx+"/grabar-postulante.action", "POST", "json", parametros);
		
   	 	if(json.transaccionUtil.estadoTransaccion === 1){

   	 		if($("#op").val() === "update" && $("#int_id_postulante").val() !== ""){
   	 			mostrarListadoPostulante();
   	 		}else{
   	 			mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
   	 		}
   	 		
   	 		limpiarForm();
   	 		
   	 	}else{

   	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
   	 	}
   	 	
   	 	$("#alert_placeholder").removeClass("hide").addClass("show");
         	 	
   	 	
//	}
}

function mostrarAtajosTeclado(){
	$("p.kbd").removeClass('hide');
}

function buscarPorDni(){
	
	idpersona = "";
	idpersonanatural = "";
	int_id_postulante = "";
	idtipodocumento = "1";
	numerodoc = $("#numeroDoc_bus").val();
	ruc = "";
	
	if(numerodoc === ''){
		return;
	}
	
	obtenerDetallePostulacion(idpersona,idpersonanatural,int_id_postulante,idtipodocumento,numerodoc,ruc,"","",'json');
	
}

function buscarPorRuc(){
	idpersona = "";
	idpersonanatural = "";
	int_id_postulante = "";
	idtipodocumento = "";
	numerodoc = "";
	ruc = $("#numero_ruc_bus").val();
	
	if(ruc===''){
		return;
	}
	
	obtenerDetallePostulacion(idpersona,idpersonanatural,int_id_postulante,idtipodocumento,numerodoc,ruc,"","",'json');
}

function limpiarForm(){
	
	activaDesactivaCampos(false);
	
	var_tipoDoc = $('#tipoDoc_bus').val();
	var_numeroDoc = $('#numeroDoc_bus').val();
	var_numeroRuc = $('#numero_ruc_bus').val();
	
	$('#frmRegistrarPostulante')[0].reset();
	
	$('#tipoDoc_bus').val(var_tipoDoc);
	$('#numeroDoc_bus').val(var_numeroDoc);
	$('#numero_ruc_bus').val(var_numeroRuc);
	
	$('#op').val("insert");
	$('#idpersona').val('');
	$('#idpersonanatural').val('');
	$('#int_id_postulante').val('');
	$('#srl_id_postulante_conv_area_org').val('');
	$('#estado_personal').val('');
	
	
//	$("#int_orden_merito").prop('disabled', true);
	$("#int_orden_merito").val('1');
	$("#int_id_estado").prop('disabled', true);
	$("#int_id_estado").val('2');
	
	$("form#frmRegistrarPostulante").data('bootstrapValidator').resetForm();
	
	$("#bloque_convocatorias").removeClass("hide").addClass("show");
	$("#bloque_tabla_reg_conv").removeClass("show").addClass("hide");
	
}

function alertTimeout(wait){
    setTimeout(function(){
        $('#alert_placeholder').children('.alert:first-child').remove();
    }, wait);
}

function validarFormulario(){
	$('#frmRegistrarPostulante').bootstrapValidator({
	    fields: {
	    	"postulante.nombre": {
	            validators: {
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	return requireCampo(value);
                        	
                        }
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
	        "postulante.apepat": {
	            validators: {
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	return requireCampo(value);
                        	
                        }
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
	        "postulante.apemat": {
	            validators: {
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	return requireCampo(value);
                        	
                        }
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
	        "postulante.idsexo": {
	            validators: {
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                 	
                        	return requireCampo(value);
                        	
                        }
                    }
	            }
	        },
	        "postulante.fechanacimiento": {
	            validators: {
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	return requireCampo(value);
                        	
                        }
                    },
	                date: {
                        format: 'DD/MM/YYYY',
                        message: 'Ingrese el formato de fecha (DD/MM/AAAA).'
                    }
                    
	             }
	        },
	    	"postulante.var_email_principal": {
	            validators: {
	                emailAddress: {
                        message: 'Ingrese un correo electrónico válido.'
                    },
                    callback: {
                        message: 'El correo ingresado ya esta registrado.',
                        callback: function(value, validator) {
                        	
                        	var estado_validacion_email = $("#estado_validacion_email").val();
                        	var val = null;
                        	
                        	if(estado_validacion_email === ""){
                        		return true;
                        	}
                        	
                        	val = parseInt(estado_validacion_email);
                        	
                        	if(val > 0){
                       	 		return false;
                       	 	}else{
                       	 		return true;
                       	 	}
                        	                       	        	
                        }
                    }
	            }
	        },
	    	"postulante.ruc": {
	            validators: {
	                digits: {
                        message: 'Ingrese sólo números.'
                    },
//                    stringLength: {
//                        max: 11,
//                        min: 11,
//                        message: 'El campo debe ser de 11 caracteres de longitud.'
//                    },
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
	        "postulante.idtipodocumento": {
	            validators: {
	            	callback: {
	                    message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	
                        	return requireCampo(value);
                        	
                        }
	                }
	            }
	        },
	    	"postulante.numerodoc": {
	            validators: {
	                stringLength: {
                        max: 45,
                        min: 3,
                        message: 'El campo debe ser mayor de 3 y menos de 45 caracteres de longitud.'
                    },
                    callback: {
                        callback: function(value, validator) {
                        	      
                        	if(estado_validacion_dni === null){
                        		return true;
                        	}
                        	                        	
                        	if(estado_validacion_dni === true){
                       	 		return true;
                       	 	}else{
                       	 		return estado_validacion_dni;
                       	 	}
                                                	
                        }
                    }
	            }
	        },
	    	"postulante.srl_id_conv_area_org": {
	            validators: {
	                notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
                    callback: {
                        message: 'No hay vacantes disponibles.',
                        callback: function(value, validator) {
                        	  
                        	return requireCampo(value);
                        	
                        }
                    }
	            }
	        },
	        "postulante.direccion": {
	            validators: {
	            	stringLength: {
	                	min: 2,
	                	max: 250,
                        message: 'El valor del campo debe tener entre 2 y 250 caracteres de longitud.'
                    },
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	return requireCampo(value);
                        	
                        }
                    }
	                
                 }
	        },
	        "postulante.idubigeo": {
	            validators: {
                    callback: {
                        message: 'No puedes dejar este campo en blanco.',
                        callback: function(value, validator) {
                        	                        	
                        	return requireCampo(value);
                        	
                        }
                    }
                 }
	        },
	        "postulante.var_codigo_ciudad_telefono": {
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
	        "postulante.var_telefono": {
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
	        "postulante.var_celular": {
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
	        numeroVacantes_reg: {
	            validators: {
	            	integer: {
                        message: 'El valor no es un número entero.'
                    },
                    digits: {
                        message: 'Solo se permite dígitos.'
                    },
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                }
	        
	            }
	        },
	        "postulante.int_orden_merito": {
	            validators: {
	            	integer: {
                        message: 'El valor no es un número entero.'
                    },
                    digits: {
                        message: 'Solo se permite dígitos.'
                    },
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
	                callback: {
                        message: 'El número debe ser mayor a cero.',
                        callback: function(value, validator) {
                        	                        	
                        	return (value>0);
                        	
                        }
                    }
	        
	            }
	        },
	        "postulante.int_num_activacion": {
	            validators: {
	            	integer: {
                        message: 'El valor no es un número entero.'
                    },
                    digits: {
                        message: 'Solo se permite dígitos.'
                    },
                    notEmpty: {
	                    message: 'No puedes dejar este campo en blanco.'
	                },
	                callback: {
                        message: 'El número debe ser mayor a cero.',
                        callback: function(value, validator) {
                        	                        	
                        	return (value>0);
                        	
                        }
                    }
	        
	            }
	        },
	        
	        "postulante.var_codigo_ciudad_telefono2": {
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
	        "postulante.var_telefono2": {
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
	        "postulante.var_celular2": {
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
	        
	        "postulante.var_codigo_ciudad_telefono3": {
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
	        "postulante.var_telefono3": {
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
	        "postulante.var_celular3": {
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
	
	
}	

function obtenerDepartamentosUbigeo(idTagDepartamento, idTagProvincia, idTagDistrito){
	
	$(idTagDepartamento).empty();
	$(idTagDepartamento).append($("<option />").val('').text('Seleccione una opción'));
	$(idTagProvincia).empty();
	$(idTagProvincia).append($("<option />").val('').text('Seleccione una opción'));
	$(idTagDistrito).empty();
	$(idTagDistrito).append($("<option />").val('').text('Seleccione una opción'));
	
	parametros = {};
	
	 var json = ajaxSincronizado(ctx+"/obtener-departamentos-ubigeo.action", "POST", "json", parametros);
	 
	$.each(json.listResult, function() {
		$(idTagDepartamento).append($("<option />").val(this.coddpto).text(this.nombre));
	}); 
	
}

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
  
}

function obtenerDistritoUbigeo(idTagDepartamento, idTagProvincia, idTagDistrito){
	
	$(idTagDistrito).empty();
	$(idTagDistrito).append($("<option />").val('').text('Seleccione una opción'));
		
	parametros = {'idDepartamento': $(idTagDepartamento).val(),'idProvincia' : $(idTagProvincia).val()};
	
	var json = ajaxSincronizado(ctx+"/obtener-distritos-ubigeo.action", "POST", "json", parametros);
			
	$.each(json.listResult, function() {
			$(idTagDistrito).append($("<option />").val(this.idubigeo).text(this.nombre));
	});

}

function mostrarDescripcionGenero() {
	
	$("#idsexo option[value='3']").text("Masculino");
	$("#idsexo option[value='4']").text("Femenino");
	    
}

function obtenerConvocatorias(idTag){
	
	$(idTag).empty();
	
	$(idTag).append($("<option />").val('').text('Seleccione una opción'));	
	
	if(idTag === "#idConvocatoria_reg"){
		$(idTag).append($("<option />").val('-1').text('NUEVO'));
	}
	
	parametros = {};
	
	var json = ajaxSincronizado(ctx+"/obtener-convocatorias.action", "POST", "json", parametros);
	
	$.each(json.listResult, function() {
		$(idTag).append($("<option />").val(this.srl_id_convocatoria).text(this.var_num_convocatoria));
	});
   
}

function obtenerCodigosPostulacion(idTag,idTagValor){
	
	$(idTag).empty();
	$(idTag).append($("<option />").val('').text('Seleccione una opción'));	
	
	parametros = {"idConvocatoria":$(idTagValor).val()};
	
	var json = ajaxSincronizado(ctx+"/obtener-codigos-postulacion.action", "POST", "json", parametros);
	
	$.each(json.listResult, function() {
		$(idTag).append($("<option />").val(this.srl_id_conv_area_org).text(this.var_codigo_postulacion));
	});
	
	$("#cantidad_vacantes").val("");
	$("#cantidad_registrados").val("");
	$("#cantidad_disponibles").val("");
   
}

function checkNuevaConvocatoria(){
	
	$('#numeroConvocatoria_reg').prop('readonly', true);
	
	if($("#idConvocatoria_reg").val() === '-1'){
		
		$( "#bloque_num_cnv_generado" ).removeClass( "hide" ).addClass( "show" );
		
		//$("#numeroConvocatoria_reg").show();
		var json = ajaxSincronizado(ctx+"/obtener-numero-convocatoria.action", "POST", "json", null);
		$("#numeroConvocatoria_reg").val(json.result);
		
	}else{
		//$("#numeroConvocatoria_reg").hide();
		$( "#bloque_num_cnv_generado" ).removeClass( "show" ).addClass( "hide" );
	}
		
}


function obtenerAreasOrganicas(){
	
	$("#idArea_reg").append($("<option />").val('').text('Seleccione una opción'));	
		
	parametros = {};
	
	var json = ajaxSincronizado(ctx+"/obtener-areas-organicas.action", "POST", "json", parametros);
	
	$.each(json.listResult, function() {
		$("#idArea_reg").append($("<option />").val(this.idarea).text(this.descrip_dependencia));
	});
   
}

function registrarConvocatoriaPostulacion(){

	parametros = {
					idArea:$("#idArea_reg").val(),
					codigoPostulacion:$("#codigoPostulacion_reg").val(),
					cantidadVacantes: ($("#numeroVacantes_reg").val() === '') ? "0" : $("#numeroVacantes_reg").val(),
					idUnidadOperativa: $("#idUnidadOp_reg").val()
							
				  };
	
	var json = ajaxSincronizado(ctx+"/registrar-convocatoria-postulacion.action", "POST", "json", parametros);
	
	if(json.transaccionUtil.estadoTransaccion === ESTADO_TRANSACCION_SUCCCESS){
		
		$('#modalRegistrarConvocatoria').modal('toggle');
		
		obtenerConvocatorias("#srl_id_convocatoria");
		$("#srl_id_convocatoria").val(json.resultDto.idConvocatoria);
		obtenerCodigosPostulacion('#srl_id_conv_area_org','#srl_id_convocatoria');
		$("#srl_id_conv_area_org").val(json.resultDto.idConvocatoriaAreaOrganica);
		
		obtenerConvocatorias("#idConvocatoria_reg");
		obtenerConvocatorias("#criteriaResumen_srl_id_convocatoria");
		
		mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">Convocatoria Registrada con exito</div>");
		
	}else{
		alert("Error registrando, intentelo mas tarde.");
	}
   
}


function registrarCodigoPostulacion(){

	parametros = {	
					idConvocatoria:$("#idConvocatoria_reg").val(),
					idArea:$("#idArea_reg").val(),
					codigoPostulacion:$("#codigoPostulacion_reg").val(),
					cantidadVacantes: ($("#numeroVacantes_reg").val() === '') ? "0" : $("#numeroVacantes_reg").val(),
					idUnidadOperativa: $("#idUnidadOp_reg").val()
				  };
	
	var json = ajaxSincronizado(ctx+"/registrar-codigo-postulacion.action", "POST", "json", parametros);
	
	if(json.transaccionUtil.estadoTransaccion === ESTADO_TRANSACCION_SUCCCESS){
		
		$('#modalRegistrarConvocatoria').modal('toggle');
		
		obtenerConvocatorias("#srl_id_convocatoria");
		$("#srl_id_convocatoria").val($("#idConvocatoria_reg").val());
		obtenerCodigosPostulacion('#srl_id_conv_area_org','#srl_id_convocatoria');
		$("#srl_id_conv_area_org").val(json.idConvocatoriaAreaOrganica);
		
		mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">Código de Postulación Registrado con exito</div>");
		
	}else{
		alert("Error registrando, intentelo mas tarde.");
	}
   
}

function iniciarRegistroConvocatoria(){
	
	if($("#idConvocatoria_reg").val() === '-1'){
		
//		$('#formRegistrarConvocatoria').bootstrapValidator('enableFieldValidators', 'idArea_reg', false);
//		$('#formRegistrarConvocatoria').bootstrapValidator('enableFieldValidators', 'codigoPostulacion_reg', false);
//		$('#formRegistrarConvocatoria').bootstrapValidator('enableFieldValidators', 'numeroVacantes_reg', false);
//		$('#formRegistrarConvocatoria').bootstrapValidator('enableFieldValidators', 'idUnidadOp_reg', false);
//		
		registrarConvocatoriaPostulacion();
		
	}else{
		registrarCodigoPostulacion();
	}
	
	obtenerInfoVacantes();
	
	//$("form#formRegistrarConvocatoria").data('bootstrapValidator').resetForm();
	
	$("#idConvocatoria_reg").val("");
	$("#idArea_reg").val("");
	$("#codigoPostulacion_reg").val("");
	$("#bloque_num_cnv_generado").removeClass("show").addClass("hide");
	$("#bloque_unidad_operativa").removeClass("show").addClass("hide");
	$("#numeroVacantes_reg").val("");
	
}

function activaDesactivaCampos(estado){
		
	var arr = [ 
	            "nombre", 
	            "apepat", 
	            "apemat", 
	            "idsexo", 
	            "fechanacimiento",
	            "idtipodocumento",
	            "numerodoc",
	            "idDepartamento",
	            "idProvincia",
	            "idubigeo",
	            "ruc",
	            "direccion",
	            "var_codigo_ciudad_telefono",
	            "var_telefono",
	            "var_celular",
	            "var_email_principal",
	            "srl_id_convocatoria",
	            "srl_id_conv_area_org",
	            "int_orden_merito",
	            "int_id_estado",
	            "fechanacimiento_datepicker",
	            
	            "var_codigo_ciudad_telefono2",
	            "var_telefono2",
	            "var_celular2",
	            
	            "var_codigo_ciudad_telefono3",
	            "var_telefono3",
	            "var_celular3",
	            
	          ];
	
	jQuery.each( arr, function( i, val ) {
	  $('#'+val).prop('disabled', estado);
	});
	
}


function activarForm(){
	
	activaDesactivaCampos(false);
	
	$("#bloque_convocatorias").show();
	$("#btnLimpiarForm").show();
	$("#btnRegistrarPostulante").show();
	$("#bloque_busqueda_basica").show();
	$("#btnBuscarAvanzada").show();
	
	
	$("#btnVolver").hide();
	$("#bloque_tabla_reg_conv").removeClass("show").addClass("hide");
	//$("#btnVolver").hide();
	//$("#bloque_tabla_reg_conv").hide();
	limpiarForm();
}


function obtenerConvocatoriasRegistradas(idPersona){
	
	$('#tabla_reg_conv tbody').remove();
	
	parametros = {
			"idPersona": idPersona
		 };
	
	$.getJSON(ctx+"/obtener-convocatorias-registradas.action", parametros, function(json){
		
		$.each(json.listResult, function() {
			$('#tabla_reg_conv').append('<tr><td>'+this.var_num_convocatoria+'</td><td>'+this.var_codigo_postulacion+'</td><td>'+this.int_num_activacion+'</td><td>'+this.desarea+'</td><td>'+((this.nomunidad===null)?'':this.nomunidad)+'</td><td>'+this.int_orden_merito+'</td><td>'+this.estado_descrip+'</td><td>'+this.tsp_fecha_registro+'</td></tr>');
		});
		
	});
}

function obtenerInfoVacantes(){

	if($("#srl_id_conv_area_org").val()===''){
		return;
	}
	
	parametros = {	
					idConvocatoriaAreaOrganica:$("#srl_id_conv_area_org").val(),
					idPostulanteConvocatoriaAreaOrganica:($("#srl_id_postulante_conv_area_org").val()==='') ? null : $("#srl_id_postulante_conv_area_org").val()
				  };
	
	var json = ajaxSincronizado(ctx+"/obtener-info-vacantes.action", "POST", "json", parametros);
	
	$("#cantidad_vacantes").val(json.result.cantidadVacantes);
	$("#cantidad_registrados").val(json.result.cantidadRegistros);
	$("#cantidad_disponibles").val(json.result.cantidadDisponibles);
	$("#int_orden_merito").val(json.result.ordenMerito);

	
}

function obtenerInfoVacantesAlterno(){

	if($("#srl_id_conv_area_org").val()===''){
		return;
	}
	
	parametros = {	
					idConvocatoriaAreaOrganica:$("#srl_id_conv_area_org").val(),
					idPostulanteConvocatoriaAreaOrganica:($("#srl_id_postulante_conv_area_org").val()==='') ? null : $("#srl_id_postulante_conv_area_org").val()
				  };
	
	var json = ajaxSincronizado(ctx+"/obtener-info-vacantes.action", "POST", "json", parametros);
	
	$("#cantidad_vacantes").val(json.result.cantidadVacantes);
	$("#cantidad_registrados").val(json.result.cantidadRegistros);
	$("#cantidad_disponibles").val(json.result.cantidadDisponibles);

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
}

function estadoRuc(value){
		
	var ep = ($("#estado_personal").val() === "") ? "1" : $("#estado_personal").val();
	var estado = false;

	if (ep === "0") {
		estado =  true;
	} else if (ep === "1") {
		estado =  false;
	}
	
	if(value === "" && estado === false){
		estado_validacion_ruc = {
            	valid: false,    // or false
            	message: 'No puedes dejar este campo en blanco.'
        		};
		
		$('#frmRegistrarPostulante').bootstrapValidator('revalidateField', 'postulante.ruc');
        		
	}else if(value === ""){
		
		estado_validacion_ruc = true;
		$('#frmRegistrarPostulante').bootstrapValidator('revalidateField', 'postulante.ruc');
	}else{
			parametros = {
					numeroRuc:$("#ruc").val(),
					idPersona:($("#idpersona").val() === '') ? null : $("#idpersona").val()
				};
	
	 	//var json = ajaxSincronizado(ctx+"/buscar-existencia-numeroruc.action", "POST", "json", parametros);
		var request = ajaxRequest(ctx+"/buscar-existencia-numeroruc.action", "POST", "json", parametros);
	 	
	 	request.done(function( json ) {
	 		if(json.registrado > 0){
		 		
	 			estado_validacion_ruc = {
	            	valid: false,    // or false
	            	message: 'El número de RUC ingresado ya esta registrado.'
	        		};
	 			
		 	}else if(!esrucok(value)){
		 		estado_validacion_ruc = {
	            	valid: false,    // or false
	            	message: 'El número de RUC ingresado no es valido.'
	        		};
		 		
		 	}else{
		 		estado_validacion_ruc = true;
		 		
		 	}
	 		
	 		$('#frmRegistrarPostulante').bootstrapValidator('revalidateField', 'postulante.ruc');
	 	});
	}
	
}

function estadoNumeroDoc(value){
		
	var ep = ($("#estado_personal").val() === "") ? "1" : $("#estado_personal").val();
	var estado = false;

	if (ep === "0") {
		estado =  true;
	} else if (ep === "1") {
		estado =  false;
	}
	
	if(value === "" && estado === false){
		
		
		estado_validacion_dni = {
            	valid: false,    // or false
            	message: 'No puedes dejar este campo en blanco.'
        		};
		
		$('#frmRegistrarPostulante').bootstrapValidator('revalidateField', 'postulante.numerodoc');
		
	}else if(value === ""){
		estado_validacion_dni = true;
		$('#frmRegistrarPostulante').bootstrapValidator('revalidateField', 'postulante.numerodoc');
	}else if($("#idtipodocumento").val()===''){
		estado_validacion_dni = true;
		$('#frmRegistrarPostulante').bootstrapValidator('revalidateField', 'postulante.numerodoc');
	}else{
		parametros = {
				  idTipoDoc: $("#idtipodocumento").val(),
				  numeroDoc:$("#numerodoc").val(),
				  idPersonaNatural:($("#idpersonanatural").val() === '') ? null : $("#idpersonanatural").val()
				  };
	
//	 	var json = ajaxSincronizado(ctx+"/buscar-existencia-tipoNumero-docidentidad", "POST", "json", parametros);
		var request = ajaxRequest(ctx+"/buscar-existencia-tipoNumero-docidentidad", "POST", "json", parametros);
		
		request.done(function( json ) {
	 		if(json.registrado > 0){
		 		
	 			estado_validacion_dni = {
	            	valid: false,    // or false
	            	message: 'El número de Documento ingresado ya esta registrado.'
	        		};
	 					 		
		 	}else{
		 		estado_validacion_dni = true;
		 		
		 	}
	 		$('#frmRegistrarPostulante').bootstrapValidator('revalidateField', 'postulante.numerodoc');
		});
		

	}
		

}

function obtenerUnidadOperativa(){

	if($("#idArea_reg").val()===''){
		return;
	}
	
	$("#idUnidadOp_reg").empty();
	$("#idUnidadOp_reg").append($("<option />").val('').text('Seleccione una opción'));
	
	parametros = {	
					idAreaOrganica:$("#idArea_reg").val()
				  };
	
	var json = ajaxSincronizado(ctx+"/obtener-unidad-operativa.action", "POST", "json", parametros);
	
	if(json.listResult.length > 0){
		$.each(json.listResult, function() {
			$("#idUnidadOp_reg").append($("<option />").val(this.idunidad).text(this.nomunidad));
		});
		$("#bloque_unidad_operativa").removeClass("hide").addClass("show");
	}else{
		$("#bloque_unidad_operativa").removeClass("show").addClass("hide");
	}
	

	
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

function validarCorreo(){
	
	if($("#var_email_principal").val()===''){
		$("#estado_validacion_email").val("");
		return;
	}

	parametros = {
				email:$("#var_email_principal").val(),
				idPostulante:($("#int_id_postulante").val() === '') ? null : $("#int_id_postulante").val()
				};

	var request = ajaxRequest(ctx+"/buscar-existencia-email.action", "POST", "json", parametros);

	request.done(function( json ) {
			
			$("#estado_validacion_email").val(json.registrado);
			$('#frmRegistrarPostulante').bootstrapValidator('revalidateField', 'postulante.var_email_principal');
			
		});
}

function validarRuc(){
	value = $("#ruc").val();
	estadoRuc(value);
}
function validarDni(){
	value = $("#numerodoc").val();
	estadoNumeroDoc(value);
}
