<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!-- <div id="divListaPapeletas"  style="height: 200px; overflow-y: scroll; overflow-x: scroll;"> -->
	<fieldset style="float:center;">
<!-- 		<table cellpadding="0" cellspacing="0" border="0"	class="table table-striped table-bordered" id="tableDefaultPapeleta"> -->
		<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover" id="tableDefaultPapeleta">
			<thead>
				<tr>
					<th>#</th>
					<th>N°</th>
					<th>F. Actividad</th>
					<th>F. Salida</th>
					<th>F. Retorno</th>
					<th>Hora. Salida</th>
					<th>Hora. Retorno</th>
					<th>Detalle</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="personalDesplazamiento" var="var" status="varStatus">

					<tr>
						<td><s:checkbox theme="simple"  name="srl_id_papeleta_p" value="false"  fieldValue="%{#var.srl_id_desp}*%{#var.dte_fec_sal_desp}*%{#var.dte_fec_ret_desp}"/></td>
						<td><s:property value="#varStatus.count" /></td>
						<td><s:property value="#var.personalActividad.var_des_per_activ" /></td>
						<td>
						<s:date name="%{#var.dte_fec_sal_desp}" format="dd/MM/yyyy" />
<%-- 						<s:property value="#var.dte_fec_sal_desp" /> --%>
						</td>
						<td>
						<s:date name="%{#var.dte_fec_ret_desp}" format="dd/MM/yyyy" />
<%-- 						<s:property value="#var.dte_fec_ret_desp" /> --%>
						</td>
						<td><s:property value="#var.hor_hor_sal_desp" /></td>
						<td><s:property value="#var.hor_hor_ret_desp" /></td>
						<td><s:property value="#var.var_lug_desp" /></td>						

					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<tr>
					<th>#</th>
					<th>N°</th>
					<th>F. Actividad</th>
					<th>F. Salida</th>
					<th>F. Retorno</th>
					<th>Hora. Salida</th>
					<th>Hora. Retorno</th>
					<th>Detalle</th>
				</tr>
			</tfoot>
		</table>
		
								
	</fieldset>		
<!-- 	<br /> -->
<!-- </div> -->

<br>


<!-- <div class="form-actions"> -->
<!-- 	<div class="row pull-right" > -->
				
<!-- 		<button type="button" class="btn btn-danger"  id="btnEliminarPapeleta" onclick="jacascript:eliminarPapeleta();" title ="Eliminar papeleta seleccionada" > -->
<!-- 			<i class="fa fa-trash-o"> Eliminar</i> -->
<!-- 		</button> -->
		
<!-- 		<button type="button"  class="btn btn-primary" id="btnCancelarPapeletas" title="Salir de Papeletas" onclick="javascript:cerrarModalPapeleta();"> -->
<!-- 			<i class="fa fa-power-off"> Cancelar</i> -->
<!-- 		</button> -->
				
<!-- 	</div> -->
<!-- </div> -->


<script type="text/javascript">
var oTableDefaultM = null;

oTableDefaultM = $('#tableDefaultPapeleta').dataTable( {
	autoWidth   : false,
	bPaginate	: false,
	bFilter		: false, 
	bInfo		: false,
	bSort 		: true

});

$('#tableDefaultPapeleta tbody').on( 'click', 'tr', function () {
	
	var isChecked = jQuery(this).find("input:checkbox").is(':checked');
	
	if(isChecked){
		if ( $(this).hasClass('danger')) {
	        $(this).removeClass('danger');
	    }else {
	    	oTableDefaultM.$('tr.danger').removeClass('danger');	    	
	        $(this).addClass('danger');
	    }
// 		$('#btnEliminarPapeleta').removeAttr('disabled','disabled');
// 		$('#btnEliminarPapeleta').attr('enabled','enabled');
		
	}else{
		 $(this).removeClass('danger');
// 			$('#btnEliminarPapeleta').attr('disabled','disabled');
// 			$('#btnEliminarPapeleta').removeAttr('enabled','enabled');
	}
	
});

</script>
