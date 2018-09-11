<div class="container">
 <div classs="row">	
 <div class="col-xs-12">
     <ol class="breadcrumb">
     	<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
     	<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products</a></li>
     	<li class="breadcrumb-item">${product.name}</li>
     </ol>
 </div>
</div>

 <div class="row">
    <!-- display product image -->	
   <div class="col-xs-12 col-md-4">
   <div class = "thumbnail">
    <img src="${images}/${product.code}.jpeg" class="img img-responsive img-thumbnail" alt="${product.name}" width="304" height="236"/>

   </div>
   </div>
   
   
    <!-- display product description -->	
    <div class="col-xs-12 col-md-8">
    <h2>${product.name}</h2>
    <hr align="left" width="100%" color="blue">
   <p>${product.description}</p>
   <h4>Price:<strong>$${product.unitPrice}</strong></h4>
   
    <!-- Display out of stock message if product count is less than 1 -->
   <c:choose>
     <c:when test="${product.purchases < 1}">
       <h6>Quantity: <span style="color:red">out of stock</span></h6>
     </c:when>  
     <c:otherwise>   
     <h6>Quantity:${product.purchases}</h6>
     </c:otherwise>
   </c:choose>
   
   <!-- Disable shopping card if product count is less than 1 -->  
    <c:choose>
     <c:when test="${product.purchases < 1}">
        <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success btn-sm disabled"><i class="fa fa-cart-plus disabled" style="font-size:18px"></i></a>
     </c:when>  
     <c:otherwise>   
     <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success btn-sm"><i class="fa fa-cart-plus" style="font-size:18px"></i></a>
     </c:otherwise>
   </c:choose>
   
     <a href="${contextRoot}/show/all/products" class="btn btn-info btn-sm">Continue shopping</a>
   </div>

</div>
</div>
