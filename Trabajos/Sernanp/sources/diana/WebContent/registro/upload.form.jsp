<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<style>
<!--
.progressbar {
	color: #00529B;
    background-color: #BDE5F8;
    font-size: 105%;    
    display: none;    
}


  .file_1-input-wrapper {
    width: 150px;
    height: 20px;
    overflow: hidden;
    position: relative;
    background-color: #FF9934;    
    border: 1px #333 solid;    
  }
  .file_1-input-wrapper > input[type="file"] {
    position: absolute;
    top: 0;
    right: 0;
    opacity: 0;
    cursor: pointer;
  }
  .file_1-input-wrapper > .btn-file_1-input {
    display: inline-block;
    width: 150px;
    height: 20px;
    color: #fff;
    font-size: 110%;
    
  }

-->
</style>

<div id="divContentUpload">

<!-- <input id="fileupload" type="file" name="files[]" data-url="registro/upload.action" multiple> -->

<div class="file_1-input-wrapper">
  	<button class="btn-file_1-input">Seleccione Archivo</button>
	<input id="fileupload" type="file" name="file_1" data-url="registro/upload.action" />
</div>
<div class="progressbar"></div>

<script>
$jq(function () {
	$jq('#fileupload').fileupload({
        dataType: 'json',
        add: function (e, data) {
            //data.context = $('<p/>').text('Cargando archivo, por favor espere...').appendTo(document.body);
            $jq('.progressbar').css('display','block');            
            $jq('.progressbar').text('CARGANDO ARCHIVO, POR FAVOR ESPERE...');            
            data.submit();
        },
        /*progress: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);

            $jq('#progress .bar').css(
                'width',
                progress + '%'
            );            
            
        },*/
        done: function (e, data) {
        	//data.context.text('Upload finished.');

        	$jq('.progressbar').css('color','#4F8A10');
        	$jq('.progressbar').css('background-color','#DFF2BF');
        	$jq('.progressbar').text('ARCHIVO CARGADO!!!');
        	
        	setTimeout(function(){ $jq('.progressbar').fadeIn(300).fadeOut(3800);}, 0);
        	
        	$jq.each(data.result.datosp, function(indx, obj){                
            	createDynamicTable($jq(".tabExcel"),1,8,obj,data.result.tipos);
        	});
        	
        	$jq('#formTabExcel').find('#nombrearchivo').val(data.result.tmpname);
        	
        }
    });


    function createDynamicTable(tbody, rows, cols, obj,tip) {

    	var datpers = ['nombre','apepat','apemat','empresa','tipodocumento','numerodocumento','tipolocal','sexo'];
    	
    	if (tbody == null || tbody.length < 1)
    		return;
    	for ( var r = 1; r <= rows; r++) {
    		var trow = $jq("<tr>");

    		if(parseInt(obj['idestado'],10) == 1)
    			$jq("<td>").html('<input type=\'checkbox\' id=\'numerodocumento\' name=\'numerodocumento\' value=\''+obj[datpers[5]]+'\' \/>').data("col", 0).appendTo(trow);
    		else
    			$jq("<td>").html('<img src=\'img/warning.png\' title=\'PersonaL ya registrado!!!\' \/>').data("col", 0).appendTo(trow);
    		
    		for ( var c = 1; c <= cols; c++) {
        		if(c == 5 || c == 7 || c == 8){

            		var cellText = tip[obj[datpers[c-1]]['idtabla']+''+obj[datpers[c-1]]['idtipo']];
        		}      		
        		else var cellText = obj[datpers[c-1]];
    			 
    			//$("<td>").addClass("tableCell").text(cellText).data("col", c).appendTo(trow);
    			
    			cellText = (cellText != null) ? cellText : '';
    			$jq("<td>").text(cellText).data("col", c).appendTo(trow);
    			
    		}
    		trow.appendTo(tbody);   		
    	}
    }
    
});
</script>


<form id="formTabExcel" action="" method="post" >

<div class="divList">
			
<table id="hor-minimalist-a" summary="Employee Pay Sheet" class="tabExcel">
    <thead>
    	<tr>
    		<th scope="col">#</th>
        	<!-- <th scope="col">N&deg;</th> -->
        	<th scope="col">Nombres</th>
        	<th scope="col">Ap.Paterno</th>
        	<th scope="col">Ap.Materno</th>
            <th scope="col">Empresa/Inst.</th>
            <th scope="col">DNI/CE</th>            
            <th scope="col">N&uacute;mero de Doc.
            <th scope="col">Proced.</th>
            <th scope="col">Genero</th>
            
    	</tr>
    	
    	</thead>
    	<tbody>

    </tbody>
</table>

</div>

<div class="divBtnEnviar">
	<input type="button" value="Agregar" class="submit" id="btnSaveTabExcel" />
</div>

<input type="hidden" id="nombrearchivo" name="nombrearchivo" value="" />

</form>

</div>