<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  




<s:if test="%{listaOperadorturismo.size() > 0}">
	   <div id="divlinkpaginacionlistaoperador" class="divlinkpaginacion" style="clear: both;">
	 <span class="totalresults">
				${pager.total} operador(es) encontrado(s).
	</span>  
 <s:if test="%{pager.totalpaginas >1}">
		
			<s:if test="%{pager.pagina>3}">
				<a  href="#"    name='1'  >
					&lt;&lt;Prim.
				</a>
				<a  href="#"    name='${pager.pagina-1}'  >
					&lt; Ant.
				</a>
			</s:if>
			<s:iterator status="ind" value="(pager.ultima).{#this}">
				<s:if test="%{ #ind.count >= pager.inicio}">
					<a  
						<s:if test="%{#ind.count==pager.pagina}">
							class="active" 
						</s:if>
						href="#" name='<s:property value="#ind.count"/>' >
						 <s:property value="#ind.count"/></a>
				</s:if>
			</s:iterator>  
			<s:if test="%{pager.totalpaginas>pager.pagina}">
				<a  href="#"    name='${pager.pagina+1}'  > 
					Sig. &gt;
				</a>
				<a  href="#"    name='${pager.totalpaginas}'  >  
					Fin. &gt;&gt;
				</a>
			</s:if>
		
</s:if>
	     </div>
	
	<form method="post" id="formListaOperadorTurismo">
		<table  id="tabListaOperador" class="ttur ttur12" style="width:75% ">
			<thead>
				<tr>
				  <s:if test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL}">
				   <th>#</th>
					</s:if>
					<th>Nombre/Raz&oacute;n Social</th>
					<th>Usuario</th>
					
					<th>RUC</th>
					<th>Correo</th>
					<th>Tel&eacute;fono</th>
					
				</tr>
			</thead>
			<tbody>
			<s:set var="i" value="0" /> 
				<s:iterator value="listaOperadorturismo" status="rows">
				<tr  class='rowtab
           <s:if test="%{#i%2==0}" >
           odd
           </s:if>
           <s:else>
           even
           </s:else>
           ' 
               > 
					<s:if test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL}">
					<td>
					  <input name="listaCodigo" class="chkbox" type="checkbox" value="${idoperadorturismo}" />
					  </td>
					</s:if>
					<td class="colleft">
					${nombrepersonajuridica}
					</td>
					<td class="colleft">
					 ${usuario.username}	  
					</td>
					
					<td class="colleft">
						${ruc}  
					</td>
					<td class="colleft">
						${correoinstitucional}
					</td>
					<td class="colleft">
						${telefono}
					</td>
					
				</tr>
				<s:set var="i" value="#i+1" />
				</s:iterator>
			</tbody>
		</table>
		</form>	
	
	    
	    
	
	   
	  
	
	
	
	

</s:if>
<s:else>
	<p>
		<strong> No se encontraron operadores...</strong> 
	</p>
</s:else>