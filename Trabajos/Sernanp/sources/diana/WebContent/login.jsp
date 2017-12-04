<%@taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 

<html>
<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<title>Login | SERNANP</title>
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" />
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.browser.min.js"></script>
	<%-- <script type="text/javascript" src="js/jquery.reject.min.js"></script> --%>	
	
	<link rel="stylesheet" type="text/css" media="all" href="css/_base.css" />
		<link rel="stylesheet" type="text/css" media="all" href="css/login.css" />
		
		<%-- <script >
		
		
		
		$(document).ready(
			function(){ 
				
				 $.reject({  
				        reject: {  
				        	 
				               
				        },imagePath:'img/browsers/' ,header:'<center><h2>\xBF Sab\xEDa usted que su explorador de Internet no est\xE1 actualizado ?</h2></center>'
				        		,paragraph1:'Su navegador no est\xE1 actualizado, y podria tener difilcutades al usar el Sistema SERNANP'
				        		,paragraph2: 'Por favor, instale uno de los muchos navegadores opcionales abajo para continuar<br><i>Basta con hacer clic en los iconos para acceder a la p\xE1gina de descarga</i>' // Paragraph 2  
				        		,display: ['chrome','firefox','msie'] // Displays only firefox, chrome, and opera
				        		,close: false
				    })  // Customized Browsers  
			}	 		
				
		);
	
		</script> --%>
		
</head>
<body id="home"> 
<div id="wrap">
	<div id="content" class="r">
<!-- Content -->

		<div id="loginLogo"><img alt="SERNANP" src="img/logo.sernanp.jpg" /> Sistema Integrado de SERNANP</div>
		<div id="loginPanel" class="r l">
			<h1>Ingresar al sistema</h1> 
			<form action="<%=request.getContextPath() %>/Login.action" method="post">
		    
			<input type="hidden"  name="paginalogin" value="0"  />
			<table>
			<tr>
				<td>
				<label >Usuario:</label>
				<input name="usuario.username" type="text" value="" class="input" size="20" />
				</td> 
			</tr>
			<tr>
				<td>
				<label >Clave:</label>
				<input name="usuario.clave" type="password" value="" class="input" size="20" />
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" id="login_label_login"
					 value="Ingresar" class="submit" /> 
				</td>
			</tr>				 
			</table>
			<div>
			<s:if test="$error != ''">${error}</s:if>
			</div>
			</form>
			<div class="forget">
<!-- 				<a href="/password.action" title="Olvidé mi password">¿Ha
						olvidado la contraseña?</a> -->
			</div>
		</div>
		<div id="modules" class="r l">
			<div class="module r"> 
			    <div class="title">SGD</div> 
			    
			    <div style=""><img src="http://intranet.sernanp.gob.pe/sistemas/img/img_1.jpg" width="50" height="70" /></div> 
			    <div style=""> 
			        <div class="cont">Sistema de Gesti&oacute;n de Documentos</div> 
			    </div> 
			</div> 
			<div class="module r"> 
			    
			    <div class="title">SAD</div> 
			    
			    <div style=""><img src="http://intranet.sernanp.gob.pe/sistemas/img/img_2.jpg" width="50" height="70" /></div> 
			    <div style=""> 
			    <div class="cont">Sistema de Archivo Digital</div> 
			    </div> 
			
			</div> 
			<div class="module r"> 
			
			    <div class="title">SASI</div> 
			    
			    <div style=""><img src="http://intranet.sernanp.gob.pe/sistemas/img/img_3.jpg" width="50" height="70" /></div> 
			    <div style=""> 
			    <div class="cont">Sistema de Autorizaci&oacute;n Para Solicitudes de Investigaci&oacute;n</div> 
			    </div> 
			    
			</div> 
			<div class="module r"> 
			    <div class="title">SIGANP</div> 
			    
			    <div style=""><img src="http://intranet.sernanp.gob.pe/sistemas/img/img_4.jpg" width="50" height="70" /></div> 
			    <div style=""> 
			    <div class="cont">Sistema Integrado de Gesti&oacute;n de &Aacute;reas Naturales Protegidas</div> 
			    </div> 
			</div> 
			<div class="module r"> 
			    <div class="title"></div> 
			    
			    <div style=""><img src="http://intranet.sernanp.gob.pe/sistemas/img/img_5.jpg" width="50" height="70" /></div> 
			    <div style=""> 
			    <div class="cont">M&oacute;dulo de Retenciones de Cuarta Categor&iacute;a</div> 
			    </div> 
			</div> 
			<div class="module r"> 
			    
			    <div class="title"></div> 
			    
			    <div style=""><img src="http://intranet.sernanp.gob.pe/sistemas/img/img_6.jpg" width="50" height="70" /></div> 
			    <div style=""> 
			    <div class="cont">M&oacute;dulo de Declaraci&oacute;n de Impuestos</div> 
			    </div> 
			
			</div> 
			<div class="module r"> 
			    
			    <div class="title"></div> 
			    
			    <div style=""><img src="http://intranet.sernanp.gob.pe/sistemas/img/img_7.jpg" width="50" height="70" /></div> 
			    <div style=""> 
			        <div class="cont">Mapas de &Aacute;reas Naturales Proteg&iacute;das</div>                    
			    </div> 
			</div> 
			<div class="module r"> 
			    
			    <div class="title"></div> 
			    
			    
			    <div style=""><img src="http://intranet.sernanp.gob.pe/sistemas/img/convenio_.jpg"  /></div> 
			    <div style=""> 
			        <div class="cont2">Convenios SERNANP</div> 
			    </div> 
			</div> 
		</div>
<!-- End Content -->
	</div>
	<div id="footer">
		<div>
			&copy; SERNANP  | Todos los derechos reservados. 
		</div>
	</div>  
</div>
</body>
</html>