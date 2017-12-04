<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>     
 
<div id="loginLogo"><img width="150" alt="SERNANP" src="img/logo.sernanp.jpg" /> Sistema Integrado de SERNANP</div>
<!-- Content -->
<h1>Editar Actividades Turísticas en Áreas Naturales Protegidas</h1>    
<div id="anps"> 
<s:iterator value="areasNaturales"> 
	<div class="l anp">     
		<a href="#" > 
		<s:if test="%{siglasareanatural != null }">  
			<s:property value="siglasareanatural" /> -
		</s:if>  
		<s:property value="categoriaanp.descategoriaanp" /> 
		<strong><s:property value="desareanatural" /></strong>   
		</a>  
	</div>  
</s:iterator> 
</div>
  