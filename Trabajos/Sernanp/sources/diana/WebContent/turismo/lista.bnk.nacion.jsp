<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<%-- <fmt:setLocale value="en_US"/> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%-- <%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax" %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css" media="all">
      @import url("css/displaytag/screen.css");
</style>



<h1>Consulta de Pagos por Turismo</h1> 
<br />	
	
	
  	<form id="FormConsultaBnkNacion" method="post" action="turismo/listNationBnk.action" >
		<fieldset>						
			<div class="campo">							
				<!-- Version Coyla 31-07-2012 -->
				<label for="strCodCateg">Categoria</label>
				<s:select theme="simple" name="categoriaanp.codcategoriaanp" id="IdCateg" 
				          list="listaCategoriaAnp" listKey="codcategoriaanp"
				          listValue="descategoriaanp" headerKey=""
				          headerValue="[--Seleccione--]" value="categoriaanp.codcategoriaanp" 
				          onchange="showNaturalArea(this.value);" cssClass="select valid" />
			</div>			
			<div class="campo">
		        <label for="IdArea">Area Natural</label>
		        <div id="IdArea">
			      <s:if test="%{categoriaanp.codcategoriaanp != null}">
				      <s:select theme="simple" name="areanatural.codareanatural" id="IdArea" 
	          list="listaAreasNaturales" listKey="codareanatural"
	          listValue="desareanatural" headerKey=""
	          headerValue="[--Seleccione--]" value="areanatural.codareanatural"
	          onchange="showTurismRoad(this.value);" cssClass="select valid" /> 	                    
	          </s:if>
	          <s:else>
	          	<select><option>[--Seleccione--]</option></select>
	          </s:else>          
		    </div> 		        
			</div>
			<div class="campo">
		        <label for="IdRuta">Ruta Turismo</label>
		        <div id="IdRuta">		           
			        <s:if test="%{areanatural.codareanatural != null}">
				       <s:select theme="simple" name="rutaturismo.codrutaturismo" id="IdRuta" 
			                  list="listaRutasTurismo"  listKey="codrutaturismo"
					          listValue="nombrerutaturismo" headerKey="" 
			                  headerValue="[--Todos--]" value="rutaturismo.codrutaturismo"  />
			        		<!-- cssClass="select valid" -->
			        </s:if>
			        <s:else>
		          	<select><option>[--Seleccione--]</option></select>
		          </s:else>
		        </div>
			</div>			
		</fieldset>
		<div class="clear"></div>
		
		<fieldset>
			<div class="campo">
				<label>Fecha Desde</label>
				<s:textfield theme="simple" name="turismopagos.strFecIni" id="fechaIni" label="Fecha de Inicio"
				             size="9" cssClass="dateDMY_ input valid datepicker" 
				             onclick="esFechaValida(this);" value="%{turismopagos.strFecIni}" readonly="true" />
				             
			</div>
			<div class="campo">
				<label>Fecha Hasta</label>
				<s:textfield theme="simple" name="turismopagos.strFecFin" label="Fecha de Termino"
				             id="fechaFin" size="9" cssClass="dateDMY_ input valid datepicker"  
				             onclick="esFechaValida(this);" value="%{turismopagos.strFecFin}" readonly="true" />
				
			</div>
			
		</fieldset>
		
		<div class="campo2">
				<input type="button" class="submit" value="Consultar" id="btnEnviarConsulta" />
		</div>
		
		<div class="clear"></div>


<jsp:scriptlet>
     org.displaytag.decorator.TotalTableDecorator totals = new org.displaytag.decorator.TotalTableDecorator();
     totals.setTotalLabel("TOTAL");
     totals.setSubtotalLabel("Sub total");
     
     pageContext.setAttribute("totals", totals);
     
  </jsp:scriptlet>
		
		<div class="divDTag">
		
				
		<!-- Usando DisplayTag -->		
		<!-- <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="content" valign="top"> -->
				
					<%-- <display:table name="listaTurismoPagos" id="row"   
					               export="false"  style="width:100%" requestURI="turismo/listNationBnk.action"  
					               class="dataTable" cellspacing="0" 
					               decorator="org.displaytag.decorator.TotalTableDecorator" pagesize="15" > --%>
					               					
			<display:table name="listaTurismoPagos" id="row" style="width:100%"  class="simple grouped-table" decorator="totals" >
			
						<!-- Columnas a Mostrar -->
 			            <display:column property="strRegistroTurista"  title="ID"	            
                                        class="hidden" headerClass="hidden" media="html" />
                                        			             
 				 		<display:column title="N°" class="rowNumber" value="${row_rowNum}" headerClass="rowNumber" style="text-align: center;"/> 
			            <display:column property="strCodTPago"    title="Cod. Tributo"  sortable="false"
			                            class="rowNumber" format="{0, number, ###0}" group="4" />
			                            
			            <%-- <display:column property="strCodCateg"    title="Categoria"     sortable="false" group="4" /> 
			            <display:column property="strCodAreaNat"  title="Area Natural." sortable="false" group="3" /> 
			            <display:column property="strRutaTurimo"  title="Ruta Turismo"  sortable="false" group="2" /> 
			            <display:column property="dFecRegTur"     title="Fec.RegBnk"    sortable="false" group="1" 
 			            				class="hidden" headerClass="hidden" />  --%>
 			            
 			            <display:column property="strCodCateg"    title="Categoria"     sortable="false" group="3" /> 
			            <display:column property="strCodAreaNat"  title="Area Natural." sortable="false" group="2" />			             
			            <display:column property="strRutaTurimo"  title="Ruta Turismo"  sortable="false" group="1" />
			                        			            
			            <display:column property="dFechaPago"     title="Fecha Pago"    sortable="false" 
 			            				class="orderDate" headerClass="orderDate"  format="{0,date,dd-MM-yyyy}" />
			            
			            <display:column property="dbImpPag" title="Monto (S/.)" sortable="false"
							            format="{0, number, ##,##0.00}" headerClass="r" class="r" total="true"  />
						
																								
		            </display:table>
				<!-- </td>
			</tr>
		</table> -->
		</div>
	</form>
	<div id="divModalDetalleBoletaje" style="display: none;"></div>	