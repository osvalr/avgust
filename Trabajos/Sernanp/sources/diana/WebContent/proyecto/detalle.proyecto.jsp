<%@ taglib prefix="s" uri="/struts-tags"%>



<div id="tabs">
	<ul>
		<li><a href="#tabs-1">DATOS GENERALES</a></li>
		<li><a href="#tabs-2">ANP</a></li>
		<li><a href="#tabs-3">DOCUMENTOS</a></li>
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
		     Nombre:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.nombreproyecto"/>
		     </td> 
		  </tr>
               
            
            <tr>
		     <th style="text-align: left;">
		     Categor&iacute;a:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.categoriaproyecto.nombretipo"/>
		     </td> 
		  </tr>
		  
		  
		  <tr>
		     <th style="text-align: left;">
		     Tipo:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.tipoproyecto.nombretipo"/>
		     </td> 
		  </tr>
               
            <s:if  test="%{!proyecto.estadoproyecto.idestado==0}">      
           <tr>
		     <th style="text-align: left;">
		     Estado:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.estadoproyecto.nombestado"/>
		     </td> 
		  </tr> 
		  </s:if>
              
             <s:if  test="%{!proyecto.codigoproyecto.equals('')}">   
           <tr>
		     <th style="text-align: left;">
		    C&oacute;digo:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.codigoproyecto"/>
		     </td> 
		  </tr>
          </s:if> 
               
               
               
              <s:if  test="%{!proyecto.objetivoproyecto.equals('')}">   
           <tr>
		     <th style="text-align: left;">
		    Objetivo:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.objetivoproyecto"/>
		     </td> 
		  </tr>
          </s:if>
               		  
		    <s:if  test="%{!proyecto.observacionproyecto.equals('')}">
		  <tr>
		     <th style="text-align: left;">
		     Observaci&oacute;n:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.observacionproyecto"/>
		     </td> 
		  </tr>
		  </s:if>
		  
		  <s:if  test="%{!proyecto.compromisoproyecto.equals('')}">
		    <tr>
		     <th style="text-align: left;">
		     Compromiso:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.compromisoproyecto"/>
		     </td> 
		  </tr>
		  </s:if>
		  
		  <s:if  test="%{!proyecto.componenteproyecto.equals('')}">
		    <tr>
		     <th style="text-align: left;">
		     Componentes:
		     </th>
		      <td style="text-align: left" >
		      <s:property  value="proyecto.componenteproyecto"/>
		     </td> 
		  </tr>
		  </s:if>
		  
		  <s:if  test="%{proyecto.listaFuenteProyecto.size()!=0}" >
		  <tr>
		     <th style="text-align: left;">
		     Fuentes de Financiamiento:
		     </th>
		      <td style="text-align: left" >
		     
		     <table>
		     <thead>
		     <tr>
		     <th>
		     Instituci&oacute;n
		     </th>
		     <th>
		     Moneda
		     </th>
		     <th>
		     Monto
		     </th>
		     <th>
		     A&ntilde;o Tipo Cambio 
		     </th>
		     <th>
		     Valor Tipo Cambio(Soles) 
		     </th>
		     </tr>
		     
		      
		     <s:iterator value="proyecto.listaFuenteProyecto">
		     <tbody>
		     <tr>
		     <td>
		      <s:property value="fteFto.personajuridica.siglas" />
		     </td>
		     <td>
		     <s:property value="moneda.nombremoneda" />
		     </td>
		     <td>
		      <s:if test="%{monto!=0}">
		        <s:text name="formato.numero.dosdecimal">
              <s:param name="value" value="monto"/>
            </s:text>
		        
		      </s:if>
		      </td>
		      <td>
		      <s:if test="%{tipocambio.anio!=0}" >
		        <s:property value="tipocambio.anio" />
		      </s:if>
		     
		     </td>
		     <td>
		     <s:if test="tipocambio.valor!=0">
		       <s:text name="formato.numero.dosdecimal">
              <s:param name="value" value="tipocambio.valor"/>
            </s:text>
		     </s:if>
		      
		     </td>
		     </tr>
		     </tbody>
		    </s:iterator>
		    
		    
		     </table>
		     
		     </td> 
		  </tr>
		  <s:if test="%{proyecto.monto!=0}">
		  <tr>
		    <th>
		     Monto:
		    </th>
		    <td style="text-align: left;">
		      
		    <s:text name="formato.numero.dosdecimal">
              <s:param name="value" value="proyecto.monto"/>
            </s:text>
            <!--  
              <s:property value="proyecto.monto"/>
             -->
		    
		    <s:property value="proyecto.moneda.nombremoneda"/>
		    </td>
		    
		  </tr>
		  </s:if>
		  </s:if>
		  
		  <s:if  test="%{proyecto.listaProyectoEjecutor.size()!=0}" >
		   <tr>
		     <th style="text-align: left;">
		     Ejecutores Financieros:
		     </th>
		      <td   style="text-align: left" >
		      
		      <ul class="detListaModal">
		      <s:iterator value="proyecto.listaProyectoEjecutor">
		       <s:if test="%{tipoejecutor.idtipo==1}">
		       <li>
		      <s:property value="ejecutor.personajuridica.siglas" />
		      </li>
		      </s:if>
		      </s:iterator>
		      </ul>
		      
		     </td> 
		  </tr>
		  <tr>
		     <th style="text-align: left;">
		     Ejecutores Tecnicos:
		     </th>
		      <td   style="text-align: left" >
		      
		      <ul class="detListaModal" >
		      <s:iterator value="proyecto.listaProyectoEjecutor">
		       <s:if test="%{tipoejecutor.idtipo==2}">
		       <li>
		      <s:property value="ejecutor.personajuridica.siglas" />
		      </li>
		      </s:if>
		      </s:iterator>
		      </ul>
		      
		     </td> 
		  </tr>
		  </s:if>
		  
		  
		  <tr>
		   <th style="text-align: left;">
		     Periodo
		    </th>
		     <td style="text-align: left">
		     
                  <s:if test="%{(proyecto.periodoproyecto/12)!=0}">
                  A&ntilde;os:
                  <s:property  value="%{proyecto.periodoproyecto/12}"/>
                  </s:if>
                  
                  <s:if test="%{(proyecto.periodoproyecto%12)!=0}">
                  Meses:
                  <s:property  value="%{proyecto.periodoproyecto%12}"/>
                  </s:if>
                  
                 
		     </td>
		  </tr>
		   
		  <tr>
		  <th style="text-align: left;">
		     A&ntilde;o Inicio/Fin
		    </th>
		    <td>
		    <s:date format="yyyy" name="proyecto.fechainicioproyecto" />
		    /
		     <s:date format="yyyy" name="proyecto.fechafinproyecto" />
		    </td>
		  </tr> 
		  
		  </tbody>
		  </table>
		  
		
	    </div>
	</div>
	<div id="tabs-2">
	
	<div style="text-align: center;">
		  <table  >
		  <thead>
		  
		  <tr>
		   
		   <th>Categor&iacute;a ANP</th>
		   <th>Area Natural</th> 
		  </tr>
		    	    
		  </thead>
		  <tbody>
		   
		    <s:if  test="%{proyecto.areanaturals.size()!=0}" >
		   		   
		   
		   <s:iterator value="proyecto.areanaturals">
		  
		   <tr>
		   <td >
		    <s:property value="categoriaanp.descategoriaanp" />
		   </td>
		   <td>
		  
		   <s:property value="desareanatural" />
		   </td> 
		   </tr>
		  
		   </s:iterator>
		   
		   
		  
		   
		   </s:if>
		   <s:if  test="%{!proyecto.areaespecificaproyecto.equals('')}">
		   <tr>
		    <th>Area Espec&iacute;fica:</th>
		   
             <td>   
		     <s:property value="proyecto.areaespecificaproyecto" />
		    </td>
		  </tr>
		  </s:if>
		  
		  
		 
		  </tbody>
		  </table>
		  
		
	 </div>
	</div>
	
	<div id="tabs-3">
	  <div style="text-align: center;">
	  
	  <s:if  test="%{proyecto.listaProyectoArchivo.size()!=0}" >
	  
	  
	  <table>
	  <thead>
	   <tr>
	     <th > 
	         Documento 
	     </th>
	     <th > 
	         Archivo 
	     </th>
	   </tr>
	   
	  </thead>
	  <tbody>
	  <s:iterator value="proyecto.listaProyectoArchivo">
	    
	     <tr>
	     
	     <td>
	      <s:property  value="archivo.descripcion" />
	     </td>
	     
	     <td>
	       <s:iterator value="archivo.listaArchivo">
	        
	           <a href="#"   param='<s:property  value="idarchivo" />' class="linkMostrarArchivo"  >
	                 <s:property  value="nombreInicial" />
              </a>
	        
	         
	         
	         <br/>
	       </s:iterator>
	     
	     
	     </td>
	     </tr>
	     
	    
	     
	     
	     
	    </s:iterator>

	  
	  </tbody>
	  </table>
	  </s:if> 
	  <s:else>
	   No existen documentos para este proyecto
	  </s:else>
	  
	  	    
	  </div>
	</div>
	
</div>

