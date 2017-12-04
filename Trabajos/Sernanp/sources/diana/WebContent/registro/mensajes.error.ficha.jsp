<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
<!--
.errors{
top: 20%;
left: 50%;
font-size: 140%;
text-align: center;
padding: 10px;
border: 1px solid #ffaa00;
color: red;
}
-->
</style>


<div class="errors">
<%=request.getAttribute("MSGERROR")%>
</div>
