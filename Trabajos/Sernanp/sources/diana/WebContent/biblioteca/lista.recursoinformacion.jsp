<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@page pageEncoding="UTF-8"%>

 <s:if  test="%{listaRecursoInformacion.size()==0}" >
         <label style="color: red;"> No se encontraron resultados
         </label>
       </s:if>
<s:else>


	













<div  id="divPagProy" class=""> 	
		<span style="display:inline-block;width:370px;text-align:left;">
				<span id="exportar">
					<span>
						Exportar a:   
					</span> 
					<a  href="#"  class="linkExpRecInf"  name="1" >
				       <img   class="imgExpExcel"  src="<%=request.getContextPath()%>/img/excel.gif" title="Exportar Excel"   />
						MS Excel
				   	</a>
				   	<a  href="#"  class="linkExpRecInf"   name="2">
				       <img   class="imgExpPdf"  src="<%=request.getContextPath()%>/img/pdf.gif" title="Exportar Pdf"   />
				   		PDF
				   	</a>
			   	</span>
		</span>  
		<span style="display:inline-block;width:600px" class="pagination">
			<span class="totalresults">
				${paginacion.total} recursos(s) encontrados.
			</span>
			<s:if test="%{paginacion.pagina>3}">
				<a  href="#"    name='1'  >
					&lt;&lt;Primera
				</a>
				<a  href="#"    name='${paginacion.pagina-1}'  >
					&lt;Anterior
				</a>
			</s:if>
			<s:iterator status="ind" value="(paginacion.ultima).{#this}">
				<s:if test="%{ #ind.count >= paginacion.inicio}">
					<a  
						<s:if test="%{#ind.count==paginacion.pagina}">
							class="active" 
						</s:if>
						href="#" name='<s:property value="#ind.count"/>' >
						 <s:property value="#ind.count"/></a>
				</s:if>
			</s:iterator>
			<s:if test="%{paginacion.total>paginacion.pagina}">
				<a  href="#"    name='${paginacion.pagina+1}'  >
					Siguiente&gt;
				</a>
				<a  href="#"    name='${paginacion.totalpaginas}'  >
					Última&gt;&gt;
				</a>
			</s:if>
		</span>
	</div>
	
	
	<div style="text-align: right;">
	<select id="cboAccionRecInf" >
	<option value="0" selected>Seleccione</option>
	<option value="1" >Eliminar</option>
	</select>
	<input id="checkTodos"  type="checkbox" />
	</div>
	
<table  cellpadding='0' cellspacing='1' class="tablaList"
	style="margin-left:2px " >
	
	<thead>
		<tr>
		<th style="width: 20px;text-align: center;">
			Detalle
		</th>
		<th style="width: 20px;text-align: center;">
			C&oacute;digo
		</th>
		<th style="width: 800px;text-align: center;">
			Nombre
		</th>
		<th style="width: 20px;text-align: center;">
			Medio
		</th>
		<th style="width: 20px;text-align: center;">
			Tipo
		</th>
		
		<th style="width: 10px;text-align: center;">
			Documento
		</th>
		
		<th style="width: 10px;text-align: center;">
			Editar
		</th>
		<th style="width: 10px;text-align: center;">
			
		</th>
		
		</tr>
	</thead>
		<tbody>
		      
		        <s:iterator  value="listaRecursoInformacion"  status="list">
		            
		            
		                   
		                <tr class="row <s:if test="#list.odd == true ">odd</s:if>">
		                <td>
		                  <a  href="#"  class="linkRecInf"  name='<s:property value="idrecursoinformacion"/>' >
		                    
		                    <img   class="imgProy" width="25"  src="img/folder.png" title="Mostrar Detalle"   />
		                     
		                    </a>
		                </td>
		                 <td style="width: 20px; "   >
		                    <s:property value="codigorecursoinformacion"/>
		                    
		                </td>
		                <td style="width: 800px; ">
		                    <s:property value="titulo"/>
		                    
		                </td>
		                 <td  class="rowlistbiblio" style="width: 20px;text-transform: uppercase;font-size: 9px">
		                    
		                    <s:property value="mediorecursoinformacion.nombretipo"/>
		                    
		                </td>
		                 <td   class="rowlistbiblio" style="width: 20px;text-transform: uppercase;font-size: 9px ">
		                    <s:property value="tiporecursoinformacion.nombretipo"/>
		                    
		                </td>               
		                         
		                <td style="width:9px;text-align: center;"> 
		                    <s:if test="%{listaRecursoInformacionArchivo[0].archivo.idarchivo!=0}">
		                   <a  href="#"  class="linkmostrararchivo"  param='<s:property  value="%{listaRecursoInformacionArchivo[0].archivo.idarchivo}" />'  >
		                    
		                    <img   class="imgProy imgmostrararchivo"  src="img/pdf.gif" title="Mostrar"   />
		                     
		                    </a>
		                    </s:if>
		                	                   
		                </td>
		                
		                <td style="width:9px;text-align: center;"> 
		               
		                <a href="#"  name='<s:property value="idrecursoinformacion"/>' class="linkRegRecInf"  >
	                         <img   src="img/page_edit.png" title="Editar"  />
	                    </a>
	                   
		                </td>
		                
		                
		                
		                <td style="width:9px;text-align: center;"> 
		               
		                <input type="checkbox"  name="listaCodigos"  value='<s:property value="idrecursoinformacion"/>' class="checkRecInf" />
	                   
		                </td>
		               
		               
		            </tr>  
		          
		        </s:iterator>
		</tbody>
	</table>




<s:hidden name="temporal" id="temporalRecInf" >  </s:hidden>


 </s:else>








