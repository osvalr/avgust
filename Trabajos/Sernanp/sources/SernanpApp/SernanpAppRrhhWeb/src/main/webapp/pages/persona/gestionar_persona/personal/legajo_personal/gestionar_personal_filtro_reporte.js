var oTableDefault = null;
var responsiveHelper = undefined;
var breakpointDefinition = {
    tablet: 1024,
    phone : 480
};

$(document).ready(function() {

	instanciarDt();
	
	$("#criteriaReporteResumen_anho_inicio").val(new Date().getFullYear());
	
	$("#criteriaReporteResumen_anho_inicio,#criteriaReporteResumen_dte_fec_inicio_desde,#criteriaReporteResumen_dte_fec_inicio_hasta").keypress (function (e) {
		if(e.which == 13) {
			iniciarFiltro();
	    }
	});
	
	$("#criteriaReporteResumen_srl_id_regimen_contractual,#criteriaReporteResumen_srl_id_cargo").change (function () {
			iniciarFiltro();
	});
	
		
	 $( "#criteriaReporteResumen_dte_fec_inicio_desde" ).datepicker({
		 dateFormat : "dd/mm/yy",
	      changeMonth: true,
	      changeYear: true,
	      numberOfMonths: 1,
	      onClose: function( selectedDate ) {
	        $( "#criteriaReporteResumen_dte_fec_inicio_hasta" ).datepicker( "option", "minDate", selectedDate );
	      }
	  });
	 
	  $( "#criteriaReporteResumen_dte_fec_inicio_hasta" ).datepicker({
		  dateFormat : "dd/mm/yy",
	      changeMonth: true,
	      changeYear: true,
	      numberOfMonths: 1,
	      onClose: function( selectedDate ) {
	        $( "#criteriaReporteResumen_dte_fec_inicio_desde" ).datepicker( "option", "maxDate", selectedDate );
	        $("#criteriaReporteResumen_anho_inicio").val('');
	      }
	  });
	
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
					{"mData" : "var_nom_cargo"},
					{"mData" : "desarea"},
					{"mData" : "descategoriaanp"},
					{"mData" : "desareanatural"},
					{"mData" : "dte_fec_inicio"},
					{"mData" : "dte_fec_termino"}
				], 
				"fnInitComplete": function(oSettings, json) {
  			   iniciarFiltro();
  		    }	 		                

	});
}

function iniciarFiltro(){

	criteriaResumen_srl_id_regimen_contractual = $.trim($('#criteriaReporteResumen_srl_id_regimen_contractual').val());
	criteriaResumen_srl_id_cargo = $.trim($('#criteriaReporteResumen_srl_id_cargo').val());
	criteriaReporteResumen_anho_inicio = $.trim($('#criteriaReporteResumen_anho_inicio').val());
	criteriaReporteResumen_dte_fec_inicio_desde = $.trim($('#criteriaReporteResumen_dte_fec_inicio_desde').val());
	criteriaReporteResumen_dte_fec_inicio_hasta = $.trim($('#criteriaReporteResumen_dte_fec_inicio_hasta').val());
	
	if(		criteriaResumen_srl_id_regimen_contractual === '' &&
			criteriaResumen_srl_id_cargo === '' &&
			criteriaReporteResumen_anho_inicio  === '' &&
			criteriaReporteResumen_dte_fec_inicio_desde  === '' &&
			criteriaReporteResumen_dte_fec_inicio_hasta  === ''){
	
	if(oTableDefault !== null){
		if(oTableDefault.fnGetData().length > 0){
				oTableDefault.fnClearTable();
			}
	}
	
	return;
}



parametros = {
		"criteriaReporteResumen.srl_id_regimen_contractual": criteriaResumen_srl_id_regimen_contractual,
		"criteriaReporteResumen.srl_id_cargo": criteriaResumen_srl_id_cargo,
		"criteriaReporteResumen.anho_inicio": criteriaReporteResumen_anho_inicio,
		"criteriaReporteResumen.dte_fec_inicio_desde": criteriaReporteResumen_dte_fec_inicio_desde,
		"criteriaReporteResumen.dte_fec_inicio_hasta": criteriaReporteResumen_dte_fec_inicio_hasta
	 };

	
	$('#loadAjax').modal('toggle');
	
//		json = filtrarPersonal(parametros);
		var request = ajaxRequest(ctx+"/listar-resumen-personal-reporte.action", "POST", "json", parametros);
		
		request.done(function( json ) {
			
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
		

	
}

function reportPdf(){
	$("#format").val("PDF");
	$("#frmReporte").submit();
}
function reportXls(){
	$("#format").val("XLS");
	$("#frmReporte").submit();
}
