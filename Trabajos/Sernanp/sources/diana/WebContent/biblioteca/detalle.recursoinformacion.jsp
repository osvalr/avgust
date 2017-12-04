<%@ taglib prefix="s" uri="/struts-tags"%>



<div id="tabsDetalleRecInf">
	<ul>
		<li><a href="#tabs-1">DATOS GENERALES</a></li>
		<li><a href="#tabs-2">DATOS BIBLIOGRAFICOS</a></li>
		<li><a href="#tabs-3">DATOS ADICIONALES</a></li>
		
		    <a href="#"  style="float: right;" param='<s:property  value="recursoinformacion.idrecursoinformacion"/>' class="linkDetRecInf"  >
	                         <img   src="img/16x16/actions/edit-delete.png"   />
	                    </a>
		 
	</ul>
	<div id="tabs-1">
		<div style="text-align: center;">
		  <table  >
		  <thead>
		  <tr>
		    <th>
		    Dato
		    </th>
	        <th>
		    Descripci&oacute;n
		    </th>
		  </tr>
		    	    
		  </thead>
		  <tbody>
		  <tr>
		     <th style="text-align: left;">
		    C&oacute;digo
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="recursoinformacion.codigorecursoinformacion"/>
		     </td> 
		  </tr>
		  <tr>
		     <th style="text-align: left;">
		     T&iacute;tulo:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="recursoinformacion.titulo"/>
		     </td> 
		  </tr>
               
            
            <tr>
		     <th style="text-align: left;">
		     Tipo Recurso Informaci&oacute;n
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="recursoinformacion.tiporecursoinformacion.nombretipo"/>
		     </td> 
		  </tr>
		  
		  
		  <tr>
		     <th style="text-align: left;">
		     Medio :
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="recursoinformacion.mediorecursoinformacion.nombretipo"/>
		     </td> 
		  </tr>
               
            
           <tr>
		     <th style="text-align: left;">
		     Tem&aacute;tica:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="recursoinformacion.tematicarecursoinformacion.nombretematicarecursoinformacion"/>
		     </td> 
		  </tr> 
		  
              <tr>
		     <th style="text-align: left;">
		     Idioma:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="recursoinformacion.idioma.nombreidioma"/>
		     </td> 
		  </tr> 
              
              
             <s:if  test="%{!recursoinformacion.isbn.equals('')}">   
           <tr>
		     <th style="text-align: left;">
		    ISBN
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="recursoinformacion.isbn"/>
		     </td> 
		  </tr>
          </s:if> 
               
               
               
              <s:if  test="%{!recursoinformacion.codigosgd.equals('')}">   
           <tr>
		     <th style="text-align: left;">
		    C&oacute;digo SGD:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="recursoinformacion.codigosgd"/>
		     </td> 
		  </tr>
          </s:if>
               		  
		  
		  <!--  
		  <tr>
		  <th style="text-align: left;">
		     Fecha Aprobaci&oacute;n
		    </th>
		    <td>
		    <s:date format="yyyy" name="recursoinformacion.aprobacionrecursoinformacion.fechaaprobacion" />
		     </td>
		  </tr>
		  -->
		  </tbody>
		  </table>
		  
		  
		   
		
	    </div>
	    
	    
	    
	</div>
	<div id="tabs-2">
	
	<div style="text-align: center;">
		  
		  
		  
		  
		  
		  
		   <s:if  test="%{recursoinformacion.listaRecursoInformacionEditorial.size()!=0}" >
		    <table  >
		  	<thead>
		  	  <tr>
		     	<th style="text-align: left;">
		     	Editorial(es):
		     	</th>
		     	
		     </tr>
		     </thead>
		     <tbody> 
		     	<s:iterator value="recursoinformacion.listaRecursoInformacionEditorial">
		     	<tr>
		     		<td>
		      			<s:property value="editorial.nombrepersonajuridica" />
		     		</td>
		    	</tr>
		     	</s:iterator>
		    </tbody>
		    
		  </table>  
		  </s:if>
		  
		  
		  
		  <s:if  test="%{recursoinformacion.listaRecursoInformacionAutor.size()!=0}" >
		    <table  >
		  	<thead>
		  	  <tr>
		     	<th style="text-align: left;">
		     	Autor(es):
		     	</th>
		     	
		     </tr>
		     </thead>
		     <tbody> 
		     	<s:iterator value="recursoinformacion.listaRecursoInformacionAutor">
		     	<tr>
		     		<td>
		      			<s:property value="autor.apepat" />  <s:property value="autor.apemat" />  <s:property value="autor.nombre" />
		     		</td>
		    	</tr>
		     	</s:iterator>
		    </tbody>
		    
		  </table>  
		  </s:if>
		  
		  
		  <s:if  test="%{recursoinformacion.listaRecursoInformacionTema.size()!=0}" >
		    <table  >
		  	<thead>
		  	  <tr>
		     	<th style="text-align: left;">
		     	Tema:
		     	</th>
		     	
		     </tr>
		     </thead>
		     <tbody> 
		     	<s:iterator value="recursoinformacion.listaRecursoInformacionTema">
		     	<tr>
		     		<td>
		      			<s:property value="tema.nombretema" />
		     		</td>
		    	</tr>
		     	</s:iterator>
		    </tbody>
		    
		  </table>  
		  </s:if>
		  
		  <table>
		   <thead>
		    <tr>
		      <th colspan="2">
		        Descripci&oacute;n Bibliogr&aacute;fica
		      </th>
		     </tr>
		    
		   </thead>
		   <tbody>
		    <s:if test="%{!recursoinformacion.descripcion.equals('')}">
		      <tr>
		        <td>
		          Descripci&oacute;n
		        </td>
		        <td>
		           <s:property value="recursoinformacion.descripcion" />
		        </td>
		      </tr>
		    </s:if>
		     <s:if test="%{recursoinformacion.numeropaginas!=0}">
		      <tr>
		        <td>
		          N&uacute;mero de p&aacute;ginas
		        </td>
		        <td>
		           <s:property value="recursoinformacion.numeropaginas" />
		        </td>
		      </tr>
		    </s:if>
		   </tbody>
		  </table>
		  
		  
		  
		 
		
	 </div>
	</div>
	
	<div id="tabs-3">
	  <div style="text-align: center;">
	  
	 
		  <table  >
		  <thead>
		  
		  <tr>
		   
		   <th>Categor&iacute;a ANP</th>
		   <th>Area Natural</th> 
		  </tr>
		    	    
		  </thead>
		  <tbody>
		   
		    <s:if  test="%{recursoinformacion.listaRecursoInformacionAreanatural.size()!=0}" >
		   		   
		   
		   <s:iterator value="recursoinformacion.listaRecursoInformacionAreanatural">
		  
		   <tr>
		   <td >
		    <s:property value="areanatural.categoriaanp.descategoriaanp" />
		   </td>
		   <td>
		  
		   <s:property value="areanatural.desareanatural" />
		   </td> 
		   </tr>
		  
		   </s:iterator>
		   
		   
		  
		   
		   </s:if>
		  
		  
		  
		 
		  </tbody>
		  </table>
		  
		
		  
		    <s:if  test="%{recursoinformacion.aprobacionrecursoinformacion.idrecursoinformacion!=0}" >
		         
		  <br>
		  <br>       
		  <table  >
		  <thead>
		  
		  <tr>
		   
		   <th colspan="2">
		   DATOS APROBACION
		   </th>
		   
		  </tr>
		    	    
		  </thead>
		  <tbody>
		   
		  <tr>
		  <td>Dependencia:</td>
		  <td>
		    <s:property value="recursoinformacion.aprobacionrecursoinformacion.areaorganica.desarea" />
		  </td>
		  </tr>
		  
		  <tr>
		  <td>Jefe/Director:</td>
		  <td>
		   <s:property value="%{recursoinformacion.aprobacionrecursoinformacion.personal.apepat}"/>
		   <s:property value="%{recursoinformacion.aprobacionrecursoinformacion.personal.apemat}"/>, 
              <s:property value="%{recursoinformacion.aprobacionrecursoinformacion.personal.nombre}"/>
		  </td>
		  </tr>
		  
		 
		  </tbody>
		  </table>
		    </s:if>
	  
	   	    
	  </div>
	</div>
	
</div>

