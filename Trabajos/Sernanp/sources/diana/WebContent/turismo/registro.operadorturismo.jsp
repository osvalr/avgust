<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@page  contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%> 


<form method="post" id="formRegOperadorTurismo">
<div class="divRegistro">

<div class="divCabecera">
REGISTRO OPERADOR TURISMO
</div>

<br/>




<span class="msgusernameexiste msg"  ><s:property value="getText('msgusernameexiste')" /></span>
<span class="msgrucexiste msg"  ><s:property value="getText('msgrucexiste')" /></span>
<span class="msgingresoanp msg"  ><s:property value="getText('msgingresoanp')" /></span>

<input type="hidden" name="operadorturismo.idoperadorturismo" value="${operadorturismo.idoperadorturismo}"  />
<input type="hidden" name="operadorturismo.idpersona" value="${operadorturismo.idpersona}"  />
<input type="hidden" name="operadorturismo.idpersonajuridica" value="${operadorturismo.idpersonajuridica}"  />







<fieldset class="regmarco">
<legend>Datos Usuario</legend>
<s:if test="%{operadorturismo.idoperadorturismo==0}">

<span class="creg">
<label>Usuario:</label>
<input type="text" size="14"   class="content valid input" name="operadorturismo.usuario.username" 
/>
</span>
<span class="creg">
<label>Correo env&iacute;o clave</label>
<input type="text" size="20" class="mail valid" name="operadorturismo.correopersonal" 
value="${operadorturismo.correopersonal}"  />
</span>





</s:if>
<s:else>

<span class="creg">
<label>Usuario</label>
<span style="float:left"> ${operadorturismo.usuario.username} </span>
</span>
</s:else>
</fieldset>





<fieldset >


<legend>Datos Operador</legend>


<div class="regmarco" >

<span class="creg">
<label>Nombre/Raz&oacute;n Social</label>
<input type="text" size="25" class="content valid input" name="operadorturismo.nombrepersonajuridica" 
value="${operadorturismo.nombrepersonajuridica}" />
</span>


<span class="creg">
<label>Siglas</label>
<input type="text" size="15" class="input" name="operadorturismo.siglas" 
value="${operadorturismo.siglas}" />
</span>

<span class="creg">
<label>RUC</label>
<input type="text" size="14" class="ruc valid input" name="operadorturismo.ruc" 
 maxlength="11" value="${operadorturismo.ruc}"/>
<br/>

</span>




<span class="creg">
<label>Pa&iacute;s Origen</label>
<s:select list="paises" name="operadorturismo.pais.idpais"
										listKey="idpais"  
										listValue="nompais"  
										label="País" 
										cssClass="cbopais"
                                         theme="simple" />
</span>




</div>






<div class="regmarco regubigeo" style="clear: both;">



<span class="creg">
<label>Direcci&oacute;n</label>
<input type="text" size="22" class="content valid input" name="operadorturismo.direccion" 
value="${operadorturismo.direccion}" />
</span>

<span class="creg">
    <label>Departamento</label> 
		<s:select  param="1"
		            cssClass="select valid idubigeodepartamento cboubigeo" 
					name="operadorturismo.ubigeo.coddepartamento"  headerKey="" 
					headerValue="[Seleccione]" 
					list="listaUbigeodepartamento"
					listKey="coddepartamento"
					listValue="nombre"
					theme="simple"
					/>  
  </span>
  <span class="creg">
     <label>Provincia</label> 
		<s:select  
		            param="2"
		            cssClass="select valid idubigeoprovincia cboubigeo" 
					name="operadorturismo.ubigeo.codprovincia"  headerKey="" 
					headerValue="[Seleccione]" 
					list="listaUbigeoprovincia"
					listKey="codprovincia"
					listValue="nombre"
					theme="simple"
					/> 
  </span>
  <span class="creg">
      <label>Distrito</label> 
		<s:select  
		            cssClass="select valid idubigeodistrito" 
					name="operadorturismo.ubigeo.idubigeo"  headerKey="" 
					headerValue="[Seleccione]" 
					list="listaUbigeodistrito"
					listKey="idubigeo"
					listValue="nombre"
					theme="simple"
					/> 
  </span>

</div>




<div class="regmarco" style="clear: both;">
<span class="creg">
<label>Tel&eacute;fono</label>
<input type="text" size="14" class="telephone valid input" name="operadorturismo.telefono" 
value="${operadorturismo.telefono}"/>
<br/>

</span>

<span class="creg">
<label>Correo</label>
<input type="text" size="20" class="mail valid" name="operadorturismo.correoinstitucional" 
value="${operadorturismo.correoinstitucional}"   />
</span>
</div>



</fieldset>




<fieldset class="regmarco">
<legend>ANP</legend>


			      
			        
			        <span>
                    Agregar ANP con Turismo
                    </span>
                     <a  style="cursor: pointer;"  id="linkAddAnpTurismo" >
                       <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar ANPs con Turismo"  />                
                      </a>
                    
			      
            
                 <div id="divListaAnpTurismo">
                 <s:set var="i"  value="0" />
                   <s:iterator value="operadorturismo.listaAnpturismo" >
                      <div id="rowanptur${i+1}"  class="rowanptur" >
	                   <input  class="idturismo" type="hidden" name="operadorturismo.listaAnpturismo[${i}].idturismo" 
						 value="${idturismo}"    />
    					<input   class="desanptur upperlbl"     type="text" size="32" 
    					   value="${categoriaanp.siglascategoriaanp} ${desareanatural}"
    					 />
						<span  class="i i_supr" title="eliminar" ></span>
						<span class="msganptur v_label" style="display:none;" >Seleccione un ANP</span>
						</div>
					 <s:set var="i" value="#i+1" />  
                   </s:iterator>
                  <input type="hidden" value='${i}'  id="idultanptur" />
                 </div>
                 
                 <div id="divContRowAnpTurismo" style="display: none;" >
	            <div id="rowanptur_n"  class="rowanptur" >
	             <input  class="idturismo" type="hidden" name="operadorturismo.listaAnpturismo[_i].idturismo"  />
    			 <input   class="desanptur upperlbl"     type="text" size="32" />
				<span  class="i i_supr" title="eliminar" ></span>
				<span class="msganptur v_label" style="display:none;" ><s:property value="getText('msganptur')" /></span>
				</div>
     </div>
     	

</fieldset>
  	
  		
  								 
<input type="button"   value="Guardar" class="btntur10"  id="btnGuardarRegOperadorTurismo" style="margin-left: 400px" />		  								 
		  								 


</div>

<div class="divEspera" style="display: none;text-align: center;">
 <h2 >Guardando </h2><br/>
 <img src='css/loading.gif'  />
</div>

		  								 								
	</form>									
									