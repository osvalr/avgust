<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page pageEncoding="UTF-8"%> 
  
<s:if test="%{datosJson2.length()>0}"> 
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
	<html xmlns="http://www.w3.org/1999/xhtml"> 
	<head>  
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<base href='<s:property   value="#application.url" />'  />
	<link rel="stylesheet" type="text/css" media="screen" href="css/_base.css" />  
	<link rel="stylesheet" type="text/css" media="screen" href="css/turismo.css" />   
	<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" >
     var routes=${datosJson1};
     var json=${datosJson2}; 
    </script>
        <script type="text/javascript" src="js/lib/highcharts/highcharts.js"></script>  
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
	    <script type="text/javascript" src="js/general.js"></script> 
	    <script type="text/javascript" src="js/turismo.estadisticas.js"></script>   
	       
	</head>
	<body id="home">  
	
		<div id="wrap">
			<div id="content">
				<h1> Reporte de Turismo </h1>
					<h3><s:property value="#session.area.desareanatural" /></h3>  
					
					<div id="charts">
						<h4><strong>Cuadro N°1:</strong> Cantidad de Visitantes por Circuito Turístico</h4>
						<div id="area_div" class="chart"></div>
							
						<h4><strong>Grafica N°1:</strong> Porcentaje de Ingresos a los principales circuitos del  
							<s:property value="#session.area.desareanatural" />
							<select class="selectchart" chart="ruta" >
								<option value="PieChart">Pie</option> 
								<option value="ColumnChart">Barras Vertical</option>
								<option value="LineChart">Linea</option>
								<option value="BarChart">Horizontal Vertical</option>
							</select> 
						</h4>
						<div id="ruta_chart_div" class="chart"></div>
						
						<h4><strong>Cuadro N°2:</strong> Cantidad de visitantes por mes
						</h4>
						<div id="month_div" class="chart"></div>
						
						<h4><strong>Grafica N°2:</strong> Ingreso de Turistas por Circuito y por Mes
							<select class="selectchart" chart="mes" >
								<option value="LineChart">Linea</option>
								<option value="ColumnChart">Barras Vertical</option>
								<option value="PieChart">Pie</option>
								<option value="BarChart">Horizontal Vertical</option>
							</select>
						</h4> 
						<div id="mes_chart_div" class="chart"></div>
						
						<h4><strong>Cuadro N°3:</strong>Ingreso de Turistas  por Nacionalidad</h4>
						<div id="table_div" class="chart"></div>
						<h4><strong>Grafica N°3:</strong> Ingreso de Turistas por Nacionalidad
							<select class="selectchart" chart="nacionalidad" >
								<option value="ColumnChart">Barras Vertical</option>
								<option value="PieChart">Pie</option>
								<option value="LineChart">Linea</option>
								<option value="BarChart">Horizontal Vertical</option>
							</select>
						</h4>
						<div id="nacionalidad_chart_div" class="chart"></div>
						
						
						
						<h4><strong>Cuadro N°4:</strong>Recaudación por concepto de turismo</h4>
						<div id="recaudacion_div" class="chart"></div>
						<h4><strong>Grafica N°4:</strong> Recaudación por concepto de turismo
							<select class="selectchart" chart="recaudacion_chart_div" >
								<option value="LineChart">Linea</option>
								<option value="ColumnChart">Barras Vertical</option>
								<option value="PieChart">Pie</option>
								<option value="BarChart">Horizontal Vertical</option>
							</select>
						</h4>
						<div id="recaudacion_chart_div" class="chart"></div>
						
						
						
						<div id="data_div"></div>
						
						
					</div>
					
					
			</div>
		</div> 
	</body>     
	</html> 
</s:if>
<s:else>
0
</s:else>