<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content">
      <div class="row">
		<div class="page-title">
				<h3>
					Gestionar <span class="semi-bold">Registro del Personal</span>
					( Actualizar Información Complementaria )
				</h3>
		</div>
	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Gestionar Registro del Personal</li>
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">

				<div class="grid-title">
					<div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	
								<button id="btnVolver" class="btn btn-default" type="button" onclick="irListarPersonal('${personalQuery.idpersonal}')">
									<i class="fa fa-reply"> </i> ir al Inicio
									</button>
							
						     	<button class="btn btn-primary" type="button" onclick="desvincularPersonal('${personalQuery.idpersonal}' , '${personalQuery.idpersonanatural}')">
									<i class="fa fa-minus-circle"></i> Desvincular Personal
							 	</button>
							    
							    <button class="btn btn-primary" type="button" onclick="registroPersonalLegajo('${personalQuery.idpersonal}' , '${personalQuery.idpersonanatural}')">
									<i class="fa fa-plus-circle"></i> Registrar Legajo
							    </button>
							    
							    <button class="btn btn-primary" type="button" onclick="generarConstancia()">
									<i class="fa fa-plus-circle"></i> Generar Constancia
							    </button>

					     </div>
							
				   </div>
				   
				   
				   
				</div>
			<div class="grid-title">	
				<div class="row">
				  
				      <div class="col-lg-2 col-md-4 col-sm-4 col-xs-6">
				         
				         	<div class="user-image no-pad profile-details" >
				         	
							<img id="imgFotoPersonal" alt="" width="190" height="230" src="">

							</div>
						</div>   
					 	<div class="col-lg-10 col-md-8 col-sm-8 col-xs-6"">
						   <h2 id="txtNombres">${personalQuery.nombre} ${personalQuery.apepat} ${personalQuery.apemat}</h2>
						  
				           <h5 >Tipo y Número de Documento:</h5>
				           <p class="semi-bold">${personalQuery.descrip_tipo_documento} ${personalQuery.numerodoc}</p>
				           
				           <h5 >Fecha de Ingreso Institucional:</h5>
				           <p class="semi-bold">${personalQuery.dte_fec_inicio}</p>
				           
				            <button  id="btnOcultarInfoPersonal" class="btn btn-primary hide " type="button" onclick="ocultarInformacionPersonal()"  >
								<i class="fa fa-list"></i> Ocultar detalles del Personal
							</button> 
				           
				            <button  id="btnMostrarInfoPersonal" class="btn btn-primary hide" type="button" onclick="mostrarInformacionPersonal()"  >
								<i class="fa fa-list"></i> Ver detalles del Personal
							</button> 
							
							 <button  id="btnMostrarContrato" class="btn btn-primary" type="button"  >
								<i class="fa fa-file-text"></i> Ver detalles del Contrato
							</button> 
							      
				       </div>  
				       
				            
				           
				 </div> 
				</div>		

				<div class="grid-body no-border">
				
				 <div class="row ">
					<form name="formPersonal" id="formPersonal" method="POST"> <!--  onreset="retornarPaisReset()">-->
					
						<input type="hidden" value="${personalQuery.idpersona}" name="personal.idpersona" id="idpersona"/>
						<input type="hidden" value="${personalQuery.idpersonanatural}" name="personal.idpersonanatural" id="idpersonanatural"/>
						<input type="hidden" value="${personalQuery.int_id_postulante}" name="personal.int_id_postulante" id="int_id_postulante"/>
						<input type="hidden" value="${personalQuery.idpersonal}" name="personal.idpersonal" id="idpersonal"/>
						
						<input type="hidden" value="${personalQuery.codprovDir}" id="codprovDir"/>
						<input type="hidden" value="${personalQuery.idubigeoDir}" id="idubigeoDir"/>
						<input type="hidden" value="${personalQuery.codprovNac}" id="codprovNac"/>
						<input type="hidden" value="${personalQuery.idubigeoNac}" id="idubigeoNac"/>
						
						<input type="hidden" value="${personalQuery.idpais}" id="hd_idpais"/>
						<input type="hidden" value="${personalQuery.idestadocivil}" id="hd_idestadocivil"/>
						<input type="hidden" value="${personalQuery.srl_id_regimen_pensionario}" id="hd_srl_id_regimen_pensionario"/>
						<input type="hidden" value="${personalQuery.srl_id_entidad_bancaria}" id="hd_srl_id_entidad_bancaria"/>
						
						
						 
						  					  
							<div id="columna-1" class="col-md-6">
							
							<div id="informacionBasica"> 
								
							<h4 class="semi-bold">
									1. <span class="light">Información</span> <span
										class="semi-bold">Básica</span>
							 </h4>
                               
								<div class="row form-row">
									<div class="col-lg-12 col-md-12">
									    <label for="nombre" class="form-label">Nombres <span class="txtrojo">*</span></label> 
										<input id="nombre" name="personal.nombre" value="${personalQuery.nombre}" type="text" class="form-control" tabindex="1">
									</div>
									<div class="col-md-6 col-sm-6">
									   <label for="apepat"  class="form-label">Apellido Paterno <span class="txtrojo">*</span></label>
									   <input id="apepat" name="personal.apepat" value="${personalQuery.apepat}" type="text" class="form-control" 
										tabindex="2">
									</div>
									<div class="col-md-6 col-sm-6">
									   <label for="apemat" class="form-label">Apellido Materno <span class="txtrojo">*</span></label>
									   <input id="apemat" name="personal.apemat" value="${personalQuery.apemat}" type="text" class="form-control" 
										tabindex="3">
									</div>
									
								</div>

								<div class="row form-row">
									<div class="col-md-6 col-sm-6">
									   <label for="idsexo" class="form-label">Sexo <span class="txtrojo">*</span></label> 
									   
									   <select name="personal.idsexo" tabindex="4" id="idsexo" class="form-control">
											<option value="">Seleccione una opción</option>
											<s:iterator value="listGenero" var="var" status="varStatus">
												 <s:if test="%{#var.idtablatipo == personalQuery.idsexo}">
												 	<option value="<s:property value="#var.idtablatipo" />" selected="selected"><s:property value="#var.destablatipo" /></option>
												 </s:if>
												 <s:else>
												 <option value="<s:property value="#var.idtablatipo" />"><s:property value="#var.destablatipo" /></option>
												 </s:else>
												
											</s:iterator>

										</select>

									</div>
									<div class="col-md-6 col-sm-6">
									   <label for="fechanacimiento" class="form-label">Fecha de Nacimiento <span class="txtrojo">*</span></label>
									   
									   <input id="fechanacimiento" name="personal.fechanacimiento" value="${personalQuery.fechanacimiento}" type="text" class="form-control" 
										tabindex="5"
                						placeholder="dd/mm/yyyy"  
                						>
                						
                						</div>
        					
									</div>

								
								
								<div class="row form-row">
									
									<div class="col-md-6 col-sm-6">
									   <label for="idtipodocumento" class="form-label">Tipo de Documento <span class="txtrojo">*</span></label>
									    <select name="personal.idtipodocumento" tabindex="4" id="idsexo" class="form-control">
											<option value="">Seleccione una opción</option>
											<s:iterator value="listTipoDocumento" var="var" status="varStatus">
												 <s:if test="%{#var.ordtablatipo == personalQuery.idtipodocumento}">
												 	<option value="<s:property value="#var.ordtablatipo" />" selected="selected"><s:property value="#var.abrtablatipo" /></option>
												 </s:if>
												 <s:else>
												 <option value="<s:property value="#var.ordtablatipo" />"><s:property value="#var.abrtablatipo" /></option>
												 </s:else>
												
											</s:iterator>

										</select>
										
									</div>
									
									<div class="col-md-6 col-sm-6">
									   <label for="numerodoc" class="form-label">Nº de Documento <span class="txtrojo">*</span></label>
									   <input id="numerodoc" name="personal.numerodoc" value="${personalQuery.numerodoc}"  type="text" class="form-control" 
										tabindex="7"
                						>
									</div>

								</div>
								
								<div class="row form-row">

									<div class="col-md-6 col-sm-6">
                                        <label for="idDepartamento" class="form-label">Departamento <span class="txtrojo">*</span></label>
                                         <select tabindex="8" id="idDepartamento" class="form-control">
											<option value="">Seleccione una opción</option>
											<s:iterator value="listUbigeoDepartamento" var="var" status="varStatus">
												 <s:if test="%{#var.coddpto == personalQuery.coddptoDir}">
												 	<option value="<s:property value="#var.coddpto" />" selected="selected"><s:property value="#var.nombre" /></option>
												 </s:if>
												 <s:else>
												 <option value="<s:property value="#var.coddpto" />"><s:property value="#var.nombre" /></option>
												 </s:else>
												
											</s:iterator>

										</select>
										

									</div>
									
									<div class="col-md-6 col-sm-6">
										<label for="idProvincia" class="form-label">Provincia <span class="txtrojo">*</span></label>
										<select id="idProvincia" class="form-control"  
										onchange="obtenerDistritoUbigeo('#idDepartamento','#idProvincia','#idubigeo')"
										tabindex="9"
                						> 
										</select>

									</div>
									
								</div>

								<div class="row form-row">

									<div class="col-md-6 col-sm-6">
										<label for="idubigeo" class="form-label">Distrito <span class="txtrojo">*</span></label>
									    <select id="idubigeo" name="personal.idubigeo" class="form-control" 
										tabindex="10" 
                						>
										</select>

									</div>
									
									<div class="col-md-6 col-sm-6"> 
									   <label for="ruc" class="form-label">RUC</label>
									   <input id="ruc" name="personal.ruc" value="${personalQuery.ruc}" type="text" class="form-control" 
									   tabindex="11" onkeyup="validarRuc()"
									   >

									</div>

								</div>

								<div class="row form-row">
									<div class="col-md-12">
									   <label for="direccion" class="form-label">Dirección <span class="txtrojo">*</span></label>
									   <input id="direccion" name="personal.direccion" value="${personalQuery.direccion}" type="text" class="form-control" 
										tabindex="12"
                						>
									</div>
								</div>
								
								<div class="row form-row">
                                   
									
									<div class="col-md-2 col-sm-2" >
									<label for="var_codigo_ciudad_telefono" class="form-label">Cod. Ciudad</label>
										<input id="var_codigo_ciudad_telefono" name="personal.var_codigo_ciudad_telefono" value="${personalQuery.var_codigo_ciudad_telefono}" type="text" class="form-control" 
										tabindex="13"
                						>
									</div>
									<div class="col-md-4 col-sm-4">
									    <label for="var_telefono" class="form-label">Teléfono N°.</label>
									    <input id="var_telefono" name="personal.var_telefono" value="${personalQuery.var_telefono}" type="text" class="form-control" 
										tabindex="14"
                						>
									</div>
									
									<div class="col-md-6  col-sm-6">
									    <label for="var_celular" class="form-label">Celular N°.</label>
									    <input id="var_celular" name="personal.var_celular" value="${personalQuery.var_celular}" type="text" class="form-control" 
										tabindex="17"
                						>
									</div>
									
								
								</div>
								
								<div class="row form-row">
								
								
								<div class="col-md-2 col-sm-2" >
									<label for="var_codigo_ciudad_telefono2" class="form-label">Cod. Ciudad</label>
										<input id="var_codigo_ciudad_telefono2" name="personal.var_codigo_ciudad_telefono2" value="${personalQuery.var_codigo_ciudad_telefono2}" type="text" class="form-control" 
										tabindex="15"
                						>
									</div>
									<div class="col-md-4 col-sm-4">
									    <label for="var_telefono2" class="form-label">Teléfono N°.</label>
									    <input id="var_telefono2" name="personal.var_telefono2" value="${personalQuery.var_telefono2}" type="text" class="form-control" 
										tabindex="16"
                						>
									</div>
								
								
								<div class="col-md-6  col-sm-6">
									    <label for="var_celular2" class="form-label">Celular N°.</label>
									    <input id="var_celular2" name="personal.var_celular2" value="${personalQuery.var_celular2}" type="text" class="form-control" 
										tabindex="18"
                						>
									</div>
								</div>
								
								<div class="row form-row">
								
								
								<div class="col-md-2 col-sm-2" >
									<label for="var_codigo_ciudad_telefono3" class="form-label">Cod. Ciudad</label>
										<input id="var_codigo_ciudad_telefono3" name="personal.var_codigo_ciudad_telefono3" value="${personalQuery.var_codigo_ciudad_telefono3}" type="text" class="form-control" 
										tabindex="15"
                						>
									</div>
									<div class="col-md-4 col-sm-4">
									    <label for="var_telefono3" class="form-label">Teléfono N°.</label>
									    <input id="var_telefono3" name="personal.var_telefono3" value="${personalQuery.var_telefono3}" type="text" class="form-control" 
										tabindex="16"
                						>
									</div>
								
								
								<div class="col-md-6  col-sm-6">
									    <label for="var_celular3" class="form-label">Celular N°.</label>
									    <input id="var_celular3" name="personal.var_celular3" value="${personalQuery.var_celular3}" type="text" class="form-control" 
										tabindex="18"
                						>
									</div>
								</div>
								
								<div class="row form-row">

									<div class="col-md-12">
									   <label for="var_email_principal" class="form-label">Correo Electrónico</label>
									   <input id="var_email_principal" name="personal.var_email_principal" value="${personalQuery.var_email_principal}" type="text" class="form-control" 
									   tabindex="19"
						                >
									</div>

								 </div>
                               </div> <!-- fin bloque informacionBasica -->

								<h4 class="semi-bold">
									<span id="dos">1.</span> <span class="light">Lugar de</span> <span class="semi-bold">Nacimiento</span>
								</h4>
								


								<div class="row form-row">
									<div class="col-md-6 col-sm-6">
										<label for="idpais" class="form-label">Nacionalidad</label>
									   <s:select headerKey="" headerValue="Seleccione una opción"
 										list="listPais" listKey="idpais" listValue="nompais"  
 										name="personal.idpais" id="idpais"
 										cssClass="form-control" tabindex="20" onchange="habilitarDeshabilitarUbigeo()" 
										/>  
									</div>
									<div class="col-md-6 col-sm-6">
										<label for="idDepartamentoNacimiento" class="form-label">Departamento</label>
										 <select tabindex="21" id="idDepartamentoNacimiento" class="form-control">
											<option value="">Seleccione una opción</option>
											<s:iterator value="listUbigeoDepartamento" var="var" status="varStatus">
												 <s:if test="%{#var.coddpto == personalQuery.coddptoNac}">
												 	<option value="<s:property value="#var.coddpto" />" selected="selected"><s:property value="#var.nombre" /></option>
												 </s:if>
												 <s:else>
												 <option value="<s:property value="#var.coddpto" />"><s:property value="#var.nombre" /></option>
												 </s:else>
												
											</s:iterator>

										</select>
										
									    
									</div>


								</div>

								<div class="row form-row" id="algo">
									<div class="col-md-6 col-sm-6">
										<label for="idProvinciaNacimiento" class="form-label">Provincia</label>
									    <select id="idProvinciaNacimiento" name="idProvinciaNacimiento"  class="form-control" 
                                      	onchange="obtenerDistritoUbigeo('#idDepartamentoNacimiento','#idProvinciaNacimiento','#int_id_ubigeo_nacimiento')"
                                      	tabindex="22"
                						>
                                        </select>
									</div>
									<div class="col-md-6 col-sm-6">
										<label for="int_id_ubigeo_nacimiento" class="form-label">Distrito</label>
									    <select id="int_id_ubigeo_nacimiento" name="personal.int_id_ubigeo_nacimiento" class="form-control"
									    tabindex="23"
									    >
									    </select>
									</div>

								</div>
								
								<h4 class="semi-bold">
								 
									<span id="tres">2.</span> <span class="light">Información</span> <span class="semi-bold">Complementaria</span>
								</h4>
								
								<div class="row form-row">

									<div class="col-md-12">
									   <label for="correoinstitucional" class="form-label">Correo Institucional</label>
									   <input id="correoinstitucional" name="personal.mailpersonal" value="${personalQuery.mailpersonal}" type="text" class="form-control" 
									   tabindex="19" 
						                >
									</div>

								 </div>
								 
								<div class="row form-row">
								
									<div class="col-md-6 col-sm-6">
										
                                       <label for="idestadocivil" class="form-label">Estado Civil</label>
                                       <s:select headerKey="" headerValue="Seleccione una opción"
										list="listEstadoCivil" listKey="idtablatipo" listValue="destablatipo" name="personal.idestadocivil" id="idestadocivil"
										cssClass="form-control" tabindex="24" 
										/>
									   
									</div>
									
									<div class="col-md-6 col-sm-6">
									   <label for="var_numero_pasaporte" class="form-label">Pasaporte N°.</label>
									   <input id="var_numero_pasaporte" name="personal.var_numero_pasaporte" value="${personalQuery.var_numero_pasaporte}" type="text" class="form-control"
									   tabindex="25"
									   >
									</div>
								</div>
								
								<div class="row form-row">
								
									<div class="col-md-6 col-sm-6">
									   <label for="var_tarjeta_proximidad" class="form-label">Tarjeta de Proximidad</label>
									   <input id="var_tarjeta_proximidad" name="personal.var_tarjeta_proximidad" value="${personalQuery.var_tarjeta_proximidad}" type="text" class="form-control" 
									   tabindex="26"
                					   >
									</div>
								
									<div class="col-md-6 col-sm-6">
									   <label for="var_numero_brevete" class="form-label">Brevete N°.</label>
									   <input id="brevete" name="personal.var_numero_brevete" value="${personalQuery.var_numero_brevete}" type="text" class="form-control" 
									   tabindex="27"
									   >
									</div>
									
									
								</div>
								
								<div class="row form-row">
									<div class="col-md-6 col-sm-6">
										<label for="srl_id_regimen_contractual" class="form-label">Régimen Contractual</label>
										<s:select headerKey="" headerValue="Seleccione una opción"
 										list="listRegimenContractual" listKey="int_cod_regimen_contractual" listValue="var_descripcion_regimen_contractual"  
										name="personal.srl_id_regimen_contractual" id="srl_id_regimen_contractual" 
 										cssClass="form-control" tabindex="28" 
										/> 
										
									</div>

									<div class="col-md-6 col-sm-6">
										<label for="srl_id_regimen_pensionario" class="form-label">Régimen Pensionario</label>
										<s:select headerKey="" headerValue="Seleccione una opción"
 										list="listRegimenPensionario" listKey="int_cod_regimen_pensionario" listValue="var_descripcion_regimen_pensionario"  
 										name="personal.srl_id_regimen_pensionario" id="srl_id_regimen_pensionario" 
 										cssClass="form-control" tabindex="29" onchange="deshabilitarHabilitarAFP()"
 										disabled="disabled"
										/> 
									    
									</div>

								</div>
								
								<div class="row form-row">
								
									<div class="col-md-4 col-sm-4">
									   <label for="var_nombre_afp" class="form-label">Nombre AFP</label>
									   <input id="var_nombre_afp" name="personal.var_nombre_afp" value="${personalQuery.descrip_nombre_afp}"  type="text" class="form-control" 
									   tabindex="30"
									   >
									</div>
								
									<div class="col-md-4 col-sm-4">
									   <label for="var_codigo_afiliacion" class="form-label">Código de Afiliación</label>
									   <input id="var_codigo_afiliacion" name="personal.var_codigo_afiliacion" value="${personalQuery.var_codigo_afiliacion}"  type="text" class="form-control" 
									   tabindex="31"
									   >
									</div>
									
									<div class="col-md-4 col-sm-4">
									   <label for="dte_fecha_afiliacion" class="form-label">Fecha de Afiliación</label>
									   <input id="dte_fecha_afiliacion" name="personal.dte_fecha_afiliacion" value="${personalQuery.dte_fecha_afiliacion}"  type="text" class="form-control" 
									   tabindex="32"
									   >
									</div>
									
								</div>
								
								<div class="row form-row">
									<div class="col-md-6 col-sm-6">
										
                                       <label for="srl_id_entidad_bancaria" class="form-label">Entidad Bancaria</label>
                                       <s:select headerKey="" headerValue="Seleccione una opción"
 										list="listEntidadBancaria" listKey="srl_id_entidad_bancaria" listValue="var_desc_entidad_bancaria"  
 										name="personal.srl_id_entidad_bancaria" id="srl_id_entidad_bancaria" 
 										cssClass="form-control" tabindex="33"
 										disabled="disabled"
										/> 
									   										
										<button class="btn btn-primary btn-sm" type="button" id="btnAgregarEntidadBancaria" onclick="$('#modalRegistrarEntidadBancaria').modal('toggle');"> 
										<i class="fa fa-plus-circle"></i> Agregar Entidad Bancaria
										</button>
									
								</div>

									<div class="col-md-6 col-sm-6">
										<label for="var_numero_cuenta_bancaria" class="form-label">Número de Cuenta</label>
									    <input id="var_numero_cuenta_bancaria" name="personal.var_numero_cuenta_bancaria" value="${personalQuery.var_numero_cuenta_bancaria}" type="text" class="form-control" 
									    tabindex="34"
									    disabled="disabled"
                						>
									</div>

								</div>
								
							  		

							</div>
<!-- 					 </form> -->
					 
					 
							<div id="columna-2" class="col-md-6">
							
							    <h4 class="semi-bold">
								        
										<span id="cuatro">3.</span> <span class="light">Información del </span> <span
											class="semi-bold">Expediente</span>
								</h4>
							
							
								<div class="row form-row">
								        <div class="col-md-3 col-sm-3">
											<label for="var_num_caja" class="form-label">Número de Caja</label>
										    <input id="var_num_caja" name="personal.var_num_caja" value="${personalQuery.var_num_caja}"  type="text" class="form-control" 
											tabindex="35"
	                						>
										</div>
										<div class="col-md-3 col-sm-3">
											<label for="var_num_file" class="form-label">Número de File</label>
										    <input id="var_num_file" name="personal.var_num_file" value="${personalQuery.var_num_file}" type="text" class="form-control" 
											tabindex="36"
	                						>
										</div>
										
									
									
									
								</div>
							</div>
								
						</form>
								
						<div id="columna-2" class="col-md-6">		
								<div class="alert alert-success">
<!--     							<a href="#" class="close" data-dismiss="alert">&times;</a> -->
    							
									<div id="formacion_academica" class="table-responsive">
										<table id="tabla_formacion_academica" class="table table-bordered table-hover">
										        <thead>
										          <tr>
										            <th>Grupo Ocupacional</th>
										            <th>Nivel de Estudio</th>
										            <th>Tipo de Profesión</th>
										            <th>Profesion</th>
										            <th>Nombre Universidad</th>
										            <th>Ubicación Universidad</th>
										            <th>F. de Ingreso</th>
										            <th>F. de Culminación</th>
										            <th>En Curso</th>
										            <th colspan="2"></th>
										          </tr>
										        </thead>

										</table>
								   </div>	
								</div>
								
								
								<h4 class="semi-bold">
								
										<span id="cinco">4.</span> <span class="light">Formacion </span> <span
											class="semi-bold">Académica</span>
								</h4>
								
								<div id="bloque_formacion">
								
								<form id="formFormacionAcademica" name="formFormacionAcademica" >
								
								   <div class="row form-row">
								        <div class="col-lg-6 col-md-6 col-sm-6">
										    <label for="srl_id_grupo_ocupacional" class="form-label">Grupo Ocupacional</label>
										    <s:select headerKey="" headerValue="Seleccione una opción"
 											list="listGrupoOcupacional" listKey="int_cod_grupo_ocupacional" listValue="var_desc_grupo_ocupacional"  
 											id="srl_id_grupo_ocupacional" name="srl_id_grupo_ocupacional" 
 											cssClass="form-control" tabindex="37"
 											
											/> 
										   
										</div>
										<div class="col-lg-6 col-md-6 col-sm-6">
										    <label for="srl_id_nivel_estudio" class="form-label">Nivel de Estudio </label>
										    <s:select headerKey="" headerValue="Seleccione una opción"
 											list="listNivelEstudio" listKey="var_cod_nivel_estudio" listValue="var_descripcion_nivel_estudio"  
 											id="srl_id_nivel_estudio" name="srl_id_nivel_estudio" onchange="habilitarDeshabilitarTipoProfesion()"
 											cssClass="form-control" tabindex="38"
											/>
											
										</div>
										
										
									
									</div>
									
									<div class="row form-row">
																		
										<div class="col-lg-6 col-md-6 col-sm-6">
										    <label for="srl_id_tipo_profesion" class="form-label">Tipo de Profesion </label>
										    <s:select headerKey="0" headerValue="Seleccione una opción"
 											list="listTipoProfesion" listKey="int_cod_tipo_profesion" listValue="var_descripcion_tipo_profesion"  
 											id="srl_id_tipo_profesion" name="srl_id_tipo_profesion"  onchange="obtenerProfesion('#srl_id_tipo_profesion','#srl_id_profesion')"
 											cssClass="form-control" tabindex="39"
											/>
										  
										</div>
										
									  <div class="col-lg-6 col-md-6 col-sm-6">
										    <label for="srl_id_profesion" class="form-label">Profesion </label>
										    <select id="srl_id_profesion" name="srl_id_profesion" class="form-control" tabindex="40">
												<option value="">Seleccione una opción</option>
										    </select>
										</div>
										
									
									</div>
									
									<div class="row form-row">
																		
										<div class="col-lg-6 col-md-6 col-sm-6">
										    <label for="idpaisUniversidad" class="form-label">Ubicación <span id="descripcion_lugar_estudios1">de la Universidad </span></label>
										    <s:select headerKey="" headerValue="Seleccione una opción"
 											list="listPais" listKey="idpais" listValue="nompais"  
 											id="idpaisUniversidad" cssClass="form-control" tabindex="41"/> 
										   
										</div>
										
										<div class="col-lg-6 col-md-6 col-sm-6">
										    <label for="var_descripcion_institucion" class="form-label">Nombre <span id="descripcion_lugar_estudios2">de la Universidad</span></label>
										    <input id="var_descripcion_institucion"  type="text" class="form-control"  
											tabindex="42"
	                						>
											
										</div>
									</div>
										
									<div class="row form-row">
								        <div class="col-md-6 col-sm-6">
										<label for="fecha_ingreso" class="form-label">Fecha de Ingreso</label>
									    <input id="fecha_ingreso" type="text" class="form-control" 
									    placeholder="dd/mm/yyyy" 
										tabindex="43"
                						>
									</div>
									
									<div class="col-md-3 col-sm-3">	
										<label for="fecha_culminacion" class="form-label">Fecha de Culminación</label>
									    <input id="fecha_culminacion" type="text" class="form-control" placeholder="dd/mm/yyyy" tabindex="44">
									</div>
									
									<div class="col-md-3 col-sm-3">
											<label for="int_sigue_estudios" class="form-label">En Curso? </label>
											<select id="int_sigue_estudios" class="form-control" tabindex="40">
												<option value="">Seleccione una opción</option>
												<option value="1">Si</option>
												<option value="2">No</option>
												
										    </select>
									 </div>		
								</div>
								
								<div class="row form-row">
								  <div class="col-md-12 col-sm-12">
									<button id="btnAgregarEstudio" name="btnAgregarEstudio" class="btn btn-primary btn-sm" type="button"><!--   onclick="agregarEstudio()" > -->
											<i class="fa fa-plus-circle"></i> Añadir estudio
									</button>
								  </div>	
								</div>	
								
							</form>		 
							</div>
													
							</div>
						</div>
					
						<div class="form-actions">
							<div class="pull-left"> 
							  <p class="kbd hide"><kbd>Alt</kbd>+<kbd>g</kbd></p>
								<button class="btn btn-info " type="button" id="btnGrabar" tabindex="50">
									<i class="fa fa-save"></i> Grabar
								</button>
								
							</div>
						</div>
<!-- 					</form> -->
				</div>
				<!--end grid-body -->

			</div>
			<!-- end grid simple -->
		</div>
		<!-- end row -->
	</div>
	<!-- end page-content -->
	
	<!-- END PAGE -->
	
	

<!-- Modal -->
<div id="modalRegistrarEntidadBancaria" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Registrar Entidad Bancaria</h4>
      </div>
      <div class="modal-body">
       
       <div class="page-container row">
  
  	   <div class="row-fluid">
        <div class="span12">
 
        
          <div class="grid simple">
        	
        	              
        <div class="grid-body no-border" style="overflow: hidden; display: block;">
		
			<form class="form-no-horizontal-spacing" novalidate="novalidate" name="formRegistrarEntidadBancaria" id="formRegistrarEntidadBancaria">	
              <div class="row">
                <div class="col-md-12">
                                                                               
                   <div class="row form-row">
                      
                      <div class="col-lg-12 col-md-12 col-sm-12">
                        <label for="nombreEntidadBancaria" class="form-label">Nombre de la entidad bancaria</label>
                        <input type="text" class="form-control" id="nombreEntidadBancaria" name="nombreEntidadBancaria">
                      </div>
                     
                   </div> 

                </div>
               
              </div>

			</form>

</div>  

          </div><!-- end grid simple -->
        </div><!-- end span12 -->
      </div>
  
  
</div>  
 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="btnRegistrarEntidadBancaria">Registrar</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

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
        <button type="button" class="btn btn-primary" onclick="grabarFormulario()">Si</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="modalError" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Advertencia</h4>
      </div>
      <div class="modal-body">
      		<br/>
     		<div class="alert alert-danger" role="alert">
     		
     		Han ocurrido errores de validación
     		
     		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Aceptar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div id="modalContrato" class="modal modal-wide" data-keyboard="false" data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Contratos y Adendas</h4>
      </div>
      <div class="modal-body">
       
							<h4 class="semi-bold">
									<span class="light">Listado de</span> 
									<span class="semi-bold">Contratos</span>
							 </h4>
							
							<br>
                      <div >
						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered" id="tableDefault">

							<thead>
								<tr>
									<th data-class="expand">Número Contrato</th>
									<th data-class="expand">Régimen Contractual</th>
									<th data-class="expand">F. Suscripción</th>
									<th data-class="expand">F. Inicio</th>
									<th data-class="expand">F. Término</th>
									<th data-class="expand">F. Cese</th>
									<th data-class="expand">Estado</th>
									<th data-class="expand">Cargo</th>	
									<th>Opcion</th>
								</tr>
							</thead>

						</table>
                      </div>
                <div id="adendas"></div>

				<div id="bloque_tabla_adendas" style="display: none;">
							<h4 class="semi-bold">
									<span class="light">Listado de</span> 
									<span class="semi-bold">Adendas</span>
							 </h4>
							
							<br>
                    	<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered" id="tableAdenda">

							<thead>
								<tr>
									<th data-class="expand">Número Adenda</th>
									<th data-class="expand">Número Contrato</th>
									<th data-class="expand">F. Suscripción</th>
									<th data-class="expand">F. Inicio</th>
									<th data-class="expand">F. Término</th>
									<th data-class="expand">F. Cese</th>
									<th data-class="expand">Estado</th>
								</tr>
							</thead>

						</table>
						
</div>
 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<s:form action="" name="form" id="form" namespace="/">
	<s:hidden name="idPersonaNatural" id="idPersonaNatural"/>
	<s:hidden name="idPersonal" id="idPersonal"/>
</s:form>

