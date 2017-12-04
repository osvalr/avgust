<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<script>
	$(function() {
		//$( "#datepicker" ).datepicker({minDate: new Date('<x%=request.getAttribute("fechaactual")%>')});
		$( "#idAddp" ).live('click',muestraCamposAdd);

		fechaServer = '<%=request.getAttribute("fechaactual")%>';
		$( ".datepicker" ).datepicker({minDate: new Date(fechaServer)});

		$(".timepicker").timepicker();

		$(".checkformConsolid").change(function() {
			if( ! $(this).is(':checked') ){            	                    
               $(this).parent().parent().children().css({'color':'#ff3233'});
               $(this).parent().parent().find(':input') // Find all the input elements under those.
               .each(function(i) {
                   //alert(this.name + " = " + i);
                   $(this).removeClass('valid');
               });

               $(this).parent().parent().children().removeClass('valid');
               
			}else{
				$(this).parent().parent().children().css({'color':'#333'});
				$(this).parent().parent().find(':input') // Find all the input elements under those.
	               .each(function(i) {
	                   //alert(this.className + " = " + i);
	            	   if(i > 1 && i<5)
	            	   this.className = this.className+" valid";
	               });
			}
        });
		
	});


</script>

<!-- Content -->
<h1>Consolidar Formulario de Ingreso<br /><span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span></h1> 

<div class="clear"></div>

<form id="formularioFichaConsolid" method="post" >

<%--
<s:hidden name="ficharegistro.idficharegistro" />
<s:hidden name="ficharegistro.codigoficha" />
<s:date name="ficharegistro.fechacreacion" format="yyyy-MM-dd HH:mm:ss.SSS" var="formattedVal"/>
<s:hidden name="ficharegistro.fechacreacion" value="%{#formattedVal}" />
 --%>


<div class="divCodF">
<b>C&oacute;digo Ficha:&nbsp;</b><s:property value="ficharegistro.codigoficha" />
</div>

<br>
	<fieldset>
		<legend><strong>Datos de la Empresa:</strong></legend>
		<div class="l h">
			<div>
				<label class="de_1">Raz&oacute;n Social:</label>
				<s:textfield value="%{personajuridica.nombrepersonajuridica}" size="30" readonly="true"></s:textfield>
			</div>
			<div><label class="de_1">Correo:</label>
			<s:textfield value="%{personajuridica.correoinstitucional}" size="30" readonly="true"></s:textfield>
			</div>
			<div><label class="de_1">Tel&eacute;fono:</label>
			<s:textfield value="%{personajuridica.telefono}" size="25" readonly="true"></s:textfield>
			</div>
			<%--<div><label class="de_1">RUC:</label> 
			<s:textfield value="%{personajuridica.ruc}" size="25" readonly="true"></s:textfield>
			</div>--%>		
		</div>
		<div class="l dv_2 h">
			<div>
				<label class="de_3">Lote:</label>
				<s:textfield name="ficharegistro.lote" size="10" cssClass ="content valid" readonly="true" />
			</div>			
			<div><label class="de_3 del_3">Nombre del Proyecto:</label>
				<s:textarea name="ficharegistro.nombreproyecto" value="%{ficharegistro.nombreproyecto}" rows="3" cols="40" readonly="true"></s:textarea>
			</div>
		</div>
		<div class="h"><label class="de_4">Responsable de la Informaci&oacute;n:</label>
				<s:textfield value="%{personanatural.nombre} %{personanatural.apepat} %{personanatural.apemat}" size="40" readonly="true"></s:textfield>
			</div>
		
		<div class="right" style="margin-top: -25px;"><img alt="" src="img/file_down.png" onclick="javascript:mostrarDetalle(this);"/></div>		
	</fieldset>	

	<fieldset>
		<legend><strong>Medio de Transporte:</strong></legend>
		<div class="l h">
				
	<s:iterator value="%{tipomediotra}" id="t1">
	
	<s:set var="check" value="false" />
	
			<s:iterator value="%{tipomediotraedit}" id="t2">			
				<s:if test ="%{#t1.idtipo == #t2.idtipo}"><s:set var="check" value="true" /></s:if>				
			</s:iterator>
			
			<div><s:checkbox name="tipomediotra.idtipo" label="%{nombretipo}" fieldValue="%{idtipo}"  value="#check" disabled="true" />						
			
			</div>
		</s:iterator>
			
		</div>
		<div class="l dv_3 h">
			<div><label class="de_1">Actividad:</label>
			<s:textfield name="ficharegistro.actividad" value="%{ficharegistro.actividad}" size="40" readonly="true" ></s:textfield>
			</div>
			<div><label class="de_1">Lugar:</label>
			<s:textfield name="ficharegistro.lugar" value="%{ficharegistro.lugar}" size="40" readonly="true" ></s:textfield>
			</div>
		</div>
<div class="right" style="margin-top: -25px;"><img alt="" src="img/file_down.png" onclick="javascript:mostrarDetalle(this);" /></div>

	</fieldset> 
	
	<fieldset>
		<legend><strong>Personal que Ingresa al ANP:</strong></legend>

<div class="divList">
			
<table id="hor-minimalist-a" summary="Employee Pay Sheet">
    <thead>
    	<tr>
        	<th scope="col">N&deg;</th>
        	<th scope="col">Apellidos y Nombres</th>            
            <th scope="col">Emp./Inst.</th>
            <th scope="col">Tip. Doc.</th>
            <th scope="col">N&uacute;mero Doc.</th>
            <th scope="col">Proced.</th>
            <th scope="col">Gen.</th>            
            <th scope="col">Fec. Ing.</th> 
            <th scope="col">H.I.</th>
            <th scope="col">Fec. Sal.</th> 
            <th scope="col">H.S.</th>
            <th scope="col"></th>

    	<tr>
    	
    	</thead>
    	<tbody>
    	
    	<s:iterator status="stat" value="%{personalregistro}">
   	
   	<s:if test="%{idestado == 0}">
<s:set name="color" value="%{'#ff3233'}"/>
</s:if>
<s:else>
<s:set name="color" value="%{'#333'}"/>
</s:else>
   		   		    	    	
    	<tr>
   	        	<td style="color: <s:property value="#color" />">   	        	
   	        	<s:property value="#stat.count" />
   	        	<s:hidden name="listapersonalficharegistro[%{#stat.count - 1}].idficharegistro" value="%{ficharegistro.idficharegistro}" />
   	        	<s:hidden name="listapersonalficharegistro[%{#stat.count - 1}].idpersonalregistro" value="%{idpersonalregistro}" />
   	        	</td>	
   	        	<td style="color: <s:property value="#color" />"><s:property value="apepat" />&nbsp;<s:property value="apemat" />,&nbsp;<s:property value="nombre" /></td>
   	        	<td style="color: <s:property value="#color" />"><s:property value="empresa" /></td>
   	        	<td style="color: <s:property value="#color" />"><s:property value="%{tipos[tipodocumento.idtabla + '' + tipodocumento.idtipo]}" /></td>   	        	
   	        	<td style="color: <s:property value="#color" />"><s:property value="numerodocumento" /></td>
   	        	<td style="color: <s:property value="#color" />"><s:property value="%{tipos[tipolocal.idtabla + '' + tipolocal.idtipo]}" /></td>
   	        	<td style="color: <s:property value="#color" />"><s:property value="%{tipos[sexo.idtabla + '' + sexo.idtipo]}" /></td>
   	        	<td style="color: <s:property value="#color" />"><s:property value="fechaingreso" /></td>
   	        	
   	        	<s:if test="%{ficharegistro.idestadoficha == 3}">
   	        	
   	        	
   	        	
   	        	
   	        	<td><s:property value="horaingreso" /></td>
   	        	<td><s:property value="fechasalida" /></td>
   	        	<td><s:property value="horasalida" /></td>
   	        	<td>
   	        	<s:if test="%{idestado == 1}"><input type="checkbox" checked="checked" disabled="disabled"  /></s:if>
   	        	<s:else><input type="checkbox" disabled="disabled" /></s:else>
   	        	</td>
   	        	</s:if>
   	        	<s:else>   	        	
   	        	<td>   	        	
   	        	<input type="text" name="listapersonalficharegistro[<s:property value="%{#stat.count - 1}" />].horaingreso" style="width: 40px;"  value="<s:property value="horaingreso" />" class="content valid timepicker" readonly="readonly" />
   	        	</td>
   	        	<td>
   	        	<input type="text" name="listapersonalficharegistro[<s:property value="%{#stat.count - 1}" />].fechasalida" value="<s:property value="fechasalida" />" size="10" class="dateDMY_ valid datepicker" readonly="readonly" /></td>   	        	
   	        	<td>
   	        	<input type="text" name="listapersonalficharegistro[<s:property value="%{#stat.count - 1}" />].horasalida" value="<s:property value="horasalida" />" style="width: 40px;" value="" class="content valid timepicker" readonly="readonly" />
   	        	</td>
				<td>
				<input type="checkbox" name="listapersonalficharegistro[<s:property value="%{#stat.count - 1}" />].idestado" value="1" checked="checked" class="checkformConsolid" />
				</td>
				</s:else>
   	    </tr>

   	    </s:iterator>    	
    	        
    </tbody>
</table>	


</div>
		
		
	</fieldset>
	<br>
		
	<div class="divBtnEnviar">
	<s:if test="%{ficharegistro.idestadoficha == 2}">
		<input type="button" value="Consolidar !" class="submit" id="btnConsolidarFicha" />
	</s:if>
	<s:elseif test="%{ficharegistro.idestadoficha == 3}">
		<input type="button" value="Consolidado !" class="submit3" />
	</s:elseif>
	
	</div>
	
	<br><br>
	
</form>

<div id="dialog-message" title="Confirmación de Aprobación" style="display: none;">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		¿Realmente desea aprobar el formulario?
	</p>
	
</div>