<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content">
      <div class="row">
		<div class="page-title">

				<h3>
					Gestionar <span class="semi-bold">Desvinculación del Personal</span>
				</h3>
		</div>

	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Gestionar Desvinculación del Personal</li>

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
<!-- 							   <p>Fotografía no encontrada en el sistema.</p> -->
							    
<!-- 								<i class="fa fa-user fa-4"></i> -->
<!--                                  <br> -->

							</div>
						</div>   
					 	<div class="col-lg-10 col-md-8 col-sm-8 col-xs-6"">
						   <h2 id="txtNombres">${record.nombrePersonal} ${record.apepat} ${record.apemat}</h2>
						  
				           <h5 >Tipo y Número de Documento:</h5>
				           <p class="semi-bold">${record.descrip_tipo_documento} ${record.numerodoc}</p>
				           
				           <h5 >Fecha de Ingreso Institucional:</h5>
				           <p class="semi-bold">${record.dte_fec_inicio}</p>
				           
				               
				       </div>  
				       
				            
				           
				 </div> 
				</div>	
			
		
			  <div id="bloque-convocatoriaListado">
			  
				<div class="grid-body no-border">
					<form class="" method="POST" id="formRegistrarDesvinculacion">

						<input type="hidden" value="${record.idpersonal}" name="desvinculacion.idpersonal" id="idpersonal"/>
						<input type="hidden" value="${record.idpersonanatural}" name="desvinculacion.idpersonanatural" id="idpersonanatural"/>
						<input type="hidden" name="desvinculacion.srl_id_estado_personal" id="srl_id_estado_personal"/>
						<s:hidden name="op" id="op"/>
						<div class="row ">
							<div class="col-lg-12">
							
							<h4 class="semi-bold">
									1. <span class="light">Información </span> <span
										class="semi-bold">Complementaria</span>
										<br>
							 </h4>
							
							<div class="row form-row">
							
										<div class="col-lg-3 col-md-4 col-sm-4">
										    <label for="int_id_tipificacion" class="form-label">Tipificación</label>
										    <s:select headerKey="" headerValue="Seleccione una opción"
	 										list="listTipificacion" listKey="int_id_tipificacion" listValue="var_descripcion_tipificacion"  
											name="desvinculacion.int_id_tipificacion" id="int_id_tipificacion" 
	 										cssClass="form-control" tabindex="1" 
											/> 
										</div>
										
										
<!-- 				                        <div class="col-lg-3 col-md-4 col-sm-4"> -->
<!-- 		                   				    <label for="dte_fecha_estado" class="form-label">Fecha del evento</label> -->
<!-- 					                        <input type="text" class="form-control" id="dte_fecha_estado" name="desvinculacion.dte_fecha_estado" tabindex="2"> -->
<!-- 				                        </div> -->
				                       
				                       <div class="col-lg-3 col-md-4 col-sm-4">
		                   				    <label for="dte_fec_cese" class="form-label">Fecha de Cese</label>
					                        <input type="text" class="form-control" id="dte_fec_cese" name="desvinculacion.dte_fec_cese" tabindex="3">
				                       </div>
						          
			                  </div>
			                  
			                  <div class="row form-row">
			                  
			                           
			                          <div class="col-lg-6 col-md-8 col-sm-8">
				                       <label for="var_motivo" class="form-label">Motivo</label>
				                        <textarea  rows="2" class="form-control" id="var_motivo" name="desvinculacion.var_motivo" tabindex="4"></textarea>
				                      </div>
				                      
				                    
				                      		    
				               </div>  
			              
					   </div>
					</div>
  							<div class="row form-row">
			                   
			                   <div class="col-lg-12" >
			                  
			                   <div class="botonera">
							    <p class="kbd hide"><kbd>Alt</kbd>+<kbd>T</kbd></p>
									<button class="btn btn-primary" type="button" id="registrarDesvinculacion" >
									<i class="fa fa-user"></i> Registrar desvinculación
								    </button>
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
                    <th data-class="expand">Tipificación</th>
                    <th data-hide="phone">Motivo</th>
                    <th data-class="expand">Estado</th>
                    <th data-class="expand">Fecha de Cese</th>
                    <th data-class="expand">Fecha del Evento</th>
                    <th></th>
                    
                  </tr>
                </thead>
       
                
           </table>
                      
            <br>
         
            </div>
                
		  </div>		
				<!-- END LISTADO DE PERSONAL -->
				
				
				
<!--                 REGISTRO DE PERSONAL  -->
                  
				
				<!--end grid-body -->
				
<!-- 				END REGISTRO DE PERSONAL -->

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
        <button type="button" class="btn btn-primary" onclick="grabarFormulario()">Si</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="modalConfirmarEliminar" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Confirmación</h4>
      </div>
      <div class="modal-body">
      		<br/>
     		
     		¿Estas seguro de eliminar la información?
     		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="eliminar()">Si</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<s:form action="" name="form" id="form" namespace="/">
	<s:hidden name="idPersonaNatural" id="idPersonaNatural"/>
	<s:hidden name="idPersonal" id="idPersonal"/>
	<s:hidden name="op" id="op"/>
</s:form>
