<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>

<!-- Content -->

 <div id="tabsRegRecInf">
	<ul>
		<li><a href="#tabs-1">DATOS GENERALES</a></li>
		<li><a href="#tabs-2">DATOS BIBLIOGRAFICOS</a></li>
		<li><a href="#tabs-3">DATOS ADICIONALES</a></li>
	</ul>
	
<!-- DATOS GENERALES -->
 <div id="tabs-1">
	   
	
	   
	   <s:hidden id="hdidrol" name="#session.USUARIO_ACTUAL.rol.idrol">  </s:hidden> 


	<fieldset class="fsMarco" >
	<legend class="lgMarco">

	</legend>

	<s:hidden id="hdrecinf" name="recursoinformacion.idrecursoinformacion">  </s:hidden> 
	




    
	<div class="rowReg" style="clear: both;">
 	<label class="etqReg">T&iacute;tulo:</label>
 	<s:textarea    id="txaTituloRecInf content valid1" rows="3" cols="90" name="recursoinformacion.titulo" theme="simple" >
 	</s:textarea>
	</div>
 
 
  
  	<div class="rowReg" style="clear: both;"> 
  	<label class="etqReg">Tipo Recurso Informaci&oacute;n:</label>
   	<s:select  id="cboTipoRecInf"
		   name="recursoinformacion.tiporecursoinformacion.idtipo"  headerKey="" 
		   headerValue="[Seleccione]" 
		   list="listaTipoRecursoInformacion"
		   listKey="idtipo"
		   listValue="nombretipo" 
		   theme="simple"
		   cssClass="select valid1 cboRegRecInf"
		 /> 
		  
  	</div>
  
  
 	<div class="rowReg" style="clear: both;"> 
  	<label class="etqReg">Medio Recurso Informaci&oacute;n:</label>
   	<s:select  id="cboMedioRecInf"
		   name="recursoinformacion.mediorecursoinformacion.idtipo"  headerKey="" 
		   headerValue="[Seleccione]" 
		   list="listaMedioRecursoInformacion"
		   listKey="idtipo"
		   listValue="nombretipo" 
		   theme="simple"
		   cssClass="select valid1 cboRegRecInf"
		 /> 
		  
  	</div>
   
    
  
  <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">Tem&aacute;tica Recurso Informaci&oacute;n:</label>
   <s:select  id="cboTematicaRecInf"
		   name="recursoinformacion.tematicarecursoinformacion.idtematicarecursoinformacion"  headerKey="" 
		   headerValue="[Seleccione]" 
		   list="listaTematicaRecursoInformacion"
		   listKey="idtematicarecursoinformacion"
		   listValue="nombretematicarecursoinformacion" 
		   theme="simple"
		   cssClass="select valid1 cboRegRecInf"
		 /> 
		  
  </div>
  
  
  <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">Idioma:</label>
   <s:select  id="cboIdiomaRecInf"
		   name="recursoinformacion.idioma.ididioma"  headerKey="" 
		   headerValue="[Seleccione]" 
		   list="listaIdioma"
		   listKey="ididioma"
		   listValue="nombreidioma" 
		   theme="simple"
		   cssClass="select valid1 cboRegRecInf"
		 /> 
		  
  </div>
  
  
   <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">ISBN:</label>
	<s:textfield name="recursoinformacion.isbn"> 
	</s:textfield>	  
  </div>
  
   <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">C&oacute;digo SGD:</label>
	<s:textfield name="recursoinformacion.codigosgd"> 
	</s:textfield>	  
  </div>
  
  
  
 
</fieldset>





     
     
     
     
     
     
   





	   <div id="divsiguiente1" style="display: none; text-align: right;">
	     <a   class="linkRegistroRecInf"  param="1"  style="text-align: right;margin-right: 0px"  href="#" >
		    Siguiente&gt;
	    </a>
	   </div>
	   
	   
	   
	   
	   
	</div>
	
	
	
	<!-- DATOS BIBLIOGRAFICOS -->
	<div id="tabs-2">
      
  
  
  
  
  
  <fieldset class="fsMarco" >
	<legend class="lgMarco">
       Editoriales
	</legend>
	
	
	<div style="float: right;">
<a href="#"   id="linkAddEditorial" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Editorial"  />                     
</a>
<a href="#"  name="1" class="linkCreaRegistro" id="linkCreaEditorial" >
    <img    name="imgEditorial"  src="<%=request.getContextPath()%>/img/editar.png" title="Registrar Editorial"  />                     
</a>
</div>
	
	
	<div id="camposEditorial">
<s:if test="%{recursoinformacion.idrecursoinformacion!=0}">

<s:set var="i" value="0" />
<s:iterator value="recursoinformacion.listaRecursoInformacionEditorial" >

  	 
		<s:set var="n" value="#i+1" /> 
		<div id="roweditorial_n"  class="roweditorial" >
		<input  class="idcodigorecinfeditorial" type="hidden" name="recursoinformacion.listaRecursoInformacionEditorial[<s:property value="#i" />].idcodigo" value='<s:property value="#n" />'    />
		<input  class="idrecinfeditorial" type="hidden" name="recursoinformacion.listaRecursoInformacionEditorial[<s:property value="#i" />].idrecursoinformacioneditorial"   value='<s:property value="%{idrecursoinformacioneditorial}" />' />
		<input  class="ideditorial" type="hidden" name="recursoinformacion.listaRecursoInformacionEditorial[<s:property value="#i" />].editorial.ideditorial"   value='<s:property value="%{editorial.ideditorial}" />' />
		 			
			<input   class="nomeditorial"     type="text" size="40"   value='<s:property value="%{editorial.nombrepersonajuridica}" />'  />
			<span  class="i i_quit" title="eliminar" ></span>

	    </div>
	    <s:set var="i" value="#i+1" /> 
	
  </s:iterator>
</s:if>
<input type="hidden" value='<s:property value="#n" />'  id="idulteditorial" />

</div>
	
	
</fieldset>	
	



<fieldset class="fsMarco" >
	<legend class="lgMarco">
       Autores
	</legend>
	
	
	<div style="float: right;">
<a href="#"   id="linkAddAutor" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Autor"  />                     
</a>
<a href="#"  name="2" class="linkCreaRegistro" id="linkCreaAutor" >
    <img    name="imgAutor" src="<%=request.getContextPath()%>/img/editar.png" title="Registrar Autor"  />                     
</a>
</div>
	
	
	<div id="camposAutor">
<s:if test="%{recursoinformacion.idrecursoinformacion!=0}">

<s:set var="i" value="0" />
<s:iterator value="recursoinformacion.listaRecursoInformacionAutor" >

  	 
		<s:set var="n" value="#i+1" /> 
		<div id="rowautor_n"  class="rowautor" >
		<input  class="idcodigorecinfautor" type="hidden" name="recursoinformacion.listaRecursoInformacionAutor[<s:property value="#i" />].idcodigo" value='<s:property value="#n" />'    />
		<input  class="idrecinfautor" type="hidden" name="recursoinformacion.listaRecursoInformacionAutor[<s:property value="#i" />].idrecursoinformacionautor"   value='<s:property value="%{idrecursoinformacionautor}" />' />
		<input  class="idautor" type="hidden" name="recursoinformacion.listaRecursoInformacionAutor[<s:property value="#i" />].autor.idautor"   value='<s:property value="%{autor.idautor}" />' />
		<input   class="nomcompautor"     type="text" size="40"   value='<s:property value="%{autor.apepat}"/> <s:property value="%{autor.apemat}"/>  <s:property value="%{autor.nombre}"/>'     />
			<span  class="i i_quit" title="eliminar" ></span>

	    </div>
	    <s:set var="i" value="#i+1" /> 
	
  </s:iterator>
</s:if>
<input type="hidden" value='<s:property value="#n" />'  id="idultautor" />

</div>
	
	
</fieldset>	








<fieldset class="fsMarco" >
	<legend class="lgMarco">
      Temas
	</legend>
	
	
	<div style="float: right;">
<a href="#"   id="linkAddTema" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Tema"  />                     
</a>
<a href="#"  name="3" class="linkCreaRegistro" id="linkCreaTema" >
    <img   name="imgTema" src="<%=request.getContextPath()%>/img/editar.png" title="Registrar Tema"  />                     
</a>
</div>
	
	
	<div id="camposTema">
<s:if test="%{recursoinformacion.idrecursoinformacion!=0}">

<s:set var="i" value="0" />
<s:iterator value="recursoinformacion.listaRecursoInformacionTema" >

  	 
		<s:set var="n" value="#i+1" /> 
		<div id="rowtema_n"  class="rowtema" >
		<input  class="idcodigorecinftema" type="hidden" name="recursoinformacion.listaRecursoInformacionTema[<s:property value="#i" />].idcodigo" value='<s:property value="#n" />'    />
		<input  class="idrecinftema" type="hidden" name="recursoinformacion.listaRecursoInformacionTema[<s:property value="#i" />].idrecursoinformaciontema"   value='<s:property value="%{idrecursoinformaciontema}" />' />
		<input  class="idtema" type="hidden" name="recursoinformacion.listaRecursoInformacionTema[<s:property value="#i" />].tema.idtema"   value='<s:property value="%{tema.idtema}" />' />
		 			
			<input   class="nomtema"     type="text" size="40"   value='<s:property value="%{tema.nombretema}" />'  />
			<span  class="i i_quit" title="eliminar" ></span>

	    </div>
	    <s:set var="i" value="#i+1" /> 
	
  </s:iterator>
</s:if>
<input type="hidden" value='<s:property value="#n" />'  id="idulttema" />

</div>
	
	
</fieldset>	



     <fieldset class="fsMarco" >
          <legend class="lgMarco">
             Descripci&oacute;n Bibliogr&aacute;fica
          </legend>
          
          
          <div class="rowReg">
 			<label class="etqReg">Descripci&oacute;n:</label>
 			<s:textarea   name="recursoinformacion.descripcion"  rows="3" cols="90" theme="simple" >
 			</s:textarea>
  
         </div>
          <div class="rowReg" style="clear: both;">
 			<label class="etqReg">N&uacute;mero de P&aacute;ginas:</label>
 			<s:textfield  name="recursoinformacion.numeropaginas" theme="simple" >
 			</s:textfield>
 			
            
         </div>
         
         
         
         <div class="rowReg" style="clear: both;"> 
  	     <label class="etqReg">A&ntilde;o de Publicaci&oacute;n:</label>
   	          <s:select  id="cboAnioPublicRecInf"
		   name="recursoinformacion.aniopublicacion"  headerKey="" 
		   headerValue="[Seleccione]" 
		   list="listaAnioPublicacion"
		   listKey="idtipo"
		   listValue="nombretipo" 
		   theme="simple"
		   cssClass="select valid2 cboRegRecInf"
		 /> 
		  </div>
         
         
          
     </fieldset> 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
  
  
  
  
  
  
  
  
   <div id="divsiguiente2" style="display: none;text-align: right;">
	     <a   class="linkRegistroRecInf"  param="2"  style="text-align: right;"  href="#" >
		    Siguiente&gt;
	    </a>
	   </div>
  
  
         
	        
	   
	   
      
   </div>
   
   
   
   <!-- DATOS ADICIONALES -->
   <div id="tabs-3">
         
	       






 <fieldset class="fsMarco">
<legend class="lgMarco">
ANP involucrada
</legend>
<div style="float: right;">
<a  href="#"   id="linkModalAnp" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar ANPs"  />                
</a>
</div>
<div id="camposAnpSel">
<s:set var="i" value="0" />
  <s:iterator value="recursoinformacion.listaRecursoInformacionAreanatural">
    <input class="idrecinfareasel" type='hidden' name="recursoinformacion.listaRecursoInformacionAreanatural[<s:property value="#i" />].idrecursoinformacionareanatural"  value='<s:property value="%{idrecursoinformacionareanatural}" />' />
    <input class="idareasel" type='hidden' name="recursoinformacion.listaRecursoInformacionAreanatural[<s:property value="#i" />].areanatural.idareanatural"  value='<s:property value="%{areanatural.idareanatural}" />' />
    <label class="nomcomareasel" >
     <s:property value="areanatural.categoriaanp.siglascategoriaanp"/>.  <s:property  value="areanatural.desareanatural"/>
    </label>
    <br>
    <s:set var="i" value="#i+1" /> 
  </s:iterator>
</div>


</fieldset>  




	<fieldset class="fsMarco" >
	<legend class="lgMarco">
        Ubicaci&oacute;n F&iacute;sica
	</legend>
  <div class="rowReg" style="clear: both;"> 
  	<label class="etqReg">Ubicaci&oacute;n:</label>
   	<s:select  id="cboUbicRecInf"
		   name="recursoinformacion.sedebiblioteca.idareanatural"  headerKey="" 
		   headerValue="[Seleccione]" 
		   list="listaSedeBiblioteca"
		   listKey="idareanatural"
		   listValue="%{desareanatural}" 
		   theme="simple"
		   cssClass="select valid3 cboRegRecInf"
		 /> 
		  
  	</div>
   </fieldset>



 

<div id="divDatosAprobacion"                 >
 
   <s:if test="%{recursoinformacion.tiporecursoinformacion.idtipo==2}">
	
	<fieldset class="fsMarco" >
	<legend class="lgMarco">
        Datos de Aprobaci&oacute;n del Producto Institucional
	</legend>
	<input class="hdaprobacionrecinf"  name="recursoinformacion.aprobacionrecursoinformacion.idaprobacionrecursoinformacion" type="hidden" 
	   value='<s:property value="%{recursoinformacion.aprobacionrecursoinformacion.idaprobacionrecursoinformacion}"/>'      />
  <div class="rowReg" style="clear: both;"> 
  	<label class="etqReg">Area Org&aacute;nica:</label>
   	<s:select  id="cboAreaOrgRecInf"
		   name="recursoinformacion.aprobacionrecursoinformacion.areaorganica.idarea"  headerKey="" 
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
            <s:hidden  id="hdpersonalaprobacion"  name="recursoinformacion.aprobacionrecursoinformacion.personal.idpersonal" >  </s:hidden>
            <input id="txtpersonalaprobacion" type="text"   
            <s:if test="%{recursoinformacion.aprobacionrecursoinformacion.personal.idpersonal!=0}" >
            
            value='<s:property value="%{recursoinformacion.aprobacionrecursoinformacion.personal.apepat}"/>
             <s:property value="%{recursoinformacion.aprobacionrecursoinformacion.personal.apemat}"/> 
              <s:property value="%{recursoinformacion.aprobacionrecursoinformacion.personal.nombre}"/>' 
              </s:if>
                >
    </div>
  	
   </fieldset>
	
 </s:if>
  
</div>





 <fieldset class="fsMarco" >
	<legend class="lgMarco">
       Archivos
	</legend>

<div id="camposArchivo">

 <div id="rowarchivo_1"  class="rowarchivo" >
 
			<div class="rowReg" >
 			
            <label class="etqReg">Documento:</label>
	
		<a class="linkModalArchivo" name="1">
		  <img   name="imgTema" src="<%=request.getContextPath()%>/img/editar.png" title="Agregar Documento"  />
		</a> 
		<input  class="idrecinfarchivo" type="hidden" name="recursoinformacion.listaRecursoInformacionArchivo[0].idrecursoinformacionarchivo"  
	         value='<s:property value="%{recursoinformacion.listaRecursoInformacionArchivo[0].idrecursoinformacionarchivo}" />'   />
	    <input  class="idarchivo" type="hidden" name="recursoinformacion.listaRecursoInformacionArchivo[0].archivo.idarchivo"   
	    value='<s:property value="%{recursoinformacion.listaRecursoInformacionArchivo[0].archivo.idarchivo}" />'  />
	    <input  class="idcodigoarchivo" type="hidden" name="recursoinformacion.listaRecursoInformacionArchivo[0].archivo.idcodigo"   
	     value='0'      />
	    <input  class="idtipoarchivo" type="hidden" name="recursoinformacion.listaRecursoInformacionArchivo[0].tipoarchivo.idtipo"   
	        value='1'            />
	    
	    <a  param='<s:property  value="%{recursoinformacion.listaRecursoInformacionArchivo[0].archivo.idarchivo}" />'  class="linkmostrararchivo" >
	    <span    class="nomarchivo" >
	      <s:property value="%{recursoinformacion.listaRecursoInformacionArchivo[0].archivo.nombreInicial}" />
	     </span>
		</a>
		<s:if test="%{recursoinformacion.listaRecursoInformacionArchivo[0].archivo.idarchivo!=0}">
		<span  class="i i_quit" title="eliminar" ></span>
        </s:if>
        <s:else>
         <span  style="display:none" class="i i_quit" title="eliminar" ></span>
        </s:else>
	    </div>
	    
	    
</div>

 <div id="rowarchivo_2"  class="rowarchivo" >
 
		
		<div class="rowReg" >
 			
            <label class="etqReg">
            Portada:
            </label>
            <a class="linkModalArchivo" name="2">
             <img   name="imgTema" src="<%=request.getContextPath()%>/img/editar.png" title="Agregar Portada"  />
            </a> 
		<input  class="idrecinfarchivo" type="hidden" name="recursoinformacion.listaRecursoInformacionArchivo[1].idrecursoinformacionarchivo"  
	         value='<s:property value="%{recursoinformacion.listaRecursoInformacionArchivo[1].idrecursoinformacionarchivo}" />'   />
	    <input  class="idarchivo" type="hidden" name="recursoinformacion.listaRecursoInformacionArchivo[1].archivo.idarchivo"   
	    value='<s:property value="%{recursoinformacion.listaRecursoInformacionArchivo[1].archivo.idarchivo}" />'  />
	    <input  class="idcodigoarchivo" type="hidden" name="recursoinformacion.listaRecursoInformacionArchivo[1].archivo.idcodigo"   
	     value='0'      />
	     <input  class="idtipoarchivo" type="hidden" name="recursoinformacion.listaRecursoInformacionArchivo[1].tipoarchivo.idtipo"   
	        value='2'            />
	   <span  class="nomarchivo" >
	      <img  id="imgPortadaRecInf" src="getImagenPortada" width="100"  />  
	    </span>
	    
		<s:if test="%{recursoinformacion.listaRecursoInformacionArchivo[1].archivo.idarchivo!=0}">
		<span  class="i i_quit" title="eliminar" ></span>
        </s:if>
        <s:else>
         <span  style="display:none" class="i i_quit" title="eliminar" ></span>
        </s:else>
  </div>

</div> 


 </div>

</fieldset>
   </div>
 </div>

















