<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>



<div align="left" >
	<label>Fecha:</label>
	<s:textfield name="dte_fec_marc" id ="dte_fec_marc" theme="simple" size="10" readonly="true" value="%{#request.dte_fec_marc}"/>
</div>

<div>																								
	<label>Apellidos y Nombres:</label>

	<s:text name="%{#request.nombreCompleto}"/>
</div>


<div id="msgSinMarcaciones">
	<s:label value="%{#request.msg}"  id="msg" cssClass="alertamsg" cssStyle="display: block;" />
</div>


