<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
<!--

$(function(){

	div = $('#formActualizarPersonalregistro'); 
	div.find("select.tipodoc").change(
			function(e) {				
				div.find('.doc').val('');
				div.find('.intipodoc').val('');
				validarDocumentoIdentidadFormReg(div.find("select.tipodoc"),div.find('.doc'),div.find('.intipodoc'));
			}
	);


	validarDocumentoIdentidadFormReg(div.find("select.tipodoc"),div.find('.doc'),div.find('.intipodoc'));
	
});


function validarDocumentoIdentidadFormReg(selectdoc,txtdoc,selloc) {
	
	if(selectdoc.val() == "0" || selectdoc.val().length == 0){
		selectdoc.val('');
	}else if(selectdoc.val() == "1"){// si es dni
		$(".divselecttl").show();
		txtdoc.attr("maxlength","8");
		txtdoc.onlyDigits();
		selloc.attr("disabled","");
		$("select.intipodoc option[value='86']").remove();
		
	}else{ // si no es dni(pasaporte, ce)
		$(".divselecttl").hide();
		txtdoc.attr("maxlength","22");
		txtdoc.unbind("keydown").unbind("keyup");
		$("select.intipodoc").append("<option value='86'>*</option>");
		selloc.val("86");
		selloc.attr("disabled","");	
	}
	
}
//-->
</script>

<div id="divContentPersonalReg">

<form id="formActualizarPersonalregistro" action="" method="post">

<s:hidden name="personalregistro[0].idpersonalregistro" />
<s:hidden name="idpersonalregistro" value="%{personalregistro[0].idpersonalregistro}" />

<div class="divCPR">

<div>
<label>Nombre:</label>
<s:textfield name="personalregistro[0].nombre" size="25" cssClass="content valid" ></s:textfield></div>

<div>
<label>Ap.Paterno:</label>
<s:textfield name="personalregistro[0].apepat" size="25" cssClass="content valid" ></s:textfield></div>

<div>
<label>Ap.Materno:</label>
<s:textfield name="personalregistro[0].apemat" size="25" cssClass="content valid" id="idapemat" ></s:textfield></div>

<div>
<label>Empresa/Inst.:</label>
<s:textfield name="personalregistro[0].empresa" size="30" cssClass="content valid"></s:textfield></div>

<div>
<label>Tipo Doc.:</label>
<s:select list="tipodocumento" listKey="idtipo" listValue="abrevtipo" name="tipodocumento[0].idtipo" value="personalregistro[0].tipodocumento.idtipo"  theme="simple" headerKey=""  headerValue="[--]" cssClass="select valid tipodoc" />
</div>

<div>
<label>Numero Doc.:</label>
<s:textfield name="personalregistro[0].numerodocumento" size="20" cssClass="doc valid" ></s:textfield></div>

<div class="divselecttl">
<label>Procedencia:</label>
<s:select list="tipolocal" listKey="idtipo" listValue="abrevtipo" name="tipolocal[0].idtipo" value="personalregistro[0].tipolocal.idtipo"  theme="simple" headerKey=""  headerValue="[--]" cssClass="select valid intipodoc" />
</div>

<div>
<label>Genero</label>
<s:select list="tipogenero" listKey="idtipo" listValue="abrevtipo" name="tipogenero[0].idtipo" value="personalregistro[0].sexo.idtipo" theme="simple" headerKey=""  headerValue="[--]" cssClass="select valid" />
</div>

</div>

<div>
<input type="button" value="Guardar !" class="submit2" id="btnUpdatePersonReg" />
</div>

</form>

</div>