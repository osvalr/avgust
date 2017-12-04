<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<div id="modalBuscarPostulantes" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title"> Buscar Postulante </h4>
      </div>
      <div class="modal-body">
      <div class="row">
		
		<div class="grid simple">

				<div style="padding-bottom: 10px" class="grid-body no-border celeste">
					<form class="form-no-horizontal-spacing" method="POST" id="frmRegistrarPostulante" novalidate="novalidate" onreset="retornarPaisReset()">
						<div class="row ">
							<div class="col-md-12 ">
								
								<div class="row form-row">
                    
                   				  <div class="col-lg-3 col-md-6 col-sm-6">
			                        <input type="text" class="form-control" id="nombresApellidoBuscar" name="nombresApellidoBuscar" placeholder="Apellidos y nombres">
			                      </div>
                    
				                    <div class="col-lg-2 col-md-3 col-sm-4">
				                      
				                        <select id="idTipoDocumentoBuscar" name="idTipoDocumentoBuscar" class="form-control" tabindex="-1">
				                        </select>
				                    </div>
				                      
				                      <div class="col-lg-2 col-md-3 col-sm-4">
				                        <input type="text" class="form-control" id="numeroDocumentoBuscar" name="numeroDocumentoBuscar" placeholder="Nº de Documento">
				                      </div>
				                      
				                      <div class="col-lg-2 col-md-3 col-sm-4">
				                        <input type="text" class="form-control" id="rucBuscar" name="rucBuscar" placeholder="Ruc">
				                      </div>
				                      				                      			                      
			                   </div> 
		
                   
							</div>

							
						</div>
						
						
						<div class="">
							<div class="pull-left">
							<br>
								<button class="btn btn-primary btn-cons" type="button" onclick="iniciarFiltro()">
									<i class="icon-ok"></i> Filtrar
								</button>
								<button class="btn btn-default btn-cons" type="reset">Limpiar Campos</button>
								
								
								
							</div>
						</div>
					</form>
				</div>
				<!--end grid-body -->

			</div>
			<!-- end grid simple -->
		</div>
		<!-- end row -->
       
           <div class="row">    
           <div class="grid simple">

				<div class="grid-body no-border">      
 
 			<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableDefault" >
               
                <thead>     
                  <tr>
                    <th data-hide="phone,tablet">T.Doc</th>
                    <th data-hide="phone">Nº Doc</th>
                    <th data-class="expand">Nombres</th>
                    <th data-hide="phone">Ruc</th>
                    <th data-hide="phone,tablet">Genero</th>
                    <th data-hide="phone">Nº Convocatoria</th>
                    <th data-hide="phone">C.Postulacion</th>
                    <th>Estado</th>
                    <th data-hide="phone,tablet">Área Organica</th>
                    <th data-hide="phone,tablet">F.Postulación</th>
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
                    <th>Estado</th>
                    <th>Área Organica</th>
                    <th>F.Postulación</th>
                    <th colspan="2">Opciones</th>
                    
                  </tr>
                </tfoot>
                
           </table>
         
            </div>
           </div>       
          </div><!--end row -->
     
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-white" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

