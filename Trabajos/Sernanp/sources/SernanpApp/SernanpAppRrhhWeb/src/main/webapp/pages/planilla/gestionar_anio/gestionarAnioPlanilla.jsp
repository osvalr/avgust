<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<!-- The line below must be kept intact for Sencha Cmd to build your application -->
	<script id="microloader" type="text/javascript" src="<%=request.getContextPath()%>/extjs5/bootstrap.js"></script>

<div id="cmp-ct"></div>


<div id="page-loader">  
    <img style="position:absolute;left:50%; top:50%;" src="<%=request.getContextPath()%>/img/360.gif" />
</div>

<script type="text/javascript">
var component = 'GestionarAnioPlanillaList';
var controllerNames = [                
						'MyApp.controller.GestionarAnioPlanilla.MainController',
						'MyApp.controller.GestionarAnioPlanilla.GestionarAnioParametroPlanillaQueryController',
						'MyApp.controller.GestionarAnioPlanilla.GestionarAnioPeriodoPlanillaQueryController'
                     ];
</script>

