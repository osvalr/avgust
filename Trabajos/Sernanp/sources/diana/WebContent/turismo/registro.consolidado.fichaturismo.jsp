<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		
			 <input  size="10" id="inFechaIngreso" name="fichaturismo.fingreso" 
				value='${fichaturismo.fpropuesta}' type="text" class="dateDMY datepicker dom valid fingreso"  
			  />
			 
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
			
			     
			       <span style="float:right">
			       Seleccionar
			       <input  class="checktodosboleto" name='<s:property value="#k" />' 
			        id='checktodosboleto<s:property value="#k" />'  type="checkbox" />
			       </span>
			     
				<table   id="tboleto<s:property value="#k" />"  class="tboleto"  >
				<col class="c1"/>
				<col class="c2"/>
				<col class="c3"/>
				<col class="c4"/>
				<col class="c5"/>
				<col class="c6"/>
			    <col class="c7"/>    
			    <col class="c8"/>
			      
				<thead>
					<tr >
						<th   >N°</th> 
						<th   >APELLIDOS Y NOMBRES</th> 
						<th  >DOCUMENTO</th>
						<th  >FEC. NAC.</th> 
						<th  >PAIS</th> 
						<th  >GENERO</th>
					    <th  >EDITAR</th>  
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
					  
					   
						<tr  id='rowtab<s:property  value="idvisitante"/>'  class="rowtab" style="background-color:#E7EBED" >
							<td  > ${num}</td>
							<td  class="cleft" >
							  <span class="nombrecomp">
							     ${apepat} ${apemat},${nombre}
							  </span>
							   
							</td> 
							<td  class="cleft">
							 <span class="numdocumento">
								<s:if test="%{tipodocumento.idtipo!=0}">
								  ${tipodocumento.abrevtipo} Nro.
								  <s:if test="%{numerodocumento!=0}"  >
								    ${numerodocumento}
								  </s:if>
								  
								</s:if>
								<s:else>
								 ------------
								</s:else>
								</span>
								<s:set name="totalboletaje" value="%{#totalboletaje+boletaje.valorboletaje}"/>	
							</td>
							<td >
							   <span class="fnacimiento">
							     <s:date format="dd-MM-yyyy" name="fechanacimiento" />
							   </span>
							     
								
							</td>
							<td > <span class="nompais"> ${pais.nompais} </span></td>
							<td > <span class="genero"> ${sexo.abrevtipo} </span></td>
							
							
							
							<td >
							   <div  id='visitante_<s:property value="idvisitante"/>' style="display: none;" >
							    <span class='idvisitante'>${idvisitante}</span>
							   	<span class='apepat'>${apepat}</span>
							   	<span class='apemat'>${apemat}</span>
							   	<span class='nombre'>${nombre }</span>
							   	<span class='fnac'> <s:date format="dd-MM-yyyy" name="fechanacimiento" /></span>
							   	<span class='idsexo'>${sexo.idtipo}</span>
							   	<span class='idpais'>${pais.idpais}</span>
							   	<input  type="hidden"  class="idtipodoc"  value='${tipodocumento.idtipo}' />
							   	<span class='numdoc'> 
							   	 <s:if test="%{numerodocumento!=0}"  >
								    ${numerodocumento}
								  </s:if>
								</span>
								<input type="hidden"  class="grupoedad" value="${grupoedad.codigointtipo}"   />
							   	<span class='idboletaje'> <s:property value="boletaje.idboletaje" /></span>
							   </div>
							   <a href="#"  name='<s:property value="idvisitante"/>' class="linkRegVis"  >    
	                             <img   src="img/page_edit.png" title="Editar"  />
	                           </a>
							</td>
							
							
							
							
							<td class="num" >   
									<input type="hidden" name="listaVisitantesel[<s:property value="#i"/>].idvisitante" 
										value="<s:property value="idvisitante"/>" /> 
								<input  class='chkbox checktodosboleto<s:property value="#k" />'  checked="checked"  type="checkbox" name="listaVisitantesel[<s:property value="#i"/>].flagvisitante"
									value="1" 
									/>
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
					       <strong style="font-size:12px">PRECIO UNITARIO:S/.0.0</strong>
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
					    colspan="5" 
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
	    <input   class="cantidad" size="5" type="text" name="fichaturismo.fichaturismoboletaje.cantidad" />
	 	</span>
	    <span class="c4 total" >SUB TOTAL:S/. </span>
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
	   
	     <!-- FICHA GENERADA -->

	<span style="float:right">Agregar Pagos
	  <a  href="#"  id="linkAddPagoFichaTurismo" >
    <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Pagos"  />                     
    </a>
	</span>
	<br style="clear: both;">
	<table id="tfcpagos">
	<col class="c1" />
   <col class="c2" />
   <col class="c3" />
   <col class="c4" />
    <col class="c5" />
    
	   <thead>
	   <tr>
	   <th>N°</th>
	   <th>Modalidad Pago</th>
	   <th>N°Voucher/Recibo</th>
	   <th>Monto(S/.)</th>
	   </tr>
	   </thead>
	   <tbody>
	   
      <s:set var="i" value="0" />
	    
	      <s:iterator value="fichaturismo.listaPagoFichaturismo" >
	         <s:set var="n" value="#i+1" /> 
	       <tr id="rowtab<s:property value="#n" />"  class="rowtab">
	      
	        <td >  
	        <input class="idpagobanco" type="hidden"  />
	        <span class="num">
	        <s:property value="#n"/>
	        </span>
	        <input  class="idpagoft" type="hidden" 
	        name="fichaturismo.listaPagoFichaturismo[<s:property value="#i" />].idpagofichaturismo" 
           value="${idpagofichaturismo}"  />
	         </td>
	         
	        
	        <td>
           <s:if test="%{modalidadpago.codigointtipo==constantes.CODIGO_MODPAGOFICHA_BANCO_FICHA}">
              
              
              ${modalidadpago.nombretipo}
             
           </s:if>
           <s:else>
           
            
             <s:select  cssClass="select valid idmodalidadpagoft"
	           name="fichaturismo.listaPagoFichaturismo[%{#i}].modalidadpago.codigointtipo"
	           headerKey="" 
			   headerValue="[Seleccione]" 
			   list="listaModalidadpago"
			   listKey="codigointtipo"
			   listValue="nombretipo" 
			   theme="simple"  
			   />
			  
			   
			   
           </s:else>
           </td>
           
	        <td>
	         
	      <s:if test="%{modalidadpago.codigointtipo==constantes.CODIGO_MODPAGOFICHA_BANCO_FICHA}">
	           <input  class="numvoucher" type="text" size="15"  readonly="readonly"  
         name="fichaturismo.listaPagoFichaturismo[<s:property value="#i" />].numvoucher" 
           value="${numvoucher}"  /> 
         
	       </s:if> 
	        <s:else>
	          <input  class="numvoucher" type="text" size="15"    
         name="fichaturismo.listaPagoFichaturismo[<s:property value="#i" />].numvoucher" 
           value="${numvoucher}"  /> 
	        </s:else>
	        </td>
	         <td > 
	          <input  class="content valid monto" type="text" size="10" 
		 name="fichaturismo.listaPagoFichaturismo[<s:property value="#i" />].monto" 
          value="${monto}"
             />
              
	         </td>
	         
	       
	         <td>
	           <s:if test="%{{modalidadpago.codigointtipo==constantes.CODIGO_MODPAGOFICHA_BANCO_FICHA}">
             <span  class="i i_supr"  param="tfcpagos" title="eliminar" ></span> 
           </s:if> 
	         </td>
	       
	       </tr>
	    <s:set var="i" value="#i+1" />  
	      </s:iterator>
	   </tbody>
	 </table>

	 <input type="hidden" value='<s:property value="#n" />'  id="idultpagoft" />

	
	   
	   
	</div>
	
	
	<div>
	
	
	
	
	
	
	</div>
	
	

	
	
	
	
	<br style="clear:both"/>
	
	
	

	<br>
	<!-- CONSOLIDAR -->
	
	<span   class="msgmontopagadormenor msg"  ><s:property value="getText('msgmontopagadormenor')" /></span>
	<span   class="msgpasamontovoucher msg"  ><s:property value="getText('msgpasamontovoucher')" /></span>
	
	 <s:if test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP}">
	 
	  <s:if test="%{ (fichaturismo.idtiporolcreacion==constantes.TIPO_ROL_OPERADOR_TURISMO 
	         &&  fichaturismo.listaPagoFichaturismo.size()>0)
	    ||   fichaturismo.idtiporolcreacion==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP }">
	      <div style="text-align: center;">
					   <input style="margin: auto;" type="button"   value="Consolidar Ficha" class="submit" id="btnConsolidar" />
		  </div>
	  </s:if>
	 <s:else>
	 <div style="text-align:center">EL PAGO DE LA FICHA SE ENCUENTRA EN PROCESO</div>
	  
	</s:else>  
					 
					  
	</s:if>
	
	
	
	
	
	
	
	
	
	
</form>



<table id="tabContRowPagoft" style="display: none;">
<col class="c1" />
<col class="c2" />
<col class="c3" />
<col class="c4" />
<col class="c5" />
<tbody class="bodyContRowPagoft">  
<tr id="rowtab_n"  class="rowtab" >
<td >
<input class="idpagobanco"  name="fichaturismo.listaPagoFichaturismo[_i].pagobanco.idpagobanco" type="hidden"  />
<span class="num"></span></td>
<td>
 <input  class="idpagoft" type="hidden" name="fichaturismo.listaPagoFichaturismo[_i].idpagofichaturismo" />
<s:select  cssClass="select valid idmodalidadpagoft"
	           name="fichaturismo.listaPagoFichaturismo[_i].modalidadpago.codigointtipo"
	           headerKey="" 
			   headerValue="[Seleccione]" 
			   list="listaModalidadpago"
			   listKey="codigointtipo"
			   listValue="nombretipo" 
			   theme="simple" />
</td>
<td class="tdnumvouvher" >
  <input  class="numvoucher" type="text"  size="15" name="fichaturismo.listaPagoFichaturismo[_i].numvoucher" />
  <span class="spPagoBancoFicha"></span>
</td>
<td >
  	<input  class="content valid monto" type="text" size="10" name="fichaturismo.listaPagoFichaturismo[_i].monto" />   	 
</td>
<td>
<span  class="i i_supr" param="tfcpagos" title="eliminar" ></span>
</td>
</tr>
</tbody>
</table>












