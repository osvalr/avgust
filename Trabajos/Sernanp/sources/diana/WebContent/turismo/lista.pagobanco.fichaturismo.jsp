<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  

<s:if test="%{listaPagobanco.size() > 0}">
	   
	   

	     
		<div id="divlinkpaginacionlistapagobanco" class="divlinkpaginacion" style="clear: both;">
		<span class="totalresults">
				${pager.total} registros encontrado(s).
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
						N&uacute;mero Voucher
					</th>
					<th>
						Fecha de pago
					</th>
					<th>
						Importe(S/.)
					</th>
					<th>
						Saldo(S/.)
					</th>
					
				</tr>
			</thead>
			<tbody>
			<s:set var="i" value="0" /> 
				<s:iterator value="listaPagobanco" status="rows">
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
					<td >${cadcodigoficha}</td>
					<td >${cadnumerovoucher}</td>
					<td><s:date format="dd-MM-yyyy" name="fechamovimiento" />  </td>
					<td >${importe}</td>
					<td >${saldo}</td>
					
				</tr>
				<s:set var="i" value="#i+1" />
				</s:iterator>
			</tbody>
		</table>
			
	</div>
	    
	    
	
	   
	  
	
	
	
	

</s:if>
<s:else>
	<p>
		<strong> No se encontraron registros...</strong> 
	</p>
</s:else>