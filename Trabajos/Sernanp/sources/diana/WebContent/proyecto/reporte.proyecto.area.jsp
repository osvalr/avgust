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
	<link rel="stylesheet" type="text/css" media="screen" href="css/proyectos.css" />   
   <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="http://www.google.com/jsapi"></script>
 <script type="text/javascript" src="js/general.js"></script> 
	      
	</head>
 
 <body>


<s:if test="%{areanatural==null}">

No existe ese valor

</s:if>
<s:else>



<script type="text/javascript" src="js/lib/highcharts/highcharts.js"></script>   
<script type="text/javascript"> 
			
var rows = ${datosJson2};
var rowsf = ${datosJson4};

var nombreAreaTotal=[];
var cantTotal=[];
var cantVigentes=[];
var cantVencidos=[];
var nombreCantTotal=[];
var nombreMontTotal=[];
var nombreCantVigTotal=[];
var nombreCantConTotal=[];
var nombreFte=[];
var chartbar;
var chartpietotal;
var chartpievigentes;
var chartpieconcluidos;
$(document).ready(function() {
	
	
	    //cantidades
		var nomcant1=[];
		nomcant1.push("Cantidad de Proyectos Vigentes");
		nomcant1.push(rows[0].cantidadProyectosVigente);
	    nombreCantTotal.push(nomcant1);
	    var nomcant2=[];
	    nomcant2.push("Cantidad de Proyectos Concluidos");
	    nomcant2.push( rows[0].cantidadProyectosVencidos);
	    nombreCantTotal.push(nomcant2);
	
	    //monto
	   
	    var nombmont1=[];
	    nombmont1.push("Monto de Proyectos Vigentes");
	    var v=parseFloat(rows[0].montoTotalVigente);
    	v=Math.round(v*100)/100;
	    nombmont1.push(v);
	    nombreMontTotal.push(nombmont1);
	    var nombmont2=[];
	    nombmont2.push("Monto de Proyectos Concluidos");
	    var c=parseFloat(rows[0].montoTotalVencido);
    	c=Math.round(c*100)/100;
	    nombmont2.push(c);
	    nombreMontTotal.push(nombmont2);
	    
	
	    //fuentes
	    for(var i=0,t=rowsf.length;i<t;i++){
			var ftemont=[];
			ftemont.push(rowsf[i].fteFto.personajuridica.nombrepersonajuridica);
			var m=parseFloat(rowsf[i].monto);
	    	m=Math.round(m*100)/100;
			ftemont.push(m);
		    nombreFte.push(ftemont);
		}
	    
	    
	
	//chart pie cantidad
	 chartpiecant = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div1',
	         plotBackgroundColor: null,
	         plotBorderWidth: null,
	         plotShadow: false
	      },
	      title: {
	         text: ''
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

	
	
	//chart pie monto
	 chartpiemont = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div2',
	         plotBackgroundColor: null,
	         plotBorderWidth: null,
	         plotShadow: false
	      },
	      title: {
	         text: ''
	      },
	      tooltip: {
	         formatter: function() {
	            return '<b>'+ this.point.name +'</b>: S/. '+  addCommas(this.y) ;
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
	        	
	        	 nombreMontTotal
	                 
	             
	        	 
	      }]
	   });
	
	
	
	
	
	//chart pie fuente
	 chartpiefte = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div3',
	         plotBackgroundColor: null,
	         plotBorderWidth: null,
	         plotShadow: false
	      },
	      title: {
	         text: ''
	      },
	      tooltip: {
	         formatter: function() {
	            return '<b> '+ this.point.name +'</b>: S/.'+  addCommas(this.y) ;
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
	                  return '<b> '+ this.point.name +'</b>: S/.'+ addCommas(this.y) ;
	               }
	            }
	         }
	      },
	       series: [{
	         type: 'pie',
	         name: 'Browser share',
	         data: 
	        	
	        	 nombreFte
	                 
	             
	        	 
	      }]
	   });
	
	
	
	
	
});
</script>






<fmt:setLocale value="en_US" scope="session"/>


<div>
<h3>
 <span> <s:property  value="areanatural.desareanatural"/> </span>
</h3>
</div>

<div style="text-align: center;" >

<div style="text-align: center;">
<h3>
<strong>Cuadro N° 1</strong>
</h3>
<h4>
Proyectos
</h4>
</div>


<div id="tableProy" ></div>

<table  cellpadding='0' cellspacing='1' class="tablaList"
	style="margin-left: auto;margin-right: auto;" >
	
	<thead>
		<tr>
		
		<th style="width: 800px;text-align: center;">
			Nombre
		</th>
		<th style="width: 20px;text-align: center;">
			A&ntilde;o Inicio
		</th>
		<th style="width: 20px;text-align: center;">
			A&ntilde;o Fin
		</th>
		<th style="width: 20px;text-align: center;">
			Estado
		</th>
		
		
		</tr>
	</thead>
		<tbody>
		      
		        <s:iterator  value="listaProyecto"  status="list">
		            
		            
		                   
		                <tr class="row <s:if test="#list.odd == true ">odd</s:if>">
		                
		                
		                <td style="width: 800px;
		                 <s:if test="%{flagVigencia==1 || flagVigencia==3}"> 
		                  color:black; 
		                    </s:if>
		                  <s:elseif test="%{flagVigencia==2 }">
		        		     color:red;
		             		</s:elseif> ">
		                    <s:property value="nombreproyecto"/>
		                   
		                </td>
		                <td style="width:20px;text-align: center;
		                <s:if test="%{flagVigencia==1 || flagVigencia==3}"> 
		                  color:black; 
		                    </s:if>
		                  <s:elseif test="%{flagVigencia==2 }">
		        		     color:red;
		             		</s:elseif> ">
		                      <s:property value="fechainicio"/>
		                </td>
		                <td style="width:20px;text-align: center;
		                
		                <s:if test="%{flagVigencia==1 || flagVigencia==3}"> 
		                  color:black; 
		                    </s:if>
		                  <s:elseif test="%{flagVigencia==2 }">
		        		     color:red;
		             		</s:elseif> ">
		                   <s:property value="fechafin"/>
		                    
		                </td>
		                
		                   	<s:if test="%{flagVigencia==1 || flagVigencia==3}"> 
		                    <td style="width:20px;text-align: center;">
		                   Vigente  
		                   </td>
		                    </s:if>
		            
		  		          <s:elseif test="%{flagVigencia==2 }">
		        		     <td style="width:20px;text-align: center;color: red;">
		        		     Concluido  
		             		 </td>
		             		</s:elseif>
		                
		                
		               
		            </tr>  
		          
		        </s:iterator>
		</tbody>
	</table>



<div style="text-align: center;">
<h3>
<strong>Gr&aacute;fico N° 1</strong>
</h3>
<h4>
Cantidad de Proyectos 
</h4>
</div>




<div class="chart_div" style="text-align: center;" id="chart_div1" ></div>


<div style="text-align: center;">
<h3>
<strong>Gr&aacute;fico N° 2</strong>
</h3>
<h4>
Monto de Proyectos(en Soles)
</h4>
</div>





<div class="chart_div"  style="text-align: center;" id="chart_div2" ></div>


<div style="text-align: center;">
<h3>
<strong>Cuadro N° 2</strong>
</h3>
<h4>
Fuentes de Financiamiento
</h4>
</div>




<div id="fteftoProy" ></div>
<table  cellpadding='0' cellspacing='1' class="tablaList"
	style="margin-left: auto;margin-right: auto; " >
	
	<thead>
		<tr>
		
		<th style="width: 500px;text-align: center;">
			Instituci&oacute;n
		</th>
		<th style="width: 150px;text-align: center;">
			Monto
		</th>
		
		
		
		</tr>
	</thead>
		<tbody>
		      
		        <s:iterator  value="listaProyectoFteFto"  status="list">
		            
		            
		                   
		                <tr class="row <s:if test="#list.odd == true ">odd</s:if>">
		                
		                 <td style="width: 500px;"   >
		                      <s:property value="fteFto.personajuridica.nombrepersonajuridica"/>
		                 </td>
		                <td style="width: 150px;"   >
		                      S/. <fmt:formatNumber pattern="#,###,###,###.##" value="${monto}"/>
		                      
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
Monto(en Soles) Fuentes Financiamiento
</h4>
</div>






<div class="chart_div" style="text-align: center;" id="chart_div3" ></div>
</div>










</s:else>



	


 </body> 
	</html> 

		 