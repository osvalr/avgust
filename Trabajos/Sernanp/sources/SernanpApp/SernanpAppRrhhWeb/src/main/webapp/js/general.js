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


//var ie6 = false;
//$(function(){
//	ie6 = ($.browser.msie && $.browser.version <= 6);
//	$(".h").removeClass("h").hide();
//	linkvolvermenu=$('.linkvolvermenu').live('click',volverMenu);
//	 function volverMenu(e) {
//	    	e.preventDefault();
//	        history.back(1);	  
//	  }
//	$('.linkopcionmodulo').live('click',
//		function(e){
//		var idmod=$(this).find('#paramidmodulo').attr('value');
//		var href=$(this).find('#paramhrefmodulo').attr('value');
//		
//		$('#formMenu #hdmodulo').val(idmod);
//		$('#formMenu').attr('action',href);
//		$('#formMenu').submit();
//	    }	 		
//	); 
//});

jQuery.fn.addToDOM = function( ) {
	var items = {};
	for(var i = 0;t = this.length,i<t;i++){
		var item = this[i];
		items[ item.getAttribute('id') ] = $(item); 
	}
	return items;
};

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

jQuery.fn.center = function () {
    this.css("position","absolute");
    this.css("top", ( $(window).height() - this.height() ) / 2+$(window).scrollTop() + "px");
    this.css("left", ( $(window).width() - this.width() ) / 2+$(window).scrollLeft() + "px");
    return this;
};

jQuery.fn.reset = function () {
	  $(this).each (function() { this.reset(); });
};