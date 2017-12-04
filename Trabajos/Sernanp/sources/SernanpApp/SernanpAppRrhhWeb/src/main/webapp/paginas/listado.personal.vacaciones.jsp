<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>




  <div class="page-content">
      <div class="row">
		<div class="page-title">
		
				<h3>
					Rol de <span class="semi-bold">Vacaciones</span>
				</h3>
		</div>

	    <ol class="breadcrumb">
	              <li><a href="index.html"><i class="fa fa-male"></i> Recursos Humanos</a></li>
	              <li class="active"><i class="fa fa-edit"></i> Rol de Vacaciones</li>
  
	    </ol>
     </div>   
          
	<div class="row">
		
		<div class="grid simple">
                           
				<div class="grid-title">
				  <div class="row form-row">
				   
				  		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				  		
<!-- 					        	<button class="btn btn-primary" type="button" onclick="javascript:oTableDefault.fnClearTable();$('#apellidoTrabajadorVac').val('');listapersonalVacacionesxApepatperiodo();"> -->
<!-- 									Limpiar Búsqueda -->
<!-- 								</button> -->
					     </div>
							
				   </div>
            
                 </div>
                 
                 <div class="grid-body no-border">
<%--                  <s:form> --%>
   
   							<div class="row form-row">
							
<!-- 										<div class="col-lg-3 col-md-6 col-sm-6"> -->
<!-- 										    <label for="apellidoTrabajador" class="form-label">Buscar por Apellido Paterno</label> -->
<!-- 										    <input type='text' class="form-control" name ='apellidoTrabajadorVac' id='apellidoTrabajadorVac' value='' size="25"	onkeyup="javascript:listapersonalVacacionesxApepatperiodoSoloNombres();" />	 -->
<!-- 										</div> -->
										
										<div class="col-lg-1 col-md-1 col-sm-1">
										    <label for="listVacPeriodo" class="form-label">Periodo</label>
												<s:select id='listVacPeriodo' 
												   listKey="int_periodo_vac"   
										  		   listValue="int_periodo_vac"  
										  		   name="int_periodo_vac"  
										  		   theme="simple"  
										 		   list="listaPeriodosVacaciones" 
										 		   cssClass="form-control" 
										 		   onchange="listapersonalVacacionesxApepatperiodo()"  
										 		/>
										</div>
										
										<div class="col-lg-2 col-md-2 col-sm-2">
				                        	<label for="estadoPersonal" class="form-label">Estado</label>
					                        <s:select id="estadoPersonal"
					                                    name="estadoPersonal"
									           			headerKey="-1" headerValue="[-- Todos --]"
										                list="#{'0':'Activo','1':'Inactivo'}"
										                value="0"
										             	cssClass="form-control"	
										             	onchange="listapersonalVacacionesxApepatperiodo()">


											</s:select>

				                        </div>
										
										
								     	<div class="col-lg-2 col-md-2 col-sm-2">
					                    	<label for="regimenContractualV" class="form-label">Régimen contractual</label>
					                    	<s:select id="regimenContractualV"
					                    		listKey="int_cod_regimen_contractual" 
					                    		listValue="var_descripcion_regimen_contractual"
					                    		name="int_cod_regimen_contractual"
					                    		headerKey="-1" headerValue="[--Todos--]"
					                    		value="3"
												list="regimenContractual"
					                    		onchange="listapersonalVacacionesxApepatperiodo()"
					                    		cssClass="form-control"                      		>		
					                    				                        	
					                    	</s:select>
					                    </div>
					                    
					             		<div class="col-lg-2 col-md-2 col-sm-2">
										    <label for=ubicacionPersonalVac class="form-label">Ubicación</label>
										    <s:select theme="simple" cssClass="form-control" id ="ubicacionPersonalVac" name="ubicacionPersonalVac" list="#{'0':'Sede Central','1':'Área Natural'}"
										    onchange="ubicaciondelPersonal(this.value,'Vac')"
											headerKey="-1" headerValue="[--- Todos---]"
											value="0"
											title="Mostrar Personal por Ubicación"/>
										</div>
										
										
										<div class="col-lg-2 col-md-2 col-sm-2">
				                        	<label for="idcategorianpVac" class="form-label">Categoría Área Natural Protegida.</label>
					                        <s:select id="idcategorianpVac"
					                                    name="idcategoriaanp"
									           			headerKey="-1" headerValue="[-- Seleccione Categoría--]"
										                list="listcategoriaanp"
										                listKey="idcategoriaanp"
										                listValue="descategoriaanp"										                
										             	cssClass="form-control"	
										             	disabled="true"
										             	onclick="loadANPs(this.value, 'Vac')" >


											</s:select>

				                        </div>
										<div class="col-lg-3 col-md-3 col-sm-3">
				                        	<label for="listANPVac" class="form-label">Área Natural Protegida.</label>
					                        <s:select id="listANPVac"
					                                    name="idareanatural"
									           			headerKey="" headerValue="[-- Seleccione ANP --]"
										                list="listareanatural"
										                listKey="idareanatural"
										                listValue="desareanatural"										                
										             	cssClass="form-control"
										             	disabled="true"	
										             	onchange="listapersonalVacacionesxApepatperiodo()">


											</s:select>

				                        </div>
														                        
						          
			                  </div>
<%--                  </s:form> --%>

					<div id="DivListadoPersonalVacaciones">
							   
					</div>
						
<%-- 						<p><strong>Exportar: </strong> --%>
<%-- 						<s:a action="downloadreportedecuentos.action">PDF</s:a> | --%>
<%-- 						<s:a action="downloadreportedecuentosXLS.action">XLS</s:a> --%>
					
				</div>
					
					<s:hidden name="dtpage" id="dtpage" />	
					
					<div id="DivmodalVacaciones"></div>
					<div id="divModalContenedorVacaciones"></div>
					
					<div id="dialog-info-vac" hidden="true">
						<br>
					  	<p><strong>Inconsistencia en cantidad de días.</strong></p>
					<%--   	<p><strong>Los d&iacute;as programados deben ser 7 como m&iacute;nimo, as&iacute; mismo los d&iacute;as pendientes mayor igual que 7 &oacute; 0.</strong></p> --%>
					</div>
					
					<div id="dialog-update-vac" hidden="true">
						<br>
					  	<p>Est&aacute; seguro que desea guardar los cambios?</p>
					</div>
					
				
					
					<div id="dialog-info-vacerrar" hidden="true">
					    <br>  <p> <strong>¿EST&Aacute; SEGURO QUE EL PERSONAL UTILIZO SUS VACACIONES?</strong></p>
					</div>
					
					<div id="dialog-info-eliminar" hidden="true">
					    <br>  <p> <strong>¿EST&Aacute; SEGURO QUE DESEA ELIMINAR LA PROGRAMACIÓN?</strong></p>
					</div>
						
		</div>
					
			<br />
                 
                 
	</div>
	
	
</div>
			<!-- end grid simple -->
<!-- 		</div> -->
		<!-- end row -->
<!-- 	</div> -->
	<!-- end page-content -->
	
	<!-- END PAGE -->
	


<script type="text/javascript">
$().ready(function(){
listapersonalVacacionesxApepatperiodo();
});
</script>
