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
	
	#divLinkInfra .btnInfra{
	color:#fff;
	font:bold 10pt Verdana;
	text-transform:uppercase;
	padding:5px 10px;
	cursor:pointer;
	background-color: #69A74E;
	border-color: #3B6E22 #3B6E22 #2C5115;
	}
	
	#divLinkInfra .btnInfraDisabled{
	color:#ccc;
	font:bold 10pt Verdana;
	text-transform:uppercase;
	padding:5px 10px;	
	background-color: #aaa;
	border-color: #ccc;
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

.elimInf{
background-color: #fff;
padding: 2px; 
}

.elimInfHover{
background-color: #feeecc;
padding: 2px;
}

legend{
display: block;
}
h1{
margin-top: 10px;
margin-bottom: 10px;
}
-->
</style>

<h1>Actualizaci&oacute;n de Infractor</h1>
<s:form id="formularioInfractor" enctype="multipart/form-data">

	<input type="hidden" name ="expediente.resolucion.idresolucion" value='<s:property value="expediente.resolucion.idresolucion"/>'/>
	
	<input type="hidden" name ="expediente.multa.idmulta" value='<s:property value="expediente.multa.idmulta"/>'/>
	
	<input type="hidden" name ="expediente.idexpediente" value='<s:property value="expediente.idexpediente"/>'/>
	
	<%--
	<input type="hidden" name ="expediente.infractor.idinfractor" value='<s:property value="expediente.infractor.idinfractor"/>'/>
	<input type="hidden" name ="expediente.infractor.idpersonanatural" value='<s:property value="expediente.infractor.idpersonanatural"/>'/>
	<input type="hidden" id="multaExpediente" value='<s:property value="expediente.multa.montomulta"/>'/>
	<input type="hidden" name="expediente.multa.idmulta" value='<s:property value="expediente.multa.idmulta"/>' />
	<input type="hidden" id="HiddenEstadoMulta" value='<s:property value="expediente.multa.estadomulta" />' />
	
	 --%>
	
	<fieldset id="Infracciones" class="l" >
	<legend>Datos generales</legend>
	
	<div class="campo">
	<label>Tipo Documento </label>
		
	<s:if test="%{expediente.infractor.tipodocumento.idtipo == 1}">
	<input type ="radio" id="DNI" name="tipodoc" value='1' checked="checked" />DNI
	</s:if>
	<s:else>
	<input type ="radio" id="DNI" name="tipodoc" value='1' />DNI
	</s:else>
	
	<s:if test="%{expediente.infractor.tipodocumento.idtipo == 2}">
	<input type ="radio" id="CE" name="tipodoc" value='2' checked="checked" />CE
	</s:if>
	<s:else>
	<input type ="radio" id="CE" name="tipodoc" value='2' />CE
	</s:else>
			
	<input type="hidden" name="expediente.infractor.tipodocumento.idtipo" id="paramTipoDocumento" value='<s:property value="expediente.infractor.tipodocumento.idtipo" />' />
	
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
		<input id="paramSexo" type="hidden" value='<s:property value="expediente.infractor.sexo.idtipo"/>'/>
		
	</div>
	<div class="campo">
		<label>Estado Civil </label>
		<select id="EstadoCivil" class="select valid"  name='expediente.infractor.estadocivil.idtipo'>
			<option >--Seleccione--</option>
			<option value='5'>Soltero</option>
			<option value='6'>Casado</option>
		</select>
		<input id="paramEstC" type="hidden" value='<s:property value="expediente.infractor.estadocivil.idtipo"/>'/>
	</div>
	<div class="limpiador"></div>
	
	</div>
	</fieldset>
	<div class="limpiador"></div>
		
	<fieldset id="Infracciones" class="l" ><legend>Infracciones</legend>
	
	<div>		
	<div  id="totalInfracciones">

	<s:set var="i" value="0" />
	<s:iterator value="expediente.listaExpedienteInfraccion">
		
		<%--					
		<input id="EditInfraccionID" type='hidden' name='expediente.listaExpedienteInfraccion[<s:property value="#y"/>].infraccion.idinfraccion'
		value="<s:property value="#y"/>" />
		<input id="EditReincidenciaMulta" type='hidden'/>
		
		<div id="divInfraccionCargada<s:property  value="infraccion.idinfraccion"/>" style="display:none" >
		<span class="descripcionInfraccion"><s:property value="infraccion.descripcioninfraccion"/></span><br>
		<span class="idInfraccion"><s:property value="infraccion.idinfraccion"/></span><br>
		<span class="codigoInfraccion"><s:property value="infraccion.codigoinfraccion"/></span><br>
		</div>
		
		 --%>
		 
		<div id="divIF_<s:property  value="infraccion.idinfraccion"/>" class="elimInf" onmouseover="className='elimInfHover'" onmouseout="className='elimInf'" >
		<input type='hidden' name='expediente.listaExpedienteInfraccion[<s:property value="#i"/>].infraccion.idinfraccion' value="<s:property  value="infraccion.idinfraccion"/>" />
		<input type='hidden' name='expediente.listaExpedienteInfraccion[<s:property value="#i"/>].reincidencia' id="inputReincidencia<s:property  value="infraccion.idinfraccion"/>" value="<s:property  value="infraccion.reincidencia" />" />
		<div style='float:left;width:30px;'><s:property value="infraccion.codigoinfraccion"/></div>
		<div style='float:left;width:650px;'><s:property value="infraccion.descripcioninfraccion"/></div>
		<div class="i_supr i" style="float:left;" title="name=" onClick = javascript:Fnc_quitarInfraccion("divIF_<s:property  value="infraccion.idinfraccion"/>","<s:property  value="infraccion.idinfraccion"/>"); ></div>
		
		<div class='limpiador'></div>
		
		</div>
		
		<s:set var="i" value="#i+1" />
		
	</s:iterator>
	
	<input type="hidden" id="cantInfrac" value="<s:property value="#i"/>" />
	</div>
	
	<div class='limpiador'></div>

	<div id="divLinkInfra">
	
	<input type="button"  class="btnInfra" value="Agregar" />
	
	</div>

	</div>

	</fieldset>
	<div class="limpiador"></div>
	
	<fieldset id="Sanciones" class="l"><legend>Sanciones</legend>
	<div>
	<label>Elija una Sanci&oacute;n</label>
	<s:select list="listaSanciones" cssClass="select valid tipoBusquedaSancion" id="listaSanciones"
			listKey="idsancion"  listValue="descripcionsancion"
  			headerKey="-1" theme="simple"
 			headerValue="------ Seleccione una Sancion------" 
 			name="expediente.listaExpedienteSancion[_n].sancion.idsancion"  onchange="javascript:agregarSancion();"/>
		
 	</div><div class="limpiador"></div><br>
	<div id="CabeceraSanciones" style="width: 650px;"><div class="DivTd3">Sanci&oacute;n</div><div class="DivTd4" style="text-align: center;">Observaci&oacute;n</div></div>
	<div class="limpiador"></div>
		
<!-- 	NUEVA OPCION PARA CARGAR LAS SANCIONES -->

<div id="totalSanciones">
		
	<s:set var="m" value="0" />
	<div>
	<s:iterator value="expediente.listaExpedienteSancion">
	
			<div id="rowSancion<s:property value="sancion.idsancion" />"  class="DivTr" >
			<div id="DivTipoSancion<s:property value="sancion.idsancion" />" class="DivTd3" style="text-align: left;" ><s:property value="sancion.descripcionsancion" /></div>
			<div class="DivTd4">
			
			<input type="hidden" id="HiddenSancion<s:property value="sancion.idsancion" />" name="expediente.listaExpedienteSancion[<s:property value="sancion.idsancion" />].sancion.idsancion" value="<s:property value="sancion.idsancion" />"/>
			
						
			<div class="CampoEditable" >
			<s:if test="%{sancion.idsancion == 1 }">
				Monto S/. 
				<input type="text" class="decimal valid" id="observacionSancion<s:property value="sancion.idsancion" />" name="expediente.listaExpedienteSancion[<s:property value="sancion.idsancion" />].expediente.multa.montomulta" size="10" value="<s:property value ="expediente.multa.montomulta" />" /> 
				cancelado
				<s:if test="%{expediente.multa.estadomulta == 1}">
				<input class="ckEstadoMulta" type='checkbox' name='expediente.listaExpedienteSancion[<s:property value="sancion.idsancion" />].expediente.multa.estadomulta' value='1' checked="checked" />
				</s:if>
				<s:else>
				<input class="ckEstadoMulta" type='checkbox' name='expediente.listaExpedienteSancion[<s:property value="sancion.idsancion" />].expediente.multa.estadomulta' value='0' />
				</s:else>				
			</s:if>
			<s:else>
				<textarea class="content valid" rows="4" cols="60" name="expediente.listaExpedienteSancion[<s:property value="sancion.idsancion" />].sancion.observacion"><s:property value="sancion.observacion" /></textarea>
			</s:else>				
			</div>		
			</div>
			<div  class="i i_supr" title="eliminar" class="DivTd5" onclick="javascript:Fnc_quitarSancion('rowSancion<s:property value="sancion.idsancion" />','<s:property value="sancion.idsancion" />');"></div>
			
			</div>
			<div class="limpiador"></div>
			
			<s:set var="m" value="#m+1" />
	
	</s:iterator>
	</div>
	
	<%--
	<s:iterator value="expediente.listaExpedienteSancion">
	
		<s:if test="%{sancion.idsancion == 1 }">
		
		</s:if>
		<s:else>
		
		</s:else>
		
		<input type="hidden" id="editHiddenIdSancion<s:property value="#m" />"  value="<s:property value="sancion.idsancion" />"/>
		<input type="hidden" id="editHiddenObservacionSancion<s:property value="#m" />" value="<s:property value="sancion.observacion" />"/>
		<s:set var="m" value="#m+1" />
		 	
	</s:iterator>
	 --%>
</div>
	 
<input type="hidden" id="cantSanc" value="<s:property value="#m"/>" />
	

<!-- 	SANCIONES -->

<script type="text/javascript">
$().ready(function(){
	
	$("#Sexo").val($("#paramSexo").val());
	$("#EstadoCivil").val($("#paramEstC").val());
	
	
	 $('#paramNumeroDocumento').attr('readOnly','readOnly');
	 $('#paramApePat').attr('readOnly','readOnly');
	 $('#paramApePat').attr('readOnly','readOnly');
	 $('#paramApeMat').attr('readOnly','readOnly');
	 $('#paramNombre').attr('readOnly','readOnly');
	 //$('#Sexo').attr('disabled','disabled');
	 //$('#EstadoCivil').attr('disabled','disabled');
	
	$("#divLinkInfra input").click(Fnc_cargaModalInfracciones);
	
	var inputInf = $("#cantInfrac"); 
	
	for(i=0; i<inputInf.val(); i++){
		inputVal = $("#totalInfracciones input[name='expediente.listaExpedienteInfraccion["+i+"].infraccion.idinfraccion']").val();
		infraccionesSeleccionadas.push(inputVal);
	}
	
	/*
	var $inputs = $("#totalInfracciones input[type=hidden]");
	var values = {};sancion.idsancion
    $inputs.each(function() {
        //values[this.name] = $(this).val();
        alert(this.name+"/"+$(this).val());
    });
    */
    	
});


	
</script>


<!-- 		ESTE ES EL DIV QUE DUPLICAR E PARA SANCION -->
<!-- el truco es hacer que este div coincida con el generado por el javascrip -->
		<div id="divCountSancion_" style="display: none;">
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
	
	<fieldset id="Infracciones" class="l" ><legend>Resoluci&oacute;n</legend>
	<div class="campo">
		<label>N° de Resoluci&oacute;n</label>
		<s:textfield theme="simple"  id="paramResolucion" name="expediente.resolucion.numeroresolucion" size="20"  cssClass="content valid"/>
	</div>
	<div class="campo">
		<label>Fecha de Resoluci&oacute;n</label>
		<s:textfield theme="simple"  name="expediente.resolucion.fecha"  id="fechaResolucion__" size="9" cssClass="dateDMY input valid datepicker" readonly="readonly" title="Fecha2" />
	</div>
	
	<div class="campo">
		<label>Adjuntar Resoluci&oacute;n</label><input type="file" name="file" id="archivoAdjunto"  size="15" />
		<br>
		<a href="#" class="linkDelImg"  >
        <s:property value="expediente.resolucion.archivo.nombreinicial" />    
	    </a>						
		
<%-- 		<input type="hidden" id="dirdirectorio" value="<s:property value="expediente.resolucion.archivo.directorioarchivo.dirdirectorio" />" /> --%>
<%-- 		<input type="hidden" id="nombregenerado" value="<s:property value="expediente.resolucion.archivo.nombregenerado" />" /> --%>
 		<input type="hidden" name="idarchivo" value="<s:property value="expediente.resolucion.archivo.idarchivo"/>" />		 
		
	</div>
	
	<div class="limpiador" ></div>	
	</fieldset>
	<div class="limpiador" ></div>	
	
	<div class="campo">
	<input type="button" value="Actualizar !" class="submit" onclick="javascript:validaFormulario();"/>
	</div>


</s:form>

<!-- en este modal se listaran las infracciones -->
<div id="muestraInfracciones" title="Lista de Infracciones" style="display:none;overflow: auto;">
</div>


<script type="text/javascript">

var arregloSancionesCargadas=new Array();

$().ready(function(){
	
	var inputSnc = $("#cantSanc");
		
	for(var i = 0;i < inputSnc.val(); i++){
		arregloSancionesCargadas.push($("#HiddenSancion"+i).val());
	}	
	
	
	$(".ckEstadoMulta").live('click',function(){
		var checkeado=$(".ckEstadoMulta").attr('checked');
	 	if(checkeado){ 	
	 		 $(this).val("1");	 		 
	 	}else{
	 		$(this).val("0");
	 	}
	 	
	});
	
});


// VALIDANDO FORMULARIO
function validaFormulario() { 
	
	Valid.init( $("#formularioInfractor .valid")  );  
	if(Valid.test()){
		
		if(infraccionesSeleccionadas.length == 0){
			alert("Debe agregar por lo menos una Infracci\xF3n!!!");
			return false;
		}else if(arregloSancionesCargadas.length == 0){
			alert("Debe agregar por lo menos una Sanci\xF3n!");
			return false;
		}else{
			$('#formularioInfractor').attr('action','actualizarInfractor.action');
	 		$('#formularioInfractor').submit();
		}
	}
}

//PARA EL COMBO

var idgenSancion = $("#cantSanc").val();
function agregarSancion(e){
		
	//var n=idgenSancion++;
		
	var sancionText= $("#listaSanciones option:selected").text();
	var sancionVal=$("#listaSanciones option:selected").val();
	
	var n=sancionVal;
	
	var row1=$('#divCountSancion_').clone();
	var row2 =row1.html().replace(/_n/g,n);
	
	var row = $(row2);
	var aux = "#DivTipoSancion"+n;
	var aux2 ="#HiddenSancion"+n;
	
	var validador=0;
	
	//colocamos cabeceras
	if(idgenSancion>=1){
		$("#CabeceraSanciones").css("display","block");
	}else{ $("#CabeceraSanciones").css("display","none");}
	
	
	if(in_array(sancionVal,arregloSancionesCargadas)){
		return false;			
	}
	
	if(sancionVal==-1){
		return false;
	}else{
		
		arregloSancionesCargadas.push(sancionVal);
		
		row.find(aux).html(sancionText);
		//validamos si se agregara un textArea o un campo de Textos
		var cadenaHtml="";
		if(sancionVal==1){
			cadenaHtml+=" Monto S/. <input type='text' class='decimal valid' name='expediente.listaExpedienteSancion["+n+"].expediente.multa.montomulta' size='10' /> cancelado<input class='ckEstadoMulta' type='checkbox' value='0' name='expediente.listaExpedienteSancion["+n+"].expediente.multa.estadomulta'>";
		}else{
			cadenaHtml+="<textarea class='content valid' rows='4' cols='60' name='expediente.listaExpedienteSancion["+n+"].sancion.observacion'></textarea>";
		}
		row.find('.CampoEditable').html(cadenaHtml);
		row.find(aux2).val(sancionVal);
		row.find('.i_supr').click(function(){Fnc_quitarSancion("rowSancion"+n,sancionVal);});
		
		$('#totalSanciones').append(row);

		return true;
	}
}



$().ready(function(){
	
	datepickerOptions.defaultDate ="-1Y"; 
	datepickerOptions.maxDate=null;
	datepickerOptions.changeYear = false;
	datepickerOptions.changeMonth = false;
	$(".onlydigits").onlyDigits();
	$("input.datepicker").datepicker(datepickerOptions);

});

//FIN MODULO

</script>