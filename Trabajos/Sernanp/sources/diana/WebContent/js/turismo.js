$(function(){
	var dialog,
	    dp = [],
	    arrayfechapropuesta = [],
		counter = 0,
		//idgenguia=0,
        divboleto = null,
		//formficha = null,
		checkRuta = false,
		step2 = $("#step2"),
		step3 = $("#step3"),
		ficha = $("#ficha"),
		secBoletos = $("#secBoletos"),
		fichawrapper = $("#fichawrapper"),
		message = $("#message"),
		q = $("#q"),
		formbusft=$('#search'),
		//search = $("#search").submit(findFicha),
		search = $("#search #submit").live('click',findFicha),
		btnexppdf=$("#btnExportPDF"),
		submit = $("#submit"),
		form = $("#form_despacho"), 
		//formModClaveUserOpTur = $("#formModClaveUserOpTur"), 
		//btnregficha=$("#btnregficha"),
		results = $("#results"),
		numerodoc = $("#form_numerodoc"),
		areanatural = $("#cbAreanatural").change(setRutas), 
		tipoturismo = $("#cbTipoturismo"), 
		//rutaturismo = $("#cbRutaturismo").change(setTipos), 
		formAddRutaTurismo = $("#formAddRutaTurismo"),
		btnAddBoletos	= $("#btnAddBoletos").click(addBoletosRow),
		secBoletoRow = $("#secBoletoRow"),
		operadores = $("#operadores"),
		btnAddRutaTurismo = $("#btnAddRutaTurismo").click(addRutaTurismo),
		btnModClaveUserOpTur= $("#btnModClaveUserOpTur").live('click',modificarClaveOpTur),
		linkModClaveUserOpTur= $("#linkModClaveUserOpTur").live('click',abrirModalModificarClaveOpTur),
		hdModalUsuarioOpTurismo=$("#hdModalUsuarioOpTurismo"),
		txtIdturismo = $("#txtIdturismo"),
		totalpax = $("#totalpax"),
		overlay = $("#overlay"),
		//divpax = $("#pax").appendTo("body"),
		divpax = $("#divContpax"),
		wrapperpax = $("#paxs"),
		modalidad = $(".modalidad").click(verificarModalidad),
		noaplica = $(".numdoc").change(verificarDoc),
		addpax = $("#addpax").click(addPax),
		formModClaveUserOpTur=$("#formModClaveUserOpTur"),
		formregft=$("#formRegistroFichaTurismo"),
		formregvis=$("#formRegVisitante"),
		formft=$("#formFichaTurismo"),
		formficha=$('#formficha'),
		btnSalirReg = $(".btnSalirReg").live('click',salirRegistro),
		tiporeg=formregft.find('.hdtiporegistro').val(),
		rutatursel=formregft.find('.cborutaturismo').val(),
		idgenguia=0,idgenactividad=0,idgenvisitante=0,idgenanptur=0,idgenpagoft,idopcionsel,
		rowtabsel,idvselfc,
		btnValidarPagobancoFichaturismo=$('#btnValidarPagobancoFichaturismo').live('click',validarPagobancoFichaturismo),
		btnValidarPagobancoFichaturismoxConsolidar=$('#btnValidarPagobancoFichaturismoxConsolidar').live('click',validarPagobancoFichaturismoxConsolidar),
		btnGuardarDatGenFichaTurismo=$('.btnGuardarDatGenFichaTurismo').live('click',guardarDatosGeneralesFichaTurismo),
		//btnGenerarFichaTurismo=$("#btnGenerarFichaTurismo").live('click',generarFichaTurismo),
		btnGuardaRegistroVisitante=$('#btnRegTur').click(guardarRegistroVisitante),
		//cbRutaturismo=$('#cbRutaturismo').change(cargarComboTipoBoletoxSeleccionRutaTurismo),
		cborutaturismo=formregft.find('.cborutaturismo').change(abrirModalConfirmacionModificacionRutaTuristica),
		//cborutaturismo=formregft.find('.cborutaturismo').change(guardaTemporalRegistroFichaTurismo),
		linkRegVisitante = $(".linkRegVisitante").live('click',irRegistroVisitante),
		opcionaccion=$('.opcionaccion').live('click',irOpcionesAccion),
		opcionaccionopetur=$('.opcionaccionopetur').live('click',irOpcionesAccionOperadorTurismo),
		opcionaccionguiatur=$('.opcionaccionguiatur').live('click',irOpcionesAccionGuiaTurismo),
		opcionaccionfichatur=$('.opcionaccionfichatur').live('click',irOpcionesAccionFichaTurismo),
		btnGuardarRegVisitante = $("#btnGuardarRegVisitante").live('click',guardarRegistroVisitanteFicha),
		btnAccionFichaTurismo= $(".btnAccionFichaTurismo").live('click',ejecutarAccionFichaTurismo),
		btnGuardarRegOpetur = $("#btnGuardarRegOperadorTurismo").live('click',guardarRegistroOperadorTurismo),
		btnValidarPagoIncompleto=$('#btnValidarPagoIncompleto').live('click',validarPagoIncompleto),
		btnGuardarRegGuiaTurismo = $("#btnGuardarRegGuiaTurismo").live('click',guardarRegistroGuiaTurismo),
		//btnAccionRegOpetur = $(".btnAccionRegOperadorTurismo").live('click',ejecutarAccionRegistroOperadorTurismo),
		btnBuscarOperadores = $("#btnBuscarOperadores").live('click',consultarOperadoresTurismo),
		cbochangeBuscarOperadores=$("#cboAnpTurOperadores").live('change',consultarOperadoresTurismo),
		btnBuscarGuias = $("#btnBuscarGuias").live('click',consultarGuiasTurismo),
		btnBuscarPagosbanco = $("#btnBuscarPagosBanco").live('click',consultarPagosBanco),
		cbochangeBuscarGuias=$("#cboAnpTurGuias").live('change',consultarGuiasTurismo),
		addanptur=$('#linkAddAnpTurismo').live('click',agregarAnpTurismo),
		addpagoftur=$('#linkAddPagoFichaTurismo').live('click',agregarPagoFichaTurismo),
		btnregrestclaveopetur=$("#formRegRestablecerClaveOperador #btnRestablecerClaveOperador").live('click',restablecerClaveOperador),
		btnlimpiar=$(".btnLimpiar").live('click',limpiarCampos),
		linkToggle=$(".linkToggleDiv").live('click',mostrarOcultarDiv),
	   //addguiaanptur=$('#linkAddGuiaAnpTurismo').live('click',agregarGuiaAnpTurismo),
		selecubig= $("#formRegOperadorTurismo").find('.cboubigeo').live('change',listarUbigeo),
		selecubigguia= $("#formRegGuiaTurismo").find('.cboubigeo').live('change',listarUbigeo),
		//checkrowtab=$('#tabListaVisitante .chkbox').live('click',seleccionarCasilla),
		selcasilla=$('.ttur .chkbox').live('click',seleccionarCasilla),
		seleccionarmodalidadpago=$('#divPagosFicha').find('.idmodalidadpagoft').live('change',seleccionarModalidadPago),
		linkBuscarPagoBanco=$('.linkConsultaPagoBanco').live('click',abrirModalPagoBancoFicha),
		linkSelPagoBanco=$('.linkSelPagoBanco').live('click',seleccionarPagoBanco),
		btnCargarPagosBanco=$('#btnCargarPagosBanco').live('click',cargarPagosBanco),
//		linkvolvermenu=$('.linkvolvermenu').live('click',volverMenu),
		opcionesFechaNacimiento = {
			changeMonth: true,
			changeYear: true,
			minDate:"-90Y",  
			maxDate: "-1Y",
			dateFormat:"dd-mm-yy",
			defaultDate:"-10Y",
			yearRange: '1910:2010', 
			showOn: "both", 
			buttonImage: "img/16x16/apps/office-calendar.png",
			buttonImageOnly: true 
		},
		
		cargarComboTipoBoletoxSeleccionFechaNacimiento =function(dateText, inst) {
		    //divvis= $('#'+inst.id).parents('.pax');
		    idruta=$('#cbRutaturismo').val();
			fechanac=dateText;
			cargarComboTipoBoletoxFechaNacimientoRutaTurismo(formregvis,fechanac,idruta);
			
	    },
		
	    

	    
	    
		//inicializarGuiasTurismo,
	    paramAutocompletarGuia= {
				opcion: 1,
				source: function (request, response) {
					$.ajax({
						url: turismoAction.t_buscaguiaturismo,
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
							 for(var i=0; i<data.guias.length ;i++ ){
									var noesta=0;
									for(var j=0;j<guiasel.length ;j++){
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
		    
		    
		    
		    paramAutocompletarAnpTurismo= {
					source: function (request, response) {
						$.post( turismoAction.t_buscaanptur , { cadena:request.term} ,function(datos){
							 listanptursel = [];
							 $('#divListaAnpTurismo').find('.rowanptur').each(
									  function(e){
										  var idanptur=$(this).find('.idturismo').val();
										  if(idanptur!=""){
											  listanptursel.push(idanptur); 
										  }									  
									  }		 
							  );
							 listanptur= [];
							   for( var i=0; i<datos.listanptur.length ;i++ ){
									var noesta=0;
									for(var j=0;j<listanptursel.length;j++){
										if(datos.listanptur[i].idturismo==listanptursel[j] ){
											noesta=1;
										}
									}
									if(noesta==0){
										listanptur.push(datos.listanptur[i]);
									}
								}
							response($.map(listanptur, function (item) {
							     return {
							    	 id: item.idturismo,
									value: item.categoriaanp.siglascategoriaanp+' '+item.desareanatural
									};
								}))
							
						},"json")
						
				      },
						select: function( e, ui ) {
							obj=ui.item;
							$(this).val(obj.value);
							$(this).parent().find('.idturismo').val(obj.id);
							return false;

						},
						
						minLength: 3
				},    
	    
	   modalConfirmacion = $("#divModalConfirmacion").dialog({
			 autoOpen: false 
		}),
	  
		  paramConfirmacionGenerarFichaTurismo={
				width: 200,
				modal: true,
				title: "  ",
				buttons: {    "Si": function() {
					generarFichaTurismo();
					}
		        ,     
		       "No": function() { 
		    	   modalConfirmacion.dialog('close');}
			 
			    }
	   },
		
	   paramConfirmacionConsolidarFichaTurismo={
				width: 200,
				modal: true,
				title: "  ",
				buttons: {    "Si": function() {
					modalConfirmacion.dialog('close');
					consolidarFichaTurismo();
					}
		        ,     
		       "No": function() { 
		    	   modalConfirmacion.dialog('close');}
			 
			    }
	   },
	   
	   paramConfirmacionGenerarConsolidarFichaTurismo={
				width: 200,
				modal: true,
				title: "  ",
				buttons: {    "Si": function() {
					generarConsolidarFichaTurismo();
					}
		        ,     
		       "No": function() { 
		    	   modalConfirmacion.dialog('close');}
			 
			    }
	   },
	   
	   paramConfirmacionEliminarOperador={
				width: 200,
				modal: true,
				title: "  ",
				buttons: {    "Si": function() {
					ejecutarAccionListadoOperadores(opcion);
					}
		        ,     
		       "No": function() { 
		    	   modalConfirmacion.dialog('close');}
			 
			    }
	   },
	   
	   paramConfirmacionGenerarClaveOperador={
				width: 400,
				height:120,
				modal: true,
				title: "  "
	   },
	   
	   paramConfirmacionEliminarGuia={
				width: 200,
				modal: true,
				title: "  ",
				buttons: {    "Si": function() {
					ejecutarAccionListadoGuias(opcion);
					}
		        ,     
		       "No": function() { 
		    	   modalConfirmacion.dialog('close');}
			 
			    }
	   },
	   
	   
	   paramConfirmacionAccionFichas={
				width: 200,
				modal: true,
				title: "  ",
				buttons: {    "Si": function() {
					ejecutarAccionListadoFichas(opcion);
					}
		        ,     
		       "No": function() { 
		    	   modalConfirmacion.dialog('close');}
			 
			    }
	   },
	   
	   
	   paramConsultarPagoBancoFicha={
				width: 300,
				height :200,
				modal: true,
				title: "PAGO BANCO"
	   },
	   
	   
	   paramConfirmacionActualizarBoletajeVisitantes={
				width: 200,
				modal: true,
				title: "  ",
				buttons: {    "Si": function() {
					 modalConfirmacion.dialog('close');
					 $.post(turismoAction.t_guardaregfichaturismo,formregft.serialize(),function(datos){
						 rutatursel=formregft.find('.cborutaturismo').val();
						 actualizarBoletajaVisitantes();
						});
					
					}
		        ,     
		       "No": function() { 
		    	   modalConfirmacion.dialog('close');
		    	   formregft.find('.cborutaturismo').val(rutatursel); 
		       }
			 
			    }
	            ,
	            closeOnEscape: false ,
	            closeText: 'hide' 
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
				title: 'CAMBIO DE CONTRASE\xD1A', 
				modal: true
			}),	
			
			printt= $("#print").live('click',
					function(e){
						e.preventDefault();
						window.print();
					}
			
			); 
				
			
			
			
//		printt= $("#print").click(function(e){
//			e.preventDefault();
//			window.print();
//		});
		
	dom = $(".dom").addToDOM();
   
	$('.onlydigits').onlyDigits();
	
	idgenguia=$('#idultguia').val();
	idgenactividad=$('#idultactividad').val();
	idgenvisitante=$('#idultvisitante').val();
	
	$('#divListaGuiaTurismo .i_supr').click(
		     quitarRow
	);
		
	
	seleccionarCasillas($('#divtipoturismo .tipoturismo'), $('#divtipoturismosel .idtipoturismo'));
	
	//seleccionarCasillas($('#divactividadturismo .actividades'), $('#divactividadturismosel .idactividadturismo'));
	seleccionarCasillas($('#divtipoturismo .actividades'), $('#divactividadturismosel .idactividadturismo'));
	
	
	$('#formRegistroFichaTurismoEdit #paxs .pax').each(
		function(i,e) {
			habilitarCamposVisitante($(this));
		}	
	
	);

	habilitarLimpiarNombreGuia();
	
	$('#form_despacho #paxs .pax').each(
			function(i,e) {
				habilitarCamposVisitante($(this));
			}	
	);
	
	
	
	//tabs
	//idficha=$('#formRegistroFichaTurismo .hdfichaturismo').val();
	var tabsregft = $("#tabsRegFichaTurismo");
	idficha=formregft.find('.hdfichaturismo').val();
	tabsregft.find('#tab2').attr('href',turismoAction.t_listavisxficha+'?'+(+new Date().getTime())+'&idfichaturismo='+idficha);
	tabsregft.tabs({
		load: function(event, ui) {
			//por el ie refrescar action del tab
			idficha=formregft.find('.hdfichaturismo').val();
			tabsregft.tabs( "url" , 1 , turismoAction.t_listavisxficha+'?'+(+new Date().getTime())+'&idfichaturismo='+idficha);
		
		}	
	}		
	);
	if(tiporeg==valueConstants.tipo_registro_crear){
		tabsregft.tabs("disable",1);
	}
//	$('#divtipoturismo .tipoturismo').each(
//			function(e) {
//				if(this.checked==false){
//					ind=$(this).val();
//					$("#divactividadturismo #divactividadturismo"+ind).remove();
//				}
//			}	
//	);
	$('#divtipoturismo .divtipoturismo').each(
			function(e) {
				if($(this).find('.tipoturismo').is(':checked')==false){
					$(this).find('.actividadturismo').html('');
				}
			}	
	);
	if(hdModalUsuarioOpTurismo.val()==1){
		modalOperadorTurismo.dialog('open');
	}
	
	$('#divListaGuiaTurismo').find('.nomcompguia').autocomplete(
			paramAutocompletarGuia
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
					sfecha= stringToDateF( dateText );
					dp[1].datepicker("setDate", sfecha );
					dp[1].datepicker( "option", "minDate", sfecha );
				}	
			}
		}));	 
	});
	
	
	$( ".fpropuesta" ).each(function(i,e){
		arrayfechapropuesta.push( $(e).datepicker({
			changeMonth: true,
			changeYear: true,
			yearRange: '1900:2060',
			minDate:"-100Y",  
			maxDate: "+2Y",
		    dateFormat:"dd-mm-yy",
			//defaultDate:"-10Y",
			showOn: "both", 
			buttonImage: "img/16x16/apps/office-calendar.png",
			buttonImageOnly: true ,
			onSelect: function(dateText, inst) {
				if(this.name == "fpropuestainicio"){
					sfecha= stringToDateF( dateText );
					arrayfechapropuesta[1].datepicker("setDate", sfecha );
					arrayfechapropuesta[1].datepicker( "option", "minDate", sfecha );
				}	
			}
		}));	 
	});
	
	var buqava=$("#imgBusqDetFich").click(
			function(e){
				 e.preventDefault();
				 $("#divBusqDetFich").slideToggle();
			}	   
	);
		
	$('.linkareanat').click(
	  function(e){
		  var idarea=$(this).attr('param');
		  $('#formListaAnpTurismo').find('#hdareanatural').val(idarea);
		    $('#formListaAnpTurismo').attr('action',turismoAction.t_anpturismo);
		    $('#formListaAnpTurismo').submit();
	  }		
	);
	
	 var dialogModalRegTur = $( "#divModalRegTur" ).dialog({
			autoOpen: false,
			width: 600,
			modal: true,
			title: "REGISTRO TURISTA",
			close: function(event, ui) { 
				$('#formRegTurista').find(".valid").
				removeClass(Valid.options.valid).
				removeClass(Valid.options.invalid).
				addClass(Valid.options.focus).
				parent().find(".v_label").remove();
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
	 
	 
		
	 
	 
	$('.linkRegVis').live('click',
		function(e){
		e.preventDefault();
		 idvis= $(this).attr("name");
		 divvis=$('#visitante_'+idvis);
		 apepat=$.trim(divvis.find('.apepat').text());
		 apemat=$.trim(divvis.find('.apemat').text());
		 nombre=$.trim(divvis.find('.nombre').text());
		 fnac=$.trim(divvis.find('.fnac').text());
		 idpais=$.trim(divvis.find('.idpais').text());
		 idsexo=$.trim(divvis.find('.idsexo').text());
		 idtipodoc=$.trim(divvis.find('.idtipodoc').val());
		 numdoc=$.trim(divvis.find('.numdoc').text());
		 grupoedad=divvis.find('.grupoedad').val();
		 if(numdoc=='null'){
			 numdoc="";
		 }
		 regtur=$('#regTurista');
		 regtur.find('.idvisitante').val(idvis);
		 regtur.find('.paterno').val(apepat);
		 regtur.find('.materno').val(apemat);
		 regtur.find('.nombre').val(nombre);
		 regtur.find('.fnac').val(fnac);
		 regtur.find('.idsexo').val(idsexo);
		 regtur.find('.idpais').val(idpais);
		 regtur.find('.tipodoc').val(idtipodoc);
		 regtur.find('.numdoc').val(numdoc);
		 habilitarCamposVisitante(regtur);
		 if(idtipodoc==0){
			 regtur.find('.numdoc').attr('disabled','disabled');
		 }
		 factual = new Date();
         anioactual=factual.getFullYear();
         if(grupoedad==valueConstants.grupo_edad_mayoredad){
        	 mindate="-101Y";
			 anioactual=anioactual-12;
			 rango='1910:'+anioactual;
         }
         else
        	 if(grupoedad==valueConstants.grupo_edad_menoredad || 
        			 grupoedad==valueConstants.grupo_edad_infante	   ){
        		 mindate= "-12Y";
        	     rango='1910:2011'; 
             }
         regtur.find('.fechanacvis').datepicker("option","minDate",mindate);
         regtur.find('.fechanacvis').datepicker("option","yearRange",rango);
         regtur.find('.fechanacvis').datepicker("option","onSelect",function(){});
         idvselfc=$(this).attr("name");
         $('#divModalRegTur').dialog('open');
		 
		 
		 
	}
			
	); 
	 
	
	$('#divtipoturismo .tipoturismo').click(
			  function(e){
				     idtipotur=$(this).val();
				     nomtipotur=$(this).attr('title');
				     if(this.checked){
				    	$.post(turismoAction.t_consultaractividadxtipoturismo, {idparam:idtipotur}, function(datos) {
//				    		rowdiv=$('#divFsActividadTurismo').clone();
//				    		rowdiv2 =rowdiv.html().replace(/_i/g,$idtipo);
//				    		rowdiv3= $(rowdiv2);
//				    		rowdiv3.find('.nomtipoturismo').text($nomtipo);
//				    		$('#divactividadturismo').append(rowdiv3);
				    		$('#divtipoturismo'+idtipotur).find('.actividadturismo').append('<div style="margin-left:15px:">Actividades</div>');
				    		for(var i = 0,t=datos.listaActividadturismo.length; i<t;i++){
				    			idgenactividad++;
				    			var activ = datos.listaActividadturismo[i]; 
								row1=$('#divContActividadTurismo').clone();
					    		row2 =row1.html().replace(/_i/g,idgenactividad);
					    		row= $(row2);
					    		row.find('.actividades').attr('title',activ.nombreactividadturismo);
					    		row.find('.actividades').attr('value',activ.idactividadturismo);
					    		row.find('.checkboxLabel').attr('param',activ.tipoturismo.idtipoturismo);
					    		row.find('.checkboxLabel').text(activ.nombreactividadturismo);
					       		//$('#divactividadturismo'+$idtipo).find('#divactividadesturismo').append(row);
					    		$('#divtipoturismo'+idtipotur).find('.actividadturismo').append(row);
							}
							  
						},'json');	
				    
				    }
				    else{
				    	$('#divtipoturismo'+idtipotur).find('.actividadturismo').html('');

				    	
				    }
			  }		
	);
	

	
	 
	$('#cboanioreporte').change(
			  function(e){
				    var idanio=$(this).val();
				    if(idanio==0){
				    	alert("Seleccione un periodo");
				    	return ;
				    }
				    $('#formReporteTurismo').attr('action',turismoAction.t_reporteturismo);
				    $('#formReporteTurismo').submit();
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
	
	
	
	btnexppdf.live('click',exportarPDF);
	
	function exportarPDF(e){
		e.preventDefault();            
		idf = $("#idfichaturismo").val();
		descargarFichaTurismo(idf);
	}
	
	var firstAddPax = true;
	//addPax();
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
		//var param= formModClaveUserOpTur.serialize();
		var blancos=false;
		var longmenor=false;
		formModClaveUserOpTur.find('.txtclaveoptur').each(
		function(e){
			var txtcl=$.trim($(this).val());
			if(txtcl==""){
				blancos=true;
			}
		}		
		);
		if(blancos){
			formModClaveUserOpTur.find('.msg').text('No ingrese espacios en blanco');
			mostrarMensajeMomentaneo(formModClaveUserOpTur, 'msg');
			return;
		}
		formModClaveUserOpTur.find('.txtclavenew').each(
				function(e){
					if($(this).val().length<valueConstants.longitud_minimo_clave){
						longmenor=true;
					}
				}		
		);
		if(longmenor){
			formModClaveUserOpTur.find('.msg').text('7 caracteres como m\u00EDnimo');
			mostrarMensajeMomentaneo(formModClaveUserOpTur, 'msg');
			return;
		}
		
		formModClaveUserOpTur.find('#btnModClaveUserOpTur').attr('disabled','disabled');
        $('.ui-dialog-titlebar-close ui-corner-all').hide();
		$.post(proyectoAction.modificaclave,formModClaveUserOpTur.serialize(),function(datos){
			$('.ui-dialog-titlebar-close ui-corner-all').show();
			formModClaveUserOpTur.find('.txtclaveoptur').val('');
			formModClaveUserOpTur.find('#btnModClaveUserOpTur').removeAttr('disabled');
			if(datos.respuesta==0){
				formModClaveUserOpTur.find('.msg').text('Se modific\u00F3 la clave con \u00E9xito');
   			    mostrarMensajeMomentaneo(formModClaveUserOpTur, 'msg');
				$('#btnModClaveUserOpTur').attr('disabled','disabled');
   			    //formModClaveUserOpTur.find('#divModClaveUserOpTur').hide();
	    		//formModClaveUserOpTur.find('.msg').text('Se modific\u00F3 la clave con \u00E9xito');
	    		setTimeout(function(){ 
	    			modalOperadorTurismo.dialog('close');
	    			$('#btnModClaveUserOpTur').removeAttr('disabled');
	    			//modalOperadorTurismo.css('display','none');

	    		 },2000); 
	    	   }else
	    		 if(datos.respuesta==1){
	    			 formModClaveUserOpTur.find('.msg').text('Ingrese la clave correcta');
	    			 mostrarMensajeMomentaneo(formModClaveUserOpTur, 'msg'); 
	    	     }
	    		else
	  	    		 if(datos.respuesta==2){
	  	    			formModClaveUserOpTur.find('.msg').text('Ingrese claves iguales');
		    			 mostrarMensajeMomentaneo(formModClaveUserOpTur, 'msg');	 
	  	    	     }

		},'json');
		
		

		
		
		
	}
	
	
	function abrirModalModificarClaveOpTur(e){
		e.preventDefault();
		formModClaveUserOpTur.find('.txtclaveoptur').val('');
		modalOperadorTurismo.css('display','block');
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
	
	
	function abrirModalConfirmacionConsolidacion() {
		formficha=$('#formficha');
		Valid.init(formficha.find(".valid"));   
		if(Valid.test()){ 
		modalConfirmacion.html(mensajes.confirmacionconsolidarficha);    
		modalConfirmacion.dialog(paramConfirmacionConsolidarFichaTurismo);
		modalConfirmacion.dialog('open');
		}
	}
	

	function consolidarFichaTurismo(e){
		//validar q no ingrese monto mayor en voucher
		$.post(turismoAction.t_validamontopagobanco,formficha.serialize(),function(datos){
			 pasamonto=datos.pasamonto;
			 if(!pasamonto){
				 //consolidar
				 $.post(turismoAction.t_consolidarfichaturismo,formficha.serialize(), function(datos) { 
						if(datos.msgconsolidacion==1){
							//mostrarMensajeMomentaneo(formficha, 'msgmontopagadormenor');
							mostrarMensajeMomentaneo($('.msgmontopagadormenor'));
						}else{
							alert(mensajes.exitoconsolidacionficha);
							window.location.href=($.browser.msie?'':turismoAction.turismo)+turismoAction.consultafichaturismo;
						}				
					},'json');
			 }else{
				 mostrarMensajeMomentaneo($('.msgpasamontovoucher'));
			 }
		},'json');
		
		
	}
	
//	
//	function consolidarFichaTurismo(e){ 
//		formficha=$("#formficha");
//		Valid.init( $("#formficha .valid")  );  
//		if ( Valid.test() ){ 
////			if( !confirm("Esta seguro de consolidar esta Ficha. No podra hacer mas cambios.")){
////				return false; 
////			}
//			//var saveFicha = $("#saveFicha").addClass("disabled").attr("disabled","disabled");
//			//var updating = $('.updating').show();
//			e.preventDefault();
//			$.post(turismoAction.t_consolidarfichaturismo,formficha.serialize(), function(datos) { 
//				if(datos.msgconsolidacion==1){
//					mostrarMensajeMomentaneo(formficha, 'msgmontopagadormenor');
//				}else{
//					//mostrarMensajeMomentaneo(formficha, 'msgfichaconsolidada');
//					window.location.href=($.browser.msie?'':turismoAction.turismo)+turismoAction.consultafichaturismo;
//				}				
//			},'json');
//		}else{
//			e.preventDefault();
//		}
//	}
	
	function findFicha(e){
		e.preventDefault();
		cerrarModal($('#divDetalleFicha'), $('#results'));
		btn=$(this);
		btn.attr('disabled','disabled');
		var param= $("#search").serialize();
		param+='&idcontrol=1';
		param+='&numpagina=1';
		 htmlesp=" <div style='text-align:center'> Consultando <br/> <img   src='css/loading.gif'  />  </div>";
		$("#results").html(htmlesp);
		$.post(turismoAction.t_consultafichaturismo, param, function(datos) { 
			$("#results").html(datos);
			btn.removeAttr('disabled');
 	    });
		

  		
	}
	
	

	$('#formInicioPagoFichaturismo #btnBuscarPagoFichaturismo').live("click",
			function(e) {
		    e.preventDefault();
		    if( $.trim($('#formInicioPagoFichaturismo').find('.numficha').val())!='' ){
		    	
		    	 $.post(turismoAction.t_consultadetallepagofichaturismo, $('#formInicioPagoFichaturismo').serialize(), function(datos) {
				    	$('#divDetallePagoFichaturismo').html(datos);  
				    	$('#divDetallePagoFichaturismo').css('display','block');
				    	$('#divListaPagoFichaturismo').css('display','none');
				    	//$('#divPagoFichaturismo').addClass('detallePagoFicha');
				    	$('#linkClose').show();
				    	$("#closeficha").click(function(){
				    		$('#divDetallePagoFichaturismo').css('display','none');
					    	$('#divListaPagoFichaturismo').css('display','block');
				    		$('#linkClose').hide();
						});
				    });
		    	
		    }
		   		    
			}			
	);
	
	
	$('#divlinkpaginacionlistapago a').live("click",
			function(e) {
		    e.preventDefault();
		    numpagina=$(this).attr('name');
		    btn=$(this).attr('param');
		    htmlesp=" <div style='text-align:center'> Espere  <br/> <img   src='css/loading.gif'  />  </div>";
		    $('#formInicioPagoFichaturismo #codigoficha').val('');
		    param=$('#formInicioPagoFichaturismo').serialize()+'&numpagina='+numpagina+'&idcontrol=1';
		    $.post(turismoAction.t_consultapagosfichaturismo,param,function(datos){
		    	$('#divListaPagoFichaturismo').html(datos);
		    });
			}			
	);
	
	
	$('#divlinkpaginacionlistaoperador a').live("click",
			function(e) {
		    e.preventDefault();
		    numpagina=$(this).attr('name');
		    btn=$(this).attr('param');
		    htmlesp=" <div style='text-align:center'> Espere  <br/> <img   src='css/loading.gif'  />  </div>";
		    param=$('#formInicioOperadorTurismo').serialize()+'&numpagina='+numpagina+'&idcontrol=1';
		    $.post(turismoAction.t_consultaoperadorturismo,param,function(datos){
		    	$('#divListaOperadorTurismo').html(datos);
		    });
			}			
	);
	
	
	$('#divlinkpaginacionlistaguia a').live("click",
			function(e) {
		    e.preventDefault();
		    numpagina=$(this).attr('name');
		    btn=$(this).attr('param');
		    htmlesp=" <div style='text-align:center'> Espere  <br/> <img   src='css/loading.gif'  />  </div>";
		    param=$('#formInicioGuiaTurismo').serialize()+'&numpagina='+numpagina+'&idcontrol=1';
		    $.post(turismoAction.t_consultaguiaturismo,param,function(datos){
		    	$('#divListaGuiaTurismo').html(datos);
		    });
			}			
	);
	
	
	$('#divlinkpaginacionlistapagobanco a').live("click",
			function(e) {
		    e.preventDefault();
		    numpagina=$(this).attr('name');
		    btn=$(this).attr('param');
		    htmlesp=" <div style='text-align:center'> Espere  <br/> <img   src='css/loading.gif'  />  </div>";
		    param=$('#formInicioPagoBancoFichaturismo').serialize()+'&numpagina='+numpagina+'&idcontrol=1';
		    $.post(turismoAction.t_consultapagobancofichaturismo,param,function(datos){
		    	$('#divListaPagoBancoFichaturismo').html(datos);
		    });
			}			
	);
	
	$('.pagination a').live("click",
    		function (e){
    			e.preventDefault();
    			numeroPagina=$(this).attr('name');
    			var param= $("#search").serialize();
    			param+='&idcontrol=1';
    			param+='&numpagina='+numeroPagina;
    			$.post(turismoAction.t_consultafichaturismo,param, function(datos) {	
    				results.show();
    				$("#results").html(datos);
    			});
    		}
    ); 
	
	
//	$('.linkDetalleFicha').live("click",
//			function(e) {
//		       e.preventDefault();
//		       var idficha= $(this).attr('param');
//		       tipopag=$(this).attr('param2');
//		       if(tipopag==valueConstants.tipo_pag_registro){
//		    	   irRegistroFichaTurismo(idficha);
//		       }else
//		    	   if(tipopag==valueConstants.tipo_pag_detalle){
//		    	    consultarDetalleFichaTurismo(idficha);
//		       }      
//		  }
//	);
	
	
	
	$('.linkAccesoFicha').live("click",
			function(e) {
		       e.preventDefault();
		       var idficha= $(this).attr('param');
               opcf=$(this).attr('name');
		       $.post(turismoAction.t_consultaminfichaturismo,{idfichaturismo:idficha},function(datos){
		    	   ft=datos.fichaturismo;
		    	   if(ft.codigoficha==""){
		    		   irRegistroFichaTurismo(idficha);
		    	   }else{
		    		   if(opcf==valueConstants.opcion_ver){
		    			   consultarDetalleFichaTurismo(idficha); 
		    		   }else
		    			   if(opcf==valueConstants.opcion_descargar){
			    			 descargarFichaTurismo(idficha);  
			    		   }
		    		     
		    	   }
		       });		            
		  }
	);
	
	
//	$('.linkFichaConsolidada').live("click",
//			function(e) {
//		       e.preventDefault();
//		       var idficha= $(this).attr('param');
//		       irRegistroOperacionFichaTurismo(idficha);
//		       //consultarDetalleFichaTurismoConsolidada(idficha);		            
//		  }
//	);
	
	
	
	
	
	$('.codigoficha').live("click",
    		function (e){
    			e.preventDefault();
    			var idficha= $(this).attr('param');
    			 tipopag=$(this).attr('param2');
    			 if(tipopag==valueConstants.tipo_pag_registro){
  		    	   irRegistroFichaTurismo(idficha);
  		       }else
  		    	   if(tipopag==valueConstants.tipo_pag_detalle){
  		    		 abrirModalFichaAConsolidar(idficha);
  		       }
    			
		
    		}
    );
	
	
	
	
	
	function abrirModalFichaAConsolidar(idficha) {
		habilitarRegistroModal($('#divDetalleFicha'), $('#results'));
        $.post(turismoAction.t_editarfichaturismo,
        		{idcodigo:idficha}, function(datos) {
      		 $("#divDetalleFicha").html(datos);
      		 habilitarCamposFichaAConsolidar();
      	 });
	}
	
	/* XHR Functions */
	
	
	function guardarRegistroVisitante(e) {
		  Valid.init($('#formRegTurista').find(".valid"));
		  if(Valid.test()){
			  $.post(turismoAction.t_guardaregvisitanteconsolidado, $("#formRegTurista").serialize(), function(datos) {
				  dialogModalRegTur.dialog('close');
				  //cerrarModal($('#divDetalleFicha'), $('#results'));
				  actualizarRowVisitanteFichaConsolidada();
				  //irRegistroOperacionFichaTurismo($('#formficha #hdfichaturismo').val());
			  },'json');
			  
		  }
	}		
	
	
	
	function actualizarRowVisitanteFichaConsolidada() {
		fregtur=$('#formRegTurista');
		frowcons=$('#rowtab'+idvselfc);
		nomcomp=fregtur.find('.paterno').val()+" "+fregtur.find('.materno').val()+","+fregtur.find('.nombre').val();
		frowcons.find('.nombrecomp').text(nomcomp);
		frowcons.find('.numdocumento').text(fregtur.find('.numdoc').val());
		frowcons.find('.fnacimiento').text(fregtur.find('.fnacimiento').val());
		frowcons.find('.nompais').text(fregtur.find('.idpais').find('option:selected').text());
		frowcons.find('.genero').text(fregtur.find('.idsexo').find('option:selected').text());
		//
		frowcons.find('.apepat').text(fregtur.find('.paterno').val());
		frowcons.find('.apemat').text(fregtur.find('.materno').val());
		frowcons.find('.nombre').text(fregtur.find('.nombre').val());
		frowcons.find('.fnac').text(fregtur.find('.fnacimiento').val());
		frowcons.find('.idpais').text(fregtur.find('.idpais').val());
		frowcons.find('.idsexo').text(fregtur.find('.idsexo').val());
		frowcons.find('.idtipodoc').val(fregtur.find('.tipodoc').val());
		frowcons.find('.numdoc').text(fregtur.find('.numdoc').val());
		
	}
	
//	function guardarRegistroVisitante(e) {
//		  Valid.init($('#formRegTurista').find(".valid"));
//		  if(Valid.test()){
//			  $.post(turismoAction.t_guardaregvisitanteconsolidado, $("#formRegTurista").serialize(), function(datos) {
//				  dialogModalRegTur.dialog('close');
//				  cerrarModal($('#divDetalleFicha'), $('#results'));
//				  abrirModalFichaAConsolidar($('#formficha #hdfichaturismo').val());
//			  },'json');
//			  
//		  }
//	}		
	
	
	
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
					
					//setFichaActions();
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
	
	
	

	
	
	
//	function setFichaActions(){
//		
//	}
	
	function getFichasPag( num ){
		results.addClass("opaque");
		$.post(ajax.fichas,{ pag:num },setFichasResult);
		$("#opcFicha #linkClose").css("display","none");
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
		idgenvisitante++;
		n=idgenvisitante;
		i=n-1;
		var size = wrapperpax.find(".pax").length;
		if (wrapperpax.length==0) return;
		var div = $( divpax.html().replace( /__/g,i ) );
		div.find(".number").text("#"+( size+ 1 ) );
		habilitarCamposVisitante(div);
		wrapperpax.append(div);
		
	}
	
	
	
	
	function validarPagobancoFichaturismo(e){
		 $("#formDetallePagoFichaturismo").attr('action',turismoAction.t_validapagobancofichaturismo);
		 $("#formDetallePagoFichaturismo").submit();
		
	}
	
	function validarPagobancoFichaturismoxConsolidar(e){
		$.post(turismoAction.t_validapagobancofichaturismoxconsolidar, {idparam:$('#formficha #hdfichaturismo').val()}, function(datos) {	
			var idficha=$('#formficha #hdfichaturismo').val();
			html= '<input  class="idfichaturismo"   type="hidden" name="fichaturismo.idfichaturismo" />';
			html+=  '<input type="hidden" name="fichaturismo.flagfichaturismo" value="1">';
			html+= '<input type="submit" value="Consolidar Ficha" class="submit " id="saveFicha" />';
			html+= '<strong class="updating h"><span class="i loading"></span>Consolidando Ficha...</strong>';
			$('#divBtnValidar').html(html);
			$('#divBtnValidar .idfichaturismo').val(idficha);
		},'json');

		
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
	
	
//	function validarDocumentoIdentidad(selectdoc) {
//		txtdoc=selectdoc.parents('.pax').find('.doc');
//		txtdoc.removeAttr("disabled").removeClass(Valid.options.norequired);
//		if(selectdoc.val() == "0" || selectdoc.val().length == 0){ //no aplica
//			txtdoc.trigger("blur").attr("disabled","disabled")
//				.addClass(Valid.options.norequired);
//		}else if(selectdoc.val() == "1"){// si es dni
//			txtdoc.attr("maxlength","8");
//			txtdoc.onlyDigits();
//		}else{ // si no es dni(pasaporte, ce)
//			txtdoc.attr("maxlength","22");
//			txtdoc.unbind("keydown").unbind("keyup");  
//		}
//		
//	}
	
	
	function validarDocumentoIdentidad(selectdoc,txtdoc) {
		//txtdoc=selectdoc.parents('.pax').find('.doc');
		txtdoc.removeAttr("disabled").removeClass(Valid.options.norequired);
		if(selectdoc.val() == "0" || selectdoc.val().length == 0){ //no aplica
			txtdoc.trigger("blur").attr("disabled","disabled")
				.addClass(Valid.options.norequired);
		}else if(selectdoc.val() == "1"){// si es dni
			txtdoc.attr("maxlength","8");
			txtdoc.onlyDigits();
		}else{ // si no es dni(pasaporte, ce)
			txtdoc.attr("maxlength","22");
			txtdoc.unbind("keydown").unbind("keyup");  
		}
		
	}
	
	function validarDocumentoIdentidadObligatorio(selectdoc,txtdoc) {
//		if(selectdoc.val() == "0" || selectdoc.val().length == 0){ 
//			
//		}else
		
		if(selectdoc.val() == "1"){// si es dni
			txtdoc.attr("maxlength","8");
			txtdoc.onlyDigits();
		}else{ // si no es dni(pasaporte, ce)
			txtdoc.attr("maxlength","22");
			txtdoc.unbind("keydown").unbind("keyup");  
		}
		
	}
	
	function verificarApellidos(e){ 
		var paterno = e.data.paterno.addClass("valid");
			materno = e.data.materno.addClass("valid"); 
		var action = (this.value == valueConstants.id_pais_peru)? "removeClass" : "addClass";
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
//	function setTipos(e){
//		if( !checkRuta ){
//			$(this.options[0]).remove();
//			checkRuta = true;
//		}
//		step3.removeClass("block");
//		submit.removeClass("disabled").removeAttr("disabled");
//		var options ="";
//		if(this.value == "") return;
//		
//		
//	} 
	
	function deletePax(){
		$(this.parentNode).parents(".pax").remove();
		wrapperpax.find(".number").each(function(i,e){
			$(e).text("#"+(i+1));  
		});
	}
	
	

	
	//form.submit(  function(e){
		
//	$('#form_despacho #submit').focus(
//		function(e) {
//			alert('fff');
//		}	
//	);
	
	
	$('#paxs').each(
	 function(e) {
		$(this).find('.doc').focus(
		  function(e) {
		
			
		}		
		);
	}		
	);
	
	

		

	
	
	function addVisitanteToFicha(paxs){
		var i=0,t=paxs.length,rows = [],trs = "";
		var rowt='';
		for(;i<t;i++){
			var arrpax = [] , 
				pax = $(paxs[i]).find("input,select");
			
			row1=$('#divContRowVisitante').clone();
			row2=row1.html();
			//alert(row2);
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
			
			if($.trim(pax[8].value)==""){
				pax[8].value="";
			}
			arrpax.push( (i+1) ,  pax[2].value.toUpperCase() + " " +  pax[3].value.toUpperCase() + " ," + pax[1].value.toUpperCase(),
						pax[8].value ,
						pax[4].value,
						ddText( pax[5] ),
						ddText( pax[6] ), 
						ddText( pax[9] ));
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
		//$('#divGuiaTurismo').show();
		//$('#divListaGuiaTurismo').html('');
		formregft.find('.msgemptur').hide();
		if(this.getAttribute("id") == "individual"){
			operadores.slideUp().find("select").attr("disabled","disabled");
			operadores.find('select').val(0);
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
		row= $(row1.html().replace(/_n/g,n).replace(/_i/g,i));
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
	function quitarRowTab(e){
		 e.preventDefault();
		 $(this).parent().parent().remove();
		 tabl=$(this).attr('param');
		 $('#'+tabl).find('.rowtab').each(function(i,e) {
			 i++;
			$(this).find('.num').text(i);
		});
		 totpag= calcularTotalPagosFicha("tfcpagos");
	 	 $('#divpagototalficha').find('.total').text('S./ '+totpag.toFixed(2));
	}
	
	
	function consultarDetalleFichaTurismo(idficha) {
	habilitarRegistroModal($('#divDetalleFicha'), $('#results'));
	$('#linkimprimir').css('display','block');
	 $.post(turismoAction.t_consultadetallefichaturismo,{idfichaturismo:idficha},function(datos){
		 $("#divDetalleFicha").html(datos);
	 });  
	}
	
	
	function consultarDetalleFichaTurismoConsolidada(idficha) {
		habilitarRegistroModal($('#divDetalleFicha'), $('#results'));	
		 $.post(turismoAction.t_accesofichaturismo,{idfichaturismo:idficha},function(datos){
			 $("#divDetalleFicha").html(datos);
		 });  
	}
	
	function irRegistroFichaTurismo(idficha) {
		$("#formListaFichaTurismo").find('#hdfichaturismo').val(idficha);
		$("#formListaFichaTurismo").attr('action',turismoAction.t_regfichaturismo);
		$("#formListaFichaTurismo").submit();
	}
	
	
	function seleccionarCasillas(listacheck ,checksel) {
		listacheck.each(
				function(e) {
					id= $(this).val();
					checkact=$(this);
					checksel.each(
					   function(e) {
						   if($(this).val()==id){
							   checkact.attr('checked',true);
						   }
					   }		
					);
				}	
		);
	}
		
    function guardarDatosGeneralesFichaTurismo() {
    	tiporeg=formregft.find('.hdtiporegistro').val();  
    	form=$(this).attr('name');
    	opcion=$(this).attr('param');
    	validaguias=validarIngresoGuiasTurismo();
    	if($('#'+form).find('#operadorturismo').attr('disabled')){
    		validaempresaturismo=true;
    	}else{
    		validaempresaturismo=validarSeleccionEmpresaTurismo();
    	}
    	
    	Valid.init($('#'+form).find(".valid")); 
		if(Valid.test() && validaguias && validaempresaturismo){
			if(tiporeg==valueConstants.tipo_registro_crear){
				rutatursel=formregft.find('.cborutaturismo').val();
				$.post(turismoAction.t_guardaregfichaturismo,formregft.serialize(),function(datos){
					formregft.find('.hdfichaturismo').val(datos.idficha);
					formregft.find('.submit').attr('disabled','disabled');
					//mostrarMensajeMomentaneo(formregft, 'msgguardaficha');
					mostrarMensajeMomentaneo($('.msgguardaficha'));
					setTimeout(function(){
						formregft.find('.submit').removeAttr('disabled');
						idficha=datos.idficha;
						idtiporeg=formregft.find('.hdtiporegistro').val();
						formregft.find('.hdfichaturismo').val(datos.idficha);
						tabsregft.tabs("enable",1);
						tabsregft.tabs( "url" , 1 , turismoAction.t_listavisxficha+'?'+(+new Date().getTime())+'&idfichaturismo='+idficha);
						tabsregft.tabs("select",1);
			         },2000);
					
				});
					    		
	    	}else
	    		if(tiporeg==valueConstants.tipo_registro_editar){
	    			$.post(turismoAction.t_guardaregfichaturismo,formregft.serialize(),function() {
	    				mostrarMensajeMomentaneo($('.msgguardaficha'));  
	    				//mostrarMensajeMomentaneo(formregft, 'msgguardaficha');
	    			},'json');
	        		
	        	}
			
		}
	}

    
  function ejecutarAccionFichaTurismo() {
	tiporeg=formregft.find('.hdtiporegistro').val();  
	form=$(this).attr('name');
	opcion=$(this).attr('param');
	validaguias=validarIngresoGuiasTurismo();
	validanumerominimovisitante=validarNumeroMinimoVisitantes();
	if(!validanumerominimovisitante){
		return;
    }
	validacompletovisitante=validarRegistroCompletoVisitantes();
	if($('#'+form).find('#operadorturismo').attr('disabled')){
		validaempresaturismo=true;
	}else{
		validaempresaturismo=validarSeleccionEmpresaTurismo();
	}
	Valid.init($('#'+form).find(".valid")); 
	validadatosficha=Valid.test();
	if(!validadatosficha || !validaguias || !validaempresaturismo){
		mostrarMensajeMomentaneo($('.msgdatosficha'));
		//mostrarMensajeMomentaneo( $('#divListaVisitante'), 'msgdatosficha');
	}
	if(validadatosficha && validaguias && validaempresaturismo && validanumerominimovisitante && validacompletovisitante){
		//copiarCasillas($('#tabListaVisitante .rowtab'),$('#divListaVisitanteFicha'),$('#divContIdvisitante'));
		if(opcion==valueConstants.opcion_guardar_ficha){
			$.post(turismoAction.t_guardaregfichaturismo,formregft.serialize(),function() {
				if(tiporeg==valueConstants.tipo_registro_crear){
					window.location.href=($.browser.msie? "":turismoAction.turismo )+turismoAction.consultafichaturismo;
				}

			},'json');
			
		}else
			if(opcion==valueConstants.opcion_generar_ficha){
				modalConfirmacion.html(mensajes.confirmaciongenerarfichaturismo);    
				modalConfirmacion.dialog(paramConfirmacionGenerarFichaTurismo);
				modalConfirmacion.dialog('open');
			}
			else
				if(opcion==valueConstants.opcion_consolidar_ficha){
					modalConfirmacion.html(mensajes.confirmaciongenerarconsolidarficha);    
					modalConfirmacion.dialog(paramConfirmacionGenerarConsolidarFichaTurismo);
					modalConfirmacion.dialog('open');
				}
	}
   }

  
  function generarFichaTurismo() {
	  $.post(turismoAction.t_generafichaturismo,formregft.serialize(),function(datos){
		  modalConfirmacion.dialog('close');
		  formft.find('.hdfichaturismo').val(datos.idficha);
		  formft.attr('action',turismoAction.t_consultadetfichaturismo);
		  formft.submit();
	  },'json');
  }
    
  function generarConsolidarFichaTurismo() {
	  var pfregtur=formregft.serialize();
	  var flvis=$('#formListaVisitante');
	  pflisv=flvis.serialize();
	  paramregft=pfregtur+"&"+pflisv;
	  $.post(turismoAction.t_generaconsolidafichaturismo,paramregft,function(datos){
		  modalConfirmacion.dialog('close');
		  formft.find('.hdfichaturismo').val(datos.idficha);
		  formft.attr('action',turismoAction.t_consultadetfichaturismo);
		  formft.submit();
	  },'json');
  }  
    

	
	function copiarCasillas(listacheck,divcontenedor,divmolde) {
		divcontenedor.html('');
        listacheck.each(
		 function(i,e) {
			id=$(this).find('.chkbox').val();
			row=$(divmolde.clone().html().replace(/_i/g,i));
			row.val(id);
			divcontenedor.append(row);
		}		
		);
   }
	
	function copiarCasillasSeleccionadas(listacheck,divcontenedor,divmolde) {
		         divcontenedor.html('');
		         j=0;
		         listacheck.each(
				 function(i,e) {
					 if($(this).find('.chkbox').attr('checked')){
						 id=$(this).find('.chkbox').val();
							row=$(divmolde.clone().html().replace(/_i/g,j));
							row.val(id);
							divcontenedor.append(row);
							j++;
					 }
					
				}		
				);
	}
	
	
	function mostrarVistaPreviaFichaTurismo(form) {
		var paxs = wrapperpax.find(".pax"); 
		$(".addpreview").each(addInfoToFicha);
		addActividadesToFicha();
		addTipoTurismoToFicha();
		addGuiasToFicha();
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
							htmlesp=" <div style='text-align:center'> Guardando Ficha.... <br/> <img   src='css/loading.gif'  />  </div>";				      	  	   								
							dialog.html(htmlesp);			
							dialog.dialog( "option", "buttons", { } );  
							totalpax.val( paxs.length); 
							$.post(turismoAction.t_generafichaturismo, $('#'+form).serialize(), function(data) {
								pagina =$('.btnGenerarFicha').attr('param');
								if(pagina==valueConstants.pagina_crear_ficha_turismo){
									window.location.href=($.browser.msie? "":turismoAction.turismo )+turismoAction.registroturismo; 
									
								}else
									if(pagina==valueConstants.pagina_editar_ficha_turismo){
										window.location.href=($.browser.msie? "":turismoAction.turismo )+turismoAction.consultafichaturismo;
									}
								
													  
						    },'json');
						}},
				close:function(){
					if(ie6){				
						$("select").show();
					}
				}
			});
	}
	
	
	function validarIngresoGuiasTurismo() {
		respuesta=true;
		$('#divListaGuiaTurismo .rowguia').each(
				  function(e) {
					  var idguia=$(this).find('.idguia').val();
					  $(this).find('.msgguia').hide();
					  if(idguia==0){
						  $(this).find('.msgguia').show();
						  respuesta=false;
					  }
				  }		
		);
		return respuesta;
	}
	
	function validarIngresoAnpTurismo() {
		respuesta=true;
		if($('#divListaAnpTurismo .rowanptur').length==0){
			mostrarMensajeMomentaneo($('.msgingresoanp'));
			respuesta=false;
		}
		$('#divListaAnpTurismo .rowanptur').each(
				  function(e) {
					  var idanptur=$(this).find('.idturismo').val();
					  $(this).find('.msganptur').hide();
					  if(idanptur==0){
						  $(this).find('.msganptur').show();
						  respuesta=false;
					  }
				  }		
		);
		return respuesta;
	}
	
	function validarRegistroCompletoVisitantes() {
		repuesta=true;
		$('#tabListaVisitante .rowtab').each(
		 function(i,e) {
			if($(this).find('.flagcompleto').val()==0){				
				respuesta=false;
			}
			if(!respuesta){
				mostrarMensajeMomentaneo($('.msgcompletovisitante'));
				//mostrarMensajeMomentaneo($('#divListaVisitante'), 'msgcompletovisitante');
			}
		}		
		);
		return respuesta;
		
	}
	
	
	function validarIngresoVisitantes() {
		respuesta=true;
		$('#paxs .pax').each(
				 function(e) {
					//valida ingreso al menos un apellido
					$(this).find('.valapellidos').hide(); 
					apepat= $.trim( $(this).find('.paterno').val() );
					apemat= $.trim( $(this).find('.materno').val() );
					if(apepat=="" && apemat==""){
						$(this).find('.valapellidos').show();
						respuesta=false;
					}
					//valida seleccion combo concepto exoneracion
					$(this).find('.valconcepto').hide();
					$(this).find('.cboconcepto').removeClass('v_invalid');
					if($(this).find('.cbBoleto').val()==0 ){
						if($(this).find('.cboconcepto').val()==0 && $(this).find('.hdflagconceptomenor').val()==0){
							$(this).find('.valconcepto').show();
							$(this).find('.cboconcepto').addClass('v_invalid');
							respuesta=false;
						}
					}
					
					
				}		
				);
	    return respuesta;
	}
	
	
	function validarIngresoDatosVisitante(divvis) {
		respuesta=true;
		//valida ingreso al menos un apellido
		divvis.find('.valapellidos').css('display','none'); 
		apepat= $.trim( divvis.find('.paterno').val() );
		apemat= $.trim( divvis.find('.materno').val() );
		if(apepat=="" && apemat==""){
			divvis.find('.valapellidos').show();
			respuesta=false;
		}
		//valida seleccion combo concepto exoneracion
		divvis.find('.valconcepto').css('display','none');
		divvis.find('.cboconcepto').removeClass('v_invalid');
		//alert(divvis.find('.cbBoleto').val());
		if(divvis.find('.cbBoleto').val()==0 ){
			//alert(divvis.find('.cboconcepto').val());
			if(divvis.find('.cboconcepto').val()==0){
				divvis.find('.valconcepto').css('display','block');
				divvis.find('.cboconcepto').addClass('v_invalid');
				respuesta=false;
			}
		}
		return respuesta;
	}
	
	function validarNumeroMinimoVisitantes() {
		respuesta=true;
		numvis=$('#tabListaVisitante .rowtab').length;
		if(numvis==0){
			mostrarMensajeMomentaneo($('.msgnumerominimovisitante'));
			//mostrarMensajeMomentaneo($('#divListaVisitante'), 'msgnumerominimovisitante');
			respuesta=false;
			
		}
		
		return respuesta;
	}
	

	
	function validarSeleccionEmpresaTurismo() {
		respuesta=true;
		formregft.find('.msgmoding').hide();
		if(formregft.find('.modalidad').is(':checked')==false){
			formregft.find('.msgmoding').show();
			respuesta=false;
		}
		if( formregft.find('#empresa').is(':checked')==true){
			agencia=$('#empresaturismo').val();
			operador=$('#operadorturismo').val();
			$('#operadores').find('.msgemptur').hide();
			if(agencia==0 && operador==0){
				respuesta=false;
				$('#operadores').find('.msgemptur').show();
			}
		}
		return respuesta;
	}
	
	
	
	function habilitarCamposVisitante(div) {
		opcionesFechaNacimiento.onSelect=cargarComboTipoBoletoxSeleccionFechaNacimiento;
		div.find('.fnacimiento').datepicker(opcionesFechaNacimiento);
		validarDocumentoIdentidad(div.find("select.tipodoc"),div.find('.doc'));
		div.find("select.tipodoc").change(
				function(e) {
					div.find('.doc').val('');
					validarDocumentoIdentidad($(this),div.find('.doc'));
				}
		);
//		div.find("select.pais").change( 
//				{paterno:div.find("input.paterno"), materno:div.find("input.materno")} , 
//				verificarApellidos );
		//div.find(".i_remove").click(deletePax);
		div.find("select.cbBoleto").change({div:div},mostrarComboConceptoExoneracionPago);
		
	}
	
	
   function habilitarCamposGuia(div) {
	    div.find('.ruc').onlyDigits();
		div.find('.fnacimiento').datepicker(opcionesFechaNacimiento);
		validarDocumentoIdentidadObligatorio(div.find("select.tipodoc"),div.find('.doc'));
		div.find("select.tipodoc").change(
				function(e) {
					div.find('.doc').val('');
					validarDocumentoIdentidadObligatorio($(this),div.find('.doc'));
				}
		);  	
   }
	
	
	function cargarComboTipoBoletoxSeleccionRutaTurismo(){	
		var idruta=$(this).val();
		$('#paxs .fechanacvis').each(
				function (i,e) {
					   if($(this).val()!=''){
						   divvis= $(this).parents('.pax');
						   cargarComboTipoBoletoxFechaNacimientoRutaTurismo(divvis,$(this).val(),idruta);   
					   }
					  
				}	
			);
	}
	
	function cargarComboTipoBoletoxFechaNacimientoRutaTurismo(divvis,fechanac,idruta) {
	   cbo = divvis.find('.cbBoleto');
	   divconceptoexon=divvis.find('.divconceptoexoneracion');
	   $.post(ajax.boletos, {idruta:idruta,fechanac:fechanac}, function(r) {
		idgrupoedad=r.idgrupoedad;
		//boletos
		if(idgrupoedad!=valueConstants.grupo_edad_infante){
			options = "<option value=''>Seleccione</option>";
		}else{
			options="";
		}
		for(var i = 0,t=r.listabol.length; i<t;i++){
			var boleto = r.listabol[i];
			options += "<option value='"+ boleto.idboletaje+"'>" 
				+ boleto.nombreboletaje +  ': '+ boleto.obsboletaje + ' S/.' + boleto.valorboletaje
				+ "</option>"; 
		}
		divconceptoexon.hide();
		cbo.html(options);
		//concepto exoneracion
		if(idgrupoedad!=valueConstants.grupo_edad_infante){
			optionscon = "<option value='0'>Seleccione</option>";
		}else{
			optionscon="";
		}
		for(var i = 0,t=r.listaconcepto.length; i<t;i++){
			var cpto = r.listaconcepto[i];
			optionscon += "<option value='"+ cpto.idconceptoexoneracionpago+"'>" 
				+ cpto.desconceptoexoneracionpago 
				+ "</option>"; 
		}
		divconceptoexon.find('select').html(optionscon);
						
	},'json');
	}
	
	
	
	function mostrarComboConceptoExoneracionPago(e){
		div=e.data.div;
		var cbobol=$(this).val();
		if(cbobol==""){
			cbobol=-1;
		}
		div.find('.cboconcepto').val(0);
		div.find('.cboconcepto').removeClass('v_invalid');
		div.find('.valconcepto').hide();
		if(cbobol==0){
			div.find(".divconceptoexoneracion").css('display','block');
			
		}else{
			div.find(".divconceptoexoneracion").css('display','none');
		}

	}	
	
	function guardaTemporalRegistroFichaTurismo() {
		validaguias=validarIngresoGuiasTurismo();
		if(validaguias){
			$.post(turismoAction.t_guardatemporalregfichaturismo,formregft.serialize(),function(datos){
				formregft.find('.hdfichaturismo').val(datos.idficha);
				formregvis.find('.hdfichaturismo').val(datos.idficha);
				$('#divListaVisitante').find('.submit').removeAttr('disabled');
				//colocar flagcompleto a 0
				$('#tabListaVisitante .rowtab').each(
				 function(i,e) {
					$(this).find('.flagcompleto').val(0);
				} 		
				);
				
			},'json');
			
		}
		else{
		formregft.find('.cborutaturismo').val(rutatursel);
		}
		
	}
	
	
	
	function abrirModalConfirmacionModificacionRutaTuristica() {
		if(formregft.find('.cborutaturismo').val()!=""){
			if(formregft.find('.hdfichaturismo').val()!=0){
				  modalConfirmacion.html(mensajes.confirmacionactualizarboletajevisitantes);    
				  modalConfirmacion.dialog(paramConfirmacionActualizarBoletajeVisitantes);
			      modalConfirmacion.dialog('open');
			      $('.ui-dialog-titlebar-close').remove();
				
			  }
		}else{
			 formregft.find('.cborutaturismo').val(rutatursel); 
		}
	  
    }
	

	
	
	
	function irOpcionesAccion(e) {
		e.preventDefault();
		opcion=$(this).attr('name');
		idparam=0;
		msgaccion="";
		idopcionsel=opcion;
		//crear
		if(opcion==valueConstants.opcion_crear){
			irRegistroVisitante(idparam);
			
		}else
		//editar	
			if(opcion==valueConstants.opcion_editar){
			numsel=contarCheckActivados($('#tabListaVisitante .rowtab').find('.chkbox'));
			if(numsel==0){
				alert('Seleccione un visitante');
				return;
			}
			else
				if(numsel>1){
					alert('Seleccione solo un visitante');
					return;
				}
			idparam=encontrarValorCheckActivado($('#tabListaVisitante .rowtab').find('.chkbox'));
			irRegistroVisitante(idparam);
			}
		//eliminar
			else
				if(opcion==valueConstants.opcion_eliminar){
					numsel=contarCheckActivados($('#tabListaVisitante .rowtab').find('.chkbox'));
					if(numsel==0){
						alert('Seleccione un visitante');
						return;
					}
					//copiarCasillasSeleccionadas($('#tabListaVisitante .rowtab'),$('#divListaVisitanteAccion'),$('#divContIdvisitante'));
					eliminarRegistroVisitante();
					
				}
		//cancelar
				else 
					if(opcion=valueConstants.opcion_cancelar){
						$('#divModalRegVisitante').hide();
						//cerrarRegistroOculto($('#divModalRegVisitante'),$('#divBotones'));
				}
		
		
	}
	
	function irRegistroVisitante(idparam) {
		formregvis=$("#formRegVisitante");
		formregvis.find('.hdfichaturismo').val(formregft.find('.hdfichaturismo').val());
		$('#divModalRegVisitante').show();
		//abrirRegistroOculto($('#divModalRegVisitante'),$('#divBotones')); 
		//habilitarRegistroModal( $("#divModalRegVisitante"),$('#divListaVisitante'));
	    $.post(turismoAction.t_regvisitante,
	      {idparam:idparam,idruta:formregft.find('.cborutaturismo').val()}, function(datos) {
		 $("#divModalRegVisitante").html(datos);
		  formregvis.find('.nombre').focus();
		  //ajustarAnchoCombo(formregvis.find('.cbBoleto'),'300px');
		 habilitarCamposVisitante(formregvis);
	     });
	}
	
//	function ajustarAnchoCombo(cbo,anchoorig) {
//		 cbo.mouseover(function(){
//			 $(this).data(anchoorig, $(this).css("width"))  
//			 .css("width", "auto");         
//			 }).mouseout(function(){            
//				 $(this).css("width", $(this).data(anchoorig));     
//				 });    
//		 
//	}
	
	
	
//	function irRegistroVisitante(idparam) {
//		formregvis=$("#formRegVisitante");
//		formregvis.find('.hdfichaturismo').val(formregft.find('.hdfichaturismo').val());
//		habilitarRegistroModal( $("#divModalRegVisitante"),$('#divListaVisitante'));
//	    $.post(turismoAction.t_regvisitante,
//	      {idparam:idparam,idruta:formregft.find('.cborutaturismo').val()}, function(datos) {
//		 $("#divModalRegVisitante").html(datos);
//		 habilitarCamposVisitante(formregvis);
//	     });
//	}	
	
	function eliminarRegistroVisitante() {
		formlistvis=$("#formListaVisitante");
		$.post(turismoAction.t_eliminalistvisitante,formlistvis.serialize(),function(datos){
			actualizarListadoVisitantes(idopcionsel);
			mostrarMensajeMomentaneo($('.msgeliminavis'));
			//listarVisitantesFicha('msgeliminavis');
		});
	}
	
		
	function contarCheckActivados(listacheck) {
		num=0;
		listacheck.each(
		  function(e) {
			if($(this).attr('checked')){
				num++;
			}
		}		
		);
		return num;
	}
	
	
	function encontrarCheckActivado(listacheck) {
		var objcheck;
		listacheck.each(
		  function(e) {
			if($(this).attr('checked')){
				objcheck=$(this);
			}
		}		
		);
		return objcheck;
	}
	
	function encontrarValorCheckActivado(listacheck) {
		objcheck=encontrarCheckActivado(listacheck);
		return objcheck.val();
	}
	
	
	
	function guardarRegistroVisitanteFicha(e) {
		e.preventDefault();
		validavisitante=validarIngresoDatosVisitante(formregvis);
		Valid.init(formregvis.find('.valid'));
		if(Valid.test() && validavisitante){
			mostrarImagenEspera(formregvis);
			$.post(turismoAction.t_guardaregvisficha,formregvis.serialize(),function(datos){
				formregvis.find('.idvisitante').val(datos.idvisitante);
				actualizarListadoVisitantes(idopcionsel);
				ocultarImagenEspera(formregvis);
				limpiarRegVisitante();
				mostrarMensajeMomentaneo($('.msgguardavis'));
				//cerrarModal($("#divModalRegVisitante"),$('#divListaVisitante'));
				//listarVisitantesFicha('msgguardavis');
			},'json');
		}
	}
	
	function actualizarListadoVisitantes(idopcionsel) {
		if(idopcionsel==valueConstants.opcion_crear){
			agregarRegistroVisitante($('#tabListaVisitante > tbody:last'));
		}else
			if(idopcionsel==valueConstants.opcion_editar){
				modificarRegistroVisitante($('#tabListaVisitante > tbody:last'));
				actualizarTablaVisitantes($('#tabListaVisitante > tbody:last'));
			}else
				if(idopcionsel==valueConstants.opcion_eliminar){
					quitarRegistrosVisitante($('#tabListaVisitante > tbody:last'));
					actualizarTablaVisitantes($('#tabListaVisitante > tbody:last'));
				}
		
	}
	
	
	
	function actualizarTablaVisitantes(tablistbody) {
		var snum=1;
		tablistbody.find('.rowtab').each(
		 function(i,e) {
			 $(this).removeClass('even');
			 $(this).removeClass('odd');
			 if(i%2==1){
				 $(this).addClass('odd');
			 }else{
				 $(this).addClass('even');
			 }
			$(this).find('.num').text(snum);
			snum++; 
		}		
		);
	}
	
	function agregarRegistroVisitante(tablistbody) {
		row=obtenerRowVisitante();
		tablistbody.append(row);
	}
	
	function modificarRegistroVisitante(tablistbody) {
		quitarRegistrosVisitante(tablistbody);
		agregarRegistroVisitante(tablistbody);
	}
	
	function quitarRegistrosVisitante(tablistbody){
		tablistbody.find('.chkbox').each(
		 function(i,e) {
			if($(this).attr('checked')){
				$(this).parent().parent().remove();
			}
		}		
		);
	}
	
	
	
	function obtenerRowVisitante() {
		formregvis=$("#formRegVisitante");
		row1=$('#tabContRowVisitante .bodyContRowVisitante').clone();
		//row= $(row1.html().replace(/_n/g,n).replace(/_i/g,i));
		row= $(row1.html());
		numv=$('#tabListaVisitante .rowtab').size();
		numv++;
		if(numv%2==1){
			row.addClass('odd');
		}else{
			row.addClass('even');
		}
		row.find('.chkbox').val(formregvis.find('.idvisitante').val());
		row.find('.num').text(numv);
		row.find('.apepat').text(formregvis.find('.paterno').val().toUpperCase());
		row.find('.apemat').text(formregvis.find('.materno').val().toUpperCase());
		row.find('.nombre').text(formregvis.find('.nombre').val().toUpperCase());
		row.find('.fnacimiento').text(formregvis.find('.fnacimiento').val());
		row.find('.pais').text(formregvis.find('.pais :selected').text());
		row.find('.genero').text(formregvis.find('.genero :selected').text());
		row.find('.tipodoc').text(formregvis.find('.tipodoc :selected').text());
		row.find('.numdoc').text(formregvis.find('.numdoc').val());
		row.find('.cbBoleto').text(formregvis.find('.cbBoleto :selected').text());
		return row;
	}
	
	function limpiarRegVisitante(){
		formregvis=$("#formRegVisitante");
		formregvis.find('.idvisitante').val(0);
		formregvis.find('.paterno').val('');
		formregvis.find('.materno').val('');
		formregvis.find('.nombre').val('');
		formregvis.find('.numdoc').val('');
		formregvis.find('.fnacimiento').val('');
	}
	
	
	
	function listarVisitantesFicha(msgaccion) {
		$.post(turismoAction.t_listavisxficha,{idfichaturismo:formregft.find('.hdfichaturismo').val()},function(datos){
			tabsregft.find('#ui-tabs-1').html(datos);	
			mostrarMensajeMomentaneo(tabsregft, msgaccion);
			
		});
	}
	
	
//	function guardarRegistroVisitanteFicha(e) {
//		e.preventDefault();
//		validavisitante=validarIngresoDatosVisitante(formregvis);
//		Valid.init(formregvis.find('.valid'));
//		if(Valid.test() && validavisitante){
//			mostrarImagenEspera(formregvis);
//			$.post(turismoAction.t_guardaregvisficha,formregvis.serialize(),function(datos){
//				cerrarModal($("#divModalRegVisitante"),$('#divListaVisitante'));
//				listarVisitantesFicha('msgguardavis');
//			},'json');
//		}
//	}
	
	function actualizarBoletajaVisitantes() {
		$.post(turismoAction.t_determinaboletajevisitantes,{idfichaturismo:formregft.find('.hdfichaturismo').val()},function(datos){
			tabsregft.tabs("select",1);
		});
	}
	
	function habilitarRegistroModal(modal,reg) {
	    modal.css('display','block');
		reg.css('display','none');
		$('#linkClose').show();
  	    $("#closemodal").click(
  	     function(e) {
  	    	cerrarModal(modal,reg);
		}		
  	    );
     }
  
    function cerrarModal(modal,reg) {
	  modal.css('display','none');
	  reg.css('display','block');
	  $('#linkClose').hide();
    }
    
    function abrirRegistroOculto(regh,regs) {
	    regh.css('display','block');
		regs.css('display','none');		
     }
  
    function cerrarRegistroOculto(regh,regs) {
	  regh.css('display','none');
	  regs.css('display','block');
    }
    
    function mostrarImagenEspera(obj) {
    	obj.find('.divEspera').css('display','block');
		obj.find('.divRegistro').css('display','none');
		$('#linkClose').hide();
	}
    
    function ocultarImagenEspera(obj) {
    	obj.find('.divEspera').css('display','none');
		obj.find('.divRegistro').css('display','block');
		$('#linkClose').show();
	}
	
    
    function mostrarMensajeMomentaneo(div,msg) {
    	div.find('.'+msg).css('display','block');
    	setTimeout(function(){ 
    		div.find('.'+msg).css('display','none');
         },2000);
	}
     
    function mostrarMensajeMomentaneo(msg) {
    	msg.css('display','block');
    	setTimeout(function(){ 
    		msg.css('display','none');
         },2000);
	}
    
    function salirRegistro() {
		link=$(this).attr('name');
		window.location.href=($.browser.msie?'':turismoAction.turismo)+link;
	}
    
    
    function  habilitarCamposFichaAConsolidar() {
    	fmin=$('#formficha .fpropuesta').text();
    	$("#inFechaIngreso").datepicker({ 
    							maxDate:"+0",
    							minDate:fmin,
    							dateFormat:datepickerOptions.dateFormat,
    							buttonImage:datepickerOptions.buttonImage,
    							buttonImageOnly: datepickerOptions.buttonImage, 
    							showOn: datepickerOptions.showOn, 
    							buttonImageOnly: datepickerOptions.buttonImageOnly
    							}); 
    	//formficha = $("#formficha").submit( consolidarFicha );	
    	formficha.find('#btnConsolidar').live('click',abrirModalConfirmacionConsolidacion);
    	$('#visitantes').find('input:checkbox').attr('checked',true);
    	$('#visitantes').find('.chkbox').click(sombrearRowCasilla);
      habilitarSeleccionTodasCasillasBoleto();
	}
    
    
    function calcularTotalBoletajeNormal() {
    	var sumsub=0;
		$('#divBoletajeNormalFicha').find('.tboleto').each(
		 function(i,e) {
			 sumsub+=parseFloat($(this).find('.hsubtotal').val());
		}		
		);
		divtnft=$('#divtotalnormalficha');
		divtnft.find('.total').text('S/. '+sumsub.toFixed(2));
		divtnft.find('.htotal').val(sumsub);
		actualizarMontoTotalCalculadoFicha();
	}
    
    function calcularTotalBoletajeAdicional(){
    	divboladdft=$('#divBoletajeAdicionalFicha');
    	divboladdft.find('.cantidad').onlyDigits();
    	divboladdft.find('.cantidad').live('keyup',function(e){
    		cant=stringToNum($(this).val());
    		pu=stringToNum(divboladdft.find('.precio').val());
    		tot=pu*cant;
    		divboladdft.find('.total').text("SUB TOTAL S/. "+tot.toFixed(2));
    		divtotadd=$('#divtotaladicionalficha');
    	    divtotadd.find('.total').text("S/. "+tot.toFixed(2));
    	    divtotadd.find('.htotal').val(tot);
    	    actualizarMontoTotalCalculadoFicha();
  	   }); 	
    }
    
    
    
    
    
    function habilitarSeleccionTodasCasillasBoleto() {
    	$('.checktodosboleto').live('click',
				function(e){
			    ind=$(this).attr('name');
				check=$('#checktodosboleto'+ind).attr('checked');
				tbol=$('#tboleto'+ind);
    			subtot=stringToNum(tbol.find('.hsubtotal').val());
    			monto=stringToNum(tbol.find('.precio').val());
				$('.checktodosboleto'+ind).each(
			    		function(e){
			    			row=$(this).parent().parent();
			    			if(check){
			    			if(!$(this).is(':checked')){
		    					subtot+=monto;
			    			}
			    			$(this).attr('checked',true);
			    			row.css('background-color','#E7EBED');
			    			row.find('.chkbox').val(1);

			    			}
			    			else{
			    				if($(this).is(':checked')){
		    					subtot=subtot-monto;
			    			    }
			    				$(this).attr('checked',false);
			    				row.removeAttr('style');
			    				row.find('.chkbox').val(0);

			    			}
			    			
			    					
			    		}	 
			    	 );
				tbol.find('.subtotal').text(subtot.toFixed(2));
		    	tbol.find('.hsubtotal').val(subtot);
		    	actualizarMontoCalculadoBoletajeNormalFicha();
			    }	
		 );
	}
    
    
//    function sombrearCasillaBoleto(){
//    	$(this).stylle
//    }
    function actualizarMontoCalculadoBoletajeNormalFicha() {
    	subtot=0;
    	$('#visitantes').find('.tboleto .hsubtotal').each(
    	function(e) {
			subtot+=parseFloat($(this).val());
		}		
    	);
		$('#divtotalnormalficha').find('.total').text('S/. '+subtot.toFixed(2));
		$('#divtotalnormalficha').find('.htotal').val(subtot);
		actualizarMontoTotalCalculadoFicha();
	}
    
    function actualizarMontoTotalCalculadoFicha() {
    	tnormal=parseFloat($('#divtotalnormalficha').find('.htotal').val());
    	tadic=parseFloat($('#divtotaladicionalficha').find('.htotal').val());
    	tot=tnormal+tadic;
    	$('#divmontototalficha').find('.total').text('S/. '+tot.toFixed(2));  	
	}
    
    function habilitarLimpiarNombreGuia() {
    	$('#divListaGuiaTurismo .rowguia').find('.nomcompguia').live('keyup',function(e){
    		  if($.trim($(this).val())==""){
    			 $(this).parent().find('.idguia').val('');
    		  }
    	   }
    	);
    }	
    
    function habilitarLimpiarNombreAnpTurismo() {
    	$('#divListaAnpTurismo .rowanptur').find('.desanptur').live('keyup',function(e){
    		  if($.trim($(this).val())==""){
    			 $(this).parent().find('.idturismo').val('');
    		  }
    	   }
    	);
    }	
//    	$('.nomcompguia').live('keypress',function(e){
//    		//hdguia=$(this).parent().find('.idguia');
//        	if( $.trim($(this).text())==""){
//        		$(this).parent().find('.idguia').val('');
//        	}
////    		if(hdguia.val()!=0 ){
////    			$(this).val('');
////    			hdguia.val(0);
////    		}
//    		
//
//           }     		
        
//	}
    
    
    function seleccionarCasilla() {
    	row=$(this).parent().parent();
    	if(this.checked){
    		
    		row.css('background-color','#FFFDEA');
    	}else{
    		row.removeAttr('style');
    		}
    	}
    	
    function sombrearRowCasilla() {
    	row=$(this).parent().parent();
    	tbol=$(this).parents('.tboleto');
    	
    	var subtotbol=stringToNum(tbol.find('.hsubtotal').val());
		var montobol=stringToNum(tbol.find('.precio').val());
    	if($(this).is(':checked')){
    		subtotbol=subtotbol+montobol;
    		row.css('background-color','#E7EBED');
    		row.find('.chkbox').val(1);
    	}else{
    		//alert('m'+monto);
    		subtotbol=subtotbol-montobol;
    		row.removeAttr('style');
    		row.find('.chkbox').val(0);
    		}
    	tbol.find('.subtotal').text(subtotbol.toFixed(2));
    	tbol.find('.hsubtotal').val(subtotbol);
    	actualizarMontoCalculadoBoletajeNormalFicha();
    	}
    
    
    
    
    function irOpcionesAccionGuiaTurismo(e) {
		e.preventDefault();
		opcion=$(this).attr('name');
		idparam=0;
		msgaccion="";
		//ver
		if(opcion==valueConstants.opcion_consultardetalle){
			numsel=contarCheckActivados($('#tabListaGuia .rowtab').find('.chkbox'));
			if(numsel==0){
				alert('Seleccione un gu\u00EDa');
				return;
			}
			else
				if(numsel>1){
					alert('Seleccione solamente un gu\u00EDa');
					return;
				}
			idparam=encontrarValorCheckActivado($('#tabListaGuia .rowtab').find('.chkbox'));
			consultarDetalleGuiaTurismo(idparam);
			
		}else
		//crear
		if(opcion==valueConstants.opcion_crear){
			irRegistroGuiaTurismo(idparam);
			
		}else
		//editar	
			if(opcion==valueConstants.opcion_editar){
			numsel=contarCheckActivados($('#tabListaGuia .rowtab').find('.chkbox'));
			if(numsel==0){
				alert('Seleccione un gu\u00EDa');
				return;
			}
			else
				if(numsel>1){
					alert('Seleccione solamente un gu\u00EDa');
					return;
				}
			idparam=encontrarValorCheckActivado($('#tabListaGuia .rowtab').find('.chkbox'));
			irRegistroGuiaTurismo(idparam);
			}
			else
				if(opcion==valueConstants.opcion_eliminar){					
					numsel=contarCheckActivados($('#tabListaGuia .rowtab').find('.chkbox'));
					if(numsel==0){
						alert('Seleccione por lo menos un gu\u00EDa');
						return;
					}
					modalConfirmacion.html(mensajes.confirmacioneliminarguia);    
					modalConfirmacion.dialog(paramConfirmacionEliminarGuia);
					modalConfirmacion.dialog('open');										
				}		
	}
    
    
    function irOpcionesAccionFichaTurismo(e) {
		e.preventDefault();
		opcion=$(this).attr('name');
		idparam=0;
		msgaccion="";	
		//consolidar
		if(opcion==valueConstants.opcion_consolidar_ficha){
		abrirModalAccionFicha('chkbox',mensajes.confirmacionconsolidarfichas);
	    }
		//ejecutar accion
//		if(opcion==valueConstants.opcion_ejecutar_accion_ficha){
//			numsel=contarCheckActivados($('#tabListaFicha .rowtab').find('.chkbox1'));
//			if(numsel==0){
//				alert('Seleccione una ficha');
//				resultado=false;
//				return;
//			}
//			else
//				if(numsel>1){
//					alert('Seleccione solamente un ficha');
//					resultado=false;
//					return;
//				}
//			idparam=encontrarValorCheckActivado($('#tabListaFicha .rowtab').find('.chkbox1'));
//			irRegistroOperacionFichaTurismo(idparam);
//		}else
		//validar pago
//		if(opcion==valueConstants.opcion_pagar_ficha){
//			abrirModalAccionFicha('chkbox2',mensajes.confirmacionpagarfichas);
//		}else
			
		
	}
    
    
    function abrirModalAccionFicha(chkbox,msg) {
    	numsel=contarCheckActivados($('#tabListaFicha .rowtab').find('.'+chkbox));
		if(numsel==0){
			alert('Seleccione por lo menos una ficha');
			return;
		}
		modalConfirmacion.html(msg);    
		modalConfirmacion.dialog(paramConfirmacionAccionFichas);
		modalConfirmacion.dialog('open');
		
	}
    
    function ejecutarAccionListadoGuias(opcion) {
    	formlguia=$('#formListaGuiaTurismo');
        param= formlguia.serialize();
		param+='&idaccion='+opcion;
    	$.post(turismoAction.t_ejecutaaccionlistguia,param, function(datos) {
    		window.location.href=($.browser.msie?'':turismoAction.turismo)+turismoAction.consultaguiaturismo;
		},'json');
	}
    
    
    function ejecutarAccionListadoOperadores(opcion) {
    	formlope=$('#formListaOperadorTurismo');
        param= formlope.serialize();
		param+='&idaccion='+opcion;
    	$.post(turismoAction.t_ejecutaaccionlistoperador,param, function(datos) {
    		window.location.href=($.browser.msie?'':turismoAction.turismo)+turismoAction.consultaoperadorturismo;
		},'json');
	}
    
    
    function ejecutarAccionListadoFichas(opcion) {
    	formlistficha=$('#formListadoFichaTurismo');
        param= formlistficha.serialize();
        param+='&idaccion='+opcion;
    	$.post(turismoAction.t_ejecutaaccionlistficha,param, function(datos) {
    		if(opcion=valueConstants.opcion_consolidar_ficha){
    			modalConfirmacion.html(mensajes.exitoconsolidacionlistadoficha);			
    		}
    		setTimeout(function(){ 
				window.location.href=($.browser.msie?'':turismoAction.turismo)+turismoAction.consultafichaturismo;
			},1000);
		},'json');
	}
    
    
    
    function consolidarFicha(opcion) {
    	formlistficha=$('#formListadoFichaTurismo');
        param= formlistficha.serialize();
        param+='&idaccion='+opcion;
    	$.post(turismoAction.t_ejecutaaccionlistficha,param, function(datos) {
    		window.location.href=($.browser.msie?'':turismoAction.turismo)+turismoAction.consultafichaturismo;
		},'json');
	}
    
    
    //acceso a ficha consolidada
    $('.linkAccesoFichaConsolidada').live("click",
			function(e) {
		       e.preventDefault();
		       var idficha= $(this).attr('param');
		       habilitarRegistroModal($('#divDetalleFicha'), $('#results'));
		       $.post(turismoAction.t_fichaturismocons,{idfichaturismo:idficha},function(datos){
		    	   $("#divDetalleFicha").html(datos);
		    	   $('#linkimprimir').css('display','none');
			       //pagos
			       idgenpagoft=$('#idultpagoft').val();
			       $('#tfcpagos .i_supr').click(
						   quitarRowTab
				   );
			       $('#tfcpagos').find('.rowtab').each(
			    	 function(i,e) {
			    		 $(this).find('.monto').onlyDigits(2);
						 $(this).find('.monto').keyup(
								       function(e) {
								    	   totpag= calcularTotalPagosFicha("tfcpagos");
								    	   $('#divpagototalficha').find('.total').text('S./ '+totpag.toFixed(2));  
									}	
						  );
					}	   
			       );
			       
		    	   habilitarCamposFichaAConsolidar();
				    calcularTotalBoletajeNormal();
				    calcularTotalBoletajeAdicional();
		    	   
		       } 		
		       ); 
		  
		       //irRegistroOperacionFichaTurismo(idficha);
		       //consultarDetalleFichaTurismoConsolidada(idficha);		            
		  }
	);
    
    
    
    
//    function irRegistroOperacionFichaTurismo(idparam) {
//    	habilitarRegistroModal($('#divDetalleFicha'), $('#results'));
//    	$('#linkimprimir').css('display','none');
//    	$.post(turismoAction.t_accesofichaturismo,{idfichaturismo:idparam}, function(datos) {
//		    $("#divDetalleFicha").html(datos);
//		    idgenpagoft=$('#idultpagoft').val();
//			 $('#tfcpagos .i_supr').click(
//			   quitarRowTab
//			  );
//			 
//		    habilitarCamposFichaAConsolidar();
//		    calcularTotalBoletajeNormal();
//		    calcularTotalBoletajeAdicional();
//		});
//	}
    
    
    function consultarDetalleGuiaTurismo(idparam) {
    	habilitarRegistroModal( $("#divModalRegGuiaTurismo"),$('#divListaGuiaTurismo'));
	    $.post(turismoAction.t_consultadetalleguiaturismo,{idparam:idparam}, function(datos) {
		 $("#divModalRegGuiaTurismo").html(datos); 
	     });
	}
    
    
    function irRegistroGuiaTurismo(idparam) {
		habilitarRegistroModal( $("#divModalRegGuiaTurismo"),$('#divListaGuiaTurismo'));
	    $.post(turismoAction.t_regguiaturismo,{idparam:idparam}, function(datos) {
		 $("#divModalRegGuiaTurismo").html(datos);
		 formregguiatur=$('#formRegGuiaTurismo');
		 habilitarCamposGuia(formregguiatur);
		 idgenanptur=$('#idultanptur').val();
		 $('#divListaAnpTurismo .i_supr').click(
				     quitarRow
		  );
		 habilitarLimpiarNombreAnpTurismo;

	     });
	}
    
    
    function irOpcionesAccionOperadorTurismo(e) {
		e.preventDefault();
		opcion=$(this).attr('name');
		idparam=0;
		msgaccion="";
		//crear
		if(opcion==valueConstants.opcion_crear){
			irRegistroOperadorTurismo(idparam);
			
		}else
		//editar	
			if(opcion==valueConstants.opcion_editar){
		    if(!validarSeleccionOperadorUnico()){
		    	return ;
		    }
			idparam=encontrarValorCheckActivado($('#tabListaOperador .rowtab').find('.chkbox'));
			irRegistroOperadorTurismo(idparam);
			}
		//eliminar
			else
				if(opcion==valueConstants.opcion_eliminar){
					numsel=contarCheckActivados($('#tabListaOperador .rowtab').find('.chkbox'));
					if(numsel==0){
						alert('Seleccione por lo menos un operador');
						return;
					}
					modalConfirmacion.html(mensajes.confirmacioneliminaroperador);    
					modalConfirmacion.dialog(paramConfirmacionEliminarOperador);
					modalConfirmacion.dialog('open');					
				}
				else
					 if(opcion=valueConstants.opcion_generarclave){
						 if(!validarSeleccionOperadorUnico()){
						    	return ;
						    }
						 idparam=encontrarValorCheckActivado($('#tabListaOperador .rowtab').find('.chkbox'));
						 irRegistroRestablecerClaveOperador(idparam);
					 }
	}
    
    function irRegistroOperadorTurismo(idparam) {
//		formregvis=$("#formRegVisitante");
//		formregvis.find('.hdfichaturismo').val(formregft.find('.hdfichaturismo').val());
		habilitarRegistroModal( $("#divModalRegOperadorTurismo"),$('#divListaOperadorTurismo'));
	    $.post(turismoAction.t_regoperadorturismo,{idparam:idparam}, function(datos) {
		 $("#divModalRegOperadorTurismo").html(datos);
		 formregoptur=$('#formRegOperadorTurismo');
		 formregoptur.find('.ruc').onlyDigits();
		 idgenanptur=$('#idultanptur').val();
		 $('#divListaAnpTurismo .i_supr').click(
				     quitarRow
		  );
		 habilitarLimpiarNombreAnpTurismo;
	     });
	}	
    
    
    function guardarRegistroOperadorTurismo() {
		//e.preventDefault();
    	formregopetur=$('#formRegOperadorTurismo');
		validaanptur= validarIngresoAnpTurismo();
		Valid.init(formregopetur.find('.valid'));
		
		if(Valid.test() && validaanptur ){
			mostrarImagenEspera(formregopetur);
			$.post(turismoAction.t_guardaregoperadorturismo,formregopetur.serialize(),function(datos){
				ocultarImagenEspera(formregopetur);
				if(datos.mensaje==0){
					formregopetur.attr('action',turismoAction.t_consultaoperadorturismo);
					formregopetur.submit();
				}else
					if(datos.mensaje==valueConstants.msg_usuario_existe) {
						mostrarMensajeMomentaneo($('.msgusernameexiste')); 
						//mostrarMensajeMomentaneo(formregopetur, 'msgusernameexiste');
						 }
					 else
					  if(datos.mensaje==valueConstants.msg_ruc_existe) {
						 mostrarMensajeMomentaneo($('.msgrucexiste'));
						 //mostrarMensajeMomentaneo(formregopetur, 'msgrucexiste');
					}
			},'json');
			
			
		}
	}
    
    
    
    
    function irRegistroRestablecerClaveOperador(idparam) {
    	$.post(turismoAction.t_regrestablecerclaveoperador,{idparam:idparam}, function(datos) {   
			modalConfirmacion.dialog(paramConfirmacionGenerarClaveOperador);
			modalConfirmacion.dialog('open');
			modalConfirmacion.html(datos);
   	     });
	}
    
    function restablecerClaveOperador() {
    	formregrest=$('#formRegRestablecerClaveOperador');
    	$('#divModalConfirmacion').html('<span>Enviando el correo</span>');
    	$('.ui-dialog-titlebar-close').hide();
    	$.post(turismoAction.t_restclaveoperador,formregrest.serialize(),function(datos){
    		$('.ui-dialog-titlebar-close').show();
    		modalConfirmacion.dialog('close');
		});
	}
    
    function guardarRegistroGuiaTurismo() {
		//e.preventDefault();
    	formregguiatur=$('#formRegGuiaTurismo');
		validaanptur= validarIngresoAnpTurismo();
		Valid.init(formregguiatur.find('.valid'));
		
		if(Valid.test() && validaanptur ){
			mostrarImagenEspera(formregguiatur);
			$.post(turismoAction.t_guardaregguiaturismo,formregguiatur.serialize(),function(datos){
				ocultarImagenEspera(formregguiatur);
				if(datos.mensaje==0){
					formregguiatur.attr('action',turismoAction.t_consultaguiaturismo);
					formregguiatur.submit();
				}else
					  if(datos.mensaje==valueConstants.msg_dni_existe) {
						  mostrarMensajeMomentaneo($('.msgdniexiste'));
						 //mostrarMensajeMomentaneo(formregguiatur, 'msgdniexiste');
					}
					  else
						  if(datos.mensaje==valueConstants.msg_guia_existe) {
							  mostrarMensajeMomentaneo($('.msgguiaexiste'));
							  //mostrarMensajeMomentaneo(formregguiatur, 'msgguiaexiste');
						}
			},'json');
			
			
		}
	}
    
    
    
    
    function agregarAnpTurismo() {
    	idgenanptur++;
		n=idgenanptur;
		i=n-1;
		row1=$('#divContRowAnpTurismo').clone();
		row= $(row1.html().replace(/_n/g,n).replace(/_i/g,i));
		//row.find('.idcodguia').val(n);//codigo
		row.find('.desanptur').autocomplete(
				paramAutocompletarAnpTurismo
				);
	    row.find('.i_supr').click(
				 quitarRow
				);
		$('#divListaAnpTurismo').append(row);	
	}
    
    function agregarPagoFichaTurismo(e) {
    	e.preventDefault();
    	idgenpagoft++;
		n=idgenpagoft;
		i=n-1;
		row1=$('#tabContRowPagoft .bodyContRowPagoft').clone();
		row= $(row1.html().replace(/_n/g,n).replace(/_i/g,i));
		row.find('.i_supr').click(
					quitarRowTab
				);
		num=$('#tfcpagos .rowtab').size();
		num++;
		row.find('.num').text(num);
		row.find('.monto').onlyDigits(2);
		row.find('.monto').keyup(
			       function(e) {
			    	   totpag= calcularTotalPagosFicha("tfcpagos");
			    	   $('#divpagototalficha').find('.total').text('S./ '+totpag.toFixed(2));
			    	   
				}	
		);
		$('#tfcpagos > tbody:last').append(row);	
	}
    
    
    
    function calcularTotalPagosFicha(tabl) {
    	totpag=0;
    	$('#'+tabl).find('.rowtab').each(
    	 function(i,e) {
			totpag+=stringToNum($(this).find('.monto').val());
		}		
    	);
    	return totpag;
	}
    
    
    function validarSeleccionOperadorUnico() {
    	resultado=true;
    	numsel=contarCheckActivados($('#tabListaOperador .rowtab').find('.chkbox'));
		if(numsel==0){
			alert('Seleccione un operador');
			resultado=false;
			return;
		}
		else
			if(numsel>1){
				alert('Seleccione solamente un operador');
				resultado=false;
				return;
			}
		return resultado;
	}
    
    
    function consultarOperadoresTurismo() {
    	forminiop=$("#formInicioOperadorTurismo");
    	divlista=$('#divListaOperadorTurismo');
    	cerrarModal($('#divModalRegOperadorTurismo'), divlista);
    	var param= forminiop.serialize();
		param+='&idcontrol=1';
		param+='&numpagina=1';
		 htmlesp=" <div style='text-align:center'> Consultando <br/> <img   src='css/loading.gif'  />  </div>";
		 divlista.html(htmlesp);
    	$.post(turismoAction.t_consultaoperadorturismo, param, function(datos) {
    		divlista.html(datos);
	    });
	}
    
    
    function consultarGuiasTurismo() {
    	forminig=$("#formInicioGuiaTurismo");
    	divlista=$('#divListaGuiaTurismo');
    	cerrarModal($('#divModalRegGuiaTurismo'), divlista);
    	var param= forminig.serialize();
		param+='&idcontrol=1';
		param+='&numpagina=1';
		 htmlesp=" <div style='text-align:center'> Consultando <br/> <img   src='css/loading.gif'  />  </div>";
		 divlista.html(htmlesp);
    	$.post(turismoAction.t_consultaguiaturismo, param, function(datos) {
    		divlista.html(datos);
	    });
	}
    
    function consultarPagosBanco() {
    	forminiop=$("#formInicioPagoBancoFichaturismo");
    	divlista=$('#divListaPagoBancoFichaturismo');
    	//cerrarModal($('#divModalRegOperadorTurismo'), divlista);
    	var param= forminiop.serialize();
		param+='&idcontrol=1';
		param+='&numpagina=1';
		 htmlesp=" <div style='text-align:center'> Consultando <br/> <img   src='css/loading.gif'  />  </div>";
		 divlista.html(htmlesp);
    	$.post(turismoAction.t_consultapagobancofichaturismo, param, function(datos) {
    		divlista.html(datos);
	    });
	}
    
    
    
    function validarPagoIncompleto() { 	
    	formficha=$('#formficha');
    	idparam=formficha.find('#hdfichaturismo').val();
		$.post(turismoAction.t_validapagoincompleto,formficha.serialize(),function(datos) {
			cerrarModal($('#divDetalleFicha'), $('#results'));
			irRegistroOperacionFichaTurismo(idparam);
		},'json');
	}
    
    
    function limpiarCampos() {
		fcampbus=$(this).attr('param');
		$('#'+fcampbus).find('input:text').val('');
		$('#'+fcampbus).find('select').val(0);
		$('#'+fcampbus).find('#idestadoficha').val(
				$('#'+fcampbus).find('#hdestadoficha').val()		
		);
		
		//document.forms[fcampbus].reset();
		//formbusft.
		//$('#'+fcampbus)[0].reset();
		
	}
    
    function abrirModalPagoBancoFicha(e) {
		  e.preventDefault();
		  idf=$('#formficha').find('#hdfichaturismo').val();
		  rowtabsel=$(this).parents('.rowtab');
		  $.post(turismoAction.t_consultapagobancoxoperador ,{idfichaturismo:idf},function(datos){
			  modalConfirmacion.dialog(paramConsultarPagoBancoFicha);
			  modalConfirmacion.html(datos);
			  $('#tpagosopetur').find('.rowtab').each(
				  function(i,e) {
					  idpb=$(this).find('.linkSelPagoBanco').attr('name');
					  elim=false; 
					$('#tfcpagos').find('.rowtab').each(
					 function(i,e) {
						if(idpb==$(this).find('.idpagobanco').val()){
							elim=true;
						}
					});
					 if(elim==true){
						 $(this).remove();
					 }
					
				}	  
			  );
			  modalConfirmacion.dialog('open'); 
		  });
	}
    
    function seleccionarModalidadPago() {   	
    	rowt=$(this).parent().parent();
    	rowt.find('.numvoucher').val('');
		rowt.find('.monto').val('');
    	if($(this).val()==valueConstants.codigo_modpago_bancoficha){
			htmllink='<a href="#" class="linkConsultaPagoBanco"><img title="Buscar" src="img/page_go.png"></a>';
			rowt.find('.spPagoBancoFicha').html(htmllink);
			rowt.find('.numvoucher').attr('readonly','readonly');
			rowt.find('.monto').attr('readonly','readonly');
		}else{
			rowt.find('.spPagoBancoFicha').html('');
			rowt.find('.numvoucher').removeAttr('readonly');
			rowt.find('.monto').removeAttr('readonly');
		}
	}
    
    
    function seleccionarPagoBanco(e) {
    	e.preventDefault();
		modalConfirmacion.dialog('close');
		idp=$(this).attr('name');
		rowpago=$(this).parents('.rowtab');
		rowtabsel.find('.idpagobanco').val($(this).attr('name'));
		rowtabsel.find('.numvoucher').val($.trim(rowpago.find('.numvoucher').text()));
		rowtabsel.find('.monto').val($.trim(rowpago.find('.saldo').text()));
		totpag= calcularTotalPagosFicha("tfcpagos");
 	    $('#divpagototalficha').find('.total').text('S./ '+totpag.toFixed(2));
	}
    
    
    function descargarFichaTurismo(idficha) {
    	location.href = ($.browser.msie? "":"turismo/" ) + "generateFichaPDF?idfichaturismo="+idficha;
	}
    
    function mostrarOcultarDiv(e) {
    	e.preventDefault();
    	divt=$(this).attr('param');
    	$('#'+divt).toggle();
    	ds=$('#'+divt).css('display');
    	if(ds=='block'){
    		txtl='Ocultar Detalle';
    	}else{
    		txtl='Mostrar Detalle';	
    	}
    	$(this).text(txtl);
	}
    
    function cargarPagosBanco() {
    	window.location.href=($.browser.msie? "":turismoAction.turismo )+turismoAction.cargapagosbancofichaturismo;
	}
    
//    function volverMenu(e) {
//    	e.preventDefault();
//    	history.back(1);
//	}
    
    
    function listarUbigeo(){
		var cbo=$(this).attr('param');
		//formreg=$("#formRegOperadorTurismo");
		formreg=$(this).parents('.regubigeo');
		var coddep= formreg.find('.idubigeodepartamento').val();
		var codubigeo=$(this).val();
		html="";
		
		$.post( UtilAction.u_listaubigeo , { cadenaparam: codubigeo,cadenaparam2: coddep,idparam:cbo} ,function(datos){
			html+="<option value='0'>Seleccione</option> ";
			if(cbo==valueConstants.combo_departamento){
				
				for (var j = 0; j < datos.listaubigeo.length ; j++) {
	      			var option = datos.listaubigeo[j];
	      			html+="<option value='";
	  	        	html+=option.codprovincia;
	  	        	html+="'>";
	  	        	html+=option.nombre;
	  	        	html+="</option>";
	  	        }
				formreg.find('.idubigeoprovincia').html(html);
				formreg.find('.idubigeodistrito').html('<option >-------</option>');
			}else if(cbo==valueConstants.combo_provincia){
				for (var j = 0; j < datos.listaubigeo.length ; j++) {
	      			var option = datos.listaubigeo[j];
	      			html+="<option value='";
	  	        	html+=option.idubigeo;
	  	        	html+="'>";
	  	        	html+=option.nombre;
	  	        	html+="</option>";
	  	        }
				formreg.find('.idubigeodistrito').html(html);
			}
			
			
				
		},"json");
		
	}
    
    
}); 
	

