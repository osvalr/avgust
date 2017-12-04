<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  
<s:if test="%{listaFichaturismo.size() > 0}">
	   
	   

	       <s:if test="%{pager.totalpaginas >1}">
		<div id="divlinkpaginacionlistapago" class="divlinkpaginacion" style="clear: both;">
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
		</div>
	</s:if>
	
	<div id="items">
		<table  class="ttur ttur12">
			<thead>
				<tr>
					<th>
						#
					</th>
					<th>
						Codigo de ficha
					</th>
					<th>
						Fecha de registro
					</th>
					<th>
						Fecha de pago
					</th>
					<th>
						Ruta Turismo
					</th>
					<!--  
					<th>
						Tipo Turismo
					</th>
					-->
				</tr>
			</thead>
			<tbody>
			<s:set var="i" value="0" /> 
				<s:iterator value="listaFichaturismo" status="rows">
				<tr      
				class='
				 <s:if test="%{#i%2==0}" >
                 odd
                 </s:if>
                 <s:else>
                  even
                  </s:else>
			    '	>
					<td>
						<s:property value="#rows.count" />
					</td>
					<td   param="<s:property value="idfichaturismo" />" >
					
					
					<s:property value="codigoficha" /></td>
					<td>
						<s:date format="dd-MM-yyyy" name="fecharegistro" />  
					</td>
					<td>
						<s:date format="dd-MM-yyyy" name="pagoBanco.fechamovimiento" />  
					</td>
					<td>
						<s:property value="rutaturismo.nombrerutaturismo"/>
					</td>
					
				</tr>
				<s:set var="i" value="#i+1" />
				</s:iterator>
			</tbody>
		</table>
			
	</div>
	    
	    
	
	   
	  
	
	
	
	

</s:if>
<s:else>
	<p>
		<strong> No se encontraron fichas...</strong> 
	</p>
</s:else>