<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- <script type="text/javascript" src="js/personal.js"></script> --%>

<div style="width:auto;margin: 0 auto;">	
	<s:form id="formRegistroMarcaciones" method="post" theme="simple">
<%-- 		<s:hidden name="personanatural.idpersonal" /> --%>
		<s:hidden name="personalMarcacion.personal.idpersonal" />
		<fieldset>
			<legend><strong>Trabajador:</strong></legend>
				<s:text name="personanatural.apepat" />&nbsp;
				<s:text name="personanatural.apemat" />,&nbsp;
				<s:text name="personanatural.nombre" />		
		</fieldset> 
		<fieldset>
			<legend><strong>Motivo de marcaci&oacute;n:</strong></legend>
				<div class="l lb_1">
					<label>Actividad:</label>
				</div>
				<div class="l lb_1">
					<label>Justificación:</label>
				</div>
				<div class="clear"></div>
				<div class="l">
					<s:select listKey="srl_id_per_activ" 
	 					listValue="var_des_per_activ"
						name="personalMarcacion.personalActividad.srl_id_per_activ"
						theme="simple"
						headerKey="" headerValue=""
						list="listaMotivoMarcacion"
						cssClass="content_ valid"
						onchange="MotivoMarcacion(this.value)"						
					/>	       			
				</div>
				<div class="l"><s:textarea  id="justificacion_marcacion" name="personalMarcacion.var_descripcion" 
					 cols="65" rows="3" cssClass="content valid" readonly ="true"></s:textarea>
				</div>
		</fieldset>


		<fieldset>
			<legend><strong>Fecha y hora:</strong></legend>
			<div>
				<div class="l lb_5"><label>F. Inicio:</label></div>
				<div class="l "><s:textfield id="fechamarcacion" name="personalMarcacion.dte_fec_marc" 
					 theme="simple" size="12" cssClass="dateDMY_ input valid" readonly="true" /></div>
					 
				<div class="l lb_1"><label>H. Inicio / Ingreso:</label></div>
				<div class="l "><s:textfield id="horaingreso" name="personalMarcacion.hor_hor_marc" 
					 theme="simple" size="10" cssClass="hour_i valid datetimepicker" readonly="true" /></div> 
					 
				<div class="clear"></div>
			
				<div class="l lb_5"><label>F. F&iacute;n:</label></div>
				<div class="l "><s:textfield id="fechamarcacion2" name="personalMarcacion.dte_fec_marc1" 
					 theme="simple" size="12" readonly="true" /></div>
					  
				<div class="l lb_1"><label>H. F&iacute;n / Salida:</label></div>
				<div class="l "><s:textfield id="horasalida" name="personalMarcacion.hor_hor_marc1" 
					 theme="simple" size="10" readonly="true" /></div>
			</div>

		</fieldset>

		<div>
			<fieldset>
				<div align="center">
					<input type="button" value="Ver Marcaciones" class="submit3" id="btnVolveraMarcaciones" title ="Mostrar marcaciones"/>			
					<input type="button" value="Guardar" class="submit3" id="btnInsertaMarcacionManual" title ="Guardar marcaci&oacute;n"/>
				</div>				
			</fieldset>
		</div>			
	</s:form>
</div>