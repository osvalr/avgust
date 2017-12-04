<%@taglib prefix="s" uri="/struts-tags" %>
  
    <div class="clearfix"></div>
    <div class="content">
      <ul class="breadcrumb">
        <li>
          <p>Recursos humanos </p>
        </li>
        <li><a href="#" class="active">Registrar Convocatoria</a> </li>
      </ul>
      <div class="page-title">
        <h3>Registrar <span class="semi-bold">Convocatoria</span></h3>
      </div>
            
       <div class="row-fluid">
        <div class="span12">
          <div class="grid simple ">
            <div class="grid-title">
              <button type="button" id="btnRegistrarConvocatoria" onclick="registrar();" class="btn btn-info btn-cons">Registrar Convocatoria</button>
              <button type="button" class="btn btn-white btn-cons" onclick="filtrar();">Filtrar</button>
              </div>



		<div class="grid-body no-border" id="formRegistro" >
        <br>
		<div class="alert">
                  <button class="close" data-dismiss="alert"></button>
                  Warning:&nbsp;Your monthly traffic is reaching limit. </div>

			<form class="form-no-horizontal-spacing" id="form-condensed" novalidate="novalidate">	
              <div class="row">
                <div class="col-md-6">
                
                <h4 class="semi-bold">I. <span class="light">Información de la Convocatoria</span></h4>
                                                     
                   <div class="row form-row">
                    
                      
                      <div class="col-md-6">
                        <input name="r_num_convocatoria" id="r_num_convocatoria" type="text" class="form-control" placeholder="Nº de Convocatoria">
                      </div>
                      <div class="col-md-3">
                      
                        <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input  type="text" id="r_fecha_vigencia_inicio" name="r_fecha_vigencia_inicio" class="form-control" placeholder="F.V Inicio">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                        </div>    
                       
                                       
                    
                      </div>
                      <div class="col-md-3">
                       <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input name="r_fecha_vigencia_finaliza" id="r_fecha_vigencia_finaliza" type="text" class="form-control" placeholder="F.V Finaliza">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                      </div>
                      </div>
                   </div>
                   <div class="row form-row">   
                      <div class="col-md-12">
                        <textarea name="r_descripcion_convocatoria" id="r_descripcion_convocatoria" class="form-control" placeholder="Descripción"></textarea>
                      </div>
                   </div>
                       
                   <div class="row form-row">   
                       <div class="col-md-12">
								<s:select cssClass="select2 form-control select2-offscreen" tabindex="-1" 
                        		  headerKey="" headerValue="Area Organica" list="listAreaOrganica" 
                        		  name="r_area_organica" id="r_area_organica" listKey="idarea" listValue="desarea" />
                      </div>
                      
                      </div>
                     
                </div>
               
              </div>
				<div class="form-actions">
					
					<div class="pull-left">
					  <button class="btn btn-primary btn-cons" type="button" onclick="registrarEditar()"><i class="icon-ok"></i> Grabar</button>
					  <button class="btn btn-white btn-cons" type="button">Cancelar</button>
					</div>
				  </div>
			</form>

		</div>


		 <div class="grid-body no-border" id="formFiltrar" >

			<form class="form-no-horizontal-spacing" id="form-condensed" novalidate="novalidate">	
              <div class="row">
                <div class="col-md-6">
                
                <h4 class="semi-bold">II. <span class="light">Filtrar Convocatorias</span></h4>
                                                     
                   <div class="row form-row">
                    
                      
                      <div class="col-md-3">
                        <input name="f_num_convocatoria" id="f_num_convocatoria" name="f_num_convocatoria" type="text" class="form-control" placeholder="Nº de Convocatoria">
                      </div>
                      <div class="col-md-3">
                        <input name="f_anho_convocatoria" id="f_anho_convocatoria" name="f_anho_convocatoria" type="text" class="form-control" placeholder="Año">
                      </div>
                      <div class="col-md-3">
                      
                        <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input  type="text" id="f_fecha_vigencia_inicio" name="f_fecha_vigencia_inicio" class="form-control" placeholder="F.V Inicio">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                        </div>    
                       
                      </div>
                      <div class="col-md-3">
                       <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input name="f_fecha_vigencia_finaliza" id="f_fecha_vigencia_finaliza" type="text" class="form-control" placeholder="F.V Finaliza">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                      </div>
                      </div>
                   </div>
                   <div class="row form-row">   
                      <div class="col-md-12">
                        <textarea name="f_descripcion_convocatoria" id="f_descripcion_convocatoria" class="form-control" placeholder="Descripción"></textarea>
                      </div>
                   </div>
                       
                   <div class="row form-row">   
                       
                      <div class="col-md-3">
                      
                        <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input  type="text" id="f_fecha_registro_desde" name="f_fecha_registro_desde" class="form-control" placeholder="F.R Desde">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                        </div>    

                      </div>
                      
                      <div class="col-md-3">
                       <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input name="f_fecha_registro_hasta" id="f_fecha_registro_hasta" type="text" class="form-control" placeholder="F.R Hasta">
                        <span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
                      </div>
                      
                      </div>
                       
                       <div class="col-md-6">
                           <select name="f_area_organica" id="f_area_organica" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="">Area Organica</option>
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                        
                        <s:select cssClass="select2 form-control select2-offscreen" tabindex="-1" 
                        		  headerKey="" headerValue="Area Organica" list="listAreaOrganica" 
                        		  name="f_area_organica" id="f_area_organica" listKey="idarea" listValue="desarea" />
                        
                      </div>
                      

                      
                      </div>
                      <div class="row form-row">   
                      
                      <div class="col-md-6">
                           <select name="f_estado_convocatoria" id="f_estado_convocatoria" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">En Proceso</option>
                          <option value="2">Desierto</option>
                          <option value="3">Finalizado</option>
                        </select>
                      </div>
                      
                      </div>
                </div>
               
              </div>
				<div class="form-actions">
					
					<div class="pull-left">
					  <button class="btn btn-primary btn-cons" type="button" onclick="iniciarFiltro()"><i class="icon-ok"></i> Filtrar</button>
					  <button class="btn btn-white btn-cons" type="button">Cancelar</button>
					</div>
				  </div>
			</form>

</div>


            <div class="grid-body">
	
			<div class="row">
			
			<table class="table table-striped dataTable" id="tableDefault" >
               
                <thead>     
                  <tr>
                    <th>Numero</th>
                    <th>Descripcion</th>
                    <th>Area Organica</th>
                    <th>F.V Inicia</th>
                    <th>F.V Finaliza</th>
                    <th>Estado</th>
                    <th>Fecha de registro</th>
                    <th>Edicion</th>
                    <th>Cambiar Estado</th>
                  </tr>
                </thead>
                
           </table>
			
			</div>
			
            </div>
          </div>
        </div>
      </div>

    <!-- END PAGE -->
  </div>
