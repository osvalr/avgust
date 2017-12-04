<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  

<style>
<!--
	#divPersona{
/*  		display: none;  */
/* 		float: left; */
	}
	
	.l{
		width: 700px;
		padding-left: 20px;
	}
	
	.limpiador{
		clear: both;
	}
	.campo{
	float: left;
	margin-right: 30px;
	margin-left: 10px;
	}
	
	.CampoEditable{
		overflow: hidden;
		
	}
	
	#totalInfracciones table td{
	text-align: justify;
	}
	
	#totalInfracciones table td.center{
	text-align: center;
	}
	
	.DivTable{
	width: 650px;
	display: block;
	color: #848484;
	
	}
	
	.DivTr{
	color: #848484;
	width: 650px;
	display: block;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #626060;
	overflow: hidden;
	}
	
	.DivTd1,.DivTd2,.DivTd3,.DivTd4,.DivTd5{
	display: block;
	float: left;
	overflow: hidden;
	} 
	
	.DivTd1{
	width: 80px;
	text-align: center;
	}
	
	.DivTd2{
	width: 520px;
	padding:5px;
	text-align: justify;
	margin-top: -4px;
	}
	
	.DivTd3{
	width: 150px;
	text-align: center;
	}
	
	.DivTd4{
	width: 470px;
	}
	.DivTd5{
	width: 30px;
	}

-->
</style>

<h1>Actualizacion de Infractor</h1>
<s:form id="formularioInfractor" enctype="multipart/form-data">

	<input type="hidden" name ="expediente.idexpediente" value='<s:property value="expediente.idexpediente"/>'/>
	<input type="hidden" name ="expediente.infractor.idinfractor" value='<s:property value="expediente.infractor.idinfractor"/>'/>
	<input type="hidden" name ="expediente.infractor.idpersonanatural" value='<s:property value="expediente.infractor.idpersonanatural"/>'/>
	<input type="hidden" id="multaExpediente" value='<s:property value="expediente.multa.montomulta"/>'/>
	<input type="hidden" name="expediente.multa.idmulta" value='<s:property value="expediente.multa.idmulta"/>' />
	<input type="hidden" id="HiddenEstadoMulta" value='<s:property value="expediente.multa.estadomulta" />' />
	
	<fieldset id="Infracciones" class="l" ><legend>Datos generales</legend>
	<div class="campo">
	<label>Tipo Documento </label>
	<input type ="radio" id="DNI" name="tipodoc" value='1' checked="checked"/>DNI 
	<input type ="radio" id="CE" name="tipodoc" value='2'/>CE 
	<input type="hidden" name="expediente.infractor.tipodocumento.idtipo" id="paramTipoDocumento" value='1' />
	</div>
	<div class="campo">
	<label>N&uacute;mero de documento </label>
	<s:textfield cssClass="doc valid onlydigits"  theme="simple" name="expediente.infractor.numerodocumento" id="paramNumeroDocumento"  onblur="javascript:verificaReincidencia();" maxlength="8" size="8"/>
	</div>
	<div class="limpiador"></div>
	
	
	
	<div id="divPersona">
	<div class="campo">
	<label>Apellido Paterno </label>
<!-- 	<input  type ="text" name="variable" id="paramApePat" /> -->
	<s:textfield name="expediente.infractor.apepat" id="paramApePat"  cssClass="content valid" theme="simple"/>
	</div>
	<div class="campo">
	<label>Apellido Materno </label>
	<s:textfield  type ="text" name="expediente.infractor.apemat" id="paramApeMat"  cssClass="content valid" theme="simple"/>
	</div>
	<div class="limpiador"></div>
	
	<div class="campo">
	<label>Nombre </label>
	<s:textfield  type ="text" name="expediente.infractor.nombre" id="paramNombre"  cssClass="content valid" theme="simple"/>
	</div>
	<div class="campo">
		<label>Sexo </label>		
		<select id="Sexo" class="select valid" name="expediente.infractor.sexo.idtipo" >
			<option >--Seleccione--</option>
			<option value='3'>Masculino</option>
			<option value='4'>Femenino</option>
		</select>
<!-- 		<input id="paramSexo" type="hidden" name="expediente.infractor.sexo.idtipo" value='3'/> -->
	</div>
	<div class="campo">
		<label>Estado Civil </label>
		<select id="EstadoCivil" class="select valid"  name='expediente.infractor.estadocivil.idtipo'>
			<option >--Seleccione--</option>
			<option value='5'>Soltero</option>
			<option value='6'>Casado</option>
		</select>
	</div>
	<div class="limpiador"></div>
	
	</div>
	</fieldset>
	<div class="limpiador"></div>
	
	
	<fieldset id="Infracciones" class="l" ><legend>Infracciones</legend>
	<div style="float: right;">
	<a id="linkAddInfraccion" href='#' style="text-decoration:none;font-weight:bold;color:#78D24C;">Agregar
	    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Ejecutoras Tecnicas" onclick="javascript:listaInfracciones();" />                     
	 </a>
	</div>
	<div>
	<div id="CabeceraInfracciones" style="width: 650px; display: none"><div class="DivTd1">Codigo</div><div class="DivTd2"  style="text-align: center;"> Detalle </div></div><div class="limpiador"></div>
	
	
	
	
	<div  id="totalInfracciones">
<!-- aqui se llenan todas las INFRACCIONES -->
	<s:set var="y" value="1" />
	<s:iterator value="expediente.listaExpedienteInfraccion">
			
				<input id="EditInfraccionID" type='hidden' name='expediente.listaExpedienteInfraccion[<s:property value="#y"/>].infraccion.idinfraccion'
				value="<s:property value="#y"/>" />
				<input id="EditReincidenciaMulta" type='hidden'/>
				
				<div id="divInfraccionCargada<s:property  value="infraccion.idinfraccion"/>" style="display:none" >
				<span class="descripcionInfraccion"><s:property value="infraccion.descripcioninfraccion"/></span><br>
				<span class="idInfraccion"><s:property value="infraccion.idinfraccion"/></span><br>
				<span class="codigoInfraccion"><s:property value="infraccion.codigoinfraccion"/></span><br>
				</div>
				<s:set var="y" value="#y+1" />
	</s:iterator>
	
	</div>
<!-- 	Fin total INFRACCIONES -->





	
	</div>

	</fieldset>
	<div class="limpiador"></div>
	
	<fieldset id="Sanciones" class="l"><legend>Sanciones</legend>
	<div >
	<div>
	<label>Elija una Sanci&oacute;n</label>
	<s:select list="listaSanciones" cssClass="select valid tipoBusquedaSancion" id="listaSanciones"
			listKey="idsancion"  listValue="descripcionsancion"
  			headerKey="-1" theme="simple"
 			headerValue="------ Seleccione una Sancion------" 
 			name="expediente.listaExpedienteSancion[_n].sancion.idsancion"  onchange="javascript:agregarSancion();"/>
		
 	</div><div class="limpiador"></div><br>
	<div id="CabeceraSanciones" style="width: 650px; display: none"><div class="DivTd3">Sanci&oacute;n</div><div class="DivTd4" style="text-align: center;">Observaci&oacute;n</div></div><div class="limpiador"></div>
	
	
	
	
	
<!-- 	NUEVA OPCION PARA CARGAR LAS SANCIONES -->
	<s:set var="m" value="1" />
	<s:iterator value="expediente.listaExpedienteSancion">
			<input type="hidden" id="editHiddenIdSancion<s:property value="#m" />" name="expediente.listaExpedienteSancion[<s:property value="#xxx" />].sancion.idsancion" value="<s:property value="sancion.idsancion" />"/>
			<input type="hidden" id="editHiddenObservacionSancion<s:property value="#m" />"
			 name="expediente.listaExpedienteSancion[<s:property value="#m" />].observacionX" 
			 value="<s:property value="sancion.observacion" />"/>
		<s:set var="m" value="#m+1" /> 	
	</s:iterator>
	
	
	
	
<!-- aqui se llenan todas las SANCIONES -->
	<div id="totalSanciones">
   <s:set var="xxx" value="1" />
   
   
   
	<s:iterator value="expediente.listaExpedienteSancion">
			<div id="divCountSancion">
			<div id="rowSancion<s:property value="#xxx" />"  class="DivTr" >
			<div id="DivTipoSancion<s:property value="#xxx" />" class="DivTd3" style="text-align: left;" ></div>
			<div class="DivTd4">
			
<!-- 			aqui obtengo los datos -->
			<input type="hidden" id="editHiddenIdSancion<s:property value="#xxx" />" name="expediente.listaExpedienteSancion[<s:property value="#xxx" />].sancion.idsancion" value="<s:property value="sancion.idsancion" />"/>
			<input type="hidden" id="editHiddenObservacionSancion<s:property value="#xxx" />"
			 name="expediente.listaExpedienteSancion[<s:property value="#xxx" />].observacionX" 
			 value="<s:property value="sancion.observacion" />"/>
			
			
			
			
			<div class="CampoEditable" id="CampoEditable<s:property value="#xxx" />">
			</div>		
<!-- 			<input type="text" id="observacionSancion_n" name="expediente.listaExpedienteSancion[_n].observacion" size="60" /> -->
			</div>
			<div  class="i i_supr" title="eliminar" class="DivTd5" ></div>
			
			</div>
			<div class="limpiador"></div>
		</div>
		<s:set var="xxx" value="#xxx+1" /> 
		
		
	</s:iterator>
	</div>
<!-- 	SANCIONES -->
	</div>

<!-- 		ESTE ES EL DIV QUE DUPLICAR E PARA SANCION -->
<!-- el truco es hacer que este div coincida con el generado por el javascrip -->
		<div id="divCountSancion" style="display: none;">
			<div id="rowSancion_n"  class="DivTr" >
			<div id="DivTipoSancion_n" class="DivTd3" style="text-align: left;" ></div>
			<div class="DivTd4">
			<input type="hidden" id="HiddenSancion_n" name="expediente.listaExpedienteSancion[_n].sancion.idsancion" value="-1"/>
			<div class="CampoEditable" ></div>		
<!-- 			<input type="text" id="observacionSancion_n" name="expediente.listaExpedienteSancion[_n].observacion" size="60" /> -->
			</div>
			<div  class="i i_supr" title="eliminar" class="DivTd5" ></div>
			
			</div>
			<div class="limpiador"></div>
		</div>
		
		
		
		
		
		
		
		
		
	</fieldset>
	<div class="limpiador"></div>
	
	<fieldset id="Infracciones" class="l" ><legend>Resolucion</legend>
	<div class="campo">
		<label>N° de Resoluci&oacute;n</label>
		<s:textfield theme="simple"  id="paramResolucion" name="expediente.resolucion.numeroresolucion" size="20"  cssClass="content valid"/>
	</div>
	<div class="campo">
		<label>Fecha de Resoluci&oacute;n</label>
		<s:textfield theme="simple"  name="expediente.resolucion.fecha"  id="fechaResolucion__" size="9" cssClass="dateDMY input valid datepicker" readonly="readonly" title="Fecha2" />
	</div>
	
	<div class="campo">
<!-- 		<label>Canceló Multa</label><input type="checkbox"/> -->
<!-- 	<label>Estado de la Multa</label> -->
<%-- 		<input type="hidden" id="estadoMulta" value='<s:property value="expediente.multa.estadomulta"/>' /> --%>
<%-- 		<select name="expediente.multa.estadomulta" id="cboEstadoMulta"> --%>
<!-- 			<option value='0'>PENDIENTE</option> -->
<!-- 			<option value='1'>CANCELADO</option> -->
<%-- 		</select> --%>
	</div>
	<div class="limpiador" ></div>	
	</fieldset>
	<div class="limpiador" ></div>	
	
	<div class="campo">
	<input type="button" value="Registrar !" class="submit" onclick="javascript:validaFormulario();"/>
	</div>
	
	
	
	
<!-- 	/**************************************************************************************************************/ -->
<!-- 	ULTIMO INTENTO -->
	
	
	
	
	
	
	
	
	
	
</s:form>

<!-- en este modal se listaran las infracciones -->
<div id="muestraInfracciones" title="Lista de Infracciones" style="height: 300px; max-height: 300px;overflow:scroll;overflow-x: hidden;">
</div>



<script type="text/javascript">


	
$().ready(function(){	
	//provisional para el estado de multa :
// 	alert(" sss /"+$("#estadoMulta").val());
// 	$("#cboEstadoMulta").val($("#estadoMulta").val());
	var estadoMulta=$("#HiddenEstadoMulta").val();
	var multa =$("#multaExpediente").val();
	
	for(var i = 1; i<10;i++){
		var htmlx="";
		
		var id=$("#editHiddenIdSancion"+i).val();
		var obs=$("#editHiddenObservacionSancion"+i).val();
		
		//alert(obs);
		var tipo="";
		if(id!=''){
			switch (parseInt(id)) {
			case 1: tipo="Multa";break;
			case 2: tipo="Comiso";break;
			case 3: tipo="Clausura Temporal";break;
			case 4: tipo="Clausura Definitiva";break;
			default:tipo="Suspencion de Permiso";break;
			}
			$("#DivTipoSancion"+i).html(tipo);
			if(id==1){
				htmlx+="Monto S/. <input type='text' class='decimal valid' id='observacionSancion"+i+"' name='expediente.multa.montomulta' value='"+multa+"' size='10' />&nbsp; cancelado<input id='ckEstadoMulta' type='checkbox' value='1' name='expediente.multa.estadomulta'>";
			}else{
				htmlx+="<textarea  class='content valid' rows='4' cols='60' id='observacionSancion"+i+"' name='expediente.listaExpedienteSancion["+i+"].observacion'  >"+obs+"</textarea> ";
			}
			
			htmlx+="<input type='hidden' id ='editHiddenIdSancion"+i+"' name='listaExpedienteSancion["+i+"].sancion.idsancion' value='"+id+"'/>";
// 			htmlx+="<input type='hidden' id='editHiddenObservacionSancion' name='listaExpedienteSancion["+i+"].observacion' value='"+obs+"'/>";
			//alert(obs);
			$('#CampoEditable'+i).html(htmlx);
			sancionesSeleccionadas[i]=1;
		}

	}
	
	
	//ahora gestionamos el check
	if(estadoMulta==1){
		$("#ckEstadoMulta").attr("checked","1");
	}
});



$().ready(function(){
// 	alert("cargado !");
	//primero cargo el arreglo con las infracciones
	
	for(i=0;i<=16;i++){
		var gg="#divInfraccionCargada"+i;
// 		var zz =$(gg).val();
		var dd= $.trim($(gg).find(".idInfraccion").text());
// 		alert(gg+" / "+dd);
		if(dd!=""){
			
			infraccionesSeleccionadas[i]++;
// 			alert("gg:"+infraccionesSeleccionadas[i]);
		}
	}
	
	var vhtml="<div class='DivTable' >";
	
	//muestra las cabeceras
	if(infraccionesSeleccionadas.length>=1){
		$("#CabeceraInfracciones").css("display","block");
	}else{ $("#CabeceraInfracciones").css("display","none");}
	
	
	for(i=1;i<infraccionesSeleccionadas.length;i++){
		if(infraccionesSeleccionadas[i]!=0){
			//mostramos cabecera
			var gg="#divInfraccionCargada"+i;
			var generaid= "#h"+i;
			var generacod="#hCod"+i;
			var boton="#DivTr"+i;
			var codigoParaMostrar="#hCodMostrar"+i;
							
//			vhtml+="<div >"+i+"</div><div  style='width:500px;text-align: justify;'>"+infraccionesSeleccionadas[i]+"/"+$(generaid).val();+"</div></hr>";
		vhtml+="<div class='DivTr' id='DivTr"+i+"'>"+
		"<div class ='DivTd1'> "+$(gg).find(".codigoInfraccion").text()+"</div>"+
		"<div class ='DivTd2'>"+$(gg).find(".descripcionInfraccion").text()+"<input type='hidden' name='expediente.listaExpedienteInfraccion["+i+"].infraccion.idinfraccion' value="+i+" /></div>"+
		"<div class='i_supr i DivTd5 '  title='eliminar'  onClick='javascript: quitarInfraccion("+i+")'></div>"+
		"<input name='expediente.listaExpedienteInfraccion["+i+"].reincidencia' id='inputReincidencia"+i+"' type='hidden' value='1' />"+
		"<div class='limpiador'></div>"+
		"</div >";
		

//			vhtml+=""+i+""+infraccionesSeleccionadas[i]+""
	
		}
	}
	vhtml+="</div>";
	
	$("#totalInfracciones").html(vhtml);
	
	
	for(var i=0;i<=infraccionesAntiguas.length;i++){
		if(infraccionesAntiguas[i]!=0){
			var aux= "#DivTr"+infraccionesAntiguas[i];
			var input="#inputReincidencia"+infraccionesAntiguas[i];
//			alert("AUX :"+aux);
			$(aux).addClass("TrReincidente");
			$(input).val('2');
		}
	}
	//***************************************
	
	
	
	
	
	$.post('verificaInfractorEnSistema.action', {dni:$("#paramNumeroDocumento").val()}, function(datos) {
		
	     var infractor= datos.MyInfractor;	    

	    
	     	     
	     if(infractor!=null){
	    	 
	    	 var idinFractor= infractor.idinfractor;
	    	 var nombres=infractor.nombre;
	         var apePat=infractor.apepat;
	         var apeMat=infractor.apemat;
	         var numerodoc=infractor.numerodocumento;
	         var sexo = infractor.sexo.idtipo;
	         var estadocivil = infractor.estadocivil.idtipo;
	         
//	         alert(idinFractor+" / "+nombres+" / "+apePat+" / "+apeMat+" / "+numerodoc+" / "+sexo+" / "+estadocivil);
	         
	         	 $('#idInfractorAyuda').val(idinFractor);
	        	 $('#Sexo').val(sexo);
	        	 $('#EstadoCivil').val(estadocivil);     	 
	        	 $('#paramApePat').val(apePat);
	        	 $('#paramApeMat').val(apeMat);
	        	 $('#paramNombre').val(nombres);
	        	 
	        	 $('#Sexo').attr('readOnly','readOnly');
	        	 $('#EstadoCivil').attr('readOnly','readOnly');
	        	 $('#paramApePat').attr('readOnly','readOnly');
	        	 $('#paramApeMat').attr('readOnly','readOnly');
	        	 $('#paramNombre').attr('readOnly','readOnly');
	         
	     }else{
	    	 $('#idInfractorAyuda').val('00');
	    	 $('#Sexo').val('');
       	 $('#EstadoCivil').val('');     	 
       	 $('#paramApePat').val('');
       	 $('#paramApeMat').val('');
       	 $('#paramNombre').val('');
       	 
       	 
       	 $('#Sexo').attr('readOnly','');
       	 $('#EstadoCivil').attr('readOnly','');
       	 $('#paramApePat').attr('readOnly','');
       	 $('#paramApeMat').attr('readOnly','');
       	 $('#paramNombre').attr('readOnly','');
	     }
			
	     $.post('verificaReincidenciaInfracciones.action',{idInfractor:$("#idInfractorAyuda").val()}, function(datosInfracciones) {
	 		var listaInfraccionesAntiguas = datosInfracciones.InfraccionesAntiguas;
	 		var arregloCadena;
	 		if(listaInfraccionesAntiguas!=null)
	 		for(var i=0;i<listaInfraccionesAntiguas.length;i++){
	 			infraccionesAntiguas[i]=listaInfraccionesAntiguas[i].idinfraccion;
	 			arregloCadena+= i+":"+infraccionesAntiguas[i]+" / ";
	 		}
	 		
	 		else{
	 			for(var i=0;i<listaInfraccionesAntiguas.length;i++){
	 				infraccionesAntiguas[i]=0;
	 			}
	 		}
	 		
	 	},'json');
	},'json');
	
});






$(function() {
	// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
	$( "#dialog:ui-dialog" ).dialog( "destroy" );

	$( "#muestraInfracciones" ).dialog({
		width: 600,
		heigth: 300,
		autoOpen: false,
		modal: true,
// 		overflow:scroll;
	//$('body').css('overflow','hidden');$('.ui-widget-overlay').css('width','100%'); 
		open: function(event, ui){$('#muestraInfracciones').css('background-color','white');$('.ui-dialog').css('background-color','white');$('.ui-dialog-buttonpane').css('background-color','white');
		$('body').css('overflow','hidden');$('.ui-widget-overlay').css('width','100%'); },
// 		$('.ui-widget').css('background-color','red');$('.ui-widget-content').css('background-color','red');$('.ui-corner-all').css('background-color','red');},
	    close: function(event, ui){$('body').css('overflow','auto'); } ,
		buttons: {
			Ok: function() {
				$( this ).dialog( "close" );


				var vhtml="<div class='DivTable' >";
				
				//muestra las cabeceras
				if(infraccionesSeleccionadas.length>=1){
					$("#CabeceraInfracciones").css("display","block");
				}else{ $("#CabeceraInfracciones").css("display","none");}
				
				
				for(i=1;i<infraccionesSeleccionadas.length;i++){
					if(infraccionesSeleccionadas[i]!=0){
						//mostramos cabecera
						
						var generaid= "#h"+i;
						var generacod="#hCod"+i;
						var boton="#DivTr"+i;
						var codigoParaMostrar="#hCodMostrar"+i;									
// 					vhtml+="<div >"+i+"</div><div  style='width:500px;text-align: justify;'>"+infraccionesSeleccionadas[i]+"/"+$(generaid).val();+"</div></hr>";
					vhtml+="<div class='DivTr' id='DivTr"+i+"'>"+
					"<div class ='DivTd1'> "+$(codigoParaMostrar).val()+"</div>"+
					"<div class ='DivTd2'>"+$(generaid).val()+"<input type='hidden' name='expediente.listaExpedienteInfraccion["+i+"].infraccion.idinfraccion' value="+$(generacod).val()+" /></div>"+
					"<div class='i_supr i DivTd5 '  title='eliminar'  onClick='javascript: quitarInfraccion("+i+")'></div>"+
					"<input name='expediente.listaExpedienteInfraccion["+i+"].reincidencia' id='inputReincidencia"+i+"' type='hidden' value='1' />"+
					"<div class='limpiador'></div>"+
					"</div >";
					

// 					vhtml+=""+i+""+infraccionesSeleccionadas[i]+""
				
					}
				}
				vhtml+="</div>";
				
				$("#totalInfracciones").html(vhtml);
				
				
				for(var i=0;i<=infraccionesAntiguas.length;i++){
    				if(infraccionesAntiguas[i]!=0){
    					var aux= "#DivTr"+infraccionesAntiguas[i];
    					var input="#inputReincidencia"+infraccionesAntiguas[i];
//    					alert("AUX :"+aux);
    					$(aux).addClass("TrReincidente");
    					$(input).val('2');
    				}
    			}
				
				
				
			}
		}
	});
});

// VALIDANDO FORMULARIO
function validaFormulario() { 
	
	Valid.init( $("#formularioInfractor .valid")  );  
	if(Valid.test()){ 	
		//alert("Se enviara el formulario !");
		$('#formularioInfractor').attr('action','actualizarInfractor.action');
		$('#formularioInfractor').submit();
	}
}



//PARA EL COMBO
function agregarSancion(e){
	//alert('agregar !');
	idgenSancion++;
	n=idgenSancion;
	
	var sancionText= $("#listaSanciones option:selected").text(); 
	var sancionVal=$("#listaSanciones option:selected").val();
	
	
	row1=$('#divCountSancion').clone();
	row2 =row1.html().replace(/_n/g,n);
	row= $(row2);
	var aux= "#DivTipoSancion"+n;
	var aux2="#HiddenSancion"+n;
	
	var validador=0;
	
	//colocamos cabeceras
	if(idgenSancion>=1){
		$("#CabeceraSanciones").css("display","block");
	}else{ $("#CabeceraSanciones").css("display","none");}
	
	//validamos que lo seleccionado no este agregado ya
	for(i =0; i<idgenSancion;i++){//length
		var x= "#HiddenSancion"+i;
		if($(x).val()==sancionVal){
			validador++;
		}
	}
	if(validador!=0){
		return false;
	}
	if(sancionVal==-1){
		return false;
	}
	else{
	row.find(aux).html(sancionText);
	//validamos si se agregara un textArea o un campo de Textos
	var cadenaHtml="";
	if(sancionVal==1){
		cadenaHtml+=" Monto S/. <input type='text' class='decimal valid' id='observacionSancion"+n+"' name='expediente.multa.montomulta' size='10' />";
	}else{
		cadenaHtml+="<textarea onClick='limpiacaja(this);' clas='content valid' rows='4' cols='60' id='observacionSancion"+n+"' name='expediente.listaExpedienteSancion["+n+"].observacion'> ...Ingrese sus detalles aqu&iacute;...</textarea>";
	}
	row.find('.CampoEditable').html(cadenaHtml);
	row.find(aux2).val(sancionVal);
	row.find('.i_supr').click(
			 quitarSancion
			);
	$('#totalSanciones').append(row);	
	
	return true;
	}
}

//FIN MODULO





datepickerOptions.defaultDate ="-1Y"; 
datepickerOptions.maxDate=null;
datepickerOptions.changeYear = false;
datepickerOptions.changeMonth = false;
$(".onlydigits").onlyDigits(); 
$("input.datepicker").datepicker(datepickerOptions);

</script>