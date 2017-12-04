<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
$(function() {
	fechaServer = '<%=request.getAttribute("fechaactual")%>';
	
	var fechaDP = fechaServer.split('-');
	
	var ano = parseInt(fechaDP[0],10);
	var mes = parseInt(fechaDP[1],10);
	var dia = parseInt(fechaDP[2],10);
	
	test = new Date(ano, mes - 1, dia);
	//testm = new Date(test.getTime());
    //testm.setDate(testm.getDate());
    
	
	$( ".datepicker" ).datepicker({minDate: test});
	
	/* $(".datepicker").live('click', function() {	    	
    	$( ".datepicker" ).datepicker( "option", "minDate", test );
    }); */	

});

</script>

<!-- Content -->
<h1>Formulario de Registro de Ingreso<br /><span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span></h1> 
<br />

<form id="formRegistroFicharegistro" method="post" >
	
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
			<%-- <div><label class="de_1">RUC:</label> 
			<s:textfield value="%{personajuridica.ruc}" size="25" readonly="true"></s:textfield>
			</div>	 --%>			
		</div>
		<div class="l dv_2">
			<div>
				<label class="de_3">Lote:</label>
				<s:textfield name="ficharegistro.lote" value="" size="10" cssClass ="content valid" />
			</div>			
			<div><label class="de_3 del_3">Nombre del Proyecto:</label>
				<s:textarea name="ficharegistro.nombreproyecto" value="" rows="3" cols="30" cssClass ="content valid" />
			</div>
			
		</div>
		
		<div class="clear"></div>		
		
		<div><label class="de_4">Responsable de la Informaci&oacute;n:</label>
			<s:textfield value="%{personanatural.nombre} %{personanatural.apepat} %{personanatural.apemat}" size="40" readonly="true"></s:textfield>
		</div>
		
		<div class="clear"></div>
		<div></div>
	</fieldset> 
	
	<fieldset>
		<legend><strong>Medio de Transporte:</strong></legend>
		<div class="l">
		<s:iterator value="%{tipomediotra}">
			<div><s:checkbox name="tipomediotra.idtipo" label="%{nombretipo}" fieldValue="%{idtipo}" cssClass="mediotra" /></div>
		</s:iterator>
		<div class="msgmedtra v_label2" style="display:none;" ><s:property value="getText('msgmedtra')" /> </div>
		</div>
		<div class="l dv_3">
			<div><label class="de_1">Actividad:</label>
			<s:textfield name="ficharegistro.actividad" value="" size="40" cssClass="content valid" ></s:textfield>
			</div>
			<div><label class="de_1">Lugar:</label>
			<s:textfield name="ficharegistro.lugar" value="" size="40" cssClass="content valid" ></s:textfield>
			</div>
		</div>

	</fieldset> 
	
	<fieldset>
		<legend><strong>Personal que Ingresa al ANP:</strong></legend>
		<div class="l">
		<div><label>Digite Nombre:</label>
			<s:textfield id="cadena" value="" size="50" ></s:textfield>
			</div>
		</div>
		
		<div class="l">
			<input type="button" value="+" class="submit2" id="btnAgregarPersonRegForm" />	
		</div>

<div class="clear" ></div>

<div class="divList">
			 
<table id="hor-minimalist-a" summary="Employee Pay Sheet">
    <thead>
    	<tr>
        	<th scope="col" width="20px;">N&deg;</th>
        	<th scope="col">Apellidos y Nombres</th>            
            <th scope="col">Empresa/Inst.</th>
            <th scope="col">Tipo de Doc.</th>
            <th scope="col">N&uacute;mero de Doc.</th>
            <th scope="col">Proced.</th>
            <th scope="col">Genero</th>            
            <th scope="col">Fecha de Ing.</th>       
            <th scope="col"></th>
    	<tr>
    	
    	</thead>
    	<tbody>    	
    	        
    </tbody>
</table>	

<div class="msgpersreg v_label2" style="display:none;" ><s:property value="getText('msgpersreg')" /> </div>

</div>
	
	</fieldset>


<fieldset>		
		
		<div class="coment">
		<div class="c1">Comentario:</div>
			<div><s:textarea name="ficharegistro.comentario" cols="2" cssStyle="width: 400px;"></s:textarea></div>			
		</div>
</fieldset>


	<br>
		
	<div class="divBtnEnviar">
	<input type="button" value="Enviar !" class="submit" id="btnEnviarFicha" />
	</div>
	
	<br><br>
	
</form>
<div id="divModalPersonalRegistro"></div>
<div id="dialog-message" title="Confirmación de Envío" style="display: none;">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		¿Esta seguro de enviar el formulario?
	</p>
	
</div>