<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax" %>

<style type="text/css" media="all">
      @import url("css/displaytag/screen.css");
</style>



<jsp:scriptlet>
     org.displaytag.decorator.TotalTableDecorator totals = new org.displaytag.decorator.TotalTableDecorator();
     totals.setTotalLabel("TOTAL");
     totals.setSubtotalLabel("Sub total");
     
     pageContext.setAttribute("totals", totals);
     
  </jsp:scriptlet>

<div id="tablaresultados">
	<display:table  name="${listaRutasTurismo}" id="resultados"
				                style="width:100%" class="simple grouped-table" cellspacing="0" 
				                decorator="totals" pagesize="15" 
				                requestURI="turismo/detalleBoletaje.action"  >
				                
<display:column title="N&deg;" ><c:out value="${resultados_rowNum}"/></display:column>
        <%-- <display:column property="nIdBoletaje"       title="Boletaje"  sortable="false"        
                        format="{0, number, ###0}"   style="text-align: right;"/> --%>
        <display:column property="strNombreBoletaje" title="Descripci&oacute;n"     sortable="false" group="2" />
        <display:column property="nSerieBoletaje"    title="Serie"           sortable="false" group="1"/>
        <display:column property="dbValorBoletaje"   title="Valor(S/.)"           sortable="false"  
           				format="{0, number, #,##0.00}" headerClass="r" class="r" total="true" />
	</display:table>
</div>