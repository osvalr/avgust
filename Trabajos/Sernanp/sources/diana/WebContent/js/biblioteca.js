
var entranuevorecurso=0;
///////////////////////////////////////////////////LOAD///////////////////////////

var idgeneditorial=0,idgenautor=0,idgentema=0;
var paramAutocompletarEditorial= {
		opcion: 1,
		source: function (request, response) {
			$.ajax({
				url: "buscaEditorial.action",
				data: "cadena="+request.term ,
				dataType: "json",
				 success: function (data) {
					 response($.map(data.editoriales, function (item) {
				     return {
						id: item.ideditorial,
						value: item.nombrepersonajuridica	
								
							
						};
					}))
				 } 
			})},
			select: function( e, ui ) {
				var obj = ui.item;
				$(this).val(obj.value);
				$(this).parent().find('.ideditorial').val(obj.id);
				return false;
	
			},
			
			minLength: 1
	};

var paramAutocompletarAutor= {
		opcion: 1,
		source: function (request, response) {
		$.ajax({
			url: "buscaAutor.action",
			data: "cadena="+request.term ,
			dataType: "json",
			 success: function (data) {
			response($.map(data.autores, function (item) {
			return {
			id: item.idautor,
			value: 
					item.apepat+' '+item.apemat+','+item.nombre
				
			}
			}))
			 }
			})
			},
			select: function( e, ui ) {
				var obj = ui.item;
				$(this).val(obj.value);
				$(this).parent().find('.idautor').val(obj.id);
				return false;

			},
			
			minLength: 1
	};


var paramAutocompletarTema= {
		opcion: 1,
		source: function (request, response) {
			$.ajax({
				url: "buscaTema.action",
				data: "cadena="+request.term ,
				dataType: "json",
				 success: function (data) {
					 response($.map(data.temas, function (item) {
				     return {
						id: item.idtema,
						value: item.nombretema	
								
							
						};
					}))
				 } 
			})},
			select: function( e, ui ) {
				var obj = ui.item;
				$(this).val(obj.value);
				$(this).parent().find('.idtema').val(obj.id);
				return false;
	
			},
			
			minLength: 1
	};
var paramAutocompletarPersonal= {
		opcion: 1,
		source: function (request, response) {
			$.ajax({
				url: "buscaPersonalAprobacion.action",
				data: "cadena="+request.term ,
				dataType: "json",
				 success: function (data) {
					 response($.map(data.personal, function (item) {
				     return {
						id: item.idpersonal,
						value: item.apepat+' '+item.apemat+','+item.nombre	
								
							
						};
					}))
				 } 
			})},
			select: function( e, ui ) {
				var obj = ui.item;
				$(this).val(obj.value);
				$('#hdpersonalaprobacion').val(obj.id);
				//$(this).parent().find('.idpersonalaprobacion').val(obj.id);
				return false;
	
			},
			
			minLength: 1
	};
//BEGIN LOAD
$(document).ready(function() {
	
	var $tabs = $("#tabsRegRecInf").tabs();
	
	var pag=$('#hdpagina').val();
	if(pag==0){
		$("#tabsRegRecInf").tabs("disable",1);
		$("#tabsRegRecInf").tabs("disable",2);
		$("#divBtnRegistroRecInf").hide();
		$('#divsiguiente1').show();
	}
	
	
	
	
	
	var dialog1 = $( "#divModalMsgRecInf" ).dialog({
		autoOpen: false,
		width: 200,
		modal: true,
		buttons: { 
			"Si": function() { 
				$("#formRegistroRecInf").attr('action','guardaRecInf.action?siguiente=2');
				$("#formRegistroRecInf").submit();
				
			},
			"No": function() {
				$("#formRegistroRecInf").attr('action','guardaRecInf.action?siguiente=3');
				$("#formRegistroRecInf").submit();
				
			} 

        },
		close: function(event, ui) { 
			dialog.empty();
		}
    });	 
	
	
	var dialog1 = $( "#divModalMsgTemporalRecInf" ).dialog({
		autoOpen: false,
		width: 200,
		modal: true,
		buttons: { "OK": function() { $(this).dialog("close"); } },
		close: function(event, ui) { 
			dialog.empty();
		}
    });	
	
	
	
	if($('#temporalRecInf').val()!=0){
		$( "#divModalMsgTemporalRecInf" ).dialog('open');
	}
	
	
	$("#cboTipoRecInf").live("change",
			function(e){
		  $("#divDatosAprobacion").html('');
		  if($(this).val()==2){
			  $('#divContRowDatosAprobacion #cboAreaOrgRecInf').attr('name','recursoinformacion.aprobacionrecursoinformacion.areaorganica.idarea');
			  $('#divContRowDatosAprobacion #hdpersonalaprobacion').attr('name','recursoinformacion.aprobacionrecursoinformacion.personal.idpersonal');
			  $('#divContRowDatosAprobacion #hdaprobacionrecinf').attr('name','recursoinformacion.aprobacionrecursoinformacion.idaprobacionrecursoinformacion');
			    row1=$('#divContRowDatosAprobacion').clone();
			    row2= $(row1).html();
			    row=$(row2);
			    row.find('#txtpersonalaprobacion').autocomplete(
	  	        		paramAutocompletarPersonal
  	        	);

				$('#divDatosAprobacion').append(row);
			   
		  }
		    
	   }
	);
		
	/*
	var cancel=$('.linkDetRecInf').live('click',
			 function(e){
				 e.preventDefault();
				 var idrec=$(this).attr('param');
				 
				 window.location.href='muestraPdfDetRecInf.action?idcodigo='+idrec; 
	         }
	);
	*/
	
	var link=$('.linkDetRecInf').live('click',
			 function(e){
				 e.preventDefault();
				 var idrec=$(this).attr('param');
				 
				 window.location.href='muestraPdfDetRecInf.action?idcodigo='+idrec; 
	         }
	);
	
	
	//
	var link=$('.linkRegistroRecInf').live('click',
	 function(e){
		 e.preventDefault();
		 var idlinkreg=$(this).attr('param');
		 var param= $("#formRegistroRecInf").serialize();
		 param+='&fuente=2';
		 var test1,test2;
		 if(idlinkreg==1){
			Valid.init($("#formRegistroRecInf .valid1"));
			test1= Valid.test();
			test2=true;
		 }
		 if(idlinkreg==2){
			 test1= Valid.init($("#formRegistroRecInf .valid1"));
			 test1= Valid.test();
			 test2= Valid.init($("#formRegistroRecInf .valid2")); 
			 test2= Valid.test();
		 }
		if( test1 && test2 ){ 
		
			 $.ajax({
					url: 'guardaRecInf.action',
		  	       data: param,
		  	       cache: false,
		  	       type: "POST",
		  	       success: function(datos){                        
		  	           $("#divRegistroRecInf").html(datos);
		  	          var $tabs = $("#tabsRegRecInf").tabs();
		  	           $('#txtpersonalaprobacion').autocomplete(
		  	        		paramAutocompletarPersonal
		  	        	);
		  	         if(idlinkreg==1){
		  	        	$("#tabsRegRecInf").tabs("select",1);
		  	        	$("#tabsRegRecInf").tabs("disable",2);
		  	        	$('#divsiguiente2').show();
		 			  }
		  	         else
		  	        	if(idlinkreg==2){
			  	        	$("#tabsRegRecInf").tabs("select",2);
			  	        	$("#divBtnRegistroRecInf").show();
		  	        	}
		  	         
		  	       }
			   });
			 
			 
		 }
		 
		  
		 
	
	 }		
	
	);
	
	
	//guardar recurso informacion 	
	var guardaRecInf = $("#btnRegistroRecInf").live('click',
	    	function(e){ 
	    		//console.log("Valida?");
	           //Valid.init($("#formRegistroRecInf .valid"));
	            test1= Valid.init($("#formRegistroRecInf .valid1"));
				 test1= Valid.test();
				 test2= Valid.init($("#formRegistroRecInf .valid2")); 
				 test2= Valid.test();
				 test3= Valid.init($("#formRegistroRecInf .valid3")); 
				 test3= Valid.test();
	            /// Incluir Temporizador
				if( test1 && test2 && test3 ){ 				
					if($('#hdpagina').val()==0){
						$( "#divModalMsgRecInf" ).dialog("open");
					}
					else{
						$("#formRegistroRecInf").attr('action','guardaRecInf.action?siguiente=3');
				 		$("#formRegistroRecInf").submit();
					}
				}
				
				
	    	}	
	 );
	
    var ExpRecInf = $(".linkExpRecInf").live("click",
    		
    		function (e){
 		 e.preventDefault();
 		var opc=$(this).attr('name');
 	   
 		//var proyParam= $("#formInicioProyectos").serialize();
 		$("#formInicioRecInf").attr('action','exportaRecInf.action?idopcion='+opc);
 		$("#formInicioRecInf").submit();
        
	}	 
    );
	
	
	var limpiarRec = $(".btnInicioRecInf").click(
    		function (e){
    	  		 e.preventDefault();
    	  		 window.location.href='consultaRecInf.action';
    	    }	 
    );	
	

	var limpiarRec = $("#btnCancelRegistroRecInf").click(
    		function (e){
    	  		 e.preventDefault();
    	  		 window.location.href='consultaRecInf.action';
    	    }	 
    );	
//combo accion
	cboaccrecy=$('#cboAccionRecInf').live('change',
			   function(e){
		         
		    	 var opc=$('#cboAccionRecInf').val();
		    	 
		    	 if(opc!=0){
		    	 
		    	 var sel=0;
		    	 $('.checkRecInf').each(
		    		function(e){
		    			if($(this).attr('checked')){
		    				sel=1;
		    			}
		    		}	 
		    	 );
		    	 if(sel==0){
		    		 $('#cboAccionRecInf').val(0);
		    		 alert('Seleccione al menos una casilla');
		    		 return;
		    	 }
		    	 
		    	 if(opc==1){
		    		 $('#divModalConf').dialog("open");
		    		 //eliminarProyectos();
		    	 }
		    	} 
		     });
	
	$('#checkTodos').live('click',
			function(e){
			check=$('#checkTodos').attr('checked');
			$('.checkRecInf').each(
		    		function(e){
		    			if(check)
		    			$(this).attr('checked',true);
		    			else
		    				$(this).attr('checked',false);	
		    		}	 
		    	 );
		    }	
		);	
	
//modal de confirmacion de eliminacion
	  var dialog3 = $( "#divModalConf" ).dialog({
			autoOpen: false,
			width: 200,
			modal: true,
			buttons: { 
				"Si": function() { 
					
					eliminarRecursosInformacion();
					
				},
				"No": function() {
					$('#cboAccionRecInf').val(0);
					$( "#divModalConf" ).dialog('close');
					$('.checkRecInf').each(
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
	
	
//combo categoria anp
	var buscarRec = $("#cboCategoriaAnp").change(
    		function (e){
    	  		 e.preventDefault();
    	  		//var divcat =$('#divCategoriaAnp').html();
       			idcodigoparam=$(this).val();
       			
       			//idcodigoparam=idcodigoparam+'&control=1';
       			//control='&control=1';
  	    		$.ajax({
  	    	        url: 'obtieneFiltrosRecInf.action',
  	    	        data: "idcodigo="+idcodigoparam,
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
	
	
	
//modal detalle recurso informacion	
	var dialog = $( "#divDetalleRecInf" ).dialog({
		autoOpen: false,
		width: 800,
		modal: true,
		buttons: { "Cerrar": function() { $(this).dialog("close"); } },
		close: function(event, ui) { 
			dialog.empty();
		}
    });	 	
	
	
//abrir modal detalle 
	 var pagRec = $('.linkRecInf').live("click",
	    		function (e){ 
	    			
	    			e.preventDefault();
	    			//idProyectoParam=$(this).text();
	    			idrecinfparam=$(this).attr('name');
	    			$.ajax({
	    			      url: 'consultaDetalleRecInf.action',
	    			      data: "idrecursoinformacionparam="+idrecinfparam,
	    			      cache: false,
	    			      type: "GET",
	    			      success: function(datos){                   
	    			          $("#divDetalleRecInf").html(datos);
	    			          
	    			          $("#tabsDetalleRecInf").tabs();
	    			          
	    		    			$( "#divDetalleRecInf" ).dialog( "open" );
	    		    			/*
	    		    			$(".linkMostrarArchivo").click(
	    		    					 mostrarArchivoProyecto
	    		    			 );
	    		    			 */
	    		    			
	    			      }
	    			  });
	    			
	    			
	    		}
	    );
	
	
//contador editoriales
idgeneditorial=$('#idulteditorial').val();
$('#camposEditorial .i_quit').click(
			quitarElemento
);	




//contador autores
idgenautor=$('#idultautor').val();
$('#camposAutor .i_quit').click(
			quitarElemento
);

//contador temas
idgentema=$('#idulttema').val();
$('#camposTema .i_quit').click(
			quitarElemento
);





$('#camposArchivo .i_quit').click(
		quitarArchivo
		
);
/*
$('.imgmostrararchivo').live("click",
		  function(e){
			mostrarArchivoRecursoInformacion(e);
		}
);
*/

$('.linkmostrararchivo').click(
  mostrarArchivoRecursoInformacion
);

/*
$('.quitArchRecInf').click(
		function (e){
			e.preventDefault();
			var id=$(this).parent().attr('id');
			alert(id);
			if(id=='rowarchivo_1'){
				$(this).parent().find('.nombrearchivo').text('');
				
			}
			else
				if(id=='rowarchivo_2'){
					
				}
			$(this).parent().find('.idcodigoarchivo').val(0);
			 
		}
);
*/

//BUSQUEDA AVANZADA	
var buqava=$("#imgBusqAvRecInf").click(
				function(e){
					 e.preventDefault();
					 $("#divBusqAvRecInf").slideToggle();
				}	   
);	
	
	


//ir registro editar
var linkEditRec = $('.linkRegRecInf').live("click",
		function (e){ 
   			e.preventDefault();
   			var id= $(this).attr("name");
   			$("#idpaginafuente").attr('value',1);
   			$("#idRecursoInformacionParam").attr('value',id);
   			$("#formInicioRecInf").attr('action','registroRecInf.action');
   			$("#formInicioRecInf").submit();
   		      
		}
		
);


//buscar recursos
var buscarRec = $("#btnBuscarRecInf").click(
		function (e){
	  		 e.preventDefault();
	  		var param= $("#formInicioRecInf").serialize();
	  		param+='&control=2';
			param+='&numeropagina=1';
	  		$.ajax({
	  	       url: 'consultaRecInf.action',
	  	       data: param,
	  	       cache: false,
	  	       type: "GET",
    	  	     beforeSend: function() {
    	  	    $("#btnBuscarRecInf").attr("disabled","disabled");
    	  	    htmlesp=" <div style='text-align:center'> Consultando <br/> <img   src='css/loading.gif'  />  </div>";
   	  	    	$("#divListaRecursoInformacion").html(htmlesp);
	  	    }, 

	  	       success: function(datos){         
	  	    	 $("#btnBuscarRecInf").removeAttr("disabled");
	  	           $("#divListaRecursoInformacion").html(datos);
	  	         $('.linkmostrararchivo').click(
	  	        		  mostrarArchivoRecursoInformacion
	  	        		);
	  	           
	  	       }
	  	   });
		}	 
);

//link pagina
var pagRec = $('.pagination a').live("click",
		function (e){
			
			e.preventDefault();
			//numeroPagina=$(this).text();
			numeropagina=$(this).attr('name');
			var param= $("#formInicioRecInf").serialize();
			param+='&control=2';
			param+='&numeropagina='+numeropagina;
			$.ajax({
				url: 'consultaRecInf.action',
 	  	       data: param,
 	  	       cache: false,
 	  	       type: "GET",
 	  	       success: function(datos){                        
 	  	           $("#divListaRecursoInformacion").html(datos);
 	  	         
 	  	           }
		   });
		   
		}
); 

var regeditorial=$('#btnRegEdit').live("click",
		function (e){
	e.preventDefault();
	 var editParam= $("#formRegistroEditorial").serialize();
	 $.ajax({
	      url: 'guardaEditorial.action',
	      data:  editParam,
	      cache: false,
	      type: "GET",
	      success: function(datos){      
	    	 $( "#divModalEdit" ).dialog("close");
	       		  agregarEditorial(e);
	    		  row.find('.ideditorial').attr('value',datos.codigo);
	    		  row.find('.nomeditorial').attr('value',datos.nombre);
	      }
	  });
	
});
	

var regautor=$('#btnRegAutor').live("click",
		function (e){
	e.preventDefault();
	 var editParam= $("#formRegistroAutor").serialize();
	 $.ajax({
	      url: 'guardaAutor.action',
	      data:  editParam,
	      cache: false,
	      type: "GET",
	      success: function(datos){      
	    	 $( "#divModalAutor" ).dialog("close");
	       		  agregarAutor(e);
	    		  row.find('.idautor').attr('value',datos.codigo);
	    		  row.find('.nomcompautor').attr('value',datos.nombre);
	      }
	  });
	
});
	

var regtema=$('#btnRegTema').live("click",
		function (e){
	e.preventDefault();
	 var param= $("#formRegistroTema").serialize();
	 $.ajax({
	      url: 'guardaTema.action',
	      data:  param,
	      cache: false,
	      type: "GET",
	      success: function(datos){      
	    	 $( "#divModalTema" ).dialog("close");
	       		  agregarTema(e);
	    		  row.find('.idtema').attr('value',datos.codigo);
	    		  row.find('.nomtema').attr('value',datos.nombre);
	      }
	  });
	
});

	
	
	
$('#txtpersonalaprobacion').autocomplete(
	paramAutocompletarPersonal
);	
	
idgeneditorial=$('#idulteditorial').val();	
idgenautor=$('#idultautor').val();	
	
//modal imagen	
	var dialogModalDoc = $( "#divModalArchivo" ).dialog({
		autoOpen: false,
		width: 500,
		modal: true
	});
	
//modal anp
	var dialogModalAnp = $( "#divModalAnp" ).dialog({
		autoOpen: false,
		width: 800,
		modal: true
		
    });	 
	
var dialogModaledit = $( "#divModalEdit" ).dialog({
			autoOpen: false,
			width: 400,
			modal: true
			
});	

var dialogModalautor = $( "#divModalAutor" ).dialog({
	autoOpen: false,
	width: 600,
	modal: true
	
});

var dialogModaltema = $( "#divModalTema" ).dialog({
	autoOpen: false,
	width: 400,
	modal: true
	
});	
var pagProy = $('.linkCreaRegistro').live("click",
		function (e){ 
   			e.preventDefault();
   			var idmodal=$(this).attr('name');
   			if(idmodal==1){
   				$( "#divModalEdit" ).dialog( "open" );
   			}
   			else
   				if(idmodal==2){
   	   				$( "#divModalAutor" ).dialog( "open" );
   	   			}
   				else
   	   				if(idmodal==3){
   	   	   				$( "#divModalTema" ).dialog( "open" );
   	   	   			}
   			$("#txaNombre").val("");
   			$("#cboPais").val(0);
   			$("#cboGenero").val(0);
   			$("#cboTipoDocumento").val(0);
   			$("#txtDireccion").val("");
   			$("#txtNumDocumento").val("");
   			$("#txtTelefono").val("");
   			$("#txtEmail").val("");
   			
		}
);
/*
var pagProy = $('.linkCreaEditorial').live("click",
		function (e){ 
   			e.preventDefault();
   			$( "#divModalEdit" ).dialog( "open" );
   			$("#txaNombre").val("");
   			$("#cboPais").val(0);
   			$("#txtDireccion").val("");
   			$("#txtTelefono").val("");
   			
		}
);

var pagProy = $('.linkCreaAutor').live("click",
		function (e){ 
   			e.preventDefault();
   			$( "#divModalAutor" ).dialog( "open" );
   			$("#txaNombre").val("");
   			$("#cboPais").val(0);
   			$("#txtDireccion").val("");
   			$("#txtTelefono").val("");
   			$("#txtEmail").val("");
   			
		}
);
	*/
//abiri modal anp
	var pagProy = $('#linkModalAnp').live("click",
    		function (e){ 
       			e.preventDefault();
       			$( "#divModalAnp" ).dialog( "open" ); 			
    			
    		}
    );
	
	

//crear recurso informacion 	
var nuevoRecInf = $("#btnNuevoRecInf").click(
    		nuevoRecursoInformacion
 );
	

	

$("#iframeUpload").load(function(){ 
	var imgPortadaRecInf  = $("#imgPortadaRecInf");
	if ( !imgPortadaRecInf.hasClass("active") ){
		imgPortadaRecInf.addClass("active");
		return;
	}
	//console.log("Mostrando Imagen");
	$("#imgPortadaRecInf").attr("src","getImagenPortada?"+(+new Date()) );
	$('#divModalImagen').dialog("close");
	/// Borrar Temporizador
}); 

var regdoc = $('#btnRegistroArchivo').click(
		function(e){
			
			Valid.init($("#formRegistroArchivo .valid"));
			
			var nomArch=$.trim($("#fileArchivo").val() );
			/// Incluir Temporizador
			if( !Valid.test() ){ 
				return;
			}
			idarchivo=$('#idarchivomodal').val();
			if(idarchivo==1){
			   $('#rowarchivo_1').find('.idcodigoarchivo').val(1);
        	   $('#rowarchivo_1').find('.i_quit').click(
        		       quitarArchivo
        	   );
        	   $('#rowarchivo_1').find('.i_quit').show();
			   $('#rowarchivo_1').find('.nomarchivo').text($("#fileArchivo").val());
			}else
				if(idarchivo==2){
				$('#rowarchivo_2').find('.idcodigoarchivo').val(2);
		        $('#rowarchivo_2').find('.i_quit').click(
		        		       quitarArchivo
		         );
		        $('#rowarchivo_2').find('.i_quit').show();
			}
			$("#formRegistroArchivo").attr('action','cargaArchivoBiblioteca.action?idcodigo='+idarchivo);
			$("#formRegistroArchivo").submit();
			$("#divModalArchivo").dialog('close');
			$("#formRegistroArchivo").attr('action','');
			//console.log("Guardando Imagen");
			

			
            
		}
	
);




var pagDoc = $('.linkModalArchivo').live('click',
		function (e){ 
			e.preventDefault();
			$('#divModalArchivo').dialog("open");
			$('#fileArchivo').text('');
			$('#fileArchivo').val('');
			id= $(this).attr('name');
			$('#idarchivomodal').val(id);
			
			
		}
);

/*
var pagDoc = $('#linkModalImagen').click(
		function (e){ 
			e.preventDefault();
			$('#divModalImagen').dialog("open");
			//limpiar
			/*
			$('#divModalRegDoc').find('.txtModalDoc').val('');
			$("#fileArchivo").val('');
			$("#divModalRegDoc").find('.divArchModalDoc').html('');
			idgendoc++;
			$('#divModalRegDoc').find('.hdModalDoc').val(idgendoc);
			*/
			//tipo
			//$('#hdTipoRegistroDoc').val(1);
			//$('#spNumDoc').text(idgendoc);
		/*	
		}
);
*/


var modanpp = $('#cboCatAnpModal').change(
		function (e){ 
   			e.preventDefault();
   			idcodigoanp=$('#cboCatAnpModal').val();
   			
   			$(".checkListaAnp").each(
   					
   			 function(i,e){
   				$(this).parent().show();
   				//$("#divAnp"+i).show();
   				if(idcodigoanp!=0){
   					if($(this).parent().find('.idcategoriaanp').val()!=idcodigoanp){
   						$(this).parent().hide();
       				}
   					/*
   					if($("#hdCatAnp"+i).val()!=idcodigoanp){
       					$("#divAnp"+i).hide();
       				}
       				*/
   				}
   				
   			 }		
   			);
   			
		}
);



var pll = $('#btnAnpSel').live("click",
		function (e){ 
			
			e.preventDefault();
			$('#camposAnpSel').html('');
				//anpsel='';
				
				 n=0;
			  $('.checkListaAnp').each(
				function(){
					if(this.checked){
						var idanpsel=$(this).parent().find('.idanpsel').val();
					    var idanp=$(this).parent().find('.idanp').val();
					    var idcatanp=$(this).parent().find('.idcategoriaanp').val();
					    var nomarea=$(this).parent().find('.nomcomareanatural').text();
					    n++;
					    i=n-1;
					    row1=$('#divContRowAnpSel').clone();
						row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
						row= $(row2);
						row.find('.idrecinfareasel').val(idanpsel);
						row.find('.idareasel').val(idanp);
						row.find('.nomcomareasel').text(nomarea);  
						$('#camposAnpSel').append(row);	
						i++;
						
					}
						
				}		
				);
				//anpsel+='';
				//$('#divListaAnpSel').html(anpsel);
				//$('#divListaAnpSel').show();
				$('#divModalAnp').dialog("close");
			}
);			


//AGREGAR EDITORIAL
var linkEdit = $('#linkAddEditorial').live('click',
		function(e) {
			e.preventDefault();
			agregarEditorial(e);
		}
);

//AGREGAR AUTOR
var linkAutor = $('#linkAddAutor').live('click',
		function(e) {
			e.preventDefault();
			agregarAutor(e);
		}
);


//AGREGAR TEMA
var linkAutor = $('#linkAddTema').live('click',
		function(e) {
			e.preventDefault();
			agregarTema(e);
		}
);

//CERRAR MODALES
var cerrar = $('.linkCerrar').live("click",
		function (e){
        e.preventDefault();
        var modal= $(this).attr("name");
        if(modal=='imgModalArchivo'){
        	$('#divModalArchivo').dialog("close");
        }
        else
        	if(modal=='imgAnp'){
	        	$('#divModalAnp').dialog("close");
	        }
        	else
	        	if(modal=='imgEditorial'){
		        	$('#divModalEdit').dialog("close");
		        }
	        	else
		        	if(modal=='imgAutor'){
			        	$('#divModalAutor').dialog("close");
			        }
		        	else
			        	if(modal=='imgTema'){
				        	$('#divModalTema').dialog("close");
				        }
        
        /*
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
		*/		        
 }
);

	



	
});

//END LOAD

/////////////////////////////////////FUNCIONES////////////////////////////////

//BEGIN FUNCTION




//agregar editorial
function agregarEditorial(e){
	idgeneditorial++;
	n=idgeneditorial;
	i=n-1;
	row1=$('#divContRowEditorial').clone();
	row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
	row= $(row2);
	row.find('.idcodigorecinfeditorial').val(n);//codigo

	row.find('.nomeditorial').autocomplete(
			paramAutocompletarEditorial
			);
	
	row.find('.i_quit').click(
			 quitarElemento
			);
	$('#camposEditorial').append(row);	
}


//agregar autor
function agregarAutor(e){
	idgenautor++;
	n=idgenautor;
	i=n-1;
	row1=$('#divContRowAutor').clone();
	row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
	row= $(row2);
	row.find('.idcodigorecinfautor').val(n);//codigo
	/*
	row.find('.tipobusquedaautor').change(
			function(e){
				paramAutocompletarAutor.opcion=$(this).val();
				row.find('.nomcompautor').val('');
			}
			
	);
	*/
	row.find('.nomcompautor').autocomplete(
			paramAutocompletarAutor
			);
	
	row.find('.i_quit').click(
			 quitarElemento
			);
	$('#camposAutor').append(row);	
}


//agregar tema
function agregarTema(e){
	idgentema++;
	n=idgentema;
	i=n-1;
	row1=$('#divContRowTema').clone();
	row2 =row1.html().replace(/_n/g,n).replace(/_i/g,i);
	row= $(row2);
	row.find('.idcodigorecinftema').val(n);//codigo

	row.find('.nomtema').autocomplete(
			paramAutocompletarTema
			);
	
	row.find('.i_quit').click(
			 quitarElemento
			);
	$('#camposTema').append(row);	
}


//crear recurso informacion
function nuevoRecursoInformacion(e){
	     e.preventDefault();
		 window.location.href='registroRecInf.action';
		 entranuevorecurso=1;
		 
}

//guardar recurso informacion
function registroRecursoInformacion(e){
	$("#formRegistroRecInf").attr('action','guardaRecInf.action');
	$("#formRegistroRecInf").submit();
}

//muestra archivos biblioteca
/*
function mostrarArchivoBiblioteca(e){
	
		 e.preventDefault();
		//var idcodigo=$(this).attr('param');
		//window.location.href='muestraArchivoProyecto.action?idcodigo='+idcodigo;
		 window.location.href='muestraArchivoBiblioteca.action';
}
*/
function quitarElemento(e){
	 e.preventDefault();
	 $(this).parent().remove();
}



function quitarArchivo(e){
	e.preventDefault();
	   $(this).parent().find('.idarchivo').val(0);
	   $(this).parent().find('.i_quit').hide();
	   $(this).parent().find('.nomarchivo').text('');
		 
}


function eliminarRecursosInformacion(e){
	$("#formInicioRecInf").attr('action','eliminaRecInf.action');
	$("#formInicioRecInf").submit();
}

function mostrarArchivoRecursoInformacion(e){
	
	    e.preventDefault();
	    var idcodigo=$(this).attr('param');
		window.location.href='muestraArchivoRecInf.action?idcodigo='+idcodigo;
}

//END FUNCTION