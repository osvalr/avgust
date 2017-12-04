<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>SERNANP</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN PLUGIN CSS -->
<link href="<%=request.getContextPath()%>/assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/assets/plugins/jquery-slider/css/jquery.sidr.light.css" rel="stylesheet" type="text/css" media="screen"/>
<!-- END PLUGIN CSS -->

<!-- BEGIN PLUGIN CSS -->
<!-- <link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/> -->
<link href="<%=request.getContextPath()%>/assets/plugins/bootstrap-select2/select2.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/assets/plugins/bootstrap-datepicker/css/datepicker.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/assets/plugins/bootstrap-timepicker/css/bootstrap-timepicker.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/assets/plugins/boostrap-checkbox/css/bootstrap-checkbox.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/assets/plugins/ios-switch/ios7-switch.css" rel="stylesheet" type="text/css" media="screen">
<link href="<%=request.getContextPath()%>/assets/plugins/jquery-slider/css/jquery.sidr.light.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/assets/plugins/jquery-datatable/css/jquery.dataTables.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/plugins/datatables-responsive/css/datatables.responsive.css" rel="stylesheet" type="text/css" media="screen">


<!-- END PLUGIN CSS -->

<!-- BEGIN CORE CSS FRAMEWORK -->
<link href="<%=request.getContextPath()%>/assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/assets/plugins/boostrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/assets/css/animate.min.css" rel="stylesheet" type="text/css"/>
<!-- END CORE CSS FRAMEWORK -->

<!-- BEGIN CSS TEMPLATE -->
<link href="<%=request.getContextPath()%>/assets/css/style.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/assets/css/responsive.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/assets/css/custom-icon-set.css" rel="stylesheet" type="text/css"/>
<!-- END CSS TEMPLATE -->
<link href="<%=request.getContextPath()%>/assets/plugins/boostrap-slider/css/slider.css" rel="stylesheet" type="text/css"/>


<script src="<%=request.getContextPath()%>/assets/plugins/jquery-1.10.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/plugins/jquery-ui/jquery-ui-1.10.4.custom.js" type="text/javascript"></script>

<script type="text/javascript">

// $('#btnRegistrarConvocatoria').click(function () {

// });


</script>


</head>
<!-- BEGIN BODY -->
<body class="">
<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse ">
  <!-- BEGIN TOP NAVIGATION BAR -->
  <div class="navbar-inner">
    <div class="header-seperation">
      <ul class="nav pull-left notifcation-center" id="main-menu-toggle-wrapper" style="display:none">
        <li class="dropdown"> <a id="main-menu-toggle" href="#main-menu"  class="" >
          <div class="iconset top-menu-toggle-white"></div>
          </a> </li>
      </ul>
      <!-- BEGIN LOGO -->
      <a href="index-2.html"><img src="<%=request.getContextPath()%>/assets/img/logo.sernanp.jpg" class="logo" alt=""  data-src="<%=request.getContextPath()%>/assets/img/logo.sernanp.jpg" data-src-retina="assets/img/logo2x.png" width="222" height="31"/></a>
      <!-- END LOGO -->
      <ul class="nav pull-right notifcation-center">
        
      
        <li class="dropdown" id="portrait-chat-toggler" style="display:none"> <a href="#sidr" class="chat-menu-toggle">
          <div class="iconset top-chat-white "></div>
          </a> </li>
      </ul>
    </div>
    <!-- END RESPONSIVE MENU TOGGLER -->
    <div class="header-quick-nav" >
      <!-- BEGIN TOP NAVIGATION MENU -->
      <div class="pull-left">
        <ul class="nav quick-section">
          <li class="quicklinks"> <a href="#" class="" id="layout-condensed-toggle" >
            <div class="iconset top-menu-toggle-dark"></div>
            </a> </li>
        </ul>
        <ul class="nav quick-section">
          <li class="quicklinks"> <a href="#" class="" >
            <div class="iconset top-reload"></div>
            </a> </li>
          <li class="quicklinks"> <span class="h-seperate"></span></li>
          <li class="quicklinks"> <a href="#" class="" >
            <div class="iconset top-tiles"></div>
            </a> </li>
          <li class="m-r-10 input-prepend inside search-form no-boarder"> <span class="add-on" style="border-left:1px solid #c7cbcc;border-top:1px solid #c7cbce;border-bottom:1px solid #c7cbcc;"> <span class="iconset top-search"></span></span>
            <input name="" type="text"   placeholder="Search Dashboard" style="width:250px;">
          </li>
        </ul>
      </div>
      <!-- END TOP NAVIGATION MENU -->
      <!-- BEGIN CHAT TOGGLER -->
      <div class="pull-right">
        <div class="chat-toggler"> <a href="#" class="dropdown-toggle" id="my-task-list" data-placement="bottom"  data-content='' data-toggle="dropdown" data-original-title="Notifications">
          <div class="user-details">
            <div class="username"> Roger Alan <span class="bold">Mor√≥n Aquije</span> </div>
          </div>
          <div class="iconset top-down-arrow"></div>
          </a>
          <div id="notification-list" style="display:none">
            <div style="width:300px">
              <div class="notification-messages info">
                <div class="user-profile"> <img src="assets/img/profiles/d.jpg"  alt="" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" width="35" height="35"> </div>
                <div class="message-wrapper">
                  <div class="heading"> David Nester - Commented on your wall </div>
                  <div class="description"> Meeting postponed to tomorrow </div>
                  <div class="date pull-left"> A min ago </div>
                </div>
                <div class="clearfix"></div>
              </div>
              <div class="notification-messages danger">
                <div class="iconholder"> <i class="icon-warning-sign"></i> </div>
                <div class="message-wrapper">
                  <div class="heading"> Server load limited </div>
                  <div class="description"> Database server has reached its daily capicity </div>
                  <div class="date pull-left"> 2 mins ago </div>
                </div>
                <div class="clearfix"></div>
              </div>
              <div class="notification-messages success">
                <div class="user-profile"> <img src="assets/img/profiles/h.jpg"  alt="" data-src="assets/img/profiles/h.jpg" data-src-retina="assets/img/profiles/h2x.jpg" width="35" height="35"> </div>
                <div class="message-wrapper">
                  <div class="heading"> You haveve got 150 messages </div>
                  <div class="description"> 150 newly unread messages in your inbox </div>
                  <div class="date pull-left"> An hour ago </div>
                </div>
                <div class="clearfix"></div>
              </div>
            </div>
          </div>
         </div>
        <ul class="nav quick-section ">
          <li class="quicklinks"> <a data-toggle="dropdown" class="dropdown-toggle  pull-right " href="#" id="user-options">
            <div class="iconset top-settings-dark "></div>
            </a>
            <ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="user-options">
              <li><a href="user-profile.html"> My Account</a> </li>
              <li><a href="calender.html">My Calendar</a> </li>
             
              <li><a href="login.html"><i class="fa fa-power-off"></i>&nbsp;&nbsp;Log Out</a></li>
            </ul>
          </li>
          <li class="quicklinks"> <span class="h-seperate"></span></li>
          <li class="quicklinks"> <a id="chat-menu-toggle" href="#sidr" class="chat-menu-toggle" >
            <div class="iconset top-chat-dark "><span class="badge badge-important hide" id="chat-message-count">1</span></div>
            </a>
            <div class="simple-chat-popup chat-menu-toggle hide" >
              <div class="simple-chat-popup-arrow"></div>
              <div class="simple-chat-popup-inner">
                <div style="width:100px">
                  <div class="semi-bold">David Nester</div>
                  <div class="message">Hey you there </div>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
      <!-- END CHAT TOGGLER -->
    </div>
    <!-- END TOP NAVIGATION MENU -->
  </div>
  <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->
<!-- BEGIN CONTAINER -->
<div class="page-container row">
  <!-- BEGIN SIDEBAR -->
  <div class="page-sidebar" id="main-menu">
    <!-- BEGIN MINI-PROFILE -->
    <div class="page-sidebar-wrapper" id="main-menu-wrapper">

      <!-- BEGIN SIDEBAR MENU -->
      <p class="menu-title">NAVEGACI”N </p>
      <ul>
        <li class="start"> <a href="index-2.html"> <i class="icon-custom-home"></i> <span class="title">Dashboard</span> <span class="selected"></span> <span class="arrow"></span> </a> 
		   <ul class="sub-menu">
            <li > <a href="dashboard_v1.html"> Dashboard v1 </a> </li>
            <li class="active"> <a href="index-2.html"> Dashboard v2 <span class=" label label-info pull-right m-r-30">NEW</span></a></li>
          </ul>
		</li>
        <li class=""> <a href="javascript:;"> <i class="icon-custom-form"></i> <span class="title">Registro de Infracciones</span> <span class="arrow "></span> </a>
          <ul class="sub-menu">
            <li > <a href="form_elements.html">Menu 1 </a> </li>
            <li > <a href="form_validations.html">Menu 2</a> </li>
          </ul>
        </li>            
        <li class="active open "> <a href="javascript:;"> <i class="icon-custom-ui"></i> <span class="title">Recursos humanos</span> <span class="arrow open "></span> </a>
          <ul class="sub-menu">
            <li class="active"> <a href="typography.html"> Registro de Personal </a> </li>
            <li > <a href="messages_notifications.html"> Control de Personal </a> </li>
            <li> <a href="icons.html"> Selecci√≥n de Personal</a> </li>
            </ul>
        </li>
        
            
        <li class=""> <a href="javascript:;"> <i class="fa fa-folder-open"></i> <span class="title">Menu Levels</span> <span class="arrow "></span> </a>
          <ul class="sub-menu">
            <li > <a href="javascript:;"> Level 1 </a> </li>
            <li > <a href="javascript:;"> <span class="title">Level 2</span> <span class="arrow "></span> </a>
              <ul class="sub-menu">
                <li > <a href="javascript:;"> Sub Menu </a> </li>
                <li > <a href="ujavascript:;"> Sub Menu </a> </li>
              </ul>
            </li>
          </ul>
        </li>
       
      </ul>
       <div class="clearfix"></div>
      <!-- END SIDEBAR MENU -->
    </div>
  </div>
  <a href="#" class="scrollup">Scroll</a>
  <div class="footer-widget">
    <div class="progress transparent progress-small no-radius no-margin">
      <div class="progress-bar progress-bar-success animate-progress-bar" data-percentage="79%" style="width: 79%;"></div>
    </div>
    <div class="pull-right">
      <div class="details-status"> <span class="animate-number" data-value="86" data-animation-duration="560">86</span>% </div>
      <a href="lockscreen.html"><i class="fa fa-power-off"></i></a></div>
  </div>
  <!-- END SIDEBAR -->
  <!-- BEGIN PAGE CONTAINER-->
  <div class="page-content">
    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
    <div id="portlet-config" class="modal hide">
      <div class="modal-header">
        <button data-dismiss="modal" class="close" type="button"></button>
        <h3>Widget Settings</h3>
      </div>
      <div class="modal-body"> Widget settings form goes here </div>
    </div>
    <div class="clearfix"></div>
    <div class="content">
      <ul class="breadcrumb">
        <li>
          <p>Recursos humanos </p>
        </li>
        <li><a href="#" class="active">Registrar Convocatoria</a> </li>
      </ul>
      <div class="page-title">
        <h3>Registrar <span class="semi-bold">Convocatoria</span></h3>
      </div>
     
     
     
     
    
          
           
            
            
            <div class="row-fluid">
        <div class="span12">
          <div class="grid simple ">
            <div class="grid-title">
              <button type="button" id="btnRegistrarConvocatoria" onclick="registrar();" class="btn btn-info btn-cons">Registrar Convocatoria</button>
              <button type="button" class="btn btn-white btn-cons" onclick="filtrar();">Filtrar</button>
              </div>



<div class="grid-body" id="formRegistro" style="display: none;">

<div class="alert">
                  <button class="close" data-dismiss="alert"></button>
                  Warning:&nbsp;Your monthly traffic is reaching limit. </div>

			<form class="form-no-horizontal-spacing" id="form-condensed" novalidate="novalidate">	
              <div class="row">
                <div class="col-md-6">
                
                <h4 class="semi-bold">I. <span class="light">InformaciÛn de la Convocatoria</span></h4>
                                                     
                   <div class="row form-row">
                    
                      
                      <div class="col-md-6">
                        <input name="r_num_convocatoria" id="r_num_convocatoria" type="text" class="form-control" placeholder="N∫ de Convocatoria">
                      </div>
                      <div class="col-md-3">
                      
                        <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input  type="text" id="r_fecha_vigencia_inicio" name="r_fecha_vigencia_inicio" class="form-control" placeholder="F.V Inicio">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                        </div>    
                       
                                       
                    
                      </div>
                      <div class="col-md-3">
                       <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input name="r_fecha_vigencia_finaliza" id="r_fecha_vigencia_finaliza" type="text" class="form-control" placeholder="F.V Finaliza">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                      </div>
                      </div>
                   </div>
                   <div class="row form-row">   
                      <div class="col-md-12">
                        <textarea name="r_descripcion_convocatoria" id="r_descripcion_convocatoria" class="form-control" placeholder="DescripciÛn"></textarea>
                      </div>
                   </div>
                       
                   <div class="row form-row">   
                       <div class="col-md-12">
								<s:select cssClass="select2 form-control select2-offscreen" tabindex="-1" 
                        		  headerKey="" headerValue="Area Organica" list="listAreaOrganica" 
                        		  name="r_area_organica" id="r_area_organica" listKey="idarea" listValue="desarea" />
                      </div>
                      
                      </div>
                     
                </div>
               
              </div>
				<div class="form-actions">
					
					<div class="pull-left">
					  <button class="btn btn-primary btn-cons" type="button" onclick="registrarEditar()"><i class="icon-ok"></i> Grabar</button>
					  <button class="btn btn-white btn-cons" type="button">Cancelar</button>
					</div>
				  </div>
			</form>

</div>


<div class="grid-body" id="formFiltrar" style="display: none;">

			<form class="form-no-horizontal-spacing" id="form-condensed" novalidate="novalidate">	
              <div class="row">
                <div class="col-md-6">
                
                <h4 class="semi-bold">II. <span class="light">Filtrar Convocatorias</span></h4>
                                                     
                   <div class="row form-row">
                    
                      
                      <div class="col-md-3">
                        <input name="f_num_convocatoria" id="f_num_convocatoria" name="f_num_convocatoria" type="text" class="form-control" placeholder="N∫ de Convocatoria">
                      </div>
                      <div class="col-md-3">
                        <input name="f_anho_convocatoria" id="f_anho_convocatoria" name="f_anho_convocatoria" type="text" class="form-control" placeholder="AÒo">
                      </div>
                      <div class="col-md-3">
                      
                        <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input  type="text" id="f_fecha_vigencia_inicio" name="f_fecha_vigencia_inicio" class="form-control" placeholder="F.V Inicio">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                        </div>    
                       
                      </div>
                      <div class="col-md-3">
                       <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input name="f_fecha_vigencia_finaliza" id="f_fecha_vigencia_finaliza" type="text" class="form-control" placeholder="F.V Finaliza">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                      </div>
                      </div>
                   </div>
                   <div class="row form-row">   
                      <div class="col-md-12">
                        <textarea name="f_descripcion_convocatoria" id="f_descripcion_convocatoria" class="form-control" placeholder="DescripciÛn"></textarea>
                      </div>
                   </div>
                       
                   <div class="row form-row">   
                       
                      <div class="col-md-3">
                      
                        <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input  type="text" id="f_fecha_registro_desde" name="f_fecha_registro_desde" class="form-control" placeholder="F.R Desde">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                        </div>    

                      </div>
                      
                      <div class="col-md-3">
                       <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input name="f_fecha_registro_hasta" id="f_fecha_registro_hasta" type="text" class="form-control" placeholder="F.R Hasta">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                      </div>
                      
                      </div>
                       
                       <div class="col-md-6">
<%--                            <select name="f_area_organica" id="f_area_organica" class="select2 form-control select2-offscreen" tabindex="-1"> --%>
<!--                           <option value="">Area Organica</option> -->
<!--                           <option value="1">DNI</option> -->
<!--                           <option value="2">Female</option> -->
<%--                         </select> --%>
                        
                        <s:select cssClass="select2 form-control select2-offscreen" tabindex="-1" 
                        		  headerKey="" headerValue="Area Organica" list="listAreaOrganica" 
                        		  name="f_area_organica" id="f_area_organica" listKey="idarea" listValue="desarea" />
                        
                      </div>
                      

                      
                      </div>
                      <div class="row form-row">   
                      
                      <div class="col-md-6">
                           <select name="f_estado_convocatoria" id="f_estado_convocatoria" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">En Proceso</option>
                          <option value="2">Desierto</option>
                          <option value="3">Finalizado</option>
                        </select>
                      </div>
                      
                      </div>
                </div>
               
              </div>
				<div class="form-actions">
					
					<div class="pull-left">
					  <button class="btn btn-primary btn-cons" type="button" onclick="iniciarFiltro()"><i class="icon-ok"></i> Filtrar</button>
					  <button class="btn btn-white btn-cons" type="button">Cancelar</button>
					</div>
				  </div>
			</form>

</div>


            <div class="grid-body">
	
			<div class="row">
			
			<table class="table table-striped dataTable" id="tableDefault" >
               
                <thead>     
                  <tr>
                    <th>Numero</th>
                    <th>Descripcion</th>
                    <th>Area Organica</th>
                    <th>F.V Inicia</th>
                    <th>F.V Finaliza</th>
                    <th>Estado</th>
                    <th>Fecha de registro</th>
                    <th>Edicion</th>
                    <th>Cambiar Estado</th>
                  </tr>
                </thead>
                
           </table>
			
			</div>
			
            </div>
          </div>

      </div>

    <!-- END PAGE -->
  </div>
</div>

<!-- END CONTAINER -->
<!-- BEGIN CORE JS FRAMEWORK-->


<script src="<%=request.getContextPath()%>/assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/breakpoints.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script> 
<!--  END CORE JS FRAMEWORK  -->
<!--  BEGIN PAGE LEVEL JS  -->
 <script src="<%=request.getContextPath()%>/assets/plugins/pace/pace.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/modernizr.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-slider/jquery.sidr.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-numberAnimate/jquery.animateNumbers.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>  
 <script src="<%=request.getContextPath()%>/assets/plugins/boostrap-slider/js/bootstrap-slider.js" type="text/javascript"></script> 
<!--  END PAGE LEVEL PLUGINS  -->
<!--  BEGIN PAGE LEVEL JS  -->
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-slider/jquery.sidr.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-block-ui/jqueryblockui.js" type="text/javascript"></script>  
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-numberAnimate/jquery.animateNumbers.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/pace/pace.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/bootstrap-select2/select2.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/boostrap-form-wizard/js/jquery.bootstrap.wizard.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-datatable/js/jquery.dataTables.min.js" type="text/javascript" ></script>
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-datatable/extra/js/TableTools.min.js" type="text/javascript" ></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/assets/plugins/datatables-responsive/js/datatables.responsive.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/assets/plugins/datatables-responsive/js/lodash.min.js"></script>
<!--  END PAGE LEVEL PLUGINS  -->

 <script src="<%=request.getContextPath()%>/assets/js/form_validations.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/js/datatables.js" type="text/javascript"></script>
<!--  PAGE JS  -->
 <script src="<%=request.getContextPath()%>/assets/js/icon.js" type="text/javascript"></script> 
<!--  BEGIN CORE TEMPLATE JS  -->
 <script src="<%=request.getContextPath()%>/assets/js/core.js" type="text/javascript"></script> 
 <script src="<%=request.getContextPath()%>/assets/js/chat.js" type="text/javascript"></script>  
 <script src="<%=request.getContextPath()%>/assets/js/demo.js" type="text/javascript"></script> 
<!--  END CORE TEMPLATE JS  -->
<!--  END JAVASCRIPTS  -->

</body>

<script type="text/javascript">
var oTableDefault = null;

$(document).ready(function() {
	
	$('#f_anho_convocatoria').val(new Date().getFullYear());
	$('#r_num_convocatoria').prop('readonly', true);
	//ocultarFomrs();
	iniciarFiltro();
	
	
    
    oTableDefault = $('#tableDefault').dataTable( {
 	   "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'p i>>",
        "aaSorting": [],
 		"oLanguage": {
 			"sLengthMenu": "_MENU_ ",
 			"sInfo": "Showing <b>_START_ to _END_</b> of _TOTAL_ entries"
 		},
 		"scrollY": 200,
        "scrollX": true,
        "scrollCollapse": true,
 		"sAjaxDataProp": "listConvocatorias",
 		"sAjaxSource": null,
		"aoColumns" : 
			[ 
				{"mData" : "var_num_convocatoria"}, 
				{"mData" : "var_nombre_convocatoria"},
				{"mData" : "desarea"},
				{"mData" : "dte_fecha_vegencia_inicio"}, 
				{"mData" : "dte_fecha_vigencia_fin"},
				{"mData" : "estado_descrip"},
				{"mData" : "tsp_fecha_registro"},
				{"mData" : "var_num_convocatoria"},
				{"mData" : "var_num_convocatoria"},
			]
 		, "aoColumnDefs": [
 		                  {
 		                       "aTargets": [7],
 		                       "mData": null,
 		                       "mRender": function (data, type, full) {
 		                           return '<button class="btn btn-success" onclick="alert(\''+ data +'\');">Editar</button>';
 		                       }
 		                   },
 		                  {
 		                       "aTargets": [8],
 		                       "mData": null,
 		                       "mRender": function (data, type, full) {
 		                           return '<button class="btn btn-success" onclick="alert(\''+ data +'\');">Cambiar Estado</button>';
 		                       }
 		                   }
 		                ]
     });
    
    $('#f_fecha_registro_desde, #f_fecha_registro_hasta').datepicker({
        showOn: "both",
        dateFormat: 'dd-mm-yy',
        changeYear: true,
        changeMonth: true,
        firstDay: 1, 
        changeFirstDay: false
    });
    
});	

function iniciarFiltro(){
	
	parametros = {
			"num_convocatoria": $('#f_num_convocatoria').val(),
			"anho_convocatoria": $('#f_anho_convocatoria').val(),
			"fecha_vegencia_inicio": $('#f_fecha_vigencia_inicio').val(),
			"fecha_vigencia_fin": $('#f_fecha_vigencia_finaliza').val(),
			"nombre_convocatoria": $('#f_descripcion_convocatoria').val(),
			"fecha_registro_desde": $('#f_fecha_registro_desde').val(),
			"fecha_registro_hasta": $('#f_fecha_registro_hasta').val(),
			"id_area_organica": $('#f_area_organica').val(),
			"estado": $('#f_estado_convocatoria').val()
		 };
	
	$.getJSON("<%=request.getContextPath()%>/filtrar-convocatorias.action", parametros, function(json){
		
		var oSettings = oTableDefault.fnSettings();
		
		oTableDefault.fnClearTable(this);
		
	    for (var i=0; i<json.listConvocatorias.length; i++)
	    {
	    	oTableDefault.oApi._fnAddData(oSettings, json.listConvocatorias[i]);
	    }
	    
	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    
	    oTableDefault.fnDraw();
	});
	
}

function registrarEditar(){
	
	parametros = {
			"fecha_vegencia_inicio": $('#r_fecha_vigencia_inicio').val(),
			"fecha_vigencia_fin": $('#r_fecha_vigencia_finaliza').val(),
			"nombre_convocatoria": $('#r_descripcion_convocatoria').val(),
			"id_area_organica": $('#r_area_organica').val()
		 };
	
	$.ajax({
	        url: '<%=request.getContextPath()%>/registrar-editar-convocatoria.action',
	        type: 'POST',
	        dataType:"json",
	        data:parametros,
	        async:false,
	        success: function(json) {
	          //alert(json.transaccionUtil.codigoGenerado);
	          iniciarFiltro();
	        },
	        error: function(jqXHR, textStatus, error) {
	          alert( "error: " + jqXHR.responseText);
	        }
      });
		
}

function ocultarFomrs(){
	 $('#formFiltrar').hide(500);
	 $('#formRegistro').hide(500);
}

function registrar() {
    $('#formRegistro').toggle(500);
    $('#formFiltrar').hide(500);
}
function filtrar() {
    $('#formFiltrar').toggle(500);
    $('#formRegistro').hide(500);
}
 </script> 
</html>
