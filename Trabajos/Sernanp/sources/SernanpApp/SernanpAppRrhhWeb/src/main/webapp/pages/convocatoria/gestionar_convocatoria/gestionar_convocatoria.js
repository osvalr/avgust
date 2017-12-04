var oTableDefault = null;

$(document).ready(function() {
	
	$('#f_anho_convocatoria').val(new Date().getFullYear());
	$('#r_num_convocatoria').prop('readonly', true);
	//ocultarFomrs();
	iniciarFiltro();
	
	
    
    oTableDefault = $('#tableDefault').dataTable( {
 	   "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'p i>>",
        "aaSorting": [],
 		"oLanguage": {
 			"sLengthMenu": "_MENU_ ",
 			"sInfo": "Showing <b>_START_ to _END_</b> of _TOTAL_ entries"
 		},
 		"scrollY": 200,
        "scrollX": true,
        "scrollCollapse": true,
 		"sAjaxDataProp": "listConvocatorias",
 		"sAjaxSource": null,
		"aoColumns" : 
			[ 
				{"mData" : "var_num_convocatoria"}, 
				{"mData" : "var_nombre_convocatoria"},
				{"mData" : "desarea"},
				{"mData" : "dte_fecha_vegencia_inicio"}, 
				{"mData" : "dte_fecha_vigencia_fin"},
				{"mData" : "estado_descrip"},
				{"mData" : "tsp_fecha_registro"},
				{"mData" : "var_num_convocatoria"},
				{"mData" : "var_num_convocatoria"},
			]
 		, "aoColumnDefs": [
 		                  {
 		                       "aTargets": [7],
 		                       "mData": null,
 		                       "mRender": function (data, type, full) {
 		                           return '<button class="btn btn-success" onclick="alert(\''+ data +'\');">Editar</button>';
 		                       }
 		                   },
 		                  {
 		                       "aTargets": [8],
 		                       "mData": null,
 		                       "mRender": function (data, type, full) {
 		                           return '<button class="btn btn-success" onclick="alert(\''+ data +'\');">Cambiar Estado</button>';
 		                       }
 		                   }
 		                ]
     });
    
    $('#f_fecha_registro_desde, #f_fecha_registro_hasta').datepicker({
        showOn: "both",
        dateFormat: 'dd-mm-yy',
        changeYear: true,
        changeMonth: true,
        firstDay: 1, 
        changeFirstDay: false
    });
    
});	

function iniciarFiltro(){
	
	parametros = {
			"num_convocatoria": $('#f_num_convocatoria').val(),
			"anho_convocatoria": $('#f_anho_convocatoria').val(),
			"fecha_vegencia_inicio": $('#f_fecha_vigencia_inicio').val(),
			"fecha_vigencia_fin": $('#f_fecha_vigencia_finaliza').val(),
			"nombre_convocatoria": $('#f_descripcion_convocatoria').val(),
			"fecha_registro_desde": $('#f_fecha_registro_desde').val(),
			"fecha_registro_hasta": $('#f_fecha_registro_hasta').val(),
			"id_area_organica": $('#f_area_organica').val(),
			"estado": $('#f_estado_convocatoria').val()
		 };
	
	$.getJSON("<%=request.getContextPath()%>/filtrar-convocatorias.action", parametros, function(json){
		
		var oSettings = oTableDefault.fnSettings();
		
		oTableDefault.fnClearTable(this);
		
	    for (var i=0; i<json.listConvocatorias.length; i++)
	    {
	    	oTableDefault.oApi._fnAddData(oSettings, json.listConvocatorias[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableDefault.fnDraw();
	});
	
}

function registrarEditar(){
	
	parametros = {
			"fecha_vegencia_inicio": $('#r_fecha_vigencia_inicio').val(),
			"fecha_vigencia_fin": $('#r_fecha_vigencia_finaliza').val(),
			"nombre_convocatoria": $('#r_descripcion_convocatoria').val(),
			"id_area_organica": $('#r_area_organica').val()
		 };
	
	$.ajax({
	        url: '<%=request.getContextPath()%>/registrar-editar-convocatoria.action',
	        type: 'POST',
	        dataType:"json",
	        data:parametros,
	        async:false,
	        success: function(json) {
	          //alert(json.transaccionUtil.codigoGenerado);
	          iniciarFiltro();
	        },
	        error: function(jqXHR, textStatus, error) {
	          alert( "error: " + jqXHR.responseText);
	        }
      });
		
}

function ocultarFomrs(){
	 $('#formFiltrar').hide(500);
	 $('#formRegistro').hide(500);
}

function registrar() {
    $('#formRegistro').toggle(500);
    $('#formFiltrar').hide(500);
}
function filtrar() {
    $('#formFiltrar').toggle(500);
    $('#formRegistro').hide(500);
}
