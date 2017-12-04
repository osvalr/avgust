<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Content -->
<h1>Aprobaci&oacute;n de Formulario de Ingreso<br /><span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span></h1> 


<form id="formularioFichaAprob" method="post" >

<s:hidden name="ficharegistro.idficharegistro" id="idficharegistro" />
<s:hidden name="ficharegistro.codigoficha" />

<s:date name="ficharegistro.fechacreacion" format="yyyy-MM-dd HH:mm:ss.SSS" var="formattedVal"/>
<s:hidden name="ficharegistro.fechacreacion" value="%{#formattedVal}" />

<div class="divCodF">
<b>C&oacute;digo Ficha:&nbsp;</b><s:property value="ficharegistro.codigoficha" />
</div>
<div class="clear"></div>
	<fieldset>
		<legend><strong>Datos de la Empresa:</strong></legend>
		<div class="l">
			<div>
				<label class="de_1">Raz&oacute;n Social:</label>
				<s:textfield value="%{personajuridica.nombrepersonajuridica}" size="30" readonly="true"></s:textfield>
			</div>
			<div><label class="de_1">Correo:</label>
			<s:textfield value="%{personajuridica.correoinstitucional}" size="30" readonly="true"></s:textfield>
			</div>
			<div><label class="de_1">Tel&eacute;fono:</label>
			<s:textfield value="%{personajuridica.telefono}" size="15" readonly="true"></s:textfield>
			</div>
			<%--<div><label class="de_1">RUC:</label> 
			<s:textfield value="%{personajuridica.ruc}" size="25" readonly="true"></s:textfield>
			</div> --%>					
		</div>
		<div class="l dv_2">
			<div>
				<label class="de_3">Lote:</label>
				<s:textfield name="ficharegistro.lote" size="10" readonly="true" />
			</div>	
			<div><label class="de_3 del_3">Nombre del Proyecto:</label>
				<s:textarea name="ficharegistro.nombreproyecto" value="%{ficharegistro.nombreproyecto}" rows="3" cols="40" readonly="true"></s:textarea>
			</div>
		</div>
		<div class="clear"></div>
		
		<div><label class="de_4">Responsable de la Informaci&oacute;n:</label>
				<s:textfield value="%{personanatural.nombre} %{personanatural.apepat} %{personanatural.apemat}" size="40" readonly="true"></s:textfield>
			</div>
		
	</fieldset> 
	
	<fieldset>
		<legend><strong>Medio de Transporte:</strong></legend>
		<div class="l">
				
	<s:iterator value="%{tipomediotra}" id="t1">
	
	<s:set var="check" value="false" />
	
			<s:iterator value="%{tipomediotraedit}" id="t2">			
				<s:if test ="%{#t1.idtipo == #t2.idtipo}"><s:set var="check" value="true" /></s:if>				
			</s:iterator>
			
			<div><s:checkbox name="tipomediotra.idtipo" label="%{nombretipo}" fieldValue="%{idtipo}"  value="#check" disabled="true" />						
			
			</div>
		</s:iterator>
			
		</div>
		<div class="l dv_3">
			<div><label class="de_1">Actividad:</label>
			<s:textfield name="ficharegistro.actividad" value="%{ficharegistro.actividad}" size="50" readonly="true" ></s:textfield>
			</div>
			<div><label class="de_1">Lugar:</label>
			<s:textfield name="ficharegistro.lugar" value="%{ficharegistro.lugar}" size="40" readonly="true" ></s:textfield>
			</div>
		</div>

	</fieldset> 
	
	<fieldset>
		<legend><strong>Personal que Ingresa al ANP:</strong></legend>

<div class="divList">
			
<table id="hor-minimalist-a" summary="Employee Pay Sheet">
    <thead>
    	<tr>
        	<th scope="col">N&deg;</th>
        	<th scope="col">Apellidos y Nombres</th>            
            <th scope="col">Empresa/Inst.</th>
            <th scope="col">Tipo de Doc.</th>
            <th scope="col">N&uacute;mero de Doc.</th>
            <th scope="col">Proced.</th>
            <th scope="col">Genero</th>            
            <th scope="col">Fecha de Ing.</th>      

    	<tr>
    	
    	</thead>
    	<tbody>
    	
    	<s:iterator status="stat" value="%{personalregistro}">
   	
   		   		    	    	
    	<tr id="IDTR_<s:property value="#stat.count" />">
   	        	<td>   	        	
   	        	<label><s:property value="#stat.count" /></label>
   	        	</td>   	        	
   	        	<td><s:property value="apepat" />&nbsp;<s:property value="apemat" />,&nbsp;<s:property value="nombre" /></td>
   	        	<td><s:property value="empresa" /></td><td><s:property value="%{tipos[tipodocumento.idtabla + '' + tipodocumento.idtipo]}" /></td>   	        	
   	        	<td><s:property value="numerodocumento" /></td><td><s:property value="%{tipos[tipolocal.idtabla + '' + tipolocal.idtipo]}" /></td>
   	        	<td><s:property value="%{tipos[sexo.idtabla + '' + sexo.idtipo]}" /></td>
   	        	<td><s:property value="fechaingreso" /></td>

   	    </tr>

   	    </s:iterator>    	
    	        
    </tbody>
</table>	


</div>
		
		
	</fieldset>
	
	<fieldset>		
		
		<div class="coment">
		<div class="c1">Comentario:</div>
			<div><s:textarea name="ficharegistro.comentario" cols="2" cssStyle="width: 400px;" readonly="true"></s:textarea></div>			
		</div>
</fieldset>
	
	<br>
		
	<div class="divBtnEnviar">
	<s:if test="%{ficharegistro.idestadoficha == 1}">
		<input type="button" value="Aprobar !" class="submit" id="btnAprobarFicha" />
		<input type="button" value="Desaprobar !" class="submit4" id="btnDesAprobarFicha" />
	</s:if>
	<s:elseif test="%{ficharegistro.idestadoficha == 2}">
		<input type="button" value="Aprobado !" class="submit3" />
	</s:elseif>
	
	</div>
	
	<br><br>
	
</form>

<div id="divModalDesAprobFicha"></div>

<div id="dialog-message" title="Confirmación de Aprobación" style="display: none;">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		¿Realmente desea aprobar el formulario?
	</p>
	
</div>