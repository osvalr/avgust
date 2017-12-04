
$(document).ready(function() {
	
//	var d = new Date();
//	var n = d.getMonth();
	
//	$('#int_anio').val(new Date().getFullYear());	
//	$('#int_id_periodo_mes').val(7);
	
	$('#srl_id_regimen_contractual').val(3);
	
	if ($('#int_anio').val() != undefined){
		obtenerRegimenContractual();
		obtenerListaReportes();
		obtenerRegimenPensionario();
//		obtenerNombreCompleto();
		
	}
	

	
	$('#listaMenuReportes').change(function(){
		
		var valorReporte = $('#listaMenuReportes').val();
				
		if(valorReporte == 'emitir-nomina-mensual'){
			
			ocultarCriteriosBusqueda();
			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=pdf]').prop("checked", true);
			$('input[type=radio][value=xls]').prop('disabled',true);
		}
		
		if(valorReporte == 'resumen-nomina-pago-regimen'){
			
			ocultarCriteriosBusqueda();
			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=xls]').prop("checked", true);
			$('input[type=radio][value=pdf]').prop('disabled',true);
		}
		

		if(valorReporte == 'reporte-boleta-pago'){
			
			ocultarCriteriosBusqueda();
			
			$('#nombres').addClass('show');
			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=pdf]').prop("checked", true);
			$('input[type=radio][value=xls]').prop('disabled',true);
			$('input[name=nombre_completo]').val($('#nombre_completo').val());
			
		}
		
		if(valorReporte == 'nomina-descuento-regimen-pensionario'){
			
			ocultarCriteriosBusqueda();
			
			$('#fuente_meta').addClass('show');
			$('#pensionario').addClass('show');
			$('#nombres').addClass('show');
			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('#c_meta').attr('disabled','disabled');
			$('input[type=radio][value=pdf]').prop("checked", true);
		}
		
		if(valorReporte == 'resumen-planilla-pago-onp'){
			
			ocultarCriteriosBusqueda();
			
			$('#nombres').addClass('show');
			$('#fuente_meta').addClass('show');
			$('#pensionario').addClass('show');
			
			$('#srl_id_regimen_pensionario').val(2);
			$('input[name=srl_id_regimen_pensionario]').val($('#srl_id_regimen_pensionario').val());
			$('#srl_id_regimen_pensionario').attr('disabled','disabled');
			
			$('#c_meta').attr('disabled','disabled');
			$('input[type=radio][value=pdf]').prop("checked", true);
		}
		
		if(valorReporte == 'resumen-planilla-pago-afp' || valorReporte == 'planilla-afp-net'){
			
			ocultarCriteriosBusqueda();
			
			$('#nombres').addClass('show');
			$('#fuente_meta').addClass('show');
			$('#pensionario').addClass('show');
			
			$('#c_meta').attr('disabled','disabled');
			
			$('#srl_id_regimen_pensionario').val(4);
			$('input[name=srl_id_regimen_pensionario]').val($('#srl_id_regimen_pensionario').val());
			$('#srl_id_regimen_pensionario').attr('disabled','disabled');
			
			$('input[type=radio][value=pdf]').prop("checked", true);
		}
		
		if(valorReporte == 'certificado-cuarta-categoria'){
			
			ocultarCriteriosBusqueda();
			
			$('#nombres').addClass('show');
			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual').attr('disabled','disabled');
			
			$('input[type=radio][value=pdf]').prop("checked", true);
			$('input[type=radio][value=xls]').prop('disabled',true);
		}
		
		if(valorReporte == 'certificado-quinta-categoria'){
			
			ocultarCriteriosBusqueda();
			
			$('#nombres').addClass('show');
			
			$('#srl_id_regimen_contractual').val(1);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual').attr('disabled','disabled');
			
			$('input[type=radio][value=pdf]').prop("checked", true);
			$('input[type=radio][value=xls]').prop('disabled',true);
		}
		
		if(valorReporte == 'descuento-judicial'){
			
			ocultarCriteriosBusqueda();
			
			$('#nombres').addClass('show');
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=pdf]').prop("checked", true);
		}
		
		if(valorReporte == 'resumen-general-planilla-FF'){ 
			
			ocultarCriteriosBusqueda();
			$('#fuente_meta').addClass('show');
			$('#c_meta').attr('disabled','disabled'); 
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=xls]').prop("checked", true);
			$('input[type=radio][value=pdf]').prop('disabled',true);
			
		}
		
		if(valorReporte == 'resumen-general-planilla-FF-MP'){ 
			
			ocultarCriteriosBusqueda();
			$('#fuente_meta').addClass('show');
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=pdf]').prop("checked", true);
			$('input[type=radio][value=xls]').prop('disabled',true);
			
		}
		
		
		
		if(valorReporte == 'proyeccion-planilla-FF-MP'){ 
			
			ocultarCriteriosBusqueda();
			$('#fuente_meta').addClass('show');
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=xls]').prop("checked", true);
			$('input[type=radio][value=pdf]').prop('disabled',true);
			
		}
		
		if(valorReporte == 'reporte-banco'){ 
			
			ocultarCriteriosBusqueda();
			$('#fuente_meta').addClass('show');
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=pdf]').prop("checked", true);
						
		}
		
		if(valorReporte == 'generar-rem'){ 
			
			ocultarCriteriosBusqueda();
			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=xls]').prop("disabled", true);
			$('input[type=radio][value=pdf]').prop('disabled',true);
						
		}
		
		if(valorReporte == 'generar-jor'){ 
			
			ocultarCriteriosBusqueda();
			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=xls]').prop("disabled", true);
			$('input[type=radio][value=pdf]').prop('disabled',true);
						
		}
		
		if(valorReporte == 'resumen-global'){ 
			
			ocultarCriteriosBusqueda();
			$('#fuente_meta').addClass('show');
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=pdf]').prop("checked", true);
			$('input[type=radio][value=xls]').prop('disabled',true);
						
		}
		
		if(valorReporte == 'nomina-descuento-concepto'){ 
			
			ocultarCriteriosBusqueda();
			obtenerDescuentoConcepto();
			
			$('#concepto_planilla').addClass('show');			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=pdf]').prop("checked", true);
			
		}
		
		if(valorReporte == 'resumen-planilla-fuente-meta'){ 
			
			ocultarCriteriosBusqueda();
			
			$('#srl_id_regimen_contractual').val(3);
//			$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
			$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
			
			$('input[type=radio][value=pdf]').prop("checked", true);
						
		}
		
		
	
	});
	
	$('#srl_id_regimen_pensionario').change(function(){
		
		$('input[name=srl_id_regimen_pensionario]').val($('#srl_id_regimen_pensionario').val());
		
	});
	
	$('#srl_id_regimen_contractual').change(function(){
		
//		$('input[name=srl_id_regimen_contractual]').val($('#srl_id_regimen_contractual').val());
		$('#srl_id_regimen_contractual_reporte').val($('#srl_id_regimen_contractual').val());
		
	});
	
	$('#srl_id_concepto_planilla').change(function(){
		
		$('input[name=srl_id_concepto_planilla]').val($('#srl_id_concepto_planilla').val());
		
	});
	
});

function destruirModal(){
	
	$( '.modal' ).modal( 'hide' ).data( 'bs.modal', null );
};

function ajaxSincronizado(path,tipoPeticion,tipoDatoRetorno){
	
	var dataReturn = null;
	
	$.ajax({
        url: path,
        type: tipoPeticion,
        dataType:tipoDatoRetorno,
        async:false,
        success: function(data) {
        	dataReturn = data;
        },
        error: function(jqXHR, textStatus, error) {
          alert( "error: " + jqXHR.responseText);
        }
	});
	
	return dataReturn;
};

function obtenerListaReportes(){
	
	var json = ajaxSincronizado("/personal/listar-menu-reportes.action", "POST", "json");
	
	$.each(json.listResult, function() {
		$('#listaMenuReportes').append($("<option />").val(this.hrefmodulo).text(this.nombremodulo));
	});
	
};

function obtenerRegimenContractual(){
	
	var json = ajaxSincronizado("/personal/obtener-valores-regimen-contractual.action", "POST", "json");
	
	$.each(json.listResult, function() {
		$('#srl_id_regimen_contractual').append($("<option />").val(this.srl_id_regimen_contractual).text(this.var_descripcion_regimen_contractual));
	});
	
};

function obtenerRegimenPensionario(){
	
	var json = ajaxSincronizado("/personal/obtener-valores-regimen-pensionario.action", "POST", "json");
	
	$.each(json.listResult, function() {
		$('#srl_id_regimen_pensionario').append($("<option />").val(this.srl_id_regimen_pensionario).text(this.var_descripcion_regimen_pensionario));
	});
	
};

function obtenerCargo(){
	
	var json = ajaxSincronizado("/personal/obtener-cargo.action", "POST", "json");
	
	$.each(json.listResult, function() {
		$('#srl_id_cargo').append($("<option />").val(this.srl_id_cargo).text(this.var_nom_cargo));
	});
	
};

function obtenerNombreCompleto(){
	
//	console.log("obtenerNombreCompleto - $('#int_anio').val() --> " + $('#int_anio').val());
	
	if ($('#int_anio').val() != undefined && $('#int_anio').val() != ''){

//		var action = "/personal/obtener-nombres-personal.action?int_anio=" + $('#int_anio').val() + "&int_id_periodo_mes=" + $('#int_id_periodo_mes_reporte').val();

		//LISTARÁ PERSONAL QUE TUVO NOMINA EN EL ANIO
		
		var action = "/personal/obtener-nombres-personal.action?int_anio=" + $('#int_anio').val() + "&int_id_periodo_mes=" ;
//		console.log("action --> " +action);
		var json = ajaxSincronizado(action, "POST", "json");
		
		$.each(json.listResult, function() {			
//			console.log('this.nombre_completo --> ' + this.nombre_completo);
			$('#nombre_completo').append($("<option />").val(this.nombre_completo).text(this.nombre_completo));
		});	
		
		
		var config = {
			      '.chosen-select'           : {},
	 		      '.chosen-select-deselect'  : {allow_single_deselect:true},
	 		      '.chosen-select-no-single' : {disable_search_threshold:10},
	 		      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
	 		      '.chosen-select-width'     : {width:"95%"}
			    }
//			var i = 0;
			    for (var selector in config) {
//			    	i++;
//			    	console.log(i + ".-  selector --> " + selector);
			      $(selector).chosen(config[selector]);
			    }
		
	}

	
};

function obtenerDescuentoConcepto(){
	
	var json = ajaxSincronizado("/personal/obtener-descuento-concepto.action?int_anio=" + $('#int_anio').val() + "&int_id_periodo_mes=" + $('#int_id_periodo_mes_reporte').val(), "POST", "json");
	
	$.each(json.listResult, function() {
		$('#srl_id_concepto_planilla').append($("<option />").val(this.srl_id_concepto_planilla).text(this.var_descrip_concepto));
	});
	
};

function mostrarCriteriosBusqueda(){
	
	if ( $("#nombres").hasClass( 'hide' ) ) $("#nombres").hide().removeClass('hide');
	if ( $("#fuente_meta").hasClass( 'hide' ) ) $("#fuente_meta").hide().removeClass('hide');
	if ( $("#pensionario").hasClass( 'hide' ) ) $("#pensionario").hide().removeClass('hide');
	if ( $("#cargo").hasClass( 'hide' ) ) $("#cargo").hide().removeClass('hide');
	
};

function ocultarCriteriosBusqueda(){
	
	$('#nombres').removeClass('show');
	$('#fuente_meta').removeClass('show');
	$('#pensionario').removeClass('show');
	$('#concepto_planilla').removeClass('show');
	$('#cargo').removeClass('show');
	
	$('#nombres').addClass('hide');
	$('#fuente_meta').addClass('hide');
	$('#concepto_planilla').addClass('hide');
	$('#pensionario').addClass('hide');
	$('#cargo').addClass('hide');
	
	$('#c_meta').val('');
	$('#c_fte_fto').val('');
	$('#srl_id_regimen_pensionario').val('');
	
	$('#c_meta').prop('disabled',false);
	$('#srl_id_regimen_contractual').prop('disabled',false);
	$('#srl_id_regimen_pensionario').prop('disabled',false);
	
	$('input[type=radio][value=xls]').prop('disabled',false);
	$('input[type=radio][value=pdf]').prop('disabled',false);
	
	$('input[type=radio][value=xls]').prop("checked", false);
	$('input[type=radio][value=pdf]').prop("checked", false);
	
	$('#nombre_completo').val('');
	
	
}

function validarCamposVacios(){
	
	if($('#srl_id_regimen_contractual').val() == ''){
		
		alert('debe seleccionar un régimen Contractual');
	}
}

function mostrarReporte() {
	
//	console.log('ANIO -->',$('input[name=int_anio]').val());
//	console.log('MES  -->',$('input[name=int_id_periodo_mes]').val());
	

	$('#int_anio').val($('input[name=int_anio]').val());	
	$('#int_id_periodo_mes_reporte').val($('input[name=int_id_periodo_mes]').val());
	
	if($('#int_anio').val() > 0 && $('#int_id_periodo_mes_reporte').val() > 0){
		
		$('#modalMostrarReporte').modal();
		
		obtenerNombreCompleto();
		
	}
	
		
};

function actionDinamico(){
	
   var url = "";
   var valorReporte = $('#listaMenuReportes').val();
//   var valorRegimen = $('input[name=srl_id_regimen_contractual]').val();
   var valorRegimen = $('#srl_id_regimen_contractual_reporte').val();

//   console.log("valorReporte  --> ",valorReporte);
   
   if(valorReporte != '' && valorReporte != '0'){
	   switch(valorReporte) {
	   
	   case 'resumen-general-planilla-FF-MP':

		   if(valorRegimen == 1){
			   
			   url = '/personal/' + $('#listaMenuReportes').val() + '-' + '728' + '-' + $("input[name='tipo_reporte']:checked").val() + '.action';
			   break;
		   }
		   
		   if(valorRegimen == 3){
			   
			   url = '/personal/' + $('#listaMenuReportes').val() + '-' + 'CAS' + '-' + $("input[name='tipo_reporte']:checked").val() + '.action';
			   break;
		   }
		   
	       break;
		   
	   case 'resumen-global':
 
		   if(valorRegimen == 1){
			   
			   url = '/personal/' + $('#listaMenuReportes').val() + '-' + '728' + '-' + $("input[name='tipo_reporte']:checked").val() + '.action';
			   break;
		   }
		   
		   if(valorRegimen == 3){
			   
			   url = '/personal/' + $('#listaMenuReportes').val() + '-' + 'CAS' + '-' + $("input[name='tipo_reporte']:checked").val() + '.action';
			   break;
		   }
		   
	      break;
	      
	   case 'generar-rem':
		   
		   url = '/personal/' + $('#listaMenuReportes').val() + '.action';
		   break;
		   
	   case 'generar-jor':
		   
		   url = '/personal/' + $('#listaMenuReportes').val() + '.action';
		   break;
		   
	   default:
		   
		   url = '/personal/' + $('#listaMenuReportes').val() + '-' + $("input[name='tipo_reporte']:checked").val() + '.action';
	   	   break;
	}
   	   
   }

	
   
   $('#formGenerarReporte').get(0).setAttribute('action', url);

};

function listarReporte(){
		
//	var regimen = $('#srl_id_regimen_contractual').val()
	var regimen = $('#srl_id_regimen_contractual_reporte').val();
	var reporte = $('#listaMenuReportes').val();
	var c_meta = $.trim($('#c_meta').val());
	
	var url = "";
//	var valorReporte = $('#listaMenuReportes').val();


	
	if( reporte == '0'){
		
		alert('Debe seleccionar un tipo de reporte');
		return false;
		
	}
	if ( regimen === ''){
		
		alert('Debe seleccionar un régimen Contractual');
		return false;
		
	}
	
	if(reporte != '' && regimen != ''){	
//		console.log('reporte --> ' + reporte);
				
					parametros = {
									"int_id_periodo_mes"			: $('#int_id_periodo_mes_reporte').val(),
						    		"int_anio"						: $('#int_anio').val(),
						    		"srl_id_regimen_contractual"	: $('#srl_id_regimen_contractual_reporte').val(),
						    		"srl_id_regimen_pensionario" 	: $('#srl_id_regimen_pensionario').val(),
						    		"srl_id_concepto_planilla" 		: $('#srl_id_concepto_planilla').val(),
						    		"srl_id_cargo" 					: $('#srl_id_cargo').val(),
						    		"nombre_completo" 				: $('#nombre_completo').val(),
						    		"c_fte_fto" 					: $('#c_fte_fto').val(),
						    		"c_meta" 						: c_meta,
						    		"tipo_reporte"					: $("input[name='tipo_reporte']:checked").val(),
						    		"reporte" 						: reporte
						    		
						    		
						            
					};
					
//					$('#loadAjax').modal('toggle');
					$('.loading').show();
					
					$.ajax({
						
					    url		  :		url,
				        data      :     parametros,
				        type	  :		$('#formGenerarReporte').attr('method'),
				        success   : 	function (data, status) {
				        	
//				        	console.log($('#formGenerarReporte').attr('action'));
				        	
						    $.ajax({
						        type		: 'HEAD',
						        data		: parametros,
						        url			: $('#formGenerarReporte').attr('action'),
						        complete	: function () {						        	
						            $('.loading').hide();
						        }
		
						    }); 

				        	
				        },
						error: function (xhr, ajaxOptions, thrownError) {
					        console.log(xhr.status);
					        console.log(thrownError);
					        $('#loadAjax').modal('hide');
				      }
				 	});
					
					return false;					

					
	
	}

	

}

 