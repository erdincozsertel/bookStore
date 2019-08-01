<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Password Tester/title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">

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
          	<a class="nav-link" href="/userlogin">Log in
          	  <span class="sr-only">(current)</span>
          	</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  
  <div class="container">
<div id="testbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
  		<div class="panel panel-info" >
  			<div class="panel-heading">
  				<div class="panel-title">Test It</div>
  			</div>     

  			<div style="padding-top:30px" class="panel-body" >
  			
  				<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
  					
					<form:form id="passT" class="form-horizontal" action="/passWordTest2" modelAttribute="passT" method="post">
						
  						<div style="margin-bottom: 25px" class="input-group">
  							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<form:input path="password" id="test-password" type="text" class="form-control" name="password" placeholder="password"/>
  						</div>
  						<div style="margin-top:10px" class="form-group">
  							<!-- Button -->

  							<div class="col-sm-12 controls">
  								 <input id="btn-login" type="submit" value="Log in" class="btn btn-success"/>
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
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
