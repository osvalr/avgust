<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<body> 
<form action="<%=request.getContextPath() %>/admin/CategoriasInsertar.action" method="post">
Nombre: <input type="text" name="nombre"><br/>
Descripci�n: <input type="text" name="descripcion"><br/>
<input type="submit" value="Insertar"/>
</form>
</body>
</html>