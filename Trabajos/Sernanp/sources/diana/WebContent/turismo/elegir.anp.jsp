<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>     
 
<div id="loginLogo"><img width="150" alt="SERNANP" src="img/logo.sernanp.jpg" /> 
Sistema Integrado de SERNANP

</div>

 

<!-- Content -->
<!--  
<h1>Registro de Turistas</h1> 
-->
<p>Elija el Area Natural:</p> 

<div id="anps">
<s:iterator value="areasNaturales"> 
	<div class="l anp">    
		<a   style="cursor: pointer;" param='<s:property value="idareanatural" />'   
	    class="linkareanat" >
	     
	      
		<s:if test="%{siglasareanatural != null }">  
			<s:property value="siglasareanatural" /> -
		</s:if>  
		<s:property value="categoriaanp.descategoriaanp" /> 
		<strong>
		<span 
		<s:if test="%{desareanatural.trim().length()>23}">
		    style="font-size:9px"
		</s:if>
		>
		 <s:property value="desareanatural" />
		</span>
		</strong>  
		</a>  
	</div>  
</s:iterator> 
</div>
 