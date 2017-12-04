 <%@page pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>  
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href='<s:property   value="#application.url" />'  />
	<title>SERNANP::</title>
	<link rel="stylesheet" type="text/css" media="all" href="css/_base.css" />
	<link rel="stylesheet" type="text/css" media="print" href="css/print.css" /> 
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/general.js"></script>
	<script src="js/anp.reporte.js"></script>   
	<link rel="stylesheet" href="css/turismo.css" type="text/css" />
 
</head>

<body id="home"> 

	<div id="wrap">


		<div id="content" class="r"> 
				<!-- 1. Add these JavaScript inclusions in the head of your page --> 
				<script type="text/javascript" src="js/lib/highcharts/highcharts.js"></script>   
			  
				<!-- 1a) Optional: add a theme file --> 
				<!--
					<script type="text/javascript" src="../js/themes/gray.js"></script>
				--> 
				<!-- 1b) Optional: the exporting module -->   
				<script type="text/javascript" src="js/lib/highcharts/modules/exporting.js"></script> 
				<script type="text/javascript"> 
					<!--
					
					var data = ${list};
					var datatemp = ${json};
					//-->
				</script>
				 
				<!-- 3. Add the container --> 
				<div class='chartdata h' id="dataTableChart">
					<div class="showchartdata">Mostrar/Ocultar Cuadro</div>
					<div class="h table">
					<table >
						<thead>
							<tr>
								<th>Año</th><th>Total de Areas Naturales</th> 
								<th>Extensión total</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					</div>
				</div>
		
		</div>


	</div> 

</body> 

</html>   