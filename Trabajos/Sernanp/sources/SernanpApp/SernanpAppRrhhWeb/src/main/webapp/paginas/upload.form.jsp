<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="divContentUpload">
<!-- <div id="divContentUpload" style="width:50%;height:50%;overflow:auto;"></div> -->

<form id="frmupload" enctype="multipart/form-data">

    <fieldset>		
	    
	    <div id="drop_zone_1" class="l">
	    <strong>Seleccione su Archivo:</strong>
	        <input id="archivoAdjunto" type="file" name="archivoAdjunto" size="40" maxlength="70">
	    </div>    
    </fieldset>
    
</form>

</div>

<!-- <div id="divExcelUpload" title="Atención" style="display:none;"></div> -->
