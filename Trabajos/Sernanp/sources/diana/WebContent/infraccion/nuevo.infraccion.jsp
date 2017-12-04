<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  
<style type="text/css">
.reincidencia{

	margin-top:30px;
	display: none;
	font-weight:bold
}
.campo{
	float: left;
	margin-right: 30px;
}
.limpiador{
	clear: both;
}

</style>
		<script type="text/javascript">
		function actualizaSexo(){
			var sexo = $('#Sexo').val();
			 $('#flagSexo').val(sexo);
		}
		
		function actualizaEstado(){
			var estado = $('#EstadoCivil').val();
			 $('#flagEstadoCivil').val(estado);
		}
		
		
		
			$('document').ready(function(){
				var codigo=0;
				 $('#numerodocumento').val("");
				
				codigo=$("#codigoGenerado").val();
				$("#numeroInfraccion").val(codigo);	
				
				 $('#flagEstadoCivil').val('');
				 $('#flagSexo').val('');
				
				
				//cambiar valor imput ESTADO CIVIL al dar click en checkbox
				
// 				$("#estadoCivilSoltero").live('click',function(){
// 				 	var checkeado=$("#estadoCivilSoltero").attr('checked');
// 				 	if(checkeado){ 				
// 				 		 $('#flagEstadoCivil').html("<input type='hidden' name='infraccion.infractor.personanatural.estadocivil.idtipo' value='5' />");
// 				 	}		 	 			 	
// 				});
				
// 				$("#estadoCivilCasado").live('click',function(){
// 				 	var checkeado=$("#estadoCivilCasado").attr('checked');
// 				 	if(checkeado){ 				
// 				 		 $('#flagEstadoCivil').html("<input  id='tttt' type='hidden' name='infraccion.infractor.personanatural.estadocivil.idtipo' value='6' />");
				 	
				 		 
// 				 	}		 	 			 	
// 				});
				
				
				
				
				
				
				//cambiar valor imput SEXO al dar click en checkbox

// 				$("#sexoM").live('click',function(){
// 				 	var checkeado=$("#sexoM").attr('checked');
// 				 	if(checkeado){ 				
// 				 		 $('#flagSexo').html("<input type='hidden' name='infraccion.infractor.personanatural.sexo.idtipo' value='3' />");
				 		
// 				 	}		 	 			 	
// 				});
				
// 				$("#sexoF").live('click',function(){
// 				 	var checkeado=$("#sexoF").attr('checked');
// 				 	if(checkeado){ 				
// 				 		 $('#flagSexo').html("<input type='hidden' name='infraccion.infractor.personanatural.sexo.idtipo' value='4' />");
				 		
// 				 	}		 	 			 	
// 				});
				
				//cambiar valor de Estado TIpo
				$("#cboEstadoMulta").live('click',function(){
				 	var checkeado=$("#cboEstadoMulta").attr('checked');
				 	if(checkeado){ 				
				 		 $('#flagEstadoMulta').html("<input id='cccc' type='hidden' name='infraccion.estadomulta' value='"+1+"' />");
				 		 
				 	}
				 	else
				 		$('#flagEstadoMulta').html("<input id='cccc' type='hidden' name='infraccion.estadomulta' value='"+0+"' />");
				
				 	alert( $('#cccc').val());
				});
				
				//cambiar valor de Tipo de Documento
				
				$("#DNI").live('click',function(){
				 	var checkeado=$("#DNI").attr('checked');
				 	if(checkeado){ 				
				 		 $('#flagTipoDoc').html("<input type='hidden' name='infraccion.infractor.personanatural.tipodocumento.idtipo' value='"+1+"' />");
				 		 $('#numerodocumento').val("");
				 		 $('#numerodocumento').attr("size","8");
				 		 $('#numerodocumento').attr("maxlength","8");
				 	}		 	 			 	
				});
				
				$("#CE").live('click',function(){
				 	var checkeado=$("#CE").attr('checked');
				 	if(checkeado){ 				
				 		 $('#flagTipoDoc').html("<input type='hidden' name='infraccion.infractor.personanatural.tipodocumento.idtipo' value='"+2+"' />");
				 		 $('#numerodocumento').val("");
				 		 $('#numerodocumento').attr("size","15");
				 		 $('#numerodocumento').attr("maxlength","15");
				 	}		 	 			 	
				});
			
				
				
				//$('#formularioInfraccion').attr('action','ingresarInfraccion');
				
			});
		</script>

<h1>Nueva Infracción</h1>
<s:form id="formularioInfraccion" enctype="multipart/form-data">
	
	
	<div class="campo">
	<input type="hidden" name=infraccion.infractor.idinfractor id="idInfractor" value='0' />
		<label>Expediente N° </label>
		<input type="text" id="codigoGenerado" value='<s:property value="%{codigoGenerado}" />' class="onlydigits" size="20" readonly="readonly"/> - 
		<input type="text" name="anio" class="onlydigits" size="4" value="2011" readonly="readonly" />
		<input type="hidden" name="infraccion.numeroinfraccion" id="numeroInfraccion" value="0"/>
	</div>
	<div class="campo" style="margin-left: 50px;">
		<label>Fecha de Infracci&oacute;n</label>
		<input name="infraccion.fecha"  type="text" id="fechaInfraccion__" size="9" class="dateDMY input valid datepicker" readonly="readonly" title="Fecha1" />
	</div>
	<div class="limpiador" ></div>	
	
	
	<div class="campo">
		<label>Tipo de Documento</label>
		<input class="bool select" type="radio" name="cboTipoDoc" id="DNI" value="1" checked="checked"/>DNI 
		<input class="bool select" type="radio" name="cboTipoDoc" id="CE" value="2"/>CE
		<div id="flagTipoDoc"><input type='hidden' name='infraccion.infractor.personanatural.tipodocumento.idtipo' value='1' /></div>
	</div>
	<div class="campo">
	<label>Numero de Documento</label>	
		<input type="text" name="infraccion.infractor.personanatural.numerodocumento" id="numerodocumento" class="doc valid onlydigits" size="8" maxlength="8" onblur="javascript:verificaReincidencia(event);"/> 
<!-- 		<input type="button" id="verificaR" value="Verificar Reincidencia" onclick="" /> -->	
	</div>	
	<div>
<!-- 		<label>Es reincidente</label> -->
<!-- 		<input type="radio" name="reincidente"  id="reincidente" value="1" align="left" disabled="disabled" />SI  <input id="reincidente" type="radio" name="reincidente" value="2" align="right" disabled="disabled" checked="checked"/>NO -->
		<div id="SiReincidente" class="campo v_label reincidencia" >REINCIDENTE</div>
		<div id="NoReincidente" class="campo v_label reincidencia" style="color: #04B431">NO REINCIDENTE, INGRESE SUS DATOS</div>
<!-- 		<div id="flagReincidente"><input type="hidden" id=Reincidencia name="infraccion.reincidente" value='0'/></div> -->
	</div>
	<div class="limpiador" ></div>	
	
	
	<div id="divDatosPersona" style="display: none;">
	<div class="campo">
		<label>Apellido Paterno</label>
		<input type="text" name="infraccion.infractor.personanatural.apepat" id="apePat" size="35"/>
		
	</div>
	
	<div class="campo">
		<label>Apellido Materno</label>
		<input type="text" name="infraccion.infractor.personanatural.apemat" id="apeMat" size="35" />
		
	</div>
	<div class="limpiador" ></div>	
	
	
	
	<div class="campo">
		<label>Nombres</label>
		<input type="text" name="infraccion.infractor.personanatural.nombre" id="nombre" size="35" />
		
	</div>
	<div class="campo">
		<label>Sexo </label>
		
		<select id="Sexo" class="select valid"  onchange="javascript:actualizaSexo();">
			<option value=''>--Seleccione--</option>
			<option value='3'>Masculino</option>
			<option value='4'>Femenino</option>
		</select>
		<input id="flagSexo" type="hidden" name="infraccion.infractor.personanatural.sexo.idtipo" value='a'/>
	</div>
	<div class="campo">
		<label>Estado Civil </label>
		<select id="EstadoCivil" class="select valid" onchange="javascript:actualizaEstado();">
			<option value=''>--Seleccione--</option>
			<option value='5'>Soltero</option>
			<option value='6'>Casado</option>
		</select>
		<input id="flagEstadoCivil" type="hidden" name='infraccion.infractor.personanatural.estadocivil.idtipo' value='a'/>
	</div>
	
<!-- 	<div class="campo"> -->
<!-- 		<label>Sexo </label> -->
<!-- 		<input type="radio" name="sexo" id="sexoM" value="3" checked="checked"/>M  -->
<!-- 		<input type="radio" name="sexo" id="sexoF" value="4"/>F -->
<!-- 		<div id="flagSexo"><input type="hidden" name="infraccion.infractor.personanatural.sexo.idtipo" value='3'/></div> -->
<!-- 	</div> -->
<!-- 	<div class="campo"> -->
<!-- 		<label>Estado civil </label>  -->
<!-- 		<input type="radio" name="estadoCivil" id="estadoCivilSoltero" value="5" checked="checked"/>Soltero  -->
<!-- 		<input type="radio" name="estadoCivil" id="estadoCivilCasado" value="6"/>Casado  -->
<!-- 		<div id="flagEstadoCivil"><input type="hidden" name="infraccion.infractor.personanatural.estadocivil.idtipo" value='5'/></div> -->
<!-- 	</div> -->
	<div class="limpiador" ></div>	
	</div>
<!-- 	FIN PERSONA -->
	
	
	
	<div class="campo">
		<label>Descripci&oacute;n de la Infracci&oacute;n</label>
		<textarea rows="8" cols="80" name="infraccion.descripcion" id="descripcion" class="content valid"></textarea>
	</div>
	<div class="limpiador" ></div>	
	
	
	<div class="campo">
		<label>N° de Resoluci&oacute;n</label>
		<input type="text" name="infraccion.resolucion.numeroresolucion" size="20"  maxlength="12" class="content valid"/>
	</div>
	<div class="campo">
		<label>Fecha de Resoluci&oacute;n</label>
		<input name="infraccion.resolucion.fecha"  type="text"  id="fechaResolucion__" size="9" class="dateDMY input valid datepicker" readonly="readonly" title="Fecha2" />
	</div>
	<div class="campo">
		<label>Adjuntar Resoluci&oacute;n</label><input type="file" name="file" id="archivoAdjunto"  size="15"/>
	</div>
	<div class="limpiador" ></div>	
	
	
	
	<div class="campo">
		<label>Sanci&oacute;n realizada</label>
		<textarea rows="8" cols="80" name="infraccion.sancioninfraccion" class="content valid"></textarea>
	</div>
	<div class="limpiador" ></div>	
	
	
	
	<div class="campo">
		<label>Multa S/.
		<input type="text" name="infraccion.multainfraccion"  size="8" maxlength="12" class="decimal valid"/>
		</label>
	</div>
	
	<div class="campo">
		<label>Cumpl&iacute;o con la multa
		<input type="checkbox" id="cboEstadoMulta"/>
		</label><div id="flagEstadoMulta"></div>	
	</div>
	<div class="limpiador" ></div>	
	
	
	<div>
	<p>
		<input type="button" value="Agregar Infracci&oacute;n" class="submit" onclick="javascript:validaFormulario();"/>

		<input type="button" value="Cancelar" class="submit" />
	</p>
	</div>
</s:form>

<div id="divDetalleInfractor">


</div>

<script type="text/javascript">
<!-- 
function validaFormulario() { 
// 	formulario=$('#formularioInfraccion');
// 	Valid.init(formulario.find(".valid"));   
// 	alert("aun !");
	Valid.init( $("#formularioInfraccion .valid")  );  
	if(Valid.test()){ 	
		alert("Se enviara el formulario !");
		$('#formularioInfraccion').attr('action','ingresarInfraccion');
		$('#formularioInfraccion').submit();
	}
}


	
	datepickerOptions.defaultDate ="-1Y"; 
	datepickerOptions.maxDate=null;
	datepickerOptions.changeYear = false;
	datepickerOptions.changeMonth = false;
	$(".onlydigits").onlyDigits(); 
	$("input.datepicker").datepicker(datepickerOptions);
	
//-->
</script>