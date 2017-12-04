var dp = [],cbs,filediv ;
var idgenarchivo=0,idgendoc=0;
var idgenfte=0;
var idgenejecfin=0;
var idgenejectec=0;
var paramAutocompletarEjecFin= {
		opcion: 1,
		source: function (request, response) {
			$.ajax({
				url: "buscaEjecutor.action",
				data: "idopcion="+paramAutocompletarEjecFin.opcion+"&cadenaParam="+request.term ,
				dataType: "json",
				 success: function (data) {
					 response($.map(data.ejecutoras, function (item) {
				     return {
						id: item.idejecutor,
						value: (paramAutocompletarEjecFin.opcion == 1)?
								item.personajuridica.nombrepersonajuridica	:
								item.personajuridica.siglas
							
						};
					}))
				 } 
			})},
			select: function( e, ui ) {
				var obj = ui.item;
				$(this).val(obj.value);
				$(this).parent().find('.idejecfin').val(obj.id);
				return false;
	
			},
			
			minLength: 1
	};
var paramAutocompletarEjecTec= {
		opcion: 1,
		source: function (request, response) {
		$.ajax({
			url: "buscaEjecutor.action",
			data: "idopcion="+paramAutocompletarEjecTec.opcion+"&cadenaParam="+request.term ,
			dataType: "json",
			 success: function (data) {
			response($.map(data.ejecutoras, function (item) {
			return {
			id: item.idejecutor,
			value: (paramAutocompletarEjecTec.opcion == 1)?
					item.personajuridica.nombrepersonajuridica	:
					item.personajuridica.siglas
				
			}
			}))
			 }
			})
			},
			select: function( e, ui ) {
				var obj = ui.item;
				$(this).val(obj.value);
				$(this).parent().find('.idejectec').val(obj.id);
				return false;

			},
			
			minLength: 1
	};
var paramAutocompletarFteFto= {
		opcion: 1,
		source: function (request, response) {
		$.ajax({
			url: "buscaFuenteFinanciamiento.action",
			data: "idopcion="+paramAutocompletarFteFto.opcion+"&cadenaParam="+request.term ,
			dataType: "json",
			 success: function (data) {
			response($.map(data.fuentes, function (item) {
			return {
			id: item.idftefto,
			value: (paramAutocompletarFteFto.opcion == 1)?
					item.personajuridica.nombrepersonajuridica	:
					item.personajuridica.siglas
				
			}
			}))
			 }
			})
			},
			select: function( e, ui ) {
				var obj = ui.item;
				$(this).val(obj.value);
				$(this).parent().find('.idftefto').val(obj.id);
				return false;

			},
			
			minLength: 1
	};
$(document).ready(function() {
	
	
	

	
	
    var dialog3 = $( "#divModalConf" ).dialog({
		autoOpen: false,
		width: 200,
		modal: true,
		buttons: { 
			"Si": function() { 
				
				eliminarProyectos();
				
			},
			"No": function() {
				$('#cboAccionProyecto').val(0);
				$( "#divModalConf" ).dialog('close');
				$('.checkProyecto').each(
			    		function(e){
			    		  $(this).attr('checked',false);	
			    		}	 
			    	 );
				
			} 

        },
		close: function(event, ui) { 
			dialog.empty();
		}
    });	
	
	
	
	$('#checkTodos').live('click',
		function(e){
		check=$('#checkTodos').attr('checked');
		$('.checkProyecto').each(
	    		function(e){
	    			if(check)
	    			$(this).attr('checked',true);
	    			else
	    				$(this).attr('checked',false);	
	    		}	 
	    	 );
	    }	
	);
	
	cboaccproy=$('#cboAccionProyecto').live('change',
			   function(e){
		         
		    	 var opc=$('#cboAccionProyecto').val();
		    	 
		    	 if(opc!=0){
		    	 
		    	 var sel=0;
		    	 $('.checkProyecto').each(
		    		function(e){
		    			if($(this).attr('checked')){
		    				sel=1;
		    			}
		    		}	 
		    	 );
		    	 if(sel==0){
		    		 $('#cboAccionProyecto').val(0);
		    		 alert('Seleccione al menos una casilla');
		    		 return;
		    	 }
		    	 
		    	 if(opc==1){
		    		 $('#divModalConf').dialog("open");
		    		 //eliminarProyectos();
		    	 }
		    	} 
		     }
	);
	
	//ejecutoras financieros
	idgenejecfin=$('#idultejecfin').val();
	$('#camposEjecFinanciero .i_supr').click(
		     quitarEjecFin
	);
	
	$('#camposEjecFinanciero .nomejecfin').autocomplete(
			paramAutocompletarEjecFin
	);
	
	//ejecutoras tecnicos
	idgenejectec=$('#idultejectec').val();
	$('#camposEjecTecnico .i_supr').click(
		     quitarEjecTec
	);
	
	$('#camposEjecTecnico .nomejectec').autocomplete(
			paramAutocompletarEjecTec
	);
	
	//fuentes
	idgenfte=$('#idultfte').val();
	
	$("#camposFteFto .montoftefto").each(
			function(i,e){
					$(this).onlyDigits(true);
			}	
	);
	
	$('#camposFteFto .i_supr').click(
		     quitarFteFto
	);
	
	$('#camposFteFto .nomftefto').autocomplete(
			paramAutocompletarFteFto
	);
	
	
	idgendoc=$('#idultdoc').val();
    idgenarchivo=$('#idultarch').val();

    
	
	
	$('#divDocumento .i_edit').click(
		     editarDocumento
	);
	$('#divDocumento .i_supr').click(
		     quitarDocumento
	);
	
	
	
	
	
	
	$('#camposFteFto .idmonedaftefto').each(
			function(e) {
				
		     	var idcodigo=$(this).val();
				var $combo=$(this);
				$combo.parent().find('.idmonedaftefto').change(
						ocultarFiltroTipoCambio	
				);
				if(idcodigo==1){ //soles
					$combo.parent().find('.idanio').hide();
					$combo.parent().find('.idmes').hide();
					$combo.parent().find('.valortipocambioftefto').hide();
			    }    
      }
	);
	
	
	$('#camposFteFto .idanio').each(
				function(e){
					var $combo=$(this);
					$combo.parent().find('.idanio').change(
							filtracombotcmes	
					);
				}
			
			
			
	);
	
	
	$('#camposFteFto .idmes').each(
			function(e) {
				var $combo=$(this);
				$combo.parent().find('.idmes').change(
						filtrartipocambio	
				);
			}
			
			
	);
	
	
	
	
	var linkFtefto = $('#linkAddFteFto').click(
			function(e) {
				e.preventDefault();
				agregarFuenteFinanciamiento(e);
			}
			
	
	);
	
	
	
	
	
	
	 var ExpProy = $(".linkRepProyArea").click(
	    		function (e){
	    			
	    	  		 e.preventDefault();
	    	  		var idopcion=$(this).attr('name');
	    	  		if(idopcion==1){
	    	  			$("#formInicioProyectos").attr('action','reporteCantidadProyectoArea.action');
	    	  		}
	    	  		else
	    	  			if(idopcion==2) {
	    	  			$("#formInicioProyectos").attr('action','reporteMontoProyectoArea.action');
	    	  		}
	    	  		
	    	  		$("#formInicioProyectos").submit();

	    		}	 
	 );
	
	
	 function mostrarArchivoProyecto(e){
		
	  		 e.preventDefault();
	  		var idcodigo=$(this).attr('param');
	  		window.location.href='muestraArchivoProyecto.action?idcodigo='+idcodigo;
	 }
	 
	 
	 
	var dialogModalDoc = $( "#divModalDoc" ).dialog({
		autoOpen: false,
		width: 500,
		modal: true
	});
	
	 
	var pagDoc = $('#linkModalDoc').click(
			function (e){ 
				e.preventDefault();
				$('#divModalDoc').dialog("open");
				//limpiar
				$('#divModalRegDoc').find('.txtModalDoc').val('');
				 $("#fileArchivo").val('');
				 $("#divModalRegDoc").find('.divArchModalDoc').html('');
				idgendoc++;
				$('#divModalRegDoc').find('.hdModalDoc').val(idgendoc);
				//tipo
				$('#hdTipoRegistroDoc').val(1);
				//$('#spNumDoc').text(idgendoc);
				
			}
	);
	
	var regdoc = $('#btnRegistroDoc').click(
    		function(e){
    			
    			var nomDoc=$.trim($('#divModalRegDoc').find('.txtModalDoc').val() );
    			if(nomDoc==""){
    				alert("Ingrese un Nombre para el documento");
    				return;
    			}
    			opcion =$('#hdTipoRegistroDoc').val();
    			n=$('#divModalRegDoc').find('.hdModalDoc').val();//leer codigo
    			if(opcion==1){//crear
    				i=n-1;//obtener indice
        			row1=$('#divContRowDoc').clone();
        			row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
    				row= $(row2);
    				row.find('.codigodocumento').val($('#divModalRegDoc').find('.hdModalDoc').val());//codigo
    				row.find('.iddocumento').val(0);//codigo
    				//row.find('.iddocumento').val($('#divModalRegDoc').find('.hdModalDoc').val());//codigo
    				row.find('.nomdocumento').text($('#divModalRegDoc').find('.txtModalDoc').val());//nombre
    				row.find('.desdocumento').val($('#divModalRegDoc').find('.txtModalDoc').val());//des
    				//archivo
    				row.find('.archivodocumento').html($('#divModalRegDoc').find('.divArchModalDoc').html());
    				row.find('.i_edit').click(
    				     editarDocumento
    				);
    				row.find('.i_supr').click(
    						 quitarDocumento
    						);
    			    $('#divDocumento').append(row);	
    			}
                else
                if(opcion==2){//actualizar
                	
                	$('#rowDoc'+n).find('.nomdocumento').text($('#divModalRegDoc').find('.txtModalDoc').val());
                	$('#rowDoc'+n).find('.desdocumento').val($('#divModalRegDoc').find('.txtModalDoc').val());
                	$('#rowDoc'+n).find('.archivodocumento').html($('#divModalRegDoc').find('.divArchModalDoc').html());
                }
				$('#divModalDoc').dialog('close');
				//limpiar registro modal
				$('#hdTipoRegistroDoc').val(0);
				$('#divModalRegDoc').find('.hdModalDoc').val(0);
				$('#divModalRegDoc').find('.txtModalDoc').val('');
    		}
    	
	);
	
	
	var rearc=$('#btnRegArchivo').click(
	  function(e){
		  e.preventDefault();
		  //if();
		  var nomArch=$.trim($("#fileArchivo").val() );
		  //var ext =nomArch.split('.');
		  //var filetype = ext[ext.length-1];
			if(nomArch==""){
				alert("Ingrese un Archivo");
				return;
			}
		  idgenarchivo++;
		  n=idgenarchivo;
		  i=n-1;
		  row1=$('#divContRowArch').clone();
		  row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
		  row= $(row2);
		  row.find('.codigoarchivo').val(idgenarchivo);
		  row.find('.idarchivo').val(0);
		  //row.find('.idarchivo').val(idgenarchivo);//codigo
		  row.find('.nomarchivo').text($("#fileArchivo").val());//nombre
		  row.find('.codigoarchivopadre').val($('#divModalRegDoc').find('.hdModalDoc').val());
		  //row.find('.idarchivopadre').val($('#divModalRegDoc').find('.hdModalDoc').val());//codigo padre
		  row.find('.i_remove').click(
					 function(e){
						 e.preventDefault();
						 $(this).parent().remove();
					 }
		   );
		  $('#divModalRegDoc').find('.divArchModalDoc').append(row);
		  $("#formRegistroArchivo").attr('action','cargaArchivo.action?idcodigo='+idgenarchivo);
  		  $("#formRegistroArchivo").submit();
  		//limpiar
		  $("#fileArchivo").val('');
  		  
	  }		
	);
	
	
	
	
	
	 
	
	 
    var buscarProy = $("#btnBuscarProyectos").click(
    		function (e){
    	  		 e.preventDefault();
    	  		var proyParam= $("#formInicioProyectos").serialize();
    	  		proyParam+='&control=2';
    			proyParam+='&numeroPagina=1';
    	  		$.ajax({
    	  	       url: 'consultaProyecto.action',
    	  	       data: proyParam,
    	  	       cache: false,
    	  	       type: "GET",
        	  	     beforeSend: function() {
        	  	    $("#btnBuscarProyectos").attr("disabled","disabled");
        	  	    htmlesp=" <div style='text-align:center'> Consultando <br/> <img   src='css/loading.gif'  />  </div>";
       	  	    	$("#divListaProyectos").html(htmlesp);
    	  	    }, 

    	  	       success: function(datos){         
    	  	    	 $("#btnBuscarProyectos").removeAttr("disabled");
    	  	           $("#divListaProyectos").html(datos);
    	  	           
    	  	           
    	  	       }
    	  	   });
    		}	 
    );
    
    
   
    
    var ExpProy = $(".linkExpProy").live("click",
    		
    		function (e){
 		 e.preventDefault();
 		var opc=$(this).attr('name');
 	   
 		var proyParam= $("#formInicioProyectos").serialize();
 		$("#formInicioProyectos").attr('action','exportaProyecto.action?idtipoexp='+opc);
 		$("#formInicioProyectos").submit();

	}	 
    );
    
    
 
     
   var buqava=$("#imgBusqDetProy").click(
	function(e){
		 e.preventDefault();
		 $("#divBusqDetProy").slideToggle();
	}	   
   );
   
   
   var delar=$(".linkEliminaArchivo").click(
	 function(){
  lll
	 }	   
   );
  
   
    var limpiarProy = $("#btnLimpiarProyectos").click(
    		function (e){
    	  		 e.preventDefault();
    	  		 window.location.href='consultaProyecto.action';
    	  	
    		}	 
    );
    
   
    var nuevoProy = $("#btnNuevoProyecto").click(
    		nuevoProyecto
    );
    var regProy = $("#btnRegistroProyecto").click(
    		registroProyecto
    );

    var regcProy = $("#btnCancelarRegistroProyecto").click(
    		cancelarRegistroProyecto
    );
    
	$( ".datepicker" ).each(function(i,e){
		
		dp.push( $(e).datepicker({
			changeMonth: true,
			changeYear: true,
			//minDate:"-70Y",  
			//maxDate: "+70Y",
			yearRange: '2000:2060',
			dateFormat:"yy-mm-dd",
			//defaultDate:"-10Y",
			showOn: "both", 
			buttonImage: "img/16x16/apps/office-calendar.png",
			buttonImageOnly: true ,
			onSelect: function(dateText, inst) {
				if(this.name == "proyecto.fechainicio"){
					dp[1].datepicker("setDate", stringToDate( dateText ) );
					dp[1].datepicker( "option", "minDate", stringToDate( dateText ) );
				}
			}
	
		}));	 
	})

	
	
	
	
	
    
	
	
	

	
	
	
	
       $('#txtProyectoPadre').autocomplete({
			source: function (request, response) {
			$.ajax({
			url: "buscaProyecto.action",
			//data: { term:   request.term   },
			data: "&cadenaParam="+request.term ,
			dataType: "json",
			 success: function (data) {
			response($.map(data.proyectos, function (item) {
			return {
			id: item.idproyecto,
			value: item.nombreproyecto 
			}
			}))
			 }
			})
			},
			select: function( e, ui ) {
				var obj = ui.item;
				var id= $(this).attr("id");
				id=id.substring(10);
				$('#hdProyectoPadre').val(obj.id);
				$('#txtProyectoPadre').val(obj.value);
				return false;

			},
			
			minLength: 2
	      });
	
	
	
	//agregar ejecutor financiero
	var linkEjecFin = $('#linkAddEjecFin').live("click",
    		function (e){ 
       			e.preventDefault();
       			agregarEjecutorFinanciero(e);

    		}
    );
	
	//agregar ejecutor tecnico
	var linkEjecTec = $('#linkAddEjecTec').live("click",
    		function (e){ 
       			e.preventDefault();
       			agregarEjecutorTecnico(e);

    		}
    );
	
//quitar ejecutor financiero
var linkDelEjecfin = $('#linkDelEjecFin').live("click",
		function (e){ 
   			e.preventDefault();
   			$(this).parent().remove();
		}
);

//quitar ejecutor tecnico
var linkDelEjectec = $('#linkDelEjecTec').live("click",
		function (e){ 
   			e.preventDefault();
   			$(this).parent().remove();
		}
);

//quitar ejecutor financiero
var linkDelFtefto = $('#linkDelFteFto').live("click",
		function (e){ 
   			e.preventDefault();
   			$(this).parent().remove();
		}
);

//quitar archivo
var linkDelArch = $('#linkDelArch').live("click",
		function (e){ 
   			e.preventDefault();
   			$(this).parent().remove();
		}
);


var mon = $('#cboMoneda').change(
		function (e){ 
   			e.preventDefault();
   			var lbl="Tipo de Cambio a:";
   			lbl+=this.options[this.selectedIndex].text;
   			
   			$("#lblTipoCambio").html(lbl);
			
   			
   			var mon= $("#cboMoneda").val();
   			$('.txtcambFte').each(
    				function(i,e){
    					$(this).val("");
    					$(this).removeAttr('readonly');
    					
       			         
    				}		
    		);
   			
   			
		}
);


var tproy = $('#cboTipoProyecto').change(
		function (e){ 
   			e.preventDefault();
   			var opc=$('#cboTipoProyecto :selected').text();
   			if(opc=='Otro'){
   				$("#divTipoProyecto").show();
   			}
   			else{
   				$("#divTipoProyecto").hide();
   			}
			
		}
);


	var rad = $('.rbGrupo').change(
    		function (e){ 
       			$("#divGrupo").toggle();	
       			var res=$(this).attr("value");
       			if(res==2){
       			$("#hdProyectoPadre").attr("value",0);
       			$("#txtProyectoPadre").attr("value",'');
       			}
    		}
    );
	
	
	
	
	var buscarProy = $("#cboCategoriaAnp").change(
    		function (e){
    	  		 e.preventDefault();
    	  		var divcat =$('#divCategoriaAnp').html();
       			idcodigoparam=$(this).val();
       			
       			idcodigoparam=idcodigoparam+'&control=1';
       			//control='&control=1';
  	    		$.ajax({
  	    	        url: 'listaFiltrosProyectos.action',
  	    	        data: "idCodigoParam="+idcodigoparam,
  	    	        cache: false,
  	    	        type: "GET",
  	    	        success: function(datos){ 
  	    	        	cbs = datos;
  	   	    	        	for(var i in datos){
  	    	        		var html = "";
  	    	        		cbo = datos[i];
  	    	        		var tipo = (i =="");
  	    	        		html+="<option value='0'>Todos</option> ";
  	    	        		for (var j = 0; j < cbo.length ; j++) {
  	    	        			var option = cbo[j];
  	    	        			html+="<option value='";
  	    	    	        	html+=option.idcodigo;
  	    	    	        	html+="'>";
  	    	    	        	html+=option.nombre;
  	    	    	        	//html+=option.nombre.substring(0,30);
  	    	    	        	html+="</option>";
  	    	    	        }
  	    	        		$("#"+i).html(html);
  	    	        		
  	    	        	}
  	    	        	
  	    	        	
  	    	        }
  	    	    });			
    		}	 
    );
	
	var buscaranp = $('#cboAnp').change(
    		function (e){ 
       			e.preventDefault();
       		    idcategoriaanp=$('#cboCategoriaAnp').val();
       		    //var divcat =$('#divCategoriaAnp').html();
       		    //var divanp =$('#divAnp').html();
       		    idcodigoparam=$(this).val();
       			idcodigoparam=idcodigoparam+'&control=2';
       			idcodigoparam=idcodigoparam+'&idCategoriaAnpParam='+idcategoriaanp;
  	    		$.ajax({
  	    	        url: 'listaFiltrosProyectos.action',
  	    	        data: "idCodigoParam="+idcodigoparam,
  	    	        cache: false,
  	    	        type: "GET",
  	    	        success: function(datos){
  	    	        	
  	    	        	cbs = datos;
	   	    	        	for(var i in datos){
	    	        		var html = "";
	    	        		cbo = datos[i];
	    	        		var tipo = (i =="");
	    	        		html+="<option value='0'>Todos</option> ";
	    	        		for (var j = 0; j < cbo.length ; j++) {
	    	        			var option = cbo[j];
	    	        			html+="<option value='";
	    	    	        	html+=option.idcodigo;
	    	    	        	html+="'>";
	    	    	        	html+=option.nombre.substring(0,30);
	    	    	        	html+="</option>";
	    	    	        }
	    	        		$("#"+i).html(html);
	    	        		
	    	        	}
  	    	        	
  	    	        }
  	    	    });			
    			
    		}
    );
	
	
	
	var modanpp = $('#cboCatAnpModal').change(
    		function (e){ 
       			e.preventDefault();
       			idcodigoanp=$('#cboCatAnpModal').val();
       			
       			$(".checkListaAnp").each(
       					
       			 function(i,e){
       				$("#divAnp"+i).show();
       				if(idcodigoanp!=0){
       					if($("#hdCatAnp"+i).val()!=idcodigoanp){
           					$("#divAnp"+i).hide();
           				}
       				}
       				
       			 }		
       			);
       			
    		}
    );
	
	
	
	 var cerrar = $('.linkCerrar').live("click",
	    		function (e){
		        e.preventDefault();
		        var modal= $(this).attr("name");
		        if(modal=='imgAnp'){
		        	$('#divModalAnp').dialog("close");
		        }
		        else
		        	if(modal=='imgEjec'){
			        	$('#divModalEjec').dialog("close");
			        }
		        	else
			        	if(modal=='imgFte'){
				        	$('#divModalFte').dialog("close");
				        }
			        	else
				        	if(modal=='imgInst'){
					        	$('#divModalInst').dialog("close");
					        }
				        	else
					        	if(modal=='imgDoc'){
						        	$('#divModalDoc').dialog("close");
						        }
	     }
	 );
	 
	 
	 
	 
	 
    var dialog = $( "#divDetalleProyecto" ).dialog({
		autoOpen: false,
		width: 800,
		modal: true,
		buttons: { "Cerrar": function() { $(this).dialog("close"); } },
		close: function(event, ui) { 
			dialog.empty();
		}
    });	     
    
    var dialog1 = $( "#divModalMsgProy" ).dialog({
		autoOpen: false,
		width: 200,
		modal: true,
		buttons: { 
			"Si": function() { 
				
				$("#formRegistroProyecto").submit();
				
			},
			"No": function() {
				$("#crear").val("2");
				$("#formRegistroProyecto").submit();
				
			} 

        },
		close: function(event, ui) { 
			dialog.empty();
		}
    });	 
    
  
    
    var dialogModalAnp = $( "#divModalAnp" ).dialog({
		autoOpen: false,
		width: 800,
		modal: true,
		close: function(event, ui) { 
			dialog.empty();
		}
    });	 
    
    
    
    var dialogModalInst = $( "#divModalInst" ).dialog({
		autoOpen: false,
		width: 400,
		modal: true,
		close: function(event, ui) { 
			dialog.empty();
		}
    });
    
  
    
    
    var dialogModalEjec = $( "#divModalEjec" ).dialog({
		autoOpen: false,
		width: 800,
		modal: true,
		close: function(event, ui) { 
			dialog.empty();
		}
    });	 
    
    
    var dialogModalEjec = $( "#divModalFte" ).dialog({
		autoOpen: false,
		width: 800,
		modal: true,
		close: function(event, ui) { 
			dialog.empty();
		}
    });
    
    var pagProy = $('#linkModalAnp').live("click",
    		function (e){ 
       			e.preventDefault();
       			$( "#divModalAnp" ).dialog( "open" ); 			
    			
    		}
    );
    
    
    var pagProy = $('.linkCreaInstitucion').live("click",
    		function (e){ 
       			e.preventDefault();
       			$( "#divModalInst" ).dialog( "open" );
       			$("#txaNombreInst").val("");
       			$("#txtSiglasInst").val("");
       			$("#cboPais").val(0);
       			$("#txtDireccion").val("");
       			$("#txtTelefono").val("");
       			$("#txtEmail").val("");
       			var hd=$(this).attr('name');
       			$("#hdtipoinst").attr('value',hd);
    		}
    );
    
    
    
    //agregar archivo
    var pagProy = $('#linkAddArch').live("click",
    		function (e){ 
       			e.preventDefault();
       			
       			
       			if($("#camposModalArchivo > div ").length==0){
       				if($("#camposArchivo > div").length==0){
       					ind2=0;
       				}
       				else{
       					var ind2= $("#camposArchivo > div").last().attr('id');
        				ind2=ind2.substring(7);
        				ind2=parseInt(ind2);
       				}
       				
       			}
       			else{
       				var ind2= $("#camposModalArchivo > div").last().attr('id');
       				ind2=ind2.substring(7);
       				ind2=parseInt(ind2);
       			}
       			ind2=ind2+1;
       			ult2=ind2-1;
       			
       			var items = $("#rowArch").html().replace(/_ult/g,ult2).replace(/_ind/g,ind2);
       			$("#camposModalArchivo").append(items);
    		}
    );
    
    
    


    
    
    
    
    
    
    
    
    //evento guardar registro institucion
    var btnreginst = $('#btnRegInst').live("click",
    		function (e){ 
    	   
    	        e.preventDefault();
    	        var nom=$.trim( $("#txaNombreInst").val() );
    	        var sig=$.trim( $("#txtSiglasInst").val() );
		    	  var telf=$.trim( $("#txtTelefono").val() );
		    	  if(nom==""){
		    		  alert("Ingrese Nombre de la Institucion");
		    		  return;
		    	  }
		    	  if(sig==""){
		    		  alert("Ingrese Siglas de la Institucion");
		    		  return;
		    	  }
		    	 var idpais=$("#cboPais").val(); 
		    	 if(idpais==0){
		    		  alert("Seleccione un país");
		    		  return;
		    	  }
    	        var institucionParam= $("#formRegistroInstitucion").serialize();
    			  
    			$.ajax({
    			      url: 'guardaInstitucion.action',
    			      data:  institucionParam,
    			      cache: false,
    			      type: "GET",
    			      success: function(datos){      
    			    	 
    			    	  var opcion=$("#hdtipoinst").val();
    			    	 
    			    	  
    			    	  $( "#divModalInst" ).dialog("close");
    			    	  if(opcion==1){
    			    		  
    			    		  agregarEjecutorFinanciero(e);
    			    		  row.find('.nomejecfin').attr('value',datos.nombre);
    			    		  row.find('.idejecfin').attr('value',datos.codigo);
    			    		 
    			    	  }
    			    	  else if(opcion==2){
    			    		  agregarEjecutorTecnico(e);
    			    		  row.find('.nomejectec').attr('value',datos.nombre);
    			    		  row.find('.idejectec').attr('value',datos.codigo);
    			    	  }
    			    	  else if(opcion==3){
    			    		  agregarFuenteFinanciamiento(e);
    			    		  row.find('.nomftefto').attr('value',datos.nombre);
    			    		  row.find('.idftefto').attr('value',datos.codigo);
    			    	  }
    			    	  
    			    	  
    			      }
    			  });
    			
    			
    		}
    );
    
    
    
    
    
    
    var pagProy = $('#linkModalEjec').live("click",
    		function (e){ 
       			e.preventDefault();
       			$( "#divModalEjec" ).dialog( "open" ); 			
    			
    		}
    );
    
    var pagProy = $('#linkModalFte').live("click",
    		function (e){ 
       			e.preventDefault();
       			$( "#divModalFte" ).dialog( "open" ); 			
    			
    		}
    );
    
    var linkDetProy = $('.linkRegProy').live("click",
    		function (e){ 
       			e.preventDefault();
       			var id= $(this).attr("name");
       			//$("#formInicioProyectos").attr('action','/diana/registroProyecto.action?idProyectoParam='+id);
       			$("#idProyectoParam").attr('value',id);
       			$("#formInicioProyectos").attr('action','registroProyecto.action');
       			//$("#formInicioProyectos").attr('action','/diana/registroProyecto.action?idProyectoParam='+$(this).attr("param"));
       			
       			$("#formInicioProyectos").submit();
       		    
    		}
    		
    );
    
    
    
    
    var pagProy = $('.pagination a').live("click",
    		function (e){
    			
    			e.preventDefault();
    			//numeroPagina=$(this).text();
    			numeroPagina=$(this).attr('name');
    			
    			var proyParam= $("#formInicioProyectos").serialize();
    			proyParam+='&control=2';
    			proyParam+='&numeroPagina='+numeroPagina;
    			$.ajax({
    				url: 'consultaProyecto.action',
     	  	       data: proyParam,
     	  	       cache: false,
     	  	       type: "GET",
     	  	       success: function(datos){                        
     	  	           $("#divListaProyectos").html(datos);
     	  	         
     	  	                	  	       }
    		   });
    		   
    		}
    ); 
    
    
    var pagProy = $('.linkProy').live("click",
    		function (e){ 
    			
    			e.preventDefault();
    			//idProyectoParam=$(this).text();
    			idProyectoParam=$(this).attr('name');
    			$.ajax({
    			      url: 'consultaDetalleProyecto.action',
    			      data: "idProyectoParam="+idProyectoParam,
    			      cache: false,
    			      type: "GET",
    			      success: function(datos){                   
    			          $("#divDetalleProyecto").html(datos);
    			          
    			          $("#tabs").tabs();
    			          
    		    			$( "#divDetalleProyecto" ).dialog( "open" );
    		    			
    		    			$(".linkMostrarArchivo").click(
    		    					 mostrarArchivoProyecto
    		    			 );
    		    			
    			      }
    			  });
    			
    			
    		}
    );
    
    
    
    var pagProy = $('.linkDocProy').live("click",
    		function (e){ 
    			
    			e.preventDefault();
    			//idProyectoParam=$(this).text();
    			idProyectoParam=$(this).attr('name');
    			$.ajax({
    			      url: 'consultaDetalleProyecto.action',
    			      data: "idProyectoParam="+idProyectoParam,
    			      cache: false,
    			      type: "GET",
    			      success: function(datos){                   
    			          $("#divDetalleProyecto").html(datos);
    			          
    			          var $tabs = $("#tabs").tabs();
    			          $tabs.tabs('select', 2); 
    		    			$( "#divDetalleProyecto" ).dialog( "open" );
    		    			
    		    			$(".linkMostrarArchivo").click(
    		    					 mostrarArchivoProyecto
    		    			 );
    		    			
    			      }
    			  });
    			
    			
    		}
    );
    
    
    // boton ver detalle proyecto
    var pll = $('.btnDetProy').live("click",
    		function (e){ 
    			
    			e.preventDefault();
    			btn=$(this).attr('name');
    			if(btn=='btnAnp'){
    				anpsel='';
    				$('.checkListaAnp').each(
    				function(){
    					if(this.checked){
    					 var area=$(this).attr('name');
    					 var cod=$(this).attr('value');
    					anpsel+=(" <input type='hidden'  class='areasel' name='listaCodigosArea' value='"+cod+"' /><label class='lblReg' >"+area+"</label>") ;	
    					}
    						
    				}		
    				);
    				anpsel+='';
    				$('#divListaAnpSel').html(anpsel);
    				$('#divListaAnpSel').show();
    				$('#divModalAnp').dialog("close");
    			}
    			
    			else
    				if(btn=='btnEjec'){
        				ejecsel='<ul>';
        				$('.checkListaEjec').each(
        				function(){
        					if(this.checked){
        					 var ejec=$(this).attr('name');
        					 var cod=$(this).attr('value');
        					ejecsel+=(" <li><input type='hidden' name='listaCodigosEjecutor' value='"+cod+"' />"+ejec+"</li>") ;	
        					}
        						
        				}		
        				);
        				ejecsel+='</ul>';
        				$('#divListaEjecSel').html(ejecsel);
        				$('#divListaEjecSel').show();
        				$('#divModalEjec').dialog("close");
        			}	
    			
    			
    				else
        				if(btn=='btnFte'){
        					 //ftesel='<div class="rowReg">';
            				ftesel='<ul>';
            				ftesel="";
        					$('.checkListaFte').each(
            				function(i,e){
            					if(this.checked){
            					 var fte=$(this).attr('name');
            					 var cod=$(this).attr('value');
            					//ftesel+=(" <div class='rowReg'> <label class='etqReg'>  <input type='hidden' name='listaCodigosFte' value='"+cod+"' />"+fte+" </label> <input type='text' name='listaMontosFteFto.cantidad'  >"+"</div>") ;	
            					ftesel+=(" <li>   <input type='hidden' name='listaCodigosFte' value='"+cod+"' />"+fte+"<input type='text' name='listaMontosFteFto.cantidad'  />"+"</li>") ;	
            					}
            			
            				}		
            				);
            				// ftesel="";
            				 //ftesel+='</div>';
            				ftesel+='</ul>';
            				$('#divListaFteSel').html(ftesel);
            				$('#divListaFteSel').show();
            				$('#divModalFte').dialog("close");
            			}
    			
    		}
    );
    
    
      
});




//registrar archivo
function registroArchivo(){
	
	$("#formRegistroArchivo").submit();
	$("#txtArchivo").val('');
	var div = filediv.clone();
	$("#fileArchivo").val(''); 
    
}


function buscarPaginaProyectos() {
	 numeroPagina;
	$.ajax({
       url: 'consultaPaginaProyecto.action',
       data: "numeroPagina="+numeroPagina,
       cache: false,
       type: "GET",
       success: function(datos){                        
           $("#divListaProyectos").html(datos);
       }
   });
}

//crear proyectos
function nuevoProyecto(){
	$("#formInicioProyectos").attr('action','registroProyecto.action');
	$("#formInicioProyectos").submit();
}

//cancelar registro proyecto
function cancelarRegistroProyecto(){
	$("#formRegistroProyecto").attr('action','consultaProyecto.action');
	$("#formRegistroProyecto").submit();
}


//guardar registro proyecto
function registroProyecto(){
	var id=$("#hdproyecto").val();
	var cboCat= $("#cboCategoriaProyecto").val();
	var cboTp= $("#cboTipoProyecto").val();
	var cboEst= $("#cboEstadoProyecto").val();
	var cboM= $("#cboMoneda").val();
	var fini=$("#fechainicio").val();
	var ffin=$("#fechafin").val();
	var nom=$.trim( $("#txaNombProy").val() );
	
	if(nom==""){
		alert("Ingrese el nombre del proyecto");
		return;
	}
	if(cboCat==0){
		alert("Seleccione una categoria de proyecto");
		return;
	}
	if(cboTp==0){
		alert("Seleccione un tipo de proyecto");
		return;
	}
	if(cboEst==0){
		alert("Seleccione un estado del proyecto");
		return;
	}
	
	
	var idrol=$('#hdidrol').val();
	//alert(idrol);
	
	if(idrol!=1){//id rol administrador
		//incluir area usuaria
		var pertenecearea=0;
		var idarea=$('#hdareanatural').val();
		$(".areasel").each(
				function(i,e){
					if(idarea==$(this).val()){
						pertenecearea=1;
					}
				}	
		);
		if(pertenecearea==0){
			alert("Debe registrar un proyecto que involucre su area");
			return;
		}
		
	}
	
	
	//return ;
	
	//financieros
	var hdEjecFin=1;
	$("#camposEjecFinanciero .nomejecfin").each(
			function(i,e){
					if($.trim( $(this).val() )==0){
						hdEjecFin=0;
					}
			}	
	);
	if(hdEjecFin==0){
		alert("Ingrese el nombre del Ejecutor Financiero");
		return;
	}
	
	
	
	
	//tecnicos
	var hdEjecTec=1;
	$("#camposEjecTecnico .nomejectec").each(
			function(i,e){
					if($.trim( $(this).val() )==0){
						hdEjecTec=0;
					}
			}	
	);
	if(hdEjecTec==0){
		alert("Ingrese el nombre del Ejecutor Tecnico");
		return;
	}
	
	//fuentes financiamiento
	var hdFteFto=1;
	$("#camposFteFto .nomftefto").each(
			function(i,e){
					if($.trim( $(this).val() )==0){
						hdFteFto=0;
					}
			}	
	);
	if(hdFteFto==0){
		alert("Ingrese el nombre de la Fuente de Financiamiento");
		return;
	}
	
	//valida cbos moneda fuente
	var cbomoneda=1;
	$("#camposFteFto .rowftefto").each(
			function(i,e){
					if($(this).find('.idmonedaftefto').val()==0 ){
						
						cbomoneda=0;
					}
			}	
	); 
	
	if(cbomoneda==0){
		alert("Seleccione una Moneda para el aporte");
		return;
	}
	
	//valida cbo año fuente
	var cboaniotc=1;
	$("#camposFteFto .idanio").each(
			function(i,e){
				   
					if( $(this).parent().find('.idmonedaftefto').val()!=1 ){//distitnto soles
						if($(this).val()==0 ){
							cboaniotc=0;
						}	
					}
				   
			}	
	); 
	
	if(cboaniotc==0){
		alert("Seleccione un periodo para el tipo de cambio");
		return;
	}
	
	
	//valida cbo mes fuente
	var cbomestc=1;
	$("#camposFteFto .idmes").each(
			function(i,e){
				if( $(this).parent().find('.idmonedaftefto').val()!=1 ){//distitnto soles
					if($(this).val()==0 ){
						cbomestc=0;
				     }	
				}
				    
			}	
	); 
	
	if(cbomestc==0){
		alert("Seleccione un mes para el tipo de cambio");
		return;
	}
	
	
	
	
	
	//valida cbos tipocambio fuente
	var cbotipocambio=1;
	$("#camposFteFto .rowftefto").each(
			function(i,e){
				if($(this).find('.idmonedaftefto').val()!=1 ){//mondea sol
					if($(this).find('.idtipocambioftefto').val()==0 ){
						cbotipocambio=0;
					}
				}
				     
					
			}	
	); 
	
	
	
	
	
	
	
	$("#formRegistroProyecto").attr('action','guardaProyecto.action');
	 
	

	if( $("#hdproyecto").val() == 0 ){
		$( "#divModalMsgProy" ).dialog("open");
	}else{
		$("#formRegistroProyecto").submit();
		
	}
	
	
	
}






//agregar ejecutor financiero
function agregarEjecutorFinanciero(e){
	idgenejecfin++;
	n=idgenejecfin;
	i=n-1;
	row1=$('#divContRowEjecFin').clone();
	row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
	row= $(row2);
	row.find('.idcodproyejecfin').val(n);//codigo
	row.find('.tipobusquedaejecfin').change(
			function(e){
				paramAutocompletarEjecFin.opcion=$(this).val();
				row.find('.nomejecfin').val('');
			}
			
	);
	row.find('.nomejecfin').autocomplete(
			paramAutocompletarEjecFin
			);
	
	row.find('.i_supr').click(
			 quitarEjecFin
			);
	$('#camposEjecFinanciero').append(row);	
}

//quitar ejecutor financiero
function quitarEjecFin(e){
	 e.preventDefault();
	 $(this).parent().remove();
}


//agregar ejecutor tecnico
function agregarEjecutorTecnico(e){
	idgenejectec++;
	n=idgenejectec;
	i=n-1;
	row1=$('#divContRowEjecTec').clone();
	row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
	row= $(row2);
	row.find('.idcodproyejectec').val(n);//codigo
	//row.find('.idejectec').val(n);//codigo
	row.find('.tipobusquedaejectec').change(
			function(e){
				paramAutocompletarEjecTec.opcion=$(this).val();
				row.find('.nomejectec').val('');
			}
			
	);
	row.find('.nomejectec').autocomplete(
			paramAutocompletarEjecTec
			);
	
	row.find('.i_supr').click(
			 quitarEjecTec
			);
	$('#camposEjecTecnico').append(row);	
}



//agregar fuente financiamiento
function agregarFuenteFinanciamiento(e){
	idgenfte++;
	n=idgenfte;
	i=n-1;
	row1=$('#divContRowFteFto').clone();
	row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
	row= $(row2);
	row.find('.idftefto').val(n);//codigo
	row.find('.montoftefto').onlyDigits(true);
	row.find('.tipobusquedaftefto').change(
			function(e){
				paramAutocompletarFteFto.opcion=$(this).val();
				row.find('.nomftefto').val('');
			}
			
	);
	row.find('.nomftefto').autocomplete(
			paramAutocompletarFteFto
			);
	
	row.find('.idmonedaftefto').change(
			 ocultarFiltroTipoCambio
			);
	row.find('.idanio').change(
			filtracombotcmes
	);
	
	row.find('.idmes').change(
			 filtrartipocambio
			);
	/*
	row.find('.idmonedaftefto').change(
			 filtrartipocambio
			);
	*/		
	row.find('.i_supr').click(
			 quitarFteFto
			);
	$('#camposFteFto').append(row);	
}











function quitarEjecTec(e){
	 e.preventDefault();
	 $(this).parent().remove();
}







function editarDocumento(e){
	 e.preventDefault();
	 $('#divModalDoc').dialog("open");
	 $("#fileArchivo").val('');
	 //tipo
	 $('#hdTipoRegistroDoc').val(2);
	 //setear modal
	 cod=$(this).parent().find('.codigodocumento').val();
	 nom=$(this).parent().find('.nomdocumento').text();
	 arch=$(this).parent().find('.archivodocumento').html();
	 $('#divModalRegDoc').find('.hdModalDoc').val(cod);
	 $('#divModalRegDoc').find('.txtModalDoc').val(nom);
	 $("#divModalRegDoc").find('.divArchModalDoc').html(arch);
	 $('#spNumDoc').text(cod);
	 //$("#divModalRegDoc").find('.divArchModalDoc').find('.rowArchivo'). ('.i_remove').click(
	 $("#divModalRegDoc").find('.i_remove').click(
	 function(e){
				 e.preventDefault();
				 $(this).parent().remove();
			 }
    );
	 
}


function quitarDocumento(e){
	 e.preventDefault();
	 $(this).parent().remove();
}


function quitarFteFto(e){
	 e.preventDefault();
	 $(this).parent().remove();
}



function eliminarProyectos(e){
	$("#formInicioProyectos").attr('action','eliminaProyectos.action');
	$("#formInicioProyectos").submit();
}


function ocultarFiltroTipoCambio(e){
    var idcodigo=$(this).val();
	var $combo=$(this);
	$combo.parent().find('.idanio').hide();
	$combo.parent().find('.idmes').hide();
	$combo.parent().find('.valortipocambioftefto').hide();
	$combo.parent().find('.idanio').val(0);
	$combo.parent().find('.idmes').val(0);
	$combo.parent().find('.valortipocambioftefto').val('');
	if(idcodigo!=1){
		$combo.parent().find('.idanio').show();
		$combo.parent().find('.idmes').show();
		$combo.parent().find('.valortipocambioftefto').show();
	}
	

 
 
}



function filtracombotcmes(e){
	var $combo=$(this);
	$combo.parent().find('.idmes').val(0);
	$combo.parent().find('.valortipocambioftefto').val('');
	//$(this).parent().find('.idmes').val(0);
	//$(this).parent().find('.valortipocambioftefto').val('');
}



function filtrartipocambio(e){
	var idcodigo=$(this).val();
	var $combo=$(this);
	
	var idanio= $combo.parent().find('.idanio').val();
	var idmes= $combo.parent().find('.idmes').val();
	var idmoneda= $combo.parent().find('.idmonedaftefto').val();
	
	
	$combo.parent().find('.idtipocambioftefto').val(0);
	
	
    	var param="";
    	param+='&idanio='+idanio;
		param+='&idmes='+idmes;
		param+='&idmoneda='+idmoneda;
		$.ajax({
				url: "buscaTipoCambio.action",
				data: param,
				dataType: "json",
				 success: function (data) {
					 $combo.parent().find('.valortipocambioftefto').val('');
					var tc=data.tipocambio;
					var idtc=data.idtipocambio;
					if(tc==0){
						$combo.parent().find('.valortipocambioftefto').removeAttr('disabled');
					}
					else{
						$combo.parent().find('.idtipocambioftefto').val(idtc);
						$combo.parent().find('.valortipocambioftefto').attr('disabled',true);
						$combo.parent().find('.valortipocambioftefto').val(tc);
					}
				    
				 }
				 });
    	
        //}
}




$(".h").removeClass("h").hide();





/******** GENERAL ************/
function stringToDate(string) {
    var matches;
    if (matches = string.match(/^(\d{4,4})-(\d{1,2})-(\d{1,2})$/)) {
      return new Date(matches[1], matches[2], matches[3], 00, 00);
    } else {
      return null;
    };
  }
