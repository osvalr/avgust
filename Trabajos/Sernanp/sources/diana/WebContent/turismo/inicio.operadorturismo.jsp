<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>   
<script type="text/javascript" src="js/lib/_class.validator.js">
</script>
 


<!-- Content -->

<div id="secc1">
<h1>Listado  Operadores de Turismo<br/>
<s:if test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP}">
<span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span>
	</s:if>
	</h1>
</div>	
<div>

<form id="formInicioOperadorTurismo" method="post" >
<div id="filters" class="regmarco"> 
<span class="creg">
<label>Nombre/Raz&oacute;n Social</label>
<input type="text"  name="nombperjur"  />
</span>

<span class="creg">
<label>Usuario</label>
<input type="text"   name="username"/>

</span>
<s:if test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL}">
<span class="creg">
<label>ANP con Turismo</label>
<s:select list="listaAnpturismo" name="idanpturismo"
										listKey="idturismo"  
										listValue="%{categoriaanp.siglascategoriaanp+' '+desareanatural}"   
                                         theme="simple" 
                                         headerKey="0"
                                         headerValue="TODOS"
                                         id="cboAnpTurOperadores"
                                         />
</span>
</s:if>


<input type="button"  style="float: right;" id="btnBuscarOperadores" value="Buscar" class="btntur10"  />

</div>
</form>

<s:if test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL}">

<div class="divbtn">
<input type="button"  name="1"  id="btnRegVisitante" value="Nuevo" class="btntur10 opcionaccionopetur"  />
<input type="button"  name="2"   value="Editar" class="btntur10 opcionaccionopetur"   />
<input type="button"  name="3"   value="Eliminar" class="btntur10 opcionaccionopetur"   />
<input type="button"  name="4"   value="Generar Clave" class="btntur10 opcionaccionopetur"   />
</div>

</s:if>
   <div  id="secc2">
   
   
	<form id="formInicioOperadorTurismo" method="post" >
	     	
	</form>
	</div>
	
	

<br/>

 <div id="linkClose" >
<span id="closemodal">
	    <span class="i i_remove"></span>
	    <strong>Cerrar</strong>
</span>
</div>

	<div id="divListaOperadorTurismo"  >
		<s:include value="lista.operadorturismo.jsp" />
	</div>
	
	
	<div id="divModalRegOperadorTurismo" class="divRegistroModal" style="display: none;">
	
	</div>
	
	
</div>

 <!-- MODAL -->
 <div id="divModalConfirmacion">
  </div>

	

<!-- End Content -->
