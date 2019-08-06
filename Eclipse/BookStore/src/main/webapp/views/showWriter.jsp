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
          	<a class="nav-link" href="/addBook">Add Book</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/userlogin">Log in</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  
  <div class="container-fluid">
  
  	<div id="addBookBox" style="margin-top:50px;" >
  		<div class="panel panel-info">
  			<div class="panel-heading">
  				<div class="panel-title">Writer List</div>
 			</div>  
  			<div class="panel-body" style="padding-top:30px" >
  				<table border="1" cellpadding="5">
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
				<form action=others>
					<td><button type="submit" name="editWriter" value=${writer.writerId} formmethod="post">Edit</button></td>
					<td><button type="submit" name="deleteWriter" value=${writer.writerId} formmethod="post">Delete!</button></td>
				</form>
			</tr>
				</c:forEach>
			<tr>
				<form action = others>
					<td><input type="text" name="writerName" required/></td>
					<td>
						<input type="radio" name="gender" value="MALE" checked> Male
  						<input type="radio" name="gender" value="FEMALE"> Female
					</td>
					<td><input type="date" name="birthDate" required></td>
					<td colspan="2"><button type="submit" name="addWriter" value="addWriter" formmethod="post" >Add Writer</button></td>
				</form>
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
