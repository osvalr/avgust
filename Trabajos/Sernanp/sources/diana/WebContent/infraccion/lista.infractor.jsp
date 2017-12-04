<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.naviInfracciones {  
	list-style:none;
	height:100%;
	width:100%;
	margin:0;
	padding:0;
	}
.naviInfracciones li {
/* 	margin:2px; */
/* 	padding:2px; */
	width:100%;
	height:100%;
	border-bottom:1px solid #CCCCCC;
	}

.naviInfracciones li {
	border-bottom:1px solid #CCCCCC;
	float:left;
	
	}
.DivDerecha{
	display: block;
	width: 20px;
/* 	border-left: 1px solid #CCCCCC; */
	border: 1px solid blue;
	height: 100%;
/* 	margin-left: 400px; */
	
}
.DivIzquierda{
	border: 1px solid red;
	display: block;
	width: 397px;
	
}
</style>
</head>
<body>

<div id="dialogoFormulario" title="Atención" style="display:none;">
	<div id="ContenedorMensaje">
		<!-- <p> -->
		 <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
		 ¿Realmente desea cambiar el estado de Morosidad?
		<!--  </p> -->
	</div>
</div>

<!-- JCEV 19-10-2012 -->
<div id="dialogoPagoFormulario" title="Atención" style="display:none;">
<form id="formConfirmaPago" enctype="multipart/form-data" method="post" >
	<div id="ContenedorMensaje">
		 <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
		 <label>¿Ya realiz&oacute; el Pago?</label>		 
	</div>
	<br />
	<div>
	<fieldset>
	<legend>Adjuntar Voucher de Pago</legend>	
	<input type="file" name="file" id="archivoAdjunto" size="40" maxlength="70" />	
	</fieldset>				
	</div>
	
</form>
</div>

<div id="dialogFormWrite" title="Atención" style="display:none;"></div>

<!-- JCEV 21-10-2012 -->
<div id="dialogoEstadoFormulario" title="Estado del Expediente" style="display:none;">
	<form id="formContentEstado">	
		<div id="ContenedorEstadoExpedienteMensaje">
			 <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
			 ¿Desea Cambiar el Estado del Expediente?
		</div>
		<div class="clear"></div>
		<div id="inputDialogEstadoExpediente">
<!--			<input type="hidden" id="paramIdExpediente" name="expediente.idexpediente" >
 			<br> -->
	
			<!-- JCEV 18-10-2012 Estado : Activo (0) / Inactivo (1) / Eliminado (2) -->
			<div>			
			<input type="radio" name="expediente.estadoexpediente" value="0" checked="checked" />Activo
			<br />
			<input type="radio" name="expediente.estadoexpediente" value="1" />Inactivo
			<br />
			<input type="radio" name="expediente.estadoexpediente" value="2" />Eliminado
			</div>
			<br />
			<div>
			<!-- JCEV 18-10-2012 La Observación -->
			<label style="font-weight: bold;">Observaci&oacute;n:</label><br />
		    <s:textarea cols="50" rows="3" name="expediente.obsestadoexpediente" ></s:textarea>
		    </div>
		</div>
	</form>	
</div>


<h1>LISTADO DE INFRACCIONES</h1>
<form>
	<label>BUSCAR POR NUMERO DE DOCUMENTO</label>
	<input type="text"   id="paramCodInfractor" />
	<input type="button" id="btnConsultar" value="Buscar ">	
	<input type="button" onclick="javascript:actualizarInfractores(0);this.form.reset();" value="Limpiar ">
</form>


<!-- <form id="formOculto">
	<input type="hidden" />
</form>
<div style="float: right;">
<span class="button" id="btnNuevoInfractor" style="font:bold 9px Verdana;text-transform:uppercase;margin-left: 15px;"> 
			<span class="i i_add" style="vertical-align:middle;"></span> 
			<span>Agregar Nuevo</span> 
</span>
</div> -->

<script type="text/javascript">

//crear proyectos
$("#btnNuevoInfractor").click(
    		nuevoProyecto
);
    
    
function nuevoProyecto(){
	$("#formOculto").attr('action','nuevoInfractor.action');
	$("#formOculto").submit();
}
</script>


<div style="clear: both;"></div>
<hr>
<!-- NUEVA INFRACCION -->
<div class="buttons" style="display:inline-block;width:280px;text-align:right;">  
		
</div>

<form id="formularioOcultoEditar">
<input type="hidden" id="paramIdExpediente" name="paramIdExpediente" value ="-1" />
</form>

<div id="divMensajeMor" style="display:none;"></div>

<div id="DivRecargarInfractores" style="min-height: 100px; min-width: 500px;">

<jsp:include page="ajax.infractores.jsp" />

</div>

<script>

//METODO QUE ACTUALIZA EL DIV A ACTUALIZAR
/*
$().ready(function(){	
	actualizarInfractores(0);
});
*/
</script>

</body>
</html>