$(function() {
			$("#fechaIni").datepicker({
				showOn: 'both',              // Parametro para que se vea el icono del calendario
				buttonImageOnly: true,       // Indicamos si queremos que solo se vea el icono y no el botón
				buttonImage: './img/16x16/apps/office-calendar.png', // Indicamos el icono del botón
				firstDay: 1,                 // El primer día será el 1
				changeMonth: true,           // Si se pueden cambiar los meses
				changeYear: true,            // Si se pueden cambiar los años
		    	onSelect: function(dateText, inst) {
			    	var lockDate = new Date($('#fechaIni').datepicker('getDate'));
			    	$('input#fechaFin').datepicker('option', 'minDate', lockDate);
			    }
			});		    
			
			$("#fechaFin").datepicker({
				showOn: 'both',              // Parametro para que se vea el icono del calendario
				buttonImageOnly: true,       // Indicamos si queremos que solo se vea el icono y no el botón
				buttonImage: './img/16x16/apps/office-calendar.png', // Indicamos el icono del botón
				firstDay: 1,                 // El primer día será el 1
				changeMonth: true,           // Si se pueden cambiar los meses
				changeYear: true             // Si se pueden cambiar los años
			});
		    
			$("#btnEnviarConsulta").live('click', Fnc_EnviarConsultaPagos);
			
			addRowHandlers('row', 'rowMouseOver', 'lista.detalle.bnk.nacion.jsp', 'id', 0);
			
			
	    });


Fnc_EnviarConsultaPagos = function(){
        	var formp = $("#FormConsultaBnkNacion");
        	Valid.init(formp.find(".valid"));
        	
        	if(Valid.test()){
        		formp.submit();	
        	}
	    	
	    };
	    
    	function showNaturalArea(code){
    		
            $("#IdArea").load("turismo/listaareanatural.action", {"categoriaanp.codcategoriaanp":code});            
        }
        
        function showTurismRoad(code){
            $("#IdRuta").load("turismo/listarutaturismo.action", {"areanatural.codareanatural":code});
        }  
        
        // Valida Fecha
        function esFechaValida(fecha){
            if (fecha != undefined && fecha.value != "" ){
                if (!/^\d{2}\/\d{2}\/\d{4}$/.test(fecha.value)){
                    alert("formato de fecha no vÃ¡lido (dd/mm/aaaa)");
                    return false;
                }
                var dia  =  parseInt(fecha.value.substring(0,2),10);
                var mes  =  parseInt(fecha.value.substring(3,5),10);
                var anio =  parseInt(fecha.value.substring(6),10);
         
            switch(mes){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    numDias=31;
                    break;
                case 4: case 6: case 9: case 11:
                    numDias=30;
                    break;
                case 2:
                    if (comprobarSiBisisesto(anio)){ numDias=29 }else{ numDias=28};
                    break;
                default:
                    alert("Fecha introducida erronea");
                    return false;
            }
                if (dia>numDias || dia==0){
                    alert("Fecha introducida erronea");
                    return false;
                }
                return true;
            }else{
            	return false;
            }
        }
         
        function comprobarSiBisisesto(anio){
        if ( ( anio % 100 != 0) && ((anio % 4 == 0) || (anio % 400 == 0))) {
            return true;
            }
        else {
            return false;
            }
        }
        
        if (!com) var com = {};
        $.displaytag= {
                onPeopleTableLoad: function() {

                    // Se llama cuando se cargan los datos
                    $("table#resultados th.sortable").each(function() {
                        // Itera sobre cada cabecera de columna conteniendo la clase sortable, de manera
                        // que
                        // podemos sobreescribir la gestión de click via ajax, en lugar de
                        // permitir al navegador seguir un enlace normal
                        $(this).click(function() {
                            // "this" es el elemento th ordenable
                            var link = $(this).find("a").attr("href") + " #tablaresultados";
                            $("div#tablaresultados").load(link, {}, $.displaytag.onPeopleTableLoad);
                            // Paramos la propagación de eventos, sin permitir que el navegador ejecute el
                            // href
                            return false;
                        });
                    });
                    $("div#tablaresultados .pagelinks a").each(function() {
                        // Itera sobre cada enlace de paginación para sobreescribirlo
                        $(this).click(function() {
                            var link = $(this).attr("href") + " #tablaresultados";
                            $("div#tablaresultados").load(link, {}, $.displaytag.onPeopleTableLoad);
                            return false;
                        });
                    });
                }
        };
        
	     // Adds onmouseover, onmouseout, and onclick handlers to each table row.  The onmouseover handler changes the row's class attribute to
	     // rowMouseOver.  The onmouseout handler changes it back.  The onclick function makes a request for the specified url, including the
	     // innerHTML of the specified column as a request parameter.
	     function addRowHandlers(tableId, rowClassName, url, paramName, columnIndex) {
	         var previousClass = null;
	         var table = document.getElementById(tableId);
	         var rows = table.getElementsByTagName("tr");
	         for (var i = 1; i < rows.length; i++) {
	             rows[i].onmouseover = function () {
	             previousClass       = this.className;
	             this.className      = this.className + " " + rowClassName ;
	         };
	             
	         rows[i].onmouseout = function () {
	             this.className = previousClass;
	         };
	             
	         rows[i].onclick = function () {
	             var cell       = this.getElementsByTagName("td")[columnIndex];
	             var paramValue = cell.innerHTML;
	             
	             if(paramValue != ""){
	               	 $( "#divModalDetalleBoletaje-dialog" ).dialog( "destroy" );              
	               	    $( "#divModalDetalleBoletaje" ).dialog({
	               	            width: 550,
	               	            height: 450,
	               	            title: 'Detalle Boletaje',
	               	            modal: true,                    
	               	            closeOnEscape: false,
	               	            open: function(event, ui) {$( "#divModalDetalleBoletaje" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Cargando...!!!</i>");},
	               	            close: function(event, ui) {$("#tablaresultados").remove();}
	              	  });
	               	 $("div#divModalDetalleBoletaje").load("turismo/detalleBoletaje.action", {"turismopagos.strRegistroTurista": "" + paramValue + ""}, $.displaytag.onPeopleTableLoad);	                  
	               	 //$("div#divModalDetalleBoletaje").load("turismo/detalleBoletaje.action", {"turismopagos.strRegistroTurista": "" + paramValue + ""});
	                 }
	             };
	         }
	     }