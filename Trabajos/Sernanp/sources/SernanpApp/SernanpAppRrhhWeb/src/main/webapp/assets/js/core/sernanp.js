jQuery(function($)
	    {
	
//	$.ajaxSetup({ scriptCharset: "utf-8" , contentType: "application/json; charset=utf-8"});
	
	       $.mask.definitions['H']='[012]';
		   $.mask.definitions['N']='[012345]';
		   $.mask.definitions['n']='[0123456789]';
		   $.mask.definitions['x']='[0123456789]';
		   
		});
		
    $(function () {$('#menu').metisMenu();});

var $overlay = $('.ui-widget-overlay');
var ctx = "${pageContext.request.contextPath}";

function obtenerValoresTablaTipo(idTablaTipo, id){
	$(id).empty();
		
	parametros = {'idTablaTipo': idTablaTipo};
	
	var json = ajaxSincronizado(ctx+"/obtener-valores-tablatipo.action", "POST", "json", parametros);

	$.each(json.listResult, function() {
			$(id).append($("<option />").val(this.idtablatipo).text((this.abrtablatipo === null ? this.destablatipo : this.abrtablatipo)));
	});
	
		
}

function ajaxSincronizado(path,tipoPeticion,tipoDatoRetorno,parametros){
	
	var dataReturn = null;
	
	$.ajax({
        url: path,
        type: tipoPeticion,
        dataType:tipoDatoRetorno,
        data:parametros,
        async:false,
        success: function(data) {
        	dataReturn = data;
        },
        error: function(jqXHR, textStatus, error) {
        	
    		//		 	17-03-2015 DAVID
    	   	if(mostrarModalResultadoSession(jqXHR.responseText,"") >  0)	cerrarSession(); //return;
    	   	alert( "error: " + jqXHR.responseText);
        	
            // END DAVID
        }
	});
	
	return dataReturn;
}

function ajaxRequest(path,tipoPeticion,tipoDatoRetorno,parametros){
		
	var request = $.ajax({
				        url: path,
				        type: tipoPeticion,
				        dataType:tipoDatoRetorno,
				        data:parametros,
				        async:true
				 });
	
	return request;
}

function ajaxRequest(path,tipoPeticion,tipoDatoRetorno,parametros,tipoContenido){
	
	var request = $.ajax({
				        url: path,
				        type: tipoPeticion,
				        dataType:tipoDatoRetorno,
				        data:parametros,
				        contentType:tipoContenido,
				        async:true
				 });
	
	return request;
}

function mostrarModalResultadoSolicitud(msj){
	
	$('#msj_resultado').html(msj);
	$('#modalResultadoSolicitud').modal('toggle');
	
}


serialize = function(obj) {
	  var str = [];
	  for(var p in obj)
	    if (obj.hasOwnProperty(p)) {
	      str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
	    }
	  return str.join("&");
	};
	
$('.dropdown-menu').on('click', function(e){
    if($(this).hasClass('dropdown-menu-form')){
        e.stopPropagation();
    }
});	


//17-03-2015 DAVID

function mostrarModalResultadoSession(msj, divModal){
	
//	alert("msj --> " + msj);
	var msgResult = msj.search("/diana/Login.action");
//	var msgResult = msj.indexOf("/diana/Login.action");

//	if(msgResult > 0){
//		$(divModal).dialog('close');
//		$('#msj_session').html("<div class=\"alert alert-info\" role=\"alert\">SU SESIÓN HA EXPIRADO.</div>");
//		$('#modalSessionExpirada').modal('toggle');
//		setTimeout("cerrarSession()", 5000);		
//	}
	return msgResult;
}

function cerrarSession(){	
	window.location.href="/diana/Salir.action";	
//	$('#modalSessionExpirada').modal('toggle');
	
}
// END DAVID