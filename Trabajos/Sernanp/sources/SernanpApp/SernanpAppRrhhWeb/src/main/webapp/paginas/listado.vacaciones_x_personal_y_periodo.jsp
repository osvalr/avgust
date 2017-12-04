<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

	<s:if test="%{#request.tieneVacacionesconGoce > 0 }">

				<div id="divListaVacaciones">
						<div class="row form-row">				
			<div class="col-lg-12 col-md-12 col-sm-12">

					<h6><span class="semi-bold">Lista de Vacaciones Programadas / utilizadas:</span></h6>				
	
					<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover" id="tableDefault_x_persona_y_periodo">
						<thead>
							<tr>
								<th>N°</th>
								<th>F. Inicio</th>
								<th>F. Fín</th>
								<th>Días</th>
								<th>Autorización / Justificación </th>								
								<th>Cerrar</th>
								<th>Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listapersonalVacacionesGoce" var="var" status="varStatus">
			
								<tr>
			
									<td><s:property value="%{#varStatus.count}" /></td>
									<td><s:date name="%{#var.dte_fec_inicio_goc_vac}" format="dd/MM/yyyy" /></td>
									<td><s:date name="%{#var.dte_fec_fin_goc_vac}" format="dd/MM/yyyy" /></td>
									<td><s:property value="#var.int_dias_goce_vac" /></td>
									<td><s:property value="#var.var_justificacion_post" /></td>
									
									<td>	
											<s:if test="#var.int_estado_goce_vac > 0">
												<button type="button" class="btn btn-primary" title="Concluir programación (cerrar)" onclick="javascript:programaVacacionesCerrar(<s:text name="#var.personalVacaciones.srl_id_pers_vac" />, 
													<s:text name="#var.srl_id_pers_goce_vac" />);">
													<i class="fa fa-check"></i>
												</button> 
											</s:if>			
											<s:elseif test="#var.int_estado_goce_vac == 0">
											<s:text name="Cerrado" />
											</s:elseif>	
	
									</td>
									<td>
	
	
									<s:if test="#var.int_estado_goce_vac > 0">
	<%-- 									<input type="button" class="btn btn-primary" value="..." onclick="javascript:programaVacacionesEditar(<s:text name="#var.srl_id_pers_goce_vac" />);" /> --%>
										<button type="button" class="btn btn-danger" title="Eliminar programación" onclick="javascript:programaVacacionesEliminar(
											<s:text name="#var.personalVacaciones.srl_id_pers_vac" />, 
											<s:text name="#var.srl_id_pers_goce_vac" />,
											'<s:date name="%{#var.dte_fec_inicio_goc_vac}" format="dd/MM/yyyy" />',
											'<s:date name="%{#var.dte_fec_fin_goc_vac}" format="dd/MM/yyyy" />');" >
											<i class="fa fa-trash-o"></i>
											
										</button>
									</s:if>	
	
									</td>									
			
								</tr>
							</s:iterator>
						</tbody>
					</table>	
	<!-- 		<br /> -->
				</div>
		</div>
				</div>

		
	</s:if>
	<s:if test="%{#request.AddProgVac > 0 }">
		<div id="regVacaciones">
			<s:form name="formRegistroVacaciones" id="formRegistroVacaciones" method="post" theme="simple">
				<s:hidden id ="idPersonal" name="idPersonal" value="%{#request.idPersonal}"/>
				<s:hidden id ="idVacacionesrv" name="personalVacacionesGoce.id_pers_vac" />
				
				<h6><span class="semi-bold">Programación del descanso físico - Vacaciones ( </span><span class="semi-bold" > <s:text name="personalVacaciones.int_dias_vac_pendientes"></s:text> días programables ).</span></h6>
				<br>
				
				<div class="row form-row">	
						
						<div class="col-lg-3 col-md-3 col-sm-3">
							<label>Fecha Inicio:</label>
							<s:textfield id="f_inicioVac" name="personalVacacionesGoce.dte_fec_inicio_goc_vac" value="%{#request.fechaFinVacacUtilizadas}" 
								 readonly="true" cssClass="form-control"/> 
						</div>
						
						<div class="col-lg-3 col-md-3 col-sm-3">
							<label>Fecha Fín:</label>
							<s:textfield id="f_finVac" name="personalVacacionesGoce.dte_fec_fin_goc_vac" value="%{#request.fechaFinVacacadd7}"
								 readonly="true" cssClass="form-control" />
						</div>
										
						<div class="col-lg-3 col-md-3 col-sm-3">
							<label>Programación (Días):</label>
							<s:textfield id="cantDiasVac" name="personalVacacionesGoce.int_dias_goce_vac"   
								 readonly="false"  cssClass="number onlyDigits form-control" 							 
								 onkeyup="javascrip:cambiarFechafinProgVac('');"/>
						</div>
						
						<div class="col-lg-3 col-md-3 col-sm-3">
							<label>Pendientes (Días):</label>
							<s:textfield id="cantDiasVacPendientes" value="%{#request.diasPendientes}"
								 readonly="true" cssClass="form-control"/> 
						</div>			
				</div>
				<div class="row form-row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<label>Autorización / Justificación </label>
						<s:textarea id="justificacion_vacaciones" name="personalVacacionesGoce.var_justificacion_post" cssClass="content_ valid form-control" />
					</div>
				</div>
				
			<div class="form-actions">
				<div class="row pull-right" >
					<button type="button" class="btn btn-primary" id="btnInsertaVacaciones" title ="Guarda Vacaciones">
						<i class="fa fa-save"> Guardar</i>
					</button>
					<button type="button" class="btn btn-primary" id="btnCancelar" title="Salir de progrmacación." onclick="javascript:cerrarModalVacaciones();">
						<i class="fa fa-power-off"> Cancelar</i>
					</button>										
				</div>
			</div>	
				
			</s:form>					
		</div>				
	</s:if>
	<s:else>
		<s:if test="%{#request.f_iniProgVaciones  != null}">
			<br/>
			<div class="row form-row">							
				<div class="col-lg-6 col-md-6 col-sm-6">
				<label>Fecha inicio programación de vacaciones:</label>
				<s:textfield value="%{#request.f_iniProgVaciones}" theme="simple" readonly="true" cssClass="form-control" /> 
				</div>
			</div>
		</s:if>
		<div class="row form-row">							
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div id="msgSinMarcaciones">
					<s:actionmessage id="msgMarcaciones" cssClass="alertamsg" cssStyle="display: block;" />
				</div>	
			</div>
		</div>

		<div class="form-actions">
			<div class="row pull-right" >					
				<button type="button" class="btn btn-primary" id="btnCancelarsinAdd" title="Salir de progrmacación." onclick="javascript:cerrarModalVacaciones();">
					<i class="fa fa-power-off"> Cancelar</i>
				</button>										
			</div>
		</div>		
	</s:else>

	<s:hidden id="f_inicioVac_dataTable" 		name="" value="%{#request.f_inicioVac_dataTable}"/>
	<s:hidden id="diasCorresponde_dataTable" 	name="" value="%{#request.diasCorresponde_dataTable}"/>
	<s:hidden id="diasGoce_dataTable" 			name="" value="%{#request.diasGoce_dataTable}"/>