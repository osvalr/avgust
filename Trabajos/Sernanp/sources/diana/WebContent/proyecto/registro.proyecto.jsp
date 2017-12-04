<%@ taglib prefix="s" uri="/struts-tags"%>


<%@page pageEncoding="UTF-8"%>


<!-- Content -->

 <!--  
 <script type="text/javascript" src="js/lib/ajaxupload.js"></script>
 -->
 
<form name="formRegistroProyecto" id="formRegistroProyecto" method="post" enctype="multipart/form-data" 
	action="#"  accept-charset="UTF-8" >

<s:hidden id="hdidrol" name="#session.USUARIO_ACTUAL.rol.idrol">  </s:hidden> 


<fieldset class="fsMarco" >
<legend class="lgMarco">
Datos Generales
</legend>

<s:hidden id="hdproyecto" name="proyecto.idproyecto">  </s:hidden> 


<div class="rowReg"> 
  <label class="etqReg">Es Subproyecto de:</label>
   <s:select  id="cboProyectoPrincipal"
		   name="proyecto.proyectoPrincipal.idproyecto"  headerKey="0" 
		   headerValue="[Ninguno]" 
		   list="listaProyectoPrincipal"
		   listKey="idproyecto"
		   listValue="siglasproyecto" 
		   theme="simple"
		   cssClass="cboRegProyecto"
		 /> 
		  


  </div>

    
<div class="rowReg" style="clear: both;">
 <label class="etqReg">Nombre:</label>
 <s:textarea    id="txaNombProy" rows="3" cols="90" name="proyecto.nombreproyecto" theme="simple" >
 </s:textarea>
</div>
 
 <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">Objetivo:</label>
  <s:textarea  id="txtObj" rows="3" cols="90" name="proyecto.objetivoproyecto" theme="simple">
  </s:textarea>
  </div>
  
  <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">Categor&iacute;a Proyecto:</label>
   <s:select  id="cboCategoriaProyecto"
		   name="proyecto.categoriaproyecto.idtipo"  headerKey="0" 
		   headerValue="[Seleccione]" 
		   list="listaCategoriaProyecto"
		   listKey="idtipo"
		   listValue="nombretipo" 
		   theme="simple"
		   cssClass="cboRegProyecto"
		 /> 
		  
  </div>
  
  
 <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">Tipo de Proyecto:</label>
   <s:select  id="cboTipoProyecto"
		   name="proyecto.tipoproyecto.idtipo"  headerKey="0" 
		   headerValue="[Seleccione]" 
		   list="listaTipoProyecto"
		   listKey="idtipo"
		   listValue="nombretipo" 
		   theme="simple"
		   cssClass="cboRegProyecto"
		 /> 
		  
  </div>
   
  
 <!--  
  <s:if test="%{proyecto.idproyecto==0}">
  </s:if>
  -->
  <div  id="divTipoProyecto"  class="rowReg" style="display: none;clear: both;"> 
  <label class="etqReg">Nombre Tipo de Proyecto:</label>
   <input type="text" name="proyecto.tipoproyecto.nombretipo" />
  </div>
  
  
  
  
  <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">Estado del Proyecto:</label>
   <s:select  id="cboEstadoProyecto"
		   name="proyecto.estadoproyecto.idestado"  headerKey="0" 
		   headerValue="[Seleccione]" 
		   list="listaEstadoProyecto"
		   listKey="idestado"
		   listValue="nombestado" 
		   theme="simple"
		   cssClass="cboRegProyecto"
		 /> 
		  
  </div>
  
  
   <div class="rowReg" style="clear: both;"> 
  <label class="etqReg">C&oacute;digo del Proyecto:</label>
	<s:textfield name="proyecto.codigoproyecto"> 
	</s:textfield>	  
  </div>
  
  <div class="rowReg" style="clear: both;"> 
  
  <label  class="etqReg" for="fechainicio">Fecha de Inicio</label>
			<div class="">
			
			<s:textfield name="proyecto.fechainicio" id="fechainicio"  
					size="10" cssClass="datepicker"  title="Fecha"> 
			</s:textfield>
			 <span class="note">&nbsp;yyyy-mm-dd</span>
			</div>
 <label  class="etqReg" for="fechafin">Fecha de Fin</label>
			<div class="">
				<s:textfield name="proyecto.fechafin" id="fechafin" value="%{proyecto.fechafin}" 
					size="10" cssClass="datepicker" readonly="readonly" title="Fecha">
			   </s:textfield>
				 <span class="note">&nbsp;yyyy-mm-dd</span>
			</div> 
  </div>
  
  
  <div class="rowReg">
 <label class="etqReg">Observaci&oacute;n:</label>
 <s:textarea  rows="3" cols="90" name="proyecto.observacionproyecto" theme="simple" >
 </s:textarea>
  
 </div>
 
 <div class="rowReg">
 <label class="etqReg">Compromiso:</label>
 <s:textarea  rows="3" cols="90" name="proyecto.compromisoproyecto" theme="simple" >
 </s:textarea>
  
 </div>
  
 <div class="rowReg">
 <label class="etqReg">Componente:</label>
 <s:textarea  rows="3" cols="90" name="proyecto.componenteproyecto" theme="simple" >
 </s:textarea>
  
 </div> 
  
  <!--  
  <div class="rowReg"> 
  <label class="etqReg">Moneda:</label>
   <s:select  
		   name="proyecto.moneda.idmoneda"  headerKey="0" 
		   headerValue="[Seleccione]" 
		   list="listaMoneda"
		   listKey="idmoneda"
		   listValue="nombremoneda" 
		   theme="simple"
		   id="cboMoneda"
		 /> 
		  
  </div>
  -->
</fieldset>

<fieldset class="fsMarco">
<legend class="lgMarco">
ANPs involucradas
</legend>
<div style="float: right;">
<a  href="#"   id="linkModalAnp" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar ANPs"  />                
</a>
</div>
<div id="divListaAnpSel">
  <s:iterator value="proyecto.areanaturals">
    <input class="areasel" type='hidden' name='listaCodigosArea' value='<s:property  value="idareanatural"/>' />
    <label class="lblReg" >
     <s:property value="categoriaanp.siglascategoriaanp"/>.  <s:property  value="desareanatural"/>
    </label>
    
  </s:iterator>
</div>

<div class="rowReg">
 <label class="etqReg">Zona Espec&iacute;fica Proyecto:</label>
 <s:textarea  rows="3" cols="90" name="proyecto.areaespecificaproyecto" theme="simple" >
 </s:textarea>
  
 </div>
</fieldset>


<!--EJECUTORES FINANCEROS -->
<fieldset class="fsMarco">
<legend class="lgMarco">
Ejecutores Financieros
</legend>
<div style="float: right;">
<a href="#"   id="linkAddEjecFin" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Ejecutoras Financieras"  />                     
</a>
<a href="#"  name="1" class="linkCreaInstitucion" id="linkCreaEjecFin" >
    <img   src="<%=request.getContextPath()%>/img/editar.png" title="Crear Ejecutoras"  />                     
</a>
</div>

<table>
 <thead>
 <tr>
 <th style="width: 70px;text-align: center;">
 <label >Busqueda por:</label>
 </th>
 <th style="width: 280px;text-align: center;">
 <label >Instituci&oacute;n</label>
 </th>

 </tr>
 
 </thead>
 </table>


<div id="camposEjecFinanciero">
<s:if test="%{proyecto.idproyecto!=0}">

<s:set var="i" value="0" />
<s:iterator value="proyecto.listaProyectoEjecutor" >

  	<s:if test="%{tipoejecutor.idtipo==1}"> 
		<s:set var="n" value="#i+1" /> 
		<div id="rowejecfin_n"  class="rowejecfin" >
		<input  class="idcodigoproyejecfin" type="hidden" name="listaProyectoEjecutorFinanciero[<s:property value="#i" />].idcodigo" value='<s:property value="#n" />'    />
		<input  class="idproyejecfin" type="hidden" name="listaProyectoEjecutorFinanciero[<s:property value="#i" />].idproyectoejecutor"   value='<s:property value="%{idproyectoejecutor}" />' />
		<input  class="idejecfin" type="hidden" name="listaProyectoEjecutorFinanciero[<s:property value="#i" />].ejecutor.idejecutor"   value='<s:property value="%{ejecutor.idejecutor}" />' />
		 <!--   
			<input  class="idejecfin" type="hidden" name="listaCodigosEjecFinanciero"   value='<s:property value="%{ejecutor.idejecutor}" />' />
		-->
			<select class="tipobusquedaejecfin">
			<option value="1">Nombre</option>
			<option value="2">Siglas</option>
			</select>
			<input   class="nomejecfin"     type="text" size="40"   value='<s:property value="%{ejecutor.personajuridica.nombrepersonajuridica}" />'  />
			<span  class="i i_supr" title="eliminar" ></span>

	    </div>
	    <s:set var="i" value="#i+1" /> 
	</s:if>
    
  </s:iterator>
</s:if>
<input type="hidden" value='<s:property value="#n" />'  id="idultejecfin" />

</div>

</fieldset>




<div id="divContRowEjecFin" style="display: none;" >

	<div id="rowejecfin_n"  class="rowejecfin" >
	<input  class="idcodproyejecfin" type="hidden" name="listaProyectoEjecutorFinanciero[_i].idcodigo" />
	<input  class="idproyejecfin" type="hidden" name="listaProyectoEjecutorFinanciero[_i].idproyectoejecutor" />
    <input  class="idejecfin" type="hidden" name="listaProyectoEjecutorFinanciero[_i].ejecutor.idejecutor" />
	<select class="tipobusquedaejecfin">
	<option value="1">Nombre</option>
	<option value="2">Siglas</option>
	</select>
	<input   class="nomejecfin"     type="text" size="40"  />
	<span  class="i i_supr" title="eliminar" ></span>

	</div>
</div>


<!-- END EJECUTORES FINANCIEROS -->



<!--  EJECUTORES TECNICOS -->
<fieldset class="fsMarco">
<legend class="lgMarco">
Ejecutores T&eacute;cnicos
</legend>
<div style="float: right;">
<a  href="#"   id="linkAddEjecTec" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Ejecutoras Tecnicas"  />                     
 </a>
 <a href="#"  name="2" class="linkCreaInstitucion" id="linkCreaEjecTec" >
    <img   src="<%=request.getContextPath()%>/img/editar.png" title="Crear Ejecutoras"  />                     
</a>
</div>
<table>
 <thead>
 <tr>
 <th style="width: 70px;text-align: center;">
 <label >Busqueda por:</label>
 </th>
 <th style="width: 280px;text-align: center;">
 <label >Instituci&oacute;n</label>
 </th>

 </tr>
 
 </thead>
 </table>
<div id="camposEjecTecnico">

<s:if test="%{proyecto.idproyecto!=0}">
 <s:set var="i" value="0" />  
<s:iterator value="proyecto.listaProyectoEjecutor" >

  	<s:if test="%{tipoejecutor.idtipo==2}"> 
		<s:set var="n" value="#i+1" /> 
		<div id="rowejectec_n"  class="rowejectec" >
           <input  class="idcodigoproyejectec" type="hidden" name="listaProyectoEjecutorTecnico[<s:property value="#i" />].idcodigo" value='<s:property value="#n" />'    />
            <input  class="idproyejectec" type="hidden" name="listaProyectoEjecutorTecnico[<s:property value="#i" />].idproyectoejecutor"   value='<s:property value="%{idproyectoejecutor}" />' />
               
			<input  class="idejectec" type="hidden" name="listaProyectoEjecutorTecnico[<s:property value="#i" />].ejecutor.idejecutor"   value='<s:property value="%{ejecutor.idejecutor}" />' />
			<!--  
			<input  class="idejectec" type="hidden" name="listaCodigosEjecTecnico"   value='<s:property value="%{ejecutor.idejecutor}" />' />
			-->
			<select class="tipobusquedaejectec">
			<option value="1">Nombre</option>
			<option value="2">Siglas</option>
			</select>
			<input   class="nomejectec"     type="text" size="60"   value='<s:property value="%{ejecutor.personajuridica.nombrepersonajuridica}" />'  />
			<span  class="i i_supr" title="eliminar" ></span>

	    </div>
	    <s:set var="i" value="#i+1" /> 
	</s:if>
    
  </s:iterator>

</s:if>

<input type="hidden" value='<s:property value="#n" />'  id="idultejectec" />
</div>
</fieldset>

<div id="divContRowEjecTec" style="display: none;" >

	<div id="rowejectec_n"  class="rowejectec" >
    <input  class="idcodproyejectec" type="hidden" name="listaProyectoEjecutorTecnico[_i].idcodigo" /> 
	<input  class="idproyejectec" type="hidden" name="listaProyectoEjecutorTecnico[_i].idproyectoejecutor" />
    <input  class="idejectec" type="hidden" name="listaProyectoEjecutorTecnico[_i].ejecutor.idejecutor" />
	<select class="tipobusquedaejectec">
	<option value="1">Nombre</option>
	<option value="2">Siglas</option>
	</select>
	<input   class="nomejectec"     type="text" size="40"  />
	<span  class="i i_supr" title="eliminar" ></span>

	</div>
</div>

<!-- END EJECUTORES TECNICOS -->


<!-- FUENTES  DE FINANCIAMIENTO -->

<fieldset class="fsMarco">
<legend class="lgMarco">
Fuentes de Financiamiento
</legend>
<div style="font-size: 9px;">*Tipo de Cambio(T.C.) a Soles </div>
<div style="float: right;">
<a  href="#"   id="linkAddFteFto" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Fuentes"  />                     
 </a>
 <a href="#"  name="3" class="linkCreaInstitucion" id="linkCreaFuente" >
    <img   src="<%=request.getContextPath()%>/img/editar.png" title="Crear Fuente de Financiamiento"  />                     
</a>
</div>

 
<label id="lblTipoCambio">
</label>
 
 <table>
 
 <thead>
 <tr>
 <th style="width: 70px;text-align: center;">
 <label >Busqueda por:</label>
 </th>
 <th style="width: 280px;text-align: center;">
 <label class="etqReg">Instituci&oacute;n</label>
 </th>
 <th style="width: 120px;text-align: center;">
 <label class="etqReg">Moneda</label>
 
 </th>
 <th style="width: 70px;text-align: center;">
 <label class="etqReg">Monto</label>
  
 </th>
 <th style="width: 100px;text-align: center;">
 <label style="width:80px " >Año T.C. </label>
  </th>
  <th style="width: 100px;text-align: center;">
 <label style="width:80px " >Mes T.C. </label>
  </th>
 <th style="width: 80px;text-align: center;">
 <label style="width:80px " >Valor T.C.</label>
  </th>
 </tr>
 
 </thead>
 
 </table>
 <div >
 
        
        
       
       
 </div>





<div id="camposFteFto">


     
   <s:if test="%{proyecto.idproyecto!=0}">
<s:set var="i" value="0" />
<s:set var="j" value="0" />
 <s:iterator value="proyecto.listaFuenteProyecto" >
 
 
 <s:set var="n" value="#i+1" /> 
   
  <div id="rowftefto<s:property value="#n" />"  class="rowftefto" >
 
 
 
 <input  class="idftefto" type="hidden" name="listaProyectoFteFto[<s:property value="#i" />].fteFto.idftefto" 
      value='<s:property value="%{fteFto.idftefto}" />'    />
 <select class="tipobusquedaftefto">
<option value="1">Nombre</option>
<option value="2">Siglas</option>
</select>
<input   class="nomftefto"     type="text" size="40"   value="<s:property value="fteFto.personajuridica.nombrepersonajuridica" />" />
<s:select  cssClass="idmonedaftefto"
	           name="listaProyectoFteFto[%{#i}].moneda.idmoneda"
	           headerKey="0" 
			   headerValue="[Seleccione]" 
			   list="listaMoneda"
			   listKey="idmoneda"
			   listValue="nombremoneda" 
			   theme="simple" />
			   
<input   class="montoftefto"   type="text" size="5"
   name="listaProyectoFteFto[<s:property value="#i" />].monto"  value='<s:property value="%{monto}" />'        />

<s:select       
	           cssClass="idanio"
	            name="listaProyectoFteFto[%{#i}].tipocambio.anio"
	           headerKey="0" 
			   headerValue="[Seleccione]" 
			   list="listaAnio"
			   listKey="idtipo"
			   listValue="nombretipo" 
			   theme="simple" />
			   
			   
<s:select  
	           cssClass="idmes"
	            name="listaProyectoFteFto[%{#i}].tipocambio.mes"
	           headerKey="0" 
			   headerValue="[Seleccione]" 
			   list="listaMes"
			   listKey="idtipo"
			   listValue="nombretipo" 
			   theme="simple" />			   			   
		
<input   class="idtipocambioftefto"   type="hidden" name="listaProyectoFteFto[<s:property value="#i" />].tipocambio.idtipocambio" 
 value='<s:property value="%{tipocambio.idtipocambio}" />'
 />
	
			   

  
<input     class="valortipocambioftefto"  disabled="disabled" type="text" size="5" 
name="listaProyectoFteFto[<s:property value="#i" />].tipocambio.valor"  value='<s:property value="%{tipocambio.valor}" />'  />

<span  class="i i_supr" title="eliminar" ></span>
 
 
 
 
  
   </div>
   <s:set var="i" value="#i+1" /> 
  </s:iterator>
  
  
</s:if>
<input type="hidden" value='<s:property value="#n" />'  id="idultfte" />
   
     
      
      
	
	

</div>
</fieldset>
  
  
  
  
  
<div id="divContRowFteFto" style="display: none;" >

<div id="rowftefto_n"  class="rowftefto" >


<input  class="idftefto" type="hidden" name="listaProyectoFteFto[_i].fteFto.idftefto" />
<select class="tipobusquedaftefto">
<option value="1">Nombre</option>
<option value="2">Siglas</option>
</select>
<input   class="nomftefto"     type="text" size="40"  />
<s:select  cssClass="idmonedaftefto"
	           name="listaProyectoFteFto[_i].moneda.idmoneda"
	           headerKey="0" 
			   headerValue="[Seleccione]" 
			   list="listaMoneda"
			   listKey="idmoneda"
			   listValue="nombremoneda" 
			   theme="simple" />
			   
<input   class="montoftefto"   type="text" size="5" name="listaProyectoFteFto[_i].monto"  />			  


<s:select  
               cssStyle="display:none"
               name="listaProyectoFteFto[_i].tipocambio.anio"
	           cssClass="idanio"
	           headerKey="0" 
			   headerValue="[Seleccione]" 
			   list="listaAnio"
			   listKey="idtipo"
			   listValue="nombretipo" 
			   theme="simple" />
<s:select  
               cssStyle="display:none"
               name="listaProyectoFteFto[_i].tipocambio.mes"   
	           cssClass="idmes"
	           headerKey="0" 
			   headerValue="[Seleccione]" 
			   list="listaMes"
			   listKey="idtipo"
			   listValue="nombretipo" 
			   theme="simple" />
			   
<input   class="idtipocambioftefto"   type="hidden" name="listaProyectoFteFto[_i].tipocambio.idtipocambio"  />

<input   class="valortipocambioftefto"  style="display:none"  disabled="disabled" type="text" size="5" name="listaProyectoFteFto[_i].tipocambio.valor"  />

<span  class="i i_supr" title="eliminar" ></span>



</div>

</div>
  
  

<!--END FUENTES DE FINANCIAMIENTO -->







<!-- DOCUMENTOS HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH  -->
<fieldset class="fsDocumento">
<legend class="lgMarco">
Documentos
</legend>

<div style="float: right;">
<a  href="#"   id="linkModalDoc" name="1" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Documentos"  />                     
</a>
</div>



 
<div id="divDocumento">
<!--  
<input type="hidden" id="maxDoc" name='${parametro.maxDoc}'  />
<input type="hidden"  id="maxArch" name='${parametro.maxArch}'  />
-->
<s:if test="%{proyecto.idproyecto!=0}">
<s:set var="i" value="0" />
<s:set var="j" value="0" />
 <s:iterator value="proyecto.listaProyectoArchivo" >
 
 
 <s:set var="n" value="#i+1" /> 
   
  <div id="rowDoc<s:property value="#n" />">
 
 <input  class="codigodocumento" type="hidden" name="listaProyectoArchivo[<s:property value="#i" />].archivo.idcodigo"
    value='<s:property value="#n" />'    />
<input  class="iddocumento" type="hidden" name="listaProyectoArchivo[<s:property value="#i" />].archivo.idarchivo"
    value='<s:property value="%{archivo.idarchivo}" />'     />
 
<span class="nomdocumento"><s:property value="archivo.descripcion" /></span>
<input class="desdocumento" type="text" name="listaProyectoArchivo[<s:property value="#i" />].archivo.descripcion" style="display: none;"
    value='<s:property value="%{archivo.descripcion}" />'  />
<div class="archivodocumento" style="display: none;">
  
<s:iterator value="archivo.listaArchivo">
<s:set var="m" value="#j+1" />
 
<div id="rowArch<s:property value="#m" />"> 
 
 <input  class="codigoarchivo" type="hidden" name="listaArchivo[<s:property value="#j" />].idcodigo"
    value='<s:property value="#m" />'   />
<input  class="idarchivo" type="hidden" name="listaArchivo[<s:property value="#j" />].idarchivo" 
     value='<s:property value="%{idarchivo}" />'   />
<span class="i i_remove"></span> 
<span class="nomarchivo"><s:property value="nombreInicial" /> </span>


<input class="codigoarchivopadre" type="hidden" name="listaArchivo[<s:property value="#j" />].idcodigopadre" 
    value='<s:property value="#n" />'   />
<input class="idarchivopadre" type="hidden" name="listaArchivo[<s:property value="#j" />].idarchivoPadre" 
value='<s:property value="idarchivoPadre" />'  />


</div>
 <s:set var="j" value="#j+1" />
</s:iterator>
 </div>
<span   title="eliminar" class="i i_supr"></span>
<span    title="editar"   class="i i_edit"></span>
 	
  
   </div>
   <s:set var="i" value="#i+1" /> 
  </s:iterator>
  
  
</s:if>
<input type="hidden" value='<s:property value="#n" />'  id="idultdoc" />
  <input type="hidden" value='<s:property value="#m" />'  id="idultarch"/>
</div>



</fieldset>

<!-- DOCUMENTOS HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH-->







<div style="text-align: center;">
	<input  type="button" id="btnRegistroProyecto" value="Guardar" class="submit"/>
	<input type="hidden" id="crear" name="crear" value="1" />
    <input  type="button" id="btnCancelarRegistroProyecto" value="Cancelar" class="submit"/>
</div>




<s:hidden id="hdareanatural" name="areanatural.idareanatural">  </s:hidden> 
  
  
   <!-- Areas -->

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
	 <s:iterator value="listaObjetoArea" status="areas">
		
		<s:if test="%{#areas.index<24 }">
		
		<div  id='divAnp<s:property value="#areas.index"/>' >
		<input id='area_<s:property value="idcodigo"/>' type="checkbox" 
		<s:if test="%{valor==1}">
		checked="checked" 
		</s:if>
		class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		
		     <input id='hdCatAnp<s:property value="#areas.index"/>' type="hidden" value="<s:property value="idtipo" />" />
		   	<label   for='area_<s:property value="idcodigo"/>'><s:property value="nombre"/></label>
		   </div>
		   
		</s:if>  
	
	</s:iterator>
	</div>
 
	<div style="float: left;">
	 <s:iterator value="listaObjetoArea" status="areas">
		<s:if test="%{#areas.index>=24 && #areas.index<47}">
		
		<div  id='divAnp<s:property value="#areas.index"/>' >
		<input id='area_<s:property value="idcodigo"/>' type="checkbox" 
		<s:if test="%{valor==1}">
		checked="checked" 
		</s:if>
		class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		    <input id='hdCatAnp<s:property value="#areas.index"/>' type="hidden" value="<s:property value="idtipo" />" />
		   	<label   for='area_<s:property value="idcodigo"/>'><s:property value="nombre"/></label>
		   </div>
		</s:if>  
	</s:iterator>
	</div>
    <div style="float: left;">
	 <s:iterator value="listaObjetoArea" status="areas">
		<s:if test="%{#areas.index>=47 }">
		<div  id='divAnp<s:property value="#areas.index"/>' >
		<input id='area_<s:property value="idcodigo"/>' type="checkbox" 
		<s:if test="%{valor==1}">
		checked="checked" 
		</s:if>
		class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		<input id='hdCatAnp<s:property value="#areas.index"/>' type="hidden" value="<s:property value="idtipo" />" />
		   	<label   for='area_<s:property value="idcodigo"/>'><s:property value="nombre"/></label>
		   </div>
		</s:if>  
	</s:iterator>
	</div>
	
	</div>
</div>

<div style="text-align: center;clear: both;">
 <input  type="button" name="btnAnp"  class="btnDetProy" value="Seleccionar"/>
</div>
</div>












<div id="divModalMsgProy" class="h" >

Se Registro con Exito.<br/>
Desea Registrar otro Proyecto?
</div>


</form>



<!-- INSTITUCION -->


<div id="divModalInst">
<form name="formRegistroInstitucion" id="formRegistroInstitucion" 
	action="#">
<div style="float: left;">
REGISTRO INSTITUCION
</div>
 <div style="float: right;">
 <a   href="#">
	  <img  name="imgInst"  class="linkCerrar" src="<%=request.getContextPath()%>/img/cancel.png"   />
</a>
 </div>
 
 
 
 <div style="clear: both;">
 <input type="hidden" id="hdtipoinst" name="codTipoInstitucion" />
<div class="rowReg"> 
  <label class="etqReg">Nombre:</label>
  <textarea id="txaNombreInst" name="nombre" rows="3" cols="40">
  </textarea>
  
  
 </div>
 <div class="rowReg"> 
  <label class="etqReg">Siglas:</label>
 <input  id="txtSiglasInst" type="text"  name="siglas" size="43"/>
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
 <div class="rowReg"> 
  <label class="etqReg">Email:</label>
 <input  id="txtEmail" type="text"  name="email" size="43"/>
 </div>
 
 
 
<div style="text-align: center;clear: both;">
 <input  type="button" id="btnRegInst"   value="Guardar" />
</div>
</div>
</form>
</div>

<!-- END INSTITUCION -->









<!--ARCHIVOS  DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD-->



<div id="divModalDoc" >
	
	<div style="float: left;">
	REGISTRO DOCUMENTO
	</div>
	<div style="float: right;">
      <a href="#">
	  <img  name="imgDoc"  class="linkCerrar" src="<%=request.getContextPath()%>/img/cancel.png"   />
      </a>
    </div>

<input id="hdTipoRegistroDoc" type="hidden"  />
<br/>
<!-- 
<label>Documento N°</label>
 
<span id="spNumDoc"> </span>
-->

<form method="post" enctype="multipart/form-data"
id="formRegistroArchivo"   name="formRegistroArchivo" action="cargaArchivo.action"
target="iframeUpload" >
<!-- documento -->
<div style="clear: both;">
<div id="divModalRegDoc">
<input class="hdModalDoc" type="hidden"  />
<label >Nombre Documento:</label>
<input  class="txtModalDoc"  size="50"  type="text"  />
<br/>
<br/>
<label >Archivo: </label>
<input  id="fileArchivo" name="file" type="file" />
<input  id="btnRegArchivo" type="button" value="Cargar"  />
<div class="divArchModalDoc">

</div>

</div>
<br/>
<div style="text-align: center;">
   <input  id="btnRegistroDoc"  type="button" value="Guardar">
</div>
</div>
<iframe name="iframeUpload" style="display: none;">
</iframe>

   
</form> 	
	
 
</div>


<div id="divContRowDoc" style="display: none;" >

<div id="rowDoc_n" >

<input  class="codigodocumento" type="hidden" name="listaProyectoArchivo[_i].archivo.idcodigo" />
<input  class="iddocumento" type="hidden" name="listaProyectoArchivo[_i].archivo.idarchivo" />
<span  class="nomdocumento"> </span>
<input class="desdocumento" type="text" name="listaProyectoArchivo[_i].archivo.descripcion" style="display: none;" />
<div class="archivodocumento" style="display: none;"> </div>


<span    title="editar"   class="i i_edit"></span>

<span   title="eliminar" class="i i_supr"></span>



</div>

</div>


<div id="divContRowArch" style="display: none;" >

<div id="rowArch_n" class="rowArchivo">
<span class="i i_remove"></span>
<input  class="codigoarchivo" type="hidden" name="listaArchivo[_i].idcodigo" />
<input  class="idarchivo" type="hidden" name="listaArchivo[_i].idarchivo" />
<span class="nomarchivo"> </span>
<input class="codigoarchivopadre" type="hidden" name="listaArchivo[_i].idcodigopadre" />
<input class="idarchivopadre" type="hidden" name="listaArchivo[_i].idarchivoPadre" />
</div>

</div>

<!-- END ARCHIVOS -->





 







