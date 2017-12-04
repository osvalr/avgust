<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@page  contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%> 


<form method="post" id="formRegGuiaTurismo">
<div class="divRegistro">

<div class="divCabecera">
REGISTRO GUIA TURISMO
</div>

<br/>





<span class="msgdniexiste msg"  ><s:property value="getText('msgdniexiste')" /> </span>
<span class="msgguiaexiste msg"  ><s:property value="getText('msgguiaexiste')" /></span>
<span class="msgingresoanp msg"  ><s:property value="getText('msgingresoanp')" /></span>

<input type="hidden" name="guia.idguia" value="${guia.idguia}"  />
<input type="hidden" name="guia.idpersona" value="${guia.idpersona}"  />
<input type="hidden" name="guia.idpersonanatural" value="${guia.idpersonanatural}"  />











<fieldset >


<legend>Datos Gu&iacute;a</legend>


<div class="regmarco" >

<span class="creg">
<label>Apellido Paterno</label>
<input type="text" size="15" class="content valid input uc" name="guia.apepat" 
value="${guia.apepat}" />
</span>
<span class="creg">
<label>Apellido Materno</label>
<input type="text" size="15" class="input uc" name="guia.apemat" 
value="${guia.apemat}" />
</span>
<span class="creg">
<label>Nombres</label>
<input type="text" size="15" class="content valid input uc" name="guia.nombre" 
value="${guia.nombre}" />
</span>









<span class="creg">
<label>Pa&iacute;s Origen</label>
<s:select list="paises" name="guia.pais.idpais"
										listKey="idpais"  
										listValue="nompais"  
										label="País" 
										cssClass="cbopais"
                                         theme="simple" />
</span>




</div>




<div class="regmarco" style="clear: both;">


<span class="creg">
<label>Tipo Doc.</label>		
									<s:select  
		                               name="guia.tipodocumento.idtipo"  headerKey="" 
		                                 headerValue="Seleccione" 
		                                list="listaTipoDocumento"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="select valid tipodoc" /> 
</span>
<span class="creg">
<label>Num Doc</label>
<input type="text" size="16" class="doc valid input" name="guia.numerodocumento"
   
   value="${guia.numerodocumento}" /> 
</span>

<span class="creg">
<label>F. Nacimiento</label>
<input type="text" size="10" class="dateDMY valid input fnacimiento" name="guia.fnacimiento"  
  value="${guia.fnacimiento}"  />
</span>


<span class="creg">
<label>G&eacute;nero</label>		
<s:select  name="guia.sexo.idtipo"  headerKey="" 
		                                 headerValue="[Seleccione]" 
		                                list="listaGenero"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="select valid" /> 	
</span>


<span class="creg">
<label>Carnet Gu&iacute;a</label>
<input type="text" size="10"  name="guia.codigoguia"  
  value="${guia.codigoguia}"  />
</span>

</div>


<div class="regmarco regubigeo" style="clear: both;">



<span class="creg">
<label>Direcci&oacute;n</label>
<input type="text" size="22" class="input" name="guia.direccion" 
value="${guia.direccion}" />
</span>

<span class="creg">
    <label>Departamento</label> 
		<s:select  param="1"
		            cssClass="select valid idubigeodepartamento cboubigeo" 
					name="guia.ubigeo.coddepartamento"  headerKey="" 
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
					name="guia.ubigeo.codprovincia"  headerKey="" 
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
					name="guia.ubigeo.idubigeo"  headerKey="" 
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
<input type="text" size="14" class="input" name="guia.telefono" 
value="${guia.telefono}"/>
<br/>

</span>

<span class="creg">
<label>Correo Personal</label>
<input type="text" size="20" class="" name="guia.correopersonal"  
value="${guia.correopersonal}" />
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
                   <s:iterator value="guia.listaAnpturismo" >
                      <div id="rowanptur${i+1}"  class="rowanptur" >
	                   <input  class="idturismo" type="hidden" name="guia.listaAnpturismo[${i}].idturismo" 
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
	             <input  class="idturismo" type="hidden" name="guia.listaAnpturismo[_i].idturismo"  />
    			 <input   class="desanptur upperlbl"     type="text" size="32" />
				<span  class="i i_supr" title="eliminar" ></span>
				<span class="msganptur v_label" style="display:none;" >Seleccione un ANP</span>
				</div>
     </div>
     	

</fieldset>
  	
  		
  								 
<input type="button"   value="Guardar" class="btntur10"  id="btnGuardarRegGuiaTurismo" style="margin-left: 400px" />		  								 
		  								 


</div>

<div class="divEspera" style="display: none;text-align: center;">
 <h2 >Guardando </h2><br/>
 <img src='css/loading.gif'  />
</div>

		  								 								
	</form>									
									