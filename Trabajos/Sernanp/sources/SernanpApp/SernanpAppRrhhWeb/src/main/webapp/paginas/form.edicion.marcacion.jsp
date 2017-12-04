<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="modal-body">

<h5 class="light">	<label>Trabajador:</label>
<!-- </h4> -->
	<span class="semi-bold">
		<s:text name="personanatural.apepat" />&nbsp;
		<s:text name="personanatural.apemat" />,&nbsp;
		<s:text name="personanatural.nombre" />
			
	</span>
				
</h5>

	<s:form id="formEdicionMarcacion" method="post" theme="simple">
		<s:hidden id = "idPersonalPapeleta" name="personalPapeleta.personal.idpersonal"/>
		<s:hidden id="id_papeleta" name="personalPapeleta.srl_id_desp" />


		<!-- <div class="row "> -->	
				
		
				<div class="col-md-12">				
		
						<div class="form-row">
							<h5 class="semi-bold">Motivo de marcación:</h5>
		
							<div class="col-md-6 col-sm-6">
								<label class="form-label">Actividad:</label>
								<s:select 
									listKey="srl_id_per_activ" 
				 					listValue="var_des_per_activ"
									name="personalPapeleta.personalActividad.srl_id_per_activ"
									theme="simple"
									headerKey="" headerValue=""
									list="listaMotivoMarcacion"
									cssClass="content_ valid form-control"
									onchange="MotivoMarcacionE(this.value)"					
								/>
							</div>
							
							<div class="col-md-6 col-sm-6">
								<label class="form-label">Justificación:</label>								

									<s:textarea  id="justificacion_marcacion" name="personalPapeleta.var_lug_desp" 
										rows="1" cssClass="content_ valid form-control" readonly ="false" theme="simple"></s:textarea>

							</div>
												
						</div>				
				
				
						<div class="form-row">
							<h5 class="semi-bold">Fecha y hora:</h5>
							<div class="col-md-4 col-sm-4">
								<label class="form-label">F. Marcación:</label>
									<s:textfield name="personalPapeleta.dte_fec_sal_desp" id="dte_fec_marc_Edicion" theme="simple" readonly="true" cssClass="form-control"  />
							</div>
							
							<div class="col-md-4 col-sm-4">
								<label class="form-label">H. Inicio:</label>
									<s:textfield id="horasalidaE" name="personalPapeleta.hor_hor_sal_desp" value="%{#request.hor_salida_papeleta}"
							 	theme="simple" cssClass="hour_i valid datetimepicker form-control" />
							</div>
							
							<div class="col-md-4 col-sm-4">
								<s:if test="%{personalPapeleta.hor_hor_ret_desp != null}">
									<label class="form-label">H. Fín:</label>									
									<s:textfield id="horaretornoE" name="personalPapeleta.hor_hor_ret_desp"									 
							 			theme="simple" cssClass="hour_i valid datetimepicker form-control" value="%{#request.hor_retorno_papeleta}"/>
							 	</s:if>
							</div>
												
						</div>
					
				</div>
		
		
		
				
		<!-- </div> -->
		
</s:form>

		<div class="form-actions">
			<div class="pull-right">
					<button type="button" class="btn btn-primary" id="btnVolveraMarcacionesEM" title ="Mostrar marcaciones">
					<i class="fa fa-eye">  Ver Marcaciones</i>
					</button>
					<button type="button" class="btn btn-primary" id="btnActualizarMarcacion" title ="Guardar los cambios">
						<i class="fa fa-save"> Guardar</i>
					</button>
			</div>
		</div>
	
<!-- 	<div id="marcacion-tempus" hidden="true"><p>Acción no permitida.</p><p> Tipo de Marcación - Reloj TEMPUS</div> -->
<div id="dialog-info-emm" hidden="true">  <p>¿Fecha y Hora Fín esta vacio, desea agregar una Fecha y Hora?</p></div>
	
</div>

