<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Search Result</title>

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
          <li class="nav-item">
          	<a class="nav-link" href="/userlogin">Log in</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">Shop Name</h1>
        <div class="list-group">
<!--      	<a href="#" class="list-group-item">Category 1</a> -->
          <c:forEach items="${categoryList}" var="category">
          	<a href="/lookBooks4Category?categoryId=${category.categoryId}" class="list-group-item" name=categoryId value="${category.categoryId}">${category.categoryName}</a>           
          </c:forEach>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div class="row mt-5">

<!--           <div class="col-lg-4 col-md-6 mb-4"> -->
<!--             <div class="card h-100"> -->
<!--               <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a> -->
<!--               <div class="card-body"> -->
<!--                 <h4 class="card-title"> -->
<!--                   <a href="#">Item One</a> -->
<!--                 </h4> -->
<!--                 <h5>$24.99</h5> -->
<!--                 <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p> -->
<!--               </div> -->
<!--               <div class="card-footer"> -->
<!--                 <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small> -->
<!--               </div> -->
<!--             </div> -->
<!--           </div> -->
          <c:forEach items="${searchedBooks}" var="book">
          	<div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="/editBook?bookId=${book.bookId}" name=bookId value="${book.bookId}">${book.bookName}</a>
                  </h4>
                  <h5>${book.bookPrice} TL</h5>
                  <p class="card-text">${book.bookDescription}</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>                    
          </c:forEach>
          

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

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
