<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  


<s:if test="{listaPagobanco.size()>0}">

 <table id="tpagosopetur"  class="ttur">
	 	   <thead>
	   <tr>
	   <th>#</th>
	   <th>Voucher</th>
	   <th>Monto</th>
	   </tr>
	   </thead>
	   <tbody>
	      <s:iterator value="listaPagobanco" >
	        <tr class="rowtab">
	        <td>
	            <a href="#"  name='${idpagobanco}' class="linkSelPagoBanco"  >    
	                             Seleccionar
	            </a>
	        </td>
	        <td>
	        <span class="numvoucher">
	          ${cadnumerovoucher}
	        </span>
	        </td>
	        <td>
	          <span class="saldo">
	          ${saldo}
	        </span>
	          
	        </td>
	        </tr>
	      </s:iterator>
	      
	      </tbody>
</table>

</s:if>
<s:else>
  No se encontraron pagos con saldo para este operador....
</s:else>
