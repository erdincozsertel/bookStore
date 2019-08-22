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
  
  	<div id="publisherBox" style="margin-top:50px;" >
  		<div class="panel panel-info">
  			<div class="panel-heading">
  				<div class="panel-title">Publisher: ${thisPublisher.publisherName}</div>
 			</div>  
  			<div class="panel-body" style="padding-top:30px" >
  				<table border="1" cellpadding="5" class="table table-bordered table-lg">
			<tr>
				<th>Publisher Name</th>
				<th>Update</th>
			</tr>
			<tr>
					<td>${thisPublisher.publisherName}</td>
					<form:form action="/deletePublisher" method="post">
						<td>
							<button type="submit" name="publisherId" value="${thisPublisher.publisherId}">Delete!</button>
						</td>
					</form:form>
			</tr>
			<tr>
				<form:form id="editPublisherForm" class="form-horizontal" action="/editPublisherPage" modelAttribute="publisher" method="post">
					<td>
						<form:input path="publisherId" id="publisher-id" type="hidden" class="form-control" value ="${thisPublisher.publisherId}"/>
						<form:input path="publisherName" id="publisher-name" type="text" class="form-control" 
						name="publisherName" placeholder="Name of the Publisher" required="required" 
						value="${thisPublisher.publisherName}"/>
					</td>
					<td>
						<input id="btn-editPublisher" type="submit" value="Edit Publisher" class="btn btn-success"/>
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
