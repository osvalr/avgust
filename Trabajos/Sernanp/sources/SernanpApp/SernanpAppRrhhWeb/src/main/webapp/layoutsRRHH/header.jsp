<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 

        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="<%=request.getContextPath() %>">
          <img src="<%=request.getContextPath() %>/assets/img/logo.png" class="logo" alt="" data-src="<%=request.getContextPath() %>/assets/img/logo_sernanp.jpg" data-src-retina="<%=request.getContextPath() %>/assets/img/logo_sernanp.jpg" width="374" height="46">
          </a>
<!--           <a class="navbar-brand" href="index.html">SERNANP</a> -->
        </div>
       
        <div class="collapse navbar-collapse navbar-ex1-collapse">
        <div class="">
         
         <!-- MENU - SIDEBAR -->
         
     <ul class="nav navbar-nav side-nav sidebar-nav" id="menu">
        <li class="active"><a href="javascript:void(0);"><i class="fa fa-male"></i>&nbsp; Recursos Humanos</a>
          <ul class="">
            
          <s:iterator value="#session.listaMenuActual">

			<li class="active"> <a href="${hrefmodulo}"> <span class="">${nombremodulo}</span><span class=" "></span></a>
            </li>
		  </s:iterator>	
            
            
             
          </ul>
        </li>

        
     </ul>
    </div>  
   
     <!-- END MENU - SIDEBAR -->
          
   
          <ul class=" nav navbar-nav navbar-right navbar-user">
            
            <li class="dropdown user-dropdown">
              <a href="#" class="orange dropdown-toggle " data-toggle="dropdown"><i class="fa fa-question-circle"></i> Ayuda <b class="caret"></b></a>
              <ul class="dropdown-menu dropdown-menu-form">
                <li>
					 
					 <label class="checkbox" style="color:#000;">
						 <input type="checkbox" value="">
						 Ver Atajos de teclado
						
					</label>
				</li>
                
                
              </ul>
            </li>
            
            <li class="dropdown user-dropdown">
              <a href="#" class="orange dropdown-toggle " data-toggle="dropdown"><i class="fa fa-user"></i> ${USUARIO_ACTUAL.apepat} ${USUARIO_ACTUAL.apemat }, ${USUARIO_ACTUAL.nombre } <b class="caret"></b></a>
              <ul class="dropdown-menu ">
<!--                 <li><a href="#"><i class="fa fa-user"></i> Perfil</a></li> -->
<!--                 <li><a href="#"><i class="fa fa-gear"></i> Configuración</a></li> -->
<!--                 <li class="divider"></li> -->
                <li><a href="/diana/Salir.action"><i class="fa fa-power-off"></i> Cerrar Sesión</a></li>
              </ul>
            </li>
          </ul>
          
      </div>
       
      
      
 