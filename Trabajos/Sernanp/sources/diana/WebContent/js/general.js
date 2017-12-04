 function MenuXL(axion,nivelmodulo,idmodulo) {
	 switch (axion) { 
		default:	location.href=axion;						break;
	 }  
}
//Internationalization strings
var labels = {
 	dayNames: [
 		"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
 		"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
 	],
 	monthNames: [
 		"Ene", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
 		"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"
 	] 
 };

var log,dom;
var datepickerOptions = {
		changeMonth: true,
		changeYear: true,
		minDate:"-90Y",  
		maxDate: "-1Y",
		dateFormat:"dd-mm-yy",
		defaultDate:"-10Y",
		yearRange: '1910:2010', 
		showOn: "both", 
		buttonImage: "img/16x16/apps/office-calendar.png",
		buttonImageOnly: true 
	};


var proyectoAction={
	modificaclave:'modificaClaveUsuario.action'
		
};


var ajax={
		fichas:"turismo/fichasAjax",
		check:"turismo/checkFicha", 
		editFicha:"turismo/editFicha",
		consolidarFicha:"turismo/consolidarFicha",
		rutaturismo:'turismo/rutasturismo',
		tipoturismo:'turismo/tiposturismo',
		boletos:'turismo/boletos.action',
		//grabar:'turismo/grabar.action',
		grabarRuta:'turismo/grabarRuta',
		turismomenu:'turismo/menu.action',
		turismomenuope:'turismo/menuOperador.action',
		consultaturismo:'turismo/consultafichaturismo.action',
		consultatipoturismo:'turismo/consultatipoturismo.action',
		reporteturismo:'turismo/reporte.action',
		guardaregvisitante:'turismo/guardaregvisitante.action',
		registroturismo:'turismo/registro.action',
		detallefichaturismo:'turismo/consultadetalleficha.action',
		modificaclaveuseroptur:'turismo/modificaClaveUserOpTur.action',	
		buscaguiaturismo:'turismo/buscaGuiaTurismo.action',
		consultaractividadxtipoturismo:'turismo/consultaactividadxtipoturismo.action'
			//regvisitante:'turismo/irregistrovisitante.action'
	}; 


var turismoAction={
		turismo:'turismo/',
		t_anpturismo:'turismo/anptur.action',
		t_turismomenu:'turismo/menu.action',
		consultafichaturismo:'consultafichaturismo.action',
		regfichaturismo:'regfichaturismo.action',
		registroturismo:'registro.action',
		t_consultafichaturismo:'turismo/consultafichaturismo.action',
		t_consultadetfichaturismo:'turismo/consultadetallefichaturismo.action',
		t_registroturismo:'turismo/registro.action',
		t_consultapagosfichaturismo:'turismo/consultapagosfichaturismo.action',
		t_consultadetallepagofichaturismo:'turismo/consultadetallepagofichaturismo.action',
		t_validapagobancofichaturismo:'turismo/validapagobancofichaturismo.action',
		t_validapagobancofichaturismoxconsolidar:'turismo/validapagobancofichaturismoxconsolidar.action',
		t_regfichaturismo:'turismo/regfichaturismo',
		t_guardaregfichaturismo:'turismo/guardaregfichaturismo.action',
		t_generafichaturismo:'turismo/generafichaturismo.action',
		t_generaconsolidafichaturismo:'turismo/generaconsolidafichaturismo.action',
		t_editarfichaturismo:"turismo/editFicha",
		t_consultadetallefichaturismo:'turismo/consultadetalleficha.action',
		t_buscaguiaturismo:'turismo/buscaGuiaTurismo.action',
		t_consultaractividadxtipoturismo:'turismo/consultaactividadxtipoturismo.action',
		t_reporteturismo:'turismo/reporte.action',
		t_consolidarfichaturismo:"turismo/consolidarFicha",
		t_guardatemporalregfichaturismo:'turismo/guardatempregft.action',
		t_regvisitante:'turismo/regvisitante.action',
		t_guardaregvisficha:'turismo/guardaregvisft.action',
		t_listavisxficha:'turismo/listavisitantesxficha',
		t_eliminalistvisitante:'turismo/eliminalistvisitante.action',
		t_determinaboletajevisitantes:'turismo/detboletvisitante.action',
		t_guardaregvisitanteconsolidado:'turismo/guardaregvisitante.action',
		t_regoperadorturismo:'turismo/regopetur.action',
		t_guardaregoperadorturismo:'turismo/guardaregopetur.action',
		t_guardauseroperadorturismo:'turismo/guardauseropetur.action',
		t_consultaoperadorturismo:'turismo/consultaoperadorturismo.action',
		t_buscaanptur:'turismo/buscaanptur.action',
		t_consultaguiaturismo:'turismo/consultaguiaturismo.action',
		t_regguiaturismo:'turismo/regguiatur.action',
		t_guardaregguiaturismo:'turismo/guardaregguiatur.action',
		t_ejecutaaccionlistguia:'turismo/ejecutaaccionlistguia.action',
		t_ejecutaaccionlistoperador:'turismo/ejecutaaccionlistoperador.action',
		consultaguiaturismo:'consultaguiaturismo.action',
		consultaoperadorturismo:'consultaoperadorturismo.action',
		t_regrestablecerclaveoperador:'turismo/regrestclaveopetur.action',
		t_restclaveoperador:'turismo/restclaveopetur.action',
		t_ejecutaaccionlistficha:'turismo/ejecutaaccionlistficha.action',
		t_accesofichaturismo:'turismo/accesofichaturismo.action',
		t_consultaminfichaturismo:'turismo/consultaminfichaturismo.action',
		t_fichaturismocons:'turismo/fichaturismocons.action',
		t_validapagoincompleto:'turismo/validapinc.action',
		t_consultapagobancoxoperador:'turismo/consultapagobancoxoperador',
		t_validamontopagobanco:'turismo/validamontopagobanco',
	    cargapagosbancofichaturismo:'cargapagosbancofichaturismo.action',
	    t_consultapagobancofichaturismo:'turismo/consultapagosbancofichaturismo.action',
	    t_consultadetalleguiaturismo:'turismo/consultadetalleguiaturismo.action'
};			



var registroAction={
		t_anpregistro:'registro/anpreg.action'
};



var UtilAction={
	u_listaubigeo:'util/listaubigeo.action'
};


var valueConstants={
		tipo_pag_registro:'1',
		tipo_pag_detalle:'2',
		grupo_edad_mayoredad:'1',
		grupo_edad_menoredad:'2',
		grupo_edad_infante:'3',
		pagina_crear_ficha_turismo:'1',
		pagina_editar_ficha_turismo:'2',
		id_pais_peru:'171',
		opcion_crear:'1',
		opcion_editar:'2',
		opcion_eliminar:'3',
		opcion_cancelar:'4',
		opcion_consultardetalle:'10',
		opcion_generarclave:'4',
		opcion_guardar_ficha:'1',
		opcion_generar_ficha:'2',
		opcion_pagar_ficha:'4',
		opcion_consolidar_ficha:'5',
		opcion_ejecutar_accion_ficha:'6',
		opcion_ver:'1',
		opcion_descargar:'2',
		opcion_registro:'1',
		opcion_consulta:'2',
		tipo_registro_crear:'1',
		tipo_registro_editar:'2',
		combo_departamento:'1',	
		combo_provincia:'2',
		msg_usuario_existe:'1',
		msg_ruc_existe:'2',
		msg_dni_existe:'1',
		msg_guia_existe:'2',
		opcion_guardar_opetur:'1',
		opcion_generaruser_opetur:'2',
		longitud_minimo_clave:'7',
		codigo_modpago_bancoficha:'3'
};


var mensajes={
		confirmaciongenerarfichaturismo:'Desea generar la ficha de turismo ahora?Luego ya no se podr\xE1n realizar cambios',
		mensajeexito:'Se registr� con �xito',
		confirmacioneliminarguia:'Desea eliminar el(los) gu\u00EDas seleccionado(s)',
		confirmacioneliminaroperador:'Desea eliminar el(los) operadores seleccionado(s)',
		mensajeguardadoficha:'Los datos generales de ficha se guardaron correctamente',
		confirmacionactualizarboletajevisitantes:'Ha seleccionado otra ruta tur\xEDstica. Desea guardar los cambios y posteriormente modificar el bolejate de los visitantes?',
		confirmacionconsolidarfichas:'Desea consolidar la(s) ficha(s) seleccionada(s)?, luego ya no se podr\xE1n realizar cambios',
		confirmacionconsolidarficha:'Desea consolidar la ficha?, luego ya no se podr\xE1n realizar cambios',
		confirmaciongenerarconsolidarficha:'Desea generar y consolidar la ficha?, luego ya no se podr\xE1n realizar cambios',
        confirmacionpagarfichas:'Desea declarar como pagadas la(s) ficha(s) seleccionada(s)?',
        exitoconsolidacionficha:'La ficha se consolid\u00F3 con \u00E9xito',
        exitoconsolidacionlistadoficha:'La(s) ficha(s) se consolidaron con \u00E9xito'	
};

jQuery.fn.addToDOM = function( ) {
	var items = {};
	for(var i = 0;t = this.length,i<t;i++){
		var item = this[i];
		items[ item.getAttribute('id') ] = $(item); 
	}
	return items;
};

var ie6 = false;
$(function(){
	//var linkanterior="";
	//jQuery('#formMenu').preventDoubleSubmit();
	ie6 = ($.browser.msie && $.browser.version <= 6);
	$(".h").removeClass("h").hide();
	//$('#formMenu').attr('action','');
	linkvolvermenu=$('.linkvolvermenu').live('click',volverMenu);
	 function volverMenu(e) {
	    	e.preventDefault();
	        history.back(1);
	  
	  }
	$('.linkopcionmodulo').live('click',
		function(e){
		var idmod=$(this).find('#paramidmodulo').attr('value');
		var href=$(this).find('#paramhrefmodulo').attr('value');
		var scad = $("#seccadena").val()+'^'+$("#periodo").val(); // Agregado 20/04/11 14:16 -- Yonny
		//linkanterior=href;
		
		$('#formMenu #hdmodulo').val(idmod);
		$('#formMenu').attr('action',href);
		$('#formMenu #seccadena_').val(scad); //Agregado 20/04/11 14:16 -- Yonny
		$('#formMenu').submit();
		//return false;
	    }
	 		
	);
	
	
	
	
	
	//$("#Diana div.r:last").unbind("click"); 
});



jQuery.fn.onlyDigits = function( decimals ) {
    var k,isNumber; 
    // little trick just in case you want use this:
    $('<span></span>').insertAfter(this);
    var $dText = $(this).next('span').hide();
    // Really cross-browser key event handler
    function Key(e) {
        if (!e.which && ((e.charCode || 
        e.charCode === 0) ? e.charCode: e.keyCode)) {
        e.which = e.charCode || e.keyCode;
        } return e.which; }
    return $(this).each(function() {
        $(this).keydown(function(e) {
            k = Key(e);
            isNumber =  (
            // Allow CTRL+V , backspace, tab, delete, arrows,
            // numbers and keypad numbers ONLY
            ( k == 86 && e.ctrlKey ) || (k == 224 && e.metaKey) || 
            k == 8 || k == 9 || k == 46 
              || (k >= 37 && k <= 40) || (k >= 48 && k <= 57) 
              || (k >= 96 && k <= 105));
            
            if ( decimals ){
            	return ( isNumber || k == 110 || k == 190 ); 
            }
            return isNumber;
        }).keyup(function(e) {
            // Check if pasted content is Number
            if (isNaN(this.value)) {
                // re-add stored digits if CTRL+V have non digits chars
                $(this).val($dText.text());
            } else { // store digits only for easy access
                $dText.empty().append(this.value);
            }
        });
    });
};

jQuery.fn.preventDoubleSubmit = function() {
	  jQuery(this).submit(function() {
	    if (this.beenSubmitted)
	      return false;
	    else
	      this.beenSubmitted = true;
	  });
	};

function addCommas(nStr)
{
	nStr += '';
	x = nStr.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	return x1 + x2;
}


function stringToNum(cadnum){
	if($.trim(cadnum)==""){
		cadnum=0;
	}
	return parseFloat(cadnum);
}


function stringToDate(string) {
    var matches;
    if (matches = string.match(/^(\d{4,4})-(\d{1,2})-(\d{1,2})$/)) {
      return new Date(matches[1], matches[2], matches[3], 00, 00);
    } else {
      return null;
    };
  }



function stringToDateF(string) {
    var matches;
    
    if (matches = string.match(/^(\d{1,2})-(\d{1,2})-(\d{4,4})$/)) {
    	sdia=0;smes=0;
    	ndia=0;nmes=0;
    	dia='';mes='';
    	dia= matches[1];
    	/*
    	alert(matches[1]);
    	alert(matches[2]);
    	alert(matches[3]);
    	*/
    	//dia.match(regexp);
    	ndia=parseInt(dia,10);
    	//alert("diaint"+ndia);
    	sdia=ndia+1;
    	mes=matches[2];
    	nmes=parseInt(mes,10);
    	smes=nmes-1;
    	//alert('dia'+sdia);
    	//alert('mes'+smes);
      return new Date(matches[3], smes, sdia, 00, 00);
    } else {
      return null;
    };
  }

//Agregado 02 Oct. 2011 (Y.C.)
if(!Array.indexOf){
    Array.prototype.indexOf = function(obj){
        for(var i=0; i<this.length; i++){
            if(this[i]==obj){
                return i;
            }
        }
        return -1;
    };
}

function in_array( what, where ){
    var a=false;
    for(var i=0;i<where.length;i++){
        if(what == where[i]){
            a=true;
            break;
        }
    }
    return a;
}

//Agregado 04 Oct. 2012
function remove_in_array(itemToRemove,originalArray) {
    
    var j = 0;
    while (j < originalArray.length) {
    	if (originalArray[j] == itemToRemove) {
    		originalArray.splice(j, 1);
    		break;
        }else{ 
            j++; 
        }
    }   
            
}

function reindexArray( array )
{
   var result = [];
    for( var key in array )
            result.push( array[key] );
    return result;
};

jQuery.fn.reset = function () {
	  $(this).each (function() { this.reset(); });
};
