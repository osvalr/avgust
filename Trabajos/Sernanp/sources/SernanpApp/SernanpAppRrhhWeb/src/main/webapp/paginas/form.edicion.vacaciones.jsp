<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="modal-body">

<div class="row form-row">
	<div class="col-lg-3 col-md-3 col-sm-3">
		<label class="form-label">Periodo:</label>
		<s:textfield id ="periodoVacacionesE"  readonly="true" value="%{periodoVacaciones}" cssClass="form-control" />
		<s:hidden id="idPersonalVacacionesE" name="personanatural.idpersonal"/>
	</div>
</div>
 

<div>																								
	<label>Apellidos y Nombres:</label>
	<s:text name="personanatural.apepat" />&nbsp; 
	<s:text name="personanatural.apemat" />,&nbsp;
	<s:text name="personanatural.nombre" />
</div>
<s:hidden name="dtpage" id="dtpage" />
<div id="divVacacionesE">
	<s:form name="formEdicionVacaciones" id="formEdicionVacaciones" method="post" theme="simple">
		<s:hidden name="personalVacacionesGoce.srl_id_pers_goce_vac" />
		<s:hidden name="idVacaciones" value="%{idVacaciones}"/>
		<s:hidden id ="idPersonal" name="idPersonal" value="%{#request.idPersonal}"/>
		<s:hidden id="f_inicioVacELimitar"  value="%{#request.f_inicioVacLimitar}" />
		<fieldset>
			<legend><strong>Datos del descanso f&iacute;sico - Vacaciones:</strong></legend>					
			<div class="l lb_e"><label>F. Inicio:</label></div>
			<div class="l lb_e">
				<s:textfield id="f_inicioVacE" name="personalVacacionesGoce.dte_fec_inicio_goc_vac" value="%{#request.f_inicioVac}" 
					 theme="simple" size="15"  readonly="true" cssStyle="text-align:center;"/>
			</div>		 

			<div class="l lb_e"><label>F. F&iacute;n:</label></div>
			<div class="l lb_e">
				<s:textfield id="f_finVacE" name="personalVacacionesGoce.dte_fec_fin_goc_vac" value="%{#request.f_finVac}"
				 theme="simple" size="15"  readonly="true" cssStyle="text-align:center;" />
			</div>
			
			<div class="l lb_e"><label>D&iacute;as Programados:</label></div>
			<div class="l lb_e"><s:textfield id="cantDiasVacE" name="personalVacacionesGoce.int_dias_goce_vac"   
				 theme="simple" size="2"  readonly="false"  cssStyle="text-align:center;" cssClass="number onlyDigits"
				 onkeyup="javascrip:cambiarFechafinProgVac('E');"/>
			</div>										 
			<div class="l lb_e"><label>D&iacute;as Pendientes:</label></div>
			<div class="l lb_e"><s:textfield id="cantDiasVacPendientesE" value="%{personalVacacionesGoce.personalVacaciones.int_dias_vac_pendientes}"
				 theme="simple" size="2"  readonly="true"  cssStyle="text-align:center;"/>
				 <%-- 			 personalVacacionesGoce.personalVacaciones.int_dias_vac_pendientes --%>
			</div>	
			<div class="clear"></div>
			<div class="l lb_1">
				<label>Justificación:</label>
			</div>
			<div class="clear"></div>
			<div class="l"><s:textarea  id="justificacion_edicion" name="personalVacacionesGoce.var_justificacion_post" 
				 cols="120" rows="2" cssClass="content valid"  readonly ="false"></s:textarea>
			</div>

		</fieldset>					
		<br/>
		<div>
			<fieldset>
				<div align="center">
					<input type="button" value="Guardar" class="btn btn-primary" id="btnUpdateVacaciones" title ="Actualiza Periodo Vacaciones"/>							
				</div>				
			</fieldset>
		</div>
	</s:form>
</div>

</div>