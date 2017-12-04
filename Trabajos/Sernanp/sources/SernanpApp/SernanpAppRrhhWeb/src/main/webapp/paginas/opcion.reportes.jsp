<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>


 		
<div class="col-md-12" id="Persona">
	<div class="row form-row">
		<div class="col-md-12 col-sm-12">	
			<span class="light">Apellidos y Nombres:</span>	   
			<span class="semi-bold" >
				<s:text name="personanatural.apepat" />&nbsp;
				<s:text name="personanatural.apemat" />,&nbsp;
				<s:text name="personanatural.nombre" />
			</span>	
		</div>
	</div>
	<br>
</div>

<div id="todos_porPersona"> <h5 class="semi-bold">Todo el Personal</h5> </div>

	<div id="divOptionReporte">
		<s:hidden name="idPersonal" id="idPersonalReporte"  class="col-lg-12 col-md-12 col-sm-12"/>
		
				<div class="col-md-12">
					<div class="row form-row">
						<div class="col-md-4 col-sm-4">
						    <label class="form-label"><strong>Tiempo</strong></label>
						    <s:select theme="simple" cssClass="form-control" id ="tiempoPersonalReportes"  list="#{'0':'Rango de Fechas','1':'Periodo'}"						    
							headerKey="-1" headerValue="[-- Seleccione --]"
							onchange="tiempoPersonalReportes(this.value)"
							title="Reporte Personal por Ubicación"/>
						</div>							

						<div class="col-md-4 col-sm-4">
                        	<label for="regimenContractualReporte" class="form-label"><strong>Régimen contractual</strong></label>
                        	<s:select id="regimenContractualReporte"
                        		listKey="int_cod_regimen_contractual" 
                        		listValue="var_descripcion_regimen_contractual"
                        		name="int_cod_regimen_contractual"
                        		headerKey="0" headerValue="[--Todos--]"
								list="regimenContractual"
                        		cssClass="form-control"                      		>		
                        				                        	
                        	</s:select>
                        </div>	
										
						<div class="col-md-4 col-sm-4">
						    <label class="form-label"><strong>Ubicación</strong></label>
						    <s:select theme="simple" cssClass="form-control" id ="ubicacionPersonalReportes"  list="#{'0':'Sede Central','1':'Área Natural'}"						    
							headerKey="-1" headerValue="[--Todos--]"
							title="Reporte Personal por Ubicación"/>
						</div>	
					
						<br>					
					</div>
					
					<div id="rangoFechas" class="row form-row">	
						<h5 class="semi-bold">Fechas:</h5>					
						<div class="col-md-6 col-sm-6">
							<label class="form-label"><strong>Desde:</strong></label>
								<s:textfield name="AsistenciafechaInicio" id="fechaIniAsistencia"  value="%{#request.AsistenciafechaInicio}" theme="simple" readonly="true" cssClass="form-control"  />
						</div>
						
						<div class="col-md-6 col-sm-6">
							<label class="form-label"><strong>Hasta:</strong></label>
								<s:textfield name="AsistenciafechaFin"  id="fechaFinAsistencia" value="%{#request.AsistenciafechaFin}" theme="simple" readonly="true" cssClass="hour_i valid datetimepicker form-control" />
						</div>
											
					</div>
<!-- 				</div> -->
					
<!-- 				<div class="col-md-12">	 -->
					<div id="periodos" class="row form-row" >
						<h5 class="semi-bold">Periodo:</h5>
							<div class="col-md-6 col-sm-6">
								<label class="form-label"><strong>Mes:</strong></label>
								<s:select id="mesdesc"
		                    		listKey="int_mes_desc" 
		                    		listValue="nom_mes_desc"
		                    		name="int_mes_desc"        		
									list="listamesDescuentos"		                    		
		                    		cssClass="form-control" >		
		                    				                        	
		                    	</s:select>
							</div>

							<div class="col-md-6 col-sm-6">						
								<label class="form-label"><strong>Año:</strong></label>
								<s:select id="periododesc"
		                    		listKey="int_periodo_desc" 
		                    		listValue="int_periodo_desc"
		                    		name="int_periodo_desc"            		
									list="listaaniosDescuentos"
		                    		cssClass="form-control" >			                    				                        	
		                    	</s:select>
							</div>
								 
					</div>
<!-- 				</div> -->
				
<!-- 				<div class="col-md-12">	 -->

				</div>
				

			<div class="form-actions">
				<br>
				<div class="row pull-left">
					<span style="display:none;" class="loading">
					<span class="semi-bold"> Generando Reporte... </span><img alt="procesando" src="<%=request.getContextPath()%>/assets/img/ajaxloader.gif">
					</span>
				</div>			
			
				<div class="row pull-right" >
					<div class="btn-group dropup">
			  			<button id="btnreportes" type="button" class="btn btn-primary dropdown-toggle " data-toggle="dropdown"> <i class="fa fa-download">  Exportar</i> <span class="caret"></span>
			  			</button>
			  				<ul class="dropdown-menu " role="menu">
			  					<li><a id="pdf" href="javascript:void(0);" onclick="dowloadReportePersonal('pdf');">PDF</a></li>
			  					<li><a id="xls" href="javascript:void(0);" onclick="dowloadReportePersonal('xls');">EXCEL</a></li>
			  				</ul>
			  		</div>

					<button type="button"  class="btn btn-primary" id="btnCancelarReportes" title="Salir de Reportes" onclick="javascript:cerrarOptReportes();">
						<i class="fa fa-power-off"> Cancelar</i>
					</button>				
				</div>

			</div>
			
	</div>
