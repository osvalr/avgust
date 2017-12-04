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
<link href="<%=request.getContextPath()%>/assets/plugins/jquery-datatable/css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>

<link href="<%=request.getContextPath()%>/assets/plugins/boostrap-checkbox/css/bootstrap-checkbox.css" rel="stylesheet" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/plugins/ios-switch/ios7-switch.css" type="text/css" media="screen">
<link href="<%=request.getContextPath()%>/assets/plugins/jquery-slider/css/jquery.sidr.light.css" rel="stylesheet" type="text/css" media="screen"/>
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
            <div class="username"> Roger Alan <span class="bold">Moron Aquije</span> </div>
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
      <p class="menu-title">NAVEGACI覰 </p>
      <ul>
<!--        <li class="active open "> <a href="javascript:;"> <i class="icon-custom-ui"></i> <span class="title">Recursos humanos</span> <span class="arrow open "></span> </a> -->
<!--           <ul class="sub-menu"> -->
<!--             <li class="active"> <a href="typography.html"> Desplazamiento y Asistencia </a> </li> -->
<!--             <li> <a href="messages_notifications.html"> Control de Personal </a> </li> -->
<!--             <li> <a href="icons.html"> Selecci髇 de Personal</a> </li> -->
<!--             </ul> -->
<!--         </li> -->
        
        
       <li class="active open"> <a href="javascript:;"> <i class="fa icon-custom-form"></i> <span class="title">Recursos Humanos</span> <span class="arrow open"></span> </a>
          <ul class="sub-menu">
            <li> <a href="../convocatoria/Registrar.Convocatoria.Edicion.html"> <span class="">Convocatorias</span><span class="arrow "></span></a>
<!--             <ul class="sub-menu"> -->
<!--                 <li> <a href="../convocatoria/Registrar.Convocatoria.Edicion.html"> Registrar Convocatoria </a> </li> -->
<!--               </ul> -->
            </li>
            <li> <a href="../personal/Gestionar.Personal.Legajo.html"> <span class="title">Personal y Legajos</span><span class="arrow "></span></a>
<!--             <ul class="sub-menu"> -->
<!--                 <li> <a href="../personal/Gestionar.Personal.Legajo.html"> Gestionar Personal y Legajos </a> </li> -->
<!--             </ul> -->
             </li>
            <li> <a href="../contrato_adenda/Consultar.Contrato.Adenda.html"> <span class="title">Contrato y Adendas</span><span class="arrow "></span></a>
<!--             <ul class="sub-menu"> -->
<!--                 <li> <a href="../contrato_adenda/Gestionar.Contrato.Adenda.html"> Gestionar Contratos y Adendas </a> </li> -->
<!--                 <li> <a href="../contrato_adenda/Consultar.Contrato.Adenda.html"> Consultar Contratos y Adendas </a> </li> -->
<!--               </ul> -->
            </li>
            <li> <a href="../expediente/Gestionar.Expediente.html"> <span class="title">Expedientes</span><span class="arrow "></span></a>
<!--               <ul class="sub-menu"> -->
<!--                 <li> <a href="../expediente/Gestionar.Expediente.html"> Gestionar Expediente </a> </li> -->
<!--               </ul> -->
            </li>
          </ul>
        </li>
              
        <li class=""> <a href="javascript:;"> <i class="icon-custom-ui"></i> <span class="title">Registro de Infracciones</span> <span class="arrow "></span> </a>
          <ul class="sub-menu">
            <li class=""> <a href="#">Opcion1</a> </li>
            <li> <a href="#">Opcion2</a> </li>
            <li> <a href="#">Opcion3</a> </li>
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
          <p>Recursos Humanos </p>
        </li>
        <li><a href="#" class="active">Registrar Postulante</a> </li>
      </ul>
      <div class="page-title"> 
        <h3>Registrar <span class="semi-bold">Postulante</span></h3>
      </div>
     
    

    
        
    
    <div class="row-fluid">
        <div class="span12">
        
        
          <div class="grid simple">
          
            <div class="grid-title">
            
            <button class="btn btn-success btn-cons" type="button" onclick="buscarExpediente()"><i class="icon-ok"></i> Filtrar</button>
            </div>
            
          
              <div class="grid-body no-border">          
         <form class="form-no-horizontal-spacing" id="form-condensed" novalidate="novalidate">
             <div class="row ">
             <div class="col-md-6">
                     <br>
                        <h4 class="semi-bold">1. <span class="light">Informaci贸n</span> <span class="semi-bold">B谩sica</span></h4>
                     <br>          
                    <div class="row form-row">
                      <div class="col-md-12">
                        <input name="form3FirstName" id="form3FirstName" type="text" class="form-control" placeholder="Nombres">
                      </div>
                      <div class="col-md-6">
                        <input name="form3LastName" id="form3LastName" type="text" class="form-control" placeholder="Apellido Paterno">
                      </div>
                       <div class="col-md-6">
                        <input name="form3LastName" id="form3LastName" type="text" class="form-control" placeholder="Apellido Materno">
                      </div>
                      <div class="col-md-6">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Tipo de documento</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                       <div class="col-md-6">
                        <input name="form3LastName" id="form3LastName" type="text" class="form-control" placeholder="N脙潞mero de documento">
                      </div>
                      
                    </div>
                   
                    <div class="row form-row">
                      <div class="col-md-6">
                        <div class="radio">
                          <input id="male" type="radio" name="gender" value="Masculino" checked="checked">
                          <label for="male">Masculino</label>
                          <input id="female" type="radio" name="gender" value="Femenino">
                          <label for="female">Femenino</label>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <input name="form3Occupation" id="form3Occupation" type="text" class="form-control" placeholder="Fecha de Nacimiento">
                      </div>
                      
                    </div>
                   <div class="row form-row" style="padding-bottom:13px"> 
                      
                       <div class="col-md-6">
                        <input name="form3LastName" id="form3LastName" type="text" class="form-control" placeholder="RUC">
                      </div>
                      
                      
                      <div class="col-md-6">
                        
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1"> 
                          <span class="select2-chosen">Departamento</span><abbr class="select2-search-choice-close"></abbr>   
                          <span class="select2-arrow"><b></b></span></a>
                          <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                          <div class="select2-drop select2-display-none select2-with-searchbox">   
                          <div class="select2-search">      
                          <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input">   </div> 
                           <ul class="select2-results">   </ul>
                           </div>
                           </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      
                      </div>
                   </div>   
                   
                    <div class="row form-row" style="padding-bottom:13px">
                      
                       <div class="col-md-6">
                       <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1"> 
                          <span class="select2-chosen">Provincia</span><abbr class="select2-search-choice-close"></abbr>   
                          <span class="select2-arrow"><b></b></span></a>
                          <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                          <div class="select2-drop select2-display-none select2-with-searchbox">   
                          <div class="select2-search">      
                          <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input">   </div> 
                           <ul class="select2-results">   </ul>
                           </div>
                           </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      
                      </div>
                      
                      
                      <div class="col-md-6">
                      <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1"> 
                          <span class="select2-chosen">Distrito</span><abbr class="select2-search-choice-close"></abbr>   
                          <span class="select2-arrow"><b></b></span></a>
                          <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                          <div class="select2-drop select2-display-none select2-with-searchbox">   
                          <div class="select2-search">      
                          <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input">   </div> 
                           <ul class="select2-results">   </ul>
                           </div>
                           </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                     
                      
                    </div>
                    
                    </div>
                    
                    <div class="row form-row">
                      <div class="col-md-12">
                        <input name="form3Email" id="form3Email" type="text" class="form-control" placeholder="Direcci贸n">
                      </div>
                    </div>
                
				    
                        <h4 class="semi-bold">2. <span class="light">Lugar de</span> <span class="semi-bold">Nacimiento</span></h4>
                     <br>
                  
                  
                    <div class="row form-row" style="padding-bottom:13px">
                     <div class="col-md-6">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Pa脙颅s</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div> 
                   <div class="col-md-6">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Departamento</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                      
                       
                    </div>
                    
                     <div class="row form-row" style="padding-bottom:13px">
                     <div class="col-md-6">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Provincia</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div> 
                   <div class="col-md-6">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Distrito</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                      
                       
                    </div>
                    
				     
                      
                       
                    </div>
                    
                    
                    
                   
                   
             
                
                
                <div class="col-md-6">
                
                
                <br>
                        <h4 class="semi-bold">3. <span class="light">Otra</span> <span class="semi-bold">Informaci贸n</span></h4>
                     <br>
                  
                  
                    <div class="row form-row" style="padding-bottom:13px">
                     <div class="col-md-6">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Estado Civil</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                      
                   <div class="col-md-6">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Grado de Instrucci贸n</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                      
                       
                    </div>
                    
                    
                    
                     <div class="row form-row" style="padding-bottom:13px">
                     <div class="col-md-4">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Licencia</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                      
                   <div class="col-md-4">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Clase</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                      
                      <div class="col-md-4">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Categoria</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                      
                       
                    </div>
                    
                    
                    
                   
                    
                     <div class="row form-row">
                      
                       
                      
                        <div class="col-md-2">
                        <input name="form3Occupation" id="form3Occupation" type="text" class="form-control" placeholder="Cod. Ciudad">
                      </div>
                       <div class="col-md-4">
                        <input name="form3Occupation" id="form3Occupation" type="text" class="form-control" placeholder="Tel脙漏fono">
                        </div>
                      
                      
                         <div class="col-md-6">
                        <input name="form3Occupation" id="form3Occupation" type="text" class="form-control" placeholder="Celular">
                      </div>                 
                      
                    </div>
                    
                     <div class="row form-row">
                      
                      
                                                           
                       <div class="col-md-12">
                        <input name="form3Occupation" id="form3Occupation" type="text" class="form-control" placeholder="Correo electr贸nico">
                      </div>                   
                      
                    </div>
                    
                    
                    
                        <h4 class="semi-bold">4. <span class="light">Informaci贸n de</span> <span class="semi-bold">Convocatoria</span></h4>
                     <br>
                  
                  
                    <div class="row form-row" style="padding-bottom:13px">
                     <div class="col-md-6">
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Convocatoria</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input disabled type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                      </div>
                      
                   <div class="col-md-6">
                        <input name="form3Occupation" id="form3Occupation" type="text" class="form-control" placeholder="Orden de M脙漏rito" disabled>
                      </div> 
                
                
                </div>
                
                
                
             </div>
                  </div>
             
             <div class="form-actions">
					
					<div class="pull-right">
					  <button class="btn btn-success btn-cons" type="submit"><i class="icon-ok"></i> Grabar</button>
					  <button class="btn btn-white btn-cons" type="button">Cancelar</button>
					</div>
				  </div>
				       
             </form>
                 
             </div><!--end grid-body -->
           
          </div><!-- end grid simple -->
        </div><!-- end span12 -->
      </div><!-- end row-fluid -->
    
      
      <br>
     
      
    <!-- END PAGE -->
  </div>
</div>


<!-- Modal -->
<div id="modalBuscarExpedientes" class="modal modal-wide fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title"> Modal </h4>
      </div>
      <div class="modal-body" id="modalBuscarExpedientesBody">
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- END CONTAINER -->
<!-- BEGIN CORE JS FRAMEWORK-->
<script src="<%=request.getContextPath()%>/assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>

 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-datatable/js/jquery.dataTables.min.js" type="text/javascript" ></script>
 <script src="<%=request.getContextPath()%>/assets/plugins/jquery-datatable/extra/js/TableTools.min.js" type="text/javascript" ></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/assets/plugins/datatables-responsive/js/datatables.responsive.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/assets/plugins/datatables-responsive/js/lodash.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/datatables.js" type="text/javascript"></script>

</body>
<script type="text/javascript">

$(document).ready(function() {
    
	$(".modal-wide").on("show.bs.modal", function() {
		  var height = $(window).height() - 100;
		  $(this).find(".modal-body").css("max-height", height);
	});
	

    
});	

function buscarExpediente(){
	
	$('#modalBuscarExpedientes').modal('toggle');
	
	$.ajax({
        url: '<%=request.getContextPath()%>/vistas/expediente/Buscar.Expediente.jsp',
        type: 'POST',
        dataType:"text",
        async:false,
        success: function(data) {
        	$('#modalBuscarExpedientesBody').html(data);
        },
        error: function(jqXHR, textStatus, error) {
          alert( "error: " + jqXHR.responseText);
        }
    });
	
	
    oTableDefault = $('#tableDefault').dataTable( {
   	   "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'p i>>",
          "aaSorting": [],
   		"oLanguage": {
   			"sLengthMenu": "_MENU_ ",
   			"sInfo": "Showing <b>_START_ to _END_</b> of _TOTAL_ entries"
   		}
   	   //,
   		//"sScrollY": "300px",
   	    //"sScrollX": "100%",
   	    //"sScrollXInner": "100%",
   	    //"bScrollCollapse": true,
    });
	
}

 </script> 

</html>

