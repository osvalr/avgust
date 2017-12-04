<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<base href='http://<%= request.getServerName() %>:<%= request.getServerPort() %><%=request.getContextPath() %>/'  />  
 <%@page  contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%> 
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" media="all" href="css/reseter_v2.css" />
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.5.custom.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" media="all" href="css/_base.css" />
<link rel="stylesheet" type="text/css" media="print" href="css/print.css" />   
<%-- <script type="text/javascript" src="js/jquery.min.js"></script> --%>
<script type="text/javascript" src="js/jquery-1.6.3.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>

<script type="text/javascript" src="js/jquery-ui-1.8.5.custom.min.js"></script>

<!-- <link type="text/css" href="css/fileupload/jquery.fileupload-ui.css" rel="stylesheet" /> -->

<link rel="stylesheet" href="css/jquery.ui.timepicker.css?v=0.3.0" type="text/css" />

<%-- <script type="text/javascript" src="js/fileupload/jquery.fileupload.js"></script> --%>
<%-- <script type="text/javascript" src="js/fileupload/jquery.fileupload-ui.js"></script> --%>

<script type="text/javascript" src="js/general.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-es.js"></script>
<script type="text/javascript" src="js/lib/_class.validator.js"></script>

<script type="text/javascript" src="js/jquery.ui.timepicker.js?v=0.3.0"></script>

<script src="js/lib/galleria-1.2.5.js" type="text/javascript"></script>

<script>
    Galleria.loadTheme('js/lib/themes/classic/galleria.classic.min.js');
</script>

<script src="<tiles:getAsString name='js' />"></script>

<tiles:useAttribute id="js" name="JSFiles" classname="java.util.List" />
<c:forEach var="item_" items="${js}"> 
  	<script src="${item_}" type="text/javascript"></script>
</c:forEach>


<tiles:useAttribute id="css" name="styles" classname="java.util.List" />
<c:forEach var="item" items="${css}"> 
  	<link rel="stylesheet" href="${item}" type="text/css" />
</c:forEach>    

 
</head>
<body id="home">
				
	<div id="wrap">
		<div id="header"><tiles:insertAttribute name="header" /></div>
		<div id="menu"><tiles:insertAttribute name="menu" /></div>
		<div id="content" class="r"><tiles:insertAttribute name="content" /></div>
		<div id="footer"><tiles:insertAttribute name="footer" /></div>
	</div> 
	
</body> 
</html>   