<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Content -->
	
	<div id="welcome">
		<div class="r l user">
			<div>
				Bienvenido: 
				<span class="upperlbl12">
				${USUARIO_ACTUAL.apepat } ${USUARIO_ACTUAL.apemat }, ${USUARIO_ACTUAL.nombre }
				</span>
			</div>
			<div>
				<img alt="Usuario" src="img/user.jpg" width="100" /> 
			</div>
		
<br><br><br><br><br><br><br><br><br><br>
				
		</div>
		<div class="panel l">
			<div>
				 
			</div>
			
			
			<div class="shortcuts">
		
				<s:iterator value="#session.listaMenuActual">
				<div class="l">
					<a class="r linkopcionmodulo"  >
					    <param  id="paramidmodulo" value="${idmodulo}" />    
						<param  id="paramhrefmodulo" value="${hrefmodulo}" />
						<img  alt="Registro" src="img/icons/<s:property value="imgmodulo"/> " />
						<s:property value="nombremodulo"/>
					</a>
					
					<s:if test="%{#session.USUARIO_ACTUAL.rol.mapModuloTipoRol.get(idmodulo)==99}">
					<br />					
					<s:date var="anioactual" format="yyyy" name="#session.fechaActual" />
					<select name="periodo" id="periodo">									
					<c:forEach var="i" begin="2010" end="${anioactual + 1}" step="1">					
					<option value="${i}" <c:if test="${i ==  anioactual}"><c:out value="selected" /></c:if> ><c:out value="${i}" /></option>
					</c:forEach>
																								
					</select>
					</s:if>
					</div>
				</s:iterator>
				
				<input type="hidden" name="seccadena" id="seccadena" value="<s:property value="#session.USUARIO_ACTUAL.username"/>^<s:property value="#session.USUARIO_ACTUAL.clave"/>" />
				
				
			</div>
			 
		</div>
	</div>
		
<!-- End Content -->

	