<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>   
<script type="text/javascript" src="js/lib/_class.validator.js">
</script>
 


<!-- Content -->

<div id="secc1">
<h1>Buscar Ficha<br/>

<span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
</span>
	</h1>
</div>	

<div>




   <div  id="secc2">
   
   
	<form id="formInicioPagoBancoFichaturismo" method="post" >
	   
	   
	   <div >
	   <div style="float:left; width: 250px;">
	     <span> 
		<s:textfield  name="codigoficha" id="codigoficha" label="código" 
			cssClass="valid onlydigits numficha searchterm codigofichapaste" maxlength="16" />
		    </span>
	   </div>
		
		
		   
		   <div style="float: right;">
		     <input type="button" value="Buscar" 
		     class="submit "  id="btnBuscarPagosBanco" /> <span id="message"></span>   
		   </div>
		</div>
		   
		   <br>
		   
		   
		   
		   
		  
		   	
	</form>
	</div>
	
	<br style="clear: both;"/>
	<br>
	<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL}">
	  <input type="button"  id="btnCargarPagosBanco"  value="Cargar" class="btntur10" style="float: left;" />
	</s:if>

	<br/>
	<div id="divListaPagoBancoFichaturismo"  >
		<s:include value="lista.pagobanco.fichaturismo.jsp" />
	</div>
	<div id="divDetallePagoFichaturismo" style="display: none;">
	
	</div>
	
	
</div>



	

<!-- End Content -->
