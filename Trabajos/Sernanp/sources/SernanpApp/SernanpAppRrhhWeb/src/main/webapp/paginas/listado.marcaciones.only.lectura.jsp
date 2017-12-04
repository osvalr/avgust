<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


<div align="left" >
	<label>Fecha:</label>
	<s:textfield name="dte_fec_marc" id ="dte_fec_marc" theme="simple" size="10" readonly="true" value="%{#request.dte_fec_marc}"/>
</div>

<div>																								
	<label>Apellidos y Nombres:</label>

	<s:text name="personanatural.apepat" />&nbsp;
	<s:text name="personanatural.apemat" />,&nbsp;
	<s:text name="personanatural.nombre" />
</div>

<s:hidden id="cantMarcacion" value="%{#request.cantMarcacion}"/>

<s:if test="%{#request.cantMarcacion > 0 }">

	<div id="divListaMarcaciones">
	
		<fieldset style="float:center;">
			<display:table uid="row" id="row" name="listamarcacionesxtrabajador" pagesize="10" requestURI="filtromarcaciones.action" excludedParams="*" class="hor-minimalist-a" >
				<display:column title="#" style="width:10px;">
					<s:checkbox theme="simple"  name="srl_id_personal_marcacion"  fieldValue="%{#attr.row.srl_id_personal_marcacion}" />
				</display:column>			
				<display:column title="N&deg;" style="width:25px;"> <c:out value="${row_rowNum}"/></display:column>
				<display:column title ="F. Marcación"  property ="dte_fec_marc" format="{0,date,dd/MM/yyyy}" style="width: 110px;"></display:column>
				<display:column title="H. Marcaci&oacute;n" property="hor_hor_marc"  style="width:110px;" />
				<display:column title="Tipo Marcaci&oacute;n" property="tipomarcacion.destipo" style="width:110px;" />
				<display:column title="Actividad" property="personalActividad.var_des_per_activ"  style="width:170px;" />
			</display:table>						
		</fieldset>		
		<s:hidden name="dtpage" id="dtpage" />	
	</div>
	<div id="msgSinMarcaciones">
		<s:actionmessage id="msgMarcaciones" cssClass="alertamsg" cssStyle="display: block;" />
	</div>
</s:if>
<s:else>
	<div id="msgSinMarcaciones">
		<s:actionmessage id="msgMarcaciones" cssClass="alertamsg" cssStyle="display: block;" />
	</div>
</s:else>

