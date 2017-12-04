<%-- @ taglib uri="http://displaytag.sf.net" prefix="display" --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<script type="text/javascript">
<!--
$(function() {
    $('tr').hover(function() {
        $(this).css('backgroundColor', '#ccc');
    },function() {
        $(this).css('backgroundColor', '');
    }
);
});
//-->
</script>

<!-- Content -->
<h1>
	Mantenimiento Registro Personas<br />
	<span> <s:property
			value="areanatural.categoriaanp.descategoriaanp" /> <s:property
			value="areanatural.desareanatural" />
	</span>
</h1>
<br />

<form id="FormListadoPersonalRegistro" name="FormListadoPersonalRegistro" method="post" >

	
<div class="divBtnMant">
	<input type="button" value="Agregar" class="submit2" id="btnAgregarPersonReg" />	
	<input type="button" id="btnImpEx" value="Importar Excel" class="submit2" />

</div>
<div class="divList">


<display:table uid="row" name="datosp" pagesize="15" class="hor-minimalist-a" requestURI="registro/mantenimientopersona.action" excludedParams="*">

<display:column title="N°" > <c:out value="${row_rowNum}"/></display:column>
<display:column title="Nombres y Apellidos">
	<s:text name="#attr.row.nombre"></s:text>,
	<s:text name="#attr.row.apepat"></s:text>
	<s:if test="#attr.row.apemat != null">
	<s:text name="#attr.row.apemat"></s:text>
	</s:if>
</display:column>
<display:column title="Empresa/Inst." property="empresa"></display:column>
<display:column title="DNI/CE">
<s:set var="TD"><s:property value="#attr.row.tipodocumento.idtabla" /><s:property value="#attr.row.tipodocumento.idtipo" /></s:set>
<s:property value="%{tipos[#TD]}" />
</display:column>
<display:column title="N&uacute;mero de Doc." property="numerodocumento"></display:column>
<display:column title="Proced.">
<s:set var="PD"><s:property value="#attr.row.tipolocal.idtabla" /><s:property value="#attr.row.tipolocal.idtipo" /></s:set>
<s:property value="%{tipos[#PD]}" />
</display:column>
<display:column title="Genero">
<s:set var="GN"><s:property value="#attr.row.sexo.idtabla" /><s:property value="#attr.row.sexo.idtipo" /></s:set>
<s:property value="%{tipos[#GN]}" />
</display:column>
<display:column title="Opc.">
<img src="img/page_edit.png" alt="[Editar]" title="Editar" style="cursor: pointer;" onclick="javascript:Fnc_editarPersonalRegistro('<s:property value="#attr.row.idpersonalregistro" />')" />
<img src="img/eliminar.png" alt="[Eliminar]" title="Eliminar" style="cursor: pointer;" onclick="javascript:Fnc_eliminarPersonalRegistro('<s:property value="#attr.row.idpersonalregistro" />')" />
</display:column>

</display:table>
<%-- 
<table id="hor-minimalist-a" summary="Employee Pay Sheet">
    <thead>
    	<tr>
        	<th scope="col">N&deg;</th>
        	<th scope="col">Nombres y Apellidos</th>            
            <th scope="col">Empresa/Inst.</th>
            <th scope="col">DNI/CE</th>
            <th scope="col">N&uacute;mero de Doc.</th>
            <th scope="col">Proced.</th>
            <th scope="col">Genero</th>
            <th scope="col" colspan="2" >Opc.</th>            
    	<tr>
    	
    	</thead>
    	<tbody>
    	
    	<s:iterator status="stat" value="%{datosp}">
   	
   		    	    	
    	<tr>
   	        	<td><s:property value="#stat.count" /></td><td><s:property value="nombre" />,&nbsp;<s:property value="apepat" />&nbsp;<s:property value="apemat" /></td>
   	        	<td><s:property value="empresa" /></td><td><s:property value="%{tipos[tipodocumento.idtabla + '' + tipodocumento.idtipo]}" /></td>
   	        	<td><s:property value="numerodocumento" /></td><td><s:property value="%{tipos[tipolocal.idtabla + '' + tipolocal.idtipo]}" /></td>
   	        	<td><s:property value="%{tipos[sexo.idtabla + '' + sexo.idtipo]}" /></td>
   	        	<td><div><img src="img/page_edit.png" alt="[Editar]" title="Editar" style="cursor: pointer;" onclick="javascript:Fnc_editarPersonalRegistro('<s:property value="idpersonalregistro" />')" /></div></td>
   	        	<td><div><img src="img/eliminar.png" alt="[Eliminar]" title="Eliminar" style="cursor: pointer;" onclick="javascript:Fnc_eliminarPersonalRegistro('<s:property value="idpersonalregistro" />')" /></div></td>
   	    </tr>   	    
   	    
   	    </s:iterator>
   	            	        
    </tbody>
</table>	
 --%>

</div>

<input type="hidden" id="idpersonalregistro" name="idpersonalregistro" value="" />

<%--
<display:table id="datosp" name="datosp" pagesize="2" export="false" excludedParams="*" requestURI="/registro/mantenimientopersona">
<display:column property="nombre" title="Nombres" paramId="nombre" sortable="false"/>
<display:setProperty name="paging.banner.placement" value="top" />
</display:table>
 --%>

</form>

<div id="divModalImportarArchivo"></div>
<div id="divModalPersonalRegistro"></div>
<div id="dialog-message" title="Confirmación de Eliminación" style="display: none;">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		¿Esta seguro de eliminar?
	</p>
	
</div>
