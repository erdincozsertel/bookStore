<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

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
          <li class="nav-item">
            <a class="nav-link" href="/userlogin">Log in</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  
  <div class="container">
  
  	<div id="writerBox" style="margin-top:50px;" >
  		<div class="panel panel-info">
  			<div class="panel-heading">
  				<div class="panel-title">Writer List</div>
 			</div>  
  			<div class="panel-body" style="padding-top:30px" >
  				<table border="1" cellpadding="5" class="table table-bordered table-lg">
			<caption>List of Writers</caption>
			<tr>
				<th>Writer Name</th>
				<th>Writer Gender</th>
				<th>Writer Birth Date</th>
				<th colspan="2"> Update</th>
			</tr>
				<c:forEach items="${writerList}" var="writer">
			<tr>
					<td>${writer.writerName}</td>
					<td>${writer.gender}</td>
					<td>${writer.birthDate}</td>
				<form:form action="/editWriter" method="post">
					<td><button type="submit" name="writerId" value="${writer.writerId}">Edit</button></td>
				</form:form>
				<form:form action="/deleteWriter" method="post">
					<td><button type="submit" name="writerId" value="${writer.writerId}">Delete!</button></td>
				</form:form>
			</tr>
				</c:forEach>
			<tr>
				<form:form id="addWriterForm" class="form-horizontal" action="/addWriter" modelAttribute="writer" method="post">
					<td>
						<form:input path="writerName" id="writer-name" type="text" class="form-control" name="writerName" placeholder="Name of the Writer" required="required"/>
					</td>
					<td>
						<form:radiobutton path="gender" id="register-gender" name="gender" value="MALE" checked="checked"/>Male
						<form:radiobutton path="gender" id="register-gender" name="gender" value="FEMALE"/> Female
					</td>
					<td>
						<form:input path="birthDate" type="date" id ="register-birthdate" class="form-control" name="birthDate" required="required"/>
					</td>
					<td colspan="2">
						<input id="btn-addWriter" type="submit" value="Add Writer" class="btn btn-success"/>
					</td>
				</form:form>
			</tr>
		</table>
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
