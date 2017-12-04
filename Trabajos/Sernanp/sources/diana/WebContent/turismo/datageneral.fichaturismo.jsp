<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>





<table   id="tdatosgenficha">
<tbody>
<tr >
<td  >AREA NATURAL</td>
<td   ><s:property value="areanatural.categoriaanp.siglascategoriaanp" />-<s:property value="areanatural.desareanatural" /> </td>
</tr>
<tr>
<td  >RUTA TURISMO</td>
<td >${fichaturismo.rutaturismo.nombrerutaturismo} </td>
</tr>

<tr>
<td style="di">AGENCIA DE VIAJE</td>
<td >${fichaturismo.empresaturismo.nombrepersonajuridica }</td>
</tr>

<tr>
<td>OPERADOR TURISTICO</td>
<td >${fichaturismo.operadorturismo.nombrepersonajuridica } </td>
</tr>

	<tr>
	  <td>TIPO TURISMO</td> 
	   <td >
	    <s:iterator   status="stat" value="fichaturismo.listaTipoturismoFichaturismo"> 
		<span style="text-transform:uppercase;font-size:12px">
		   <s:if test="%{!#stat.last}">
		    <s:property value="tipoturismo.nombretipoturismo" />
		    ,
		   </s:if>
			<s:else>
			 <s:property value="tipoturismo.nombretipoturismo" />
			</s:else>
			
		</span>
       </s:iterator>
	   </td>
	</tr>	

	<tr>
	  <td>ACTIVIDADES TURISTICAS</td> 
	   <td >
	    <s:iterator   status="stat" value="fichaturismo.listaActividadturismo"> 
		<span style="text-transform:uppercase;font-size:12px">
		   <s:if test="%{!#stat.last}">
		    <s:property value="nombreactividadturismo" />
		    ,
		   </s:if>
			<s:else>
			 <s:property value="nombreactividadturismo" />
			</s:else>
			
		</span>
       </s:iterator>
	   </td>
	</tr>	





	<tr>
	  <td>GUIA(S) / ORIENTADOR(ES)</td> 
	   <td >
	    <s:iterator   status="stat" value="fichaturismo.listaGuiaFichaturismo"> 
		<span style="text-transform:uppercase;font-size:12px">
		    
	<span style="text-transform:uppercase;font-size:12px">
		<s:property value="guia.apepat" />
		<s:property value="guia.apemat" />,
		<s:property value="guia.nombre" />
	</span> 
	<br>
  			
		</span>
       </s:iterator>
	   </td>
	</tr>	

<tr>
<td >FECHA TENTATIVA DE INGRESO</td>
<td   ><s:date format="dd-MM-yyyy" name="fichaturismo.fechapropuesta" /> </td>
</tr>
</tbody>

</table>













 