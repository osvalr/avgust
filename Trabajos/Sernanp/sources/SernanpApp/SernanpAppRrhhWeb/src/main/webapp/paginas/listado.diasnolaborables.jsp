<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


<div class="modal-body" style="height: auto; width:auto;">


<br/>
<div class="row form-row ">
	<div class="col-lg-1 col-md-1 col-sm-1" style="display:inline">	
		<h5 class="bold">
		<span class="bold">Año </span>
		</h5>
	</div>

	<div class="col-lg-5 col-md-5 col-sm-5" style="display:inline">	
		<s:select 
			id="periodoDiasNoLaborables"
			name="anio"
			list="listaniosDiasNoLaborables"
			listKey="periodo"
			listValue="periodo"	
			headerKey=""
			headerValue="[-- Todos --]"				 
			onchange="javascrip:selectDiasNoLaborablesxPeriodo()"
			/>
	</div>
	
	<div class="col-lg-1 col-md-1 col-sm-1" style="display:inline">		
		<h5 class="bold">
		<span class="bold">Mes </span>
		</h5>
	</div>
	
	<div class="col-lg-5 col-md-5 col-sm-5" style="display:inline">	
		<s:select 
			id="mesDiasNoLaborables"
			name="mes"
			list="listamesesDiasNoLaborables"
			listKey="periodo"
			listValue="descripcion"
			headerKey=""
			headerValue="[-- Todos --]"
			onchange="javascrip:selectDiasNoLaborablesxPeriodo()"
			/>
	</div>

</div>
<br/>

<div style="height: 250px; width:600px; overflow-x: scroll;overflow-y: scroll;" id="divDiasNoLaborables">
	<table cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-hover"  id="tableDiasNoLaborables">
	
	<thead>
		<tr>
			<th class="text-center">Fecha</th>
			<th class="text-center">Descripción</th>
			<th class="text-center">Estado</th>
			<th class="text-center">Opción</th>
		</tr>
	</thead>
	<tbody>
	
<%-- 		<s:iterator value="listadiasnolaborables" var="var" status="varStatus"> --%>
	
<!-- 			<tr> -->
	
<%-- 				<td align="center"><s:property value="%{#varStatus.count}" /></td> --%>
<%-- 				<td align="center"><s:date name="%{#var.dte_fec_no_laborable}" format="dd/MM/yyyy" /></td> --%>


<!-- 				<td>						 -->
<%-- 					<s:if test="#var.int_estado == 0 "> --%>
<%-- 						<s:text name="Activo"></s:text> --%>

<%-- 					</s:if> --%>
<%-- 					<s:elseif test="#var.int_estado == 1"> --%>
<%-- 						<s:text name="Anulado" /> --%>
<%-- 					</s:elseif>	 --%>
				
<!-- 				</td> -->

				
<!-- 				<td align="center">						 -->
<%-- 					<s:if test="#var.int_estado == 0 "> --%>
<%-- 						<div title="Anular día" onclick="javascript:eliminarLicencias( --%>
<%-- 							<s:text name="#var.int_estado" />,'<s:date name="%{#var.dte_fec_no_laborable}" format="dd/MM/yyyy" />', '<s:date name="%{#var.dte_fec_no_laborable}" format="dd/MM/yyyy" />');"> --%>
<!-- 							<img src='img/eraser.png' border='0' style='cursor: pointer;'/>							 -->
<!-- 						</div> -->

<%-- 					</s:if> --%>
<!-- 				</td> -->

				
	
<!-- 			</tr> -->
<%-- 		</s:iterator> --%>
		
		</tbody>
		<tfoot>
			<tr>
				<th class="text-center">Fecha</th>
				<th class="text-center">Descripción</th>
				<th class="text-center">Estado</th>
				<th class="text-center">Opción</th>
			</tr>
		</tfoot>
	</table>
</div>

	<br/>

		<form name="formRegistroDiasNoLaborables" id="formRegistroDiasNoLaborables" method="POST" >
		
			<s:hidden name="diasNoLaborablesDTO.int_anio" value="" id="tDiasNoLaborables_int_anio" />
			<s:hidden name="diasNoLaborablesDTO.int_mes" value="" id="tDiasNoLaborables_int_mes" />
			<s:hidden name="diasNoLaborablesDTO.srl_id_no_laborable" value="" id="srl_id_no_laborable" />
			
			<h5 class="semi-bold">
			<span class="bold">Agrega nuevo día no laborable:</span>
			</h5>
			<div class="row ">
	
				<div class="col-md-12">
	
					<div class="row form-row">

						<div class="col-ml-4 col-md-4 col-sm-4">
							<label class="form-label">Fecha:</label>
							<s:textfield
								id="dianolaborable"
								name="diasNoLaborablesDTO.dte_fec_no_laborable"								
								readonly="true"
								cssClass="form-control" />
						</div>
<!-- 					</div> -->
						
<!-- 					<div class="row form-row"> -->
						<div class="col-ml-8 col-md-8 col-sm-8">
							<label class="form-label">Descripción:</label>
							<s:textarea 
								id="dianolaborabledescripcion"
								name="diasNoLaborablesDTO.var_dia_no_lab_descripcion"
								cssClass="form-control"/>
						</div>	

					</div>						
	
				</div>
	
			</div>
			
			<div class="form-actions">

				<div class="pull-right"> 
						<button type="button" class="btn btn-primary" onclick="javascript:grabarDiasNoLaborables();"   title ="Guardar día no laborable"><i class="fa fa-save"> Grabar</i></button>

					<button type="button" class="btn btn-primary" id="btnCancelarDNL" title="Salir del registro días no laborables." onclick="javascript:cerrarModalDiasNoLaborables();">
						<i class="fa fa-ban"> Cerrar</i>
					</button>
				</div>
			</div>
			
		</form>									

<div id="divModalContenedorMsgInterceptor"></div>
</div>


<div id="modalResultadoSolicitudDiasNoLaborables" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Estado de la solicitud</h4>
      </div>
      <div class="modal-body">
      		<br/>
     		
     		<div id="msj_resultadoDiasNoLaborables"></div>
     		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-white" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="modalConfirmarEliminarDNL" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Confirmación</h4>
      </div>
      <div class="modal-body">
      		<br/>
     		
     		¿Estas seguro Eliminar el día?
     		
      </div>
      <div class="modal-footer">
<!--         <button type="button" class="btn btn-primary" onclick="grabarFormulario()">Si</button> -->
		<button type="button" id="confirmacion_grabar" class="btn btn-primary" onclick="eliminarDiasNoLaborables()"  >Si</button>
<!-- 			<button type="button"   class="btn btn-danger" data-dismiss="modal">No</button>	 -->
        <button type="button" id="desistir_grabar"  class="btn btn-danger" data-dismiss="modal">No</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
