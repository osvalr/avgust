<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  
<head>
<style type="text/css">
#ss{
	font: bold 10px "Tahoma, Arial, sans-serif;
	color: #BDBDBD;
	text-align: center;
	margin: 10px auto;	
}

.TrSombreado{
	background-color:#F7B64B;
}
.TrDesombreado{
	background-color: #FFFFFF;
}
.TrReincidente{
	background-color: #EFFFEB;
}
</style>
<script type="text/javascript">
	function sombrear(obj){
//  		$(obj).css('background-color','#F7B64B');
			$(obj).addClass("TrSombreado");
	}
	
	function dessombrear(obj){
//  		$(obj).css('background-color','');
			$(obj).removeClass("TrSombreado");
	}

</script>


</head>

<body>
<s:set var="i" value="1"/>
<form id="ForminfraccionesSeleccionadas" name="ForminfraccionesSeleccionadas" >
<table id="ss" width="100%" border="1" cellpadding="0" cellspacing="1" bordercolor="#BDBDBD" style="border-collapse:collapse;" >
<s:iterator value="listaInfracciones">

	<tr>
	<%-- <tr onmouseover="javascript:sombrear(this);" onmouseout="javascript:dessombrear(this)" id="TrModal<s:property value="#i" />"> --%>
<%-- 	<td><s:property value="#i" /></td> --%>
	<td>
	<s:if test="%{checkeado > 0}">
	<!-- 
	<input name="c<s:property value="#i" />" type="checkbox" id="c<s:property value="#i" />" 
	 value="<s:property value='idinfraccion' />" onclick="chequea(this)" checked="checked" />
	  -->
	
	<input name="chkinfra" type="checkbox" id="chkinfra" value="<s:property value='idinfraccion' />" checked="checked" />
	  
	</s:if>
	<s:if test="%{checkeado == 0}">
	<!-- 
	<input name="c<s:property value="#i" />" type="checkbox" id="c<s:property value="#i" />" 
	 value="<s:property value='idinfraccion' />" onclick="chequea(this)" />
	 -->
	 <input name="chkinfra" type="checkbox" id="chkinfra" value="<s:property value='idinfraccion' />" />
	</s:if>
	
	</td>
	<td>
	<label><s:property value="descripcioninfraccion" /></label>
	<!--
	<label for="c<s:property value="#i" />"><s:property value="descripcioninfraccion" /></label> 
	<input type="hidden" id="h<s:property value='#i' />"  value ="<s:property value='descripcioninfraccion' />"/>
	<input type="hidden" id="hCod<s:property value='#i' />"  value="<s:property value="idinfraccion" />"  />
	<input type="hidden" id="hCodMostrar<s:property value='#i' />"  value="<s:property value="codigoinfraccion" />"  />
	-->
	<input type="hidden" id="desinfra" name="desinfra" value ="<s:property value='descripcioninfraccion' />" />
	<input type="hidden" id="idinfra" name="idinfra" value="<s:property value="idinfraccion" />"  />
	<input type="hidden" id="codinfra" name="codinfra" value="<s:property value="codigoinfraccion" />"  />
	
	</td>
<%-- 	<td><s:property value="idinfraccion" /></td> --%>
	</tr>
	<s:set var="i" value="#i+1" />
</s:iterator>
</table>
<%-- <input type="text" value='<s:property value="cadIds" />' /> --%>
</form>
</body>