<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!-- <div id="divListaMarcaciones"> -->
<!-- 			<div id="msgSinMarcaciones"> -->
<%-- 				<s:actionmessage id="msgMarcaciones" cssClass="alertamsg" cssStyle="display: block;" /> --%>
<!-- 			</div> -->
	<s:if test="%{#request.estadoAsist != null}">
		<div class="alert alert-warning">
		    	<a href="#" class="close" data-dismiss="alert">&times;</a>
		    <strong > <s:property value="%{#request.estadoAsist}"/>
		    </strong>
		</div>
	</s:if>		
	
			
	<s:if test="%{#request.cantMarcacion > 0 }">
	

	       <div class="grid-body no-border">     
	       
<!-- 			<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableDefault"> -->
			<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover" id="tableDefaultMarcaciones">
				<thead>
					<tr>
						<th>#</th>
						<th>N°</th>
						<th>F. Marcación</th>
						<th>H. Marcación</th>
						<th>Tipo Marcación</th>
						<th>Actividad</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listamarcacionesxtrabajador" var="var" status="varStatus">
	
						<tr>
	
							<td>
								<s:checkbox theme="simple"  name="srl_id_papeleta" value="false"  fieldValue="%{#var.srl_id_papeleta}-%{#var.srl_id_personal_marcacion}-%{#var.tipomarcacion.idtipo}"/>	</td>
							<td><s:property value="#varStatus.count" /></td>
<%-- 							<td><s:property value="#var.dte_fec_marc" /></td> --%>
							<td><s:date name="%{#var.dte_fec_marc}" format="dd/MM/yyyy" /></td>
							<td><s:property value="#var.hor_hor_marc" /></td>
							<td><s:property value="#var.tipomarcacion.destipo" /></td>							
							<td><s:property value="#var.personalActividad.var_des_per_activ" /></td>	
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>     
	                 <tr>
	                    <th>#</th>
						<th>N°</th>
						<th>F. Marcación</th>
						<th>H. Marcación</th>
<!-- 						<th>Id tipo Marcación</th> -->
						<th>Tipo Marcación</th>
						<th>Actividad</th>
<!-- 						<th>Eliminar</th> -->
	                  </tr>
	                </tfoot>
			</table>
		  </div>
			
	<!-- 	</div> -->
	</s:if>
<%-- 	<s:else> --%>
<!-- 			<div id="msgSinMarcaciones"> -->
<%-- 				<s:actionmessage id="msgMarcaciones" cssClass="alertamsg" cssStyle="display: block;" /> --%>
<!-- 			</div> -->
<%-- 	</s:else> --%>
<!-- </div> -->

<s:hidden id="isajaxcantMarcacion" value="%{#request.cantMarcacion}"/>
<s:hidden id="hor_ingreso" value="%{#request.hor_ingreso}"/>
<s:hidden id="hor_salida" value="%{#request.hor_salida}"/>
<s:hidden id="min_tardanza" value="%{#request.minutos_tardanza}"/>
<s:hidden id="estadoAsist" value="%{#request.estadoAsist}"/>
<s:hidden id="eliminarMarcacion" value="%{#request.elininarMarcacion}" />



<script type="text/javascript">
var oTableDefaultM = null;

oTableDefaultM = $('#tableDefaultMarcaciones').dataTable( {
	autoWidth   : false,
	bPaginate	: false,
	bFilter		: false, 
	bInfo		: false,
	bSort 		: false

});

$('#tableDefaultMarcaciones tbody').on( 'click', 'tr', function () {
	
	var isChecked = jQuery(this).find("input:checkbox").is(':checked');
	
	if(isChecked){
		if ( $(this).hasClass('danger')) {
	        $(this).removeClass('danger');
	    }else {
	    	oTableDefaultM.$('tr.danger').removeClass('danger');
	        $(this).addClass('danger');
	    }
	}else{
		 $(this).removeClass('danger');
	}
	
});

</script>