	var oTableDefault = null;
	var responsiveHelper = undefined;
	var breakpointDefinition = {
	    tablet: 1024,
	    phone : 480
	};
	
$(document).ready(function() {	
	
	instanciarDt();
	
	$("#btnFiltrar").click(function() {
		iniciarFiltro();
	});
	
	$("#criteriaResumen_nombres,#criteriaResumen_numeroRuc,#criteriaResumen_numerodoc").keypress (function (e) {
		if(e.which == 13) {
			iniciarFiltro();
	    }
	});
	
	$("#criteriaResumen_srl_id_convocatoria").change(function(){
 		obtenerCodigosPostulacion('#criteriaResumen_srl_id_conv_area_org','#criteriaResumen_srl_id_convocatoria');
 		iniciarFiltro();
	});
	
	$("#criteriaResumen_srl_id_conv_area_org").change(function(){
 		iniciarFiltro();
	});
	
	$("#criteriaResumen_idarea").change(function(){
			obtenerUnidadOperativa('#criteriaResumen_idunidad','#criteriaResumen_idarea');
	 		iniciarFiltro();
	});
	
	$("#criteriaResumen_idunidad").change(function(){
 		iniciarFiltro();
	});
	
	$("#criteriaResumen_srl_id_convocatoria").val($("#criteriaResumen_srl_id_convocatoria option:eq(1)").val());
	obtenerCodigosPostulacion('#criteriaResumen_srl_id_conv_area_org','#criteriaResumen_srl_id_convocatoria');
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
					{"mData" : "falg_contrato_generado"},
					{"mData" : "idpersonanatural"}
					
				]
			, "aoColumnDefs": [
												{
												     "aTargets": [7],
												     "mData": null,
												     "mRender": function (data, type, row) {
												  	   
												      	  var b = '';
												          	
												      	  if(data === 1)
												      	  
												      		 b ='<center><button type="button" class="btn btn-primary dropdown-toggle btn-sm-success">'+
												          	    'Si'+
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
							 		                    	    'Contratos <span class="caret"></span>'+
							 		                    	  '</button>'+
							 		                    	  '<ul class="dropdown-menu" role="menu">'+
							 		                    	    '<li><a href="javascript:void(0);" onclick="seleccionarPersona('+data+','+row.srl_id_postulante_conv_area_org+');">Información</a></li>'+
							 		                    	    '<li><a href="javascript:void(0);" onclick="registrarContrato('+data+','+row.srl_id_postulante_conv_area_org+');">Generar Contrato</a></li>'+
							 		                    	  '</ul>'+
							 		                    	'</div>';
						 		                    	   
						 		                    	   return b;
					 		                    	   
//					 		                    		  return '<center><button title="Seleccionar" class="btn btn-primary" onclick="seleccionarPersona('+data+');">Info Contratos</button></center>';
					 		                    	}
					 		                   }
					 		                  
					 		  ],
					 		  
  		   "fnInitComplete": function(oSettings, json) {
  			   iniciarFiltro();
  		    }

	});
	
}

function iniciarFiltro(){
	
	criteriaResumen_nombres = $.trim($('#criteriaResumen_nombres').val());
	criteriaResumen_numeroRuc = $.trim($('#criteriaResumen_numeroRuc').val());
	criteriaResumen_tipoDoc =  $.trim($('#criteriaResumen_tipoDoc').val());
	criteriaResumen_numerodoc = $.trim($('#criteriaResumen_numerodoc').val());
	criteriaResumen_srl_id_convocatoria = $.trim($('#criteriaResumen_srl_id_convocatoria').val());
	criteriaResumen_srl_id_conv_area_org = $.trim($('#criteriaResumen_srl_id_conv_area_org').val());
	criteriaResumen_idarea = $.trim($('#criteriaResumen_idarea').val());
	criteriaResumen_idunidad = $.trim($('#criteriaResumen_idunidad').val());
	criteriaResumen_int_id_estado = "2";
	
	if(criteriaResumen_nombres === '' && 
			criteriaResumen_numeroRuc === '' && 
			criteriaResumen_tipoDoc === '' && 
			criteriaResumen_numerodoc === '' && 
			criteriaResumen_srl_id_convocatoria === '' &&
			criteriaResumen_srl_id_conv_area_org === '' &&
			criteriaResumen_idarea === '' &&
			criteriaResumen_idunidad === ''){
		
		if(oTableDefault !== null){
			if(oTableDefault.fnGetData().length > 0){
				oTableDefault.fnClearTable();
			}
		}
		return;
	}
	
	parametros = {
			"criteriaPostulanteGanador.tipoDoc": criteriaResumen_tipoDoc,
			"criteriaPostulanteGanador.numerodoc": criteriaResumen_numerodoc,
			"criteriaPostulanteGanador.numeroRuc": criteriaResumen_numeroRuc,
			"criteriaPostulanteGanador.nombres": criteriaResumen_nombres,
			"criteriaPostulanteGanador.srl_id_convocatoria": criteriaResumen_srl_id_convocatoria,
			"criteriaPostulanteGanador.srl_id_conv_area_org": criteriaResumen_srl_id_conv_area_org,
			"criteriaPostulanteGanador.idarea": criteriaResumen_idarea,
			"criteriaPostulanteGanador.idunidad": criteriaResumen_idunidad,
			"criteriaPostulanteGanador.int_id_estado": criteriaResumen_int_id_estado,
			"tipoResultado": 'json'
		 };
	
		$('#loadAjax').modal('toggle');
		
		json = filtrarPersonasParaContrato(parametros);
		
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

function obtenerCodigosPostulacion(idTag,idTagValor){
	
	$(idTag).empty();
	$(idTag).append($("<option />").val('').text('Seleccione una opción'));	
	
	parametros = {"idConvocatoria":$(idTagValor).val()};
	
	var json = ajaxSincronizado(ctx+"/obtener-codigos-postulacion.action", "POST", "json", parametros);
	
	$.each(json.listResult, function() {
		$(idTag).append($("<option />").val(this.srl_id_conv_area_org).text(this.var_codigo_postulacion));
	});
	   
}

function obtenerUnidadOperativa(idTag,idTagValor){
	
	$(idTag).empty();
	$(idTag).append($("<option />").val('').text('Seleccione una opción'));	
	
	if($("#criteriaResumen_idarea").val() === ''){
		return;
	}
	
	parametros = {	
					idAreaOrganica:$(idTagValor).val()
				  };
	
	var json = ajaxSincronizado(ctx+"/obtener-unidad-operativa.action", "POST", "json", parametros);
	
		$.each(json.listResult, function() {
			$(idTag).append($("<option />").val(this.idunidad).text(this.nomunidad));
		});
}

function seleccionarPersona(idPersona,idPostulacion){
	$('#idPersonaNatural').val(idPersona);
	$('#idPostulacion').val(idPostulacion);
	$('#form').get(0).setAttribute('action', '/personal/gestionar-contrato.action');
	$("#form").submit();
}
function registrarContrato(idPersona,idPostulacion){
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-contrato.action');
	$('#idPersonaNatural').val(idPersona);
	$('#idPostulacion').val(idPostulacion);
	$('#op').val("insert");
	$('#tipoReg').val("contrato");
	$("#form").submit();
}
