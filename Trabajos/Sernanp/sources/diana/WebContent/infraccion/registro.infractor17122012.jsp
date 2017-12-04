<!-- 

Se agrego estos registros a las tablas JCEV 22-08-2012

Tabla
=====
insert into sernanp.Tabla(idtabla,destabla) values(24,'Tipo de Persona');

TablaTipo
=========
insert into sernanp.Tablatipo(idtablatipo,ordtablatipo,destablatipo,abrtablatipo,idtabla) 
values(90, 1, 'Persona Natural', 'PN', 24);
insert into sernanp.Tablatipo(idtablatipo,ordtablatipo,destablatipo,abrtablatipo,idtabla) 
values(91, 2, 'Persona Juridica', 'PJ', 24);

Se modifico en la Tabla infractor el campo idpersonanatural por IdPersona y se agrego la columna TipoPersona,
el cual contendra la informacion de la TablaTipo

select *
from sernanp.infractor;

1. PN : Persona Natural
2. PJ : Persona Juridica

-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>  

<h1>Registro de Infractor</h1>

<form id="formularioInfractor" enctype="multipart/form-data" method="post" >

	<fieldset class="fieldSetDG">	
		<legend><strong>Datos generales</strong></legend>
		<div class="l">
			<label>Tipo Documento</label>
			<select id="tipoDocumento" name="expediente.infractor.tipodocumento.idtipo"
				onchange="javascript:valorSeleccionado('tipoDocumento');clearTextbox();">
				<option value="1" selected="selected">DNI</option>
				<option value="2">CE</option>
				<option value="3">PASAPORTE</option>
				<option value="4">RUC</option>
			</select>	
		</div>		
		<div class="l">
			<label>N&uacute;mero de documento </label>
			<s:textfield cssClass="doc valid onlydigits"  theme="simple" 
			             name="expediente.infractor.numerodocumento" id="paramNumeroDocumento"   						
   						 onblur="javascript:controlReincidencia();"
			             maxlength="8" size="12" />
		</div>		
		<div class="clear"></div>
						
		<div id="divPersona">						
			<div class="l" id="frmRazonSocial" style="display: none;" >
				<label>Raz&oacute;n Social </label>
				<s:textfield name="expediente.infractor.empresa" id="paramRazSocial"  
				             theme="simple"
				             cssStyle="text-transform:uppercase;" 
   						     size="40" />
   						     <!-- cssClass="content valid" -->

			</div>
			<div class="l" id="frmApePat" >
				<label>Apellido Paterno </label>
				<s:textfield name="expediente.infractor.apepat" id="paramApePat"
				             onkeypress="soloLetras(event)"  
				             cssClass="content valid" theme="simple"
				             cssStyle="text-transform:uppercase;"/> 
			</div>				
			<div class="l" id="frmApeMat" >
				<label>Apellido Materno </label>
				<s:textfield  type ="text" name="expediente.infractor.apemat" id="paramApeMat"  
				              onkeypress="soloLetras(event)"  
				              cssClass="content valid" theme="simple" 
				              cssStyle="text-transform:uppercase;" 
				              onblur="this.value.toUpperCase()"/>
			</div>						
			<div class="l" id="frmNombre" >
				<label>Nombres </label>
				<s:textfield  type ="text" name="expediente.infractor.nombre" id="paramNombre"  
				              onkeypress="soloLetras(event)"  
				              cssClass="content valid" theme="simple" 
				              cssStyle="text-transform:uppercase;" 
				              onblur="this.value.toUpperCase()"  />
			</div>
		</div>		
		<div class="clear"></div>	
	</fieldset>
	<div class="clear"></div>	
	<fieldset>
		<legend><strong>Infracciones</strong></legend>		
		<div>			
			<div  id="totalInfracciones" >
		    <!-- aqui se llenan todas las infracciones -->				
		</div>
		<div class="clear"></div>
		
		<div id="divLinkInfra" >	
			<input type="button" class="btnInfraDisabled" value="Agregar" id="BotonAdd" />	
		</div>
		</div>	
	</fieldset>
	
	<div class="clear"></div>
	
	<fieldset class="fieldSetSanc">
		<legend><strong>Sanciones</strong></legend>		
		<div>
				<label>Elija una Sanci&oacute;n</label>
				<s:select list="listaSanciones" cssClass="select valid tipoBusquedaSancion" id="listaSanciones"
						listKey="idsancion"  listValue="descripcionsancion"
			  			headerKey="-1" theme="simple"
			 			headerValue="------ Seleccione una Sancion------" 
 			 			name="selectSancion" onchange="javascript:agregarSancion(event);"
			 			/>	
		</div> 			
		<div>
			<table id="hor-minimalist-a" summary="Employee Pay Sheet" class="tabla_Table">
			    <thead>
			    	<tr>
<!-- 			        	<th scope="col" width="20px;">N&deg;</th> -->
			        	<th scope="col">Nombre&nbsp;Sanci&oacute;n</th>            
			            <th scope="col">Campo</th>
			            <th scope="col">Comentario</th>
			            <th scope="col">Acci&oacute;n</th>			            
			    	<tr>
		    	</thead>
		    	<tbody style="font-size-adjust: inherit;" id="Detail_Table">    	
			    	        
			    </tbody>
			</table>
		</div>
						
	</fieldset>
	
	<div class="clear"></div>
	
	<fieldset id="Infracciones"  class="fieldSetDG" >
	
	<legend>Resoluci&oacute;n</legend>
		<div class="l">
			<label>N° de Resoluci&oacute;n</label>
			<s:textfield theme="simple"  id="paramResolucion" 
			             name="expediente.resolucion.numeroresolucion" size="40"   
			             cssClass="content valid"/>
		</div>
		<div class="l">
 			<label>F. Resoluci&oacute;n</label> 
			<s:textfield theme="simple"  name="expediente.resolucion.fecharesolucion"  
			             id="fechaResolucion__" size="9" cssClass="dateDMY_ input valid datepicker" 
			             readonly="true" />
		</div>
		<div class="l">
			<label>Adjuntar Archivo</label>
<!-- 			<input type="file" name="file" id="archivoAdjunto" size="25" />			 -->
			<s:textfield type="file" name="file" id="archivoAdjunto" size="25" cssClass="input valid"/>			
		</div>
		<div class="l">				
			<label>F. Notificaci&oacute;n</label>
			<s:textfield theme="simple"  name="expediente.resolucion.fechanotificacion"  
			             id="fechaNotifResolucion__" size="9" cssClass="dateDMY_ input valid datepicker" 
			             readonly="true" />
		</div>
		<div class="clear" ></div>
	</fieldset>

	<div class="clear" ></div>	
	
	<div class="campo">
		<input type="button" value="Registrar !" class="submit" onclick="javascript:enviarFormulario();" />
	</div>
	
	<div class="clear" ></div>
	
	<input type="hidden" id="idInfractorAyuda" name ="idInfractorAyuda" value="00"/>
	<input type="hidden" id="idPersonaNatural" name ="idPersonaNatural" value="0"/>
			
</form>

<!-- en este modal se listaran las infracciones -->
<div id="muestraInfracciones" title="Lista de Infracciones" style="display:none;overflow: auto;"></div>


<!-- ESTE ES LOS CAMBIOS QUE REALICE 17-10-2012 -->
<!-- 

Se agrego estos registros a las tablas JCEV 22-08-2012

Tabla
=====
insert into sernanp.Tabla(idtabla,destabla) values(24,'Tipo de Persona');

TablaTipo
=========
insert into sernanp.Tablatipo(idtablatipo,ordtablatipo,destablatipo,abrtablatipo,idtabla) 
values(90, 1, 'Persona Natural', 'PN', 24);
insert into sernanp.Tablatipo(idtablatipo,ordtablatipo,destablatipo,abrtablatipo,idtabla) 
values(91, 2, 'Persona Juridica', 'PJ', 24);

Se modifico en la Tabla infractor el campo idpersonanatural por IdPersona y se agrego la columna TipoPersona,
el cual contendra la informacion de la TablaTipo

select *
from sernanp.infractor;

1. PN : Persona Natural
2. PJ : Persona Juridica

-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>  

<h1>Registro de Infractor</h1>

<form id="formularioInfractor" enctype="multipart/form-data" method="post" >

	<fieldset class="fieldSetDG">	
		<legend><strong>Datos generales</strong></legend>
		<div class="l">
			<label>Tipo Documento</label>
			<select id="tipoDocumento" name="expediente.infractor.tipodocumento.idtipo"
				onchange="javascript:alert("234567!!!");valorSeleccionado('tipoDocumento');clearTextbox();">
				<option value="1" selected="selected">DNI</option>
				<option value="2">CE</option>
				<option value="3">PASAPORTE</option>
				<option value="4">RUC</option>
			</select>	
		</div>		
		<div class="l">
			<label>N&uacute;mero de documento </label>
			<s:textfield cssClass="doc valid onlydigits"  theme="simple" 
			             name="expediente.infractor.numerodocumento" id="paramNumeroDocumento"   						
   						 onblur="javascript:controlReincidencia()"
			             maxlength="8" size="12" />
		</div>		
		<div class="clear"></div>
						
		<div id="divPersona">						
			<div class="l" id="frmRazonSocial" style="display: none;" >
				<label>Raz&oacute;n Social </label>
				<s:textfield name="expediente.infractor.empresa" id="paramRazSocial"  
				             theme="simple"
				             cssStyle="text-transform:uppercase;" 
				             cssClass="content Valid" 
   						     size="40" />
			</div>
			<!--  
			<div class="l" id="frmRepLegal" style="display: none;" >
				<label>Representante Legal </label>
				<s:textfield name="representantaLegal" id="paramRepLegal"  
 				             theme="simple" 
 				             cssStyle="text-transform:uppercase;"  
 				             cssClass="content Valid"  
    						     size="40" /> 
			</div>
			-->
			<div class="l" id="frmApePat" >
				<label>Apellido Paterno </label>
				<s:textfield name="expediente.infractor.apepat" id="paramApePat"
				             onkeypress="soloLetras(event)"  
				             cssClass="content valid" theme="simple"
				             cssStyle="text-transform:uppercase;"/> 
			</div>				
			<div class="l" id="frmApeMat" >
				<label>Apellido Materno </label>
				<s:textfield  type ="text" name="expediente.infractor.apemat" id="paramApeMat"  
				              onkeypress="soloLetras(event)"  
				              cssClass="content valid" theme="simple" 
				              cssStyle="text-transform:uppercase;" 
				              onblur="this.value.toUpperCase()"/>
			</div>						
			<div class="l" id="frmNombre" >
				<label>Nombres </label>
				<s:textfield  type ="text" name="expediente.infractor.nombre" id="paramNombre"  
				              onkeypress="soloLetras(event)"  
				              cssClass="content valid" theme="simple" 
				              cssStyle="text-transform:uppercase;" 
				              onblur="this.value.toUpperCase()"  />
			</div>
		</div>		
		<div class="clear"></div>	
	</fieldset>
	<div class="clear"></div>	
	<fieldset>
		<legend><strong>Infracciones</strong></legend>		
		<div>			
			<div  id="totalInfracciones" >
		    <!-- aqui se llenan todas las infracciones -->				
		</div>
		<div class="clear"></div>
		
		<div id="divLinkInfra" >	
			<input type="button" class="btnInfraDisabled" value="Agregar" id="BotonAdd" />	
		</div>
		</div>	
	</fieldset>
	
	<div class="clear"></div>
	
	<fieldset class="fieldSetSanc">
		<legend><strong>Sanciones</strong></legend>		
		<div>
				<label>Elija una Sanci&oacute;n</label>
				<s:select list="listaSanciones" cssClass="select valid tipoBusquedaSancion" id="listaSanciones"
						listKey="idsancion"  listValue="descripcionsancion"
			  			headerKey="-1" theme="simple"
			 			headerValue="------ Seleccione una Sancion------" 
 			 			name="selectSancion" onchange="javascript:agregarSancion(event);"
			 			/>	
		</div> 			
		<div>
			<table id="hor-minimalist-a" summary="Employee Pay Sheet" class="tabla_Table">
			    <thead>
			    	<tr>
<!-- 			        	<th scope="col" width="20px;">N&deg;</th> -->
			        	<th scope="col">Nombre&nbsp;Sanci&oacute;n</th>            
			            <th scope="col">Campo</th>
			            <th scope="col">Comentario</th>
			            <th scope="col">Acci&oacute;n</th>			            
			    	<tr>
		    	</thead>
		    	<tbody style="font-size-adjust: inherit;" id="Detail_Table">    	
			    	        
			    </tbody>
			</table>
		</div>
						
	</fieldset>
	
	<div class="clear"></div>
	
	<fieldset id="Infracciones"  class="fieldSetDG" >
	
	<legend>Resoluci&oacute;n</legend>
<!-- 		<div class="l"> -->
<!-- 			<label>N° de Resoluci&oacute;n</label> -->
<%-- 			<s:textfield theme="simple"  id="paramResolucion"  --%>
<%-- 			             name="expediente.resolucion.numeroresolucion" size="40"    --%>
<%-- 			             cssClass="content valid"/> --%>
<!-- 		</div> -->
		<div class="l">
 			<label>Nu&oacute;mero</label> 
			<s:textfield theme="simple" name="expediente.resolucion.numero"  
			             id="numerofechaResolucion" size="10" cssClass="content valid" />
 			<label>Año</label> 
			<s:textfield theme="simple" name="expediente.resolucion.anno"  
			             id="annoResolucion" size="4" cssClass="content valid" />
		</div>
		<div class="l">
			<label>Adjuntar Archivo</label>
			<s:textfield type="file" name="file" id="archivoAdjunto" size="25" 
			             cssClass="input valid"/>			
		</div>
		<div class="l">				
			<label>F. Notificaci&oacute;n</label>
			<s:textfield theme="simple"  name="expediente.resolucion.fechanotificacion"  
			             id="fechaNotifResolucion__" size="9" 
			             cssClass="dateDMY_ input valid datepicker" readonly="true" />
		</div>
		<div class="clear" ></div>
	</fieldset>

	<div class="clear" ></div>	
	
	<div class="campo">
		<input type="button" value="Registrar !" class="submit" onclick="javascript:enviarFormulario();" />
	</div>
	
	<div class="clear" ></div>
	
	<input type="hidden" id="idInfractorAyuda" name ="idInfractorAyuda" value="00"/>
	<input type="hidden" id="idPersonaNatural" name ="idPersonaNatural" value="0"/>
			
</form>

<!-- en este modal se listaran las infracciones -->
<div id="muestraInfracciones" title="Lista de Infracciones" style="display:none;overflow: auto;"></div>
