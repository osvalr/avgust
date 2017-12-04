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
  
      <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse_menu">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
         
     <!-- MENU HORIZONTAL -->
     <div class="collapse navbar-collapse" id="collapse_menu">
                       
            <ul class="nav navbar-nav">                                
                
                <li class="active">
                	<a href="#"> <i class="fa fa-bars"></i></a>
              	</li>                 
    
                <s:iterator value="#session.listaMenuActual" var="nivel1">
                <li>
                	<s:if test="#nivel1.nivelmodulo==2">                	
                		<s:if test="#nivel1.hrefmodulo.equalsIgnoreCase('#')"> 
                		
                			<s:if test="#nivel1.idmodulo==232">
                				<a href="javascript:void(0)" onclick="mostrarReporte()"> Reportes</a>
                				<script src="<%=request.getContextPath()%>/assets/js/otro/core_menu_reporte.js" type="text/javascript"></script>
                			</s:if>
                			
                			<s:else>
								<a href="${nivel1.hrefmodulo}" data-toggle="dropdown">${nivel1.nombremodulo}</a>
	                		<ul class="dropdown-menu">
		                		<s:iterator value="#session.listaMenuActual" var="nivel2">
		                	
				                	<s:if test="#nivel2.nivelmodulo==3">
				                	
				                		<s:if test="#nivel2.niveldependemodulo==#nivel1.idmodulo">
				                		
				                			<s:if test="#nivel2.hrefmodulo.equalsIgnoreCase('#')">                		
												
												<li class="dropdown-submenu"> 
												    <a tabindex="-1" href="${nivel2.hrefmodulo}">${nivel2.nombremodulo}</a>
												    <ul class="dropdown-menu">
												    
														<s:iterator value="#session.listaMenuActual" var="nivel3">
					                	
									                	<s:if test="#nivel3.nivelmodulo==4">
									                	
									                		<s:if test="#nivel3.niveldependemodulo==#nivel2.idmodulo">
									                		
									                			<li>
									                				<a tabindex="-1" href="${nivel3.hrefmodulo}">${nivel3.nombremodulo}</a>
									                			</li>
									                			
									                		</s:if>
									                		
									                	</s:if>
									                	
									                	</s:iterator>
												
													</ul>
							                	</li>
							                		
					                		</s:if>
					                		<s:else>
											<li><a href="${nivel2.hrefmodulo}">${nivel2.nombremodulo}</a></li>
					                		</s:else>
				                			
				                		</s:if>
				                	
				                	</s:if>
			                	
			                	</s:iterator>
			                	
			                </ul>
                			</s:else>               		

                		</s:if>
                		<s:else>
                			<a href="${nivel1.hrefmodulo}">${nivel1.nombremodulo} </a>                		
                		</s:else>                		
                	</s:if>
                </li> 
                </s:iterator>                              
            </ul>            
            
     </div>
     <!-- END MENU HORIZONTAL -->     
     
  </div> 
  
  
  
  
   <!-- MENU ANTERIOR --> 
  
  
<!--   <div class="container-fluid sub-menu"> -->
<!--       <div class="navbar-header"> -->
<!--           <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> -->
<%-- 	            <span class="sr-only">Toggle navigation</span> --%>
<%-- 	            <span class="icon-bar"></span> --%>
<%-- 	            <span class="icon-bar"></span> --%>
<%-- 	            <span class="icon-bar"></span> --%>
<!--           </button> -->
<!--       </div>         -->
<!--      MENU HORIZONTAL -->
<!--      <div class="collapse navbar-collapse">             -->
<!--             <ul class="nav navbar-nav"> -->
<!--                 <li class="active"> -->
<!--                 	<a href="#"> <i class="fa fa-bars"></i></a> -->
<!--                 </li>                 -->
<%--                 <s:iterator value="#session.listaMenuActual"> --%>
<!--                 <li> -->
<%-- 					<a href="${hrefmodulo}" >${nombremodulo} </a> --%>
<!--                 </li> -->
<%--                 </s:iterator>                 --%>
<!--             </ul>           -->
<!--       </div> -->
<!--     </div>       -->

                
<!--                  <li> -->
<!--                 	<a href="javascript:void(0)" onclick="mostrarReporte()"> Reportes</a> -->


