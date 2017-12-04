	var oTableDefault = null;
	var oTableAdenda = null;
	var responsiveHelper = undefined;
	var breakpointDefinition = {
	    tablet: 1024,
	    phone : 480
	};
	
$(document).ready(function() {	
	
	instanciarDt();
	
	$("#btnVolver").click(function() {
		window.history.back();
	});
	
//	$("#btnRegistrarNuevoContrato").click(function() {
//		registrarContrato();
//	});
	
});	

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
					{"mData" : "var_num_convocatoria"},
					{"mData" : "var_codigo_postulacion"}, 
					{"mData" : "var_nom_cargo"},
					{"mData" : "srl_id_contrato"}
					
				]
			, "aoColumnDefs": [
					 		                  {
					 		                       "aTargets": [10],
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    	  
					 		                    	  var b = '';
					 		                    	
						 		                    	b = '<div class="btn-group">'+
							 		                    	  '<button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown">'+
							 		                    	    'Contrato <span class="caret"></span>'+
							 		                    	  '</button>'+
							 		                    	  '<ul class="dropdown-menu" role="menu">'+
							 		                    	    '<li><a href="javascript:void(0);" onclick="editarContrato('+data+');">Editar</a></li>'+
							 		                    	    '<li><a href="javascript:void(0);" onclick="consultarContrato('+data+');">Consultar</a></li>';
						 		                    	
						 		                    	if(row.srl_id_postulante_conv_area_org != null){
						 		                    		b = b + '<li><a href="javascript:void(0);" onclick="generarContratoPdf('+data+');">Descargar PDF</a></li>';
						 		                    		b = b + '<li><a href="javascript:void(0);" onclick="generarContratoWord('+data+');">Descargar WORD</a></li>';
						 		                    	}
						 		                    	// SE QUITO PARA QUE PUEDAN REGISTRAR ADENDAS EN PENULTIMOS CONTRATOS 05-08-2015 DAVID
						 		                    	
						 		                    	if(row.srl_id_regimen_contractual === 3 && row.falg_ultimo_contrato === 1){
						 		                    		b = b + '<li><a href="javascript:void(0);" onclick="registrarAdenda('+data+');">Registrar Adenda</a></li>';
						 		                    	}
						 		                    	
						 		                    	if(row.srl_id_regimen_contractual === 3){
//						 		                    		b = b + '<li><a href="javascript:void(0);" onclick="registrarAdenda('+data+');">Registrar Adenda</a></li>';
						 		                    		b = b + '<li><a href="#adendas" onclick="obtenerAdendas('+data+');">Adendas</a></li>';
						 		                    	}
						 		                    	
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
					{"mData" : "var_nombre_estado"},
					{"mData" : "srl_id_contrato"}
					
				]
			, "aoColumnDefs": [
					 		                  {
					 		                       "aTargets": [7],
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    	   
					 		                    	  var b = '';
					 		                    	
					 		                    	  b = '<div class="btn-group">'+
						 		                    	  '<button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown">'+
						 		                    	    'Adenda <span class="caret"></span>'+
						 		                    	  '</button>'+
						 		                    	  '<ul class="dropdown-menu" role="menu">'+
						 		                    	    '<li><a href="javascript:void(0);" onclick="editarAdenda('+data+');">Editar</a></li>'+
						 		                    	    '<li><a href="javascript:void(0);" onclick="consultarAdenda('+data+');">Consultar</a></li>';
					 		                    	  
//					 		                    	 if(row.srl_id_postulante_conv_area_org != null){
						 		                    		b = b + '<li><a href="javascript:void(0);" onclick="generarAdendaPdf('+data+');">Descargar PDF</a></li>';
						 		                    		b = b + '<li><a href="javascript:void(0);" onclick="generarAdendaWord('+data+');">Descargar WORD</a></li>';
//						 		                    	}
					 		                    	 
					 		                    	 b = b +  '</ul>'+'</div>'; 
					 		                    	 
					 		                    	   return b;
					 		                    	}
					 		                   }
					 		                   
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
			"criteriaCPP.idpersonanatural": $('#idPersonaNatural').val()
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

function editarContrato(idContrato){
	$('#op').val("update");
	$('#tipoReg').val("contrato");
	$('#srl_id_contrato').val(idContrato);
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-contrato.action');
	$("#form").submit();
}

function consultarContrato(idContrato){
	$('#op').val("query");
	$('#tipoReg').val("contrato");
	$('#srl_id_contrato').val(idContrato);
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-contrato.action');
	$("#form").submit();
}

function registrarContrato(idPostulacion){
	$('#op').val("insert");
	$('#tipoReg').val("contrato");
	$('#srl_id_contrato').val('');
	$('#srl_id_contrato_padre').val('');
	
//	var postulacion = $('#srl_id_postulante_conv_area_org').val();
	$('#idPostulacion').val(idPostulacion);
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-contrato.action');
	$("#form").submit();
}

function registrarAdenda(idContrato){
	$('#op').val("insert");
	$('#tipoReg').val("adenda");
	$('#srl_id_contrato').val('');
	$('#srl_id_contrato_padre').val(idContrato);
	$('#idPostulacion').val('');
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-contrato.action');
	$("#form").submit();
}

function editarAdenda(idContrato){
	$('#op').val("update");
	$('#tipoReg').val("adenda");
	$('#srl_id_contrato').val(idContrato);
	$('#idPostulacion').val('');
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-contrato.action');
	$("#form").submit();
}

function consultarAdenda(idContrato){
	$('#op').val("query");
	$('#tipoReg').val("adenda");
	$('#idPostulacion').val('');
	$('#srl_id_contrato').val(idContrato);
	$('#form').get(0).setAttribute('action', '/personal/registrar-editar-contrato.action');
	$("#form").submit();
}

function generarContratoPdf(idContrato){
	$('#idContrato').val(idContrato);
	$('#form').get(0).setAttribute('action', '/personal/generar-contrato-pdf.action');
	$("#form").submit();
}
function generarContratoWord(idContrato){
	$('#idContrato').val(idContrato);
	$('#form').get(0).setAttribute('action', '/personal/generar-contrato-word.action');
	$("#form").submit();
}

function generarAdendaPdf(idContrato){
	$('#idContrato').val(idContrato);
	$('#form').get(0).setAttribute('action', '/personal/generar-adenda-pdf.action');
	$("#form").submit();
}

function generarAdendaWord(idContrato){
	$('#idContrato').val(idContrato);
	$('#form').get(0).setAttribute('action', '/personal/generar-adenda-word.action');
	$("#form").submit();
}