<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  
<h1>Agregar Visitantes</h1>
<form method="post" id="addvisitantes">
	<div> 
		<s:select name="idareanatural" 
			label="Area Natural" 
			headerValue="Seleccione.."
			headerKey="" 
			listKey="%{idareanatural+'|'+turismo.idturismo}" 
			listValue="desareanatural"  
			list="areasNaturales"  
			id="cbAreanatural" 
			  />  
	</div>
	<div>
		<label>Cantidad</label>
		<span><input type="text" name="size" class="onlydigits" size="6" /></span>
	</div>
	<div>  
	    <label for="cbRutaturismo" class="label">Sector Turistico:</label>
	    <span>
		    <select name="idrutaturismo" id="cbRutaturismo">  
		    	<option> Seleccione...</option>
			</select> 
		</span>
		 <a href="#" id="btnAddRutaTurismo" class="h addlink"  >
		 	(+) Agregar Ruta Turismo</a>
	</div>
	<div>
		<s:select name="idtipoturismo" 
			label="Tipo de Turismo" 
			listKey="idtipoturismo" 
			listValue="nombretipoturismo"
			headerValue="Seleccione.."
			headerKey="null" 
			list="tiposturismo" 
			id="cbTipoturismo"
			  />  
	</div>
	
	<div >
		<s:select list="paises" name="idpais"
			listKey="idpais"  
			listValue="nombrepais"  
			label="País" 
			value="171" 
		/>
	</div>
	<div class=" ">
		<label for="fecharegistro">Fecha de Registro.</label>
		<div class=""> 
			<input name="fecharegistro" id="fechanacimiento__" value=""  type="text"
				size="9" class="date valid input datepicker" readonly="readonly" title="Fecha" />
		</div>
	</div> 
	<div class=" ">
		<label>Tipo de Boleto</label>
		<select name="idboletaje" class="select valid cbBoleto">
			<option value="">Seleccione </option>
		</select>
	</div>
	<div>
		<input type="submit" value="Agregar Visitantes" class="submit" />
	</div>
</form>
<div id="windowAddRutaTurismo" class="h"> 
	<form id="formAddRutaTurismo">
		<div class="l" style="width:370px">
			<div class="inputs">
				<div>
					<s:textfield name="rutaturismo.nombrerutaturismo" 
						label="Nombre Sector" size="40" cssClass="content valid" /> 
				</div>
				<div>
					<s:textfield name="rutaturismo.detallerutaturismo" 
						label="Detalle" size="40" cssClass="content valid" />
					<input type="hidden" name="rutaturismo.idturismo" id="txtIdturismo" />
				</div>
			</div>
			<div id="tiposturismo" class="checkboxes">
				<h4>Seleccione tipos de Turismo</h4>
				<s:iterator value="tiposturismo" status="it">
				  <div>
						<input type="checkbox" 
							id="id_<s:property value="#it.index" />" 
							value="<s:property value="idtipoturismo" />"
							name="rutaturismo.tipoturismos[<s:property value="#it.index" />].idtipoturismo" 
							class="checkbox"
							/>	  
						<label for="id_<s:property value="#it.index" />">
							<s:property value="nombretipoturismo" />
						</label>
				  </div>
				</s:iterator>
					 
			</div>
		</div>
		<div class="right" style="width:400px">
			<div id="secBoletos" >
				<h4>Boletos <span><a href="#" id="btnAddBoletos" class="addlink">(+) Agregar</a></span></h4>
				<div id="secBoletoRow" class="secBoletoRow">
					<span class="i i_remove"></span>
					<div>
						<label>Nombre: </label> 
						<input name="rutaturismo.boletajes[0].nombreboletaje" class="content valid" size="40" /><br /> 
						</div>
					<div>
						<label>Observación: </label>
						<input name="rutaturismo.boletajes[0].obsboletaje" class="content valid" size="40" /><br />
					</div>
					<div>
						<span>
						<label>Valor:</label> 
						<input name="rutaturismo.boletajes[0].valorboletaje" class="content valid" size="5" class="onlyDigits" />
						</span>
						<span>
							<label>Serie:</label>
							<input name="rutaturismo.boletajes[0].serieboletaje" class="content valid" size="5" /> 
						</span>  
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
<!-- 
	
	datepickerOptions.defaultDate ="-1Y"; 
	datepickerOptions.maxDate=null;
	datepickerOptions.changeYear = false;
	datepickerOptions.changeMonth = false;
	$(".onlydigits").onlyDigits(); 
	$("input.datepicker").datepicker(datepickerOptions);
	
//-->
</script>
<!-- 
		size = 184;
		visitante.setIdpais( 200 );
		fichaturismo.setIdrutaturismo(1);
		fichaturismo.setIdtipoturismo(1);
		fichaturismo.setFecharegistro("2010-01-01");
		visitante.setIdboletaje(1);
		insertVisitantesTest();
 -->