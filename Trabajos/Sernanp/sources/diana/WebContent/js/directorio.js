$(document).ready(function() {
	
	
	
	bdir = $("#btnConsultarDirectorio").click(
    		function (e){
    	  		 e.preventDefault();
    	  		dir= $("#formInicioDirectorio").serialize();
    	  		dir+='&control=2';
    			dir+='&numeroPagina=1';
    	  		$.ajax({
    	  	       url: 'consultaProyecto.action',
    	  	       data: dir,
    	  	       cache: false,
    	  	       type: "POST",
        	  	     beforeSend: function() {
        	  	    /*
        	  	    $("#btnBuscarProyectos").attr("disabled","disabled");
        	  	    htmlesp=" <div style='text-align:center'> Consultando <br/> <img   src='css/loading.gif'  />  </div>";
       	  	    	$("#divListaProyectos").html(htmlesp);
    	  	        */
    	  	    }, 

    	  	       success: function(datos){         
    	  	    	 $("#btnConsultarDirectorio").removeAttr("disabled");
    	  	           $("#divDirectorio").html(datos);
    	  	           
    	  	           
    	  	       }
    	  	   });
    		}	 
    );	
	
	
	
});