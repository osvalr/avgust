<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!-- <div align="left" > -->
<!-- 	<label>Periodo:</label> -->
<%-- 	<s:textfield id ="periodoVacaciones"  readonly="true" value="%{#request.periodoVacaciones}" size="8" /> --%>
<%-- 	<s:hidden id="idPersonalVacaciones" name="personanatural.idpersonal"/> --%>
<!-- </div> -->
<br/>
<div>																								
	<label>Apellidos y Nombres:</label>
	<span class="semi-bold">
		<s:text name="personanatural.apepat" />&nbsp;
		<s:text name="personanatural.apemat" />,&nbsp;
		<s:text name="personanatural.nombre" />
	</span>
</div>

<div id="divListaVacaciones" style="height: auto; overflow-y: scroll;">
	<span class="semi-bold">Lista de Vacaciones pendientes: </span>	
		<display:table uid="row" id="row" name="listapersonalVacaciones" requestURI="vacacionesPendientesxidPersonal.action" excludedParams="*" class="hor-minimalist-a" >
			<display:column title="N&deg;" > <c:out value="${row_rowNum}"/></display:column>
			<display:column title ="Periodo"  property ="int_periodo_vac" ></display:column>
			<display:column title="Fecha programación" property="dte_fec_inicio_programacion_vac" format ="{0,date,dd/MM/yyyy}" />
			<display:column title="Corresponde"  property="int_dias_vac_corresponde" />	
			<display:column title="Pendientes"  property="int_dias_vac_pendientes" />
			<display:column title="Programados"  property="int_dias_vac_goce" />
			<display:column title="Estado">
				<s:if test="#attr.row.int_est_vacaciones == 0"><s:text name="<span style='width:40px; text-align:center; color:green;'>Utilizada</span>" /></s:if>
				<s:elseif test="#attr.row.int_est_vacaciones > 0">
					<s:if test="#attr.row.int_dias_vac_goce > 0"><s:text name="<span style='width:40px; text-align:center; color:red;'>Programada</span>" /></s:if>
					<s:else><s:text name="<span style='width:40px; text-align:center; color:blue;'>Pendiente</span>" /></s:else>
				</s:elseif>
				
			</display:column>					
			
			
						
		</display:table>						
</div>
			
