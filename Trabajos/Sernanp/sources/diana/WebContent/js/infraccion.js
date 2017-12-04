var idgenInfraccion           = 0;
var idgenSancion              = 0;
var infraccionesSeleccionadas = new Array(); //26 por que son 26 infracciones
var sancionesSeleccionadas    = new Array();
var infraccionesAntiguas      = new Array();


//VARIABLES GLOBALES
var numeroTotalInfracciones=0;
var numeroTotalSanciones=0;
//end

$().ready(function(){		

	// JCEV Colocando para el Control de fechas 24-09-2012
	$("#fechaResolucion__").datepicker({
		showOn: 'both',              // Parametro para que se vea el icono del calendario
		buttonImageOnly: true,       // Indicamos si queremos que solo se vea el icono y no el botón
		buttonImage: './img/16x16/apps/office-calendar.png', // Indicamos el icono del botón
		firstDay: 1,                 // El primer día será el 1
		changeMonth: true,           // Si se pueden cambiar los meses
		changeYear: true,            // Si se pueden cambiar los años
    	onSelect: function(dateText, inst) {
	    	var lockDate = new Date($('#fechaResolucion__').datepicker('getDate'));
	    	$('input#fechaNotifResolucion__').datepicker('option', 'minDate', lockDate);
	    }
	});		    
	
	$("#fechaNotifResolucion__").datepicker({
		showOn: 'both',              // Parametro para que se vea el icono del calendario
		buttonImageOnly: true,       // Indicamos si queremos que solo se vea el icono y no el botón
		buttonImage: './img/16x16/apps/office-calendar.png', // Indicamos el icono del botón
		firstDay: 1,                 // El primer día será el 1
		changeMonth: true,           // Si se pueden cambiar los meses
		changeYear: true             // Si se pueden cambiar los años
	});	
	
    // When a link is clicked
    $("a.tab").click(function () {               
          // switch all tabs off
          $(".active").removeClass("active");

          // switch this tab on
          $(this).addClass("active");

          // slide all content up
          $(".content").slideUp();

          // slide this content up
          var content_show = $(this).attr("title");
          $("#"+content_show).slideDown();
    });    
       
  });    

function checkLen(x,y) {
  if (y.length == x.maxLength) {
     var next = x.tabIndex;
     if (next<document.getElementById("formularioInfractor").length){
        this.controlReincidencia();
       	$("#BotonAdd").focus();
//            document.getElementById("formularioInfractor").elements[next].focus();
     }
  }
}

// Validando Formulario
function enviarFormulario() { 
var Archivo = "&file=" + $('#archivoAdjunto').val();                                
    //seteaIndex();

    // Validamos que no mande infracciones vacias;          
    Valid.init( $("#formularioInfractor .valid")  );  

    if(Valid.test()){
        if(infraccionesSeleccionadas.length == 0){
            alert("Debe agregar por lo menos una Infracción!!!");
            return false;
        }else if(numeroTotalSanciones == 0){
            alert("Ingrese sanción!");
            return false;
        }else{
            seteaIndex();
            
//            $.post('registraInfractor.action',
//              $("#formularioInfractor").serialize()+Archivo,function(data){

            $('#formularioInfractor').attr("action","registraInfractor.action");
            $('#formularioInfractor').attr("method","post");
            
            var options = {
            		target:        '#dialogFormWrite',
                    beforeSubmit:  showRequest, 
                    success:       showResponse
                }; 
            
            //$('#formularioInfractor').ajaxForm();
            
            $('#formularioInfractor').ajaxSubmit(options);
            
            function showRequest() {
            	$('#dialogFormWrite:ui-dialog' ).dialog('destroy'); 
            	$('#dialogFormWrite').dialog({
            	    modal: true,	
            	    width: 350,         
            	    height: 'auto',
            	    closeOnEscape: false,
            	    open: function() { 
            	    	$(this).closest(".ui-dialog").find(".ui-dialog-titlebar:first").hide(); 
            	    	$( "#dialogFormWrite" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Guardando...!!!</i>");
            	    }
            	});
            	    
                return true; 
            }
            
            function showResponse(){
            	$('#dialogFormWrite').dialog({
            	    buttons: {	    	
                    Continuar: function() {
                    	
                    	var datos = $('#dialogFormWrite').html();
                    	
                    	if (datos.indexOf("ERROR") >= 0){
                    		$( this ).dialog('close');
                    	}else if (datos.indexOf("SUCCESS") >= 0){                    	
                    		$('#formularioInfractor').reset();
                     	   	$("#divLinkInfra input").removeClass('btnInfra').addClass('btnInfraDisabled');                     	   	
                            //$('#formularioInfractor').attr('action','nuevoInfractor.action');
                            //$('#formularioInfractor').submit();
                     	   	
                     	   $("#totalInfracciones div[class='elimInf']").each(function (index) {                     		 
                     		  var row1 = $(this);
                     		  var idDiv = row1.attr("id");
                     		  var idVal = idDiv.split('_'); 
                     		  Fnc_quitarInfraccion(idDiv, idVal[1]);
                     	  });
                     	   
                     	  $("#hor-minimalist-a tbody tr[class='cabN']").each(function (index) {
                              
                     		 var row1 = $(this);
                    		 var idDiv = row1.attr("id");
                    		 var idVal = idDiv.split('_');
                    		 table_elimina(idVal[1]);
                     	 }); 
                     	   	
                            $('#formularioInfractor').resetForm();
                 		   	$( this ).dialog('close');
                    	}                  	   
                     }             
            	    }	   
            	}); 
            }
            
        }                       
    }
}


// Para el Combo	
var aMatrix      = new Array();
var sancionVal   = 0;                           
function agregarSancion(e){
                        
        var sancionSelect = $("#listaSanciones option:selected");
        var sancionText = sancionSelect.text();
//      var nLen        = 0;     
        //var nItem       = 0;
        var nItem       =  aMatrix.length;
        var tabla       = 0;
        var nuevaFila   = 0;
        var celda;

   // Validamos que lo seleccionado no este agregado ya
// nLen         = 18;
   sancionVal   = sancionSelect.val();     
   $('select#listaSanciones').prop('selectedIndex', 0);

   if(in_array(sancionVal, aMatrix)){
       return false;
   }
   
   if(sancionVal==-1){
       return false;
   }

    // Actualiza la Matrix, de acuerdo a sancionVal 
    //tabla               = document.getElementById("Detail_Table");
    tabla               = $(".tabla_Table tbody");    
    //nuevaFila           = tabla.insertRow(-1);    
    //nuevaFila.id        = 'TR_'+sancionVal;
    //nuevaFila.className = "cabN";
    var nuevaFila = $("<tr id='TR_"+sancionVal+"' class='cabN'>");
    aMatrix[nItem]      = sancionVal;
                
    
    if(sancionVal == 1){
       //celda           = nuevaFila.insertCell(-1);
       sancionText     = sancionText + '<input type="hidden" class="idClase" name="expediente.listaExpedienteSancion[_n].sancion.idsancion" ' + 
                         'value="'+sancionVal+'"/>';
       //celda.innerHTML = sancionText;
       
       $("<td>").html(sancionText).data("col", 0).appendTo(nuevaFila);
       
       
       //celda           = nuevaFila.insertCell(-1);
       sancionText     = 'Monto(S/.) :<input type="text" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.datoVariado"' +
                         ' size="10" style="text-align: right;" value="" class="content_ valid decimal onlydigits campoSancion" >';
       //celda.innerHTML = sancionText;
       
       $("<td>").html(sancionText).data("col", 1).appendTo(nuevaFila);
       
       //celda           = nuevaFila.insertCell(-1);       
       //celda.innerHTML = 
       sancionText = '<input type="text" class="content campoObs" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.observacion" ' +
                         'size="25" value="" maxlength="100" />';
       
       $("<td>").html(sancionText).data("col", 2).appendTo(nuevaFila);
    }
    if(sancionVal == 2){
       //celda           = nuevaFila.insertCell(-1);
       //celda.innerHTML = sancionText + '<input type="hidden" class="idClase" name="expediente.listaExpedienteSancion[_n].sancion.idsancion" value="'+ sancionVal + '"/>';
       sancionText += '<input type="hidden" class="idClase" name="expediente.listaExpedienteSancion[_n].sancion.idsancion" value="'+ sancionVal + '"/>';
       $("<td>").html(sancionText).data("col", 0).appendTo(nuevaFila);
    	
       //celda           = nuevaFila.insertCell(-1);
       //celda.innerHTML = '<input type="hidden" class="campoSancion" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.datoVariado" size="10" value="" >';
       sancionText = '<input type="hidden" class="campoSancion" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.datoVariado" size="10" value="" >';
       $("<td>").html(sancionText).data("col", 1).appendTo(nuevaFila);
       
       //celda           = nuevaFila.insertCell(-1); 
       //celda.innerHTML = '<input type="text" class="content campoObs" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.observacion" ' +
       //                  'size="25" value="" maxlength="100" />';
       
       sancionText = '<input type="text" class="content campoObs" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.observacion" ' +
       				 'size="25" value="" maxlength="100" />';
       $("<td>").html(sancionText).data("col", 2).appendTo(nuevaFila);
       
    }
    if(sancionVal == 3){
       //celda           = nuevaFila.insertCell(-1);
       //celda.innerHTML = sancionText + '<input type="hidden" class="idClase" name="expediente.listaExpedienteSancion[_n].sancion.idsancion" value="'+sancionVal+'"/>';
       
       sancionText += '<input type="hidden" class="idClase" name="expediente.listaExpedienteSancion[_n].sancion.idsancion" value="'+sancionVal+'"/>';
       $("<td>").html(sancionText).data("col", 0).appendTo(nuevaFila);
       
       //celda           = nuevaFila.insertCell(-1);
       //celda.innerHTML = '<div class="l">' +
       sancionText = '<div class="l">' +
       					 '<input type="hidden" class="campoClausura" value="" />' +
       					 
       					 '<input type="radio" name="tipoClausula" value="1" align="right"' +
                         ' onclick="javascript:habilitarDias(this,'+sancionVal+');" checked />Definitiva ' +
                         '<input type="radio" name="tipoClausula" value="2"' +
                         ' onclick="javascript:habilitarDias(this,'+sancionVal+');" />Temporal</div>' +                             
                         
                         // JCEV 17-09-2012, actualizado 18-09-2012 por Yonny 
                         '<div class="l h" id="divCampoDay">Dias. <input type="text" id="paramDias' + sancionVal + '"' +
                                 'size="5" value= "" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.datoVariado" onkeypress="return validarNro(event);" ' +
                                 'style="text-align: right;" /></div>';
       
       $("<td>").html(sancionText).data("col", 1).appendTo(nuevaFila);
       
       //celda           = nuevaFila.insertCell(-1);
       //celda.innerHTML
       sancionText = '<input type="text" class="content campoObs" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.observacion" ' +
                         'size="25" value="" maxlength="100" />';
       
       $("<td>").html(sancionText).data("col", 2).appendTo(nuevaFila);
    }
    if(sancionVal > 3){
       //celda           = nuevaFila.insertCell(-1);
       sancionText     = sancionText + '<input type="hidden" class="idClase" name="expediente.listaExpedienteSancion[_n].sancion.idsancion" value="'+sancionVal+'"/>';
       //celda.innerHTML = sancionText;
       
       $("<td>").html(sancionText).data("col", 0).appendTo(nuevaFila);
       
       //celda           = nuevaFila.insertCell(-1);
       //celda.innerHTML
       sancionText = '<input type="hidden" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.datoVariado" class="campoSancion" size="10" value="" >';
       
       $("<td>").html(sancionText).data("col", 1).appendTo(nuevaFila);
       
       //celda           = nuevaFila.insertCell(-1);
       //celda.innerHTML
       sancionText = '<input type="text" class="content campoObs" name="expediente.listaExpedienteSancion[_n].detalleExpedienteSancion.observacion" ' +
                         'size="25" value="" maxlength="100" />';
       
       $("<td>").html(sancionText).data("col", 2).appendTo(nuevaFila);
    }   
    //celda           = nuevaFila.insertCell(-1);
    //celda.innerHTML
    sancionText = '<div style="text-align:center;cursor:pointer;" ' + 
                      'onclick=javascript:table_elimina(' + sancionVal + ')>' +
                      '<img src="img/eraser.png" border="0"/></div>';
    
    $("<td style='width: 15px;'>").html(sancionText).data("col", 3).appendTo(nuevaFila);
    
    
    nuevaFila.appendTo(tabla);
    
    // Importante
    numeroTotalSanciones++;
    //nItem               = aMatrix.length + 1;
    
    return true;            
}

// JCEV 07-11-2012
function eliminaTablaSancion(){
var nPos = aMatrix.length;
var nMat = 0;
var xn   = 0;
  for(xn=1;xn<=nPos;xn++){
	  nMat = aMatrix[xn]; 
	  this.table_elimina(nMat);
  }  
}       

function table_elimina(n){
  //var tabla = document.getElementById('Detail_Table');
  //tabla.deleteRow(fila.rowIndex);
  $("#TR_"+n).remove();
  remove_in_array(n, aMatrix);
  aMatrix   = reindexArray(aMatrix);
  numeroTotalSanciones--;
  
}       

// JCEV 08-11-2012
function elimimaTablaInfracciones(){
//	function elimimaTablaInfracciones(nPos){
//	var DivIF    = "divIF_" + nPos;
//	var contiena = ":contains('" + DivIF + "')";
//	$("#totalInfracciones").remove(contiena);
	$("#totalInfracciones").remove(":contains('divIF_')");
	$("#totalInfracciones").remove();
}

function quitarTotalInfracciones(){   
	var nLen = infraccionesSeleccionadas.length;
    var idx  = 0;     
	var i    = 0;
	for(i=0;i<nLen;i++){
        obj = $("#" + i);
        obj.remove();
        idx = infraccionesSeleccionadas.indexOf(0);     
        infraccionesSeleccionadas.splice(idx,1);
	}
}

//JCEV 08-11-2012
function deleteAllTablesRows(){
  var tabla     = document.getElementById('Detail_Table');
  var nLen      = $("#Detail_Table").attr('rows').length; // tabla.rows.length;
  var nuevaFila = 0;
//  var rowCount = $('table#Detail_Table:last').index() + 1;
// alert("Len : " + nLen);
//alert("Len : " + nLen + " -- " + $("#Detail_Table").attr('rows').length + " **** " + rowCount);
  if(nLen>0){
	  while(nLen>0){
		  alert("Len : " + nLen);
		  // tabla.deleteRow(nLen - 1);
		  removeRow(tabla);
//		  tabla.deleteRow(0);
		  nLen = $("#Detail_Table").attr('rows').length; // tabla.rows.length;
	  }
      // nuevaFila = tabla.insertRow(-1);
  }
}       

function removeRow(form) {
    form.deleteRow(form.deleteIndex.value);
    updateRowCounters(form);
}

function updateRowCounters(form) {
    var sel1 = form.insertIndex
    var sel2 = form.deleteIndex
    sel1.options.length = 0
    sel2.options.length = 0
    for (var i = 0; i < form.rows.length; i++) {
        sel1.options[i] = new Option(i, i)
        sel2.options[i] = new Option(i, i)
    }
//    form.removeRowBtn.disabled = (i==0)
}

// JCEV 04-09-2012
function pad(number, length, caracter) {
           
    var str = '' + number;
    while (str.length < length) {
        str = ' ' + str;                
    }      
    return str;
}

var STR_PAD_LEFT  = 1;
var STR_PAD_RIGHT = 2;
var STR_PAD_BOTH  = 3;   

function padUnique(str, len, pad, dir) {
        if (typeof(len) == "undefined") { var len = 0; }
        if (typeof(pad) == "undefined") { var pad = ' '; }
        if (typeof(dir) == "undefined") { var dir = STR_PAD_RIGHT; }
 
        if (len + 1 >= str.length) {     
                switch (dir){    
                        case STR_PAD_LEFT:
                                 str = Array(len + 1 - str.length).join(pad) + str;
                             break;      
                        case STR_PAD_BOTH:
                             var i     = 0;
                                 var right = Math.ceil((padlen = len - str.length) / 2);
                                 var left  = padlen - right;
                                 str       = Array(left+1).join(pad) + str + Array(right+1).join(pad);
                             break;      
                        default:
                                 str = str + Array(len + 1 - str.length).join(pad);
                             break;      
                } 
        }       
        return str;      
}       

function LPad(ContentToSize,PadLength,PadChar){
  var PaddedString = ContentToSize.toString();
  var i            = 0;
  for(i = ContentToSize.length + 1;i<=PadLength;i++){
    PaddedString = PadChar + PaddedString;
  }
  return PaddedString;
}
        
// JCEV 21-08-2012
function ver(){
        if(document.all['nombre_div'].style = 'background-color:#eeeeee;border:1px solid'){
                document.all['nombre_div'].style = 'display:none;overflow: auto;'; 
        }else{
                document.all['nombre_div'].style = 'background-color:#eeeeee;border:1px solid'; 
        }
}

// JCEV 20-08-2012
function valorSeleccionado(attribName){
        
        // Obtener la referencia a la lista
        var newLength = 0;
        var nValor    = getSelectElementById(attribName);
        
        if(nValor == 1){
                newLength = '8';
        }else if(nValor == 2){
                newLength = '23';
        }else if(nValor == 3){
                newLength = '15';
        }else if(nValor == 4){
                newLength = '11';
        }
        document.all['paramNumeroDocumento'].maxLength = newLength; 
        document.all['paramNumeroDocumento'].size      = newLength;             
        
        if(nValor == 4){
            mostrardiv('frmRazonSocial','paramRazSocial');
            mostrardiv('frmRepLegal','paramRepLegal');
            cerrar('frmApePat','paramApePat');
            cerrar('frmApeMat','paramApeMat');
            cerrar('frmNombre','paramNombre');
        }else{
            cerrar('frmRazonSocial','paramRazSocial');
            cerrar('frmRepLegal','paramRepLegal');
            mostrardiv('frmApePat','paramApePat');
            mostrardiv('frmApeMat','paramApeMat');
            mostrardiv('frmNombre','paramNombre');
        }
}

function habilitarDias(obj, vs){
        
        // Obtener la referencia a la lista
        if(obj.value == 2){
                //mostrardiv('frmTemporalDias', 'radioTmp');
                $("#divCampoDay").css("display","block");
                $("#paramDias"+vs).addClass("content_ valid onlydigits campoSancion");
        }else{
                //cerrar('frmTemporalDias', 'radioTmp');
                $("#divCampoDay").css("display","none");
                $("#paramDias"+vs).removeClass("content_ valid onlydigits campoSancion");
        }
        
        $(".campoClausura").val(obj.value);
}

function OptioncantDias(){
        
        // Obtener la referencia a la lista
        var lista  = document.getElementById("tipoClausula");
        var nValor = lista.options[lista.selectedIndex].value;
        // alert('nValor : ' + nValor);
        if(nValor == 2){
                mostrardiv('frmTemporalDias');
        }else{
                cerrar('frmTemporalDias');
        }
        
}

// Obtener el valor de la posicion en la lista
function getSelect(){
        var lista  = document.getElementById("Documento");
        var nValor = lista.options[lista.selectedIndex].value;
        return nValor;
}

// Obtener el valor de la posicion en la lista
function getSelectElementById(nombre){
        //var lista  = document.getElementById(nombre);
        //var nValor = lista.options[lista.selectedIndex].value;
        nValor = $("#"+nombre).val();
        return nValor;
}

function clearTextbox(){
        document.formularioInfractor.paramNumeroDocumento.value = '';
}

function soloLetras(e){
  key        = e.keyCode || e.which;
  tecla      = String.fromCharCode(key).toLowerCase();
  letras     = " áéíóúabcdefghijklmnñopqrstuvwxyz";
  especiales = [8,37,39,46];

  tecla_especial = false
  for(var i in especiales){
      if(key == especiales[i]){
                   tecla_especial = true;
                   break;
      } 
  }       
          if(letras.indexOf(tecla)==-1 && !tecla_especial){
             return false;
          }else{
             return true;
          }       
}

function conMayusculas(field) {
    field.value = field.value.toUpperCase()
}
        
function validarEntero(valor){ 
        // Intento convertir a entero. 
    // Si era un entero no le afecta, si no lo era lo intenta convertir 
    valor = parseInt(valor); 

        //Compruebo si es un valor numérico 
        if (isNaN(valor)) { 
         // Entonces (no es numero) devuelvo el valor cadena vacia 
         return
        }else{ 
         // En caso contrario (Si era un número) devuelvo el valor 
         return valor 
        } 
}

// En JQuery
function mostrardiv(nombre, idinput) {
        var div  = $("#" + nombre);             
        var div2 = $("#" + idinput);
        div.css("display","block");
        div2.addClass("content valid");
        
}

function cerrar(nombre, idinput) {
        var div = $("#" + nombre);              
        div.css("display","none");
                        
        var div2 = $("#"+idinput);
        div2.removeClass("content valid");
        
}

// En Javascript
function mostrardivJavascript(nombre) {
        var div = document.getElementById(nombre);
        div.style.display = "";
}

function cerrarJavascript(nombre) {
        div = document.getElementById(nombre);
        div.style.display = "none";
        
}

// Solo acepta numero y punto decimal
function fieldNumber (objeto){
var valorCampo;
var evento_key      = window.event.keyCode;
var numPosPunto     = 0;
var strParteEntera  = "";
var strParteDecimal = "";
var NUM_DECIMALES   = 2;
        switch (evento_key){
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 46:
                        valorCampo = objeto.value;
                        if (evento_key == 46)
                        if (valorCampo.indexOf(".") != -1){
                                window.event.keyCode = 0;
                                return false;
                        }
                        /* Sólo puede teclear el número de decimales indicado en NUM_DECIMALES */
                        if ((numPosPunto = valorCampo.indexOf(".")) != -1){
                                strParteEntera  = valorCampo.substr(0,(numPosPunto - 1));
                                strParteDecimal = valorCampo.substr((numPosPunto + 1), valorCampo.length)
                                if (strParteDecimal.length > (NUM_DECIMALES - 1)){
                                        window.event.keyCode = 0;
                                        return false;
                                }
                        }
                        return true;
                    break;
                default:
                    window.event.keyCode = 0;
        }
    return false;
}

// Backspace = 8, Enter = 13, ’0′ = 48, ’9′ = 57, ‘.’ = 46
// if (key <= 13 || (key >= 48 && key <= 57) || key == 46)
function validarNro(e) {
        var key;
        if(window.event){  // IE                        
                key = e.keyCode;
        }else if(e.which){ // Netscape/Firefox/Opera
                key = e.which;
        }
        if ((key >= 48 && key <= 57) || key < 13){
       return true;
    }
        return false;
}

function soloNumeros(evt){
        
    // Validar la existencia del objeto event
    evt = (evt) ? evt : event;
     
    // Extraer el codigo del caracter de uno de los diferentes grupos de codigos
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0));
     
    // Predefinir como valido
    var respuesta = true;
     
    // Validar si el codigo corresponde a los NO aceptables
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        // Asignar FALSE a la respuesta si es de los NO aceptables
        respuesta = false;
    }
     
    // Regresar la respuesta
    return respuesta;
}       




// Metodo para agregar y quitar sancion
// Agregar Sancion
var linkEjecTec = $('#linkAddSancion').live("click",
        function (e){ 
                e.preventDefault();
                agregarSancion(e);
        }
);

//quitar sancion
/*
function quitarSancion(e,v){            
         e.preventDefault();
         $(this).parent().parent().remove();
         $('#listaSanciones').val(-1);
         numeroTotalSanciones--;
}*/


function quitarSancion(e,v){     
         $("#"+v).remove();
         $('#listaSanciones').val(-1);
         numeroTotalSanciones--;
}

//limpia caja de texto
function limpiacaja(obj){
        $(obj).val('');
}

var Fnc_cargaModalInfracciones = function(){
        $.ajax({
              url: 'listaInfracciones.action',
              data: "cadIds ="+infraccionesSeleccionadas.join("-"),
              cache: false,
              type: "post",
              success: function(datos){
                  var showInf = $("#muestraInfracciones");
                  showInf.html(datos);
                        //$( "#muestraInfracciones" ).dialog( "open" );
                  $( "#dialog:ui-dialog" ).dialog( "destroy" );
                  showInf.dialog({
                        width: 600,
                        height: 500,
                        autoOpen: true,
                        modal: true,
//                      overflow:scroll,
                //$('body').css('overflow','hidden');$('.ui-widget-overlay').css('width','100%'); 
                        /*open: function(event, ui){
                                $('#muestraInfracciones').css('background-color','white');
                                $('.ui-dialog').css('background-color','white');
                                $('.ui-dialog-buttonpane').css('background-color','white');
                                $('body').css('overflow','hidden');
                                $('.ui-widget-overlay').css('width','100%');
                                },*/
                    close: function(event, ui){
                        showInf.children().remove();
                        $('body').css('overflow','auto'); 
                        } ,
                        buttons: {
                                "A\xf1adir": function() {
                                        Fnc_insertarinfraccion("totalInfracciones");
                                        $( this ).dialog( "close" );                                                    
                                }
                        }
                });                               
             }
          });   
}

function Fnc_insertarinfraccion(idiv){
    selector = "#" + idiv;
    chkinfra = document.ForminfraccionesSeleccionadas.elements["chkinfra"];
    codinfra = document.ForminfraccionesSeleccionadas.elements["codinfra"];
    desinfra = document.ForminfraccionesSeleccionadas.elements["desinfra"];
    for(var i = 0; i < chkinfra.length; i++ ){
        if(chkinfra[i].checked == true){
            if(!in_array(chkinfra[i].value,infraccionesSeleccionadas)){
                    html = "<div id='divIF_"+chkinfra[i].value+"' class='elimInf' onmouseover=className='elimInfHover' onmouseout=className='elimInf'>" +
                                    "<input type='hidden' name='expediente.listaExpedienteInfraccion["+i+"].infraccion.idinfraccion' value="+chkinfra[i].value+" />" +
                                    "<input type='hidden' name='expediente.listaExpedienteInfraccion["+i+"].reincidencia' id='inputReincidencia"+chkinfra[i].value+"' value='1' />" +
                                    "<div style='float:left;width:30px;'>"+codinfra[i].value.toString()+"</div>" +
                                    "<div style='float:left;width:700px;'>"+desinfra[i].value.toString()+"</div>"+
                                    "<div class='i_supr i' style='float:left;margin:0 5px;' title='quitar' onClick = javascript:Fnc_quitarInfraccion('divIF_"+chkinfra[i].value+"','"+chkinfra[i].value+"'); ></div>"+
                                    "<div class='clear' />" +
                                    "</div>";
                    $(selector).append(html);
                    infraccionesSeleccionadas.push(chkinfra[i].value);
            }
        }
    }           
    for(var i=0;i<=infraccionesAntiguas.length;i++){        
            var aux= "#divIF_"+infraccionesAntiguas[i];             
            var input="#inputReincidencia"+infraccionesAntiguas[i];
            $(aux).addClass("TrReincidente");
            $(input).val('2');      
    }
}

function Fnc_quitarInfraccion(idDiv, idVal){   
        obj = $("#" + idDiv);
        obj.remove();
        var idx = infraccionesSeleccionadas.indexOf(idVal);     
        infraccionesSeleccionadas.splice(idx,1);        
}

function Fnc_quitarSancion(idDiv, idVal){       
        obj = $("#" + idDiv);
        obj.remove();
        $('#listaSanciones').val(-1);
        var idx = arregloSancionesCargadas.indexOf(idVal);      
        arregloSancionesCargadas.splice(idx,1);
}

// PARA EL LISTADO DE CHECK BOX
function chequea(obj){
        return;
        /*
        var checkeado = $(obj).attr('checked');
        var x =$(obj).val();
        if(checkeado){ 
                infraccionesSeleccionadas[x]="1";
        }else{
                infraccionesSeleccionadas[x]="0";
        }*/
        
}

$("#DNI").live('click',function(){
        var objrtd = $("#DNI");
        var checkeado=objrtd.attr('checked');
        if(checkeado){
                 $('#paramTipoDocumento').val(objrtd.val());            
                 $('#paramNumeroDocumento').val("");
                 $('#paramNumeroDocumento').attr("size","8");
                 $('#paramNumeroDocumento').attr("maxlength","8");
        }
});

$("#CE").live('click',function(){
        var objrtd = $("#CE");
        var checkeado=objrtd.attr('checked');
        if(checkeado){
                 $('#paramTipoDocumento').val(objrtd.val());
                 $('#paramNumeroDocumento').val("");
                 $('#paramNumeroDocumento').attr("size","15");
                 $('#paramNumeroDocumento').attr("maxlength","15");
        }                                                       
});

// METODOS PARA EDITAR
var linkDetProy = $('.linkRegProy').live("click",
        function (e){ 
                e.preventDefault();
                var id= $(this).attr("name");
                //alert(" a ditar !!/"+id);
                //$("#formInicioProyectos").attr('action','/diana/registroProyecto.action?idProyectoParam='+id);
                
                $("#paramIdExpediente").val(id);
                $("#formularioOcultoEditar").attr('action','mostrarEditarExpediente.action');//$("#formInicioProyectos").attr('action','/diana/registroProyecto.action?idProyectoParam='+$(this).attr("param"));                        
                $("#formularioOcultoEditar").submit();
        }
);

var linkDelImg = $('.linkDelImg').live("click",
        function (e){ 
                e.preventDefault();                                             
                $("#formularioInfractor").attr('action','descargaArchivoExpediente.action');                    
                $("#formularioInfractor").submit();                                         
        }               
);

// METODOS PARA LA PAGINACION
$('#btnConsultar').live("click",
		function (e){ 
   			e.preventDefault();
   			nPag = $(".paginationinf a[class='active']").attr('name');
   			listarInfractoresXDocumento(e);
		}
);

// JCEV 27-08-2012
function controlReincidencia(e){
	$.post('verificaInfractorEnSistema.action', 
    	   {nroDoc:$("#paramNumeroDocumento").val(), 
    	    tipDoc:$("#tipoDocumento").val()}, function(datos) {
         var infractor = datos.MyInfractor;
         if(infractor != null){
             var idinFractor = infractor.idinfractor;
             var numerodoc   = infractor.numerodocumento;
                                       
             $('#idInfractorAyuda').val(idinFractor);
             $('#paramNumeroDocumento').val(numerodoc);
             if($('#tipoDocumento').val() == 4){
                 var razonSocial = infractor.empresa;
                 
                 // JCEV 21-10-2012, viene la Inf. de RowMapper: InfractorJuridicoMapper
                 var personJurid = infractor.nombrepersonajuridica;
                                             
                 $('#paramRazSocial').val(razonSocial);
                 $('#paramRazSocial').attr('readOnly','readOnly');
                 
                 // JCEV 21-10-2012, con esto se muestra la información en
                 // Representante Legal de la pantalla de REGISTRO DE INFRACTORES
                 $('#paramRepLegal').val(personJurid);
                 $('#paramRepLegal').attr('readOnly','readOnly');
                                          
             }else{
                     var nombres = infractor.nombre;
                     var apePat  = infractor.apepat;
                     var apeMat  = infractor.apemat;
                     $('#paramApePat').val(apePat);
                     $('#paramApeMat').val(apeMat);
                     $('#paramNombre').val(nombres);
                     $('#paramApePat').attr('readOnly','readOnly');
                     $('#paramApeMat').attr('readOnly','readOnly');
                     $('#paramNombre').attr('readOnly','readOnly');
             }
         }else{        	 
             var numerodoc = $('#paramNumeroDocumento').val();
             //$('#idInfractorAyuda').val('00');
             $('#paramNumeroDocumento').val(numerodoc);
             if($('#tipoDocumento').val() == 4){
                $('#paramRazSocial').val('');
                $('#paramRazSocial').attr('readOnly',false);
                $('#paramRepLegal').val('');
                $('#paramRepLegal').attr('readOnly',false);
             }else{            	 
                $('#paramApePat').val('');
                $('#paramApeMat').val('');
                $('#paramNombre').val('');
                $('#paramApePat').attr('readOnly',false);
                $('#paramApeMat').attr('readOnly',false);
                $('#paramNombre').attr('readOnly',false);
             }
         }
         
         $("#divLinkInfra input").removeClass('btnInfraDisabled').addClass('btnInfra');
         $("#divLinkInfra input").click(Fnc_cargaModalInfracciones);
         
         $.post('verificaReincidenciaInfracciones.action',
        		                         {idInfractor:$("#idInfractorAyuda").val()}, 
            function(datosInfracciones) {
                    var listaInfraccionesAntiguas = datosInfracciones.InfraccionesAntiguas;
                    if(listaInfraccionesAntiguas!=null){
                            for(var i=0;i<listaInfraccionesAntiguas.length;i++){
                                    infraccionesAntiguas[i] = listaInfraccionesAntiguas[i].idinfraccion;
                            }
                    }else{
                            for(var i=0;i<listaInfraccionesAntiguas.length;i++){
                                    infraccionesAntiguas[i] = 0;
                            }
                    }                       
            },'json');
    },'json');
}



//Funcion para setear index de objetos input
function seteaIndex(){
        
        var nn1 = 0;
        $("#hor-minimalist-a tbody tr[class='cabN']").each(function (index) {
                                
                var row1 = $(this);             
                
                
                var idSanc = row1.find('.idClase').val();
        		var valCampo = row1.find('.campoClausura').val();
                
                var valdat = row1.find('.campoSancion').val();
                var valobs = row1.find('.campoObs').val();
               
                /*
                if(idSanc == 1){
        			valdat = "S/. " + valdat;
        		}else if(idSanc == 3){		
        		    if(valCampo != "" && valCampo == 2) {  
        				valdat += " Días";
        	        }  
        		}else{
        			valdat = "";
        		}*/
                
                
                var row2 =row1.html().replace(/_n/g,nn1);       
                var row = $(row2);
                row1.html(row);                                
                
                row1.find('.campoSancion').val(valdat);
                row1.find('.campoObs').val(valobs);
                
                nn1++;          
    });
      
}

function listarInfractoresXDocumento(){
	var codi = $('#paramCodInfractor').val();	
	$.post("listarInfractoresXDocumento.action",{dniRecibido:codi}, function(data) { 
		   $('#DivRecargarInfractores').html(data);
		});
}

/* ****************************************** */
/* PARA EL LISTADO DE INFRACTORES - MOROSIDAD */
/* ****************************************** */
function actualizarInfractores(n){ 
	var numeropagina = (n > 0) ? n : 1;
	$.post("listarInfractores.action",{numeropagina:numeropagina}, function(datos) {
		
			$('#DivRecargarInfractores').html(datos);
	});
};

//09-05-2013
function actualizarInfractoresxAnp(n){ 
	var numeropagina = (n > 0) ? n : 1;
	
	$.post("listarInfractoresxanp_.action",{'categoriaanp.idcategoriaanp':$("#sel_idcategoriaanp").val(),'areanatural.idareanatural':$("#sel_idareanatural").val(),numeropagina:numeropagina}, function(datos) {
		
			$('#DivRecargarInfractores').html(datos);
	});
};


// JCEV 12-10-2012, actualizado: 15-10-2012
function updateMorosos(idExp){

	var nPagina = $("#PaginaActual").val();

   // Abrimos el diàlogo de confirmación
   // $('#dialogoFormulario').dialog('open');
   // alert(idExp);
   $( "#dialogoFormulario:ui-dialog" ).dialog( "destroy" ); 

   // Damos formato a la Ventana de Diálogo
   $('#dialogoFormulario').dialog({
	    modal: true,	
	    width: 350,         
	    height: 'auto',	    
	    buttons: {	    	
	           Aceptar: function() {
	               
	   			   // Mostramos un alert con los datos del formulario
	   			   $.post("updateMorosidad.action",{nIdExpediente:idExp}, function(datos) { 
				   		$("#divMensajeMor").html(datos);
					    $("#divMensajeMor").fadeIn(500).fadeOut(2000);					
	   			   });
	   			   
	   			   $( this ).dialog( "close" );
	   			   	
	   			   // JCEV 15-10-2012 Actualizado
 				   $.post("listarInfractores.action", {numeropagina:nPagina}, function(datos){
 					   $("#DivRecargarInfractores").html(datos);
 				   });		    	  	   
	           },
	   
	           Cancelar: function() {
	   
	               // Cerramos el diálogo
	               $( this ).dialog( "close" );	   
	           }	   
	       }	   
   });
   
}

// JCEV 19-10-2012
function updatePagos(idExp, opc){
	//var nPagina = $('#PaginaActual').val();
	var nPagina = nPag = $(".paginationinf a[class='active']").attr('name');
	$('#dialogoPagoFormulario:ui-dialog' ).dialog('destroy'); 
	$('#dialogoPagoFormulario').dialog({
	    modal: true,	
	    width: 400,         
	    height: 'auto',	    
	    buttons: {	    	
           Guardar: function() {
   			   
/*        	   
        	   $.post('actualizaPagoMoroso.action',
   					   {nIdExpediente:idExp}, 
   				   function(datos) {
   				
   					if(opc > 0) actualizarInfractores(nPagina);
   					else listarInfractoresXDocumento();
   						   
			   	   $('#divMensajeMor').html(datos);
				   $('#divMensajeMor').fadeIn(500).fadeOut(2000);					
   			   });
*/        	   
        	   
        	   $('#formConfirmaPago').attr("action","actualizaPagoMoroso.action");
        	   
        	   var options = {
               		target:        '#dialogFormWrite',
                       beforeSubmit:  showRequest, 
                       success:       showResponse,
                       data: { nIdExpediente: idExp }
                   };               
              
               $('#formConfirmaPago').ajaxSubmit(options);
               
               function showRequest() {
               	$('#dialogFormWrite:ui-dialog' ).dialog('destroy'); 
               	$('#dialogFormWrite').dialog({
               	    modal: true,	
               	    width: 350,         
               	    height: 'auto',
               	    buttons: {	    	
                     Cerrar: function() {$( this ).dialog('close');}},
               	    closeOnEscape: false,
               	    open: function() { 
               	    	$(this).closest(".ui-dialog").find(".ui-dialog-titlebar:first").hide(); 
               	    	$( "#dialogFormWrite" ).html("<img src='img/wait2.gif' alt='>>>' />&nbsp;<i>Guardando...!!!</i>");
               	    }
               	});
               	    
                   return true; 
               }
               
               function showResponse(){
            	   if(opc > 0) actualizarInfractores(nPagina);
  					else listarInfractoresXDocumento();
  				   //var datos = $('#dialogFormWrite').html();
			   	   //$('#divMensajeMor').html(datos);
				   //$('#divMensajeMor').fadeIn(500).fadeOut(2000);
               }  	         	        	   
        	       	   
        	   
   			   $( this ).dialog('close');  			   
   			   		    	  	   
           },
   
           Cancelar: function() {
               $( this ).dialog('close');
           }	   
	    }	   
	});
}

//JCEV 21-10-2012
function updateEstado(idExp, opc){
	var nPagina = $('#PaginaActual').val();
//	var nEstado = $('#EstadoExpediente').val();
//	var strObse = $('#ObsEstadoExpediente').val();
//	alert("idExp : " + idExp);
	$('#dialogoEstadoFormulario:ui-dialog' ).dialog('destroy'); 
	$('#dialogoEstadoFormulario').dialog({
	    modal: true,	
	    width: 350,         
	    height: 'auto',	    
	    buttons: {	    	
           Procesa: function() {
   			   
        	   var nPagina = nPag = $(".paginationinf a[class='active']").attr('name');
        	   
        	   $.post('actualizaEstadoExpediente.action', 
   					   $("#formContentEstado").serialize()+"&expediente.idexpediente="+idExp, 
   				   function(datos) { 
        		   
        		   if(opc > 0)actualizarInfractores(nPagina);
        		   else listarInfractoresXDocumento();
        		   
			   	   $('#divMensajeMor').html(datos);
				   $('#divMensajeMor').fadeIn(500).fadeOut(2000);					
   			   });
        	   
   			   $( this ).dialog('close');   			   
   			   
			   
   			   /*
   			   $.post('listarInfractores.action', {numeropagina:nPagina}, 
				   function(datos){
				   $('#DivRecargarInfractores').html(datos);
			   });
			   */		    	  	   
           },
   
           Cancela: function() {
               $( this ).dialog('close');
           }	   
	    }	   
	});
}

//JCEV 08-11-2012
function grabaExitosa(){
	$('#dialogFormWrite:ui-dialog' ).dialog('destroy'); 
	$('#dialogFormWrite').dialog({
	    modal: true,	
	    width: 350,         
	    height: 'auto',	    
	    buttons: {	    	
        Continuar: function() {
      	   $('#formularioInfractor').reset();
    	   $("#divLinkInfra input").removeClass('btnInfra').addClass('btnInfraDisabled');
           $('#formularioInfractor').attr('action','nuevoInfractor.action');
           $('#formularioInfractor').submit();
		   $( this ).dialog('close');
         }
 
	    }	   
	});
}

$('.paginationinf a').live("click",
		function (e){
			e.preventDefault();
			nPagina=$(this).attr('name');			
			actualizarInfractores(nPagina);
			/*
			var param= $("#search").serialize();
			param+='&idcontrol=1';
			param+='&numpagina='+numeroPagina;
			$.post(turismoAction.t_consultafichaturismo,param, function(datos) {	
				results.show();
				$("#results").html(datos);
			});
			*/
		}
);

$('.paginationinfxanp a').live("click",
		function (e){
			e.preventDefault();
			nPagina=$(this).attr('name');			
			actualizarInfractoresxAnp(nPagina);
			
		}
);