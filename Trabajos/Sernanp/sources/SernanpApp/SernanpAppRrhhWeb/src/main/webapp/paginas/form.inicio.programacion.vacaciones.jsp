<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div align="left" >
	<label>Periodo:</label>
	<s:textfield id ="periodoVacaciones"  readonly="true" value="%{#request.periodoVacaciones}" size="8" />
	<s:hidden id="idPersonalVacaciones" name="personanatural.idpersonal"/>
</div>

<div>																								
	<label>Apellidos y Nombres:</label>
	<s:text name="personanatural.apepat" />&nbsp;
	<s:text name="personanatural.apemat" />,&nbsp;
	<s:text name="personanatural.nombre" />
</div>

<s:form name="formUpdateFIPVacaciones" id="formUpdateFIPVacaciones" method="post" theme="simple">
	<s:hidden name="personalVacaciones.srl_id_pers_vac" />	
	<fieldset>
		<legend><strong>Registrar / actualizar :</strong></legend>						
			<div class="l lb_e"><label>Fecha Incio:</label></div>
			<div class="l lb_e">
				<s:textfield id="f_inicioProgVac" name="personalVacaciones.dte_fec_inicio_programacion_vac" value="%{#request.fechaFinVacacUtilizadas}" 
					 theme="simple" size="15"  readonly="true" cssStyle="text-align:center;"/>	
			</div>	
	</fieldset>					
	
	<div>
		<div align="center">
			<input type="button" value="Guardar" class="submit3" id="btnUpdateFIPVacaciones" title ="Guardar fecha inicio Vacaciones"/>	
		</div>				
	</div>
</s:form>					
		<div>
			<s:actionmessage cssClass="alertamsg" cssStyle="display: block;" />
		</div>
<s:hidden name="dtpage" id="dtpage" />	