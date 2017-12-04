<%@page pageEncoding="UTF-8"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
	<html xmlns="http://www.w3.org/1999/xhtml"> 
	<head>  
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<base href='<s:property   value="#application.url" />'  /> 
	<link rel="stylesheet" type="text/css" media="screen" href="css/_base.css" />  
	<link rel="stylesheet" type="text/css" media="screen" href="css/turismo.css" />   
   <script type="text/javascript" src="js/jquery.min.js"></script>
   <script type="text/javascript" src="js/general.js"></script> 
    
   <script type="text/javascript" src="js/lib/highcharts/highcharts.js"></script>  
	<script  type="text/javascript" src="js/lib/highcharts/modules/exporting.js" ></script>
	<script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript" >
     var routes=${datosJson1};
     var json=${datosJson2}; 
    </script>
    
    <script type="text/javascript" >
     
    $(document).ready(function() {
    	$('#cboanioreporte').live('change',
    			function(e){
			    var idanio=$(this).val();
			    if(idanio==0){
			    	alert("Seleccione un periodo");
			    	return ;
			    }
			   
			  
			    $('#formReporteTurismo').attr('action','turismo/estadisticas.action');
			    $('#formReporteTurismo').submit();
		  }
    	
    	);
    	
    });
    </script>
    
    <script type="text/javascript" src="js/turismo.reporte.js"></script>
	      
	</head>
 
 <body>


<s:if test="%{areanatural==null}">

No existe ese valor

</s:if>
<s:else>



<form id="formReporteTurismo" method="post">
   
   <div style="display: none;"> 
     <input type="text"  name="codareanatural"  value='<s:property value="cadena"/>'/>
   </div>
   
      
<h4> Reportes de Turismo: <s:property value="idanio" /><br/>
<span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span>
 </h4>
<label>
Periodo:
</label>
<s:select name="idanio"  
						list="listaAnio"   
						listKey="idtipo" 
						listValue="nombretipo" 
						 
						headerKey="0"  
						headerValue="Seleccione" 
						id="cboanioreporte"
						 cssStyle="font-size:10px"
						
					/> 

	<div id="charts">
	 
	</div>
	
	<div style="text-align: center;">
	<h3>
	<strong>Gr&aacute;fico N° 1</strong>
	</h3>
	<h4>
		PORCENTAJE DE VISITANTES POR RUTA TURISTICA
	</h4>
	</div>
	<div class="chart_div"  id="chart_div1" ></div>
	
	<div style="text-align: center;">
	<h3>
	<strong>Cuadro N° 1</strong>
	</h3>
	<h4>
		CANTIDAD DE VISITANTES POR RUTA TURISTICA
	</h4>
	</div>
		<table   class="ttur">
		<thead>
		<tr>
		
		<th >
			Ruta Tur&iacute;stica
		</th>
		<th style="width: 10px">
			Cantidad de Visitantes
		</th>
		<th >
			Porcentaje
		</th>
		
		
		</tr>
		</thead>
		<tbody>
		     <s:iterator value="listaReporte1" status="list">
		        <tr class="row <s:if test="#list.odd == true ">odd</s:if>">
		        <td>
		         <s:property value="nombrerutaturismo" /> 
		        </td>
		        <td>
		         <s:property value="total" /> 
		        </td>
		        <td>
		         <s:property value="percent" /> 
		        </td>
		        </tr>
		         
		        
		     </s:iterator> 
		      
		</tbody>
	</table>




     <div style="text-align: center;">
	<h3>
	<strong>Gr&aacute;fico N° 2</strong>
	</h3>
	<h4>
		CANTIDAD DE VISITANTES POR MES
	</h4>
	</div>
	<div class="chart_div"  id="chart_div2" ></div>
	
	
	<div style="text-align: center;">
	<h3>
	<strong>Cuadro N° 2</strong>
	</h3>
	<h4>
		CANTIDAD DE VISITANTES POR MES
	</h4>
	</div>
		<table  class="ttur" >
		<thead>
		<tr>
		
		<th >
			Ruta Turística
		</th>
		<th style="width: 20px;text-align: center;">
			Enero
		</th>
		<th style="width: 20px;text-align: center;">
			Febrero
		</th>
		<th style="width: 20px;text-align: center;">
			Marzo
		</th>
		<th style="width: 20px;text-align: center;">
			Abril
		</th>
		<th style="width: 20px;text-align: center;">
			Mayo
		</th>
		<th style="width: 20px;text-align: center;">
			Junio
		</th>
		<th style="width: 20px;text-align: center;">
			Julio
		</th>
		<th style="width: 20px;text-align: center;">
			Agosto
		</th>
		<th style="width: 20px;text-align: center;">
			Setiembre
		</th>
		<th style="width: 20px;text-align: center;">
			Octubre
		</th>
		<th style="width: 20px;text-align: center;">
			Noviembre
		</th>
		<th style="width: 20px;text-align: center;">
			Diciembre
		</th>
		
		
		
		</tr>
		</thead>
		<tbody>
		     <s:iterator value="listaReporte2"  status="list" >
		        <tr  class="row <s:if test="#list.odd == true ">odd</s:if>" >
		        <td>
		         <s:property value="nombrerutaturismo" /> 
		        </td>
		        <td>
		         <s:property value="enero" /> 
		        </td>
		        <td>
		         <s:property value="febrero" /> 
		        </td>
		        <td>
		         <s:property value="marzo" /> 
		        </td>
		        <td>
		         <s:property value="abril" /> 
		        </td>
		        <td>
		         <s:property value="mayo" /> 
		        </td>
		        <td>
		         <s:property value="junio" /> 
		        </td>
		        <td>
		         <s:property value="julio" /> 
		        </td>
		        <td>
		         <s:property value="agosto" /> 
		        </td>
		        <td>
		         <s:property value="setiembre" /> 
		        </td>
		        <td>
		         <s:property value="octubre" /> 
		        </td>
		        <td>
		         <s:property value="noviembre" /> 
		        </td>
		        <td>
		         <s:property value="diciembre" /> 
		        </td>
		        
		        </tr>
		         
		        
		     </s:iterator> 
		      
		</tbody>
	</table>
	
	
	<div style="text-align: center;">
	<h3>
	<strong>Gr&aacute;fico N° 3</strong>
	</h3>
	<h4>
		INGRESO DE TURISTAS POR NACIONALIDAD 
	</h4>
	</div>
	<div class="chart_div"  id="chart_div3" ></div>
	
	
	<div style="text-align: center;">
	<h3>
	<strong>Cuadro N° 3</strong>
	</h3>
	<h4>
		INGRESO DE TURISTAS POR NACIONALIDAD
	</h4>
	</div>
		<table  class="ttur" >
		<thead>
		<tr>
		<th style="width: 50px;text-align: center;">
			Mes
		</th>
		<th style="width: 40px;text-align: center;">
			Total
		</th>
		<th style="width: 40px;text-align: center;">
			Nacional
		</th>
		<th style="width: 40px;text-align: center;">
			Extranjero
		</th>
		
		
		</tr>
		</thead>
		<tbody>
		     <s:iterator value="listaReporte3" status="list" >
		        <tr  class="row <s:if test="#list.odd == true ">odd</s:if>" >
		        <td>
		         <s:property value="nommes" /> 
		        </td>
		        <td>
		         <s:property value="Total" /> 
		        </td>
		        <td>
		         <s:property value="Nacional" /> 
		        </td>
		        <td>
		         <s:property value="Extranjero" /> 
		        </td>
		        </tr>
		         
		        
		     </s:iterator> 
		      
		</tbody>
	</table>
	
	
	<br/>
	<div style="text-align: center;">
	<h3>
	<strong>Gr&aacute;fico N° 4</strong>
	</h3>
	<h4>
		RECAUDACION POR CONCEPTO DE TURISMO
	</h4>
	</div>
	<br/>
	<div class="chart_div"  id="chart_div4" ></div>
	
	
	
	
	
	<div style="text-align: center;">
	<h3>
	<strong>Cuadro N° 4</strong>
	</h3>
	<h4>
		RECAUDACION POR CONCEPTO DE TURISMO(S/.)
	</h4>
	</div>
		<table  class="ttur" >
		<thead>
		<tr>
		
		<th style="width: 50px;text-align: center;">
			Mes
		</th>
		<th style="width: 40px;text-align: center;">
			Total
		</th>
		<th style="width: 40px;text-align: center;">
			Boleto(S/.)
		</th>
		
		
		
		</tr>
		</thead>
		<tbody>
		     <s:iterator value="listaReporte3" status="list">
		        <tr  class="row <s:if test="#list.odd == true ">odd</s:if>" >
		        <td>
		         <s:property value="nommes" /> 
		        </td>
		        <td>
		         <s:property value="Total" /> 
		        </td>
		        <td>
		         <s:property value="Boleto" /> 
		        </td>
		        </tr>
		         
		        
		     </s:iterator> 
		      
		</tbody>
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- DIV CHART  -->
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
	<!-- END -->
	</form>


</s:else>



	


 </body> 
	</html> 

		 