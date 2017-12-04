 <%@page pageEncoding="UTF-8"%>

		
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
			//alert("Test");
			//-->
		</script>
		
<!--		<script>-->
<!--				// increase the default animation speed to exaggerate the effect-->
<!--				$.fx.speeds._default = 500;-->
<!--				function DetalleAreas(anios){-->
<!--					$.fx.speeds._default = 500;-->
<!--					-->
<!--						$( "#dialog" ).dialog({-->
<!--							autoOpen: false,-->
<!--							show: "blind",-->
<!--							hide: "explode"-->
<!--						});-->
<!--						-->
<!--							$( "#dialog" ).dialog( "open" );-->
<!--							$("#cod").html("<b>COD. Activo.! :</b> ");-->
<!--							$("#anio").html("<b>AÑO Act.! :"+anios+"</b> ");-->
<!--							$("#desc").html("      DESC. Act.!");-->
<!--							$("#ext").html("       EXT. Act. !");-->
<!--							return false;-->
<!--						-->
<!--				}-->
<!--				-->
<!--		</script>-->
		
		<div class='chartdata h' id="dataTableChart" style="display:none">
		<div class="showchartdata">Mostrar/Ocultar Cuadro</div>
		<div class="h table">
			<table >
				<thead>
					<tr>
						<th>Año</th><th>Total de Areas Naturales</th> 
						<th>Extensión total</th>
<!-- 						<th></th> -->
					</tr>
				</thead> 
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
	
	
	




		
<!--		<h1>Reporte de Variación de las Áreas Naturales</h1>-->
		

		<div class="period h" id="periodo_wrapper">
			<strong>Mostrando Periodo :</strong> 
			<select id="periodo">
				<option value="1">Año</option>
				<option value="2" selected="selected">Bienio</option>
				<option value="5">Quinquenio</option>
				<option value="10">Decenio</option>
			</select>
		</div>
<div id="charts">
</div>

<!-- ESTO ESTOY MODUIFICANDO -->
<div id='renovar'>
<div id="dialog-modal" title="Detalles ANP" >
		<div  id="contenedordeModalDialog" >
		</div>
</div>
</div>
<!-- MODIF.EDGAR -->
<!--		<script type="text/javascript">	-->
<!--		$(document).ready(function(){-->
<!--		suma();-->
<!--		Pintar(0)})-->
<!--		</script>-->