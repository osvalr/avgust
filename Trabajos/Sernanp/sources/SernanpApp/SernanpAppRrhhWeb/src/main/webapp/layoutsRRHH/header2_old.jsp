<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<div class="navbar-top"> 
<!--     <div class="container"> -->
      <div class="row">
        <div class="col-lg-6 col-sm-6 col-xs-6 col-md-6">
        
        <div class="pull-left ">
            <a href="<%=request.getContextPath() %>">
          		<img src="<%=request.getContextPath() %>/assets/img/logo.png" class="logo" alt="" data-src="<%=request.getContextPath() %>/assets/img/logo_sernanp.jpg" data-src-retina="<%=request.getContextPath() %>/assets/img/logo_sernanp.jpg" width="374" height="46">
            </a>
          
          </div>
<!--            <ul class="nav navbar-nav" style="padding-bottom:8px; "> -->
<!--                 <li class="active"> -->
<!--                    <a href="#" style="background-color:#8F857D">Recursos Humanos</a> -->
<!--                 </li> -->
<!--             </ul>    -->
        </div>
        <div class="col-lg-6 col-sm-6 col-xs-6 col-md-6 ">
          <div class="pull-right">
           <ul class="orange nav navbar-nav navbar-right">
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle white" data-toggle="dropdown"><i class="fa fa-user"></i>
               <s:property value="%{#session.USUARIO_ACTUAL.apepat}" />
               <s:property value="%{#session.USUARIO_ACTUAL.apemat}" />
               <s:property value="%{#session.USUARIO_ACTUAL.nombre}" />
                <s:property value="%{#session.USUARIO_ACTUAL.personal.idpersonal}" />
               <b class="caret"></b></a>
              <ul class="dropdown-menu ">
<!--                 <li><a href="#"><i class="fa fa-user"></i> Perfil</a></li> -->
<!--                 <li><a href="#"><i class="fa fa-gear"></i> Configuración</a></li> -->
<!--                 <li class="divider"></li> -->
                <li><a href="/diana/Salir.action"><i class="fa fa-power-off"></i> Cerrar Sesión</a></li>
              </ul>
            </li>
            </ul>
          </div>
        </div>
      </div>
<!--     </div> -->
  </div>
  
  <div class="container-fluid sub-menu">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
          </button>
          
<!--           <a class="navbar-brand" href="index.html">SERNANP</a> -->
      </div>
  
        
     <!-- MENU HORIZONTAL -->
     <div class="collapse navbar-collapse">
            
            <ul class="nav navbar-nav">
                <li class="active">
                	<a href="#"> <i class="fa fa-bars"></i></a>
                </li>
                <s:iterator value="#session.listaMenuActual">
                <li>
<%--                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">${nombremodulo} <b class="caret"></b></a> --%>
					<a href="${hrefmodulo}" >${nombremodulo} </a>

                </li>
                </s:iterator>
              
                
                <li>
                	<a href="javascript:void(0)" onclick="mostrarReporte()"> Reportes</a>
					<script src="<%=request.getContextPath()%>/assets/js/otro/core_menu_reporte.js" type="text/javascript"></script>
                </li>
                
            </ul>
       <!-- </div>/.nav-collapse -->
  <!-- END MENU HORIZONTAL -->   
     
   
     <!-- END MENU - SIDEBAR -->
          
   
          
          
      </div>
    </div>    
    

     
      
 