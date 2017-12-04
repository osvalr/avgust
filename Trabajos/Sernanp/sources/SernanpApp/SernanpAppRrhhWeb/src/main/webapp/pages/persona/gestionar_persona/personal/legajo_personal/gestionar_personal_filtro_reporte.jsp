<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content">
      <div class="row">
		<div class="page-title">
	
				<h3>
					Reporte <span class="semi-bold">Personal</span> 
				</h3>
		</div>

	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i>Reporte Personal</li>
	      
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">
            
				<div class="grid-title">
				  <div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				  		
            			<a class="btn btn-primary" href="<%=request.getContextPath()%>/gestionar-personal-filtro" >
									Consulta Personal
						</a>
						
						<a class="btn btn-primary" href="<%=request.getContextPath()%>/gestionar-personal-filtro-reporte" >
									Reporte Personal
						</a>
					        
					        
					     </div>
							
				   </div>
            
                 </div>
                  
			
			  <div id="bloque-legajoListado">
			  
				<div class="grid-body no-border">
<%-- 					<form method="POST" action="<%=request.getContextPath()%>/reporte-personal" id="frmReporte" target="_blank"> --%>
					<form method="POST" action="<%=request.getContextPath()%>/listar-resumen-altas-bajas.action?int_estado" id="frmReporte">					
					<input type="hidden" name="format" id="format" /> 
						<div class="row ">
							<div class="col-lg-12">
							
							<h4 class="semi-bold">
									1. <span class="light">Listado del</span> <span
										class="semi-bold">Personal</span>
										<br>
							 </h4>
							
					          
					          <div class="row form-row"> 
					                   
						          <div class="col-lg-2 col-md-2 col-sm-2">
		                   			 <label for="criteriaReporteResumen_anho_inicio" class="form-label">Año</label>
									 <input type="text" class="form-control" id="criteriaReporteResumen_anho_inicio" name="criteriaReporteResumen.anho_inicio" tabindex="1">
				                  </div>
				                  				                  
				                   <div class="col-lg-2 col-md-2 col-sm-2">
		                   			 
		                   			 	<label for="criteriaReporteResumen_dte_fec_inicio_desde" class="form-label">Rango Desde</label>
										 <input type="text" class="form-control" id="criteriaReporteResumen_dte_fec_inicio_desde" name="criteriaReporteResumen.dte_fec_inicio_desde" tabindex="1">
				                  	
				                  </div>
				                  
				                  <div class="col-lg-2 col-md-2 col-sm-2">
		                   			 	<label for="criteriaReporteResumen_dte_fec_inicio_hasta" class="form-label">Rango Hasta</label>
										 <input type="text" class="form-control" id="criteriaReporteResumen_dte_fec_inicio_hasta" name="criteriaReporteResumen.dte_fec_inicio_hasta" tabindex="1">
				                  	
				                  </div>
				                  <!-- SE QUITO PARA TENER UNA SOLA FILA EN EL FILTRO EL 05-08-2015 DAVID -->
<!-- 			                  </div> -->
					          
<!-- 					          <div class="row form-row">           -->
						          <div class="col-lg-3 col-md-3 col-sm-3">
		                   			 <label for="criteriaResumen_srl_id_regimen_contractual" class="form-label">Régimen Contractual</label>
										<s:select headerKey="" headerValue="Seleccione una opción"
 										list="listRegimenContractual" listKey="int_cod_regimen_contractual" listValue="var_descripcion_regimen_contractual"  
										id="criteriaReporteResumen_srl_id_regimen_contractual" name="criteriaReporteResumen.srl_id_regimen_contractual"
 										cssClass="form-control" tabindex="5" 
										/> 
				                  </div>
				                  				                  
				                   <div class="col-lg-3 col-md-3 col-sm-3">
		                   			 <label for="criteriaResumen_srl_id_cargo" class="form-label">Cargo</label>
		                   			<s:select headerKey="" headerValue="Seleccione una opción"
 										list="listCargo" listKey="srl_id_cargo" listValue="var_nom_cargo"  
										id="criteriaReporteResumen_srl_id_cargo" name="criteriaReporteResumen.srl_id_cargo"
 										cssClass="form-control" tabindex="7" 
										/> 
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
									<button class="btn btn-default" type="reset" tabindex="8"><i class="fa fa-file-o"></i> Limpiar </button>
						          </div>
						          <!-- SE OCULTO EL 05-08-2015 DAVID -->
<!-- 						          <div class="botonera"> -->
<!-- 							        <p class="kbd hide"><kbd>Alt</kbd>+<kbd>L</kbd></p> -->
<!-- 									<button class="btn btn-primary" type="button" tabindex="8" onclick="reportPdf()"><i class="fa fa-file-o"></i> Exportar PDF</button> -->
<!-- 						          </div> -->
						          
						          <div class="botonera">
							        <p class="kbd hide"><kbd>Alt</kbd>+<kbd>L</kbd></p>
									<button class="btn btn-primary" type="button" tabindex="8" onclick="reportXls()"><i class="fa fa-file-o"></i> Exportar EXCEL</button>
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
                    <th data-hide="phone,tablet">Inicio Contrato</th>
                    <th data-hide="phone,tablet">Fin Contrato</th>
                   
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
	
	<!-- END PAGE -->

<s:form action="" name="form" id="form" namespace="/">
	<s:hidden name="idPersonaNatural" id="idPersonaNatural" />
	<s:hidden name="idPersonal" id="idPersonal"/>
</s:form>