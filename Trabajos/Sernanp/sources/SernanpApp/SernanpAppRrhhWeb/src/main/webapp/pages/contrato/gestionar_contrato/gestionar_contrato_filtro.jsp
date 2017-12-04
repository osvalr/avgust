<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content">
      <div class="row">
		<div class="page-title">
		<!-- 		cambio alanmar 14:02pm -->
				<h3>
					Gestionar <span class="semi-bold">Contrato</span>
				</h3>
		</div>

	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Gestionar Contrato</li>
<!-- 	end	cambio alanmar 14:02pm -->	      
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">
            
				<div class="grid-title">
				  <div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								
					       <a class="btn btn-primary" href="/personal/gestionar-contrato-filtro">
									Postulantes Seleccionados
							</a>
							
							<a class="btn btn-primary" href="/personal/gestionar-contrato-personal-filtro">
									Personal Sernanp
							</a>
							
							 <a class="btn btn-primary" href="/personal/generar-pdf">
									Generar PDF's Contratos
							</a>
							
							<a class="btn btn-primary" href="/personal/contrato-adenda-vencimiento">
									Vencimientos
							</a>
					        
					     </div>
							
				   </div>
            
                 </div>
                 
				<div class="grid-body no-border">
					<form class="" method="POST" id="frmListarPostulante" novalidate="novalidate">
						<div class="row ">
							<div class="col-lg-12">
							
							<h4 class="semi-bold">
									1. <span class="light">Listado de</span> <span
										class="semi-bold">Postulantes Seleccionados</span>
										<br>
							 </h4>
							
							<div class="row form-row">
							
							
<!-- 										<div class="col-lg-3 col-md-6 col-sm-6"> -->
<!-- 		                   				    <label for="criteriaResumen_nombres" class="form-label">Nombres o Apellidos</label> -->
<!-- 					                        <input type="text" class="form-control" id="criteriaResumen_nombres" tabindex="1"> -->
<!-- 				                        </div> -->
						
<!-- 				                        <div class="col-lg-3 col-md-6 col-sm-6"> -->
<!-- 		                   				    <label for="criteriaResumen_numeroRuc" class="form-label">RUC</label> -->
<!-- 					                        <input type="text" class="form-control" id="criteriaResumen_numeroRuc" tabindex="2"> -->
<!-- 				                        </div> -->
			                          
	                                    <div class="col-lg-2 col-md-2 col-sm-2">
					                        <label for="criteriaResumen_tipoDoc" class="form-label">Tipo de Documento</label>
					                        <select id="criteriaResumen_tipoDoc" class="form-control" tabindex="3">
					                        <option value="">Seleccione una opción</option>
											<option value="1">DNI</option>
					                        </select>
					                    </div>
				                      
					                    <div class="col-lg-2 col-md-2 col-sm-2">
					                       <label for="criteriaResumen_numerodoc" class="form-label">Nº Documento</label>
					                       <input type="text" class="form-control" id="criteriaResumen_numerodoc" tabindex="4">
					                    </div>
					                    

<!-- 			                  </div> -->
<!-- 			                  <div class="row form-row"> -->
			                  
			                  			<div class="col-lg-2 col-md-2 col-sm-2">
										    <label for="criteriaResumen_srl_id_convocatoria" class="form-label">Nº de Convocatoria</label>
										    <s:select headerKey="" headerValue="Seleccione una opción"
													  list="listCD" listKey="srl_id_convocatoria" listValue="var_num_convocatoria" 
													  id="criteriaResumen_srl_id_convocatoria" 
													  cssClass="form-control" tabindex="5" />
										</div>
										
										<div class="col-lg-2 col-md-2 col-sm-2">
										    <label for="criteriaResumen_srl_id_conv_area_org" class="form-label">Código de Postulación</label>
										    <select id="criteriaResumen_srl_id_conv_area_org" class=" form-control " tabindex="6">
											<option value="">Seleccione una opción</option>
										    </select>
										</div>
										
										<div class="col-lg-2 col-md-2 col-sm-2">
					                        <label for="criteriaResumen_idarea" class="form-label">Area Orgánica</label>
					                        <s:select headerKey="" headerValue="Seleccione una opción"
													  list="listAreaOrganica" listKey="idarea" listValue="descrip_dependencia" 
													  id="criteriaResumen_idarea" 
													  cssClass="form-control" tabindex="7" />
				                      	</div>
				                      	
				                      	<div class="col-lg-2 col-md-2 col-sm-2">
					                        <label for="criteriaResumen_idunidad" class="form-label">Unidad Operativa</label>
					                        <select id="criteriaResumen_idunidad" class="form-control" tabindex="8">
					                        <option value="">Seleccione una opción</option>
					                        </select>
					                    </div>
			                  
			                  </div>
			                  
					   </div>
					</div>
  							<div class="row form-row">
			                   
			                   <div class="col-lg-12" >
			                  
									<button class="btn btn-primary" type="button" tabindex="7" id="btnFiltrar"><i class="fa fa-filter"></i> Filtrar </button>

									<button class="btn btn-default" type="reset" tabindex="8"><i class="fa fa-file-o"></i> Limpiar </button>

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
                    <th data-hide="phone,tablet">T.D</th>
                    <th data-hide="phone">Nº Documento</th>
                    <th data-class="expand">Nombres</th>
                    <th data-hide="phone,tablet">Ruc</th>
                    <th data-hide="phone,tablet">Genero</th>
                    <th data-hide="phone,tablet">Nº Convocatoria</th>
                    <th data-hide="phone,tablet">Código Postulación</th>
                    <th>Generado</th>
                    <th>Opciones</th>
                  </tr>
                </thead>
                
           </table>
                                   
<br/>

			</div>
			<!-- end grid simple -->
		</div>
		<!-- end row -->
	</div>
	<!-- end page-content -->
	</div>
	<!-- END PAGE -->

<s:form action="gestionar-contrato" name="form" id="form" namespace="/">
	<s:hidden name="idPersonaNatural" id="idPersonaNatural"/>
	<s:hidden name="idPostulacion" id="idPostulacion"/>
	<s:hidden id="op" name="op"/>
	<s:hidden id="tipoReg" name="tipoReg"/>
</s:form>
