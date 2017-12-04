<%@ taglib prefix="s" uri="/struts-tags" %>

<style type="text/css">

</style>

<div class="page-container row">
  
  <div class="row-fluid">
        <div class="span12">
        
        
          <div class="grid simple">
          
            <div class="grid-title">
            
            <h4 class="semi-bold"><span class="light">Filtrar</span> <span class="bold">Expedientes</span></h4>
            </div>
            
        <div class="grid-body no-border" id="formFiltrar" style="overflow: hidden; display: block;">

			<form class="form-no-horizontal-spacing" id="form-condensed" novalidate="novalidate">	
              <div class="row">
                <div class="col-md-6">
                
                <br>
                                                     
                   <div class="row form-row">
                    
                      
                      <div class="col-md-10">
                        <input name="f_num_convocatoria" id="f_num_convocatoria" type="text" class="form-control" placeholder="Apellidos y nombres">
                      </div>

                      <div class="col-md-3">
                      
                        
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Tipo de documento</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                        
                       
                      </div>
                      
                      <div class="col-md-3">
                        <input name="f_fecha_vigencia_finaliza" id="f_fecha_vigencia_finaliza" type="text" class="form-control" placeholder="Nro Documento">
                      </div>
                      
                      <div class="col-md-3">
                        <input name="f_fecha_vigencia_finaliza" id="f_fecha_vigencia_finaliza" type="text" class="form-control" placeholder="Nro Ruc">
                      </div>
                      
                   </div>
                   <div class="row form-row">   


                      
                      <div class="col-md-3">
                        <input name="f_fecha_vigencia_finaliza" id="f_fecha_vigencia_finaliza" type="text" class="form-control" placeholder="Convocatoria">
                      </div>
                      
                      <div class="col-md-3">
                      
                        
                        <div class="select2-container select2 form-control" id="s2id_form3Gender">
                        <a href="javascript:void(0)" onclick="return false;" class="select2-choice" tabindex="-1">
                           <span class="select2-chosen">Estado</span>
                           <abbr class="select2-search-choice-close"></abbr> 
                             <span class="select2-arrow"><b></b></span></a>
                             <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen1">
                             <div class="select2-drop select2-display-none select2-with-searchbox"> 
                               <div class="select2-search">       
                               <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                                 </div>   <ul class="select2-results">   </ul>
                                 </div>
                                 </div>
                           <select name="form3Gender" id="form3Gender" class="select2 form-control select2-offscreen" tabindex="-1">
                          <option value="1">DNI</option>
                          <option value="2">Female</option>
                        </select>
                        
                       
                      </div>


                   </div>
                       
                   <div class="row form-row">   
                       
                      <div class="col-md-3">
                      
                        <div class="input-append success date col-md-11 col-lg-9 no-padding">
                        <input type="text" id="f_fecha_registro_desde" name="f_fecha_registro_desde" class="form-control" placeholder="F.R Desde">
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
					
					<div class="center-block">
					  <button class="btn btn-success btn-cons" type="button" onclick="iniciarFiltro()"><i class="icon-ok"></i> Filtrar</button>
					  <button class="btn btn-white btn-cons" type="button">Cancelar</button>
					</div>
				  </div>
			</form>

</div>  
              <div class="grid-body">          
 
 			<table class="table table-striped dataTable" id="tableDefault" >
               
                <thead>     
                  <tr>
                    <th>Numero Expediente</th>
                    <th>Nombres completos</th>
                    <th>Tipo documento</th>
                    <th>Numero documento</th>
                    <th>Ruc</th>
                    <th>Genero</th>
                    <th>Nacionalidad</th>
                    <th>Estado</th>
                    <th></th>
                    <th></th>
                    <th></th>
                  </tr>
                </thead>
                
                <tbody>
                
                 <tr>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td><button class="btn btn-success" onclick="">Editar</button></td>
                    <td><button class="btn btn-success" onclick="">Consultar</button></td>
                    <td><button class="btn btn-success" onclick="">Registrar Postulacion</button></td>
                  </tr>
                  
                  <tr>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td><button class="btn btn-success" onclick="">Editar</button></td>
                    <td><button class="btn btn-success" onclick="">Consultar</button></td>
                    <td><button class="btn btn-success" onclick="">Registrar Postulacion</button></td>
                  </tr>
                  
                  <tr>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td>XXXXXXXXX</td>
                    <td><button class="btn btn-success" onclick="">Editar</button></td>
                    <td><button class="btn btn-success" onclick="">Consultar</button></td>
                    <td><button class="btn btn-success" onclick="">Registrar Postulacion</button></td>
                  </tr>
                  
                  
 
                </tbody>
                
                <tfoot>     
                  <tr>
                    <th>Numero Expediente</th>
                    <th>Nombres completos</th>
                    <th>Tipo documento</th>
                    <th>Numero documento</th>
                    <th>Ruc</th>
                    <th>Genero</th>
                    <th>Nacionalidad</th>
                    <th>Estado</th>
                    <th></th>
                    <th></th>
                    <th></th>
                  </tr>
                </tfoot>
                
           </table>
                 
             </div><!--end grid-body -->
           
          </div><!-- end grid simple -->
        </div><!-- end span12 -->
      </div>
  
  
</div>  
 