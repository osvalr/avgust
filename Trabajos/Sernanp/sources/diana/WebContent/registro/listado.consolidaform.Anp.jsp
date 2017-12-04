<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form id="formularioListadoFichasAprob" method="post" >

<h1>Listado de Formularios Enviados<br /><span>
<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
</span></h1> 


<div class="divList">

<input type="hidden" name="ficharegistro.idficharegistro" id="idficharegistro" />

<table id="hor-minimalist-a" summary="Employee Pay Sheet">
    <thead>
    	<tr>
    		<!-- <th scope="col">#</th> -->
        	<th scope="col">N&deg;</th>
        	<th scope="col">Código</th>
        	<th scope="col">Empresa</th>
            <th scope="col">Fecha de Envío</th>
            <th>Opc.</th>             
    	<tr>
    	
    	</thead>
    	<tbody>
    	
    	<s:iterator status="stat" value="%{listaficharegistro}">
    	
    	<tr>
    		<%-- <td><s:checkbox theme="simple" name="ficharegistro.idficharegistro" fieldValue="%{idficharegistro}" cssClass="idfichareg" /></td> --%>
    		<td><s:property value="#stat.count" /></td>
    		<td><s:property value="codigoficha" /></td>
    		<td><s:property value="personajuridica.nombrepersonajuridica" /></td>
    		<td><s:date name="fechacreacion" format="dd/MM/yyyy" /></td>
    		<s:if test="%{idestadoficha == 3}">
    			<td><img src="img/document_lined.png" onclick="javascript:Fnc_MuestraFichaParaConsolidar('<s:property value="idficharegistro" />')" border="0" style="cursor: pointer;" /></td>
    		</s:if>
    		<s:else>
    			<td><img src="img/file_conso.png" onclick="javascript:Fnc_MuestraFichaParaConsolidar('<s:property value="idficharegistro" />')" border="0" style="cursor: pointer;" /></td>
    		</s:else>
    		
    	</tr>
    	
    	</s:iterator>
    	        
    </tbody>
</table>	


</div>
<br />

</form>