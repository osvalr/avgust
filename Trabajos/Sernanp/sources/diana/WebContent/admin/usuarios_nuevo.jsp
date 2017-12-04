<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<body> 
<form action="<%=request.getContextPath() %>/admin/UsuariosInsertar.action" method="post">
IdUsuario: <input type="text" name="idUsuario"> <br/>
Clave: <input type="password" name="clave"><br/>
Nombres: <input type="text" name="nombres"><br/>
Paterno: <input type="text" name="paterno"><br/>
Materno: <input type="text" name="materno"><br/>
Correo: <input type="text" name="correo"><br/>
Dirección: <input type="text" name="direccion"><br/>
Teléfono: <input type="text" name="telefono"><br/>
<input type="hidden" name="estado" value="1"/>
<input type="submit" value="Insertar"/>
</form>
</body>
</html>