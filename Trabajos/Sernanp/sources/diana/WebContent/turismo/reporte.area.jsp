<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%> 
	
	<script type="text/javascript" src="js/lib/highcharts/highcharts.js"></script>  
	<script  type="text/javascript" src="js/lib/highcharts/modules/exporting.js" ></script>
<!--	<script type="text/javascript" src="http://www.google.com/jsapi"></script>-->
    <script type="text/javascript" >
     var routes=${datosJson1};
     var json=${datosJson2}; 
    
    </script>
    <script type="text/javascript" src="js/turismo.reporte.js"></script>
    
   <form id="formReporteTurismo" method="post">
   
   
 
      
<h1> Reportes de Turismo: <s:property value="idanio" /><br/>
<span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span>
 </h1>

<s:select name="idanio"  
						list="listaAnio"   
						listKey="idtipo" 
						listValue="nombretipo" 
						 
						headerKey="0"  
						headerValue="Seleccione" 
						id="cboanioreporte"
						 
						
					/> 

	<div id="charts">
	 
	</div>
	
	
	
	
	<br>
	
	
	<div style="margin: auto;text-align: center;">
	
	
	<h3>
	<strong>Cuadro N° 1</strong>
	</h3>
	<h4>
		CANTIDAD DE VISITANTES MENSUAL
	</h4>
	<table   class="ttur tsum" >
		<thead>
		<tr>
		<th rowspan="2" >Mes</th>
		<th rowspan="2">Total</th>
		<th colspan="2">Origen</th>
		<th colspan="2">Genero</th>
		<th colspan="3">Ocupaci&oacute;n</th>
		<th colspan="3">Motivo de Visita</th>
		</tr>
		<tr>
		<th >Nacional</th>
		<th >Extranjero</th>
		<th >Masculino</th>
		<th >Femenino</th>
		<th >Estudiante</th>
		<th >Profesional</th>
		<th >Otros</th>
		<th >Turismo</th>
		<th >Estudio</th>
		<th >Otros</th>
		
		</tr>
		</thead>
		<tbody>
		     <s:iterator value="listaReporte3" status="list" >
		        <tr  class="row <s:if test="#list.odd == true ">odd</s:if>" >
		        <td>${nommes}</td>
		        <td>${total}</td>
		        <td>${nacional}</td>
		        <td>${extranjero}</td>
		        <td>${masculino}</td>
		        <td>${femenino}</td>
		        <td>${estudiante}</td>
		        <td>${profesional}</td>
		        <td>${otrosocupacion}</td>
		        <td>${turismo}</td>
		        <td>${estudio}</td>
		        <td>${otrosmotivovisita}</td>
		        </tr>
		         
		        
		     </s:iterator> 
		      
		</tbody>
	</table>
	<br>
	<h3>
	<strong>Gr&aacute;fico N° 1</strong>
	</h3>
	<h4>
		CANTIDAD DE VISITANTES POR NACIONALIDAD
	</h4>
   <div class="chart_div"  id="chart_div1" ></div>
	<br>
	
	
	</div>
	
	<br/>
	
	
	
	<div style="text-align: center;">
	<h3>
	<strong>Cuadro N° 2</strong>
	</h3>
	<h4>
		CANTIDAD DE VISITANTES POR RUTA TURISTICA
	</h4>
	<table  class="ttur tsum" >
		<thead>
		<tr>
		<th >Ruta Tur&iacute;stica</th>
		<th >Cantidad de Visitantes</th>
		<th >Porcentaje</th>
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
	
	<br>
	<h3>
	<strong>Gr&aacute;fico N° 2</strong>
	</h3>
	<h4>
		PORCENTAJE DE VISITANTES POR RUTA TURISTICA
	</h4>
	<div class="chart_div" style="text-align: center;" id="chart_div2" ></div>
	
	
	</div>
	
	<br>
		




     <div style="text-align: center;">
	
	<h3>
	<strong>Cuadro N° 3</strong>
	</h3>
	<h4>
		CANTIDAD DE VISITANTES MENSUAL POR RUTA TURISTICA
	</h4>
		<table  class="ttur tsum" >
		<thead>
		<tr>
		<th >Ruta Turística</th>
		<th >Enero</th>
		<th >Febrero</th>
		<th >Marzo</th>
		<th >Abril</th>
		<th >Mayo</th>
		<th >Junio</th>
		<th >Julio</th>
		<th >Agosto</th>
		<th >Setiembre</th>
		<th >Octubre</th>
		<th >Noviembre</th>
		<th >Diciembre</th>
		</tr>
		</thead>
		<tbody>
		     <s:iterator value="listaReporte4"  status="list" >
		        <tr  class="row <s:if test="#list.odd == true ">odd</s:if>" >
		        <td><s:property value="nombrerutaturismo" /> </td>
		        <td>${enero}</td>
		        <td>${febrero}</td>
		        <td>${marzo}</td>
		        <td>${abril}</td>
		        <td>${mayo}</td>
		        <td>${junio}</td>
		        <td>${julio}</td>
		        <td>${agosto}</td>
		        <td>${setiembre}</td>
		        <td>${octubre}</td>
		        <td>${noviembre}</td>
		        <td>${diciembre}</td>
		        </tr>
		         
		        
		     </s:iterator> 
		      
		</tbody>
	</table>
	<br>
	<h3>
	<strong>Gr&aacute;fico N° 3</strong>
	</h3>
	<h4>
		CANTIDAD DE VISITANTES MENSUAL POR RUTA TURISTICA
	</h4>
	</div>
	<div class="chart_div" style="text-align: center;" id="chart_div3" ></div>
	
	
	<br>
	
	<div style="text-align: center;">
	
	<h3>
	<strong>Cuadro N° 4</strong>
	</h3>
	<h4>
		RECAUDACION POR CONCEPTO DE TURISMO
	</h4>
	<table class="ttur tsum">
		<thead>
		<tr>
	   <th >Mes</th>
	   <th>Total</th>
	   <th >Boleto</th>
		</tr>
		</thead>
		<tbody>
		     <s:iterator value="listaReporte3" status="list">
		        <tr  class="row <s:if test="#list.odd == true ">odd</s:if>" >
		        <td><s:property value="nommes" /> </td>
		        <td><s:property value="Total" /> </td>
		        <td><s:property value="Boleto" /> </td>
		        </tr>
		         
		        
		     </s:iterator> 
		      
		</tbody>
	</table>
	<span style="font-size:9px;font-weight:bold:">*No se considera el monto del boletaje adicional</span> 
	<br>
	<h3>
	<strong>Gr&aacute;fico N° 4</strong>
	</h3>
	<h4>
		RECAUDACION POR CONCEPTO DE TURISMO
	</h4>
	<br/>
	<div class="chart_div" style="text-align: center;" id="chart_div4" ></div>
	
	
	
	
	</div>
		
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
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
 