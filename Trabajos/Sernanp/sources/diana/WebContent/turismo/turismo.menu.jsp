<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>     
 
<!-- Content -->

<h1>Turismo<br /><span> 
	<s:property value="#session.area.categoriaanp.descategoriaanp" />  
    <s:property value="#session.area.desareanatural" />
	</span><br/>
	
	</h1>
	<h3>Elija el módulo que desea utilizar:</h3> 
	
	
	
<div id="menuturismo">
	<div class="shortcuts">
		   <s:iterator value="#session.listaMenuActual">
					<a class="r linkmenuportada"  param="<s:property value="idmodulo"/>" name="idmodulomenu">    
						<param  id="param2" value="<s:property value="hrefmodulo"/>" name="param2"/>
						<img  alt="Registro" src="img/icons/<s:property value="imgmodulo"/> " />
						<s:property value="nombremodulo"/> 
					</a>
					
		  </s:iterator>	
	</div>
</div>
  