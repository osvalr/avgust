<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!-- <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tableDefault"> -->
<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover" id="tableDefault" >
	<thead>
		<tr>
			<th rowspan="2" class="text-left">N°</th>
			<th colspan="2" class="text-center">PERSONAL</th>
<!-- 			<th>Apellidos y Nombres</th> -->

			<th colspan="2" class="text-center">CONTRATO</th>
<!-- 			<th>Fec. Cese</th> -->
			<th colspan="4" class="text-center">TIEMPO SERVICIO TRUNCO</th>
			<th colspan="7" class="text-center">VACACIONES</th>
<!-- 			<th>Corresponde</th> -->
<!-- 			<th>Goce</th> -->
<!-- 			<th>Truncas</th> -->
<!-- 			<th>Pendientes</th> -->
<!-- 			<th>Programar</th> -->
		</tr>
		<tr>			
			<th>Número doc.</th>
			<th>Apellidos y Nombres</th>
			
			<th>Fec. Ingreso</th>			
			<th>Fec. Cese</th>
			<th>Total Dias</th>
			<th>Años</th>
			<th>Meses</th>
			<th>Dias</th>
			<th>Fec. Inicio Prog.</th>
			<th>Corresponde</th>
			<th>Goce</th>
			<th>Truncas</th>
			<th>Pendientes</th>
			<th>Programar</th>
<!-- 			<th></th> -->
		</tr>
	</thead>
	<tbody>
					<s:iterator value="listapersonalVacaciones" var="personalVacacion" status="personalVacacionStatus">
					
					
					
						<tr id="<s:text name="%{#personalVacacion.personal.idpersonal}"/>">
																
								<td><s:text name="%{#personalVacacionStatus.count}" /></td>
								<td><s:text name="#personalVacacion.personal.numerodocumento" /></td>
								
								<td>
									<s:text name="#personalVacacion.personal.apepat"></s:text>
									<s:text name="#personalVacacion.personal.apemat"></s:text>,
									<s:text name="#personalVacacion.personal.nombre"></s:text>
								</td> 

								
								<td>
									<s:date name="%{#personalVacacion.personalContratoAdenda.personalContrato.dte_fec_inicio}" format="dd/MM/yyyy" />
								</td>
								
								<td>
									<s:date name="%{#personalVacacion.personalContratoAdenda.personalContrato.dte_fec_cese}" format="dd/MM/yyyy" />
								</td>								
								
<!-- 								SE AGREGO PARA MOSTRAR LOS DIAS LABORADOS TRUNCOS -->
								<td><s:text name="#personalVacacion.int_cant_dias_laborados_truncos"  />	</td>
								<td><s:text name="#personalVacacion.anios_servicio"  />	</td>
								<td><s:text name="#personalVacacion.meses_servicio"  />	</td>
								<td><s:text name="#personalVacacion.dias_servicio"  />	</td>

								<td><s:date name="%{#personalVacacion.dte_fec_inicio_programacion_vac}" format="dd/MM/yyyy" /> </td>
																								
								<td>
<%-- 								<td id="<s:text name="%{#personalVacacion.personal.idpersonal}_corresponde"/>"> --%>
<%-- 								<s:if test="#personalVacacion.int_dias_vac_goce > 0">  --%>
				 					<s:text name="#personalVacacion.int_dias_vac_corresponde - #personalVacacion.int_dias_vac_goce"></s:text> 
<%-- 				 				</s:if>	 --%>
				 				</td>
				 				
				 				<td>
<%-- 				 				<td id="<s:text name="%{#personalVacacion.personal.idpersonal}_goce"/>"> --%>
				 					<s:text name="#personalVacacion.int_dias_vac_goce" />
				 				</td>
<%-- 				 				<td><s:text name="#personalVacacion.int_dias_vac_truncas" /></td> --%>
								<td><s:text name="#personalVacacion.double_dias_vac_truncas" /></td>
				 				
				 				
				 				<td>
				 				<s:if test="#personalVacacion.personal.estado  == 0 && #personalVacacion.vac_pendientes_periodos_ant  > 0 ">	
<%-- 				 					<s:text name="#personalVacacion.vac_pendientes_periodos_ant"/>			 									 					 --%>
									<p style="text-align:center"> 
					 					<button type="button" class="btn btn-primary pull-left" onclick="javascript:vacacionesPendientesxidPersonal(<s:text name="#personalVacacion.personal.idpersonal"></s:text>);">
					 						<i class="fa fa-eye"></i>
					 					</button>
					 					<s:text name="#personalVacacion.vac_pendientes_periodos_ant" />
				 					</p>
				 					 
				 				</s:if>
				 				</td>
				 				
				 				<td>
<%-- 				 				<s:if test="#personalVacacion.dte_fec_inicio_programacion_vac != null && #personalVacacion.int_dias_vac_truncas == 0 && #personalVacacion.personal.estado  == 0">				 				 --%>
				 				<s:if test="#personalVacacion.dte_fec_inicio_programacion_vac != null ">
				 					<button type="button" class="btn btn-primary" style="text-align:center" onclick="javascript:programarVacaciones(<s:text name="#personalVacacion.personal.idpersonal"></s:text>),0">
				 						<i class="fa fa-edit"></i>
				 					</button>
				 				</s:if>
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
//     	"sDom": " lfptip",
		"sDom": "<'row'<'col-md-12'f>> <'row' <'col-md-6'l><'col-md-6'p>>  t <'row'<'col-md-12'p i> >",
		"order": [[ 2, "asc" ]],
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
	
	//var idP = 0;	
	var row = oTableDefault.fnGetData(this);
	//idP=row[0];	
     if ( $(this).hasClass('active') ) {
         $(this).removeClass('active');
//          $("#idPersonalM").val('');
     }else {
     	oTableDefault.$('tr.active').removeClass('active');
         $(this).addClass('active');
//          $("#idPersonalM").val(idP);
     }
});
</script>
