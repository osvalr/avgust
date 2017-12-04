<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<!-- The line below must be kept intact for Sencha Cmd to build your application -->
	<script id="microloader" type="text/javascript" src="<%=request.getContextPath()%>/extjs5/bootstrap.js"></script>

<div id="cmp-ct"></div>

<div id="page-loader">  
    <img style="position:absolute;left:50%; top:50%;" src="<%=request.getContextPath()%>/img/360.gif" />
</div>

<script type="text/javascript">

var alter = true;
var idpersonal = ${USUARIO_ACTUAL.personal.idpersonal};
// var idarea = null;
var idarea 	= ${USUARIO_ACTUAL.areaorganica.idarea};
// var desarea = ${USUARIO_ACTUAL.areaorganica.desarea};
var idunidad = null;



// $.ajax({
//     type: "GET",
//     dataType: "json",
//     url: "obtener-area-actual-personal.action", //Relative or absolute path to response.php file
//     data: {'idpersonal':idpersonal},
//     success: function(json) {
//     	idarea = json.result.idarea;
//     	idunidad = json.result.idunidad; 
//     }
//   });
  
 
  

var component = 'GestionarReqPersonalListAlterno';
var controllerNames = [                
						'MyApp.controller.GestionarReqPersonal.MainController',
						'MyApp.controller.GestionarReqPersonal.ArchivoRequerimientoQueryController'
                    ];
</script>

