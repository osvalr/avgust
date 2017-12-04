function filtrarPersonasParaContrato(parametros){
	var json = ajaxSincronizado(ctx+"/listar-postulante-ganador.action", "POST", "json", parametros);
	return json;
}

function filtrarPersonal(parametros){
	var json = ajaxSincronizado(ctx+"/listar-resumen-personal.action", "POST", "json", parametros);
	return json;
}

