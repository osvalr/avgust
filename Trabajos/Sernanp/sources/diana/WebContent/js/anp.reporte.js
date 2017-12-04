
function Pintar(numeroRefer) {

	 $(".chartdata2").remove(); 
	 $(".chart").remove(); 
	 $(".mostrarAnio").remove();


	var oldestyear,currentyear,chart,div,line,
		j=0,i,counter=0,
		sumareas=0,
		sumextension=0,
		years = [],
		rows={areas:[],extension:[],anp:[]};
		
	//CREO ESTA VARIABLE
	var desAreas= [];

	var anios = {},resume = {},hasadminindex = {},anps = {},areas = {},finaldata={}/*desanps={}*/;
	var dataByYearsAAN = [],dataByYears = [],administrations=[];
	var anpstemp = [];
	var numareasAAN=0,numareas =0;
	var extareasAAN=0,extareas =0;
	var j=0; 
	
	
	//console.time("CHART");
	areas.total = {totalareas:0,totalextension:0,titulo:"\xC1reas Naturales Protegidas",siglas:"ANP"}; 
	areas.zr = {totalareas:0,totalextension:0,titulo:"Zonas Reservadas",siglas:"ZR"};
	//Add Administrators
	resume.zr= [];
	for(var i=0,t=data.length;i<t;i++){
		var adminindex = "admin_"+ data[i].idadministracionareanatural;
		areas[ adminindex ] = {
				areas:0,
				extension:0,
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
		//Another Bug - Javascript Sucks!

		var year = parseInt( row.fechahistoricoareanatural.substring(0,4) );    
		var yearindex = "y" + year;
		var anpindex = "a"+ row.idareanatural;
		var adminindex = "admin_"+ row.idadministracionareanatural;
		
//		//ESTO ESTOY AGREGANDO
//		var desAreaindex="x"+row.desareanatural;
		
		desAreas[i]=row.desareanatural;
		

		var rowyear = areas[ adminindex ];
		var admin = row.idadministracionareanatural;

		
		if(!( yearindex in anios) ){
			anios[ yearindex ] = true;
			//*
//			if(!( desAreaindex in desanps) ){
//				desanps[ desAreaindex ] = true;	
//			}
			//*
			j++;
			
		} 
		

		//AGREGANDO METODOS**********************************************
	
	
		
		//If Exist ANP.
		if( !( anpindex in anps)  ){
			rowyear.areas++;
			areas.total.totalareas ++; 
			
			if( row.idcategoriaanp == 10 ){ 
				areas.zr.totalareas ++; 
			} 
			
		}else{
			areas[ adminindex ].extension -= anps[ anpindex ] ;
			areas.total.totalextension -= anps[ anpindex ];

			if( row.idcategoriaanp == 10 ){ 
				areas.zr.totalextension  -= anps[ anpindex ] ; 
			} 
		}   

		
		
		anps[ anpindex] = row.extension;
		
		
		if( row.ideventoareanatural ==2 ){
			areas[ adminindex ].areas--;
			areas.total.totalareas--;

			if( row.idcategoriaanp == 10 ){ 
				areas.zr.totalareas--; ; 
			} 
		}    
		
		areas[ adminindex ].extension += row.extension ;
		areas.total.totalextension += row.extension ;
		if( row.idcategoriaanp == 10 ){
			areas.zr.totalextension += row.extension ;
		}
		//console.log("Total:", areas.total.totalextension ," Extensi\xF3n", row.extension, " YEAR:",year);
		var datarow = {  
				year:year,
				extension:(areas[ adminindex ].extension),
				areas:areas[ adminindex ].areas
			}; 
		
		resume.total[j-1]={
				year:year,
				extension:(areas.total.totalextension),
				areas:areas.total.totalareas
			};
		
		if( row.idcategoriaanp == 10 ){ 
			/*
			console.log("ZR"," Area:",row.idareanatural, " Cat:",row.idcategoriaanp, 
					" Evento:", row.ideventoareanatural,year);
					*/
			resume.zr[j-1]={
					year:year, 
					extension:(areas.zr.totalextension),
					areas:areas.zr.totalareas
				};
		}else{
			//resume.zr[j-1] = null;
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
	
	// Delete ZR.
	//delete resume.zr;
	
	//console.log("RESUME", resume);
	
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
	
	//VARIABLE PARA PINTAR SOLO EN EL PRIMER CUADRO LOS BOTONES
	//var pinto=0;
	for( var anp in finaldata){
		
		makeChart(anp);
		
		
//		alert('el valor de pinto es :'+pinto);
//		makeChart(anp,0);
//		pinto+=1;
 
	}
	
	
	//modificando makechart
	function makeChart(anp){ 
		
		var tituloareas;
		line = finaldata[anp]; 
		rows={areas:[],extension:[],years:[]};
		oldestyear = line[0].year;
		newestyear = line[line.length-1].year; 
		currentyear = new Date().getFullYear();
		diff = currentyear - newestyear;
		//console.log("DATA:", line, "Is minor", currentyear - newestyear,anp,currentyear,newestyear );
		counter = currentyear-oldestyear;
		if(!(numeroRefer==1)){
			 
			counter=counter-1;
			 
		}
		
		years=[];
		var l=0;
  
//		var d = document.createElement('div');
//        d.id = 'dataTableChartX';
        
		var tabledata = $("#dataTableChart").clone();
		tabledata.removeClass('chartdata');
		tabledata.addClass('chartdata2');
 
		var filler = ""; 
		var lugares='';
		
		
		
		
		
		
		
	//	console.log("LINE", line[l],l,"Lines:",line, "Oldest Year", oldestyear);
		for( i=0 ;i<=counter;i++ ){ 
			if( (l in line) && ( line[l].year == (oldestyear + i) ) ){
				l++; 
			}
			var y = ((oldestyear + i).toString());
			var row = line[l-1]; 
			rows.extension.push( row.extension );    
			rows.areas.push( row.areas ); 
			rows.years.push( y.substring(2) );  
			
//			var desAr=[];
//			desAr.push(row.areas);
			//var aux = lugares+desAreas[i+5]+',';
		//if(mipintar==0)alert ('mi pintar es '+mipintar);
		//if(mipintar==0){
			
//			ESTO ES PARA CUANDO HABILITEN EL BOTON AREANATURAL	
//				filler +="<tr class='"+ (i%2? "odd":"") +"'><td>"+y+"</td><td>"+row.areas+
//				"</td><td>"+row.extension.toFixed(2)+" ha</td><td><center>" +
//				"<div class='verAreas' id='DivOpener'  >" +
//						"<div id='miIcon' class='ui-state-default ui-corner-all' style='width:16px'><a  name="+y+" id='linkModalDetalleAnp' class='ui-icon ui-icon-circle-plus' href='#'></a></div></div></center></td></tr>"; 
//				
				
				filler +="<tr class='"+ (i%2? "odd":"") +"'><td>"+y+"</td><td>"+row.areas+
				"</td><td>"+row.extension.toFixed(2)+" ha</td></tr>"; 
		
				
				
				
		//}	
	
	
	}
		
		
		//ojo con el evento html
		tabledata.show().find("tbody").html(filler); 
		
		
		//aumentamos el ii
		mipintar=2;
		
		
		tabledata.find(".showchartdata").click(function(){ 
			tabledata.find(".table").slideToggle();
		}); 
		div = "container1_"+anp;
		
		var nombreareas =  areas[ anp ].titulo   ;

		$("#content").prepend(tabledata).prepend("<div id='"+div+"' class='chart'></div");   
		
		var titulo = ('Acumulado de las ' +nombreareas + 
					' por A\xF1o').toUpperCase(); 
		
		chart = new Highcharts.Chart({
			chart: {
				renderTo: div,
				zoomType: 'xy'
			},
			title: {
				text: titulo
			},
			subtitle: { 
				text: 'Informaci\xF3n: Servicio Nacional de Areas Protegidas del Per\xFA - SERNANP'
			},
			xAxis: [{
				categories: rows.years
			}],
			yAxis: [{ // Primary yAxis
				labels: {
					formatter: function() {
						return this.value +' ha';
					},
					style: {
						color: '#FA9605'
					}
				},
				title: {
					text: 'Total Extension ha',
					style: {
						color: '#FA9605'  
					}
				} 
			}, { // Secondary yAxis
				title: {
					text: nombreareas,
					style: {
						color: '#89A54E'
					}
				},
				labels: {
					formatter: function() {
						return this.value +' areas';
					},
					style: {
						color: '#89A54E'
					}
				},
				opposite: true
			}],
			tooltip: {
				formatter: function() {
					return 'A\xF1o:'+
						this.x +': '+ 
						(this.series.name == 'Extensi\xF3n' ? 
							(this.y.toFixed(2) + 'ha') :  
							( this.y + ' areas' ) 
						) ;
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
			series: [{
				name: 'N\xFAmero de ' +areas[ anp ].siglas,
				color: '#89A54E',
				type: 'column',
				yAxis: 1,
				data: rows.areas 	
			 
			}, {
				name: 'Extensi\xF3n',
				color: '#FA9605',
				type: 'spline',
				data: rows.extension 
			}]
		}); 
		if( anp=="total" || anp=="admin_1"){
			$("g.highcharts-axis:eq(1) tspan:first").hide(); 
		}
		
	}

	
	//AUMENTAR
	 $("#content").prepend("<div id='botones' style='position: absolute; padding-top:15px ; z-index: 1; float:left'>"+				
			 	"<div><input type='button' id='MostrarAnio' name='MostrarAnio' class='mostrarAnio' value='Mostrar A\xF1o Actual' onclick='Pintar(1);' /></div>"+
				"<div><input type='button' id='NoMostrarAnio' name='NoMostrarAnio' class='mostrarAnio' value='No Mostrar A\xF1o Actual' onclick='Pintar(0);' /></div></div>");	
	 $("#MostrarAnio").hide();
	 $("#NoMostrarAnio").show();
	 
	if(!(numeroRefer==1)){
			 
		 $("#MostrarAnio").show();
		 $("#NoMostrarAnio").hide();
			 
	}
	 
	 
};

$(document).ready(function(){
Pintar(0)});

//$(document).ready(function(){
//	Pintar(0);
//	
//	//alert('dd');
//	$('#linkModalDetalleAnp').live('click',
//	function(e) {
//		e.preventDefault();
//		var anio=$(this).attr('name');
//		//alert(anio);
//		
//	
//		$.ajax({
//		       url: 'anp/listarXYear.action',
//		       data: "anio="+anio,
//		       cache: false,
//		       dataType: "json",
//		       success: function(datos){  
//		    	   
//		    	  
//	
//		    	   
//		    	   var xhtml="<table  width='380px'>";
//		    	   xhtml+="<tr><td width='20px'><center><b><font size=0.6>#</font></b></center></td><td width='310px'><center><b><font size=0.6>NOMBRE</font></b></center></td><td width='50px'><center><b><font size=0.6>EXTENSION</font></b></center></td></tr>";
//		    	   
//		    	   var numerador=1;
//		    	   $.map(datos.lista, function (item) {
//		    		   	
////		    		      alert(item.codigo);
////		    		      alert(item.descripcion);
////		    		      alert(item.extension);
//		    			xhtml+="<tr><td><b><font size=0.5 color='#5D5D5D'>"+numerador+"<font></b></td><td><font size=0.5 color='#5D5D5D'>"+item.descripcion+"</font></td><td><font size=0.5 color='#5D5D5D'>"+item.extension+"</font></td></tr>";
//		    			numerador++;
//		    	   });
//		    	   $.fx.speeds._default = 500;
//		    	  // alert(xhtml);
//		    	   xhtml+="</table >";
//					$( "#contenedordeModalDialog" ).html(xhtml);
//					
//					
//			    	 //para modificar el titulo correctamente
//					
//					var nuevotitulo="AREAS NATURALES HASTA EL A\xF1O "+anio;
//					
//					$('#dialog-modal').attr({'title': nuevotitulo});
//					$('#ui-dialog-title-dialog-modal').html(nuevotitulo);
//					//
//				
//					$( "#dialog-modal" ).dialog({
//						autoOpen: false,
//						show: "blind",
//						width: 400,
//						modal: true,
//						hide: "explode"
//					});
//
//					$( "#dialog-modal" ).dialog( "open" );
//		           //$("#divListaProyectos").html(datos);
//		    	   
//		    	   
//		       }
//		   });
//		
//	
//	
//	
//	});
//	
//	
//			
//});



