<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="js/lib/ajaxupload.js"></script>

<h1>Registro de Visitantes<br /><span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span></h1>
	
<form id="formRegistroFichaTurismoEdit" method="post">
	

   <fieldset class="l">
			<legend>Fecha y Modalidad </legend>
	<input type="hidden" name="fichaturismo.idfichaturismo" 
			value="${fichaturismo.idfichaturismo}"  />
	
	<div>
			<strong>Fecha de Ingreso:</strong> 
			<input name="fichaturismo.fpropuesta" id="inFechaIngreso" 
				class="dateDMY valid datepicker dom addpreview" size="10" 
				  value="${fichaturismo.fpropuesta}"   params="lbl_fechaingreso" type="text" />
   </div>
   <hr />  
   
   
   <!-- modalidad de ingreso -->
   
   <div>
	  <strong>Modalidad de Ingreso:</strong>
	</div>
	
		<s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal!=0}">
		
		<div class="radios">
			<input id="individual" name="modalidad" value="1" type="radio" class="modalidad dom  addpreview"
				 params="lbl_modalidad" title="Individual" />
			<label for="individual">Individual</label>
			 
				<input id="empresa" name="modalidad" value="2" type="radio" class="modalidad dom  addpreview"
					 params="lbl_modalidad"  title="Agencia de Viaje/Operador Tur�stico" /> 
				<label for="empresa">Agencia de Viaje/Operador Tur�stico</label>   
			
		</div>
		
			 
			 <div id="operadores" class="h">
				<div>   
					<s:select name="fichaturismo.empresaturismo.idoperadorturismo"  
						list="listaAgenciaviaje"   
						listKey="idoperadorturismo" 
						listValue="nombrepersonajuridica" 
						label="Agencia de Viaje" 
						headerKey="0"  
						headerValue="Ninguna" 
						id="empresaturismo"
						cssClass="dom  addpreview" 
						params="lbl_empresaturismo"
					/>
				</div>
				 
				<div>
					<s:select name="fichaturismo.operadorturismo.idoperadorturismo" 
					    list="listaOperadorturismo" 
						listKey="idoperadorturismo" 
						listValue="nombrepersonajuridica"
						label="Operador Tur�stico" 
						headerKey="0" headerValue="Ninguna"
						id="operadorturismo"
						cssClass="dom  addpreview"   
						params="lbl_operadorturismo"
					/> 
					
				</div>
				<div class="msgemptur v_label" style="display:none" >Seleccione una agencia o un operador </div>
			 </div>
			
			
			 
		    
		 
		   
		</s:if>
		<s:else>
		    <s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal==0}">
		            <input  type="hidden" class="addpreview"
					 params="lbl_modalidad"  title="Agencia de Viaje/Operador Tur�stico" /> 
		         <div id="operadores" >
				<div>   
					<s:select name="fichaturismo.empresaturismo.idoperadorturismo"  
						list="listaAgenciaviaje"   
						listKey="idoperadorturismo" 
						listValue="nombrepersonajuridica" 
						label="Agencia de Viaje" 
						headerKey="0"  
						headerValue="Ninguna" 
						id="empresaturismo"
						cssClass="dom  addpreview" 
						params="lbl_empresaturismo"
					/> 
				</div>
				 
				<div>
					<s:select name="fichaturismo.operadorturismo.idoperadorturismo" 
					    list="listaOperadorturismo" 
						listKey="idoperadorturismo" 
						listValue="nombrepersonajuridica"
						label="Operador Tur�stico" 
						headerKey="0" headerValue="Ninguna"
						id="operadorturismo"
						cssClass="dom  addpreview"   
						params="lbl_operadorturismo"
						disabled="true"
					/> 
				</div>
			 </div>
			
		         
		     </s:if>
		</s:else>
	
	
	
	<hr />
	
	
	
	
	
	<!-- GUIAS -->
	 <div id="divGuiaTurismo" >  
			      <strong>Gu&iacute;a(s)</strong>   
			        
			        <div style="float: right;">
                     <a  href="#"   id="linkAddGuia" >
                       <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Gu�as"  />                
                      </a>
                  </div>
			         
			      
            
                 <div id="divListaGuiaTurismo">
                 <s:set var="i"  value="0" />
                   <s:iterator value="fichaturismo.listaGuiaFichaturismo" >
                      <div id="rowguia${i+1}"  class="rowguia" style="width: 330px">
	                   <input  class="idcodguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[${i}].idcodigo" />
						<input  class="idguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[${i}].guia.idguia" 
						 value="${guia.idguia}"    />
    					<input   class="nomcompguia upperlbl"     type="text" size="32" 
    					   value="${guia.apepat} ${guia.apemat}, ${guia.nombre}"
    					 />
						<span  class="i i_supr" title="eliminar" ></span>
						<span class="msgguia v_label" style="display:none;" >Seleccione un gu�a</span>
						</div>
					 <s:set var="i" value="#i+1" />  
                   </s:iterator>
                  <input type="hidden" value='${i}'  id="idultguia" />
                 </div>
     </div>	
	
	<div id="divContRowGuia" style="display: none;" >
	            <div id="rowguia_n"  class="rowguia" style="width: 330px">
	            <input  class="idcodguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[_i].idcodigo" />
				<input  class="idguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[_i].guia.idguia" />
    			<input   class="nomcompguia upperlbl"     type="text" size="32"  />
				<span  class="i i_supr" title="eliminar" ></span>
				<span class="msgguia v_label" style="display:none;" >Seleccione un gu�a</span>
				</div>
     </div>
	
	</fieldset>

	
	
		
	
	
	
	
   <!-- SECTOR -->
	
	<fieldset>
	   <legend>Sector Tur&iacute;stico</legend>
	    <s:select name="fichaturismo.rutaturismo.idrutaturismo" 
						label="Sector Turistico" 
						listKey="idrutaturismo" 
						listValue="nombrerutaturismo"
						headerKey=""  
						headerValue="Seleccione"
						list="rutas" 
						id="cbRutaturismo"
						cssClass="dom addpreview"
						params="lbl_rutaturismo" 	
						  /> 
	</fieldset>

         
         
       
	
	<div style="clear: both;">
	
	
	
	 <div id="divtipoturismo" style="float: left;">
	   <fieldset class="row" style="width: 200px">
			<legend>Tipo Turismo</legend>
			<div class="checkboxes" >
			<s:set var="i" value="0" />
				<s:iterator status="st" value="listaTipoturismo" >
					<input name="fichaturismo.listaTipoturismoFichaturismo[${i}].tipoturismo.idtipoturismo" 
					 class="dom tipoturismo" 
						title="${nombretipoturismo}"  
						type="checkbox" id="tipoturismo_${i}"
						value="${idtipoturismo}"     />
					<label   for="tipoturismo_${i}"  	
						class="checkboxLabel" >${nombretipoturismo}
				    </label>
				  <br>
				  <s:set var="i" value="#i+1" /> 
				</s:iterator>
				
				    
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
	
	
	<div id="divactividadturismo">

        <s:set var="i" value="0" />
	    <s:iterator value="listaTipoturismo">
	        <div  id='divactividadturismo${idtipoturismo}' style="float:left;width:170px;margin: 0px 10px;padding: 10px">
	        <fieldset   class="row">
			   <legend>Actividades <span class="nomtipoturismo">${nombretipoturismo} </span></legend>
			    
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
			     
			    
		     </fieldset>
	       </div>
	    
	    </s:iterator>
	   <input type="hidden" value='${i}'  id="idultactividad" />
	   
		
	</div>
	
	
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
	
	
	</div>
	
	   
	   
	   
	   
	   <!-- VISITANTES -->
	   
	   	<fieldset style="clear: both;">
			<legend>Datos de los turistas </legend>
			
			
			<div id="paxs" >
			   <span class="msgnumerominimovisitante v_label" style="display:none;" >Ingrese al menos un visitante</span>
			   <s:set var="i"  value="0" />
                   <s:iterator value="visitantes" >
                    
                        <div id="pax"   class="rowvisitante">
					<div class="pax" param='${i}' >
						
						<div class="l index number">
							#${i+1}
						</div>
						<div class="l" >
							<div class="row">
							
							    <input type="hidden" name="visitantes[${i}].idvisitante"   
							          value="${idvisitante}"    />
								<div class="l">
								   <label >
								   Nombres:
								   </label>
								   <input name="visitantes[${i}].nombre" value="${nombre}" 
								   size="16"  class="content valid input"  />

								</div>
								
								<div class="l" >
								  <label>
								   Apellido Pat.
								  </label> 
								  <input  name="visitantes[${i}].apepat" value="${apepat}"   
								     size="14"  class="content input apellidos paterno" />  
								    <div class="valapellidos v_label" style="display: none;position: absolute;">
						              Ingrese al menos un apellido
						            </div>
								</div>
								<div class="l">
								    <label>
								   Apellido Mat.
								  </label> 
								  <input  name="visitantes[${i}].apemat" value="${apemat}"   
								     size="14"  class="content input apellidos materno" />
									 
								</div>
								
								
								<div class="l">
									<label for="fechanacimiento${i}">Fecha de Nac.</label>
									<div class=""> 
										<input name="visitantes[${i}].fnacimiento" id="fechanacimiento${i}" 
										value="${fnacimiento}"  type="text"
											size="9" class="dateDMY valid input fechanacvis" readonly="readonly" title="Fecha" />
									</div>
									
								</div> 
								
								
								<div class="l">
									<s:select list="paises" name='visitantes[%{#i}].pais.idpais'
										listKey="idpais"  
										listValue="nompais"  
										label="Pa�s" 
										value="171" 
										cssClass="pais"
									/>
								</div>
								  
								  
								 <div class="l">
									<label>Sexo</label>		
									 <s:select  
		                               name='visitantes[%{#i}].sexo.idtipo'  headerKey="" 
		                                 headerValue="[Seleccione]" 
		                                list="listaGenero"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="select valid" /> 
									
									
								</div>
								<div class="l">
									<label>Tipo Doc.</label>		
									<s:select  
		                               name='visitantes[%{#i}].tipodocumento.idtipo'  headerKey="" 
		                                 headerValue="[No aplica]" 
		                                list="listaTipoDocumento"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="tipodoc" /> 
								</div>
								
								<div class="right">
									<span class="button">
										<span class="i i_remove"></span>
									</span>
									
								</div>
								 
								 
								  
						
							</div>
						
						
                         <div class="row">
								<div class="l">
								    <label>
								   Numero Doc.
								  </label> 
								  
								  <input  name="visitantes[${i}].numerodocumento" value="${numerodocumento}"   
								     size="16"  class="doc valid v_norequired input"
								     <s:if test="%{tipodocumento.idtipo==0}" >
								       disabled="disabled"
								     </s:if>
								         />  
									
								</div>
						
						<div class="l">
									<label>Tipo de Boleto</label>
								
									<s:if test="%{grupoedad.codigointtipo==1}">
									<!-- adulto -->
									<s:select  
		                               name='visitantes[%{#i}].boletaje.idboletaje'  
		                                 headerValue="Seleccione" 
		                                headerKey="" 
		                                list="listaBoletajemayoredad"
		                                  listKey="idboletaje"
		  								 listValue="%{nombreboletaje+':'+obsboletaje+'S/.'+valorboletaje}" 
		   								theme="simple"
		   								cssClass="select valid cbBoleto"
		  								 /> 
									
									</s:if>
									<s:elseif test="%{grupoedad.codigointtipo==2}">
									<!-- menor -->
									<s:select  
		                               name='visitantes[%{#i}].boletaje.idboletaje'  
		                                 headerValue="Seleccione" 
		                                headerKey="" 
		                                list="listaBoletajemenoredad"
		                                  listKey="idboletaje"
		  								 listValue="%{nombreboletaje+':'+obsboletaje+'S/.'+valorboletaje}" 
		   								theme="simple"
		   								cssClass="select valid cbBoleto"
		  								 /> 
									  
									</s:elseif>
									<s:elseif test="%{grupoedad.codigointtipo==3}" >
									<!-- infante -->
									<s:select  
		                               name='visitantes[%{#i}].boletaje.idboletaje'  
		                                list="listaBoletajeinfante"
		                                  listKey="idboletaje"
		  								 listValue="%{nombreboletaje+':'+obsboletaje+'S/.'+valorboletaje}" 
		   								theme="simple"
		   								cssClass="select valid cbBoleto"
		  								 /> 
									   
									  </s:elseif>
									<s:else>
									
									</s:else>
									
						</div>

                        <s:if test="%{boletaje.idboletaje==0}">
                            <s:if test="%{grupoedad.codigointtipo!=3}">
                                <div class="l divconceptoexoneracion"  >
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name='visitantes[%{#i}].conceptoexoneracionpago.idconceptoexoneracionpago'  
		                                 headerValue="Seleccione" 
		                                headerKey="0" 
		                                list="listaConceptoexonnoinfante"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<div style="display: none;" class="valconcepto v_label">Seleccionar</div>		 
						    </div>
                            </s:if>
                            <s:else>
                              <div class="l divconceptoexoneracion" style="display:none;" >
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name='visitantes[%{#i}].conceptoexoneracionpago.idconceptoexoneracionpago'   
		                                list="listaConceptoexoninfante"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<div style="display: none;" class="valconcepto v_label">Seleccionar</div>		 
						    </div>
                            </s:else>
							
						</s:if>
                        <s:else >
							   <div class="l divconceptoexoneracion" style="display:none;" >
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name='visitantes[%{#i}].conceptoexoneracionpago.idconceptoexoneracionpago'  
		                                 headerValue="Seleccione" 
		                                headerKey="0" 
		                                list="listaConceptoexonnoinfante"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<div style="display: none;" class="valconcepto v_label">Seleccionar</div>		 
						       </div>							
						    
						 </s:else>		
						
								<input type="hidden"   name="visitantes[${i}].conceptoexoneracionpago.flagconceptomenor" 
								class="hdflagconceptomenor" value="0" />
							
							
						</div>
						
						
						
						</div>
					</div>  
				</div>
                    
                  
					 <s:set var="i" value="#i+1" />  
                   </s:iterator>
                     
			<input type="hidden"  id="idultvisitante"  value="${i}" />
			
			
			</div>   
			   
				
				
			<div class="icons">
				<span class="button" id="addpax"> 
					<span class="i i_add"></span> <span>Agregar ingresante</span> 
				</span>
			</div> 
		</fieldset>
	   
	   
	   
	   
	   
	   

	   <div style="text-align: center;clear: both;">
	     <input type="button"  value="Guardar" name="formRegistroFichaTurismoEdit"
			id="btnGuardarRegFichaTurismo" class="submit" />
			
		<input type="button"  value="Generar Ficha" name="formRegistroFichaTurismoEdit"
			id="btnGenerarFichaTurismo" class="submit btnGenerarFicha"  param="2" />	
	   </div>
	   
	   
	   
	  
	   
</form>



<div id="secFichaDetalle" class="h dom"> 
	<h4>Confirmar Ficha de Registro</h4>
	<div>
		<strong>Fecha de Ingreso:</strong> <span id="lbl_fechaingreso" class="dom"></span>  
		<strong>Modalidad:</strong> <span id="lbl_modalidad" class="dom">Ninguno</span>   
		<strong>Gu&iacute;a(s):</strong> <span id="lbl_guia" class="dom">Ninguno</span>
	</div> 
	<div>
		<strong>Agencia de Viaje:</strong> <span id="lbl_empresaturismo" class="dom">Ninguno</span>
		<strong>Operador Tur&iacute;stico:</strong> <span id="lbl_operadorturismo" class="dom">Ninguno</span>
	</div>
	<div>
		<strong>Ruta Turismo:</strong> <span id="lbl_rutaturismo" class="dom">Ninguno</span>
		<strong>Tipo Turismo:</strong> <span id="lbl_tipoturismo" class="dom">Ninguno</span>
		<strong>Actividades:</strong> <span id="lbl_actividades" class="dom">Ninguna</span>
	</div>
	
	<div id="visitantes"> 
		<table class="display">
			<thead>
				<tr> 
					<th># </th> 
					<th>Apellidos y Nombres</th>
					<th>N�mero Documento</th>
					<th>Nacimiento</th> 
					<th>Pa�s</th> 
					<th>Sexo</th>     
					<th>Boleto</th>  
				</tr>
			</thead>   
			<tbody id="secPreviewVisitantes" class="dom">   
			</tbody>
		</table>
	
	</div> 
</div>

	<!-- Pax div, Cloning with jQuery -->
	<div id="divContpax" class="h">
					<div class="pax">
						
						<div class="l index number">
							#__
							
						</div>
						<input type="hidden" name="visitantes[__].idvisitante"   
							          value="0"    />
						<div class="l" >
							<div class="row">
								<div class="l">
									<s:textfield name="visitantes[__].nombre" label="Nombres" size="16" 
										cssClass="content valid input" />   
								</div>
								
								<div class="l" >
									<s:textfield name="visitantes[__].apepat" label="Apellido Pat." size="14" 
										cssClass="content input apellidos paterno  " />  
								    <div class="valapellidos v_label" style="display: none;position: absolute;">
						              Ingrese al menos un apellido
						            </div>
								</div>
								<div class="l">
									<s:textfield name="visitantes[__].apemat" label="Apellidos Mat." size="14" 
										cssClass="content input apellidos materno  " /> 
								</div>
								
								
								<div class="l">
									<label for="fechanacimiento__">Fecha de Nac.</label>
									<div class=""> 
										<input name="visitantes[__].fnacimiento" id="fechanacimiento__" value=""  type="text"
											size="9" class="dateDMY valid input datepicker fechanacvis" readonly="readonly" title="Fecha" />
									</div>
									
								</div> 
								<div class="l">
									<s:select list="paises" name="visitantes[__].pais.idpais"
										listKey="idpais"  
										listValue="nompais"  
										label="Pa�s" 
										value="%{idpais}" 
										cssClass="pais"
									/>
								</div>  
								<div class="l">
									<label>Sexo</label>		
									 <s:select  
		                               name="visitantes[__].sexo.idtipo"  headerKey="" 
		                                 headerValue="[Seleccione]" 
		                                list="listaGenero"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="select valid" /> 
									
									
								</div>
								<div class="l">
									<label>Tipo Doc.</label>		
									<s:select  
		                               name="visitantes[__].tipodocumento.idtipo"  headerKey="" 
		                                 headerValue="[No aplica]" 
		                                list="listaTipoDocumento"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="tipodoc" /> 
								</div>
								<div class="l">
									<s:textfield name="visitantes[__].numerodocumento" label="N�mero Doc." size="16" 
										  cssClass="doc valid v_norequired input" disabled="true" />  
								</div>
								<div class="right">
									<span class="button">
										<span class="i i_remove"></span>
									</span>
									
								</div>
							</div>
							<div class="row">
								<div class="l">
									<label>Tipo de Boleto</label>
									<select   name="visitantes[__].boletaje.idboletaje" class="select valid cbBoleto">
										<option value="">Seleccione</option>
									</select>
								</div>
								<div class="l divconceptoexoneracion" style="display: none;" >
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name="visitantes[__].conceptoexoneracionpago.idconceptoexoneracionpago"  
		                                 headerValue="Seleccione" 
		                                headerKey="0" 
		                                list="listaConceptoexoneracionpago"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<div style="display: none;" class="valconcepto v_label">Seleccionar</div>		 
								</div>
								<input type="hidden"   name="visitantes[__].conceptoexoneracionpago.flagconceptomenor" class="hdflagconceptomenor" value="0" />
							</div>
						</div>
					</div>  
				</div>
				
		<div id="dialog" title="Basic dialog">
	<p>Grabando...</p>
</div>		
				
