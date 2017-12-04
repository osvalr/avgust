<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@page  contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%> 

<!--<link rel="stylesheet" type="text/css" media="print" href="css/turismo.css" />  -->


<div class="divRegistro">

<div class="divCabecera">
LISTADO VISITANTES
</div>
		
<div class="divContenido">
<div id="divListaVisitante">	
	<form id="formListaVisitante">	
		

<span class="msgnumerominimovisitante msg" > <s:property value="getText('msgnumerominimovisitante')" /> </span>	   
<span class="msgcompletovisitante msg"  > <s:property value="getText('msgcompletovisitante')" /></span> 	
 <span class="msgdatosficha msg" >  <s:property value="getText('msgdatosficha')" /> </span>	
 <span class="msgeliminavis msg" > <s:property value="getText('msgeliminavis')" /> </span>	 
 <span class="msgguardafichvis msg" > <s:property value="getText('msgguardafichvis')" /> </span>
 
 		
<div class="divbtn" style="float: left;">
<input type="button"  name="1"  id="btnRegVisitante" value="Nuevo" class="btntur10 opcionaccion"  />
<input type="button"  name="2"   value="Editar" class="btntur10 opcionaccion"   />
<input type="button"  name="3"   value="Eliminar" class="btntur10 opcionaccion"   />
</div>	

<s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP}">
<div style="float: right;">

<fieldset class="regmarco" style="padding: 3px 0px">

<span class="creg">
<label>Modalidad Pago:</label>

<s:select  cssClass="select valid idmodalidadpagoft"
	           name="fichaturismo.listaPagoFichaturismo[0].modalidadpago.codigointtipo"
	           list="listaModalidadpago"
			   listKey="codigointtipo"
			   listValue="nombretipo" 
			   theme="simple" />
</span>
<span class="creg">
<label>N°Voucher/Recibo:</label>
<input  class="numvoucher" type="text"  size="15" name="fichaturismo.listaPagoFichaturismo[0].numvoucher" />
</span>

</fieldset>


</div>




</s:if>
 <br style="clear: both;"/>
<br>



<div  id="divScrollListaVisitante">
   <table  id="tabListaVisitante" class="ttur">
 <thead>
   <tr >
       <th ></th>
       <th >N</th>
       <th >Apellido Paterno</th>
       <th >Apellido Materno</th>
       <th >Nombres</th>
       <th >Fecha Nacimiento</th>
       <th >Pa&iacute;s</th>
       <th >G&eacute;nero</th>
       <th >Tipo Doc</th>
       <th >Num Doc</th>
       <th >Tipo Boleto</th>
       
   </tr>
 </thead>
   <tbody>
      <s:set var="i" value="0" /> 
        <s:iterator value="listaVisitante">
           <tr   class='rowtab
           <s:if test="%{#i%2==0}" >
           odd
           </s:if>
           <s:else>
           even
           </s:else>
           ' 
           
           > 
           <td>
            <input type="hidden" class="flagcompleto" value="${flagcompleto}"   />
            <input name="listaCodigo" class="chkbox" type="checkbox" value="${idvisitante}" /></td>
           <td> <span class="num">${i+1}</span> </td>
           <td class="colleft"><span class="apepat">${apepat}</span> </td>
           <td class="colleft" > <span class="apemat">${apemat}</span> </td>
           <td class="colleft"> <span class="nombre">${nombre}</span>  </td>
           <td> <span class="fnacimiento"><s:date format="dd-MM-yyyy" name="fechanacimiento" /></span> </td>
           <td> <span class="pais">${pais.nompais}</span></td>
           <td> <span class="genero">${sexo.abrevtipo}</span> </td>
           <td> 
           <span class="tipodoc">
           <s:if test="%{tipodocumento.idtipo==0}">
            NO APLICA  
           </s:if>
           <s:else>
           ${tipodocumento.abrevtipo}
           </s:else>
           </span>
            </td>
           <td> 
           <span class="numdoc">
           <s:if test="%{tipodocumento.idtipo==0}">
            ----- 
           </s:if>
           <s:else>
           ${numerodocumento}
           </s:else>
           </span>
            </td>
           <td class="colleft"> 
           <span class="cbBoleto">
           <s:if test="%{boletaje.idboletaje==0}">
             NO APLICA
           </s:if>
           <s:else>
           ${boletaje.nombreboletaje}:
           ${boletaje.obsboletaje} S/. ${boletaje.valorboletaje}
           </s:else>
           </span>
           
            </td>
           </tr>
           <s:set var="i" value="#i+1" />
         </s:iterator>
   </tbody>                     
</table>	
</div>
	 </form>		
 
</div>
 <div id="divBotones" style="text-align:center;margin:5px 0px">
 
 <s:if  test="%{#session.idtiporegistro==constantes.TIPO_REGISTRO_CREAR}">
		 <input type="button"  value="Volver" name="consultafichaturismo.action"
			 class="submit btnSalirReg"   />
<!--           <input type="button"  value="Guardar" name="tabsRegFichaTurismo"-->
<!--			id="btnGuardarRegFichaTurismo" class="submit btnAccionFichaTurismo"   param="1" />-->
			
         </s:if>
  		 <s:elseif test="%{#session.idtiporegistro==constantes.TIPO_REGISTRO_EDITAR}">
  			   <input type="button"  value="Volver" name="consultafichaturismo.action"
			 class="submit btnSalirReg"   />
  		 </s:elseif>
  		  <input type="button"  value="Generar Ficha" name="formRegistroFichaTurismo"
			id="btnGenerarFichaTurismo" class="submit btnGenerarFicha btnAccionFichaTurismo"  param="2" />
  		 <s:if  test="%{#session.idtiporol==constantes.TIPO_ROL_ADMINISTRADOR_SEDE_ANP}">
  		   <input type="button"  value="Consolidar Ficha" name="formRegistroFichaTurismo"
			 class="submit btnAccionFichaTurismo"  param="5" />
  		 </s:if>
  		 
	    	
 </div>	
	
 </div>
 <!-- END CONTENIDO -->






		
		
		
 
			
 
 


</div> 
 <!-- END REGISTRO -->
 


 <span class="msgguardavis msg" > <s:property value="getText('msgguardavis')" />  </span>


<form id="formRegVisitante">
 <input  class="hdfichaturismo"  type="hidden" name="visitante.fichaturismo.idfichaturismo" 
			value="${fichaturismo.idfichaturismo}"  />
 
 <div id="divModalRegVisitante"  class="divmarco" >

</div>
</form>

	





