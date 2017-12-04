<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content" id="principal">
      <div class="row">
		<div class="page-title">
				<h3>
					Gestionar <span class="semi-bold">Contratos y Adendas</span>
				</h3>
		</div>
	    <ol class="breadcrumb">
	              <li><a href="#"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Gestionar Contratos y Adendas</li>
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">

				<div class="grid-title">
					<div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

							<a class="btn btn-default" id="btnVolver">
									<i class="fa fa-reply"> </i> Volver
							</a>
							


					     </div>
					     
					     
							
				   </div>
				   
				   
				   
				</div>
			<div class="grid-title">	
				<div class="row">
				      						
						<div class="col-lg-10 col-md-8 col-sm-8 col-xs-6">
						   <h2 id="txtNombres">${personaNatural.nombre} ${personaNatural.apepat} ${personaNatural.apemat}</h2>
						  
				           <p><strong>Tipo y Número de Documento:</strong></p>
				           <p>${personaNatural.descrip_tipo_documento} ${personaNatural.numerodoc}</p>
				           
				           <p><strong>Fecha de Nacimiento:</strong></p>
				           <p>${personaNatural.fechanacimiento}</p>
				           
				           <p><strong>Dirección:</strong></p>
				           <p>${personaNatural.direccion}</p>
				           
<!-- 							<button  id="btnRegistrarNuevoContrato" class="btn btn-primary" type="button" > -->
<!-- 								<i class="fa fa-plus-circle"></i> Registrar Contrato -->
<!-- 							</button> -->

						<div class="btn-group">
							<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
								Generar Contrato <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<s:iterator value="listCcpp" var="var" status="varStatus">
								<li><a href="javascript:void(0);" onclick="registrarContrato(<s:property value="#var.srl_id_postulante_conv_area_org" />);"><s:property value="#var.descrip_completa" /></a></li>
								</s:iterator>
							</ul>
						</div>
							
							

					</div>  
				    
				           
				 </div> 
				</div>		



				<div class="grid-body no-border">
						<div class="row ">
							<div class="col-lg-12">
							
							<h4 class="semi-bold">
									<span class="light">Listado de</span> 
										<span class="semi-bold">Contratos</span>
							 </h4>
							
							<br>

						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered" id="tableDefault">

							<thead>
								<tr>
									<th data-class="expand">Número Contrato</th>
									<th data-class="expand">Régimen Contractual</th>
									<th data-class="expand">F. Suscripción</th>
									<th data-class="expand">F. Inicio</th>
									<th data-class="expand">F. Término</th>
									<th data-class="expand">F. Cese</th>
									<th data-class="expand">Estado</th>
									<th data-class="expand">Convocatoria</th>
									<th data-class="expand">Código de Postulación</th>
									<th data-class="expand">Cargo</th>
									
									<th>Opciones</th>	
								</tr>
							</thead>

						</table>

<div id="adendas"></div>
<div id="bloque_tabla_adendas" style="display: none;">
							<h4 class="semi-bold">
									<span class="light">Listado de</span> 
									<span class="semi-bold">Adendas</span>
							 </h4>
							
							<br>

						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered" id="tableAdenda">

							<thead>
								<tr>
									<th data-class="expand">Número Adenda</th>
									<th data-class="expand">Número Contrato</th>
									<th data-class="expand">F. Suscripción</th>
									<th data-class="expand">F. Inicio</th>
									<th data-class="expand">F. Término</th>
									<th data-class="expand">F. Cese</th>
									<th data-class="expand">Estado</th>
									<th>Opciones</th>	
								</tr>
							</thead>

						</table>
</div>


						<br>        
                   
					   </div>
					</div>
 
				</div>
				<!--end grid-body -->

			</div>
			<!-- end grid simple -->
		</div>
		<!-- end row -->
	</div>
	<!-- end page-content -->
	
	<!-- END PAGE -->

<s:form action="registrar-editar-contrato" name="form" id="form" namespace="/">
	<s:hidden id="idPersonaNatural" name="idPersonaNatural"/>
	<s:hidden id="idPersonal" name="idPersonal"/>
	<s:hidden id="idContrato" name="idContrato"/>
	<s:hidden name="contrato.srl_id_contrato" id="srl_id_contrato"/>
	<s:hidden name="contrato.srl_id_contrato_padre" id="srl_id_contrato_padre"/>
	<s:hidden name="idPostulacion" id="idPostulacion"/>
	<s:hidden id="op" name="op"/>
	<s:hidden id="tipoReg" name="tipoReg"/>
</s:form>