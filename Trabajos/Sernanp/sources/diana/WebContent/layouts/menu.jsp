<%@taglib prefix="s" uri="/struts-tags"%>

<div id="headerMenu" class="">
	<form  id="formMenu"     method="post" >
	<input   id="hdmodulo"   type="hidden" name="idmodulo"  
	  value='<s:property value="#session.idmoduloactual"/>'  />
	
	
	<input   id="hdareanatural"   type="hidden" name="idarea"  />
	<input   id="seccadena_" type="hidden" name="seccadena_"  /> <!-- Agregado 29/04/11 14:49 (Yonny) -->
	
	
	<ul id="navmenu-h">
	
	
	  <s:if test="%{#session.noMuestraMenu!=1}">
	 <s:iterator value="#session.listaMenuActual">
				<li>
				<a  class="linkopcionmodulo" style="cursor: pointer;"   
					title="Ir al Módulo de <s:property	value="nombremodulo" />"> 
					<param  id="paramidmodulo" value="${idmodulo}" />    
				    <param  id="paramhrefmodulo" value="${hrefmodulo}" />
			         ${nombremodulo}
			    </a>
					
				</li>
			
    </s:iterator>
	</s:if>
<!--    <s:if test="%{#session.idmoduloactual!=0}">-->
<!--      <li style="float:right">-->
<!--      <a  class="linkvolvermenu" href='#' > -->
<!--     Volver-->
<!--      </a>-->
<!--    </li>-->
<!--    </s:if>-->
    
	
	 </ul>

	</form>
</div> 