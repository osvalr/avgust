<%@page import="java.util.*,proyecto.vo.Usuario" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<form action="<%=request.getContextPath() %>/admin/UsuariosMantener.action" method="post">
	Nombre: <input type="text" name="nombres"/>
	<input type="submit" value="Buscar"/>
	<input type="button" value="Nuevo" onclick="document.location='<%=request.getContextPath() %>/admin/UsuariosNuevo.action'"/>
    <input type="button" value="Regresar" onclick="document.location='<%=request.getContextPath() %>/Portada.action'"/>	
</form>

<table border="1">
<%
if (null != request.getAttribute("usuarios")){
	Collection<Usuario> c2= (ArrayList<Usuario>)request.getAttribute("usuarios");
	for(Usuario vo : c2){ 
		out.println("<tr><td>"+vo.getIdUsuario()+"</td><td>"+vo.getNombre()+"</td><td>"+vo.getApepat()+"</td><td><a href='"+request.getContextPath()+"/admin/UsuariosEditar.action?idUsuario="+vo.getIdUsuario()+"'>Editar</a> - <a href='"+request.getContextPath()+"/admin/UsuariosEliminar.action?idUsuario="+vo.getIdUsuario()+"'>Eliminar</a></td></tr>");
	}
}
%>
</table>
</body>
</html>