<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="page-content">
      <div class="row">
		<div class="page-title">
		
				<h3>
					Registro de Ingreso y <span class="semi-bold">Salida</span>
				</h3>
		</div>

	    <ol class="breadcrumb">
	              <li><a href="index.html"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Registro de Ingreso y Salida</li>
  
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">
                           
				<div class="grid-title">
				  <div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				  		
<!-- 				  					<button class="btn btn-primary btn-sm" type="button" id="btnhorarios" onclick="diasnolaborables()" title="Registra días no laborables"> -->
<!-- 										<i class="fa fa-calendar"> Días no laborables </i> -->
<!-- 									</button> -->
									
									<div class="btn-group ">
							  			<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Mantenimiento<span class="caret"></span>
							  			</button>
							  				<ul class="dropdown-menu" role="menu">
							  					<li><a href="javascript:void(0);" onclick="diasnolaborables();"> Día no Laborable</a></li>
<!-- 							  					<li><a href="javascript:void(0);" onclick="dialogImportaArchivoExcel();"> Horario</a></li>							  					 -->
							  				</ul>
							  		</div>	
									
<!-- 				  					<button class="btn btn-primary" type="button" id="btnImportarExcel"> -->
<!-- 										<i class="fa fa-upload"> Importar Excel</i> -->
<!-- 									</button> -->
									
									
									
							  		<div class="btn-group ">
							  			<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Importar Marcaciones<span class="caret"></span>
							  			</button>
							  				<ul class="dropdown-menu" role="menu">
							  					<li><a href="javascript:void(0);" onclick="dialogImportaArchivo();"> Reloj TEMPUS</a></li>
							  					<li class="divider"></li>
							  					<li><a href="javascript:void(0);" onclick="dialogImportaArchivoExcel();"> Excel ANPs</a></li>							  					
							  				</ul>
							  		</div>									
									
<!-- 									<button class="btn btn-primary" type="button" id="btnimportarTxtRelog" onclick="dialogImportaArchivo();"> -->
<!-- 										<i class="fa fa-upload"> Marcaciones TEMPUS</i> -->
<!-- 									</button> -->
									
<!-- 									<button class="btn btn-primary" type="button" id="btnverMarcaciones" onclick="modalFiltroMarcaciones();"> -->
<!-- 										<i class="fa fa-eye"> Mostrar marcaciones</i> -->
									
<!-- 									</button> -->
									
									
<!-- 									<button class="btn btn-primary " type="button" id="btnRegistroLicencia" onclick="javascript:btnRegistroLicencia();"> -->
<!-- 										<i class="fa fa-edit"> Registrar Licencia</i> -->
<!-- 									</button> -->
									
									
									<div class="btn-group ">
							  			<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Registrar<span class="caret"></span>
							  			</button>
							  				<ul class="dropdown-menu" role="menu">
							  					<li><a href="javascript:void(0);" onclick="modalFiltroMarcaciones();"> Marcaciones / Papeleta</a></li>
							  					<li class="divider"></li>
							  					<li><a href="javascript:void(0);" onclick="btnRegistroLicencia();">Licencias</a></li>
							  					
							  				</ul>
							  		</div>	
									
									<div class="btn-group ">
							  			<button type="button" class="btn btn-primary dropdown-toggle " data-toggle="dropdown">
							  				<i class="fa fa-file-text"> Reportes</i>
							  				<span class="caret"></span>							  				
							  			</button>
							  				<ul class="dropdown-menu " role="menu">	
							  				
												<li>
							  						<a href="javascript:void(0);" onclick="reporteporPersonal('-1');">
							  							Ingreso y Salida por Persona <i class="fa fa-user"></i>
							  						</a>
							  					</li>
							  					
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteTodoPersonal('-1');">
							  							Ingreso y Salida del Personal <i class="fa fa-users"></i>
							  						</a>
							  					</li>
							  						
							  					<li class="divider"></li>
							  					
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteporPersonal('0');">
							  							Asistencia por Persona <i class="fa fa-user"></i>
							  						</a>
							  					</li>
							  					
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteTodoPersonal('0');">
							  							Asistencia del Personal <i class="fa fa-users"></i>
							  						</a>
							  					</li>					  				
				
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteporPersonal('1');">
							  							Inasistencias por Persona <i class="fa fa-user"></i>
							  						</a>
							  					</li>
							  					
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteTodoPersonal('1');">
							  							Inasistencias del Personal <i class="fa fa-users"></i>
							  						</a>
							  					</li>
							  					<li class="divider"></li>
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteporPersonal('2');">
							  							Papeletas por Persona <i class="fa fa-user"></i>
							  						</a>
							  					</li>
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteTodoPersonal('2');">
							  							Papeletas del Personal <i class="fa fa-users"></i>
							  						</a>
							  					</li>
							  					<li class="divider"></li>
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteporPersonal('3');">
							  							Resúmen de Asistencia por Persona <i class="fa fa-user"></i>
							  						</a>
							  					</li>
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteTodoPersonal('3');">
							  							Resúmen de Asistencia del Personal <i class="fa fa-users"></i>
							  						</a>
							  					</li>
							  					<li class="divider"></li>
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteporPersonal('4');">
							  							Record de Asistencia por Persona <i class="fa fa-user"></i>
							  						</a>
							  					</li>
							  					<li>
							  						<a href="javascript:void(0);" onclick="reporteTodoPersonal('4');">
							  							Record de Asistencia del Personal <i class="fa fa-users"></i>
							  						</a>
							  					</li>
							  				</ul>
							  		</div>	

					     </div>
							
				   </div>
            
                 </div>
                 
                 	<s:hidden name ="dtpage" id="dtpage" />
					<s:hidden name = "idPersonalM" id ="idPersonalM" value=""/>
					<s:hidden name = "tipoReportePersonal" id ="tipoReportePersonal" value=""/>
                 
                 <div class="grid-body no-border">
<%--                  <s:form> --%>
   
   							<div class="row form-row">
							
<!-- 										<div class="col-lg-1 col-md-1 col-sm-1"> -->
<!-- 										    <label for="apellidoTrabajador" class="form-label">Buscar por Apellidos y/o Nombres</label> -->
<!-- 										    <input class="form-control" type='text' name='apellidoTrabajador' id='apellidoTrabajador' value=''	size="25" onkeyup="javascript:filtraApellidos();" />	 -->
<!-- 										</div> -->
														                        

				                        <div class="col-lg-2 col-md-2 col-sm-2">
		                   				    <label for="fechamaAsistencia" class="form-label">Fecha Asistencia</label>
					                        <s:textfield cssClass="form-control"  id="fechamaAsistencia" name="dte_fec_asist"	theme="simple" size="12" readonly="true"	
											value="%{#request.dte_fec_asist}" title ="Mostrar Personal por fecha de asistencia"/>
				                        </div>                      
				                        
				                        <div class="col-lg-2 col-md-2 col-sm-2">
										    <label for="estadoAsistencia" class="form-label">Estado Asistencia</label>
										    <s:select theme="simple" cssClass="form-control" id ="estadoAsistencia" name="estadoAsistencia" list="#{'0':'Asistencias','1':'Inasistencias','2':'Regularizadas','3':'Observado'}" 
											headerKey="4" headerValue="[--- Todos---]"
											title="Mostrar Personal por motivo de incidencia"/>
										</div>
										
				                        <div class="col-lg-2 col-md-2 col-sm-2">
				                        	<label for="regimenContractual" class="form-label">Régimen contractual</label>
				                        	<s:select id="regimenContractual"
				                        		listKey="int_cod_regimen_contractual" 
				                        		listValue="var_descripcion_regimen_contractual"
				                        		name="int_cod_regimen_contractual"
				                        		headerKey="" headerValue="[--Todos--]"
				                        		value="3"
												list="regimenContractual"
				                        		onchange="FiltrarPersonalAsistenciaxfecha_motivo_apepat()"
				                        		cssClass="form-control"                      		>		
				                        				                        	
				                        	</s:select>
				                        </div>
						          
<!-- 			                  </div> -->
			                  
<!-- 			                  <div class="row form-row"> -->
			                  
			                  			<div class="col-lg-2 col-md-2 col-sm-2">
										    <label for=ubicacionPersonal class="form-label">Ubicación</label>
										    <s:select theme="simple" cssClass="form-control" id ="ubicacionPersonal" name="ubicacionPersonal" list="#{'-1':'[--Todos--]','0':'Sede Central','1':'Área Natural'}"
										    onchange="ubicaciondelPersonal(this.value,'')"
											value="0"
											title="Mostrar Personal por Ubicación"/>
										</div>									

				                       <div class="col-lg-2 col-md-2 col-sm-2">
				                        	<label for="idcategorianp" class="form-label">Categoría Área Natural Protegida.</label>
					                        <s:select id="idcategorianp"
					                                    name="idcategoriaanp"
									           			headerKey="-1" headerValue="[-- Seleccione Categoría--]"
										                list="listcategoriaanp"
										                listKey="idcategoriaanp"
										                listValue="descategoriaanp"										                
										             	cssClass="form-control"	
										             	disabled="true"
										             	onclick="loadANPs(this.value,'')" >


											</s:select>

				                        </div>
										<div class="col-lg-2 col-md-2 col-sm-2">
				                        	<label for="listANP" class="form-label">Área Natural Protegida.</label>
					                        <s:select id="listANP"
					                                    name="idareanatural"
									           			headerKey="" headerValue="[-- Seleccione ANP --]"
										                list="listareanatural"
										                listKey="idareanatural"
										                listValue="desareanatural"										                
										             	cssClass="form-control"
										             	disabled="true"	
										             	onchange="FiltrarPersonalAsistenciaxfecha_motivo_apepat()">


											</s:select>

				                        </div>
			                  
			                  </div>
<%--                  </s:form> --%>

	
	<div id="DivListadoPersonal">
		
	</div>

</div>

<br />
                 
                 
                 </div>
	
	
		</div>
			<!-- end grid simple -->
		</div>
		<!-- end row -->

	<!-- end page-content -->
	
	<!-- END PAGE -->

<div id="divModalDiasNoLaborables"></div>	
<div id="divModalContenedor"></div>
<div id="divModalmsg"></div>
<div id="divModalMarcaciones"></div>
<div id="divModalLicencias"></div>
<div id="divModalImportarArchivo" ></div>
<div id="dialog-info" hidden="true">  </br><p><strong>Debe seleccionar un Trabajador!</strong></p></div>
<div id="dialog-info-m" hidden="true"> </br> <p><strong>Debe seleccionar una Marcación!</strong></p></div>
<!-- <div id="dialog-info-nm" hidden="true"><p>Cuando el trabajador tiene marcación de ingreso y salida según su horario oficial, no podr&aacute; agregarle marcación</div> -->
<div id="dialog-info-nm" hidden="true"><p>La primera y última marcación del trabajador seleccionado, cumple con su horario oficial, no puede agregar otra marcación.</div>
<div id="dialog-info-nmp" hidden="true"><p>Cuando el trabajador tiene  Permiso, no puede agregar marcación / Permiso.</div>
<div id="dialog-info-rm" hidden="true">  <p>No ha ingresado Fecha y Hora de Retorno.</p><p>¿Desea agregar una Fecha y Hora?</p></div>
<div id="dialog-form">   <p>¿Realmente desea eliminar?</p> </div>
<div id="dialog-form-wait"></div>
<div id="dialog-formLic" hidden="true"> </br><p>¿Est&aacute; seguro que desea guardar los cambios?</p> </div>
<div id="dialog-formLicerrar" hidden="true"> </br><p>¿Est&aacute; seguro que el Personal ha utilizado su licencia?</p> </div>
<div id="dialog-info-ValidaVac" hidden="true">
	</br>
  	<p><strong>El personal tiene Vacaciones registradas en el rango de fechas seleccionado.</strong></p>
</div>
	<script type="text/javascript">
		$().ready(function(){
			FiltrarPersonalAsistenciaxfecha_motivo_apepat();
		});
	</script>