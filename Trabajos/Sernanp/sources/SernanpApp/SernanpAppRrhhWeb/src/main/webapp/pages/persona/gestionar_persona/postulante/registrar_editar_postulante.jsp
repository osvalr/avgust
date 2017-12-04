<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content">
      <div class="row">
		<div class="page-title">
		<!-- 		cambio alanmar 14:02pm -->
				<h3>
					Gestionar <span class="semi-bold">Postulantes Seleccionados</span> (
					<span id="tituloRegistrar">Registrar</span> / 
	              <span id="tituloEditar"> Editar</span> /
	              <span id="tituloConsultar"> Consultar</span>)
				</h3>
		</div>

	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Gestionar Postulantes Seleccionados (Registrar / Editar / Consultar)</li>
<!-- 	end	cambio alanmar 14:02pm -->	      
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">
            
				<div class="grid-title">
				  <div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				  		
			
					     
					   						 
							<div class="grid-botonera" id="bloque_btn_registrar_postulante" style="float: left;">
							 <p class="kbd hide"><kbd>Alt</kbd>+<kbd>P</kbd></p>

								<button class="btn btn-primary" type="button" onclick="mostrarFormRegistroPostulante()">
									<i class="fa fa-plus-circle"></i> Agregar Nuevo Postulante
									</button>
					        </div>
					        
					        <!-- 		cambio alanmar 14:02pm -->  
					        <div class="grid-botonera" id="btnVolverListado" style="float: left;">
							 
								<p class="kbd hide"><kbd>Alt</kbd>+<kbd>V</kbd></p>
								<button class="btn btn-default" type="button" onclick="mostrarListadoPostulante()">
									<i class="fa fa-reply"> </i> Volver
									</button>
					        </div>
					     <!-- 	end	cambio alanmar 14:02pm --> 
					        
					      <div class="grid-botonera hide" id="bloque_btn_agregar_convocatoria" style="float: left;">
							<p class="kbd hide"><kbd>Alt</kbd>+<kbd>C</kbd></p>
							
						     	<button class="btn btn-primary" type="button" onclick="$('#modalRegistrarConvocatoria').modal('toggle');">
									<i class="fa fa-plus-circle"></i> Agregar Convocatoria
								</button>
								
						  </div>	
					        
  			        
					        <div class="grid-botonera hide" id="bloque_btn_impresion_info" style="float: left;">
							 
								<p class="kbd hide"><kbd>Alt</kbd>+<kbd>V</kbd></p>
								<button class="btn btn-default" type="button" id="btnImprimirForm">
									<i class="fa fa-print"> </i> Imprimir
								</button>
								
					        </div>
					        
					     </div>
							
				   </div>
            
                 </div>
                 
				
				<!-- LISTADO DE POSTULANTES -->
			
		
			  <div id="bloque-convocatoriaListado">
			  
				<div class="grid-body no-border">
					<form class="" method="POST" id="frmListarPostulante" novalidate="novalidate">
						<div class="row ">
							<div class="col-lg-12">
							
							<h4 class="semi-bold">
									1. <span class="light">Listado de</span> <span
										class="semi-bold">Postulantes</span>
										<br>
							 </h4>
							
							<div class="row form-row">
							
										<div class="col-lg-2 col-md-2 col-sm-2">
										    <label for="criteriaResumen_srl_id_convocatoria" class="form-label">Nº de Convocatoria</label>
										    <select id="criteriaResumen_srl_id_convocatoria" class=" form-control " tabindex="1">
										    </select>
										</div>
										
										<div class="col-lg-2 col-md-2 col-sm-2">
										    <label for="criteriaResumen_srl_id_conv_area_org" class="form-label">Código de Postulación</label>
										    <select id="criteriaResumen_srl_id_conv_area_org" class=" form-control " tabindex="2">
											<option value="">Seleccione una opción</option>
										    </select>
										</div>
										
										<div class="col-lg-2 col-md-2 col-sm-2">
		                   				    <label for="criteriaResumen_nombres" class="form-label">Nombres o Apellidos</label>
					                        <input type="text" class="form-control" id="criteriaResumen_nombres" tabindex="3">
				                        </div>
				                        
<!-- 				                        <div class="col-lg-3 col-md-6 col-sm-6"> -->
<!-- 		                   				    <label for="criteriaResumen_numeroRuc" class="form-label">RUC</label> -->
<!-- 					                        <input type="text" class="form-control" id="criteriaResumen_numeroRuc" tabindex="3"> -->
<!-- 				                        </div> -->
						          
<!-- 			                  </div> -->
			                  
<!-- 			                  <div class="row form-row"> -->
			                          
                                    <div class="col-lg-2 col-md-2 col-sm-2">
				                        <label for="criteriaResumen_tipoDoc" class="form-label">Tipo de Documento</label>
				                        <select id="criteriaResumen_tipoDoc" class="form-control" tabindex="4">
				                        <option value="">Seleccione una opción</option>
										<option value="1" selected="selected">DNI</option>
				                        </select>
				                    </div>
				                      
				                      <div class="col-lg-2 col-md-2 col-sm-2">
				                       <label for="criteriaResumen_numerodoc" class="form-label">Nº Documento</label>
				                        <input type="text" class="form-control" id="criteriaResumen_numerodoc" tabindex="5">
				                      </div>
				                      
				                    <div class="col-lg-2 col-md-2 col-sm-2">
				                        <label for="criteriaResumen_int_id_estado" class="form-label">Estado</label>
				                        <select id="criteriaResumen_int_id_estado" class="form-control" tabindex="6" onchange="iniciarFiltro();">
										<option value="1,2,0">Seleccione una opción</option>
										<option value="1">Registrado</option>
										<option value="2">Ganador</option>
										<option value="3">Contrato suscrito</option>
										<option value="4">Anulado</option>
										<option value="5">Descartado</option>
										<option value="6">Contrato no suscrito</option>
				                        </select>
				                    </div>
				                      		    
				               </div> 
			                   
			              
                   
					   </div>
					</div>
  							<div class="row form-row">
			                   
			                   <div class="col-lg-12" >
			                  
			                      <div class="botonera">
							    	 <p class="kbd hide"><kbd>Alt</kbd>+<kbd>T</kbd></p>
									<button class="btn btn-primary" type="button" onclick="iniciarFiltro('json')" tabindex="7"><i class="fa fa-filter"></i> Filtrar </button>
							      </div>
							      <div class="botonera">
							       <p class="kbd hide"><kbd>Alt</kbd>+<kbd>L</kbd></p>
									<button class="btn btn-default" type="reset" tabindex="8"><i class="fa fa-file-o"></i> Limpiar </button>
						          </div>
						          <div class="botonera">
							       <p class="kbd hide"><kbd>Alt</kbd>+<kbd>P</kbd></p>
									<button class="btn btn-default" type="button" tabindex="9" id="btnImprimirLista"><i class="fa fa-print"></i> Imprimir</button>
						          </div>
							   </div>
							   
		                    </div> 
							
				 </form>
				</div>
				<!--end grid-body -->
				

			

			<div class="grid-body no-border">      
             	<br>
 			<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableDefault" >
               
                <thead>     
                  <tr>
                    <th data-hide="phone,tablet">T.Doc</th>
                    <th data-hide="phone">Nº Doc</th>
                    <th data-class="expand">Nombres</th>
                    <th data-hide="phone,tablet">Ruc</th>
                    <th data-hide="phone,tablet">Genero</th>
                    <th data-hide="phone">Nº Convocatoria</th>
                    <th data-hide="phone">C.Postulacion</th>
                    <th data-hide="phone">Nº Lanzamiento</th>
                    <th>Estado</th>
                    <th data-hide="phone,tablet">Área Organica</th>
                    <th data-hide="phone,tablet">Unidad Operativa</th>
                    <th data-hide="phone,tablet">F.Registro</th>
                    <th colspan="2">Opciones</th>
                  </tr>
                </thead>
       
                <tfoot>     
                 <tr>
                    <th>T.Doc</th>
                    <th>Nº Doc</th>
                    <th>Nombres</th>
                    <th>Ruc</th>
                    <th>Genero</th>
                    <th>Nº Convocatoria</th>
                    <th>C.Postulacion</th>
                    <th>Nº Lanzamiento</th>
                    <th>Estado</th>
                    <th>Área Organica</th>
                    <th>Unidad Operativa</th>
                    <th>F.Registro</th>
                    <th colspan="2">Opciones</th>
                  </tr>
                </tfoot>
                
           </table>
                      
            <br>
         
            </div>
                
		  </div>		
				<!-- END LISTADO DE POSTULANTES -->
				
				
				
<!--                 REGISTRO DE POSTULANTES  -->
                  
				<div id="bloque-convocatoriaFormulario" class="grid-body no-border hide">
					<form class="form-horizontal" method="POST" id="frmRegistrarPostulante">
					<input type="hidden" name="postulante.idpersona" id="idpersona" />
					<input type="hidden" name="postulante.idpersonanatural" id="idpersonanatural" />
					<input type="hidden" name="postulante.int_id_postulante" id="int_id_postulante" />
					<input type="hidden" name="postulante.srl_id_postulante_conv_area_org" id="srl_id_postulante_conv_area_org" />
					<input type="hidden" name="estado_personal" id="estado_personal" />
					<input type="hidden" name="op" id="op" value="insert" />
					
					<input type="hidden" name="estado_validacion_email" id="estado_validacion_email" value="" />
<!-- 					<input type="hidden" name="estado_validacion_ruc" id="estado_validacion_ruc" value="" /> -->
<!-- 					<input type="hidden" name="estado_validacion_dni" id="estado_validacion_dni" value="" /> -->
						
						
						<div id="bloque_busqueda_basica">

									<h4 class="semi-bold">
												<i class="fa fa-search"></i><span class="light"> Búsqueda</span> 
												   <span class="semi-bold">Básica</span>
									</h4>
								  <div class="row form-row resaltado">
									<br>
											<div class="col-lg-2 col-md-3 col-sm-6">
			
												<select id="tipoDoc_bus" name="tipoDoc_bus" class="form-control" tabindex="-1">
												<option value="">Seleccione una opción </option>
												<option value="1">DNI</option>
												<option value="2">RUC</option>
												</select>
			
											</div>
											<div class="col-lg-2 col-md-3 col-sm-6">
				 								<input id="numeroDoc_bus" name="numeroDoc_bus" type="text" class="form-control" placeholder="Nº de documento" disabled="disabled">
											</div>
			
											<div class="col-lg-2 col-md-3 col-sm-6">
												<input id="numero_ruc_bus" name="numero_ruc_bus" type="text" class="form-control" placeholder="Nº RUC" disabled="disabled">
											</div>
											
											<div class="col-lg-1 col-md-2 col-sm-3 col-sx-2">
											
											<button id="btnBusquedaBasica" class="btn btn-primary" type="button">
												<i class="fa fa-search"></i> Buscar
											</button>
											
											</div>	
								          
					              </div>
			              </div>
			              
			              <div id="bloque_editar_postulante" class="hide">

<!-- 									<h4 class="semi-bold"> -->
<%-- 												<i class="fa fa-search"></i><span class="light"> Búsqueda</span>  --%>
<%-- 												   <span class="semi-bold">Básica</span> --%>
<!-- 									</h4> -->
								  <div class="row form-row ">
									<br>
											
											<div class="col-lg-1 col-md-2 col-sm-3 col-sx-2">
											
											<button id="btnEditarPostulante" class="btn btn-default" type="button">
												<i class="fa fa-edit"></i> Editar Postulante
											</button>
											
											</div>	
								          
					              </div>
			              </div>
			              
							<div class="row" id="bloque_impresion_info_postulante">		
							<br>		  
							<div id="columna-1" class="col-md-6">
								
							<h4 class="semi-bold">
									1. <span class="light">Información de</span> <span
										class="semi-bold">Convocatorias</span>
							 </h4>
								
							<div class="row form-row">
								<div class="col-md-4 col-sm-4">
											    <label for="srl_id_convocatoria" class="form-label">Nº de Convocatoria <span class="txtrojo">*</span></label>
											    <select id="srl_id_convocatoria" name="postulante.srl_id_convocatoria" class=" form-control " tabindex="9" onchange="obtenerCodigosPostulacion('#srl_id_conv_area_org','#srl_id_convocatoria')">
											    </select>
								</div>
											
								<div class="col-md-4 col-sm-4">
											    <label for="srl_id_conv_area_org" class="form-label">Código de Postulación <span class="txtrojo">*</span></label>
											    <select id="srl_id_conv_area_org" name="postulante.srl_id_conv_area_org" class=" form-control " tabindex="10">
												<option value="">Seleccione una opción</option>
											    </select>
								</div>
								
								<div class="col-md-4 col-sm-4">
										    
										    <label for="int_num_activacion" class="form-label">Nº Lanzamiento</label>
	                																    
										    <input id="int_num_activacion" name="postulante.int_num_activacion" type="text" class="form-control" tabindex="11" value="1">
	                						
								</div>
										
							</div>
							
								<div class="row form-row" id="bloque_info_vacantes">
                                   
									
									<div class="col-md-4 col-sm-6" >
									<label for="cantidad_vacantes" class="form-label">Vacantes</label>
										<input id="cantidad_vacantes" name="cantidad_vacantes" type="text" class="form-control" readonly="readonly">
									</div>
									<div class="col-md-4 col-sm-6">
									    <label for="cantidad_registrados" class="form-label">Registrados</label>
									    <input id="cantidad_registrados" name="cantidad_registrados" type="text" class="form-control" readonly="readonly">
									</div>

									<div class="col-md-4  col-sm-6">
									    <label for="cantidad_disponibles" class="form-label">Disponibles</label>
									    <input id="cantidad_disponibles" name="cantidad_disponibles" type="text" class="form-control" readonly="readonly">
									</div>

								</div>					
								
							<h4 class="semi-bold">
									2. <span class="light">Información</span> <span
										class="semi-bold">Personal</span>
							 </h4>
                               
								<div class="row form-row">
									<div class="col-lg-12 col-md-12">
									   <label for="nombre" class="form-label">Nombres <span class="txtrojo">*</span></label>
									   
										<input id="nombre" name="postulante.nombre" type="text" class="form-control" tabindex="12" >
									</div>
									<div class="col-md-6 col-sm-6">
									   <label for="apepat"  class="form-label">Apellido Paterno <span class="txtrojo">*</span></label>
									   <input id="apepat" name="postulante.apepat" type="text" class="form-control" tabindex="13">
									</div>
									<div class="col-md-6 col-sm-6">
									   <label for="apemat" class="form-label">Apellido Materno <span class="txtrojo">*</span></label>
									   <input id="apemat" name="postulante.apemat" type="text" class="form-control" tabindex="14">
									</div>
									
								</div>

								<div class="row form-row">
									<div class="col-md-6 col-sm-6">
									   <label for="idsexo" class="form-label">Sexo <span class="txtrojo">*</span></label>
									    <select id="idsexo" name="postulante.idsexo" class="form-control" tabindex="14">
										</select>
									</div>
									<div class="col-md-6 col-sm-6">
									   <label for="fechanacimiento" class="form-label">Fecha de Nacimiento <span class="txtrojo">*</span></label>
									   <input id="fechanacimiento" name="postulante.fechanacimiento" type="text" class="form-control" tabindex="16">

        					
									</div>

								</div>
								
								<div class="row form-row">
									
									<div class="col-md-6 col-sm-6">
									   <label for="idtipodocumento" class="form-label">Tipo de Documento <span class="txtrojo">*</span></label>
									   <select id="idtipodocumento" name="postulante.idtipodocumento" class="form-control" tabindex="17">
										</select>
									</div>
									<div class="col-md-6 col-sm-6">
									   <label for="numerodoc" class="form-label">Nº de Documento <span class="txtrojo">*</span></label>
									   <input id="numerodoc" name="postulante.numerodoc"  type="text" class="form-control" tabindex="18" onkeyup="validarDni()">
									</div>

								</div>
								
								<div class="row form-row">

									
									<div class="col-md-6 col-sm-6">
                                        <label for="idDepartamento" class="form-label">Departamento <span class="txtrojo">*</span></label>
									    <select id="idDepartamento" name="idDepartamento" class="form-control " tabindex="19" 
										onchange="obtenerProvinciaUbigeo('#idDepartamento','#idProvincia','#idubigeo')">
										</select>

									</div>
									
									<div class="col-md-6 col-sm-6">
										<label for="idProvincia" class="form-label">Provincia <span class="txtrojo">*</span></label>
									    <select id="idProvincia" name="idProvincia" class=" form-control -offscreen" tabindex="20" 
										onchange="obtenerDistritoUbigeo('#idDepartamento','#idProvincia','#idubigeo')">
										</select>

									</div>
									
								</div>

								<div class="row form-row">

									<div class="col-md-6 col-sm-6">
										<label for="idubigeo" class="form-label">Distrito <span class="txtrojo">*</span></label>
									    <select id="idubigeo" name="postulante.idubigeo" class=" form-control -offscreen" tabindex="21">
									    
										</select>

									</div>
									
									<div class="col-md-6 col-sm-6">
									   <label for="ruc" class="form-label">RUC <span class="txtrojo">*</span></label>
									   <input id="ruc" name="postulante.ruc"  type="text" class="form-control" tabindex="22" onkeyup="validarRuc()">
									</div>

								</div>

								<div class="row form-row">
									<div class="col-md-12">
									   <label for="direccion" class="form-label">Dirección <span class="txtrojo">*</span></label>
									   <input id="direccion" name="postulante.direccion" type="text" class="form-control" tabindex="23">
									</div>
								</div>
								
								<div class="row form-row">
                                   
									
									<div class="col-md-4 col-sm-6" >
									<label for="var_codigo_ciudad_telefono" class="form-label">Cod. Ciudad</label>
										<input id="var_codigo_ciudad_telefono" name="postulante.var_codigo_ciudad_telefono" type="text" class="form-control" tabindex="24">
									</div>
									<div class="col-md-4 col-sm-6">
									    <label for="var_telefono" class="form-label">Teléfono</label>
									    <input id="var_telefono" name="postulante.var_telefono" type="text" class="form-control" tabindex="25">
									</div>

									<div class="col-md-4  col-sm-6">
									    <label for="var_celular" class="form-label">Celular</label>
									    <input id="var_celular" name="postulante.var_celular" type="text" class="form-control" tabindex="26">
									</div>

								</div>
								
								<div class="row form-row">
                                   
									
									<div class="col-md-4 col-sm-6" >
									<label for="var_codigo_ciudad_telefono2" class="form-label">Cod. Ciudad</label>
										<input id="var_codigo_ciudad_telefono2" name="postulante.var_codigo_ciudad_telefono2" type="text" class="form-control" tabindex="27">
									</div>
									<div class="col-md-4 col-sm-6">
									    <label for="var_telefono2" class="form-label">Teléfono</label>
									    <input id="var_telefono2" name="postulante.var_telefono2" type="text" class="form-control" tabindex="28">
									</div>

									<div class="col-md-4  col-sm-6">
									    <label for="var_celular2" class="form-label">Celular</label>
									    <input id="var_celular2" name="postulante.var_celular2" type="text" class="form-control" tabindex="29">
									</div>

								</div>
								
								<div class="row form-row">
                                   
									
									<div class="col-md-4 col-sm-6" >
									<label for="var_codigo_ciudad_telefono3" class="form-label">Cod. Ciudad</label>
										<input id="var_codigo_ciudad_telefono3" name="postulante.var_codigo_ciudad_telefono3" type="text" class="form-control" tabindex="30">
									</div>
									<div class="col-md-4 col-sm-6">
									    <label for="var_telefono3" class="form-label">Teléfono</label>
									    <input id="var_telefono3" name="postulante.var_telefono3" type="text" class="form-control" tabindex="31">
									</div>

									<div class="col-md-4  col-sm-6">
									    <label for="var_celular3" class="form-label">Celular</label>
									    <input id="var_celular3" name="postulante.var_celular3" type="text" class="form-control" tabindex="32">
									</div>

								</div>
								
								<div class="row form-row">

									<div class="col-md-12">
									   <label for="var_email_principal" class="form-label">Correo Electrónico</label>
									   <input style="text-transform: lowercase;" id="var_email_principal" name="postulante.var_email_principal" type="text" class="form-control" tabindex="33" onkeyup="validarCorreo()">
									</div>

								</div>
			

							</div>

							<div id="columna-2" class="col-md-6">

							
								
									
									<h4 class="semi-bold">
									   	3. <span class="light">Información de</span> <span
											class="semi-bold">Postulación</span>
											<br> 
									</h4>
							<div id="bloque_convocatorias">	
							
									<div class="row form-row">
										<div class="col-md-6 col-sm-6">
										    <label for="int_id_estado" class="form-label">Estado</label>
										    <select id="int_id_estado" name="postulante.int_id_estado" class=" form-control " tabindex="34" disabled="disabled">
										    <option value="2">GANADOR</option>
										    <option value="6">CONTRATO NO SUSCRITO</option>
										    <option value="4">ANULADO</option>
										    </select>
										</div>
									
									
									<div class="col-md-6 col-sm-6">
										    
										    <label for="int_orden_merito" class="form-label">Orden de Mérito</label>
										    <input id="int_orden_merito" name="postulante.int_orden_merito" type="text" class="form-control" tabindex="35" value="1">
	                						
										</div>
										
										
										
								</div>
						         
							</div>
							
							<div id="bloque_tabla_reg_conv" class="table-responsive hide">
								<table id="tabla_reg_conv" class="table table-striped table-bordered">
								        <thead>
								          <tr>
								            <th>Nº de Convocatoria</th>
								            <th>Código Postulación</th>
								            <th>Nº Lanzamiento</th>
								            <th>Área Organica</th>
								            <th>Unidad Operativa</th>
								            <th>Orden Mérito</th>
								            <th>Estado</th>
								            <th>Fecha Registro</th>
								          </tr>
								        </thead>
								        <tbody>

								        </tbody>
								      </table>
							</div>
							
							</div>
							
						</div>
                        <br><p><span class="txtrojo">* Datos Obligatorios</span></p>
						<div class="form-actions" id="bloque_botones_form_reg_postulante">
							<div class="pull-left"> 
							
							<div class="botonera">
							   <p class="kbd hide"><kbd>Alt</kbd>+<kbd>G</kbd></p>
								<button class="btn btn-primary" type="button" id="btnRegistrarPostulante" tabindex="29"><i class="fa fa-save"></i> Grabar</button>
							</div>
							
							<div class="botonera">
							 <p class="kbd hide"><kbd>Alt</kbd>+<kbd>N</kbd></p>	
							  <button class="btn btn-danger" type="button" id="btnCancelar" tabindex="30" onclick="mostrarListadoPostulante();">
							  <i class="fa fa-times-circle"></i> Cancelar</button>
							 </div> 
							 
							<div class="botonera">
							<p class="kbd hide"><kbd>Alt</kbd>+<kbd>L</kbd></p>
							 <button class="btn btn-default" type="button" id="btnLimpiarForm" tabindex="31"><i class="fa fa-file-o"></i> Limpiar Campos</button>
							</div>	
								
								
							</div>
						</div>
					</form>
				</div>
				<!--end grid-body -->
				
<!-- 				END REGISTRO DE POSTULANTES -->

			</div>
			<!-- end grid simple -->
		</div>
		<!-- end row -->
	</div>
	<!-- end page-content -->
	
	<!-- END PAGE -->

<!-- Modal -->
<div id="modalRegistrarConvocatoria" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title"> Registrar Convocatoria / Código Postulación </h4>
      </div>
      <div class="modal-body">
       
       <div class="page-container row">
  
  	   <div class="row-fluid">
        <div class="span12">
 
        
          <div class="grid simple">
        	
        	              
        <div class="grid-body no-border" style="overflow: hidden; display: block;">
		
			<form class="form-no-horizontal-spacing" id="formRegistrarConvocatoria" novalidate="novalidate" name="formRegistrarConvocatoria" >	
              <div class="row">
                <div class="col-md-12">
                                                                               
                   <div class="row form-row">
                    
                    <div class="col-lg-6 col-md-12 col-sm-6">
                        <label for="idConvocatoria_reg" class="form-label">Nº Convocatoria</label>
                        <select id="idConvocatoria_reg" name="idConvocatoria_reg" class="form-control" tabindex="32" onclick="checkNuevaConvocatoria()">
                        </select>
                        
                       
                      </div>
                      
                      <div id="bloque_num_cnv_generado" class="col-lg-6 col-md-12 col-sm-6 hide">
                       <label for="numeroConvocatoria_reg" class="form-label">Numero generado</label>
                       <input type="text" class="form-control" id="numeroConvocatoria_reg" name="numeroConvocatoria_reg">
                      </div>
                                           
                   </div>   
                      
                   <div class="row form-row">
                      
                      <div class="col-lg-6 col-md-12 col-sm-6">
                        <label for="idArea_reg" class="form-label">Area Orgánica</label>
                        <select id="idArea_reg" name="idArea_reg" class="form-control" tabindex="33" onchange="obtenerUnidadOperativa();">
                        </select>
                       
                      </div>
                      
					  <div class="col-lg-6 col-md-12 col-sm-6">
                        <label for="codigoPostulacion_reg" class="form-label">Código de Postulación</label>
                        <input type="text" class="form-control" id="codigoPostulacion_reg" name="codigoPostulacion_reg" tabindex="35">
                      </div>
                      
                     
                   </div> 
                   
                   <div class="row form-row">
                      
                      <div class="hide" id="bloque_unidad_operativa">
                      
	                      <div class="col-lg-6 col-md-12 col-sm-6">
	                        <label for="idUnidadOp_reg" class="form-label">Unidad Operativa</label>
	                        <select id="idUnidadOp_reg" name="idUnidadOp_reg" class="form-control" tabindex="34">
	                        </select>
	                      </div>
                      
                      </div>
                      
                      
                      
                     <div class="col-lg-6 col-md-12 col-sm-6">
                        <label for="numeroVacantes_reg" class="form-label">Nº de Vacantes</label>
                        <input type="text" class="form-control" id="numeroVacantes_reg" name="numeroVacantes_reg" tabindex="36">
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
	       <div class="botonera">
		       <p class="kbd hide"><kbd>Alt</kbd>+<kbd>S</kbd></p>
		        <button type="button" class="btn btn-primary" id="btnRegistrarConvocatoria" tabindex="36">Guardar</button>
	       </div> 
	       <div class="botonera">
		        <p class="kbd hide"><kbd>Alt</kbd>+<kbd>C</kbd></p>
		        <button type="button" class="btn btn-danger" data-dismiss="modal" tabindex="37">Cerrar</button>
	        </div>
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
