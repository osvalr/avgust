<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page pageEncoding="UTF-8"%>

<div   class="rounded"   id="numeroficha"  >
		   <div class="rounded divnum" >
		     <h1 class="hnum"><span><small> 
		     <s:property value="fichaturismo.codigoficha" />
		     </small></span> </h1>
		   </div>
			
</div>
		<br>
<br>
<form method="post" id="formficha"> 
	
	<input type="hidden" id="hdfichaturismo"   name="fichaturismo.idfichaturismo" value="${fichaturismo.idfichaturismo}"   />
	
	<div id="fichahead">   
              <img   src="turismo/getImagenLogo" width="211" />
		</div>  
	 

	<div style="text-align: center;">
		   <h2 > FICHA TURISMO <br/>
		   </h2> 
		  </div>
		  
	
	<p><strong>Fecha de Ingreso:</strong> 
		<span>
		
			<s:date format="dd-MM-yyyy" name="fichaturismo.fechaingreso" />
	
   </span></p>
	
	
	
	
	
	

	   <br/>
	   <strong>DATOS GENERALES</strong>
	   <table  id="tdatosgenficha"  >
         <tbody>
        <tr>
        <td>ESTADO FICHA</td>
        <td> 
        <span style="text-transform:uppercase">${fichaturismo.estadoficha.nombretipo}</span>
        </td>
        </tr> 
             <tr >
            <td  class="csupleft" >AREA NATURAL</td>
            <td class="csupright"><s:property value="areanatural.categoriaanp.siglascategoriaanp" />-<s:property value="areanatural.desareanatural" /> </td>
              </tr>
<tr>
<td >RUTA TURISMO</td>
<td>${fichaturismo.rutaturismo.nombrerutaturismo} </td>
</tr>

<tr>
<td >AGENCIA DE VIAJE</td>
<td >${fichaturismo.empresaturismo.nombrepersonajuridica }</td>
</tr>

<tr>
<td>OPERADOR TURISTICO</td>
<td class="ccenterleft">${fichaturismo.operadorturismo.nombrepersonajuridica } </td>
</tr>

	<tr>
	  <td>TIPO TURISMO</td> 
	   <td class="ccenterleft">
	    <s:iterator   status="stat" value="fichaturismo.listaTipoturismoFichaturismo"> 
		<span style="text-transform:uppercase;font-size:12px">
		   <s:if test="%{!#stat.last}">
		    <s:property value="tipoturismo.nombretipoturismo" />
		    ,
		   </s:if>
			<s:else>
			 <s:property value="tipoturismo.nombretipoturismo" />
			</s:else>
			
		</span>
       </s:iterator>
	   </td>
	</tr>	




	<tr>
	  <td>ACTIVIDADES TURISTICAS</td> 
	   <td class="ccenterleft">
	    <s:iterator   status="stat" value="fichaturismo.listaActividadturismo"> 
		<span style="text-transform:uppercase;font-size:12px">
		   <s:if test="%{!#stat.last}">
		    <s:property value="nombreactividadturismo" />
		    ,
		   </s:if>
			<s:else>
			 <s:property value="nombreactividadturismo" />
			</s:else>
			
		</span>
       </s:iterator>
	   </td>
	</tr>	





	<tr>
	  <td>GUIA(S)</td> 
	   <td class="ccenterleft">
	    <s:iterator   status="stat" value="fichaturismo.listaGuiaFichaturismo"> 
		<span style="text-transform:uppercase;font-size:12px">
		    
	<span style="text-transform:uppercase;font-size:12px">
		<s:property value="guia.apepat" />
		<s:property value="guia.apemat" />,
		<s:property value="guia.nombre" />
	</span> 
	<br>
  			
		</span>
       </s:iterator>
	   </td>
	</tr>	

<tr>
<td >FECHA TENTATIVA DE INGRESO</td>
<td >  <span class="fpropuesta"><s:date format="dd-MM-yyyy" name="fichaturismo.fechapropuesta" /></span> </td>
</tr>




</tbody>

</table>
	
		
	<br>
	<strong>HISTORIAL</strong>
		<table id="tabhistficha">
	<thead>
	<tr>
	<th>Tipo Evento</th>
	<th>Fecha/Hora </th>
	<th>Usuario </th>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="fichaturismo.listaHistorialaccion">
	   <tr>
	   <td style="text-align: left;"> ${tipoaccionficha.nombretipo}</td>
	   <td> <s:date format="dd-MM-yyyy hh:mm a" name="fecha" /></td>
	   <td> ${usuario.username} </td>
	   </tr>
	</s:iterator>
	</tbody>
	</table>
	
	
	
	
	
	<br>
	
	
	
	
	
	
	<!-- VISITANTES -->
	
	<s:if  test="%{fichaturismo.estadoficha.codigointtipo == constantes.CODIGO_ESTADO_FICHA_CONSOLIDADO}">
	
	
	<strong>INGRESO TURISTAS</strong>
	
	<div  id="divmontototalficha" class="divmontoficha">
	     <span class="lbl">TOTAL A PAGAR</span>
	     <span class="total"></span>
	     <br style="clear: both;">
	 </div> 
	
	<br>
	
	
	
	<div id="visitantes"> 
	
	<!-- BOLETAJE NORMAL -->
	   <div  id="divtotalnormalficha" class="divmontoficha">
	     <span class="lbl">SUB TOTAL A PAGAR</span>
	     <span class="total"></span>
	     <input class="htotal" type="hidden"  /> 
	     <br style="clear: both;">
	   </div> 
	     <a href="#"  class="linkToggleDiv" param="divBoletajeNormalFicha" style="float: right;"  >
	        Mostrar Detalle
	     </a>
	   	
	    <div id="divBoletajeNormalFicha" style="display: none;">
	             <br>
	    
	    <s:set var="codintestadoficha" value="fichaturismo.estadoficha.codigointtipo" />	
		<s:set var="i" value="0" />				
		<s:set var="k" value="1" />		
		<s:iterator value="fichaturismo.listaBoletajeParam"  status="rows">
			
			     
				<table   id="tboleto<s:property value="#k" />"  class="tboleto"  >
				<col class="c1"/>
				<col class="c2"/>
				<col class="c3"/>
				<col class="c4"/>
				<col class="c5"/>
				<col class="c6"/>
			    <col class="c8"/>
			      
				<thead>
					<tr >
						<th   >N°</th> 
						<th   >APELLIDOS Y NOMBRES</th> 
						<th  >DOCUMENTO</th>
						<th  >FEC. NAC.</th> 
						<th  >PAIS</th> 
						<th  >GENERO</th>
					    <th  class="checkboxes num" > 
					      <label for="checkall" style="color: black;" >ASISTIO</label>
					    </th>
					      
						
					    
					</tr>
				</thead>   
				<tbody>
				
				   	<s:set name="total" value="0"/>
					<s:set var="num" value="1" />
					<s:set name="totalboletaje" value="0"/>
					
					<s:iterator value="listaVisitante" status="rows1"> 
					  
					   
						<tr  class="rowtab" 
						<s:if test="%{flagvisitante==1}">
						  style="background-color:#E7EBED"
						</s:if>
						
						>
							<td  > ${num}</td>
							<td  class="cleft" >
							    ${apepat} ${apemat},${nombre}
							</td> 
							<td  class="cleft">
								<s:if test="%{tipodocumento.idtipo!=0}">
								  ${tipodocumento.abrevtipo} Nro.
								  <s:if test="%{numerodocumento!=0}"  >
								    ${numerodocumento}
								  </s:if>
								  
								</s:if>
								<s:else>
								 ------------
								</s:else>
								
								
								
								   <s:if test="%{flagvisitante==1}">
								  <s:set name="totalboletaje" value="%{#totalboletaje+boletaje.valorboletaje}"/>
								</s:if>
								
								
							</td>
							<td >
							     <s:date format="dd-MM-yyyy" name="fechanacimiento" />
								
							</td>
							<td >${pais.nompais}</td>
							<td >${sexo.abrevtipo}</td>
							
							
							
							
							
							  <td class="num" >
							       <s:if test="%{flagvisitante == 1}"> 
										SI
									</s:if>
									<s:else>
										NO
									</s:else>  
									</td>
							
							
							
						</tr>
						<s:set var="num" value="#num+1" /> 
						<s:set var="i" value="#i+1" />
					</s:iterator>
					<tr class="total">
					    <td style="border-right-style: hidden;">
					    </td>
					    
					    <td style="border-right-style: hidden;text-align: left;">
					    <input  class="precio" type="hidden" value="${valorboletaje}" />
					    <s:if test="%{valorboletaje!=null}">
					        <strong style="font-size:12px">PRECIO UNITARIO:S/.
					        <s:text name="formato.numero.dosdecimal"><s:param value="valorboletaje"/></s:text>
					         </strong>
					    </s:if>
					      <s:else>
					       <strong style="font-size:12px">PRECIO UNITARIO:S/.0.00</strong>
					      </s:else>
					    </td>
					    <td style="border-right-style: hidden;text-align: left;">
					      <s:if test="%{valorboletaje!=null}">
					        <strong style="font-size:12px"> SERIE:<s:property value="serieboletaje" /></strong>					      
					      </s:if>
					      <s:else>
					      	<strong style="font-size:12px"> SERIE:</strong>
					      </s:else>
					      
					    </td>
					    
					    <td 
					  
					    colspan="4"
					   
					    class="num" style="text-align: right;"
					    >
					     
					  
					     <input  class="hsubtotal" type="hidden" value='<s:property value="#totalboletaje" />' />
					    <strong style="font-size:12px" >SUB TOTAL:  S/. 
					      <span class="subtotal" >
					       <s:text name="formato.numero.dosdecimal"><s:param value="#totalboletaje"/></s:text>
					      </span>
				     
					   
					      
					    </strong>
					     
						
						
						</td>
						
						
					</tr>
					
					<s:set name="total" value="%{#total+#totalboletaje}"/> 
					</tbody>
				</table>
					
					<br/>
				
					<s:set var="k" value="#k+1" /> 
		   </s:iterator>	
	    </div>	
	    	
	 	
	</div>
	
	
	<br>
	
	
	
	<!-- ADICIONAL -->
	<div  id="divtotaladicionalficha" class="divmontoficha">
	     <span class="lbl">SUB TOTAL A PAGAR ADICIONAL</span>
	     <span class="total">S/.  
	     <s:text name="formato.numero.dosdecimal"><s:param value="fichaturismo.montoboletajeadicional"/></s:text>
	    </span>
	     <input class="htotal" type="hidden" value="${fichaturismo.montoboletajeadicional}" /> 
	     <br style="clear: both;">
	</div> 
	<a href="#"  class="linkToggleDiv" param="divBoletajeAdicionalFicha" style="float: right;"  >
	        Mostrar Detalle
	</a>
	<br>
	<div id="divBoletajeAdicionalFicha" class="divsubmontoficha" style="display: none;">
	    <input  class="precio"  type="hidden" value="${boletaje.valorboletaje}" />
	    <span class="c1">PRECIO UNITARIO: S/.
	    <s:text name="formato.numero.dosdecimal"><s:param value="boletaje.valorboletaje"/></s:text></span>
	    <span class="c2" >SERIE: ${boletaje.serieboletaje}</span>
	    <span class="c3">CANTIDAD:  
	   
	    ${fichaturismo.fichaturismoboletaje.cantidad}
	    </span>
	    <span class="c4 total" >SUB TOTAL:S/.  
	    <s:text name="formato.numero.dosdecimal"><s:param value="fichaturismo.montoboletajeadicional"/></s:text>
	    </span>
	    
	</div>
	
	<br>
	
	<!-- PAGOS -->
	<div  id="divpagototalficha"  class="divmontoficha">
	     <span class="cleft">PAGOS REALIZADOS</span>
	     <span class="cright total">S/. 
	       <s:text name="formato.numero.dosdecimal"><s:param value="fichaturismo.montopagado"/></s:text>
	      </span>
	     <br style="clear: both;">
	</div> 
	<a href="#"  class="linkToggleDiv" param="divPagosFicha" style="float: right;"  >
	        Mostrar Detalle
	</a>
	<br>
	<div id="divPagosFicha"  style="display: none;width: 60%">
	   
	   
	<!-- FICHA CONSOLIDADA -->

	
	<s:set var="num" value="1" />
	<s:set var="totpag" value="0" />
	 <table id="tfcpagos">
	 <colgroup >
   <col class="c1" />
   <col class="c2" />
   <col class="c3" />
   <col class="c4" />
   
    </colgroup>
	   <thead>
	   <tr>
	   <th>N°</th>
	   <th>Modalidad Pago</th>
	   <th>N°Voucher/Recibo</th>
	   <th>Monto</th>
	   </tr>
	   </thead>
	   <tbody>
	      <s:iterator value="fichaturismo.listaPagoFichaturismo" >
	       <tr class="rowtab">
	        <td class="num">${num}</td>
	        <td>${modalidadpago.nombretipo}</td>
	        <td>${numvoucher}</td>
	         <td style="text-align: right;"> S/. 
	         <s:text name="formato.numero.dosdecimal"><s:param value="monto"/></s:text>
	         </td>
	       </tr>
	       <s:set var="num" value="#num+1" />  
	       <s:set var="totpag" value="%{#totpag+monto}" />
	      </s:iterator>
	      <tr>
	      <td></td>
	      <td colspan="2" style="border-left-width: 0px;border-right-width: 0px;text-align:left;"> <span class="pietot">TOTAL PAGADO</span> </td>
	      <td style="text-align: right;">  <span style="font-size:14px;font-weight:bold">S/. 
	      <s:text name="formato.numero.dosdecimal"><s:param value="totpag"/></s:text></span></td>
	      </tr>
	     
	      
	   </tbody>
	 </table>
	
	
	
	
	   
	</div>
	
	

	
	</s:if>
	<s:elseif test="%{fichaturismo.estadoficha.codigointtipo == constantes.CODIGO_ESTADO_FICHA_GENERADO}">
	  <div style="text-align: center;">
	    LA FICHA AUN NO HA SIDO CONSOLIDADA
	  </div>
	  
	  
	</s:elseif>
	
	
	<br style="clear:both"/>
	
	
	

	<br>
	
	
	
	
	
	

	
	
	
	
	
	
</form>




















