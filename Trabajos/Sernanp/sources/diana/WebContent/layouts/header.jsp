<%@taglib prefix="s" uri="/struts-tags" %>
<div id="head">
		
	
		<s:if  test="%{#session.USUARIO_ACTUAL.personal.idpersonal!=0}">
		   
		   <div id="logo">
		   <a  class="linkopcionmodulo"  style="cursor: pointer;" >
		   <param  id="paramidmodulo" value="0" />    
		   <param  id="paramhrefmodulo" value="<%=request.getContextPath() %>/Portada.action" />
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
				<a href="<%=request.getContextPath() %>/Salir.action">Salir</a>
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
					<param  id="paramhrefmodulo" value="<%=request.getContextPath() %>/registro/listarAreaRegIng.action" />
				</s:if>
				<s:if test="%{#session.paginalogin==3}">
					<param  id="paramhrefmodulo" value="<%=request.getContextPath() %>/saddde/iniciosaddde.action" />
				</s:if>
				<s:if test="%{#session.paginalogin==4}">
					<param  id="paramhrefmodulo" value="<%=request.getContextPath() %>/redcap/inicioredcap.action" />
				</s:if>
				<s:if test="%{#session.paginalogin==5}">
					<param  id="paramhrefmodulo" value="<%=request.getContextPath() %>/convcain/inicioconvoca.action" />
				</s:if>
				
				<img alt="SERNANP" src="img/logo.sernanp.png"   /> 
			</a>
			
			Sistema Integrado
		         </div>
	 	
	 	
	 	
		 	<div id="session">
				Bienvenido: 
				<span class="upperlbl12">
				
				<s:if  test="%{#session.paginalogin < 3}">
					<s:property value="#session.operadorturismo.nombrepersonajuridica" />
				</s:if>
				<s:else>
					<s:property value="#session.usuarioexterno.apepat" />
					<s:property value="#session.usuarioexterno.apemat" />,
					<s:property value="#session.usuarioexterno.nombre" />
				</s:else>				
				  
				</span>
				 | |  
				<a id="linkModClaveUserOpTur" href="#">Cambiar Contraseņa</a> | | 
				
				<s:if  test="%{#session.paginalogin==1}">
					<a href="<%=request.getContextPath() %>/salirOperador.action">Salir</a>
				</s:if>
				<s:if  test="%{#session.paginalogin==2}">
					<a href="<%=request.getContextPath() %>/salirRegistro.action">Salir</a>
				</s:if>
				<s:if  test="%{#session.paginalogin==3}">
					<a href="<%=request.getContextPath() %>/salirSaddde.action">Salir</a>
				</s:if>
				<s:if  test="%{#session.paginalogin==4}">
					<a href="<%=request.getContextPath() %>/salirRedcap.action">Salir</a>
				</s:if>
				<s:if  test="%{#session.paginalogin==5}">
					<a href="<%=request.getContextPath() %>/salirConvoca.action">Salir</a>
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
        Contraseņa Actual:
         </label>
         <input class="password valid txtclaveoptur"  type="password" name="clave1">
       </div>
        <br>  
      <div>
         <label style="width:130px">
         Contraseņa Nueva:
         </label>
         <input class="password valid txtclaveoptur txtclavenew"  type="password" name="clave2">
       </div>
        <br>
        <div >
        <label style="width:130px">
         Repetir Contraseņa Nueva:
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