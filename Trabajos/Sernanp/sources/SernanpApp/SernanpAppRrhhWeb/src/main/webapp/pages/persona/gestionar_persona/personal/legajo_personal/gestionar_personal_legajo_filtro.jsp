<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content" id="principal">
      <div class="row">
		<div class="page-title">
				<h3>
					Gestionar <span class="semi-bold">Legajos del Personal</span>
				</h3>
		</div>
	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Gestionar Legajos del Personal</li>
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">

				<div class="grid-title">
					<div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				  		
								<button id="btnVolver" class="btn btn-default" type="button" onclick="irListarPersonal('${record.idpersonal}')">
									<i class="fa fa-reply"> </i> ir al Inicio
								</button>	
								
								<button class="btn btn-default" id="btnVolver" type="button" onclick="irRegistroPersonal('${record.idpersonal}')">
									<i class="fa fa-reply"> </i> ir a Registro de Personal
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
						   <h2 id="txtNombres">${record.nombrePersonal} ${record.apepat} ${record.apemat}</h2>
						  
				           <h5 >Tipo y Número de Documento:</h5>
				           <p class="semi-bold">${record.descrip_tipo_documento} ${record.numerodoc}</p>
				           
				           <h5 >Fecha de Ingreso Institucional:</h5>
				           <p class="semi-bold">${record.dte_fec_inicio}</p>
				             
<!-- 				           <h5 >Fecha de Último Contrato:</h5> -->
<%-- 				           <p class="semi-bold">${record.dte_fecha_inicio_max}</p> --%>
				           
				            
							<button data-toggle="modal" id="btnRegistrarNuevoLegajo" onclick="registrarLegajo()" class="btn btn-primary">
				    	       <i class="fa fa-plus-circle"></i> Registrar Nuevo Legajo
				           </button> 
				            
				           <button data-toggle="modal" id="btnSubirFotos" onclick="registrarFotoLegajo()" class="btn btn-primary">
					           <i class="fa fa-plus-circle"></i> Agregar Foto
				           </button>
				           
				           <button  id="btnverContratos" class="btn btn-primary" onclick="obtenerContratos()">
				        	   <i class="fa fa-plus-circle"></i> Registrar Contrato y/o Adenda
				           </button>       
				       </div>  
				       
				            
				           
				 </div>  
				</div>		
				<input type="hidden"  name="flag_contrato_adenda" id="flag_contrato_adenda" value=""/>
				<div id="bloque_tabla_legajos" class="grid-body no-border">
					<div class="row ">
						<div class="col-lg-12">
						
							<h4 class="semi-bold">
									1. <span class="light">Listado de</span> <span
										class="semi-bold">Legajos del Personal</span>
										
							</h4>
							<br>		                  
					 		<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableDefault" >
			               
				                <thead>     
				                  <tr>
				                    <th data-class="expand">Tipo de Documento</th>
				                    <th data-class="expand">Asunto</th>
				                    <th data-class="expand">Descripción</th>
				                    <th data-hide="phone">Fecha de Registro</th>
<!-- 				                    <th data-hide="expand">Contrato / Adenda</th> -->
				                    <th colspan="3">Acciones</th>
				                   
				                    
				                  </tr>
				                </thead>
				       
			                
			           		</table>  
			                   
			      			<br>        
                  
						</div>
					</div>  				
				</div>
				<!--end grid-body -->
				
				<!-- 09-02-2015 DAVID -->
				<div id="bloque_tabla_contratos" class="grid-body no-border" style="display: none;">
					<div class="row ">
						<div class="col-lg-12">
						
						<h4 class="semi-bold">
								2. <span class="light">Listado de</span> <span
									class="semi-bold">Contratos y Adendas</span>
									
						</h4>
						<br>	       
	
	                      <div >
							<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableContratos">
	
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
										<th>Digital</th>	
										<th>Opciones</th>
									</tr>
								</thead>
	
							</table>
	                      </div>
	                		<div id="adendas"></div>
	
							<div id="bloque_tabla_adendas" style="display: none;">
									<h4 class="semi-bold">
										2.1 <span class="light">Listado de</span> 
											<span class="semi-bold">Adendas</span>
									 </h4>
									
									<br>
			                   	<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableAdenda">
			
									<thead>
										<tr>
											<th data-class="expand">Número Adenda</th>
											<th data-class="expand">Número Contrato</th>
											<th data-class="expand">F. Suscripción</th>
											<th data-class="expand">F. Inicio</th>
											<th data-class="expand">F. Término</th>
											<th data-class="expand">F. Cese</th>
											<th data-class="expand">Estado</th>
											<th>Digital</th>	
											<th>Opciones</th>
										</tr>
									</thead>
			
								</table>
									
							</div>
		      			</div>
					</div>  				
				</div>

  <!-- FIN DAVID -->



			</div>   
			<!-- end grid simple -->
		</div>
		<!-- end row -->
	</div>
	<!-- end page-content -->
	
	<!-- END PAGE -->
	


<!-- Modal --> 
<div id="modalRegistrarLegajo" class="modal fade" data-keyboard="false" data-backdrop="static">
    
  <div class="modal-dialog modal-dialog-center">
  <s:form id="formRegistrarLegajo" name="formRegistrarLegajo" method="POST" action="grabar-legajo" enctype="multipart/form-data" namespace="/" theme="simple" target="iframe">
    <input type="hidden"  name="legajo.idpersonanatural" id="idpersonanatural" value="${record.idpersonanatural}" />
    <input type="hidden"  name="legajo.idpersonal" id="idpersonal" value="${record.idpersonal}" />
    <input type="hidden"  name="srl_id_persona_natural_legajo" id="srl_id_persona_natural_legajo" />
    <input type="hidden"  name="op" id="op" />
    <input type="hidden"  name="legajo.var_nombre_documento" id="var_nombre_documento" /> 
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Registro / Edicion Nuevo Legajo</h4>
      </div>
		<div class="modal-body">
          <div class="container-fluid">
  
		  	    <div class="row-fluid">
		         
		 
		          <div class="grid simple">
		        	              
		        	<div class="grid-body no-border" style="overflow: hidden; display: block;">
						
					<div class="row ">
					
					            <div class="row form-row">
					            
<!-- 					             <div class="col-md-12 col-lg-12"> -->
<!-- 			                        <div class="input-group"> -->
<!-- 			                            <input type="text" class="form-control"> -->
<%-- 			                            <span class="input-group-btn"> --%>
<!-- 			                                <button class="btn btn-default" type="button"><i class="glyphicon glyphicon-search"></i></button> -->
<%-- 			                            </span> --%>
<!-- 			                        </div>/input-group -->
<!-- 			                          </div> -->
					            
					               <div class="col-lg-12 col-md-12">


									 <label for="int_id_tipo_documento" class="form-label">Tipo de Documento</label>
					                
					                <div class="input-group">
					                
					                        <s:select headerKey="" headerValue="Seleccione una opción"
 	 										list="listTipoLegajo" listKey="idtablatipo" listValue="destablatipo"    
  											name="legajo.int_id_tipo_documento" id="int_id_tipo_documento"   
  	 										cssClass="form-control" tabindex="1"
  											/>  

 											<span class="input-group-btn">
 											<button id="btnAgregarTipoLegajo" class="btn btn-default" type="button" onclick="$('#modalRegistrarTipoLegajo').modal('toggle');"> 
 										   <i class="fa fa-plus"></i></button>
											</span>

								    </div>
								    
								    
								</div>
										
								</div>

								<div class="row form-row">	
									<div class="col-md-12 col-sm-12" style="padding-top:10px"> 
									   <label for="var_asunto_documento"  class="form-label">Asunto</label>
									    <s:textfield name="legajo.var_asunto_documento" id="var_asunto_documento" cssClass="form-control"
									    tabindex="3" />
									  
									</div>
								</div>
								<div class="row form-row">	
									<div class="col-md-12 col-sm-12">
									   <label for="var_descripcion_documento" class="form-label">Descripción</label>
									   <s:textarea rows="3" name="legajo.var_descripcion_documento" id="var_descripcion_documento" cssClass="form-control"
									    tabindex="4" />
									  
									</div>
									
								</div>
								
								<div class="form-group">
									<div class="row form-row">
										<div class="col-md-12 col-sm-12">
										    <label class="form-label">Adjuntar Archivo</label>
										    
										    
										    <s:file id="fileUpload" name="fileUpload" cssClass="form-control" accept=".pdf"  label="Selecciona un archivo"
										     size="40" tabindex="5" />
										    
			
										    
										</div>
									</div>
								</div>
							
					        </div>
					    	
		             </div>  
		
		          		</div><!-- end grid simple -->
		        	 
		      		</div>
			</div>
		 </div>	
		<div class="modal-footer">
	        <button id="registrarLegajo" class="btn btn-primary" type="submit"> Grabar</button>
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
    </s:form>

  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal --> 
<div id="modalSubirFoto" class="modal fade" data-keyboard="false" data-backdrop="static">
    
  <div class="modal-dialog modal-dialog-center">
  <s:form id="fomSubirFoto" name="fomSubirFoto" method="POST" action="grabar-foto-personal" enctype="multipart/form-data" namespace="/" theme="simple" target="iframeFoto">
    <input type="hidden"  name="legajo.idpersonanatural" id="idpersonanatural" value="${record.idpersonanatural}" />
    <input type="hidden"  name="legajo.idpersonal" id="idpersonal" value="${record.idpersonal}" />
    <input type="hidden"  name="srl_id_persona_natural_legajo" id="srl_id_persona_natural_legajo" />
    <input type="hidden"  name="op" id="op" />
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Foto Personal</h4>
      </div>
		<div class="modal-body">
          <div class="container-fluid">
  
		  	    <div class="row-fluid">
		         
		 
		          <div class="grid simple">
		        	              
		        	<div class="grid-body no-border" style="overflow: hidden; display: block;">
						
					<div class="row ">
					
								
								<div class="form-group">
									<div class="row form-row">
										<div class="col-md-12 col-sm-12">
										    <label class="form-label">Adjuntar Archivo</label>
										    										    
										    <s:file id="fileFoto" name="fileFoto" cssClass="form-control btn-file"  accept="image/*" label="Selecciona un archivo" size="40" tabindex="4" />
										    
			
										     
										</div>
									</div>
								</div>
							
					        </div>
					    	
		             </div>  
		
		          		</div><!-- end grid simple -->
		        	 
		      		</div>
			</div>
		 </div>	
			<div class="modal-footer">
        <button id="btnGrabarFoto" class="btn btn-primary" type="submit"> Grabar</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
    </s:form>

  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="modalRegistrarTipoLegajo" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Registrar Tipo de Documento</h4>
      </div>
      <div class="modal-body">
       
       <div class="page-container row">
  
  	   <div class="row-fluid">
        <div class="span12">
 
        
          <div class="grid simple">
        	
        	              
        <div class="grid-body no-border" style="overflow: hidden; display: block;">
		
			<form class="form-no-horizontal-spacing" novalidate="novalidate" name="formRegistrarTipoLegajo" id="formRegistrarTipoLegajo">	
              <div class="row">
                <div class="col-md-12">
                                                                               
                   <div class="row form-row">
                      
                      <div class="col-lg-12 col-md-12 col-sm-12">
                        <label for="nombreTipoLegajo" class="form-label">Nombre del Tipo de Documento</label>
                        <input type="text" class="form-control" id="nombreTipoLegajo" name="nombreTipoLegajo">
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
        <button type="button" class="btn btn-primary" id="btnRegistrarTipoLegajo">Registrar</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="modalConfirmarEliminar" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
<input type="hidden" id="idLegajo" name="idLegajo"> 
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Confirmación</h4>
      </div>
      <div class="modal-body">
      		<br/>
     		
     		¿Está seguro de eliminar el legajo?
     		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="anularLegajo()">Si</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<iframe name="iframe"  id="iframe" class="hide"></iframe>
<iframe name="iframeFoto"  id="iframeFoto" class="hide"></iframe>

<s:form action="" name="form" id="form" namespace="/">
	<s:hidden id="idPersonal" name="idPersonal"/>
</s:form>
	

  <!-- 06-02-2015 DAVID -->

<iframe name="iframeContratoAdenda"  id="iframeContratoAdenda" class="hide"></iframe>

<!-- Modal --> 
<div id="modalRegistrarLegajoContratoAdenda" class="modal fade" data-keyboard="false" data-backdrop="static">
  <div class="modal-dialog modal-dialog-center">
  <%-- 	  <s:form 	id="formRegistrarLegajoContratoAdenda" name="formRegistrarLegajoContratoAdenda" method="POST" action="grabar-legajo-ContratoAdenda" --%>
	  <s:form 	id="formRegistrarLegajoContratoAdenda" name="formRegistrarLegajoContratoAdenda" method="POST" action="grabar-legajo"
	  			enctype="multipart/form-data" namespace="/" theme="simple" target="iframeContratoAdenda">
	    <input type="hidden"  name="legajo.idpersonanatural" id="idpersonanatural_legajo_ContratoAdenda" value="${record.idpersonanatural}" />
	    <input type="hidden"  name="legajo.idpersonal" id="idpersonal" value="${record.idpersonal}" />
	    <input type="hidden"  name="op" id="opContratoAdenda" />
	    <input type="hidden"  name="legajo.srl_id_contrato" id="srl_id_contrato" />
	    <input type="hidden"  name="srl_id_persona_natural_legajo" id="srl_id_persona_natural_legajo_ContratoAdenda" />
	    
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title">Registro de Legajo Contrato / Adenda</h4>
	      </div>
			<div class="modal-body">
	          <div class="container-fluid">
	  
			  	    <div class="row-fluid">			         
			 
			          <div class="grid simple">
			        	              
			        	<div class="grid-body no-border" style="overflow: hidden; display: block;">
							
								<div class="row ">
									
									<div class="form-group">
										<div class="row form-row">
											<div class="col-md-12 col-sm-12">
											    <label class="form-label">Adjuntar Archivo</label>											    
											    
											    <s:file id="fileUpload_ContratoAdenda" name="fileUpload" cssClass="form-control" accept=".pdf"  label="Selecciona un archivo"   size="80" tabindex="5" />				
											    
											</div>
										</div>
									</div>
								
						        </div>
						    	
			             </div>  
			
			          </div><!-- end grid simple -->
			        	 
			      </div>
				</div>
			 </div>	
			<div class="modal-footer">
	        	<button id="registrarLegajoContratoAdenda" class="btn btn-primary" type="submit"> Grabar</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
	    	</div>
	    </div><!-- /.modal-content -->
	    </s:form>

  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- FIN -->
	
	
	
