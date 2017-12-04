<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


<div align="left" >
	<label>Periodo:</label>
	<s:textfield theme="simple" size="10" readonly="true" value="%{#request.mesIP} / %{#request.periodoIP}"/>
</div>

<div>																								
	<label>Apellidos y Nombres:</label>

	<s:text name="personanatural.apepat" />&nbsp;
	<s:text name="personanatural.apemat" />,&nbsp;
	<s:text name="personanatural.nombre" />
</div>


	
		<s:if test="%{#request.Inasistencias > 0}">
		
<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableDefault">
	<thead>
		<tr>
			<th>N°</th>
			<th>Fecha</th>
			<th>Motivo</th>
		</tr>
	</thead>
	<tbody>
					<s:iterator value="listapersonalinasistencias" var="personal" status="personalStatus">
										
						<tr>
																
								<td><s:property value="%{#personalStatus.count}" /></td>
								<td>
								<s:date name="%{#personal.dte_fecha}" format="dd/MM/yyyy" />
<%-- 								<s:property value="#personal.dte_fecha" /> --%>
								</td>
								<td>
									<s:if test="%{#personal.estado == 1 && #personal.int_vac_lic == 0 }">
										<s:text name="Inasistencia"></s:text>
									</s:if>
									<s:elseif test="%{#personal.estado == 1 && #personal.int_vac_lic == 2 }">
										<s:text name="Licencia sin goce de haberes"></s:text>
									</s:elseif>
									<s:else>
										<s:text name="Permiso"></s:text>
									</s:else>
								</td> 
									
						</tr>
					</s:iterator>
					</tbody>
</table>
		

		</s:if>
		
		<s:else>
			<div id="msgSinMarcaciones">
				<s:actionmessage id="msgMarcaciones" cssClass="alertamsg" cssStyle="display: block;" />
			</div>
		</s:else>

	
	<s:hidden name="dtpage" id="dtpage" />	

