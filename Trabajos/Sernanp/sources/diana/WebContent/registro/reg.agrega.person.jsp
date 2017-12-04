<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
<!--

$(function(){

	//validarDocumentoIdentidad(div.find("select.tipodoc"),div.find('.doc'));
	div = $('#FormInsertaPersonalRegistro'); 
	div.find("select.tipodoc").change(
			function(e) {				
				div.find('.doc').val('');
				div.find('.intipodoc').val('');
				validarDocumentoIdentidadFormReg(div.find("select.tipodoc"),div.find('.doc'),div.find('.intipodoc'));
			}
	);
	
});

function validarDocumentoIdentidadFormReg(selectdoc,txtdoc,selloc) {
	
	if(selectdoc.val() == "0" || selectdoc.val().length == 0){
		selectdoc.val('');
	}else if(selectdoc.val() == "1"){// si es dni
		$(".divselecttl").show();
		txtdoc.attr("maxlength","8");
		txtdoc.onlyDigits();
		selloc.attr("disabled",false);
		$("select.intipodoc option[value='86']").remove();
		
	}else{ // si no es dni(pasaporte, ce)
		$(".divselecttl").hide();
		txtdoc.attr("maxlength","22");
		txtdoc.unbind("keydown").unbind("keyup");
		$("select.intipodoc").append("<option value='86'>*</option>");
		selloc.val("86");
		selloc.attr("disabled",false);	
	}
	
}
//-->
</script>

<div id="divContentPersonalReg">

<form id="FormInsertaPersonalRegistro" method="post">

<div class="divCPR">

<div>
<label>Nombre:</label>
<s:textfield id="nombre" name="nombre" size="25" cssClass="content valid"></s:textfield></div>

<div>
<label>Ap.Paterno:</label>
<s:textfield name="apepat" size="25" cssClass="content valid"></s:textfield></div>

<div>
<label>Ap.Materno:</label>
<s:textfield name="apemat" size="25" cssClass="content valid" id="idapemat"></s:textfield></div>

<div>
<label>Empresa/Inst.:</label>
<s:textfield name="empresa" size="30" cssClass="content valid"></s:textfield></div>

<div>
<label>Tipo Doc.:</label>
<s:select list="tipodocumento" listKey="idtipo" listValue="abrevtipo" id="idtipodocumento" name="idtipodocumento"  theme="simple" headerKey=""  headerValue="[--]" cssClass="select valid tipodoc"  />
</div>

<div>
<label>Numero Doc.:</label>
<s:textfield name="numerodocumento" size="20" cssClass="doc valid"></s:textfield></div>

<div class="divselecttl">
<label>Procedencia:</label>
<s:select list="tipolocal" listKey="idtipo" listValue="abrevtipo" name="intipodoc"  theme="simple" headerKey=""  headerValue="[--]" cssClass="select valid intipodoc" disabled="true" />
</div>

<div>
<label>Genero</label>
<s:select list="tipogenero" listKey="idtipo" listValue="abrevtipo" name="idsexo"  theme="simple" headerKey=""  headerValue="[--]" cssClass="select valid" />
</div>

</div>

<div>
<input type="button" value="Guardar !" class="submit2" id="btnSavePersonRegForm" />
</div>

</form>

</div>