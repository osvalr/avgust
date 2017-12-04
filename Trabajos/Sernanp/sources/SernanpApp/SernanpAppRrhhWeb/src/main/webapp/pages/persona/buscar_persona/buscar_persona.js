var oTableDefault = null;
var responsiveHelper = undefined;
var breakpointDefinition = {
    tablet: 1024,
    phone : 480
};

$(document).ready(function() {


$("#criteriaResumen_numerodoc,#criteriaResumen_nombres,#criteriaResumen_numeroRuc").keypress (function (e) {
	if(e.which == 13) {
		iniciarFiltro('json');
    }
});


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
			"sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'p i>>",
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
					{"mData" : "tipoDoc"},
					{"mData" : "numerodoc"},
					{"mData" : "nombre_completo"}, 
					{"mData" : "ruc"},
					{"mData" : "genero"},
					{"mData" : "var_num_convocatoria"},
					{"mData" : "var_codigo_postulacion"},
					{"mData" : "int_num_activacion"},
					{"mData" : "estado_descrip"},
					{"mData" : "desarea"},
					{"mData" : "nomunidad"},
					{"mData" : "tsp_fecha_registro"},
					{"mData" : "idpersona"},
					{"mData" : "idpersona"}
					
				]
			, "aoColumnDefs": [
					 		                  {
					 		                       "aTargets": [12],
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    	   
					 		                    	   var estado = row.int_id_estado;
					 		                    	   var postulacion = row.srl_id_postulante_conv_area_org;
					 		                    	   
					 		                    	   if(estado === 1 || estado === 2 || estado === null){
					 		                    		  return '<button title="Seleccionar" class="btn btn-primary" onclick="seleccionarPostulante('+ data +','+ estado +','+ postulacion +',\'json\');"><i class="fa fa-check"></i></button>';
					 		                    	   }else{
					 		                    		  return '<button title="Seleccionar" class="btn btn-white"><i class="fa fa-ban"></i></button>';
					 		                    	   }
					 		                    	   
					 		                           
					 		                    	}
					 		                   },
					 		                  {
					 		                       "aTargets": [13],
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    	   
					 		                    	  var estado = row.int_id_estado;
					 		                    	  var postulacion = row.srl_id_postulante_conv_area_org;
					 		                    	  
					 		                    	   if(estado === 1 || estado === 2 || estado === null){
					 		                    		  return '<button title="Consultar" class="btn btn-primary" onclick="consultarPostulante('+ data +','+ estado +','+ postulacion +',\'json\');"><i class="fa fa-eye"></i></button>';
					 		                    	   }else{
					 		                    		  return '<button title="Consultar" class="btn btn-white"><i class="fa fa-ban"></i></button>';
					 		                    	   }
					 		                    	   
					 		                           
					 		                       }
					 		                   }
					 		                ]

	});
	
});	



function buscarPostulante(){
	
	$('#modalBuscarPostulantes').modal('toggle');

}

function iniciarFiltro(tipoResultado){
	
	criteriaResumen_srl_id_convocatoria = $.trim($('#criteriaResumen_srl_id_convocatoria').val());
	criteriaResumen_srl_id_conv_area_org = $.trim($('#criteriaResumen_srl_id_conv_area_org').val());
	criteriaResumen_nombres = $.trim($('#criteriaResumen_nombres').val());
	criteriaResumen_numeroRuc = $.trim($('#criteriaResumen_numeroRuc').val());
	criteriaResumen_tipoDoc =  $.trim($('#criteriaResumen_tipoDoc').val());
	criteriaResumen_numerodoc = $.trim($('#criteriaResumen_numerodoc').val());
	criteriaResumen_int_id_estado = $.trim($('#criteriaResumen_int_id_estado').val());
	
	if(criteriaResumen_numerodoc === '' &&  criteriaResumen_numeroRuc === '' && criteriaResumen_nombres === '' && criteriaResumen_srl_id_convocatoria === '' && criteriaResumen_srl_id_conv_area_org === '' && criteriaResumen_int_id_estado === '1,2,0'){
		
		if(oTableDefault !== null){
			oTableDefault.fnClearTable();
		}
		
		//mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">No se han ingresado los criterios de búsqueda.</div>");
		
		return;
	}
	
	

	parametros = {
			"criteriaResumen.tipoDoc": criteriaResumen_tipoDoc,
			"criteriaResumen.numerodoc": criteriaResumen_numerodoc,
			"criteriaResumen.numeroRuc": criteriaResumen_numeroRuc,
			"criteriaResumen.nombres": criteriaResumen_nombres,
			"criteriaResumen.srl_id_convocatoria": criteriaResumen_srl_id_convocatoria,
			"criteriaResumen.srl_id_conv_area_org": criteriaResumen_srl_id_conv_area_org,
			"criteriaResumen.int_id_estado": criteriaResumen_int_id_estado,
			"tipoResultado": tipoResultado
		 };
	
	if(tipoResultado === 'json'){
		
		$('#loadAjax').modal('toggle');
		
		$.getJSON(ctx+"/listar-resumen-postulaciones.action", parametros, function(json){
			
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
		});
	}else if(tipoResultado === 'pdf'){
		var params = serialize(parametros);
		window.open(ctx+"/listar-resumen-postulaciones.action?"+params, '_blank');
	}
	

}

function seleccionarPostulante(idpersona,id_estado,id_postulacion,tipoResultado){
	obtenerDetallePostulacion(idpersona,"","","","","",id_estado,id_postulacion,tipoResultado);
	mostrarFormRegistroPostulante();
//	$("#int_orden_merito").prop('disabled', false);
	$("#int_id_estado").prop('disabled', false);
	activaDesactivaCampos(false);
	$("#bloque_tabla_reg_conv").removeClass("show").addClass("hide");
	$("#bloque_busqueda_basica").removeClass("hide").addClass("show");
	$("#bloque_botones_form_reg_postulante").removeClass("hide").addClass("show");
	$("#bloque_info_vacantes").removeClass("hide").addClass("show");
	
	
	//cambio alanmar 08/07/2014 14:25
	$('#tituloRegistrar').removeClass('semi-bold').addClass('light');
	$('#tituloEditar').removeClass('light').addClass('semi-bold');
    $('#tituloConsultar').removeClass('semi-bold').addClass('light');
    
    $('#bloque_editar_postulante').removeClass('show').addClass('hide');
    
    //end cambio
}

function consultarPostulante(idpersona,id_estado,id_postulacion,tipoResultado){
	
	obtenerDetallePostulacion(idpersona,"","","","","",id_estado,id_postulacion,tipoResultado);
	mostrarFormRegistroPostulante();
	activaDesactivaCampos(true);
	
	$("#bloque_tabla_reg_conv").removeClass("hide").addClass("show");
	$("#bloque_convocatorias").removeClass("show").addClass("hide");
	$("#bloque_busqueda_basica").removeClass("show").addClass("hide");
	$("#bloque_botones_form_reg_postulante").removeClass("show").addClass("hide");
	$("#bloque_info_vacantes").removeClass("show").addClass("hide");
	
	//cambio alanmar 08/07/2014 14:25
	$('#tituloRegistrar').removeClass('semi-bold').addClass('light');
	$('#tituloEditar').removeClass('semi-bold').addClass('light');
    $('#tituloConsultar').removeClass('light').addClass('semi-bold');
    
    $('#bloque_editar_postulante').removeClass('hide').addClass('show');
    
	//end cambio
    
	obtenerConvocatoriasRegistradas(idpersona);
}

function obtenerDetallePostulacion(idpersona,idpersonanatural,int_id_postulante,idtipodocumento,numerodoc,ruc,int_id_estado,srl_id_postulante_conv_area_org,tipoResultado){
	
	parametros = {
			"criteriaDetalle.idpersona": idpersona,
			"criteriaDetalle.idpersonanatural": idpersonanatural,
			"criteriaDetalle.int_id_postulante": int_id_postulante,
			"criteriaDetalle.idtipodocumento": idtipodocumento,
			"criteriaDetalle.numerodoc": numerodoc,
			"criteriaDetalle.ruc": ruc,
			"criteriaDetalle.int_id_estado":int_id_estado,
			"criteriaDetalle.srl_id_postulante_conv_area_org": srl_id_postulante_conv_area_org,
			"tipoResultado": tipoResultado
		 };
	
	if(tipoResultado ==='json'){
		$('#loadAjax').modal('toggle');
		limpiarForm();
		
		//var json = ajaxSincronizado(ctx+"/obtener-detalle-postulacion.action", "POST", "json", parametros);
		
		$.getJSON(ctx+"/obtener-detalle-postulacion.action", parametros, function(json){
		
			if(json.record === null){
				$('#loadAjax').modal('toggle');
				mostrarModalResultadoSolicitud('<i class="fa fa-exclamation-triangle"></i> No se encontró coincidencias con los datos enviados.');
				return;
			}
			
			$('#op').val("update");
			$('#idpersona').val(json.record.idpersona);
			$('#idpersonanatural').val(json.record.idpersonanatural);
			$('#int_id_postulante').val(json.record.int_id_postulante);
			$('#srl_id_postulante_conv_area_org').val(json.record.srl_id_postulante_conv_area_org);
			$('#nombre').val(json.record.nombre);
			$('#apepat').val(json.record.apepat);
			$('#apemat').val(json.record.apemat);
			$('#idsexo').val(json.record.idsexo);
			$('#fechanacimiento').val(json.record.fechanacimiento);
			$('#idtipodocumento').val(json.record.idtipodocumento);
			$('#numerodoc').val(json.record.numerodoc);
			$('#idDepartamento').val(json.record.coddptoDir);
			obtenerProvinciaUbigeo('#idDepartamento','#idProvincia','#idubigeo');
			$('#idProvincia').val(json.record.codprovDir);
			obtenerDistritoUbigeo('#idDepartamento','#idProvincia','#idubigeo');
			$('#idubigeo').val(json.record.idubigeoDir);
			$('#ruc').val(json.record.ruc);
			$('#direccion').val(json.record.direccion);
			$('#var_codigo_ciudad_telefono').val(json.record.var_codigo_ciudad_telefono);
			$('#var_telefono').val(json.record.var_telefono);
			$('#var_celular').val(json.record.var_celular);
						
			$('#var_codigo_ciudad_telefono2').val(json.record.var_codigo_ciudad_telefono2);
			$('#var_telefono2').val(json.record.var_telefono2);
			$('#var_celular2').val(json.record.var_celular2);
			
			$('#var_codigo_ciudad_telefono3').val(json.record.var_codigo_ciudad_telefono3);
			$('#var_telefono3').val(json.record.var_telefono3);
			$('#var_celular3').val(json.record.var_celular3);
			
			$('#var_email_principal').val(json.record.var_email_principal);
			$("#srl_id_convocatoria").val(json.record.srl_id_convocatoria);
			obtenerCodigosPostulacion('#srl_id_conv_area_org','#srl_id_convocatoria');
			$('#srl_id_conv_area_org').val(json.record.srl_id_conv_area_org);
			$('#int_orden_merito').val(json.record.int_orden_merito);
			$('#int_id_estado').val(json.record.int_id_estado);
			($('#int_orden_merito').val()===null || $('#int_orden_merito').val()==='') ? $('#int_orden_merito').val('1'):$('#int_orden_merito').val();
			($('#int_id_estado').val()===null) ? $('#int_id_estado').val('2') : $('#int_id_estado').val();
//			(json.record.int_num_activacion===null) ? $('#int_num_activacion').val('1') : $('#int_num_activacion').val();
			$('#int_num_activacion').val(json.record.int_num_activacion);
//			$('#int_orden_merito').prop('disabled', false);
			$('#int_id_estado').prop('disabled', false);
			obtenerInfoVacantesAlterno();
			$("form#frmRegistrarPostulante").data('bootstrapValidator').resetForm();
			
			/* Validacion de estado de personal */
			param = {
					"idPersonaNatural": json.record.idpersonanatural,
				 };
			var json = ajaxSincronizado(ctx+"/obtener-estado-personal.action", "POST", "json", param);
			
			if(json.result === 0){
				
				$('#nombre').prop('disabled', true);
				$('#apepat').prop('disabled', true);
				$('#apemat').prop('disabled', true);
				$('#idsexo').prop('disabled', true);
				$('#fechanacimiento').prop('disabled', true);
				$('#idtipodocumento').prop('disabled', true);
				$('#numerodoc').prop('disabled', true);
				$('#idDepartamento').prop('disabled', true);
				$('#idProvincia').prop('disabled', true);
				$('#idubigeo').prop('disabled', true);
				$('#ruc').prop('disabled', true);
				$('#direccion').prop('disabled', true);
				$('#fechanacimiento_datepicker').prop('disabled', true);
				
				
				$('#estado_personal').val(json.result);
				
			}
			
			$('#loadAjax').modal('toggle');
			
		});
		
	}else if(tipoResultado === 'pdf'){
		var params = serialize(parametros);
		window.open(ctx+"/obtener-detalle-postulacion.action?"+params, '_blank');
	}
	
}
