<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<style type="text/css">
table tbody tr.selected {
  background-color: #b0bed9 !important;
}
</style>
<!-- <table cellpadding="0" cellspacing="0" border="0" class="table  table-bordered" id="tableDefault"> -->
<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover" id="tableDefault" >
	<thead>
		<tr>
<!-- 			<th>#</th> -->
<!-- 			<th hidden="false"></th> -->
			<th rowspan="2" class="text-left">N°</th>
			<th colspan="2" class="text-center">PERSONAL</th>
<!-- 			<th>N° Doc.</th> -->
<!-- 			<th>Apellidos y Nombres</th> -->
			<th colspan="4" class="text-center">CONTRATO</th>
<!-- 			<th>Fec. Inicio</th>			 -->
<!-- 			<th>Fec. Cese</th> -->
<!-- 			<th>Oficina</th> -->
<!-- 			<th>Cargo</th> -->
			<th colspan="4" class="text-center">ASISTENCIA</th>
<!-- 			<th>H. Ingreso</th> -->
<!-- 			<th>H. Salida</th> -->
<!-- 			<th>Tardanza</th> -->
<!-- 			<th>Estado</th> -->
		</tr>	
		<tr>
<!-- 			<th>#</th> -->
			<th hidden="false"></th>			
			<th class="text-center">DNI.</th>
			<th class="text-center">Apellidos y Nombres</th>
			<th class="text-center">Fec. Inicio</th>			
			<th class="text-center">Fec. Cese</th>
			<th class="text-center">Oficina</th>
			<th class="text-center">Cargo</th>
			<th class="text-center">H. Ingreso</th>
			<th class="text-center">H. Salida</th>
			<th class="text-center">Tardanza</th>
			<th class="text-center">Estado</th>
		</tr>
	</thead>
	<tbody>
					<s:iterator value="listapersonal" var="personal" status="personalStatus">
					
					<s:set var="varId" value="personal.idpersonal" />
					
						<tr id="<s:text name="personal.idpersonal"/>">
								
<%-- 								<td><s:checkbox theme="simple"   name="personal.idpersonal"  value="false" fieldValue="%{#varId}" /></td> --%>
								<td hidden="true"><s:property  value="%{#varId}" /></td>
								
								<td><s:property value="%{#personalStatus.count}" /></td>
								<td><s:property value="personal.numerodocumento" /></td>
								<!-- nombres y apellidos -->
								<td>
								<s:if test="personal.apepat != null">
									<s:property value="personal.apepat"/>
								</s:if>
								<s:else>
									<s:property value="apepat"/>,
								</s:else>
								
								<s:if test="personal.apemat != null">
									<s:property value="personal.apemat"/>,
								</s:if>
								<s:else>
									<s:property value="apemat"/>,
								</s:else>
								
								<s:if test="personal.nombre != null">
									<s:property value="personal.nombre" />
								</s:if>
								<s:else>
									<s:property value="nombre"/>
								</s:else>					
								</td> 
<!-- 								Fecha Inicio Contrato y Cargo -->
								<td><s:date name="%{#personal.personalContrato.dte_fec_inicio}" format="dd/MM/yyyy" /></td>
								<td><s:date name="%{#personal.personalContrato.dte_fec_cese}" format="dd/MM/yyyy" /></td>
								<td><s:property  value="#personal.descoficina" /></td>
								<td><s:property value="#personal.personal.cargo.nombrecargo"/></td>
								
								<!-- nombres y apellidos -->							
								
								<td><s:property value="#personal.hor_hor_ingreso" /></td>
								<td><s:property value="#personal.hor_hor_salida" /></td>
								<td><s:property value="#personal.minutostardanza" /></td>

<!-- estado -->

				<s:if test="#personal.estado == 2">
						<td><s:text name="<span style='width:40px; text-align:left; color:blue;'>Permiso</span>" /></td>
				</s:if>
				<s:elseif test="#personal.estado == 1">
					<s:if test="#personal.int_vac_lic == 2">
							<td>
							<s:text name="<span style='width:40px; text-align:left; color:blue;'>Licencia sin goce</span>" />
							</td>
					</s:if>
					<s:else>

							<s:if test="#personal.estadoTmp == 1 ">
								<td>
								<s:text name="<span style='width:40px; text-align:left; color:red;'>Inasistencia</span>" />
								</td>
							</s:if>
							<s:else>
								<td>
								<s:text name="<span style='width:40px; text-align:left; color:red;'>Observado</span>" />
								</td>
							</s:else>

					</s:else>

				</s:elseif>
				<s:else>
						<s:if test="#personal.int_vac_lic == 1">
							<td>
							<s:text name="<span style='width:40px; text-align:left; color:green;'>Vacaciones</span>" />
							</td>
						</s:if>
						<s:elseif test="#personal.int_vac_lic == 2">
							<td>
							<s:text name="<span style='width:40px; text-align:left; color:green;'>Licencia</span>" />
							</td>
						</s:elseif>
						<s:else>
							<td>
							<s:text name="" />
							</td>
						</s:else>
				</s:else>
<!-- estado -->
							
						</tr>
					</s:iterator>
					</tbody>
</table>



 <s:if test="%{#request.cantidadincidencias > 0 }">
		<s:label  value="%{#request.msgincidencias}" cssStyle="text-align:right; color:red; font-weight: bold; padding: 1px; font-size: 105%"/>
	</s:if>
	<s:else >
		<s:label  value="%{#request.msgincidencias}" cssStyle="text-align:right; color:green; font-weight: bold; padding: 1px; font-size: 105%"/>
	</s:else>
	<hr>

<script type="text/javascript">
var oTableDefault = null;
var responsiveHelper = undefined;
var breakpointDefinition = {
    tablet: 1024,
    phone : 480
};

$(document).ready(function() {
	
oTableDefault = $('#tableDefault').dataTable( {
// 	"bFilter": false,
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
    	"sDom": "<'row'<'col-md-12'f>> <'row' <'col-md-6'l><'col-md-6'p>>  t <'row'<'col-md-12'p i> >",
	    "aaSorting": [],
	    "oLanguage": {
		   "sUrl": "assets/plugins/datatables/lang/spanish.json"
		     },
		   "aLengthMenu": [
		                 [25, 50, 100, 200, -1],
		                 [25, 50, 100, 200, "Todos"]
		             ]

	});
});


$('#tableDefault tbody').on( 'click', 'tr', function () {
	
	var idP = 0;	
	var row = oTableDefault.fnGetData(this);
	idP=row[0];	
     if ( $(this).hasClass('active') ) {
         $(this).removeClass('active');
         $("#idPersonalM").val('');
     }else {
     	oTableDefault.$('tr.active').removeClass('active');
         $(this).addClass('active');
         $("#idPersonalM").val(idP);
     }
	
// 	var isChecked = jQuery(this).find("input:checkbox").is(':checked');
	
// 	if(isChecked){
// 		if ( $(this).hasClass('warning')) {
// 	        $(this).removeClass('warning');
// 	    }
// 	    else {
// 	    	oTableDefault.$('tr.warning').removeClass('warning');
// 	        $(this).addClass('warning');
// 	    }
// 	}else{
// 		 $(this).removeClass('warning');
// 	}
	
});

</script>

	