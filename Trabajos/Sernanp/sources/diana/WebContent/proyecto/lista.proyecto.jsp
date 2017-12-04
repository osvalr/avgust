<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@page pageEncoding="UTF-8"%>

 <s:if  test="%{listaProyecto.size()==0}" >
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
					<a  href="#"  class="linkExpProy"  name="1" >
				       <img   class="imgExpExcel"  src="<%=request.getContextPath()%>/img/excel.gif" title="Exportar Excel"   />
						MS Excel
				   	</a>
				   	<a  href="#"  class="linkExpProy"   name="2">
				       <img   class="imgExpPdf"  src="<%=request.getContextPath()%>/img/pdf.gif" title="Exportar Pdf"   />
				   		PDF
				   	</a>
			   	</span>
		</span>  
		<span style="display:inline-block;width:600px" class="pagination">
			<span class="totalresults">
				${paginacion.totalProyectos} proyecto(s) encontrados.
			</span>
			<s:if test="%{paginacion.pagina>3}">
				<a  href="#"    name='1'  >
					&lt;&lt;Primera
				</a>
				<a  href="#"    name='${paginacion.pagina-1}'  >
					&lt;Anterior
				</a>
			</s:if>
			<s:iterator status="ind" value="(paginacion.final).{#this}">
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
				<a  href="#"    name='${paginacion.total}'  >
					Última&gt;&gt;
				</a>
			</s:if>
		</span>
	</div>
	
	<s:if test="#session.USUARIO_ACTUAL.rol.mapRolModulo.get('Proyectos')==1">
	<div style="text-align: right;">
	<select id="cboAccionProyecto" >
	<option value="0" selected>Seleccione</option>
	<option value="1" >Eliminar</option>
	</select>
	<input id="checkTodos"  type="checkbox" />
	</div>
	</s:if>
<table  cellpadding='0' cellspacing='1' class="tablaList"
	style="margin-left:2px " >
	
	<thead>
		<tr>
		<th style="width: 20px;text-align: center;">
			Detalle
		</th>
		<th style="width: 800px;text-align: center;">
			Nombre
		</th>
		<th style="width: 20px;text-align: center;">
			A&ntilde;o Inicio
		</th>
		<th style="width: 20px;text-align: center;">
			A&ntilde;o Fin
		</th>
		<th style="width: 20px;text-align: center;">
			Estado
		</th>
		<th style="width: 10px;text-align: center;">
			Documentos
		</th>
		<s:if test="#session.USUARIO_ACTUAL.rol.mapRolModulo.get('Proyectos')==1 " >
		<th style="width: 10px;text-align: center;">
			Editar
		</th>
		<th style="width: 10px;text-align: center;">
			
		</th>
		</s:if>
		</tr>
	</thead>
		<tbody>
		      
		        <s:iterator  value="listaProyecto"  status="list">
		            
		            
		                   
		                <tr class="row <s:if test="#list.odd == true ">odd</s:if>">
		                <td>
		                  <a  href="#"  class="linkProy"  name='<s:property value="idproyecto"/>' >
		                    
		                    <img   class="imgProy" width="25"  src="img/folder.png" title="Mostrar Detalle"   />
		                     
		                    </a>
		                </td>
		                
		                <td style="width: 800px;
		                 <s:if test="%{flagVigencia==1 || flagVigencia==3}"> 
		                  color:black; 
		                    </s:if>
		                  <s:elseif test="%{flagVigencia==2 }">
		        		     color:red;
		             		</s:elseif> ">
		                    <s:property value="nombreproyecto"/>
		                    
		                </td>
		                <td style="width:20px;text-align: center;
		                <s:if test="%{flagVigencia==1 || flagVigencia==3}"> 
		                  color:black; 
		                    </s:if>
		                  <s:elseif test="%{flagVigencia==2 }">
		        		     color:red;
		             		</s:elseif> ">
		                    <s:date format="yyyy" name="fechainicioproyecto" />
		                    
		                </td>
		                <td style="width:20px;text-align: center;
		                
		                <s:if test="%{flagVigencia==1 || flagVigencia==3}"> 
		                  color:black; 
		                    </s:if>
		                  <s:elseif test="%{flagVigencia==2 }">
		        		     color:red;
		             		</s:elseif> ">
		                    <s:date format="yyyy" name="fechafinproyecto" />
		                    
		                </td>
		                
		                   	<s:if test="%{flagVigencia==1 || flagVigencia==3}"> 
		                    <td style="width:20px;text-align: center;">
		                   Vigente  
		                   </td>
		                    </s:if>
		            
		  		          <s:elseif test="%{flagVigencia==2 }">
		        		     <td style="width:20px;text-align: center;color: red;">
		        		     Concluido  
		             		 </td>
		             		</s:elseif>
		                <td style="text-align: center;">
		                
		              
		                <s:if test="%{listaProyectoArchivo.size()!=0}">
		                   <a  href="#"  class="linkDocProy"  name='<s:property value="idproyecto"/>' >
		                    
		                    <img   class="imgProy"  src="img/pdf.gif" title="Mostrar Documentos"   />
		                     
		                    </a>
		                </s:if>
		                 
		                </td>
		                <s:if test="#session.USUARIO_ACTUAL.rol.mapRolModulo.get('Proyectos')==1">
		                
		                
		                  <td style="width:9px;text-align: center;"> 
		                <s:if test="%{flagAccion==1}">
		                <a href="#"  name='<s:property value="idproyecto"/>' class="linkRegProy"  >
	                         <img   src="img/page_edit.png" title="Editar"  />
	                    </a>
	                    </s:if>
		                </td>
		                
		                
		                
		                <td style="width:9px;text-align: center;"> 
		                <s:if test="%{flagAccion==1}">
		                <input type="checkbox"  name="listaCodigos"  value='<s:property value="idproyecto"/>' class="checkProyecto" />
	                    </s:if>
		                </td>
		                </s:if>
		               
		            </tr>  
		          
		        </s:iterator>
		</tbody>
	</table>








 </s:else>








