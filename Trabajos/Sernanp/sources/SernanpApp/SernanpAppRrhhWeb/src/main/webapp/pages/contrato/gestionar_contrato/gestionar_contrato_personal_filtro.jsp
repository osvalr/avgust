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
										class="semi-bold">Personal</span>
										<br>
							 </h4>
							
							<div class="row form-row">
							
							
<!-- 										<div class="col-lg-3 col-md-6 col-sm-6"> -->
<!-- 		                   				    <label for="criteriaPersonalContrato_nombres" class="form-label">Nombres o Apellidos</label> -->
<!-- 					                        <input type="text" class="form-control" id="criteriaPersonalContrato_nombres" tabindex="1"> -->
<!-- 				                        </div> -->
						
<!-- 				                        <div class="col-lg-3 col-md-6 col-sm-6"> -->
<!-- 		                   				    <label for="criteriaPersonalContrato_numeroRuc" class="form-label">RUC</label> -->
<!-- 					                        <input type="text" class="form-control" id="criteriaPersonalContrato_numeroRuc" tabindex="2"> -->
<!-- 				                        </div> -->
			                          
	                                    <div class="col-lg-3 col-md-3 col-sm-3">
					                        <label for="criteriaPersonalContrato_tipoDoc" class="form-label">Tipo de Documento</label>
					                        <select id="criteriaPersonalContrato_tipoDoc" class="form-control" tabindex="3">
					                        <option value="">Seleccione una opción</option>
											<option value="1" selected="selected">DNI</option>
					                        </select>
					                    </div>
				                      
					                    <div class="col-lg-3 col-md-3 col-sm-3">
					                       <label for="criteriaPersonalContrato_numeroDoc" class="form-label">Nº Documento</label>
					                       <input type="text" class="form-control" id="criteriaPersonalContrato_numeroDoc" tabindex="4">
					                    </div>
					                    

<!-- 			                  </div> -->
			                  
<!-- 					          <div class="row form-row">           -->
						          <div class="col-lg-3 col-md-3 col-sm-3">
		                   			 <label for="criteriaPersonalContrato_srl_id_regimen_contractual" class="form-label">Régimen Contractual</label>
										<s:select headerKey="" headerValue="Seleccione una opción"
 										list="listRegimenContractual" listKey="int_cod_regimen_contractual" listValue="var_descripcion_regimen_contractual"  
										name="" id="criteriaPersonalContrato_srl_id_regimen_contractual" 
 										cssClass="form-control" tabindex="5" 
										/> 
				                  </div>
				                  
				                  <div class="col-lg-3 col-md-3 col-sm-3">
		                   			 <label for="criteriaPersonalContrato_int_estado" class="form-label">Estado</label>
		                   			<select name="criteriaPersonalContrato_int_estado" id="criteriaPersonalContrato_int_estado" class="form-control" tabindex="6">
		                   			  <option value="">Todos</option>
		                   			  <option value="0">Activo</option>
									  <option value="1">Inactivo</option>
									  
									</select>
				                  </div>
				              </div>
			                  
					          <div class="row form-row">          
				                   <div class="col-lg-3 col-md-3 col-sm-3">
		                   			 <label for="criteriaPersonalContrato_srl_id_cargo" class="form-label">Cargo</label>
		                   			<s:select headerKey="" headerValue="Seleccione una opción"
 										list="listCargo" listKey="srl_id_cargo" listValue="var_nom_cargo"  
										name="" id="criteriaPersonalContrato_srl_id_cargo" 
 										cssClass="form-control" tabindex="7" 
										/> 
				                  </div>
				                  
				                  <div class="col-lg-3 col-md-3 col-sm-3">
					                  <label for="criteriaPersonalContrato_idarea" class="form-label">Area Orgánica</label>
					                   <s:select headerKey="" headerValue="Seleccione una opción"
											list="listAreaOrganica" listKey="idarea" listValue="descrip_dependencia" 
											id="criteriaPersonalContrato_idarea" 
											cssClass="form-control" tabindex="7" 
											/>
				                 </div>
<!-- 			                  </div> -->
			                  
<!-- 			                  <div class="row form-row">  -->
			                     <div class="col-lg-3 col-md-3 col-sm-3">
					                  <label for="idcategoriaanp" class="form-label">Categoria ANP</label>
					                   <s:select headerKey="" headerValue="Seleccione una opción"
											list="listCategoriaAnp" listKey="idcategoriaanp" listValue="descategoriaanp" 
											id="idcategoriaanp" onchange="obtenerAreaNatural('#idcategoriaanp','#idareanatural')"
											cssClass="form-control" tabindex="8" 
											/>
				                 </div>
				                 
				                 <div class="col-lg-3 col-md-3 col-sm-3">
					                  <label for="idareanatural" class="form-label">Area Natural</label>
					                   <select id="idareanatural" name="idareanatural" class="form-control" tabindex="9">
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
                    <th data-hide="phone,tablet">Tipo</th>
                    <th data-class="expand">Número</th>
                    <th data-class="expand">Nombres</th>
                    <th data-hide="phone,tablet">Cargo</th>
                    <th data-hide="phone">Área Orgánica</th>
                    <th data-hide="phone">Categoría ANP</th>
                    <th data-hide="phone">Área Natural</th>
                    <th data-hide="phone,tablet">Ultimo Contrato</th>
                    <th data-hide="phone,tablet">Estado</th>
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
	<s:hidden id="op" name="op"/>
	<s:hidden id="tipoReg" name="tipoReg"/>
</s:form>
