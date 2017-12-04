<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 

<html> 
<head> 

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<title><tiles:insertAttribute name="title" ignore="true" /> | SERNANP</title>
	<link rel="stylesheet" type="text/css" media="all" href="css/_base.css" />
	<base href='<s:property   value="#application.url" />'  />
	<tiles:useAttribute id="css" name="styles" classname="java.util.List" />
    <c:forEach var="item" items="${css}"> 
      <link rel="stylesheet" href="${item}" type="text/css" />
    </c:forEach>
    <script src="<%=request.getContextPath()%><tiles:getAsString name='js' />"></script>
</head>  
<body id="home"> 
<div id="wrap">
	<div id="content" class="r">
		<tiles:insertAttribute name="content" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>  
</div>
</body>
</html>