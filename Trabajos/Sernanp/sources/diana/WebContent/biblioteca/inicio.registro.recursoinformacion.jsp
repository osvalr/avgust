<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>


<form name="formRegistroRecInf" id="formRegistroRecInf" method="post" enctype="multipart/form-data" 
	      action="#"  accept-charset="UTF-8" >  


<s:hidden id="hdpagina" name="idpagina"  >  </s:hidden>


<div id="divRegistroRecInf">

<jsp:include page="/biblioteca/registro.recursoinformacion.jsp" />

</div>
<div  id="divBtnRegistroRecInf" style="text-align: center;">
		
		<input  type="button" id="btnRegistroRecInf" value="Guardar" class="submit"/>
		<input  type="button" id="btnCancelRegistroRecInf" value="Cancelar" class="btnIncioRecInf submit"/>
</div>


			

 </form>  





  <!--ARCHIVOS  DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD-->



<div id="divModalArchivo" >
	
	<div style="float: left;">
	REGISTRO 
	</div>
	<div style="float: right;">
      <a href="#">
	  <img  name="imgModalArchivo"  class="linkCerrar" src="<%=request.getContextPath()%>/img/cancel.png"   />
      </a>
    </div>

<br/>

<form method="post" enctype="multipart/form-data"
id="formRegistroArchivo"   name="formRegistroArchivo" 
target="iframeUpload" >
<!-- documento -->
<div style="clear: both;">

<br/>
<label >Archivo: </label>
<div>
	<input  id="idarchivomodal" type="hidden" >
	<input  id="fileArchivo" name="file" type="file" class="contentimg valid" />
</div>
<div >
   <input  id="btnRegistroArchivo"  type="button" value="Guardar">
</div>
</div>
<iframe name="iframeUpload" id="iframeUpload" style="display: none;"  >

</iframe>

   
</form> 	
	
 
</div>





<!-- MODAL REGISTRO EDITORIAL -->

<div id="divModalEdit">
<form name="formRegistroEditorial" id="formRegistroEditorial" 
	action="#">
<div style="float: left;">
REGISTRO EDITORIAL
</div>
 <div style="float: right;">
 <a   href="#">
	  <img  name="imgEditorial"  class="linkCerrar" src="<%=request.getContextPath()%>/img/cancel.png"   />
</a>
 </div>
 
 
 
 <div style="clear: both;">
 
<div class="rowReg"> 
  <label class="etqReg">Nombre:</label>
  <textarea id="txaNombre" name="nombre" rows="3" cols="40">
  </textarea>
  
 </div>
  <div class="rowReg"> 
  <label class="etqReg">Pa&iacute;s:</label>
  <s:select  
		   name="pais"  headerKey="0" 
		   headerValue="[Seleccione]" 
		   list="listaPais"
		   listKey="idpais"
		   listValue="nombrepais"
		  id="cboPais"
    />
    
 </div>
 <div class="rowReg"> 
  <label class="etqReg">Direcci&oacute;n:</label>
 <input  id="txtDireccion" type="text"  name="direccion" size="43"/>
 </div> 
 <div class="rowReg"> 
  <label class="etqReg">Tel&eacute;fono:</label>
 <input  id="txtTelefono" type="text"  name="telefono" size="43"/>
 </div>
 
<div style="text-align: center;clear: both;">
 <input  type="button" id="btnRegEdit"   value="Guardar" />
</div>
</div>
</form>
</div>







<!-- MODAL REGISTRO AUTOR -->

<div id="divModalAutor">
<form name="formRegistroAutor" id="formRegistroAutor" 
	action="#">
<div style="float: left;">
REGISTRO AUTOR
</div>
 <div style="float: right;">
 <a   href="#">
	  <img  name="imgAutor"  class="linkCerrar" src="<%=request.getContextPath()%>/img/cancel.png"   />
</a>
 </div>
 
 
 
 <div style="clear: both;">
 
  <label class="etqReg">Apellido Paterno:</label>
 <input  id="txtApPaterno" type="text"  name="appaterno" size="43"/>
 </div>
 
 <div > 
  <label class="etqReg">Apellido Materno:</label>
 <input  id="txtApMaterno" type="text"  name="apmaterno" size="43"/>
 </div>
 
<div > 
  <label class="etqReg">Nombre:</label>
 <input  id="txtNombre" type="text"  name="nombre" size="43"/>
 </div>
 
 <div > 
  <label class="etqReg">G&eacute;nero:</label>
  <s:select  
		   name="genero"  headerKey="0" 
		   headerValue="[Seleccione]" 
		   list="listaGenero"
		   listKey="codigotipo"
		   listValue="nombretipo"
		  id="cboGenero"
    />
    
 </div>
 
 <div > 
  <label class="etqReg">Tipo Documento:</label>
  <s:select  
		   name="tipodocumento"  headerKey="0" 
		   headerValue="[Seleccione]" 
		   list="listaTipoDocumentoIdentidad"
		   listKey="idtipo"
		   listValue="nombretipo"
		  id="cboTipoDocumento"
    />
    
 </div>
 <div > 
  <label class="etqReg">Nro Documento:</label>
 <input  id="txtNumDocumento" type="text"  name="numdocumento" size="43"/>
 </div>
  <div > 
  <label class="etqReg">Pa&iacute;s:</label>
  <s:select  
		   name="pais"  headerKey="0" 
		   headerValue="[Seleccione]" 
		   list="listaPais"
		   listKey="idpais"
		   listValue="nombrepais"
		  id="cboPais"
    />
    
 </div>
 <div > 
  <label class="etqReg">Direcci&oacute;n:</label>
 <input  id="txtDireccion" type="text"  name="direccion" size="43"/>
 </div> 
 <div > 
  <label class="etqReg">Tel&eacute;fono:</label>
 <input  id="txtTelefono" type="text"  name="telefono" size="43"/>
 </div>
  <div > 
  <label class="etqReg">Email:</label>
 <input  id="txtEmail" type="text"  name="email" size="43"/>
 </div>
<div style="text-align: center;clear: both;">
 <input  type="button" id="btnRegAutor"   value="Guardar" />
</div>

</form>
</div>










<!-- MODAL REGISTRO TEMA -->

<div id="divModalTema">
<form name="formRegistroTema" id="formRegistroTema" 
	action="#">
<div style="float: left;">
REGISTRO TEMA
</div>
 <div style="float: right;">
 <a   href="#">
	  <img  name="imgTema"  class="linkCerrar" src="<%=request.getContextPath()%>/img/cancel.png"   />
</a>
 </div>
 
 
 
 <div style="clear: both;">
 
 <div class="rowReg"> 
  <label class="etqReg">Tema:</label>
 <input  id="txaNombre" type="text"  name="nombre" size="43"/>
 </div>
 
 
   
<div style="text-align: center;clear: both;">
 <input  type="button" id="btnRegTema"   value="Guardar" />
</div>
</div>
</form>
</div>








<!-- REGISTRO EDITORIAL -->
<div id="divContRowEditorial" style="display: none;" >

	<div id="roweditorial_n"  class="roweditorial" >
    <input  class="idcodigorecinfeditorial" type="hidden" name="recursoinformacion.listaRecursoInformacionEditorial[_i].idcodigo" /> 
	<input  class="idrecinfeditorial" type="hidden" name="recursoinformacion.listaRecursoInformacionEditorial[_i].idrecursoinformacioneditorial" />
    <input  class="ideditorial" type="hidden" name="recursoinformacion.listaRecursoInformacionEditorial[_i].editorial.ideditorial" />
	<input   class="nomeditorial"     type="text" size="40"  />
	<span  class="i i_quit" title="eliminar" ></span>

	</div>
</div>

<!-- REGISTRO AUTOR -->
<div id="divContRowAutor" style="display: none;" >

	<div id="rowautor_n"  class="rowautor" >
    <input  class="idcodigorecinfautor" type="hidden" name="recursoinformacion.listaRecursoInformacionAutor[_i].idcodigo" /> 
	<input  class="idrecinfautor" type="hidden" name="recursoinformacion.listaRecursoInformacionAutor[_i].idrecursoinformacionautor" />
    <input  class="idautor" type="hidden" name="recursoinformacion.listaRecursoInformacionAutor[_i].autor.idautor" />
	<input   class="nomcompautor"     type="text" size="40"  />
	<span  class="i i_quit" title="eliminar" ></span>

	</div>
</div>


<!-- REGISTRO TEMA -->
<div id="divContRowTema" style="display: none;" >

	<div id="rowtema_n"  class="rowtema" >
    <input  class="idcodigorecinftema" type="hidden" name="recursoinformacion.listaRecursoInformacionTema[_i].idcodigo" /> 
	<input  class="idrecinftema" type="hidden" name="recursoinformacion.listaRecursoInformacionTema[_i].idrecursoinformaciontema" />
    <input  class="idtema" type="hidden" name="recursoinformacion.listaRecursoInformacionTema[_i].tema.idtema" />
	<input   class="nomtema"     type="text" size="40"  />
	<span  class="i i_quit" title="eliminar" ></span>

	</div>
</div>



 
 
<!-- REGISTRO ANP -->
<div id="divContRowAnpSel" style="display: none;" >

	<div id="rowanpsel_n"  class="rowanpsel" >
	 <input class="idrecinfareasel" type='hidden' name="recursoinformacion.listaRecursoInformacionAreanatural[_i].idrecursoinformacionareanatural"   />
    <input class="idareasel" type='hidden' name="recursoinformacion.listaRecursoInformacionAreanatural[_i].areanatural.idareanatural"   />
    <label class="nomcomareasel" >
     <s:property value="areanatural.categoriaanp.siglascategoriaanp"/>.  <s:property  value="areanatural.desareanatural"/>
    </label>
    

	</div>
</div> 




<!-- MODAL AREA NATURAL -->
<div id="divModalAnp">
<div style="float: left;">
LISTADO DE ANPs
</div>
 <div style="float: right;">
 <a   href="#">
	  <img  name="imgAnp"  class="linkCerrar" src="<%=request.getContextPath()%>/img/cancel.png"   />
</a>
 </div>
 <div  style="font-size:9px;clear: both;">
 
      
      <div>
       <s:select  
	           id="cboCatAnpModal" 
			   headerKey="0" 
			   headerValue="[Todos]" 
			   list="listaCategoriaAnp"
			   listKey="idcategoriaanp"
			   listValue="descategoriaanp" 
			   theme="simple"
			 />
      </div>  
 
 
   <div  id="divListaAnpModal"  > 
 
    
    <div style="float: left;">
	 <s:set var="i" value="0" />
	 <s:iterator value="listaAreaNaturalSel" status="areas">
	 	<s:if test="%{#areas.index<24 }">
		
	     	<div  class="rowanpsel" >
	     	<input class="idanpsel"  type="hidden" value="<s:property value="%{idareanaturalsel}" />" />
		    <input class="idanp"  type="hidden" value="<s:property value="%{areanatural.idareanatural}" />" />
		    <input class="idcategoriaanp"  type="hidden" value="<s:property value="%{areanatural.categoriaanp.idcategoriaanp}" />" />
		   <input id='area_<s:property value="#i" />' type="checkbox" 
		   <s:if test="%{flagseleccion==1}">
		    checked="checked" 
		    </s:if>
		    class="checkListaAnp"   />
		   <label   class="nomcomareanatural" for='area_<s:property value="#i" />' > <s:property value="%{areanatural.categoriaanp.siglascategoriaanp}"/> <s:property value="%{areanatural.desareanatural}"/></label>
		  </div>
		   
		</s:if>  
	 <s:set var="i" value="#i+1" /> 
	</s:iterator>
	</div>
    
    <div style="float: left;">
	
	 <s:iterator value="listaAreaNaturalSel" status="areas">
	 	<s:if test="%{#areas.index>=24 && #areas.index<47 }">
		
	     	<div  class="rowanpsel" >
	     	<input class="idanpsel"  type="hidden" value="<s:property value="%{idareanaturalsel}" />" />
		    <input class="idanp"  type="hidden" value="<s:property value="%{areanatural.idareanatural}" />" />
		    <input class="idcategoriaanp"  type="hidden" value="<s:property value="%{areanatural.categoriaanp.idcategoriaanp}" />" />
		   <input id='area_<s:property value="#i" />' type="checkbox" 
		   <s:if test="%{flagseleccion==1}">
		    checked="checked" 
		    </s:if>
		    class="checkListaAnp"   />
		   <label   class="nomcomareanatural" for='area_<s:property value="#i" />' > <s:property value="%{areanatural.categoriaanp.siglascategoriaanp}"/> <s:property value="%{areanatural.desareanatural}"/></label>
		  </div>
		   
		</s:if>  
	 <s:set var="i" value="#i+1" /> 
	</s:iterator>
	</div>
	
	<div style="float: left;">
	
	 <s:iterator value="listaAreaNaturalSel" status="areas">
	 	<s:if test="%{#areas.index>=47 }">
		
	     	<div  class="rowanpsel" >
	     	<input class="idanpsel"  type="hidden" value="<s:property value="%{idareanaturalsel}" />" />
		    <input class="idanp"  type="hidden" value="<s:property value="%{areanatural.idareanatural}" />" />
		    <input class="idcategoriaanp"  type="hidden" value="<s:property value="%{areanatural.categoriaanp.idcategoriaanp}" />" />
		   <input id='area_<s:property value="#i" />' type="checkbox" 
		   <s:if test="%{flagseleccion==1}">
		    checked="checked" 
		    </s:if>
		    class="checkListaAnp"   />
		   <label   class="nomcomareanatural" for='area_<s:property value="#i" />' > <s:property value="%{areanatural.categoriaanp.siglascategoriaanp}"/> <s:property value="%{areanatural.desareanatural}"/></label>
		  </div>
		   
		</s:if>  
	 <s:set var="i" value="#i+1" /> 
	</s:iterator>
	</div>
 
    

	
	</div>
</div>

<div style="text-align: center;clear: both;">
 <input  type="button"   id="btnAnpSel" value="Seleccionar"/>
</div>
</div>

<!-- END MODAL AREA NATURAL-->
 
 
 
 <!-- REGISTRO DATOS DE APROBACION -->
<div id="divContRowDatosAprobacion" style="display: none;" >

	<fieldset class="fsMarco" >
	<legend class="lgMarco">
        Datos de Aprobaci&oacute;n del Producto Institucional
	</legend>
  <input class="hdaprobacionrecinf"  name="" type="hidden"  />
  <div class="rowReg" style="clear: both;"> 
  	<label class="etqReg">Area Org&aacute;nica:</label>
   	<s:select  id="cboAreaOrgRecInf"
		   name=""  headerKey="" 
		   headerValue="[Seleccione]" 
		   list="listaAreaOrganica"
		   listKey="idarea"
		   listValue="desarea" 
		   theme="simple"
		   cssClass="select valid3 cboRegRecInf"
		 /> 
		  
  	</div>
  	<div class="rowReg" >
 			
            <label class="etqReg">Jefe/Director:</label>
            <s:hidden  id="hdpersonalaprobacion"  name="" >  </s:hidden>
            <input id="txtpersonalaprobacion" type="text"  >
    </div>
  	
   </fieldset>
</div>
 
 

<!-- MODAL CONFIRMACION REGISTRO RECURSO INFORMACION -->
<div id="divModalMsgRecInf"  >
	Se guardó con exito.
	¿Desea registrar otro?
</div>

