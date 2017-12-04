<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>


    <div style="float: left;">
	 <s:iterator value="listaObjetoArea" status="areas">
		
		<s:if test="%{#areas.index<24 }">
		<s:if test="%{valor==1}">
		<input id='area_<s:property value="idcodigo"/>' type="checkbox" checked="checked" class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		</s:if>
		<s:else>
		<input id='area_<s:property value="idcodigo"/>' type="checkbox"  class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		</s:else>
		
		   	<label   for='area_<s:property value="idcodigo"/>'><s:property value="nombre"/></label>
		  <br/>
		</s:if>  
	
	</s:iterator>
	</div>
 
	<div style="float: left;">
	 <s:iterator value="listaObjetoArea" status="areas">
		<s:if test="%{#areas.index>=24 && #areas.index<47}">
		<s:if test="%{valor==1}">
		<input id='area_<s:property value="idcodigo"/>' type="checkbox" checked="checked" class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		</s:if>
		<s:else>
		<input id='area_<s:property value="idcodigo"/>' type="checkbox"  class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		</s:else>
		
		   	<label   for='area_<s:property value="idcodigo"/>'><s:property value="nombre"/></label>
		  <br/>
		</s:if>  
	</s:iterator>
	</div>
    <div style="float: left;">
	 <s:iterator value="listaObjetoArea" status="areas">
		<s:if test="%{#areas.index>=47 }">
		<s:if test="%{valor==1}">
		<input id='area_<s:property value="idcodigo"/>' type="checkbox" checked="checked" class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		</s:if>
		<s:else>
		<input id='area_<s:property value="idcodigo"/>' type="checkbox"  class="checkListaAnp"  name='<s:property value="nombre"/>' value='<s:property value="idcodigo"/>' />
		</s:else>
		
		   	<label   for='area_<s:property value="idcodigo"/>'><s:property value="nombre"/></label>
		  <br/>
		</s:if>  
	</s:iterator>
	</div>
