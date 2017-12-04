<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@page  contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%> 



<div class="divRegistro">

<div class="divCabecera">
REGISTRO VISITANTE
</div>


<div class="divContenido">
<fieldset class="regmarco">


<input  class="idvisitante" type="hidden" name="visitante.idvisitante" value="${visitante.idvisitante}"  />

<span class="creg">
<label>Nombres</label>
<input type="text" size="16" class="content valid input nombre" name="visitante.nombre" value="${visitante.nombre}" />
</span>

<span class="creg">
<label>Ap. Paterno</label>
<input type="text" size="14" class="content input apellidos paterno" name="visitante.apepat" value="${visitante.apepat}"/>
<br/>
<span class="valapellidos v_label" style="display: none;">
						              <s:property value="getText('msgvalapellidos')" />
						            </span>
</span>


<span class="creg">
<label>Ap. Materno</label>
<input type="text" size="14" class="apellidos materno" name="visitante.apemat" value="${visitante.apemat}" />
</span>

<span class="creg">
<label>G&eacute;nero</label>		
<s:select  name="visitante.sexo.idtipo"  headerKey="" 
		                                 headerValue="[Seleccione]" 
		                                list="listaGenero"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		   								cssStyle="width:70px"
		  								 cssClass="select valid genero"  /> 	
</span>

<span class="creg">
<label>Ocupaci&oacute;n</label>
<s:select list="listaTipoocupacion" name="visitante.tipoocupacion.idtipo"
										headerKey=""
										headerValue="Seleccione"
										listKey="idtipo"  
										listValue="nombretipo"   
										cssClass="select valid"
										cssStyle="width:70px"
                                         theme="simple" />
</span>


</fieldset>


<fieldset class="regmarco">

<span class="creg">
<label>Pa&iacute;s</label>
<s:select list="paises" name="visitante.pais.idpais"
										listKey="idpais"  
										listValue="nompais"  
										label="País" 
										cssClass="pais"
                                         theme="simple" />
</span>

<span class="creg">
<label>Tipo Doc.</label>		
									<s:select  
		                               name="visitante.tipodocumento.idtipo"  headerKey="" 
		                                 headerValue="[NO APLICA]" 
		                                list="listaTipoDocumento"
		                                  listKey="idtipo"
		  								 listValue="abrevtipo" 
		   								theme="simple"
		  								 cssClass="tipodoc" /> 
</span>
<span class="creg">
<label>Num Doc</label>
<input type="text" size="16" class="doc valid v_norequired input numdoc" name="visitante.numerodocumento"
<s:if test="%{visitante.tipodocumento.idtipo==0}" >
								       disabled="disabled"
</s:if> 
   value="${visitante.numerodocumento}" /> 
</span>

<span class="creg">
<label>F. Nacimiento</label>
<input type="text" size="10" class="dateDMY valid input fechanacvis fnacimiento" name="visitante.fnacimiento"  
  value="${visitante.fnacimiento}"   readonly="readonly" />
</span>

</fieldset>







<fieldset class="regmarco">



<span class="creg">
<label>Tipo de Boleto</label>

<!-- CREAR -->
<s:if test="%{visitante.idvisitante==0 }">
     <select   name="visitante.boletaje.idboletaje" class="select valid cbBoleto"
         >
										<option value="">Seleccione</option>
    </select>
</s:if>
<!-- EDITAR -->
<s:else>
    
     <s:select  
		  name='visitante.boletaje.idboletaje'  
		  headerValue="Seleccione" 
		  headerKey="" 
		  list="listaBoletaje"
		  listKey="idboletaje"
          listValue="%{nombreboletaje+':'+obsboletaje+'S/.'+valorboletaje}" 
		  theme="simple"
		  cssClass="select valid cbBoleto"
		  cssStyle="width:200px"
	 /> 		
    
   
</s:else>



									
</span>



<!-- CREAR -->
<s:if test="%{visitante.idvisitante==0 }">

<span    class="creg divconceptoexoneracion" style="display:none">
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name='visitante.conceptoexoneracionpago.idconceptoexoneracionpago'  
		                                 headerValue="Seleccione" 
		                                headerKey="0" 
		                                list="listaConceptoexonnoinfante"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<span style="display: none;" class="valconcepto v_label">Seleccionar</span>		 
</span>
						       
</s:if>	
<!-- EDITAR -->					       
<s:else>

        <s:if test="%{visitante.boletaje.idboletaje==0}">
                            <s:if test="%{visitante.grupoedad.codigointtipo!=constantes.CODIGO_GRUPO_EDAD_INFANTE}">
                              <span    class="creg divconceptoexoneracion" >
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name='visitante.conceptoexoneracionpago.idconceptoexoneracionpago'  
		                                 headerValue="Seleccione" 
		                                headerKey="0" 
		                                list="listaConceptoexonnoinfante"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<span style="display: none;" class="valconcepto v_label">Seleccionar</span>		 
						    </span>
                            </s:if>
                            <s:else>
                             <span    class="creg divconceptoexoneracion" style="display:none">
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name='visitante.conceptoexoneracionpago.idconceptoexoneracionpago'   
		                                list="listaConceptoexoninfante"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<span style="display: none;" class="valconcepto v_label">Seleccionar</span>		 
						    </span>
                            </s:else>
							
</s:if>
 <s:else >
							   <span    class="creg divconceptoexoneracion" style="display:none">
									<label>Concepto Exoneraci&oacute;n:</label>
								<s:select  
		                               name='visitante.conceptoexoneracionpago.idconceptoexoneracionpago'  
		                                 headerValue="Seleccione" 
		                                headerKey="0" 
		                                list="listaConceptoexonnoinfante"
		                                  listKey="idconceptoexoneracionpago"
		  								 listValue="desconceptoexoneracionpago" 
		   								theme="simple"
		  								 cssClass="cboconcepto" /> 
		  						<span style="display: none;" class="valconcepto v_label">Seleccionar</span>		 
						       </span>							
						    
</s:else>

</s:else>						       
<span class="creg">
<label>Motivo Visita</label>
<s:select list="listaMotivovisita" name="visitante.motivovisita.idtipo"
										listKey="idtipo"  
										listValue="nombretipo"   
										cssClass="select valid"
                                         theme="simple" />
</span>

</fieldset>
  		
  		
 <div style="text-align: center;">
  <input type="button"  value="Guardar" class="submit"  id="btnGuardarRegVisitante"  />
<input type="button"  value="Cancelar" class="submit opcionaccion" name="4"   /> 
 </div>								 
		  								 
		  								 

</div>
</div>







<div class="divEspera" style="display: none;text-align: center;">
 <h2 >Guardando </h2><br/>
 <img src='css/loading.gif'  />
</div>



<table id="tabContRowVisitante" class="ttur" style="display: none;">
<!--<col class="c1" />-->

<tbody class="bodyContRowVisitante">  
<tr   class="rowtab" >
<td >
  <input type="hidden" class="flagcompleto" value="1"   />
  <input name="listaCodigo" class="chkbox" type="checkbox"  />
</td>
<td> <span class="num"></span></td>
<td class="colleft"> <span class="apepat"></span> </td>
<td class="colleft"> <span class="apemat"></span> </td>
<td class="colleft"> <span class="nombre"></span> </td>
<td > <span class="fnacimiento"></span> </td>
<td > <span class="pais"></span> </td>
<td > <span class="genero"></span> </td>
<td > <span class="tipodoc"></span> </td>
<td > <span class="numdoc"></span> </td>
<td  class="colleft"> <span class="cbBoleto"></span> </td>
</tr>
</tbody>
</table>
		  								 								
									
									