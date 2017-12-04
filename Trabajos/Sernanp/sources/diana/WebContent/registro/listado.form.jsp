<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<form id="formularioListadoFichas" method="post" >

<s:hidden name="idficharegistro_" id="idficharegistro_"  />

<h1>Listado de Formularios Enviados<br /><span>
<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
</span></h1> 
<br />

<div class="divList">

<display:table uid="row" name="listaficharegistro" pagesize="15" class="hor-minimalist-a" requestURI="registro/listadoformulario.action" excludedParams="*">

<display:column title="#">
	<s:checkbox theme="simple"  name="ficharegistro.idficharegistro" fieldValue="%{#attr.row.idficharegistro}" cssClass="idfichareg" />
</display:column>

<display:column title="N°" > <c:out value="${row_rowNum}"/></display:column>
  <display:column property="codigoficha" title="Código" />
  <%-- <display:column property="personajuridica.nombrepersonajuridica" title="Empresa" /> --%>
  <display:column property="fechacreacion" format="{0,date,dd/MM/yyyy}" title="Fecha de Envío" style="text-align: center;" />
  
  <display:column title="Estado" style="font-weight:bold;">
  <s:if test="#attr.row.idestadoficha==1">
    <s:text name="[Pendiente]"></s:text>
  </s:if>
  <s:elseif test="#attr.row.idestadoficha==2">
   <s:text name="">[Aprobado]<img src="img/pdf.gif" onclick="javascript:descargarArchivo_('<s:property value="#attr.row.idficharegistro" />');" style="cursor: pointer;" /></s:text>	
  </s:elseif>
  <s:elseif test="#attr.row.idestadoficha==3">
   <s:text name="">[Aprobado]<img src="img/pdf.gif" onclick="javascript:descargarArchivo_('<s:property value="#attr.row.idficharegistro" />');" style="cursor: pointer;" /></s:text>
  </s:elseif>  
  <s:elseif test="#attr.row.idestadoficha==4">
   <s:text name="[No Aprobado]"></s:text>      	
  </s:elseif>
  
  </display:column>
   
</display:table>


			
<%-- <table id="hor-minimalist-a" summary="Employee Pay Sheet">
    <thead>
    	<tr>
    		<th scope="col">#</th>
        	<th scope="col">N&deg;</th>
        	<th scope="col">Código</th>            
            <th scope="col">Fecha de Envío</th>
            <th>Estado</th>
            <th></th>            
    	<tr>
    	
    	</thead>
    	<tbody>
    	
    	<s:iterator status="stat" value="%{listaficharegistro}">
    	
    	<tr>
    		<td><s:checkbox theme="simple" name="ficharegistro.idficharegistro" fieldValue="%{idficharegistro}" /></td>
    		<td><s:property value="#stat.count" /></td><td><s:property value="codigoficha" /></td>
    		<td><s:date name="fechacreacion" format="dd/MM/yyyy" /></td>
    		<s:if test="%{idestadoficha == 1}">
    			<td><b>[Pendiente]</b></td>
    			<td>?</td>
    		</s:if>
    		<s:elseif test="%{idestadoficha > 1}">
    			<td><b>[Aprobado]</b></td>
    			<td><img src="img/pdf.gif" onclick="javascript:descargarArchivo_('<s:property value="idficharegistro" />');" style="cursor: pointer;" /></td>
    		</s:elseif>
    		<s:else>
    			<td><b>[Anulado]</b></td>
    			<td>X</td>
    		</s:else>
    	</tr>
    	
    	</s:iterator>
    	        
    </tbody>
</table> --%>	


</div>
<br />
<div>
	<input type="button" value="Consultar" class="submit2" id="btnViewFicha" />
</div>

<div class="msgselficha v_label2" style="display:none;" ><s:property value="getText('msgselficha')" /> </div>
	<div class="msgselfichas v_label2" style="display:none;" ><s:property value="getText('msgselfichas')" /> </div>

</form>