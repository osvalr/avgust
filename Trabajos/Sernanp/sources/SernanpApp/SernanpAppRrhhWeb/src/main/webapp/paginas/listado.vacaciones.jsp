<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="modal-body">

	<div class="row form-row">
		<div class="col-lg-3 col-md-3 col-sm-3">																								
			<span class="light">Apellidos y Nombres:</span>
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-6">	
			<span class="semi-bold" >		   
				<s:text name="personanatural.apepat" />&nbsp;
				<s:text name="personanatural.apemat" />,&nbsp;
				<s:text name="personanatural.nombre" />
			</span>
		</div>
<!-- 	</div> -->

<!-- 	<div class="row form-row"> -->
		<div class="col-lg-1 col-md-1 col-sm-1">
			<label class="form-label">Periodo:</label>
		</div>

<!-- 		<div class="col-lg-3 col-md-3 col-sm-3">	 -->
<%-- 			<s:textfield id ="periodoVacaciones"  readonly="true" value="%{periodoVacaciones}" cssClass="form-control" /> --%>
<%-- 			<s:hidden id="idPersonalVacaciones" name="personanatural.idpersonal"/> --%>
<!-- 		</div> -->
		
		<div class="col-lg-2 col-md-2 col-sm-2">
			<s:hidden id="idPersonalVacaciones" name="personanatural.idpersonal"/>
				<s:select id='periodoVacaciones' 
				   listKey="int_periodo_vac"   
		  		   listValue="int_periodo_vac"  
		  		   value="%{periodoVacaciones}"
		  		   name="int_periodo_vac"  
		 		   list="listaPeriodosVacaciones" 
		 		   cssClass="form-control" 
		 		   onchange='programarVacaciones($("#idPersonalVacaciones").val(),1)'  
		 		   title="Periodo de Vacaciones"
		 		/>
		</div>
		
	</div>

	<div id="view_vacaciones">

	</div>
		<script type="text/javascript">
		$(document).ready(function(){
			programarVacaciones($("#idPersonalVacaciones").val(),1);
		});
		</script>	
	
	<!-- Todo lo que esta hacia abajo, esta en el archivo listado.vacaciones_x_personal_y_periodo.jsp -->
	
<%-- 	<s:if test="%{#request.tieneVacacionesconGoce > 0 }"> --%>
<!-- 		<div id="divListaVacaciones"> -->
<%-- 			<legend><strong>Lista de Vacaciones Programadas / utilizadas:</strong></legend>	 --%>
		
<!-- 					<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover" id="tableDefault"> -->
<!-- 						<thead> -->
<!-- 							<tr> -->
<!-- 								<th>N°</th> -->
<!-- 								<th>F. Inicio</th> -->
<!-- 								<th>F. Fín</th> -->
<!-- 								<th>Días</th> -->
<!-- 								<th>F. Posterg.</th> -->
<!-- 								<th>Descripción</th> -->
<!-- 								<th>Eliminar</th> -->
<!-- 								<th>Cerrar</th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody> -->
<%-- 							<s:iterator value="listapersonalVacacionesGoce" var="var" status="varStatus"> --%>
			
<!-- 								<tr> -->
			
<%-- 									<td><s:property value="%{#varStatus.count}" /></td> --%>
<!-- 									<td> -->
<%-- 									<s:date name="%{#var.dte_fec_inicio_goc_vac}" format="dd/MM/yyyy" /> --%>
									
<!-- 									</td> -->
<!-- 									<td> -->
									
<%-- 									<s:date name="%{#var.dte_fec_fin_goc_vac}" format="dd/MM/yyyy" /> --%>
<!-- 									</td> -->
<%-- 									<td><s:property value="#var.int_dias_goce_vac" /></td> --%>
<!-- 									<td> -->
									
<%-- 									<s:date name="%{#var.tsp_fec_post_goce_vac}" format="dd/MM/yyyy" /> --%>
<!-- 									</td> -->
<%-- 									<td><s:property value="#var.var_justificacion_post" /></td> --%>
<!-- 									<td> -->
	
	
<%-- 									<s:if test="#var.int_estado_goce_vac > 0"> --%>
<%-- 	<%-- 									<input type="button" class="btn btn-primary" value="..." onclick="javascript:programaVacacionesEditar(<s:text name="#var.srl_id_pers_goce_vac" />);" /> --%> 
<%-- 										<button type="button" class="btn btn-danger" onclick="javascript:programaVacacionesEliminar( --%>
<!-- 											<s:text name="#var.personalVacaciones.srl_id_pers_vac" />,  -->
<!-- 											<s:text name="#var.srl_id_pers_goce_vac" />, -->
<!-- 											'<s:date name="%{#var.dte_fec_inicio_goc_vac}" format="dd/MM/yyyy" />', -->
<%-- 											'<s:date name="%{#var.dte_fec_fin_goc_vac}" format="dd/MM/yyyy" />');" > --%>
<!-- 											<i class="fa fa-trash-o"></i> -->
											
<!-- 										</button> -->
<%-- 									</s:if>	 --%>
	
<!-- 									</td> -->
									
<!-- 									<td> -->
	
	
<%-- 											<s:if test="#var.int_estado_goce_vac > 0"> --%>
<%-- 												<button type="button" class="btn btn-primary" onclick="javascript:programaVacacionesCerrar(<s:text name="#var.personalVacaciones.srl_id_pers_vac" />,  --%>
<%-- 													<s:text name="#var.srl_id_pers_goce_vac" />);"> --%>
<!-- 													<i class="fa fa-check"></i> -->
<!-- 												</button>  -->
<%-- 											</s:if>			 --%>
<%-- 											<s:elseif test="#var.int_estado_goce_vac == 0"> --%>
<%-- 											<s:text name="Cerrado" /> --%>
<%-- 											</s:elseif>	 --%>
	
<!-- 									</td> -->
									
			
<!-- 								</tr> -->
<%-- 							</s:iterator> --%>
<!-- 						</tbody> -->
<!-- 					</table>	 -->
<!-- 		</div> -->
<%-- 	</s:if> --%>
<%-- 	<s:if test="%{#request.AddProgVac > 0 }"> --%>
<!-- 		<div id="regVacaciones"> -->
<%-- 			<s:form name="formRegistroVacaciones" id="formRegistroVacaciones" method="post" theme="simple"> --%>
<%-- 				<s:hidden id ="idPersonal" name="idPersonal" value="%{#request.idPersonal}"/> --%>
<%-- 				<s:hidden id ="idVacacionesrv" name="personalVacacionesGoce.id_pers_vac" /> --%>
				
<!-- 			<h4 class="semi-bold"> -->
<!-- 			<br> -->
<%-- 				<span class="light">Datos del descanso físico - Vacaciones:</span> --%>
<!-- 			</h4> -->
				
<!-- 				<div class="row form-row">	 -->
						
<!-- 						<div class="col-lg-6 col-md-6"> -->
<!-- 							<label>F. Inicio:</label> -->
<%-- 							<s:textfield id="f_inicioVac" name="personalVacacionesGoce.dte_fec_inicio_goc_vac" value="%{#request.fechaFinVacacUtilizadas}"  --%>
<%-- 									 theme="simple" readonly="true" cssClass="form-control"/>  --%>
<!-- 						</div> -->
						
<!-- 						<div class="col-lg-6 col-md-6"> -->
<!-- 							<label>F. Fín:</label> -->
<%-- 							<s:textfield id="f_finVac" name="personalVacacionesGoce.dte_fec_fin_goc_vac" value="%{#request.fechaFinVacacadd7}" --%>
<%-- 								 theme="simple" readonly="true" cssClass="form-control" /> --%>
<!-- 						</div> -->
						

<!-- 				</div> -->
				
<!-- 				<div class="row form-row">	 -->
				
<!-- 						<div class="col-lg-6 col-md-6"> -->
<!-- 							<label>Días a Programar:</label> -->
<%-- 							<s:textfield id="cantDiasVac" name="personalVacacionesGoce.int_dias_goce_vac"    --%>
<%-- 								 theme="simple" readonly="false"  cssClass="number onlyDigits form-control" 							  --%>
<%-- 								 onkeyup="javascrip:cambiarFechafinProgVac('');"/> --%>
<!-- 						</div> -->
						
<!-- 						<div class="col-lg-6 col-md-6"> -->
<!-- 							<label>Días Pendientes:</label> -->
<%-- 							<s:textfield id="cantDiasVacPendientes" value="%{#request.diasPendientes}" --%>
<%-- 								 theme="simple" readonly="true" cssClass="form-control"/>  --%>
<!-- 						</div> -->
				
<!-- 				</div> -->
				
<!-- 			<div class="form-actions"> -->
<!-- 				<div class="row pull-right" > -->
<!-- 					<button type="button" class="btn btn-primary" id="btnInsertaVacaciones" title ="Guarda Vacaciones"> -->
<!-- 						<i class="fa fa-save"> Guardar</i> -->
<!-- 					</button> -->
<!-- 					<button type="button" class="btn btn-primary" id="btnCancelar" title="Salir de progrmacación." onclick="javascript:cerrarModalVacaciones();"> -->
<!-- 						<i class="fa fa-power-off"> Cancelar</i> -->
<!-- 					</button>										 -->
<!-- 				</div> -->
<!-- 			</div>	 -->
				
<%-- 			</s:form>					 --%>
<!-- 		</div>				 -->
<%-- 	</s:if> --%>
<%-- 	<s:else> --%>
<%-- 		<s:if test="%{#request.f_iniProgVaciones  != null}"> --%>
<!-- 			<br/> -->
<!-- 			<div class="row form-row">							 -->
<!-- 				<div class="col-lg-6 col-md-6"> -->
<!-- 				<label>Fecha inicio programación de vacaciones:</label> -->
<%-- 				<s:textfield value="%{#request.f_iniProgVaciones}" theme="simple" readonly="true" cssClass="form-control" />  --%>
<!-- 				</div> -->
<!-- 			</div> -->
<%-- 		</s:if> --%>
<!-- 		<div id="msgSinMarcaciones"> -->
<%-- 			<s:actionmessage id="msgMarcaciones" cssClass="alertamsg" cssStyle="display: block;" /> --%>
<!-- 		</div>	 -->
<!-- 		<div class="form-actions"> -->
<!-- 			<div class="row pull-right" >					 -->
<!-- 				<button type="button" class="btn btn-primary" id="btnCancelarsinAdd" title="Salir de progrmacación." onclick="javascript:cerrarModalVacaciones();"> -->
<!-- 					<i class="fa fa-power-off"> Cancelar</i> -->
<!-- 				</button>										 -->
<!-- 			</div> -->
<!-- 		</div>		 -->
<%-- 	</s:else> --%>
<%-- 	<s:hidden id="f_inicioVac_dataTable" 		name="" value="%{#request.f_inicioVac_dataTable}"/> --%>
<%-- 	<s:hidden id="diasCorresponde_dataTable" 	name="" value="%{#request.diasCorresponde_dataTable}"/> --%>
<%-- 	<s:hidden id="diasGoce_dataTable" 			name="" value="%{#request.diasGoce_dataTable}"/> --%>
	
	<!-- Hasta aqui esta en el archivo  -->			
</div>