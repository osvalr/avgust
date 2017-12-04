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
						<div class="row ">
							<div class="col-lg-12">
							
							<h4 class="semi-bold">
									<span class="light">Listado de</span> 
										<span class="semi-bold">Contratos por vencer</span>
							 </h4>
							 

						<div class="btn-group">
							<button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown"> Descargar <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								
								<li><a href="javascript:void(0);" onclick="generarPdf()">PDF</a></li>
								<li><a href="javascript:void(0);" onclick="generarXLS()">XLS</a></li>
								
							</ul>
						</div>

						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered" id="tableDefault">
							<thead>
								<tr>
									<th data-class="expand">Número Contrato</th>
									<th>Persona</th>
									<th data-class="expand">F. Suscripción</th>
									<th data-class="expand">F. Inicio</th>
									<th data-class="expand">F. Término</th>										
								</tr>
							</thead>
						</table>

					<div id="adendas"></div>

							<h4 class="semi-bold">
									<span class="light">Listado de</span> 
									<span class="semi-bold">Adendas por vencer</span>
							 </h4>
						

						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered" id="tableAdenda">
							<thead>
								<tr>
									<th data-class="expand">Número Adenda</th>
									<th data-class="expand">Número Contrato</th>
									<th>Persona</th>
									<th data-class="expand">F. Suscripción</th>
									<th data-class="expand">F. Inicio</th>
									<th data-class="expand">F. Término</th>
								</tr>
							</thead>
						</table>
						<br>                   
					   </div>
					</div>
 
				</div>
				<!--end grid-body -->
		</div>
		<!-- end row -->
	</div>
	<!-- end page-content -->
	</div>
	<!-- END PAGE -->
<form method="POST" action="<%=request.getContextPath()%>/reporteContratosVencimientopdf" id="frmReportepdf">					
	<input type="hidden" name="int_anio" id="int_anio" />
	<input type="hidden" name="int_mes" id="int_mes" />			
</form>			
<form method="POST" action="<%=request.getContextPath()%>/reporteContratosVencimientoxls" id="frmReportexls">					
	<input type="hidden" name="int_anio" id="int_anio" />
	<input type="hidden" name="int_mes" id="int_mes" />			
</form>	
