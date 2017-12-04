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
	<script type="text/javascript" src="js/jquery.reject.min.js"></script>	
	
	<link rel="stylesheet" type="text/css" media="all" href="css/_base.css" />
		<link rel="stylesheet" type="text/css" media="all" href="css/login.css" />
		
		<script >
		
		
		
		/* $(document).ready(
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
				
		); */
	
		</script>
		
</head>
<body id="home"> 
<div id="wrap">
	<div id="content" class="r">
<!-- Content -->

		<div id="loginLogo"><img alt="SERNANP" src="img/logo.sernanp.jpg" /> Sistema Integrado de SERNANP</div>
		<div id="loginPanel" class="r l">
			<h1>Ingresar al sistema</h1> 
			<form action="<%=request.getContextPath() %>/Login.action" method="post">
			<input type="hidden"  name="paginalogin"  value="1" />
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
		
		<div>
		  <img src="<%=request.getContextPath() %>/img/portadaoperador.jpg" />
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