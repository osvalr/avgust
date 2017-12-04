<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content">
      <div class="row">
		<div class="page-title">
	
				<h3>
					Gestionar <span class="semi-bold">Personal</span> 
				</h3>
		</div>

	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Gestionar Personal</li>
	      
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">
            
				<div class="grid-title">
				  <div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				  		
            			<a class="btn btn-primary" href="<%=request.getContextPath()%>/consulta-personal.action" >
									Consulta Personal
						</a>
						
						<a class="btn btn-primary" href="#" data-toggle="modal" data-target="#resumen-altas-bajas">Resumen de Altas y Bajas</a>

						
<%-- 						<a class="btn btn-primary" href="<%=request.getContextPath()%>/listar-resumen-altas-bajas.action" > --%>
<!-- 									Resumen de Altas y Bajas -->
<!-- 						</a> -->
					        
					        
					     </div>
							
				   </div>
            
                 </div>
                 
			
			  <div id="bloque-legajoListado">
			  
				<div class="grid-body no-border">
					<form class="" method="POST" id="frmListarPersonal" novalidate="novalidate">
						<div class="row ">
							<div class="col-lg-12">
							
							<h4 class="semi-bold">
									1. <span class="light">Listado del</span> <span
										class="semi-bold">Personal</span>
										<br>
							 </h4>
							
							<div class="row form-row">
							 
								  	    <div class="col-lg-3 col-md-6 col-sm-6">
		                   				    <label for="criteriaResumen_nombres" class="form-label">Nombres o Apellidos</label>
					                        <input type="text" class="form-control" id="criteriaResumen_nombres" tabindex="1">
				                        </div>
						
				                        <div class="col-lg-3 col-md-6 col-sm-6">
		                   				    <label for="criteriaResumen_ruc" class="form-label">RUC</label>
					                        <input type="text" class="form-control" id="criteriaResumen_ruc" tabindex="2">
				                        </div>
			                          
	                                    <div class="col-lg-3 col-md-6 col-sm-6">
					                        <label for="criteriaResumen_tipoDoc" class="form-label">Tipo de Documento</label>
					                        <select id="criteriaResumen_tipoDoc" class="form-control" tabindex="3">
					                        <option value="">Seleccione una opción</option>
											<option value="1">DNI</option>
					                        </select>
					                    </div>
				                      
					                    <div class="col-lg-3 col-md-6 col-sm-6">
					                       <label for="criteriaResumen_numerodoc" class="form-label">Nº Documento</label>
					                       <input type="text" class="form-control" id="criteriaResumen_numerodoc" tabindex="4">
					                    </div>
					          
					          </div>
					          
					          <div class="row form-row">          
						          <div class="col-lg-3 col-md-6 col-sm-6">
		                   			 <label for="criteriaResumen_srl_id_regimen_contractual" class="form-label">Régimen Contractual</label>
										<s:select headerKey="" headerValue="Seleccione una opción"
 										list="listRegimenContractual" listKey="int_cod_regimen_contractual" listValue="var_descripcion_regimen_contractual"  
										name="" id="criteriaResumen_srl_id_regimen_contractual" 
 										cssClass="form-control" tabindex="5" 
										/> 
				                  </div>
				                  
				                  <div class="col-lg-3 col-md-6 col-sm-6">
		                   			 <label for="criteriaResumen_int_estado" class="form-label">Estado</label>
		                   			<select name="criteriaResumen_int_estado" id="criteriaResumen_int_estado" class="form-control" tabindex="6">
		                   			  <option value="">Todos</option>
		                   			  <option value="0">Activo</option>
									  <option value="1">Inactivo</option>
									  
									</select>
				                  </div>
				                  
				                   <div class="col-lg-3 col-md-6 col-sm-6">
		                   			 <label for="criteriaResumen_srl_id_cargo" class="form-label">Cargo</label>
		                   			<s:select headerKey="" headerValue="Seleccione una opción"
 										list="listCargo" listKey="srl_id_cargo" listValue="var_nom_cargo"  
										name="" id="criteriaResumen_srl_id_cargo" 
 										cssClass="form-control" tabindex="7" 
										/> 
				                  </div>
				                  
				                  <div class="col-lg-3 col-md-6 col-sm-6">
					                  <label for="criteriaResumen_idarea" class="form-label">Area Orgánica</label>
					                   <s:select headerKey="" headerValue="Seleccione una opción"
											list="listAreaOrganica" listKey="idarea" listValue="desarea" 
											id="criteriaResumen_idarea" 
											cssClass="form-control" tabindex="7" 
											/>
				                 </div>
			                  </div>
			                  
			                  <div class="row form-row"> 
			                     <div class="col-lg-3 col-md-6 col-sm-6">
					                  <label for="idcategoriaanp" class="form-label">Categoria ANP</label>
					                   <s:select headerKey="" headerValue="Seleccione una opción"
											list="listCategoriaAnp" listKey="idcategoriaanp" listValue="descategoriaanp" 
											id="idcategoriaanp" onchange="obtenerAreaNatural('#idcategoriaanp','#idareanatural')"
											cssClass="form-control" tabindex="8" 
											/>
				                 </div>
				                 
				                 <div class="col-lg-3 col-md-6 col-sm-6">
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
			                  
			                      <div class="botonera">
							    	 <p class="kbd hide"><kbd>Alt</kbd>+<kbd>T</kbd></p>
									<button class="btn btn-info" type="button" onclick="iniciarFiltro('json')" tabindex="7"><i class="fa fa-filter"></i> Filtrar </button>
							      </div>
							      <div class="botonera">
							       <p class="kbd hide"><kbd>Alt</kbd>+<kbd>L</kbd></p>
									<button class="btn btn-default" type="reset" tabindex="8"><i class="fa fa-file-o"></i> Limpiar Campos</button>
						          </div>
						          <div class="botonera hide">
							       <p class="kbd hide"><kbd>Alt</kbd>+<kbd>P</kbd></p>
									<button class="btn btn-default" type="button" tabindex="9" id="btnImprimirLista"><i class="fa fa-print"></i> Imprimir</button>
						          </div>
							   </div>
							   
		                    </div> 
							
				 </form>
				</div>
				<!--end grid-body -->
				

			

			<div class="grid-body no-border">      
             	
 			<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover" id="tableDefault" >
               
                <thead>     
                  <tr>
                    <th data-hide="phone,tablet">Tipo</th>
                    <th data-class="expand">Número</th>
                    <th data-class="expand">Nombres</th>
                    <th data-hide="phone,tablet">Cargo</th>
                    <th data-hide="phone">Área Orgánica</th>
                    <th data-hide="phone">Categoría ANP</th>
                    <th data-hide="phone">Área Natural</th>
                    <th data-hide="phone,tablet">Fecha de Contrato</th>
                    <th data-hide="phone,tablet">Estado</th>
                    <th data-hide="expand">Expediente</th>
                    <th colspan="1">Detalle</th>
                   
                  </tr>
                </thead>
       
               
           </table>
                      
            <br>
         
            </div>
                
		  </div>		
				<!-- END LISTADO DE PERSONAL -->
				
				
			</div>
			<!-- end grid simple -->
		</div>
		<!-- end row -->
	</div>
	<!-- end page-content -->
	
	<div class="modal fade" id="resumen-altas-bajas" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
               Resumen de Altas y Bajas del Personal
            </div>
            <div class="modal-body">
                <div class="row form-row">
                	<div class="col-lg-6 col-md-6 col-sm-12">
                	<br>
		               <label for="int_estado" class="form-label">Estado</label>
		               <select name="int_estado" id="int_estado" class="form-control" tabindex="6">
		                 <option value="">Todos</option>
		                 <option value="0">Activo</option>
						 <option value="1">Inactivo</option>
					 </select>
				    </div>
				 </div>
            </div>
            <div class="modal-footer">
            
               <script type="text/javascript">
               
                  setTimeout(function(){
 					 $('#resumen-altas-bajas').modal('hide')
                  }, 10000);
                	
                  $(document).ready(function(){
                	  
                	  $("#generar_reporte").click(function(){
                   	  
                	   var int_estado = $('#int_estado').val();
                	   console.log(int_estado);
                	   $('#generar_reporte').attr('href','<%=request.getContextPath()%>/listar-resumen-altas-bajas.action?int_estado=' + int_estado);
                	  });
                	  
                  });
                  
               </script>
               

				<a class="btn btn-primary" id="generar_reporte" > 
				       Generar Reporte
				</a>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                 
                       
            </div>
        </div>
      </div>
	</div>
	
	<!-- END PAGE -->

<s:form action="" name="form" id="form" namespace="/">
	<s:hidden name="idPersonaNatural" id="idPersonaNatural" />
	<s:hidden name="idPersonal" id="idPersonal"/>
</s:form>