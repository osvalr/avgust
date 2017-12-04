<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>  
<s:if test="%{fichas.size() > 0}">
	
	<div class="divlinkpaginacion pagination" style="clear: both;">
	
	
	
	
	
	<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP}">
	  <input type="button"  name="5"   value="Consolidar" class="btntur10 opcionaccionfichatur" style="float: left;margin-left: 5px" />
	</s:if>
	
	
	<span class="totalresults">
				${pager.total} ficha(s) encontrada(s).
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
	
	
	<form method="post" id="formListadoFichaTurismo"  >
		<table  id="tabListaFicha" 
		<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP
					   || #session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL  }">
		   style="width: 100%"
		</s:if>
		<s:elseif  test="%{#session.idtiporol==constantes.TIPO_ROL_OPERADOR_TURISMO }">
		   style="width: 70%"
		</s:elseif>
		
		 class="ttur ttur11">
			<thead>
				<tr>
				    <s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP}">
					<th>
						#
					</th>
					</s:if>
					<th>
						C&oacute;digo de ficha
					</th>

					<th>
						Fecha de visita
					</th>
					<th>
						Ruta Turismo
					</th>
					<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP
				      || #session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL }">
					<th>
					 Operador
					</th>
					
					</s:if>
					
					<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP
					   || #session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL  }">
					<th >
					Estado
					</th>
					</s:if>
					
					<th>
					 
					  <s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP
					   || #session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL  }">
					      F. INICIAL
					  </s:if>
					  <s:elseif  test="%{#session.idtiporol==constantes.TIPO_ROL_OPERADOR_TURISMO}">
					    VER
					  </s:elseif>
						
					</th>
					
					<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP
					   || #session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL  }">
					    <th>
					    F. CONS
					    </th>
					</s:if>
		
				</tr>
			</thead>
			<tbody>
				
				
			
				 
				  <s:set var="i" value="0" />
				  <s:iterator value="fichas" status="rows">
				    
				   
				 
				 <tr      
				class='rowtab
				 <s:if test="%{#i%2==0}" >
                  odd
                 </s:if>
                 <s:else>
                  even
                  </s:else>
			    '	>
			    
					
					<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP}">
					<td>
					   <s:if test="%{!codigoficha.equals('') && estadoficha.codigointtipo==constantes.CODIGO_ESTADO_FICHA_GENERADO}">
					     <!-- SOLO SE PUEDEN CONSOLIDAR EN GRUPO LOS QUE PRESENTEN PAGOCALC+ADIC=PAGADO-->
					     <s:if test="%{montopagado>=(montocalculadopagar+montoboletajeadicional)}"  >
					       
					       <input name="listaCodigo"  
					        class="chkbox" type="checkbox" value="${idfichaturismo}" />
<!--					       <input name="listaFichaturismosel[<s:property value="#i" />].fpropuesta"  -->
<!--					         type="hidden" value="${fpropuesta}" />-->
					      </s:if>
					   </s:if>
					
					</td>
					</s:if>

					<td>
                      <a   param="<s:property value="idfichaturismo" />" 
					class="linkAccesoFicha link" name="1">     
					<s:if test="%{!codigoficha.equals('')}">    
					   ${codigoficha}
					</s:if>
					<s:else>
					   C&oacute;digo Pendiente
					</s:else>
					 </a>
					</td>
					

					
					<td>
						<s:date format="dd-MM-yyyy" name="fechapropuesta" />  
					</td>
					<td class="colleft">
						<s:property value="rutaturismo.nombrerutaturismo"/>
					</td>
					
					
					<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP
					 || #session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL }">
					
					<td  class="colleft">
						${operadorturismo.nombrepersonajuridica}
					</td>
					
					
					</s:if>
					
					<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP
					   || #session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL  }">
					<td>
					   ${estadoficha.nombretipo}
					</td>
					</s:if>
					
					<td    >
					
					
					
	                    
	                <s:if test="%{!codigoficha.equals('')}">
					  <a href="#"  param="<s:property value="idfichaturismo" />" 
					  	class="linkAccesoFicha link" name="1" style="margin-right:10px" >
					     <img   src="img/page_go.png" title="Ver"  /> 
					  </a >
					  <a href="#"   param="<s:property value="idfichaturismo" />" 
					  	class="linkAccesoFicha link"  name="2" >
					   <img   src="img/pdf.png" title="Descargar"  />
					   </a>
					</s:if>
					<s:else>
					 <a href="#"   param="<s:property value="idfichaturismo" />" 
					  	class="linkAccesoFicha link"  >
					  <img   src="img/page_edit.png" title="Editar"  />
					  </a>
					</s:else>
	                             
	                
					
					</td>
					
					<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP
					 || #session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_CENTRAL }">
					
					
					<td  param="<s:property value="idfichaturismo" />"  class="linkAccesoFichaConsolidada"
					 >
					    
					    <s:if test="%{estadoficha.codigointtipo>=constantes.CODIGO_ESTADO_FICHA_GENERADO}">
					    
					    <a href="#"     >
					    <img   src="img/page_go.png" title="Ver"  /> 
					    </a>
					    
					    </s:if>
					</td>
					
					</s:if>

					
					  
				</tr>
				<s:set var="i" value="#i+1" />
				
				
				</s:iterator>
				
				
				
			
				
				
				
				
			</tbody>
		</table>
	</form>		
	</div>

</s:if>
<s:else>
	<p>
		<strong> No se encontraron fichas...</strong> 
	</p>
</s:else>