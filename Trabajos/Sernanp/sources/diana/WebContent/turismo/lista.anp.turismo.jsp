<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>     
 

 

<form id="formListaAnpTurismo" method="post">
<input   id="hdmodulo"   type="hidden" name="idmodulo"  value='<s:property value="#session.idmoduloactual"/>' />
<input   id="hdareanatural"   type="hidden" name="idarea"  />
<h3>Elija el &Aacute;rea Natural:</h3>
<!--<h1><br /><span> -->
<!--	-->
<!--	</span></h1>-->

<div id="anps">
<s:iterator value="listaAreanatural"> 
	<div class="l anp">    
		<a   style="cursor: pointer;" param="${idareanatural}"   
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

</form>
 