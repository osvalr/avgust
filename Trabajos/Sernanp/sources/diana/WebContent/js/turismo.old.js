$(function(){
	var dialog,
	    dp = [],
		counter = 0,
		divboleto = null,
		formficha = null,
		checkRuta = false,
		step2 = $("#step2"),
		step3 = $("#step3"),
		ficha = $("#ficha"),
		secBoletos = $("#secBoletos"),
		fichawrapper = $("#fichawrapper"),
		message = $("#message"),
		q = $("#q"),
		//search = $("#search").submit(findFicha),
		search = $("#search #submit").live('click',findFicha),
		btnexppdf=$("#btnExportPDF"),
		submit = $("#submit"),
		form = $("#form_despacho"), 
		formModClaveUserOpTur = $("#formModClaveUserOpTur"), 
		//btnregficha=$("#btnregficha"),
		results = $("#results"),
		numerodoc = $("#form_numerodoc"),
		areanatural = $("#cbAreanatural").change(setRutas), 
		tipoturismo = $("#cbTipoturismo"), 
		rutaturismo = $("#cbRutaturismo").change(setTipos), 
		formAddRutaTurismo = $("#formAddRutaTurismo"),
		btnAddBoletos	= $("#btnAddBoletos").click(addBoletosRow),
		secBoletoRow = $("#secBoletoRow"),
		operadores = $("#operadores"),
		btnAddRutaTurismo = $("#btnAddRutaTurismo").click(addRutaTurismo),
		btnModClaveUserOpTur= $("#btnModClaveUserOpTur").click(modificarClaveOpTur),
		linkModClaveUserOpTur= $("#linkModClaveUserOpTur").click(abrirModalModificarClaveOpTur),
		hdModalUsuarioOpTurismo=$("#hdModalUsuarioOpTurismo"),
		txtIdturismo = $("#txtIdturismo"),
		totalpax = $("#totalpax"),
		overlay = $("#overlay"),
		divpax = $("#pax").appendTo("body"),
		wrapperpax = $("#paxs"),
		modalidad = $(".modalidad").click(verificarModalidad),
		noaplica = $(".numdoc").change(verificarDoc),
		addpax = $("#addpax").click(addPax),
		formModClaveUserOpTur=$("#formModClaveUserOpTur"),
		idgenguia=0,
		paramAutocompletarGuia= {
			opcion: 1,
			source: function (request, response) {
				$.ajax({
					url: ajax.buscaguiaturismo,
					data: "cadena="+request.term ,
					dataType: "json",
					 success: function (data) {
						 
						 guiasel = [];
						 $('#divListaGuiaTurismo').find('.rowguia').each(
								  function(e){
									  var idguia=$(this).find('.idguia').val();
									  if(idguia!=""){
										  guiasel.push(idguia); 
									  }									  
								  }		 
						  );
						 guialist= [];
						   for(var i in data.guias ){
								var noesta=0;
								for(var j in guiasel){
									if(data.guias[i].idguia==guiasel[j] ){
										noesta=1;
									}
								}
								if(noesta==0){
									guialist.push(data.guias[i]);
								}
							}
							
						 response($.map(guialist, function (item) {
					     return {
							id: item.idguia,
							value: item.apepat.toUpperCase()+' '+item.apemat.toUpperCase()+','+item.nombre.toUpperCase()	
									
								
							};
						}))
						 				
					 } 
				})},
				select: function( e, ui ) {
					var obj = ui.item;
					$(this).val(obj.value);
					$(this).parent().find('.idguia').val(obj.id);
					//$(this).parent().find('.idpersonalaprobacion').val(obj.id);
					return false;
		
				},
				
				minLength: 1
	    },
	    
		dialog = $( "#dialog" ).dialog({
				height: 100,
				autoOpen: false,
				title: 'Registrando Visitante', 
				modal: true
			}),
		modalOperadorTurismo = $( "#divModalUsuarioOpTurismo" ).dialog({
				height: 260,
				width:340,
				autoOpen: false,
				title: 'CAMBIO DE CONTRASE�A', 
				modal: true
			}),	
			
			print= $("#print").live('click',
					function(e){
						e.preventDefault();
						window.print();
					}
			
			); 
			/*	
		print= $("#print").click(function(e){
			e.preventDefault();
			window.print();
		});
		*/
	dom = $(".dom").addToDOM();
   
	
	if(hdModalUsuarioOpTurismo.val()==1){
		modalOperadorTurismo.dialog('open');
	}
	
	$('.nomcompguia').live('keypress',function(e){
    	if( $.trim($(this).text())==""){
    		$(this).parent().find('.idguia').val('');
    	}
       }
      		
    );
	
	$( ".fbus" ).each(function(i,e){
		
		dp.push( $(e).datepicker({
			changeMonth: true,
			changeYear: true,
			yearRange: '1900:2060',
			minDate:"-100Y",  
			maxDate: "+0",
		    dateFormat:"dd-mm-yy",
			//defaultDate:"-10Y",
			showOn: "both", 
			buttonImage: "img/16x16/apps/office-calendar.png",
			buttonImageOnly: true ,
			onSelect: function(dateText, inst) {
				if(this.name == "fregistroinicio"){
					//alert(dateText);
					
					sfecha= stringToDateF( dateText );
					dp[1].datepicker("setDate", sfecha );
					dp[1].datepicker( "option", "minDate", sfecha );
				}
				
			}
	
		}));	 
	});
	
	
	
	
	/*
$( ".fechanacvis" ).each(function(i,e){
		
		 $(e).datepicker({
			changeMonth: true,
			changeYear: true,
			//minDate:"-70Y",  
			//maxDate: "+70Y",
			yearRange: '2000:2060',
			dateFormat:"dd-mm-yy",
			//defaultDate:"-10Y",
			showOn: "both", 
			buttonImage: "img/16x16/apps/office-calendar.png",
			buttonImageOnly: true ,
			onSelect: function(dateText, inst) {
				alert('sss')
				
			}
	
		});	 
	});
	*/
	
	

	
	var buqava=$("#imgBusqDetFich").click(
			function(e){
				 e.preventDefault();
				 $("#divBusqDetFich").slideToggle();
			}	   
	);
	
	
	
	
	
	$('.linkareanat').click(
	  function(e){
		  var idarea=$(this).attr('param');
		    //alert(idarea);
			//var href=$(this).find('#param2').attr('value');
		    $('#formMenu #hdareanatural').val(idarea);
		    $('#formMenu').attr('action',ajax.turismomenu);
		    $('#formMenu').submit();
	  }		
	);
	
	
	/*
	$('.linkopeareanat').click(
			  function(e){
				  var idarea=$(this).attr('param');
				  //alert(idarea);
					//var href=$(this).find('#param2').attr('value');
				    $('#formMenu #hdareanatural').val(idarea);
				    $('#formMenu').attr('action',ajax.turismomenuope);
				    $('#formMenu').submit();
			  }		
	);
	*/
	
	
	/*
	 var dialogModalGuia = $( "#divModalGuia" ).dialog({
			autoOpen: false,
			width: 700,
			modal: true,
			title: "LISTADO DE GUIAS",
			close: function(event, ui) { 
				dialog.empty();
			}
	  });	 
	*/
	 var dialogModalRegTur = $( "#divModalRegTur" ).dialog({
			autoOpen: false,
			width: 600,
			modal: true,
			title: "REGISTRO TURISTA",
			close: function(event, ui) { 
				dialog.empty();
			}
	  });
	 
	 
	 var cerrar = $('.linkCerrar').live("click",
	    		function (e){
		        e.preventDefault();
		        	$(this).parents('.divmodal').dialog("close");
		        }
	 );
	 
	 
	 $('#linkAddGuia').click(
				function(e) {
					e.preventDefault();
					agregarGuiaTurismo(e);
				}
				
		
	);
	 
	 
	 /*
	 $('#btnSelGuia').live('click',
			 function(e){
		 	e.preventDefault();
		 	guiasel='';
		 	var i=0;
			$('.checkListaGuia').each(
			function(){
				if(this.checked){
				 var nomguia=$(this).attr('name');
				 var idguia=$(this).attr('value');
				guiasel+=(" <input type='hidden'  class='guiasel' name='fichaturismo.listaGuiaFichaturismo["+i+"].guia.idguia' value='"+idguia+"' /><label class='lblReg upperlbl' >"+nomguia+"</label>") ;	
				i++;
				}
					
			}		
			);
			guiasel+='';
			$('#divListaGuiaSel').html(guiasel);
			$('#divModalGuia').dialog("close");
		 	
	 }
			 
	 );
	 */
	 
	 
		$('#btnRegTur').click(
				  function(e){
					  
					  param= $("#formRegTurista").serialize();
					  $.ajax({
							url: ajax.guardaregvisitante,
							data: param,
							dataType: "json",
							 success: function (data) {
								 
							    
							 }
					  });
					  
					  var divregtur= $('#divModalRegTur');
					  if(divregtur.find('.idsexo').val()==0){
						  alert('Seleccione genero');
						  return false;
					  }
					  
					  /*
					  $('#visitante_'+idvis).find('.apepat').text($('#regTurista').find('.apepat').val());
					  $('#visitante_'+idvis).find('.apemat').text($('#regTurista').find('.apemat').val());
					  $('#visitante_'+idvis).find('.nombre').text($('#regTurista').find('.nombre').val());
					  $('#visitante_'+idvis).find('.fnac').text($('#regTurista').find('.fnac').val());
					  $('#visitante_'+idvis).find('.idsexo').text($('#regTurista').find('.idsexo').val());
					  $('#visitante_'+idvis).find('.idpais').text($('#regTurista').find('.idpais').val());
					  $('#visitante_'+idvis).find('.idtipodoc').text($('#regTurista').find('.idtipodoc').val());
					  $('#visitante_'+idvis).find('.numdoc').text($('#regTurista').find('.numdoc').val());
				      */
					  
					  $('#divModalRegTur').dialog('close');
				       cod=$('#hdfichaturismo').val();
					  $.ajax({
		    				url: ajax.editFicha,
		     	  	       data: 'idcodigo='+cod,
		     	  	       cache: false,
		     	  	       type: "GET",
		     	  	       beforeSend: function() {
		        	  	    $('#search .submit').attr("disabled","disabled");
		     	  	    	htmlesp=" <div style='text-align:center'> Espere mientras carga la ficha <br/> <img   src='css/loading.gif'  />  </div>";
		     	  	    	ficha.show();
		     	  	    	fichawrapper.html(htmlesp);
		     	  	    	results.hide();
		    	  	    }, 
		     	  	       success: function(datos){
		     	  	    	$('#search .submit').removeAttr("disabled");
		     	  	    	//ficha.show(); 
		    				fichawrapper.empty();
		    				//results.hide();   
		     	  	    	fichawrapper.html(datos);
							ficha.addClass("active");   
		     	  	    	$("#inFechaIngreso").datepicker({ 
								maxDate:"+0",
								dateFormat:datepickerOptions.dateFormat,
								buttonImage:datepickerOptions.buttonImage,
								buttonImageOnly: datepickerOptions.buttonImage, 
								showOn: datepickerOptions.showOn, 
								buttonImageOnly: datepickerOptions.buttonImageOnly
								}); 
		     	  	    	setFichaActions();  
		     	  	    	   
		     	  	       }
		    		     });
					  
					  
					  
				  
				  }		
		);
	 
	 
	$('.linkRegVis').live('click',
		function(e){
		e.preventDefault();
		 idvis= $(this).attr("name");
		 apepat=$.trim($('#visitante_'+idvis).find('.apepat').text());
		 apemat=$.trim($('#visitante_'+idvis).find('.apemat').text());
		 nombre=$.trim($('#visitante_'+idvis).find('.nombre').text());
		 fnac=$.trim($('#visitante_'+idvis).find('.fnac').text());
		 idpais=$.trim($('#visitante_'+idvis).find('.idpais').text());
		 idsexo=$.trim($('#visitante_'+idvis).find('.idsexo').text());
		 idtipodoc=$.trim($('#visitante_'+idvis).find('.idtipodoc').text());
		 numdoc=$.trim($('#visitante_'+idvis).find('.numdoc').text());
		 flagmayoredad=$.trim($('#visitante_'+idvis).find('.flagmayoredad').text());
		 $('#regTurista').find('.idvisitante').val(idvis);
		 $('#regTurista').find('.apepat').val(apepat);
		 $('#regTurista').find('.apemat').val(apemat);
		 $('#regTurista').find('.nombre').val(nombre);
		 $('#regTurista').find('.fnac').val(fnac);
		 $('#regTurista').find('.idsexo').val(idsexo);
		 $('#regTurista').find('.idpais').val(idpais);
		 $('#regTurista').find('.idtipodoc').val(idtipodoc);
		 $('#regTurista').find('.numdoc').val(numdoc);
		 $('#regTurista').find('.idtipodoc').change({doc :$('#regTurista').find('.numdoc')}, verificarDoc );
		 //div.find("select.tipodoc").change({doc :div.find("input.doc")}, verificarDoc ); 
		 
		 if(idtipodoc==0){
			 $('#regTurista').find('.numdoc').attr('disabled','disabled');
		 }
		 if(flagmayoredad==0){
			 datepickerOptions.minDate="-18Y"; 
		 }
		 datepickerOptions.maxDate="+0";
		 datepickerOptions.yearRange='1910:2011';
		 $("#fnacdialog").datepicker(datepickerOptions);
		 
		 /*
		 $("#fnacdialog").datepicker({ 
			   yearRange: '2000:2060',
				dateFormat:datepickerOptions.dateFormat,
				buttonImage:datepickerOptions.buttonImage,
				buttonImageOnly: datepickerOptions.buttonImage, 
				showOn: datepickerOptions.showOn, 
				buttonImageOnly: datepickerOptions.buttonImageOnly
		  });
		  */ 
		 //alert($(this).attr('apepat'));
		 
		 //alert($('#visitante_'+idvis).find('.nombre').text());
		 /*
		 $.post(ajax.editFicha,{q: code },function(data){
		 });
		 */
		 $('#divModalRegTur').dialog('open');
		 
		 
		 
	}
			
	); 
	 
	 
	 
	$('#cboanioreporte').change(
			  function(e){
				    var idanio=$(this).val();
				    if(idanio==0){
				    	alert("Seleccione un periodo");
				    	return ;
				    }
				   
				    //$('#hdreporteturismo').val(idanio);
				    $('#formReporteTurismo').attr('action',ajax.reporteturismo);
				    $('#formReporteTurismo').submit();
			  }		
	);
	
	
	$('#cbRutaturismo').change(
			function(e){	
			var idruta=$(this).val();
			$.post(ajax.consultatipoturismo,{idruta:idruta}, function(data) { 
			   $('#divtipoturismo').html(data);
			});
			
			$('.cbBoleto').each(
						function(i,e) {
							var opt="<option value=''>Seleccione</option>";
							$(this).html(opt);
						}	
			 );
			$('#paxs .txtobsvisitante').each(
					function(i,e) {
						$(this).val('');
					}	
		    );
			
			$('#paxs .fechanacvis').each(
				function (i,e) {
					$(this).val('');
				}	
			);
			
			}
	);
	
	if (dom.inFechaIngreso ){
		dom.inFechaIngreso.datepicker({ 
			minDate:"+0d",  
			maxDate: "+6m",
			dateFormat:"dd-mm-yy", 
			buttonImage:datepickerOptions.buttonImage,
			buttonImageOnly: datepickerOptions.buttonImage, 
			showOn: datepickerOptions.showOn,  
			buttonImageOnly: datepickerOptions.buttonImageOnly  
		});
	}
	
	/*
	if(dom.btnExportPDF){
		dom.btnExportPDF.live('click',exportarPDF);  //click( exportarPDF ); 
	}
    */
	
	//dom.btnExportPDF.live('click',exportarPDF);
	
	btnexppdf.live('click',exportarPDF);
	
	function exportarPDF(e){
		e.preventDefault();            
		location.href = ($.browser.msie? "":"turismo/" ) + "generateFichaPDF?ficha=" + this.name;     
	}
	
	var firstAddPax = true;
	addPax();
	//setFichaResultEvents();
	search.find(".onlydigits").onlyDigits(); 
	if(form.length){
		form[0].reset();  
	}
	
	function addInfoToFicha(i,e){ 
		var item =  dom[ e.getAttribute('params') ];
		var type = e.getAttribute("type");
		var title = e.getAttribute("title");
		var label = "";
		if(e.tagName =="SELECT"){
			label = e.options[e.selectedIndex].text;
		}else{
			label = ( type == "text" )? e.value  : title ;
		} 
		item.text(label); 
	}  
	
	function addActividadesToFicha(){
		var actividades = [];
		var label = ""; 
		$(".actividades").each(function(i,e){
			if(e.checked){
				actividades.push(e.getAttribute("title"));
			}
			label = e.getAttribute("params");
		});  
		if(actividades.length > 0 ){
			var listact=actividades.join(",");
			dom[label].text(listact);
		}else{
			dom.lbl_actividades.text("Ninguna");  
		}
	}
	
	function addTipoTurismoToFicha(){
		var tipoturismo = [];
		var labeltiptur = "";
		existe=0; 
		$(".tipoturismo").each(function(i,e){
			if(e.checked){
			    existe=1;
				labeltiptur+=e.getAttribute("title")+',';
			}
		});  
		if(existe==1 ){
			dom.lbl_tipoturismo.text(labeltiptur.substr(labeltiptur, (labeltiptur.length-1)  ));
		}else{
			dom.lbl_tipoturismo.text("Ninguna");  
		}
		
	}
	
	function addGuiasToFicha(){
		var guias = [];
		var labelguia = "";
		existe=0; 
		$("#divListaGuiaTurismo .rowguia").each(function(i,e){
			    existe=1;
			    //alert($(this).find('.nomcompguia').val());
				labelguia+=$(this).find('.nomcompguia').val()+';';
			
		});  
		if(existe==1 ){
			dom.lbl_guia.text(labelguia.substr(labelguia, (labelguia.length-1)  ));
		}else{
			dom.lbl_guia.text("Ninguna");  
		}
		
	}
	
	
	
	function modificarClaveOpTur(e){
		e.preventDefault();
		var param= formModClaveUserOpTur.serialize();
		var blancos=0;
		formModClaveUserOpTur.find('.txtclaveoptur').each(
		function(e){
			var txtcl=$.trim($(this).val());
			if(txtcl==""){
				blancos=1;
			}
		}		
		);
		if(blancos==1){
			 formModClaveUserOpTur.find('.msg').text('No ingrese espacios en blanco');
			return;
		}
		
		
		$.ajax({
			url: proyectoAction.modificaclave,
	  	       data: param,
	  	       cache: false,
	  	       type: "POST",
	  	       success: function(datos){ 
	  	    	 formModClaveUserOpTur.find('.txtclaveoptur').val('');
	  	    	   if(datos.respuesta==0){
	  	    		  formModClaveUserOpTur.find('#divModClaveUserOpTur').hide();
	  	    		formModClaveUserOpTur.find('.msg').text('Se modific� la clave con �xito');
	  	    		setTimeout(function(){ 
	  	    			modalOperadorTurismo.dialog('close');
	  	    		 },2000); 
	  	    	   }else
	  	    		 if(datos.respuesta==1){
	  	    		 formModClaveUserOpTur.find('.msg').text('Ingrese la clave correcta');
	  	    	     }
	  	    		else
		  	    		 if(datos.respuesta==2){
		  	    		 formModClaveUserOpTur.find('.msg').text('Ingrese claves iguales');
		  	    	     }
	  	       } 
	  	 });
		
		
		
	}
	
	
	function abrirModalModificarClaveOpTur(e){
		e.preventDefault();
		modalOperadorTurismo.dialog('open');
		formModClaveUserOpTur.find('.msg').text('');
		 formModClaveUserOpTur.find('#divModClaveUserOpTur').show();
		
	}
	
	
	
	
	
	
	function addRutaTurismo(e){
		e.preventDefault();  
		if(divboleto == null){ 
			divboleto = secBoletoRow.clone( true );
			secBoletoRow.remove();
			var divtemp = divboleto.clone().appendTo(secBoletos)
							.find(".i_remove").remove(); 
			  
		} 
	    dialog = $( "#windowAddRutaTurismo" ).dialog({ 
	    	title:"Agregar Sector Turistico a " +  
	    		areanatural[0].options[areanatural[0].selectedIndex].text,
	    	modal: true,
	    	width:800,
			buttons: { "Agregar":  saveRuta}  
	    });

		function saveRuta() { 
			Valid.init(formAddRutaTurismo.find(".valid"));   
			if(Valid.test()){ 	 
				if( $("input.checkbox:checked").length > 0  ){
					if( confirm("Esta seguro de grabar este Sector Turistico?") ){ 
						$.post(ajax.grabarRuta,formAddRutaTurismo.serialize(),
							function(r){ 
									if( typeof(r) == "object" ){   
										//alert("Se grabo el sector:" + $("#rutaturismo_nombrerutaturismo").val() ); 
									}else{
										//alert("Ah ocurrido algun error. contacte con Soporte Tecnico");
									}

									dialog.dialog("close");   
									areanatural.trigger("change");
								}); 
					}
				}else{
					alert("Agrege al menos 1 tipo de turismo para este Sector");
					$("input.checkbox:eq(0)").focus();
				}
			}
			 
		}
	}
	
	function addBoletosRow(e){
		e.preventDefault();
		var div = divboleto.clone();   
		secBoletos.append(
			div.html(div.html()
				.replace(/\[0\]/g,"["+( ++counter )+"]") )
				.find(".i_remove")
				.click(function(){ $(this).parent().remove();})
				.parent()
		);
	}
	function consolidarFicha(e){ 
		 
		Valid.init( $("#formficha .valid")  );  
		if ( Valid.test() ){ 
			if( !confirm("Esta seguro de consolidar esta Ficha. No podra hacer mas cambios.")){
				return false; 
			}
			var saveFicha = $("#saveFicha").addClass("disabled").attr("disabled","disabled");
			var updating = $('.updating').show();
			e.preventDefault();
			$.post(ajax.consolidarFicha,formficha.serialize(), function(data) { 
				if(data.save){ 
					updating.text('Ficha Consolidada');
					setTimeout(function(){ 
						q.val("");
						message.text("");
						ficha.hide().removeClass("active");
						getFichasPag(0);
						results.show();
						
					},2000); 
				  	
				}
			});
		}else{
			e.preventDefault();
		}
	}
	
	function findFicha(e){
		e.preventDefault();
		$('#divDetalleFicha').hide();
		$('#ficha').hide();
		results.show();
		loadAjax(true);
		var param= $("#search").serialize();
		param+='&control=2';
		param+='&numeropagina=1';
  		$.ajax({
	  	       url: ajax.consultaturismo ,
	  	       data: param,
	  	       cache: false,
	  	       type: "GET",
 	  	     beforeSend: function() {
 	  	    //$("#btnBuscarProyectos").attr("disabled","disabled");
 	  	    htmlesp=" <div style='text-align:center'> Consultando <br/> <img   src='css/loading.gif'  />  </div>";
 	  	    $("#results").html(htmlesp);	
 	  	    //$("#divListaProyectos").html(htmlesp);
	  	    }, 

	  	       success: function(datos){         
	  	    	 //$("#btnBuscarProyectos").removeAttr("disabled");
	  	    	 
	  	    	   $("#results").html(datos);
	  	         unloadAjax();
	  	       
	  	       }
	  	   });
	}
	
	
	$('.pagination a').live("click",
    		function (e){
		
    			e.preventDefault();
    			numeroPagina=$(this).attr('name');
    			
    			var param= $("#search").serialize();
    			param+='&control=2';
    			param+='&numeropagina='+numeroPagina;
    			$.ajax({
    				url: ajax.consultaturismo,
     	  	       data: param,
     	  	       cache: false,
     	  	       type: "GET",
     	  	       success: function(datos){                        
       	  	    	   results.show();
     	  	    	   //$("#results").show();
     	  	    	   $("#results").html(datos);
     	  	       }
    		   });
    		}
    ); 
	
	
	$('.linkDetalleFicha').live("click",
			function(e) {
		       e.preventDefault();
		       var idficha= $(this).attr('param');
		       $('#ficha').hide();
		       $("#results").show();
		      
		       $.ajax({
   				   url: ajax.detallefichaturismo,
    	  	       data: 'ficha='+idficha,
    	  	       cache: false,
    	  	       type: "GET",
    	  	       beforeSend: function() {
    	  	    	 $('#search .submit').attr("disabled","disabled");
      	  	    	htmlesp=" <div style='text-align:center'> Espere mientras carga la ficha <br/> <img   src='css/loading.gif'  />  </div>";
      	  	    $("#ficha").show();
      	  	    $("#fichawrapper").html(htmlesp);
      	  	 $("#results").hide();
      	  	       
     	  	    }, 
    	  	        success: function(datos){
    	  	        	$('#search .submit').removeAttr("disabled");
    	  	        	$("#fichawrapper").empty();
    	  	        	$("#fichawrapper").html(datos);
    	  	        	$("#ficha").addClass("active");  
    	  	        	
    	  	        	
    					$("#closeficha").click(function(){
    						$("#ficha").hide().removeClass("active");
    						results.show();
    					});
    	  	    	 
   				
    	  	       
    	  	      }
   		     });
		  }
	);
	
	
	
	$('.codigoficha').live("click",
    		function (e){
    			e.preventDefault();
    			var cod= $(this).attr('param');
    			$.ajax({
    				url: ajax.editFicha,
     	  	       data: 'idcodigo='+cod,
     	  	       cache: false,
     	  	       type: "GET",
     	  	       beforeSend: function() {
        	  	    $('#search .submit').attr("disabled","disabled");
     	  	    	htmlesp=" <div style='text-align:center'> Espere mientras carga la ficha <br/> <img   src='css/loading.gif'  />  </div>";
     	  	    	ficha.show();
     	  	    	fichawrapper.html(htmlesp);
     	  	    	results.hide();
    	  	    }, 
     	  	       success: function(datos){
     	  	    	$('#search .submit').removeAttr("disabled");
    				fichawrapper.empty();
    				fichawrapper.html(datos);
					ficha.addClass("active");   
					$("#inFechaIngreso").datepicker({ 
						maxDate:"+0",
						dateFormat:datepickerOptions.dateFormat,
						buttonImage:datepickerOptions.buttonImage,
						buttonImageOnly: datepickerOptions.buttonImage, 
						showOn: datepickerOptions.showOn, 
						buttonImageOnly: datepickerOptions.buttonImageOnly
						}); 
     	  	    	setFichaActions();  
     	  	    	   
     	  	       }
    		     });
    			
    			
    			
    			
    			
    		}
    );
	
	
	
	/* XHR Functions */
	function getFichaxCod( code, hasmessage ){ 
		$.post( ajax.check ,{ q: code },function(data){
			var msg = "";
			if( data.find == 1 ){
				ficha.show(); 
				fichawrapper.empty();
				results.hide();
				msg = "Ficha Encontrada" ;
				$.post(ajax.editFicha,{q: code },function(data){
					fichawrapper.html(data);
					ficha.addClass("active");
					$("#inFechaIngreso").datepicker({ 
							maxDate:"+0",
							dateFormat:datepickerOptions.dateFormat,
							buttonImage:datepickerOptions.buttonImage,
							buttonImageOnly: datepickerOptions.buttonImage, 
							showOn: datepickerOptions.showOn, 
							buttonImageOnly: datepickerOptions.buttonImageOnly
							}); 
					setFichaActions();
				});
			}else{
				ficha.hide().removeClass("active");
				results.show();
				msg = "Ficha No Encontrada" ;
			}
			if(hasmessage){
				message.html( msg ).addClass("error");
			}
			unloadAjax();
		},"json");
	}
	
	
	

	
	
	
	function setFichaActions(){
		formficha = $("#formficha").submit( consolidarFicha );
		var checkboxes = ficha.find("td input[type=checkbox]").click(function(){
			$(this).parent().parent().toggleClass("toRemove");
		});
		var rows = ficha.find("tr");
		$("#checkall").change(function(){
			if( this.checked ){
				rows.removeClass("toRemove");  
				checkboxes.attr("checked","checked");    
			}else{
				rows.addClass("toRemove");  
				checkboxes.removeAttr("checked"); 
			}
		});
		
		$("#closeficha").click(function(){
			ficha.hide().removeClass("active");
			results.show();
		});
		
	}
	
	function getFichasPag( num ){
		results.addClass("opaque");
		$.post(ajax.fichas,{ pag:num },setFichasResult);
	}
	/**********/
	
	function loadAjax(type ){
		q.addClass("loading").attr("readonly","readonly");
		submit.addClass("disabled").attr("disabled","disabled");
	}
	function unloadAjax(){
		submit.removeClass("disabled").removeAttr("disabled");
		q.removeClass("loading").removeAttr("readonly");
	}
	
	function addPax(){ 
		var size = wrapperpax.find(".pax").length;
		if (wrapperpax.length==0) return;
		var div = $( divpax.html().replace( /__/g, counter++ ) );
		datepickerOptions.dateFormat = "dd-mm-yy";
		datepickerOptions.onSelect= function(dateText, inst) {
			//usar parents.find('.cbBoleto')
			$cbo = $(this).parent().parent().parent().parent().find('.cbBoleto');
			idruta=$('#cbRutaturismo').val();
			fechanac=dateText;
			$.post(ajax.boletos, {idruta:idruta,fechanac:fechanac}, function(r) {
				options = "<option value=''>Seleccione</option>";
				options+="<option value='0'>No Aplica </option>";
				for(var i = 0,t=r.data.length; i<t;i++){
					var boleto = r.data[i]; 
					options += "<option value='"+ boleto.idboletaje+"'>" 
						+ boleto.nombreboletaje +  ': '+ boleto.obsboletaje + ' S/.' + boleto.valorboletaje
						+ "</option>"; 
				}
				$cbo.html(options);  
			},'json');
			
		};
		
		div.find("input.datepicker").datepicker(datepickerOptions);
		div.find("select.tipodoc").change({doc :div.find("input.doc")}, verificarDoc );  ////////////////////////
		div.find("select.pais").change( 
				{paterno:div.find("input.paterno"), materno:div.find("input.materno")} , 
				verificarApellidos );
		if (size == 0){
			div.find(".i_remove").remove(); 
		}else{
			div.find(".i_remove").click(deletePax);
		} 
		wrapperpax.append( div );
		div.find(".number").text("#"+( size+ 1 ) );
		div.find("select.cbBoleto").change( 
			function(e){
				var cbobol=$(this).val();
				if(cbobol==""){
					cbobol=-1;
				}
				 if(cbobol==0){
					div.find(".divobsvisitante").show();
					div.find(".txtobsvisitante").val('');
				 }else{
					div.find(".divobsvisitante").hide();
				 }
			}	
		);
	}

	function verificarDoc(e){
		e.data.doc.removeAttr("disabled").removeClass(Valid.options.norequired); 
		log = e.data.doc;
		if(this.value == "0" || this.value.length == 0){ //no aplica
			log.trigger("blur").attr("disabled","disabled")
				.addClass(Valid.options.norequired).val("");
		}else if(this.value == "1"){// si es dni
			log.attr("maxlength","8");
			log.onlyDigits();
		}else{ // si no es dni(pasaporte, ce)
			log.attr("maxlength","22");
			log.unbind("keydown").unbind("keyup").val("");  
		}
	}
	
	function verificarApellidos(e){ 
		var paterno = e.data.paterno.addClass("valid"),
			materno = e.data.materno.addClass("valid"); 
		var action = (this.value == 171)? "removeClass" : "addClass";
		paterno[action](Valid.options.norequired);
		materno[action](Valid.options.norequired);  
	}
	
	function setPager(e){
		e.preventDefault();
		getFichasPag(this.name);
	}
	
	function linkCodCodigoFicha(){
		getFichaxCod( $(this).text() ); 
	}
	
	function setFichasResult(r){
		results.html(r).removeClass("opaque");
		setFichaResultEvents();
	}
	 
	function setFichaResultEvents(){
		results.find(".pagination a").click(setPager);
		results.find("td.codigoficha").click(linkCodCodigoFicha);
	}
	
	function setRutas(e){
		if(this.value.length > 0){
			var val = this.value.split("|");
			btnAddRutaTurismo.show() ;	 	
			txtIdturismo.val(val[1]);
			//console.log("txtIdturismo.val",txtIdturismo.val())
			$.post(ajax.rutaturismo,{idarea:val[0]},function(r){
				if(r.data.length > 0){
					options ="";
					for(var i = 0,t=r.data.length; i<t;i++){ 
						var ruta = r.data[i]; 
						options += "<option value='"+ ruta.idrutaturismo+"'>" 
							+ ruta.nombrerutaturismo
							+ "</option>"; 
					}
					checkRuta = true; 
					rutaturismo.html(options);
					setTimeout(function(){ 
						rutaturismo.change();
					},500);
					 
				}else{
					rutaturismo.html("<option value=''>Agregar Ruta &gt;</option>");
				}
			}); 
		}else{
			btnAddRutaTurismo.hide() ;
		}
	}
	function setTipos(e){
		if( !checkRuta ){
			$(this.options[0]).remove();
			checkRuta = true;
		}
		step3.removeClass("block");
		submit.removeClass("disabled").removeAttr("disabled");
		var options ="";
		if(this.value == "") return;
		//console.log("VALUE FOR TIPOS", this.value);
		/*
		setTimeout(function(){
			tipoturismo.change();    
		},500);
		*/
		 
		
		
		
		/*
		$.post(ajax.boletos, {id:this.value}, function(r) {
			options = "<option value=''>Seleccione</option>";
			for(var i = 0,t=r.data.length; i<t;i++){
				var boleto = r.data[i]; 
				options += "<option value='"+ boleto.idboletaje+"'>" 
					+ boleto.nombreboletaje +  ': '+ boleto.obsboletaje + ' S/.' + boleto.valorboletaje
					+ "</option>"; 
			} 
			$(".cbBoleto").html(options);  
		},'json');
		*/
		
	} 
	
	function deletePax(){
		$(this.parentNode).parents(".pax").remove();
		wrapperpax.find(".number").each(function(i,e){
			$(e).text("#"+(i+1));  
		});
	}
	
	
	
	form.submit(  function(e){
		
		
		 //validar guias
		var guias=0;
		$('#divListaGuiaTurismo .rowguia').each(
		  function(e) {
			  var idguia=$(this).find('.idguia').val();
			  if(idguia==0){
				  guias=1;
			  }
		  }		
		);
		
		if(guias==1){
			alert('Seleccione un guia en el campo de texto');
			return false;
		}
        
		wrapperpax.find(".pax").each(function(i,e){ 
			if( $(e).find("select.pais").val() != 171 ){ 
				var apellidos = $(e).find("input.apellidos");  
				if( $.trim( apellidos.eq(0).val() ) == "" && $.trim( apellidos.eq(1).val() ) == "" ){ 
					apellidos.addClass( Valid.options.invalid ).removeClass("valid");
					var parent = apellidos.eq(0).parent(); 
					apellidos.find(".v_label").remove(); 
					parent.append( Valid.options.message.replace(/errors/, "Ingresar algun apellido") ); 
				} 
			};
		});
		
		
	   
		
		Valid.init(form.find(".valid")); 
		var tipoDoc = noaplica.attr("checked");
		e.preventDefault(); 
		/*
		 */
		
		validanombrecompleto=0;
		$('#paxs .pax').each(
		 function(e) {
			 
			apepat= $.trim( $(this).find('.paterno').val() );
			apemat= $.trim( $(this).find('.materno').val() );
			if(apepat=="" && apemat==""){
				validanombrecompleto=1;
			}
		}		
		);
		
		
		
		if($('#empresa').is(':checked')==true){
			agencia=$('#empresaturismo').val();
			operador=$('#operadorturismo').val();
			if(agencia==0 && operador==0){
				alert('Seleccione una agencia o un operador');
				return ;
			}
		}
		
		
		
		
		if(validanombrecompleto==1){
			alert('Ingrese al menos un apellido en uno de los turistas');
			return ;
		}
		
		
		
		if( Valid.test() ){  
			
			var paxs = wrapperpax.find(".pax"); 
			$(".addpreview").each(addInfoToFicha);
			addActividadesToFicha();
			addTipoTurismoToFicha();
			addGuiasToFicha();
			//addVisitanteToFicha(paxs);
			//dom.secPreviewVisitantes.html( addVisitanteToFicha(paxs) ) ;
			//dom.secPreviewVisitantes.html( addPaxToFicha(paxs) ) ;
			dom.secPreviewVisitantes.html( addPaxToFicha(paxs) ) ;
			dialog.empty().append( dom.secFichaDetalle.clone().show() ); 
			if(ie6){				
				$("select").hide();
			}
			dialog.dialog({ 
					title: 'Vista Previa de la Ficha de Registro', 
					width:800,
					height: (ie6? "auto" : 400), 
					autoOpen:true,  
					buttons: {  
						"Cancelar": function(){ 
							dialog.dialog("close");
							if(ie6){				
								$("select").show(); 
							}
						},
						"Confirmar": 
							function() {  
								form.find('select').each(function(i,e){  
									if(e.value =="null"){e.disabled=true;} 
								});   
								dialog.append("<strong>Guardando Ficha....</strong>");
								dialog.dialog( "option", "buttons", { } );  
								totalpax.val( paxs.length); 
								
								$.ajax({
									url: ajax.grabar,
									data: $("#form_despacho").serialize(),
									dataType: "json",
									 success: function (data) {
										var idf=data.idfichat;
										
										//dialog.html("<strong>Visitante Guardado</strong>");
										setTimeout(function(){
												window.location.href = ($.browser.msie? "":"turismo/" ) + "ficha.action?ficha="+idf;
											 
										},2000 );
									 }
									 });
								
								/*
								$.post(ajax.grabar,$("#form_despacho").serialize(), function(data) { 
									var idf=$('#idfichars').val();
									alert(idf);
									if($.trim(data)=="ok"){
										dialog.html("<strong>Visitante Guardado</strong>");
									}
									setTimeout(function(){
										if( !isNaN(data) ) {
											window.location.href = ($.browser.msie? "":"turismo/" ) + "ficha.action?ficha="+idf;
										} 
									},2000 );   
								});
								*/
								
								
								
								
								
								form.find('select').removeAttr("disabled");
							}},
					close:function(){
						if(ie6){				
							$("select").show();
						}
					}
				}); 
		}
		
	});
	
	
	
	function addVisitanteToFicha(paxs){
		var i=0,t=paxs.length,rows = [],trs = "";
		var rowt='';
		for(;i<t;i++){
			var arrpax = [] , 
				pax = $(paxs[i]).find("input,select");
			
			row1=$('#divContRowVisitante').clone();
			row2=row1.html();
			alert(row2);
			row= $(row2);
			row.find('.nombrecompleto').val(pax[1].value);
			dom.secPreviewVisitantes.append(row);
			/*
			arrpax.push( (i+1) ,  pax[1].value + " " +  pax[2].value + " ," + pax[0].value,
						pax[7].value ,
						pax[3].value,
						ddText( pax[4] ),
						ddText( pax[5] ), 
						ddText( pax[8] ));
			rows[i] = "<tr><td>" + arrpax.join("</td><td>") + "</td></tr>";
			*/
		} 
		
		//trs = rowt.join(" "); 
		//return trs;
	}
	
	function addPaxToFicha(paxs){
		var i=0,t=paxs.length,rows = [],trs = "";
		for(;i<t;i++){
			var arrpax = [] , 
				pax = $(paxs[i]).find("input,select");
			
			if($.trim(pax[7].value)==""){
				pax[7].value="------------------------------";
			}
			arrpax.push( (i+1) ,  pax[1].value.toUpperCase() + " " +  pax[2].value.toUpperCase() + " ," + pax[0].value.toUpperCase(),
						pax[7].value ,
						pax[3].value,
						ddText( pax[4] ),
						ddText( pax[5] ), 
						ddText( pax[8] ));
			rows[i] = "<tr><td>" + arrpax.join("</td><td>") + "</td></tr>";
		} 
		trs = rows.join(" "); 
		return trs;
	}
	
	
	function ddText( dd ){
		 return dd.options[dd.selectedIndex].text;
	};
	function verificarModalidad(e){
		step2.removeClass("block");
		//dom.lbl_modalidad.text( this.getAttribute("title") );
		if(this.getAttribute("id") == "individual"){
			operadores.slideUp().find("select").attr("disabled","disabled");
		}else{ 
			operadores.slideDown().find("select").removeAttr("disabled");
		}
	}
	
	
	
	
	//agregar guia
	function agregarGuiaTurismo(e){
		idgenguia++;
		n=idgenguia;
		i=n-1;
		row1=$('#divContRowGuia').clone();
		row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
		row= $(row2);
		row.find('.idcodguia').val(n);//codigo
		row.find('.nomcompguia').autocomplete(
				paramAutocompletarGuia
				);
	    row.find('.i_supr').click(
				 quitarRow
				);
		$('#divListaGuiaTurismo').append(row);	
	}
	
	function quitarRow(e){
		 e.preventDefault();
		 $(this).parent().remove();
	}
	
}); 


/*
ficha.show(); 
fichawrapper.empty();
results.hide();
msg = "Ficha Encontrada" ;
$.post(ajax.editFicha,{q: code },function(data){
	fichawrapper.html(data);
	ficha.addClass("active");
	$("#inFechaIngreso").datepicker({ 
			maxDate:"+0",
			dateFormat:datepickerOptions.dateFormat,
			buttonImage:datepickerOptions.buttonImage,
			buttonImageOnly: datepickerOptions.buttonImage, 
			showOn: datepickerOptions.showOn, 
			buttonImageOnly: datepickerOptions.buttonImageOnly
			}); 
	setFichaActions();
});
*/
