$(function() {
	
	$("#btnSaveTabExcel").live('click', Fnc_GuardaPersonalFile);
	$("#btnEnviarFicha").live('click', Fnc_GuardaFicha);
	$("#btnViewFicha").live('click', Fnc_MuestraFicha);
	$("#btnActualizarFicha").live('click', Fnc_ActualizaFicha);
	$("#btnAgregarPersonReg").live('click', Fnc_AgregarPersonalRegistro);
	$("#btnSavePersonReg").live('click',Fnc_GuardarPersonalRegistro);
	$("#btnUpdatePersonReg").live('click',Fnc_ActualizarPersonalRegistro);
	$("#btnViewActivaFicha").live('click', Fnc_MuestraFichaParaAprobar);
	$("#btnAprobarFicha").live('click', Fnc_AprobarFicha);
	$("#btnDesAprobarFicha").live('click', Fnc_DesAprobarFicha);
	$("#btnAgregarPersonRegForm").live('click', Fnc_AgregarPersonalRegistroForm);
	$("#btnSavePersonRegForm").live('click',Fnc_GuardarPersonalRegistroForm);
	$("#btnConsolidarFicha").live('click', Fnc_ConsolidarFicha);
	
	
	$('.linkareanatreg').click(
			  function(e){
				  var idarea=$(this).attr('param');
				  $('#formListaAnpRegistro').find('#hdareanatural').val(idarea);
				    $('#formListaAnpRegistro').attr('action',registroAction.t_anpregistro);
				    $('#formListaAnpRegistro').submit();
			  }		
			);
	
		
	$("#cadena").autocomplete(
			{

				source : function(request, response) {
					$.ajax({
						url : "registro/buscarPersonaRegistro.action",
						data : "cadena=" + request.term,
						dataType : "json",
						success : function(data) {

							response($.map(data.person, function(item) {
					
								return {
									id : item.idpersonalregistro,
									value : item.apepat.toUpperCase() + ' '
											+ ( (item.apemat != null) ? item.apemat.toUpperCase() : '' ) + ','
											+ item.nombre.toUpperCase(),
									campo: [item.idpersonalregistro,item.apepat.toUpperCase() + ' '
											+ ( (item.apemat != null) ? item.apemat.toUpperCase() : '' ) + ','
											+ item.nombre.toUpperCase(),item.empresa,item.tipodocumento,item.numerodocumento,item.tipolocal,item.sexo],
									tipos: data.tipos

								};
							}));

						}
					});
				},
				select : function(e, ui) {
					var obj = ui.item;										
					$(this).val('');					
					
					//createDynamicTable($("#hor-minimalist-a"), 1, 7,obj);
					//$("#hor-minimalist-a > tbody").empty();
					createDynamicTable($("#hor-minimalist-a"),$("#hor-minimalist-a tbody tr"),1,7,obj,obj.tipos);

										
					return false;

				},

				minLength : 1

			});
	
	
	    
    $("#btnImpEx").live('click',dialogImportaArchivo);

});

var fechaServer;
var nrow=0;
var idrow=0;
var arrayidpr=new Array();

function createDynamicTable(tbody, tbodytr ,rows, cols, obj,tip) {

	if(!in_array(obj.campo[0], arrayidpr)){
	
	//var datpers = ['nombre','apepat','apemat','empresa','tipodocumento','numerodocumento','tipolocal','sexo'];	
	
	//if (tbody == null || tbodytr.length < 1)
		//return;

	//alert(tbodytr.length);
	
	for ( var r = 1; r <= rows; r++) {

		nrow = tbodytr.length + 1;
		
		var trow = $("<tr id='IDTR_"+nrow+"'>");
		
		var html = "<input type='hidden' name='personalregistro[_n].idpersonalregistro' value='"+obj.campo[0]+"' />";
		var fec = "<input type='text' name='personalregistro[_n].fechaingreso' size='15' class='dateDMY_ valid datepicker' readonly />";
		
		//nrow+=r;
		
		$("<td class='cabN'>").html("<label>"+nrow.toString()+"</label>"+html).data("col", 0).appendTo(trow);
		
		for ( var c = 1; c <= cols; c++) {
    		if(c == 3 || c == 5 || c == 6){
        		//var cellText = tip[obj[datpers[c-1]]['idtabla']+''+obj[datpers[c-1]]['idtipo']];
    			var cellText = tip[ obj.campo[c]['idtabla']+''+obj.campo[c]['idtipo'] ];
    		}else if(c == 7){
    			$("<td class='cabNF'>").html(fec).data("col", c).appendTo(trow);
    			break;
    		}
    		else var cellText = obj.campo[c];
			 
			//$("<td>").addClass("tableCell").text(cellText).data("col", c).appendTo(trow);
    		if(cellText != null)
    		$("<td>").text(cellText).data("col", c).appendTo(trow);
			
		}
		var html = "<div onClick=javascript:removeTR('IDTR_"+nrow+"',"+obj.campo[0]+");><img src='img/eliminar.png' border='0' /></div>";
		
		$("<td>").html(html).data("col", 8).appendTo(trow);
				
		trow.appendTo(tbody);
		
		arrayidpr.push(obj.campo[0]);

		var fechaDP = fechaServer.split('-');
		var ano = parseInt(fechaDP[0],10);
		var mes = parseInt(fechaDP[1],10);
		var dia = parseInt(fechaDP[2],10);
		
		test = new Date(ano, mes - 1, dia);
		
		$( ".datepicker" ).datepicker({minDate: test});
		
	}
	
	}
}


function createDynamicTable_(tbody, tbodytr ,rows, cols, obj,tip) {
		
	if(!in_array(obj['idpersonalregistro'], arrayidpr)){
		
	for ( var r = 1; r <= rows; r++) {

		nrow = tbodytr.length + 1;
		
		var trow = $("<tr id='IDTR_"+nrow+"'>");
		
		var html = "<input type='hidden' name='personalregistro[_n].idpersonalregistro' value='"+obj['idpersonalregistro']+"' />";
		var fec = "<input type='text' name='personalregistro[_n].fechaingreso' size='15' class='dateDMY_ valid datepicker' readonly />";
		
		//nrow+=r;
		
		$("<td class='cabN'>").html("<label>"+nrow.toString()+"</label>"+html).data("col", 0).appendTo(trow);
		$("<td>").text(obj['apepat']+' '+obj['apemat']+', '+obj['nombre']).data("col", 1).appendTo(trow);
		$("<td>").text(obj['empresa']).data("col", 2).appendTo(trow);
		$("<td>").text(tip[ obj['tipodocumento']['idtabla']+''+obj['tipodocumento']['idtipo'] ]).data("col", 3).appendTo(trow);
		$("<td>").text(obj['numerodocumento']).data("col", 4).appendTo(trow);
		$("<td>").text(tip[ obj['tipolocal']['idtabla']+''+obj['tipolocal']['idtipo'] ]).data("col", 5).appendTo(trow);
		$("<td>").text(tip[ obj['sexo']['idtabla']+''+obj['sexo']['idtipo'] ]).data("col", 6).appendTo(trow);
		$("<td class='cabNF'>").html(fec).data("col", 7).appendTo(trow);
				
		var html = "<div onClick=javascript:removeTR('IDTR_"+nrow+"',"+obj['idpersonalregistro']+");><img src='img/eliminar.png' border='0' /></div>";
		
		$("<td>").html(html).data("col", 8).appendTo(trow);
		
		trow.appendTo(tbody);
				
		arrayidpr.push(obj['idpersonalregistro']);
		
				
		/*$( ".datepicker" ).datepicker({
			minDate: new Date(fechaServer)//,
			//dateFormat: $.datepicker.TIMESTAMP		
		});*/
		
		var fechaDP = fechaServer.split('-');
		var ano = parseInt(fechaDP[0],10);
		var mes = parseInt(fechaDP[1],10);
		var dia = parseInt(fechaDP[2],10);
		
		test = new Date(ano, mes - 1, dia);
		
		$( ".datepicker" ).datepicker({minDate: test});
	}
	
	}
}

var nN=0;

function removeTR(id,v){
	$("#"+id).remove();
	
	var idx = arrayidpr.indexOf(v); // Find the index
	if(idx!=-1) arrayidpr.splice(idx, 1);
	
	var n = 1;
	
	$("#hor-minimalist-a tr td[class='cabN'] label").each(function (index) {		 
		$(this).text(n);
		n++;
    });
	
	nN = n;
}

muestraCamposAdd = function(){
	$(".divaddper_").css("display","block");
};


function dialogImportaArchivo(){
	$( "#divModalImportarArchivo:ui-dialog" ).dialog( "destroy" );              
    $( "#divModalImportarArchivo" ).dialog({
            width: 990,
            height: 580,
            title: 'Importar desde Archivo',
            modal: true,                    
            closeOnEscape: false,
            open: function(event, ui) {$( "#divModalImportarArchivo" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
            close: function(event, ui) {$("#divContentUpload").remove();}
    });
    //{indent: ""+inputString+"", clasifica: ""+txtBusq+"", idGenerica: ""+gg+""}
    $.post("registro/formularioupload.action", "", function(data){
        if(data.length > 0){
                $("#divModalImportarArchivo").html(data);
        }
});

};

Fnc_GuardaPersonalFile = function(){
	
	//var nombrefile =  $('#nombre_file').val();	
	//$('#formTabExcel').find('#nombrearchivo').val(nombrefile);
	
	$('#formTabExcel').attr('action',"registro/registrarpersonal.action");
	$('#formTabExcel').submit();
};

Fnc_GuardaFicha = function(){
	
	formficha=$('#formRegistroFicharegistro');
	validmt = validarSeleccionMedioTransp();
	validprf = validarIngresoPersonalFicha();
	Valid.init(formficha.find(".valid"));   
	if(Valid.test() && validmt && validprf){
	
		$( "#dialog-message:ui-dialog" ).dialog( "destroy" );
		
		$( "#dialog-message" ).dialog({
			modal: true,
			width: 300,			
			buttons: {
				Ok: function() {
					$( this ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Enviando...!!!</i>");					
					//$( this ).dialog({buttons: 'none'});
					$( this ).dialog( "option", "buttons", { } );
					seteaIndex();					
					$('#formRegistroFicharegistro').attr('action',"registro/registrarficha.action");
					$('#formRegistroFicharegistro').submit();
				}
			}
		});		
	
	}
};

Fnc_MuestraFicha = function(){
	
	formficha = $('#formularioListadoFichas');
	formficha.find('.msgselficha').hide();
	formficha.find('.msgselfichas').hide();
	chkidfr = formficha.find('.idfichareg');
	var countchk=0;
	$.each(chkidfr, function(i,e){
		if($(this).is(':checked') == true)countchk++;
	});
	
	if(countchk > 0 && countchk == 1){	
		$('#formularioListadoFichas').attr('action',"registro/registrofichaformulario.action");
		$('#formularioListadoFichas').submit();	
	}else{		
		if(countchk == 0)formficha.find('.msgselficha').show();
		if(countchk > 1)formficha.find('.msgselfichas').show();
		return false;
	}	
};

Fnc_ActualizaFicha = function(){
	
	formficha=$('#formEditarFicharegistro');
	validmt = validarSeleccionMedioTransp();
	validprf = validarIngresoPersonalFicha();
	Valid.init(formficha.find(".valid"));   
	if(Valid.test() && validmt && validprf){
		
		seteaIndex();
		
		$('#formEditarFicharegistro').attr('action',"registro/actualizaficha.action");
		$('#formEditarFicharegistro').submit();
	}
};

function seteaIndex(){
	
	var nn1 = 0;
	$("#hor-minimalist-a tr td[class='cabN']").each(function (index) {		
		var row1 = $(this);		
		var row2 =row1.html().replace(/_n/g,nn1);	
		var row = $(row2);
		row1.html(row);
		
		nn1++;		
    });
	
	var nn2=0;
	$("#hor-minimalist-a tr td[class='cabNF']").each(function (index) {
		var row1 = $(this);
		var valdate = row1.find('.datepicker').val();
		var row2 =row1.html().replace(/_n/g,nn2);	
		var row = $(row2);				
		
		row1.html(row);
		
		row1.find('.datepicker').val(valdate);
		
		nn2++;		
    });
	
}

Fnc_AgregarPersonalRegistro = function(){
			
	//var pos = $("#hor-minimalist-a").offset();		
	//var ptop = pos.top - $(window).scrollTop();
	
	$( "#divModalPersonalRegistro:ui-dialog" ).dialog( "destroy" );              
    $( "#divModalPersonalRegistro" ).dialog({
            width: 400,
           
            //position: [pos.left, ptop],
            title: 'Formulario Agregar Personal',
            modal: true,                    
            closeOnEscape: false,
            open: function(event, ui) {$( "#divModalPersonalRegistro" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
            close: function(event, ui) {$("#divContentPersonalReg").remove();}
    });  
    
    $.post("registro/formularioagregarPersonalRegistro.action", "", function(data){
        if(data.length > 0){
                $("#divModalPersonalRegistro").html(data);
        }
    });
    
};

Fnc_editarPersonalRegistro = function(idpr){
	
	$( "#divModalPersonalRegistro:ui-dialog" ).dialog( "destroy" );              
    $( "#divModalPersonalRegistro" ).dialog({
            width: 400,           
            title: 'Formulario Editar Personal',
            modal: true,                    
            closeOnEscape: false,
            open: function(event, ui) {$( "#divModalPersonalRegistro" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
            close: function(event, ui) {$("#divContentPersonalReg").remove();}
    });
    
    //{indent: ""+inputString+"", clasifica: ""+txtBusq+"", idGenerica: ""+gg+""}
    
    $.post("registro/formularioeditarPersonalRegistro.action", {"personalregistro[0].idpersonalregistro":""+idpr+""}, function(data){
        if(data.length > 0){
                $("#divModalPersonalRegistro").html(data);
        }
    });
};

Fnc_eliminarPersonalRegistro = function(idpr){

$( "#dialog-message:ui-dialog" ).dialog( "destroy" );
	
	$( "#dialog-message" ).dialog({
		modal: true,
		width: 300,        
		buttons: {
			Ok: function() {
				$( this ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Eliminando...!!!</i>");					
				//$( this ).dialog({buttons: 'none'});
				$( this ).dialog( "option", "buttons", { } );
				$("#idpersonalregistro").val(idpr);
				$('#FormListadoPersonalRegistro').attr('action',"registro/eliminarpersonal.action");
				$('#FormListadoPersonalRegistro').submit();
			}
		}
	});
};

Fnc_AgregarPersonalRegistroForm = function(){
	
	var pos = $("#btnAgregarPersonRegForm").offset();		
	var ptop = pos.top - $(window).scrollTop();
	
	$( "#divModalPersonalRegistro:ui-dialog" ).dialog( "destroy" );              
    $( "#divModalPersonalRegistro" ).dialog({
            width: 400,
            height: "auto",
            position: [pos.left/2, ptop/2],
            title: 'Formulario Agregar Personal',
            modal: true,                    
            closeOnEscape: false,
            open: function(event, ui) {$( "#divModalPersonalRegistro" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
            close: function(event, ui) {$("#divContentPersonalReg").remove();}
    });  
    
    $.post("registro/formularioagregarPersonalRegistroForm.action", "", function(data){
        if(data.length > 0){
                $("#divModalPersonalRegistro").html(data);
        }
    });
    
};

Fnc_GuardarPersonalRegistroForm = function(){	
	
	var idtipdoc = $(".tipodoc").val();	
	if(idtipdoc != "" && idtipdoc != 1 ){		
		$("#idapemat").addClass("v_norequired");
				
	}else if(idtipdoc != ""){		
		$("#idapemat").removeClass("v_norequired");
	}
	
	 Valid.init($('#FormInsertaPersonalRegistro').find(".valid"));
	  if(Valid.test()){
	
		param=$('#FormInsertaPersonalRegistro').serialize();
		 
		 $.post("registro/insertarpersonalregistroform.action",
				param,
				function(data) {			 		
			 		
			 		if(data.person){
					obj = data.person;
					
					tip = data.tipos;
					createDynamicTable_($("#hor-minimalist-a"),$("#hor-minimalist-a tbody tr"),1,7,obj,tip);
					
					$("#divContentPersonalReg").remove();
					$("#divModalPersonalRegistro").dialog('close');
					
			 		}else{
			 			$('#divContentPersonalReg').html(data);
			 		}
				}
			);
		 
		 //$("#divContentPersonalReg").remove();
		 //$("#divModalPersonalRegistro").dialog('close');
	 
	  }
};

Fnc_GuardarPersonalRegistro = function(){	
	
	var idtipdoc = $(".tipodoc").val();	
	if(idtipdoc != "" && idtipdoc != 1 ){		
		$("#idapemat").addClass("v_norequired");
				
	}else if(idtipdoc != ""){		
		$("#idapemat").removeClass("v_norequired");
	}	
	
	Valid.init($('#formInsertaPersonalregistro').find(".valid"));
	
	if(Valid.test()){	  
		$('#formInsertaPersonalregistro').attr('action',"registro/insertarpersonalregistro.action");
		$('#formInsertaPersonalregistro').submit();
	}

};

Fnc_ActualizarPersonalRegistro = function(){
	
	var idtipdoc = $(".tipodoc").val();	
	if(idtipdoc != "" && idtipdoc != 1 ){		
		$("#idapemat").addClass("v_norequired");
				
	}else if(idtipdoc != ""){		
		$("#idapemat").removeClass("v_norequired");
	}
	
	Valid.init($('#formActualizarPersonalregistro').find(".valid"));
	  if(Valid.test()){
	
		  $('#formActualizarPersonalregistro').attr('action',"registro/actualizarpersonalregistro.action");
			$('#formActualizarPersonalregistro').submit();
	  }
	
};

Fnc_MuestraFichaParaAprobar = function(){	
	formficha = $('#formularioListadoFichasAprob');
	formficha.find('.msgselficha').hide();
	formficha.find('.msgselfichas').hide();
	chkidfr = formficha.find('.idfichareg');
	var countchk=0;
	$.each(chkidfr, function(i,e){
		if($(this).is(':checked') == true)countchk++;
	});
	
	if(countchk > 0 && countchk == 1){
	
	$('#formularioListadoFichasAprob').attr('action',"registro/registrofichaformularioAprob.action");
	$('#formularioListadoFichasAprob').submit();
	}else{
		
		if(countchk == 0)formficha.find('.msgselficha').show();
		if(countchk > 1)formficha.find('.msgselfichas').show();
		return false;
	}
};

Fnc_MuestraFichaParaConsolidar = function(idfr){	
	$('#idficharegistro').val(idfr);
	
	$('#formularioListadoFichasAprob').attr('action',"registro/muestrafichaformularioConsolida.action");
	$('#formularioListadoFichasAprob').submit();

};

Fnc_AprobarFicha = function(){
	
	$( "#dialog-message:ui-dialog" ).dialog( "destroy" );
	
	$( "#dialog-message" ).dialog({
		modal: true,
		width: 300,        
		buttons: {
			Ok: function() {
				$( this ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Aprobando...!!!</i>");					
				//$( this ).dialog({buttons: 'none'});
				$( this ).dialog( "option", "buttons", { } );
				$('#formularioFichaAprob').attr('action',"registro/aprobarfichaformulario.action");
				$('#formularioFichaAprob').submit();
			}
		}
	});
	
	
};

Fnc_DesAprobarFicha = function(){
	
	var idf = $("#idficharegistro").val();
	
	$( "#divModalDesAprobFicha:ui-dialog" ).dialog( "destroy" );              
    $( "#divModalDesAprobFicha" ).dialog({
            width: 450,
            height: "auto",            
            title: 'Desaprobación de Ficha',
            modal: true,                    
            closeOnEscape: false,
            open: function(event, ui) {$( "#divModalDesAprobFicha" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
            close: function(event, ui) {$("#divContentDesAprobFicha").remove();}
            ,
            buttons: {            	
    			Aceptar: function() {
    				
    				Valid.init($('#formDesaprobarFicha').find(".valid"));
    				if(Valid.test()){
    					$(".ui-dialog-buttonset").html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Desaprobando...!!!</i>");    					    	    			
    					
    	    			$('#formDesaprobarFicha').attr('action',"registro/desaprobarfichaformulario.action");
    	    			$('#formDesaprobarFicha').submit();
    				}
    			}
    			
            }
    });  
    
    $.post("registro/formulariodesaprobarficha.action", {"ficharegistro.idficharegistro":idf}, function(data){
        if(data.length > 0){
                $("#divModalDesAprobFicha").html(data);
        }
    });
	
	
};

function descargarArchivo(idfr){
	$("#idficharegistro_").val(idfr);
	$('#formularioListadoFichasAprob').attr('action',"registro/descargafichaformularioAprob.action");
	$('#formularioListadoFichasAprob').submit();	
	
}

function descargarArchivo_(idfr){
	$("#idficharegistro_").val(idfr);
	$('#formularioListadoFichas').attr('action',"registro/descargafichaformularioAprob.action");
	$('#formularioListadoFichas').submit();	
	
}

function validarSeleccionMedioTransp() {
	respuesta=false;
//	chkcount=0;
	formficha.find('.msgmedtra').hide();
	chkmedtra = formficha.find('.mediotra');
	
	$.each(chkmedtra, function(i,e){
		//if($(this).is(':checked')==false)chkcount++;
		respuesta = respuesta || $(this).is(':checked');
	});
	
	if(respuesta == false)formficha.find('.msgmedtra').show();
		
	return respuesta;
}

function validarIngresoPersonalFicha(){
	
	formficha.find('.msgpersreg').hide();
	tbodytr = $("#hor-minimalist-a tbody tr");
	if(tbodytr.length == 0){
		formficha.find('.msgpersreg').show();
		return false;
	}else{
		return true;
	}
	
}


function mostrarDetalle(obj){
	var bfr = $(obj).attr('src').match(/up/);		
	var fs = $(obj.parentNode.parentNode);
	if(bfr == null){fs.children("div").show();$(obj).attr("src","img/file_up.png");}
	else{fs.children("div").hide();$(obj).attr("src","img/file_down.png");$(obj.parentNode).show();}	
}

Fnc_ConsolidarFicha = function(){
	
	formficha=$('#formularioFichaConsolid');	
	
	Valid.init(formficha.find(".valid"));   
	if( Valid.test() ){
		
		seteaIndex();
		
		formficha.attr('action',"registro/consolidaficha.action");
		formficha.submit();
	}
};
