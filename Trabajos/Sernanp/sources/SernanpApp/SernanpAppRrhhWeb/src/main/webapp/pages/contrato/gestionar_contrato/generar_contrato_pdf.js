	var oTableDefault = null;
	var oTableAdenda = null;
	var responsiveHelper = undefined;
	var breakpointDefinition = {
	    tablet: 1024,
	    phone : 480
	};
	
$(document).ready(function() {	
	
	cargarContratos();
	
	$("#btnVolver").click(function() {
		window.history.back();
	});

	
    $('#cbContratos').click(function(event) {  //on click 
        if(this.checked) { // check select status
            $('.checkboxContratos').each(function() { //loop through each checkbox
                this.checked = true;  //select all checkboxes with class "checkbox1"               
            });
        }else{
            $('.checkboxContratos').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"                       
            });         
        }
    });
    
    $('#cbAdendas').click(function(event) {  //on click 
        if(this.checked) { // check select status
            $('.checkboxAdendas').each(function() { //loop through each checkbox
                this.checked = true;  //select all checkboxes with class "checkbox1"               
            });
        }else{
            $('.checkboxAdendas').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"                       
            });         
        }
    });
    
});	

function cargarContratos(){
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
    		                 [ 25, 50, 100, 200, -1],
      		                 [ 25, 50, 100, 200, "Todos"]
  		             ],
			"sAjaxDataProp": "listResult",
			"sAjaxSource": null,
			"aoColumns" : 
				[ 
				 	{"mData" : "srl_id_contrato"},
				 	{"mData" : "var_num_contrato"},
				 	{"mData" : "des_tipo_contrato"},
				 	{"mData" : "nombre_completo"},
					{"mData" : "dte_fec_suscrip"},
					{"mData" : "dte_fec_inicio"},
					{"mData" : "dte_fec_termino"},
					{"mData" : "var_num_convocatoria"},
					{"mData" : "var_codigo_postulacion"}, 
					{"mData" : "var_nom_cargo"}
					
					
				], 
				"aoColumnDefs": [
		 		                  {
		 		                       "aTargets": [0],
		 		                       "mData": null,
		 		                       "mRender": function (data, type, row) {
		 		                    	  
		 		                    	   return "<input type=\"checkbox\" name=\"idContratos\" class=\"checkboxContratos\" value=\""+data+"\" />";
		 		                    	}
		 		                   }
		 		                   
		 		  ], 		  
	  		   "fnInitComplete": function(oSettings, json) {
	  			   obtenerContratos();
	  		    },
  		  bFilter: true,
  		  bInfo: true,
//  		  "bLengthChange": true

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
		    "aaSorting": [],
		    "oLanguage": {
			   "sUrl": "assets/plugins/datatables/lang/spanish.json"
  		     },
  		   "aLengthMenu": [
  		                 [ 25, 50, 100, 200, -1],
  		                 [ 25, 50, 100, 200, "Todos"]
  		             ],
			"sAjaxDataProp": "listResult",
			"sAjaxSource": null,
			"aoColumns" : 
				[ 
				 	{"mData" : "srl_id_contrato"},
				 	{"mData" : "var_num_contrato"},
				 	{"mData" : "var_num_contrato_padre"},
				 	{"mData" : "nombre_completo"},
					{"mData" : "dte_fec_suscrip"},
					{"mData" : "dte_fec_inicio"},
					{"mData" : "dte_fec_termino"},
					{"mData" : "int_meses_prorroga"},
//					{"mData" : "var_ubicacion_fisica"},
					{"mData" : "desarea"},
					
					
				],
				"aoColumnDefs": [
		 		                  {
		 		                       "aTargets": [0],
		 		                       "mData": null,
		 		                       "mRender": function (data, type, row) {
		 		                    	  
		 		                    	   return "<input type=\"checkbox\" name=\"idAdendas\" class=\"checkboxAdendas\" value=\""+data+"\" />";
		 		                    	} 
		 		                   }
		 		                   
		 		  ],
  		   "fnInitComplete": function(oSettings, json) {
  			   obtenerAdendas();
  		    },
  		    bInfo: true,
  		  "bLengthChange": true,

	});
	
}

function obtenerContratos(){
	
	parametros = {
			
		 };
	
		$('#loadAjax').modal('toggle');
		
		json = ajaxSincronizado(ctx+"/buscar-contratos-generados.action", "POST", "json", parametros);
		
		oTableDefault.fnClearTable();

		var oSettings = oTableDefault.fnSettings();
		
		oTableDefault.fnClearTable(this);

	    for (var i=0; i<json.listResult.length; i++)
	    {
	    	oTableDefault.oApi._fnAddData(oSettings, json.listResult[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableDefault.fnDraw();
	    
//	    $('#loadAjax').modal('toggle');
}

function obtenerAdendas(){
	
	parametros = {
		 };
	
//		$('#loadAjax').modal('toggle');
		
		json = ajaxSincronizado(ctx+"/busca-adendas-generadas.action", "POST", "json", parametros);
		
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

function generarContratosPdf(){
	
	var ids="";
	
	$('#tableDefault tr td input:checked').each(function() {
		if(ids === ""){
			ids = $(this).attr('value');
		}else{
			ids = ids +","+$(this).attr('value');
		}
	    
	});
	
	if(ids === ""){
		return;
	}
	
	$('#idContratos').val(ids);
	$("#formContratos").submit();
}

function generarAdendasPdf(){
	var ids="";
	
	$('#tableAdenda tr td input:checked').each(function() {
		if(ids === ""){
			ids = $(this).attr('value');
		}else{
			ids = ids +","+$(this).attr('value');
		}
	    
	});
	
	if(ids === ""){
		return;
	}
	
	$('#idAdendas').val(ids);
	$("#formAdendas").submit();
}

function suscribirContratos(){
	
	var ids="";
	
	$('#tableDefault tr td input:checked').each(function() {
		if(ids === ""){
			ids = $(this).attr('value');
		}else{
			ids = ids +","+$(this).attr('value');
		}
	    
	});
	
	if(ids === ""){
		return;
	}
	
	$('#modalConfirmarGrabar').modal('toggle');
	
	parametros = {idContratos : ids}
	
	var json = ajaxSincronizado(ctx+"/suscribir-contratos-masivos.action", "POST", "json", parametros);
	
	$('#modalConfirmarGrabar').modal('toggle');
	
	 	if(json.transaccionUtil.estadoTransaccion === 1){
	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	 		obtenerContratos();
	 		$('#tableDefault tr th input:checkbox').attr('checked', false);
	 		$('#loadAjax').modal('toggle');
	 	}else{
	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	 	}
	
}

function suscribirAdendas(){
	
	var ids="";
	
	$('#tableAdenda tr td input:checked').each(function() {
		if(ids === ""){
			ids = $(this).attr('value');
		}else{
			ids = ids +","+$(this).attr('value');
		}
	    
	});
	
	if(ids === ""){
		return;
	}
	
	$('#modalConfirmarGrabar').modal('toggle');
	
	parametros = {idAdendas : ids}
	
	var json = ajaxSincronizado(ctx+"/suscribir-adendas-masivos.action", "POST", "json", parametros);
	
	$('#modalConfirmarGrabar').modal('toggle');
	
	 	if(json.transaccionUtil.estadoTransaccion === 1){
	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-success\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	 		$('#loadAjax').modal('toggle');
	 		obtenerAdendas();
	 		$('#tableAdenda tr th input:checkbox').attr('checked', false);
	 	}else{
	 		mostrarModalResultadoSolicitud("<div class=\"alert alert-danger\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	 	}	
	
}

/*ADD 11-11-2015 DAVID*/

function generarXLS(){
//	$("#format").val("XLS");
	$("#frmReportexls").submit();
}