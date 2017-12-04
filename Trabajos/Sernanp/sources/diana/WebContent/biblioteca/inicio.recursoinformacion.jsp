<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="proyecto.util.*" %>

<!-- Content -->
<form name="formInicioRecInf" id="formInicioRecInf" method="post"
	action="#">
	<h1 style="display:inline-block;width:670px;">
		Biblioteca Institucional
	</h1>
	
	
	<div class="buttons" style="text-align:right;display:inline-block;width:300px;text-align:right;">    
		<span class="button" id="btnNuevoRecInf" style="font:bold 11px Verdana;text-transform:uppercase;"> 
			 <span class="i i_add" style="vertical-align:middle;"></span>  
			 <span>Crear Nuevo Recurso de Informaci&oacute;n</span> 
		</span> 
	</div>
	   



<div id="filters"> 
  
  <!-- CAMPOS BUSQUEDA -->
   <div style="float: left;width: 830px"> 
   
   <div class="row">
     		
	      	<div   style="float:left;width: 200px;"  > 
		  		<label>Tipo:</label> 
		 		<s:select  
				   name="idtipo"  headerKey="0" 
			    	 headerValue="[Todos]" 
				   list="listaTipoRecursoInformacion"
				   listKey="idtipo" 
				   listValue="nombretipo"
				   id="cboTipo" 
				   cssClass="cboBuscarRecInf"
				    /> 
			</div>  
	     	<div style="float:left;width:120px; "> 
				<label>Medio:</label> 
				<s:select  
					name="idmedio"  headerKey="0" 
					headerValue="[Todos]" 
					list="listaMedioRecursoInformacion"
					listKey="idtipo"
					listValue="nombretipo"
					id="cboMedio"
				    cssClass="cboBuscarRecInf"
					/>    
			</div>  
	     	
	     	<div style="float:left;"> 
					<label  >T&iacute;tulo:</label> 
					<s:textfield  id="txtTitulo" name="titulo" size="55"/>
			</div>
	     	
			
	</div>
	
	
	
	 <!-- Búsqueda Avanzada-->
	
	<div id="divBusqAvRecInf" style="display: none;">
	
	<div class="row">
     		
	      	<div id="divCategoriaAnp"  style="float:left;width: 200px;"  > 
		  		<label>Categor&iacute;a ANP :</label> 
		 		<s:select  
				   name="idcategoriaanp"  headerKey="0" 
			    	 headerValue="[Todos]" 
				   list="listaCategoriaAnp"
				   listKey="idcategoriaanp" 
				   listValue="descategoriaanp"
				   id="cboCategoriaAnp" 
				   cssClass="cboBuscarRecInf"
				    /> 
			</div>  
	     	<div  id="divAnp" style="float:left;width: 400px">  
				<label>Areas Naturales :</label> 
			 	<div id="divAreaNatural">
					 <s:select  cssStyle="width:300px"
					   name="idareanatural"  headerKey="0" 
					   headerValue="[Todos]" 
					   list="listaAreaNatural"
					   listKey="idareanatural"
					   listValue="desareanatural"
					   id="cboAnp" 
					   cssClass="cboBuscarRecInf"
					   theme="simple"
					    /> 
				</div>
			</div>
			<div style="float:left;width:120px; "> 
				<label>Idioma:</label> 
				<s:select  
					name="ididioma"  headerKey="0" 
					headerValue="[Todos]" 
					list="listaIdioma"
					listKey="ididioma"
					listValue="nombreidioma"
					id="cboIdioma"
				    cssClass="cboBuscarRecInf"
					/>    
			</div>  
			
			
		</div>
		
		
		
		
		
		<div class="row">
     		
	      	<div style="float:left;width:300px; "> 
				<label>Tem&aacute;tica:</label> 
				<s:select  
					name="idtematica"  headerKey="0" 
					headerValue="[Todos]" 
					list="listaTematica"
					listKey="idtematicarecursoinformacion"
					listValue="nombretematicarecursoinformacion"
					id="cboTematica"
				    cssClass="cboBuscarRecInf"
					/>    
			</div>  
			
			<div style="float:left;"> 
					<label  >Autor:</label> 
					<s:textfield  id="txtAutor" name="nomautor" size="40" theme="simple"/>
			</div>
			
			<div style="float:left;"> 
					<label  >SGD:</label> 
					<s:textfield  id="txtSgd" name="codsgd" size="20" theme="simple"/>
			</div>
			
		</div>
		
	</div>
   
         <div class=" "> 
				<span id="imgBusqAvRecInf" style="cursor:pointer;font:bold 9px Verdana;text-transform:uppercase;">
					<img  src="img/16x16/actions/list-add.png" 
						title="Busqueda Avanzada" style="vertical-align: middle;"  /> B&uacute;squeda Avanzada
				</span>
			</div>
   
   </div>
   <!-- END CAMPOS BUSQUEDA -->
   
   <!-- BOTONES -->
    <div style="width: 100px;float: right;">
		<input type="button" id="btnBuscarRecInf" value="Buscar" class="submit" />
		<input type="button" id="btnLimpiarRecInf" value="Limpiar" class="btnInicioRecInf reset" />
    </div>
  
</div>

<input type="hidden" name="idrecursoinformacionparam" id="idRecursoInformacionParam" value="0"/>
<input type="hidden" name="pagina" id="idpaginafuente" value="0"/>
<div  id="divListaRecursoInformacion" style='border:none;clear:both;'>


	<jsp:include page="/biblioteca/lista.recursoinformacion.jsp" />

</div>




</form>


<div id="divDetalleRecInf">


</div>




<div id="divModalConf">
   Está seguro que desea eliminar lo seleccionado?
</div>


<div id="divModalMsgTemporalRecInf">
   Faltan registrar algunos recursos
</div>



