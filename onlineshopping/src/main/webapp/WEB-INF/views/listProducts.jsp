<div class="container">

	<div class="row">
		<%@include file="./shared/sidebar.jsp"%>

		<!-- Display all the products in this section  -->
		<div class="col-md-9">
			<!-- Adding breadcrumb using bootstrap class -->

			<div class="row">
				<div class="col-md-12">

					<!-- JSTL tags used with spring ${contextRoot} reference -->
					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="active breadcrumb-item">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="active breadcrumb-item">Category</li>
							<li class="active breadcrumb-item">${category.name}</li>
						</ol>
					</c:if>

					<!-- JQUERY DATATABLE DISPLAY  -->
					<div class ="container">
					<!--  <div class="row"> -->
					<div class="col-xs-12">
						<table id="listProducts"
							class="table table-striped table-bordered">
							<thead>
								<tr>
								    <td></td>
									<td>NAME</td>
									<td>BRAND</td>
									<td>UNIT PRICE</td>
									<td>PURCHASES</td>
									<td>VIEWS</td>
									<td></td>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
					<!--</div>-->
				</div>


			</div>
			<!--end colmd12 -->
		</div>
		<!-- end inner row -->
	</div>
	<!--end colmd9 -->

	<div class="col-md-3 p-3"></div>
</div>
<!-- end outer row -->
</div>
<!-- end container -->
