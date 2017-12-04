<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
	
	<input type="hidden" id="hdfichaturismo" value='<s:property value="fichaturismo.idfichaturismo"/>'  >
	
	<div id="fichahead">   
              <img   src="turismo/getImagenLogo" width="211" />
		</div>  
	 
		

	<div style="text-align: center;">
		   <h2 > FICHA TURISMO <br/>
		   </h2> 
		  </div>
	<p><strong>Fecha de Ingreso:</strong> 
		<span>
		<s:if test="%{fichaturismo.flagfichaturismo == 0}">  
			<input value="" size="10" id="inFechaIngreso" name="fichaturismo.fingreso" 
				type="text" class="dateDMY datepicker dom valid fingreso"  readonly="readonly" />
		</s:if> 
		<s:else>
			<s:date format="dd-MM-yyyy" name="fichaturismo.fechaingreso" /> 
		</s:else>
		</span></p>
	
	   <table  border="1" class="display tdatosficha"  id="tboleto">
         <tbody>
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
	
	<div id="visitantes"> 
	
	<!-- total a pagar -->
	<div class="rounded"  id="divctotalboleto" >
		<table class="display ttotalboleto">
		  <tbody>
		     <tr class="total">
		        <td ><strong>TOTAL A PAGAR</strong></td> 
				<td class="num"><strong>S/.${fichaturismo.montototal}</strong> </td>
		     </tr>
		  </tbody>
		</table>
		</div>
	    	
	    	
	    <br>	
				
		 <s:set var="i" value="0" />		
				
		<s:set var="k" value="1" />		
				
		<s:iterator value="fichaturismo.listaBoletajeParam"  status="rows">
			
			    <span style="float:right">
			    Seleccionar
			    <input  class="checktodosboleto" name='<s:property value="#k" />'  id='checktodosboleto<s:property value="#k" />'  type="checkbox" />
			    </span>
			     
				<table id="tboleto" border="1"  class="display" >
				
				<thead>
					<tr >
						<th  style="width: 20px;text-align: center;">N°</th> 
						<th  style="width: 250px;text-align: center;">APELLIDOS Y NOMBRES</th> 
						<th style="text-align: center;" >DOCUMENTO</th>
						<th  style="width:90px;text-align: center;">FEC. NAC.</th> 
						<th style="text-align: center;">PAIS</th> 
						<th  style="width:60px;text-align: center;">GENERO</th>
						<th  style="width:60px;text-align: center;">EDITAR</th>   
					    <th   class="checkboxes num" style="width:60px"> 
						<label for="checkall" style="color: black;" >ASISTIO</label>
						
					   </th>  
					</tr>
				</thead>   
				<tbody>
				
				<s:if test="%{fichaturismo.flagfichaturismo == 0}">
				
					<s:set name="total" value="0"/>
					<s:set var="num" value="1" />
					
					 <s:set name="totalboletaje" value="0"/>
					<s:iterator value="listaVisitante" status="rows1"> 
					  
					   
						<tr    >
							<td style="width: 15px" ><s:property value="#num" /></td>
							<td  style="width: 250px; text-transform: uppercase;" ><s:property value="apepat" /> 
								<s:property value="apemat" />, 
								<s:property value="nombre" />
							</td> 
							<td style="text-align: center;">
								<s:if test="%{tipodocumento.idtipo!=0}">
								  <s:property value="tipodocumento.abrevtipo" /> Nro.
								  <s:if test="%{numerodocumento!=0}"  >
								    <s:property value="numerodocumento" />
								  </s:if>
								  
								</s:if>
								<s:else>
								 ------------
								</s:else>
								
								
								
								<s:set name="totalboletaje" value="%{#totalboletaje+boletaje.valorboletaje}"/>
							</td>
							<td style="text-align: center;">
							     <s:date format="dd-MM-yyyy" name="fechanacimiento" />
								
							</td>
							<td style="text-align: center;">
								<s:property value="pais.nompais" /> 
							</td>
							<td style="text-align: center;"><s:property value="sexo.abrevtipo" /></td>
							
							<td style="text-align: center;">
							   <div  id='visitante_<s:property value="idvisitante"/>' style="display: none;" >
							    <span class='idvisitante'> <s:property value="idvisitante" /></span>
							   	<span class='apepat'> <s:property value="apepat" /></span>
							   	<span class='apemat'> <s:property value="apemat" /></span>
							   	<span class='nombre'> <s:property value="nombre" /></span>
							   	<span class='fnac'> <s:date format="dd-MM-yyyy" name="fechanacimiento" /></span>
							   	<span class='idsexo'> <s:property value="sexo.idtipo" /></span>
							   	<span class='idpais'> <s:property value="pais.idpais" /></span>
							   	<input  type="hidden"  class="idtipodoc"  value='${tipodocumento.idtipo}' />
<!--							   	<span class='idtipodoc'> <s:property value="tipodocumento.idtipo" /></span>-->
							   	<span class='numdoc'> 
							   	 <s:if test="%{numerodocumento!=0}"  >
								    <s:property value="numerodocumento" />
								  </s:if>
								</span>
								<input type="hidden"  class="grupoedad" value="${grupoedad.codigointtipo}"   />
							   	<span class='idboletaje'> <s:property value="boletaje.idboletaje" /></span>
							   </div>
							   <a href="#"  name='<s:property value="idvisitante"/>' class="linkRegVis"  >    
	                             <img   src="img/page_edit.png" title="Editar"  />
	                           </a>
							</td>
							<td class="num" style="text-align: center;">   
									<input type="hidden" name="visitantes[<s:property value="#i"/>].idvisitante" 
										value="<s:property value="idvisitante"/>" /> 
								<input  class='checktodosboleto<s:property value="#k" />'  type="checkbox" name="visitantes[<s:property value="#i"/>].flagvisitante"
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
					    
					    <td style="border-right-style: hidden;">
					    
					    <s:if test="%{valorboletaje!=null}">
					        <strong style="font-size:12px">PRECIO UNITARIO:S/.<s:property value="valorboletaje" /></strong>
					    </s:if>
					      <s:else>
					       <strong style="font-size:12px">PRECIO UNITARIO:S/.0.0</strong>
					      </s:else>
					    </td>
					    <td style="border-right-style: hidden;">
					      <s:if test="%{valorboletaje!=null}">
					        <strong style="font-size:12px"> SERIE:<s:property value="serieboletaje" /></strong>					      
					      </s:if>
					      <s:else>
					      	<strong style="font-size:12px"> SERIE:</strong>
					      </s:else>
					      
					    </td>
					    
					    <td colspan="5"  class="num">
					   
						<strong style="font-size:12px">SUB TOTAL:  S/. <s:property value="#totalboletaje" /></strong>
					    </td>
						
						
					</tr>
					
					<s:set name="total" value="%{#total+#totalboletaje}"/>
					
					
					
					
				   </s:if>
				    <s:else>
				    
				    
				        
				    <s:set name="total" value="0"/>
					<s:set var="num" value="1" />
					
					<s:iterator value="listaVisitante" status="rows1"> 
					   <s:set name="totalboletaje" value="0"/>
					   
						<tr    >
							<td ><s:property value="#num" /></td>
							<td style="text-transform: capitalize;"><s:property value="apepat" /> 
								<s:property value="apemat" />, 
								<s:property value="nombre" />
							</td> 
							<td>
								<s:if test="%{tipodocumento.idtipo!=0}">
								  <s:property value="tipodocumento.abrevtipo" /> Nro.
								  <s:property value="numerodocumento" />
								</s:if>
								<s:else>
								 ------------
								</s:else>
								
								
								
								<s:set name="totalboletaje" value="%{#totalboletaje+boletaje.valorboletaje}"/>
							</td>
							<td>
							     <s:date format="dd-MM-yyyy" name="fechanacimiento" />
								
							</td>
							<td style="text-align: center;">
								<s:property value="pais.nompais" /> 
							</td>
							<td style="text-align: center;"><s:property value="sexo.abrevtipo" /></td>
							
							
							<td class="num">   
									<s:if test="%{flagvisitante == 1}"> 
										Si
									</s:if>
									<s:else>
										No
									</s:else>  
							</td>
							
							
						</tr>
						<s:set var="num" value="#num+1" /> 
						
					</s:iterator>
					<tr class="total">
					    <td>
					    </td>
					    <td>
					    
					    <s:if test="%{valorboletaje!=null}">
					        <strong>PRECIO UNITARIO:<s:property value="valorboletaje" /></strong>
					    </s:if>
					      <s:else>
					       <strong>NO APLICA</strong>
					      </s:else>
					    </td>
					    <td>
					      <s:if test="%{valorboletaje!=null}">
					        <strong> SERIE:<s:property value="serieboletaje" /></strong>
					      </s:if>
					      
					    </td>
					    
					    <td colspan="5" class="num">
					   
						<strong>SUB TOTAL:  S/. <s:property value="#totalboletaje" /></strong>
					    </td>
						
						
					</tr>
					
					<s:set name="total" value="%{#total+#totalboletaje}"/>
					
				        
				    
				       
					
					</s:else>
					
					
					</tbody>
				</table>
					
					<br/>
				
					<s:set var="k" value="#k+1" /> 
		   </s:iterator>		
		
	
	
		
		
		
		
		
	
	</div>
	
	
	
	
	
	
	<div>
		<s:if test="%{fichaturismo.flagfichaturismo == 0}"> 
		
		   <s:if test="%{fichaturismo.estadopagobanco.codigointtipo==1}">
		        
		     <input type="hidden" name="fichaturismo.idfichaturismo" 
				value="<s:property value="fichaturismo.idfichaturismo"/>">
			<input type="hidden" name="fichaturismo.flagfichaturismo" value="1">
			<input type="submit" value="Consolidar Ficha" class="submit " id="saveFicha" />
			<strong class="updating h"><span class="i loading"></span>Consolidando Ficha...</strong>   
		    
		        
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
		   
		   
			
		</s:if>
		<s:else>
			<strong>
			Esta Ficha ya se encuentra consolidada.
			</strong>
		</s:else>
	</div>
	
	
	
	
	
	
</form>
















