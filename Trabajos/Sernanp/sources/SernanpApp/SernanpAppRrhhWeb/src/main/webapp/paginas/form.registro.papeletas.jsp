<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- <script type="text/javascript" src="js/personal.js"></script> --%>

<div style="width:auto;margin: 0 auto;">	
	<s:form id="formRegistroPapeletas" method="post" theme="simple">
		<s:hidden name="personalPapeleta.personal.idpersonal" />
		<s:hidden id="motivo_Papeleta" value=""/>
		<fieldset>
			<legend><strong>Trabajador:</strong></legend>
				<s:text name="personanatural.apepat" />&nbsp;
				<s:text name="personanatural.apemat" />,&nbsp;
				<s:text name="personanatural.nombre" />		
		</fieldset> 
		<fieldset>
			<legend><strong>Descripci&oacute;n de papeleta:</strong></legend>
				
				<div class="l lb_e"><label>Motivo:</label></div>
				<div class="l "><label>Actividad:</label></div>
				<div class="clear"></div>				
				<div class="l lb_e ">					
					<s:select id ="tipoPapeleta" name="tipoPapeleta" 
						list="#{'0':'COMISION','1':'PERMISO'}"
						cssClass="content_ valid" 
						headerKey=""
						headerValue="--Seleccione--"
						onchange="tipoPapeletas(this.value)" 
					/>					
				</div>			

				<div class="l ">
					<s:select 
						id="motivoPapeleta" 
						listKey="srl_id_per_activ" 
	 					listValue="var_des_per_activ"
						name="personalPapeleta.personalActividad.srl_id_per_activ"
						theme="simple"
						headerKey="" headerValue="--Seleccione--"
						list="listaMotivoMarcacion"
						cssClass="content_ valid"
						onchange="tipoPapeletas(this.value)"						
					/>
				</div>

				<div class="clear"></div>
				<br>
				<div class="l lb_5"><label>Justificación:</label></div>
				<div class="clear"></div>
				<div class="l"><s:textarea  id="justificacion_papeleta" name="personalPapeleta.var_lug_desp" 
					 cols="80" rows="2" cssClass="content valid" readonly ="true"></s:textarea>
				</div>
		
			<div class="clear"></div>
	
			<fieldset class="myFieldSet">
				<legend><strong>Salida:</strong></legend>
				<div>
					<div class="l lb_e"><label>Fecha:</label></div>
					<div class="l lb_e"><label>Hora:</label></div>
					<div class="clear"></div>									 
						<div class="l lb_e"><s:textfield id="fechapapeleta" name="personalPapeleta.dte_fec_sal_desp" 
						 theme="simple" size="12" cssClass="dateDMY_ input valid" readonly="true" /></div>				
					
						<div class="l lb_e"><s:textfield id="horasalidap" name="personalPapeleta.hor_hor_sal_desp" 
						 theme="simple" size="10" cssClass="hour_i valid datetimepicker" readonly="true" /></div>			
				
				</div>				
			</fieldset>			
			
			<fieldset class="myFieldSet">
				<legend><strong>Retorno:</strong></legend>
				<div>					
					<div class="l lb_e"><label>Fecha:</label></div>
					<div class="l lb_e"><label>Hora:</label></div>
					<div class="clear"></div>	
					<div class="l lb_e"><s:textfield id="fechapapeleta2" name="personalPapeleta.dte_fec_ret_desp" 
						 theme="simple" size="12" readonly="true" /></div>						
	
					<div class="l lb_e"><s:textfield id="horaretornop" name="personalPapeleta.hor_hor_ret_desp" 
						 theme="simple" size="10" readonly="true" /></div>
				</div>	
			</fieldset>		
		</fieldset>
		<div>
			<fieldset>
				<div align="center">
					<input type="button" value="Ver Marcaciones" class="submit3" id="btnVerMarcaciones" title ="Mostrar marcaciones"/>			
					<input type="button" value="Guardar" class="submit3" id="btnInsertaPapeleta" title ="Guardar Papeleta"/>
				</div>				
			</fieldset>
		</div>			
	</s:form>
</div>
