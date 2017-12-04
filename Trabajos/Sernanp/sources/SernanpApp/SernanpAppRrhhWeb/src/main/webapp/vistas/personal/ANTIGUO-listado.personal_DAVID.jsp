<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
  
<div style="margin:0 15px;">

<h1>Registro de Ingreso y Salida</h1></br>
	<span> 
		<s:form>
			<label>BUSCAR POR APELLIDO PATERNO</label>
			<input type='text' name='apellidoTrabajador' id='apellidoTrabajador' value=''	size="25" onkeypress="javascript:filtraApellidos();" />			
			<input type="button" onclick="javascript:FiltrarPersonalAsistenciaxfecha_motivo_apepat();this.form.reset();" value="Limpiar ">	
		</s:form>
		<hr>
	</span>	
	
	<span class="fltrCombo " >
		<s:select id ="estadoAsistencia" name="estadoAsistencia" list="#{'0':'Asistencias','1':'Inasistencias','2':'Regularizadas','3':'Observado'}" 
			headerKey="4" headerValue="[--- Todas---]"
			title="Mostrar Personal por motivo de incidencia"/>
			<%-- 			onchange="filtraxfechaymotivoAsistencia(this.value)"  --%>		
	</span>
	
	<span class = "fltrAsistdate">
		<s:textfield  id="fechamaAsistencia" name="dte_fec_asist"	theme="simple" size="12" readonly="true"	
		value="%{#request.dte_fec_asist}" title ="Mostrar Personal por fecha de asistencia"/>
	</span>

	<span class="fltrTxt" >
		<s:label value="Filtrar:"/>		
	</span>
	
	<div id="DivListadoPersonal">
	
		<display:table uid="row" id="row" name="listapersonal" pagesize="15" requestURI="listadoPersonalRrhh.action" excludedParams="*"	class="hor-minimalist-a">
		
			<display:column title="#" style="width:10px;">
				<s:checkbox theme="simple"  name="personal.idpersonal"  fieldValue="%{#attr.row.personal.idpersonal}" />
			</display:column>
			
			
			<display:column title="N&deg;" style="width:20px;"> <c:out value="${row_rowNum}"/></display:column>
			<display:column title="N&deg; Doc." property="personal.numerodocumento" style="width:40px;" />
			<display:column title="Apellidos y Nombres" style="width: 200px;" ><%-- sortable="true" --%>
				
				<s:if test="%{#attr.row.personal.apepat != null}">
					<s:text name="#attr.row.personal.apepat"></s:text>
				</s:if>
				<s:else>
					<s:text name="apepat">,</s:text>
				</s:else>
				
				<s:if test="%{#attr.row.personal.apemat != null}">
					<s:text name="#attr.row.personal.apemat"></s:text>,
				</s:if>
				<s:else>
					<s:text name="apemat">,</s:text>
				</s:else>
				
				<s:if test="%{#attr.row.personal.nombre != null}">
					<s:text name="#attr.row.personal.nombre"></s:text>
				</s:if>
				<s:else>
					<s:text name="nombre"></s:text>
				</s:else>						
			</display:column>				
			<display:column title="Oficina"  	style="width:100px;"></display:column>
			<display:column title="H. Ingreso" 	property="hor_hor_ingreso" style="width:40px;"></display:column>
			<display:column title="H. Salida"  	property="hor_hor_salida" style="width:40px;"></display:column>			
			<display:column title="Tardanza"  	property="minutostardanza" style="width:40px;"></display:column>
			
		<s:if test="%{#attr.row.estado == 1}">
			<display:column title="Estado" style="width:40px; text-align:left; color:red;">	
				<s:if test="%{#attr.row.estadoTmp == 1 }">
					 <s:text name="Inasistencia" ></s:text>
				</s:if>					
				<s:else>
					<s:text name="Observado"></s:text>
				</s:else>				
		  	</display:column>			
		</s:if>
		
		<s:elseif test="%{#attr.row.estado == 2}">
			<display:column title="Estado" style="width:40px; text-align:left; color:blue;">
				<s:text name="Permiso"></s:text>
		  	</display:column>	
		</s:elseif>
		
		<s:elseif test="%{#attr.row.estado == 0}">
			<display:column title="Estado" style="width:40px; ">
				<s:text name=""></s:text>
		  	</display:column>	
		</s:elseif>
		</display:table >
		

		<s:if test="%{#request.cantidadincidencias > 0 }">
			<s:label  value="%{#request.msgincidencias}" cssStyle="text-align:right; color:red; font-weight: bold; padding: 1px; font-size: 105%"/>	
		</s:if>
		<s:else >
			<s:label  value="%{#request.msgincidencias}" cssStyle="text-align:right; color:green; font-weight: bold; padding: 1px; font-size: 105%"/>	
		</s:else>
		<hr>
	</div>
	<s:hidden name ="dtpage" id="dtpage" />
	<s:hidden name = "idPersonalM" id ="idPersonalM" value=""/>
</div>

<br />
<div align="center">
	
	<input type="button" value="Importar Excel" class="submit2" id="btnImportarExcel" title ="Importar Personal desde Excel" />
	<input type="button" value="Marcaciones TEMPUS" class="submit2" id="btnimportarTxtRelog" title ="Importar marcaciones de reloj TEMPUS" />
	<input type="button"  value="Mostrar marcaciones" class="submit2" id="btnverMarcaciones" title ="Mostrar marcaciones del personal elegido" />	
<!-- 	<input type="button" value="Registrar Papeleta" class="submit2" id="btnRegistroPapeleta" title ="Registrar Papeleta"/> -->

</div>

<div id="divModalContenedor"></div>
<div id="divModalMarcaciones"></div>
<div id="divModalPapeletas"></div>
<div id="divModalImportarArchivo" ></div>

<div id="dialog-info" hidden="true">  </br><p><strong>Debe seleccionar un Trabajador!</strong></p></div>

<div id="dialog-info-m" hidden="true"> </br> <p><strong>Debe seleccionar una Marcaci&oacute;n!</strong></p></div>
<!-- <div id="dialog-info-nm" hidden="true"><p>Cuando el trabajador tiene marcaci&oacute;n de ingreso y salida seg&uacute;n su horario oficial, no podr&aacute; agregarle marcaci&oacute;n</div> -->
<div id="dialog-info-nm" hidden="true"><p>La primera y &uacute;ltima marcaci&oacute;n del trabajador seleccionado, cumple con su horario oficial, no puede agregar otra marcaci&oacute;n.</div>
<div id="dialog-info-nmp" hidden="true"><p>Cuando el trabajador tiene  Permiso, no puede agregar marcaci&oacute;n / Permiso.</div>

<div id="dialog-info-rm" hidden="true">  <p>No ha ingresado Fecha y Hora de Retorno.</p><p>¿Desea agregar una Fecha y Hora?</p></div>

<div id="dialog-form">   <p>¿Realmente desea eliminar?</p> </div>

<div id="dialog-form-wait"></div>

