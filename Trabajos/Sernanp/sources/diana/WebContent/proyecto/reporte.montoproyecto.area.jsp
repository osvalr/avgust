<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
		<script type="text/javascript" src="js/lib/highcharts/highcharts.js"></script>   
		<script type="text/javascript"> 
			
var rows = ${datosJson2};
var rowsv = ${datosJson3};
var rowsc = ${datosJson4};
var nombreAreaTotal=[];
var montTotal=[];
var montVigentes=[];
var montVencidos=[];
var nombreMontTotal=[];
var nombreMontVigTotal=[];
var nombreMontConTotal=[];
var chartbar;
var chartpietotal;
var chartpievigentes;
var chartpieconcluidos;
$(document).ready(function() {
	
	
	for(var i=0,t=rows.length;i<t;i++){
		nombreAreaTotal.push(rows[i].areanatural.desareanatural);
		var m=parseFloat(rows[i].montoTotalProyectos);
    	m=Math.round(m*100)/100;
    	var v=parseFloat(rows[i].montoTotalVigente);
    	v=Math.round(v*100)/100;
    	var c=parseFloat(rows[i].montoTotalVencido);
    	c=Math.round(c*100)/100;
    	montTotal.push(m);
    	montVigentes.push(v);
    	montVencidos.push(c);
	    var nombmont=[];
	    nombmont.push(rows[i].areanatural.desareanatural);
	    nombmont.push(m);
	    nombreMontTotal.push(nombmont);
	}
	
	for(var i=0,t=rowsv.length;i<t;i++){
		var nombmont=[];
		nombmont.push(rowsv[i].areanatural.desareanatural);
		var v=parseFloat(rowsv[i].montoTotalVigente);
    	v=Math.round(v*100)/100;
		nombmont.push(v);
	    nombreMontVigTotal.push(nombmont);
	}
	
	for(var i=0,t=rowsc.length;i<t;i++){
		var nombmont=[];
		nombmont.push(rowsc[i].areanatural.desareanatural);
		var c=parseFloat(rowsc[i].montoTotalVencido);
    	c=Math.round(v*100)/100;
		nombmont.push(c);
	    nombreMontConTotal.push(nombmont);
	}
	
	chartbar = new Highcharts.Chart({
		chart: {
			renderTo: 'chart_div1',
			zoomType: 'xy',
			 defaultSeriesType: 'bar'

		},
		title: {
			text: 'Monto de Proyectos por ANP (en soles)'
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
	            text: 'Monto de Proyectos',
	            align: 'high'
	         }
	      },


	      tooltip: {
	          formatter: function() {
	             return ''+
	                 this.series.name +': S/.'+ addCommas(this.y) ;
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
	         data: montTotal
	      },
	      {
		         name: 'Vigentes',
		         data: montVigentes
		      },
		      {
			         name: 'Concluidos',
			         data: montVencidos
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
	         text: 'Monto de Proyectos(en Soles)'
	      },
	      tooltip: {
	         formatter: function() {
	            return '<b>'+ this.point.name +'</b>: S/.'+ addCommas(this.y) ;
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
	                  return '<b> ' + this.point.name +'</b>: S/.'+ addCommas(this.y) ;
	               }
	            }
	         }
	      },
	       series: [{
	         type: 'pie',
	         name: 'Browser share',
	         data: 
	        	
	        	 nombreMontTotal
	                 
	             
	        	 
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
	         text: 'Monto de Proyectos Vigentes(en Soles)'
	      },
	      tooltip: {
	         formatter: function() {
	            return '<b>'+ this.point.name +'</b>: S/.'+ addCommas(this.y) ;
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
	                  return '<b>'+ this.point.name +'</b>: S/.'+  addCommas(this.y);
	               }
	            }
	         }
	      },
	       series: [{
	         type: 'pie',
	         name: 'Browser share',
	         data: 
	        	
	        	 nombreMontVigTotal
	                 
	             
	        	 
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
	         text: 'Monto de Proyectos Concluidos(en Soles)'
	      },
	      tooltip: {
	         formatter: function() {
	            return '<b>'+ this.point.name +'</b>: S/.'+ addCommas(this.y) ;
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
	                  return '<b>'+ this.point.name +'</b>: S/.'+ addCommas(this.y) ;
	               }
	            }
	         }
	      },
	       series: [{
	         type: 'pie',
	         name: 'Browser share',
	         data: 
	        	
	        	 nombreMontConTotal
	                 
	             
	        	 
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
	
	
	
	
	
	
	
	
	
});
</script>

<fmt:setLocale value="en_US" scope="session"/>

<div style="text-align: center;">
<h2>
<strong>Gr&aacute;fico N°1</strong>
</h2>
<h4>
Monto(en Soles) de Proyectos por ANP
<select id="cboChart" >
				<option value="1">Barras Vertical</option>
				<option value="2">Pie</option>
</select>
</h4>
</div>




<div class="chart_div" id="chart_div1"  style="height: 800px "></div>
<div>
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
Monto(en Soles) de Proyectos por ANP

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
		<th  colspan="3" style="width: 80px;text-align: center;">
			Monto de Proyectos(en Soles)
		</th>
		</tr>
		<tr>
		<th style="width: 20px;text-align: left;">
			Total
		</th>
		<th style="width: 20px;text-align: left;">
			Vigentes
		</th>
		<th style="width: 20px;text-align: left;">
			Concluidos
		</th>
		
		</tr>
	</thead>
	 <tbody>
	 
        <s:iterator value="listaConsolidadoAreaNatural">
          <tr   class="row <s:if test="#list.odd == true ">odd</s:if>" >
          <td style="text-align: left;width: 100px;"> 
		     <s:property value="areanatural.desareanatural"/>           
		   </td>
		   <td style="text-align: left;" > 
		   <s:if test="{montoTotalProyectos!=0}">
		      S/. <fmt:formatNumber pattern="#,###,###,###.##" value="${montoTotalProyectos}"/>
		  
		   </s:if>
		                
		   </td>
		   <td  style="text-align: left;"> 
		   <s:if test="{montoTotalVigente!=0}">
		   S/. <fmt:formatNumber pattern="#,###,###,###.##" value="${montoTotalVigente}"/>
		   </s:if>
		   </td>
		   <td  style="text-align: left;"> 
		   <s:if test="{montoTotalVencido!=0}">
		   S/. <fmt:formatNumber pattern="# ### ### ###.##" value="${montoTotalVencido}"/>
		  </s:if>
		   </td>
          </tr>
        </s:iterator>
        
     </tbody>
	</table>




</div>






		 