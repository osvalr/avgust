<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div class="modal-body" style="height: auto; width: auto;">


	<div class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="light">Apellidos y Nombres:</span> <span
					class="semi-bold"> <s:text name="personanatural.apepat" />&nbsp;
					<s:text name="personanatural.apemat" />,&nbsp; <s:text
						name="personanatural.nombre" />
				</span>
			</div>
			<div class="panel-body">
			
			
			<div class="row form-row">
		

			

			
			
<!-- 		</div> -->
		
<!-- 		<div class="row form-row"> -->
			<div class="col-lg-3 col-md-3 col-sm-3" style="display:inline">	
				<h5 class="bold">
				<span class="bold">Año </span>
				</h5>
<!-- 			</div> -->

<!-- 			<div class="col-lg-2 col-md-2 col-sm-2"> -->
				<s:select 
					listKey="int_anio" 
					listValue="int_anio"
					name="int_anio"
					id="int_anio_licencia_filtro"
					headerKey=""
					headerValue="[-- Todos --]"
					list="anios_licencias_personal"
					onchange="javascript:filtrarLicenciasPersonal();"/>
			</div>


			<div class="col-lg-3 col-md-3 col-sm-3" style="display:inline">		
				<h5 class="bold">
				<span class="bold">Mes </span>
				</h5>
<!-- 			</div> -->
			
<!-- 			<div class="col-lg-2 col-md-2 col-sm-2" > -->
				<s:select 
					listKey="int_mes" 
					listValue="descripcion"
					name="int_mes"
					id="int_mes_licencia_filtro"
					headerKey=""
					headerValue="[-- Todos --]"
					list="meses_licencias_personal"					
					onchange="javascript:filtrarLicenciasPersonal();" />
			</div>
			

			<div class="col-lg-2 col-md-2 col-sm-2" style="display:inline">		
				<h5 class="bold">
				<span class="bold">Licencia </span>
				</h5>
<!-- 			</div>	 -->
					
<!-- 			<div class="col-lg-4 col-md-4 col-sm-4" > -->
				<s:select 
					listKey="srl_id_per_activ" 
					listValue="var_des_per_activ"
					name="srl_id_per_activ"
					id="int_tipo_licencia_filtro"
					headerKey=""
					headerValue="[-- Todos --]"
					list="listTipoLicencia"					
					onchange="javascript:filtrarLicenciasPersonal();" />
			</div>

		</div>

				<div id="divListaLicencias" 
					style="height: 300px; width: auto; overflow-x: scroll; overflow-y: scroll;">

					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-bordered table-hover" id="tableLicencias">

						<thead>
							<tr>
<!-- 								<th class="text-center">N°</th> -->
								<th class="text-center">F. Inicio</th>
								<th class="text-center">F. Fín</th>
								<th class="text-center">Días</th>
								<th class="text-center">Resolución</th>
								<th class="text-center">Tipo</th>
								<th class="text-center">Descripción</th>
								<th colspan="2" class="text-center">Estado</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>



				</div>
			</div>
		</div>



		<!-- 		<div class="panel-group"> -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<span class="bold"><a data-toggle="collapse"
						href="#nuevaLicencia">Nueva licencia</a></span>
				</h4>
			</div>

			<div id="nuevaLicencia" class="panel-collapse collapse">

				<div class="panel-body">

					<s:hidden id="idPersonalLicencia" value="%{idPersonal}" />

					<s:form name="formRegistroLicencias" id="formRegistroLicencias"
						method="post" theme="simple">
						<s:hidden id="intEstadoLicencia"
							name="personalLicencias.int_est_lic" />
						<s:hidden id="idPersonalrl"
							name="personalLicencias.idPersonallicencia"
							value="%{#request.idPersonal}" />
						<s:hidden id="idLicenciasrl"
							name="personalLicencias.srl_id_pers_lic" />
						<s:hidden id="fechaFinVacaciones"
							value="%{#request.fechaIniLicValid}" />
						<s:hidden id="estadoAsist" value="%{#request.estadoAsist}" />

						<div class="row ">
							<div class="row form-row">
								<div class="col-lg-4 col-md-4 col-sm-4">
									<label class="form-label">Tipo:</label>
									<s:select listKey="srl_id_per_activ"
										listValue="var_des_per_activ"
										name="personalLicencias.tipolicencia.srl_id_per_activ"
										theme="simple" headerKey="" headerValue=""
										list="listTipoLicencia" cssClass="content_ valid form-control" />
								</div>

								<div class="col-lg-3 col-md-3 col-sm-3">
									<label class="form-label">N° Doc. Autoriza:</label>
									<s:textfield id="num_resol_autoriza"
										name="personalLicencias.var_num_resol_autoriza_lic"
										theme="simple" readonly="false"
										cssClass="content_ valid form-control" />
								</div>

								<div class="col-lg-2 col-md-2 col-sm-2">
									<label class="form-label">F. Inicio:</label>
									<s:textfield id="f_inicioLic"
										name="personalLicencias.dte_fec_inicio_lic"
										value="%{#request.fechaIniLic}" theme="simple" readonly="true"
										cssClass="content_ valid form-control" />
								</div>

								<div class="col-lg-2 col-md-2 col-sm-2">
									<label class="form-label">F. Fín:</label>
									<s:textfield id="f_finLic"
										name="personalLicencias.dte_fec_fin_lic"
										value="%{#request.fechaFinLic}" theme="simple" readonly="true"
										cssClass="content_ valid form-control" />
								</div>

								<div class="col-lg-1 col-md-1 col-sm-1">
									<label class="form-label">Días:</label>
									<s:textfield id="cantDiasLic"
										name="personalLicencias.int_dias_lic" theme="simple"
										readonly="false" cssClass="number onlyDigits form-control"
										onkeyup="javascrip:cambiarFechafinProgLic('');" />
								</div>
							</div>

							<div class="row form-row">
								<div class="col-lg-9 col-md-9 col-sm-9">
									<label class="form-label">Descripción:</label>
									<s:textarea id="descripcionLic"
										name="personalLicencias.var_descripcion_lic" rows="1"
										cssClass="content_ valid form-control" readonly="false"></s:textarea>
								</div>
							</div>
						</div>

						<div class="pull-right">
							<button type="button" class="btn btn-default"
								id="btnInsertaLicencias" title="Guardar Licencia">
								<i class="fa fa-save"> Grabar</i>
							</button>
							<button type="button" class="btn btn-default" id="btnCancelarLic"
								title="Salir de registro Licencias.">
								<!-- 									onclick="javascript:cerrarModalLicencias();" -->
								<i class="fa fa-ban"> Cancelar</i>
							</button>

						</div>

					</s:form>

				</div>

			</div>
		</div>
	</div>

</div>


<div id="divModalContenedorMsgInterceptor"></div>

<script>
$(document).ready(function(){	

    $("#btnCancelarLic").click(function(){
        $("#nuevaLicencia").collapse('hide');
    });    
	
});


$('#tableLicencias tbody').on( 'click', 'tr', function () {	

     if ( $(this).hasClass('active') ) {
         $(this).removeClass('active');

     }else {
    	 $('#tableLicencias').DataTable().$('tr.active').removeClass('active');
         $(this).addClass('active');

     }	
});

</script>



