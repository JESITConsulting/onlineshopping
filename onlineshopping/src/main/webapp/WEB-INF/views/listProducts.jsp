<div class ="container">

	<div class="row">
	 <%@include file="./shared/sidebar.jsp"%>
	 
		<!-- Display all the products in this section  -->
		<div class="col-md-9">
			<!-- Adding breadcrumb using bootstrap class -->
			
			<div class="row"> 
			<div class="col-md-12">
				
				
				   <c:if test="${userClickAllProducts == true}">
				   <ol class="breadcrumb">					
						<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
						<li class="active breadcrumb-item"> All Products</li>					
					</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
					<ol class="breadcrumb">					
						<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
						<li class="active breadcrumb-item">Category</li>	
						<li class="active breadcrumb-item">${category.name}</li>					
					</ol>
					</c:if>				
					
				</div><!--end colmd12 -->			
			 </div><!-- end inner row -->	
		</div> <!--end colmd9 -->	
		
		<div class="col-md-3 p-3">
	  
	   </div> 	
	</div><!-- end outer row -->	
</div><!-- end container -->
