<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">
  
    <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/"><img src="book.png" alt="logo" style="width:70px;"></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
          <li class="nav-item active">
          	<a class="nav-link" href="/addBook">Add Book
          	  <span class="sr-only">(current)</span>
          	</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/userlogin">Log in</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  
  <div class="container">
  	<div id="addBookBox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
  		<div class="panel panel-info">
  			<div class="panel-heading">
  				<div class="panel-title">Add Book</div>
 			</div>  
  			<div class="panel-body" style="padding-top:30px">
  				<form:form id="bookForm" class="form-horizontal" action="/bookRegister" modelAttribute="book" method="post">
  					<div id="bookAddAlert" style="display:none" class="alert alert-danger">
  						<p>Error:</p>
  						<span></span>
  					</div>   
                               <div class="form-group">
                                   <label for="bookName" class="col-md-3 control-label">Book Name</label>
                                   <div class="col-md-9">
                                       <form:input path="bookName" id="register-bookName" type="text" class="form-control" name="bookName" placeholder="Book Name" required="required"/>
                                   </div>
                               </div>    
                               <div class="form-group">
                                	<label for="bookWriter" class="col-md-3 control-label">Writer</label>
                                	<div class="col-md-9">
                                		<form:select path= "bookWriter" id="register-bookWriter" class="form-control" name="bookWriter" required="required">
                                			<form:option value = "NONE" label = "Select" itemValue="writerId" itemLabel="writerName"/>
                                			<form:options items="${writerList}" /> 
                                		</form:select>   
                                		<!-- Button for Writer -->
                                		<div class="form-group2">
  											<div class="col-md-offset-3 col-md-9">
                                        		<a id="btn-editWriter" class="btn btn-info" href="/showWriter">Edit Writer</a>
                                    		</div>		
                                    	</div>								
                                	</div>
                                </div>
                                <div class="form-group">
                                	<label for="bookPublisher" class="col-md-3 control-label">Publisher</label>
                                	<div class="col-md-9">
                                		<form:select path= "bookPublisher" id="register-bookPublisher" class="form-control" name="bookPublisher" required="required">
                                			<form:option value = "NONE" label = "Select" itemValue="publisherId" itemLabel="publisherName"/>
                                			<form:options items="${writerList}" /> 
                                		</form:select>     	
                                	</div>
                                </div>
                                <div class="form-group">
                                   <label for="bookPrice" class="col-md-3 control-label">Book Price</label>
                                   <div class="col-md-9">
                                       <form:input path="bookPrice" id="register-bookPrice" type="number" step="0.01" min="0.01" max="999.99" class="form-control" name="bookPrice" placeholder="Book Price" required="required"/>
                                   </div>
                               </div>
                               <div class="form-group">
                                	<label for="bookCategory" class="col-md-3 control-label">Category</label>
                                	<div class="col-md-9">
                                		<form:select path= "bookCategory" id="register-bookCategory" class="form-control" name="bookCategory" required="required">
                                			<form:option value = "NONE" label = "Select" itemValue="categoryId" itemLabel="categoryName"/>
                                			<form:options items="${categoryList}" /> 
                                		</form:select>     	
                                	</div>
                                </div>
                                

                                <div class="form-group">
                                    <!-- Button -->                                      
                                    <div class="col-md-offset-3 col-md-9">
                                        <input id="btn-addBook" type="submit" value="Add Book" class="btn btn-info"/>
                                    </div>
                                </div>
  				</form:form>
  			</div>
  		</div>     
  	</div> 
  </div>
  <!-- /.container -->


  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>
</body>

</html>
