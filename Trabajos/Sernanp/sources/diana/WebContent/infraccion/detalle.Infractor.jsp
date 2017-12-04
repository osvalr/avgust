<%@ taglib prefix="s" uri="/struts-tags"%>



<div id="tabs">
	<ul>
		<li><a href="#tabs-1">DATOS DE INFRACTOR</a></li>
		<li><a href="#tabs-2">INFRACCIONES</a></li>
	</ul>
	<div id="tabs-1">
		<div style="text-align: center;">
		  <table  >
<!-- 		  <thead> -->
<!-- 		  <tr> -->
<!-- 		    <th> -->
<!-- 		    Dato -->
<!-- 		    </th> -->
<!-- 	        <th> -->
<!-- 		    Descripci&oacute;n -->
<!-- 		    </th> -->
<!-- 		  </tr> -->
<!-- 		 </thead> -->
<!-- 		 <tbody> -->
		 	<tr><td>Nombres:</td><td><s:property value='infraccion.infractor.personanatural.nombre' /></td></tr>
		 	<tr><td>Apellidos:</td><td><s:property value='infraccion.infractor.personanatural.apepat' /> 
		 	<s:property value='infraccion.infractor.personanatural.apemat' /></td></tr>
		 	<tr><td>DNI :</td><td><s:property value='infraccion.infractor.personanatural.numerodocumento' /></td></tr>
<!-- 		 </tbody> -->
		 </table>
	  
	  	    
	  </div>
	</div>
	<div id="tabs-2">
	
	
	</div>
	
</div>

