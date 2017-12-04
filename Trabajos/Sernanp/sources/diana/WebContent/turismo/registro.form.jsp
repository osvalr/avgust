<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="js/lib/ajaxupload.js"></script>
<!-- Content -->
<h1>Registro de Visitantes<br /><span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span></h1> 
 
<form name="form_despacho" id="form_despacho" method="post"
	action="">
	
	
	
	<fieldset class="l">
		<legend><strong>PASO 1:</strong> Elija Fecha y Modalidad</legend>
			<div>
			<strong>Fecha de Ingreso:</strong> 
			<input name="fichaturismo.fpropuesta" id="inFechaIngreso" 
				class="dateDMY valid datepicker dom addpreview" size="10" params="lbl_fechaingreso" type="text" />
			</div>  
			<hr />   
			
		 
		
		<input type="hidden" name="fichaturismo.areanatural.idareanatural" 
			value="<s:property value="areanatural.idareanatural" />" />
			<strong>Modalidad de Ingreso:</strong> 
		
		
		<s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal!=0}">
		
		<div class="radios">
			<input id="individual" name="modalidad" value="1" type="radio" class="modalidad dom  addpreview"
				 params="lbl_modalidad" title="Individual" />
			<label for="individual">Individual</label>
			 
				<input id="empresa" name="modalidad" value="2" type="radio" class="modalidad dom  addpreview"
					 params="lbl_modalidad"  title="Agencia de Viaje/Operador Turístico" /> 
				<label for="empresa">Agencia de Viaje/Operador Turístico</label>   
			
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
						label="Operador Turístico" 
						headerKey="0" headerValue="Ninguna"
						id="operadorturismo"
						cssClass="dom  addpreview"   
						params="lbl_operadorturismo"
					/> 
					
				</div>
				<div class="msgemptur v_label" style="display:none" >Seleccione una agencia o un operador </div>
			 </div>
			 <hr />
			 <div id="divGuiaTurismo" >  
			      <strong>Gu&iacute;a(s)</strong>   
			
			      <div style="float: right;">
                     <a  href="#"   id="linkAddGuia" >
                       <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Guías"  />                
                      </a>
                  </div>
            
                 <div id="divListaGuiaTurismo">
            
                 </div>
                 <input type="hidden" value='0'  id="idultguia" />
                 
             </div>
			 
		    
		 
		   
		</s:if>
		<s:else>
		    <s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal==0}">
		         
		        <input  type="hidden" class="addpreview"
					 params="lbl_modalidad"  title="Agencia de Viaje/Operador Turístico" /> 
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
						label="Operador Turístico" 
						headerKey="0" headerValue="Ninguna"
						id="operadorturismo"
						cssClass="dom  addpreview"   
						params="lbl_operadorturismo"
						disabled="true"
					/> 
				</div>
			 </div>
			 <hr />
		     <div id="divGuiaTurismo" >  
			      <strong>Gu&iacute;a(s)</strong>   
			
			      <div style="float: right;">
                     <a  href="#"   id="linkAddGuia" >
                       <img   src="<%=request.getContextPath()%>/img/add.png" title="Agregar Guías"  />                
                      </a>
                  </div>
            
                 <div id="divListaGuiaTurismo">
            
                 </div>
                 <input type="hidden" value='0'  id="idultguia" />
             </div>      
		     </s:if>
		</s:else>
		
		
		 
		
		<div id="divContRowGuia" style="display: none;" >
	            <div id="rowguia_n"  class="rowguia" style="width: 330px">
	            <input  class="idcodguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[_i].idcodigo" />
				<input  class="idguia" type="hidden" name="fichaturismo.listaGuiaFichaturismo[_i].guia.idguia" />
    			<input   class="nomcompguia upperlbl"     type="text" size="32"  />
				<span  class="i i_supr" title="eliminar" ></span>
				<span class="msgguia v_label" style="display:none;" >Seleccione un guía</span>
				</div>
         </div>
		
		
		
	</fieldset> 
	
	
	
	
	
	
	
	
	
	
	
	<div   id="step2" 
	
	<s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal!=0}">
	   class="block l"
	</s:if>
		<s:else>
		    <s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal==0}">
		        class="l"
		     </s:if>
		</s:else>
	
	
	
	> 
			<div class="overlay opaque"></div>
		<fieldset>
				<legend><strong>PASO 2:</strong> Elija su Sector</legend>
				<div class="l">
					<s:select name="fichaturismo.rutaturismo.idrutaturismo" 
						label="Sector Turistico" 
						listKey="idrutaturismo" 
						listValue="nombrerutaturismo"
						headerValue="Seleccione.."
						headerKey=""  
						list="rutas" 
						id="cbRutaturismo"
							cssClass="dom addpreview"   
							params="lbl_rutaturismo" 
						  />  
				</div>
				
				
				
				
				 
		</fieldset> 
	
	
	</div> 
	
	
	<div style="clear: both;">
	
	
	<div id="divtipoturismo" style="float: left;">
	   <fieldset class="row" style="width: 200px">
			<legend>Tipo Turismo</legend>
			<div class="checkboxes" >
			<s:set var="i" value="0" />
				<s:iterator status="st" value="listaTipoturismo">
					<input name="fichaturismo.listaTipoturismoFichaturismo[<s:property value="#i" />].tipoturismo.idtipoturismo" 
					 class="dom tipoturismo" 
						title="<s:property value='nombretipoturismo'/>"  
						type="checkbox" id="tipoturismo_<s:property value='#i'/>"
						value="<s:property value='idtipoturismo'/>"     />
					<label   for="tipoturismo_<s:property value='#i'/>"  
						class="checkboxLabel"><s:property value='nombretipoturismo'/></label>
				  <br>
				  <s:set var="i" value="#i+1" /> 
				</s:iterator>
				    
			</div> 
       </fieldset>
	</div>
	
	<input type="hidden" value='0'  id="idultactividad" />
	<div id="divactividadturismo">

	
		
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
	              <input name="fichaturismo.actividades"  class="dom actividades"   
						type="checkbox" id="actividad_i" 
						 params="lbl_actividades"    />
					<label  for="actividad_i"  
						class="checkboxLabel"></label>
				 </span>
				 <br>		
     </div>
	
	
	
	
	
	
	</div>
	
	
	
	
		
	
	
	<div  id="step3" class="row block">
		<fieldset>
			<legend><strong>PASO 3:</strong> Ingrese los datos de los turistas </legend>
			<div id="paxs" >
			   
			
			     <div class="pax"  class="rowvisitante">
						
						<div class="l index number">
							#1
						    
						</div>
						<input type="hidden" name="visitantes[0].idvisitante"   
							          value="0"    />
						<div class="l" >
							<div class="row">
							  
								<div class="l">
									<s:textfield name="visitantes[0].nombre" label="Nombres" size="16" 
										cssClass="content valid input" />   
								</div>
								
								<div class="l" >
									<s:textfield name="visitantes[0].apepat" label="Apellido Pat." size="14" 
										cssClass="content input apellidos paterno  " />  
								    <div class="valapellidos v_label" style="display: none;position: absolute;">
						              Ingrese al menos un apellido
						            </div>
								</div>
								<div class="l">
									<s:textfield name="visitantes[0].apemat" label="Apellidos Mat." size="14" 
										cssClass="content input apellidos materno  " /> 
								</div>
								
								
								<div class="l">
									<label for="fechanacimiento0">Fecha de Nac.</label>
									<div class=""> 
										<input name="visitantes[0].fnacimiento" id="fechanacimiento0" value=""  type="text"
											size="9" class="dateDMY valid input datepicker fechanacvis" readonly="readonly" title="Fecha" />
									</div>
									
								</div> 
								<div class="l">
									<s:select list="paises" name="visitantes[0].pais.idpais"
										listKey="idpais"  
										listValue="nompais"  
										label="País" 
										value="%{idpais}"
										cssClass="pais"
									/>
								</div>  
								<div class="l">
									<label>Sexo</label>		
									 <s:select  
		                               name="visitantes[0].sexo.idtipo"  headerKey="" 
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
		                               name="visitantes[0].tipodocumento.idtipo"  headerKey="" 
		                                 headerValue="[No aplica]" 
		                                list="listaTipoDocumento"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="tipodoc" /> 
								</div>
								<div class="l">
									<s:textfield name="visitantes[0].numerodocumento" label="Número Doc." size="16" 
										  cssClass="doc valid v_norequired input" disabled="true" />  
								</div>
								<div class="right">
									
									
								</div>
							</div>
							<div class="row">
								<div class="l">
									<label>Tipo de Boleto</label>
									<select   name="visitantes[0].boletaje.idboletaje" class="select valid cbBoleto">
										<option value="">Seleccione</option>
									</select>
								</div>
								<div class="l divconceptoexoneracion" style="display: none;" >
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name="visitantes[0].conceptoexoneracionpago.idconceptoexoneracionpago"  
		                                 headerValue="Seleccione" 
		                                headerKey="0" 
		                                list="listaConceptoexoneracionpago"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<div style="display: none;" class="valconcepto v_label">Seleccionar</div>		 
								</div>
								<input type="hidden"   name="visitantes[0].conceptoexoneracionpago.flagconceptomenor" class="hdflagconceptomenor" value="0" />
							</div>
						</div>
						
						
						
					</div> 
			
			<input type="hidden"  id="idultvisitante"  value="1" />
			
			</div>   
			   
				
			<div class="icons">
				<span class="button" id="addpax"> 
					<span class="i i_add"></span> <span>Agregar ingresante</span> 
				</span>
			</div> 
		</fieldset> 
		<div class="overlay opaque"></div>
	</div>
	
	<div class="buttons row" style="text-align: center;clear: both;">
		
		 <input type="button"  value="Guardar" name="form_despacho"
			id="btnGuardarRegFichaTurismo" class="submit" />
			
		<input type="button"  value="Generar Ficha" name="form_despacho"
			id="btnGenerarFichaTurismo" class="submit btnGenerarFicha" param="1" />	
			
				
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
					<th>Número Documento</th>
					<th>Nacimiento</th> 
					<th>País</th> 
					<th>Sexo</th>     
					<th>Boleto</th>  
				</tr>
			</thead>   
			<tbody id="secPreviewVisitantes" class="dom">   
			</tbody>
		</table>
	
	</div> 
</div>


<form name="formVistaFicha" id="formVistaFicha" method="post">
<input type="hidden" name="ficha" id="idfichaturismo" />

</form>



<!-- Pax div, Cloning with jQuery -->
				<div  id="divContpax" class="h">
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
										label="País" 
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
									<s:textfield name="visitantes[__].numerodocumento" label="Número Doc." size="16" 
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
<!-- End Content -->
