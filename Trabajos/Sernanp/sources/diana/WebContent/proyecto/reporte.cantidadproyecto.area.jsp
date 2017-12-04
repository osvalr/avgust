<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<script type="text/javascript" src="js/lib/highcharts/highcharts.js"></script>   
<script type="text/javascript"> 
			
var rows = ${datosJson2};
var rowsv = ${datosJson3};
var rowsc = ${datosJson4};
var nombreAreaTotal=[];
var cantTotal=[];
var cantVigentes=[];
var cantVencidos=[];
var nombreCantTotal=[];
var nombreCantVigTotal=[];
var nombreCantConTotal=[];
var chartbar;
var chartpietotal;
var chartpievigentes;
var chartpieconcluidos;
$(document).ready(function() {
	
	
	for(var i=0,t=rows.length;i<t;i++){
		nombreAreaTotal.push(rows[i].areanatural.desareanatural);
	    cantTotal.push(rows[i].cantidadProyectos);
	    cantVigentes.push(rows[i].cantidadProyectosVigente);
	    cantVencidos.push(rows[i].cantidadProyectosVencidos);
	    var nomcant=[];
	    nomcant.push(rows[i].areanatural.desareanatural);
	    nomcant.push(rows[i].cantidadProyectos);
	    nombreCantTotal.push(nomcant);
	}
	
	for(var i=0,t=rowsv.length;i<t;i++){
		
	    var nomcant=[];
	    nomcant.push(rowsv[i].areanatural.desareanatural);
	    nomcant.push(rowsv[i].cantidadProyectosVigente);
	    nombreCantVigTotal.push(nomcant);
	}
	
	for(var i=0,t=rowsc.length;i<t;i++){
		var nomcant=[];
	    nomcant.push(rowsc[i].areanatural.desareanatural);
	    nomcant.push(rowsc[i].cantidadProyectosVencidos);
	    nombreCantConTotal.push(nomcant);
	}
	
	chartbar = new Highcharts.Chart({
		chart: {
			renderTo: 'chart_div1',
			zoomType: 'xy',
			 defaultSeriesType: 'bar'

		},
		title: {
			text: 'Cantidad de Proyectos por ANP'
		},
		subtitle: { 
			text: 'Areas Naturales '
		},
		xAxis: [{
			categories: nombreAreaTotal

		}],
		
		
		yAxis: {
	         min: 0,
	         title: {
	            text: 'Cantidad de Proyectos',
	            align: 'high'
	         }
	      },


	      tooltip: {
	          formatter: function() {
	             return ''+
	                 this.series.name +': '+ this.y +' proyectos';
	          }
	       },

		
		
		legend: {
			layout: 'vertical',
			align: 'left',
			x: 800,
			verticalAlign: 'top',
			y: 50,
			floating: true,
			backgroundColor: '#FFFFFF'
		},
		 series: [{
	         name: 'Total',
	         data: cantTotal
	      },
	      {
		         name: 'Vigentes',
		         data: cantVigentes
		      },
		      {
			         name: 'Concluidos',
			         data: cantVencidos
			      }
	      
	      ]

	}); 
   
   
	
	
	
	
	
	
	
	
	
	
	chartpietotal = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div2',
	         plotBackgroundColor: null,
	         plotBorderWidth: null,
	         plotShadow: false
	      },
	      title: {
	         text: 'Cantidad de Proyectos'
	      },
	      tooltip: {
	         formatter: function() {
	            return '<b>'+ this.point.name +'</b>: '+ this.y ;
	         }
	      },
	      plotOptions: {
	         pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	               enabled: true,
	               color: '#000000',
	               connectorColor:  '#000000',
	               formatter: function() {
	                  return '<b>'+ this.point.name +'</b>: '+ this.y ;
	               }
	            }
	         }
	      },
	       series: [{
	         type: 'pie',
	         name: 'Browser share',
	         data: 
	        	
	        	 nombreCantTotal
	                 
	             
	        	 
	      }]
	   });

	
	
	
	chartpievigentes = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div3',
	         plotBackgroundColor: null,
	         plotBorderWidth: null,
	         plotShadow: false
	      },
	      title: {
	         text: 'Cantidad de Proyectos Vigentes'
	      },
	      tooltip: {
	         formatter: function() {
	            return '<b>'+ this.point.name +'</b>: '+ this.y ;
	         }
	      },
	      plotOptions: {
	         pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	               enabled: true,
	               color: '#000000',
	               connectorColor:  '#000000',
	               formatter: function() {
	                  return '<b>'+ this.point.name +'</b>: '+ this.y ;
	               }
	            }
	         }
	      },
	       series: [{
	         type: 'pie',
	         name: 'Browser share',
	         data: 
	        	
	        	 nombreCantVigTotal
	                 
	             
	        	 
	      }]
	   });
	
	
	chartpieconcluidos = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div4',
	         plotBackgroundColor: null,
	         plotBorderWidth: null,
	         plotShadow: false
	      },
	      title: {
	         text: 'Cantidad de Proyectos Concluidos'
	      },
	      tooltip: {
	         formatter: function() {
	            return '<b>'+ this.point.name +'</b>: '+ this.y ;
	         }
	      },
	      plotOptions: {
	         pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	               enabled: true,
	               color: '#000000',
	               connectorColor:  '#000000',
	               formatter: function() {
	                  return '<b>'+ this.point.name +'</b>: '+ this.y ;
	               }
	            }
	         }
	      },
	       series: [{
	         type: 'pie',
	         name: 'Browser share',
	         data: 
	        	
	        	 nombreCantConTotal
	                 
	             
	        	 
	      }]
	   });
	$("#cboChart").change(function(){
     	if(this.value=="") return ;
     	$(".chart_div").hide();
     	
         if($(this).val()==1){
         	$("#chart_div1").show();
         }
         else if($(this).val()==2){
         	$("#chart_div2").show();
         	$("#chart_div3").show();
         	$("#chart_div4").show();
         }
         
     	
     });
	/*
	var tabledata = $("#dataTableChart").clone();
	var filler = ""; 
	
	for( i=0 ;i<=counter;i++ ){ 
		if( (l in line) && ( line[l].year == (oldestyear + i) ) ){
			l++; 
		}
		var y = ((oldestyear + i).toString());
		var row = line[l-1]; 
		rows.extension.push( row.extension );    
		rows.areas.push( row.areas ); 
		rows.years.push( y.substring(2) );  
		filler +="<tr class='"+ (i%2? "odd":"") +"'><td>"+y+"</td><td>"+row.areas+
			"</td><td>"+row.extension+" ha.</td></tr>"; 
	}
	
	tabledata.show().find("tbody").html(filler); 
	tabledata.find(".showchartdata").click(function(){ 
		tabledata.find(".table").slideToggle();
	});
	*/
	
	
	
	
	
	
});
</script>

<div style="text-align: center;">
<h2>
<strong>Gr&aacute;fico N°1</strong>
</h2>

<h4>
Cantidad de Proyectos por Area Natural
<select id="cboChart" >
				<option value="1">Barras Vertical</option>
				<option value="2">Pie</option>
				
</select>
</h4>
</div>

<div class="chart_div" id="chart_div1"  style="height: 800px "></div>
<div style="margin-left: auto;margin-right: auto;text-align: center;">
<div class="chart_div"  id="chart_div2"  style="text-align: center;display: none;width:900px"></div>
<div  class="chart_div" id="chart_div3" style="display: none;float: left;width:900px"></div>
<div  class="chart_div" id="chart_div4" style="display: none;float: left;width:900px"></div>

</div>







<br>



<div style="text-align: center;">
<h2>
<strong>Cuadro N°1</strong>
</h2>

<h4>
Cantidad de Proyectos por ANP

</h4>
</div>



<div style="text-align: center;clear: both;">
<table  cellpadding='0' cellspacing='1' class="tablaList"
	 style="margin-right: auto;margin-left: auto;width: 1000px"  >
	
	<thead>
		<tr>
		<th rowspan="2" style="width: 100px;text-align: center;">
			Area Natural
		</th>
		<th  colspan="3" style="width: 50px;text-align: center;">
			Cantidad de Proyectos
		</th>
		</tr>
		<tr>
		<th style="width: 10px;text-align: center;">
			Total
		</th>
		<th style="width: 10px;text-align: center;">
			Vigentes
		</th>
		<th style="width: 10px;text-align: center;">
			Concluidos
		</th>
		
		</tr>
	</thead>
	 <tbody>
        <s:iterator value="listaConsolidadoAreaNatural" status="list">
          <tr   class="row <s:if test="#list.odd == true ">odd</s:if>" >
          <td style="text-align: left;width: 100px;"> 
		     <s:property value="areanatural.desareanatural"/>           
		   </td>
		   <td style="text-align: center;"> 
		     <s:property value="cantidadProyectos"/>           
		   </td>
		   <td  style="text-align: center;"> 
		     <s:property value="cantidadProyectosVigente"/>           
		   </td>
		   <td  style="text-align: center;"> 
		     <s:property value="cantidadProyectosVencidos"/>           
		   </td>
          </tr>
        </s:iterator>
        
     </tbody>
	</table>

</div>










		 