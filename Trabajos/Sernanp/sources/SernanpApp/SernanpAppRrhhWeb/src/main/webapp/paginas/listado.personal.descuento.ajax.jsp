<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


<!-- <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableDefault"> -->
<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover" id="tableDefault" >
	<thead>
		<tr>
			<th>N°</th>
			<th>N° Doc.</th>
			<th>Apellidos y Nombres</th>
			<th>Tardanza Min.</th>
			<th>Permisos Dias</th>
			<th>Permisos Horas</th>
			<th>Permisos Min.</th>
			<th>Inasistencias</th>
			<th>Licencias</th>
			<th>S/. Descuento</th>
			<th>Detalle</th>
		</tr>
	</thead>
	<tbody>
					<s:iterator value="listapersonaldescuentos" var="personal" status="personalStatus">
										
						<tr>
																
								<td><s:property value="%{#personalStatus.count}" /></td>
								<td><s:property value="#personal.personaldescuento.numerodocumento" /></td>
								<!-- nombres y apellidos -->
								<td>
								<s:text name="#personal.personaldescuento.apepat"></s:text>
								<s:text name="#personal.personaldescuento.apemat"></s:text>,
								<s:text name="#personal.personaldescuento.nombre"></s:text>
								</td> 
								<!-- nombres y apellidos -->
								
								<td><s:property value="#personal.minutos_tardanza" /></td>
								<td><s:property value="#personal.permisos" /></td>
								<td><s:property value="#personal.permiso_horas" /></td>
								<td><s:property value="#personal.permiso_minutos" /></td>
								<td><s:property value="#personal.inasistencias" /></td>
								<td><s:property value="#personal.licencias_sgh" /></td>
								<td><s:property value="#personal.total_descuento" /></td>
								<td>
								<button type="button" class="btn btn-primary"   
									onclick="javascript:mostrarinasistenciaspermisos(<s:text name="#personal.personaldescuento.idpersonal"></s:text>)">
									<i class="fa fa-eye"></i>
								</button> 
								</td>



							
						</tr>
					</s:iterator>
					</tbody>
</table>

<script type="text/javascript">
var oTableDefault = null;
var responsiveHelper = undefined;
var breakpointDefinition = {
    tablet: 1024,
    phone : 480
};

$(document).ready(function() {
	
oTableDefault = $('#tableDefault').dataTable( {
	autoWidth      : false,
    preDrawCallback: function () {
        
        if (!responsiveHelper) {
            responsiveHelper = new ResponsiveDatatablesHelper(oTableDefault, breakpointDefinition);	
        }
    },
    rowCallback    : function (nRow) {
        responsiveHelper.createExpandIcon(nRow);
    },
    drawCallback   : function (oSettings) {
        responsiveHelper.respond();
    },
    	"sDom": "<'row'<'col-md-12'f>> <'row' <'col-md-6'l><'col-md-6'p>> t <'row'<'col-md-12'p i> >",
	    "aaSorting": [],
	    "oLanguage": {
		   "sUrl": "assets/plugins/datatables/lang/spanish.json"
		     },
		   "aLengthMenu": [
		                 [10, 25, 50, 100, -1],
		                 [10, 25, 50, 100, "Todos"]
		             ]
	});
});
</script>

	<s:hidden id="mesofcontdeschidden" value="%{reportParams['mesofcontdesc']}" />
	<s:hidden id="periodofcontdeschidden" value="%{reportParams['periodofcontdesc']}" />										  
	<s:hidden id="mesofefectuadeschidden" value="%{reportParams['mesofefectuadesc']}"/> 
	<s:hidden id="periodoefectuadeschidden" value="%{reportParams['periodoefectuadesc']}"/> 
	
	<s:hidden id="descV" name="descValidados1" value="%{reportParams['descValidados']}"/>
	<s:hidden id="cantDescuentos" value="%{reportParams['cantdescuentos']}"/>
	
	
	
	
	