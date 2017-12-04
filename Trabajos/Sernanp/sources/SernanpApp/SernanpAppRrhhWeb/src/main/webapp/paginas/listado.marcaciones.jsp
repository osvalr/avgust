<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="modal-body">

<div class="row form-row">
		<br>
<!-- <div class="row form-row"> -->
	<div class="col-lg-8 col-md-8 col-sm-8">	
<!-- 	<div style="padding-top:5px; padding-bottom:5px;">																							 -->
		<span class="light">Apellidos y Nombres:</span>	   
		<span class="semi-bold" >
			<s:text name="personanatural.apepat" />&nbsp;
			<s:text name="personanatural.apemat" />,&nbsp;
			<s:text name="personanatural.nombre" />
		</span>

	</div>

	<div class="col-lg-1 col-md-1 col-sm-1">
		<label class="form-label">Fecha:</label>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3" style="display:inline">
		<s:textfield id ="dte_fec_marc" name="dte_fec_marc" cssClass="form-control"  readonly="true" 
			value="%{#request.dte_fec_marc}"  tabindex="2" 
			onchange="javascrip:marcacionesxFechaxidPersonal(this.value)"
			/>
	</div>

</div>

<s:hidden id="idpersonal_marc" name="personanatural.idpersonal" />
<%-- <s:textfield id="regHI" value="%{#request.regHI}"/> --%>
<%-- <s:textfield id="regHS" value="%{#request.regHS}"/> --%>
<s:hidden id="cantMarcacion" value="%{#request.cantMarcacion}"/>
<s:hidden id="descValidados" value="%{#request.descValidados}"/>
<s:hidden id="personalconP" value="%{#request.PersonalPermiso}" />
	
<!-- 	INICIO -->
<div id="divListaMarcaciones" style="height: 175px;overflow-y: scroll;">

	<script type="text/javascript">
		$(document).ready(function(){
			marcacionesxFechaxidPersonal($("#dte_fec_marc").val());
		});
	
	</script>


</div>
<br>
<div class="row form-row">

	<button type="button" class="btn btn-primary btn-xs" onclick="javascript:verPapeletasxidP();" title ="Mostrar papeleta del Personal.">
		<i class="fa fa-eye"> Papeleta</i>
	</button>

	<button type="button" class="btn btn-primary"  id="btnEditarMarcacion" onclick="jacascript:modalEditarMarcacion(0);" title ="Editar marcaci&oacute;n seleccionada" disabled ="disabled">
		<i class="fa fa-edit"> Modificar</i>
	</button>

	<button type="button" class="btn btn-danger"  id="btnEliminarMarcacion" onclick="jacascript:modalEditarMarcacion(1);" title ="Eliminar marcaci&oacute;n seleccionada" disabled ="disabled">
		<i class="fa fa-trash-o"> Eliminar</i>
	</button>

	
</div>

		<s:form id="formRegistroMarcaciones" method="post" theme="simple" style="overflow:hidden">
			<s:hidden id ="idPersonalrm" name="personalMarcacion.personal.idpersonal" />
			<s:hidden id="fechamarcacion" name="personalMarcacion.dte_fec_marc" value="%{#request.dte_fec_marc}"/>
			
			
			<h4 class="semi-bold">
			<br>
				<span id="dos">1.</span> <span class="light">Datos de la </span> <span class="semi-bold">Marcaci&oacute;n Manual</span>
			</h4>
				
				
					<div class="row form-row">	
						
	<!-- 					<div class="clear"></div> -->
						<div class="col-lg-8 col-md-8">
							<label>Actividad:</label>
							<s:select id="MotivoM" 
								listKey="srl_id_per_activ" 
			 					listValue="var_des_per_activ"
								name="personalMarcacion.personalActividad.srl_id_per_activ"
								theme="simple"
								headerKey="" headerValue=""
								list="listaMotivoMarcacion"								
								onchange="MotivoMarcacion(this.value)"
								cssClass="content_ valid form-control"		
								tabindex="1" 				
							/>	 
<!-- 							cssClass="content_ valid"      			 -->
						</div>
						
	
						
						<div class="col-lg-4 col-md-4" id="divtimePermiso">
							<label>Tiempo:</label>
							<s:select id ="timePermiso" name="timePermiso" list="#{'0':'Día','1':'Horas'}" 
								headerValue="" headerKey=""
								cssClass="content_ valid form-control"
								onchange="tipoPermiso(this.value)"/>
<!-- 								cssClass="content_ valid" -->
						</div>					


					</div>

					
					<div class="row form-row">
						<div class="col-lg-12 col-md-12">
								<label>Justificación:</label>
								<s:textarea  id="justificacion_marcacion" name="personalMarcacion.var_descripcion" 
							 				cols ="100" rows="2" cssClass="content_ valid form-control" readonly ="true" value=""></s:textarea>
						</div>
					</div>
					
					
					<div id="divhoras" class="row form-row" >					

<!-- 							<div class="l lb_e"> -->
							<div class="col-lg-3 col-md-3">
								<label class="form-label">H. Inicio:</label>
								<s:textfield id="horaingreso" cssClass="form-control" name="personalMarcacion.hor_hor_marc" value=""
								 theme="simple" size="12"  />
<!-- 							</div>						 -->
<!-- 						cssClass="hour_i valid datetimepicker" -->
							</div>
							<div class="col-lg-3 col-md-3">						
								<label class="form-label">H. F&iacute;n:</label>
								<s:textfield id="horasalida" cssClass="form-control" name="personalMarcacion.hor_hor_marc1" value=""
								 theme="simple" size="12" />
							</div>
								 
					</div>
					
<!-- 					<br/> -->
<!-- 					<div class="clear" ></div> -->
					<div id="divfechas" class="row form-row">
										
						<div class="col-lg-4 col-md-4">
							<label class="form-label">F. Inicio:</label>
							<s:textfield id="fechaIniM" cssClass="form-control" name="personalMarcacion.dte_fec_marc1" value=""
							 theme="simple" size="12"  readonly="true"  />
						</div>		 
						
						<div class="col-lg-4 col-md-4">
							<label class="form-label">F. F&iacute;n:</label>
							<s:textfield id="fechaFinM" cssClass="form-control" name="personalMarcacion.dte_fec_marc2" value=""
							 theme="simple" size="12"  readonly="true" />
						</div>		
											 
					</div>

					
		
			<div class="form-actions">
				<div class="row pull-right" >
				
					<button type="button" class="btn btn-primary" id="btnInsertaMarcacionManual" title ="Guardar marcaci&oacute;n">
						<i class="fa fa-save">  Guardar</i>
					</button>

					<button type="button"  class="btn btn-primary" id="btnCancelarMarc" title="Salir de Marcaciones" onclick="javascript:cerrarModalMarcaciones();">
						<i class="fa fa-power-off"> Cancelar</i>
					</button>
				
				</div>
			</div>		
				

		</s:form>


</div>

<div id="dialog-info-rmm" hidden="true">  
	<p>Hora salida esta vac&iacute;a.</p>
	<p>¿Desea agregar una hora?</p>
</div>
<div id="dialog-info-noeditable" hidden="true">  
	<p><strong>Marcac&oacute;n de Reloj TEMPUS - Acci&oacute;n no permitida.</strong></p>
</div>				
<div id="divModalMarcacionesE"></div>
<div id="dialog-info-Papeleta" hidden="true"> </br> <p><strong>Debe seleccionar una Papeleta!</strong></p></div>