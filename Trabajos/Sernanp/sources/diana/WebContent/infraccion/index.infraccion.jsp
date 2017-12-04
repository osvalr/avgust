 <%@page pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<h1>Infracciones</h1>

	<h4>Elija la acci&oacute;n que desea realizar:</h4>
<!-- 
	<div class="shortcuts">		
		   <s:iterator value="#session.listaMenuActual">		   
		   	<a class="r linkmenuportada"  param="<s:property value="idmodulo" />" name="idmodulomenu" >
		   	<param  id="param2" value="<s:property value="hrefmodulo" />" name="param2" />		   
		   	<img  alt="Registro" src="img/icons/<s:property value="imgmodulo" /> " />
		   	<s:property value="nombremodulo" />
		   </a>					
		  </s:iterator>	
	</div>
	-->
	<div id="opcionesmodulo">
	<div class="shortcuts">
		   <s:iterator value="#session.listaMenuActual">
					<a class="r linkopcionmodulo" >
					    <param  id="paramidmodulo" value="${idmodulo}" />    
						<param  id="paramhrefmodulo" value="${hrefmodulo}" />
						<img  alt="Registro" src="img/icons/<s:property value="imgmodulo"/> " />
						${nombremodulo} 
					</a>
					
		  </s:iterator>	
	</div>
</div>