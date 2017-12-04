<%@ taglib prefix="s" uri="/struts-tags"%>    

<!-- Version Coyla 31-07-2012 Modificado JCEV -->
<s:select theme="simple" name="areanatural.codareanatural" id="IdArea" 
          list="listaAreasNaturales" listKey="codareanatural"
          listValue="desareanatural" headerKey=""
          headerValue="[--Seleccione--]" value="areanatural.codareanatural"
          onchange="showTurismRoad(this.value);"
          cssClass="select valid"
/>

          
          
          

<!-- <option value="">--Seleccione--</option> -->
<%-- <s:iterator status="stat" value="%{listaAreasNaturales}" >		 --%>
<%-- 	<option value="<s:property value="codareanatural" />"> --%>
<%-- 		<s:property value="desareanatural" />						 --%>
<!-- 	</option> -->
<%-- </s:iterator> --%>

