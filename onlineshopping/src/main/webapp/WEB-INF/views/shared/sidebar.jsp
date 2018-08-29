        
        
        <!-- Add context:component-scan for the backend project as well
             so that the frontend can find the backend classes-->
               
        <div class="col-lg-3">
        <h1 class="my-4">Store</h1>      
          <div class="list-group">
          <c:forEach items = "${categories}" var= "category">
            <a href="${contextRoot}/show/all/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
            </c:forEach>
          </div>
        </div>
        
