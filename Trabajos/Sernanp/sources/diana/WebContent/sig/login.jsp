<%@taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login SIG</title>
</head>
<body >
	<form style="display:none" id="loginsig" name="loginsig" method="post" 
		action="http://10.10.11.189:2903/sernanp_sig_d/valida_user.php" class="h">
		<input name="user" value="ejuandedioz" />
		<input name="password" value="myshua" /> 
		<input type="submit" />
	</form>  
	<script type="text/javascript">
		function login(){ 
			document.forms["loginsig"].submit();
		}
		login();
	</script>
</body>
</html>