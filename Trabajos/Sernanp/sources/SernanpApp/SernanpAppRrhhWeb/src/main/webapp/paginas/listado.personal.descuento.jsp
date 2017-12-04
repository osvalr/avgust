<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="page-content">
	<div class="row">
		<div class="page-title">

			<h3>
				Desplazamiento y  <span class="semi-bold">Asistencia</span>
			</h3>
		</div>

		<ol class="breadcrumb">
			<li><a href="index.html"><i class="fa fa-male"></i> Recursos
					Humanos</a></li>
			<li class="active"><i class="fa fa-edit"></i> 
				Desplazamiento y Asistencia</li>

		</ol>
	</div>

	<div class="row">

		<div class="grid simple">

			<div class="grid-title">
			
				<div class="row form-row">

					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">					

								<s:hidden id="cantdescuentos" value="%{reportParams['cantdescuentos']}" />
																
								<div id="periodo">
								
									<h1 align="center">Desplazamiento y Asistencia</h1>
									<h4 align="center">Consolidado de descuentos del Personal por Concepto de: Tardanzas, Permisos, Inasistencias y Licencias sin goce de haber correspondiente al mes de
										<s:label id="mesofcontdesc" value="%{reportParams['mesofcontdesc']}" /> -
										<s:label id="periodofcontdesc" value="%{reportParams['periodofcontdesc']}" />										  
									</h4>
									
									
									<h4 align="center">Mes a efectuarse el descuento: 
										<s:label id="mesofefectuadesc" value="%{reportParams['mesofefectuadesc']}"/> - 
										<s:label id="periodoefectuadesc" value="%{reportParams['periodoefectuadesc']}"/> 
									</h4>
								
								</div>
						</div>	
					</div>	
					<br>
     
    			
    			<div class="row form-row">       
    			    <s:hidden id="isajax" name="isajax" />                         
                    <div class="col-lg-1 col-md-1 col-sm-1">
                    	<label class="form-label">Mes</label>
                    	<s:select id="mesdesc"
                    		listKey="int_mes_desc" 
                    		listValue="nom_mes_desc"
                    		name="int_mes_desc"        		
							list="listamesDescuentos"
                    		onchange="filtrarDescuentosxperiodo()"
                    		cssClass="form-control"                      		>		
                    				                        	
                    	</s:select>
                    </div>
                    
                    
                    <div class="col-lg-1 col-md-1 col-sm-1">
                    	<label class="form-label">Año</label>
                    	<s:select id="periododesc"
                    		listKey="int_periodo_desc" 
                    		listValue="int_periodo_desc"
                    		name="int_periodo_desc"            		
							list="listaaniosDescuentos"
                    		onchange="filtrarDescuentosxperiodo()"
                    		cssClass="form-control"                      		>		
                    				                        	
                    	</s:select>
                    </div>
                    
	                <div class="col-lg-2 col-md-2 col-sm-2">
                    	<label class="form-label">Régimen contractual</label>
                    	<s:select id="regimenContractualD"
                    		listKey="int_cod_regimen_contractual" 
                    		listValue="var_descripcion_regimen_contractual"
                    		name="int_cod_regimen_contractual"
                    		headerKey="-1" headerValue="[--Todos--]"
                    		value="3"
							list="regimenContractual"
                    		onchange="filtraApellidosOfDescuentoInicial()"
                    		cssClass="form-control"                      		>		
                    				                        	
                    	</s:select>
                    </div>                    


					<div class="col-lg-2 col-md-2 col-sm-2 ">
					    <label for=ubicacionPersonalDesc class="form-label">Ubicación</label>
					    <s:select theme="simple" cssClass="form-control" id ="ubicacionPersonalDesc" name="ubicacionPersonal" list="#{'0':'Sede Central','1':'Área Natural'}"
					    		onchange="ubicaciondelPersonal(this.value,'Desc')"
								headerKey="-1" headerValue="[--- Todos---]"
								value="0"
								title="Mostrar Personal por Ubicación"/>
					</div>
					
					<div class="col-lg-2 col-md-2 col-sm-2">
	                      	<label for="idcategorianpDesc" class="form-label">Categoría Área Natural Protegida.</label>
	                       <s:select id="idcategorianpDesc"
	                                name="idcategoriaanp"
				           			headerKey="-1" headerValue="[-- Seleccione Categoría--]"
					                list="listcategoriaanp"
					                listKey="idcategoriaanp"
					                listValue="descategoriaanp"										                
					             	cssClass="form-control"	
					             	disabled="true"
					             	onclick="loadANPs(this.value, 'Desc')" >	
							</s:select>
	
	                </div>
					<div class="col-lg-4 col-md-4 col-sm-4">
	                      	<label for="listANPDesc" class="form-label">Área Natural Protegida.</label>
	                       <s:select id="listANPDesc"
	                                name="idareanatural"
				           			headerKey="" headerValue="[-- Seleccione ANP --]"
					                list="listareanatural"
					                listKey="idareanatural"
					                listValue="desareanatural"										                
					             	cssClass="form-control"
					             	disabled="true"	
					             	onchange="filtraApellidosOfDescuentoInicial()">
	
	
							</s:select>
	
	                </div>
				
				</div>
					<br>
				<div class="row form-row" >	
					<div class="col-lg-12 col-md-12 col-sm-12 " >
						<s:if test="%{#request.reportParams['cantdescuentos'] > 0}">
							<s:if test="%{reportParams['descValidados'] == 0 }">								
								<br>
								<input class="btn btn-primary pull-right" type="button" value="Cerrar reporte Descuentos" class="submit3" id="btnValidarDescuentos" title ="Validar Reporte Descuentos" />
							</s:if>
							<s:else>		
								<input class="btn btn-primary  pull-right" type="button" value="REPORTE DESCUENTOS CERRADO" class="submit2" id="btnDescuentosCerrado" />
							</s:else>
									
	<!-- 						<input class="btn btn-primary" type="button" onclick="javascript:oTableDefault.fnClearTable();this.form.reset();" value="Limpiar Busqueda"> -->
						</s:if>
					
					</div>
				</div> 
				

			</div>			

			<div class="grid-body no-border">			
			
				<s:if test="%{#request.reportParams['cantdescuentos'] > 0}">
								
						<div id="DivListadoPersonalDescuento">
					
						</div>

						<p><strong>Exportar: </strong> 
						<s:a id="pdfLink" action="downloadreportedecuentos.action" onclick="javascript:obtenerRegimen('');" >PDF	</s:a> |	
						<s:a id="xlsLink" action="downloadreportedecuentosXLS.action" onclick="javascript:obtenerRegimen('XLS');" >XLS</s:a> 
						<br />
						
						<script type="text/javascript">
							$().ready(function(){
							
// 								filtraApellidosOfDescuentoInicial();
								filtrarDescuentosxperiodo();
							});
						</script>
				
				</s:if> 
				<s:else> 
					<div id="msgSinDescuento">
						<s:actionmessage id="msgSinDescuento" cssClass="alertamsg" cssStyle="display: block;" /> 
					</div>			
				</s:else> 
			
			
			</div>

			<br />


		</div>
	</div>

	</div>
	<!-- end grid simple -->
</div>
<!-- end row -->

<!-- end page-content -->

<!-- END PAGE -->


<s:hidden name="dtpage" id="dtpage" />	
<div id="Divmodalinasistenciaspermisos"></div>

<div id="dialog-info-desc" hidden="true">
  <p><strong>¿Estás seguro en generar los descuentos?</strong></p>
</div>

<div id="dialog-info-descvalidar" hidden="true">
  </br>
  <p> <strong> <font color="red">CERRAR:  Permite validar y cerrar la generación de descuentos.</font></strong></p>
  </br>
  <p> <strong> <font color="red">¿ESTÁS SEGURO EN CERRAR LOS DESCUENTOS?</font></strong></p>
</div>
<div id="dialog-info-descvalidar2" hidden="true">  
  </br>
  <p> <strong> <font color="red">¿ESTÁS SEGURO EN CERRAR LOS DESCUENTOS Y CONVERTIRLOS EN DEFINITIVOS?</font></strong></p>
</div>

