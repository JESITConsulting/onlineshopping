<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags"%>

<!--  
The pageContext for the JSP page. Provides access to various objects including:
servletContext,session,request or response
-->

<spring:url var="js" value="/resources/js"/>
<spring:url var="css" value="/resources/css"/>
<spring:url var="images" value="/resources/images"/>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>Online Shopping - "${title}"</title>

<!--////Setting GLOBAL VARIABLES to be used by all pages/////-->
<script>
	window.menu = '${title}';
	window.context = '${contextRoot}';
	
</script>
<!--////end/////-->


<!--////Linking GLOBAL css style sheets to the main page/////-->
<!-- Bootstrap core CSS -->
	<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
	<link href="${css}/shop-homepage.css" rel="stylesheet">
<!-- Bootstrap theme CSS -->
	<link href="${css}/bootstrap.flatly.css" rel="stylesheet">
<!-- Bootstrap for the dataTables css -->
	<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
<!-- Bootstrap for the font-awesome icons css -->	
	<link rel="stylesheet" href="${css}/font-awesome.min.css" rel="stylesheet">
</head>

<body>
<div class="wrapper">
    <!-- Navigation -->
   <%@include file="./shared/navbar.jsp" %>
    
    <!-- Page Content -->   
    <div class="content"> 
    <c:if test ="${userClickHome == true }">
    <%@include file="home.jsp" %>
    </c:if>
    
    <c:if test ="${userClickAbout == true }">
    <%@include file="about.jsp" %>
    </c:if>
    
    <c:if test ="${userClickContact == true }">
    <%@include file="contact.jsp" %>
    </c:if>
    
    
    <c:if test ="${userClickAllProducts == true or userClickCategoryProducts == true }">
    <%@include file="listProducts.jsp" %>
    </c:if>
    
     <c:if test ="${userClickSingleProduct == true}">
    <%@include file="product.jsp" %>
    </c:if>
    
    </div>
    </div>
      
    <!-- Page footer -->
    <%@include file="./shared/footer.jsp" %>
    
    
    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script> 
    <!-- JQuery table plugin -->
    <script src="${js}/jquery.dataTables.js"></script> 
    <script src="${js}/dataTables.bootstrap4.js"></script> 
   <!-- <script src="${js}/dataTables.bootstrap.js"></script> -->
    <!-- custom file -->
    <script src="${js}/myapp.js"></script>
  
 
  </body>

</html>
