<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="msgIterceptor">
	<s:label value="%{#request.msg}"  id="msgIterceptor" cssClass="alertamsg" cssStyle="display: block;" />	
</div>


