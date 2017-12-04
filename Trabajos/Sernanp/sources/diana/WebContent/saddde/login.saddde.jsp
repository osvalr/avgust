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
		
<style type="">
.titleModulo{
margin-top: 30%;
font-size: 200%;
text-align: center;
font-family: "Times";
}
</style>				
</head>
<body id="home" > 
<div id="wrap" >
	<div id="content" class="r" >
<!-- Content -->

		<div id="loginLogo" style="text-align: center;"><img alt="SERNANP" src="img/logo.sernanp.jpg"  /> Sistema Integrado de SERNANP</div>
		<div id="loginPanel" class="r" style="margin: 0 auto;">
			<h1>Ingresar al sistema</h1> 
			<form action="<%=request.getContextPath() %>/Login.action" method="post">
			<input type="hidden"  name="paginalogin"  value="3" />
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
			
			<div class="titleModulo">M&oacute;dulo Archivo Digital<br />(SAD-DDE)</div>
			
			<div>
			<s:if test="$error != ''">${error}</s:if>
			</div>
			</form>
			<div class="forget">
<!-- 				<a href="/password.action" title="Olvidé mi password">¿Ha
						olvidado la contraseña?</a> -->
			</div>
		</div>
		
<!-- 		<div> -->
<%-- 		  <img src="<%=request.getContextPath() %>/img/portadaregistro.jpg" /> --%>
<!-- 		</div> -->
		
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