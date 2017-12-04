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
	
	$("#criteriaPersonalContrato_nombres,#criteriaPersonalContrato_numeroRuc,#criteriaPersonalContrato_numeroDoc").keypress (function (e) {
		if(e.which == 13) {
			iniciarFiltro();
	    }
	});
	
	$("#criteriaPersonalContrato_srl_id_regimen_contractual,#criteriaPersonalContrato_tipoDoc," +
	  "#criteriaPersonalContrato_srl_id_cargo,#criteriaPersonalContrato_idarea,#idcategoriaanp,#idareanatural").change (function () {
		
			iniciarFiltro();
	 
	});
	
	$("#criteriaPersonalContrato_int_estado").change (function () {
		
		iniciarFiltro();

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
					{"mData" : "desc_estado"},
					{"mData" : "idpersonanatural"}
					
				]
			, "aoColumnDefs": [
					 		                  {
					 		                       "aTargets": [9],
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    		  return '<center><button title="Seleccionar" class="btn btn-primary btn-sm" onclick="seleccionarPersona('+data+');">Info Contratos</button></center>';
					 		                    	}
					 		                   }
					 		  ],
					 		  
  		   "fnInitComplete": function(oSettings, json) {
  			   iniciarFiltro();
  		    }

	});
	
}

function iniciarFiltro(){
	
//	criteriaPersonalContrato_nombres = $.trim($('#criteriaPersonalContrato_nombres').val());
//	criteriaPersonalContrato_numeroRuc = $.trim($('#criteriaPersonalContrato_numeroRuc').val());
//	criteriaPersonalContrato_tipoDoc =  $.trim($('#criteriaPersonalContrato_tipoDoc').val());
//	criteriaPersonalContrato_numeroDoc = $.trim($('#criteriaPersonalContrato_numeroDoc').val());
		
	criteriaPersonalContrato_nombres = $.trim($('#criteriaPersonalContrato_nombres').val());
	criteriaPersonalContrato_ruc = $.trim($('#criteriaPersonalContrato_ruc').val());
	criteriaPersonalContrato_tipoDoc =  $.trim($('#criteriaPersonalContrato_tipoDoc').val());
	criteriaPersonalContrato_numeroDoc = $.trim($('#criteriaPersonalContrato_numeroDoc').val());
	criteriaPersonalContrato_srl_id_regimen_contractual = $.trim($('#criteriaPersonalContrato_srl_id_regimen_contractual').val());
	criteriaPersonalContrato_int_estado = $.trim($('#criteriaPersonalContrato_int_estado').val());
	criteriaPersonalContrato_srl_id_cargo = $.trim($('#criteriaPersonalContrato_srl_id_cargo').val());
	criteriaPersonalContrato_idarea = $.trim($('#criteriaPersonalContrato_idarea').val());
	criteriaPersonalContrato_idcategoriaanp = $.trim($('#idcategoriaanp').val());
	criteriaPersonalContrato_idareanatural = $.trim($('#idareanatural').val());
	
//	if(criteriaPersonalContrato_nombres === '' && 
//			criteriaPersonalContrato_ruc === '' && 
//			criteriaPersonalContrato_tipoDoc === '' && 
//			criteriaPersonalContrato_numerodoc === '' &&
//			criteriaPersonalContrato_srl_id_regimen_contractual === '' &&
//			criteriaPersonalContrato_int_estado === '' &&
//			criteriaPersonalContrato_srl_id_cargo === '' &&
//			criteriaPersonalContrato_idarea === '' &&
//			criteriaPersonalContrato_idcategoriaanp === '' &&
//			criteriaPersonalContrato_idareanatural === ''){
//	
//	if(oTableDefault !== null){
//		if(oTableDefault.fnGetData().length > 0){
//				oTableDefault.fnClearTable();
//			}
//	}
//	
//	return;
//}
	
	parametros = {
			"criteriaPersonalContrato.tipoDoc": criteriaPersonalContrato_tipoDoc,
			"criteriaPersonalContrato.numerodoc": criteriaPersonalContrato_numeroDoc,
			"criteriaPersonalContrato.ruc": criteriaPersonalContrato_ruc,
			"criteriaPersonalContrato.nombres": criteriaPersonalContrato_nombres,
			"criteriaPersonalContrato.srl_id_regimen_contractual": criteriaPersonalContrato_srl_id_regimen_contractual,
			"criteriaPersonalContrato.int_estado": criteriaPersonalContrato_int_estado,
			"criteriaPersonalContrato.srl_id_cargo": criteriaPersonalContrato_srl_id_cargo,
			"criteriaPersonalContrato.idarea": criteriaPersonalContrato_idarea,
			"criteriaPersonalContrato.idcategoriaanp": criteriaPersonalContrato_idcategoriaanp,
			"criteriaPersonalContrato.idareanatural": criteriaPersonalContrato_idareanatural
		 };
	
		$('#loadAjax').modal('toggle');
		
		var request = ajaxRequest(ctx+"/buscar-personal-contrato.action", "POST", "json", parametros);
		
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

function seleccionarPersona(idPersona){
	$('#idPersonaNatural').val(idPersona);
	$('#form').get(0).setAttribute('action', '/personal/gestionar-contrato.action');
	$("#form").submit();
}

function obtenerAreaNatural(idTagCategoriaAnp,idTagAreaNatural){
	
	$(idTagAreaNatural).empty();
	$(idTagAreaNatural).append($("<option />").val('').text('Seleccione una opción'));
		
	parametros = {'idCategoriaAnp': $(idTagCategoriaAnp).val()};
	
	var json = ajaxSincronizado(ctx+"/obtener-area-natural.action", "POST", "json", parametros);
	
	$.each(json.listResult, function() {
		$(idTagAreaNatural).append($("<option />").val(this.idareanatural).text(this.desareanatural));
	});
  
};  