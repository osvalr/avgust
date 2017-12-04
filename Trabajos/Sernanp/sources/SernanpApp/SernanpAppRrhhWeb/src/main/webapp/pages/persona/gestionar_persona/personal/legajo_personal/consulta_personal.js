var oTableDefault = null;
var responsiveHelper = undefined;
var breakpointDefinition = {
    tablet: 1024,
    phone : 480
};

$(document).ready(function() {

	instanciarDt();

	$("#criteriaResumen_numerodoc,#criteriaResumen_nombres,#criteriaResumen_ruc").keypress (function (e) {
		if(e.which == 13) {
			iniciarFiltro();
	    }
	});
	
	$("#criteriaResumen_srl_id_regimen_contractual,#criteriaResumen_tipoDoc," +
	  "#criteriaResumen_srl_id_cargo,#criteriaResumen_idarea,#idcategoriaanp,#idareanatural").change (function () {
		
			iniciarFiltro();
	 
	});
	
	$("#criteriaResumen_int_estado").change (function () {
		
		iniciarFiltro();
 
});
	
	$("#criteriaResumen_tipoDoc").prop('selectedIndex',1);
		
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
					{"mData" : "expediente"},
					{"mData" : "idpersonal"}

					
				]
			, "aoColumnDefs": [
					 		                  {
					 		                       "aTargets": [10], 
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    	   
					 		                    		  return '<button title="Seleccionar" class="btn btn-primary btn-sm" onclick="registroPersonal('+ row.idpersonal +','+ row.idpersonanatural +');">Consultar</button>';
					 		                           
					 		                    	}
					 		                   }
//					 		                  
             
					 		                ],
				"fnInitComplete": function(oSettings, json) {
  			   iniciarFiltro();
  		    }	 		                

	});
}

function iniciarFiltro(){

	criteriaResumen_nombres = $.trim($('#criteriaResumen_nombres').val());
	criteriaResumen_ruc = $.trim($('#criteriaResumen_ruc').val());
	criteriaResumen_tipoDoc =  $.trim($('#criteriaResumen_tipoDoc').val());
	criteriaResumen_numerodoc = $.trim($('#criteriaResumen_numerodoc').val());
	criteriaResumen_srl_id_regimen_contractual = $.trim($('#criteriaResumen_srl_id_regimen_contractual').val());
	criteriaResumen_int_estado = $.trim($('#criteriaResumen_int_estado').val());
	criteriaResumen_srl_id_cargo = $.trim($('#criteriaResumen_srl_id_cargo').val());
	criteriaResumen_idarea = $.trim($('#criteriaResumen_idarea').val());
	criteriaResumen_idcategoriaanp = $.trim($('#idcategoriaanp').val());
	criteriaResumen_idareanatural = $.trim($('#idareanatural').val());
	
	if(criteriaResumen_nombres === '' && 
			criteriaResumen_ruc === '' && 
			criteriaResumen_tipoDoc === '' && 
			criteriaResumen_numerodoc === '' &&
			criteriaResumen_srl_id_regimen_contractual === '' &&
			criteriaResumen_int_estado === '' &&
			criteriaResumen_srl_id_cargo === '' &&
			criteriaResumen_idarea === '' &&
			criteriaResumen_idcategoriaanp === '' &&
			criteriaResumen_idareanatural === ''){
	
	if(oTableDefault !== null){
		if(oTableDefault.fnGetData().length > 0){
				oTableDefault.fnClearTable();
			}
	}
	
	return;
}



parametros = {
		"criteriaResumen.tipoDoc": criteriaResumen_tipoDoc,
		"criteriaResumen.numerodoc": criteriaResumen_numerodoc,
		"criteriaResumen.ruc": criteriaResumen_ruc,
		"criteriaResumen.nombres": criteriaResumen_nombres,
		"criteriaResumen.srl_id_regimen_contractual": criteriaResumen_srl_id_regimen_contractual,
		"criteriaResumen.int_estado": criteriaResumen_int_estado,
		"criteriaResumen.srl_id_cargo": criteriaResumen_srl_id_cargo,
		"criteriaResumen.idarea": criteriaResumen_idarea,
		"criteriaResumen.idcategoriaanp": criteriaResumen_idcategoriaanp,
		"criteriaResumen.idareanatural": criteriaResumen_idareanatural
		
	 };

	
	$('#loadAjax').modal('toggle');
	
//		json = filtrarPersonal(parametros);
		var request = ajaxRequest(ctx+"/listar-resumen-personal.action", "POST", "json", parametros);
		
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

function obtenerAreaNatural(idTagCategoriaAnp,idTagAreaNatural){
	
	$(idTagAreaNatural).empty();
	$(idTagAreaNatural).append($("<option />").val('').text('Seleccione una opción'));
		
	parametros = {'idCategoriaAnp': $(idTagCategoriaAnp).val()};
	
	var json = ajaxSincronizado(ctx+"/obtener-area-natural.action", "POST", "json", parametros);
	
	$.each(json.listResult, function() {
		$(idTagAreaNatural).append($("<option />").val(this.idareanatural).text(this.desareanatural));
	});
  
};  

function registroPersonal(idPersonal,idPersonaNatural){
	$('#idPersonal').val(idPersonal);
	$('#idPersonaNatural').val(idPersonaNatural);
	$('#form').get(0).setAttribute('action', '/personal/consulta-personal-detalle.action');
	$("#form").submit();
}
	