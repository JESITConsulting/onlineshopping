$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#products').addClass('active');
		break;

	default:
		//if( menu == 'Home' ) break;	    
		$('#home').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}
    
	
	
	//code for product listing
	if(window.categoryId==''){
		jsonUrl = window.context+'/json/data/all/products';
	}else{
		jsonUrl = window.context+'/json/data/category/'+window.categoryId+'/products';
	}

	
	$table = $('#listProducts');
	//execute this tbale only on pages where the table is present
	if ($table.length) {
		console.log(products);

		disableCart='';
		//apply the DataTable function on the listProducts table
		$table.DataTable({

			//lengthMenu is an object the specify the display option drop down 
			lengthMenu : [ [ 2, 5, 10, -1 ], [ '3 Records', '5 Records', '10 Records', 'All' ] ],
			pageLength : -1,
			
			//dataSrc is set to empty because the json received doesnt have a value before '{'
			ajax : {url: jsonUrl, dataSrc: ''},
			
			//this object defines the columns to display in the datatable
			columns: [
				      {
				       data: 'code',
				       mRender: function(data, type, row){
				       img= '<image src="'+window.context+'/resources/images/'
				                            +data+'.jpeg" '+'class="productimg"/>'; 	
				      return img;
			       
				       }  
				      },
				 
		    	      {data: 'name'},
		    	      {data: 'brand'},
		    	      {
                       data: 'unitPrice',
                       
                      //adding the dollar sign to unit price
                      mRender: function(data, type, row){
                    	   return '$'+data;}
		    	      },
		    	      {data: 'purchases',
                       mRender:function(data,type,row){
                       if(data < 1){
                    	   data = '<span style="color:red">out of stock</span>';
                         }
                       return data;
                       }
		    	         
		    	        },
		    	      
		    	      
		    	      {data: 'views'},
		    	      {
                      data: 'id',
                     
                      //remove the sort icon
                      bSortable:false,
                      mRender: function(data, type, row){
                   	   str='';
                   	   str+='<a href="'+window.context+'/show/'+data+'/product" class="btn btn-info btn-sm">view</a>&#160;';
                       
                   	   //row contain all the data for that product
                   	   //disable is set if row.purchases is less than 1
                   	   if(row.purchases<1)
                   		str+='<a href="javascript:void(0)" class="btn btn-success btn-sm disabled"><i class="fa fa-cart-plus" style="font-size:18px"></i></a>';     
                   	   else 
                   		str+='<a href="'+window.context+'/cart/add/'+data+'/product" class="btn btn-success btn-sm '+disableCart+'"><i class="fa fa-cart-plus" style="font-size:18px"></i></a>';                  
                       
                   	   
                   	   console.log('this is the row.purchases: '+row.purchases);          	   
                   	   console.log(str);
                       return str;
                      
                      }
		    	     

		    	      }
		             ]
		});

	}

});