<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
  
<%--     <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/img/favicon.png"> --%>
    <title>SERNANP</title>

<!-- CORE -->
<link href="<%=request.getContextPath()%>/assets/css/core/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/css/core/sernanp-themeExtJs.css" rel="stylesheet" type="text/css">

<!-- CUSTOM CSS  -->
    
<link href="<%=request.getContextPath()%>/assets/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/css/otro/chosen.css" rel="stylesheet" type="text/css">

<script src="<%=request.getContextPath()%>/assets/js/core/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/core/bootstrap.min.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/assets/js/otro/chosen.jquery.min.js" type="text/javascript"></script>

  </head>

  <body>

     <div id="wrapper">
    
    	 <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    	
    		<!-- HEADER -->
  			<tiles:insertAttribute name="header" />
			<!-- END HEADER -->
		
		</nav>
	
	 <div id="page-wrapper">
	  	<div class="page-content">
    	  	<div class="row">
	
				<!-- BODY -->
				<tiles:insertAttribute name="content" />
				<!-- END BODY -->
			</div>
		</div>

     </div><!-- end page-wrapper -->

    </div><!-- end wrapper -->
       
<!-- Modal --> 
<div id="modalMostrarReporte" class="modal fade" data-keyboard="false" data-backdrop="static">


  <div class="modal-dialog modal-dialog-center">

  <form id="formGenerarReporte" name="formGenerarReporte" onsubmit="return actionDinamico();" method="GET" enctype="multipart/form-data"  target="iframe"> 
    
    <input type="hidden" name="srl_id_regimen_pensionario" value="" />
<!--     <input type="hidden" name="srl_id_regimen_contractual" value="" /> -->
	<input type="hidden" name="srl_id_regimen_contractual" value="" id="srl_id_regimen_contractual_reporte"/>
    <input type="hidden" name="srl_id_concepto_planilla" value="" />
       
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Generar Reportes</h4>
      </div>
		<div class="modal-body">
          <div class="container-fluid">
  
		  	    <div class="row-fluid">
		         
		 
		          <div class="grid simple">
		        	              
		        	<div class="grid-body no-border" style="overflow: hidden; display: block;">
						
					<div class="row ">
					
					            <div class="row form-row">
					            
					            
					               <div class="col-lg-12 col-md-12 col-sm-12">


									 <label for="int_id_tipo_documento" class="form-label">Tipo de Reporte</label>					           
											<select id="listaMenuReportes" class="form-control" tabindex="5" >
											<option value="0" selected>[-- Seleccione un reporte --]</option>
											</select>
								</div>
										
								</div>

								<div class="row form-row">	
									<div class="col-md-3 col-sm-3"> 
									   <label for="int_anio"  class="form-label">Año</label>
									    <s:textfield type="number" pattern="[0-9]+" min="2009" max="2020" name="int_anio" id="int_anio" cssClass="form-control"
									    tabindex="2" required="required" />
									  
									</div>
									
									<div class="col-md-3 col-sm-3"> 
									   <label for="int_id_periodo_mes"  class="form-label">Periodo</label>
<%-- 									    <s:textfield type="number" pattern="[0-9]+" min="1" max="12" name="int_id_periodo_mes" id="int_id_periodo_mes" cssClass="form-control" --%>
										<s:textfield type="number" pattern="[0-9]+" min="1" max="12" name="int_id_periodo_mes" id="int_id_periodo_mes_reporte" cssClass="form-control"
									    tabindex="3" required="required" />
									  
									</div>
									
									<div class="col-md-6 col-sm-6"> 
									   <label for="srl_id_regimen_contractual"  class="form-label">Reg. Contractual</label>
											<select id="srl_id_regimen_contractual" class="form-control" tabindex="4" >
											</select>
									  
									</div>
									
									
									
								</div>
								
								<div id="pensionario" class="row form-row hide">
								
									<div class="col-md-12 col-sm-12"> 
										   <label for="srl_id_regimen_pensionario"  class="form-label">Reg. Pensionario</label>

											<select id="srl_id_regimen_pensionario" class="form-control" tabindex="5" >
											</select>										  
									</div>
								</div>
								
								<div id="fuente_meta" class="row form-row hide">	
									<div class="col-md-6 col-sm-6"> 
									   <label for="c_fte_fto" class="form-label">Fuente</label>
									    <s:textfield name="c_fte_fto" id="c_fte_fto" cssClass="form-control"
									    tabindex="5" placeholder="00" />
									  
									</div>
									
									<div class="col-md-6 col-sm-6"> 
									   <label for="c_meta" class="form-label">Meta</label>
									    <s:textfield name="c_meta" id="c_meta" cssClass="form-control"
									    tabindex="6" />
									  
									</div>
									
									
								</div>
								
								<div id="concepto_planilla" class="row form-row hide">	
									<div class="col-md-12 col-sm-12"> 
									   <label for="srl_id_concepto_planilla" class="form-label">Conceptos</label>

									  		<select id="srl_id_concepto_planilla" class="form-control" tabindex="6" >
<!-- 									  		<option value=""></option> -->
									  		<option value="" selected>[-- Seleccione un concepto --]</option>
											</select>
									</div>
									
								</div>
								
								<div id="cargo" class="row form-row hide">	
									<div class="col-md-12 col-sm-12"> 
									   <label for="srl_id_cargo" class="form-label">Cargo</label>

									  		<select id="srl_id_cargo" data-placeholder="-- Ingrese un cargo --" name="srl_id_cargo" tabindex="6" >
									  		<option value=""></option>
<!-- 									  		<option value="" selected>-- ingrese un cargo --</option> -->
											</select>
									</div>
									
								</div>
								
								<div id="nombres" class="row form-row hide">	
									<div class="col-md-12 col-sm-12"> 
									   <label for="nombre_completo" class="form-label">Nombres</label>
											<select id="nombre_completo" data-placeholder="[-- Ingrese un nombre --]" name="nombre_completo" class="form-control chosen-select-deselect" tabindex="7" >
											<option value=""></option>
<!-- 											<option value="" selected>-- Ingrese un nombre --</option> -->
											</select>
									  
									</div>
																		
								</div>
								
								<div class="row form-row">	
									<div class="col-md-6 col-sm-6"> 
									   <label for="tipo_reporte" class="form-label">Exportar en: </label>
									    
										<input type="radio" name="tipo_reporte" id="tipo_reporte" value="pdf" checked> PDF
										<input type="radio" name="tipo_reporte" id="tipo_reporte" value="xls"> XLS 
									  
									</div>
									
								</div>

							</div>
					    	
		             </div>  
		
		          		</div><!-- end grid simple -->
		        	 
		      		</div>
			</div>
		 </div>	
		 
		<div class="modal-footer">
			<div class="row pull-left">
				<span style="display: none;" class="loading"> <span
					class="semi-bold"> Generando Reporte... </span><img
					alt="procesando"
					src="<%=request.getContextPath()%>/assets/img/ajaxloader.gif">
				</span>
			</div>
			<div class="row pull-right">
				<button id="generarReporte" class="btn btn-primary" onclick="listarReporte()">Generar Reporte</button>
		        <button type="button" class="btn btn-primary" onclick="destruirModal()" data-dismiss="modal">Cerrar</button>
			</div>
<!-- 	        <button id="generarReporte" class="btn btn-primary" onclick="listarReporte()">Generar Reporte</button> -->
<!-- 	        <button type="button" class="btn btn-primary" onclick="destruirModal()" data-dismiss="modal">Cerrar</button> -->
      </div>
    </div><!-- /.modal-content -->

    </form>

  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal -->
<div id="loadAjax" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Procesando solicitud</h4>
      </div>
      <div class="modal-body">
      		<br/>
     		
     		Un momento por favor... <img alt="procesando" src="<%=request.getContextPath()%>/assets/img/ajaxloader.gif">
     		
      </div>
      <div class="modal-footer">
       
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<iframe name="iframe"  id="iframe" class="hide"></iframe>


<!-- 17-03-2015 STAR DAVID -->

<div id="modalSessionExpirada" class="modal fade" data-keyboard="false" data-backdrop="static" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Estado de Sessión</h4>
      </div>
      <div class="modal-body">
      		<br/>
     		
     		<div id="msj_session"></div>
     		
      </div>
      <div class="modal-footer">
<!--         <button type="button" class="btn btn-white" data-dismiss="modal">Cerrar</button> -->
			<button type="button" class="btn btn-white" onclick="cerrarSession();">Aceptar</button>        
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- END DAVID -->

</body> 
</html>   