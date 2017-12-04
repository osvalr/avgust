<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@page pageEncoding="UTF-8"%>

 <s:if  test="%{listaTelefono.size()==0}" >
         <label style="color: red;"> No se encontraron resultados
         </label>
       </s:if>
<s:else>



<span style="color:blue;">
<!--  
Se encontraron  ${paginacion.totalProyectos} proyecto(s) 
<a  href="#"  class="linkExpProy"  name="1" >
	       <img   class="imgExpExcel"  src="<%=request.getContextPath()%>/img/excel.gif" title="Exportar Excel"   />
	   </a>
	   <a  href="#"  class="linkExpProy"   name="2">
	       <img   class="imgExpPdf"  src="<%=request.getContextPath()%>/img/pdf.gif" title="Exportar Pdf"   />
	   </a>
	   -->
</span>


<!--  
<div  id="divPagProy" class="pagination"> 

    
    
	<s:if test="%{paginacion.pagina>3}">
		<a  href="#"    name='1'  >
			Primera
		</a>
		<a  href="#"    name='${paginacion.pagina-1}'  >
			Anterior
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
			Siguiente
		</a>
		<a  href="#"    name='${paginacion.total}'  >
			Última
		</a>
	</s:if>
</div>
-->



<table  cellpadding='0' cellspacing='1' class="tablaList"
style="margin-left:2px " >

<thead>
<tr style="background:#eee;border:1px solid #ccc;">

<th style="width: 800px;text-align: center;">
Usuario
</th>
<th style="width: 800px;text-align: center;">
Tel&eacute;fono
</th>
<th style="width: 10px;text-align: center;">
Editar
</th>
</tr>
</thead>
     
<tbody>
      
        <s:iterator  value="listaTelefono" status="list" >
           
	                   
	                <tr    
	                
	                 class="row <s:if test="#list.odd == true ">odd</s:if>"	     
	                     
	                 >
	                
	                  <td style="width:20px;text-align: center;">
	                   <s:property   value="personal.apepat" />  
	                   <s:property   value="personal.apemat" />  
	                    <s:property   value="personal.nombre" />  
	                   </td>
	                      
	               	                
	            </tr>  
	             
	             
	             
	             
	             
	             
	            
        </s:iterator>
</tbody>
    </table>




 </s:else>








