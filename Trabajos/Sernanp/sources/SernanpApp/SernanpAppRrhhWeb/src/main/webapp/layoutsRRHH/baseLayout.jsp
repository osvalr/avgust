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
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/img/favicon.png">
    <title>SERNANP</title>
    
    <!--  Fix Compatibilidad HTML 5 (placeholder) en IE9 -->
    <!--[if (IE 9) & (!IEMobile)]>
	 <script src="<%=request.getContextPath()%>/assets/js/placeholders.jquery.min.js"></script>
	<![endif]-->

	<!-- CORE -->
	<link href="<%=request.getContextPath()%>/assets/css/core/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/assets/css/core/sernanp-theme2.css" rel="stylesheet" type="text/css">
	
	<!-- CUSTOM CSS  -->
	    
	<link href="<%=request.getContextPath()%>/assets/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<!-- VALIDATOR -->
	<link href="<%=request.getContextPath()%>/assets/plugins/bootstrapvalidator/css/bootstrapvalidator.min.css" rel="stylesheet" type="text/css" />
	<!-- DATATABLE -->
	<link href="<%=request.getContextPath()%>/assets/plugins/datatables/css/datatables.bootstrap.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/assets/plugins/datatables/css/datatables-responsive.css" rel="stylesheet" type="text/css">
	<!-- DATEPICKER -->
	<%-- <link href="<%=request.getContextPath()%>/assets/plugins/datepicker/css/datepicker.css" rel="stylesheet" type="text/css"> --%>
	<!--  UPLOAD ARCHIVOS -->
	<link href="<%=request.getContextPath()%>/assets/plugins/bootstrap-dialog/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css">
	    
	<!-- SERNANP DAVID -->
	<link type="text/css" href="<%=request.getContextPath()%>/assets/css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
	<link type="text/css" media="all" href="<%=request.getContextPath()%>/css/personal.css" rel="stylesheet"/>
	<!-- SERNANP DAVID -->
	    
	<link href="<%=request.getContextPath()%>/assets/plugins/bootstrap-touchspin-master/jquery.bootstrap-touchspin.css" rel="stylesheet" type="text/css" media="all">
	
	
	<!-- <!-- CORE JS -->
	<script src="<%=request.getContextPath()%>/assets/js/core/jquery-1.10.2.min.js" type="text/javascript"></script>
	<%-- <script src="<%=request.getContextPath()%>/assets/js/core/jquery-ui-1.11.0.min.js" type="text/javascript"></script> --%>
	<script src="<%=request.getContextPath()%>/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/assets/js/core/jquery.metismenu.js" type="text/javascript"></script>
	
	<!--  CUSTOM JS --> 
	
	<!-- VALIDADOR -->
	<script src="<%=request.getContextPath()%>/assets/plugins/bootstrapvalidator/js/bootstrapvalidator.min.js" type="text/javascript"></script>
	<!-- DATATABLES --> 
	<script src="<%=request.getContextPath()%>/assets/plugins/datatables/js/jquery.datatables.1.10.0.js" type="text/javascript" ></script>
	<script src="<%=request.getContextPath()%>/assets/plugins/datatables/js/datatables.bootstrap.js" type="text/javascript" ></script>
	<script src="<%=request.getContextPath()%>/assets/plugins/datatables/js/datatables-responsive.js" type="text/javascript" ></script>
	<!-- DATEPICKER -->
	<%-- <script src="<%=request.getContextPath()%>/assets/plugins/datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script> --%>
	<%-- <script src="<%=request.getContextPath()%>/assets/plugins/datepicker/local/bootstrap-datepicker.es.js" charset="UTF-8" type="text/javascript" ></script> --%>
	<!-- HOTKEYS-->
	<%-- <script src="<%=request.getContextPath()%>/assets/plugins/hotkeys/jquery-hotkeys.min.js" type="text/javascript"></script> --%>
	<!-- BREAKPOINTS-->
	<script src="<%=request.getContextPath()%>/assets/plugins/breakpoint/breakpoints.js" type="text/javascript"></script>
	<!-- PRINTAREA-->
	<script src="<%=request.getContextPath()%>/js/jquery.PrintArea.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/assets/plugins/bootstrap-touchspin-master/jquery.bootstrap-touchspin.js"></script>
	<!-- UPLOAD ARCHIVOS -->
	<%-- <script src="<%=request.getContextPath()%>/assets/plugins/bootstrap-dialog/js/bootstrap-dialog.min.js" type="text/javascript"></script> --%>
	<%-- <script src="<%=request.getContextPath()%>/assets/js/dropzone/dropzone.js" type="text/javascript"></script> --%>
	<%-- <script src="<%=request.getContextPath()%>/assets/js/dropzone/app.js" type="text/javascript"></script> --%>
	<!-- UPLOAD FILESTYLE -->
	<%-- <script src="<%=request.getContextPath()%>/assets/plugins/filestyle/bootstrap-filestyle.min.js" type="text/javascript"></script> --%>
	
	<!-- SERNANP DAVID -->
<%-- 	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/jquery-ui-1.10.0.custom.min.js"></script> --%>
<%-- 	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/otro/jquery-ui-1.10.4.min.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/jquery-ui-1.10.1.min.js"></script>
		
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.maskedinput.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/general.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/lib/_class.validator.js"></script>
	
	<script src="<tiles:getAsString name='js' />"></script>  
	<!-- SERNANP DAVID -->    
  </head>

  <body>

     <div id="wrapper">
    
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				
				<!-- HEADER -->
				<tiles:insertAttribute name="header" />
				<!-- END HEADER -->
			
			</nav>
	
			<div id="page-wrapper">
			
				<!-- BODY -->
				<tiles:insertAttribute name="content" />
				<!-- END BODY -->
				
				<!-- MODALES -->
				<tiles:insertAttribute name="content_buscar_expediente" />
				<tiles:insertAttribute name="content_buscar_persona" />
				
				<!-- END MODALES -->
			
			</div><!-- end page-wrapper -->

    </div><!-- end wrapper -->

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

	<div id="modalResultadoSolicitud" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">Estado de la solicitud</h4>
	      </div>
	      <div class="modal-body">
	      		<br/>
	     		
	     		<div id="msj_resultado"></div>
	     		
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-white" data-dismiss="modal">Cerrar</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


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


	<!-- CORE DEL NEGOCIO -->
	<script src="<%=request.getContextPath()%><tiles:getAsString name='core' />"></script>
	
	<script src="<%=request.getContextPath()%><tiles:getAsString name='jsfile' />"></script>
	<script src="<%=request.getContextPath()%><tiles:getAsString name='content_buscar_expediente_js' />"></script>
	<script src="<%=request.getContextPath()%><tiles:getAsString name='content_buscar_persona_js' />"></script>
	<script src="<%=request.getContextPath()%><tiles:getAsString name='content_subir_archivo_js' />"></script>
	
	
	
	<!-- END CUSTOM JS -->


	</body> 
</html>   