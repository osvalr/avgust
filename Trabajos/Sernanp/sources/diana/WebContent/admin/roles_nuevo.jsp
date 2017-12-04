<%@taglib prefix="s" uri="/struts-tags" %> 
<html>
<body>
<form action="<%=request.getContextPath() %>/admin/RolesInsertar.action" method="post">
Nombre de Rol: <input type="text" name="rolNombre"><br/>
Descripción: <input type="text" name="descripcion"><br/>
<input type="submit" value="Insertar"/>
</form>
</body>
</html>