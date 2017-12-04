
var oldestyear,currentyear,chart,div,line,
	j=0,i,counter=0,
	sumareas=0,
	sumextension=0,
	years = [],
	rows={areas:[],extension:[]};

var anios = {},resume = {},hasadminindex = {},anps = {},
	areas = {},finaldata={},chartdata={};
var dataByYearsAAN = [],dataByYears = [],administrations=[];
var anpstemp = [];
var numareasAAN=0,numareas =0;
var extareasAAN=0,extareas =0;
var j=0; 


$(document).ready(function() {
	var colors = {anp:"#89A54E",total:"#AA4643",AAN:"#F0BE32",ACR:"#80699B",ACP:"#4572A7",zr:"#DB843D"}; 
	parseData();
	drawCharts(2);
	 
	$("#periodo").change(function(){
		$("#charts").empty();
		drawCharts(parseInt(this.value)); 
	}).parent().show();
	
	function parseData(){ 
		areas.zr = {titulo:"Zonas Reservadas",siglas:"ZR"};
		areas.anp = {titulo:"\xC1reas Naturales Protegidas (Nacionales-Regionales)",siglas:"ANP"}; 
		areas.total = {titulo:"\xC1reas Naturales Protegidas + Zonas Reservadas",siglas:"ANP + ZR"}; 
		//Add Administrators
		resume.anp= []; 
		resume.zr= [];
		for(var i=0,t=data.length;i<t;i++){
			var adminindex =  data[i].siglasadministracionareanatural;  
			areas[ adminindex ] = { 
					titulo: data[i].nombreadministracionareanatural.replace(/AREA/g,"AREAS"),
					siglas:data[i].siglasadministracionareanatural
					}; 
			resume[adminindex] =[]; 
			administrations.push(adminindex);
		}
		
		resume.total= []; 
		// Parse Years
		for( var i=0,t=datatemp.length; i<t; i++ ){
			
			var row = datatemp[i];
			//Another Bug - Javascript Sucks!+
			var year = parseInt( row.fechahistoricoareanatural.substring(0,4) );    
			var yearindex = "y" + year;
			var anpindex = "a"+ row.idareanatural;
			var adminindex =  row.siglasadministracionareanatural;
			
	
			var rowyear = areas[ adminindex ];
			var admin = row.idadministracionareanatural; 
			
			if(!( yearindex in anios) ){
				anios[ yearindex ] = true; 
				
				for(var ix in areas){
					areas[ix].areas = 0;
					areas[ix].extension = 0;
				} 
				
				j++;
			} 
			//|| row.idadministracionareanatural == 2 

			//If Exist ANP.
			if( !( anpindex in anps)  ){
				rowyear.areas++;
				areas.total.areas ++; 
	
				if( row.idcategoriaanp == 10 ){ 
					areas.zr.areas ++; 
				} 
				if( ( row.idcategoriaanp != 10 && row.idcategoriaanp != 0 )  ){
					areas.anp.areas ++;
				}
				
			}  

			anps[ anpindex] = row.extension;
			
			areas[ adminindex ].extension += row.extension ;
			areas.total.extension += row.extension ;
			if( row.idcategoriaanp == 10 ){
				areas.zr.extension += row.extension ;
			}

			if( row.idcategoriaanp != 10 && row.idcategoriaanp != 0 ){
				areas.anp.extension += row.extension ;
			}
			 
			var datarow = {  
					year:year,
					extension:(areas[ adminindex ].extension),
					areas:areas[ adminindex ].areas
				}; 
			
			resume.total[j-1]={
					year:year,
					extension:(areas.total.extension),
					areas:areas.total.areas
				};
			
			if( row.idcategoriaanp == 10 ){ 
	
				resume.zr[j-1]={
						year:year, 
						extension:(areas.zr.extension),
						areas:areas.zr.areas
					}; 
			}

			if( row.idcategoriaanp != 10 && row.idadministracionareanatural != 3 ){ 
				resume.anp[j-1]={
						year:year, 
						extension:(areas.anp.extension),
						areas:areas.anp.areas
					}; 
			}
			
			if( !(adminindex in hasadminindex) ){
				hasadminindex[adminindex] = true;
			}
	
	
			for(var k=0,tx=administrations.length;k<tx;k++){ 
				var admintemp = administrations[k];
				if(admintemp in hasadminindex){ 
					resume[admintemp][j-1] = ( { 
							year:year,
							extension:(areas[ admintemp ].extension),
							areas:areas[ admintemp ].areas
						});  
				}else{
					resume[admintemp][j-1] = null;
				}
			}
		} 
		 
		// Delete ZR | Total
		 delete resume.total;
		// delete resume.anp;
		 
		
		// Clear data undefined - Delete after Presentation.
		for( var anp in resume){
			var lineanp = resume[anp];
			finaldata[anp] = [];
			for(var i = 0;i<lineanp.length;i++){
				if( lineanp[i] != null){
					finaldata[anp].push(lineanp[i]); 
				}
			} 
		}

	}
	

	function makeChart(anp,step){ 
		 
		var tituloareas;
		line = finaldata[anp]; 
		rows={areas:[],extension:[],years:[]};
		oldestyear = parseInt(datatemp[0].fechahistoricoareanatural.substring(0,4));
		newestyear = line[line.length-1].year;  
		currentyear = new Date().getFullYear() - 1;
		diff = currentyear - newestyear;
		//console.log("DATA:", line, "Is minor", currentyear - newestyear,anp,currentyear,newestyear );
 
		counter = currentyear-oldestyear;
		years=[];
		var l=0;
   
		//var filler = ""; 
		//console.log("LINE", line[l],l,"Lines:",line, "Oldest Year", oldestyear);
		
		for( i=0 ;i<=counter;i+=step ){ 

			var row = {},
				x =0;a = 0;
			
			for(j=i;j<(i+step);j++){

				if( (l in line) && ( line[l].year == (oldestyear + j) ) ){
					l++; 
					row = line[l-1];
				}else{
					row = {extension:0,areas:0};
				}
				x += row.extension;
				a += row.areas;
			}
			
			
			var y = ((oldestyear + i).toString());
			if(step > 1){
				y +="-" + ((oldestyear + j - 1).toString());
			}
			rows.extension.push( x );    
			rows.areas.push( a ); 
			rows.years.push( y  );   
		} 
		rows.div = "container_"+anp;
		
		
		rows.label =  "N\xFAmero de \xC1reas Naturales"   ;
		rows.titulo = ('Variaci\xF3n de las ' +areas[ anp ].titulo ).toUpperCase();
		rows.siglas = 'N\xFAmero de ' + areas[ anp ].siglas;
		rows.serie = {
				 color:colors[anp],
		         name: rows.siglas, 
		         data: rows.areas,
		         dataLabels: {
		        	 y:12, 
					 color: '#ffffff' 
		        	// enabled: true
		         }         
		      }; 
		return rows;
	}

	function drawCharts(step){
		var row = {}, charts=[];
		
		for( var anp in finaldata){ 
			var bucket = makeChart(anp,step);
			//console.log(bucket);
			row = {
				titulo : bucket.titulo,
				div : bucket.div,
				years : bucket.years,
				label : bucket.label,
				series : [bucket.serie] 
			};
			//console.log("Bucket",bucket);
			if( anp != "anp"){
				charts.push( row ); 
			}
			chartdata[anp] = bucket;
		} 

		row = {
				titulo : "Variaci\xF3n de \xC1reas Naturales Protegidas de caracter definitivo", 
				div : "anp_acr",
				years : chartdata.zr.years,
				label : "N\xFAmero de \xC1reas Naturales",
				series : [ chartdata.anp.serie,chartdata.ACR.serie ],
				plotOptions: {
			         column: {
			            stacking: 'normal'
			         } 
				}
			};
		
		charts.push( row ); 
		
		row = {
			titulo : "Variaci\xF3n de establecimiento de ANP - (Categor\xEDas Definitivas + ACP)",
			div : "zr_anp",
			years : chartdata.zr.years,
			label : "N\xFAmero de \xC1reas Naturales",
			series : [ chartdata.anp.serie,chartdata.ACR.serie,chartdata.ACP.serie  ],
			plotOptions: {
		         column: {
		            stacking: 'normal'
		         }
			}
		};
		charts.push( row ); 
		
		row = {
				titulo : "Variaci\xF3n de ANP de categor\xEDa definitiva  + ANP Privadas + Zonas Reservadas",
				div : "zr_anp_acp",
				years : chartdata.zr.years,
				label : "N\xFAmero de \xC1reas Naturales",
				series : [ chartdata.anp.serie,chartdata.ACR.serie,chartdata.ACP.serie, chartdata.zr.serie ],
				plotOptions: {
			         column: {
			            stacking: 'normal'
			         }
				}
			};
		charts.push( row ); 

		
		var t = charts.length;
		while(t--){
			addChart( charts[t]);
		}
	}

	function addChart(row){ 
		$("#charts").append("<div id='"+row.div+"' class='chart'></div");   
		var cbPeriodo = $("#periodo");
		var params = {
				chart: {
					 renderTo: row.div,
					 zoomType: 'xy',
				defaultSeriesType: 'column',
				     margin: [ 50, 50, 100, 80]
				  },
				title: {
					text: ( row.titulo + " por " + cbPeriodo[0].options[cbPeriodo[0].selectedIndex].text ).toUpperCase()
				},
				subtitle: { 
					text: 'Informaci\xF3n: Servicio Nacional de Areas Protegidas del Per\xFA - SERNANP'
				}, 
		      xAxis: {
		         categories: row.years,
		         labels: { 
					formatter: function() {  
						//console.log(this.value.split("-"));
						var label = "";
						if( !(/-/.test( this.value ) ) ){
							label = this.value.substring(2); 
						}else{
							var range = this.value.split("-");
							label = (range[0].substring(2) + "-" + range[1].substring(2) );
						} 
						return label;
					},
					y: 20,
					rotation: -45,
		            style: {
		                font: 'bold 9px Verdana, sans-serif'
		            }
		         }
		      },
		      yAxis: {
		         min: 0,
		         title: {
		            text:  ( row.label ).toUpperCase()
		         },
				labels: { 
					//y: -20,
					formatter: function() {
						return parseInt(this.value) +' areas';
					},
					style: { 
						color: '#999999'
					}
				}
		      },
		      legend: {
		         enabled: false
		      },
		      tooltip: { 
		         formatter: function() {
		            return '<b>'+ this.x +'</b><br/>'+
		                'Areas: '+ Highcharts.numberFormat(this.y,0)  ;
		         }
		      },
		      credits: {
		          enabled: false
		       },
		      legend: {
		          layout: 'vertical',
		          align: 'left',
		          verticalAlign: 'top',
		          x: 100,
		          y: 50,
		          floating: true,
		          borderWidth: 1,
		          backgroundColor:  '#FFFFFF',
		          shadow: true
		       },
		      plotOptions: row.plotOptions,
		      series: row.series
		   };
		 
		   chart = new Highcharts.Chart(params);
	} ;

	//console.timeEnd("CHART");
	
});

