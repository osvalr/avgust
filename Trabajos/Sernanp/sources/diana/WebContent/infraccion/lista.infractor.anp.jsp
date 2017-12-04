<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

<h1>LISTADO DE INFRACTORES</h1><hr>

<%-- <div class="clear"></div>
<div class="l">
<fieldset>
<legend style="display: block;">Categoria ANP</legend>
<s:select list="listacategoriaanp" 
		  listKey="idcategoriaanp" 
		  listValue="descategoriaanp" 
		  name="categoriaanp.idcategoriaanp" 
		  theme="simple" 
		  headerKey="" 
		  value=""  
		  headerValue="[---Seleccione----]"  
		  onchange="javascript:actualizarInfractoresxAnp(0);"
		  />
</fieldset>
</div>

<div class="l">
<fieldset>
<legend style="display: block;">Area Natural</legend>
<s:select list="listaareanatural" listKey="idareanatural" listValue="desareanatural" name="areanatural.idareanatural" theme="simple" headerKey="" value=""  headerValue="[---Seleccione----]"  />
</fieldset>
</div>

<div class="clear"></div> --%>

<div id="DivRecargarInfractores">

<!-- <div id="DivRecargarInfractores" style="min-height: 100px; min-width: 500px;"> -->

<jsp:include page="ajax.infractores.anp.jsp" />

</div>

</body>
</html>