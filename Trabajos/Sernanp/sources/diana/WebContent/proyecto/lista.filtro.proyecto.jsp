<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>


<s:if test="%{control==1}">

<div id="divAnp" style="float:left;">  
<label>Areas Naturales con Proyectos</label> 
		 <div id="divAreaNatural">
		 <s:select  cssStyle="width:200px"
		   name="proyectoParam.areanatural.idareanatural"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaAreaNatural"
		   listKey="idareanatural"
		   listValue="desareanatural" 
		   cssClass="cboBuscarProyectos"
		   id="cboAnp"
		    /> 
		    </div>
</div>
	
<div style="float:left;clear: left;"> 
		<label>Ejecutor Financiero:</label> 
		 <s:select  
		   name="proyectoParam.ejecutorFinanciero.idejecutor"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaEjecutorFinanciero"
		   listKey="idejecutor"
		   listValue="personajuridica.siglas"  
		   cssClass="cboBuscarProyectos"
		   /> 
</div>
	

<div style="float:left;"> 
		<label>Ejecutor T&eacute;cnico</label> 
		 <s:select  
		   name="proyectoParam.ejecutorTecnico.idejecutor"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaEjecutorTecnico"
		   listKey="idejecutor"
		   listValue="personajuridica.siglas"  
		   cssClass="cboBuscarProyectos"
		   /> 
</div>

	
<div style="float:left;"> 
		<label>Financiamiento:</label> 
		 <s:select  
		   name="proyectoParam.ftefto.idftefto"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaFtefto"
		   listKey="idftefto"
		   listValue="personajuridica.siglas"
		   cssClass="cboBuscarProyectos"
		     /> 
</div>
</s:if>
<s:elseif test="%{control==2}">


</s:elseif>

 





<!--  

<div    id="divCategoriaAnp"  style="float:left"> 
<label>Categor&iacute;a ANP(Proyectos) :</label> 
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
 
 <div    id="divCategoriaAnp"  style="float:left"> 
<label>Categor&iacute;a ANP(Proyectos) :</label> 
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
 

<div id="divAnp" style="float:left;">  
<label>Areas Naturales con Proyectos</label> 
		 <div id="divAreaNatural">
		 <s:select  cssStyle="width:200px"
		   name="proyectoParam.areanatural.idareanatural"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaAreaNatural"
		   listKey="idareanatural"
		   listValue="desareanatural" 
		   cssClass="cboBuscarProyectos"
		   id="cboAnp"
		    /> 
		    </div>
</div>
	
<div style="float:left;clear: left;"> 
		<label>Ejecutor Financiero:</label> 
		 <s:select  
		   name="proyectoParam.ejecutorFinanciero.idejecutor"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaEjecutorFinanciero"
		   listKey="idejecutor"
		   listValue="personajuridica.siglas"  
		   cssClass="cboBuscarProyectos"
		   /> 
</div>
	

<div style="float:left;"> 
		<label>Ejecutor T&eacute;cnico</label> 
		 <s:select  
		   name="proyectoParam.ejecutorTecnico.idejecutor"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaEjecutorTecnico"
		   listKey="idejecutor"
		   listValue="personajuridica.siglas"  
		   cssClass="cboBuscarProyectos"
		   /> 
</div>

	
<div style="float:left;"> 
		<label>Financiamiento:</label> 
		 <s:select  
		   name="proyectoParam.ftefto.idftefto"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaFtefto"
		   listKey="idftefto"
		   listValue="personajuridica.siglas"
		   cssClass="cboBuscarProyectos"
		     /> 
</div>

-->
 
 
 <!--  
 <div style="float:left;clear: left;"> 
		<label>Ejecutor:</label> 
		 <s:select  
		   name="proyectoParam.ejecutor.idejecutor"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaEjecutor"
		   listKey="idejecutor"
		   listValue="personajuridica.siglas"  
		   cssClass="cboBuscarProyectos"
		   /> 
</div>
	
	
<div style="float:left;"> 
		<label>Financiamiento:</label> 
		 <s:select  
		   name="proyectoParam.ftefto.idftefto"  headerKey="0" 
		   headerValue="[Todos]" 
		   list="listaFtefto"
		   listKey="idftefto"
		   listValue="personajuridica.siglas"
		   cssClass="cboBuscarProyectos"
		     /> 
</div>
 
 
 -->
 
 
 <!--  
 
<div    id="divCategoriaAnp"  style="float:left;clear: left"> 
<label>Categor&iacute;a ANP(Proyectos) :</label> 
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
-->

 

