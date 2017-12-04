<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="proyecto.util.*" %>

<!-- Content -->
<form name="formInicioProyectos" id="formInicioProyectos" method="post"
	action="#">
	<h1 style="display:inline-block;width:670px;">
		Consulta Proyectos 
	</h1>
	
	<s:if test="#session.USUARIO_ACTUAL.rol.mapRolModulo.get('Proyectos')==1">
	<div class="buttons" style="text-align:right;display:inline-block;width:300px;text-align:right;">    
		<span class="button" id="btnNuevoProyecto" style="font:bold 11px Verdana;text-transform:uppercase;"> 
			 <span class="i i_add" style="vertical-align:middle;"></span>  
			 <span>Crear Nuevo Proyecto</span> 
		</span> 
	</div>
	</s:if>   
<div id="filters"> 
   <div style="float: left;width: 830px"> 
		<div class="row">
     		<div style="float:left;width:120px; "> 
				<label>Estado Vigencia:</label> 
				<s:select  
					name="proyectoParam.flagVigencia"  headerKey="0" 
					headerValue="[Todos]" 
					list="listaEstadoVigencia"
					listKey="idestado"
					listValue="nombestado"
					id="cboEstVig"
					value="estado.idestado"
					ccssClass="cboBuscarProyectos"
					/>    
			</div>  
	      	<div id="divCategoriaAnp"  style="float:left;width: 200px;"  > 
		  		<label>Categor&iacute;a ANP con Proyectos :</label> 
		 		<s:select  
				   name="proyectoParam.areanatural.categoriaanp.idcategoriaanp"  headerKey="0" 
			    	 headerValue="[Todos]" 
				   list="listaCategoriaAnp"
				   listKey="idcategoriaanp" 
				   listValue="descategoriaanp"
				   id="cboCategoriaAnp" 
				   cssClass="cboBuscarProyectos"
				    /> 
			</div>  
	     	<div  id="divAnp" style="float:left;width: 400px">  
				<label>Areas Naturales con Proyectos:</label> 
			 	<div id="divAreaNatural">
					 <s:select  cssStyle="width:300px"
					   name="proyectoParam.areanatural.idareanatural"  headerKey="0" 
					   headerValue="[Todos]" 
					   list="listaAreaNatural"
					   listKey="idareanatural"
					   listValue="desareanatural"
					   id="cboAnp" 
					   cssClass="cboBuscarProyectos"
					   theme="simple"
					    /> 
				</div>
			</div>
			
			
		</div>
	    <!-- Búsqueda Avanzada-->
		<div>
			<div id="divBusqDetProy" style="display: none;">
				<div class="row">
					<div style="float:left;"> 
						<label  >Nombre Proyecto:</label> 
						<s:textfield    id="txtNomProyecto" name="proyectoParam.nombre" size="55"/>
					</div>
					<div style="float: left;"> 
						<label  >Objetivo Proyecto:</label> 
						<s:textfield  id="txtObjProyecto" name="proyectoParam.objetivo"/>
					</div>
					<div style="float:left;"> 
						<label  >Zona Espec&iacute;fica:</label> 
						<s:textfield   id="txtAreaEspecifica" name="proyectoParam.areaEspecifica"/>
					</div>
				</div>
				
				<div class="row">
			     	<div style="float:left;width: 200px;"> 
						<label  >Tipo Proyecto:</label>  
						 <s:select  id="cboTipoProyecto"
						   name="proyectoParam.tipoProyecto.idTipo"  headerKey="0" 
						   headerValue="[Todos]" 
						   list="listaTipoProyecto"
						   listKey="idtipo"
						   listValue="nombretipo" 
						   cssClass="cboBuscarProyectos"
						 /> 
					</div> 
					<div style="float:left;width: 280px;"> 
						<label>Categoria Proyecto:</label>  
						 <s:select  id="cboCategoriaProyecto"
						   name="proyectoParam.categoriaproyecto.idtipo"  headerKey="0" 
						   headerValue="[Todos]" 
						   list="listaCategoriaProyecto"
						   listKey="idtipo"
						   listValue="nombretipo" 
						   cssClass="cboBuscarProyectos"
						 /> 
					</div> 
				 	<div style="float:left; width: 350px;"> 
						<label>Financiamiento:</label> 
						<div id="divFteFto">
							<s:select  
								id="cboFteFto"
								name="proyectoParam.ftefto.idftefto"  headerKey="0" 
								headerValue="[Todos]" 
								list="listaFtefto"
								listKey="idftefto"
								listValue="personajuridica.siglas"
								cssClass="cboBuscarProyectos"
								cssStyle="width:300px"
							    /> 
						</div>  
					</div>
				</div>
				<div class="row">
			     
				    <div style="float:left;width: 150px;"> 
					  	<label >Es Subproyecto de:</label>
					   	<s:select  id="cboProyectoPrincipal"
							   name="proyectoParam.proyectoPrincipal.idproyecto"  headerKey="0" 
							   headerValue="[Todos]" 
							   list="listaProyectoPrincipal"
							   listKey="idproyecto"
							   listValue="siglasproyecto" 
							   theme="simple"
						  		cssClass="cboBuscarProyectos"  
							 /> 
					</div>
			       <div style="float:left;width: 340px;"> 
						<label>Ejecutor Financiero:</label>   
					 	<div id="divEjecFinanciero" >  
						 	<s:select  
							 	id="cboEjecFin"
							   	name="proyectoParam.ejecutorFinanciero.idejecutor"  headerKey="0" 
							   	headerValue="[Todos]" 
							   	list="listaEjecutorFinanciero"
							   	listKey="idejecutor"
							   	listValue="personajuridica.siglas"  
							   	cssClass="cboBuscarProyectos" 
							   	/>   
						</div> 
			        </div>
			       
					<div style="float:left; width: 340px;"> 
						<label>Ejecutor T&eacute;cnico</label> 
						 <div id="divEjecTecnico">
						 <s:select  
						 id="cboEjecTec"
						   name="proyectoParam.ejecutorTecnico.idejecutor"  headerKey="0" 
						   headerValue="[Todos]" 
						   list="listaEjecutorTecnico"
						   listKey="idejecutor"
						   listValue="personajuridica.siglas"  
						   cssClass="cboBuscarProyectos"
						   cssStyle="width:300px"
						   /> 
						   </div>
				   	</div>
				</div>
				<div class="row">
				  <div style="float:left;width: 200px;"> 
						<label  >Estado Proyecto:</label>  
						 <s:select  
						   name="proyectoParam.estadoProyecto.idEstado"  headerKey="0" 
						   headerValue="[Todos]" 
						   list="listaEstadoProyecto"
						   listKey="idestado"
						   listValue="nombestado" 
						   cssClass="cboBuscarProyectos"
						 /> 
					</div>
				</div>
			</div>
			
			
			<div class=" "> 
				<span id="imgBusqDetProy" style="cursor:pointer;font:bold 9px Verdana;text-transform:uppercase;">
					<img  src="img/16x16/actions/list-add.png" 
						title="Busqueda Avanzada" style="vertical-align: middle;"  /> Busqueda Avanzada
				</span>
			</div>
			
		</div>
	</div>
    <div style="width: 100px;float: right;">
		<input type="button" id="btnBuscarProyectos" value="Buscar" class="submit" />
		<input type="button" id="btnLimpiarProyectos" value="Limpiar" class="reset" />
    </div>
    
   </div>
	<!--  
	<div style="float:right;">
	   <input type="button" id="btnNuevoProyecto" value="Nuevo" class="submit" /> 
	  </div>
	-->
	<input type="hidden" name="idProyectoParam" id="idProyectoParam" value="0"/>
<div  id="divListaProyectos" style='border:none;clear:both;'>


	<jsp:include page="/proyecto/lista.proyecto.jsp" />

</div>



</form>


<div id="divDetalleProyecto">


</div>


<div id="divModalConf">
   Está seguro que desea eliminar lo seleccionado?
</div>

