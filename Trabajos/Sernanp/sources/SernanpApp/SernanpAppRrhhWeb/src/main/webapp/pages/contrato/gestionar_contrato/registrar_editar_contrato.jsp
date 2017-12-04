<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content">
      <div class="row">
		<div class="page-title">
				<h3>
					Edición <span class="semi-bold">Contrato / Adenda</span>
				</h3>
		</div>
	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Edición Contrato / Adenda </li>
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">

				<div class="grid-title">
					<div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

							<button class="btn btn-default" type="button" id="btnVolver">
									<i class="fa fa-reply"> </i> Volver
							</button>
								
							<button class="btn btn-primary" type="button" id="btnEditarForm">
									<i class="fa fa-edit"> </i> Editar
							</button>
								
					     </div>
							
				   </div>
				   
				</div>
			<div class="grid-title">	
				<div class="row">
				  
				    						
					 	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				           <h2>${personaNatural.nombre} ${personaNatural.apepat} ${personaNatural.apemat}</h2>
				           <p><strong>Tipo y Número de Documento:</strong></p>
				           <p>${personaNatural.descrip_tipo_documento} ${personaNatural.numerodoc}</p>
				           <p><strong>Fecha de Nacimiento:</strong></p>
				           <p>${personaNatural.fechanacimiento}</p>
				           <p><strong>Dirección:</strong></p>
				           <p>${personaNatural.direccion}</p>

				       </div> 
<%-- 				       <s:if test="%{convocatoriaCodigoPostulacionPersonaQuery!=null}"> --%>
				       
				       <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				           <h2>&nbsp;</h2>
				           <p><strong>Numero Convocatoria:</strong></p>
				           <p>
				           
								<s:if test="%{convocatoriaCodigoPostulacionPersonaQuery==null}">
									No disponible.
								</s:if>
								<s:else>
								   ${convocatoriaCodigoPostulacionPersonaQuery.var_num_convocatoria}
								</s:else>

				           
				           </p>
				           <p><strong>Codigo de Postulación:</strong></p>
				           <p>
				           
				           <s:if test="%{convocatoriaCodigoPostulacionPersonaQuery == null}">
									No disponible.
							</s:if>
							<s:else>
								   ${convocatoriaCodigoPostulacionPersonaQuery.var_codigo_postulacion}
							</s:else>
				           
				           
				           </p>
				           
				           <p><strong>Dependencia:</strong></p>
				           <p>
				           
				           <s:if test="%{convocatoriaCodigoPostulacionPersonaQuery == null}">
				           
					           <s:if test="%{areaOrganica == null}">
										No disponible.
								</s:if>
								<s:else>
										${areaOrganica.descrip_dependencia}
								</s:else>
									
							</s:if>
							<s:else>
								   ${convocatoriaCodigoPostulacionPersonaQuery.nombre_dependencia}
							</s:else>
				           
				           </p>

				       </div> 
<%-- 				       </s:if>             --%>
				           
				 </div> 
				</div>		

				<div class="grid-body no-border">
					<form class=" bv-form" method="POST" name="formContrato" id="formContrato">
					
						<s:hidden name="personaNatural.idpersona" id="idpersona"/>
						<s:hidden name="personaNatural.idpersonanatural" id="idpersonanatural"/>
						<s:hidden name="personaNatural.int_id_personal" id="int_id_personal"/>
						<s:hidden name="contrato.srl_id_contrato" id="srl_id_contrato"/>
						<s:hidden name="contrato.srl_id_contrato_padre" id="srl_id_contrato_padre"/>
						<s:hidden name="op" id="op"/>
						<s:hidden name="tipoReg" id="tipoReg"/>
						<input type="hidden" name="contrato.srl_id_postulante_conv_area_org" id="srl_id_postulante_conv_area_org" value="${idPostulacion}"/>				
						<div class="row ">
						 
						  					  
							<div class="col-md-12">
							
							<div id="informacionBasica" > 
								
							<h4 class="semi-bold">
								<span class="semi-bold">Información del Contrato / Adenda</span>
							 </h4>
                               
								<div class="row form-row">
									
									<div class="col-md-6 col-sm-6">
									   <label class="form-label">Número</label>
									   <input type="text" value="${numContrato}" readonly="readonly" class="form-control">
									</div>

								</div>

								<div class="row form-row">
						
									<div class="col-md-3 col-sm-3" id="bloque_campo_tipo_contrato">
									   <label for="apemat" class="form-label">Régimen Contractual</label>
									   
									   <s:select headerKey="" headerValue="Seleccione una opción"
													  list="listTipoContrato" listKey="srl_id_regimen_contractual" listValue="var_descripcion_regimen_contractual" 
													  id="srl_id_regimen_contractual" name="contrato.srl_id_regimen_contractual"
													  cssClass="form-control" tabindex="5" />
									</div>

									
									<div class="col-md-3 col-sm-3" id="bloque_campo_tipo_trato">
									   <label for="apemat" class="form-label">Trato Persona</label>
									   
									   <s:select headerKey="" headerValue="Seleccione una opción"
													  list="listTratoPersona" listKey="codinttablatipo" listValue="abrtablatipo"
												  	  id="int_id_tipo_trato" name="contrato.int_id_tipo_trato"
													  cssClass="form-control" tabindex="5" />
									</div>
									
									<div class="col-md-3 col-sm-3" id="bloque_campo_resolucion_hasta" style="display: none;">
										   <label for="var_num_resolucion" class="form-label">Numero Resolucion</label>
										   <s:textfield name="contrato.var_num_resolucion" id="var_num_resolucion" cssClass="form-control"/>
									</div>
									
									<div class="col-md-3 col-sm-3">
									   <label for="apemat" class="form-label">Fecha de suscripción</label>
									   <s:textfield name="contrato.dte_fec_suscrip" id="dte_fec_suscrip" cssClass="form-control"/>
									</div>									

								</div>		
								
								<div class="row form-row">
								
									<div class="col-md-3 col-sm-3">
									   <label for="dte_fec_inicio" class="form-label">Fecha de Inicio</label>
									   <s:textfield name="contrato.dte_fec_inicio" id="dte_fec_inicio" cssClass="form-control"/>
									</div>
									
									<div class="col-md-3 col-sm-3" id="bloque_campo_periodo_hasta">
									   <label for="dte_fec_termino" class="form-label">Fecha Termino</label>
									   <s:textfield name="contrato.dte_fec_termino" id="dte_fec_termino" cssClass="form-control"/>
									</div>
									
									<div class="col-md-3 col-sm-3" id="bloque_campo_fecha_cese" style="display: none;">
										   <label for="dte_fec_termino" class="form-label">Fecha de Cese</label>
										   <s:textfield name="contrato.dte_fec_cese" id="dte_fec_cese" cssClass="form-control"/>
									</div>
									
									<div class="col-md-3 col-sm-3" id="bloque_num_sueldo">
									   <label for="apemat" class="form-label">Remuneración</label>
									   <s:textfield name="contrato.num_sueldo" id="num_sueldo" cssClass="form-control"/>
									</div>
																		
									
								
								</div>						
								<div class="row form-row">
								
								
								   <div class="col-md-3 col-sm-3" id="bloque_srl_id_cargo">
									   <label for="idtipodocumento" class="form-label">Cargo</label>
									   <s:select headerKey="" headerValue="Seleccione una opción"
													  list="listCargos" listKey="srl_id_cargo" listValue="var_nom_cargo" 
													  id="srl_id_cargo" name="contrato.srl_id_cargo"
													  cssClass="form-control" tabindex="5" />
									</div>

									<div class="col-md-6 col-sm-6" id="bloque_var_lugar_prestacion">
                                        <label for="var_lugar_prestacion" class="form-label">Lugar de Prestación</label>
                                        
                                        <s:if test="%{contrato!=null}">
	                                        <s:if test="%{contrato.var_lugar_prestacion==null}">
												<textarea name="contrato.var_lugar_prestacion" id="var_lugar_prestacion" class="form-control">${convocatoriaCodigoPostulacionPersonaQuery.sede_direccion}</textarea>
											</s:if>
											<s:else>
											   <textarea name="contrato.var_lugar_prestacion" id="var_lugar_prestacion" class="form-control">${contrato.var_lugar_prestacion}</textarea>
											</s:else>
                                        </s:if>
                                        <s:else>
                                        	<textarea name="contrato.var_lugar_prestacion" id="var_lugar_prestacion" class="form-control">${convocatoriaCodigoPostulacionPersonaQuery.sede_direccion}</textarea>
                                        </s:else>
                                        
                                        
									    
									</div>
									
									<div class="col-md-3 col-sm-3" id="bloque_int_id_estado">
										<label for="idubigeo" class="form-label">Estado</label>
									    <s:select
													  list="listEstado" listKey="var_cod_estado" listValue="var_nombre_estado" 
													  id="int_id_estado" name="contrato.int_id_estado"
													  cssClass="form-control" tabindex="5" />

									</div>
									
									
									
									
									

								</div>
								
								
								
                               </div> <!-- fin bloque informacionBasica -->

							
							</div>

						</div>

						<div class="form-actions" id="bloque_btn_form">
							<div class="pull-left"> 
							
								<button class="btn btn-primary " type="button" id="btnGrabar">
									<i class="fa fa-save"></i> Grabar
								</button>
								 
								<button class="btn btn-white " type="button" id="btnLimpiarForm" tabindex="34">
									<i class="fa fa-file-o"></i> Limpiar Campos
								</button>
								
							</div>
						</div>
					</form>
				</div>
				<!--end grid-body -->

			</div>
			<!-- end grid simple -->
		</div>
		<!-- end row -->
	</div>
	<!-- end page-content -->
	
	<!-- END PAGE -->
	
<div id="modalConfirmarGrabar" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Confirmación</h4>
      </div>
      <div class="modal-body">
      		<br/>
     		
     		¿Estas seguro grabar la información?
     		
      </div>
      <div class="modal-footer">
<!--         <button type="button" class="btn btn-primary" onclick="grabarFormulario()">Si</button> -->
		<button type="button" id="confirmacion_grabar" class="btn btn-primary" onclick="grabarFormulario()"  >Si</button>
<!-- 			<button type="button"   class="btn btn-danger" data-dismiss="modal">No</button>	 -->
        <button type="button" id="desistir_grabar"  class="btn btn-danger" data-dismiss="modal">No</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
