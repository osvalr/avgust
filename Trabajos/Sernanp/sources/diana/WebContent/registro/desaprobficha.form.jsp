<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="divContentDesAprobFicha">

<form id="formDesaprobarFicha" method="post">

<s:hidden name="ficharegistro.idficharegistro" />

<label>Motivo:</label>
<div>
<s:textarea name="ficharegistro.observacion" rows="5" cols="80" cssClass="content valid"></s:textarea>
</div>

</form>

</div>