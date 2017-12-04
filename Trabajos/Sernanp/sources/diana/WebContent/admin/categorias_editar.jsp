<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html> 
<body>
<form action="<%=request.getContextPath() %>/admin/CategoriasActualizar.action" method="post">
<input type="hidden" name="idCategoria" value="${categoria.idCategoria}">
IdCategoria: ${categoria.idCategoria} <br/>
Nombre: <input type="text" name="nombre" value="${categoria.nombre }"><br/>
Descripcion: <input type="text" name="descripcion" value="${categoria.descripcion }"><br/>
<input type="submit" value="Actualizar"/>
</form>

<br/>
<ul>
<c:forEach items="${categoria.productos}" var="x">
<li><c:out value="${x.nombre}"/></li>
</c:forEach>
</ul>
</body>
</html>