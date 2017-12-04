<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="js/lib/ajaxupload.js"></script>

<h1>Registro de Turistas<br /><span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span></h1>
	
	
	
	<div id="tabsRegFichaTurismo">
	<ul>
		<li><a href="#tabs-1">DATOS GENERALES</a></li>
		<li><a  id="tab2" href="" >DATOS VISITANTES</a></li>
	
	</ul>
	
	<div id="tabs-1">
	
	<form id="formRegistroFichaTurismo" method="post">
	
	
	 <span class="msgcambioruta msg"  ><s:property value="getText('msgcambioruta')" /></span>
	  <span class="msgguardaficha msg"  ><s:property value="getText('msgguardaficha')" /></span>	  
	<input  class="hdtiporegistro"  type="hidden" name="idtiporegistro" 
	 <s:if test="%{fichaturismo.idfichaturismo==0}" >
		 value="1"
	 </s:if>
	  <s:else>
	    value="2"
	  </s:else>
    
			
			  />
    
    
     <input  class="hdfichaturismo"  type="hidden" name="fichaturismo.idfichaturismo" 
			value="${fichaturismo.idfichaturismo}"  />
	
	<input type="hidden" name="fichaturismo.areanatural.idareanatural" 
			value="${area.idareanatural}" />




<!-- Fecha de Ingreso -->
   <fieldset class="l regtur" style="width: 40%"  >
			<legend>Destino</legend>
	
	
	
	    <label>Fecha de Ingreso:</label>
	    <input name="fichaturismo.fpropuesta" id="inFechaIngreso" 
				class="dateDMY valid datepicker dom addpreview" size="10" 
				  value="${fichaturismo.fpropuesta}"   params="lbl_fechaingreso" type="text" />
		<br/>
        
      <label>Ruta Turística: </label>
       <s:select name="fichaturismo.rutaturismo.idrutaturismo" 
						 
						listKey="idrutaturismo" 
						listValue="nombrerutaturismo"
						headerKey=""  
						headerValue="Seleccione"
						list="rutas" 
						id="cbRutaturismo"
						cssClass="select valid dom addpreview cborutaturismo"
						params="lbl_rutaturismo" 	
						  theme="simple"
						  /> 
   
   	
	</fieldset>

	
	
		
		<!-- modalidad de ingreso -->
		
<fieldset class="l">
		
		<legend>Modalidad de Ingreso</legend>
		
		
   
   <div>
	  
	</div>
	
		<s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal!=0}">
		
		<div class="radios">
			<input id="individual" name="modalidad" value="1" type="radio" class="modalidad dom  addpreview"
				 params="lbl_modalidad" title="Individual"
				 ${fichaturismo.empresaturismo.idoperadorturismo}
				  <s:if test="%{fichaturismo.empresaturismo.idoperadorturismo==0 && fichaturismo.operadorturismo.idoperadorturismo==0}">
			          checked
			       </s:if> 
				 
				  />
			<label for="individual">Individual</label>
			 
				<input id="empresa" name="modalidad" value="2" type="radio" class="modalidad dom  addpreview"
					 params="lbl_modalidad"  title="Agencia de Viaje/Operador Turístico" 
					 
				   <s:if test="%{fichaturismo.empresaturismo.idoperadorturismo!=0 || fichaturismo.operadorturismo.idoperadorturismo!=0}">
			          checked
			       </s:if> 
					 
					 /> 
				<label for="empresa">Agencia de Viaje/Operador Turístico</label>   
			
		</div>
		
			 
			 <div id="operadores" 
			 <s:if test="%{fichaturismo.empresaturismo.idoperadorturismo==0 && fichaturismo.operadorturismo.idoperadorturismo==0}">
			   class="h regtur" 
			 </s:if>
			 <s:else>
			 class="regtur"
			 style="display:block"
			 </s:else>
			 
			 >
				  
					<label>Agencia de Viaje:</label>
					<s:select name="fichaturismo.empresaturismo.idoperadorturismo"  
						list="listaAgenciaviaje"   
						listKey="idoperadorturismo" 
						listValue="nombrepersonajuridica"  
						headerKey="0"  
						headerValue="Ninguna" 
						id="empresaturismo"
						cssClass="dom  addpreview" 
						params="lbl_empresaturismo"
					/>
				    <label>Operador Turístico:</label>
					<s:select name="fichaturismo.operadorturismo.idoperadorturismo" 
					    list="listaOperadorturismo" 
						listKey="idoperadorturismo" 
						listValue="nombrepersonajuridica"
						headerKey="0" headerValue="Ninguna"
						id="operadorturismo"
						cssClass="dom  addpreview"   
						params="lbl_operadorturismo"
					/> 
					
				
				<div class="msgemptur v_label" style="display:none" ><s:property value="getText('msgemptur')" /> </div>
				
			 </div>
			
			<div class="msgmoding v_label" style="display:none" ><s:property value="getText('msgmoding')" /> </div>
			 
		    
		 
		   
		</s:if>
		<s:else>
		    <s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal==0}">
		            <input  type="hidden" class="addpreview"
					 params="lbl_modalidad"  title="Agencia de Viaje/Operador Turístico" /> 
		         <div id="operadores" class="regtur" >
				    <label>Agencia de Viaje:</label>
					<s:select name="fichaturismo.empresaturismo.idoperadorturismo"  
						list="listaAgenciaviaje"   
						listKey="idoperadorturismo" 
						listValue="nombrepersonajuridica"  
						headerKey="0"  
						headerValue="Ninguna" 
						id="empresaturismo"
						cssClass="dom  addpreview" 
						params="lbl_empresaturismo"
					/> 
					<label>Operador Turístico:</label>
					<s:select name="fichaturismo.operadorturismo.idoperadorturismo" 
					    list="listaOperadorturismo" 
						listKey="idoperadorturismo" 
						listValue="nombrepersonajuridica" 
						headerKey="0" headerValue="Ninguna"
						id="operadorturismo"
						cssClass="dom  addpreview"   
						params="lbl_operadorturismo"
						disabled="true"
					/> 
				
			 </div>
			
		         
		     </s:if>
		</s:else>
	
		
		
		
		
		</fieldset>
		
		
	
	
	
	
   <!-- SECTOR -->
	
<!--	<fieldset class="l">-->
<!--	   <legend>Ruta Tur&iacute;stica</legend>-->
<!--	   -->
<!--	</fieldset>-->

         
         <br style="clear: both;"/>
         
         
         
         
         <!-- GUIAS -->
         <fieldset class="l">
         <legend>Gu&iacute;a/Orientador</legend>
         	
	 <div id="divGuiaTurismo" >  
			      
			        
			        <span>
                    Agregar
                    </span>
                     <a  href="#"   id="linkAddGuia" >
                       <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Guías"  />                
                      </a>
                    
			      
            
                 <div id="divListaGuiaTurismo">
                 <s:set var="i"  value="0" />
                   <s:iterator value="fichaturismo.listaGuiaFichaturismo" >
                      <div id="rowguia${i+1}"  class="rowguia" >
	                   <input  class="idcodguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[${i}].idcodigo" />
						<input  class="idguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[${i}].guia.idguia" 
						 value="${guia.idguia}"    />
    					<input   class="nomcompguia upperlbl"     type="text" size="32" 
    					   value="${guia.apepat} ${guia.apemat}, ${guia.nombre}"
    					 />
						<span  class="i i_supr" title="eliminar" ></span>
						<span class="msgguia v_label" style="display:none;" ><s:property value="getText('msgguia')" /></span>
						</div>
					 <s:set var="i" value="#i+1" />  
                   </s:iterator>
                  <input type="hidden" value='${i}'  id="idultguia" />
                 </div>
     </div>	
	
	<div id="divContRowGuia" style="display: none;" >
	            <div id="rowguia_n"  class="rowguia" >
	            <input  class="idcodguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[_i].idcodigo" />
				<input  class="idguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[_i].guia.idguia" />
    			<input   class="nomcompguia upperlbl"     type="text" size="32"  />
				<span  class="i i_supr" title="eliminar" ></span>
				<span class="msgguia v_label" style="display:none;" ><s:property value="getText('msgguia')" /></span>
				</div>
     </div>
         
         </fieldset>
         
       
	  
	
	
	 <div id="divtipoturismo" class="l">
	   <fieldset class="row" >
			<legend>Tipos Turismo</legend>
			<div class="checkboxes" >
			<s:set var="i" value="0" />
				<s:iterator status="st" value="listaTipoturismo" >
					
					<div    id='divtipoturismo${idtipoturismo}' class="divtipoturismo"  style="float: left;margin-right:5px ">
					  <input name="fichaturismo.listaTipoturismoFichaturismo[${i}].tipoturismo.idtipoturismo" 
					 class="dom tipoturismo" 
						title="${nombretipoturismo}"  
						type="checkbox" id="tipoturismo_${i}"
						value="${idtipoturismo}"     />
					<label   style="font-weight:bold;" for="tipoturismo_${i}"  	
						class="checkboxLabel" >${nombretipoturismo}
				    </label>
				    <br>
				 
				  <div  class="actividadturismo" style="margin-left: 15px">
				      <s:if test="%{fichaturismo.idfichaturismo!=0}">
				        <div style="margin-left:15px:">Actividades</div>
				        <s:iterator value="listaActividadturismo">
			      <div  id="divactividadesturismo" class="checkboxes" >
			    	    <span class="rowactividadturismo">
	              <input name="fichaturismo.listaActividadturismo[${i}].idactividadturismo"  class="dom actividades"   
						type="checkbox" id="actividad${i}"  title='${nombreactividadturismo}'
						 params="lbl_actividades" value="${idactividadturismo}"   />
					<label  for="actividad${i}"  
						class="checkboxLabel">
					 ${nombreactividadturismo}	
					</label>
				 </span>
			    </div>
			    <s:set var="i" value="#i+1" />  
			    </s:iterator>
				      </s:if>
				       
				  </div>
				       
				  
					
					
					</div>
					
				  <s:set var="i" value="#i+1" /> 
				</s:iterator>
				
				   <input type="hidden" value='${i}'  id="idultactividad" /> 
			</div> 
       </fieldset>
	</div>
	
	<div id="divtipoturismosel" style="display: none;">
	    <s:iterator value="fichaturismo.listaTipoturismoFichaturismo">
	      <input  class="idtipoturismo" type="hidden" value="${tipoturismo.idtipoturismo}"  />
	    </s:iterator>
	</div>
	
	<div id="divactividadturismosel" style="display: none;">
	    <s:iterator value="fichaturismo.listaActividadturismo">
	      <input  class="idactividadturismo" type="hidden" value="${idactividadturismo}"  />
	    </s:iterator>
	</div>
	
	
<!--	<div id="divactividadturismo">-->
<!---->
<!--        <s:set var="i" value="0" />-->
<!--	    <s:iterator value="listaTipoturismo">-->
<!--	        <div  id='divactividadturismo${idtipoturismo}' style="float:left;width:170px;margin: 0px 10px;padding: 10px">-->
<!--	        <fieldset   class="row">-->
<!--			   <legend>Actividades <span class="nomtipoturismo">${nombretipoturismo} </span></legend>-->
<!--			    -->
<!--			    <s:iterator value="listaActividadturismo">-->
<!--			      <div  id="divactividadesturismo" class="checkboxes" >-->
<!--			    	    <span class="rowactividadturismo">-->
<!--	              <input name="fichaturismo.listaActividadturismo[${i}].idactividadturismo"  class="dom actividades"   -->
<!--						type="checkbox" id="actividad${i}"  title='${nombreactividadturismo}'-->
<!--						 params="lbl_actividades" value="${idactividadturismo}"   />-->
<!--					<label  for="actividad${i}"  -->
<!--						class="checkboxLabel">-->
<!--					 ${nombreactividadturismo}	-->
<!--					</label>-->
<!--				 </span>-->
<!--			    </div>-->
<!--			    <s:set var="i" value="#i+1" />  -->
<!--			    </s:iterator>-->
<!--			     -->
<!--			    -->
<!--		     </fieldset>-->
<!--	       </div>-->
<!--	    -->
<!--	    </s:iterator>-->
<!--	   <input type="hidden" value='${i}'  id="idultactividad" />-->
<!--	   -->
<!--		-->
<!--	</div>-->
	
	
	<div id="divFsActividadTurismo" style="display: none;">
	     <div  id="divactividadturismo_i" style="float:left;width:170px;margin: 0px 10px;padding: 10px">
	        <fieldset   class="row">
			   <legend>Actividades <span class="nomtipoturismo"></span></legend>
			    <div  id="divactividadesturismo" class="checkboxes" >
			    	    
			    </div> 
		     </fieldset>
	    </div>
	   
	 </div>
	 
	 
	 <div id="divContActividadTurismo" style="display: none;" >
	             <span class="rowactividadturismo">
	              <input name="fichaturismo.listaActividadturismo[_i].idactividadturismo"  class="dom actividades"   
						type="checkbox" id="actividad_i" 
						 params="lbl_actividades"    />
					<label  for="actividad_i"  
						class="checkboxLabel"></label>
				 </span>
				 <br>		
     </div>
	
	
	
	   
<!--	  <div id="divListaVisitanteFicha" style="display: none;">-->
<!--	  </div> -->
<!--	   -->
<!--	   <div id="divContIdvisitante" style="display:  none">-->
<!--	     <input  class="idvisitante"   name="fichaturismo.listaVisitante[_i].idvisitante" type="hidden"   />-->
<!--	   </div>-->
	   
	   
   <div style="text-align: center;clear: both;">
	     
	     	
		  
		 <s:if  test="%{#session.idtiporegistro==constantes.TIPO_REGISTRO_CREAR}">
		 <input type="button"  value="Cancelar" name="regfichaturismo.action"
			 class="submit btnSalirReg"   />
           <input type="button"  value="Siguiente"  name="formRegistroFichaTurismo"
			 class="submit btnGuardarDatGenFichaTurismo"    />	
         </s:if>
  		 <s:elseif test="%{#session.idtiporegistro==constantes.TIPO_REGISTRO_EDITAR}">
  		 <input type="button"  value="Volver" name="consultafichaturismo.action"
			 class="submit btnSalirReg"   />
           <input type="button"  value="Guardar"  name="formRegistroFichaTurismo"
			 class="submit btnGuardarDatGenFichaTurismo"    />	  
  		 </s:elseif>
		 
			
			
		 

 </div>	
</form>
	
	
	</div>
	
	 <!-- VISITANTES -->
	<div id="tabs-2" >
	
    </div>
	</div>
	
	 <!-- MODAL -->
	<div id="divModalConfirmacion">
    </div>	
	


<form id="formFichaTurismo" method="post">
<input  type="hidden"  name="idfichaturismo" class="hdfichaturismo"  />
</form>


	
				
	
				
