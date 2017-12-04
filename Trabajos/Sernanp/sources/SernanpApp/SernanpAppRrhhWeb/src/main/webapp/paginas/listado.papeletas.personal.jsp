<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div id="divListaPapeletas"  style="height: 200px; overflow-y: scroll; overflow-x: scroll;">
<script type="text/javascript">
	$(document).ready(function(){
 		papeletasajax('1');
 	});
</script>

</div>

<br>


<div class="form-actions">
	<div class="row pull-right" >
				
		<button type="button" class="btn btn-danger"  id="btnEliminarPapeleta" onclick="jacascript:eliminarPapeleta();" title ="Eliminar papeleta seleccionada" >
			<i class="fa fa-trash-o"> Eliminar</i>
		</button>
		
		<button type="button"  class="btn btn-primary" id="btnCancelarPapeletas" title="Salir de Papeletas" onclick="javascript:cerrarModalPapeleta();">
			<i class="fa fa-power-off"> Cancelar</i>
		</button>
				
	</div>
</div>
