<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>   
<script type="text/javascript" src="js/lib/_class.validator.js">
</script>
 



<form id="formListaFichaTurismo" method="post" >
<input    id="hdfichaturismo" type="hidden" name="idparam"   />
</form>
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




   <div  id="filters">
   
   
	<form id="search" method="post" action="">
	   
	   
	   <div >
	   <div style="float:left; width: 250px;">
	     <span> 
		<s:textfield value="" name="q" id="q" label="Código" 
			cssClass="numficha valid onlydigits searchterm" maxlength="16" />
		    </span>
	   </div>
		
		
		   
		   <div style="float: right;">
		     <input type="submit" value="Buscar" class="submit " id="submit" /> <span id="message"></span>   
		     <input type="button" value="Limpiar" class="submit btnLimpiar"  param="search" >
		   </div>
		   </div>
		   
		   <br>
		   
		    <div class=" " style="clear: both;"> 
				<span id="imgBusqDetFich" style="cursor:pointer;font:bold 9px Verdana;text-transform:uppercase;">
					<img  src="img/16x16/actions/list-add.png" 
						title="Busqueda Avanzada" style="vertical-align: middle;"  /> Busqueda Avanzada
				</span>
			</div>
		   
		   
		   <!-- campo busqueda fecha -->
		   
		   <div  id="divBusqDetFich" class="regmarco"  style="clear: both;display: none; margin-bottom: 10px;">
		   

		     
		     <div class="cfecha">
			<label >fecha visita inicio </label>
			<input   type="text"  id="fpropuestainicio"  readonly="readonly" name="fpropuestainicio"  class="fpropuesta"  size="10"  />
			</div>
			
			<div class="cfecha">
			<label >fecha visita fin </label>
			<input   type="text"  id="fpropuestafin"   readonly="readonly"  name="fpropuestafin"  class="fpropuesta"  size="10"  />
			</div>
		   
		   <span class="creg">
          <label>Rutas de Turismo</label>
           <s:select list="listaRutaturismo" name="idrutaturismo"
										listKey="idrutaturismo"  
										listValue="nombrerutaturismo"   
                                         theme="simple" 
                                         headerKey="0"
                                         headerValue="TODOS"
                                         
                                         />
             </span>
             
             <s:if  test="%{#session.idtiporol!=constantes.TIPO_ROL_OPERADOR_TURISMO}">
             <span class="creg">
          <label>Operadores de Turismo</label>
           <s:select list="listaOperadorturismo" name="idoperadorturismo"
										listKey="idoperadorturismo"  
										listValue="nombrepersonajuridica"   
                                         theme="simple" 
                                         headerKey="0"
                                         headerValue="TODOS"
                                         cssStyle="width:150px"
                                         />
             </span>
            
		    <span class="creg" >
          <label>Estado Ficha</label>
           <s:select list="listaEstadoficha" name="idestadoficha"
										listKey="idtipo"  
										listValue="nombretipo"   
                                         theme="simple" 
                                         headerKey="0"
                                         headerValue="TODOS"
                                         value="%{idestado}"
                                         />
             </span>
             <input type="hidden" id="hdestadoficha" value="${idestado}" />
		   </s:if>
		   
		   
		   
		   
		   
		   
		   </div>
		  
		   	
	</form>
	</div>
	
	<br style="clear: both;"/>
<br>
<div id="results" style="margin-top: 15px">
		<s:include value="ajax.fichas.jsp" />
</div>	
 
<div id="opcFicha">
   <div id="linkClose" style="width:100%">
   <span id="closemodal" style="float:right;margin-left:20px;cursor:pointer">
	    <span class="i i_remove"></span>
	    <strong>Cerrar</strong>
   </span>
   
    <span   id="linkimprimir" style="float:right">
       <a   style="margin-left: 20px" href="#" class="button dom " name="${ficha}" id="btnExportPDF"  ><span class="i i_pdf"></span> <span>Descargar Ficha</span></a>
	   <a   style="margin-left: 20px"  href="#" class="button dom" id="print"><span class="i i_print"></span> <span>Imprimir</span></a>
    </span>
   
   
  </div>     
</div>
	
<div id="divDetalleFicha" class="divRegistroModal2" style="display:none"  >
   
</div>

    
    </div>





<!-- MODAL REG TUR -->

<div id="divModalRegTur" style="display: none;">
<form id="formRegTurista">
  <div  id="regTurista" style="clear: both;">
<input  class="idvisitante" type="hidden" name="idvisitante"  >
<div class="rowReg"> 
  <label class="etqReg " style="width: 200px;">Nombres:</label>
     <s:textfield  size="30"    name="nombre"  cssStyle="text-transform:uppercase"
										cssClass="content valid input nombre" /> 
</div>
  
 <div class="rowReg"> 
  <label class="etqReg" style="width: 200px">Apellido Paterno:</label>
     <s:textfield  size="30"   name="apepat" cssStyle="text-transform:uppercase"
										cssClass="input paterno" /> 
</div>

<div class="rowReg"> 
  <label class="etqReg" style="width: 200px">Apellido Materno:</label>
     <s:textfield   size="30"    name="apemat" cssStyle="text-transform:uppercase"
										cssClass="input materno" /> 
</div>

<div class="rowReg">
	<label for="fechanacimiento__" style="width: 200px">Fecha de Nacimiento:</label>
	 
		<input  id="fnacdialog" value=""  type="text" name="fnac"
		 size="11" class="dateDMY valid input datepicker fnac fechanacvis fnacimiento" readonly="readonly" title="Fecha" />
	
</div> 

<div class="rowReg">
            <label class="etqReg" style="width: 200px">Pa&iacute;s:</label>
			<s:select list="paises" name="idpais"
										listKey="idpais"  
										listValue="nompais"										
										cssClass="idpais"
										theme="simple"
									/>
</div>  

<div class="rowReg" >
		<label class="etqReg" style="width: 200px">G&eacute;nero:</label>	
			 <s:select  
		                               name="idsexo"  
		                                  
		                                list="listaGenero"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="select valid idsexo" /> 
									
</div>
 
<div class="rowReg" >
		<label class="etqReg" style="width: 200px">Tipo Documento:</label>	
			<s:select  
		                               name="idtipodocumento"  headerKey="0" 
		                                 headerValue="[No aplica]" 
		                                list="listaTipoDocumento"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="tipodoc" />
									
</div> 
  
 <div class="rowReg" >
		<label class="etqReg" style="width: 200px">Nro doc:</label>	
			<s:textfield name="numerodocumento"  size="16" 
									cssClass="doc valid v_norequired input numdoc"  />  
									
</div> 
  
 
 
 
<div style="text-align: center;clear: both;">
 <input style="cursor: pointer;" type="button" id="btnRegTur"   value="Guardar" />
</div>
</div>
</form>
</div>
	
	
<!-- MODAL -->
 <div id="divModalConfirmacion">
  </div>	

<!-- End Content -->
