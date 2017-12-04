<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- <script type="text/javascript" src="js/personal.js"></script> --%>

<div style="width:auto;margin: 0 auto;">	
	<s:form id="formRegistroMarcaciones" method="post" theme="simple">
		<s:hidden id ="cantMarcacion" value="%{#request.cantMarcacion}"/>
		<s:hidden id ="idPersonalrm" name="personalMarcacion.personal.idpersonal" />
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
				
				<s:if test="%{#request.cantMarcacion > 0 }">
					<div class="l"><s:textarea  name="personalMarcacion.var_descripcion" cols="65" rows="3" readonly ="true"></s:textarea></div>
				</s:if>
				
				<s:else>
					<div class="l"><s:textarea  id="justificacion_marcacion" name="personalMarcacion.var_descripcion" 
						 cols="65" rows="3" cssClass="content valid" readonly ="true"></s:textarea>
					</div>
				</s:else>
				
		</fieldset>

<%-- 		<s:textfield value="%{#request.cantMarcacion}"/> --%>
<%-- 		<s:textfield value="%{#request.regHI}"/> --%>
<%-- 		<s:textfield value="%{#request.regHS}"/> --%>
		<fieldset>
			<legend><strong>Fecha y hora:</strong></legend>
			<div>
				<div class="l "><label>F. Marcaci&oacute;n:</label></div>
				<div class="l lb_5"><s:textfield id="fechamarcacion"name="personalMarcacion.dte_fec_marc" theme="simple" size="12"  readonly="true" /></div>		
			</div>
			<div class="clear"></div>
			<s:if test="%{#request.cantMarcacion > 0 }">
			
				<fieldset class="myFieldSet">
					<legend><strong>Marcaciones existentes:</strong></legend>
					<div>
						<div class="l lb_e"><label>Primera:</label></div>
						<div class="l lb_e"><s:textfield name="personalMarcacion.hor_hor_marc" theme="simple" size="10"  readonly="true" />	</div>				
						
						<s:if test="%{#request.cantMarcacion >= 2}">
							<div class="l lb_e"><label>&Uacute;ltima:</label></div>
							<div class="l lb_e"><s:textfield  name="personalMarcacion.hor_hor_marc1"	 theme="simple" size="10" readonly="true" /></div>		 
						</s:if>		
					
					</div>				
				</fieldset>	
				
				<fieldset class="myFieldSet">
					<legend><strong>Marcaci&oacute;n Manual:</strong></legend>
					<div>					
						<s:if test="%{#request.regHI > 0 }">
							<div class="l lb_e"><label>H. Ingreso:</label></div>
							<div class="l lb_e"><s:textfield id="horaingreso" name="personalMarcacion.hor_hor_marc" 
								 theme="simple" size="10" cssClass="hour_i valid datetimepicker" readonly="true" />
							</div>		 
						</s:if>
						
						
						<s:if test="%{#request.regHS > 0 }">
							<div class="l lb_e"><label>H. Salida:</label></div>
							<div class="l lb_e"><s:textfield id="horasalida" name="personalMarcacion.hor_hor_marc1" 
								 theme="simple" size="10" readonly="true" />
							</div>
						</s:if>
							 
					</div>	
				</fieldset>	
			
			</s:if>		
			
			
			
		
			

			
			
			
			
			
<!-- 			<div> -->
<!-- 				<div class="l "><label>F. Marcaci&oacute;n:</label></div> -->
<%-- 				<div class="l lb_5"><s:textfield id="fechamarcacion"name="personalMarcacion.dte_fec_marc" theme="simple" size="12"  readonly="true" /></div>		 --%>
<!-- 				<div class="l "><label>H. Ingreso:</label></div> -->
<%-- 				<s:if test="%{#request.cantMarcacion > 0 }"> --%>
<%-- 					<div class="l lb_5"><s:textfield name="personalMarcacion.hor_hor_marc" theme="simple" size="10"  readonly="true" />	</div>				 --%>
<%-- 				</s:if> --%>
<%-- 				<s:else> --%>
<%-- 					<div class="l lb_5"><s:textfield id="horaingreso" name="personalMarcacion.hor_hor_marc"  --%>
<%-- 						 theme="simple" size="10" cssClass="hour_i valid datetimepicker" readonly="true" /> --%>
<!-- 					</div>		  -->
<%-- 				</s:else> --%>
				
<!-- 				<div class="l "><label>H. Salida:</label></div> -->
<%-- 				<s:if test="%{#request.cantMarcacion >= 2 }"> --%>
<%-- 					<div class="l lb_5"><s:textfield name="personalMarcacion.hor_hor_marc1" theme="simple" size="10" readonly="true" />	</div>				 --%>
<%-- 				</s:if> --%>
<%-- 				<s:else> --%>
<%-- 					<div class="l lb_5"><s:textfield id="horasalida" name="personalMarcacion.hor_hor_marc1"  --%>
<%-- 						 theme="simple" size="10" readonly="true" /> --%>
<!-- 					</div> -->
<%-- 				</s:else> --%>
				
<!-- 			</div> -->

		</fieldset>

		<div>
			<fieldset>
				<div align="center">
					<input type="button" value="Ver Marcaciones" class="submit3" id="btnVolveraMarcacionesRM" title ="Mostrar marcaciones"/>			
					<input type="button" value="Guardar" class="submit3" id="btnInsertaMarcacionManual" title ="Guardar marcaci&oacute;n"/>
				</div>				
			</fieldset>
		</div>			
	</s:form>
</div>
<div id="dialog-info-rmm" hidden="true">  
	<p>Hora salida esta vac&iacute;a.</p>
	<p>¿Desea agregar una hora?</p>
</div>