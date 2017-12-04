<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@page pageEncoding="UTF-8"%>   
<!-- Content -->


<form id="formDetallePagoFichaturismo"    method="post">

<s:if test="%{fichaturismo.idfichaturismo==0}">
<span style="text-transform:uppercase">
No se ha registrado la ficha con ese codigo
</span>
</s:if>
<s:else>
   
   
    <s:if test="%{fichaturismo.flagfichaturismo==1}">
       Esta ficha ya se encuentra consolidada
     </s:if>
     <s:else>
        
  <div class="divregfichatur">
    <label>Estado:</label>
     <span class="msgestadopago"
     <s:if test="%{fichaturismo.estadopagobanco.codigointtipo==1}">
       style="color:green"
      </s:if>
     <s:elseif test="%{fichaturismo.estadopagobanco.codigointtipo==2}">
      style="color:red"
       </s:elseif>
      > ${fichaturismo.estadopagobanco.mensajetipo}</span>
  
    <label>C&oacute;digo Ficha:</label>
    <span> ${fichaturismo.codigoficha}</span>

    <label>Monto Ficha a pagar:</label>
    <span>  S/.
      <s:text name="formato.numero.dosdecimal">
              <s:param name="value" value="fichaturismo.montototal"/>
      </s:text>
    </span>
  
 <s:if test="%{fichaturismo.estadopagobanco.codigointtipo!=0}">
  <label>Monto Ficha cancelado:</label>
  <span>  S/.
      <s:text name="formato.numero.dosdecimal">
              <s:param name="value" value="fichaturismo.pagoBanco.importe"/>
      </s:text>
    </span>
 <label>Fecha Pago:</label>
 <span>   <s:date format="dd-MM-yyyy" name="fichaturismo.pagoBanco.fechamovimiento" /> </span>
 
 </s:if>
<br style="clear: both;"/>
</div>
        
     
     </s:else>
   
    
   
</s:else>
 

</form>

