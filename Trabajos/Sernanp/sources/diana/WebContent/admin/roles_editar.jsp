<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<body> 
<form action="<%=request.getContextPath() %>/admin/RolesActualizar.action" method="post">
Nombre de Rol: <input type="text" name="rolNombre" value="${rol.rolNombre }" readonly="readonly"><br/>
Descripcion: <input type="text" name="descripcion" value="${rol.descripcion }"><br/>
<input type="submit" value="Actualizar"/>
</form>
</body>
</html>