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
    		                 [25, 50, 100, 200, -1],
      		                 [25, 50, 100, 200, "Todos"]
  		             ],
			"sAjaxDataProp": "listResult",
			"sAjaxSource": null,
			"aoColumns" : 
				[ 
				 	{"mData" : "var_num_contrato"},
				 	{"mData" : "nombre_completo"},
					{"mData" : "dte_fec_suscrip"},
					{"mData" : "dte_fec_inicio"},
					{"mData" : "dte_fec_termino"}
				],  
	  		   "fnInitComplete": function(oSettings, json) {
	  			   obtenerContratos();
	  		    },
  		  bFilter: true,
  		     bInfo: true,
  		   "bLengthChange": true,

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
    		                 [25, 50, 100, 200, -1],
      		                 [25, 50, 100, 200, "Todos"]
  		             ],
			"sAjaxDataProp": "listResult",
			"sAjaxSource": null,
			"aoColumns" : 
				[ 
				 	{"mData" : "var_num_contrato"},
				 	{"mData" : "var_num_contrato_padre"},
				 	{"mData" : "nombre_completo"},
					{"mData" : "dte_fec_suscrip"},
					{"mData" : "dte_fec_inicio"},
					{"mData" : "dte_fec_termino"}
					
					
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
		
		json = ajaxSincronizado(ctx+"/contratos-vencimiento", "POST", "json", parametros);
		
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

function obtenerAdendas(idContratoPadre){
	
	parametros = {
		 };
	
//		$('#loadAjax').modal('toggle');
		
		json = ajaxSincronizado(ctx+"/adendas-vencimiento", "POST", "json", parametros);
		
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

function generarPdf(){
	$("#format").val("PDF");
	$("#frmReportepdf").submit();
}
function generarXLS(){
	$("#format").val("XLS");
	$("#frmReportexls").submit();
}


