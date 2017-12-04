<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>
<!-- Content -->
<form name="formInicioDirectorio" id="formInicioDirectorio" method="post"
	action="#">
	
<div id="filters"> 

   
   
   
   <div style="float: left;width: 800px">
  
   
	<div >
     
     
     
	
     
        
     
     </div>
     
    
     <div >
     
     
    
   
    
     
     
    
	
     </div>
     
     <div>
     
      
       
	
	
	
     </div>
     
    
     
     
     
   </div>
   
   
   
    <div style="width: 100px;float: right;">
     <input type="button" id="btnBuscarProyectos" value="Buscar" class="submit" />
      <input type="button" id="btnLimpiarProyectos" value="Limpiar" class="submit" />
      <input type="button" id="btnNuevoProyecto" value="Nuevo" class="submit" /> 
       <br/>
       
	   <br/>
	    
	   
    </div>
   
   
   
   
   </div>
   
 
   
   
	


<input type="hidden" name="idProyectoParam" id="idProyectoParam" value="0"/>



<div  id="divListaDirectorio" style='border:none;clear:both;'>

<jsp:include page="/directorio/lista.directorio.jsp" />

</div>



</form>


<div id="divDetalleDirec">


</div>
