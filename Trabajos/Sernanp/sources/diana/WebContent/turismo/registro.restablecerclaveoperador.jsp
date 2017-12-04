<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@page  contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%> 



<form method="post" id="formRegRestablecerClaveOperador">
<input type="hidden"   name="operadorturismo.usuario.idUsuario" value="${operadorturismo.usuario.idUsuario}" />
 <input type="hidden" name="operadorturismo.idoperadorturismo" value="${operadorturismo.idoperadorturismo}" />
 <input type="hidden"   name="operadorturismo.nombrepersonajuridica" value="${operadorturismo.nombrepersonajuridica}" />
 <input type="hidden"  name="operadorturismo.correopersonal"   value="${operadorturismo.correopersonal}" />
 <input type="hidden"  name="operadorturismo.usuario.username"   value="${operadorturismo.usuario.username}" />
 
 
 
 <div class="regtur">
 
  <label>Operador:</label>
 <span style="width:200px">
   ${operadorturismo.nombrepersonajuridica}
 </span>
  <label>Usuario:</label>
 <span>
   ${operadorturismo.usuario.username}
 </span>
 
 <label>Correo Clave env&iacute;o:</label>
 <span>
   ${operadorturismo.correopersonal}
 </span>
 </div>
 
 

<br style="clear: both;"/>
<div style="text-align: center;">
 <input   id="btnRestablecerClaveOperador" type="button"  value="Restablecer Clave" style="cursor: pointer;"/>
</div>

</form>


		  								 								
									
									