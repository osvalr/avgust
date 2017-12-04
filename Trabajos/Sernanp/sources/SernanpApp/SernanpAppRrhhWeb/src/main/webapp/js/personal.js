var oTableDiasNoLaborables = null;	

$().ready(function(){	
	
	jQuery(function($){
		   $.datepicker.regional['es'] = {
		      closeText: 'Cerrar',
		      prevText: '<Ant',
		      nextText: 'Sig>',
		      currentText: 'Hoy',
		      monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
		      monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
		      dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
		      dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
		      dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
		      weekHeader: 'Sm',
		      dateFormat: 'dd/mm/yy',
		      firstDay: 1,
		      isRTL: false,
		      showMonthAfterYear: false,
		      yearSuffix: ''};
		   $.datepicker.setDefaults($.datepicker.regional['es']);
		});
	
	
	
	$("#fechamarcacion1").datepicker({
//			showOn: 'both',              // Parametro para que se vea el icono del calendario
//			dateFormat : "dd/mm/yy",
//			buttonImageOnly: true,       // Indicamos si queremos que solo se vea el icono y no el botón
//			buttonImage: './img/icons/office-calendar.png', // Indicamos el icono del botón
			//firstDay: 1,                 // El primer día será el 1
			changeMonth: true,           // Si se pueden cambiar los meses
			changeYear: true            // Si se pueden cambiar los años		    
	});
	
	
	
	$("#fechamaAsistencia").datepicker({
//		showOn: 'both',              // Parametro para que se vea el icono del calendario
//		dateFormat : "dd/mm/yy",
//		buttonImageOnly: true,       // Indicamos si queremos que solo se vea el icono y no el botón
//		buttonImage: './img/icons/office-calendar.png', // Indicamos el icono del botón
		//firstDay: 1,                 // El primer día será el 1
		changeMonth: true,           // Si se pueden cambiar los meses
		changeYear: true            // Si se pueden cambiar los años    
	});
	
	
	
	$("#fechaNow").datepicker({
//		showOn: 'both',              // Parametro para que se vea el icono del calendario
//		dateFormat : "dd/mm/yy",
//		buttonImageOnly: true,       // Indicamos si queremos que solo se vea el icono y no el botón
//		buttonImage: './img/icons/office-calendar.png', // Indicamos el icono del botón
		//firstDay: 1,                 // El primer día será el 1
		changeMonth: true,           // Si se pueden cambiar los meses
		changeYear: true            // Si se pueden cambiar los años	    
	});
	
	
	

	$("body").on('click','.fltrBtnF', modalFiltroPersonal);
//	$("#fechamaAsistencia").live('change', FiltrarPersonalAsistenciaxfecha);
	$("body").on('change',"#fechamaAsistencia", FiltrarPersonalAsistenciaxfecha_motivo_apepat);
	$("#estadoAsistencia").bind('change', FiltrarPersonalAsistenciaxfecha_motivo_apepat);
//	$("#apellidoTrabajador").live('change', filtraApellidos);
	
//	$("body").on('click',"#btnverMarcaciones", modalFiltroMarcaciones);
	$("body").on('click',"#btnVolveraMarcacionesRM",volveramodalFiltroMarcaciones);	
	$("body").on('click',"#btnVolveraMarcacionesEM",volveramodalFiltroMarcaciones);
	
//	$("body").on('click',"#btnImportarExcel",dialogImportaArchivoExcel);
//	$("body").on('click',"#btnimportarTxtRelog",dialogImportaArchivo);
	$("body").on('click',"#btnGeneraDescuentos",generaDescuentos);
	$("body").on('click',"#btnValidarDescuentos",validarDescuentos);
	
	
	$("body").on('click',"#btnRegistroMarcaciones",modalregistroMarcaciones);//Agregar Marcaciones
//	$("body").on('click',"#btnEditarMarcacion",modalEditarMarcacion);
	$("body").on('click',"#btnActualizarMarcacion",actualizarMarcacion);
	$("body").on('click','#btnInsertaMarcacionManual',validarinsertarMarcacionManual);
	//$("#btnRegistroPapeleta").live('click', modalregistroPapeletas);
	
	$("#btnLimpiarLS").click(function(){
		oTableDefault.fnClearTable();
		$('#apellidoTrabajador').val('');
		FiltrarPersonalAsistenciaxfecha_motivo_apepat();
	});
	
	//VACACIONES
	
	$("body").on('click',"#btnInsertaVacaciones",btnInsertaVacaciones);

	//	LICENCIAS
	
	$("body").on('click',"#btnInsertaLicencias",btnInsertaLicencias);
	
});





modalFiltroPersonal = function(){

//	$( "#divModalContenedor:ui-dialog" ).dialog( "destroy" );              
    $( "#divModalContenedor" ).dialog({
            width: 'auto',            
//            height: 300,
            title: 'Filtrar',
            modal: true,
            closeOnEscape: false,
            open: function(event, ui) {
            	$( "#divModalContenedor" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");            	
            },
            close: function(event, ui) {$("#divContenedor").remove();},
            buttons: {
            	Aceptar : function(){
            		
            		 $('#formFiltroPersonal').attr("action","listadoPersonalRrhhAjax.action");
            		 var options = {
                     		target:        '#DivListadoPersonal',
                             beforeSubmit:  showRequest, 
                             success:       showResponse
                         }; 
            		
            		 $('#formFiltroPersonal').ajaxSubmit(options);
            		 
            		 function showRequest() {
//                     	$('#dialog-form-wait:ui-dialog' ).dialog('destroy'); 
                     	$('#dialog-form-wait').dialog({
                     	    modal: true,	
                     	    width: 'auto',
//                     	    width: 350,         
//                     	    height: 'auto',
                     	    closeOnEscape: false,
                     	    open: function() { 
                     	    	$(this).closest(".ui-dialog").find(".ui-dialog-titlebar:first").hide(); 
                     	    	$( "#dialog-form-wait" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Filtrando...!!!</i>");
                     	    	
                     	    }
                     	});
                     	    
                         return true; 
                     }
            		 
                     function showResponse(){
                    	 $("#divContenedor").remove();
                    	 $("#divModalContenedor").dialog('close');
                    	 
                    	 $("#dialog-form-wait").remove();
                    	 $("#dialog-form-wait").dialog('close');
                     }         		 

            	}
            }
    });

    $.post("filtropersonal.action", null, function(data){
        if(data.length > 0){        		
                $("#divModalContenedor").html(data);
                $("#divModalContenedor").dialog("option", "position", "center");
                var ancho = $("#divModalContenedor").width();
                $("#divModalContenedor").dialog( "option", "width", ancho + 50 );
        }
    });
};





if (!com) var com = {};
$.displaytag= {
        onPeopleTableLoad: function() {

            // Se llama cuando se cargan los datos
            $("table#listapersonal th.sortable").each(function() {
                // Itera sobre cada cabecera de columna conteniendo la clase sortable, de manera
                // que
                // podemos sobreescribir la gestión de click via ajax, en lugar de
                // permitir al navegador seguir un enlace normal
                $(this).click(function() {
                    // "this" es el elemento th ordenable
                    var link = $(this).find("a").attr("href") + " #DivListadoPersonal";
                    $("div#DivListadoPersonal").load(link, {}, $.displaytag.onPeopleTableLoad);
                    // Paramos la propagación de eventos, sin permitir que el navegador ejecute el
                    // href
                    return false;
                });
            });
            $("div#DivListadoPersonal .pagelinks a").each(function() {
                // Itera sobre cada enlace de paginación para sobreescribirlo
                $(this).click(function() {
                    var link = $(this).attr("href") + " #DivListadoPersonal";
                    $("div#DivListadoPersonal").load(link, {}, $.displaytag.onPeopleTableLoad);
                    return false;
                });
            });
        

		
		    // Se llama cuando se cargan los datos
		    $("table#listapersonaldescuentos th.sortable").each(function() {
		        // Itera sobre cada cabecera de columna conteniendo la clase sortable, de manera
		        // que
		        // podemos sobreescribir la gestión de click via ajax, en lugar de
		        // permitir al navegador seguir un enlace normal
		        $(this).click(function() {
		            // "this" es el elemento th ordenable
		            var link = $(this).find("a").attr("href") + " #DivListadoPersonalDescuento";		            
		            $("div#DivListadoPersonalDescuento").load(link, {}, $.displaytag.onPeopleTableLoad);
		            // Paramos la propagación de eventos, sin permitir que el navegador ejecute el
		            // href
		            return false;
		        });
		    });
		    $("div#DivListadoPersonalDescuento .pagelinks a").each(function() {
		        // Itera sobre cada enlace de paginación para sobreescribirlo
		        $(this).click(function() {
		            var link = $(this).attr("href") + " #DivListadoPersonalDescuento";
		            $("div#DivListadoPersonalDescuento").load(link, {}, $.displaytag.onPeopleTableLoad);
		            return false;
		        });
		    });	
		    
		    
		    
		    // Se llama cuando se cargan los datos
		    $("table#listapersonalVacaciones th.sortable").each(function() {
		        // Itera sobre cada cabecera de columna conteniendo la clase sortable, de manera
		        // que
		        // podemos sobreescribir la gestión de click via ajax, en lugar de
		        // permitir al navegador seguir un enlace normal
		        $(this).click(function() {
		            // "this" es el elemento th ordenable
		            var link = $(this).find("a").attr("href") + " #DivListadoPersonalVacaciones";		            
		            $("div#DivListadoPersonalVacaciones").load(link, {}, $.displaytag.onPeopleTableLoad);
		            // Paramos la propagación de eventos, sin permitir que el navegador ejecute el
		            // href
		            return false;
		        });
		    });
		    $("div#DivListadoPersonalVacaciones .pagelinks a").each(function() {
		        // Itera sobre cada enlace de paginación para sobreescribirlo
		        $(this).click(function() {
		            var link = $(this).attr("href") + " #DivListadoPersonalVacaciones";
		            $("div#DivListadoPersonalVacaciones").load(link, {}, $.displaytag.onPeopleTableLoad);
		            return false;
		        });
		    });	


        }
};




function loadANPs(val, vista){
	
	if(val <= 0){
		$('#listANP'+vista).html("");
		$('#listANP'+vista).append('<option value="-1">[-- Seleccione ANP --]</option>');
	}else{

		$.post("listarANPs.action",{idCategoriaANP : val},function(datos){
			x = datos.listaANPs;
			if(x.length > 0){
				$('#listANP'+vista).html("");
				$('#listANP'+vista).append('<option value="-1">[-- Seleccione ANP --]</option>');	
				for(var i=0;i<x.length;i++){
		    		$('#listANP'+vista).append('<option value="' + x[i].idareanatural + '">' + 
		    				                x[i].desareanatural + '</option>');
			    }				
			}
		},"json");
	}
}


function ubicaciondelPersonal(val, vista){
//	console.log("Vista : " + vista);
	
	if(val <= 0){
		$('#listANP'+vista).html("");
		$('#listANP'+vista).append('<option value="-1">[-- Seleccione ANP --]</option>');
		$('#idcategorianp'+vista+ ' option[value=-1]').attr('selected',"selected");	
		$('#listANP'+vista).attr('disabled',"disabled");
		$('#listANP'+vista).removeAttr('enabled',"enabled");
		$('#idcategorianp'+vista).attr('disabled',"disabled");		
		$('#idcategorianp'+vista).removeAttr('enabled',"enabled");		
	}else{
		$('#listANP'+vista).html("");
		$('#listANP'+vista).append('<option value="-1">[-- Seleccione ANP --]</option>');	
		$('#listANP'+vista).attr('enabled',"enabled");
		$('#listANP'+vista).removeAttr('disabled',"disabled");
		$('#idcategorianp'+vista).attr('enabled',"enabled");	
		$('#idcategorianp'+vista).removeAttr('disabled',"disabled");
	}
	
	if(vista == ''){
		FiltrarPersonalAsistenciaxfecha_motivo_apepat();		
	}else if(vista == 'Vac'){
		listapersonalVacacionesxApepatperiodo();
	}else if(vista == 'Desc'){
//		$("#isajax").val('1');
		filtraApellidosOfDescuentoInicial();
	}
	
	
}



function FiltrarPersonalAsistenciaxfecha_motivo_apepat(){

	var nroElementos = 	$('select[name=tableDefault_length]').val();
	
	var fechaasist 	= $("#fechamaAsistencia").val();
	var nValor 		= $("#estadoAsistencia").val();
	var irdreg		= $("#regimenContractual").val();
	var aPaterno  	= $("#apellidoTrabajador").val();
	var ubicacion	= $("#ubicacionPersonal").val();
	var areantural	= $("#listANP").val();

	$('#loadAjax').modal('toggle');
//	$("div#DivListadoPersonal").load("listadoPersonalRrhhAjax.action", {aPaterno : aPaterno, dte_fec_asist : "" + fechaasist + "", Motivo : nValor, 
//		idregimenContractual: irdreg, nroRegistros : nroElementos,  ubicacionPersonal : ubicacion, idANP : areantural, isajax : 1}, function(){
	$.post("listadoPersonalRrhhAjax.action", {aPaterno : aPaterno, dte_fec_asist : "" + fechaasist + "", Motivo : nValor, 
		idregimenContractual: irdreg, nroRegistros : nroElementos,  ubicacionPersonal : ubicacion, idANP : areantural, isajax : 1}, function(data){

		//		 	17-03-2015 DAVID
	   	if(mostrarModalResultadoSession(data,"") >  0)	cerrarSession(); //return;
	   	//		   	END DAVID		
		   	
		if(data.length > 0){
			
			$("#DivListadoPersonal").html(data);		
			
			$('#loadAjax').modal('toggle');	
		}
		
		
	});
	
}


function filtraApellidos(){
	
	var aPaterno  	= $("#apellidoTrabajador").val();				
	var fechaasist 	= $("#fechamaAsistencia").val();
	var nValor 		= $("#estadoAsistencia").val();	
	
	$("div#DivListadoPersonal").load("listadoPersonalRrhhAjax.action", {dte_fec_asist : "" + fechaasist + "", Motivo : nValor, aPaterno : aPaterno});	
		
}



function norequiereMarcacion(){
	var RequiereMarc 	= $("#regHI").val() +  $("#regHS").val();
	var cantMarcacion	= $("#cantMarcacion").val();
	if(RequiereMarc == '00'&& cantMarcacion	!= 0){
		$( "#dialog-info-nm" ).dialog({
//		      resizable: false,
//		      height:'auto',
			width: 'auto',
		      title: 'Agregar Marcación:',
		      modal: true,
		      buttons: {
		        Aceptar: function() {
		          $( this ).dialog( "close" );
		        },		        
		      }
		    });
		return;
		
	}
}


function MotivoMarcacionE(nValor){
		$("#justificacion_marcacion").focus();
}
	


function MotivoMarcacion(nValor){
	
	if(nValor != ''){			
		$("#timePermiso").focus();
		$("#horaingreso").mask("Hx:Nn:00");
		$("#horasalida").mask("Hx:Nn:00");
		
	}else{
		return;
	}

}





function vistasinPermiso(){
  		
	$("#divhoras").css("display","none");
	$("#divfechas").css("display","none");
}


function limitarFecha(fecha){
	var fechaDP = fecha.split('/');

	var ano = parseInt(fechaDP[2],10);
	var mes = parseInt(fechaDP[1],10);
	var dia = parseInt(fechaDP[0],10);
	
	var iniciofecha = new Date(ano, mes - 1, dia);
	
	return iniciofecha;	
}




modalregistroMarcaciones = function(){

	var fecha_Elejida 	= $("#dte_fec_marc").val();
	var	idpersonal 		= $("#idpersonal_marc").val();
	var ubicacion		= $("#ubicacionPersonal").val();
	var idreg			= $("#regimenContractual").val();
	
	$.post("registromarcaciones.action", {idPersonal : idpersonal, dte_fec_marc : fecha_Elejida , ubicacionPersonal : ubicacion, idregimenContractual : idreg}, function(data){
        if(data.length > 0){	
        	
//        	17-03-2015 DAVID
	    	if(mostrarModalResultadoSession(data,"#divModalMarcaciones") >  0)	cerrarSession(); //return;	    	
//	    	END DAVID
	    	
        	$("#divModalMarcaciones").html(data);
            $("#divModalMarcaciones").dialog("option", "position", "center");		
    		
            vistasinPermiso();           
    		
    		$("#horaingreso").mask("Hx:Nn:00");    		
   		
    		$("#horasalida").mask("Hx:Nn:00");
    		
  
        }
    });

};




function modalEditarMarcacion (nValor){
	
	var cant 				= 0;
//	var srl_id_pers_marc	= 0;
	var srl_id_papeleta	= 0;
	var idMarcacion		= 0;
	var idTipoMarc		= 0;
		
		$("input[name='srl_id_papeleta']").each(function(){		
			if($(this).is(":checked")){
			      cant++;
			      srl_id_papeleta 	= $(this).val();
			      var valores		= srl_id_papeleta.split("-");
			      srl_id_papeleta	= valores[0];
			      idMarcacion		= valores[1];
			      idTipoMarc		= valores[2];
			      
			}
		});	
		
		if(cant != 1){		
			$( "#dialog-info-m" ).dialog({
			      width: 'auto',
			      title: 'Actualización de marcación:',
			      modal: true,
			      buttons: {
			        Aceptar: function() {
			          $( this ).dialog( "close" );
			        },		        
			      }
			    });
			return;	
		}else{
		    if(nValor == 0){
		    	
			    if(srl_id_papeleta == 0){
			    	$( "#dialog-info-noeditable" ).dialog({
			    		  width: 'auto',
					      title: 'Actualización de marcación:',
					      modal: true,
					      buttons: {
					        Aceptar: function() {
					        	$( this ).dialog( "close" );				          
					        }	         
					      }
					    });
					return;  
		        }
		    	
				$.post("editarmarcacion.action", {idPapeleta : srl_id_papeleta}, function(data){
	
			        $( "#divModalMarcaciones").dialog('close');
				    $( "#divModalMarcacionesE" ).dialog({
				    		width: 'auto',  
				            title: 'Actualización de marcaciones:',
				            modal: true,
				            closeOnEscape: false,
				            open: function(event, ui) { $( "#divModalMarcacionesE" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
				            close: function(event, ui) {$("#divModalMarcacionesE").remove();},
				    });
			    
//		        	17-03-2015 DAVID
			    	if(mostrarModalResultadoSession(data,"#divModalMarcacionesE") >  0)	cerrarSession(); //return;
//			    	END DAVID
				    
		            $("#divModalMarcacionesE").html(data);
	                $("#divModalMarcacionesE").dialog("option", "position", "center");
	
	               
	                $("#horasalidaE").mask("Hx:Nn:00");
	                $("#horaretornoE").mask("Hx:Nn:00");
				});
		    }else if(nValor == 1){
			    if(idTipoMarc == 126){
			    	$( "#dialog-info-noeditable" ).dialog({
			    		  width: 'auto',
					      title: 'Actualización de marcación:',
					      modal: true,
					      buttons: {
					        Aceptar: function() {
					        	$( this ).dialog( "close" );				          
					        }	         
					      }
					    });
					return;  
		        }
		    	var fecha_marcacion = $("#dte_fec_marc").val();
		    	var idPersonal		= $("#idpersonal_marc").val();
		    	
		    	$( "#dialog-form" ).dialog({
				      width	:'auto',
				      title: 'Eliminar Marcación:',
				      modal: true,
				      buttons: {
				    	'No': function(){
					       	$( this ).dialog( "close" );
						     return;
					    },
				        'Sí': function() {

					    	$.post("eliminarMarcacion.action", {idPersonal : idPersonal, idPapeleta : srl_id_papeleta, dte_fec_marc : fecha_marcacion, isajax : 1, idMarcacion : idMarcacion}, function(data){

					    		var msgResult = data.search("msgIsertsuccess");
					    		if (data.length > 0){
					    			
//						        	17-03-2015 DAVID
							    	if(mostrarModalResultadoSession(data,"#divModalMarcaciones") >  0)	cerrarSession(); //return;
//							    	END DAVID
							    	
					    			$('#divModalmsg').html(data);
					    			
					    			$( "#divModalmsg" ).dialog({
//					    			    resizable: false,
					    			    height: 'auto',
					    			    width: 'auto',
					    			    title: 'Registro de papeletas:',
					    			    modal: true,
					    			  	    
					    			    buttons: {
					    			      Aceptar: function() {				    	  
					    			        $( this ).dialog( "close" );
					    			      },		        
					    			    }
					    			  });
					    			
					    			if(msgResult > 0){

					    	    		marcacionesxFechaxidPersonal($("#dte_fec_marc").val());
					    	    		
					    			}			
					    		}
					    		
					    	});
				        	
				        	$( this ).dialog( "close" );
				        }
				        
				      }
				 });
		    	
		    	
		    	

		    }
	}		
};



function validarinsertarMarcacionManual(){
	
		
		Valid.init($('#formRegistroMarcaciones').find(".valid"));
		

		if(Valid.test()){		
			
			insertarMarcacionManual();

		}else{		

			$("#formRegistroMarcaciones .v_label").css("display","inline");
		}		
		
};




function insertarMarcacionManual(){	
	
	$.post('insertarMarcacionPersonal.action', $('#formRegistroMarcaciones').serialize(), function(data) {		
		
		var msgResult = data.search("msgIsertsuccess");

		if (data.length > 0){
			
//        	17-03-2015 DAVID
	    	if(mostrarModalResultadoSession(data,"") >  0)	cerrarSession(); //return;
//	    	END DAVID	
			
			$('#divModalmsg').html(data);
			
			$( "#divModalmsg" ).dialog({
			    height: 'auto',
			    width: 'auto',
			    title: 'Registro de papeletas:',
			    modal: true,
			    buttons: {
			      Aceptar: function() {				    	  
			        $( this ).dialog( "close" );
			      },		        
			    }
			  });
			
			if(msgResult > 0){
				$('#formRegistroMarcaciones').reset();				

	    		marcacionesxFechaxidPersonal($("#dte_fec_marc").val());

	    		vistasinPermiso();  

	    		var fecha_asisatencia 	= $("#dte_fec_marc").val();	    		
    		
	    		$("#fechamaAsistencia").val(fecha_asisatencia);
	    		
			}			
		}		
		    	    	
    });	
	
}




function actualizarMarcacion(){

	idP = $("#idPersonalM").val();
	
	Valid.init($('#formEdicionMarcacion').find(".valid"));
	if(Valid.test()){


		$( "#dialog-formLic" ).dialog({
		      width	:'auto',
		      title: 'Actualización de Marcación:',
		      modal: true,
		      buttons: {
		    	'No': function(){
			       	$( this ).dialog( "close" );
				     return;
			    },
		        'Sí': function() {
		        	
		    		$.post('actualizararMarcacionPersonal.action', $('#formEdicionMarcacion').serialize(), function(datos) {
						
//		            	17-03-2015 DAVID
		    	    	if(mostrarModalResultadoSession(datos.MsgTrx.toString(),"#dialog-formLic") >  0)	cerrarSession(); //return;
//		    	    	END DAVID	
		    			
		    			var msg = datos.MsgTrx.toUpperCase();		    			
		    			
		    	    	if(msg == 'SUCCESS'){
    	    		
		    	    		oTableDefault 		= null;
		    	        	oTableDefault 		= $('#tableDefault').dataTable();

		    	        	//Valor, fila, columna
		    	        	oTableDefault.fnUpdate(datos.hor_ingreso, $('tr#'+idP)[0], 8, false  );
		    	        	oTableDefault.fnUpdate(datos.hor_salida, $('tr#'+idP)[0], 9, false  ); 
		    	        	oTableDefault.fnUpdate(datos.min_tardanza, $('tr#'+idP)[0], 10, false  );
		    	        	oTableDefault.fnUpdate(datos.estadoAsist, $('tr#'+idP)[0], 11, false  );
//		    	        	oTableDefault.fnUpdate(estadoAsist, $('tr#'+idP)[0], 8 );		    	        	
//		    	        	$('input', oTableDefault.fnGetNodes($('tr#'+idP)[0])).attr('checked','checked'); 
		    	    		
		    	    		var fecha_asisatencia 	= $("#fechamaAsistencia").val();
		    	    		var idreg				= $("#regimenContractual").val();
		    	    		var ubicacion			= $("#ubicacionPersonal").val();		    	    		
		    				$('#divModalmsg').html(		    						
		    						'<div id="msgIsertsuccess">	<ul id="msgIsertsuccess" class="exitomsg" style="display: block;">' +
		    					                '<li><span>Se Actualizó con éxito</span></li>'+
		    						'</ul></div>');		    				
		    				$( "#divModalmsg" ).dialog({
		    				    height: 'auto',
		    				    width: 'auto',
		    				    title: 'Actualización de Marcación:',
		    				    modal: true,
		    				  	    
		    				    buttons: {
		    				      Aceptar: function() {				    	  
		    				        $( this ).dialog( "close" );
		    				        $("#dte_fec_marc").datepicker("destroy");	
		    				        $("#divModalMarcaciones").dialog('close');
		    				    	$("#divModalMarcacionesE").dialog('close');
		    				        filtraxFecha(fecha_asisatencia, $("#idPersonalM").val(),ubicacion, idreg);
		    				      },		        
		    				    }
		    				  });
		    	    		
		    	    	}else if(msg == 'ERROR'){
		    	    		$("#divModalMarcaciones").dialog('close');
		    	    		
		    				$('#divModalmsg').html(		    						
		    						'<div id="msgIsertsuccess">	<ul id="msgIsertsuccess" class="errormsg" style="display: block;">' +
		    					                '<li><span>A ocurrido un error, vuelva a intentarlo</span></li>'+
		    						'</ul></div>');		    				
		    				$( "#divModalmsg" ).dialog({
		    				    height: 'auto',
		    				    width: 'auto',
		    				    title: 'Actualización de Marcación:',
		    				    modal: true,
		    				  	    
		    				    buttons: {
		    				      Aceptar: function() {	
		    				    	  $("#divModalMarcaciones").dialog('close');		    				    	  
		    				        $( this ).dialog( "close" );
		    				      },		        
		    				    }
		    				  });
		    	    	}		    	    
		    	    	
		    	    },"json");
		        	
		        	$( this ).dialog( "close" );
		        }
		        
		      }
		 });
		
		
		

	}

}


function eliminarPapeleta(){
	var cant 			= 0;
	var srl_id_papeleta	= null;
    var fecha_inicio	= null;
    var fecha_fin		= null;
		
	$("input[name='srl_id_papeleta_p']").each(function(){		
		if($(this).is(":checked")){
		      cant++;
		      srl_id_papeleta 	= $(this).val();
		      var valores		= srl_id_papeleta.split("*");
		      srl_id_papeleta	= valores[0];
		      fecha_inicio		= valores[1];
		      fecha_fin			= valores[2];
		}
	});	
	
	
	if(cant != 1){		
		$( "#dialog-info-Papeleta" ).dialog({
		      width: 'auto',
		      title: 'Eliminar Papeleta:',
		      modal: true,
		      buttons: {
		        Aceptar: function() {
		          $( this ).dialog( "close" );
		        },		        
		      }
		    });
		return;	
	}			


	var idPersonal		= $("#idpersonal_marc").val();

	$( "#dialog-form" ).dialog({
	      width	:'auto',
	      title: 'Eliminar Papeleta:',
	      modal: true,
	      buttons: {
	    	'No': function(){
		       	$( this ).dialog( "close" );
			     return;
		    },
	        'Sí': function() {
	        	
		    	$.post("eliminarPapeleta.action", {idPersonal : idPersonal, idPapeleta : srl_id_papeleta, f_inicioVac : fecha_inicio, f_finVac : fecha_fin, isajax : 1, dte_fec_marc :fecha_inicio }, function(data){
		    		var msgResult = data.search("msgIsertsuccess");

		    		if (data.length > 0){
		    			
		    			$('#divModalmsg').html(data);
		    			
		    			$( "#divModalmsg" ).dialog({
		    			    height: 'auto',
		    			    width: 'auto',
		    			    title: 'Registro de papeletas:',
		    			    modal: true,
		    			    buttons: {
		    			      Aceptar: function() {				    	  
		    			        $( this ).dialog( "close" );
		    			      },		        
		    			    }
		    			  });
		    			
		    			if(msgResult > 0){

		    	    		marcacionesxFechaxidPersonal($("#dte_fec_marc").val());
		    	    		papeletasajax('1');
		    			}			
		    		}
		    		
		    	});
	        	
	        	$( this ).dialog( "close" );
	        }
	        
	      }
	 });	
}


function cerrarModalPapeleta(){
	$( "#divModalContenedor" ).dialog( "close" );	 
}



function verPapeletasxidP (){
            
	$( "#divModalContenedor" ).dialog({
	        width:  'auto',
	        height: 'auto',
	        title: 'Lista Papeletas del Personal:',
	        modal: true,
	        closeOnEscape: false,
	        open: function(event, ui) {	$( "#divModalContenedor" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
	        close: function(event, ui) {$("#divListaPapeletas").remove();}
	});	
	
	$.post("papeletaxidP.action", {idPersonal : $("#idpersonal_marc").val(), dte_fec_marc : $("#dte_fec_marc").val(), isajax : 0}, function(data){
			
	    if(data.length > 0){
	    	
//        	17-03-2015 DAVID
	    	if(mostrarModalResultadoSession(data,"#divModalMarcaciones") >  0) 		cerrarSession();//	    		return;
//	    	END DAVID	
	    	
	        $("#divModalContenedor").html(data);
	        $("#divModalContenedor").dialog("option", "position", "center"); 
	    	
	    };
	});	

}

function papeletasajax(val_isajax){

	$.post("papeletaxidP.action", {idPersonal : $("#idpersonal_marc").val(), dte_fec_marc : $("#dte_fec_marc").val(), isajax : val_isajax}, function(data){
		
	    if(data.length > 0){
	    	
//        	17-03-2015 DAVID
	    	if(mostrarModalResultadoSession(data,"") >  0)	cerrarSession(); //return;
//	    	END DAVID		
	    	
	        $("#divListaPapeletas").html(data);
	        $("#divListaPapeletas").dialog("option", "position", "center"); 	    	
	    };
	});		
}







function volveramodalFiltroMarcaciones(){

	$( "#divModalMarcacionesE").dialog('close');
	$( "#divModalMarcacionesE:ui-dialog" ).dialog( "destroy" );     
	$( "#dte_fec_marc").datepicker("destroy");	
	filtraxFecha($("#fechamaAsistencia").val(), $("#idPersonalM").val(),-1, 0);

}





function modalFiltroMarcaciones (){
	
//	var cant 		= 0;
	var idpersonal 	= 0;
	var fecha_asist	= '';
	
	idpersonal = $("#idPersonalM").val();
	/*
	$("input[name='personal.idpersonal']").each(function(){		
		if($(this).is(":checked")){
		      cant++;
		      idpersonal = $(this).val();
		}
	});
		*/
	if(idpersonal <= 0){
//		$("#dialog-info:ui-dialog").dialog('destroy');
		$( "#dialog-info" ).dialog({
			width: 'auto',
		      title: 'Marcaciones del Personal:',
		      modal: true,
		      buttons: {
		        Aceptar: function() {
		          $( this ).dialog( "close" );
		        },		        
		      }
		    });
		return;	
	}else{
		
		fecha_asist	= $("#fechamaAsistencia").val();
//		$("#idPersonalM").val(idpersonal);
		var ubicacion	= $("#ubicacionPersonal").val();
		var idreg		= $("#regimenContractual").val();
		filtraxFecha(fecha_asist, idpersonal, ubicacion, idreg);		
		
	}
};




function marcacionesxFechaxidPersonal(nValor){

	$("#fechamarcacion").val(nValor);
	var idP			= $("#idpersonal_marc").val();
	var ubicacion	= $("#ubicacionPersonal").val();
	var idreg		= $("#regimenContractual").val();
	var estadoAsist	= null;
	if (idreg == '') idreg = 0;
		
	$("div#divListaMarcaciones").load("filtromarcacionesajax.action",{idPersonal : idP, dte_fec_marc : nValor, ubicacionPersonal : ubicacion, idregimenContractual : idreg, isajax : 1},function(data){
		
	  var valores		= $("#estadoAsist").val();
	  valores			= valores.charAt(0);

      if(valores === 'O' || valores === 'I'){
    	  estadoAsist	= '<span style="text-align:left; color:red;">'+$("#estadoAsist").val()+'</span>'; 
      }else if(valores === 'L' || valores === 'V'){
    	  estadoAsist	= '<span style="text-align:left; color:green;">'+$("#estadoAsist").val()+'</span>';
      }else{    		  
    	  estadoAsist	= $("#estadoAsist").val();
      }
	      
		oTableDefault 		= null;
    	oTableDefault 		= $('#tableDefault').dataTable();

    	//Valor, fila, columna
    	oTableDefault.fnUpdate($("#hor_ingreso").val(), $('tr#'+idP)[0], 8, false  );    	
    	oTableDefault.fnUpdate($("#hor_salida").val(), $('tr#'+idP)[0], 9, false  ); 
    	oTableDefault.fnUpdate($("#min_tardanza").val(), $('tr#'+idP)[0], 10, false  );
    	oTableDefault.fnUpdate(estadoAsist, $('tr#'+idP)[0], 11, false  );    	

//    	$('input', oTableDefault.fnGetNodes($('tr#'+idP)[0])).attr('checked','checked');
    	
    	$("#fechamaAsistencia").val(nValor);
		

    	if($("#eliminarMarcacion").val() > 0){			
			$("#btnEditarMarcacion").attr('enabled',"enabled");
			$("#btnEditarMarcacion").removeAttr('disabled',"disabled");
			$("#btnEliminarMarcacion").attr('enabled',"enabled");
			$("#btnEliminarMarcacion").removeAttr('disabled',"disabled");
		}else {
			$("#btnEditarMarcacion").attr('disabled',"disabled");
			$("#btnEditarMarcacion").removeAttr('enabled',"enabled");
			$("#btnEliminarMarcacion").attr('disabled',"disabled");
			$("#btnEliminarMarcacion").removeAttr('enabled',"enabled");
		}
	});
	


}


function cerrarModalMarcaciones(){	
	$( "#dte_fec_marc").datepicker("destroy");	
	$( "#divModalMarcaciones" ).dialog( "close" );	 
}



/*------- MUESTRA MARCACIONES DEL PERSSONAL - POR FECHA ASISTENCIA E IDPERSONAL -------*/

function filtraxFecha(fechamarc, idPersonal, ubicacion, idreg){

	var fecmarc 	= '';
	
	if(fechamarc != ''){
		fecmarc 	= fechamarc;
	}else{
		fecmar = $("#dte_fec_marc").val();
	}

	if(idreg == '') idreg = 0;
	
    var idpersonal	= $("#idPersonalM").val();
    
//	$( "#divModalMarcaciones:ui-dialog" ).dialog( "destroy" );              
	$( "#divModalMarcaciones" ).dialog({
	        width: 'auto',
	        title: 'Lista marcaciones del Personal:',
	        modal: true,
	        closeOnEscape: false,
	        open: function(event, ui) {	$( "#divModalMarcaciones" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
	        close: function(event, ui) {$("#divListaMarcaciones").remove();}
	});
	
	$.post("filtromarcaciones.action", {idPersonal : idpersonal, dte_fec_marc : fecmarc, ubicacionPersonal : ubicacion, idregimenContractual : idreg}, function(data){
		
	    if(data.length > 0){ 	
	    	
//        	17-03-2015 DAVID
	    	if(mostrarModalResultadoSession(data,"#divModalMarcaciones") >  0)	cerrarSession(); //return;
//	    	END DAVID	
    	
	        $("#divModalMarcaciones").html(data);
	        $("#divModalMarcaciones").dialog("option", "position", "center");	        
	        	        
	        vistasinPermiso();	        

    		$('#horasalida').click(function(){
    			$('#horasalida').val('');
    		});
    		
    		$("#horaingreso").mask("Hx:Nn:00");
    		
    		$("#horasalida").mask("Hx:Nn:00");
    		
        	$("#fechaIniM").datepicker({
    			changeMonth: true,           // Si se pueden cambiar los meses
    			changeYear: true,            // Si se pueden cambiar los años
			    onSelect: function(dateText, inst) {			    	
			    	$("#fechaFinM").val($("#fechaIniM").val());
		    		$("#fechaFinM").datepicker("option", "minDate", $("#fechaIniM").val());			    	
			    } 
 			
        	});
			
        	
        	$("#fechaFinM").datepicker({
    			changeMonth: true,           // Si se pueden cambiar los meses
    			changeYear: true            // Si se pueden cambiar los años

        	});  
        	
	    	$("#dte_fec_marc").datepicker({
	    		changeMonth: true,           // Si se pueden cambiar los meses
	    		changeYear: true            // Si se pueden cambiar los años		
	    	});      	
        	
        	
        	
	    };
	});
    
}


function tipoPermiso(nValor){

	$("#horaingreso").val('');
	$("#horasalida").val('');
	$("#fechaIniM").val('');
	$("#fechaFinM").val('');
	
	if(nValor != ''){
		$("#justificacion_marcacion").attr("readonly", false);
		$("#justificacion_marcacion").focus();
		if(nValor == '0' ){

			$("#horaingreso").css("display","none");
			$("#horasalida").css("display","none");
			$("#divhoras").css("display","none");
			$("#divfechas").css("display","block");
			$("#fechaIniM").css("display","block");
			$("#fechaFinM").css("display","block");			

		}else {	

			$("#divfechas").css("display","none");
			$("#fechaIniM").css("display","none");
			$("#fechaFinM").css("display","none");
			$("#divhoras").css("display","block");
			$("#horaingreso").css("display","block");
			$("#horasalida").css("display","block");
		}		
	}else{
		$("#justificacion_marcacion").attr("readonly", true);
		return;
	}


	
}


function generaDescuentos(){
	
	var generaovalida = 0;

	$( "#dialog-info-desc" ).dialog({
	      width	:'auto',
	      title: 'Generación de descuentos:',
	      modal: true,
	      buttons: {
	    	'No': function(){
		       	$( this ).dialog( "close" );
			     return;
		    },
	        'Sí': function() {
	        	
	        	$.post('generaDescuentos.action',{Generaovalida : generaovalida}, function(datos) {
					
    				var msg 		= datos.MsgTrx.toUpperCase();
    				var msgdesc		= "";

    		    	if(msg 			== 'SUCCESS'){
    		    		msgdesc 	= datos.MsgExito;	    
    		    		divMsg 		= $(".msgExito");
    		    		var page 	= 1;		    		
			    		if( page 	!= 'undefined'){
			    			page 	= datos.dtpage;
			    		} 		    	
    		    		$.post('descuentosPersonalRrhhajax.action', {'d-16544-p':page}, function(datos) {
    		    			if(datos.length > 0){   
    		    				
    		    				$("#DivListadoPersonalDescuento").html(datos);	
    		    			}
    		    			    		    			
    		    		});
    		    		
	
    		    	}else if(msg 	== 'ERROR'){
    		    		msgdesc 	= datos.MsgErr;
    		    		divMsg		= $(".msgError");   		  
    		    	}
    		    	
    		    	divMsg.text(msgdesc);
    		    	    	
    		    	divMsg.css("z-Index","1100");
    		    	divMsg.center();
    		    	setTimeout(function(){ divMsg.fadeIn(300).fadeOut(8800);}, 0);        		    			
  		    	
    		    },"json");
	        	
	        	$( this ).dialog( "close" );
	        }
	        
	      }
	 });
}





function actualizarListaPersonalDescuento(n){ 

	var page 	= $("#dtpage").val();
	var apepat	= $("#apellidoTrabajadordesc").val();
	if(apepat != ""){
		if( page == '') page = 1;

		$("div#DivListadoPersonalDescuento").load("descuentosPersonalRrhhajax.action", { 'd-16544-p':page }, $.displaytag.onPeopleTableLoad);

	}
	
};



function filtraApellidosOfDescuento(){
	
	var aPaterno  = $("#apellidoTrabajadordesc").val();
	var page 	= $("#dtpage").val();
	if( page == '') page = 1;
	
	$("div#DivListadoPersonalDescuento").load("descuentosPersonalRrhhajax.action", {'d-16544-p':page, aPaterno : aPaterno}, $.displaytag.onPeopleTableLoad);
//	$("div#DivListadoPersonalDescuento").load("descuentosPersonalRrhh.action", {'d-16544-p':page, aPaterno : aPaterno}, $.displaytag.onPeopleTableLoad);

}


function filtrarDescuentosxperiodo(){
	
	$("#isajax").val('1');
	
	filtraApellidosOfDescuentoInicial();		
}


function filtraApellidosOfDescuentoInicial(){	
	
	var aPaterno  	= $("#apellidoTrabajadordesc").val();
	var page 		= $("#dtpage").val();	
	var descV		= $("#descV").val();
	var periododesc	= $("#periododesc").val();
	var mesdesc		= $("#mesdesc").val();
	var idreg		= $("#regimenContractualD").val();
	var ubicacion	= $("#ubicacionPersonalDesc").val();
	var areantural	= $("#listANPDesc").val();
	var isajax		= $("#isajax").val();
	$("#isajax").val('0');
	
		
	if( page == '') page = 1;

	$('#loadAjax').modal('toggle');
	
//	$("div#DivListadoPersonalDescuento").load("descuentosPersonalRrhhajax.action", {'d-16544-p':page, aPaterno : aPaterno, descValidados : descV, idregimenContractual : idreg, 
//		periododesc : periododesc, mesdesc : mesdesc, ubicacionPersonal : ubicacion, idANP : areantural, isajax : isajax}, function(){		
	$.post("descuentosPersonalRrhhajax.action", {'d-16544-p':page, aPaterno : aPaterno, descValidados : descV, idregimenContractual : idreg, 
		periododesc : periododesc, mesdesc : mesdesc, ubicacionPersonal : ubicacion, idANP : areantural, isajax : isajax}, function(data){	
//		 	17-03-2015 DAVID
		   	if(mostrarModalResultadoSession(data,"") >  0)	cerrarSession(); //return;		   	
//		   	END DAVID		
		if(data.length > 0 ){
			
			$("div#DivListadoPersonalDescuento").html(data);
			
			 $("#periodofcontdesc").text($("#periodofcontdeschidden").val());
			 $("#mesofcontdesc").text($("#mesofcontdeschidden").val());
			 $("#periodoefectuadesc").text($("#periodoefectuadeschidden").val());
			 $("#mesofefectuadesc").text($("#mesofefectuadeschidden").val());

			 if($("#descV").val() > 0){
				$("#btnValidarDescuentos").attr('value',"REPORTE DESCUENTOS CERRADO");			    	    		    		
				$("#btnValidarDescuentos").attr('class','btn btn-primary  pull-right');
				$("#btnValidarDescuentos").attr('id',"btnDescuentosCerrado");	

			 }else{
				$("#btnDescuentosCerrado").attr('value',"Cerrar reporte Descuentos");			    	    		    		
				$("#btnDescuentosCerrado").attr('class','btn btn-primary  pull-right');
				$("#btnDescuentosCerrado").attr('id',"btnValidarDescuentos");
			 }		 
			 
			$('#loadAjax').modal('toggle');		

		}			
		
	});
	

	
	

}

function obtenerRegimen(nval){
	
	var idreg		= $("#regimenContractualD").val();
	var descV		= $("#descV").val();
	var periododesc	= $("#periododesc").val();
	var mesdesc		= $("#mesdesc").val();
	var ubicacion	= $("#ubicacionPersonalDesc").val();
	var areantural	= $("#listANPDesc").val();
	var href 		= '/personal/downloadreportedecuentos'+nval+'.action';

	href 			= href + '?descValidados='+descV+'&idregimenContractual='+idreg+'&periododesc='+periododesc+'&mesdesc='+mesdesc+'&ubicacionPersonal='+ubicacion+'&idANP='+areantural+'&isajax=1';

	if(nval != ''){
		$("#xlsLink").attr('href',href);
	}else{
		$("#pdfLink").attr('href',href);	
	}
	

}



function validarDescuentos(){
	var generaovalida = 1;
	
	var periododesc	= $("#periododesc").val();
	var mesdesc		= $("#mesdesc").val();
	var idRegimen	= $("#regimenContractualD").val();
	var ubicacion	= $("#ubicacionPersonalDesc").val();
	var areantural	= $("#listANPDesc").val();
	
	if($("#cantDescuentos").val() == 0){
		 alert("No éxiste Descuentos para CERRAR.");
		 return;
 	}	
	
	$("#dialog-info-descvalidar").dialog({
//	      resizable: false,
//	      width	:380,
	      width : 'auto',
	      height:'auto',
	      title: 'Validación de descuentos:',
	      modal: true,
	      buttons: {
		    	'No': function(){
			       	$( this ).dialog( "close" );
				     return;
			    },
			        'Sí': function() {			        	
			        	
			        	$("#dialog-info-descvalidar2").dialog({
//			      	      resizable: false,
			      	      width : 'auto',
//			      	      height:'auto',
			      	      title: 'Validación de descuentos:',
			      	      modal: true,
			      	      buttons: {
			      		    	'No': function(){
			      			       	$( this ).dialog( "close" );
			      				     return;
			      			    },
			      		        'Sí': function() {
			      		        	$('#loadAjax').modal('toggle');
			      		        	var page 	= $("#dtpage").val();
			      		        	if( page == '') page = 1;
			      		        	
			    		        	$.post('validaDescuentos.action',{Generaovalida : generaovalida, idregimenContractual : idRegimen, periododesc : periododesc, 
			    		        			mesdesc : mesdesc, ubicacionPersonal : ubicacion, idANP : areantural}, function(datos) {
			    		        				
//			    		        		17-03-2015 DAVID
			    		        		if(mostrarModalResultadoSession(datos.MsgTrx.toString(),"") >  0)	cerrarSession(); //return;		   	
//			    		        		END DAVID
			    		        		
			    		        		$('#loadAjax').modal('toggle');

			    	    				var msg = datos.MsgTrx.toUpperCase();			
			    	    				
			    	    		    	if(msg == 'SUCCESS'){
			    	    		    		var msgdesc = datos.MsgExito;	    
			    	    		    		divMsg 		= $(".msgExito");
			    	    		    		divMsg.text(msgdesc);			    	    		    		
			    	    		    		alert(msgdesc);
			    	    		    		$("div#DivListadoPersonalDescuento").load("descuentosPersonalRrhhajax.action", { 'd-16544-p':page, descValidados : 1, 
			    	    		    			idregimenContractual : idRegimen, periododesc : periododesc, mesdesc : mesdesc, ubicacionPersonal : ubicacion, idANP : areantural}, $.displaytag.onPeopleTableLoad);
			    	    		    		
			    	    		    		$("#descV").val(1);
			    	    		    		$("#btnValidarDescuentos").attr('value',"REPORTE DESCUENTOS CERRADO");			    	    		    		
			    	    		    		$("#btnValidarDescuentos").attr('class','btn btn-primary  pull-right');
			    	    		    		$("#btnValidarDescuentos").attr('id',"btnDescuentosCerrado");
			    			
			    	    		    	}else if(msg == 'ERROR'){
			    	    		    		var msgdp 	= datos.MsgErr;
			    	    		    		divMsg 		= $(".msgError");
			    	    		    		divMsg.text(msgdp);
			    	    		    		alert(msgdp);
			    	    		    	}
			    	    		    	
			    	    		    	    	
			    	    		    	divMsg.css("z-Index","1100");
			    	    		    	divMsg.center();
			    	    		    	setTimeout(function(){ divMsg.fadeIn(300).fadeOut(8800);}, 0);        		    			
			    	  		    	
			    	    		    },"json");
			    		        	
			    		        	$( this ).dialog( "close" );
	
			      		        }
			      		        
			      		      }
			      		
			        	});		        	
			        	$( this ).dialog( "close" );
		        }
		        
		      }
		
	});
	
}




function mostrarinasistenciaspermisos(idP) {

	var periododesc	= $("#periododesc").val();
	var mesdesc		= $("#mesdesc").val();	
	var ubicacion	= $("#ubicacionPersonalDesc").val();
	var idreg		= $("#regimenContractualD").val();	
	var fechaAsist	= null;
	fechaAsist		= $("#fechamaAsistencia").val();
	
	if(idreg == '') idreg = 0;	
	
	if($("#fechamaAsistencia").val() !== undefined ){	

		$('#divModalContenedor').dialog({
			width: 'auto',
			height: 'auto',
			title: 'Lista de Inasistencias / Permisos:',
			modal: true,
			closeOnEscape: false,
			open: function(event, ui) {$('#divModalContenedor').html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");}
		});
		
		$.post('inasistenciaspermisosPersonal.action',{idPersonal : idP, periododesc : periododesc, mesdesc : mesdesc, ubicacionPersonal : ubicacion, idregimenContractual : idreg, dte_fec_marc : fechaAsist}, function(datos){
			if(datos.length > 0){
//			 	17-03-2015 DAVID
			   	if(mostrarModalResultadoSession(datos,"") >  0)	cerrarSession(); //return;		   	
//			   	END DAVID		
				
				$('#divModalContenedor').html(datos);
				$("#divModalContenedor").dialog("option", "position", "center");
			}
			
		});
	}else{

		$('#Divmodalinasistenciaspermisos').dialog({
			width: 'auto',
			height: 'auto',
			title: 'Lista de Inasistencias / Permisos:',
			modal: true,
			closeOnEscape: false,
			open: function(event, ui) {$('#Divmodalinasistenciaspermisos').html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");}
		});
		
		$.post('inasistenciaspermisosPersonal.action',{idPersonal : idP, periododesc : periododesc, mesdesc : mesdesc, ubicacionPersonal : ubicacion, idregimenContractual : idreg, dte_fec_marc : fechaAsist}, function(datos){
			if(datos.length > 0){
//			 	17-03-2015 DAVID
			   	if(mostrarModalResultadoSession(datos,"") >  0)	cerrarSession(); //return;		   	
//			   	END DAVID	
				$('#Divmodalinasistenciaspermisos').html(datos);
				$("#Divmodalinasistenciaspermisos").dialog("option", "position", "center");
			}
			
		});

	}	    
}






function dialogImportaArchivo(){
	
	$.post("formularioupload.action", "", function(data){
		
		$("#divModalImportarArchivo").html(data);
	});
	
	$( "#divModalImportarArchivo:ui-dialog" ).dialog( "destroy" );              
	$( "#divModalImportarArchivo" ).dialog({
		width: 390,
		height: 'auto',
		title: 'Importar Archivo txt del Relog:',
		modal: true,                    
		closeOnEscape: false,     
		open: function(event, ui)  {$(this).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
		close: function(event, ui) {$("#divContentUpload").remove();},
     
	    buttons: {        

	           Importar: function() {
	        	   
	        	   if ($('#archivoAdjunto').val().length == 0){
	        		   alert("Seleccione su Archivo.");
	        		   return false;
	        	   };
	        	   
	        	   $('#frmupload').attr("action","frmuploadTxtRelog.action");
	        	   $('#frmupload').attr("method","post");
	        	   
	        	   var options = {
	               		target      : '#divModalImportarArchivo',
	                    beforeSubmit: showRequest,
	                    success		: showResponse
	        	   };
	        	   
	               $('#frmupload').ajaxSubmit(options);


	               function showRequest() {

	            	   $('#divModalImportarArchivo:ui-dialog' ).dialog('destroy');	            	   
	               	   $('#divModalImportarArchivo').dialog({
		               	    modal			: true,	
		               	    height			: 'auto',
		               	    width			: 'auto',
		               	    title			: 'Resultado',
		               	    closeOnEscape	: false,
		            		overflow		: scroll,
		               	    open			: function() {
		               	    	$(this).closest(".ui-dialog").find(".ui-dialog-titlebar:first").hide(); 
		               	    	$( this ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Importando...!!!</i>");		               	    	
		               	    }	               	   
	             	    }); 

	               	    return true;
	               }
	               
	               
	          	 function showResponse(responseText, statusText){ 
	          		 
	          		var bool = $("#divModalImportarArchivo #msgExcel").hasClass('exitomsg');

	          		if(bool){	          			
	          			
	          			$('#divModalImportarArchivo').dialog('option','buttons',{	          				          			
	          				'Aceptar': function() {
	          					$('#divModalImportarArchivo').dialog('close');
	          					var fechamaAsistencia 	= $("#fechamaAsistencia").val();
	          		    		var irdreg				= $("#regimenContractual").val();
	          		    		var aPaterno  			= $("#apellidoTrabajador").val();  
	          		    		var ubicacion			= $("#ubicacionPersonal").val();
	          					
	          					$('#loadAjax').modal('toggle');
	          					$("div#DivListadoPersonal").load("listadoPersonalRrhhAjax.action", {'d-16544-p':1, aPaterno : aPaterno, dte_fec_asist : fechamaAsistencia, 
	          						idregimenContractual: irdreg, ubicacionPesonal : ubicacion, isajax : 1}, function(){
	          						$('#loadAjax').modal('toggle');	
	          					});
	          					

	          				}
	          			});          			
			    		
	          		}else{	          		
	          			$('#divModalImportarArchivo').dialog('option','buttons',{	          				          			
	          				'Aceptar': function() {
	          					$('#divModalImportarArchivo').dialog('close');
	          					return false;
	          				}
	          			}); 	          		
	
	          		}	          		
	          			          		
	               } 	          	 
	        }
	    }
	});

	
};




function dialogImportaArchivoExcel(){

	$.post("formularioupload.action", "", function(data){
	
		$("#divModalImportarArchivo").html(data);
	});
	
	$( "#divModalImportarArchivo:ui-dialog" ).dialog( "destroy" );              
	$( "#divModalImportarArchivo" ).dialog({
		width: 390,
		height: 180,
		title: 'Importar Archivo Excel:',
		modal: true,                    
		closeOnEscape: false,     
		open: function(event, ui)  {$( this ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
		close: function(event, ui) {$("#divContentUpload").remove();},
     
	    buttons: {	 
	           Importar: function() {
	        	   
	        	   if ($('#archivoAdjunto').val().length == 0){
	        		   alert("Seleccione su Archivo.");
	        		   return false;
	        	   };

	        	   $('#frmupload').attr("action","frmuploadPersonalExcel.action");
	        	   $('#frmupload').attr("method","post");
	        	   
	        	   var options = {
	               		target      : '#divModalImportarArchivo',
	                    beforeSubmit: showRequest,
	                    success		: showResponse
//	                    async		:false
	                    //success     : showResponse	                    
	        	   };
	        	   
	            	   $('#frmupload').ajaxSubmit(options);	
	            	   
	               function showRequest() {
	            	   $('#divModalImportarArchivo:ui-dialog' ).dialog('destroy');
	               	   $('#divModalImportarArchivo').dialog({
		               	    modal			: true,	
		               	    width: 'auto',
		               	    title			: 'Resultado',
		               	    closeOnEscape	: false,
		            		overflow		: scroll,
		               	    open			: function() {
		               	    	$(this).closest(".ui-dialog").find(".ui-dialog-titlebar:first").hide(); 
		               	    	$( "#divModalImportarArchivo" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Importando...!!!</i>");
		               	    	}
	             	    });
	               	   
	               	    return true;
	               }
	               
	          	 function showResponse(){
 
	          			$('#divModalImportarArchivo').dialog('option','buttons',{	          				          			
	          				'Aceptar': function() {
	          					$('#divModalImportarArchivo').dialog('close');
	          					
	          					if( page == '') page = 1;
	    			    		
	    			    		$.post('listadoPersonalRrhhAjax.action', {'d-16544-p':page}, function(datos) {
	    			    					    					    			
	    			    			$("#DivListadoPersonal").html(datos);
	    			    			
	    			    		});
	          				}
	          			});	          		 
	               }
	           }
	       }
		});
};


function listaPersonal(){
	
	$.post('listadoPersonalRrhh.action', {'d-16544-p':page}, function(datos) {
		
		$("#DivListadoPersonal").html(datos);
		
	});
}






/*---------------------------------ROL DE VACACIONES--------------------------------------------------*/

function listapersonalVacacionesxApepatperiodo(){

	var aPaterno	= $("#apellidoTrabajadorVac").val();
	var page 		= $("#dtpage").val();	
	var xperiodo	= $("#listVacPeriodo").val();
	var idregc		= $("#regimenContractualV").val();
	var ubicacion	= $("#ubicacionPersonalVac").val();
	var areantural	= $("#listANPVac").val();
	var estadoP		= $("#estadoPersonal").val();
	
	if( page == '') page = 1;
	
	$('#loadAjax').modal('toggle');
	$.post("listapersonalVacacionesajax.action", {'d-16544-p':page, periodoVacaciones : xperiodo, aPaterno : aPaterno, 
		idregimenContractual : idregc, ubicacionPersonal : ubicacion, idANP : areantural, estadoPersonal : estadoP}, function(data){

//		 	17-03-2015 DAVID
		   	if(mostrarModalResultadoSession(data,"") >  0)	cerrarSession(); //return;		   	
//		   	END DAVID					
		   	$("div#DivListadoPersonalVacaciones").html(data);
			$('#loadAjax').modal('toggle');	
	});
	
//	$("div#DivListadoPersonalVacaciones").load("listapersonalVacacionesajax.action", {'d-16544-p':page, periodoVacaciones : xperiodo, aPaterno : aPaterno, 
//			idregimenContractual : idregc, ubicacionPersonal : ubicacion, idANP : areantural, estadoPersonal : estadoP}, function(data){
//		$('#loadAjax').modal('toggle');		

//	});
	
}

function listapersonalVacacionesxApepatperiodoSoloNombres(){

	var aPaterno	= $("#apellidoTrabajadorVac").val();
	var page 		= $("#dtpage").val();	
	var xperiodo	= $("#listVacPeriodo").val();
	var idregc		= $("#regimenContractualV").val();

	if( page == '') page = 1;	

	$("div#DivListadoPersonalVacaciones").load("listapersonalVacacionesajax.action", {'d-16544-p':page, periodoVacaciones : xperiodo, aPaterno : aPaterno, idregimenContractual : idregc}, function(){
	});
	
}


function actualizarListaPersonalVacaciones(n){ 

	var page 		= $("#dtpage").val();
	var apepat		= $("#apellidoTrabajadorVac").val();
	var xperiodo	= $("#listVacPeriodo").val();
	if(apepat != ""){
		if( page == '') page = 1;

		$("div#DivListadoPersonalVacaciones").load("listapersonalVacacionesajax.action", { 'd-16544-p':page, periodoVacaciones : xperiodo }, $.displaytag.onPeopleTableLoad);

	}
	
};


function vacacionesPendientesxidPersonal(idP){
//	var xperiodo	= $("#listVacPeriodo").val();
	
	$.post('vacacionesPendientesxidPersonal.action',{idPersonal : idP}, function(datos){
		if(datos.length > 0){
			
//        	17-03-2015 DAVID
	    	if(mostrarModalResultadoSession(datos,"#divModalContenedorVacaciones") >  0)	cerrarSession(); //return;
//	    	END DAVID	
			
			$('#divModalContenedorVacaciones').html(datos);		
			$( "#divModalContenedorVacaciones" ).dialog({
//			    resizable: false,
			    height: 'auto',
			    width: 'auto',
			    title: 'Lista de  Vacaciones pendientes:',
			    modal: true,
			  	    
			    buttons: {
			      Aceptar: function() {				    	  
			        $( this ).dialog( "close" );
			      },		        
			    }
			  });
			
		}
		
	});
}


function cerrarModalVacaciones(){	
	
	$( "#DivmodalVacaciones" ).dialog( "close" );	 
}




function programarVacaciones(idP,isajax) {

	var xperiodo	= 0;
	
//	if(xperiodo < 0){
//		alert('Seleccione Periodo');
//		return;
//	}	

	if (isajax === undefined || isajax == 0){
		//$('#DivmodalVacaciones').dialog('destroy');
		$('#DivmodalVacaciones').dialog({
			width: '700',
			height: 'auto',
			title: 'Programación de Vacaciones:',
			modal: true,
			closeOnEscape: false,
			open: function(event, ui) {$('#DivmodalVacaciones').html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
			close: function(event, ui) {$("#divListaVacaciones").remove();}

		});	
		xperiodo	= $("#listVacPeriodo").val();
	}else{
		xperiodo	= $("#periodoVacaciones").val();
	}

	$.post('vacacionesPersonal.action',{idPersonal : idP, periodoVacaciones : xperiodo, isajax : isajax}, function(datos){
		
		if(datos.length > 0){
			
//        	17-03-2015 DAVID
	    	if(mostrarModalResultadoSession(datos,"#DivmodalVacaciones") >  0)	cerrarSession(); //return;
//	    	END DAVID				
			if(isajax === undefined  || isajax == 0){					
				
				$('#DivmodalVacaciones').html(datos);
				$("#DivmodalVacaciones").dialog("option", "position", "center");
			}else{				
				
	//	    	var f_inicio_Vac	= null;
	//	    	var f_fin_Vac 		= null;
	//	    	var idPersonalVac	= $("#idPersonalVacaciones").val();
	//	    	var periodoVac		= $("#periodoVacaciones").val();
	//	    	$("#listVacPeriodo").val($("#periodoVacaciones").val());
	//	    	
	//    		oTableDefault 		= null;
	//	    	oTableDefault 		= $('#tableDefault').dataTable();
	//
	//	    	//Valor, fila, columna
	//	    	oTableDefault.fnUpdate($("#f_inicioVac_dataTable").val() , $('tr#'+idP)[0], 5 );
	//	    	oTableDefault.fnUpdate($("#diasCorresponde_dataTable").val() - $("#diasGoce_dataTable").val() , $('tr#'+idP)[0], 6 ); 
	//	    	oTableDefault.fnUpdate($("#diasGoce_dataTable").val() , $('tr#'+idP)[0], 7 );	    	
		    	
	//	    	f_inicioVac_dataTable,	diasCorresponde_dataTable, diasGoce_dataTable
		    	
//		    	if($("#f_inicioProgVac").val() !== undefined ){
//					var lastfinVac  	= limitarFecha($("#f_inicioProgVac").val());
//					
//		    		$("#f_inicioProgVac").datepicker({
//		    			changeMonth: true,           // Si se pueden cambiar los meses
//		    			changeYear: true,            // Si se pueden cambiar los años
//		    			minDate: lastfinVac
//	
//		    		});
//		    	}
//		    	
				
				$('#view_vacaciones').html(datos);
				$("#DivmodalVacaciones").dialog("option", "position", "center");
		    	
		    	if($("#f_inicioVac").val() !== undefined ){
					var lastfinVac  	= limitarFecha($("#f_inicioVac").val());
					
		    		$("#f_inicioVac").datepicker({
		    			changeMonth: true,           // Si se pueden cambiar los meses
		    			changeYear: true,            // Si se pueden cambiar los años
		    			minDate: lastfinVac,
		    			onSelect: function(dateText, inst) {
	//	    		    	f_inicio_Vac	= $("#f_inicioVac").val();
	//	    		    	f_fin_Vac 		= $("#f_finVac").val();
	//	    		    	console.log(f_inicio_Vac +", "+ f_fin_Vac);
		    		    	cantdiasentre2fechas($("#f_inicioVac").val(), $("#f_finVac").val(), $("#idPersonalVacaciones").val(), $("#periodoVacaciones").val(), '', $("#cantDiasVac").val());//0, es porque no se ingresa / cambia el número de días a programar
		    		    }
		    		});
		    	}
				
				if($("#f_finVac").val() !== undefined ){
					var daylastfinVacP 	= limitarFecha($("#f_finVac").val());		    		
	    		
			    	$('#f_finVac').datepicker({
						changeMonth: true,           // Si se pueden cambiar los meses
						changeYear: true,            // Si se pueden cambiar los años
						minDate: daylastfinVacP,
					    onSelect: function(dateText, inst) {
	//				    	f_inicio_Vac	= $("#f_inicioVac").val();
	//				    	f_fin_Vac 		= $("#f_finVac").val();
					    	cantdiasentre2fechas($("#f_inicioVac").val(), $("#f_finVac").val(), $("#idPersonalVacaciones").val(), $("#periodoVacaciones").val(), '', 0 );//0, es porque no se ingresa / cambia el número de días a programar
					    }    			
			    	});
				}
				
		    	$("#listVacPeriodo").val($("#periodoVacaciones").val());
		    	
	    		oTableDefault 		= null;
		    	oTableDefault 		= $('#tableDefault').dataTable();

		    	//Valor, fila, columna, recargar - redraw
		    	oTableDefault.fnUpdate($("#f_inicioVac_dataTable").val() , $('tr#'+idP)[0], 9, false  );
		    	oTableDefault.fnUpdate($("#diasCorresponde_dataTable").val() - $("#diasGoce_dataTable").val() , $('tr#'+idP)[0], 10, false  ); 
		    	oTableDefault.fnUpdate($("#diasGoce_dataTable").val() , $('tr#'+idP)[0], 11, false  );				
			}
			
	
			
		}
		
	});
    
}


function Vacaciones_fnUdatedataTable(){	
	oTableDefault 		= null;
	oTableDefault 		= $('#tableDefault').dataTable();	
	//Valor, fila, columna, recargar - redraw
	oTableDefault.fnUpdate($("#f_inicioVac_dataTable").val() , $('tr#'+idP)[0], 9, false  );
	oTableDefault.fnUpdate($("#diasCorresponde_dataTable").val() - $("#diasGoce_dataTable").val() , $('tr#'+idP)[0],10, false  ); 
	oTableDefault.fnUpdate($("#diasGoce_dataTable").val() , $('tr#'+idP)[0], 11, false  );
}

function btnInsertaVacaciones(){	

	var diasPendientes	= $("#cantDiasVacPendientes").val();
	if(diasPendientes < 0 || $("#f_finVac").val() == ''){
		dialogVacacionesInconsistentes();
		return;
	}
	
	Valid.init($('#formRegistroVacaciones').find(".valid"));
	

	if(!Valid.test()){		
		$("#formRegistroVacaciones .v_label").css("display","inline");
		return;
	}
	
	
//	if(diasPrograVac >= 7 && (diasPendientes >= 7 || diasPendientes == 0)){
		
		var params = $('#formRegistroVacaciones').serialize();
		$.post('insertarVacacionesPersonal.action', params, function(data) {
//        	17-03-2015 DAVID
	    	if(mostrarModalResultadoSession(data,"") >  0)	cerrarSession(); //return;
//	    	END DAVID	
			
			var msgResult = data.search("msgIsertsuccess");

			if (data.length > 0){				
				if(msgResult > 0){		    		
		    		$("#listVacPeriodo").val($("#periodoVacaciones").val());		    		
		    		//Para cargar el modal, con la data actualizada
		    		programarVacaciones($("#idPersonalVacaciones").val(), 1);	
				}
				$('#divModalContenedorVacaciones').html(data);					
				dialogmsgVacciones();
			}
		});			

//	}else{
//		dialogVacacionesInconsistentes();
//		return;
//	}		

}


function programaVacacionesEliminar(idV, idVG, finicioVacaciones, ffinVacaciones){
	
	var xperiodo		= $("#periodoVacaciones").val();
	var idPer			= $("#idPersonalVacaciones").val();
	var idregc			= $("#regimenContractualV").val();
	var ubicacion		= $("#ubicacionPersonalVac").val();
	

//	$('#dialog-info-vacerrar').dialog('destroy');
	$('#dialog-info-eliminar').dialog({
		width: 'auto',
//		height: 'auto',
		title: 'Eliminar Vacaciones programadas:',
		modal: true,
		closeOnEscape: false,
	      buttons: {
		        'No': function(){
		        	$( this ).dialog( "close" );
		        	return;
		        },
		        'Si': function() {
		        	
		        	$.post('eliminarVacacionesProgramadas.action',{idVacaciones : idV, idVacacionesGoce : idVG, periodoVacaciones : xperiodo, 
		        		idPersonal : idPer, f_inicioVac : finicioVacaciones, f_finVac : ffinVacaciones, idregimenContractual : idregc, ubicacionPersonal : ubicacion }, function(datos){
		        	
//		        	    	17-03-2015 DAVID
		        	    	if(mostrarModalResultadoSession(datos,"#dialog-info-eliminar") >  0)	cerrarSession();  //return;
//		        	    	END DAVID	
						
						var msgResult = datos.search("msgIsertsuccess");

						if (datos.length > 0){							
							if(msgResult > 0){     
		        				$("#listVacPeriodo").val($("#periodoVacaciones").val());	        				

		    		    		//Para cargar el modal, con la data actualizada
		    		    		programarVacaciones($("#idPersonalVacaciones").val(),1);

							}
							$('#divModalContenedorVacaciones').html(datos);
							dialogmsgVacciones();
						}
		        	});
	
		          $( this ).dialog( "close" );
		          
		        }
		      }
		
	});	

}




function programaVacacionesCerrar(idV, idVG){

//	$('#dialog-info-vacerrar').dialog('destroy');
	$('#dialog-info-vacerrar').dialog({
		width: 'auto',
//		height: 'auto',
		title: 'Aprobar goce de Vacaciones programadas:',
		modal: true,
		closeOnEscape: false,
	      buttons: {
		        'No': function(){
		        	$( this ).dialog( "close" );
		        	return;
		        },
		        'Si': function() {
		        	$.post('updateVacacionesPersonal.action',{idVacaciones : idV, idVacacionesGoce : idVG}, function(datos){
//	        	    	17-03-2015 DAVID
	        	    	if(mostrarModalResultadoSession(datos,"#dialog-info-vacerrar") >  0)	cerrarSession(); //return;
//	        	    	END DAVID	
						
						var msgResult = datos.search("msgIsertsuccess");

						if (datos.length > 0){							
							if(msgResult > 0){     
		        				$("#listVacPeriodo").val($("#periodoVacaciones").val());	        				
		    		    		//Para cargar el modal, con la data actualizada
		    		    		programarVacaciones($("#idPersonalVacaciones").val(), 1);

							}
							
							$('#divModalContenedorVacaciones').html(datos);
							dialogmsgVacciones();
				
						}
		        	});
	
		          $( this ).dialog( "close" );
		          
		        }
		      }
		
	});	

}


function dialogmsgVacciones(){	
	
	$('#divModalContenedorVacaciones' ).dialog({
//	    resizable: false,
//	    height: 'auto',
	    width: 'auto',
	    title: 'Programación de vacaciones:',
	    modal: true,
	    closeOnEscape: false,
	  	    
	    buttons: {
	      Aceptar: function() {				    	  
	        $( this ).dialog( "close" );
	      },		        
	    }
	  });
}

function dialogVacacionesInconsistentes (){
	$( "#dialog-info-vac" ).dialog({
//	    resizable: false,
//	    height:140,
	    width: 'auto',
	    title: 'Programación de vacaciones:',
	    modal: true,
	  	    
	    buttons: {
	      Aceptar: function() {
	        $( this ).dialog( "close" );
	      },		        
	    }
	  });	
}







function cambiarFechafinProgVac(idvista){
	var f_inicio 	= $("#f_inicioVac"+idvista).val();
	var f_fin 		= $("#f_finVac"+idvista).val();
	var xperiodo	= $("#periodoVacaciones"+idvista).val();
	var idP			= $("#idPersonalVacaciones"+idvista).val();
	var cantdias	= $("#cantDiasVac"+idvista).val();

	if(window.event)	event = window.event;		

	//Estos valores son aplicables para el evento keyup
	if((event.keyCode >= 96 && event.keyCode <= 105) || (cantdias >= 1)){
		if(cantdias.length == 1  &&  (cantdias == 0 )){
			$("#cantDiasVac"+idvista).val('');
			$("#f_finVac"+idvista).val('');
			return;
		}
		
		if (cantdias >= 1 ){

			cantdiasentre2fechas(f_inicio, f_fin, idP, xperiodo, idvista, cantdias );
		}else {
			$("#cantDiasVac"+idvista).val('');
			$("#cantDiasVacPendientes"+idvista).val('');
			$("#f_finVac"+idvista).val('');
		}	
	}else if(event.keyCode == 8){
		if (cantdias == 0 ){
			$("#cantDiasVac"+idvista).val('');
			$("#cantDiasVacPendientes"+idvista).val('');
			$("#f_finVac"+idvista).val('');
		}
	}	
			
}




function cantdiasentre2fechas(f_inicio, f_fin, idPersonalVac, periodoVac, idvista, xdiasProg){
	
//	console.log(f_inicio +","+ f_fin+","+ idPersonalVac+","+ periodoVac+","+ idvista+","+ xdiasProg);
//	if(xdiasProg > 0){
		$.post('cantdiasentre2fechas.action', {f_inicioVac : f_inicio, f_finVac : f_fin, idPersonal : idPersonalVac, periodoVacaciones : periodoVac, ndiasProgVac : xdiasProg}, function(datos) {
			var msg 	= datos.MsgTrx.toUpperCase();
//			console.log("msg --> " + msg);
			
			if(msg != 'NONE'){

				if(datos.ndias > 0 &&  datos.diasPendientes >=  0){
					
					$("#cantDiasVac"+idvista).val(datos.ndias);
					$("#cantDiasVacPendientes"+idvista).val(datos.diasPendientes);
					$("#f_finVac"+idvista).val(datos.fechaFinVacacadd7);			
				}else{
					$("#cantDiasVac"+idvista).val(0);
					$("#cantDiasVacPendientes"+idvista).val(0);
					$("#f_finVac"+idvista).val('');		
				}
				if(msg == 'ERROR'){
					dialogVacacionesInconsistentes();
				}	
				
			}else if(msg == 'NONE'){
				if(datos.ndias > 0){
					$("#cantDiasLic"+idvista).val(datos.ndias);			
					$("#f_finLic"+idvista).val(datos.fechaFinLic);			
				}else{
					$("#cantDiasLic"+idvista).val('');
					$("#f_finLic"+idvista).val('');
				}
			}
	    		    			
		},"json");
	
//	}
	
}



/*---------------FIN VACACIONES-----------------*/





/*---------------------------------LICENCIAS--------------------------------------------------*/

function formLicencias (idP){

		$.post('licenciasPersonal.action',{idPersonal : idP,  fechaAsistenciaLic : $("#fechamaAsistencia").val()}, function(datos){
	
			if(datos.length > 0){
				
//	        	17-03-2015 DAVID
		    	if(mostrarModalResultadoSession(datos,"#divModalLicencias") >  0)	cerrarSession(); //return;
//		    	END DAVID									

				$('#divModalLicencias').html(datos);				
				
		    	var f_inicio_Vac	= null;
		    	var f_fin_Vac 		= null;
		    	
		    	
		    	if($("#fechaFinVacaciones").val() !== undefined )		lastfinLic  	= limitarFecha($("#fechaFinVacaciones").val());
		    	
		    	if($("#f_inicioLic").val() !== undefined ){
		    		$("#f_inicioLic").datepicker({
		    			changeMonth: true,           // Si se pueden cambiar los meses
		    			changeYear: true,            // Si se pueden cambiar los años

		    			onSelect: function(dateText, inst) {
		    		    	f_inicio_Vac	= $("#f_inicioLic").val();
		    		    	f_fin_Vac 		= $("#f_finLic").val();
					// ADD 20-03-2015 17:58
					$( "#f_finLic" ).datepicker( "option", "minDate", dateText );
		    		    	cantdiasentre2fechas(f_inicio_Vac, f_fin_Vac, idP, 0, '', $("#cantDiasLic").val());//0, es porque no se ingresa / cambia el número de días a programar
		    		    }
		    		});
		    	}
				
				if($("#f_finLic").val() !== undefined ){
			    	$('#f_finLic').datepicker({
						changeMonth: true,           // Si se pueden cambiar los meses
						changeYear: true,            // Si se pueden cambiar los años
					    onSelect: function(dateText, inst) {
					    	f_inicio_Vac	= $("#f_inicioLic").val();
					    	f_fin_Vac 		= $("#f_finLic").val();
					    	cantdiasentre2fechas(f_inicio_Vac, f_fin_Vac, idP, 0, '', 0 );//0, es porque no se ingresa / cambia el número de días a programar
					    }    			
			    	});
				}
		    	
		    	
				oTableDefault 		= null;
		    	oTableDefault 		= $('#tableDefault').dataTable();
		    	
		    	//Valor, fila, columna, refresca
		    	
		    	oTableDefault.fnUpdate($("#estadoAsist").val(), $('tr#'+idP)[0], 11, false );

//		    	$('input', oTableDefault.fnGetNodes($('tr#'+idP)[0])).attr('checked','checked'); 		    	

		    	$("#divModalLicencias").dialog("option", "position", "center");		    	
		
			}
			
			creatoTableLicenciasPersonal($("#int_anio_licencia_filtro").val(), $("#int_mes_licencia_filtro").val(), idP, $("#int_tipo_licencia_filtro").val());
			
		});	
		

}


function cerrarModalLicencias(){	
	
	$( "#divModalLicencias" ).dialog( "close" );	 
}


function creatoTableLicenciasPersonal(anio, mes, idp, activ){
	
	oTableLicencias = $('#tableLicencias').dataTable( {
		autoWidth      : false,
	    preDrawCallback: function () {
	        
	        if (!responsiveHelper) {
	            responsiveHelper = new ResponsiveDatatablesHelper(oTableLicencias, breakpointDefinition);
	        }
	    },
	    rowCallback    : function (nRow) {
	        responsiveHelper.createExpandIcon(nRow);
	    },
	    drawCallback   : function (oSettings) {
	        responsiveHelper.respond();
	    },
			"sDom": " <'row' <'col-md-6'l><'col-md-6'p>>  t <'row'<'col-md-12'p i> >",
			bPaginate: true,
		    "aaSorting": [],
		    "oLanguage": {
			   "sUrl": "assets/plugins/datatables/lang/spanish.json"
  		     },
  		   "aLengthMenu": [
  		                 [5, 10, 15, -1],
  		                 [5, 10, 15, "Todos"]
  		             ],
			"sAjaxDataProp": "listResult",
			"sAjaxSource": null,
			"aoColumns" : 
				[ 
				 
				 	{"mData" : "dte_fec_inicio_lic"},
				 	{"mData" : "dte_fec_fin_lic"},	
				 	{"mData" : "int_dias_lic"},	
				 	{"mData" : "var_num_resol_autoriza_lic"},	
				 	{"mData" : "var_des_per_activ"},
				 	{"mData" : "var_descripcion_lic"},
					{"mData" : "srl_id_pers_lic"},
					{"mData" : "int_est_lic"}
				 	
					
				]
			, "aoColumnDefs": [
					 		                  {
					 		                       "aTargets": [6],
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    	   
						 		                    	  var b = '';
							 		                    	
						 		                    	  
							 		                    	 
							 		                    	 if(row.int_est_lic == 1){
							 		                    		 	b = b + '<div title="Confirmar utilización" onclick="cerrarLicencias(' + data  + ')";>';
							 		                    		 	b = b + '<center><img src="img/accepted20.png" border="0" style="cursor: pointer;"/></center>'
							 		                    		 	b = b +  '</div>'; 		
								 		                    }else{
								 		                    		b = '<center>Cerrado</center>';
								 		                    }						 		                    	 
							 		                    	 
							 		                    	   return b;
							 		                    	}
					 		                  },
					 		                  {
					 		                    	"aTargets": [7],
					 		                    	"mData": null,
					 		                    	"mRender": function (data, type, row) {
					 		                    	   
					 		                    	  var b = '';
					 		                    	
					 		                    	  
						 		                    	 
					 		                    	 if(row.int_est_lic == 1){
					 		                    		 var fecha_inicio 	= row.dte_fec_inicio_lic;
					 		                    		 var fecha_fin		= row.dte_fec_fin_lic;
					 		                    		 console.log("Inicio : " + fecha_inicio + " ----- Fin : " + fecha_fin);
					 		                    		 
					 		                    		 	b = b + '<div title="Eliminar licencia" onclick="eliminarLicencias(' + row.srl_id_pers_lic + ',' 
					 		                    		 	+ "'" + fecha_inicio.toString() + "'" + ',' 
					 		                    		 	+ "'" + fecha_fin.toString() + "'" + ')";>';
					 		                    		 	b = b + '<center><img src="img/eraser.png" border="0" style="cursor: pointer;"/></center>'
					 		                    		 	b = b +  '</div>'; 		
					 		                    		 
					 		  
					 		                    		 
						 		                    }				 		                    	 
					 		                    	 
					 		                    	   return b;
					 		                    	}
					 		                  		
					 		                   }
					 		                   
					 		  ],
					 		  
  		   "fnInitComplete": function(oSettings, json) {
  			   
  			 listarlicenciasPersonal(anio, mes, idp, activ);
  			 
  		    },
  		    bFilter: false, 
  		    bInfo: true

	});	
}


function filtrarLicenciasPersonal(){	
	
	console.log("$(int_anio_licencia_filtro).val() --> " + $("#int_anio_licencia_filtro").val());
	listarlicenciasPersonal($("#int_anio_licencia_filtro").val(), $("#int_mes_licencia_filtro").val(), $("#idPersonalLicencia").val(), $("#int_tipo_licencia_filtro").val());
}


function listarlicenciasPersonal(int_anio, int_mes, int_id_personal, int_id_actividad){
	
	parametros = {
			"anio"				: int_anio,
			"mes"				: int_mes,
			"idPersonal"		: int_id_personal,
			"srl_id_actividad"	: int_id_actividad
		 };
	
	
		var json = ajaxReturnJson("/personal/listarLicencias.action","POST","json",parametros);
		
	
		
		oTableLicencias.fnClearTable();

		var oSettings = oTableLicencias.fnSettings();
		
		oTableLicencias.fnClearTable(this);

	    for (var i=0; i<json.listResult.length; i++)
	    {
	    	oTableLicencias.oApi._fnAddData(oSettings, json.listResult[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableLicencias.fnDraw();	
	    
//	    if(mes != ''){
//	    	$("#mesDiasNoLaborables").val(parseInt(mes));	
//	    }
	
	
}


function btnRegistroLicencia() {
	
	var idP	= 0;
	idP		= $("#idPersonalM").val();	

	/*
	var cant		= 0;	
	
	$("input[name='personal.idpersonal']").each(function(){		
		if($(this).is(":checked")){
		      cant++;
		      idP = $(this).val();
		}
	});
	*/
	if(idP <= 0){		
		$( "#dialog-info" ).dialog({
			width: 'auto',
			title: 'Registro de Licencias:',
			modal: true,
			buttons: {
		        Aceptar: function() {
		          $( this ).dialog( "close" );
		        },		        
		      }
		    });
		return;	
	}else{

		$('#divModalLicencias').dialog({
			width: 'auto',
			height: 'auto',
			title: 'Licencias registradas / utilizadas: ',
			modal: true,
			closeOnEscape: false,
			open: function(event, ui) {$('#divModalLicencias').html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");}
//			close: function(event, ui) {$("#divListaLicencias").remove(), $("#regLicencias").remove();}
//			,close: function(event, ui) {$("#divListaLicencias").remove(); }
			
		});	
		
		formLicencias(idP);
		
	}	
	
}



function cambiarFechafinProgLic(idvista){
	
	/*
	 cambios javier raffo
	 */
	
	if($("#cantDiasLic").val() === ''){
		$("#f_finLic").val($("#f_inicioLic").val());
		//$("#cantDiasLic").val('1');
		return;
	}
	/*
	 cambios javier raffo
	 */
	
	var f_inicio 	= $("#f_inicioLic"+idvista).val();
	var f_fin 		= $("#f_finLic"+idvista).val();
	var cantdias	= $("#cantDiasLic"+idvista).val();
	var idP			= $("#idPersonalrl"+idvista).val();

	if(window.event)	event = window.event;	

	if((event.keyCode >= 96 && event.keyCode <= 105) || (cantdias >= 1)){

		if (cantdias >= 1 ){
			cantdiasentre2fechas(f_inicio, f_fin, idP, 0, idvista, cantdias );
		}else {
			$("#cantDiasLic"+idvista).val(0);
			$("#f_finLic"+idvista).val('');
		}	
	}else if(event.keyCode == 8 || cantdias == 0 ){
//		if (cantdias == 0 ){
			$("#cantDiasLic"+idvista).val('');
			$("#f_finLic"+idvista).val('');
//		}
	}	
			
}


function dialogRangoFechaLicenciasInconsistente (){
	$( "#dialog-info-ValidaVac" ).dialog({
//	    resizable: false,
//	    height:140,
	    width: 'auto',
	    title: 'Registro / Actualización de licencias:',
	    modal: true,
	  	    
	    buttons: {
	      Aceptar: function() {
	        $( this ).dialog( "close" );
	      },		        
	    }
	  });	
}



function btnInsertaLicencias (){
	
	var idP		= $("#idPersonalrl").val();
	
	Valid.init($('#formRegistroLicencias').find(".valid"));
	
	if(Valid.test()){
		$('#loadAjax').modal('toggle');
		$.post('insertarLicenciasPersonal.action', $('#formRegistroLicencias').serialize(),function(data) {
				$('#loadAjax').modal('toggle');
			var msgResult = data.search("msgIsertsuccess");

			if (data.length > 0){
				
//	        	17-03-2015 DAVID
		    	if(mostrarModalResultadoSession(data,"") >  0)	cerrarSession(); //return;
//		    	END DAVID	
				
				if(msgResult > 0){
 					
//  					formLicencias(idP);
					
					listarlicenciasPersonal($("#int_anio_licencia_filtro").val(), $("#int_mes_licencia_filtro").val(), $("#idPersonalLicencia").val(), $("#int_tipo_licencia_filtro").val());
  					
					$("#num_resol_autoriza").val('');
					$("#descripcionLic").val('');
					
//					btnRegistroLicencia();
				}
				
				$('#divModalmsg').html(data);
				
				$( "#divModalmsg" ).dialog({
//				    resizable: false,
				    height: 'auto',
				    width: 'auto',
				    title: 'Registro / Actualización de licencias:',
				    modal: true,
				  	    
				    buttons: {
				      Aceptar: function() {				    	  
				        $( this ).dialog( "close" );
				      },		        
				    }
				  });				
			}
		});	
	}else{
		$("#formRegistroLicencias .v_label").css("display","inline");
	}	
}




function eliminarLicencias(idLicenciaVista, fechainicio, fechafin){
	
//	var page 			= $("#dtpage").val();
	var idPer			=$("#idPersonalLicencia").val();
	var ubicacion		= $("#ubicacionPersonal").val();
	var idreg			= $("#regimenContractual").val();
	
	console.log(fechainicio);
	console.log(fechafin);

//	$('#dialog-info-vacerrar').dialog('destroy');
	$('#dialog-form').dialog({
		width: 'auto',
//		height: 'auto',
		title: 'Eliminar Licencias:',
		modal: true,
		closeOnEscape: false,
	      buttons: {
		        'No': function(){
		        	$( this ).dialog( "close" );
		        	return;
		        },
		        'Si': function() {		        	

		        	$('#loadAjax').modal('toggle');
		        	
		        	$.post('eliminarLicencias.action',{	idLicencia 				: idLicenciaVista, 
		        										idPersonal 				: idPer, 
		        										f_inicioLic 			:  fechainicio, 
		        										f_finLic 				: fechafin,
		        										idregimenContractual 	: idreg, 
		        										ubicacionPersonal 		: ubicacion  }, function(datos){
		        		
		        	$('#loadAjax').modal('toggle');		        											
	        		
						var msgResult = datos.search("msgIsertsuccess");

						if (datos.length > 0){	
							
//				        	17-03-2015 DAVID
					    	if(mostrarModalResultadoSession(datos,"") >  0)	cerrarSession(); //return;
//					    	END DAVID	
							
							if(msgResult > 0){			
//								formLicencias(idPer);
								listarlicenciasPersonal($("#int_anio_licencia_filtro").val(), $("#int_mes_licencia_filtro").val(), $("#idPersonalLicencia").val(), $("#int_tipo_licencia_filtro").val());
							}	
							
							$("#divModalmsg" ).html(datos);
							$( "#divModalmsg" ).dialog({
//							    resizable: false,
							    height: 'auto',
							    width: 'auto',
							    title: 'Licencias:',
							    modal: true,
							  	    
							    buttons: {
							      Aceptar: function() {				    	  
							        $( this ).dialog( "close" );
							      },		        
							    }
							  });
				
						}
						
		        	});
	
		          $( this ).dialog( "close" );
		          
		        }
		      }
		
	});	

}


function updateLicencias(){

//	$('#dialog-formLic').dialog('destroy');
	$('#dialog-formLic').dialog({
		width: 'auto',
		height: 'auto',
		title: 'Actualizar licencia:',
		modal: true,
		closeOnEscape: false,
	      buttons: {
		        'No': function(){
		        	$( this ).dialog( "close" );
		        	return;
		        },
		        'Si': function() {	
		        	btnInsertaLicencias();
		          $( this ).dialog( "close" );
		          
		        }
		      }
		
	});	

}

function cerrarLicencias(idLicenciaVista){
	var idP		= $("#idPersonalrl").val();
	
//	$('#dialog-formLicerrar').dialog('destroy');
	$('#dialog-formLicerrar').dialog({
		width: 'auto',
		height: 'auto',
		title: 'Actualizar licencia:',
		modal: true,
		closeOnEscape: false,
	      buttons: {
		        'No': function(){
		        	$( this ).dialog( "close" );
		        	return;
		        },
		        'Si': function() {	

		        	$.post('cerrarLicenciasPersonal.action', {idLicencia : idLicenciaVista},function(datos) {		    			
		    			var msg = datos.MsgTrx.toUpperCase();					    			
		    	    	if(msg == 'SUCCESS'){
		    	    		divMsg = $(".msgExito4");	 
		    	    		
		    	    		/*Para actualizar la vista Lista de Personal*/
//		    	    		formLicencias(idP);
		    	    		listarlicenciasPersonal($("#int_anio_licencia_filtro").val(), $("#int_mes_licencia_filtro").val(), $("#idPersonalLicencia").val(), $("#int_tipo_licencia_filtro").val());
//		    	    		btnRegistroLicencia();		    		    		
		    			
		    	    	}else if(msg == 'ERROR'){
		    	    		var msgdp = datos.MsgDuplex;
		    	    		divMsg = $(".msgError");
		    	    		divMsg.text(msgdp);
		    	    	}
		    	    	    	
		    	    	divMsg.css("z-Index","1100");
		    	    	divMsg.center();
		    	    	setTimeout(function(){ divMsg.fadeIn(400).fadeOut(3800);}, 0);			    	    	
		    	    },"json");	
		        	
		          $( this ).dialog( "close" );
		          
		        }
		      }
		
	});	

}/*---------------FIN LICENCIAS-----------------*/





/*--------------- REPORTES -----------------*/


function reporteporPersonal(tipoReporte){
	
//	var cant 		= 0;
	var idpersonal 	= 0;	
	idpersonal = $("#idPersonalM").val();
	
	/*
	$("input[name='personal.idpersonal']").each(function(){		
		if($(this).is(":checked")){
		      cant++;
		      idpersonal = $(this).val();
		}
	});
	*/
	
	if(idpersonal <= 0){
		var title_	= null;
		if(tipoReporte == -1){
			title_	= 'Ingreso y Salida por Persona:';
		}if(tipoReporte == 0){
			title_	= 'Asistencia por Persona:';
		}else if(tipoReporte == 1){
			title_	= 'Inasistencias por Persona:';
		}else if(tipoReporte == 2){
			title_	= 'Papeletas por Persona:';
		}else if(tipoReporte == 3){
			title_	= 'Resúmen de Asistencia por Persona:';
		}else if(tipoReporte == 4){
			title_	= 'Record de Asistencia por Persona:';
		}
//		$("#dialog-info:ui-dialog").dialog('destroy');
		$( "#dialog-info" ).dialog({
//		      resizable: false,
//		      height:140,
			width: 'auto',
//			resizable: true,
		      title: title_,
		      modal: true,
		      buttons: {
		        Aceptar: function() {
		          $( this ).dialog( "close" );
		        },		        
		      }
		    });
		return;	
	}else{	
		
//		mostrarinasistenciaspermisos(idpersonal);	
//		$("#idPersonalM").val(idpersonal);
		$("#tipoReportePersonal").val(tipoReporte);		
		reporteTodoPersonal(tipoReporte);
		
	}	
}

	
function reporteTodoPersonal(tipoReporte){	

	$("#tipoReportePersonal").val(tipoReporte);	
	var idPer = $("#idPersonalM").val();
	var title_	= null;
	
	if(tipoReporte == -1){
		title_	= ' - Ingreso y Salida de:';
	}else if(tipoReporte == 0){
		title_	= ' - Asistencia de:';
	}else if(tipoReporte == 1){
		title_	= ' - Inasistencia de:';
	}else if(tipoReporte == 2){
		title_	= ' - Papeletas de :';
	}else if(tipoReporte == 3){
		title_	= ' - Resúmen Asistencia de:';
	}else if(tipoReporte == 4){
		title_	= ' - Record Asistencia de:';		
		$("#tiempoPersonalReportes").attr('disabled','disabled');   
		
	}
	
	
	oTableDefault 		= null;
	oTableDefault 		= $('#tableDefault').dataTable();
	
	//Valor, fila, columna, refresca
	
//	console.log(oTableDefault.fnGetData($('tr#'+idPer)[0], 3));
	
	$('#divModalContenedor').dialog({
		width: 'auto',
		height: 'auto',
		title: 'Reportes' + title_,// + ' ' +oTableDefault.fnGetData($('tr#'+idPer)[0], 3),
		modal: true,
		closeOnEscape: false,
		open: function(event, ui) {$('#divModalContenedor').html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
		close: function(event, ui) {$("#tipoReportePersonal").val('');	}

	});
	
	$.post('viewOptionsReporte.action',{idPersonal : idPer}, function(data){
		
//    	17-03-2015 DAVID
    	if(mostrarModalResultadoSession(data,"#divModalContenedor") >  0)	cerrarSession(); //return;
//    	END DAVID	
				
		$('#divModalContenedor').html(data);
		$("#divModalContenedor").dialog("option", "position", "center");

        	$('#fechaIniAsistencia').datepicker({
//    			dateFormat : "dd/mm/yy",
    			changeMonth: true,           // Si se pueden cambiar los meses
    			changeYear: true,            // Si se pueden cambiar los años
			    onSelect: function(dateText, inst) {			    	
			    	$("#fechaFinAsistencia").val($("#fechaIniAsistencia").val());
			    	$("#fechaFinAsistencia").datepicker("option", "minDate", $("#fechaFinAsistencia").val());			    	
			    } 
 			
        	});
			
        	
        	$('#fechaFinAsistencia').datepicker({
//    			dateFormat : "dd/mm/yy",
    			changeMonth: true,           // Si se pueden cambiar los meses
    			changeYear: true            // Si se pueden cambiar los años

        	});

        	$("#rangoFechas").css("display","none");
        	$("#periodos").css("display","none");
        	$("#btnreportes").attr('disabled',"disabled");
        	
        	var idP	= $("#idPersonalReporte").val();        	
        	
//        	$("#idPersonalM").val('');
        	
        	if(tipoReporte == 4){
        		
        		$("#tiempoPersonalReportes").attr('disabled','disabled');
        		$("#tiempoPersonalReportes").val(1);        		
        		tiempoPersonalReportes(1);
        		
        	}

        	
        	if(idP > 0){
        		$("#Persona").css('display','block');
        		$("#todos_porPersona").css('display','none');
        		$("#ubicacionPersonalReportes").attr('disabled','disabled');
        		$("#regimenContractualReporte").attr('disabled','disabled');        		
        	}else{
        		$("#todos_porPersona").css('display','block');
        		$("#Persona").css('display','none');
        	}			
        	
	});   	
	
}



function tiempoPersonalReportes(val){

	$("#btnreportes").removeAttr('disabled','disabled');
	
	if(val == 0){
		
		$("#rangoFechas").css("display","block");
		$("#periodos").css("display","none");
		$("#btnreportes").attr('enabled','enabled');
		
	}else if(val == 1){
		
		$("#rangoFechas").css("display","none");
		$("#periodos").css("display","block");
		$("#btnreportes").attr('enabled','enabled');
		
	}else{
		
		$("#rangoFechas").css("display","none");
		$("#periodos").css("display","none");		
		$("#btnreportes").attr('disabled','disabled');
		$("#btnreportes").removeAttr('enabled','enabled');
	}

	
}

function dowloadReportePersonal(valFormato){
	var fechaInicioInasist 	= $("#fechaIniAsistencia").val();
	var fechaFinInasist 	= $("#fechaFinAsistencia").val();
	var ubicacionP			= $("#ubicacionPersonalReportes").val();
	var tiempoReporte		= $("#tiempoPersonalReportes").val();
	var mes					= $("#mesdesc").val();
	var periodo				= $("#periododesc").val();
	var idP					= $("#idPersonalReporte").val();
	var idRegimen			= $("#regimenContractualReporte").val();
	var tipoReporte			= $("#tipoReportePersonal").val();
	
	var href 				= '';
	
	if(tipoReporte === '1' || tipoReporte === '0' || tipoReporte === '-1'){
		href				= '/personal/listarInasistenciasPersonal'+valFormato+'.action';	
	}else if(tipoReporte === '2'){
		href				= '/personal/listarPersonalporActividad'+valFormato+'.action';
	}else if(tipoReporte === '3'){
		href				= '/personal/listarPersonalResumenAsistencia'+valFormato+'.action';
	}else if(tipoReporte === '4'){
		href				= '/personal/listarPersonalRecordAsistencia'+valFormato+'.action';
	}
		
	href 					= href +'?AsistenciafechaInicio='+fechaInicioInasist
							  +'&AsistenciafechaFin='+fechaFinInasist+'&ubicacionPersonal='+ubicacionP+'&tiempoReportePersonal='+tiempoReporte
							  +'&periododesc='+periodo+'&mesdesc='+mes+'&idPersonal='+idP+'&idregimenContractual='+idRegimen+'&tipoReporte='+tipoReporte;

	$("#"+valFormato).attr('href',href);

    $('.loading').show();
//    $('#loadAjax').modal('toggle');

    $.ajax({
        type: 'HEAD',
        url: href,
        complete: function () {
            $('.loading').hide();
//        	$('#loadAjax').modal('toggle');
        }

    });    	    

}


function cerrarOptReportes(){	
	$( "#fechaIniAsistencia").datepicker("destroy");
	$( "#fechaFinAsistencia").datepicker("destroy");	
	$( "#divModalContenedor" ).dialog( "close" );	
//	$( "#idPersonalM").val('');
	$( "#tipoReportePersonal").val('');	
}


function cerrarModalDiasNoLaborables(){	
	
	$( "#divModalDiasNoLaborables" ).dialog( "close" );	 
}


function creatoTableDiasNoLaborables(anio, mes){
	
	oTableDiasNoLaborables = $('#tableDiasNoLaborables').dataTable( {
		autoWidth      : false,
	    preDrawCallback: function () {
	        
	        if (!responsiveHelper) {
	            responsiveHelper = new ResponsiveDatatablesHelper(oTableDiasNoLaborables, breakpointDefinition);
	        }
	    },
	    rowCallback    : function (nRow) {
	        responsiveHelper.createExpandIcon(nRow);
	    },
	    drawCallback   : function (oSettings) {
	        responsiveHelper.respond();
	    },
			"sDom": " <'row' <'col-md-6'l><'col-md-6'p>>  t <'row'<'col-md-12'p i> >",
			bPaginate: true,
		    "aaSorting": [],
		    "oLanguage": {
			   "sUrl": "assets/plugins/datatables/lang/spanish.json"
  		     },
  		   "aLengthMenu": [
  		                 [5, 10, 15, -1],
  		                 [5, 10, 15, "Todos"]
  		             ],
			"sAjaxDataProp": "listResult",
			"sAjaxSource": null,
			"aoColumns" : 
				[ 
				 	
				 	{"mData" : "dte_fec_no_laborable"},	
				 	{"mData" : "var_dia_no_lab_descripcion"},
				 	{"mData" : "int_estado"},
					{"mData" : "srl_id_no_laborable"}
				 	
					
				]
			, "aoColumnDefs": [
					 		                  {
					 		                       "aTargets": [2],
					 		                       "mData": null,
					 		                       "mRender": function (data, type, row) {
					 		                    	   
					 		                    	  var b = '';
					 		                    	
					 		                    	  
						 		                    	 
					 		                    	 
					 		                    	  if(data == '0'){
					 		                    		 	b = b + '<center> Activo </center>';
					 		                    		 	
					 		                    		 		
					 		                    	  }else{
					 		                    			b = b + '<center> Procesado </center>';
					 		                    	  }					 		                    	 
					 		                    	 
					 		                    	   return b;		
					 		                    	   
					 		                    	   
					 		                    	}
					 		                  },
					 		                  {
					 		                    	"aTargets": [3],
					 		                    	"mData": null,
					 		                    	"mRender": function (data, type, row) {
					 		                    	   
					 		                    	  var b = '';
					 		                    	
					 		                    	  
						 		                    	 
					 		                    	 if(row.int_estado == 0){
					 		                    		 	b = b + '<div title="Eliminar día" onclick="confirmarEliminarDiasNoLaborables(' + data + ',' + row.int_mes + ',' + row.int_anio + ')";>';
					 		                    		 	b = b + '<center><img src="img/eraser.png" border="0" style="cursor: pointer;"/></center>'
					 		                    		 	b = b +  '</div>'; 		
						 		                    }					 		                    	 
					 		                    	 
					 		                    	   return b;
					 		                    	}
					 		                  		
					 		                   }
					 		                   
					 		  ],
					 		  
  		   "fnInitComplete": function(oSettings, json) {
  			 diasNoLaborablesxPeriodo(anio, mes);
  		    },
  		    bFilter: false, 
  		    bInfo: true

	});	
}


function diasnolaborables(){
	
	$('#divModalDiasNoLaborables').dialog({
		width: 'auto',
		height: 'auto',
		title: 'Registro días no laborables:',
		modal: true,
		closeOnEscape: false,
		open: function(event, ui) {$('#divModalDiasNoLaborables').html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
		close: function(event, ui) {$("#tipoReportePersonal").val('');	}

	});
	
	var fhoy = $("#fechamaAsistencia").val();
	var anio = fhoy.substring(6,fhoy.length);
	var mes	 = fhoy.substring(3,5);

	$.post('listarAniosdiasnolaborables.action', {anio : anio}, function(data){
	
		$('#divModalDiasNoLaborables').html(data);
		
		$("#divModalDiasNoLaborables").dialog("option", "position", "center");	
		
    	$('#dianolaborable').datepicker({
//			dateFormat : "dd/mm/yy",
			changeMonth: true,           // Si se pueden cambiar los meses
			changeYear: true,            // Si se pueden cambiar los años

		    onSelect: function(dateText, inst) {			    	

		    	var seldate = $(this).datepicker('getDate');		    	
		    	
		    	var diaSemana = validarDiaSemana(seldate);
		        
	        	$("#srl_id_no_laborable").val('');
	        	$("#tDiasNoLaborables_int_anio").val('');
		    	$("#tDiasNoLaborables_int_mes").val('');		        
		        
		        if(diaSemana === 'Sábado' || diaSemana === 'Domingo'){
		        	$("#dianolaborabledescripcion").val('');
		        	$('#msj_resultadoDiasNoLaborables').html("<div class=\"alert alert-danger\" role=\"alert\">No puede registrar el día " + diaSemana + " como no laborable.</div>");
			   		$('#modalResultadoSolicitudDiasNoLaborables').modal('toggle');
			   		
		        }else{
		        	
		        	$("#tDiasNoLaborables_int_anio").val(dateText.substring(6,dateText.length));
			    	$("#tDiasNoLaborables_int_mes").val(dateText.substring(3,5));	
			    	$("#dianolaborabledescripcion").focus();
			    	
		        }
		   	 	
		    	
		    	
		    				    	
		    } 
			

    	});
		
    	    	
		creatoTableDiasNoLaborables(anio, mes);

		
	}); 

}

function validarDiaSemana(fecha){
	
    seldate = fecha.toDateString();
    seldate = seldate.split(' ');
    var weekday=new Array();
        weekday['Mon']="Lunes";
        weekday['Tue']="Martes";
        weekday['Wed']="Miércoles";
        weekday['Thu']="Jueves";
        weekday['Fri']="Viernes";
        weekday['Sat']="Sábado";
        weekday['Sun']="Domingo";
        
    var diaSemana = weekday[seldate[0]];
	
	return diaSemana;
	
}

function ajaxReturnJson(path, typeEnvio, typeReturn, parametros){
	
	var dataReturn = null;
	
	$.ajax({
        url			: path,
        type		: typeEnvio,
        dataType	: typeReturn,
        data		: parametros,
        async		: false,
        success		: function(data) {
        	dataReturn = data;
        },
        error: function(jqXHR, textStatus, error) {
          alert( "error: " + jqXHR.responseText);
        }
	});		
	
	return dataReturn;
}



function selectDiasNoLaborablesxPeriodo(){
	
	diasNoLaborablesxPeriodo($("#periodoDiasNoLaborables").val(), $("#mesDiasNoLaborables").val());
	
}

function diasNoLaborablesxPeriodo(periodo, mes) {
	
	parametros = {
			"anio"	: periodo,
			"mes"	: mes
		 };
	
	
		var json = ajaxReturnJson("/personal/buscarDiasNoLaborablesxPeriodo.action","POST","json",parametros);
		
		
		oTableDiasNoLaborables.fnClearTable();

		var oSettings = oTableDiasNoLaborables.fnSettings();
		
		oTableDiasNoLaborables.fnClearTable(this);

	    for (var i=0; i<json.listResult.length; i++)
	    {
	    	oTableDiasNoLaborables.oApi._fnAddData(oSettings, json.listResult[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableDiasNoLaborables.fnDraw();	
	    
	    if(mes != ''){
	    	$("#mesDiasNoLaborables").val(parseInt(mes));	
	    }
	    
    
}

function grabarDiasNoLaborables(){
	
	$('#formRegistroDiasNoLaborables').bootstrapValidator({
	    fields: {
	        "diasNoLaborablesDTO.dte_fec_no_laborable": {
	            validators: {
	            	notEmpty: {
	                    message: 'Campo obligatorio.'
	                }                    
	             }
	        },
	        "diasNoLaborablesDTO.var_dia_no_lab_descripcion": {
	            validators: {
	            	notEmpty: {
	                    message: 'Campo obligatorio.'
	                }
                    
	             }
	        }
	     }
	});
	
	
	
	$("form#formRegistroDiasNoLaborables").data('bootstrapValidator').resetForm();
	$("form#formRegistroDiasNoLaborables").data('bootstrapValidator').validate();
	
	if($("form#formRegistroDiasNoLaborables").data('bootstrapValidator').isValid()){
		
		parametros = $("form#formRegistroDiasNoLaborables").serialize();
		
//		parametros = {
//				"diasNoLaborablesDTO.var_dia_no_lab_descripcion" 	: $("#dianolaborabledescripcion").val(),
//				"diasNoLaborablesDTO.dte_fec_no_laborable"			: $("#dianolaborable").val(),
//				"diasNoLaborablesDTO.int_anio"						: $("#tDiasNoLaborables_int_anio").val()
//				
//		};
		
		var seldate = $("#dianolaborable").datepicker('getDate')

		var diaSemana = validarDiaSemana(seldate)

		
        if(diaSemana === 'Sábado' || diaSemana === 'Domingo'){        	
        	
        	$('#msj_resultadoDiasNoLaborables').html("<div class=\"alert alert-danger\" role=\"alert\">No puede registrar el día " + diaSemana + " como no laborable.</div>");
	   		$('#modalResultadoSolicitudDiasNoLaborables').modal('toggle');
	   		
        }else{
        	
    	 	var json = ajaxReturnJson("/personal/grabarDiasNoLaborables.action","POST","json",parametros);
       	 	
       	 	if(json.transaccionUtil.estadoTransaccion === 1){
       	 		
    	   	 	$("#dianolaborabledescripcion").val('');
    	   		$("#dianolaborable").val('');

//       	 		diasNoLaborablesxPeriodo($("#periodoDiasNoLaborables").val());
       	 		diasNoLaborablesxPeriodo($("#periodoDiasNoLaborables").val(), $("#mesDiasNoLaborables").val());
       	 		
       	 	}else{
       	 		
       	 	$('#msj_resultadoDiasNoLaborables').html("<div class=\"alert alert-danger\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
       		$('#modalResultadoSolicitudDiasNoLaborables').modal('toggle');
       	 	}
        }   
		
	}
	
}

function confirmarEliminarDiasNoLaborables(idDiaNoLaborable, int_mes, int_anio){
	
	$("#srl_id_no_laborable").val('');
	$("#tDiasNoLaborables_int_anio").val('');
	$("#tDiasNoLaborables_int_mes").val('');
	$("#dianolaborabledescripcion").val('');
	$("#dianolaborable").val('');
	
	
	
	$("#srl_id_no_laborable").val(idDiaNoLaborable);
	$("#tDiasNoLaborables_int_anio").val(int_anio);
	$("#tDiasNoLaborables_int_mes").val(int_mes);
	
	$('#modalConfirmarEliminarDNL').modal('toggle');
	
}

function eliminarDiasNoLaborables(){	
	
		
//	parametros = $("form#formRegistroDiasNoLaborables").serialize();
	
	
	parametros = {
			"diasNoLaborablesDTO.srl_id_no_laborable" 	: $("#srl_id_no_laborable").val(),
			"diasNoLaborablesDTO.dte_fec_no_laborable"	: $("#dte_fec_no_laborablehidden").val(),		
			"diasNoLaborablesDTO.int_anio" 				: $("#tDiasNoLaborables_int_anio").val(),
			"diasNoLaborablesDTO.int_mes" 				: $("#tDiasNoLaborables_int_mes").val()
	};
	
	
	 	var json = ajaxReturnJson("/personal/eliminarDiasNoLaborables.action", "POST", "json", parametros);
	 
	 	if(json.transaccionUtil.estadoTransaccion === 1){

	 		$('#modalConfirmarEliminarDNL').modal('toggle');
	 		selectDiasNoLaborablesxPeriodo();
	 		
	 	}else{
	 		$('#modalConfirmarEliminarDNL').modal('toggle');
	   	 	$('#msj_resultadoDiasNoLaborables').html("<div class=\"alert alert-danger\" role=\"alert\">"+json.transaccionUtil.mensaje+"</div>");
	   		$('#modalResultadoSolicitudDiasNoLaborables').modal('toggle');
	 	}
}

