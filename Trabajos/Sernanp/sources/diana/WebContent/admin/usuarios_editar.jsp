<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<body> 
<form action="<%=request.getContextPath() %>/admin/UsuariosActualizar.action" method="post">
<input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
IdUsuario: ${usuario.idUsuario} <br/>
Clave: <input type="password" name="clave" value="${usuario.clave }"><br/>
Nombres: <input type="text" name="nombres" value="${usuario.nombres }"><br/>
Paterno: <input type="text" name="paterno" value="${usuario.paterno }"><br/>
Materno: <input type="text" name="materno" value="${usuario.materno }"><br/>
Correo: <input type="text" name="correo" value="${usuario.correo}"><br/>
Dirección: <input type="text" name="direccion" value="${usuario.direccion}"><br/>
Teléfono: <input type="text" name="telefono" value="${usuario.telefono }"><br/>
<input type="hidden" name="estado" value="${usuario.estado }"/>
<input type="submit" value="Actualizar"/>
</form>

<table border="1" cellpadding="3" cellspacing="0">
			<tr>
				<th width="100">Rol</th>
				<th width="250">Descripcion</th>
			</tr>
						
			<c:forEach items="${usuario.rolesUsuarios}" var="r">
			<tr>
	   			<td><c:out value="${r.rolNombre}"/></td>
	   			<td><c:out value="${r.descripcion}"/></td>
			</tr>
   			</c:forEach>			
		</table>

</body>
</html>