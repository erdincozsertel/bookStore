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
  <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/css/shop-homepage.css" rel="stylesheet">
  
      <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/"><img src="/book.png" alt="logo" style="width:70px;"></a>
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
          <li class="nav-item">
          	<a class="nav-link" href="/admin">Admin Dashboard</a>
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
<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
  		<div class="panel panel-info" >
  			<div class="panel-heading">
  				<div class="panel-title">Sign In</div>
  				<div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
  			</div>     

  			<div style="padding-top:30px" class="panel-body" >
  			
  				<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
  					
					<form:form id="loginform" class="form-horizontal" action="/loginCntr" modelAttribute="userLogin" method="post">
  						
  						<div style="margin-bottom: 25px" class="input-group">
  							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<form:input path="username" id="login-username" type="text" class="form-control" name="username" placeholder="username or email"/>
  						</div>
						
  						<div style="margin-bottom: 25px" class="input-group">
  							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<form:input path="password" id="login-password" type="password" class="form-control" name="password" placeholder="password"/>
  						</div>
<!--   						<div style="margin-bottom: 25px" class="input-group"> -->
<%-- 							<form:input type="checkbox" name="remember-me"/> --%>
<!--   						</div> -->
  						<div style="margin-top:10px" class="form-group">
  							<!-- Button -->

  							<div class="col-sm-12 controls">
  								 <input id="btn-login" type="submit" value="Log in" class="btn btn-success"/>
  							</div>
  						</div>
  						
  						<div class="form-group">
  							<div class="col-md-12 control">
  								<div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
  									Don't have an account! 
  								<a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
  									Sign Up Here
  								</a>
  								</div>
  							</div>
  						</div>    
  					</form:form>     
  			</div>                     
  		</div>  
  	</div>
  	
  	<div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
  		<div class="panel panel-info">
  			<div class="panel-heading">
  				<div class="panel-title">Sign Up</div>
  				<div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
 			</div>  
  			<div class="panel-body" style="padding-top:30px">
  				<form:form id="signupform" class="form-horizontal" action="/register" modelAttribute="user" method="post">
  					<div id="signupalert" style="display:none" class="alert alert-danger">
  						<p>Error:</p>
  						<span></span>
  					</div>   
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <form:input path="email" id="register-email" type="text" class="form-control" name="email" placeholder="Email Address" required="required"/>
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-9">
                                        <form:input path="name" id="register-name" type="text" class="form-control" name="firstname" placeholder="First Name" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-9">
                                        <form:input path="surname" id="register-surname" type="text" class="form-control" name="surname" placeholder="Last Name" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="username" class="col-md-3 control-label">User Name</label>
                                    <div class="col-md-9">
                                        <form:input path="username" id="register-username" type="text" class="form-control" name="username" placeholder="User Name" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <form:input path="password" type="password" id="register-password" class="form-control" name="password" placeholder="Password" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="birthDate" class="col-md-3 control-label">Birth Date</label>
                                    <div class="col-md-9">
                                        <form:input path="birthDate" type="date" id ="register-birthdate" class="form-control" name="birthDate" required="required"/>
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label for="gender" class="col-md-3 control-label">Gender</label>
                                    <div class="col-md-9">
                                        <form:radiobutton path="gender" id="register-gender" name="gender" value="MALE" checked="checked"/> Male
  										<form:radiobutton path="gender" id="register-gender" name="gender" value="FEMALE"/> Female
                                    </div>
                                </div>

                                <div class="form-group">
                                    <!-- Button -->                                      
                                    <div class="col-md-offset-3 col-md-9">
                                        <input id="btn-signup" type="submit" value="Sign up" class="btn btn-info"/>
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
