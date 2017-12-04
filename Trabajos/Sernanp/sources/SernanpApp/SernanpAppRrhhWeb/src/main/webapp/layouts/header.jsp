<%@taglib prefix="s" uri="/struts-tags" %>
<div id="head">
	
		<s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal!=0}">
		   
		   <div id="logo">
		   <a  class="linkopcionmodulo"  style="cursor: pointer;" >
		   <param  id="paramidmodulo" value="0" />    
<%-- 		   <param  id="paramhrefmodulo" value="<%=request.getContextPath() %>/Portada.action" /> --%>
				<param  id="paramhrefmodulo" value="/diana/Portada.action" />
<!--		     <param  id="param2" value="< %=request.getContextPath() %>/Portada.action" name="param2"/>-->
				<img alt="SERNANP" src="img/logo.sernanp.png"   /> 
				
			</a>
		  
			Sistema Integrado
		  </div>
	 	
	 	
	 	<s:if test="%{#session.USUARIO_ACTUAL}">
		 	<div id="session">
				Bienvenido: 
				<span class="upperlbl12">
				   ${USUARIO_ACTUAL.apepat } ${USUARIO_ACTUAL.apemat }, ${USUARIO_ACTUAL.nombre }
				</span>
				 |  
				<a style="cursor: pointer;">Configuracion</a> |
				<a style="cursor: pointer;">Ayuda</a> | 
<%-- 				<a href="<%=request.getContextPath() %>/Salir.action">Salir</a> --%>
				<a href="/diana/Salir.action">Salir</a>
			</div>
	 	</s:if>
		   
		   
		   
		</s:if>
		<s:else>
		    
		    
<s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal==0}">
		         <div id="logo"> 
			<a  class="linkopcionmodulo"  style="cursor: pointer;" >
				<param  id="paramidmodulo" value="0" /> 
				
				<s:if  test="%{#session.paginalogin==1}">
					<param  id="paramhrefmodulo" value="<%=request.getContextPath() %>/turismo/listarAreaTurOpe.action" />
				</s:if>
				<s:if test="%{#session.paginalogin==2}">
					<param  id="paramhrefmodulo" value="<%=request.getContextPath() %>/registro/inicioregistro.action" />
				</s:if>
				
				<img alt="SERNANP" src="img/logo.sernanp.png"   /> 
			</a>
			
			Sistema Integrado
		         </div>
	 	
	 	
	 	
		 	<div id="session">
				Bienvenido: 
				<span class="upperlbl12">
				  <s:property value="#session.operadorturismo.nombrepersonajuridica" /> 
				</span>
				 | |  
				<a id="linkModClaveUserOpTur" href="#">Cambiar Contraseña</a> | | 
				
				<s:if  test="%{#session.paginalogin==1}">
					<a href="<%=request.getContextPath() %>/salirOperador.action">Salir</a>
				</s:if>
				<s:if  test="%{#session.paginalogin==2}">
					<a href="<%=request.getContextPath() %>/salirRegistro.action">Salir</a>
				</s:if>
			</div>
			
			

		   <div id="divModalUsuarioOpTurismo" style="display: none">
     
       
      <form id="formModClaveUserOpTur">
     
     <span class="msg" style="color:red"> </span>
    
     <div id="divModClaveUserOpTur">  
      <div>
     <label style="width:130px">
     Usuario:
     </label>
     <s:property value="#session.operadorturismo.nombrepersonajuridica" /> 
    </div>
      <br>
      <div>
         <label style="width:130px">
        Contraseña Actual:
         </label>
         <input class="password valid txtclaveoptur"  type="password" name="clave1">
       </div>
        <br>  
      <div>
         <label style="width:130px">
         Contraseña Nueva:
         </label>
         <input class="password valid txtclaveoptur txtclavenew"  type="password" name="clave2">
       </div>
        <br>
        <div >
        <label style="width:130px">
         Repetir Contraseña Nueva:
        </label>
        <input   class="password valid txtclaveoptur txtclavenew" type="password" name="clave3">
        </div>
        <br>
         <div style="text-align: center;" >
           <input style="cursor: pointer;" id="btnModClaveUserOpTur"  type="button" value="Cambiar">
         </div>
     
     
   </div>  
         
         
      </form>
   <div class="divEspera" style="display: none;">
      Modificando clave
   </div>
   
    </div>
  
  
  
<input type="hidden"  id="hdModalUsuarioOpTurismo" 
<s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal!=0}">
value='0'
</s:if>
		<s:else>
		    <s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal==0 && #session.USUARIO_ACTUAL.firstlogin==0}">
		    value='1'
		    </s:if>
		</s:else>
>			
			
</s:if>
		
</s:else>    
		    
</div>