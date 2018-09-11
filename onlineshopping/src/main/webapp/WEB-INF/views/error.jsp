<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--  
The pageContext for the JSP page. Provides access to various objects including:
servletContext,session,request or response
-->

<spring:url var="js" value="/resources/js" />
<spring:url var="css" value="/resources/css" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

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
<link rel="stylesheet" href="${css}/font-awesome.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<%@include file="./shared/navbar.jsp"%>
	 

	<div class="container">
		<div class="row col-xs-12 justify-content-center py-4">

			<div class="col-xs-6">
			<p><i class="fa fa-exclamation-triangle" aria-hidden="true" style="font-size:36px; color:red"></i>
				${errorTitle}
				<br><strong>${title}</strong></p>
			</div>
						
			<div class="col-xs-6 ">
				<blockquote class="blockquote" style="word-wrap:break-word">
					<p>${errorDesc}</p>
					<footer class="blockquote-footer">
						 <cite title="Source Title">Onlineshopping
							by JES Consulting</cite>
					</footer>
				</blockquote>
			</div>		
		</div>
	</div>
</div>
	<!-- Page footer -->
	<%@include file="./shared/footer.jsp"%>


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