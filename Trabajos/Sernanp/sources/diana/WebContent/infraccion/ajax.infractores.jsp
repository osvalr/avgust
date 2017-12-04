<%@page pageEncoding="UTF-8"%>  

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<span id="paginationexpinfractor" style="display:inline-block;width:600px" class="paginationinf">
	<span class="totalresults">
		${paginacion.total} recursos(s) encontrados.
	</span>
<%-- 			<input type="text" value='total / ${paginacion.total}' /><input type="text" value='pagina / ${paginacion.pagina}' /> --%>

<s:if test="%{paginacion.itemsxpag > 0}">

	<s:if test="%{paginacion.pagina>1}">
		<a href="#" name='1'  >&lt;&lt;Primera</a>
		<a href="#" name='${paginacion.pagina-1}'  >&lt;Anterior</a>
	</s:if>
	<s:iterator status="ind" value="(paginacion.ultima).{#this}">
		<s:if test="%{ #ind.count >= paginacion.inicio}">
			<a <s:if test="%{#ind.count==paginacion.pagina}">class="active"</s:if>
			   href="#" name='<s:property value="#ind.count"/>' >
			   <s:property value="#ind.count"/>
		    </a>
		</s:if>
	</s:iterator>
	<s:if test="%{paginacion.totalpaginas>paginacion.pagina}">
		<a href="#" name='${paginacion.pagina+1}'  >Siguiente&gt;</a>
		<a href="#" name='${paginacion.totalpaginas}'  >Última&gt;&gt;</a>
	</s:if>
	
</s:if>
	
</span>
		
<s:set var="i" value="1"/>
<form id="FormInfractores">
    <input type="hidden" value="${paginacion.pagina}" id="PaginaActual" />
	<input id="IdExpediente" value="" type="hidden"/>
	<table class="tablaListinf">
	<thead>
	<tr>
		<td style="width:100px;">N&deg; Exp.</td>
		<td style="width:250px;">Nombre y Apellidos / R.S.</td>
		<td style="width:60px;">DNI/CE/ PSP/RUC</td>
		<td style="width:210px;">Infraccion</td>	
		<td style="width:50px;">Repite</td>	
		<td style="width:100px;">N&deg;&nbsp;Resoluci&oacute;n</td>
		<td style="width:80px;">Fecha</td>
		<td style="width:130px;">Sancion (Monto / Días)</td>
<!-- 		<td style="width:50px;">Pagos</td> -->
		<td style="width:50px;" align="center">Moroso?</td>
<!-- 		<td style="width:70px;" align="center">Opciones</td> -->
		<td align="center">Opciones</td>
		<td></td>
		<td></td>
	</tr>
	</thead>
	<tbody>

	<s:iterator value="listaExpedientes">
		<tr>
			<td style="width:100px;"><s:property value='anpxExpedientexano.codAnpxExpedientexAno' /></td>
			<td style="width:250px;">		
				<s:if test='%{infractor.tipodocumento.idtipo != 0}' >
					<s:property value='infractor.apepat' /> 
					<s:property value='infractor.apemat' /> 
					<s:property value='infractor.nombre' />
				</s:if>
				<s:else>
					<s:property value='infractor.empresa' />
				</s:else>		
			</td>
			<td style="width:60px;">
				<s:if test='%{infractor.tipodocumento.idtipo != 0}' >
					<s:property value='infractor.numerodocumento' />
				</s:if>
				<s:else>
					<s:property value='infractor.ruc' />
				</s:else>
			</td>
			<td colspan="2" >
				<table style="width:260px;">			
					<s:iterator value="listaExpedienteInfraccion">
					<tr>
						<td style="width:210px;">
						    <s:property value='infraccion.descripcioninfraccion'/>
						</td>
						
				        <!-- Esta es la columna de REINCIDENCIA JCEV 04-10-2012 -->
						<td style="width:50px;text-align: center;">
							<s:if test="%{infraccion.reincidencia > 1}">
								<s:text name="msgReinc">Si(<s:property value='infraccion.reincidencia'/>)</s:text>
							</s:if>
							<s:else>
								<s:text name="msgReinc">No(1)</s:text>
							</s:else>
					    </td>						
					</tr>
					</s:iterator>
				</table>
			</td>
			<td style="width:80px;text-align: center;">
			  <s:property value='resolucion.numeroresolucion' /> 			  
			</td>
			<td style="width:80px;">
			  <s:property value='resolucion.fecharesolucion'/>
			</td>
			<td>
				<s:set var="idexp" value="" />		
				<table style="width:130px;">
					<s:iterator value="ListaExpedienteSancion">					
					<tr>
						<td style="width:150px;text-align: left;">
							<s:property value='sancion.descripcionsancion'/>
							<s:if test="%{detalleExpedienteSancion.datoVariado != ''}">(<s:property value='detalleExpedienteSancion.datoVariado'/>)</s:if>
							<s:if test="%{sancion.idsancion == 1}">
								<s:set var="idexp" value="%{idexpediente}" />							
							</s:if>
							
						</td>
<!-- 						<td style="width:200px;text-align: center;"> -->
<%-- 							<s:property value='detalleExpedienteSancion.datoVariado'/> --%>
<!-- 						</td> -->
<!-- 						<td style="width:50px;"> -->
<%-- 							<s:if test="%{sancion.descripcionsancion == 'Multa'}"> --%>
<!-- 								<td> -->
<%-- 								    <div onclick="javascript:updatePagos('<s:property value="idexpediente"/>');" > --%>
<!-- 							             <img align="right" src="img/page_edit.png" title="Confirmación de Pago"/> -->
<!-- 							        </div> -->
<!-- 								</td> -->
<%-- 							</s:if> --%>
<!-- 						</td> -->
					</tr>
					</s:iterator>
				</table>
			</td>
			
			<!-- JCEV 04-10-2012 Morosos  -->
			<td style="text-align: center;">
			<s:if test="%{#idexp > 0 && flagestadopago > 0}">
				<s:text name="p">Pag&oacute;</s:text>
			</s:if>
			<s:else>
				<s:property value='morosidad'/>
			</s:else>
			
				
<%-- 				<s:set name="mor" value="%{morosidad}"/> --%>
			</td>

			<!-- JCEV 18-10-2012 Estado : Activo (0) / Inactivo (1) / Eliminado (2) -->
			<td style="text-align: center;" >
<%-- 			<s:property value="#idexp"/>  --%>			
			
			<s:if test="%{#request.NDOC != NULL}">
			
				<s:if test="%{#idexp > 0 && flagestadopago == 0 }">
			
					<div style="cursor: pointer;padding-left: 5px;" onclick="javascript:updatePagos('<s:property value="#idexp"/>',0);" >
					      <img align="middle" src="img/option_3.png" title="Confirmación de Pago" />
					</div>
				
				</s:if>
				
<%-- 				<div style="float: right;cursor: pointer;padding-right: 5px;" onclick="javascript:updateEstado('<s:property value="idexpediente"/>', 0);" > --%>
<!-- 			      <img align="middle" src="img/option_1.png" title="Procesar" /> -->
<!-- 				</div> -->
				
			</s:if>
			<s:else>
			
				<s:if test="%{#idexp > 0 && flagestadopago == 0 }">
				
					<div style="cursor: pointer;padding-left: 5px;" onclick="javascript:updatePagos('<s:property value="#idexp"/>',1);" >
					      <img align="middle" src="img/option_3.png" title="Confirmación de Pago" />
					</div>
				
				</s:if>
				
<%-- 				<div style="float: right;cursor: pointer;padding-right: 5px;" onclick="javascript:updateEstado('<s:property value="idexpediente"/>', 1);" > --%>
<!-- 			      <img align="middle" src="img/option_1.png" title="Procesar" /> -->
<!-- 				</div> -->
							
			</s:else>
			
			</td>
			
			<td style="text-align: center;">
					<s:a action="descargaArchivoExpediente" includeParams="none">
						<s:param name="idarchivo" value="resolucion.archivo.idarchivo"></s:param>
						<img alt="" src="img/pdf.png" title="Descarga Resoluc&oacute;n">
					</s:a>
			</td>
			
			<td style="text-align: center;">
				<s:if test="%{#idexp > 0 && flagestadopago > 0}">
					<s:a action="descargaArchivoExpediente" includeParams="none">
						<s:param name="idarchivo" value="archivo.idarchivo"></s:param>
						<img alt="" src="img/icon_vouch.png" title="Voucher de Pago">
					</s:a>
				</s:if>
				<s:else>
					<img alt="" src="img/nofound.png" title="No existe archivo!!!">
				</s:else>
			</td>
			
		</tr>
		<s:set var="i" value="#i+1" />
	</s:iterator>
	</tbody>
	</table>
</form>
