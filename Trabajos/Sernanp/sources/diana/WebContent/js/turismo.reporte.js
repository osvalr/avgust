  var data  ,map,result,datatotal,resume, // DataTables
  	table,chart,
  	cols,rows,size,
  	json55,months = {},charts={},
  	monthnames=[];

  var wrapper,routes1,div,ch;
  //var vis=${datosJson1};
  //alert('tam5'+vis.length);
  
  
$(function(){
	//routes = map[0].data;
	//routes=${datosJson1};
	/*
	alert('tam'+routes.length);
	for(var i = 0, t=routes.length;i<t;i++){
		alert(routes[i].nombrerutaturismo) ;
		alert(routes[i].percent);
		
	} 
	*/
	ch = new Charter();
	div = $("#dataTableChart").clone();
	div.removeAttr("id").show();
	
	
	ch.make( chartPie ); 
	ch.make( chartLine ); 
	ch.make( chartBarRevenue );
	ch.make( chartBar );
	//ch.make( chartBarOcupacion);
	

});

function Charter() {
	var ix = 0;
	this.id = "";
	
	this.make = function ( fn ){
		wrapper = div.clone(); 
		data = [];
		this.id = 'chart_'+getIx();
		//wrapper.attr( 'id', this.id ).appendTo("#charts");	 
		fn( this.id );
	};
	
	function getIx(){
		return ix++;
	}
	
};

function chartPie(){
	
	for(var i = 0, t=routes.length;i<t;i++){
		bucket = routes[i];
		data.push( [ bucket.nombrerutaturismo, bucket.percent ] );
	} 
	chart = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div2'
	      },
	      title: {
		         text: ''
		      },
	      tooltip: {
	         formatter: function() {
	            return '<b>'+ this.point.name +'</b>: '+ this.y +' %';
	         }
	      },
	      exporting:{
	    	  enabled:true
	      },
	      credits: {
	          enabled: false
	       },
	      plotOptions: {
	         pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	               enabled: true, 
	               formatter: function() {
	                  return '<b>'+ this.point.name +'</b>: '+ this.y +' %';
	               }
	            },
	      		showInLegend: true
	         }
	       
	     
	       
	      },
	       series: [{
	         type: 'pie',
	         name: 'Browser share',
	         data: data
	      }]
	   });
}



function chartLine(){
	 
	// Parser by Month
	for(var i = 0, t=json.length;i<t;i++){
		var row;
		bucket = json[i];
		if( !( bucket.mes in months ) ){
			row =  {data:{total:0,nacional:0,extranjero:0,boleto:0,estudiante:0,profesional:0,otrosocupacion:0}};
			monthnames.push( labels.monthNames[ bucket.mes -1 ]  );
		} 
		for(var k in row.data){
			row.data[k] += parseInt(bucket[k]);
		}
		//console.log("DATA",row.data);
		months[ bucket.mes ] = row;
		months[ bucket.mes ]['id_' + bucket.idrutaturismo] = bucket.total;
	}
	// Formatting Data to Graph
	for( var i=0,t= routes.length; i<t;i++ ){
		bucket = routes[i];
		data[i] = { name:bucket.nombrerutaturismo,data:[] };
		for( var j in months ){
			data[i].data.push( months[j]['id_' +bucket.idrutaturismo] || 0  );
		}
	}
	
	chart = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div3',
	         defaultSeriesType: 'line'
	      },
	      title: {
		         text: ''
		      },
	      credits: {
	          enabled: false
	       },
	      subtitle: {
	         text: 'Fuente: SERNANP'
	      },
	      xAxis: {
	         categories: monthnames
	      },
	      yAxis: {
	         title: {
	            text: 'Visitantes'
	         },
	         min: 0
	      },
	      tooltip: {
	         formatter: function() {
	            return ''+
	                this.x +': '+ Highcharts.numberFormat(this.y, 0, ',') +' visitantes';
	         } 
	      }, 
	      series: data
	   });
}






function chartBarRevenue(){

	// Formatting Data to Graph
	var i = 0;
	var titles = {total:{title:"Total",type:"column",color: '#4572A7'},boleto:{title:"Boleto",type:"spline", color: '#89A54E'}};
	for(var k in titles){ 
		data[i] = {name:titles[k].title,data:[],type:titles[k].type,color:titles[k].color};
		for( var j in months ){
				data[i].data.push( months[j].data[k]  ); 
			}
		i++; 
	}
	data[0].yAxis = 1;
	//console.log("DATA Mixed",data);
	chart = new Highcharts.Chart({
	      chart: {
	         renderTo: 'chart_div4',
	         zoomType: 'xy'
	      },
	      title: {
		         text: ''
		      },
	      /*
	      title: {
	         text: 'Recaudaci\xF3n por concepto de turismo'
	      },
	      */
	      credits: {
	          enabled: false
	       },
	      subtitle: {
	         text: 'Fuente: SERNANP'
	      },
	      xAxis: [{
	         categories: monthnames
	      }],
	      yAxis: [{ // Primary yAxis
	         labels: {
	            formatter: function() {
	               return "S/." + this.value ;
	            },
	            style: {
	               color: '#89A54E'
	            }
	         },
	         title: {
	            text: 'Recaudaci\xF3n',
	            style: {
	               color: '#89A54E'
	            }
	         },
	         min: 0
	      }, { // Secondary yAxis
	         title: {
	            text: 'Visitantes',
	            style: {
	               color: '#4572A7'
	            }
	         },
	         labels: {
	            formatter: function() {
	               return this.value +' visitantes';
	            },
	            style: {
	               color: '#4572A7'
	            }
	         },
	         opposite: true
	      }],
	      tooltip: {
	         formatter: function() {
	            return ''+
	               this.x +': ' +
	               (this.series.name == 'Total' ? ( this.y + ' visitantes ' ) : (' S/.' +Highcharts.numberFormat(this.y, 2, '.') ) );
	         }
	      },
	      legend: {
	         layout: 'vertical',
	         align: 'left',
	         x: 120,
	         verticalAlign: 'top',
	         y: 100,
	         floating: true,
	         backgroundColor: '#FFFFFF'
	      },
	      series: data
	   });
}



function chartBar(){

	// Formatting Data to Graph
//	for( var i=0,t= routes.length; i<t;i++ ){
//		bucket = routes[i];
//		data[i] = { name:bucket.nombrerutaturismo,data:[] };
//		for( var j in months ){
//			data[i].data.push( months[j]['id_' +bucket.idrutaturismo] || 0  );
//		}
//	}
	  
	// Formatting Data to Graph
	var i = 0;
	var titles = {total:"Total",nacional:"Nacionales",extranjero:"Extranjeros"};
	for(var k in titles){ 
			data[i] = {name:titles[k],data:[]};
			for( var j in months ){
					data[i].data.push( months[j].data[k]  ); 
				}
			i++; 
	}
	
	chart = new Highcharts.Chart({
	      chart: {
	    	  renderTo: 'chart_div1',
	         defaultSeriesType: 'column'
	      },
	      title: {
		         text: ''
		      },
	      credits: {
	          enabled: false
	       },
	      subtitle: {
	         text: 'Fuente: SERNANP'
	      },
	      xAxis: {
	         categories: monthnames
	      },
	      yAxis: {
	         min: 0,
	         title: {
	            text: 'Cantidad de Visitantes'
	         }
	      },
	      legend: {
	         layout: 'vertical',
	         backgroundColor:  '#FFFFFF',
	         align: 'left',
	         verticalAlign: 'top',
	         x: 100,
	         y: 70,
	         floating: true,
	         shadow: true
	      },
	      tooltip: {
	         formatter: function() {
	            return ''+
	               this.x +': '+ this.y +' mm';
	         }
	      },
	      plotOptions: {
	         column: {
	            pointPadding: 0.2,
	            borderWidth: 0
	         }
	      },
	           series: data
	   });
	   
}

//function chartBarOcupacion(){
//	// Formatting Data to Graph
//	var i = 0;
//	var titles = {total:"Total",estudiante:"Estudiante",profesional:"Profesional",otrosocupacion:"Otros"};
//	for(var k in titles){ 
//			data[i] = {name:titles[k],data:[]};
//			for( var j in months ){
//					data[i].data.push( months[j].data[k]  ); 
//				}
//			i++; 
//	}
//	
//	chart = new Highcharts.Chart({
//	      chart: {
//	    	  renderTo: 'chart_div1_2',
//	         defaultSeriesType: 'column'
//	      },
//	      title: {
//		         text: ''
//		      },
//	      credits: {
//	          enabled: false
//	       },
//	      subtitle: {
//	         text: 'Fuente: SERNANP'
//	      },
//	      xAxis: {
//	         categories: monthnames
//	      },
//	      yAxis: {
//	         min: 0,
//	         title: {
//	            text: 'Cantidad de Visitantes'
//	         }
//	      },
//	      legend: {
//	         layout: 'vertical',
//	         backgroundColor:  '#FFFFFF',
//	         align: 'left',
//	         verticalAlign: 'top',
//	         x: 100,
//	         y: 70,
//	         floating: true,
//	         shadow: true
//	      },
//	      tooltip: {
//	         formatter: function() {
//	            return ''+
//	               this.x +': '+ this.y +' mm';
//	         }
//	      },
//	      plotOptions: {
//	         column: {
//	            pointPadding: 0.2,
//	            borderWidth: 0
//	         }
//	      },
//	           series: data
//	   });
//	   
//}

/*********************************************************/