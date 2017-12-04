<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib prefix="s" uri="/struts-tags"%>



<style>
<!--

.divMessages{	
	text-align: center;
	border: 1px solid #ffaa00;
	padding: 5px;
	color: #666;
	font-weight: bold;	
}

.actionMessage{
font-size: 170%;
text-align: center;
}

.errors{
font-size: 170%;
text-align: center;
color: red;
}
-->
</style>

<div class="divMessages ui-widget">

<s:if test="hasActionMessages()">
<s:iterator value="actionMessages">
<span class="actionMessage"><s:property escapeHtml="false" />
</span>
</s:iterator>
</s:if>

<s:if test="hasActionErrors()">
<s:iterator value="actionErrors">
<span class="actionError"><s:property escapeHtml="false" />
</span>
</s:iterator>
</s:if>

<%
if(request.getAttribute("MSGERROR") != null){
	String strerror = (String)request.getAttribute("MSGERROR");
	out.print("<label class='errors'>"+strerror+"</label>");
} 
%>

</div>