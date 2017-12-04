<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>   
<!-- Content -->



<s:if test="%{fichaturismo.idfichaturismo!=0}">
  
<!--  <div id="mydiv" style="border: 1px solid">-->
<!--  xdxvcvv-->
<!--  </div>-->
  
	<div   >		
		<div  id="numeroficha"  >
		   <div class="divnum"  >
		     <h1 class="hnum" ><span><small> 
		     <s:property value="fichaturismo.codigoficha" />
		     </small></span> </h1>
		   </div>
		</div>
		
		
		
		<div id="fichahead">
             <img   src="turismo/getImagenLogo" width="211"  />		
    	</div>  
		  
	     <div style="text-align: center;">
		   <h2 > FICHA TURISMO<br/>
		   </h2> 
		  </div>	
		 
<br>
		<s:include value="/turismo/datageneral.fichaturismo.jsp" />
		   
		    
		<!-- total a pagar -->
		<div id="divctotalboleto" >
		 <table class="display ttotalboleto"  >
		  <tbody>
		     <tr class="total">
		        <td ><strong>TOTAL A PAGAR</strong></td> 
				<td class="num"><strong>S/.${fichaturismo.montototal}</strong> </td>
		     </tr>
		  </tbody>
		</table>
		</div>
		
		
	   <div >  
				
				
		<s:iterator value="fichaturismo.listaBoletajeParam"  status="rows">
			
			
			  
				<table    class="tboleto"  >
				<col class="c1"/>
				<col class="c2"/>
				<col class="c3"/>
				<col class="c4"/>
				<col class="c5"/>
				<col class="c6"/>
				<thead>
					<tr  >
						<th  > N° </th> 
						<th  >APELLIDOS Y NOMBRES</th> 
						<th  >DOCUMENTO</th>
						<th  >FEC. NAC.</th> 
						<th  >PAIS</th> 
						<th >GENERO</th>  
					</tr>
				</thead>   
				<tbody>
					<s:set name="total" value="0"/>
					<s:set var="num" value="1" />
					
					
					 <s:set name="totalboletaje" value="0"/>
					<s:iterator value="listaVisitante" status="rows1"> 
					  
					   
						<tr>
							<td  > ${num}</td>
							<td class="cleft">${apepat} ${apemat},${nombre} 
							</td> 
							<td >
								<s:if test="%{tipodocumento.idtipo!=0}">
								  ${tipodocumento.abrevtipo} Nro.
								  ${numerodocumento}  
								</s:if>
								<s:else>
								 ------------
								</s:else>
								
								
								
								<s:set name="totalboletaje" value="%{#totalboletaje+boletaje.valorboletaje}"/>
							</td>
							<td >
							     <s:date format="dd-MM-yyyy" name="fechanacimiento" />
								
							</td>
							<td > ${pais.nompais} 
							</td>
							<td >${sexo.abrevtipo}</td>
							
						</tr>
						<s:set var="num" value="#num+1" /> 
					</s:iterator>
					<tr class="total" >
					    <td style="border-right-style: hidden;" >
					    </td>
					    <td  style="border-right-style: hidden;text-align: left;">
					    
					    <s:if test="%{valorboletaje!=null}">
					        <strong style="font-size:12px;">PRECIO UNITARIO: S/.<s:property value="valorboletaje" /></strong>
					    </s:if>
					      <s:else>
					       <strong style="font-size:12px;">PRECIO UNITARIO: S/.0.0</strong>
					      </s:else>
					    </td>
					    <td  style="border-right-style: hidden;text-align: left;">
					      <s:if test="%{valorboletaje!=null}">
					        <strong style="font-size:12px;"> SERIE:<s:property value="serieboletaje" /></strong>
					      </s:if>
					      <s:else>
					      	<strong style="font-size:12px;"> SERIE:</strong>
					      </s:else>
					      
					    </td>
					    
					    <td colspan="3" class="num" style="text-align: right;" >
					   
						<strong style="font-size:12px;">SUB TOTAL:  S/. <s:property value="#totalboletaje" /></strong>
					    </td>
						
						
					</tr>
					
					<s:set name="total" value="%{#total+#totalboletaje}"/>
					</tbody>
				</table>
				
					<br>
					
		   </s:iterator>		
				
				
				
		</div> 
	</div>
	

	
</s:if>
<s:else>
	<div>
		No se encuentra el número de ficha solicitada:
<!--		<s:a href="registrar.action"> ir al Registro de Turistas</s:a> -->
	</div>
</s:else>
 
<div id="json" class="h"> 
	${json} 
</div>

<input type="hidden" id="idfichaturismo" value='<s:property value="fichaturismo.idfichaturismo" />' />

<!-- End Content -->
